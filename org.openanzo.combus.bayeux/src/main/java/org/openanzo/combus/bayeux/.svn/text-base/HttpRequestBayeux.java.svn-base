/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Jordi A. Albornoz Mulligan <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>
 * Created on:  Jul 15, 2008
 * Revision:    $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.combus.bayeux;

import javax.servlet.http.HttpServletRequest;

import org.cometd.Bayeux;

/**
 * An expanded Bayeux interface that adds support for obtaining the current HTTP request.
 * 
 * @author Jordi A. Albornoz Mulligan <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>
 * 
 */
interface HttpRequestBayeux extends Bayeux {

    public boolean isRequestAvailable();

    public void setRequestAvailable(boolean requestAvailable);

    public HttpServletRequest getCurrentRequest();

}
