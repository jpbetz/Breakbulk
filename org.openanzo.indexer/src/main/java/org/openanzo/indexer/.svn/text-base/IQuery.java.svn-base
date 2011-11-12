/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.indexer/src/com/ibm/adtech/indexer/IQuery.java,v $
 * Created by:  Wing Yung ( <a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com </a>)
 * Created on:  10/11/2005
 * Revision:	$Id: IQuery.java 175 2007-07-31 14:22:29Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
  *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.indexer;


/**
 * Wrapper for query. Use an ISearch to 
 * actually execute the query after initialization. 
 * 
 * Not a great abstraction, but I'm not sure what other 
 * queries will look like.
 * 
 * @author Wing Yung (<a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com</a>)
 */
public interface IQuery {
    
    /**
     * Sets up the query.
     * 
     * @param queryStr
     * 		raw query string to be passed through
     * @throws IndexerException
     * 		
     */
    public void initialize(String queryStr) throws IndexerException;
    
    /**
     * Sets up the query.
     * 
     * @param field
     * 		field in which to look for text
     * @param text
     * 		text to look for 
     * @throws IndexerException
     */
    public void initialize(String field, String text) throws IndexerException;
}
