/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.indexer.lucene/src/com/ibm/adtech/indexer/lucene/LuceneIndexerBase.java,v $
 * Created by:  Wing Yung ( <a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com </a>)
 * Created on:  10/11/2005
 * Revision:	$Id: LuceneIndexerBase.java 169 2007-07-31 14:11:15Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.indexer.lucene;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Dictionary;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.ConcurrentMergeScheduler;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.MergeScheduler;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.util.Version;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.indexer.IIndexer;
import org.openanzo.indexer.IndexerDictionary;
import org.openanzo.indexer.IndexerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Configures lucene directory from provided anzo properties file and provides basic lucene IndexWriter lifecycle management.
 * 
 * @param <T>
 *            Type of objects that will be indexed
 * @param <F>
 *            Type of object that will be source of rebuild
 * 
 * @author Wing Yung (<a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com</a>)
 */
public abstract class LuceneIndexerBase<T, F> implements IIndexer<T, F> {

    private static final Logger      log               = LoggerFactory.getLogger(LuceneIndexerBase.class);

    protected String                 location          = null;

    protected final StandardAnalyzer analyzer          = new StandardAnalyzer(Version.LUCENE_CURRENT);

    protected IndexWriter            indexWriter;

    protected boolean                needsIndexRebuild = false;

    /**
     * Initializes the indexer.
     * 
     * The properties object should contain the location of the directory containing the index (org.openanzo.indexer.lucene.indexLocation) and whether or not
     * the index should be cleared upon initialization (org.openanzo.indexer.indexClear).
     * 
     * Note that there are additional Lucene properties that can be set via Java system properties. For example, org.apache.lucene.writeLockTimeout (in ms)
     * 
     * @throws IndexerException
     *             {@link ExceptionConstants.INDEX#INDEX_CONFIG_PARAM_MISSING} if the {@link LuceneProperties#KEY_LUCENE_INDEX_LOCATION} property is missing
     */
    public void initialize(Dictionary<? extends Object, ? extends Object> configProperties) throws IndexerException {

        location = LuceneDictionary.getIndexLocation(configProperties);
        if (location == null) {
            throw new IndexerException(ExceptionConstants.INDEX.INDEX_CONFIG_PARAM_MISSING, LuceneProperties.KEY_LUCENE_INDEX_LOCATION);
        }
        String indexerHome = LuceneDictionary.getIndexerHome(configProperties);

        location = getAbsoluteIndexLocation(location, indexerHome);

        boolean clear = IndexerDictionary.getIndexClear(configProperties);
        boolean removeLock = LuceneDictionary.getRemoveLockFile(configProperties);
        needsIndexRebuild = initialize(location, clear, removeLock);
    }

    /**
     * 
     * @param rebuildIndex
     * @param removeLock
     * @param location
     * @param indexHome
     * @throws IndexerException
     */
    public void initialize(boolean rebuildIndex, boolean removeLock, String location, String indexHome) throws IndexerException {

        this.location = location;
        if (location == null) {
            throw new IndexerException(ExceptionConstants.INDEX.INDEX_CONFIG_PARAM_MISSING, LuceneProperties.KEY_LUCENE_INDEX_LOCATION);
        }
        location = getAbsoluteIndexLocation(location, indexHome);

        needsIndexRebuild = initialize(location, rebuildIndex, removeLock);
    }

    public boolean needsIndexRebuild() {
        return needsIndexRebuild;
    }

    /**
     * If an relative index path is provided, attempt to use the ANZO_HOME property to create an absolute file path.
     * 
     * @param indexDirectoryPath
     * @param properties
     * @return the absolute path to the index directory
     */
    protected static String getAbsoluteIndexLocation(String indexDirectoryPath, String indexerHome) {
        if (indexDirectoryPath == null)
            return null;
        if (indexerHome != null) {
            File indexerDir = new File(indexerHome);
            File indexDirectoryFile = new File(indexDirectoryPath);
            if (!indexDirectoryFile.isAbsolute() && indexerDir.exists() && indexerDir.isDirectory()) {
                File absoluteLocation = new File(indexerDir, indexDirectoryPath);
                return absoluteLocation.getAbsolutePath();
            }
        }
        return indexDirectoryPath;
    }

