/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Sep 9, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.manager.internal;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;
import org.openanzo.datasource.IDatasource;
import org.openanzo.datasource.manager.IDatasourceManager;

/**
 * Command that gets registered with the osgi command console in order to show basic datasource information
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class DatasourceManagerCommand implements CommandProvider {

    private final IDatasourceManager manager;

    DatasourceManagerCommand(IDatasourceManager manager) {
        this.manager = manager;
    }

    public String getHelp() {
        return "---Status of OpenAnzo Datasources---\n\tdatasources - Get the status of Datasources\n";
    }

    /**
     * Command that shows the registered datasources
     * 
     * @param ci
     *            CommandInterpreter
     */
    public void _datasources(CommandInterpreter ci) {
        for (IDatasource datasource : manager.getDatasources()) {
            ci.println(datasource.getInstanceURI() + " isPrimary=[" + datasource.isPrimary() + "]");
        }
    }
}
