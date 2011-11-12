/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/model/Attic/IContainer.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  5/24/2006
 * Revision:	$Id: IContainer.java 168 2007-07-31 14:11:14Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf;

import java.util.Collection;
import java.util.Set;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.glitter.query.QueryResults;

/**
 * IQuadstore is a storage container that holds quads
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public interface IQuadStore {

    /**
     * Get an iterator over all statements within this container
     * 
     * @return CloseableIterator of all statements within this container
     */
    public Collection<Statement> getStatements();

    /**
     * Return an iterator over all statements that match the pattern of subj,prop,obj
     * 
     * @param subj
     *            Subject resource to match, or wildcard if null
     * @param prop
     *            Predicate uri to match, or wildcard if null
     * @param obj
     *            Object value to match, or wildcard if null
     * @param namedGraphUri
     *            Named graph values to match, or wildcard if null
     * @return an iterator of all statements that match the pattern of subj,prop,obj,namedGraphUri
     */
    public Collection<Statement> find(Resource subj, URI prop, Value obj, URI... namedGraphUri);

    /**
     * Return true if the container contains atleast 1 statement that matches the pattern of subj,prop,obj,namedGraphUri
     * 
     * @param subj
     *            Subject resource to match, or wildcard if null
     * @param prop
     *            Predicate uri to match, or wildcard if null
     * @param obj
     *            Object value to match, or wildcard if null
     * @param namedGraphUri
     *            named graph values to match, or wildcard if null
     * @return true if the container contains atleast 1 statement that matches the pattern of subj,prop,obj
     */
    public boolean contains(Resource subj, URI prop, Value obj, URI... namedGraphUri);

    /**
     * Return true if the container contains atleast 1 statement that matches the statement provided
     * 
     * @param statement
     *            Statement to check for existence in container
     * @return true if the container contains atleast 1 statement that matches the statement provided
     */
    public boolean contains(Statement statement);

    /**
     * Add a new statement with given subj,pred,obj,namedGraphUri
     * 
     * @param subj
     *            Subject of statement
     * @param pred
     *            Predicate of statement
     * @param obj
     *            Object of statement
     * @param namedGraphUri
     *            named graph of statement
     */
    public void add(Resource subj, URI pred, Value obj, URI namedGraphUri);

    /**
     * Add a set of statements from container
     * 
     * @param statements
     *            statements to add to container
     */
    public void add(Collection<Statement> statements);

    /**
     * Add one or more statements to container
     * 
     * @param statements
     *            statements to add to container
     */
    public void add(Statement... statements);

    /**
     * Delete a statement from container
     * 
     * @param subj
     *            Subject resource to match, or wildcard if null
     * @param prop
     *            Predicate uri to match, or wildcard if null
     * @param obj
     *            Object value to match, or wildcard if null
     * @param namedGraphUri
     *            Named graph values to match, or wildcard if null
     */
    public void remove(Resource subj, URI prop, Value obj, URI... namedGraphUri);

    /**
     * Delete a set of statements from container
     * 
     * @param statements
     *            statements to delete from container
     */
    public void remove(Collection<Statement> statements);

    /**
     * Delete a set of statements from container
     * 
     * @param statements
     *            statements to delete from container
     */
    public void remove(Statement... statements);

    /**
     * Delete all statements in container
     * 
     */
    public void clear();

    /**
     * Return number of statements in container
     * 
     * @return number of statements in container
     */
    public int size();

    /**
     * Size of the given graphs
     * 
     * @param namedGraphUris
     *            graphs for which to determine size
     * @return size of the given graphs
     */
    public int size(URI... namedGraphUris);

    /**
     * Return if container is empty
     * 
     * @return true if container is empty
     */
    public boolean isEmpty();

    /**
     * Get the set of named graph URIs that are container within this Container
     * 
     * @return the set of named graph URIs that are container within this Container
     */
    public Collection<URI> getNamedGraphUris();

    /**
     * Execute a SPARQL query against the data within this container
     * 
     * @param defaultNamedGraphs
     *            Set&lt;URI&gt; of URIs for NamedGraphs that will make up the default graph for this query
     * @param namedGraphs
     *            Set&lt;URI&gt; of URIs for NamedGraphs that will make up the NamedGraphs for this query
     * @param namedDatasets
     *            Set of URIs that specify datasets that will contribute to the RDF dataset (default and named graphs) for this query
     * @param query
     *            SPARQL query string
     * @param baseUri
     *            An absolute URI against which relative URI references in the query are resolved
     * @return Results of running query
     * @throws AnzoException
     */
    public QueryResults executeQuery(Set<URI> defaultNamedGraphs, Set<URI> namedGraphs, Set<URI> namedDatasets, String query, URI baseUri) throws AnzoException;
}
