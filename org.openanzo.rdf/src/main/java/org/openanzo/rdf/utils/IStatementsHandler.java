/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Feb 7, 2009
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.rdf.utils;

import java.util.Collection;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Statement;

/**
 * Basic handler that handles statements from read write utils
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface IStatementsHandler {
    /**
     * Handle a collection of statements
     * 
     * @param statements
     *            collection of statements to handle
     * @throws AnzoException
     */
    void handleStatements(Collection<Statement> statements) throws AnzoException;
}
