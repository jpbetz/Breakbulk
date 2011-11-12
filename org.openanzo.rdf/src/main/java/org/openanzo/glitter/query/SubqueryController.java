/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections15.BidiMap;
import org.apache.commons.collections15.bidimap.TreeBidiMap;
import org.openanzo.glitter.Engine;
import org.openanzo.glitter.dataset.QueryDataset;
import org.openanzo.glitter.syntax.concrete.ParseException;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Variable;

/**
 * A SubqueryController specializes {@link QueryController} to be used for capturing the details of a subquery. Subqueries are more limited versions of full
 * queries - they can only be initialized from existing queries and copy things like base URI, prefix map, and dataset information from their parent.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class SubqueryController extends QueryController {
    private QueryController parent;

    /**
     * @param parent
     */
    public SubqueryController(QueryController parent) {
        this.parent = parent;
    }

    @Override
    public void setEngine(Engine engine) {
        if (engine == null || !engine.equals(getEngine()))
            throw new UnsupportedOperationException("Subqueries cannot have a different engine from the parent query.");
    }

    @Override
    public Engine getEngine() {
        return this.parent.getEngine();
    }

    @Override
    public QueryDataset getQueryDataset() {
        return parent.getQueryDataset();
    }

    @Override
    public void setQueryDataset(QueryDataset queryDataset) {
        throw new UnsupportedOperationException("Subqueries cannot set the query Dataset.");
    }

    @Override
    public void setBaseUri(URI u) {
        throw new UnsupportedOperationException("Subqueries cannot have a different base URI from the parent query.");
    }

    @Override
    public URI getBaseUri() {
        return this.parent.getBaseUri();
    }

    @Override
    public void mapPrefix(String prefix, URI uri) {
        throw new UnsupportedOperationException("Subqueries cannot have a different set of prefixes from the parent query.");
    }

    @Override
    public URI resolveQName(String prefix, String localPart) throws ParseException {
        return this.parent.resolveQName(prefix, localPart);
    }

    @Override
    public SolutionGenerator getSolutionGenerator() {
        return this.parent.getSolutionGenerator();
    }

    @Override
    public void setSolutionGenerator(SolutionGenerator solutionGenerator) {
        throw new UnsupportedOperationException("Subqueries cannot have a different solution generator from the parent query.");
    }

    @Override
    public void prettyPrint(StringBuilder buffer) {
        buffer.append("Query(");

        int limit = this.getLimit();
        if (limit > -1)
            buffer.append("LIMIT(" + limit + "), ");

        int offset = this.getOffset();
        if (offset > -1)
            buffer.append("OFFSET(" + offset + "), ");

        List<OrderingCondition> orderingConditions = this.getOrderingConditions();
        if (orderingConditions.size() > 0) {
            buffer.append("OrderBy(");
            int i = 0;
            for (OrderingCondition condition : orderingConditions) {
                condition.getCondition().prettyPrint(buffer);
                if (++i < orderingConditions.size())
                    buffer.append(", ");
            }
            buffer.append("), ");
        }

        this.getQueryResultForm().prettyPrint(buffer);
        buffer.append(", GraphPattern(");
        queryPattern.prettyPrint(buffer);
        buffer.append(")");

        buffer.append(")");
    }

    /**
     * Pretty print query string
     * 
     * @param printFlags
     *            print flags
     * @param startIndentLevel
     * @return pretty print version of query
     */
    @SuppressWarnings("all")
    public String prettyPrintQueryString(EnumSet<QueryStringPrintOptions> printFlags, int startIndentLevel) {
        StringBuilder s = new StringBuilder();
        prettyPrintQueryStringPart(printFlags, startIndentLevel, s);
        return s.toString();
    }

    /**
     * Pretty print query string
     * 
     * @param printFlags
     *            print flags
     * @param startIndentLevel
     * @return pretty print version of query
     */
    @SuppressWarnings("all")
    public void prettyPrintQueryStringPart(EnumSet<QueryStringPrintOptions> printFlags, int startIndentLevel, StringBuilder s) {
        QueryResultForm queryResultForm = this.getQueryResultForm();

        final BidiMap<String, String> prefix2uri = new TreeBidiMap<String, String>();
        Map<String, String> uri2prefix = prefix2uri.inverseBidiMap();
        for (Entry<String, URI> e : this.parent.prefixMap.entrySet())
            prefix2uri.put(e.getKey(), e.getValue().toString());
        this.resultForm.prettyPrintQueryPart(printFlags, startIndentLevel, uri2prefix, s);
        printSeparator(printFlags, startIndentLevel, s);
        s.append("WHERE {");
        printSeparator(printFlags, startIndentLevel + 1, s);
        this.queryPattern.prettyPrintQueryPart(printFlags, startIndentLevel + 1, uri2prefix, s);
        printSeparator(printFlags, startIndentLevel, s);
        s.append("}");

        if (queryResultForm instanceof Projection) {
            Projection projection = (Projection) queryResultForm;
            if (!projection.getGroupByVariables().isEmpty()) {
                printSeparator(printFlags, startIndentLevel, s);
                projection.prettyPrintGroupByQueryPart(printFlags, startIndentLevel, uri2prefix, s);
            }
        }

        if (this.ordering.size() > 0) {
            printSeparator(printFlags, 0, s);
            s.append("ORDER BY ");
            for (int i = 0; i < this.ordering.size(); i++) {
                OrderingCondition c = this.ordering.get(i);
                if (i != 0)
                    s.append(' ');
                c.prettyPrintQueryPart(printFlags, startIndentLevel, uri2prefix, s);
            }
            printSeparator(printFlags, startIndentLevel, s);
        }

        if (this.limit > -1) {
            printSeparator(printFlags, startIndentLevel, s);
            s.append("LIMIT ");
            s.append(this.limit);
        }
        if (this.offset > -1) {
            printSeparator(printFlags, startIndentLevel, s);
            s.append("OFFSET ");
            s.append(this.offset);
        }
    }

    @Override
    public String getQueryString(boolean includeFromClauses) {
        QueryResultForm queryResultForm = this.getQueryResultForm();

        StringBuilder s = new StringBuilder(this.resultForm.toString());

        s.append(" WHERE { ");
        s.append(this.queryPattern);
        s.append(" }");
        if (this.ordering.size() > 0) {
            s.append(" ORDER BY");
            for (OrderingCondition c : this.ordering)
                s.append(" " + c.getCondition());
        }

        if (queryResultForm instanceof Projection) {
            Projection projection = (Projection) queryResultForm;
            List<Variable> vars = projection.getGroupByVariables();
            if (vars != null && !vars.isEmpty()) {
                s.append(" GROUP BY");
                for (Variable v : vars)
                    s.append(" " + v);
            }
        }

        if (this.limit > -1)
            s.append(" LIMIT " + this.limit);
        if (this.offset > -1)
            s.append(" OFFSET " + this.offset);
        return s.toString();
    }

}
