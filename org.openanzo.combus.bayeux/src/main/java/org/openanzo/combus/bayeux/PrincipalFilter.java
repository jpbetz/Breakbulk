/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Oct 12, 2007
 * Revision:
 $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

package org.openanzo.combus.bayeux;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.openanzo.services.AnzoPrincipal;

/**
 * 
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 * 
 */
class PrincipalFilter implements Filter {

    private static final ThreadLocal<AnzoPrincipal> principal = new ThreadLocal<AnzoPrincipal>();

    protected static AnzoPrincipal getPrincipal() {
        return principal.get();
    }

    public void init(FilterConfig arg0) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        try {
            principal.set((AnzoPrincipal) httpReq.getUserPrincipal());
            chain.doFilter(req, resp);
        } finally {
            // For security make sure that we get always get rid of the principal from the thread-local
            // once it's no longer needed. Threads can be potentially reused for other requests.
            // Better safe than sorry.
            principal.set(null);
        }
    }

    public void destroy() {

    }

}
