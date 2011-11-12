/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/QueryController.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: QueryController.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections15.BidiMap;
import org.apache.commons.collections15.MapIterator;
import org.apache.commons.collections15.OrderedMap;
import org.apache.commons.collections15.bidimap.TreeBidiMap;
import org.apache.commons.collections15.map.ListOrderedMap;
import org.openanzo.glitter.Engine;
import org.openanzo.glitter.dataset.DefaultQueryDataset;
import org.openanzo.glitter.dataset.QueryDataset;
import org.openanzo.glitter.exception.UnknownPrefixException;
import org.openanzo.glitter.syntax.abstrakt.GraphPattern;
import org.openanzo.glitter.syntax.concrete.ParseException;
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Variable;
import org.openanzo.rdf.utils.PrettyPrintable;

/**
 * The {@link QueryController} is a central point for much of the information that characterizes a parsed and prepared query. A QueryController is populated as
 * a query is parsed, and its information is used to feed other parts of the query system (e.g. the {@link RDFDataset})
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class QueryController implements QueryInformation, PrettyPrintable {
    protected URI                          baseUri          = null;

    protected java.net.URI                 baseJavaUri      = null;

    protected OrderedMap<String, URI>      prefixMap        = new ListOrderedMap<String, URI>();

    protected OrderedMap<String, URI>      queryOptions     = new ListOrderedMap<String, URI>();

    protected QueryDataset                 queryDataset;

    protected QueryDataset                 parsedDataset    = new DefaultQueryDataset();

    protected QueryResultForm              resultForm;

    protected GraphPattern                 queryPattern;

    protected QueryResults                 queryResults;

    protected SolutionGenerator            solutionGenerator;

    protected Engine                       engine;

    // query modifiers
    protected int                          limit            = -1;

    protected int                          offset           = -1;

    protected ArrayList<OrderingCondition> ordering         = new ArrayList<OrderingCondition>();

    protected boolean                      datasetFromQuery = false;

    protected boolean                      cancelled        = false;

    /**
     * Default constructor.
     */
    public QueryController() {
    }

    /**
     * @param engine
     *            the engine to set
     */
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    /**
     * @return the engine
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * Notes an {@link OrderingCondition} (expression + sort direction) found in a query in an <tt>ORDER BY</tt> clause. Note that the order that
     * {@link #addOrderingCondition(OrderingCondition)} is called is significant and should match the order the conditions are present in the query.
     * 
     * @param condition
     */
    public void addOrderingCondition(OrderingCondition condition) {
        this.ordering.add(condition);
    }

    /* (non-Javadoc)
     * @see com.ibm.adtech.glitter.query.QueryInformation#getBaseUri()
     */
    public URI getBaseUri() {
        return this.baseUri;
    }

    public int getLimit() {
        return this.limit;
    }

    /**
     * @return the queryDataset
     */
    public QueryDataset getQueryDataset() {
        return (datasetFromQuery) ? parsedDataset : queryDataset;
    }

    /**
     * @return the queryDataset
     */
    public QueryDataset getParsedQueryDataset() {
        return parsedDataset;
    }

    /**
     * @param queryDataset
     *            the queryDataset to set
     */
    public void setQueryDataset(QueryDataset queryDataset) {
        this.queryDataset = queryDataset;
    }

    public int getOffset() {
        return this.offset;
    }

    public List<OrderingCondition> getOrderingConditions() {
        return this.ordering;
    }

    public GraphPattern getQueryPattern() {
        return this.queryPattern;
    }

    public QueryResultForm getQueryResultForm() {
        return this.resultForm;
    }

    /** Pretty print options */
    static public enum QueryStringPrintOptions {
        /** Indent the query lines */
        INDENT,
        /** Use prefixes in query string */
        USE_PREFIXES,
        /** Generate new prefixes based on query string */
        GENERATE_NEW_PREFIXES,
        /** Remove unused prefixes from query */
        REMOVE_UNUSED_PREFIXES;
    }

    /**
     * Pretty print a new line
     * 
     * @param printFlags
     *            flags for printing
     * @param indentLevel
     *            level of indentation for this line
     * @param sb
     *            output builder
     */
    static public void printSeparator(EnumSet<QueryStringPrintOptions> printFlags, int indentLevel, StringBuilder sb) {
        if (printFlags.contains(QueryStringPrintOptions.INDENT)) {
            sb.append('\n');
            for (int i = 0; i < indentLevel; i++)
                sb.append('\t');
        } else {
            sb.append(' ');
        }
    }

    /**
     * Pretty print a URI
     * 
     * @param u
     *            URI to print
     * @param printFlags
     *            flags to printing
     * @param uri2prefix
     *            map of uris and prefixes
     * @param sb
     *            output builder
     */
    static private void printURI(URI u, EnumSet<QueryStringPrintOptions> printFlags, Map<String, String> uri2prefix, StringBuilder sb) {
        if (printFlags.contains(QueryStringPrintOptions.USE_PREFIXES)) {
            // first, try the whole URI
            String prefix = uri2prefix.get(u.toString());
            if (prefix != null) {
                sb.append(prefix);
                sb.append(':');
                return;
            }
            prefix = uri2prefix.get(u.getNamespace());
            if (prefix != null) {
                sb.append(prefix);
                sb.append(':');
                sb.append(u.getLocalName());
                return;
            }
        }
        sb.append('<');
        sb.append(u.toString());
        sb.append('>');
        return;
    }

    /**
     * Print a triple pattern
     * 
     * @param tpc
     *            triple pattern to print
     * @param printFlags
     *            flags to printing
     * @param uri2prefix
     *            uri prefixes
     * @param sb
     *            output builder
     */
    static public void printTriplePatternComponent(TriplePatternComponent tpc, EnumSet<QueryStringPrintOptions> printFlags, Map<String, String> uri2prefix, StringBuilder sb) {
        if (tpc instanceof URI)
            printURI((URI) tpc, printFlags, uri2prefix, sb);
        else if (tpc instanceof BlankNode)
            sb.append(tpc.toString());
        else if (tpc instanceof Literal)
            sb.append(tpc.toString());
        else if (tpc instanceof Variable)
            sb.append(tpc.toString());
        else
            sb.append(tpc.toString());
    }

    /**
     * Pretty print query string
     * 
     * @param printFlags
     *            print flags
     * @return pretty print version of query
     */
    public String prettyPrintQueryString(EnumSet<QueryStringPrintOptions> printFlags) {
        return prettyPrintQueryString(printFlags, 0);
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
        QueryResultForm queryResultForm = this.getQueryResultForm();

        StringBuilder s = new StringBuilder();

        // output the base, if any
        if (this.baseUri != null) {
            s.append("BASE <");
            s.append(this.baseUri);
            s.append(">");
            printSeparator(printFlags, 0, s);
        }
        // add prefixes for all URIs mentioned in the query

        final BidiMap<String, String> prefix2uri = new TreeBidiMap<String, String>();
        Map<String, String> uri2prefix = prefix2uri.inverseBidiMap();
        for (Entry<String, URI> e : this.prefixMap.entrySet())
            prefix2uri.put(e.getKey(), e.getValue().toString());
        for (Entry<String, URI> e : this.queryOptions.entrySet())
            prefix2uri.put(e.getKey(), e.getValue().toString());
        if (printFlags.contains(QueryStringPrintOptions.GENERATE_NEW_PREFIXES)) {
            visitURIs(new URIVisitor() {
                private int p = 0;

                public boolean visitURI(URI u) {
                    if (!prefix2uri.containsValue(u.getNamespace())) {
                        // TODO - could use next-to-last URI component to name prefix
                        while (prefix2uri.containsKey("p" + ++p))
                            ;
                        prefix2uri.put("p" + p, u.getNamespace());
                    }
                    return true;
                }
            }, false, true);
        }
        // output prefixes
        MapIterator<String, String> it = prefix2uri.mapIterator();
        while (it.hasNext()) {
            String key = it.next();
            String value = it.getValue();
            s.append("PREFIX ");
            s.append(key);
            s.append(": <");
            s.append(value);
            s.append(">");
            printSeparator(printFlags, 0, s);
        }
        this.resultForm.prettyPrintQueryPart(printFlags, startIndentLevel, uri2prefix, s);
        printSeparator(printFlags, startIndentLevel, s);
        if (isDatasetFromQuery()) {
            for (URI u : getQueryDataset().getDefaultGraphURIs()) {
                s.append("FROM ");
                printURI(u, printFlags, uri2prefix, s);
                printSeparator(printFlags, startIndentLevel, s);
            }
            for (URI u : getQueryDataset().getNamedGraphURIs()) {
                s.append("FROM NAMED ");
                printURI(u, printFlags, uri2prefix, s);
                printSeparator(printFlags, startIndentLevel, s);
            }
            for (URI u : getQueryDataset().getNamedDatasetURIs()) {
                s.append("FROM DATASET ");
                printURI(u, printFlags, uri2prefix, s);
                printSeparator(printFlags, startIndentLevel, s);
            }
        }
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
            printSeparator(printFlags, startIndentLevel, s);
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
        if (printFlags.contains(QueryStringPrintOptions.REMOVE_UNUSED_PREFIXES)) {
            String q = s.toString();
            s = new StringBuilder();
            String[] lines = q.split("\n");
            Pattern p = Pattern.compile("^PREFIX\\s*(\\w+:)", Pattern.CASE_INSENSITIVE);
            boolean first = true;
            for (String line : lines) {
                Matcher m = p.matcher(line);
                if (m.find()) {
                    Pattern prefix = Pattern.compile("\\W" + m.group(1));
                    if (prefix.split(q).length <= 2)
                        continue;
                }
                if (!first)
                    s.append('\n');
                s.append(line);
                first = false;
            }
        }
        return s.toString();
    }

    public String getQueryString(boolean includeFromClause) {
        QueryResultForm queryResultForm = this.getQueryResultForm();
        StringBuilder s = new StringBuilder(this.resultForm.toString());
        if (includeFromClause && isDatasetFromQuery()) {
            for (URI u : getQueryDataset().getDefaultGraphURIs())
                s.append(" FROM <" + u + ">");
            for (URI u : getQueryDataset().getNamedGraphURIs())
                s.append(" FROM NAMED <" + u + ">");
            for (URI u : getQueryDataset().getNamedDatasetURIs()) {
                s.append(" FROM DATASET <" + u + ">");
            }
        }
        s.append(" WHERE { ");
        s.append(this.queryPattern);
        s.append(" }");
        if (queryResultForm instanceof Projection) {
            Projection projection = (Projection) queryResultForm;
            List<Variable> vars = projection.getGroupByVariables();
            if (vars != null && !vars.isEmpty()) {
                s.append(" GROUP BY");
                for (Variable v : vars)
                    s.append(" " + v);
            }
        }

        if (this.ordering.size() > 0) {
            s.append(" ORDER BY");
            for (OrderingCondition c : this.ordering)
                s.append(" " + c.toString());
        }

        if (this.limit > -1)
            s.append(" LIMIT " + this.limit);
        if (this.offset > -1)
            s.append(" OFFSET " + this.offset);
        return s.toString();
    }

    public QueryType getQueryType() {
        if (this.resultForm instanceof Projection)
            return QueryType.SELECT;
        else if (this.resultForm instanceof Ask)
            return QueryType.ASK;
        else if (this.resultForm instanceof Construct)
            return QueryType.CONSTRUCT;
        else
            return null;
    }

    /**
     * 
     * @return Whether or not the query is ordered; i.e., if it has any {@link OrderingCondition}s
     */
    public boolean isOrdered() {
        return getOrderingConditions().size() > 0;
    }

    /**
     * @return the queryOptions
     */
    public OrderedMap<String, URI> getQueryOptions() {
        return queryOptions;
    }

    /**
     * Records a mapping from a given prefix to its {@link URI} expansion. See {@link #resolveQName(String, String)}
     * 
     * @param prefix
     * @param uri
     */
    public void mapPrefix(String prefix, URI uri) {
        if (uri.getNamespace().equals(Constants.NAMESPACES.GLITTER_QUERYOPTION_NAMESPACE)) {
            this.queryOptions.put(prefix, uri);
        } else {
            this.prefixMap.put(prefix, uri);
        }
    }

    /**
     * Fully resolves a prefixed name into the full {@link URI} that it represents
     * 
     * @param prefix
     *            The prefix part of the prefixed name (before the ':')
     * @param localPart
     *            The local name part of the prefixed name (after the ':')
     * @return A fully resolved (absolute) {@link URI}
     * @throws ParseException
     */
    public URI resolveQName(String prefix, String localPart) throws ParseException {
        return resolveQName(prefix, localPart, true);
    }

    /**
     * Resolves a prefixed name into the full {@link URI} that it represents.
     * 
     * @param prefix
     *            The prefix part of the prefixed name (before the ':')
     * @param localPart
     *            The local name part of the prefixed name (after the ':')
     * @param fullyResolve
     *            If <tt>false</tt>, simply resolve the <tt>prefix</tt>. If <tt>true</tt>, also resolve a relative URI based on our base URI. See
     *            {@link #resolveUri(String)}.
     * @return The resolved prefixed name.
     * @throws ParseException
     */
    private URI resolveQName(String prefix, String localPart, boolean fullyResolve) throws ParseException {
        URI u = this.prefixMap.get(prefix);
        if (u == null)
            throw new UnknownPrefixException(prefix);
        try {
            if (fullyResolve && baseJavaUri != null)
                return resolveUri(new java.net.URI(u.toString() + localPart));
            else
                return MemURI.create(u.toString() + localPart);
        } catch (URISyntaxException e) {
            throw new ParseException(e.getMessage());
        }
    }

    /**
     * 
     * @param u
     *            Anzo URI form of the URI to resolve.
     * @return The resolved {@link URI}.
     */
    public URI resolveUri(String u) {
        if (getBaseUri() != null) {
            java.net.URI uri = java.net.URI.create(u.toString());
            return resolveUri(uri);
        } else {
            return MemURI.create(u);
        }
    }

    /**
     * @param u
     * @return uri
     */
    public URI resolveUri(java.net.URI u) {
        if (baseJavaUri != null) {
            return MemURI.create(baseJavaUri.resolve(u));
        } else {
            return MemURI.create(u.toString());
        }
    }

    /**
     * Sets the base URI against which relative URIs are resolved.
     * 
     * @param u
     *            the bsae {@link URI}
     */
    public void setBaseUri(URI u) {
        this.baseUri = u;
        this.baseJavaUri = java.net.URI.create(u.toString());
    }

    /**
     * Sets the solution limit as given by a <tt>LIMIT</tt> clause
     * 
     * @param limit
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * Sets the offset into the solution sequence as given by a <tt>OFFSET</tt> clause
     * 
     * @param offset
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * Sets the root node in the <tt>WHERE</tt> clause of the query
     * 
     * @param pattern
     */
    public void setQueryPattern(GraphPattern pattern) {
        this.queryPattern = pattern;
    }

    /**
     * Sets the query form. One of {@link Projection}, {@link Ask}, or {@link Construct}.
     * 
     * @param resultForm
     */
    public void setQueryResultForm(QueryResultForm resultForm) {
        this.resultForm = resultForm;
    }

    /**
     * Retrieves the query results. This is only valid after {@link #setQueryResults(QueryResults)} has been called.
     * 
     * @return The {@link QueryResults}
     */
    public QueryResults getQueryResults() {
        return this.queryResults;
    }

    /**
     * Sets the results of executing the query.
     * 
     * @param queryResults
     */
    public void setQueryResults(QueryResults queryResults) {
        this.queryResults = queryResults;
    }

    public SolutionGenerator getSolutionGenerator() {
        return this.solutionGenerator;
    }

    /**
     * Sets the {@link SolutionGenerator} used for generating bindings while executing the query.
     * 
     * @param solutionGenerator
     */
    public void setSolutionGenerator(SolutionGenerator solutionGenerator) {
        this.solutionGenerator = solutionGenerator;
    }

    /**
     * 
     * @return true if the dataset (graphs) for this query came from the query itself (as opposed to the protocol / API)
     */
    public boolean isDatasetFromQuery() {
        return datasetFromQuery;
    }

    /**
     * 
     * @param datasetFromQuery
     *            true if the dataset (graphs) for this query came from the query itself (as opposed to the protocol / API)
     */
    public void setDatasetFromQuery(boolean datasetFromQuery) {
        this.datasetFromQuery = datasetFromQuery;
    }

    public void prettyPrint(StringBuilder buffer) {
        buffer.append("Query(");

        if (this.getBaseUri() != null) {
            buffer.append("BaseUri(");
            buffer.append(this.getBaseUri());
            buffer.append("), ");
        }

        Set<URI> graphs = getQueryDataset().getDefaultGraphURIs();
        if (graphs.size() > 0) {
            buffer.append("DefaultGraphs(");
            int i = 0;
            for (URI graph : graphs) {
                buffer.append(graph);
                if (++i < graphs.size())
                    buffer.append(", ");
            }
            buffer.append("), ");
        }

        Set<URI> namedGraphs = getQueryDataset().getNamedGraphURIs();
        if (namedGraphs.size() > 0) {
            buffer.append("NamedGraphs(");
            {
                int i = 0;
                for (URI graph : namedGraphs) {
                    buffer.append(graph);
                    if (++i < graphs.size())
                        buffer.append(", ");
                }
            }
            buffer.append("), ");
        }

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

    protected boolean visitURI(URIVisitor v, URI u) {
        if (u != null)
            return v.visitURI(u);
        return true;
    }

    //    private boolean visitVariable(VariableVisitor v, Variable var) {
    //        if (v != null)
    //            return v.visitVariable(var);
    //        return true;
    //    }

    protected void visitURIs(URIVisitor v, boolean includeBaseAndPrefixes, boolean includeGraphsAndDatasets) {
        if (includeBaseAndPrefixes) {
            if (!visitURI(v, this.baseUri))
                return;
            for (URI u : this.prefixMap.values())
                if (!visitURI(v, u))
                    return;
        }
        if (includeGraphsAndDatasets) {
            for (URI u : getQueryDataset().getDefaultGraphURIs())
                if (!visitURI(v, u))
                    return;
            for (URI u : getQueryDataset().getNamedGraphURIs())
                if (!visitURI(v, u))
                    return;
            for (URI u : getQueryDataset().getNamedDatasetURIs())
                if (!visitURI(v, u))
                    return;
        }
        ArrayList<QueryPart> queryParts = new ArrayList<QueryPart>();
        queryParts.add(this.resultForm);
        queryParts.add(this.queryPattern);
        queryParts.addAll(this.ordering);

        for (QueryPart part : queryParts)
            for (URI u : part.getReferencedURIs())
                if (!visitURI(v, u))
                    return;
    }

    static interface URIVisitor {
        public boolean visitURI(URI u);
    }

    static interface VariableVisitor {
        public boolean visitVariable(Variable v);
    }

    /**
     * @return the cancelled
     */
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * @param cancelled
     *            the cancelled to set
     */
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
