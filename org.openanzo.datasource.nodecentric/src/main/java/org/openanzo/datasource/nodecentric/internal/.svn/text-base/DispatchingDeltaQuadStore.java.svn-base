/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jan 17, 2008
 * Revision:	$Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.internal;

import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.datatype.XMLGregorianCalendar;

import org.openanzo.datasource.IServerQuadStore;
import org.openanzo.datasource.IStoredNamedGraph;
import org.openanzo.datasource.StoredNamedGraph;
import org.openanzo.datasource.nodecentric.sql.GlitterRdbWrapper;
import org.openanzo.datasource.nodecentric.sql.LastTransactionTime;
import org.openanzo.datasource.nodecentric.sql.NamedGraphRdbWrapper;
import org.openanzo.datasource.update.NamedGraphType;
import org.openanzo.datasource.update.ServerUpdateTransaction;
import org.openanzo.datasource.update.UpdateChanges;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.CompoundAnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.jdbc.container.sql.BaseSQL;
import org.openanzo.jdbc.utils.ClosableIterator;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.MemTypedLiteral;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.datatype.TypeMaps;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.IUpdateResultListener;
import org.openanzo.services.IUpdates;
import org.openanzo.services.Privilege;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A QuadStore for the server that dispatches operations to different underlying stores, as well as storing changes within deltas
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
class DispatchingDeltaQuadStore implements IServerQuadStore {
    protected static final Logger                   log                 = LoggerFactory.getLogger(DispatchingDeltaQuadStore.class);

    private final URI                               instanceURI;

    private final HashMap<URI, NamedGraphType>      namedGraphToType    = new HashMap<URI, NamedGraphType>();

    private final Map<URI, IStoredNamedGraph>       storedNamedGraphs   = new HashMap<URI, IStoredNamedGraph>();

    private final NodeCentricServerQuadStore        revisionedQuadStore;

    private final NodeCentricServerQuadStore        nonRevisionedQuadStore;

    private final NodeCentricOperationContext       context;

    private Long                                    transactionId       = null;

    private Map<Value, Long>                        storedNodes         = null;

    private Map<URI, URI>                           resolvedUUIDS       = null;

    private Map<URI, Long>                          graphIds            = null;

    private Map<Long, URI>                          graphUris           = null;

    private final Collection<IUpdateResultListener> datasourceUpdateResultListeners;

    private final Map<URI, URI>                     removedNamedGraphs  = new HashMap<URI, URI>();

    private static final String                     STMTS_TMP           = "STMTS_TMP";

    private static final String                     STMT_ID_TMP         = "STMT_ID_TMP";

    private static final String                     NAMEDGRAPH_IDS_TEMP = "NAMEDGRAPH_IDS_TEMP";

    private boolean                                 direct;

    public DispatchingDeltaQuadStore(NodeCentricOperationContext context, URI instanceURI, Collection<IUpdateResultListener> datasourceUpdateResultListeners) {
        this.instanceURI = instanceURI;
        this.context = context;
        try {
            direct = (context.getAttribute("dispatchUpdate") != null) ? context.getAttribute("dispatchUpdate", Boolean.class) : false;
        } catch (AnzoException ae) {
            direct = false;
        }
        this.revisionedQuadStore = new NodeCentricServerQuadStore(context, true, direct);
        this.nonRevisionedQuadStore = new NodeCentricServerQuadStore(context, false, direct);
        this.datasourceUpdateResultListeners = datasourceUpdateResultListeners;
        namedGraphToType.put(GRAPHS.GRAPHS_DATASET, NamedGraphType.REVISIONED);
        namedGraphToType.put(GRAPHS.METADATA_GRAPHS_DATASET, NamedGraphType.REVISIONED);

    }

    public NodeCentricOperationContext getContext() {
        return context;
    }

    public URI getInstanceURI() {
        return instanceURI;
    }

    public void close() throws AnzoException {
        revisionedQuadStore.close();
        nonRevisionedQuadStore.close();
    }

    public void fireUpdatesToListeners(IUpdates updates) throws AnzoException {
        for (IUpdateResultListener listener : datasourceUpdateResultListeners) {
            listener.updateComplete(context, updates);
        }
    }

