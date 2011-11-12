/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 29, 2007
 * Revision:	$Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.commons.collections15.MultiMap;
import org.openanzo.datasource.DatasourceDictionary;
import org.openanzo.datasource.IDatasource;
import org.openanzo.datasource.nodecentric.sql.Backup;
import org.openanzo.datasource.nodecentric.sql.InsertStatementsRdbWrapper;
import org.openanzo.datasource.nodecentric.sql.LastTransactionTime;
import org.openanzo.datasource.nodecentric.sql.ServerRdbWrapper;
import org.openanzo.datasource.services.BaseResetService;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.jdbc.container.sql.BaseSQL;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.ontologies.openanzo.AnzoServer;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Dataset;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.MemTypedLiteral;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.SegmentedStatementCollector;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.rdf.Constants.OSGI;
import org.openanzo.rdf.utils.Pair;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.SmartEncodingInputStream;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.rdf.vocabulary.RDF;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.impl.BaseOperationContext;
import org.openanzo.services.serialization.BackupRevision;
import org.openanzo.services.serialization.IBackupHandler;
import org.openanzo.services.serialization.XMLBackupReader;
import org.osgi.service.event.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NodeCentric implementation of the IResetService
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
class NodeCentricResetService extends BaseResetService {
    private static final Logger         log                 = LoggerFactory.getLogger(NodeCentricResetService.class);

    private final NodeCentricDatasource datasource;

    private static final String         resourcePrefix      = "resource:";

    private static final String         initServerStatement = "initServerTables";

    private static final String         initTablespace      = "initTablespace";

    private static final String         initDBtables        = "initDBtables";

    private static final String         initIndexes         = "initIndexes";

    private static final String         initSequences       = "initSequences";

    private static final String         dropSequence        = "DROP SEQUENCE ";

    private static final String         dropView            = "DROP VIEW ";

    private static final String         dropTable           = "DROP TABLE ";

    static final String[]               liveTables          = { "NAMEDGRAPHS", "NAMEDGRAPHS_NR", "STATEMENTS", "STATEMENTS_NR", "LASTTRANSACTIONTIME", "LOCKED_GRAPHS", "TRANSACTIONTIME", "QUERY_GRAPHS" };

    private static final String[]       tempTables          = { "DEFAULTGRAPHS_TMP", "NAMEDGRAPHS_TMP", "TEMPGRAPHS", "TEMP_COLUMNS", "SUBJECT_IDS_TEMP", "PREDICATE_IDS_TEMP", "OBJECT_IDS_TEMP", "NAMEDGRAPH_IDS_TEMP", "ID_TMP", "RES_TMP", "LIT_TMP", "STMTS_TMP", "NGR_TMP", "STMTS_REP_TMP", "STMT_ID_TMP", "REMOVE_GRAPHS_TMP", "TEMP_CONSTRAINT0", "TEMP_CONSTRAINT1", "TEMP_CONSTRAINT2", "TEMP_CONSTRAINT3" };

    private static final String[]       staticTables        = { "GLITTERUNIT" };

    private static final String[][]     sequences           = { { "NODE_SEQ_0", "NODE_SEQ_1", "NODE_SEQ_2", "NODE_SEQ_3", "NODE_SEQ_4", "NODE_SEQ_5", "NODE_SEQ_6" }, {}, {}, {}, {}, {}, {}, {}, { "DATATYPE_SEQ", "LANG_SEQ" }, {}, {}, {}, {}, {}, {}, {}, {} };

    private static final String[]       views               = { "ALL_STMTS_VIEW", "ALL_LITERALS_VIEW" };

    private String[]                    nodeCentricTables   = null;

    private Collection<String>          rdfInitFiles        = null;

    private boolean                     hardReset           = false;

    protected NodeCentricResetService(boolean resetEnabled, NodeCentricDatasource datasource) {
        super(resetEnabled, datasource.getEventAdmin());
        this.datasource = datasource;
    }

    public IDatasource getDatasource() {
        return datasource;
    }

    @Override
    public void start() throws AnzoException {
        String[] postfixes = new String[] { "_B", "_L", "_LL", "_LU", "_U", "_USED_IDS", "_TL", "_LTL", "_DATATYPE", "_LANGUAGE" };
        nodeCentricTables = new String[postfixes.length];
        for (int i = 0; i < postfixes.length; i++) {
            nodeCentricTables[i] = datasource.getConfiguration().getContainerName() + postfixes[i];
        }
        String intResources = DatasourceDictionary.getInitFiles(datasource.getConfigurationParameters());
        if (intResources != null && intResources.length() > 0) {
            rdfInitFiles = new ArrayList<String>();
            StringTokenizer st = new StringTokenizer(intResources, ",");
            while (st.hasMoreTokens()) {
                rdfInitFiles.add(st.nextToken());
            }
        }
        //this.aclEventListeners = datasource.getAclEventListeners();
        hardReset = datasource.getConfiguration().getUseHardReset();
    }

