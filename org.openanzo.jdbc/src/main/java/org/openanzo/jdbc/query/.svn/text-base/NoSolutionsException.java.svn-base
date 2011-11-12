/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/glitter/NoSolutionsException.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/27/06
 * Revision: $Id: NoSolutionsException.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.query;

import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.exception.GlitterException;

/**
 * Glitter exception when there are no solutions to a query
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class NoSolutionsException extends GlitterException {

    private static final long serialVersionUID = -8521395066017617828L;

    /**
     * @see GlitterException#GlitterException(long, String...)
     */
    public NoSolutionsException() {
        super(ExceptionConstants.GLITTER.NO_SOLUTIONS);
    }

    /**
     * Create a new exception with a set of error tags, an error code, and 0 or more string arguments to the error message.
     * 
     * @param cause
     *            Cause of exception
     * @param args
     *            Arguments to error messages
     */
    public NoSolutionsException(Throwable cause, String... args) {
        super(ExceptionConstants.GLITTER.NO_SOLUTIONS, cause, args);
    }
}
