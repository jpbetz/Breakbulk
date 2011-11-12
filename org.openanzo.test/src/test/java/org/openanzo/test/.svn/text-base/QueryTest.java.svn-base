/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.test;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import org.openanzo.rdf.Constants;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.URI;

/**
 * A query test against a glitter query engine
 */
public class QueryTest {
    private InputStream query;

    private InputStream data;

    private InputStream results;

    private Set<URI>    defaultGraphs;

    private Set<URI>    namedGraphs;

    private Set<URI>    namedDatasets;

    private String      base;

    private RDFFormat   resultFileFormat;

    private boolean     forceIgnoreOrder = false;

    private boolean     allowAnagrams = false;

    private Exception   expectedException;

    /**
     * Create query test
     *
     * @param query
     *            query
     * @param data
     *            data
     * @param results
     *            expected results
     */
    public QueryTest(InputStream query, InputStream data, InputStream results) {
        super();
        this.query = query;
        this.data = data;
        this.results = results;
        this.defaultGraphs = new HashSet<URI>();
        this.namedGraphs = new HashSet<URI>();
        this.namedDatasets = new HashSet<URI>();
        this.resultFileFormat = null;
    }

    /**
     * Get the default graphs used for test
     *
     * @return the default graphs used for test
     */
    public Set<URI> getDefaultGraphs() {
        return defaultGraphs;
    }

    /**
     * Set the default graphs used for test
     *
     * @param defaultGraphs
     *            the default graphs used for test
     */
    public void setDefaultGraphs(Set<URI> defaultGraphs) {
        this.defaultGraphs = defaultGraphs;
    }

    /**
     * Get the named graphs used for test
     *
     * @return the named graphs used for test
     */
    public Set<URI> getNamedGraphs() {
        return namedGraphs;
    }

    /**
     * Set the named graphs used for test
     *
     * @param namedGraphs
     *            the named graphs used for test
     */
    public void setNamedGraphs(Set<URI> namedGraphs) {
        this.namedGraphs = namedGraphs;
    }

    /**
     * Get the named datasets used for test
     *
     * @return the named datasets used for test
     */
    public Set<URI> getNamedDatasets() {
        return namedDatasets;
    }

    /**
     * Set the named datasets used for test
     *
     * @param namedDatasets
     *            the named datasets used for test
     */
    public void setNamedDatasets(Set<URI> namedDatasets) {
        this.namedDatasets = namedDatasets;
    }

    /**
     * Get the query string
     *
     * @return the query string
     */
    public InputStream getQuery() {
        return query;
    }

    /**
     * Set the query string
     *
     * @param query
     *            the query string
     */
    public void setQuery(InputStream query) {
        this.query = query;
    }

    /**
     * Get the data for the query
     *
     * @return the query data
     */
    public InputStream getData() {
        return data;
    }

    /**
     * Set the data
     *
     * @param data
     *            the data
     */
    public void setData(InputStream data) {
        this.data = data;
    }

    /**
     * Get the results data
     *
     * @return the expected results data
     */
    public InputStream getResults() {
        return results;
    }

    /**
     * Set the expected results data
     *
     * @param results
     *            the expected results data
     */
    public void setResults(InputStream results) {
        this.results = results;
    }

    /**
     * Add default graph
     *
     * @param g
     *            graph to add
     */
    public void addDefaultGraph(URI g) {
        this.defaultGraphs.add(g);
    }

    /**
     * Add named graph
     *
     * @param g
     *            namedgraph to add
     */
    public void addNamedGraph(URI g) {
        this.namedGraphs.add(g);
    }

    /**
     * Add named dataset
     *
     * @param ds
     *            named dataset
     */
    public void addNamedDataset(URI ds) {
        this.namedDatasets.add(ds);
    }

    /**
     * Add default graph
     *
     * @param g
     *            default graph
     */
    public void addDefaultGraph(String g) {
        addDefaultGraph(Constants.valueFactory.createURI(g));
    }

    /**
     * Add named graph
     *
     * @param g
     *            named graph
     */
    public void addNamedGraph(String g) {
        addNamedGraph(Constants.valueFactory.createURI(g));
    }

    /**
     * Add named dataset
     *
     * @param ds
     *            named dataset
     */
    public void addNamedDataset(String ds) {
        addNamedDataset(Constants.valueFactory.createURI(ds));
    }

    /**
     * Get base uri
     *
     * @return base uri
     */
    public String getBase() {
        return base;
    }

    /**
     * Set base uri
     *
     * @param base
     *            base uri
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     * Get the results format
     *
     * @return the results format
     */
    public RDFFormat getResultRDFFormat() {
        return resultFileFormat;
    }

    /**
     * Set the results format
     *
     * @param resultFileFormat
     *            the results format
     */
    public void setResultRDFFormat(RDFFormat resultFileFormat) {
        this.resultFileFormat = resultFileFormat;
    }

    /**
     * Set if test ignores order
     *
     * @return true if force ignore order
     */
    public boolean isForceIgnoreOrder() {
        return forceIgnoreOrder;
    }

    /**
     * Set force ignore order
     *
     * @param forceIgnoreOrder
     *            ignore order
     */
    public void setForceIgnoreOrder(boolean forceIgnoreOrder) {
        this.forceIgnoreOrder = forceIgnoreOrder;
    }

    /**
     * Set allow anagrams
     *
     * @param allowAnagrams allow anagrams of result values
     */
    public void setAllowAnagrams(boolean allowAnagrams) {
        this.allowAnagrams = allowAnagrams;
    }

    /**
     * Set if test allows anagrams of result values
     *
     * @return true if allow anagrams
     */
    public boolean isAllowAnagrams() {
        return this.allowAnagrams;
    }

    /**
     * @return true if this test expects an exception to be thrown for correctly passing.
     */
    public boolean hasExpectedException() {
        return this.expectedException != null;
    }

    /**
     * @return the expected exception of the test, if any.
     */
    public Exception getExpectedException() {
        return expectedException;
    }

    /**
     * Sets the exception expected to be thrown by executing this test.
     * @param expectedException
     */
    public void setExpectedException(Exception expectedException) {
        this.expectedException = expectedException;
    }
}