    /**
     * Reset the database
     * 
     * @param connectionContext
     *            NodeCentric specific context, which contains connection to run queries against
     * @param hardReset
     *            if true, all tables are dropped and not just truncated
     * @param statements
     *            statements to use to initialize database
     * @return ValuePair containing servers new URI and ID
     * @throws AnzoException
     */
    protected URI resetDatabase(NodeCentricOperationContext connectionContext, boolean hardReset, MultiMap<URI, Statement> statements) throws AnzoException {
        datasource.resetDatasource();
        Pair<Long, URI> serverURI = null;
        boolean[] result = lockDB(connectionContext);
        if (result[1]) {
            try {
                serverURI = resetDatabaseTables(connectionContext, hardReset);
                if (statements != null && statements.size() > 0) {
                    resetGraph(statements, connectionContext, serverURI.second);
                } else {
                    if (rdfInitFiles != null && rdfInitFiles.size() > 0) {
                        initializeProvidedRoles(connectionContext, serverURI.second);
                    } else {
                        initializeDefaultRoles(connectionContext, serverURI.second);
                    }
                }
                unLockDB(connectionContext, true, serverURI.first);
                return serverURI.second;
            } catch (AnzoException ae) {
                if (result[0]) {
                    BaseSQL.dropTable(connectionContext.getStatementProvider(), connectionContext.getConnection(), connectionContext.getConfiguration().getUsesUppercase() ? NodeCentricDatasource.serverUpper : NodeCentricDatasource.serverLower);
                }
                throw ae;
            }
        } else {
            if (result[0]) {
                BaseSQL.dropTable(connectionContext.getStatementProvider(), connectionContext.getConnection(), connectionContext.getConfiguration().getUsesUppercase() ? NodeCentricDatasource.serverUpper : NodeCentricDatasource.serverLower);
            }
            throw new AnzoException(ExceptionConstants.RDB.FAILED_INITIALZE_DB);
        }
    }

    @Override
    protected URI resetInternal(IOperationContext context, MultiMap<URI, Statement> statements, java.util.Collection<org.openanzo.rdf.Statement> checks) throws AnzoException {
        NodeCentricOperationContext connectionContext = null;
        try {
            connectionContext = datasource.getWriteContext(context);
            return resetDatabase(connectionContext, getUseHardReset(), statements);
        } finally {
            if (connectionContext != null) {
                datasource.returnWriteContext(connectionContext);
            }
        }
    }

    /*
     * Reset the underlying JDBC database tables
     */
    private Pair<Long, URI> resetDatabaseTables(NodeCentricOperationContext connectionContext, boolean hardReset) throws AnzoException {
        try {
            dropTables(connectionContext, hardReset);
            datasource.begin(connectionContext.getConnection(), true, true);
            Long ts = Long.valueOf(0);
            LastTransactionTime.insertFirstTransactionTime(connectionContext.getStatementProvider(), connectionContext.getConnection(), ts);
            URI serverUri = UriGenerator.generateServerIdURI();
            Long serverId = connectionContext.getNodeLayout().store(serverUri, connectionContext.getConnection(), 1);
            ServerRdbWrapper.setServerId(connectionContext.getStatementProvider(), connectionContext.getConnection(), serverId);
            connectionContext.getNodeLayout().store(Constants.EVERYONE_ROLE, connectionContext.getConnection(), 1);
            datasource.commit(connectionContext.getConnection(), true, true);
            connectionContext.getNodeLayout().commitReferencedIds(connectionContext.getConnection(), 1);
            return new Pair<Long, URI>(serverId, serverUri);
        } catch (Exception e) {
            log.error(LogUtils.RDB_MARKER, "SQL Error resetting database tables", e);
            datasource.abort(connectionContext.getConnection(), true, true);
            throw new AnzoException(ExceptionConstants.RDB.OPERATION_ERROR, e, e.getMessage());
        }
    }

    /*
     * Initialize default system information with data from RepositoryInitializationFile if no system graph information was
     * provided
     */
    private void initializeProvidedRoles(NodeCentricOperationContext context, URI serverURI) throws AnzoException {
        SegmentedStatementCollector sc = new SegmentedStatementCollector();
        try {
            if (log.isWarnEnabled()) {
                log.warn(LogUtils.RDB_MARKER, "Initializing database from files: {}", Arrays.toString(rdfInitFiles.toArray()));
            }
            for (String file : rdfInitFiles) {
                ReadWriteUtils.parseStatements(SmartEncodingInputStream.createSmartReader(getLocationAsStream(file)), RDFFormat.forFileName(file), "", sc);
            }
        } catch (AnzoException mse) {
            throw new AnzoRuntimeException(mse);
        }
        resetGraph(sc.getStatements(), context, serverURI);
    }

