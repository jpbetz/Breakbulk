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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.collections15.multimap.MultiHashMap;
import org.openanzo.cache.ICacheProvider;
import org.openanzo.datasource.IDatasource;
import org.openanzo.datasource.nodecentric.operations.Find;
import org.openanzo.datasource.nodecentric.sql.NamedGraphRdbWrapper;
import org.openanzo.datasource.nodecentric.sql.ServerRdbWrapper;
import org.openanzo.datasource.nodecentric.sql.StatementRdbWrapper;
import org.openanzo.datasource.nodecentric.sql.NamedGraphRdbWrapper.SelectNamedGraphRevisionResult;
import org.openanzo.datasource.nodecentric.sql.StatementRdbWrapper.ResolveDatasetNRResult;
import org.openanzo.datasource.nodecentric.sql.StatementRdbWrapper.ResolveDatasetResult;
import org.openanzo.datasource.services.BaseModelService;
import org.openanzo.datasource.update.NamedGraphType;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.dataset.DefaultQueryDataset;
import org.openanzo.glitter.dataset.QueryDataset;
import org.openanzo.jdbc.utils.ClosableIterator;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.ontologies.openanzo.Dataset;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IRDFHandler;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.serialization.IValueSetHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NodeCentric implementation of the IModelService
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
class NodeCentricModelService extends BaseModelService {
    private static final Logger         log                          = LoggerFactory.getLogger(NodeCentricModelService.class);

    private final NodeCentricDatasource datasource;

    private Long                        defaultGraphPredicateId      = null;

    private Long                        namedGraphPredicateId        = null;

    private Long                        defaultNamedGraphPredicateId = null;

    public NodeCentricModelService(NodeCentricDatasource datasource, ICacheProvider cacheProvider) {
        super();
        this.datasource = datasource;
        initializeCache(cacheProvider);
    }

    public IDatasource getDatasource() {
        return datasource;
    }

    @Override
    public void start() throws AnzoException {
        datasource.setDatasourceInstanceURI(getServerUriInternal());
    }

    @Override
    public void reset() throws AnzoException {
        super.reset();
        defaultGraphPredicateId = null;
        namedGraphPredicateId = null;
        defaultNamedGraphPredicateId = null;
    }