    /**
     * Initializes the indexer.
     * 
     * @param location
     *            the location of the directory containing the index
     * @param indexClear
     *            whether or not the index should be cleared upon initialization
     * @param removeLock
     *            whether or not the index's lock should be removed upon initialization
     * @throws IndexerException
     *             {@link ExceptionConstants.INDEX#LOCK_FILE_NO_EXIST} if there was an exception trying to remove a lock file that didn't exist
     * @throws IndexerException
     *             {@link ExceptionConstants.INDEX#FAILED_DELETE_LOCK_FILE} if there was an exception trying to remove a lock file
     * @throws IndexerException
     *             {@link ExceptionConstants.INDEX#NO_DELETE_LOCK_FILE} if there was a lock file, but removeLock was false
     * @throws IndexerException
     *             {@link ExceptionConstants.INDEX#FAILED_INDEX_INIT} if there was an exception initializing the index
     * @return true if the index has to be rebuilt
     */
    public boolean initialize(String location, boolean indexClear, boolean removeLock) throws IndexerException {
        boolean clearTheIndex = indexClear;
        try {
            File f = new File(location);
            log.info(LogUtils.DATASOURCE_MARKER, "lucene index location:{}", location);
            if (!f.exists() || f.list().length == 0) {
                // Create a new index if there isn't one there already.
                log.info(LogUtils.DATASOURCE_MARKER, "Creating new index at location:{}", new String[] { location });
                clearTheIndex = getIndexWriter(location, true);
            } else {
                clearTheIndex = getIndexWriter(location, indexClear);
            }
        } catch (IOException e) {
            Exception currException = e;
            while (currException != null && currException.getMessage().contains(LuceneConstants.LockExceptionMessage)) {
                Pattern p = Pattern.compile(LuceneConstants.LockFileExpression);
                Matcher m = p.matcher(e.getMessage());
                String lockfilename = null;
                if (m.find()) {
                    lockfilename = m.group(1);
                }
                // Depending on whether it's possible to have multiple locks (probably would 
                // require some strange sequence of events), may want to put this into a 
                // while loop.
                if (removeLock) {
                    if (lockfilename != null) {
                        File lockfile = new File(lockfilename);
                        if (!lockfile.exists()) {
                            throw new IndexerException(ExceptionConstants.INDEX.LOCK_FILE_NO_EXIST, lockfilename);
                        }
                        if (!lockfile.delete()) {
                            throw new IndexerException(ExceptionConstants.INDEX.FAILED_DELETE_LOCK_FILE, lockfilename);
                        }
                        log.info(LogUtils.DATASOURCE_MARKER, "Deleted indexer file:{} ", lockfilename);
                        try {
                            clearTheIndex = getIndexWriter(location, indexClear);
                            currException = null;
                        } catch (IOException e1) {
                            currException = e1;
                        }
                    } else {
                        throw new IndexerException(ExceptionConstants.INDEX.FAILED_DELETE_LOCK_FILE, e);
                    }
                } else {
                    throw new IndexerException(ExceptionConstants.INDEX.NO_DELETE_LOCK_FILE, lockfilename);
                }
            }
            if (currException != null) {
                throw new IndexerException(ExceptionConstants.INDEX.FAILED_INDEX_INIT, currException);
            }
        }
        if (log.isInfoEnabled()) {
            log.info(LogUtils.DATASOURCE_MARKER, "Index Location:{}", location);
            if (clearTheIndex) {
                log.info(LogUtils.DATASOURCE_MARKER, "Index Clear");
            } else {
                log.info(LogUtils.DATASOURCE_MARKER, "Index Don't clear");
            }
        }
        return clearTheIndex;
    }

