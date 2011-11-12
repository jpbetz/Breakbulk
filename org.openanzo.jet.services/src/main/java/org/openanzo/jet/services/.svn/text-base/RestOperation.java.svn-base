/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Dec 3, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.jet.services;

import org.openanzo.ontologies.system.Operation;

/**
 * Rest operation
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class RestOperation implements Comparable<RestOperation> {
    /** Operation name */
    public String    operationName = null;

    /** Operation */
    public Operation operation     = null;

    /** Object URI */
    public boolean   objectUri     = false;

    /**
     * Create new rest operation
     * 
     * @param operationName
     *            name of operation
     * @param operation
     *            operation object
     * @param objectUri
     *            uri of object
     */
    public RestOperation(String operationName, Operation operation, boolean objectUri) {
        super();
        this.operationName = operationName;
        this.operation = operation;
        this.objectUri = objectUri;
    }

    public int compareTo(RestOperation o) {
        if (operationName == null && o.operationName == null) {
            if (objectUri)
                return -1;
            else if (o.objectUri)
                return 1;
            return 0;
        } else if (operationName != null && o.operationName != null) {
            int compare = operationName.compareTo(o.operationName);
            if (compare == 0) {
                if (objectUri)
                    return -1;
                else if (o.objectUri)
                    return 1;
                return 0;
            } else {
                return compare;
            }
        } else if (operationName == null) {
            return -1;
        } else {
            return 1;
        }
    }

    /** Request type */
    public enum RequestType {
        /** Get request */
        GET,
        /** Post request */
        POST,
        /** Put request */
        PUT,
        /** Delete request */
        DELETE
    }
}