    private boolean containsNamedGraphInternal(NodeCentricOperationContext context, URI namedGraphUri) throws AnzoException {
        Long id = context.getNodeLayout().fetchId(namedGraphUri, context.getConnection());
        if (id != null) {
            NamedGraphType type = datasource.containsNamedGraph(context, namedGraphUri, UriGenerator.isMetadataGraphUri(namedGraphUri));
            if (type != null) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    @Override
    protected boolean containsNamedGraphInternal(IOperationContext context, URI namedGraphUri) throws AnzoException {
        if (namedGraphUri == null) {
            throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER, SerializationConstants.namedGraphUri);
        }
        NodeCentricOperationContext connectionContext = null;
        boolean isMine = false;
        try {
            if (context instanceof NodeCentricOperationContext) {
                connectionContext = (NodeCentricOperationContext) context;
            } else {
                connectionContext = datasource.getQueryContext(context);
                isMine = true;
            }
            return containsNamedGraphInternal(connectionContext, namedGraphUri);
        } finally {
            if (isMine && connectionContext != null) {
                datasource.returnQueryContext(connectionContext);
            }
        }
    }

    @Override
    protected Collection<Statement> getNamedGraphRevisionInternal(IOperationContext context, URI namedGraphUri, long revision) throws AnzoException {
        if (namedGraphUri == null) {
            throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER, SerializationConstants.namedGraphUri);
        }
        NodeCentricOperationContext connectionContext = null;
        boolean isMine = false;
        try {
            if (context instanceof NodeCentricOperationContext) {
                connectionContext = (NodeCentricOperationContext) context;
            } else {
                connectionContext = datasource.getQueryContext(context);
                isMine = true;
            }
            Long gid = connectionContext.getNodeLayout().fetchId(namedGraphUri, connectionContext.getConnection());
            if (gid == null) {
                return null;
            }
            Long uuidId = null;
            URI uuid = null;
            NamedGraphType type = null;
            if (revision == -1) {
                type = datasource.containsNamedGraph(connectionContext, namedGraphUri, UriGenerator.isMetadataGraphUri(namedGraphUri));
                if (type == null) {
                    return null;
                } else if (!(type.equals(NamedGraphType.REVISIONED) || type.equals(NamedGraphType.NON_REVISIONED_PERSISTED))) {
                    throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.NON_REVISIONED_GRAPH, Long.toString(revision), namedGraphUri.toString());
                }
                if (type.equals(NamedGraphType.NON_REVISIONED_PERSISTED) && revision != -1) {
                    throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.NON_REVISIONED_GRAPH, Long.toString(revision), namedGraphUri.toString());
                }
            } else {
                try {
                    uuid = getUUIDforUri(connectionContext, namedGraphUri);
                    if (uuid != null) {
                        uuidId = connectionContext.getNodeLayout().fetchId(uuid, connectionContext.getConnection());
                    }
                } catch (AnzoException ae) {
                    if (log.isDebugEnabled()) {
                        log.debug(LogUtils.RDB_MARKER, "Error getting UUID for graph", ae);
                    }
                }
                if (uuidId == null) {
                    return null;
                }
                try {
                    Long exists = NamedGraphRdbWrapper.containsNamedGraphAtRevision(connectionContext.getStatementProvider(), connectionContext.getConnection(), uuidId, revision);
                    if (exists == null) {
                        throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.REVISION_NOT_FOUND, Long.toString(revision), namedGraphUri.toString());
                    }
                    type = datasource.containsNamedGraph(connectionContext, namedGraphUri, UriGenerator.isMetadataGraphUri(namedGraphUri));
                } catch (RdbException sqle) {
                    throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.REVISION_NOT_FOUND, sqle, Long.toString(revision), namedGraphUri.toString());
                }
            }

            try {
                URI metadataURI = UriGenerator.generateMetadataGraphUri(namedGraphUri);
                if (revision == -1) {
                    return Find.findQuads(connectionContext, (type.equals(NamedGraphType.NON_REVISIONED_PERSISTED)) ? NodeCentricDatasource.STATEMENTS_NR : NodeCentricDatasource.STATEMENTS, type.equals(NamedGraphType.REVISIONED), true, null, null, null, new URI[] { namedGraphUri, metadataURI });
                } else {
                    ArrayList<Statement> stmts = new ArrayList<Statement>();
                    if (uuidId == null) {
                        try {
                            uuid = getUUIDforUri(connectionContext, namedGraphUri);
                            if (uuid != null) {
                                uuidId = connectionContext.getNodeLayout().fetchId(uuid, connectionContext.getConnection());
                            }
                        } catch (AnzoException ae) {
                            if (log.isDebugEnabled()) {
                                log.debug(LogUtils.RDB_MARKER, "Error getting uuid for metagraph", ae);
                            }
                        }
                        if (uuidId == null) {
                            return null;
                        }
                    }
                    ClosableIterator<SelectNamedGraphRevisionResult> result = NamedGraphRdbWrapper.selectNamedGraphRevision(connectionContext.getStatementProvider(), connectionContext.getConnection(), uuidId, revision, revision);
                    while (result.hasNext()) {
                        SelectNamedGraphRevisionResult entry = result.next();
                        Long ngId = entry.getNamedgraphid();
                        Long sId = entry.getSubject();
                        Long pId = entry.getPredicate();
                        Long oId = entry.getObject();
                        URI graphURI = (URI) connectionContext.getNodeLayout().fetchValue(ngId, connectionContext.getConnection());
                        Resource subject = (Resource) connectionContext.getNodeLayout().fetchValue(sId, connectionContext.getConnection());
                        URI predicate = (URI) connectionContext.getNodeLayout().fetchValue(pId, connectionContext.getConnection());
                        Value object = connectionContext.getNodeLayout().fetchValue(oId, connectionContext.getConnection());
                        stmts.add(Constants.valueFactory.createStatement(subject, predicate, object, graphURI));
                    }
                    return stmts;
                }
            } catch (RdbException sqle) {
                throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.REVISION_NOT_FOUND, sqle, namedGraphUri.toString(), Long.toString(revision));
            }
        } finally {
            if (connectionContext != null && isMine) {
                datasource.returnQueryContext(connectionContext);
            }
        }
    }

    @Override
    protected QueryDataset resolveNamedDatasetInternal(IOperationContext context, URI namedDatasetUri) throws AnzoException {
        long total = System.currentTimeMillis();
        DefaultQueryDataset uriSet = new DefaultQueryDataset(new TreeSet<URI>(), new TreeSet<URI>(), new TreeSet<URI>());
        NodeCentricOperationContext connectionContext = null;
        boolean isMine = false;
        try {
            if (context instanceof NodeCentricOperationContext) {
                connectionContext = (NodeCentricOperationContext) context;
            } else {
                connectionContext = datasource.getQueryContext(context);
                isMine = true;
            }

            Long id = connectionContext.getNodeLayout().fetchId(namedDatasetUri, connectionContext.getConnection());
            if (id == null) {
                return uriSet;
            }
            namedGraphPredicateId = connectionContext.getNodeLayout().store(Dataset.namedGraphProperty, connectionContext.getConnection(), 0);
            defaultGraphPredicateId = connectionContext.getNodeLayout().store(Dataset.defaultGraphProperty, connectionContext.getConnection(), 0);
            defaultNamedGraphPredicateId = connectionContext.getNodeLayout().store(Dataset.defaultNamedGraphProperty, connectionContext.getConnection(), 0);
            boolean includeMetadataGraphs = false;
            if (!namedDatasetUri.equals(Constants.GRAPHS.GRAPHS_DATASET) && !namedDatasetUri.equals(Constants.GRAPHS.METADATA_GRAPHS_DATASET)) {
                Collection<Statement> stmts = find(connectionContext, namedDatasetUri, Dataset.includeMetadataGraphsProperty, null, new URI[] { namedDatasetUri });
                if (stmts != null && stmts.size() > 0) {
                    Statement stmt = stmts.iterator().next();
                    if (stmt.getObject() instanceof TypedLiteral) {
                        Object obj = ((TypedLiteral) stmt.getObject()).getNativeValue();
                        if (obj instanceof Boolean) {
                            includeMetadataGraphs = ((Boolean) obj).booleanValue();
                        }
                    }
                }
            }
            HashSet<Long> ids = new HashSet<Long>();
            MultiHashMap<Long, Long> sets = new MultiHashMap<Long, Long>();
            boolean doNr = true;
            long start = System.currentTimeMillis();
            for (ResolveDatasetResult result : StatementRdbWrapper.resolveDataset(connectionContext.getStatementProvider(), connectionContext.getConnection(), id, id, namedGraphPredicateId.toString(), defaultGraphPredicateId.toString(), defaultNamedGraphPredicateId.toString())) {
                doNr = false;
                ids.add(result.getObject());
                sets.put(result.getPredicateId(), result.getObject());
            }
            if (log.isInfoEnabled()) {
                log.info(LogUtils.RDB_MARKER, "[RESOLVE NAMED DATASET] {}:{}", Integer.toString(sets.size()), Long.toString(System.currentTimeMillis() - start));
            }
            if (doNr) {
                start = System.currentTimeMillis();
                for (ResolveDatasetNRResult result : StatementRdbWrapper.resolveDatasetNR(connectionContext.getStatementProvider(), connectionContext.getConnection(), id, id, namedGraphPredicateId.toString(), defaultGraphPredicateId.toString(), defaultNamedGraphPredicateId.toString())) {
                    doNr = false;
                    ids.add(result.getObject());
                    sets.put(result.getPredicateId(), result.getObject());
                }
                if (log.isInfoEnabled()) {
                    log.info(LogUtils.RDB_MARKER, "[RESOLVE NAMEDNR DATASET] {}:{}", Integer.toString(sets.size()), Long.toString(System.currentTimeMillis() - start));
                }
            }
            Map<Long, Value> values = connectionContext.getNodeLayout().resolveStoredIds(ids, connectionContext.getConnection());
            Collection<Long> ngIds = sets.get(namedGraphPredicateId);
            if (ngIds != null) {
                for (Long gid : ngIds) {
                    Value uri = values.get(gid);
                    if (uri != null) {
                        if (uri instanceof URI) {
                            uriSet.namedGraphs.add((URI) uri);
                            if (includeMetadataGraphs && !UriGenerator.isMetadataGraphUri((URI) uri)) {
                                uriSet.namedGraphs.add(UriGenerator.generateMetadataGraphUri((URI) uri));
                            }
                        }
                    }
                }
            }
            ngIds = sets.get(defaultGraphPredicateId);
            if (ngIds != null) {
                for (Long gid : ngIds) {
                    Value uri = values.get(gid);
                    if (uri != null) {
                        if (uri instanceof URI) {
                            uriSet.defaultGraphs.add((URI) uri);
                            if (includeMetadataGraphs && !UriGenerator.isMetadataGraphUri((URI) uri)) {
                                uriSet.defaultGraphs.add(UriGenerator.generateMetadataGraphUri((URI) uri));
                            }
                        }
                    }
                }
            }
            ngIds = sets.get(defaultNamedGraphPredicateId);
            if (ngIds != null) {
                for (Long gid : ngIds) {
                    Value uri = values.get(gid);
                    if (uri != null) {
                        if (uri instanceof URI) {
                            uriSet.namedGraphs.add((URI) uri);
                            uriSet.defaultGraphs.add((URI) uri);
                            if (includeMetadataGraphs && !uri.toString().startsWith(Constants.NAMESPACES.METADATAGRAPH_PREFIX)) {
                                URI muri = UriGenerator.generateMetadataGraphUri((URI) uri);
                                uriSet.defaultGraphs.add(muri);
                                uriSet.namedGraphs.add(muri);
                            }

                        }
                    }
                }
            }
            if (log.isInfoEnabled()) {
                log.info(LogUtils.RDB_MARKER, "[RESOLVE NAMED DATASET TOTAL] {}/{}:{}", new Object[] { Integer.toString(uriSet.defaultGraphs.size()), Integer.toString(uriSet.namedGraphs.size()), Long.toString(System.currentTimeMillis() - total) });
            }
            return uriSet;
        } finally {
            if (connectionContext != null && isMine) {
                datasource.returnQueryContext(connectionContext);
            }
        }
    }

    @Override
    protected long getSizeInternal(IOperationContext context, URI namedGraphUri) throws AnzoException {
        if (namedGraphUri == null) {
            throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER, SerializationConstants.namedGraphUri);
        }
        NodeCentricOperationContext connectionContext = null;
        boolean isMine = false;
        try {
            if (context instanceof NodeCentricOperationContext) {
                connectionContext = (NodeCentricOperationContext) context;
            } else {
                connectionContext = datasource.getQueryContext(context);
                isMine = true;
                datasource.begin(connectionContext.getConnection(), false, true);
            }
            Long id = connectionContext.getNodeLayout().fetchId(namedGraphUri, connectionContext.getConnection());
            if (id == null) {
                throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND, namedGraphUri.toString());
            }
            try {
                Long size = null;
                NamedGraphType type = datasource.containsNamedGraph(connectionContext, namedGraphUri, UriGenerator.isMetadataGraphUri(namedGraphUri));
                if (type == null) {
                    throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND, namedGraphUri.toString());
                }
                switch (type) {
                case REVISIONED:
                    size = NamedGraphRdbWrapper.selectNamedGraphSize(connectionContext.getStatementProvider(), connectionContext.getConnection(), id.longValue());
                    break;
                case NON_REVISIONED_PERSISTED:
                    size = NamedGraphRdbWrapper.selectNamedGraphSizeNonRevisioned(connectionContext.getStatementProvider(), connectionContext.getConnection(), id.longValue());
                    break;
                default:
                    throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.NAMED_GRAPH_TYPE_INCORRECT, namedGraphUri.toString());
                }

                return (size != null) ? size.longValue() : 0;
            } catch (RdbException sqle) {
                throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.GET_SIZE, sqle, namedGraphUri.toString());
            }
        } finally {
            if (isMine && connectionContext != null) {
                datasource.commit(connectionContext.getConnection(), false, true);
                datasource.returnQueryContext(connectionContext);
            }
        }
    }

    @Override
    protected URI getUriForUUIDInternal(IOperationContext context, URI namedGraphUUIDUri) throws AnzoException {
        if (namedGraphUUIDUri == null) {
            throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER, SerializationConstants.namedGraphUri);
        }
        NodeCentricOperationContext connectionContext = null;
        boolean isMine = false;
        try {
            if (context instanceof NodeCentricOperationContext) {
                connectionContext = (NodeCentricOperationContext) context;
            } else {
                connectionContext = datasource.getQueryContext(context);
                isMine = true;
            }
            Long id = connectionContext.getNodeLayout().fetchId(namedGraphUUIDUri, connectionContext.getConnection());
            if (id == null) {
                throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND, namedGraphUUIDUri.toString());
            }
            try {
                Long ngId = null;
                if (namedGraphUUIDUri.toString().startsWith(NAMESPACES.NAMEDGRAPH_REVISIONED_UUID_PREFIX)) {
                    ngId = NamedGraphRdbWrapper.getNamedGraphForUUID(connectionContext.getStatementProvider(), connectionContext.getConnection(), id);
                } else if (namedGraphUUIDUri.toString().startsWith(NAMESPACES.NAMEDGRAPH_NONREVISIONED_UUID_PREFIX)) {
                    ngId = NamedGraphRdbWrapper.getNamedGraphForUUIDNR(connectionContext.getStatementProvider(), connectionContext.getConnection(), id);
                } else {
                    throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND, namedGraphUUIDUri.toString());
                }
                if (ngId != null) {
                    URI ngURI = (URI) connectionContext.getNodeLayout().fetchValue(ngId, connectionContext.getConnection());
                    if (ngURI == null) {
                        throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND, namedGraphUUIDUri.toString());
                    }
                    return ngURI;
                } else {
                    return null;
                }
            } catch (RdbException sqle) {
                throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.GET_URI, sqle, namedGraphUUIDUri.toString());
            }
        } finally {
            if (connectionContext != null && isMine) {
                datasource.returnQueryContext(connectionContext);
            }
        }
    }

    @Override
    protected URI getUUIDforUriInternal(IOperationContext context, URI namedGraphUri) throws AnzoException {
        if (namedGraphUri == null) {
            throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER, SerializationConstants.namedGraphUri);
        }
        NodeCentricOperationContext connectionContext = null;
        boolean isMine = false;
        try {
            if (context instanceof NodeCentricOperationContext) {
                connectionContext = (NodeCentricOperationContext) context;
            } else {
                connectionContext = datasource.getQueryContext(context);
                isMine = true;
            }
            Long id = connectionContext.getNodeLayout().fetchId(namedGraphUri, connectionContext.getConnection());
            if (id == null) {
                return null;
            }
            try {
                Long ngId = null;
                ngId = NamedGraphRdbWrapper.getUUIDForNamedGraph(connectionContext.getStatementProvider(), connectionContext.getConnection(), id);
                if (ngId == null) {
                    ngId = NamedGraphRdbWrapper.getUUIDForNamedGraph(connectionContext.getStatementProvider(), connectionContext.getConnection(), id);
                }
                if (ngId != null) {
                    URI ngUUID = (URI) connectionContext.getNodeLayout().fetchValue(ngId, connectionContext.getConnection());
                    if (ngUUID == null) {
                        throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND, namedGraphUri.toString());
                    }
                    return ngUUID;
                } else {
                    return null;
                }
            } catch (RdbException sqle) {
                throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.GET_URI, sqle, namedGraphUri.toString());
            }
        } finally {
            if (connectionContext != null && isMine) {
                datasource.returnQueryContext(connectionContext);
            }
        }
    }

    @Override
    protected void getStoredNamedGraphsInternal(IOperationContext context, IValueSetHandler<String> valueSetHandler) throws AnzoException {
        NodeCentricOperationContext connectionContext = null;
        boolean isMine = false;
        try {
            if (context instanceof NodeCentricOperationContext) {
                connectionContext = (NodeCentricOperationContext) context;
            } else {
                connectionContext = datasource.getQueryContext(context);
                isMine = true;
            }
            try {
                valueSetHandler.start();
                if (context.getOperationPrincipal().isSysadmin()) {
                    Set<String> ngURIs = getAllStoredNamedGraphsInternal(connectionContext);
                    for (String ngURI : ngURIs) {
                        valueSetHandler.handleValue(ngURI);
                    }
                } else {
                    Collection<Statement> results = Find.findQuads(connectionContext, NodeCentricDatasource.STATEMENTS, true, true, new Resource[] { GRAPHS.METADATA_GRAPHS_DATASET }, new URI[] { Dataset.namedGraphProperty }, null, new URI[] { GRAPHS.METADATA_GRAPHS_DATASET });
                    ArrayList<URI> namedGraphs = new ArrayList<URI>();
                    for (Statement stmts : results) {
                        namedGraphs.add((URI) stmts.getObject());
                    }

                    Collection<Statement> rolesResult = Find.findQuads(connectionContext, NodeCentricDatasource.STATEMENTS, true, true, null, new URI[] { NamedGraph.canBeReadByProperty }, context.getOperationPrincipal().getRoles().toArray(new URI[0]), namedGraphs.toArray(new URI[0]));
                    HashSet<URI> namedGraphsResults = new HashSet<URI>();
                    for (Statement stmt : rolesResult) {
                        URI ngURI = (URI) stmt.getSubject();
                        if (!UriGenerator.isMetadataGraphUri(ngURI)) {
                            namedGraphsResults.add(ngURI);
                        }
                    }
                    for (URI uri : namedGraphsResults) {
                        valueSetHandler.handleValue(uri.toString());
                    }
                }
                valueSetHandler.end();
            } catch (IOException ioe) {
                throw new AnzoException(ExceptionConstants.SERVER.GET_STORED_GRAPHS_ERROR, ioe);
            }
        } finally {
            if (isMine && connectionContext != null) {
                datasource.returnQueryContext(connectionContext);
            }
        }
    }

    private Set<String> getAllStoredNamedGraphsInternal(NodeCentricOperationContext connectionContext) throws AnzoException {
        Set<String> graphs = new HashSet<String>();
        try {
            ClosableIterator<Long> ids = NamedGraphRdbWrapper.getAllRevisionedNamedGraphs(connectionContext.getStatementProvider(), connectionContext.getConnection());
            for (Long id : ids) {
                graphs.add(connectionContext.getNodeLayout().fetchValue(id, connectionContext.getConnection()).toString());
            }
            ids = NamedGraphRdbWrapper.getAllNonRevisionedNamedGraphs(connectionContext.getStatementProvider(), connectionContext.getConnection());
            for (Long id : ids) {
                graphs.add(connectionContext.getNodeLayout().fetchValue(id, connectionContext.getConnection()).toString());
            }
        } catch (RdbException sqle) {
            throw new AnzoException(ExceptionConstants.SERVER.GET_STORED_GRAPHS_ERROR, sqle);
        }
        return graphs;
    }

    public Long getServerIdInternal() throws AnzoException {
        Long serverId = null;
        NodeCentricOperationContext connectionContext = null;
        try {
            connectionContext = datasource.getQueryContext(null);
            serverId = ServerRdbWrapper.getServerId(connectionContext.getStatementProvider(), connectionContext.getConnection());

        } catch (RdbException sqle) {
            throw new AnzoRuntimeException(ExceptionConstants.SERVER.NO_SERVER_CONFIG, sqle);
        } finally {
            if (connectionContext != null) {
                datasource.returnQueryContext(connectionContext);
            }
        }
        return serverId;
    }

    public URI getServerUriInternal() throws AnzoException {
        URI serverURI = null;
        NodeCentricOperationContext connectionContext = null;
        try {
            connectionContext = datasource.getQueryContext(null);
            Long serverId = ServerRdbWrapper.getServerId(connectionContext.getStatementProvider(), connectionContext.getConnection());
            if (serverId != null) {
                serverURI = (URI) connectionContext.getNodeLayout().fetchValue(serverId, connectionContext.getConnection());
            }
        } catch (RdbException sqle) {
            throw new AnzoRuntimeException(ExceptionConstants.SERVER.NO_SERVER_CONFIG, sqle);
        } finally {
            if (connectionContext != null) {
                datasource.returnQueryContext(connectionContext);
            }
        }
        return serverURI;
    }

    @Override
    protected void findStatementsInternal(IOperationContext context, Resource subject, URI predicate, Value object, URI[] namedGraphURI, IRDFHandler handler) throws AnzoException {
        NodeCentricOperationContext connectionContext = null;
        boolean isMine = false;
        try {
            if (context instanceof NodeCentricOperationContext) {
                connectionContext = (NodeCentricOperationContext) context;
            } else {
                connectionContext = datasource.getQueryContext(context);
                isMine = true;
                if (namedGraphURI != null && namedGraphURI.length >= 100) {
                    datasource.begin(connectionContext.getConnection(), false, true);
                }
            }
            Collection<Statement> statements = find(connectionContext, subject, predicate, object, namedGraphURI);
            if (statements != null) {
                handler.startRDF();
                for (Statement stmt : statements) {
                    handler.handleStatement(stmt);
                }
                handler.endRDF();
            }
        } catch (RdbException sqle) {
            throw new AnzoException(ExceptionConstants.DATASOURCE.FIND_STATEMENTS, sqle);
        } finally {
            if (connectionContext != null && isMine) {
                if (namedGraphURI != null && namedGraphURI.length >= 100) {
                    datasource.commit(connectionContext.getConnection(), false, true);
                }
                datasource.returnQueryContext(connectionContext);
            }
        }
    }

    protected Collection<Statement> find(NodeCentricOperationContext connectionContext, Resource subject, URI predicate, Value object, URI[] namedGraphURI) throws AnzoException {
        try {
            Collection<Statement> statements = null;
            if (namedGraphURI != null && namedGraphURI.length == 1) {
                NamedGraphType type = datasource.containsNamedGraph(connectionContext, namedGraphURI[0], UriGenerator.isMetadataGraphUri(namedGraphURI[0]));
                if (type == null) {
                    return java.util.Collections.<Statement> emptySet();
                }
                switch (type) {
                case REVISIONED:
                    statements = Find.findQuads(connectionContext, NodeCentricDatasource.STATEMENTS, true, false, new Resource[] { subject }, new URI[] { predicate }, new Value[] { object }, namedGraphURI);
                    break;
                case NON_REVISIONED_PERSISTED:
                    statements = Find.findQuads(connectionContext, NodeCentricDatasource.STATEMENTS_NR, false, false, new Resource[] { subject }, new URI[] { predicate }, new Value[] { object }, namedGraphURI);
                    break;
                default:
                    throw new AnzoException(ExceptionConstants.DATASOURCE.NAMEDGRAPH.NAMED_GRAPH_TYPE_INCORRECT, Arrays.toString(namedGraphURI));
                }
            } else {
                statements = new ArrayList<Statement>();
                statements.addAll(Find.findQuads(connectionContext, NodeCentricDatasource.STATEMENTS, true, false, new Resource[] { subject }, new URI[] { predicate }, new Value[] { object }, namedGraphURI));
                statements.addAll(Find.findQuads(connectionContext, NodeCentricDatasource.STATEMENTS_NR, false, false, new Resource[] { subject }, new URI[] { predicate }, new Value[] { object }, namedGraphURI));
            }

            return statements;
        } catch (RdbException sqle) {
            throw new AnzoException(ExceptionConstants.DATASOURCE.FIND_STATEMENTS, sqle);
        }
    }
}
