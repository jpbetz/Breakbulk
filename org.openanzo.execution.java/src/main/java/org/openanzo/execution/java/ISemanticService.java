/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.execution.java;

import org.openanzo.client.AnzoClient;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.ontologies.execution.JavaSemanticService;
import org.openanzo.services.IStatisticsProvider;

/**
 * Java semantic service interface
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public interface ISemanticService extends IStatisticsProvider {
    /**
     * Initialize semantic service
     * 
     * @param serviceConfig
     *            Jastor object containing configuration data
     * @param anzoClient
     *            AnzoClient used for service to initialized
     * @throws AnzoException
     */
    public void initialize(JavaSemanticService serviceConfig, AnzoClient anzoClient) throws AnzoException;

    /**
     * Stop the semantic service
     * 
     * @param anzoClient
     *            AnzoClient used for service to stop
     * @throws AnzoException
     */
    public void stop(AnzoClient anzoClient) throws AnzoException;

}
