/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/model/Attic/IDataset.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Dec 18, 2006
 * Revision:	$Id: IDataset.java 168 2007-07-31 14:11:14Z mroy $
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
 * IDataset is an extension of IQuadStore that exposes methods needed for Dataset operations. These methods are mainly related to managing the NamedGraphs which
 * are stored within the Dataset. All quad store operations are carried out against the union of all default and named graphs. Implementations of IDataset are
 * responsible for instantiating INamedGraphs and managing their life cycles.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public interface IDataset extends IQuadStore, IStatementNotifier<IDataset> {
    /** Default dataset uri */
    //public static org.openanzo.rdf.URI defaultDatasetUri = Constants.valueFactory.createURI("http://openanzo.org/datasets/default");

    /**
     * Gets the URI of this dataset
     * 
     * @return URI of this dataset
     */
    public URI getURI();

    /**
     * Returns a named graph containing the RDF serialization of the dataset structure. Implementations should maintain this graph, so that subsequent changes
     * to the dataset are reflected in the graph instances after it is returned.
     * 
     * @return a named graph containing the RDF serialization of the dataset structure.
     */
    public INamedGraph getDatasetGraph();

    /**
     * Add a named graph to the dataset by specifying its URI. This is an optional method and implementations of IDataset that support it must have a routine
     * for creating an INamedGraph given a URI. The underlying implementation is responsible for instantiating the INamedGraph instance. If the graph already
     * exists as a default graph, that same instance will be used for both.
     * 
     * @param uri
     *            uri of graph to add
     * @return INamedGraph for given URI
     */
    public INamedGraph addNamedGraph(URI uri);

    /**
     * Set the named graphs for this dataset.
     * 
     * @param namedGraphUris
     *            set of uris for namedgraphs
     */
    public void setNamedGraphs(Set<URI> namedGraphUris);

    /**
     * Get the INamedGraph for the given URI if it is within this dataset
     * 
     * @param uri
     *            URI of INamedGraph
     * @return the INamedGraph for the given URI if it is within this dataset
     */
    public INamedGraph getNamedGraph(URI uri);

    /**
     * Return an Collection&lt;URI&gt; of the URIs for the INamedGraphs within this dataset
     * 
     * @return an Collection&lt;URI&gt; of the URIs for the INamedGraphs within this dataset
     */
    public Set<URI> getNamedGraphUris();

    /**
     * Return if this dataset contains a INamedGraph with the given URI
     * 
     * @param uri
     *            URI of INamedGraph
     * @return true if this dataset contains a INamedGraph with the given URI
     */
    public boolean containsNamedGraph(URI uri);

    /**
     * Remove the URI of an INamedGraph to include within this dataset
     * 
     * @param uri
     *            URI of namedgraph to add to this dataset
     */
    public void removeNamedGraph(URI uri);

    /**
     * Add the URI of an INamedGraph to include within this dataset's default graph. The underlying implementation is responsible for instantiating the
     * INamedGraph instance. If the graph already exists as a default graph, that same instance will be used for both.
     * 
     * @param uri
     *            URI of namedgraph to add to this dataset's default model
     * @return INamedGraph for added graph
     */
    public INamedGraph addDefaultGraph(URI uri);

    /**
     * Replace all existing graph URIs
     * 
     * @param defaultGraphUris
     */
    public void setDefaultGraphs(Set<URI> defaultGraphUris);

    /**
     * Get the INamedGraph for the given URI if it is within the default graphs
     * 
     * @param uri
     *            URI of INamedGraph
     * @return the INamedGraph for the given URI if it is within this dataset
     */
    public INamedGraph getDefaultGraph(URI uri);

    /**
     * Return an Collection&lt;URI&gt; of the URIs for the INamedGraphs within this dataset's default model
     * 
     * @return an Collection&lt;URI&gt; of the URIs for the INamedGraphs within this dataset's default model
     */
    public Set<URI> getDefaultGraphUris();

    /**
     * Return if this dataset contains a INamedGraph with the given URI in the dataset's default model
     * 
     * @param uri
     *            URI of INamedGraph
     * @return true if this dataset contains a INamedGraph with the given URI in the dataset's default model
     */
    public boolean containsDefaultGraph(URI uri);

    /**
     * Remove the URI of an INamedGraph to include within this dataset's default graph
     * 
     * @param uri
     *            URI of namedgraph to add to this dataset's default model
     */
    public void removeDefaultGraph(URI uri);

    /**
     * Return an iterator of all statements that match the pattern of subj,prop,obj If includeEntireDataset is asserted, and if namedGraphs are provided, they
     * are used to sort results, but not limit results, ie the results contains all statements that match the subj,prop,obj, with matching statements within the
     * given contexts earlier in the iterator than statements not in the provided contexts.
     * 
     * @param includeEntireDataset
     *            if true, the provided namedGraphUris are used as priority graphs to search over, but results contain all data that matches in dataset
     * @param subj
     *            Subject resource to match, or null for any
     * @param prop
     *            Predicate uri to match, or null for any
     * @param obj
     *            Object value to match, or null for any
     * @param namedGraphUris
     *            Set of contexts to search first, before searching the rest of the dataset
     * @return an iterator of all statements that match the pattern of subj,prop,obj
     */
    public Collection<Statement> find(boolean includeEntireDataset, Resource subj, URI prop, Value obj, URI... namedGraphUris);

    /**
     * Execute a SPARQL query against the data within this dataset, using the dataset's DefaultGraph and NameGraph sets
     * 
     * @param query
     *            SPARQL query string
     * @return Results of running query
     * @throws AnzoException
     */
    public QueryResults executeQuery(String query) throws AnzoException;

    /**
     * Close dataset
     * 
     * @throws AnzoException
     */
    public void close() throws AnzoException;

    /**
     * Clear all statements, graphs and default graphs from the dataset
     */
    public void clear();

}
