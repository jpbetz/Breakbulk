/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.jdbc.container;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.IQuadStore;

interface IRDBQuadStore extends IQuadStore {

    /**
     * Connect to the relational database.
     */
    public abstract void connect();

    /**
     * Returns true if there is an active connection to the relational database.
     * 
     * @return True if the connection is active.
     */
    public abstract boolean isConnected();

    /**
     * Closes the connection to the relational database.
     */
    public abstract void close();

    /**
     * Returns true if the connection to the relational database is closed.
     * 
     * @return True if the connection is closed.
     */
    public abstract boolean isClosed();

    /**
     * Delete all the tables for this container
     */
    public abstract void clearDatabase();

    /**
     * Begin database transaction
     * 
     * Note:Database already in transaction
     * 
     * @throws AnzoException
     *             if there was an error starting transaction
     */
    public abstract void begin() throws AnzoException;

    /**
     * Abort database transaction
     * 
     * @throws AnzoException
     *             if there was an error aborting transaction
     */
    public abstract void abort() throws AnzoException;

    /**
     * Commit database transaction
     * 
     * @throws AnzoException
     *             if there was an error committing transaction
     */
    public abstract void commit() throws AnzoException;

}
