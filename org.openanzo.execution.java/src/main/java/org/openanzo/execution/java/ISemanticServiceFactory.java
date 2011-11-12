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

import org.openanzo.exceptions.AnzoException;
import org.openanzo.ontologies.execution.JavaSemanticService;

/**
 * Factory for a java semantic service
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public interface ISemanticServiceFactory {
    /**
     * Create a service based on the configuration from the JavaSemanticService jastor object
     * 
     * @param serviceConfig
     *            JavaSemanticService jastor object
     * @return new Service
     * @throws AnzoException
     */
    public ISemanticService createService(JavaSemanticService serviceConfig) throws AnzoException;

}
