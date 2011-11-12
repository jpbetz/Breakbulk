/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/QueryResults.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: QueryResults.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openanzo.glitter.dataset.QueryDataset;
import org.openanzo.rdf.Bindable;
import org.openanzo.rdf.MemVariable;
import org.openanzo.rdf.Statement;

/**
 * {@link QueryResults} bundles together the result object (as given by {@link QueryResultForm#serializeResults(SolutionSet)} with the {@link QueryController}
 * that represents the parsed and prepared query.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class QueryResults implements Serializable {
    private static final long         serialVersionUID = -8795763865054482962L;

    private final Object              results;

    private final QueryDataset        queryDataset;

    private final ArrayList<Bindable> varnames;

    private final QueryType           type;

    private int                       totalSolutions   = 0;

    /**
     * Constructor.
     * 
     * @param results
     * @param controller
     * @param totalSolutions
     */
    public QueryResults(Object results, QueryController controller, int totalSolutions) {
        this.results = results;
        this.queryDataset = controller.getQueryDataset();
        this.totalSolutions = totalSolutions;
        if (controller.getQueryResultForm() instanceof Projection) {
            Projection proj = (Projection) controller.getQueryResultForm();
            varnames = new ArrayList<Bindable>();
            if (proj != null) {
                varnames.addAll(proj.getResultVariables());
            }
        } else {
            varnames = null;
        }
        if (isAskResult()) {
            this.type = QueryType.ASK;
        } else if (isSelectResult()) {
            this.type = QueryType.SELECT;
        } else if (isConstructResult()) {
            this.type = doStatementsContainQuads() ? QueryType.CONSTRUCT_QUADS : QueryType.CONSTRUCT;
        } else if (isDescribeResult()) {
            this.type = doStatementsContainQuads() ? QueryType.DESCRIBE_QUADS : QueryType.DESCRIBE;
        } else {
            this.type = null;
        }
    }

    /**
     * Constructor with parameter for binding names. If the binding names are not provided this object will attempt to infer them from the projection data in
     * the query controller.
     * 
     * @param results
     * @param controller
     * @param bindingNames
     * @param totalSolutions
     */
    public QueryResults(Object results, QueryController controller, List<String> bindingNames, int totalSolutions) {
        this(results, controller, totalSolutions);

        List<Bindable> bindables = new ArrayList<Bindable>();
        for (String binding : bindingNames) {
            bindables.add(MemVariable.createVariable(binding));
        }

        ((SolutionList) results).bindings = bindables;
    }

    /**
     * Get the query results cast to a {@link SolutionSet}.
     * 
     * @return The query results cast to a {@link SolutionSet}.
     */
    public SolutionSet getSelectResults() {
        SolutionList solution = (SolutionList) this.results;
        if (solution.bindings.isEmpty())
            solution.bindings.addAll(getBindings());
        return solution;
    }

    /**
     * Get the query results cast to a boolean.
     * 
     * @return The query results cast to a boolean.
     */
    public boolean getAskResults() {
        return (Boolean) this.results;
    }

    /**
     * Get the query results cast to a collection of triples (a graph).
     * 
     * @return The query results cast to a collection of triples (a graph).
     */
    @SuppressWarnings("unchecked")
    public Collection<Statement> getConstructResults() {
        return (Collection<Statement>) this.results;
    }

    /**
     * Get the query results cast to a collection of triples (a graph).
     * 
     * @return The query results cast to a collection of triples (a graph).
     */
    @SuppressWarnings("unchecked")
    public Collection<Statement> getDescribeResults() {
        return (Collection<Statement>) this.results;
    }

    /**
     * Get the raw results object
     * 
     * @return The raw results object.
     */
    public Object getResults() {
        return this.results;
    }

    /**
     * @return the queryDataset
     */
    public QueryDataset getQueryDataset() {
        return queryDataset;
    }

    /**
     * 
     * @return true if this was an ask query
     */
    public boolean isAskResult() {
        return this.results instanceof Boolean;
    }

    /**
     * 
     * @return true if this was a select query
     */
    public boolean isSelectResult() {
        return this.results instanceof SolutionSet;
    }

    /**
     * 
     * @return true if this was a construct query
     */
    public boolean isConstructResult() {
        return !(this.results instanceof SolutionSet) && (this.results instanceof Collection<?>);
    }

    /**
     * 
     * @return true if this was a describe query
     */
    public boolean isDescribeResult() {
        return false;
    }

    /**
     * 
     * @return true if the construct or describe results contain quads
     */
    @SuppressWarnings("unchecked")
    public boolean doStatementsContainQuads() {
        if (!(this.results instanceof SolutionSet) && (this.results instanceof Collection)) {
            for (Statement s : (Collection<Statement>) results) {
                if (s != null && s.getNamedGraphUri() != null)
                    return true;
            }
        }
        return false;
    }

    /**
     * 
     * @return the type of query for which this is the result
     */
    public QueryType getQueryType() {
        return type;
    }

    private List<Bindable> getBindings() {
        return varnames;
    }

    /**
     * @param totalSolutions
     *            the totalSolutions to set
     */
    public void setTotalSolutions(int totalSolutions) {
        this.totalSolutions = totalSolutions;
    }

    /**
     * @return the totalSolutions
     */
    public int getTotalSolutions() {
        return totalSolutions;
    }
}
