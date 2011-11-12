/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Feb 15, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services;

import java.util.Set;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Statement;

/**
 * Event fired when authorization information occurred on within the repository Statements are in format <namedGraphURI> <PriviligePredicate> <RoleURI>
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface IAuthorizationEventListener {
    /**
     * Acl changes occurred
     * 
     * @param aclAdditions
     *            acls that were added
     * @param aclRemovals
     *            acls that were removed
     * @throws AnzoException
     */
    public void handleAuthorizationUpdates(Set<Statement> aclAdditions, Set<Statement> aclRemovals) throws AnzoException;

}
