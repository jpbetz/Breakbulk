/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
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

import java.util.ArrayList;
import java.util.Collection;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.URI;

class NodeCentricDatasourceJMX implements NodeCentricDatasourceJMXMBean {

    private final NodeCentricDatasource datasource;

    public NodeCentricDatasourceJMX(NodeCentricDatasourcesJMX nodeCentricBackendsJMX, NodeCentricDatasource backend) {
        this.datasource = backend;
    }

    public void exportGraphs(String graph, String fileName) {
        try {
            Collection<URI> uris = new ArrayList<URI>();
            uris.add(org.openanzo.rdf.Constants.valueFactory.createURI(graph));
            datasource.exportGraphs(uris, fileName);
        } catch (AnzoException ae) {
            if (NodeCentricDatasourcesJMX.log.isWarnEnabled()) {
                NodeCentricDatasourcesJMX.log.warn(LogUtils.RDB_MARKER, "Error exporting graphs via JMX", ae);
            }
            throw new AnzoRuntimeException(ae);
        }
    }

    public void importBackupData(String fileName) {
        try {
            datasource.importBackupData(true, fileName);
        } catch (AnzoException ae) {
            if (NodeCentricDatasourcesJMX.log.isWarnEnabled()) {
                NodeCentricDatasourcesJMX.log.warn(LogUtils.RDB_MARKER, "Error importing backup data via JMX", ae);
            }
            throw new AnzoRuntimeException(ae);
        }
    }

    public void backup(String fileName) {
        try {
            datasource.backupData(fileName);
        } catch (AnzoException ae) {
            if (NodeCentricDatasourcesJMX.log.isWarnEnabled()) {
                NodeCentricDatasourcesJMX.log.warn(LogUtils.RDB_MARKER, "Error backing up data via JMX", ae);
            }
            throw new AnzoRuntimeException(ae);
        }
    }

    public void restore(String fileName) {
        try {
            datasource.restoreData(fileName);
        } catch (AnzoException ae) {
            if (NodeCentricDatasourcesJMX.log.isWarnEnabled()) {
                NodeCentricDatasourcesJMX.log.warn(LogUtils.RDB_MARKER, "Error restoring data via JMX", ae);
            }
            throw new AnzoRuntimeException(ae);
        }
    }

    public void runstats() {
        try {
            datasource.runstats();
        } catch (AnzoException ae) {
            if (NodeCentricDatasourcesJMX.log.isWarnEnabled()) {
                NodeCentricDatasourcesJMX.log.warn(LogUtils.RDB_MARKER, "Error running runstats via JMX", ae);
            }
            throw new AnzoRuntimeException(ae);
        }
    }

    public int getActiveWriteConnections() {
        return this.datasource.writePool.getNumActive();
    }

    public int getIdleWriteConnections() {
        return this.datasource.writePool.getNumIdle();
    }

    public int getMaxWriteConnections() {
        return this.datasource.writePool.getMaxActive();
    }

    public int getMinIdleWriteConnections() {
        return this.datasource.writePool.getMinIdle();
    }

    public void setMinIdleWriteConnections(int connections) {
        this.datasource.writePool.setMinIdle(connections);
    }

    public void setMinIdleTimeWriteConnections(long idleTime) {
        this.datasource.writePool.setMinEvictableIdleTimeMillis(idleTime);
    }

    public long getMinIdleTimeWriteConnections() {
        return this.datasource.writePool.getMinEvictableIdleTimeMillis();
    }

    public void setMaxWriteConnections(int connections) {
        this.datasource.writePool.setMaxActive(connections);
    }

    public int getMaxIdleWriteConnections() {
        return this.datasource.writePool.getMaxIdle();
    }

    public void setMaxIdleWriteConnections(int connections) {
        this.datasource.writePool.setMaxIdle(connections);
    }

    public long getMaxWaitTimeWriteConnections() {
        return this.datasource.writePool.getMaxWait();
    }

    public void setMaxWaitTimeWriteConnections(long waitTime) {
        this.datasource.writePool.setMaxWait(waitTime);
    }

    public int getActiveQueryConnections() {
        return this.datasource.queryPool.getNumActive();
    }

    public int getIdleQueryConnections() {
        return this.datasource.queryPool.getNumIdle();
    }

    public int getMaxQueryConnections() {
        return this.datasource.queryPool.getMaxActive();
    }

    public int getMinIdleQueryConnections() {
        return this.datasource.queryPool.getMinIdle();
    }

    public void setMinIdleQueryConnections(int connections) {
        this.datasource.queryPool.setMinIdle(connections);
    }

    public void setMinIdleTimeQueryConnections(long idleTime) {
        this.datasource.queryPool.setMinEvictableIdleTimeMillis(idleTime);
    }

    public long getMinIdleTimeQueryConnections() {
        return this.datasource.queryPool.getMinEvictableIdleTimeMillis();
    }

    public void setMaxQueryConnections(int connections) {
        this.datasource.queryPool.setMaxActive(connections);
    }

    public int getMaxIdleQueryConnections() {
        return this.datasource.queryPool.getMaxIdle();
    }

    public void setMaxIdleQueryConnections(int connections) {
        this.datasource.queryPool.setMaxIdle(connections);
    }

    public long getMaxWaitTimeQueryConnections() {
        return this.datasource.queryPool.getMaxWait();
    }

    public void setMaxWaitTimeQueryConnections(long waitTime) {
        this.datasource.queryPool.setMaxWait(waitTime);
    }

    public void purgeQueryConnections() {
        this.datasource.queryPool.clear();
    }

    public void purgeWriteConnections() {
        this.datasource.writePool.clear();
    }

    public String getDatabaseDriver() {
        return this.datasource.getConfiguration().getDriverClassName();
    }

    public String getDatabasePassword() {
        return this.datasource.getConfiguration().getPassword();
    }

    public String getDatabaseURL() {
        return this.datasource.getConfiguration().getJdbcUrl();
    }

    public String getDatabaseUser() {
        return this.datasource.getConfiguration().getUser();
    }
}
