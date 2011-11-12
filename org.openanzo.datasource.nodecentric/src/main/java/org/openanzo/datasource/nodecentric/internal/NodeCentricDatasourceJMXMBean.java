/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse public abstract License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Mar 13, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.internal;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 *
 */
/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface NodeCentricDatasourceJMXMBean {
    /**
     * Run stats on the underlying RDB database
     */
    public abstract void runstats();

    /**
     * Backup the datasource data to a file
     * 
     * @param fileName
     *            name of file for backup
     */
    public abstract void backup(String fileName);

    /**
     * Reset server with backup data
     * 
     * @param fileName
     *            name of file containing backup data
     */
    public abstract void restore(String fileName);

    /**
     * Export the full revision history for a set of graphs
     * 
     * @param graphs
     *            set of graphs to export
     * @param fileName
     *            name of file to store data
     */
    public abstract void exportGraphs(String graphs, String fileName);

    /**
     * Import data from file
     * 
     * @param fileName
     *            name of file containing data
     */
    public abstract void importBackupData(String fileName);

    /**
     * Get the max write connections
     * 
     * @return the max write connections
     */
    public abstract int getMaxWriteConnections();

    /**
     * Set the max write connections
     * 
     * @param connections
     *            max write connections
     */
    public abstract void setMaxWriteConnections(int connections);

    /**
     * Get the min number of idle write connections to keep in pool
     * 
     * @return the min number of idle write connections to keep in pool
     */
    public abstract int getMinIdleWriteConnections();

    /**
     * Set the min number of idle write connections to keep in pool
     * 
     * @param connections
     *            the min number of idle write connections to keep in pool
     */
    public abstract void setMinIdleWriteConnections(int connections);

    /**
     * Get the max idle write connections to keep in pool
     * 
     * @return the max idle write connections to keep in pool
     */
    public abstract int getMaxIdleWriteConnections();

    /**
     * Set the max idle write connections to keep in pool
     * 
     * @param connections
     *            the max idle write connections to keep in pool
     */
    public abstract void setMaxIdleWriteConnections(int connections);

    /**
     * Get the number of active write connections
     * 
     * @return the number of active write connections
     */
    public abstract int getActiveWriteConnections();

    /**
     * Get the numer of idle write connections
     * 
     * @return the numer of idle write connections
     */
    public abstract int getIdleWriteConnections();

    /**
     * @param idleTime
     */
    public abstract void setMinIdleTimeWriteConnections(long idleTime);

    /**
     * Get min idle time for write connections
     * 
     * @return min idle time for write connections
     */
    public abstract long getMinIdleTimeWriteConnections();

    /**
     * Get max wait time for write connections
     * 
     * @return max wait time for write connections
     */
    public abstract long getMaxWaitTimeWriteConnections();

    /**
     * Set the max wait time for write connection
     * 
     * @param waitTime
     *            the max wait time for write connection
     */
    public abstract void setMaxWaitTimeWriteConnections(long waitTime);

    /**
     * Purge the write connections
     */
    public abstract void purgeWriteConnections();

    /**
     * Purge the query connections
     */
    public abstract void purgeQueryConnections();

    /**
     * Get the max query connections
     * 
     * @return the max query connections
     */
    public abstract int getMaxQueryConnections();

    /**
     * Set the max query connections
     * 
     * @param connections
     *            the max query connections
     */
    public abstract void setMaxQueryConnections(int connections);

    /**
     * Set the min idle query connections
     * 
     * @return the min idle query connections
     */
    public abstract int getMinIdleQueryConnections();

    /**
     * Set the min idle query connections
     * 
     * @param connections
     *            the min idle query connections
     */
    public abstract void setMinIdleQueryConnections(int connections);

    /**
     * Set the max idle query connections
     * 
     * @return the max idle query connections
     */
    public abstract int getMaxIdleQueryConnections();

    /**
     * Set the max idle query connections
     * 
     * @param connections
     *            the max idle query connections
     */
    public abstract void setMaxIdleQueryConnections(int connections);

    /**
     * Get the active query connections
     * 
     * @return the active query connections
     */
    public abstract int getActiveQueryConnections();

    /**
     * Get the idle query connections
     * 
     * @return the idle query connections
     */
    public abstract int getIdleQueryConnections();

    /**
     * Set the min idle time for query connections
     * 
     * @param idleTime
     *            the min idle time for query connections
     */
    public abstract void setMinIdleTimeQueryConnections(long idleTime);

    /**
     * Get the min idle time for query connections
     * 
     * @return the min idle time for query connections
     */
    public abstract long getMinIdleTimeQueryConnections();

    /**
     * Get the max wait time for query connections
     * 
     * @return the max wait time for query connections
     */
    public abstract long getMaxWaitTimeQueryConnections();

    /**
     * Set the max wiat time for query connections
     * 
     * @param waitTime
     *            the max wiat time for query connections
     */
    public abstract void setMaxWaitTimeQueryConnections(long waitTime);

    /**
     * Get the url of the database connection
     * 
     * @return the url of the database connection
     */
    public abstract String getDatabaseURL();

    /**
     * Get the database user
     * 
     * @return the database user
     */
    public abstract String getDatabaseUser();

    /**
     * Get the database password
     * 
     * @return the database password
     */
    public abstract String getDatabasePassword();

    /**
     * Get the database driver
     * 
     * @return the database driver
     */
    public abstract String getDatabaseDriver();

}
