/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model.indexer.lucene/src/com/ibm/adtech/boca/model/indexer/lucene/ModelIndexerFactory.java,v $
 * Created by:  Wing Yung ( <a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com </a>)
 * Created on:  9/19/2006
 * Revision:	$Id: ModelIndexerFactory.java 161 2007-07-31 14:11:06Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.indexer;

import java.util.Collection;
import java.util.Dictionary;

import org.apache.lucene.search.Query;
import org.openanzo.datasource.nodecentric.internal.NodeCentricDatasource;
import org.openanzo.datasource.nodecentric.internal.StatementWrapper;
import org.openanzo.indexer.IQuery;
import org.openanzo.indexer.IndexerException;
import org.openanzo.indexer.lucene.LuceneIndexerFactory;

/**
 * Factory for Anzo Lucene indexing.
 * 
 * @author wingerz
 */
public class ModelIndexerFactory extends LuceneIndexerFactory<StatementWrapper, NodeCentricDatasource> {

    /**
     * Create new ModelIndexerFactory
     */
    public ModelIndexerFactory() {

    }

    @Override
    public ModelIndexer createIndexer(Dictionary<? extends Object, ? extends Object> configProperties) throws IndexerException {
        ModelIndexer indexer = new ModelIndexer();
        indexer.initialize(configProperties);
        return indexer;
    }

    /**
     * Creates a query.
     * 
     * @param field
     *            default field to search in the index
     * @param text
     *            text to search for
     */
    @Override
    public IQuery createQueryFromDefaultFieldAndText(String field, String text) throws IndexerException {
        IQuery query = new ModelIndexQuery();
        query.initialize(field, text);
        return query;
    }

    /**
     * Creates a query.
     * 
     * @param field
     *            default field to search in the index
     * @param text
     *            text to search for
     * @param terms
     *            Extra query terms for query
     * @return new query object
     * @throws IndexerException
     */
    public ModelIndexQuery createQueryFromDefaultFieldAndTextAndTerms(String field, String text, Collection<Query> terms) throws IndexerException {
        ModelIndexQuery query = new ModelIndexQuery();
        query.initialize(field, text, terms);
        return query;
    }
}
