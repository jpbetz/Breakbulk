/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  May 22, 2009
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.servlet;

import org.eclipse.jetty.server.Request;
import org.openanzo.services.AnzoPrincipal;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface IAuthenticatorRealm {

    /**
     * Authenticate a user with the authentication service
     * 
     * @param userId
     *            userid to authentication
     * @param credentials
     *            password to authenticate
     * @param request
     *            request to authenticate
     * @return principal if authentication passed
     */
    public abstract AnzoPrincipal authenticate(String userId, Object credentials, Request request);

}
