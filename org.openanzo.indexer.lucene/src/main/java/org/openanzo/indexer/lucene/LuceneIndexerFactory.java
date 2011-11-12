/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.indexer.lucene/src/com/ibm/adtech/indexer/lucene/LuceneIndexerFactory.java,v $
 * Created by:  Wing Yung ( <a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com </a>)
 * Created on:  9/19/2006
 * Revision:	$ Id $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.indexer.lucene;

import java.util.Dictionary;

import org.openanzo.indexer.IIndexer;
import org.openanzo.indexer.IQuery;
import org.openanzo.indexer.IndexerException;
import org.openanzo.indexer.IndexerFactoryBase;

/**
 * Factory for the Lucene-based indexer.
 * 
 * @param <T>
 *            Type of objects that will be indexed
 * @param <F>
 *            Type of object that will be source of rebuild
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public abstract class LuceneIndexerFactory<T, F> extends IndexerFactoryBase<T, F> {

    @Override
    abstract public IIndexer<T, F> createIndexer(Dictionary<? extends Object, ? extends Object> configProperties) throws IndexerException;

    /**
     * Create a query from the given field and search string
     * 
     * @param field
     *            field to query
     * @param text
     *            search string
     * @return IQuery for given field and text
     * @throws IndexerException
     */
    public IQuery createQueryFromDefaultFieldAndText(String field, String text) throws IndexerException {
        LuceneQuery query = new LuceneQuery();
        query.initialize(field, text);
        return query;
    }

    @Override
    public LuceneSearch createSearchFromLocation(String location) throws IndexerException {
        LuceneSearch search = new LuceneSearch();
        search.initialize(location);
        return search;
    }
}
