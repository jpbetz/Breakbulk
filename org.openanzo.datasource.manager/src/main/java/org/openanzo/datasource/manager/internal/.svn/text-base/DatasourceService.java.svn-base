/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Mar 17, 2009
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.manager.internal;

import java.util.List;

import org.openanzo.client.AnzoClient;
import org.openanzo.datasource.IDatasource;
import org.openanzo.datasource.manager.IDatasourceManager;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.execution.IExecutionContext;
import org.openanzo.execution.java.IBundledSemanticService;
import org.openanzo.ontologies.execution.JavaSemanticService;
import org.openanzo.ontologies.system.Datasource;
import org.openanzo.ontologies.system.SystemFactory;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.URI;
import org.openanzo.services.DynamicServiceStats;

/**
 * Semantic Service to make calls against datasources
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class DatasourceService implements IBundledSemanticService {
    static URI          SERVICE_URI = Constants.valueFactory.createURI("http://openanzo.org/semanticServices/datasources");

    IDatasourceManager  manager;

    String              serviceUser;

    DynamicServiceStats stats       = new DynamicServiceStats();

    /**
     * Create new DatasourceService
     * 
     * @param manager
     *            DatasourceManager
     * @param serviceUser
     *            service user
     */
    public DatasourceService(IDatasourceManager manager, String serviceUser) {
        this.manager = manager;
        this.serviceUser = serviceUser;
    }

    public URI getServiceUri() {
        return SERVICE_URI;
    }

    public String getServiceUser() {
        return serviceUser;
    }

    public boolean isLongRunning() {
        return false;
    }

    public void initialize(JavaSemanticService serviceConfig, AnzoClient anzoClient) throws AnzoException {
    }

    public void stop(AnzoClient anzoClient) throws AnzoException {
    }

    /**
     * Runstats on a datasource
     * 
     * @param context
     * @param request
     * @param response
     * @throws AnzoException
     */
    public void runstats(IExecutionContext context, IDataset request, IDataset response) throws AnzoException {
        List<Datasource> datasources = SystemFactory.getAllDatasource(request);
        for (Datasource ds : datasources) {
            IDatasource datasource = manager.getDatasource((URI) ds.resource());
            if (datasource != null) {
                datasource.executeCommand("runstats", request, response);
            }
        }
    }

    public boolean getRestrictInitialPermission() {
        return true;
    }

    public String getDescription() {
        return "Datasource management service";
    }

    public String getName() {
        return "Service=DatasourceManagementService";
    }

    public DynamicServiceStats getStatistics() {
        return stats;
    }
}
