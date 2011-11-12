/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/model/Attic/QuadStore.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Apr 25, 2007
 * Revision:	$Id: QuadStore.java 168 2007-07-31 14:11:14Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.collections15.MultiMap;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.Engine;
import org.openanzo.glitter.dataset.DefaultQueryDataset;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.glitter.syntax.concrete.ParseException;
import org.openanzo.rdf.query.CoreEngineConfig;
import org.openanzo.rdf.query.QuadStoreEngineConfig;
import org.openanzo.rdf.utils.MultiTreeArrayMap;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.rdf.vocabulary.Anzo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Core storage of quads with indexes for s,p,o,nguri, po, and sp
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class MemQuadStore extends BaseQuadStore implements IQuadStore {

    private static final Logger                           log = LoggerFactory.getLogger(MemQuadStore.class);

    //Set of all statements in store
    private final Collection<Statement>                   statements;

    //Index map of namedGraphUris to statements
    private final MultiMap<URI, Statement>                namedGraphMap;

    //Index map of subjects to statements
    private final MultiMap<Resource, Statement>           subjectMap;

    //Index map of predicates to statements
    private final MultiMap<URI, Statement>                predMap;

    //Index map of object to statements
    private final MultiMap<Value, Statement>              objMap;

    //Index map of predicates/object to statements
    private final Map<URI, MultiMap<Value, Statement>>    poIndex;

    //Index map of predicate/subject to statements
    private final Map<URI, MultiMap<Resource, Statement>> psIndex;

    private final Engine                                  glitter;

    /**
     * Initialize quadstore's statement set and indexes
     */
    public MemQuadStore() {
        statements = new HashSet<Statement>();
        subjectMap = new MultiTreeArrayMap<Resource, Statement>();
        predMap = new MultiTreeArrayMap<URI, Statement>();
        objMap = new MultiTreeArrayMap<Value, Statement>();
        namedGraphMap = new MultiTreeArrayMap<URI, Statement>();
        poIndex = new TreeMap<URI, MultiMap<Value, Statement>>();
        psIndex = new TreeMap<URI, MultiMap<Resource, Statement>>();

        CoreEngineConfig config = new QuadStoreEngineConfig(this);
        glitter = new Engine(config);
    }

    /**
     * Add statements to store and index them
     * 
     * @param statements
     *            Statements to add
     * @throws AnzoRuntimeException
     *             if the namedGraphURI of a statement is null
     */
    public void add(Statement... statements) {
        synchronized (this.statements) {
            for (Statement stmt : statements) {
                if (stmt.getNamedGraphUri() == null) {
                    throw new AnzoRuntimeException(ExceptionConstants.CLIENT.URI_NOT_NULL);
                }
                if (stmt.getSubject() == null || stmt.getPredicate() == null || stmt.getObject() == null)
                    throw new IllegalStateException("statement cannot contain nulls");
                if (this.statements.add(stmt)) {
                    addMaps(stmt);
                }
            }
        }
    }

    /**
     * Delete statements from store and remove indexes
     * 
     * @param statements
     *            Statements to delete
     * @throws AnzoRuntimeException
     *             if the namedGraphURI of a statement is null
     */
    public void remove(Statement... statements) {
        synchronized (this.statements) {
            for (Statement stmt : statements) {
                if (stmt.getNamedGraphUri() == null) {
                    throw new AnzoRuntimeException(ExceptionConstants.CLIENT.URI_NOT_NULL);
                }
                if (this.statements.remove(stmt)) {
                    removeMaps(stmt);
                }
            }
        }
    }

    /**
     * Index this statement
     * 
     * @param stmt
     *            Statement to index
     */
    private void addMaps(Statement stmt) {
        URI c = stmt.getNamedGraphUri();
        Resource s = stmt.getSubject();
        URI p = stmt.getPredicate();
        Value o = stmt.getObject();
        subjectMap.put(s, stmt);
        predMap.put(p, stmt);
        objMap.put(o, stmt);
        namedGraphMap.put(c, stmt);
        MultiMap<Value, Statement> poIndexMap = poIndex.get(p);
        if (poIndexMap == null) {
            poIndexMap = new MultiTreeArrayMap<Value, Statement>();
            poIndex.put(p, poIndexMap);
        }
        poIndexMap.put(o, stmt);

        MultiMap<Resource, Statement> psIndexMap = psIndex.get(p);
        if (psIndexMap == null) {
            psIndexMap = new MultiTreeArrayMap<Resource, Statement>();
            psIndex.put(p, psIndexMap);
        }
        psIndexMap.put(s, stmt);
    }

    /**
     * Remove indexes for this statement
     * 
     * @param stmt
     *            statement to deindex
     */
    private void removeMaps(Statement stmt) {
        Resource c = stmt.getNamedGraphUri();
        Resource s = stmt.getSubject();
        URI p = stmt.getPredicate();
        Value o = stmt.getObject();
        subjectMap.remove(s, stmt);
        predMap.remove(p, stmt);
        objMap.remove(o, stmt);
        namedGraphMap.remove(c, stmt);
        MultiMap<Value, Statement> poIndexMap = poIndex.get(p);
        if (poIndexMap != null) {
            poIndexMap.remove(o, stmt);
            if (poIndexMap.size() == 0) {
                poIndex.remove(p);
            }
        }
        MultiMap<Resource, Statement> psIndexMap = psIndex.get(p);
        if (psIndexMap != null) {
            psIndexMap.remove(s, stmt);
            if (psIndexMap.size() == 0) {
                psIndex.remove(p);
            }
        }
    }

    public Collection<Statement> find(Resource subj, URI pred, Value obj, URI... namedGraphUris) {
        if (namedGraphUris != null && namedGraphUris.length == 1 && namedGraphUris[0] == null) {
            namedGraphUris = new URI[0];
        }
        return findStatements(subj, pred, obj, namedGraphUris);
    }

    /**
     * Find set of statements that match provided parameters
     * 
     * @param subj
     *            Subject value to match, or wildcard if null
     * @param pred
     *            predicate value to match, or wildcard if null
     * @param obj
     *            Object value to match, or wildcard if null
     * @param namedGraphUris
     *            namedGraphURI value to match, or wildcard if null
     * @return Collection<Statement> of matching statements
     */
    private Collection<Statement> findStatements(Resource subj, URI pred, Value obj, URI... namedGraphUris) {
        //Determine what kind of query this is based on what values are provided
        int type = 0;
        if (subj != null) {
            type |= 1;
        }
        if (pred != null) {
            type |= 2;
        }
        if (obj != null) {
            type |= 4;
        }
        if (namedGraphUris != null && namedGraphUris.length > 0) {
            type |= 8;
        }
        synchronized (statements) {
            switch (type) {
            case 0:
                ArrayList<Statement> results = new ArrayList<Statement>(statements);
                return results;
            case 1:
                Collection<Statement> sSet = subjectMap.get(subj);
                if (sSet == null) {
                    return Collections.<Statement> emptyList();
                } else {
                    return org.openanzo.rdf.utils.Collections.copyCollection(sSet);
                }
            case 2:
                Collection<Statement> pSet = predMap.get(pred);
                if (pSet == null) {
                    return Collections.<Statement> emptyList();
                } else {
                    return org.openanzo.rdf.utils.Collections.copyCollection(pSet);
                }
            case 3:
                return findPS(subj, pred);
            case 4:
                Collection<Statement> oSet = objMap.get(obj);
                if (oSet == null) {
                    return Collections.<Statement> emptyList();
                } else {
                    return org.openanzo.rdf.utils.Collections.copyCollection(oSet);
                }
            case 5:
                return findSOC(subj, obj);
            case 6:
                return findPO(pred, obj);
            case 7:
                return findSPO(subj, pred, obj);
            case 8:
                Collection<Statement> matches = new ArrayList<Statement>();
                if (namedGraphUris != null) {
                    for (Resource namedGraphURI : namedGraphUris) {
                        Collection<Statement> gSet = namedGraphMap.get(namedGraphURI);
                        if (gSet != null) {
                            matches.addAll(gSet);
                        }
                    }
                }
                return matches;
            case 9:
                return findSC(subj, namedGraphUris);
            case 10:
                return findPC(pred, namedGraphUris);
            case 11:
                return findPS(subj, pred, namedGraphUris);
            case 12:
                return findOC(obj, namedGraphUris);
            case 13:
                return findSOC(subj, obj, namedGraphUris);
            case 14:
                return findPO(pred, obj, namedGraphUris);
            case 15:
                matches = new HashSet<Statement>();
                if (namedGraphUris != null) {
                    for (URI namedGraphURI : namedGraphUris) {
                        Statement stmt = new Statement(subj, pred, obj, namedGraphURI);
                        if (statements.contains(stmt)) {
                            matches.add(stmt);
                        }
                    }
                }
                return matches;
            default:
                return Collections.<Statement> emptyList();
            }
        }
    }

    /**
     * Use the predicate/Subject index to find statements
     * 
     * @param subj
     *            Subject value to match
     * @param pred
     *            predicate value to match
     * @param namedGraphUris
     *            namedGraphURI value to match, or wildcard if null
     * @return Collection<Statement> of matching statements
     */
    private Collection<Statement> findPS(Resource subj, URI pred, URI... namedGraphUris) {
        //Lookup predicate/subject index for predicate value provided
        MultiMap<Resource, Statement> psIndexMap = psIndex.get(pred);
        if (psIndexMap != null) {
            //Find subject index for subject provided
            Collection<Statement> map = psIndexMap.get(subj);
            if (map != null && map.size() > 0) {
                //If only 1 namedGraphURI is provided, then get index for that namedGraphURI
                if (namedGraphUris == null || namedGraphUris.length == 0) {
                    return org.openanzo.rdf.utils.Collections.copyCollection(map);
                } else if (namedGraphUris.length == 1) {
                    Collection<Statement> gSet = namedGraphMap.get(namedGraphUris[0]);
                    if (gSet == null) {
                        return Collections.<Statement> emptyList();
                    }
                    Collection<Statement> matches = new ArrayList<Statement>();
                    //Use the smallest set of statements, the ones from the index or set from namedGraphURI index
                    if (gSet.size() < map.size()) {
                        for (Statement stmt : gSet) {
                            if (stmt.getPredicate().equals(pred) && stmt.getSubject().equals(subj)) {
                                matches.add(stmt);
                            }
                        }
                    } else {
                        for (Statement stmt : map) {
                            if (stmt.getNamedGraphUri().equals(namedGraphUris[0])) {
                                matches.add(stmt);
                            }
                        }
                    }
                    return matches;
                } else { //If more than one namedGraphURI compare the namedGraphURI of statement from p/s index to set of namedGraphUris
                    Collection<Statement> matches = new ArrayList<Statement>();
                    HashSet<Resource> namedGraphUriset = new HashSet<Resource>(namedGraphUris.length);
                    Collections.addAll(namedGraphUriset, namedGraphUris);
                    for (Statement stmt : map) {
                        if (namedGraphUriset.contains(stmt.getNamedGraphUri())) {
                            matches.add(stmt);
                        }
                    }
                    return matches;
                }
            }
        }
        return Collections.<Statement> emptyList();
    }

    /**
     * Use the predicate/Object index to find statements
     * 
     * @param pred
     *            predicate value to match
     * @param obj
     *            Object value to match
     * @param namedGraphUris
     *            namedGraphURI value to match, or wildcard if null
     * @return Collection<Statement> of matching statements
     */
    private Collection<Statement> findPO(URI pred, Value obj, Resource... namedGraphUris) {
        MultiMap<Value, Statement> poIndexMap = poIndex.get(pred);
        if (poIndexMap != null) {
            Collection<Statement> map = poIndexMap.get(obj);
            if (map != null && map.size() > 0) {
                if (namedGraphUris == null || namedGraphUris.length == 0) {
                    return org.openanzo.rdf.utils.Collections.copyCollection(map);
                } else if (namedGraphUris.length == 1) {
                    Collection<Statement> matches = new ArrayList<Statement>();
                    Collection<Statement> gSet = namedGraphMap.get(namedGraphUris[0]);
                    if (gSet == null) {
                        return Collections.<Statement> emptyList();
                    }
                    if (gSet.size() < map.size()) {
                        for (Statement stmt : gSet) {
                            if (stmt.getPredicate().equals(pred) && stmt.getObject().equals(obj)) {
                                matches.add(stmt);
                            }
                        }
                    } else {
                        for (Statement stmt : map) {
                            if (stmt.getNamedGraphUri().equals(namedGraphUris[0])) {
                                matches.add(stmt);
                            }
                        }
                    }
                    return matches;
                } else {
                    Collection<Statement> matches = new ArrayList<Statement>();
                    HashSet<Resource> namedGraphUriset = new HashSet<Resource>(namedGraphUris.length);
                    Collections.addAll(namedGraphUriset, namedGraphUris);
                    for (Statement stmt : map) {
                        if (namedGraphUriset.contains(stmt.getNamedGraphUri())) {
                            matches.add(stmt);
                        }
                    }
                    return matches;
                }
            }
        }
        return Collections.<Statement> emptyList();
    }

    /**
     * Find statements that match Subject,Predicate, and Object values provided
     * 
     * @param subj
     *            Subject value to match
     * @param pred
     *            predicate value to match
     * @param obj
     *            Object value to match
     * @return Collection<Statement> of matching statements
     */
    @SuppressWarnings("unchecked")
    private Collection<Statement> findSPO(Resource subj, URI pred, Value obj) {
        Collection<Statement> sSet = subjectMap.get(subj);
        if (sSet == null) {
            return Collections.<Statement> emptyList();
        }
        Collection<Statement> pSet = predMap.get(pred);
        if (pSet == null) {
            return Collections.<Statement> emptyList();
        }
        Collection<Statement> oSet = objMap.get(obj);
        if (oSet == null) {
            return Collections.<Statement> emptyList();
        }
        Collection<Statement>[] set = new Collection[3];
        set[0] = sSet;
        set[1] = pSet;
        set[2] = oSet;
        Arrays.sort(set, comparator);
        Collection<Statement> matches = new ArrayList<Statement>();
        if (set[0] == sSet) {
            for (Statement stmt : sSet) {
                if (stmt.getObject().equals(obj) && stmt.getPredicate().equals(pred)) {
                    matches.add(stmt);
                }
            }
        } else if (set[0] == oSet) {
            for (Statement stmt : oSet) {
                if (stmt.getSubject().equals(subj) && stmt.getPredicate().equals(pred)) {
                    matches.add(stmt);
                }
            }
        } else {
            for (Statement stmt : pSet) {
                if (stmt.getSubject().equals(subj) && stmt.getObject().equals(obj)) {
                    matches.add(stmt);
                }
            }
        }
        return matches;
    }

    /**
     * Find statements that match Subject and Object values provided
     * 
     * @param subj
     *            Subject value to match
     * @param obj
     *            Object value to match
     * @param namedGraphUris
     *            namedGraphURI value to match, or wildcard if null
     * @return Collection<Statement> of matching statements
     */
    @SuppressWarnings("unchecked")
    private Collection<Statement> findSOC(Resource subj, Value obj, Resource... namedGraphUris) {
        Collection<Statement> sSet = subjectMap.get(subj);
        if (sSet == null || sSet.size() == 0) {
            return Collections.<Statement> emptyList();
        }
        Collection<Statement> oSet = objMap.get(obj);
        if (oSet == null || oSet.size() == 0) {
            return Collections.<Statement> emptyList();
        }
        if (namedGraphUris != null && namedGraphUris.length > 0) {
            if (namedGraphUris.length == 1) {
                Collection<Statement> gSet = namedGraphMap.get(namedGraphUris[0]);
                if (gSet == null || gSet.size() == 0) {
                    return Collections.<Statement> emptyList();
                }
                Collection<Statement>[] set = new Collection[3];
                set[0] = sSet;
                set[1] = gSet;
                set[2] = oSet;
                Arrays.sort(set, comparator);
                Collection<Statement> matches = new ArrayList<Statement>();
                if (set[0] == sSet) {
                    for (Statement stmt : sSet) {
                        if (stmt.getObject().equals(obj) && stmt.getNamedGraphUri().equals(namedGraphUris[0])) {
                            matches.add(stmt);
                        }
                    }
                } else if (set[0] == oSet) {
                    for (Statement stmt : oSet) {
                        if (stmt.getSubject().equals(subj) && stmt.getNamedGraphUri().equals(namedGraphUris[0])) {
                            matches.add(stmt);
                        }
                    }
                } else {
                    for (Statement stmt : gSet) {
                        if (stmt.getSubject().equals(subj) && stmt.getObject().equals(obj)) {
                            matches.add(stmt);
                        }
                    }
                }
                return matches;
            } else {
                Collection<Statement> matches = new ArrayList<Statement>();
                HashSet<Resource> namedGraphUriset = new HashSet<Resource>(namedGraphUris.length);
                Collections.addAll(namedGraphUriset, namedGraphUris);
                if (sSet.size() < oSet.size()) {
                    for (Statement stmt : sSet) {
                        if (stmt.getObject().equals(obj) && namedGraphUriset.contains(stmt.getNamedGraphUri())) {
                            matches.add(stmt);
                        }
                    }
                } else {
                    for (Statement stmt : oSet) {
                        if (stmt.getSubject().equals(subj) && namedGraphUriset.contains(stmt.getNamedGraphUri())) {
                            matches.add(stmt);
                        }
                    }
                }
                return matches;
            }
        } else {
            Collection<Statement> matches = new ArrayList<Statement>();
            if (sSet.size() < oSet.size()) {
                for (Statement stmt : sSet) {
                    if (stmt.getObject().equals(obj)) {
                        matches.add(stmt);
                    }
                }
            } else {
                for (Statement stmt : oSet) {
                    if (stmt.getSubject().equals(subj)) {
                        matches.add(stmt);
                    }
                }
            }
            return matches;
        }
    }

    /**
     * Find statements that match predicate and namedGraphURI values provided
     * 
     * @param pred
     *            predicate value to match
     * @param namedGraphUris
     *            namedGraphURI value to match, or wildcard if null
     * @return Collection<Statement> of matching statements
     */
    private Collection<Statement> findPC(URI pred, Resource... namedGraphUris) {
        Collection<Statement> pSet = predMap.get(pred);
        if (pSet == null) {
            return Collections.<Statement> emptyList();
        }
        if (namedGraphUris.length == 1) {
            Collection<Statement> gSet = namedGraphMap.get(namedGraphUris[0]);
            if (gSet == null) {
                return Collections.<Statement> emptyList();
            }
            Collection<Statement> matches = new ArrayList<Statement>();
            if (gSet.size() < pSet.size()) {
                for (Statement stmt : gSet) {
                    if (stmt.getPredicate().equals(pred)) {
                        matches.add(stmt);
                    }
                }
            } else {
                for (Statement stmt : pSet) {
                    if (stmt.getNamedGraphUri().equals(namedGraphUris[0])) {
                        matches.add(stmt);
                    }
                }
            }
            return matches;
        } else {
            Collection<Statement> matches = new ArrayList<Statement>();
            HashSet<Resource> namedGraphUriset = new HashSet<Resource>(namedGraphUris.length);
            Collections.addAll(namedGraphUriset, namedGraphUris);
            for (Statement stmt : pSet) {
                if (namedGraphUriset.contains(stmt.getNamedGraphUri())) {
                    matches.add(stmt);
                }
            }
            return matches;
        }
    }

    /**
     * Find statements that match Subject and namedGraphURI values provided
     * 
     * @param subj
     *            Subject value to match
     * @param namedGraphUris
     *            namedGraphURI value to match, or wildcard if null
     * @return Collection<Statement> of matching statements
     */
    private Collection<Statement> findSC(Resource subj, Resource... namedGraphUris) {
        Collection<Statement> sSet = subjectMap.get(subj);
        if (sSet == null) {
            return Collections.<Statement> emptyList();
        }
        if (namedGraphUris.length == 1) {
            Collection<Statement> gSet = namedGraphMap.get(namedGraphUris[0]);
            if (gSet == null) {
                return Collections.<Statement> emptyList();
            }
            Collection<Statement> matches = new ArrayList<Statement>();

            if (gSet.size() < sSet.size()) {
                for (Statement stmt : gSet) {
                    if (stmt.getSubject().equals(subj)) {
                        matches.add(stmt);
                    }
                }
            } else {
                for (Statement stmt : sSet) {
                    if (stmt.getNamedGraphUri().equals(namedGraphUris[0])) {
                        matches.add(stmt);
                    }
                }
            }
            return matches;
        } else {
            Collection<Statement> matches = new ArrayList<Statement>();
            HashSet<Resource> namedGraphUriset = new HashSet<Resource>(namedGraphUris.length);
            Collections.addAll(namedGraphUriset, namedGraphUris);
            for (Statement stmt : sSet) {
                if (namedGraphUriset.contains(stmt.getNamedGraphUri())) {
                    matches.add(stmt);
                }
            }
            return matches;
        }
    }

    /**
     * Find statements that match Subject and namedGraphURI values provided
     * 
     * @param obj
     *            Object value to match
     * @param namedGraphUris
     *            namedGraphURI value to match, or wildcard if null
     * @return Collection<Statement> of matching statements
     */
    private Collection<Statement> findOC(Value obj, Resource... namedGraphUris) {
        Collection<Statement> oSet = objMap.get(obj);
        if (oSet == null) {
            return Collections.<Statement> emptyList();
        }
        if (namedGraphUris.length == 1) {
            Collection<Statement> gSet = namedGraphMap.get(namedGraphUris[0]);
            if (gSet == null) {
                return Collections.<Statement> emptyList();
            }
            Collection<Statement> matches = new ArrayList<Statement>();
            if (gSet.size() < oSet.size()) {
                for (Statement stmt : gSet) {
                    if (stmt.getObject().equals(obj)) {
                        matches.add(stmt);
                    }
                }
            } else {
                for (Statement stmt : oSet) {
                    if (stmt.getNamedGraphUri().equals(namedGraphUris[0])) {
                        matches.add(stmt);
                    }
                }
            }
            return matches;
        } else {
            Collection<Statement> matches = new ArrayList<Statement>();
            HashSet<Resource> namedGraphUriset = new HashSet<Resource>(namedGraphUris.length);
            Collections.addAll(namedGraphUriset, namedGraphUris);
            for (Statement stmt : oSet) {
                if (namedGraphUriset.contains(stmt.getNamedGraphUri())) {
                    matches.add(stmt);
                }
            }
            return matches;
        }
    }

    /**
     * Return all statements in the store
     * 
     * @return Collection<Statement> of statements in store
     */
    public Collection<Statement> getStatements() {
        return new ArrayList<Statement>(statements);
    }

    /**
     * Tests if a statement is contained in the store.
     * 
     * @param match
     *            is the statement to be tested
     * @return boolean result to indicate if the statement was contained in store
     */
    public boolean contains(Statement match) {
        return contains(match.getSubject(), match.getPredicate(), match.getObject(), match.getNamedGraphUri());
    }

    /**
     * Tests if a statement is contained in store that match provided parameters
     * 
     * @param subj
     *            Subject value to match, or wildcard if null
     * @param pred
     *            predicate value to match, or wildcard if null
     * @param obj
     *            Object value to match, or wildcard if null
     * @param namedGraphUris
     *            namedGraphURI value to match, or wildcard if null
     * @return boolean result to indicate if the statement was contained in store
     */
    @SuppressWarnings( { "unchecked" })
    public boolean contains(Resource subj, URI pred, Value obj, URI... namedGraphUris) {
        if ((subj == null && pred == null && obj == null && namedGraphUris == null) || statements.size() == 0) {
            return (statements.size() > 0);
        }
        synchronized (this.statements) {
            if (subj != null && pred != null && obj != null && namedGraphUris != null && namedGraphUris.length == 1) {
                Statement stmt = new Statement(subj, pred, obj, namedGraphUris[0]);
                return statements.contains(stmt);
            }
            if (subj == null && pred != null && obj != null) {
                MultiMap<Value, Statement> poIndexMap = poIndex.get(pred);
                if (poIndexMap != null) {
                    Collection<Statement> map = poIndexMap.get(obj);
                    if (map != null && map.size() > 0) {
                        if (namedGraphUris != null && namedGraphUris.length > 0) {
                            Collection<Statement> gSet = null;
                            HashSet<Resource> namedGraphUriset = null;
                            if (namedGraphUris.length == 1) {
                                gSet = namedGraphMap.get(namedGraphUris[0]);
                            } else {
                                namedGraphUriset = new HashSet<Resource>(namedGraphUris.length);
                                Collections.addAll(namedGraphUriset, namedGraphUris);
                            }
                            if (gSet != null) {
                                Collection<Statement>[] set = new Collection[2];
                                set[0] = (gSet.size() < map.size()) ? gSet : map;
                                set[1] = (gSet.size() < map.size()) ? map : gSet;
                                for (Statement stmt : set[0]) {
                                    if (set[1].contains(stmt)) {
                                        return true;
                                    }
                                }
                            } else if (namedGraphUriset != null) {
                                for (Statement stmt : map) {
                                    if (namedGraphUriset.contains(stmt.getNamedGraphUri())) {
                                        return true;
                                    }
                                }
                            }
                        } else {
                            return true;
                        }
                    } else {
                        return false;
                    }
                }
            }
            if (subj != null && pred != null && obj == null) {
                MultiMap<Resource, Statement> psIndexMap = psIndex.get(pred);
                if (psIndexMap != null) {
                    Collection<Statement> map = psIndexMap.get(subj);
                    if (map != null && map.size() > 0) {
                        if (namedGraphUris != null && namedGraphUris.length > 0) {
                            Collection<Statement> gSet = null;
                            HashSet<Resource> namedGraphUriset = null;
                            if (namedGraphUris.length == 1) {
                                gSet = namedGraphMap.get(namedGraphUris[0]);
                            } else {
                                namedGraphUriset = new HashSet<Resource>(namedGraphUris.length);
                                Collections.addAll(namedGraphUriset, namedGraphUris);
                            }
                            if (gSet != null) {
                                Collection<Statement>[] set = new Collection[2];
                                set[0] = (gSet.size() < map.size()) ? gSet : map;
                                set[1] = (gSet.size() < map.size()) ? map : gSet;
                                for (Statement stmt : set[0]) {
                                    if (set[1].contains(stmt)) {
                                        return true;
                                    }
                                }
                            } else if (namedGraphUriset != null) {
                                for (Statement stmt : map) {
                                    if (namedGraphUriset.contains(stmt.getNamedGraphUri())) {
                                        return true;
                                    }
                                }
                            }
                        } else {
                            return true;
                        }
                    } else {
                        return false;
                    }
                }
            }
            Collection<Statement> sSet = (subj != null) ? subjectMap.get(subj) : statements;
            Collection<Statement> pSet = (pred != null) ? predMap.get(pred) : statements;
            Collection<Statement> oSet = (obj != null) ? objMap.get(obj) : statements;
            Collection<Statement> gSet = null;
            if (namedGraphUris != null) {
                if (namedGraphUris.length == 1) {
                    gSet = namedGraphMap.get(namedGraphUris[0]);
                    if (gSet == null) {
                        return false;
                    }
                }
            } else {
                gSet = statements;
            }
            if (sSet != null && pSet != null && oSet != null && gSet != null) {
                Collection<Statement>[] set = new Collection[4];
                set[0] = sSet;
                set[1] = pSet;
                set[2] = oSet;
                set[3] = gSet;
                Arrays.sort(set, comparator);
                if (set[0].size() == statements.size()) {
                    return true;
                } else {
                    for (Statement stmt : set[0]) {
                        if ((set[1] == statements || set[1].contains(stmt)) && (set[2] == statements || set[2].contains(stmt)) && (set[3] == statements || set[3].contains(stmt))) {
                            return true;
                        }
                    }
                }
            } else if (sSet != null && pSet != null && oSet != null && gSet == null) {
                if (namedGraphUris != null) {
                    HashSet<Resource> namedGraphUriset = new HashSet<Resource>(namedGraphUris.length);
                    Collections.addAll(namedGraphUriset, namedGraphUris);
                    Collection<Statement>[] set = new Collection[3];
                    set[0] = sSet;
                    set[1] = pSet;
                    set[2] = oSet;
                    Arrays.sort(set, comparator);
                    if (set[0].size() == statements.size()) {
                        return true;
                    } else {
                        for (Statement stmt : set[0]) {
                            if ((set[1] == statements || set[1].contains(stmt)) && (set[2] == statements || set[2].contains(stmt)) && namedGraphUriset.contains(stmt.getNamedGraphUri())) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Tests if a statement is contained in store that match provided parameters
     * 
     * @param subj
     *            Subject value to match, or wildcard if null
     * @param pred
     *            predicate value to match, or wildcard if null
     * @param obj
     *            Object value to match, or wildcard if null
     * @param namedGraphUris
     *            namedGraphURI value to match, or wildcard if null
     * @return boolean result to indicate if the statement was contained in store
     */
    @SuppressWarnings( { "unchecked" })
    public long count(Resource subj, URI pred, Value obj, URI... namedGraphUris) {
        if ((subj == null && pred == null && obj == null && namedGraphUris == null) || statements.size() == 0) {
            return statements.size();
        }
        synchronized (this.statements) {
            if (subj != null && pred != null && obj != null && namedGraphUris != null && namedGraphUris.length == 1) {
                Statement stmt = new Statement(subj, pred, obj, namedGraphUris[0]);
                return statements.contains(stmt) ? 1 : 0;
            }
            long count = 0;
            if (subj == null && pred != null && obj != null) {
                MultiMap<Value, Statement> poIndexMap = poIndex.get(pred);
                if (poIndexMap != null) {
                    Collection<Statement> map = poIndexMap.get(obj);
                    if (map != null && map.size() > 0) {
                        if (namedGraphUris != null && namedGraphUris.length > 0) {
                            Collection<Statement> gSet = null;
                            HashSet<Resource> namedGraphUriset = null;
                            if (namedGraphUris.length == 1) {
                                gSet = namedGraphMap.get(namedGraphUris[0]);
                            } else {
                                namedGraphUriset = new HashSet<Resource>(namedGraphUris.length);
                                Collections.addAll(namedGraphUriset, namedGraphUris);
                            }
                            if (gSet != null) {
                                Collection<Statement>[] set = new Collection[2];
                                set[0] = (gSet.size() < map.size()) ? gSet : map;
                                set[1] = (gSet.size() < map.size()) ? map : gSet;
                                for (Statement stmt : set[0]) {
                                    if (set[1].contains(stmt)) {
                                        count++;
                                    }
                                }
                            } else if (namedGraphUriset != null) {
                                for (Statement stmt : map) {
                                    if (namedGraphUriset.contains(stmt.getNamedGraphUri())) {
                                        count++;
                                    }
                                }
                            }
                        } else {
                            return map.size();
                        }
                    } else {
                        return 0;
                    }
                }
            }
            if (subj != null && pred != null && obj == null) {
                MultiMap<Resource, Statement> psIndexMap = psIndex.get(pred);
                if (psIndexMap != null) {
                    Collection<Statement> map = psIndexMap.get(subj);
                    if (map != null && map.size() > 0) {
                        if (namedGraphUris != null && namedGraphUris.length > 0) {
                            Collection<Statement> gSet = null;
                            HashSet<Resource> namedGraphUriset = null;
                            if (namedGraphUris.length == 1) {
                                gSet = namedGraphMap.get(namedGraphUris[0]);
                            } else {
                                namedGraphUriset = new HashSet<Resource>(namedGraphUris.length);
                                Collections.addAll(namedGraphUriset, namedGraphUris);
                            }
                            if (gSet != null) {
                                Collection<Statement>[] set = new Collection[2];
                                set[0] = (gSet.size() < map.size()) ? gSet : map;
                                set[1] = (gSet.size() < map.size()) ? map : gSet;
                                for (Statement stmt : set[0]) {
                                    if (set[1].contains(stmt)) {
                                        return count++;
                                    }
                                }
                            } else if (namedGraphUriset != null) {
                                for (Statement stmt : map) {
                                    if (namedGraphUriset.contains(stmt.getNamedGraphUri())) {
                                        return count++;
                                    }
                                }
                            }
                        } else {
                            return map.size();
                        }
                    } else {
                        return 0;
                    }
                }
            }
            Collection<Statement> sSet = (subj != null) ? subjectMap.get(subj) : statements;
            Collection<Statement> pSet = (pred != null) ? predMap.get(pred) : statements;
            Collection<Statement> oSet = (obj != null) ? objMap.get(obj) : statements;
            Collection<Statement> gSet = null;
            if (namedGraphUris != null) {
                if (namedGraphUris.length == 1) {
                    gSet = namedGraphMap.get(namedGraphUris[0]);
                    if (gSet == null) {
                        return 0;
                    }
                }
            } else {
                gSet = statements;
            }
            if (sSet != null && pSet != null && oSet != null && gSet != null) {
                Collection<Statement>[] set = new Collection[4];
                set[0] = sSet;
                set[1] = pSet;
                set[2] = oSet;
                set[3] = gSet;
                Arrays.sort(set, comparator);
                if (set[0].size() == statements.size()) {
                    return statements.size();
                } else {
                    for (Statement stmt : set[0]) {
                        if ((set[1] == statements || set[1].contains(stmt)) && (set[2] == statements || set[2].contains(stmt)) && (set[3] == statements || set[3].contains(stmt))) {
                            return count++;
                        }
                    }
                }
            } else if (sSet != null && pSet != null && oSet != null && gSet == null) {
                if (namedGraphUris != null) {
                    HashSet<Resource> namedGraphUriset = new HashSet<Resource>(namedGraphUris.length);
                    Collections.addAll(namedGraphUriset, namedGraphUris);
                    Collection<Statement>[] set = new Collection[3];
                    set[0] = sSet;
                    set[1] = pSet;
                    set[2] = oSet;
                    Arrays.sort(set, comparator);
                    if (set[0].size() == statements.size()) {
                        return statements.size();
                    } else {
                        for (Statement stmt : set[0]) {
                            if ((set[1] == statements || set[1].contains(stmt)) && (set[2] == statements || set[2].contains(stmt)) && namedGraphUriset.contains(stmt.getNamedGraphUri())) {
                                return count++;
                            }
                        }
                    }
                }
            }
            return count;
        }

    }

    /**
     * Simple comparator to sort arrays by size
     */
    private final static StmtSetComp comparator = new StmtSetComp();

    static private class StmtSetComp implements Comparator<Collection<?>> {

        public int compare(Collection<?> o1, Collection<?> o2) {
            int result = 0;
            if (o1.size() == o2.size()) {
                return result;
            }
            return (o1.size() < o2.size()) ? -1 : 1;
        }
    }

    /**
     * Clear statements and indexes from memory
     */
    public void clear() {
        synchronized (this.statements) {
            statements.clear();
            subjectMap.clear();
            predMap.clear();
            objMap.clear();
            namedGraphMap.clear();
            poIndex.clear();
            psIndex.clear();
        }
    }

    /**
     * Return the number of statements in the store
     * 
     * @return the number of statements in the store
     */
    public int size() {
        return statements.size();
    }

    /**
     * Return if store is empty
     * 
     * @return if store is empty
     */
    public boolean isEmpty() {
        return statements.isEmpty();
    }

    /* Return the number of statements in the store for given namedGraphUris
     * @param namedGraphUris to determine size of in container
     * @return the number of statements in the store for given namedGraphUris
     */
    public int size(URI... namedGraphUris) {
        int size = 0;
        for (Resource namedGraphURI : namedGraphUris) {
            Collection<Statement> stmts = namedGraphMap.get(namedGraphURI);
            if (stmts != null) {
                size += stmts.size();
            }
        }
        return size;
    }

    /**
     * Return the set of namedGraphUris contained within store
     * 
     * @return collection of namedGraphUris contained within store
     */
    public Collection<URI> getNamedGraphUris() {
        return new HashSet<URI>(namedGraphMap.keySet());
    }

    public QueryResults executeQuery(Set<URI> defaultNamedGraphsIn, Set<URI> namedGraphsIn, Set<URI> namedDatasets, String query, URI baseUri) throws AnzoException {
        try {
            HashSet<URI> defaultNamedGraphs = new HashSet<URI>(defaultNamedGraphsIn);
            HashSet<URI> namedGraphs = new HashSet<URI>(namedGraphsIn);
            if (namedDatasets != null) {
                for (URI uri : namedDatasets) {
                    for (Statement s : find(uri, Anzo.DEFAULTGRAPH, null, uri)) {
                        defaultNamedGraphs.add((URI) s.getObject());
                    }
                    for (Statement s : find(uri, Anzo.NAMEDGRAPH, null, uri)) {
                        namedGraphs.add((URI) s.getObject());
                    }
                }
            }
            // copy these since we then modify them
            UriGenerator.handleSpecialGraphUris(defaultNamedGraphs, this);
            UriGenerator.handleSpecialGraphUris(namedGraphs, this);

            return glitter.executeQuery(null, query, new DefaultQueryDataset(defaultNamedGraphs, namedGraphs), baseUri);
        } catch (ParseException e) {
            log.error(LogUtils.GLITTER_MARKER, "Error parsing query:" + query, e);
            throw new AnzoException(ExceptionConstants.CLIENT.ERROR_PARSING_QUERY, e, query);
        }
    }
}
