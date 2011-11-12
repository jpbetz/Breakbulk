/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/exception/UnknownFunctionException.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: UnknownFunctionException.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.exception;

import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.glitter.syntax.concrete.ParseException;

/**
 * Thrown if a SELECT clause includes a complex expression (not a variable) that is not given an explicit name with the "AS" keyword.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class UnnamedProjectionException extends ParseException {
    private static final long serialVersionUID = -5291275963452341656L;

    /**
     * Unnamed projection exception
     * 
     * @param e
     */
    public UnnamedProjectionException(Expression e) {
        super("Expression is not named: " + e.toString());
    }

}
