/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.indexer/src/com/ibm/adtech/indexer/IndexerException.java,v $
 * Created by:  Wing Yung ( <a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com </a>)
 * Created on:  10/11/2005
 * Revision:	$Id: IndexerException.java 175 2007-07-31 14:22:29Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.indexer;

import org.openanzo.exceptions.AnzoException;

/**
 * Exception thrown by index api classes
 * 
 * @author Wing Yung (<a href="mailto:crv@us.ibm.com">wingyung@us.ibm.com</a>)
 */
public class IndexerException extends AnzoException {
    private static final long serialVersionUID = 1L;

    /**
     * @see AnzoException#AnzoException(long, String...)
     */
    public IndexerException(long errorCode, String... message) {
        super(errorCode, message);
    }

    /**
     * @see AnzoException#AnzoException(long, Throwable,String...)
     */
    public IndexerException(long errorCode, Throwable cause, String... message) {
        super(errorCode, cause, message);
    }

}