    public void abort() throws AnzoException {
        try {
            if (context.getConnection().isClosed()) {
                context.getDatasource().abort(context.getConnection(), false, true);
                context.getDatasource().rebindWriteContext(context);
            } else {
                context.getDatasource().abort(context.getConnection(), false, true);
            }

        } catch (SQLException sqle) {
            log.error(LogUtils.RDB_MARKER, "Error aborting connection", sqle);
            //new AnzoException(ExceptionConstants.ERROR_TAGS.DATASOURCE_ERROR | ExceptionConstants.ERROR_TAGS.RDB_ERROR, ExceptionConstants.RDB.FAILED_ROLLBACK_RDB_TRANSACTION, sqle);
        }
        context.getDatasource().begin(context.getConnection(), false, true);
        revisionedQuadStore.abort();
        nonRevisionedQuadStore.abort();
        context.getNodeLayout().abortReferencedIds(context.getConnection(), transactionId);
        NamedGraphRdbWrapper.purgelockedNamedGraph(context.getStatementProvider(), context.getConnection(), transactionId);
        LastTransactionTime.abortTransactions(context.getStatementProvider(), context.getConnection(), transactionId);
        try {
            BaseSQL.truncateTableWithSessionMayCommit(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix(), STMTS_TMP);
            BaseSQL.truncateTableWithSessionMayCommit(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix(), STMT_ID_TMP);
        } catch (RdbException sqle) {
            log.error(LogUtils.RDB_MARKER, "Error truncating tables", sqle);
        }
        context.getDatasource().commit(context.getConnection(), false, true);
        storedNamedGraphs.clear();
        graphIds.clear();
        graphUris.clear();
        resolvedUUIDS = null;
    }

