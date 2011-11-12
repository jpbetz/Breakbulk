/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     
 *     Cambridge Semantics Incorporated - Initial Implementation
 *******************************************************************************/
package org.openanzo.client;

import java.util.Collection;

import org.openanzo.rdf.Statement;
import org.openanzo.rdf.Value;

/**
 * Listener for the BinaryStore client for events about the status of operations
 */
public interface IBinaryStoreItemProgressListener {
    /**
     * Progress event about binary store operation
     * 
     * @param job
     *            Job which this event is about
     * @param jobCompleted
     *            Amount of data completed
     * @param jobComplete
     *            Total amount of data in job
     * @param additionalStatements
     *            Additional feedback statements
     */
    public void progress(Value job, long jobCompleted, long jobComplete, Collection<Statement> additionalStatements);
}
