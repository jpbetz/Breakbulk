/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.jdbc.utils/src/com/ibm/adtech/jdbc/utils/RdbException.java,v $
 * Created by:  Joe Betz
 * Created on:  9/30/2005
 * Revision:	$Id: RdbException.java 176 2007-07-31 14:22:30Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.utils;

import org.openanzo.exceptions.AnzoException;

/**
 * Exception dealing with RDB errors
 * 
 * @author Joe Betz
 * 
 */

public class RdbException extends AnzoException {
    private static final long serialVersionUID = 1L;

    /**
     * @see AnzoException#AnzoException(long, String...)
     */
    public RdbException(long errorCode, String... message) {
        super(errorCode, message);
    }

    /**
     * @see AnzoException#AnzoException(long, Throwable, String...)
     */
    public RdbException(long errorCode, Throwable cause, String... message) {
        super(errorCode, cause, message);
    }

}
