/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jun 10, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource;

/**
 * Listener that is notified when a datasource is registered and available from OSGI
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface IDatasourceRegistrationListener {
    /**
     * Datasource is available
     * 
     * @param datasource
     *            the available datasource
     */
    public void registerDatasource(IDatasource datasource);

    /**
     * Datasource is no longer available
     * 
     * @param datasource
     *            the no longer available datasource
     */
    public void unregisterDatasource(IDatasource datasource);
}
