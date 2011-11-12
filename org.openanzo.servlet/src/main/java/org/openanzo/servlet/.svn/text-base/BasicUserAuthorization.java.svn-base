/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 11, 2009
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.servlet;

import javax.security.auth.Subject;

import org.eclipse.jetty.security.DefaultUserIdentity;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.server.UserIdentity.Scope;
import org.openanzo.rdf.URI;
import org.openanzo.services.AnzoPrincipal;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class BasicUserAuthorization implements Authentication.User {
    UserIdentity  userIdentity;

    AnzoPrincipal principal;

    String        authType;

    /**
     * 
     */
    public BasicUserAuthorization(AnzoPrincipal principal, String authType) {
        this.principal = principal;
        Subject subject = new Subject();
        subject.getPrincipals().add(principal);
        subject.setReadOnly();
        String roles[] = new String[principal.getRoles().size()];
        int i = 0;
        for (URI role : principal.getRoles()) {
            roles[i++] = role.toString();
        }
        userIdentity = new DefaultUserIdentity(subject, principal, roles);
        this.authType = authType;
    }

    public String getAuthMethod() {
        return authType;
    }

    public UserIdentity getUserIdentity() {
        return userIdentity;
    }

    public boolean isUserInRole(Scope scope, String role) {
        return userIdentity.isUserInRole(role, scope);
    }

    public void logout() {
    }

}
