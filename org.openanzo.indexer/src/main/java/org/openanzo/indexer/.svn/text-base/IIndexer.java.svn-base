/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.indexer/src/com/ibm/adtech/indexer/IIndexer.java,v $
 * Created by:  Wing Yung ( <a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com </a>)
 * Created on:  10/11/2005
 * Revision:	$Id: IIndexer.java 175 2007-07-31 14:22:29Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.indexer;

import java.util.Dictionary;

/**
 * Generic interface for a text indexer. Currently there is only one implementation (Lucene).
 * 
 * @param <T>
 *            Type of objects that will be indexed
 * @param <S>
 *            Type of object that will be source of rebuild
 * @author Wing Yung (<a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com</a>)
 */
public interface IIndexer<T, S> {

    /**
     * Initializes the indexer with a properties object.
     * 
     * @param configProperties
     *            configuration for the indexer, usually comes from a .properties file
     * @throws IndexerException
     *             if there were errors initializing the indexer
     */
    public void initialize(Dictionary<? extends Object, ? extends Object> configProperties) throws IndexerException;

    /**
     * Return true if the index is invalid and needs to be rebuilt
     * 
     * @return true if the index is invalid and needs to be rebuilt
     */
    public boolean needsIndexRebuild();

    /**
     * Prepares the indexer for calls to index().
     * 
     * @throws IndexerException
     */
    public void preIndex() throws IndexerException;

    /**
     * Called after indexing of a set of statements is complete.
     * 
     * @throws IndexerException
     */
    public void postIndex() throws IndexerException;

    /**
     * Adds the object to the index.
     * 
     * @param object
     *            object to add to the index.
     * @return true if indexing object was successfull
     * @throws IndexerException
     */
    public boolean index(T object) throws IndexerException;

    /**
     * Prepares the indexer for calls to remove().
     * 
     * @throws IndexerException
     */
    public void preRemove() throws IndexerException;

    /**
     * Called after removing a set of statements is complete.
     * 
     * @throws IndexerException
     */
    public void postRemove() throws IndexerException;

    /**
     * Removes the object from the index.
     * 
     * @param object
     *            object to remove from the index.
     * @throws IndexerException
     */
    public void remove(T object) throws IndexerException;

    /**
     * Clears the contents of the index.
     * 
     * @throws IndexerException
     */
    public void clear() throws IndexerException;

    /**
     * Cleans up the indexer, freeing resources. The indexer should not be used after it is closed.
     * 
     * @throws IndexerException
     */
    public void close() throws IndexerException;

    /**
     * Rebuilds the index given the seed object.
     * 
     * @param seedObject
     *            object used to rebuild the entire index
     * @return id of the indexer
     * @throws IndexerException
     */
    public int rebuild(S seedObject) throws IndexerException;
}