    private static final String ID_STRING = "{0}:{1}:{2}:{3}";

    public void restoreData(String fileName) throws AnzoException {
        final NodeCentricOperationContext connectionContext = datasource.getWriteContext(new BaseOperationContext("RESTORE", BaseOperationContext.generateOperationId(), new AnzoPrincipal("sysadmin", null, null, true, false)));
        if (getLockProvider() != null) {
            getLockProvider().writeLock().lock();
        }
        try {
            datasource.resetStarting();
            datasource.reset();
            if (eventAdmin != null)
                eventAdmin.sendEvent(new Event(OSGI.RESET_TOPIC, (Dictionary<Object, Object>) new Properties()));

            Pair<Long, URI> serverURI = null;

            datasource.resetDatasource();
            boolean[] result = lockDB(connectionContext);
            if (result[1]) {
                try {
                    serverURI = resetDatabaseTables(connectionContext, hardReset);

                    try {
                        Reader fileReader = ReadWriteUtils.createSmartFileReader(fileName);
                        XMLBackupReader reader = new XMLBackupReader(fileReader);
                        try {
                            reader.read(new IBackupHandler() {
                                Long graphId;

                                Long metaId;

                                Long uuidId;

                                public void start() throws AnzoException {
                                    datasource.begin(connectionContext.getConnection(), true, true);
                                }

                                public void handleStatement(boolean metadata, boolean revisioned, Statement statement, Long start, Long end) throws AnzoException {
                                    Long s = connectionContext.getNodeLayout().store(statement.getSubject(), connectionContext.getConnection(), 1);
                                    Long p = connectionContext.getNodeLayout().store(statement.getPredicate(), connectionContext.getConnection(), 1);
                                    Long o = connectionContext.getNodeLayout().store(statement.getObject(), connectionContext.getConnection(), 1);
                                    String stmtId = MessageFormat.format(ID_STRING, (metadata) ? metaId.toString() : graphId.toString(), s.toString(), p.toString(), o.toString());
                                    if (revisioned) {
                                        Backup.restoreStatement(connectionContext.getStatementProvider(), connectionContext.getConnection(), stmtId, metadata ? 1 : 0, uuidId, metadata ? metaId : graphId, s, p, o, start, end);
                                    } else {
                                        Backup.restoreStatementNR(connectionContext.getStatementProvider(), connectionContext.getConnection(), stmtId, metadata ? 1 : 0, metadata ? metaId : graphId, s, p, o);
                                    }
                                }

                                public boolean handleNamedGraph(boolean revisioned, URI namedGraphUri, URI metadataURI, URI uuid, Collection<BackupRevision> revisions) throws AnzoException {
                                    try {
                                        connectionContext.getConnection().commit();
                                    } catch (SQLException sqle) {
                                        throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_COMMIT_RDB_TRANSACTION, sqle);
                                    }
                                    uuidId = connectionContext.getNodeLayout().store(uuid, connectionContext.getConnection(), 1);
                                    graphId = connectionContext.getNodeLayout().store(namedGraphUri, connectionContext.getConnection(), 1);
                                    metaId = connectionContext.getNodeLayout().store(metadataURI, connectionContext.getConnection(), 1);
                                    for (BackupRevision backup : revisions) {
                                        Long lastMod = connectionContext.getNodeLayout().store(backup.lastModifiedBy, connectionContext.getConnection(), 1);
                                        if (revisioned) {
                                            Backup.restoreNamedGraph(connectionContext.getStatementProvider(), connectionContext.getConnection(), backup.start, backup.end, graphId, metaId, uuidId, backup.revision, lastMod);
                                        } else {
                                            Backup.restoreNamedGraphNR(connectionContext.getStatementProvider(), connectionContext.getConnection(), backup.start, graphId, metaId, uuidId, backup.revision, lastMod);
                                        }
                                    }
                                    return true;
                                }

                                public void end() throws AnzoException {
                                    datasource.commit(connectionContext.getConnection(), true, true);
                                    connectionContext.getNodeLayout().commitReferencedIds(connectionContext.getConnection(), 1);
                                }
                            });
                        } catch (AnzoException ae) {
                            datasource.abort(connectionContext.getConnection(), true, true);
                        } finally {
                            if (fileReader != null) {
                                fileReader.close();
                            }
                        }
                    } catch (Exception e) {
                        log.error(LogUtils.RDB_MARKER, "Error resetting datasource", e);
                    }
                    datasource.getIndexHandler().rebuildIndex(true);
                } catch (AnzoException ae) {
                    if (result[0]) {
                        BaseSQL.dropTable(connectionContext.getStatementProvider(), connectionContext.getConnection(), connectionContext.getConfiguration().getUsesUppercase() ? NodeCentricDatasource.serverUpper : NodeCentricDatasource.serverLower);
                    }
                    throw ae;
                }
                unLockDB(connectionContext, true, serverURI.first);
                datasource.postReset();
                datasource.resetFinished();
            } else {
                if (result[0]) {
                    BaseSQL.dropTable(connectionContext.getStatementProvider(), connectionContext.getConnection(), connectionContext.getConfiguration().getUsesUppercase() ? NodeCentricDatasource.serverUpper : NodeCentricDatasource.serverLower);
                }
                throw new AnzoException(ExceptionConstants.RDB.FAILED_INITIALZE_DB);
            }
        } finally {
            if (getLockProvider() != null) {
                getLockProvider().writeLock().unlock();
            }
            datasource.returnWriteContext(connectionContext);
        }
    }

    private boolean[] lockDB(NodeCentricOperationContext connectionContext) {
        boolean ownsIt = false;
        try {
            connectionContext.getStatementProvider().runSQLGroup(initServerStatement, datasource.getInitParams(), connectionContext.getConnection());
            ownsIt = true;
        } catch (SQLException sqle) {
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "SQL Error initializing SERVER table", sqle);
            }
        } catch (RdbException sqle) {
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "SQL Error initializing SERVER table", sqle);
            }
        }
        try {
            int counter = ServerRdbWrapper.setInitializing(connectionContext.getStatementProvider(), connectionContext.getConnection(), System.currentTimeMillis());
            if (counter == 0) {
                ServerRdbWrapper.setInitializingFailed(connectionContext.getStatementProvider(), connectionContext.getConnection());
                return new boolean[] { ownsIt, false };
            }
            return new boolean[] { ownsIt, true };
        } catch (AnzoException sqle) {
            if (log.isErrorEnabled()) {
                log.error(LogUtils.RDB_MARKER, "Error unlocking db", sqle);
            }
            return new boolean[] { ownsIt, false };
        }
    }

    private void unLockDB(NodeCentricOperationContext connectionContext, boolean passed, long serverId) {
        if (passed) {
            try {
                ServerRdbWrapper.setInitialized(connectionContext.getStatementProvider(), connectionContext.getConnection(), serverId);
            } catch (AnzoException sqle) {
                log.error(LogUtils.RDB_MARKER, "Error unlocking db", sqle);
            }
        } else {
            try {
                ServerRdbWrapper.setInitializingFailed(connectionContext.getStatementProvider(), connectionContext.getConnection());
            } catch (AnzoException sqle) {
                log.error(LogUtils.RDB_MARKER, "Error unlocking db", sqle);
            }
        }
    }

    private void dropTables(NodeCentricOperationContext connectionContext, boolean hardReset) throws AnzoException, SQLException {
        long start = System.currentTimeMillis();
        if (hardReset) {
            String[][] tableSets = { liveTables, nodeCentricTables, staticTables };
            datasource.begin(connectionContext.getConnection(), true, true);

            java.sql.Statement stmt = connectionContext.getConnection().createStatement();
            try {
                for (String view : views) {
                    try {
                        stmt.executeUpdate(dropView + datasource.getConfiguration().getDropExtras() + " " + view);
                    } catch (SQLException sqle) {
                        if (log.isTraceEnabled()) {
                            log.trace(LogUtils.RDB_MARKER, "SQL Error droping view", sqle);
                        }
                    }
                }
                for (String[] sequenceVers : sequences) {
                    if (sequenceVers != null) {
                        for (String sequence : sequenceVers) {
                            try {
                                stmt.executeUpdate(dropSequence + datasource.getConfiguration().getDropExtras() + " " + sequence);
                            } catch (SQLException sqle) {
                                if (log.isTraceEnabled()) {
                                    log.trace(LogUtils.RDB_MARKER, "SQL Error droping sequence", sqle);
                                }
                            }
                        }
                    }
                }
                if (!connectionContext.getConfiguration().getSupportsIdentity()) {
                    try {
                        stmt.executeUpdate(dropSequence + datasource.getConfiguration().getDropExtras() + " LANG_SEQ");
                    } catch (SQLException sqle) {
                        if (log.isTraceEnabled()) {
                            log.trace(LogUtils.RDB_MARKER, "SQL Error droping sequence", sqle);
                        }
                    }
                    try {
                        stmt.executeUpdate(dropSequence + datasource.getConfiguration().getDropExtras() + " DATATYPE_SEQ");
                    } catch (SQLException sqle) {
                        if (log.isTraceEnabled()) {
                            log.trace(LogUtils.RDB_MARKER, "SQL Error droping sequence", sqle);
                        }
                    }
                }
                for (String[] tables : tableSets) {
                    for (String table : tables) {
                        try {
                            stmt.executeUpdate(dropTable + datasource.getConfiguration().getDropExtras() + " " + table);
                        } catch (SQLException sqle) {
                            if (log.isTraceEnabled()) {
                                log.trace(LogUtils.RDB_MARKER, "SQL Error droping table", sqle);
                            }
                        }
                    }
                }
                for (String table : tempTables) {
                    try {
                        stmt.executeUpdate(dropTable + datasource.getConfiguration().getDropExtras() + " " + datasource.getConfiguration().getSessionPrefix() + table);
                    } catch (SQLException sqle) {
                        if (log.isTraceEnabled()) {
                            log.trace(LogUtils.RDB_MARKER, "SQL Error droping temptable", sqle);
                        }
                    }
                }
            } finally {
                try {
                    stmt.close();
                } catch (SQLException sqle) {
                    if (log.isTraceEnabled()) {
                        log.trace(LogUtils.RDB_MARKER, "SQL Error closing statement", sqle);
                    }
                }
                datasource.commit(connectionContext.getConnection(), true, true);
            }

            if (datasource.getConfiguration().getRequiresTempTablespace() && InsertStatementsRdbWrapper.getTempTablespaceDefined(connectionContext.getStatementProvider(), connectionContext.getConnection()) == 0) {
                datasource.begin(connectionContext.getConnection(), true, true);
                try {
                    connectionContext.getStatementProvider().runSQLGroup(initTablespace, new String[0], connectionContext.getConnection());
                } catch (SQLException sqle) {
                    if (log.isErrorEnabled()) {
                        log.error(LogUtils.RDB_MARKER, "SQL Error initializing tablespace", sqle);
                    }
                    throw sqle;
                } finally {
                    datasource.commit(connectionContext.getConnection(), true, true);
                }

            }
            datasource.begin(connectionContext.getConnection(), true, true);
            try {
                connectionContext.getStatementProvider().runSQLGroup(initDBtables, datasource.getInitParams(), connectionContext.getConnection());
                connectionContext.getStatementProvider().runSQLGroup(initIndexes, datasource.getInitParams(), connectionContext.getConnection());
                connectionContext.getStatementProvider().runSQLGroup(initSequences, datasource.getInitParams(), connectionContext.getConnection());
                datasource.commit(connectionContext.getConnection(), true, true);
            } catch (SQLException sqle) {
                log.error(LogUtils.RDB_MARKER, "Error initializing database tables", sqle);
                datasource.abort(connectionContext.getConnection(), true, true);
                throw new AnzoException(ExceptionConstants.RDB.FAILED_INITIALZE_DB, sqle);
            }
            try {
                datasource.begin(connectionContext.getConnection(), true, true);
                connectionContext.getStatementProvider().runSQLGroup("createTemporaryTables", datasource.getInitParams(), connectionContext.getConnection());
                datasource.commit(connectionContext.getConnection(), true, true);
            } catch (SQLException sqle) {
                log.error(LogUtils.RDB_MARKER, "Error initializing database temporary tables", sqle);
                datasource.abort(connectionContext.getConnection(), true, true);
                throw new AnzoException(ExceptionConstants.RDB.FAILED_INITIALZE_TEMPTABLES, sqle);
            }

        } else {
            String[][] tableSets = { liveTables, nodeCentricTables };
            datasource.begin(connectionContext.getConnection(), true, true);
            java.sql.Statement stmt = connectionContext.getConnection().createStatement();
            try {
                for (String[] tables : tableSets) {
                    for (String table : tables) {
                        try {
                            BaseSQL.truncateTableMayCommit(connectionContext.getStatementProvider(), connectionContext.getConnection(), table);
                        } catch (RdbException sqle) {
                            if (log.isErrorEnabled()) {
                                log.error(LogUtils.RDB_MARKER, "SQL Error truncating table", sqle);
                            }
                        }
                    }
                }
            } finally {
                try {
                    stmt.close();
                } catch (SQLException sqle) {
                    if (log.isTraceEnabled()) {
                        log.trace(LogUtils.RDB_MARKER, "SQL Error closing statement", sqle);
                    }
                }
                datasource.commit(connectionContext.getConnection(), true, true);
            }
        }
        if (log.isDebugEnabled()) {
            log.debug(LogUtils.RDB_MARKER, "[RESET DB] {}", (System.currentTimeMillis() - start));
        }
    }

    /*
     * Process the contents of the graph into the database
     */
    private void resetGraph(MultiMap<URI, Statement> statements, NodeCentricOperationContext context, URI serverURI) throws AnzoException {
        Collection<Statement> graphTemplates = new ArrayList<Statement>();
        // If a graph doesn't have a corresponding metadata graph in the statements, then add a default metadata graph for it.
        graphTemplates.add(new Statement(GRAPHS.DEFAULT_GRAPH_TEMPLATE, RDF.TYPE, NamedGraph.TYPE));
        graphTemplates.add(new Statement(GRAPHS.DEFAULT_GRAPH_TEMPLATE, NamedGraph.revisionedProperty, MemTypedLiteral.create(true)));
        graphTemplates.add(new Statement(GRAPHS.DEFAULT_GRAPH_TEMPLATE, NamedGraph.persistedProperty, MemTypedLiteral.create(true)));

        graphTemplates.add(new Statement(GRAPHS.DEFAULT_GRAPH_TEMPLATE, NamedGraph.canBeReadByProperty, Constants.EVERYONE_ROLE));
        graphTemplates.add(new Statement(GRAPHS.DEFAULT_GRAPH_TEMPLATE, NamedGraph.canBeAddedToByProperty, Constants.EVERYONE_ROLE));
        graphTemplates.add(new Statement(GRAPHS.DEFAULT_GRAPH_TEMPLATE, NamedGraph.canBeRemovedFromByProperty, Constants.EVERYONE_ROLE));

        graphTemplates.add(new Statement(GRAPHS.DEFAULT_METADATA_GRAPH_TEMPLATE, NamedGraph.canBeReadByProperty, Constants.EVERYONE_ROLE));
        graphTemplates.add(new Statement(GRAPHS.DEFAULT_METADATA_GRAPH_TEMPLATE, NamedGraph.canBeAddedToByProperty, Constants.EVERYONE_ROLE));
        graphTemplates.add(new Statement(GRAPHS.DEFAULT_METADATA_GRAPH_TEMPLATE, NamedGraph.canBeRemovedFromByProperty, Constants.EVERYONE_ROLE));

        context.setAttribute("resetting", Boolean.valueOf(true));
        statements.put(GRAPHS.DEFAULT_SYSTEMGRAPH, Constants.valueFactory.createStatement(GRAPHS.DEFAULT_SYSTEMGRAPH, AnzoServer.serverIdProperty, serverURI, GRAPHS.DEFAULT_SYSTEMGRAPH));
        datasource.getUpdateService().importStatements(context, statements.values(), graphTemplates);

    }

    /*
     * Process the contents of the graph into the database
     */
    private void initializeDefaultRoles(NodeCentricOperationContext context, URI serverURI) throws AnzoException {
        context.setAttribute("resetting", Boolean.valueOf(true));
        IDataset dataset = new Dataset();
        //System graph
        dataset.addNamedGraph(GRAPHS.DEFAULT_SYSTEMGRAPH);
        dataset.addNamedGraph(GRAPHS.DEFAULT_SYSTEM_METAGRAPH);

        dataset.add(GRAPHS.DEFAULT_SYSTEMGRAPH, AnzoServer.serverIdProperty, serverURI, GRAPHS.DEFAULT_SYSTEMGRAPH);
        dataset.add(GRAPHS.DEFAULT_SYSTEMGRAPH, RDF.TYPE, org.openanzo.ontologies.openanzo.NamedGraph.TYPE, GRAPHS.DEFAULT_SYSTEM_METAGRAPH);
        dataset.add(GRAPHS.DEFAULT_SYSTEMGRAPH, org.openanzo.ontologies.openanzo.NamedGraph.persistedProperty, Constants.valueFactory.createTypedLiteral(Boolean.TRUE), GRAPHS.DEFAULT_SYSTEM_METAGRAPH);
        dataset.add(GRAPHS.DEFAULT_SYSTEMGRAPH, org.openanzo.ontologies.openanzo.NamedGraph.revisionedProperty, Constants.valueFactory.createTypedLiteral(Boolean.TRUE), GRAPHS.DEFAULT_SYSTEM_METAGRAPH);
        dataset.add(GRAPHS.DEFAULT_SYSTEMGRAPH, org.openanzo.ontologies.openanzo.NamedGraph.canBeReadByProperty, Constants.EVERYONE_ROLE, GRAPHS.DEFAULT_SYSTEM_METAGRAPH);
        dataset.add(GRAPHS.DEFAULT_SYSTEMGRAPH, org.openanzo.ontologies.openanzo.NamedGraph.canBeAddedToByProperty, Constants.NOONE_ROLE, GRAPHS.DEFAULT_SYSTEM_METAGRAPH);
        dataset.add(GRAPHS.DEFAULT_SYSTEMGRAPH, org.openanzo.ontologies.openanzo.NamedGraph.canBeRemovedFromByProperty, Constants.NOONE_ROLE, GRAPHS.DEFAULT_SYSTEM_METAGRAPH);
        dataset.add(GRAPHS.DEFAULT_SYSTEM_METAGRAPH, org.openanzo.ontologies.openanzo.NamedGraph.canBeReadByProperty, Constants.NOONE_ROLE, GRAPHS.DEFAULT_SYSTEM_METAGRAPH);
        dataset.add(GRAPHS.DEFAULT_SYSTEM_METAGRAPH, org.openanzo.ontologies.openanzo.NamedGraph.canBeAddedToByProperty, Constants.NOONE_ROLE, GRAPHS.DEFAULT_SYSTEM_METAGRAPH);
        dataset.add(GRAPHS.DEFAULT_SYSTEM_METAGRAPH, org.openanzo.ontologies.openanzo.NamedGraph.canBeRemovedFromByProperty, Constants.NOONE_ROLE, GRAPHS.DEFAULT_SYSTEM_METAGRAPH);

        //Graph Dataset
        dataset.addNamedGraph(GRAPHS.GRAPHS_DATASET);
        dataset.addNamedGraph(GRAPHS.GRAPHS_DATASET_META);
        dataset.add(GRAPHS.GRAPHS_DATASET, RDF.TYPE, org.openanzo.ontologies.openanzo.Dataset.TYPE, GRAPHS.GRAPHS_DATASET);
        dataset.add(GRAPHS.GRAPHS_DATASET, org.openanzo.ontologies.openanzo.Dataset.namedGraphProperty, GRAPHS.DEFAULT_SYSTEMGRAPH, GRAPHS.GRAPHS_DATASET);
        dataset.add(GRAPHS.GRAPHS_DATASET, RDF.TYPE, org.openanzo.ontologies.openanzo.NamedGraph.TYPE, GRAPHS.GRAPHS_DATASET_META);
        dataset.add(GRAPHS.GRAPHS_DATASET, org.openanzo.ontologies.openanzo.NamedGraph.persistedProperty, Constants.valueFactory.createTypedLiteral(Boolean.TRUE), GRAPHS.GRAPHS_DATASET_META);
        dataset.add(GRAPHS.GRAPHS_DATASET, org.openanzo.ontologies.openanzo.NamedGraph.revisionedProperty, Constants.valueFactory.createTypedLiteral(Boolean.TRUE), GRAPHS.GRAPHS_DATASET_META);
        dataset.add(GRAPHS.GRAPHS_DATASET, org.openanzo.ontologies.openanzo.NamedGraph.canBeReadByProperty, Constants.EVERYONE_ROLE, GRAPHS.GRAPHS_DATASET_META);
        dataset.add(GRAPHS.GRAPHS_DATASET, org.openanzo.ontologies.openanzo.NamedGraph.canBeAddedToByProperty, Constants.EVERYONE_ROLE, GRAPHS.GRAPHS_DATASET_META);
        dataset.add(GRAPHS.GRAPHS_DATASET, org.openanzo.ontologies.openanzo.NamedGraph.canBeRemovedFromByProperty, Constants.EVERYONE_ROLE, GRAPHS.GRAPHS_DATASET_META);
        dataset.add(GRAPHS.GRAPHS_DATASET_META, org.openanzo.ontologies.openanzo.NamedGraph.canBeReadByProperty, Constants.NOONE_ROLE, GRAPHS.GRAPHS_DATASET_META);
        dataset.add(GRAPHS.GRAPHS_DATASET_META, org.openanzo.ontologies.openanzo.NamedGraph.canBeAddedToByProperty, Constants.NOONE_ROLE, GRAPHS.GRAPHS_DATASET_META);
        dataset.add(GRAPHS.GRAPHS_DATASET_META, org.openanzo.ontologies.openanzo.NamedGraph.canBeRemovedFromByProperty, Constants.NOONE_ROLE, GRAPHS.GRAPHS_DATASET_META);
        //MetadataGraph Dataset
        dataset.addNamedGraph(GRAPHS.METADATA_GRAPHS_DATASET);
        dataset.addNamedGraph(GRAPHS.METADATA_GRAPHS_DATASET_META);
        dataset.add(GRAPHS.METADATA_GRAPHS_DATASET, RDF.TYPE, org.openanzo.ontologies.openanzo.Dataset.TYPE, GRAPHS.METADATA_GRAPHS_DATASET);
        dataset.add(GRAPHS.METADATA_GRAPHS_DATASET, org.openanzo.ontologies.openanzo.Dataset.namedGraphProperty, GRAPHS.DEFAULT_SYSTEM_METAGRAPH, GRAPHS.METADATA_GRAPHS_DATASET);
        dataset.add(GRAPHS.METADATA_GRAPHS_DATASET, RDF.TYPE, org.openanzo.ontologies.openanzo.NamedGraph.TYPE, GRAPHS.METADATA_GRAPHS_DATASET_META);
        dataset.add(GRAPHS.METADATA_GRAPHS_DATASET, org.openanzo.ontologies.openanzo.NamedGraph.persistedProperty, Constants.valueFactory.createTypedLiteral(Boolean.TRUE), GRAPHS.METADATA_GRAPHS_DATASET_META);
        dataset.add(GRAPHS.METADATA_GRAPHS_DATASET, org.openanzo.ontologies.openanzo.NamedGraph.revisionedProperty, Constants.valueFactory.createTypedLiteral(Boolean.TRUE), GRAPHS.METADATA_GRAPHS_DATASET_META);
        dataset.add(GRAPHS.METADATA_GRAPHS_DATASET, org.openanzo.ontologies.openanzo.NamedGraph.canBeReadByProperty, Constants.EVERYONE_ROLE, GRAPHS.METADATA_GRAPHS_DATASET_META);
        dataset.add(GRAPHS.METADATA_GRAPHS_DATASET, org.openanzo.ontologies.openanzo.NamedGraph.canBeAddedToByProperty, Constants.EVERYONE_ROLE, GRAPHS.METADATA_GRAPHS_DATASET_META);
        dataset.add(GRAPHS.METADATA_GRAPHS_DATASET, org.openanzo.ontologies.openanzo.NamedGraph.canBeRemovedFromByProperty, Constants.NOONE_ROLE, GRAPHS.METADATA_GRAPHS_DATASET_META);
        dataset.add(GRAPHS.METADATA_GRAPHS_DATASET_META, org.openanzo.ontologies.openanzo.NamedGraph.canBeReadByProperty, Constants.NOONE_ROLE, GRAPHS.METADATA_GRAPHS_DATASET_META);
        dataset.add(GRAPHS.METADATA_GRAPHS_DATASET_META, org.openanzo.ontologies.openanzo.NamedGraph.canBeAddedToByProperty, Constants.NOONE_ROLE, GRAPHS.METADATA_GRAPHS_DATASET_META);
        dataset.add(GRAPHS.METADATA_GRAPHS_DATASET_META, org.openanzo.ontologies.openanzo.NamedGraph.canBeRemovedFromByProperty, Constants.NOONE_ROLE, GRAPHS.METADATA_GRAPHS_DATASET_META);

        datasource.getUpdateService().importStatements(context, dataset.getStatements(), Collections.<Statement> emptySet());
    }

    /**
     * Convert a string to an InputStream
     * 
     * @param location
     *            Location of data to convert to an InputStream
     * @return the location converted to an InputStream
     * @throws AnzoException
     */
    private InputStream getLocationAsStream(String location) throws AnzoException {
        InputStream initializationStream = null;
        if (location.startsWith(resourcePrefix)) {
            String resourceLocation = location.substring(resourcePrefix.length());
            initializationStream = this.getClass().getResourceAsStream(resourceLocation);
            if (initializationStream == null) {
                throw new AnzoException(ExceptionConstants.SERVER.INIT_FILE, resourceLocation);
            }
        } else {
            File initializationFile = new File(location);
            try {
                initializationStream = SmartEncodingInputStream.createSmartStream(new FileInputStream(initializationFile));
            } catch (FileNotFoundException e2) {
                throw new AnzoException(ExceptionConstants.SERVER.INIT_FILE, initializationFile.getAbsolutePath());
            }
        }
        return initializationStream;
    }

    /**
     * @return the nodeCentricTables
     */
    public String[] getNodeCentricTables() {
        return nodeCentricTables;
    }

    public String[] getRequiredTables() {
        return liveTables;
    }

    public String[][] getRequiredSequences() {
        return sequences;
    }

    public String[] getRequiredViews() {
        return views;
    }

    /**
     * Get if the server uses hard resets to clear database tables
     * 
     * @return true if the server uses hard resets to clear database tables
     */
    public boolean getUseHardReset() {
        return hardReset;
    }

    /**
     * Set whether or not the server uses hard resets to clear database tables
     * 
     * @param hardReset
     *            whether or not the server uses hard resets to clear database tables
     */
    public void setUseHardReset(boolean hardReset) {
        this.hardReset = hardReset;
    }

    @Override
    protected void resetChecks(IOperationContext context, Collection<Statement> checks) throws AnzoException {
    }
}
