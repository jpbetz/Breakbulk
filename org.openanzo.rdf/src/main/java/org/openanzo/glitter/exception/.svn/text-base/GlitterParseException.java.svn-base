/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Feb 27, 2009
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.glitter.exception;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.syntax.concrete.ParseException;

/**
 * Glitter parse exception wrapper
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class GlitterParseException extends AnzoException {
    private static final long serialVersionUID = -6812545832679132104L;

    /**
     * Create a new glitter parse exception
     * 
     * @param pe
     *            wrapped parse exception
     * @param queryString
     *            that failed parsing
     * @param parserMessage
     *            message from parser
     */
    public GlitterParseException(ParseException pe, String queryString, String parserMessage) {
        super(ExceptionConstants.GLITTER.PARSE_EXCEPTION, pe, queryString, parserMessage);
    }
}
