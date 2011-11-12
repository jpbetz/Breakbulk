/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/exception/UnknownPrefixException.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: UnknownPrefixException.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.exception;

import org.openanzo.glitter.syntax.concrete.ParseException;

/**
 * Parse-time error indicating that a prefixed name had a prefix that was not bound to a URI.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class UnknownPrefixException extends ParseException {
    private static final long serialVersionUID = 527265144118266113L;

    private final String      prefix;

    /**
     * 
     * @param prefix
     *            The unbound prefix
     */
    public UnknownPrefixException(String prefix) {
        super("");
        this.prefix = prefix;
    }

    @Override
    public String getMessage() {
        return "The prefix '" + this.prefix + "' is not bound.";
    }

}
