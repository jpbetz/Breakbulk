/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.indexer/src/com/ibm/adtech/indexer/ISearch.java,v $
 * Created by:  Wing Yung ( <a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com </a>)
 * Created on:  10/11/2005
 * Revision:	$Id: ISearch.java 175 2007-07-31 14:22:29Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.indexer;

import java.util.List;

/**
 * Used for searching, can be used to iterate over search results.
 * 
 * WWW: Add something to get a result iterator.
 * 
 * @author Wing Yung (<a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com</a>)
 */
public interface ISearch {

    /**
     * Sets the pageSize for getNextResults().
     * 
     * @param pageSize
     *            maximum number of results returned when getNextResults() is called
     */
    public void setPageSize(int pageSize);

    /**
     * Executes the given query, returning the number of hits. Extract the results with getNextResults() or getAllResults().
     * 
     * @param query
     *            text of query to run
     * @return the number of hits in the results
     * @throws IndexerException
     */
    public List<IResult> executeQuery(IQuery query) throws IndexerException;

}
