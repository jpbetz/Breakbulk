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
import org.openanzo.exceptions.AnzoRuntimeException;

/**
 * Glitter runtime Exception
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class GlitterRuntimeException extends AnzoRuntimeException {

    private static final long serialVersionUID = 7416286536705118823L;

    /**
     * @param anzoException
     */
    public GlitterRuntimeException(AnzoException anzoException) {
        super(anzoException.getErrorCode(), anzoException.getCause(), anzoException.getArgs());
    }

    /**
     * @param errorCode
     * @param arguments
     */
    public GlitterRuntimeException(long errorCode, String... arguments) {
        super(errorCode, arguments);
    }

    /**
     * @param errorCode
     * @param cause
     * @param arguments
     */
    public GlitterRuntimeException(long errorCode, Throwable cause, String... arguments) {
        super(errorCode, cause, arguments);
    }
}
