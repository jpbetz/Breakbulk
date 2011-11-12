/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Dec 26, 2007
 * Revision: $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

package org.openanzo.client.command;

import java.util.List;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.URI;

/**
 * Called whenever the manager's notifier is invoked.
 * 
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 */
public interface ICommandListener {
    /**
     * Command completed
     * 
     * @param commandType
     *            Type of command completed
     * @param commandContext
     *            Context for the command
     */
    public void commandCompleted(URI commandType, INamedGraph commandContext);

    /**
     * Command failed
     * 
     * @param commandType
     *            Type of command that failed
     * @param commandContext
     *            Context of command
     * @param errors
     *            List of errors that caused command to fail
     */
    public void commandFailed(URI commandType, INamedGraph commandContext, List<AnzoException> errors);

}
