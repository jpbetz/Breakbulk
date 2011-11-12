/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Nov 1, 2007
 * Revision:	$Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.services;

import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.openanzo.analysis.RequestAnalysis;
import org.openanzo.cache.ICacheProvider;
import org.openanzo.datasource.IReplicationService;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.utils.Collections;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.DynamicServiceStats;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.ITracker;
import org.openanzo.services.IUpdateResultListener;
import org.openanzo.services.Privilege;
import org.openanzo.services.serialization.INamedGraphUpdateHandler;
import org.openanzo.services.serialization.IReplicationHandler;
import org.openanzo.services.serialization.ReplicationHandler;
import org.openanzo.services.serialization.Writers;

/**
 * Base implementation of the IReplicationService
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public abstract class BaseReplicationService extends BaseDatasourceComponent implements IReplicationService {
    //private static final Logger log = LoggerFactory.getLogger(BaseReplicationService.class);

    private final ReplicationWithCacheStats stats = new ReplicationWithCacheStats("replicate");

    ReplicationCache                        cache = null;

    protected void initializeCache(ICacheProvider cacheProvider) {
        if (cacheProvider != null) {
            cache = new ReplicationCache(cacheProvider.<URI, NamedGraphRevision> openCache(getDatasource().getInstanceURI() + "_" + "ReplicationService", 1000, true));
        }
    }

    public void start() throws AnzoException {
        stats.setEnabled(true);
    }

    public void reset() throws AnzoException {
        stats.reset();
        if (cache != null)
            cache.reset();
    }

    public String getName() {
        return getDatasource().getName() + ",Service=ReplicationService";
    }

    public String getDescription() {
        return "Replication Service for " + getDatasource().getName();
    }

    public DynamicServiceStats getStatistics() {
        return stats;
    }

    /**
     * Get the cacheUpdateListener for this service
     * 
     * @return the cacheUpdateListener for this service
     */
    public IUpdateResultListener getCacheUpdateListener() {
        return cache;
    }

    public void replicate(IOperationContext context, String reader, String readerFormat, int batchSize, Writer output, String format) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        if (getLockProvider() != null)
            getLockProvider().readLock().lock();
        logEntry();
        try {
            Collection<Statement> trackers = ReadWriteUtils.readStatements(reader, RDFFormat.forMIMEType(readerFormat));
            INamedGraphUpdateHandler writer = Writers.getNamedGraphUpdatesWriter(output, format);
            ReplicationHandler handler = new ReplicationHandler(writer);
            replicate(context, trackers, handler, batchSize);
        } finally {
            if (stats.isEnabled()) {
                stats.use("replicate", (System.currentTimeMillis() - start));
            }
            if (getLockProvider() != null)
                getLockProvider().readLock().unlock();
            logExit();
        }
    }

    public void replicate(IOperationContext context, Collection<Statement> trackers, IReplicationHandler handler, int batchSize) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        if (getLockProvider() != null)
            getLockProvider().readLock().lock();
        logEntry();
        try {
            Collection<NamedGraphRevision> newGraphs = new ArrayList<NamedGraphRevision>();
            Collection<NamedGraphRevision> diffGraphs = new ArrayList<NamedGraphRevision>();
            for (Statement statement : trackers) {
                if (statement.getPredicate().equals(NamedGraph.revisionProperty)) {
                    Value rev = statement.getObject();
                    if (rev instanceof Literal) {
                        long revision = Long.parseLong(((Literal) rev).getLabel());

                        URI ngURI = (URI) statement.getSubject();
                        URI uuid = null;
                        if (ngURI.toString().startsWith(NAMESPACES.NAMEDGRAPH_REVISIONED_UUID_PREFIX)) {
                            uuid = ngURI;
                            try {
                                ngURI = getDatasource().getModelService().getUriForUUID(context, uuid);
                            } catch (AnzoException ae) {
                                if (ae.getErrorCode() != ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND) {
                                    throw ae;
                                }
                            }
                        } else if (ngURI.toString().startsWith(NAMESPACES.NAMEDGRAPH_NONREVISIONED_UUID_PREFIX)) {
                            uuid = ngURI;
                            try {
                                ngURI = getDatasource().getModelService().getUriForUUID(context, uuid);
                            } catch (AnzoException ae) {
                                if (ae.getErrorCode() != ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND) {
                                    throw ae;
                                }
                            }
                        } else {
                            try {
                                uuid = getDatasource().getModelService().getUUIDforUri(context, ngURI);
                            } catch (AnzoException ae) {
                                if (ae.getErrorCode() != ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND) {
                                    throw ae;
                                }
                            }
                        }
                        if (ngURI != null) {
                            URI metadataGraphUri = UriGenerator.generateMetadataGraphUri(ngURI);
                            try {
                                NamedGraphRevision ngr = new NamedGraphRevision(ngURI, metadataGraphUri, uuid, revision, revision == -1, context.getOperationPrincipal().isSysadmin() || Collections.memberOf(getDatasource().getAuthorizationService().getRolesForGraph(context, ngURI, Privilege.READ), context.getOperationPrincipal().getRoles()), context.getOperationPrincipal().isSysadmin()
                                        || Collections.memberOf(getDatasource().getAuthorizationService().getRolesForGraph(context, metadataGraphUri, Privilege.READ), context.getOperationPrincipal().getRoles()));
                                if (revision == -1) {
                                    newGraphs.add(ngr);
                                } else {
                                    diffGraphs.add(ngr);
                                }
                            } catch (AnzoException ae) {
                                if (ae.getErrorCode() != ExceptionConstants.DATASOURCE.NAMEDGRAPH.NOT_FOUND)
                                    throw ae;
                            }
                        }
                    }
                }
            }
            handler.start(0);
            for (Iterator<NamedGraphRevision> iter = newGraphs.iterator(); iter.hasNext();) {
                NamedGraphRevision ngr = iter.next();
                if (cache != null && ngr.uuid != null) {
                    if (cache.lookupCache(ngr.uuid, handler)) {
                        stats.cacheHit.increment();
                        iter.remove();
                        if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                            RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_CACHE_HIT, Boolean.TRUE);
                        }
                    } else {
                        stats.cacheMiss.increment();
                        if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                            RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_CACHE_HIT, Boolean.FALSE);
                        }
                    }
                }
            }
            if (newGraphs.size() > 0 || diffGraphs.size() > 0) {
                replicateInternal(context, newGraphs, diffGraphs, handler, cache);
            } else {
                handler.end();
            }
        } finally {
            if (stats.isEnabled()) {
                stats.use("replicate", (System.currentTimeMillis() - start));
            }
            if (getLockProvider() != null)
                getLockProvider().readLock().unlock();
            logExit();
        }
    }

    /**
     * Determine delta changes between marker and last transaction committed on server
     * 
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param trackers
     *            Set of existing {@link ITracker}s.
     * @param Trackers
     *            Set of {@link ITracker}s.
     * @param handler
     *            {@link IRepositoryHandler} call-back handler to which changes are written
     * @throws AnzoException
     */
    protected abstract void replicateInternal(IOperationContext context, Collection<NamedGraphRevision> newGraphs, Collection<NamedGraphRevision> diffGraphs, IReplicationHandler handler, ReplicationCache cache) throws AnzoException;

}