    private boolean getIndexWriter(String location, boolean indexClear) throws CorruptIndexException, LockObtainFailedException, IOException {
        boolean indexCleared = false;
        try {
            indexWriter = new IndexWriter(FSDirectory.open(new File(location)), analyzer, indexClear, new IndexWriter.MaxFieldLength(IndexWriter.DEFAULT_MAX_FIELD_LENGTH));
            indexCleared = indexClear;
        } catch (CorruptIndexException cie) {
            log.error(LogUtils.DATASOURCE_MARKER, "Corrupt index error:" + cie);
            indexWriter = new IndexWriter(FSDirectory.open(new File(location)), analyzer, true, new IndexWriter.MaxFieldLength(IndexWriter.DEFAULT_MAX_FIELD_LENGTH));
            indexCleared = true;
        } catch (FileNotFoundException cie) {
            log.error(LogUtils.DATASOURCE_MARKER, "Corrupt index error:" + cie);
            indexWriter = new IndexWriter(FSDirectory.open(new File(location)), analyzer, true, new IndexWriter.MaxFieldLength(IndexWriter.DEFAULT_MAX_FIELD_LENGTH));
            indexCleared = true;
        }
        indexWriter.setMaxBufferedDocs(20000);
        MergeScheduler mergeScheduler = indexWriter.getMergeScheduler();
        if (mergeScheduler instanceof ConcurrentMergeScheduler) {
            ConcurrentMergeScheduler cScheduler = (ConcurrentMergeScheduler) mergeScheduler;
            cScheduler.setMergeThreadPriority(Thread.MIN_PRIORITY);
        }
        return indexCleared;
    }

    /**
     * A no-op. IndexWriter takes care of all of the reading/writing in a threadsafe manner.
     * 
     * @throws IndexerException
     */
    public void preIndex() throws IndexerException {
    }

    /**
     * Flushes and optimizes the index.
     * 
     * @throws IndexerException
     */
    public void postIndex() throws IndexerException {
        try {
            if (indexWriter != null)
                indexWriter.commit();
        } catch (IOException e) {
            log.error(LogUtils.DATASOURCE_MARKER, "Couldn't flush the index.", e);
        }
    }

    /**
     * A no-op. IndexWriter takes care of all of the reading/writing in a thread safe manner.
     * 
     * @throws IndexerException
     */
    public void preRemove() throws IndexerException {
    }

    /**
     * Flushes and optimizes the index.
     * 
     * @throws IndexerException
     */
    public void postRemove() throws IndexerException {
        try {
            indexWriter.commit();
        } catch (IOException e) {
            log.error(LogUtils.DATASOURCE_MARKER, "Couldn't flush the indexs:", e);
        }
    }

    /**
     * @throws IndexerException
     *             {@link ExceptionConstants.INDEX#FAILED_INDEX_CLEAR} if there was an exception clearing the index
     */
    public void clear() throws IndexerException {
        try {
            if (indexWriter != null) {
                indexWriter.close();
                indexWriter = null;
            }
            indexWriter = new IndexWriter(FSDirectory.open(new File(location)), analyzer, true, new IndexWriter.MaxFieldLength(IndexWriter.DEFAULT_MAX_FIELD_LENGTH));
            log.trace(LogUtils.DATASOURCE_MARKER, "Index cleared");
        } catch (IOException ioe) {
            throw new IndexerException(ExceptionConstants.INDEX.FAILED_INDEX_CLEAR, ioe);
        }
    }

    /**
     * Closes the resources used by the indexer.
     * 
     * Closes the IndexWriter.
     * 
     * @throws IndexerException
     *             {@link ExceptionConstants.INDEX#FAILED_INDEX_CLOSE} if there was an exception closing the index
     */
    public void close() throws IndexerException {
        try {
            indexWriter.close();
        } catch (IOException e) {
            throw new IndexerException(ExceptionConstants.INDEX.FAILED_INDEX_CLOSE, e);
        }
    }

    /**
     * Add document to index
     * 
     * @param doc
     *            document to index
     * @throws IndexerException
     */
    public void addDocument(Document doc) throws IndexerException {
        try {
            indexWriter.addDocument(doc);
            log.trace(LogUtils.DATASOURCE_MARKER, "statements added to index");
        } catch (IOException e) {
            throw new IndexerException(ExceptionConstants.INDEX.FAILED_CREATE_DOC, e);
        }
    }

    /**
     * Delete document from index
     * 
     * @param term
     *            term to delete
     * @throws IndexerException
     */
    public void deleteDocuments(Term term) throws IndexerException {
        try {
            indexWriter.deleteDocuments(term);
            log.trace(LogUtils.DATASOURCE_MARKER, "statements deleted from index");
        } catch (IOException e) {
            throw new IndexerException(ExceptionConstants.INDEX.FAILED_DELETE_DOC, e);
        }
    }
}
