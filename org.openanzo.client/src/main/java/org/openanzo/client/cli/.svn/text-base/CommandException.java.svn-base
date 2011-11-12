/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Apr 13, 2009
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.client.cli;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;

/**
 * Command Exception
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class CommandException extends AnzoException {
    private static final long serialVersionUID = 5878320653497364042L;

    CommandException(String reason) {
        super(ExceptionConstants.CLIENT.COMMAND_ERROR, reason);
    }

    CommandException(Throwable exception, String reason) {
        super(ExceptionConstants.CLIENT.COMMAND_ERROR, exception, reason);
    }
}