    public void prepareForUpdate() throws AnzoException {
        context.getDatasource().begin(context.getConnection(), false, true);
        for (URI uri : namedGraphToType.keySet().toArray(new URI[0])) {
            IStoredNamedGraph graph = getStoredNamedGraph(uri);
            if (graph == null && !removedNamedGraphs.containsKey(uri)) {
                throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND, uri.toString());
            }
        }
        context.getDatasource().commit(context.getConnection(), false, true);
        HashSet<Value> values = new HashSet<Value>();
        if (context.getOperationPrincipal() != null && context.getOperationPrincipal().getUserURI() != null) {
            values.add(context.getOperationPrincipal().getUserURI());
        }
        for (Statement statement : revisionedQuadStore.getAdditions()) {
            values.add(statement.getNamedGraphUri());
            values.add(statement.getSubject());
            values.add(statement.getPredicate());
            values.add(statement.getObject());
        }
        for (Statement statement : nonRevisionedQuadStore.getAdditions()) {
            values.add(statement.getNamedGraphUri());
            values.add(statement.getSubject());
            values.add(statement.getPredicate());
            values.add(statement.getObject());
        }
        if (values.size() > 0) {
            storedNodes = new HashMap<Value, Long>();
            Value valsArray[] = values.toArray(new Value[0]);
            for (int i = 0; (i * NodeCentricDatasource.MAX_OPERATION_SIZE) <= valsArray.length; i++) {
                int offset = (i * NodeCentricDatasource.MAX_OPERATION_SIZE);
                Set<Value> subSet = null;
                if (valsArray.length > NodeCentricDatasource.MAX_OPERATION_SIZE) {
                    subSet = new LinkedHashSet<Value>();
                    for (int k = offset; k < Math.min(offset + NodeCentricDatasource.MAX_OPERATION_SIZE, valsArray.length); k++) {
                        subSet.add(valsArray[k]);
                    }
                } else {
                    subSet = values;
                }
                try {
                    context.getDatasource().begin(context.getConnection(), true, true);
                    storedNodes.putAll(context.getNodeLayout().resolveStoredNodes(subSet, true, context.getConnection(), transactionId));
                    context.getDatasource().commit(context.getConnection(), true, true);
                } catch (AnzoException ae) {
                    context.getDatasource().abort(context.getConnection(), true, true);
                    throw ae;
                }
            }
        }
    }

    public void commitTransaction(ServerUpdateTransaction currentTransactionUpdateResults, Collection<URI> namedGraphs) throws AnzoException {
        try {
            context.getDatasource().begin(context.getConnection(), true, true);
            LastTransactionTime.insertLastTransactionTime(context.getStatementProvider(), context.getConnection(), currentTransactionUpdateResults.getTransactionTimestamp());
            context.getDatasource().commit(context.getConnection(), true, true);

        } catch (RdbException sqle) {
            try {
                abort();
            } catch (AnzoException ae2) {
                throw new CompoundAnzoException(sqle, ae2);
            }
            throw sqle;
        }
        try {
            context.getDatasource().begin(context.getConnection(), true, true);
            context.getNodeLayout().commitReferencedIds(context.getConnection(), transactionId);
            context.getDatasource().commit(context.getConnection(), true, true);

            revisionedQuadStore.commit(currentTransactionUpdateResults);
            nonRevisionedQuadStore.commit(currentTransactionUpdateResults);

            context.getDatasource().begin(context.getConnection(), false, true);
            LastTransactionTime.updateTransaction(context.getStatementProvider(), context.getConnection(), currentTransactionUpdateResults.getTransactionTimestamp(), transactionId);
            try {
                BaseSQL.truncateTableWithSessionMayCommit(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix(), STMTS_TMP);
                BaseSQL.truncateTableWithSessionMayCommit(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix(), STMT_ID_TMP);
            } catch (RdbException sqle) {
                log.warn(LogUtils.RDB_MARKER, "Error truncating tables", sqle);
            }
            context.getDatasource().commit(context.getConnection(), false, true);
            storedNamedGraphs.clear();
            unlockNamedGraphs(namedGraphs);
            graphIds.clear();
            graphUris.clear();
            resolvedUUIDS = null;
        } catch (AnzoException sqle) {
            try {
                abort();
            } catch (AnzoException ae2) {
                throw new CompoundAnzoException(sqle, ae2);
            }
            throw sqle;
        }
    }

    private void unlockNamedGraphs(Collection<URI> namedGraphs) throws AnzoException {
        NamedGraphRdbWrapper.BatchUnlockNamedGraph stmt = new NamedGraphRdbWrapper.BatchUnlockNamedGraph(context.getConnection(), context.getStatementProvider());
        try {
            for (URI ngURI : namedGraphs) {
                Long id = graphIds.get(ngURI);
                if (id == null) {
                    id = context.getNodeLayout().fetchId(ngURI, context.getConnection());
                }
                if (id != null) {
                    stmt.addEntry(id, transactionId);
                }
            }
            context.getDatasource().begin(context.getConnection(), false, true);
            stmt.executeStatement();
            context.getDatasource().commit(context.getConnection(), false, true);
        } catch (RdbException sqle) {
            context.getDatasource().abort(context.getConnection(), false, true);
            throw new AnzoException(ExceptionConstants.DATASOURCE.FAILED_EXECUTE_BATCH, sqle);
        } finally {
            try {
                stmt.close();
            } catch (RdbException sqle) {
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.RDB_MARKER, "Error closing statement", sqle);
                }
            }
        }
    }

    public void addNewNamedGraph(URI namedGraphUri, URI metadataGraphUri, URI uuid, NamedGraphType type) throws AnzoException {
        namedGraphToType.put(namedGraphUri, type);
        namedGraphToType.put(metadataGraphUri, type);
        IStoredNamedGraph graph = new StoredNamedGraph(true, type, namedGraphUri, metadataGraphUri, uuid, Long.valueOf(0), null, null);
        storedNamedGraphs.put(namedGraphUri, graph);
        storedNamedGraphs.put(metadataGraphUri, graph);
        switch (type) {
        case REVISIONED:
            revisionedQuadStore.add(Constants.valueFactory.createStatement(namedGraphUri, org.openanzo.ontologies.openanzo.NamedGraph.revisionedProperty, MemTypedLiteral.create(Boolean.valueOf(true)), metadataGraphUri));
            revisionedQuadStore.add(Constants.valueFactory.createStatement(namedGraphUri, org.openanzo.ontologies.openanzo.NamedGraph.persistedProperty, MemTypedLiteral.create(Boolean.valueOf(true)), metadataGraphUri));
            break;
        case NON_REVISIONED_PERSISTED:
            nonRevisionedQuadStore.add(Constants.valueFactory.createStatement(namedGraphUri, org.openanzo.ontologies.openanzo.NamedGraph.revisionedProperty, MemTypedLiteral.create(Boolean.valueOf(false)), metadataGraphUri));
            nonRevisionedQuadStore.add(Constants.valueFactory.createStatement(namedGraphUri, org.openanzo.ontologies.openanzo.NamedGraph.persistedProperty, MemTypedLiteral.create(Boolean.valueOf(true)), metadataGraphUri));
            break;
        }
    }

    private void updateNamedGraphRevision(IStoredNamedGraph storedGraph, URI lastModifiedBy, long transactionStart) throws AnzoException {
        if (!storedGraph.isNewGraph()) {
            remove(Constants.valueFactory.createStatement(storedGraph.getURI(), org.openanzo.ontologies.openanzo.NamedGraph.revisionProperty, Constants.valueFactory.createTypedLiteral(storedGraph.getRevision()), storedGraph.getMetaURI()));
        }

        if (!storedGraph.isNewGraph()) {
            if (storedGraph.getLastModifiedBy() != null && !lastModifiedBy.equals(storedGraph.getLastModifiedBy())) {
                if (storedGraph.getLastModifiedBy() != null) {
                    remove(Constants.valueFactory.createStatement(storedGraph.getURI(), org.openanzo.ontologies.openanzo.NamedGraph.lastModifiedByUserProperty, storedGraph.getLastModifiedBy(), storedGraph.getMetaURI()));
                }
            }
            if (storedGraph.getLastModifiedTime() != null && transactionStart != storedGraph.getLastModifiedTime()) {
                if (storedGraph.getLastModifiedTime() != null) {
                    XMLGregorianCalendar cal = TypeMaps.getXMLCaledar(storedGraph.getLastModifiedTime());
                    remove(Constants.valueFactory.createStatement(storedGraph.getURI(), org.openanzo.ontologies.openanzo.NamedGraph.modifiedProperty, Constants.valueFactory.createTypedLiteral(cal), storedGraph.getMetaURI()));
                }
            }
        }
        add(Constants.valueFactory.createStatement(storedGraph.getURI(), org.openanzo.ontologies.openanzo.NamedGraph.revisionProperty, Constants.valueFactory.createTypedLiteral(storedGraph.getNewRevision()), storedGraph.getMetaURI()));
        add(Constants.valueFactory.createStatement(storedGraph.getURI(), org.openanzo.ontologies.openanzo.NamedGraph.lastModifiedByUserProperty, lastModifiedBy, storedGraph.getMetaURI()));
        storedGraph.setLastModifiedBy(lastModifiedBy);
        XMLGregorianCalendar cal = TypeMaps.getXMLCaledar(transactionStart);
        add(Constants.valueFactory.createStatement(storedGraph.getURI(), org.openanzo.ontologies.openanzo.NamedGraph.modifiedProperty, Constants.valueFactory.createTypedLiteral(cal), storedGraph.getMetaURI()));
        storedGraph.setLastModifiedTime(transactionStart);

        NamedGraphType type = storedGraph.getNamedGraphType();
        if (type == null) {
            throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND, storedGraph.getURI().toString());
        }
        switch (type) {
        case REVISIONED:
            revisionedQuadStore.updateNamedGraphRevision(storedGraph);
            break;
        case NON_REVISIONED_PERSISTED:
            nonRevisionedQuadStore.updateNamedGraphRevision(storedGraph);
            break;
        }
    }

    public void removeNamedGraph(URI namedGraphUri, URI uuid, long transactionStart) throws AnzoException {
        NamedGraphType type = getNamedGraphType(namedGraphUri);
        if (type == null) {
            throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND, namedGraphUri.toString());
        }
        IStoredNamedGraph graph = getStoredNamedGraph(namedGraphUri);
        switch (type) {
        case REVISIONED:
            revisionedQuadStore.removeNamedGraph(namedGraphUri, transactionStart, graph.getRevision());
            break;
        case NON_REVISIONED_PERSISTED:
            nonRevisionedQuadStore.removeNamedGraph(namedGraphUri, transactionStart, graph.getRevision());
            break;
        }
        removedNamedGraphs.put(namedGraphUri, uuid);
    }

    public void insertUpdates(UpdateChanges updateResults, long transactionStart, URI userURI) throws AnzoException {
        prepareForUpdate();
        //context.getDatasource().begin(context.getConnection(), false, true);
        HashSet<IStoredNamedGraph> modifiedGraphs = new HashSet<IStoredNamedGraph>();
        try {
            UpdateChanges revUpdates = revisionedQuadStore.update(storedNamedGraphs, storedNodes);
            UpdateChanges nonrevUpdates = nonRevisionedQuadStore.update(storedNamedGraphs, storedNodes);
            updateResults.addedStatements.addAll(revUpdates.addedStatements);
            updateResults.addedStatements.addAll(nonrevUpdates.addedStatements);
            updateResults.namedGraphs.addAll(nonrevUpdates.namedGraphs);
            updateResults.namedGraphs.addAll(revUpdates.namedGraphs);
            modifiedGraphs.addAll(revUpdates.namedGraphs);
            modifiedGraphs.addAll(nonrevUpdates.namedGraphs);
            updateResults.removedStatements.addAll(revUpdates.removedStatements);
            updateResults.removedStatements.addAll(nonrevUpdates.removedStatements);
            //     context.getDatasource().commit(context.getConnection(), false, true);
        } catch (AnzoException ae) {
            //context.getDatasource().abort(context.getConnection(), false, true);
            throw ae;
        }
        revisionedQuadStore.precommit();
        nonRevisionedQuadStore.precommit();
        for (IStoredNamedGraph storedGraph : modifiedGraphs) {
            updateNamedGraphRevision(storedGraph, userURI, transactionStart);
        }

        prepareForUpdate();
        //context.getDatasource().begin(context.getConnection(), false, true);
        revisionedQuadStore.executeNamedGraphsUpdates();
        nonRevisionedQuadStore.executeNamedGraphsUpdates();
        try {
            BaseSQL.truncateTableWithSessionMayCommit(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix(), NodeCentricServerQuadStore.REMOVE_GRAPHS_TMP);
        } catch (RdbException sqle) {
            log.warn(LogUtils.RDB_MARKER, "Error truncating tables", sqle);
        }
        try {

            UpdateChanges revUpdates = revisionedQuadStore.update(storedNamedGraphs, storedNodes);
            UpdateChanges nonrevUpdates = nonRevisionedQuadStore.update(storedNamedGraphs, storedNodes);
            updateResults.addedStatements.addAll(revUpdates.addedStatements);
            updateResults.addedStatements.addAll(nonrevUpdates.addedStatements);
            updateResults.namedGraphs.addAll(nonrevUpdates.namedGraphs);
            updateResults.namedGraphs.addAll(revUpdates.namedGraphs);
            modifiedGraphs.addAll(revUpdates.namedGraphs);
            modifiedGraphs.addAll(nonrevUpdates.namedGraphs);
            updateResults.removedStatements.addAll(revUpdates.removedStatements);
            updateResults.removedStatements.addAll(nonrevUpdates.removedStatements);
            //    context.getDatasource().commit(context.getConnection(), false, true);
        } catch (AnzoException ae) {
            //   context.getDatasource().abort(context.getConnection(), false, true);
            throw ae;
        }

        for (IStoredNamedGraph storedGraph : modifiedGraphs) {
            storedGraph.commitNewRevision();
        }
        updateResults.removedNamedGraphs.putAll(removedNamedGraphs);
    }

    public void add(Statement... statements) throws AnzoException {
        for (Statement stmt : statements) {
            NamedGraphType type = getNamedGraphType(stmt.getNamedGraphUri());
            if (type == null) {
                throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND, stmt.getNamedGraphUri().toString());
            }

            switch (type) {
            case REVISIONED:
                revisionedQuadStore.add(stmt);
                break;
            case NON_REVISIONED_PERSISTED:
                nonRevisionedQuadStore.add(stmt);
                break;
            }
        }
    }

    public void remove(Statement... statements) throws AnzoException {
        for (Statement stmt : statements) {
            NamedGraphType type = getNamedGraphType(stmt.getNamedGraphUri());
            if (type == null) {
                throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND, stmt.getNamedGraphUri().toString());
            }

            switch (type) {
            case REVISIONED:
                revisionedQuadStore.remove(stmt);
                break;
            case NON_REVISIONED_PERSISTED:
                nonRevisionedQuadStore.remove(stmt);
                break;
            }
        }
    }

    private NamedGraphType getNamedGraphType(URI namedGraphUri) throws AnzoException {
        NamedGraphType type = namedGraphToType.get(namedGraphUri);
        if (type == null) {
            if (revisionedQuadStore.containsNamedGraph(namedGraphUri)) {
                namedGraphToType.put(namedGraphUri, NamedGraphType.REVISIONED);
                type = NamedGraphType.REVISIONED;
                return type;
            } else if (nonRevisionedQuadStore.containsNamedGraph(namedGraphUri)) {
                namedGraphToType.put(namedGraphUri, NamedGraphType.NON_REVISIONED_PERSISTED);
                type = NamedGraphType.NON_REVISIONED_PERSISTED;
                return type;
            }
        }
        return type;
    }

    public boolean containsNamedGraph(URI namedGraphURI) throws AnzoException {
        if (UriGenerator.isMetadataGraphUri(namedGraphURI)) {
            namedGraphURI = UriGenerator.stripEncapsulatedURI(NAMESPACES.METADATAGRAPH_PREFIX, namedGraphURI);
        }
        if (resolvedUUIDS != null && resolvedUUIDS.containsKey(namedGraphURI)) {
            return true;
        }
        NamedGraphType type = getNamedGraphType(namedGraphURI);
        if (type == null) {
            return false;
        } else {
            return true;
        }
    }

    public URI getNamedGraphUUID(URI namedGraphURI) throws AnzoException {
        if (UriGenerator.isMetadataGraphUri(namedGraphURI)) {
            namedGraphURI = UriGenerator.stripEncapsulatedURI(NAMESPACES.METADATAGRAPH_PREFIX, namedGraphURI);
        }
        if (resolvedUUIDS != null && resolvedUUIDS.containsKey(namedGraphURI)) {
            return resolvedUUIDS.get(namedGraphURI);
        }
        NamedGraphType type = getNamedGraphType(namedGraphURI);
        if (type == null)
            return null;
        switch (type) {
        case REVISIONED:
            return revisionedQuadStore.getNamedGraphUUID(namedGraphURI);
        case NON_REVISIONED_PERSISTED:
            return nonRevisionedQuadStore.getNamedGraphUUID(namedGraphURI);
        }
        return null;
    }

    public void beginTransaction(Long transactionId, URI transactionURI, Collection<URI> namedGraphs, Collection<Statement> transactionContext) throws AnzoException {
        //  SelectCurrentTimestampResult timestampResult = LastTransactionTime.selectCurrentTimestamp(context.getStatementProvider(), context.getConnection());
        this.transactionId = transactionId;
        Long tid = context.getNodeLayout().store(transactionURI, context.getConnection(), transactionId);
        String cntx = null;
        if (transactionContext != null && transactionContext.size() > 0) {
            StringWriter tc = new StringWriter();
            ReadWriteUtils.writeStatements(transactionContext, tc, RDFFormat.JSON);
            cntx = tc.toString();
        }
        LastTransactionTime.insertTransaction(context.getStatementProvider(), context.getConnection(), transactionId, context.getDatasource().getInstanceId(), tid, cntx);
        revisionedQuadStore.beginTransaction(this.transactionId);
        nonRevisionedQuadStore.beginTransaction(this.transactionId);
        graphIds = new HashMap<URI, Long>();
        graphUris = new HashMap<Long, URI>();
        resolvedUUIDS = new HashMap<URI, URI>();
        boolean ok = lockNamedgraphs(namedGraphs);
        int retryCount = 600;
        while (!ok && retryCount-- > 0) {
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "Could not lock the necessary namedGraphs");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                throw new AnzoException(ExceptionConstants.CORE.INTERRUPTED);
            }
            ok = lockNamedgraphs(namedGraphs);
        }
        if (!ok) {
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.RDB_MARKER, "Could not get a lock on the NamedGraphs. Aborting");
            }
            throw new AnzoException(ExceptionConstants.DATASOURCE.NO_LOCK_NAMEDGRAPHS, Arrays.toString(namedGraphs.toArray(new URI[0])));
        }
        if (graphIds.size() > 25) {
            for (Map.Entry<URI, Long> entry : graphIds.entrySet()) {
                graphUris.put(entry.getValue(), entry.getKey());
            }
            GlitterRdbWrapper.BatchInsertGraphSysAdmin batch = null;
            try {
                context.getDatasource().begin(context.getConnection(), false, true);
                batch = new GlitterRdbWrapper.BatchInsertGraphSysAdmin(context.getConnection(), context.getStatementProvider(), context.getConfiguration().getSessionPrefix(), NAMEDGRAPH_IDS_TEMP);
                for (Long id : graphIds.values()) {
                    batch.addEntry(id);
                }
                batch.executeStatement();
                Set<Long> ids = new HashSet<Long>();
                HashMap<Long, Long> uuids = new HashMap<Long, Long>();

                ClosableIterator<NamedGraphRdbWrapper.SelectNamedGraphRevisionedBatchResult> iterator = NamedGraphRdbWrapper.selectNamedGraphRevisionedBatch(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix(), NAMEDGRAPH_IDS_TEMP);
                ArrayList<NamedGraphRdbWrapper.SelectNamedGraphRevisionedBatchResult> revisionedResults = new ArrayList<NamedGraphRdbWrapper.SelectNamedGraphRevisionedBatchResult>();
                for (NamedGraphRdbWrapper.SelectNamedGraphRevisionedBatchResult result : iterator) {
                    revisionedResults.add(result);
                    uuids.put(result.getUuid(), result.getId());
                    ids.add(result.getUuid());
                    ids.add(result.getId());
                    ids.add(result.getMetaId());
                    ids.add(result.getLastModifiedBy());
                }
                iterator.close();
                ClosableIterator<NamedGraphRdbWrapper.SelectNamedGraphNonRevisionedBatchResult> iterator2 = NamedGraphRdbWrapper.selectNamedGraphNonRevisionedBatch(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix(), NAMEDGRAPH_IDS_TEMP);
                ArrayList<NamedGraphRdbWrapper.SelectNamedGraphNonRevisionedBatchResult> nonrevisionedResults = new ArrayList<NamedGraphRdbWrapper.SelectNamedGraphNonRevisionedBatchResult>();
                for (NamedGraphRdbWrapper.SelectNamedGraphNonRevisionedBatchResult result : iterator2) {
                    nonrevisionedResults.add(result);
                    uuids.put(result.getUuid(), result.getId());
                    ids.add(result.getUuid());
                    ids.add(result.getId());
                    ids.add(result.getMetaId());
                    ids.add(result.getLastModifiedBy());
                }
                iterator2.close();
                Map<Long, URI> resolved = context.getNodeLayout().getNodeURILayout().resolveStoredIds(ids, context.getConnection());
                for (Map.Entry<Long, Long> entry : uuids.entrySet()) {
                    URI graphUri = graphUris.get(entry.getKey());
                    resolvedUUIDS.put(graphUri, resolved.get(entry.getValue()));
                }

                for (NamedGraphRdbWrapper.SelectNamedGraphRevisionedBatchResult result : revisionedResults) {
                    URI namedGraphUri = resolved.get(result.getId());
                    URI metaUri = resolved.get(result.getMetaId());
                    URI uuidURI = resolved.get(result.getUuid());
                    Long revision = result.getRevision();
                    Long hStart = result.getHstart();
                    URI userURI = resolved.get(result.getLastModifiedBy());
                    storedNamedGraphs.put(namedGraphUri, new StoredNamedGraph(false, NamedGraphType.REVISIONED, namedGraphUri, metaUri, uuidURI, revision, userURI, hStart));
                }

                for (NamedGraphRdbWrapper.SelectNamedGraphNonRevisionedBatchResult result : nonrevisionedResults) {
                    URI namedGraphUri = resolved.get(result.getId());
                    URI metaUri = resolved.get(result.getMetaId());
                    URI uuidURI = resolved.get(result.getUuid());
                    Long revision = result.getRevision();
                    Long hStart = result.getHstart();
                    URI userURI = resolved.get(result.getLastModifiedBy());
                    storedNamedGraphs.put(namedGraphUri, new StoredNamedGraph(false, NamedGraphType.NON_REVISIONED_PERSISTED, namedGraphUri, metaUri, uuidURI, revision, userURI, hStart));
                }
                context.getDatasource().commit(context.getConnection(), false, true);
            } catch (RdbException sqle) {
                context.getDatasource().abort(context.getConnection(), false, true);
            } finally {
                try {
                    if (batch != null) {
                        batch.close();
                    }
                } catch (RdbException sqle) {
                    if (log.isDebugEnabled()) {
                        log.debug(LogUtils.RDB_MARKER, "error closing batch statement", sqle);
                    }
                }
                try {
                    BaseSQL.truncateTableWithSessionMayCommit(context.getStatementProvider(), context.getConnection(), context.getConfiguration().getSessionPrefix(), STMTS_TMP);
                } catch (RdbException sqle) {
                    if (log.isDebugEnabled()) {
                        log.debug(LogUtils.RDB_MARKER, "error truncating table", sqle);
                    }
                }
            }
        }
    }

    private boolean lockNamedgraphs(Collection<URI> namedGraphs) throws AnzoException {
        NamedGraphRdbWrapper.BatchLockNamedGraph stmt = new NamedGraphRdbWrapper.BatchLockNamedGraph(context.getConnection(), context.getStatementProvider());
        try {
            context.getDatasource().begin(context.getConnection(), true, true);
            if (namedGraphs.size() > 100) {
                graphIds.putAll(context.getNodeLayout().getNodeURILayout().resolveStoredNodes(namedGraphs, true, context.getConnection(), transactionId));
            } else {
                for (URI uri : namedGraphs) {
                    graphIds.put(uri, context.getNodeLayout().store(uri, context.getConnection(), transactionId));
                }
            }
            for (Long id : graphIds.values()) {
                stmt.addEntry(id, transactionId);
            }
            stmt.executeStatement();
            context.getDatasource().commit(context.getConnection(), true, true);
            return true;
        } catch (RdbException sqle) {
            context.getDatasource().abort(context.getConnection(), true, true);
            return false;
        } finally {
            try {
                stmt.close();
            } catch (RdbException sqle) {
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.RDB_MARKER, "error closing statement", sqle);
                }
            }
        }

    }

    private IStoredNamedGraph getStoredNamedGraph(URI namedGraphUri) throws AnzoException {
        IStoredNamedGraph graph = storedNamedGraphs.get(namedGraphUri);
        if (graph == null) {
            if (UriGenerator.isMetadataGraphUri(namedGraphUri)) {
                namedGraphUri = UriGenerator.stripEncapsulatedURI(NAMESPACES.METADATAGRAPH_PREFIX, namedGraphUri);
            }
            NamedGraphType type = getNamedGraphType(namedGraphUri);
            if (type == null)
                return null;
            switch (type) {
            case REVISIONED:
                graph = revisionedQuadStore.getStoredNamedGraph(namedGraphUri);
                break;
            case NON_REVISIONED_PERSISTED:
                graph = nonRevisionedQuadStore.getStoredNamedGraph(namedGraphUri);
                break;
            }
            if (graph != null) {
                storedNamedGraphs.put(namedGraphUri, graph);
                storedNamedGraphs.put(graph.getMetaURI(), graph);
            }
        }
        return graph;
    }

    public void addAcl(URI namedGraphUri, URI Role, org.openanzo.services.Privilege privilege) throws AnzoException {
    }

    public void removeAcl(URI namedGraphUri, URI Role, Privilege privilege) throws AnzoException {
    }
}
