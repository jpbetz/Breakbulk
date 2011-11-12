/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/graph/Attic/FindInferred.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Feb 8, 2007
 * Revision:	$Id: FindInferred.java 229 2007-08-07 15:22:00Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.container.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.exception.UnknownGraphException;
import org.openanzo.jdbc.container.RDBQuadStore;
import org.openanzo.jdbc.container.query.ExtraSQL.SelectQuadResult;
import org.openanzo.jdbc.container.sql.BaseSQL;
import org.openanzo.jdbc.container.sql.GlitterSQL;
import org.openanzo.jdbc.container.sql.GlitterSQL.SelectAllResult;
import org.openanzo.jdbc.container.sql.GlitterSQL.SelectOResult;
import org.openanzo.jdbc.container.sql.GlitterSQL.SelectPResult;
import org.openanzo.jdbc.container.sql.GlitterSQL.SelectSResult;
import org.openanzo.jdbc.layout.Quad;
import org.openanzo.jdbc.query.SQLQueryConstants;
import org.openanzo.jdbc.utils.ClosableIterator;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.utils.StatementUtils;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.rdf.vocabulary.RDF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Set of find operations for both regular finds, as well as find with inferred results.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class FindInferred {

    private static final Logger log = LoggerFactory.getLogger(FindInferred.class);

    /**
     * Find all statements in container that match the provided parameters including inferred statements
     * 
     * @param container
     *            source of data
     * @param subj
     *            Subject resource to match, or wildcard if null
     * @param prop
     *            Predicate uri to match, or wildcard if null
     * @param obj
     *            Object value to match, or wildcard if null
     * @param contexts
     *            Context values to match, or wildcard if null
     * @param ontology
     *            URI of ontology that contains inferred property and object definitions
     * @return Iterable set of quads containing results of find operation
     * @throws AnzoException
     *             if there was an error finding statements
     */
    public static Iterable<Quad> findStatementsInferred(RDBQuadStore container, Resource subj, URI prop, Value obj, Resource[] contexts, Resource ontology) throws AnzoException {
        //try {
        Long namedGraphId = null;
        String graphTable = null;
        int metadataGraph = -1;
        if (contexts != null && contexts.length == 1) {
            Resource context = (Resource) StatementUtils.convertUriToAny(contexts[0]);
            if (context != null) {
                namedGraphId = container.getNodeLayout().fetchId(context, container.getConnection());
                if (namedGraphId == null) {
                    return Collections.<Quad> emptySet(); // required node is not even in db
                }
                metadataGraph = context.toString().startsWith(NAMESPACES.METADATAGRAPH_PREFIX) ? 1 : 0;
            }
        } else {
            HashSet<Value> set = new HashSet<Value>();
            boolean includeAllNamedGraphs = false, includeAllMetadataGraphs = false;
            Map<Value, Long> graphIds = null;
            if (contexts != null && contexts.length > 0) {
                for (Resource context : contexts) {
                    if (context.equals(GRAPHS.ALL_GRAPHS))
                        includeAllNamedGraphs = includeAllMetadataGraphs = true;
                    else if (context.equals(GRAPHS.ALL_NAMEDGRAPHS))
                        includeAllNamedGraphs = true;
                    else if (context.equals(GRAPHS.ALL_METADATAGRAPHS))
                        includeAllMetadataGraphs = true;
                    else
                        set.add(context);
                }
                if (set.size() > 0) {
                    graphIds = container.getNodeLayout().resolveStoredNodes(set, false, container.getConnection(), -1);
                    if (graphIds.size() < set.size()) {
                        set.removeAll(graphIds.keySet());
                        log.debug(LogUtils.DATASOURCE_MARKER, "findStatementsInferred", new UnknownGraphException(StringUtils.join(set.iterator(), ", ")));
                        if (graphIds.size() == 0 && !includeAllNamedGraphs && !includeAllMetadataGraphs) {
                            return Collections.<Quad> emptyList();// required node is not even in db
                        }
                    }
                    if (graphIds.size() > 0) {
                        graphTable = SQLQueryConstants.defaultGraphsTempTable;
                        //container.populateValidGraphs(graphIds, includeAllNamedGraphs, includeAllMetadataGraphs, graphTable);
                        //container.populateValidGraphs(graphIds, includeAllNamedGraphs, graphTable);
                    }
                } else if (includeAllNamedGraphs || includeAllMetadataGraphs) {
                    metadataGraph = includeAllNamedGraphs ? (includeAllMetadataGraphs ? -1 : 0) : 1;
                }
            }
        }
        return findStatementsInferred(container, subj, prop, obj, namedGraphId, metadataGraph, graphTable, ontology);
        /*} catch (SQLException e) {
            throw new AnzoException(ExceptionConstants.ERROR_TAGS.CORE_ERROR | ExceptionConstants.ERROR_TAGS.RDB_ERROR, ExceptionConstants.CLIENT.FAILED_CONTAINER_FIND_STATEMENTS, e);
        }*/
    }

    /**
     * Find statements in container that match pattern. Include inferred statements. <li>If graphTable is not null, queries are joined against temporary table
     * containing valid graphs for this query</li> <li>Else if the namedGraphId is not null, then queries go against only statements that have the specific
     * namedGraphId</li> <li>Finally, if both the graphTable and namedGraphId are null, query either queries all graphs if metadataGraph==-1, namedGraphs if
     * metadataGraph==0, or metadataGraphs if metadataGraph==1
     * 
     * @param container
     *            source of data
     * @param subj
     *            Subject resource to match, or wildcard if null
     * @param prop
     *            Predicate uri to match, or wildcard if null
     * @param obj
     *            Object value to match, or wildcard if null
     * @param namedGraphId
     *            id of namedGraph to query
     * @param metadataGraph
     *            if both the graphTable and namedGraphId are null, query either queries all graphs if metadataGraph==-1, namedGraphs if metadataGraph==0, or
     *            metadataGraphs if metadataGraph==1
     * @param graphTable
     *            temporary table containing valid graphs for this query *
     * @param ontology
     *            URI of ontology that contains inferred property and object definitionss
     * @return Iterable set of quads containing results of find operation
     * @throws AnzoException
     *             if there was an error finding statements
     */
    public static Iterable<Quad> findStatementsInferred(RDBQuadStore container, Resource subj, URI prop, Value obj, Long namedGraphId, int metadataGraph, String graphTable, Resource ontology) throws AnzoException {
        try {
            ArrayList<Quad> list = new ArrayList<Quad>();
            HashSet<Long> ids = new HashSet<Long>();
            try {
                subj = (Resource) StatementUtils.convertUriToAny(subj);
                prop = (URI) StatementUtils.convertUriToAny(prop);
                obj = StatementUtils.convertUriToAny(obj);
                boolean isRdfType = false;
                int type = 0;
                Long subjId = null;
                Long predId = null;
                Long objId = null;
                Long ontId = null;
                if (subj != null) {
                    subjId = container.getNodeLayout().fetchId(subj, container.getConnection());
                    if (subjId == null) {
                        return Collections.<Quad> emptyList(); // required node is not even in db
                    }
                } else {
                    //	subjId = null;//Long.valueOf(-1);
                }
                if (prop != null) {
                    isRdfType = prop.equals(RDF.TYPE);
                    predId = container.getNodeLayout().fetchId(prop, container.getConnection());
                    if (predId == null) {
                        return Collections.<Quad> emptyList(); // required node is not even in db
                    }
                } else {
                    //	predId = null;//Long.valueOf(-1);
                }
                if (obj != null) {
                    objId = container.getNodeLayout().fetchId(obj, container.getConnection());
                    if (objId == null) {
                        return Collections.<Quad> emptyList(); // required node is not even in db
                    }
                } else {
                    //objId = null;// Long.valueOf(-1);
                }
                //FIXME:SHOULD A null ontology throw an exception
                if (ontology != null) {
                    ontId = container.getNodeLayout().fetchId(ontology, container.getConnection());
                    if (ontId == null) {
                        return Collections.<Quad> emptyList(); // required node is not even in db
                    }
                } else {
                    ontId = Long.valueOf(-1);
                }
                GlitterSQL.insertQueryStatement(container.getStmtProvider(), container.getConnection(), namedGraphId, subjId, predId, objId, container.getConfiguration().getSessionPrefix());
                if (namedGraphId != null || graphTable != null)
                    type |= 1;
                if (subjId != null)
                    type |= 2;
                if (predId != null)
                    type |= 4;
                if (objId != null)
                    type |= 8;
                switch (type) {
                case 0: {
                    int count = GlitterSQL.insert0(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    if (count > 0) {
                        ClosableIterator<SelectSResult> results = GlitterSQL.selectS(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName(), container.getConfiguration().getUniqueTempName("STMT_TMP", 1), container.getConfiguration().getUniqueTempName("STMT_TMP", 2), container.getConfiguration()
                                .getUniqueTempName("STMT_TMP", 3));
                        try {
                            parseResultsS(container, results, list, ids);
                        } finally {
                            results.close();
                        }
                    }
                }
                    break;
                case 1: {
                    int count = 0;
                    if (graphTable == null) {
                        count = GlitterSQL.insert1(container.getStmtProvider(), container.getConnection(), namedGraphId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    } else {
                        count = GlitterSQL.insert1M(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable);
                    }
                    if (count > 0) {
                        ClosableIterator<SelectSResult> results = GlitterSQL.selectS(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName(), container.getConfiguration().getUniqueTempName("STMT_TMP", 1), container.getConfiguration().getUniqueTempName("STMT_TMP", 2), container.getConfiguration()
                                .getUniqueTempName("STMT_TMP", 3));
                        try {
                            parseResultsS(container, results, list, ids);
                        } finally {
                            results.close();
                        }
                    }
                }
                    break;
                case 2: {
                    int count = 0;
                    if (metadataGraph == -1) {
                        count = GlitterSQL.insert2(container.getStmtProvider(), container.getConnection(), subjId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    } else {
                        count = GlitterSQL.insert2META(container.getStmtProvider(), container.getConnection(), metadataGraph, subjId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    }
                    if (count > 0) {
                        ClosableIterator<SelectSResult> results = GlitterSQL.selectS(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName(), container.getConfiguration().getUniqueTempName("STMT_TMP", 1), container.getConfiguration().getUniqueTempName("STMT_TMP", 2), container.getConfiguration()
                                .getUniqueTempName("STMT_TMP", 3));
                        try {
                            parseResultsS(container, results, list, ids);
                        } finally {
                            results.close();
                        }
                    }
                }
                    break;
                case 3: {
                    int count = 0;
                    if (graphTable == null) {
                        count = GlitterSQL.insert3(container.getStmtProvider(), container.getConnection(), namedGraphId, subjId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    } else {
                        count = GlitterSQL.insert3M(container.getStmtProvider(), container.getConnection(), subjId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable);
                    }
                    if (count > 0) {
                        if (container.getConfiguration().getSupportsWithClause()) {
                            GlitterSQL.preparePropInfer_0(container.getStmtProvider(), container.getConnection(), ontId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                        } else {
                            int counter = GlitterSQL.preparePropInfer_0_NO_WITH_0(container.getStmtProvider(), container.getConnection(), ontId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                            while (counter > 0) {
                                // oCount += counter;
                                counter = GlitterSQL.preparePropInfer_0_NO_WITH_1(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 2), container.getContainerName());
                            }
                        }
                        ClosableIterator<SelectSResult> results = GlitterSQL.selectS(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName(), container.getConfiguration().getUniqueTempName("STMT_TMP", 1), container.getConfiguration().getUniqueTempName("STMT_TMP", 2), container.getConfiguration()
                                .getUniqueTempName("STMT_TMP", 3));
                        try {
                            parseResultsS(container, results, list, ids);
                        } finally {
                            results.close();
                        }
                    }
                }
                    break;
                case 4: {
                    int count = 0;
                    if (metadataGraph == -1) {
                        count = GlitterSQL.insert4(container.getStmtProvider(), container.getConnection(), predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    } else {
                        count = GlitterSQL.insert4META(container.getStmtProvider(), container.getConnection(), metadataGraph, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    }
                    int oCount = 0;
                    if (container.getConfiguration().getSupportsWithClause()) {
                        oCount = GlitterSQL.preparePropInferP_0(container.getStmtProvider(), container.getConnection(), ontId, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                    } else {
                        int counter = GlitterSQL.preparePropInferP_0_NO_WITH_0(container.getStmtProvider(), container.getConnection(), ontId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                        while (counter > 0) {
                            oCount += counter;
                            counter = GlitterSQL.preparePropInferP_0_NO_WITH_1(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 2), container.getContainerName());
                        }
                    }
                    if (metadataGraph == -1) {
                        count += GlitterSQL.insertFindP(container.getStmtProvider(), container.getConnection(), predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                    } else {
                        count += GlitterSQL.insertFindPMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                    }
                    if (count > 0) {
                        int iCount = 0;
                        if (container.getConfiguration().getSupportsWithClause()) {
                            iCount = GlitterSQL.preparePropInferP_0(container.getStmtProvider(), container.getConnection(), ontId, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                        } else {
                            int counter = GlitterSQL.preparePropInferP_0_NO_WITH_0(container.getStmtProvider(), container.getConnection(), ontId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                            while (counter > 0) {
                                iCount += counter;
                                counter = GlitterSQL.preparePropInferP_0_NO_WITH_1(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 2), container.getContainerName());
                            }
                        }
                        if (iCount > 0) {
                            count += GlitterSQL.insertFindP(container.getStmtProvider(), container.getConnection(), predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                        }
                        ClosableIterator<SelectPResult> results = GlitterSQL.selectP(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("STMT_TMP", 1), container.getContainerName());
                        try {
                            parseResultsP(container, results, list, ids);
                        } finally {
                            results.close();
                        }
                    }
                }
                    break;
                case 5: {
                    int count = 0;
                    if (graphTable == null) {
                        count = GlitterSQL.insert5(container.getStmtProvider(), container.getConnection(), namedGraphId, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    } else {
                        if (metadataGraph == -1) {
                            count = GlitterSQL.insert5M(container.getStmtProvider(), container.getConnection(), predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable);
                        } else {
                            count = GlitterSQL.insert5MMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable);
                        }
                    }
                    int oCount = 0;
                    if (container.getConfiguration().getSupportsWithClause()) {
                        oCount = GlitterSQL.preparePropInferP_0(container.getStmtProvider(), container.getConnection(), ontId, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                    } else {
                        int counter = GlitterSQL.preparePropInferP_0_NO_WITH_0(container.getStmtProvider(), container.getConnection(), ontId, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                        while (counter > 0) {
                            oCount += counter;
                            counter = GlitterSQL.preparePropInferP_0_NO_WITH_1(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 2), container.getContainerName());
                        }
                    }
                    if (oCount > 0) {
                        if (graphTable != null) {
                            if (metadataGraph == -1) {
                                count += GlitterSQL.insertFindMP(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName(), graphTable);
                            } else {
                                count += GlitterSQL.insertFindMPMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName(), graphTable);
                            }
                        } else {
                            count += GlitterSQL.insertFindNP(container.getStmtProvider(), container.getConnection(), namedGraphId, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                        }
                    }
                    if (count > 0) {
                        ClosableIterator<SelectPResult> results = GlitterSQL.selectP(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("STMT_TMP", 1), container.getContainerName());
                        try {
                            parseResultsP(container, results, list, ids);
                        } finally {
                            results.close();
                        }
                    }
                }
                    break;
                case 6: {
                    int count = 0;
                    if (metadataGraph == -1) {
                        count = GlitterSQL.insert6(container.getStmtProvider(), container.getConnection(), subjId, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    } else {
                        count = GlitterSQL.insert6META(container.getStmtProvider(), container.getConnection(), metadataGraph, subjId, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    }
                    if (metadataGraph == -1) {
                        count += GlitterSQL.insertFindSP(container.getStmtProvider(), container.getConnection(), subjId, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                    } else {
                        count += GlitterSQL.insertFindSPMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, subjId, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                    }
                    if (count > 0) {
                        ClosableIterator<SelectPResult> results = GlitterSQL.selectP(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("STMT_TMP", 1), container.getContainerName());
                        try {
                            parseResultsP(container, results, list, ids);
                        } finally {
                            results.close();
                        }
                    }
                }
                    break;
                case 7: {
                    int count = 0;
                    if (graphTable == null) {
                        count = GlitterSQL.insert7(container.getStmtProvider(), container.getConnection(), namedGraphId, subjId, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    } else {
                        if (metadataGraph == -1) {
                            count = GlitterSQL.insert7M(container.getStmtProvider(), container.getConnection(), subjId, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable);
                        } else {
                            count = GlitterSQL.insert7MMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, subjId, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable);
                        }
                    }
                    if (graphTable != null) {
                        count += GlitterSQL.insertFindMSP(container.getStmtProvider(), container.getConnection(), subjId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName(), graphTable);
                    } else {
                        count += GlitterSQL.insertFindNSP(container.getStmtProvider(), container.getConnection(), namedGraphId, subjId, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                    }
                    if (count > 0) {
                        ClosableIterator<SelectPResult> results = GlitterSQL.selectP(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("STMT_TMP", 1), container.getContainerName());
                        try {
                            parseResultsP(container, results, list, ids);
                        } finally {
                            results.close();
                        }
                    }
                }
                    break;
                case 8: {
                    int count = 0;
                    if (metadataGraph == -1) {
                        count = GlitterSQL.insert8(container.getStmtProvider(), container.getConnection(), objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    } else {
                        count = GlitterSQL.insert8META(container.getStmtProvider(), container.getConnection(), metadataGraph, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    }
                    int oCount = 0;
                    if (container.getConfiguration().getSupportsWithClause()) {
                        if (metadataGraph == -1) {
                            oCount = GlitterSQL.prepareObjectInferO_0(container.getStmtProvider(), container.getConnection(), ontId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                            //oCount += GlitterSQL.prepareObjectInferO_1(container.getPreparedStatementProvider(),container.getConnection(), ontId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                        } else {
                            oCount = GlitterSQL.prepareObjectInferO_0(container.getStmtProvider(), container.getConnection(), ontId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                            //oCount += GlitterSQL.prepareObjectInferO_1(container.getPreparedStatementProvider(),container.getConnection(), ontId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                        }
                        GlitterSQL.preparePropInfer_0(container.getStmtProvider(), container.getConnection(), ontId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                    } else {
                        int counter = GlitterSQL.prepareObjectInferO_0_NO_WITH_0(container.getStmtProvider(), container.getConnection(), ontId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                        while (counter > 0) {
                            oCount += counter;
                            counter = GlitterSQL.prepareObjectInferO_0_NO_WITH_1(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 2), container.getContainerName());
                        }
                        //								counter = GlitterSQL.prepareObjectInferO_1_NO_WITH_0(container.getPreparedStatementProvider(),container.getConnection(), ontId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                        //								while (counter > 0) {
                        //									oCount += counter;
                        //									counter = GlitterSQL.prepareObjectInferO_1_NO_WITH_1(container.getPreparedStatementProvider(),container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 2), container.getContainerName());
                        //								}
                        //								
                        counter = GlitterSQL.preparePropInfer_0_NO_WITH_0(container.getStmtProvider(), container.getConnection(), ontId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                        while (counter > 0) {
                            oCount += counter;
                            counter = GlitterSQL.preparePropInfer_0_NO_WITH_1(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 2), container.getContainerName());
                        }
                    }
                    if (oCount > 0) {
                        if (metadataGraph == -1) {
                            count += GlitterSQL.insertFindO(container.getStmtProvider(), container.getConnection(), objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                        } else {
                            count += GlitterSQL.insertFindOMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                        }
                    }
                    if (count > 0) {
                        ClosableIterator<SelectOResult> results = GlitterSQL.selectO(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("STMT_TMP", 1), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                        try {
                            parseResultsO(container, results, list, ids);
                        } finally {
                            results.close();
                        }
                    } else {
                        ClosableIterator<SelectAllResult> results = GlitterSQL.selectAll(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0));
                        try {
                            parseResults(container, results, list, ids);
                        } finally {
                            results.close();
                        }
                    }
                }
                    break;
                case 9: {
                    int count = 0;
                    if (graphTable == null) {
                        count = GlitterSQL.insert9(container.getStmtProvider(), container.getConnection(), namedGraphId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    } else {
                        if (metadataGraph == -1) {
                            count = GlitterSQL.insert9M(container.getStmtProvider(), container.getConnection(), objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable);
                        } else {
                            count = GlitterSQL.insert9MMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable);
                        }
                    }
                    int oCount = 0;
                    if (container.getConfiguration().getSupportsWithClause()) {
                        oCount = GlitterSQL.prepareObjectInferO_0(container.getStmtProvider(), container.getConnection(), ontId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                        //oCount += GlitterSQL.prepareObjectInferO_1(container.getPreparedStatementProvider(),container.getConnection(), ontId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                        GlitterSQL.preparePropInfer_0(container.getStmtProvider(), container.getConnection(), ontId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                    } else {
                        int counter = GlitterSQL.prepareObjectInferO_0_NO_WITH_0(container.getStmtProvider(), container.getConnection(), ontId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                        while (counter > 0) {
                            oCount += counter;
                            counter = GlitterSQL.prepareObjectInferO_0_NO_WITH_1(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 2), container.getContainerName());
                        }
                        /*counter = GlitterSQL.prepareObjectInferO_1_NO_WITH_0(container.getPreparedStatementProvider(),container.getConnection(), ontId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                         while (counter > 0) {
                         oCount += counter;
                         counter = GlitterSQL.prepareObjectInferO_1_NO_WITH_1(container.getPreparedStatementProvider(),container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 2), container.getContainerName());
                         }
                         */
                        counter = GlitterSQL.preparePropInfer_0_NO_WITH_0(container.getStmtProvider(), container.getConnection(), ontId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                        while (counter > 0) {
                            //oCount += counter;
                            counter = GlitterSQL.preparePropInfer_0_NO_WITH_1(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 2), container.getContainerName());
                        }
                    }
                    if (oCount > 0) {
                        if (graphTable != null) {
                            if (metadataGraph == -1) {
                                count += GlitterSQL.insertFindMO(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName(), graphTable);
                            } else {
                                count += GlitterSQL.insertFindMOMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName(), graphTable);
                            }
                        } else {
                            count += GlitterSQL.insertFindNO(container.getStmtProvider(), container.getConnection(), namedGraphId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                        }
                    }
                    if (count > 0) {
                        ClosableIterator<SelectOResult> results = GlitterSQL.selectO(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("STMT_TMP", 1), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                        try {
                            parseResultsO(container, results, list, ids);
                        } finally {
                            results.close();
                        }
                    }
                }
                    break;
                case 10: {
                    int count = 0;
                    if (metadataGraph == -1) {
                        count = GlitterSQL.insert10(container.getStmtProvider(), container.getConnection(), subjId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    } else {
                        GlitterSQL.insert10META(container.getStmtProvider(), container.getConnection(), metadataGraph, subjId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    }
                    int oCount = 0;
                    if (container.getConfiguration().getSupportsWithClause()) {
                        oCount = GlitterSQL.prepareObjectInferO_0(container.getStmtProvider(), container.getConnection(), ontId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                        //oCount += GlitterSQL.prepareObjectInferO_1(container.getPreparedStatementProvider(),container.getConnection(), ontId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                        GlitterSQL.preparePropInfer_0(container.getStmtProvider(), container.getConnection(), ontId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                    } else {
                        int counter = GlitterSQL.prepareObjectInferO_0_NO_WITH_0(container.getStmtProvider(), container.getConnection(), ontId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                        while (counter > 0) {
                            oCount += counter;
                            counter = GlitterSQL.prepareObjectInferO_0_NO_WITH_1(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 2), container.getContainerName());
                        }
                        /*counter = GlitterSQL.prepareObjectInferO_1_NO_WITH_0(container.getPreparedStatementProvider(),container.getConnection(), ontId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                         while (counter > 0) {
                         oCount += counter;
                         counter = GlitterSQL.prepareObjectInferO_1_NO_WITH_1(container.getPreparedStatementProvider(),container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 2), container.getContainerName());
                         }
                         */
                        counter = GlitterSQL.preparePropInfer_0_NO_WITH_0(container.getStmtProvider(), container.getConnection(), ontId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                        while (counter > 0) {
                            // oCount += counter;
                            counter = GlitterSQL.preparePropInfer_0_NO_WITH_1(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 2), container.getContainerName());
                        }
                        if (oCount > 0) {
                            if (metadataGraph == -1) {
                                count += GlitterSQL.insertFindSO(container.getStmtProvider(), container.getConnection(), subjId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                            } else {
                                count += GlitterSQL.insertFindSOMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, subjId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                            }
                        }
                    }
                    if (count > 0) {
                        ClosableIterator<SelectOResult> results = GlitterSQL.selectO(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("STMT_TMP", 1), "PROP_INFER_TEMP", container.getContainerName());
                        try {
                            parseResultsO(container, results, list, ids);
                        } finally {
                            results.close();
                        }
                    }
                }
                    break;
                case 11: {
                    int count = 0;
                    if (graphTable == null) {
                        count = GlitterSQL.insert11(container.getStmtProvider(), container.getConnection(), namedGraphId, subjId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    } else {
                        if (metadataGraph == -1) {
                            count = GlitterSQL.insert11M(container.getStmtProvider(), container.getConnection(), subjId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable);
                        } else {
                            count = GlitterSQL.insert11MMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, subjId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable);
                        }
                    }
                    int oCount = 0;
                    if (container.getConfiguration().getSupportsWithClause()) {
                        oCount = GlitterSQL.prepareObjectInferO_0(container.getStmtProvider(), container.getConnection(), ontId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                        //oCount += GlitterSQL.prepareObjectInferO_1(container.getPreparedStatementProvider(),container.getConnection(), ontId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                        GlitterSQL.preparePropInfer_0(container.getStmtProvider(), container.getConnection(), ontId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                    } else {
                        int counter = GlitterSQL.prepareObjectInferO_0_NO_WITH_0(container.getStmtProvider(), container.getConnection(), ontId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                        while (counter > 0) {
                            oCount += counter;
                            counter = GlitterSQL.prepareObjectInferO_0_NO_WITH_1(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 2), container.getContainerName());
                        }
                        /*counter = GlitterSQL.prepareObjectInferO_1_NO_WITH_0(container.getPreparedStatementProvider(),container.getConnection(), ontId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                         while (counter > 0) {
                         oCount += counter;
                         counter = GlitterSQL.prepareObjectInferO_1_NO_WITH_1(container.getPreparedStatementProvider(),container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 2), container.getContainerName());
                         }*/
                        counter = GlitterSQL.preparePropInfer_0_NO_WITH_0(container.getStmtProvider(), container.getConnection(), ontId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                        while (counter > 0) {
                            // oCount += counter;
                            counter = GlitterSQL.preparePropInfer_0_NO_WITH_1(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 2), container.getContainerName());
                        }
                    }
                    if (oCount > 0) {
                        if (graphTable != null) {
                            if (metadataGraph == -1) {
                                count += GlitterSQL.insertFindMSO(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName(), graphTable);
                            } else {
                                count += GlitterSQL.insertFindMSOMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName(), graphTable);
                            }
                        } else {
                            count += GlitterSQL.insertFindNSO(container.getStmtProvider(), container.getConnection(), namedGraphId, subjId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                        }
                    }
                    if (count > 0) {
                        ClosableIterator<SelectOResult> results = GlitterSQL.selectO(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("STMT_TMP", 1), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                        try {
                            parseResultsO(container, results, list, ids);
                        } finally {
                            results.close();
                        }
                    }
                }
                    break;
                case 12: {
                    int count = 0;
                    if (metadataGraph == -1) {
                        count = GlitterSQL.insert12(container.getStmtProvider(), container.getConnection(), predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    } else {
                        count = GlitterSQL.insert12META(container.getStmtProvider(), container.getConnection(), metadataGraph, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    }
                    int oCount = 0;
                    if (container.getConfiguration().getSupportsWithClause()) {
                        if (isRdfType) {
                            oCount = GlitterSQL.prepareObjectInferPO_0(container.getStmtProvider(), container.getConnection(), ontId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                            //	oCount += GlitterSQL.prepareObjectInferPO_1(container.getPreparedStatementProvider(),container.getConnection(), ontId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                        }
                        oCount += GlitterSQL.preparePropInfer_0(container.getStmtProvider(), container.getConnection(), ontId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                    } else {
                        if (isRdfType) {
                            int counter = GlitterSQL.prepareObjectInferPO_0_NO_WITH_0(container.getStmtProvider(), container.getConnection(), ontId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                            while (counter > 0) {
                                oCount += counter;
                                counter = GlitterSQL.prepareObjectInferPO_0_NO_WITH_1(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 2), container.getContainerName());
                            }
                            /*counter = GlitterSQL.prepareObjectInferPO_1_NO_WITH_0(container.getPreparedStatementProvider(),container.getConnection(), ontId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                             while (counter > 0) {
                             oCount += counter;
                             counter = GlitterSQL.prepareObjectInferPO_1_NO_WITH_1(container.getPreparedStatementProvider(),container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 2), container.getContainerName());
                             }*/
                        }
                        int counter = GlitterSQL.preparePropInfer_0_NO_WITH_0(container.getStmtProvider(), container.getConnection(), ontId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                        while (counter > 0) {
                            oCount += counter;
                            counter = GlitterSQL.preparePropInfer_0_NO_WITH_1(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 2), container.getContainerName());
                        }
                    }
                    if (oCount > 0) {
                        if (metadataGraph == -1) {
                            if (isRdfType) {
                                count += GlitterSQL.insertFindPO_O(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                            }
                            count += GlitterSQL.insertFindPO_P(container.getStmtProvider(), container.getConnection(), objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                        } else {
                            if (isRdfType) {
                                count += GlitterSQL.insertFindPO_OMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                            }
                            count += GlitterSQL.insertFindPO_PMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                        }
                    }
                    if (count > 0) {
                        ClosableIterator<SelectAllResult> results = GlitterSQL.selectAll(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0));
                        try {
                            parseResults(container, results, list, ids);
                        } finally {
                            results.close();
                        }
                    }
                }
                    break;
                case 13: {
                    int count = 0;
                    if (graphTable == null) {
                        count = GlitterSQL.insert13(container.getStmtProvider(), container.getConnection(), namedGraphId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    } else {
                        if (metadataGraph == -1) {
                            count = GlitterSQL.insert13M(container.getStmtProvider(), container.getConnection(), predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable);
                        } else {
                            count = GlitterSQL.insert13MMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable);
                        }
                    }
                    int oCount = 0;
                    if (container.getConfiguration().getSupportsWithClause()) {
                        if (isRdfType) {
                            oCount = GlitterSQL.prepareObjectInferPO_0(container.getStmtProvider(), container.getConnection(), ontId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                            //oCount += GlitterSQL.prepareObjectInferPO_1(container.getPreparedStatementProvider(),container.getConnection(), ontId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                        }
                        oCount += GlitterSQL.preparePropInferP_0(container.getStmtProvider(), container.getConnection(), ontId, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                    } else {
                        if (isRdfType) {
                            int counter = GlitterSQL.prepareObjectInferPO_0_NO_WITH_0(container.getStmtProvider(), container.getConnection(), ontId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                            while (counter > 0) {
                                oCount += counter;
                                counter = GlitterSQL.prepareObjectInferPO_0_NO_WITH_1(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 2), container.getContainerName());
                            }
                            //									counter = GlitterSQL.prepareObjectInferPO_1_NO_WITH_0(container.getPreparedStatementProvider(),container.getConnection(), ontId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                            //									while (counter > 0) {
                            //										oCount += counter;
                            //										counter = GlitterSQL.prepareObjectInferPO_1_NO_WITH_1(container.getPreparedStatementProvider(),container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 2), container.getContainerName());
                            //									}
                        }
                        int counter = GlitterSQL.preparePropInferP_0_NO_WITH_0(container.getStmtProvider(), container.getConnection(), ontId, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                        while (counter > 0) {
                            oCount += counter;
                            counter = GlitterSQL.preparePropInferP_0_NO_WITH_1(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 2), container.getContainerName());
                        }
                    }
                    if (oCount > 0) {
                        /*ClosableIterator<SelectInferedInferenceResult> results=GlitterSQL.selectInferedInference(container.getPreparedStatementProvider(),container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                         for(SelectInferedInferenceResult result:results	) {
                         System.err.println("<"+result.getProp()+"> <"+result.getObj()+"> <"+result.getObjInfer()+">");
                         }
                         results.close();*/
                        if (graphTable != null) {
                            if (metadataGraph == -1) {
                                if (isRdfType) {
                                    count += GlitterSQL.insertFindMPO_O(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName(), graphTable);
                                }
                                count += GlitterSQL.insertFindMPO_P(container.getStmtProvider(), container.getConnection(), objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName(), graphTable);
                            } else {
                                if (isRdfType) {
                                    count += GlitterSQL.insertFindMPO_OMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName(), graphTable);
                                }
                                count += GlitterSQL.insertFindMPO_PMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName(), graphTable);
                            }
                        } else {
                            if (isRdfType) {
                                count += GlitterSQL.insertFindNPO_O(container.getStmtProvider(), container.getConnection(), namedGraphId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                            }
                            count += GlitterSQL.insertFindNPO_P(container.getStmtProvider(), container.getConnection(), namedGraphId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                        }
                    }
                    if (count > 0) {
                        ClosableIterator<SelectAllResult> results = GlitterSQL.selectAll(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0));
                        try {
                            parseResults(container, results, list, ids);
                        } finally {
                            results.close();
                        }
                    }
                }
                    break;
                case 14: {
                    int count = 0;
                    if (metadataGraph == -1) {
                        count = GlitterSQL.insert14(container.getStmtProvider(), container.getConnection(), subjId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    } else {
                        count = GlitterSQL.insert14META(container.getStmtProvider(), container.getConnection(), metadataGraph, subjId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    }
                    int oCount = 0;
                    if (container.getConfiguration().getSupportsWithClause()) {
                        if (isRdfType) {
                            oCount = GlitterSQL.prepareObjectInferPO_0(container.getStmtProvider(), container.getConnection(), ontId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                            //oCount += GlitterSQL.prepareObjectInferPO_1(container.getPreparedStatementProvider(),container.getConnection(), ontId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                        }
                        oCount += GlitterSQL.preparePropInfer_0(container.getStmtProvider(), container.getConnection(), ontId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                    } else {
                        if (isRdfType) {
                            int counter = GlitterSQL.prepareObjectInferPO_0_NO_WITH_0(container.getStmtProvider(), container.getConnection(), ontId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                            while (counter > 0) {
                                oCount += counter;
                                counter = GlitterSQL.prepareObjectInferPO_0_NO_WITH_1(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 2), container.getContainerName());
                            }
                            /*counter = GlitterSQL.prepareObjectInferPO_1_NO_WITH_0(container.getPreparedStatementProvider(),container.getConnection(), ontId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                             while (counter > 0) {
                             oCount += counter;
                             counter = GlitterSQL.prepareObjectInferPO_1_NO_WITH_1(container.getPreparedStatementProvider(),container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 2), container.getContainerName());
                             }*/
                        }
                        int counter = GlitterSQL.preparePropInfer_0_NO_WITH_0(container.getStmtProvider(), container.getConnection(), ontId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                        while (counter > 0) {
                            oCount += counter;
                            counter = GlitterSQL.preparePropInfer_0_NO_WITH_1(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 2), container.getContainerName());
                        }
                    }
                    if (oCount > 0) {
                        if (metadataGraph == -1) {
                            if (isRdfType) {
                                count += GlitterSQL.insertFindSPO_O(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                            }
                            count += GlitterSQL.insertFindSPO_P(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                        } else {
                            if (isRdfType) {
                                count += GlitterSQL.insertFindSPO_OMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                            }
                            count += GlitterSQL.insertFindSPO_PMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                        }
                    }
                    if (count > 0) {
                        ClosableIterator<SelectAllResult> results = GlitterSQL.selectAll(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0));
                        try {
                            parseResults(container, results, list, ids);
                        } finally {
                            results.close();
                        }
                    }
                }
                    break;
                case 15: {
                    int count = 0;
                    if (graphTable == null) {
                        count = GlitterSQL.insert15(container.getStmtProvider(), container.getConnection(), namedGraphId, subjId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName());
                    } else {
                        if (metadataGraph == -1) {
                            count = GlitterSQL.insert15M(container.getStmtProvider(), container.getConnection(), subjId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable);
                        } else {
                            count = GlitterSQL.insert15MMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, subjId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable);
                        }
                    }
                    int oCount = 0;
                    if (container.getConfiguration().getSupportsWithClause()) {
                        if (isRdfType) {
                            oCount = GlitterSQL.prepareObjectInferPO_0(container.getStmtProvider(), container.getConnection(), ontId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                            //oCount += GlitterSQL.prepareObjectInferPO_1(container.getPreparedStatementProvider(),container.getConnection(), ontId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                        }
                        oCount += GlitterSQL.preparePropInfer_0(container.getStmtProvider(), container.getConnection(), ontId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                    } else {
                        if (isRdfType) {
                            int counter = GlitterSQL.prepareObjectInferPO_0_NO_WITH_0(container.getStmtProvider(), container.getConnection(), ontId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                            while (counter > 0) {
                                oCount += counter;
                                counter = GlitterSQL.prepareObjectInferPO_0_NO_WITH_1(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 2), container.getContainerName());
                            }
                            /*counter = GlitterSQL.prepareObjectInferPO_1_NO_WITH_0(container.getPreparedStatementProvider(),container.getConnection(), ontId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                             while (counter > 0) {
                             oCount += counter;
                             counter = GlitterSQL.prepareObjectInferPO_1_NO_WITH_1(container.getPreparedStatementProvider(),container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 2), container.getContainerName());
                             }*/
                        }
                        int counter = GlitterSQL.preparePropInfer_0_NO_WITH_0(container.getStmtProvider(), container.getConnection(), ontId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                        while (counter > 0) {
                            oCount += counter;
                            counter = GlitterSQL.preparePropInfer_0_NO_WITH_1(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 1), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 2), container.getContainerName());
                        }
                    }
                    if (oCount > 0) {
                        if (graphTable != null) {
                            if (metadataGraph == -1) {
                                if (isRdfType) {
                                    count += GlitterSQL.insertFindMSPO_O(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName(), graphTable);
                                }
                                count += GlitterSQL.insertFindMSPO_P(container.getStmtProvider(), container.getConnection(), subjId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName(), graphTable);
                            } else {
                                if (isRdfType) {
                                    count += GlitterSQL.insertFindMSPO_OMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName(), graphTable);
                                }
                                count += GlitterSQL.insertFindMSPO_PMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, subjId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName(), graphTable);
                            }
                        } else {
                            if (isRdfType) {
                                count += GlitterSQL.insertFindNSPO_O(container.getStmtProvider(), container.getConnection(), namedGraphId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0), container.getContainerName());
                            }
                            count += GlitterSQL.insertFindNSPO_P(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0), container.getContainerName());
                        }
                    }
                    if (count > 0) {
                        ClosableIterator<SelectAllResult> results = GlitterSQL.selectAll(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0));
                        try {
                            parseResults(container, results, list, ids);
                        } finally {
                            results.close();
                        }
                    }
                }
                }
            } finally {
                try {
                    BaseSQL.clearTableWithSessionPrefix(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), "QUERY");
                } catch (RdbException e) {
                    log.error(LogUtils.RDB_MARKER, "Error clearing temporary table:query", e);
                }
                try {
                    BaseSQL.clearTableWithSessionPrefix(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("PROP_INFER_TMP", 0));
                } catch (RdbException e) {
                    log.error(LogUtils.RDB_MARKER, "Error clearing temporary table:PROP_INFER_TMP", e);
                }
                try {
                    BaseSQL.clearTableWithSessionPrefix(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0));
                } catch (RdbException e) {
                    log.error(LogUtils.RDB_MARKER, "Error clearing temporary table:STMT_TMP", e);
                }
                try {
                    BaseSQL.clearTableWithSessionPrefix(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("OBJ_INFER_TMP", 0));
                } catch (RdbException e) {
                    log.error(LogUtils.RDB_MARKER, "Error clearing temporary table:OBJ_INFER_TMP", e);
                }
            }
            container.getNodeLayout().resolveStoredIds(ids, container.getConnection());
            return list;
        } catch (RdbException e) {
            throw new AnzoException(ExceptionConstants.CLIENT.FAILED_CONTAINER_FIND_STATEMENTS, e);
        }
    }

    /**
     * Find all statements in container that match the provided parameters
     * 
     * @param container
     *            source of data
     * @param subj
     *            Subject resource to match, or wildcard if null
     * @param prop
     *            Predicate uri to match, or wildcard if null
     * @param obj
     *            Object value to match, or wildcard if null
     * @param contexts
     *            Context values to match, or wildcard if null
     * @return Iterable set of quads containing results of find operation
     * @throws AnzoException
     *             if there was an error finding statements
     */
    @SuppressWarnings("unchecked")
    public static Iterable<Quad> findStatements(RDBQuadStore container, Resource subj, URI prop, Value obj, URI... contexts) throws AnzoException {

        Long namedGraphId = null;
        String graphTable = null;
        int metadataGraph = -1;
        if (contexts != null && contexts.length == 1) {
            URI context = (URI) StatementUtils.convertUriToAny(contexts[0]);
            if (context != null) {
                namedGraphId = container.getNodeLayout().fetchId(context, container.getConnection());
                if (namedGraphId == null) {
                    return Collections.EMPTY_LIST; // required node is not even in db
                }
                metadataGraph = UriGenerator.isMetadataGraphUri(context) ? 1 : 0;
            }
        } else {
            HashSet<Value> set = new HashSet<Value>();
            boolean includeAllNamedGraphs = false, includeAllMetadataGraphs = false;
            Map<Value, Long> graphIds = null;
            if (contexts != null && contexts.length > 0) {
                for (Resource context : contexts) {
                    if (context.equals(GRAPHS.ALL_GRAPHS))
                        includeAllNamedGraphs = includeAllMetadataGraphs = true;
                    else if (context.equals(GRAPHS.ALL_NAMEDGRAPHS))
                        includeAllNamedGraphs = true;
                    else if (context.equals(GRAPHS.ALL_METADATAGRAPHS))
                        includeAllMetadataGraphs = true;
                    else
                        set.add(context);
                }
                if (set.size() > 0) {
                    graphIds = container.getNodeLayout().resolveStoredNodes(set, false, container.getConnection(), -1);
                    if (graphIds.size() < set.size()) {
                        set.removeAll(graphIds.keySet());
                        log.debug(LogUtils.RDB_MARKER, "findStatementsInferred", new UnknownGraphException(StringUtils.join(set.iterator(), ", ")));
                        if (graphIds.size() == 0 && !includeAllNamedGraphs && !includeAllMetadataGraphs) {
                            return Collections.EMPTY_LIST;// required node is not even in db
                        }
                    }
                    if (graphIds.size() > 0) {
                        graphTable = SQLQueryConstants.defaultGraphsTempTable;
                        //container.populateValidGraphs(graphIds, includeAllNamedGraphs, includeAllMetadataGraphs, graphTable);
                        //container.populateValidGraphs(graphIds, includeAllNamedGraphs, graphTable);
                    }
                } else if (includeAllNamedGraphs || includeAllMetadataGraphs) {
                    metadataGraph = includeAllNamedGraphs ? (includeAllMetadataGraphs ? -1 : 0) : 1;
                }
            }
        }
        return findStatements(container, subj, prop, obj, namedGraphId, metadataGraph, graphTable);

    }

    /**
     * Find statements in container that match pattern. <li>If graphTable is not null, queries are joined against temporary table containing valid graphs for
     * this query</li> <li>Else if the namedGraphId is not null, then queries go against only statements that have the specific namedGraphId</li> <li>Finally,
     * if both the graphTable and namedGraphId are null, query either queries all graphs if metadataGraph==-1, namedGraphs if metadataGraph==0, or
     * metadataGraphs if metadataGraph==1
     * 
     * @param container
     *            source of data
     * @param subj
     *            Subject resource to match, or wildcard if null
     * @param prop
     *            Predicate uri to match, or wildcard if null
     * @param obj
     *            Object value to match, or wildcard if null
     * @param namedGraphId
     *            id of namedGraph to query
     * @param metadataGraph
     *            if both the graphTable and namedGraphId are null, query either queries all graphs if metadataGraph==-1, namedGraphs if metadataGraph==0, or
     *            metadataGraphs if metadataGraph==1
     * @param graphTable
     *            temporary table containing valid graphs for this query
     * @return Iterable set of quads containing results of find operation
     * @throws AnzoException
     *             if there was an error finding statements
     */
    public static Iterable<Quad> findStatements(RDBQuadStore container, Resource subj, URI prop, Value obj, Long namedGraphId, int metadataGraph, String graphTable) throws AnzoException {
        try {
            ArrayList<Quad> list = new ArrayList<Quad>();
            HashSet<Long> ids = new HashSet<Long>();
            try {
                subj = (Resource) StatementUtils.convertUriToAny(subj);
                prop = (URI) StatementUtils.convertUriToAny(prop);
                obj = StatementUtils.convertUriToAny(obj);
                int type = 0;
                Long subjId = null;
                Long predId = null;
                Long objId = null;
                if (subj != null) {
                    subjId = container.getNodeLayout().fetchId(subj, container.getConnection());
                    if (subjId == null) {
                        return Collections.<Quad> emptyList(); // required node is not even in db
                    }
                } else {
                    //subjId = null;//Long.valueOf(-1);
                }
                if (prop != null) {
                    predId = container.getNodeLayout().fetchId(prop, container.getConnection());
                    if (predId == null) {
                        return Collections.<Quad> emptyList(); // required node is not even in db
                    }
                } else {
                    //predId = null;//Long.valueOf(-1);
                }
                if (obj != null) {
                    objId = container.getNodeLayout().fetchId(obj, container.getConnection());
                    if (objId == null) {
                        return Collections.<Quad> emptyList(); // required node is not even in db
                    }
                } else {
                    //objId = null;// Long.valueOf(-1);
                }
                if (namedGraphId != null || graphTable != null)
                    type |= 1;
                if (subjId != null)
                    type |= 2;
                if (predId != null)
                    type |= 4;
                if (objId != null)
                    type |= 8;
                //	if(graphTable!=null)System.err.println("Row Count:"+	GlitterSQL.countRows(container.getPreparedStatementProvider(),container.getConnection(), container.getConfiguration().getSessionPrefix(), graphTable));
                switch (type) {
                case 0: {
                    parseResultsQuad(container, ExtraSQL.select0(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                }
                    break;
                case 1: {
                    if (graphTable == null) {
                        parseResultsQuad(container, ExtraSQL.select1(container.getStmtProvider(), container.getConnection(), namedGraphId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                    } else {
                        parseResultsQuad(container, ExtraSQL.select1M(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable), list, ids);
                    }
                }
                    break;
                case 2: {
                    if (metadataGraph == -1) {
                        parseResultsQuad(container, ExtraSQL.select2(container.getStmtProvider(), container.getConnection(), subjId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                    } else {
                        parseResultsQuad(container, ExtraSQL.select2META(container.getStmtProvider(), container.getConnection(), metadataGraph, subjId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                    }
                }
                    break;
                case 3: {
                    if (graphTable == null) {
                        parseResultsQuad(container, ExtraSQL.select3(container.getStmtProvider(), container.getConnection(), namedGraphId, subjId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                    } else {
                        parseResultsQuad(container, ExtraSQL.select3M(container.getStmtProvider(), container.getConnection(), subjId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable), list, ids);
                    }
                }
                    break;
                case 4: {
                    if (metadataGraph == -1) {
                        parseResultsQuad(container, ExtraSQL.select4(container.getStmtProvider(), container.getConnection(), predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                    } else {
                        parseResultsQuad(container, ExtraSQL.select4META(container.getStmtProvider(), container.getConnection(), metadataGraph, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                    }
                }
                    break;
                case 5: {
                    if (graphTable == null) {
                        parseResultsQuad(container, ExtraSQL.select5(container.getStmtProvider(), container.getConnection(), namedGraphId, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                    } else {
                        if (metadataGraph == -1) {
                            parseResultsQuad(container, ExtraSQL.select5M(container.getStmtProvider(), container.getConnection(), predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable), list, ids);
                        } else {
                            parseResultsQuad(container, ExtraSQL.select5MMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable), list, ids);
                        }
                    }
                }
                    break;
                case 6: {
                    if (metadataGraph == -1) {
                        parseResultsQuad(container, ExtraSQL.select6(container.getStmtProvider(), container.getConnection(), subjId, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                    } else {
                        parseResultsQuad(container, ExtraSQL.select6META(container.getStmtProvider(), container.getConnection(), metadataGraph, subjId, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                    }
                }
                    break;
                case 7: {
                    if (graphTable == null) {
                        parseResultsQuad(container, ExtraSQL.select7(container.getStmtProvider(), container.getConnection(), namedGraphId, subjId, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                    } else {
                        if (metadataGraph == -1) {
                            parseResultsQuad(container, ExtraSQL.select7M(container.getStmtProvider(), container.getConnection(), subjId, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable), list, ids);
                        } else {
                            parseResultsQuad(container, ExtraSQL.select7MMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, subjId, predId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable), list, ids);
                        }
                    }
                }
                    break;
                case 8: {
                    if (metadataGraph == -1) {
                        parseResultsQuad(container, ExtraSQL.select8(container.getStmtProvider(), container.getConnection(), objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                    } else {
                        parseResultsQuad(container, ExtraSQL.select8META(container.getStmtProvider(), container.getConnection(), metadataGraph, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                    }
                }
                    break;
                case 9: {
                    if (graphTable == null) {
                        parseResultsQuad(container, ExtraSQL.select9(container.getStmtProvider(), container.getConnection(), namedGraphId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                    } else {
                        if (metadataGraph == -1) {
                            parseResultsQuad(container, ExtraSQL.select9M(container.getStmtProvider(), container.getConnection(), objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable), list, ids);
                        } else {
                            parseResultsQuad(container, ExtraSQL.select9MMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable), list, ids);
                        }
                    }
                }
                    break;
                case 10: {
                    if (metadataGraph == -1) {
                        parseResultsQuad(container, ExtraSQL.select10(container.getStmtProvider(), container.getConnection(), subjId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                    } else {
                        parseResultsQuad(container, ExtraSQL.select10META(container.getStmtProvider(), container.getConnection(), metadataGraph, subjId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                    }
                }
                    break;
                case 11: {
                    if (graphTable == null) {
                        parseResultsQuad(container, ExtraSQL.select11(container.getStmtProvider(), container.getConnection(), namedGraphId, subjId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                    } else {
                        if (metadataGraph == -1) {
                            parseResultsQuad(container, ExtraSQL.select11M(container.getStmtProvider(), container.getConnection(), subjId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable), list, ids);
                        } else {
                            parseResultsQuad(container, ExtraSQL.select11MMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, subjId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable), list, ids);
                        }
                    }
                }
                    break;
                case 12: {
                    if (metadataGraph == -1) {
                        parseResultsQuad(container, ExtraSQL.select12(container.getStmtProvider(), container.getConnection(), predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                    } else {
                        parseResultsQuad(container, ExtraSQL.select12META(container.getStmtProvider(), container.getConnection(), metadataGraph, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                    }
                }
                    break;
                case 13: {
                    if (graphTable == null) {
                        parseResultsQuad(container, ExtraSQL.select13(container.getStmtProvider(), container.getConnection(), namedGraphId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                    } else {
                        if (metadataGraph == -1) {
                            parseResultsQuad(container, ExtraSQL.select13M(container.getStmtProvider(), container.getConnection(), predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable), list, ids);
                        } else {
                            parseResultsQuad(container, ExtraSQL.select13MMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable), list, ids);
                        }
                    }
                }
                    break;
                case 14: {
                    if (metadataGraph == -1) {
                        parseResultsQuad(container, ExtraSQL.select14(container.getStmtProvider(), container.getConnection(), subjId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                    } else {
                        parseResultsQuad(container, ExtraSQL.select14META(container.getStmtProvider(), container.getConnection(), metadataGraph, subjId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                    }
                }
                    break;
                case 15: {
                    if (graphTable == null) {
                        parseResultsQuad(container, ExtraSQL.select15(container.getStmtProvider(), container.getConnection(), namedGraphId, subjId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName()), list, ids);
                    } else {
                        if (metadataGraph == -1) {
                            parseResultsQuad(container, ExtraSQL.select15M(container.getStmtProvider(), container.getConnection(), subjId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable), list, ids);
                        } else {
                            parseResultsQuad(container, ExtraSQL.select15MMETA(container.getStmtProvider(), container.getConnection(), metadataGraph, subjId, predId, objId, container.getConfiguration().getSessionPrefix(), container.getConfiguration().getUniqueTempName("STMT_TMP", 0), container.getContainerName(), graphTable), list, ids);
                        }
                    }
                }
                }
            } finally {
                try {
                    if (graphTable != null)
                        BaseSQL.truncateTableWithSessionMayCommit(container.getStmtProvider(), container.getConnection(), container.getConfiguration().getSessionPrefix(), graphTable);
                } catch (RdbException e) {
                    log.error(LogUtils.RDB_MARKER, "Error clearing temporary table:" + graphTable, e);
                }
            }
            container.getNodeLayout().resolveStoredIds(ids, container.getConnection());
            return list;
        } catch (RdbException e) {
            throw new AnzoException(ExceptionConstants.CLIENT.FAILED_CONTAINER_FIND_STATEMENTS, e);
        }
    }

    private static void parseResults(RDBQuadStore container, ClosableIterator<SelectAllResult> results, ArrayList<Quad> list, HashSet<Long> ids) throws RdbException {
        for (SelectAllResult result : results) {
            long n = result.getNamedgraphId();
            long s = result.getSubjId();
            long p = result.getPropId();
            long o = result.getObjId();
            Quad quint = new Quad(container.getConnection(), container.getNodeLayout().getNodeConverter(), n, s, p, o);
            list.add(quint);
            if (!container.getNodeLayout().isCached(n))
                ids.add(n);
            if (!container.getNodeLayout().isCached(s))
                ids.add(s);
            if (!container.getNodeLayout().isCached(p))
                ids.add(p);
            if (!container.getNodeLayout().isCached(o))
                ids.add(o);
        }
    }

    private static void parseResultsQuad(RDBQuadStore container, ClosableIterator<SelectQuadResult> results, ArrayList<Quad> list, HashSet<Long> ids) throws RdbException {
        try {
            for (SelectQuadResult result : results) {
                long n = result.getNamedGraphId();
                long s = result.getSubj();
                long p = result.getProp();
                long o = result.getObj();
                Quad quint = new Quad(container.getConnection(), container.getNodeLayout().getNodeConverter(), n, s, p, o);
                list.add(quint);
                if (!container.getNodeLayout().isCached(n))
                    ids.add(n);
                if (!container.getNodeLayout().isCached(s))
                    ids.add(s);
                if (!container.getNodeLayout().isCached(p))
                    ids.add(p);
                if (!container.getNodeLayout().isCached(o))
                    ids.add(o);
            }
        } finally {
            results.close();
        }
    }

    private static void parseResultsS(RDBQuadStore container, ClosableIterator<SelectSResult> results, ArrayList<Quad> list, HashSet<Long> ids) throws RdbException {
        for (SelectSResult result : results) {
            long n = result.getNamedgraphId();
            long s = result.getSubjId();
            long p = result.getPropId();
            long o = result.getObjId();
            Quad quint = new Quad(container.getConnection(), container.getNodeLayout().getNodeConverter(), n, s, p, o);
            list.add(quint);
            if (!container.getNodeLayout().isCached(n))
                ids.add(n);
            if (!container.getNodeLayout().isCached(s))
                ids.add(s);
            if (!container.getNodeLayout().isCached(p))
                ids.add(p);
            if (!container.getNodeLayout().isCached(o))
                ids.add(o);
        }
    }

    private static void parseResultsP(RDBQuadStore container, ClosableIterator<SelectPResult> results, ArrayList<Quad> list, HashSet<Long> ids) throws RdbException {
        for (SelectPResult result : results) {
            long n = result.getNamedgraphId();
            long s = result.getSubjId();
            long p = result.getPropId();
            long o = result.getObjId();
            Quad quint = new Quad(container.getConnection(), container.getNodeLayout().getNodeConverter(), n, s, p, o);
            list.add(quint);
            if (!container.getNodeLayout().isCached(n))
                ids.add(n);
            if (!container.getNodeLayout().isCached(s))
                ids.add(s);
            if (!container.getNodeLayout().isCached(p))
                ids.add(p);
            if (!container.getNodeLayout().isCached(o))
                ids.add(o);
        }
    }

    private static void parseResultsO(RDBQuadStore container, ClosableIterator<SelectOResult> results, ArrayList<Quad> list, HashSet<Long> ids) throws RdbException {
        for (SelectOResult result : results) {
            long n = result.getNamedgraphId();
            long s = result.getSubjId();
            long p = result.getPropId();
            long o = result.getObjId();
            Quad quint = new Quad(container.getConnection(), container.getNodeLayout().getNodeConverter(), n, s, p, o);
            list.add(quint);
            if (!container.getNodeLayout().isCached(n))
                ids.add(n);
            if (!container.getNodeLayout().isCached(s))
                ids.add(s);
            if (!container.getNodeLayout().isCached(p))
                ids.add(p);
            if (!container.getNodeLayout().isCached(o))
                ids.add(o);
        }
    }
}
