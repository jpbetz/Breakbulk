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

import org.openanzo.rdf.URI;

/**
 * Interface for semantic services loaded from a bundle
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public interface IBundledSemanticService extends ISemanticService {
    /**
     * Get the services URI
     * 
     * @return URI of service
     */
    public URI getServiceUri();

    /**
     * Get the user which will run this service
     * 
     * @return this service's user
     */
    public String getServiceUser();

    /**
     * Return true if this is a long running service
     * 
     * @return true if this is a long running service
     */
    public boolean isLongRunning();

    /**
     * 
     * @return true if initial permissions for the newly created service should be locked down to sysadmin users
     */
    public boolean getRestrictInitialPermission();

}
