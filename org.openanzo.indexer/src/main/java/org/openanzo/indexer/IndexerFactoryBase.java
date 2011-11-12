/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.indexer/src/com/ibm/adtech/indexer/IndexerFactoryBase.java,v $
 * Created by:  Wing Yung ( <a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com </a>)
 * Created on:  9/19/2006
 * Revision:	$Id: IndexerFactoryBase.java 175 2007-07-31 14:22:29Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.indexer;

import java.util.Dictionary;

/**
 * Factory for indexer-related classes.
 * 
 * @param <T>
 *            type of object to be indexed
 * @param <F>
 *            type of seed object for rebuild of index
 * @author Wing Yung ( <a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com </a>)
 */
public abstract class IndexerFactoryBase<T, F> {

    /**
     * Create an indexer for the given properties
     * 
     * @param configProperties
     *            configuration properties for creating indexer
     * @return indexer for the given properties
     * @throws IndexerException
     */
    public abstract IIndexer<T, F> createIndexer(Dictionary<? extends Object, ? extends Object> configProperties) throws IndexerException;

    /**
     * Create an ISearch object from the given location
     * 
     * @param location
     *            location of properties
     * @return ISearch object for the properties at the given location
     * @throws IndexerException
     */
    public abstract ISearch createSearchFromLocation(String location) throws IndexerException;
}
