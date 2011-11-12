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
package org.openanzo.jdbc.container.query;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.Projection;
import org.openanzo.glitter.query.QueryInformation;
import org.openanzo.glitter.query.QueryType;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.jdbc.container.CoreDBConfiguration;
import org.openanzo.jdbc.container.sql.GlitterSQL;
import org.openanzo.jdbc.layout.CompositeNodeLayout;
import org.openanzo.jdbc.layout.NodeLiteralLayout;
import org.openanzo.jdbc.layout.NodeType;
import org.openanzo.jdbc.query.IRdbValue;
import org.openanzo.jdbc.query.NoSolutionsException;
import org.openanzo.jdbc.query.SQLQueryConstants;
import org.openanzo.jdbc.utils.PreparedStatementProvider;
import org.openanzo.rdf.Bindable;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.MemVariable;
import org.openanzo.rdf.TriplePattern;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Variable;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.rdf.utils.HashSetMultiHashMap;
import org.openanzo.rdf.utils.Pair;
import org.openanzo.rdf.utils.Predicate;
import org.slf4j.LoggerFactory;

/**
 * {@link AnzoBGPQuery} is a base class for Anzo Glitter implementations that share similar approaches to solving Glitter queries. (Mainly used for code
 * factoring / reuse.)
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public abstract class AnzoBGPQuery {

    static private final String                       datasetTableAlias  = "ds";

    private static final org.slf4j.Logger             log                = LoggerFactory.getLogger(AnzoBGPQuery.class);

    private final QueryInformation                    query;

    private TreeNode                                  thisNode           = null;

    private final boolean                             distinctSolutions;

    private long                                      defaultGraphs      = -1;

    /**
     * map column aliases (foo in "bar AS foo") to the bindable objects that are being selected for
     */
    private final HashMap<String, Bindable>           columnsToBindables;

    /**
     * map bindable objects to the relational columns ("table alias"."column") where it occurs
     */
    private final HashMap<Bindable, List<String>>     variableColumns;

    /**
     * map bindable objects to the relational columns ("table alias"."column") where it occurs This map is for variables in @@
     */
    private final HashMap<Bindable, List<String>>     variableColumnsExtra;

    /**
     * for each set of triple patterns, map bindable objects to the relational columns ("table alias"."column") where it occurs
     */
    private final List<Map<Bindable, List<String>>>   variableColumnsOptional;

    /**
     * keep track of the triples that will make up this query
     */
    private final ArrayList<TripleInstance>           triples;

    /**
     * keep track of the extraTriples that will make up this query
     */
    private final ArrayList<TripleInstance>           extraTriples;

    /**
     * keep track of the sets of optional triples that will make up this query
     */
    private final ArrayList<List<TripleInstance>>     optionalTriples;

    /**
     * keep track of the sets of equals bindables
     */
    private final ArrayList<Pair<Bindable, Bindable>> equalsBindables;

    /**
     * keep track of the sets of equals bindables
     */
    private final ArrayList<Pair<Bindable, Bindable>> notEqualsBindables;

    /**
     * Keep track of all the bindables in equals and notEquals
     */
    private final HashSet<Bindable>                   equalityBindables  = new HashSet<Bindable>();

    /**
     * Keep track of all the isIRI bindables in equals and notEquals
     */
    private final HashSet<Pair<Bindable, Boolean>>    isIRIBindables     = new HashSet<Pair<Bindable, Boolean>>();

    /**
     * Keep track of all the isLiteral bindables in equals and notEquals
     */
    private final HashSet<Pair<Bindable, Boolean>>    isLiteralBindables = new HashSet<Pair<Bindable, Boolean>>();

    /**
     * Keep track of all the isBlank bindables in equals and notEquals
     */
    private final HashSet<Pair<Bindable, Boolean>>    isBlankBindables   = new HashSet<Pair<Bindable, Boolean>>();

    /**
     * A set of all variables and blanknodes that occur in optional triple patterns in this query. We need this because "extra" triples that also occur in an
     * optional need to be handled as normal constraints rather than as "add-on" triples
     */
    private final HashSet<Bindable>                   allOptionalBindables;

    /**
     * Map from variable to the string to search for as a LIKE match
     */
    private final HashMap<Bindable, String>           likeMatches;

    /**
     * <tt>selectedColumns</tt> builds up a list of the bindables that are being selected "for the outside". <tt>getSQL</tt>, <tt>getExtraSQL</tt>, and
     * <tt>getOuterJoinString</tt> all add to it or modify it.
     */
    private final List<Bindable>                      selectedBindables;

    /**
     * If non-null, the name of the table that has intermediate results from a preliminary getSQL query
     */
    private String                                    temporaryTable     = null;

    /**
     * <tt>namedGraphVariable</tt> and <tt>namedGraphIRI</tt> effectively comprise a C-style union (which can itself be null)
     */
    private Variable                                  namedGraphVariable = null;

    /**
     * <tt>namedGraphVariable</tt> and <tt>namedGraphIRI</tt> effectively comprise a C-style union (which can itself be null)
     */
    private URI                                       namedGraphIRI      = null;

    private SolutionSet                               requiredBindings   = null;

    protected AnzoBGPQuery(QueryInformation qi) {
        this.query = qi;

        this.variableColumns = new HashMap<Bindable, List<String>>();
        this.columnsToBindables = new HashMap<String, Bindable>();
        this.triples = new ArrayList<TripleInstance>();
        this.variableColumnsExtra = new HashMap<Bindable, List<String>>();
        this.extraTriples = new ArrayList<TripleInstance>();
        this.variableColumnsOptional = new ArrayList<Map<Bindable, List<String>>>();
        this.optionalTriples = new ArrayList<List<TripleInstance>>();
        this.likeMatches = new HashMap<Bindable, String>();
        this.allOptionalBindables = new HashSet<Bindable>();
        this.selectedBindables = new ArrayList<Bindable>();
        this.equalsBindables = new ArrayList<Pair<Bindable, Bindable>>();
        this.notEqualsBindables = new ArrayList<Pair<Bindable, Bindable>>();

        this.distinctSolutions = this.query.getQueryType() == QueryType.SELECT && ((Projection) this.query.getQueryResultForm()).isDistinct();
    }

    // Subclasses must implement specific ways of getting connection and node layout (for ID lookup) objects
    abstract protected Connection getConnection();

    abstract protected CoreDBConfiguration getConfiguration();

    abstract protected PreparedStatementProvider getPreparedStatementProvider();

    abstract protected String getQueryHint(String tableName);

    abstract protected CompositeNodeLayout getNodeLayout();

    abstract protected String getStatementTable();

    abstract protected String getDefaultGraphsTable();

    abstract protected String getNamedGraphsTable();

    abstract protected long getNumberOfValidDefaultGraphs();

    abstract protected Collection<Long> getValidDefaultGraphs() throws AnzoException;

    abstract protected String getLiteralTable();

    abstract protected boolean bypassAcls();

    abstract protected GraphSetType getNamedGraphsType();

    abstract protected GraphSetType getDefaultGraphsType();

    /**
     * Set the TreeNode that this query is processing
     * 
     * @param node
     *            the TreeNode that this query is processing
     */
    public void setThisNode(TreeNode node) {
        this.thisNode = node;
    }

    /**
     * Set the graph variable for the current node
     * 
     * @param variable
     *            the graph variable for the current node
     */
    public void setGraphVariable(Variable variable) {
        this.namedGraphVariable = variable;
    }

    /**
     * Set the requiredBindings
     * 
     * @param requiredBindings
     */
    public void setRequiredBindings(SolutionSet requiredBindings) {
        this.requiredBindings = requiredBindings;
    }

    /**
     * Set the graph URI for the current node
     * 
     * @param uri
     *            the graph URI for the current node
     * @throws NoSolutionsException
     *             if the provided named graph URI does not exist in the system
     */
    public void setNamedGraph(URI uri) throws NoSolutionsException {
        this.namedGraphIRI = uri;
        if (!GRAPHS.ALL_NAMEDGRAPHS.equals(namedGraphIRI) && !GRAPHS.ALL_METADATAGRAPHS.equals(namedGraphIRI) && !GRAPHS.ALL_GRAPHS.equals(namedGraphIRI)) {
            long id = 0;
            if (uri instanceof IRdbValue) {
                id = ((IRdbValue) uri).getId();
                if (id != 0) {
                    return;
                } else {
                }
            } else {
                try {
                    Long lid = getNodeLayout().fetchId(Constants.valueFactory.createURI(uri.toString()), getConnection());
                    id = (lid != null) ? lid.longValue() : 0;
                } catch (AnzoException rdbe) {
                    throw new NoSolutionsException(rdbe);
                }
            }
            if (id == 0) {
                throw new NoSolutionsException();
            }
        }
    }

    /**
     * Sets the number of graphs that comprise the default graph. This provides an important optimization in certain cases when unused variables can be ignored
     * in SQL projections.
     * 
     * @param defaultGraphs
     */
    public void setDefaultGraphCount(long defaultGraphs) {
        this.defaultGraphs = defaultGraphs;
    }

    /**
     * 
     * @return how many actual graphs comprise the default graph, or -1 if unknown
     */
    public long getDefaultGraphCount() {
        return this.defaultGraphs;
    }

    /**
     * Returns the bindable object that corresponds with a specific column alias that was selected by this query
     * 
     * @param alias
     * @return
     */
    protected Bindable getBindableForAlias(String alias) {
        return columnsToBindables.get(alias);
    }

    /**
     * 
     * @return The regular triples that this BGP query handles.
     */
    public ArrayList<TripleInstance> getTriples() {
        return this.triples;
    }

    /**
     * 
     * @return The extra (attribute retrieving) triples that this BGP query handles.
     */
    public ArrayList<TripleInstance> getExtraTriples() {
        return this.extraTriples;
    }

    /**
     * 
     * @return The set of optional triples that this BGP query handles.
     */
    public ArrayList<List<TripleInstance>> getOptionalTriples() {
        return this.optionalTriples;
    }

    /**
     * Add a regular triple pattern to this query
     * 
     * @param tp
     *            triple pattern to add
     */
    public void addTriplePattern(TriplePattern tp) {
        TriplePatternComponent s = tp.getSubject(), p = tp.getPredicate(), o = tp.getObject();
        TripleInstance ti = new TripleInstance(s, p, o);
        this.triples.add(ti);
    }

    /**
     * Add an extra triple patter to this query. An extra triple pattern is any triple pattern with two or three variables, such that exactly one of the
     * variables occurs in another triple pattern and the other one or two variables only appear in this triple pattern. Usually, 'extra' triple patterns in a
     * query are used to extract properties of an object located via other parts of the query.
     * 
     * @param s
     *            Subject value or variable
     * @param p
     *            Property value or variable
     * @param o
     *            Object value or variable
     */
    public void addExtraTriplePattern(TriplePatternComponent s, TriplePatternComponent p, TriplePatternComponent o) {
        TripleInstance ti = new TripleInstance(s, p, o);
        this.extraTriples.add(ti);
    }

    /**
     * Add an pattern for the special textLike predicate
     * 
     * @param variable
     *            variable for subject of pattern
     * @param matchText
     *            string to match in like query
     */
    public void addLikeMatch(Variable variable, String matchText) {
        likeMatches.put(variable, matchText);
    }

    /**
     * Add an optional triple pattern to this query. These optional patterns are (left) joined to the results of the regular and extra pattern queries.
     * 
     * @param tp
     *            triple pattern to add
     */
    protected void addOptionalPattern(TriplePattern tp) {
        TriplePatternComponent s = tp.getSubject(), p = tp.getPredicate(), o = tp.getObject();
        TripleInstance ti = new TripleInstance(s, p, o);

        List<TripleInstance> triples = new ArrayList<TripleInstance>();
        triples.add(ti);

        // we maintain parallel structure - for each list of optional triple there is a corresponding
        // map from bindables to columns at the same index in variableColumnsOptional
        this.optionalTriples.add(triples);
        this.variableColumnsOptional.add(new HashMap<Bindable, List<String>>());

        // 2: optional triple
        catalog(ti.s, ti.tripleTableAlias + ".SUBJECT", 2);
        catalog(ti.p, ti.tripleTableAlias + ".PREDICATE", 2);
        catalog(ti.o, ti.tripleTableAlias + ".OBJECT", 2);
    }

    /**
     * Add an optional triple patterns to this query. These optional patterns are (left) joined to the results of the regular and extra pattern queries.
     * 
     * @param tps
     *            triple patterns to add
     */
    protected void addOptionalPatterns(List<TriplePattern> tps) {
        List<TripleInstance> triples = new ArrayList<TripleInstance>();
        this.optionalTriples.add(triples);
        this.variableColumnsOptional.add(new HashMap<Bindable, List<String>>());
        for (TriplePattern tp : tps) {
            TriplePatternComponent s = tp.getSubject(), p = tp.getPredicate(), o = tp.getObject();
            TripleInstance ti = new TripleInstance(s, p, o);
            triples.add(ti);
            catalog(ti.s, ti.getTripleTableAlias() + ".SUBJECT", 2);
            catalog(ti.p, ti.getTripleTableAlias() + ".PREDICATE", 2);
            catalog(ti.o, ti.getTripleTableAlias() + ".OBJECT", 2);
        }
    }

    private void populateSelectedColumnsFromMap(List<String> selectedColumns, Map<Bindable, List<String>> bindableMap, Predicate<Bindable> selectPredicate) {
        for (Entry<Bindable, List<String>> e : bindableMap.entrySet()) {
            Bindable bindable = e.getKey();
            if (!this.selectedBindables.contains(bindable) && selectPredicate.satisfies(bindable)) { // 2)
                selectedColumns.add(e.getValue().get(0) + " AS \"" + bindable2alias(bindable) + "\""); // 3)
                this.selectedBindables.add(bindable);
            }
        }
    }

    private boolean populateSelectedColumnsWithUnit(List<String> selectedColumns) {
        if (selectedColumns.size() == 0) {
            selectedColumns.add(SQLQueryConstants.glitterUnitTableColumnFull + " AS \"" + SQLQueryConstants.glitterIgnoredVariable + "\"");
            return true;
        }
        return false;
    }

    protected List<String> populateConstraintsFromTriples(List<String> constraints, Iterable<TripleInstance> triples, String alternativeColumnForNamedGraphs) throws NoSolutionsException {
        ArrayList<String> columns = new ArrayList<String>();
        if (alternativeColumnForNamedGraphs == null) {
            //We don't use a dataset table if acls are disabled, and only going against one of the all constants
            if (!bypassAcls() || (!useDefaultDataset() && getNamedGraphsType() == GraphSetType.LISTED)) {
                alternativeColumnForNamedGraphs = datasetTableAlias + ".ID";
            }
        }
        boolean hasTriples = false;
        boolean thisOne = false;
        for (TripleInstance ti : triples) {
            hasTriples = true;
            constraints.addAll(ti.getConstantRestrictions());

            //This will be true if acls are disabled, and only going against one of the all* constants
            if (alternativeColumnForNamedGraphs == null) {
                alternativeColumnForNamedGraphs = ti.getTripleTableAlias() + ".NAMEDGRAPHID";
                thisOne = true;
            }
            columns.add(ti.getTripleTableAlias() + ".NAMEDGRAPHID");

            if (!useDefaultDataset()) {
                switch (getNamedGraphsType()) {
                case ALL_GRAPHS:
                    break;
                case ALL_METADATA_GRAPHS:
                    constraints.add(ti.getTripleTableAlias() + ".METADATA = 1");
                    break;
                case ALL_NAMED_GRAPHS:
                    constraints.add(ti.getTripleTableAlias() + ".METADATA = 0");
                    break;
                }
                if (!thisOne)
                    constraints.add(ti.getTripleTableAlias() + ".NAMEDGRAPHID = " + alternativeColumnForNamedGraphs);
            }

        }
        if (hasTriples && namedGraphIRI != null)
            constraints.add(alternativeColumnForNamedGraphs + " = " + getId(namedGraphIRI));
        //If not using a dataset table because acls are disabled, and only going against one of the all* constants, then use metadata column within statements table
        if (useDefaultDataset()) {
            if (bypassAcls()) {
                switch (getDefaultGraphsType()) {
                case ALL_GRAPHS:
                    return columns;
                case ALL_METADATA_GRAPHS:
                    for (TripleInstance ti : triples) {
                        constraints.add(ti.getTripleTableAlias() + ".METADATA = 1");
                    }
                    return columns;
                case ALL_NAMED_GRAPHS:
                    for (TripleInstance ti : triples) {
                        constraints.add(ti.getTripleTableAlias() + ".METADATA = 0");
                    }
                    return columns;
                case LISTED:
                    break;
                }
            }
            if (getNumberOfValidDefaultGraphs() > 100) {
                for (TripleInstance ti : triples) {
                    constraints.add(getNamedGraphInQuery(ti.getTripleTableAlias() + ".NAMEDGRAPHID"));
                }
            } else {
                try {
                    Collection<Long> graphs = getValidDefaultGraphs();
                    StringBuilder sb = new StringBuilder();
                    for (Iterator<Long> graphsIter = graphs.iterator(); graphsIter.hasNext();) {
                        sb.append(graphsIter.next().toString());
                        if (graphsIter.hasNext()) {
                            sb.append(',');
                        }
                    }
                    String defaultGraphsSQL = "IN (" + sb.toString() + ")";
                    for (TripleInstance ti : triples) {
                        constraints.add(ti.getTripleTableAlias() + ".NAMEDGRAPHID " + defaultGraphsSQL);
                    }
                } catch (AnzoException ae) {
                    throw new NoSolutionsException(ae);
                }
            }
        }
        return columns;

    }

    protected String getNamedGraphInQuery(String columnName) {
        return columnName + " IN(SELECT ID FROM " + getDefaultGraphsTable() + ")";
    }

    protected void populateConstraintsFromMap(List<String> constraints, Map<Bindable, List<String>> bindableMap) {
        for (Entry<Bindable, List<String>> e : bindableMap.entrySet()) {
            String canonicalColumn = e.getValue().get(0);
            for (int i = 1; i < e.getValue().size(); i++)
                constraints.add(canonicalColumn + " = " + e.getValue().get(i)); // 5)
        }
    }

    static final String[] constraintName = { "TEMP_CONSTRAINT0", "TEMP_CONSTRAINT1", "TEMP_CONSTRAINT2", "TEMP_CONSTRAINT3" };

    int                   c              = 0;

    protected boolean populateRequiredBindings(List<String> constraints, Map<Bindable, List<String>> bindableMap) throws AnzoException {
        if (requiredBindings != null && requiredBindings.size() > 0) {
            HashSetMultiHashMap<Bindable, Value> values = new HashSetMultiHashMap<Bindable, Value>();
            HashMap<Bindable, Integer> valueCount = new HashMap<Bindable, Integer>();
            int requiredBindingCount = 0;

            for (PatternSolution element : requiredBindings) {
                Bindable[] bees = element.getBoundDomain(true);
                if (bees.length > 0) {
                    requiredBindingCount++;
                }
                for (Bindable bindable : bees) {
                    values.put(bindable, element.getBinding(bindable));
                    Integer i = valueCount.get(bindable);
                    valueCount.put(bindable, i != null ? i + 1 : 1);
                }
            }
            // the constraint on a particular variable/bindable is only applicable if the bindable has a value
            // in every required binding solution.
            for (Entry<Bindable, List<String>> e : bindableMap.entrySet()) {
                if (values.containsKey(e.getKey()) && valueCount.get(e.getKey()) == requiredBindingCount) {
                    StringBuilder options = new StringBuilder();
                    Collection<Value> collection = values.get(e.getKey());
                    if (collection.size() < 125) {
                        if (collection.size() > 1) {
                            for (Iterator<Value> vals = collection.iterator(); vals.hasNext();) {
                                Value val = vals.next();
                                if (val instanceof IRdbValue) {
                                    options.append(((IRdbValue) val).getId());
                                    if (vals.hasNext()) {
                                        options.append(",");
                                    }
                                } else {
                                    Long id = getNodeLayout().fetchId(val, getConnection());
                                    if (id != null) {
                                        options.append(id);
                                        if (vals.hasNext()) {
                                            options.append(",");
                                        }
                                    } else {
                                        return false;
                                    }
                                }
                            }
                            for (String columnName : e.getValue()) {
                                constraints.add(columnName + " IN (" + options.toString() + ")"); // 5)
                            }
                        } else {
                            Value val = collection.iterator().next();
                            if (val instanceof IRdbValue) {
                                for (String columnName : e.getValue()) {
                                    constraints.add(columnName + " = " + ((IRdbValue) val).getId() + ""); // 5)
                                }
                            } else {
                                Long id = getNodeLayout().fetchId(val, getConnection());
                                if (id != null) {
                                    for (String columnName : e.getValue()) {
                                        constraints.add(columnName + " = " + id + ""); // 5)
                                    }
                                } else {
                                    return false;
                                }
                            }
                        }
                    } else if (c < 4) {
                        GlitterSQL.BatchInsertIdToTempTable statement = new GlitterSQL.BatchInsertIdToTempTable(getConnection(), getPreparedStatementProvider(), getConfiguration().getSessionPrefix(), constraintName[c]);
                        for (Iterator<Value> vals = collection.iterator(); vals.hasNext();) {
                            Value val = vals.next();
                            if (val instanceof IRdbValue) {
                                statement.addEntry(((IRdbValue) val).getId());
                            } else {
                                Long id = getNodeLayout().fetchId(val, getConnection());
                                if (id != null) {
                                    statement.addEntry(id);
                                } else {
                                    return false;
                                }
                            }
                        }
                        statement.executeStatement();
                        for (String columnName : e.getValue()) {
                            constraints.add(columnName + " IN (SELECT " + getQueryHint(constraintName[c]) + " ID FROM " + getConfiguration().getSessionPrefix() + constraintName[c] + ")");
                        }
                        c++;
                        statement.close();
                    }
                }
            }
        }
        return true;
    }

    protected void populateFilterConstraintsFromMap(List<String> constraints, Map<Bindable, List<String>> bindableMap) {
        for (Pair<Bindable, Bindable> pair : equalsBindables) {
            if (bindableMap.containsKey(pair.first) && bindableMap.containsKey(pair.second)) {
                List<String> e1 = bindableMap.get(pair.first);
                List<String> e2 = bindableMap.get(pair.second);
                for (String column1 : e1) {
                    for (String column2 : e2) {
                        constraints.add(column1 + " = " + column2); // 5)
                    }
                }
            }
        }
        for (Pair<Bindable, Bindable> pair : notEqualsBindables) {
            if (bindableMap.containsKey(pair.first) && bindableMap.containsKey(pair.second)) {
                List<String> e1 = bindableMap.get(pair.first);
                List<String> e2 = bindableMap.get(pair.second);
                for (String column1 : e1) {
                    for (String column2 : e2) {
                        constraints.add(column1 + " != " + column2); // 5)
                    }
                }
            }
        }

        for (Pair<Bindable, Boolean> bindable : isIRIBindables) {
            if (bindableMap.containsKey(bindable.first)) {
                List<String> e1 = bindableMap.get(bindable.first);
                for (String column1 : e1) {
                    if (bindable.second) {
                        constraints.add("((" + column1 + " < " + NodeType.URI.getTypeMask() + " OR " + column1 + " > " + NodeType.URI.getMaxValue() + ") AND (" + column1 + " < " + NodeType.LONG_URI.getTypeMask() + " OR " + column1 + " > " + NodeType.LONG_URI.getMaxValue() + "))"); // 5)
                    } else {
                        constraints.add("((" + column1 + " > " + NodeType.URI.getTypeMask() + " AND " + column1 + " < " + NodeType.URI.getMaxValue() + ") OR (" + column1 + " > " + NodeType.LONG_URI.getTypeMask() + " AND " + column1 + " < " + NodeType.LONG_URI.getMaxValue() + "))"); // 5)
                    }
                }
            }
        }
        for (Pair<Bindable, Boolean> bindable : isLiteralBindables) {
            if (bindableMap.containsKey(bindable.first)) {
                List<String> e1 = bindableMap.get(bindable.first);
                for (String column1 : e1) {
                    if (bindable.second) {
                        constraints.add("(" + column1 + " < " + NodeType.LITERAL.getTypeMask() + " OR " + column1 + " > " + NodeType.TYPED_LONG_LITERAL.getMaxValue() + ")"); // 5)
                    } else {
                        constraints.add("(" + column1 + " > " + NodeType.LITERAL.getTypeMask() + " AND " + column1 + " < " + NodeType.TYPED_LONG_LITERAL.getMaxValue() + ")"); // 5)
                    }
                }
            }
        }
        for (Pair<Bindable, Boolean> bindable : isBlankBindables) {
            if (bindableMap.containsKey(bindable.first)) {
                List<String> e1 = bindableMap.get(bindable.first);
                for (String column1 : e1) {
                    if (bindable.second) {
                        constraints.add("(" + column1 + " < " + NodeType.BLANK.getTypeMask() + " OR " + column1 + " > " + NodeType.BLANK.getMaxValue() + ")"); // 5)
                    } else {
                        constraints.add("(" + column1 + " > " + NodeType.BLANK.getTypeMask() + " AND " + column1 + " < " + NodeType.BLANK.getMaxValue() + ")"); // 5)
                    }
                }
            }
        }
    }

    /**
     * Get the SQL string for this BGP. This can take the form of selecting variables (and blank nodes) relevant to the rest of the SPARQL query, or of
     * inserting the result set into a temporary table.
     * 
     * @param tempTable
     *            If not null, results are inserted into this temporary table
     * @return the SQL string for this query
     * @throws NoSolutionsException
     */
    protected String getSQL(String tempTable) throws NoSolutionsException, AnzoException {
        boolean insert = tempTable != null;

        if ((insert && triples.size() == 0)) {
            return null; // no rows to populate in this case
        }

        // only assign the temporary table if we're going forward to insert rows into it
        this.temporaryTable = tempTable;

        //////////////////////////////////////////////////////////////
        // SELECT clause
        //
        // 1) take all of the variables and bnodes that we've matched with
        // columns
        // 2) Omit any which do not occur outside of this BGP
        //    (where "outside of this BGP" includes the projected variables, constructed
        //     variables, described variables, etc.)
        // 3) for each, alias the first column as appropriate for the select
        // list
        // 4) If using a graph variable, include that in the list of selected
        // variables
        // 5) We always select for SQLQueryConstants.glitterUnitTableColumnFull in order that
        // we never have an empty SELECT list (unless we're inserting for later)
        // 6) If we're not already selecting it, select for any LIKE variables
        ArrayList<String> selectedColumns = new ArrayList<String>();
        populateSelectedColumnsFromMap(selectedColumns, variableColumns, new Predicate<Bindable>() {
            public boolean satisfies(Bindable b) {
                return isNeededOutsideOfSQL(b) || needsUnusedVariables();
            }
        });

        if (namedGraphVariable != null && !this.selectedBindables.contains(namedGraphVariable) && (isNeededOutsideOfSQL(namedGraphVariable) || needsUnusedVariables())) {
            //Check to see the dataset table is in use, if not, use the first triple pattern's namedgraphID as the source of the namedgraphID
            if (!bypassAcls() || (!useDefaultDataset() && getNamedGraphsType() == GraphSetType.LISTED)) {
                selectedColumns.add(datasetTableAlias + ".ID AS \"" + bindable2alias(namedGraphVariable) + "\""); // 4)
            } else {
                TripleInstance ti = triples.get(0);
                selectedColumns.add(ti.tripleTableAlias + ".NAMEDGRAPHID AS \"" + bindable2alias(namedGraphVariable) + "\""); // 4)
            }
            this.selectedBindables.add(namedGraphVariable);
        }
        ArrayList<String> tables = new ArrayList<String>();

        if (!insert) {
            if (populateSelectedColumnsWithUnit(selectedColumns)) {
                tables.add(SQLQueryConstants.glitterUnitTable); // 3)
            }
        }

        HashMap<Bindable, Integer> likeVariables = new HashMap<Bindable, Integer>(likeMatches.size());
        int likeMatchCount = 0;
        for (Bindable likeVar : likeMatches.keySet()) {
            if (!variableColumns.containsKey(likeVar) && isNeededOutsideOfSQL(likeVar)) {
                selectedColumns.add("LITERALS" + likeMatchCount + ".ID AS \"" + bindable2alias(likeVar) + "\"");
                likeVariables.put(likeVar, Integer.valueOf(likeMatchCount));
                likeMatchCount++;
            }
        }
        //////////////////////////////////////////////////////////////
        // FROM clause
        //
        // 1) if a named graph dataset, contains one instance of the named graph
        //    temp dataset table (if the default part of the dataset, the WHERE
        //    constraints will match each triple instance to an ID from the default graphs)
        // 2) contains one instance of the StatementHistory table for each
        //    triple pattern
        // 3) We always include SQLQueryConstants.glitterUnitTable which has one row and
        //    and one column and cross-joins with the rest of the result set
        //    such that it doesn't add any rows, but in the absence of any other
        //    tables we'll still get one solution. (Don't include it if we're inserting for
        //    a future query.)
        // 4) If there is a textlikematch predicate, add the anzo_l table once for each
        //Don't add the dataset table if it isn't going to be used
        if (!useDefaultDataset() && (!bypassAcls() || getNamedGraphsType() == GraphSetType.LISTED)) {
            tables.add(getNamedGraphsTable() + " " + datasetTableAlias); // 1)
        }
        for (TripleInstance ti : triples)
            tables.add(ti.getFrom()); // 2)
        //////////////////////////////////////////////////////////////
        // WHERE clause
        //
        // 1) Add all constant restrictions (IRIs or literals)
        // 2) If using a named graph, restrict each instance of the
        // triple table to the same instance of the NG table (datasetTableAlias)
        // 3) Restrict HEND as appropriate for temporal queries (or specify that it must be current)
        // 4) If using a fixed named graph, add that restriction
        // 5) Add bindable coreference restrictions
        // 6) If querying the default graph, constrain each triple instance against any one of the graphs
        // that (logically) make up the default graph
        // 7) Constrain LIKE matches appropriately (i.e. using the SQL LIKE predicate, and, if necessary,
        // matching with the canonical column for the bindable)
        ArrayList<String> clauses = new ArrayList<String>();
        List<String> columnNames = populateConstraintsFromTriples(clauses, triples, null);
        if (namedGraphVariable != null && variableColumns.containsKey(namedGraphVariable)) {
            if (!useDefaultDataset() && (!bypassAcls() || getNamedGraphsType() == GraphSetType.LISTED)) {
                variableColumns.get(namedGraphVariable).add(datasetTableAlias + ".ID");
            } else if (!useDefaultDataset() && (bypassAcls() || getNamedGraphsType() != GraphSetType.LISTED) && (!columnNames.isEmpty())) {
                variableColumns.put(namedGraphVariable, columnNames);
            }
        } else if (!columnNames.isEmpty() && !useDefaultDataset()) {
            variableColumns.put(namedGraphVariable, columnNames);
        }
        populateConstraintsFromMap(clauses, variableColumns);
        populateFilterConstraintsFromMap(clauses, variableColumns);
        if (!populateRequiredBindings(clauses, variableColumns)) {
            //A required value is not in the db, so can never be true
            return null;
        }
        if (likeMatches.size() > 0) { // 7)
            for (Map.Entry<Bindable, String> match : likeMatches.entrySet()) {
                List<String> vals = variableColumns.get(match.getKey());
                String value = match.getValue();
                if (!value.endsWith("%")) {
                    value += NodeLiteralLayout.PAD;
                }
                value = value.replace("'", "''");
                if (vals != null) {
                    String canonicalColumn = vals.get(0);
                    String literalTable = "LITERALS" + likeMatchCount;
                    clauses.add(literalTable + ".VALUE LIKE '" + value + "' AND " + literalTable + ".ID=" + canonicalColumn);
                    likeMatchCount++;
                } else if (likeVariables.containsKey(match.getKey())) {
                    Integer likeId = likeVariables.get(match.getKey());
                    clauses.add("LITERALS" + likeId + ".VALUE LIKE '" + value + "'");
                }
            }
        }
        for (int i = 0; i < likeMatchCount; i++) {
            tables.add(getLiteralTable() + " LITERALS" + i); // 4)
        }
        // put it all together
        String prefix = "";
        if (insert) {
            StringBuilder insertSQL = new StringBuilder("INSERT INTO " + tempTable + "(");
            for (int i = 0; i < selectedColumns.size(); i++) {
                insertSQL.append("C" + i);
                if (i < selectedColumns.size() - 1) {
                    insertSQL.append(",");
                }
            }
            insertSQL.append(") ");
            prefix = insertSQL.toString();
        }
        return prefix + getSQLString(selectDistinct(), selectedColumns, tables, clauses, "");
    }

    /**
     * Get the SQL string for this query for the extra triple patterns. This joins the results from the getSQL() statement, if any, and the results from the
     * extra triple patterns. If there are any optional query patterns, outer joins are added to merge those results in as well.
     * 
     * @return the SQL string for this query
     * @throws NoSolutionsException
     * @throws AnzoException
     */
    public String getExtraSQL() throws NoSolutionsException, AnzoException {
        int namedGraphVariableTemporaryColumn = this.selectedBindables.indexOf(namedGraphVariable);

        // what concrete columns (w/ aliases) will go in our SELECT clause?
        ArrayList<String> selectedColumns = new ArrayList<String>();
        // what bindables did we already select for into our temp table?
        ArrayList<Bindable> tempTableBindables = new ArrayList<Bindable>(this.selectedBindables);

        // Copy columns from the temp table to our result columns list, and stick the proper
        // column name for them in selectedColumns - take any columns that we don't need after
        // this query and skip them
        int c = 0;
        for (Bindable b : tempTableBindables) {
            if (isUsedOutsideOfQuery(b) || isOptionalBindable(b) || needsUnusedVariables()) {
                selectedColumns.add(this.temporaryTable + ".C" + c + " AS \"" + bindable2alias(b) + "\"");
            } else {
                this.selectedBindables.remove(b);
            }
            c++;
        }
        populateSelectedColumnsFromMap(selectedColumns, variableColumnsExtra, new Predicate<Bindable>() {
            public boolean satisfies(Bindable b) {
                return isUsedOutsideOfQuery(b) || needsUnusedVariables();
            }
        });
        ArrayList<String> tables = new ArrayList<String>();

        if (populateSelectedColumnsWithUnit(selectedColumns)) {
            tables.add(SQLQueryConstants.glitterUnitTable);
        }
        String graphsTableName = null;
        if (extraTriples.size() > 0 && namedGraphVariable != null && !this.selectedBindables.contains(namedGraphVariable) && (isUsedOutsideOfQuery(namedGraphVariable) || isOptionalBindable(namedGraphVariable) || needsUnusedVariables())) {
            //Again do the check to determine if a dataset graph table is being used, or to use first triple patterns namedgraphid
            if (!useDefaultDataset() && (!bypassAcls() && getNamedGraphsType() == GraphSetType.LISTED)) {
                graphsTableName = datasetTableAlias + ".ID";

            } else {
                TripleInstance ti = extraTriples.get(0);
                graphsTableName = ti.tripleTableAlias + ".NAMEDGRAPHID";
            }
            selectedColumns.add(graphsTableName + " AS \"" + bindable2alias(namedGraphVariable) + "\""); // 4)
        }
        //////////////////////////////////////////////////////////////
        // FROM clause
        //
        if (this.temporaryTable != null)
            tables.add(this.temporaryTable);
        // we need the dataset table if we didn't already select for the named graph variable in our original
        // query
        if (extraTriples.size() > 0 && !useDefaultDataset() && namedGraphVariableTemporaryColumn == -1) {
            //Don't add the dataset table to tables if it isn't beind used
            if (!bypassAcls() || getNamedGraphsType() == GraphSetType.LISTED) {
                tables.add(getNamedGraphsTable() + " " + datasetTableAlias);
            }
        }
        for (TripleInstance ti : extraTriples)
            tables.add(ti.getFrom());

        //////////////////////////////////////////////////////////////
        // WHERE clause
        //
        ArrayList<String> clauses = new ArrayList<String>();
        // We need to constrain triples either by the namedgraph table or by the already bound
        // named graphs coming from the temporary table
        populateConstraintsFromTriples(clauses, extraTriples, namedGraphVariableTemporaryColumn > -1 ? this.temporaryTable + ".C" + namedGraphVariableTemporaryColumn : null);
        if (extraTriples.size() > 0 && namedGraphVariableTemporaryColumn == -1 && (!useDefaultDataset() && (!bypassAcls() && getNamedGraphsType() == GraphSetType.LISTED)) && namedGraphVariable != null && variableColumnsExtra.containsKey(namedGraphVariable))
            variableColumnsExtra.get(namedGraphVariable).add(datasetTableAlias + ".ID");
        populateConstraintsFromMap(clauses, variableColumnsExtra);
        populateFilterConstraintsFromMap(clauses, variableColumnsExtra);
        if (!populateRequiredBindings(clauses, variableColumnsExtra)) {
            //A required value is not in the db, so can never be true
            return null;
        }
        // make sure that any variabels in both the extra triples and regular triples are constrained to match
        for (Entry<Bindable, List<String>> e : variableColumnsExtra.entrySet()) {
            int col = tempTableBindables.indexOf(e.getKey());
            if (col > -1) {
                clauses.add(this.temporaryTable + ".C" + col + "=" + e.getValue().get(0));
            }
        }
        // put it all together

        String sql = getSQLString(selectDistinct(), selectedColumns, tables, clauses, getQueryHint(this.temporaryTable));
        if (variableColumnsOptional.size() > 0) {

            for (int depth = 0; depth < this.optionalTriples.size(); depth++) {
                try {
                    String oldSql = sql;
                    sql = getOuterJoinSQL(sql, depth);
                    if (sql == null) {
                        sql = oldSql;
                    }
                } catch (NoSolutionsException nse) {
                    log.trace(LogUtils.DATASOURCE_MARKER, "No solutions found for right-hand side of OPTIONAL. Nothing to see here, move along.");
                }
            }
            return sql;
        } else {
            return sql;
        }
    }

    /**
     * This returns a new sql string, which does an outer join between a provided sql select statement, and a set of optional triple patterns
     * 
     * @param leftSideSql
     *            sql select statement text which makes up left side of join,
     * @param depth
     *            how many nested outerJoins are we currently at
     * @return new SQL string containing the join
     * @throws NoSolutionsException
     */
    private String getOuterJoinSQL(String leftSideSql, int depth) throws NoSolutionsException, AnzoException {
        // what bindables are we now selecting out to the top level (that will need to be added
        // to this.selectedBindables)?
        ArrayList<Bindable> newResultBindables = new ArrayList<Bindable>();
        // what bindables are we selecting on the RHS of out LEFT JOIN?
        ArrayList<Bindable> rightHandBindables = new ArrayList<Bindable>();
        // what concrete columns (w/ aliases) are we selecting in the RHS of the left join?
        ArrayList<String> columnsOptional = new ArrayList<String>();
        // what concrete columns (w/ aliases) are we selecting from the left joined result set?
        ArrayList<String> outerColumnsOptional = new ArrayList<String>();

        Map<Bindable, List<String>> map = variableColumnsOptional.get(depth);
        List<TripleInstance> rightSideTriples = this.optionalTriples.get(depth);
        /////////////////////////////////////
        // SELECT
        //
        // first, build the right-hand side SQL (the SQL for the optional triples)
        if (map != null) {

            for (Entry<Bindable, List<String>> e : map.entrySet()) { // 1)
                Bindable bindable = e.getKey();
                // (N.B. we don't need to check variableExtraColumns here since earlier we made sure that
                // extra triples don't include variables mentioned in OPTIONALs)
                if (variableColumns.containsKey(bindable) || isUsedOutsideOfQuery(bindable) || needsUnusedVariables()) {
                    rightHandBindables.add(bindable);
                    columnsOptional.add(e.getValue().get(0) + " AS \"" + bindable2alias(bindable) + "\""); // 2)
                    // if this isn't a variable we're already selecting from the LHS and we need it beyond this
                    // BGP+ query, then record the R## column alias to be selected out at top level
                    if (!this.selectedBindables.contains(bindable) && (isUsedOutsideOfQuery(bindable) || needsUnusedVariables())) {
                        outerColumnsOptional.add("R" + depth + ".\"" + bindable2alias(bindable) + "\""); // + "\""
                        newResultBindables.add(bindable);
                    }
                }
            }
        }
        if (namedGraphVariable != null && !rightHandBindables.contains(namedGraphVariable)) {
            rightHandBindables.add(namedGraphVariable);
            if (!useDefaultDataset() && (!bypassAcls() || getNamedGraphsType() == GraphSetType.LISTED)) {
                columnsOptional.add(datasetTableAlias + ".ID AS \"" + bindable2alias(namedGraphVariable) + "\""); // 3)
            } else if (rightSideTriples.size() > 0) {
                columnsOptional.add(rightSideTriples.get(0).tripleTableAlias + ".NAMEDGRAPHID AS \"" + bindable2alias(namedGraphVariable) + "\"");
            }
            if (!this.selectedBindables.contains(namedGraphVariable) && (isUsedOutsideOfQuery(namedGraphVariable) || needsUnusedVariables())) {
                outerColumnsOptional.add("R" + depth + ".\"" + bindable2alias(namedGraphVariable) + "\""); // + "\""
                newResultBindables.add(namedGraphVariable);
            }
        }
        /////////////////////////////////////
        // FROM
        //
        ArrayList<String> tablesOptional = new ArrayList<String>();
        if (!useDefaultDataset() && (!bypassAcls() || getNamedGraphsType() == GraphSetType.LISTED)) {
            tablesOptional.add(getNamedGraphsTable() + " " + datasetTableAlias); // 2a)
        }
        for (TripleInstance ti : rightSideTriples) {
            tablesOptional.add(ti.getFrom()); // 1)
        }
        // ////////////////////////////////////////////////////////////
        // WHERE clause
        //
        ArrayList<String> clausesOptional = new ArrayList<String>();
        ArrayList<String> clausesOptionalOuter = new ArrayList<String>();
        populateConstraintsFromTriples(clausesOptional, rightSideTriples, null);
        if (map != null) {
            if (namedGraphVariable != null && map.containsKey(namedGraphVariable) && (!bypassAcls() || getNamedGraphsType() == GraphSetType.LISTED)) {
                map.get(namedGraphVariable).add(datasetTableAlias + ".ID");
            }
            populateConstraintsFromMap(clausesOptional, map);
            if (!populateRequiredBindings(clausesOptional, map)) {
                //A required value is not in the db, so can never be true
                return null;
            }
            for (Entry<Bindable, List<String>> e : map.entrySet()) {
                // if something occurs on both the LHS and the RHS, add a top-level constraint that
                // their values be equal
                if (this.selectedBindables.contains(e.getKey())) {
                    clausesOptionalOuter.add("L" + depth + ".\"" + bindable2alias(e.getKey()) + "\"=" + "R" + depth + ".\"" + bindable2alias(e.getKey()) + "\"");
                }
            }
        }
        if (namedGraphVariable != null) {
            String condition = "L" + depth + ".\"" + bindable2alias(namedGraphVariable) + "\"=" + "R" + depth + ".\"" + bindable2alias(namedGraphVariable) + "\"";
            if (!clausesOptionalOuter.contains(condition)) {
                clausesOptionalOuter.add(condition);
            }
        }
        String sqlOptional = getSQLString(selectDistinct(), columnsOptional, tablesOptional, clausesOptional, "");

        ArrayList<String> optionalSelectedColumns = new ArrayList<String>();
        Bindable fake = MemVariable.createVariable(SQLQueryConstants.glitterIgnoredVariable);
        for (Bindable b : this.selectedBindables) {
            boolean usedInUnprocessedOptional = false;
            for (int i = depth + 1; i < variableColumnsOptional.size(); i++) {
                if (variableColumnsOptional.get(i).containsKey(b)) {
                    usedInUnprocessedOptional = true;
                    break;
                }
            }
            if (fake.equals(b) || usedInUnprocessedOptional || isUsedOutsideOfQuery(b) || needsUnusedVariables())
                optionalSelectedColumns.add("L" + depth + ".\"" + bindable2alias(b) + "\"");//
        }
        String selectOptional = "SELECT " + StringUtils.join(optionalSelectedColumns.iterator(), ", ");
        if (outerColumnsOptional.size() > 0) {
            if (optionalSelectedColumns.size() > 0)
                selectOptional += ", ";
            selectOptional += StringUtils.join(outerColumnsOptional.iterator(), ", ");
        }
        String joinCondition = clausesOptionalOuter.size() > 0 ? StringUtils.join(clausesOptionalOuter.iterator(), " AND ") : "1=1";
        selectOptional += " FROM (" + leftSideSql + ") L" + depth + " LEFT OUTER JOIN (" + sqlOptional + ") R" + depth + " ON " + joinCondition;

        this.selectedBindables.addAll(newResultBindables);
        return selectOptional;
    }

    /**
     * Records a mapping from a variable to a particular concrete column ("alias.col") for a SQL query. There is one list for each variable for regular and
     * extra triple patterns. Every set of optional patterns, however, has its own such list (as each set of optional patterns can fail on its own)
     * 
     * @param x
     *            A piece of the triple pattern. <tt>catalog</tt> only acts on it if it's a {@link Bindable} (Variable or BlankNode)
     * @param column
     *            The identifier for the concrete column that is being bound to this bindable or must match this term
     * @param type
     *            if 0, this is from a normal triple pattern; if 1, this is from an "extra" triple pattern (see addExtraTriplePattern); if 2, this is from an
     *            optional triple pattern
     */
    private void catalog(TriplePatternComponent x, String column, int type) {
        if (x instanceof Bindable) {
            List<String> columns = null;
            switch (type) {
            case 0:
                columns = variableColumns.get(x);
                break;
            case 1:
                columns = variableColumnsExtra.get(x);
                break;
            case 2:
                // catalog for optional triples is called immediately after a map was created for
                // the current set of optional triples, so we retrieve that at index .size() - 1
                allOptionalBindables.add((Bindable) x);
                Map<Bindable, List<String>> map = variableColumnsOptional.get(variableColumnsOptional.size() - 1);
                if (map == null) {
                    map = new HashMap<Bindable, List<String>>();
                    variableColumnsOptional.add(map);
                }
                columns = map.get(x);
                break;
            }
            // create a list of columns aliased to this binding if we didn't already have one
            if (columns == null) {
                columns = new ArrayList<String>();
                switch (type) {
                case 0:
                    variableColumns.put((Bindable) x, columns);
                    break;
                case 1:
                    variableColumnsExtra.put((Bindable) x, columns);
                    break;
                case 2:
                    variableColumnsOptional.get(variableColumnsOptional.size() - 1).put((Bindable) x, columns);
                    break;
                }
            }
            columns.add(column);
        }
    }

    protected void catalogTriples() {
        // catalog all extra (property-accessing) triples, but note that an extra triple
        // that is used in a LIKE or also appears in an optional triple pattern should be
        // reclassified as a normal triple
        for (Iterator<TripleInstance> tis = this.extraTriples.iterator(); tis.hasNext();) {
            TripleInstance ti = tis.next();
            if ((ti.s instanceof Bindable && (likeMatches.containsKey(ti.s) || allOptionalBindables.contains(ti.s) || equalityBindables.contains(ti.s))) || (ti.p instanceof Bindable && (likeMatches.containsKey(ti.p) || allOptionalBindables.contains(ti.p) || equalityBindables.contains(ti.p))) || (ti.o instanceof Bindable && (likeMatches.containsKey(ti.o) || allOptionalBindables.contains(ti.o) || equalityBindables.contains(ti.o)))) {
                tis.remove();
                this.triples.add(ti); // reclassify
            } else {
                // 1: extra triple
                catalog(ti.s, ti.tripleTableAlias + ".SUBJECT", 1);
                catalog(ti.p, ti.tripleTableAlias + ".PREDICATE", 1);
                catalog(ti.o, ti.tripleTableAlias + ".OBJECT", 1);
            }
        }
        for (TripleInstance ti : this.triples) {
            // 0: normal triple
            catalog(ti.s, ti.tripleTableAlias + ".SUBJECT", 0);
            catalog(ti.p, ti.tripleTableAlias + ".PREDICATE", 0);
            catalog(ti.o, ti.tripleTableAlias + ".OBJECT", 0);
        }
    }

    protected boolean useDefaultDataset() {
        return namedGraphVariable == null && namedGraphIRI == null;
    }

    protected Long getId(TriplePatternComponent tpc) throws NoSolutionsException {
        try {
            Long l = getNodeLayout().fetchId((Value) tpc, getConnection());
            if (l == null)
                throw new NoSolutionsException();
            return l;
        } catch (AnzoException rdbe) {
            throw new NoSolutionsException(rdbe);
        }
    }

    // Right now, this alias system is only used for table aliases, so we
    // don't need to maintain any state
    private int                           nextAlias = 1;

    private final HashMap<Object, String> aliases   = new HashMap<Object, String>();

    protected String getAliasFor(Object o, String prefix) {
        String alias = aliases.get(o);
        if (alias == null) {
            alias = prefix + nextAlias++;
            aliases.put(o, alias);
        }
        return alias;
    }

    private String bindable2alias(Bindable x) {
        String alias;
        if (x instanceof Variable)
            alias = ((Variable) x).getName();
        else
            alias = x.toString();
        try {
            if (alias != null && alias.getBytes(Constants.byteEncoding).length >= 30) {
                alias = getAliasFor(alias, "bind");
            }
        } catch (UnsupportedEncodingException uee) {
            log.error(LogUtils.RDB_MARKER, "Byte encoding error", uee);
            throw new RuntimeException(uee);
        }
        columnsToBindables.put(alias, x);
        return alias;
    }

    private boolean isOptionalBindable(Bindable b) {
        // check optional list
        for (Map<Bindable, List<String>> m : variableColumnsOptional) {
            if (m.containsKey(b))
                return true;
        }
        return false;
    }

    /**
     * If we're querying for distinct solutions only because the default graph (may contain/contains multiple actual graphs, then we need to select variables
     * that are otherwise unused in order to get the proper cardinalities.
     * 
     * This could be replaced with SELECT DISTINCT x, y, z, count(*) ... GROUP BY x, y, z but that requires further infrastructure updates.
     * 
     * @return
     */
    protected boolean needsUnusedVariables() {
        return selectDistinct() && !this.distinctSolutions;
    }

    private boolean selectDistinct() {
        // we select distinct if
        //  (1) the SPARQL query is distinct
        //  (2) the query is against the default dataset which has (or might have) more than 1 actual graph
        //  (eliminate false duplicates arising from querying multiple actual graphs that comprise a single logical graph)
        return this.distinctSolutions || (useDefaultDataset() && this.defaultGraphs != 1);
    }

    // @@ check for counting and/or counting distinct - need enough information preserved to get the proper
    // counts (consider GROUP BY as well)

    /**
     * Returns whether or not the given bindable is needed outside the query. We need to select this variable if it appears as an extra or optional triple
     * pattern or if it is used in a filter or anywhere outside of the node we're dealing with now (including in the query's projection)
     * 
     * @param b
     * @return
     */
    protected boolean isNeededOutsideOfSQL(Bindable b) {
        return isOptionalBindable(b) || variableColumnsExtra.containsKey(b) || isUsedOutsideOfQuery(b);
    }

    protected boolean isUsedOutsideOfQuery(Bindable b) {
        return filterReferencesBindable(b) || Glitter.isNeededOutsideOfNode(b, this.thisNode, this.query, true);
    }

    protected boolean filterReferencesBindable(Bindable b) {
        Set<Expression> exps = this.thisNode.getFilters();
        if (exps != null) {
            for (Expression e : exps) {
                if (e.getReferencedVariables().contains(b))
                    return true;
            }
        }
        return false;
    }

    private String getSQLString(boolean distinct, List<String> columns, List<String> tables, List<String> constraints, String queryHints) {
        return (distinct ? "SELECT " + queryHints + " DISTINCT " : "SELECT ") + StringUtils.join(columns.iterator(), ", ") + " FROM " + StringUtils.join(tables.iterator(), ", ") + (constraints.size() > 0 ? " WHERE " + StringUtils.join(constraints.iterator(), " AND ") : "");
    }

    /**
     * Add equals bindable
     * 
     * @param b1
     *            bindable 1
     * @param b2
     *            bindable 2
     */
    public void addEqualVariables(Bindable b1, Bindable b2) {
        equalsBindables.add(new Pair<Bindable, Bindable>(b1, b2));
        equalityBindables.add(b1);
        equalityBindables.add(b2);
    }

    /**
     * Add equals bindable
     * 
     * @param b1
     *            bindable 1
     * @param b2
     *            bindable 2
     */
    public void addNotEqualVariables(Bindable b1, Bindable b2) {
        notEqualsBindables.add(new Pair<Bindable, Bindable>(b1, b2));
        equalityBindables.add(b1);
        equalityBindables.add(b2);
    }

    /**
     * Add equals bindable
     * 
     * @param b1
     *            bindable 1
     * @param not
     */
    public void addIsIRI(Bindable b1, boolean not) {
        isIRIBindables.add(new Pair<Bindable, Boolean>(b1, not));
    }

    /**
     * Add equals bindable
     * 
     * @param b1
     *            bindable 1
     * @param not
     */
    public void addIsLiteral(Bindable b1, boolean not) {
        isLiteralBindables.add(new Pair<Bindable, Boolean>(b1, not));
    }

    /**
     * Add equals bindable
     * 
     * @param b1
     *            bindable 1
     * @param not
     */
    public void addIsBlank(Bindable b1, boolean not) {
        isBlankBindables.add(new Pair<Bindable, Boolean>(b1, not));
    }

    /**
     * A TripleInstance represents one triple pattern that is going into an SQL query. It receives its own alias of the STATEMENTS table and can produce WHERE
     * clause restrictions for non-bindable parts of the triple pattern.
     * 
     * @author lee <lee@cambridgesemantics.com>
     * 
     */
    protected class TripleInstance {
        protected final String tripleTableAlias;

        protected final TriplePatternComponent s, p, o;

        protected TripleInstance(TriplePatternComponent s, TriplePatternComponent p, TriplePatternComponent o) {
            this.s = s;
            this.p = p;
            this.o = o;
            this.tripleTableAlias = getAliasFor(this, "tp");
        }

        public String getFrom() {
            return getStatementTable() + " " + this.tripleTableAlias;
        }

        private void addRestrictionIfConstant(TriplePatternComponent tpc, String column, ArrayList<String> clauses) throws NoSolutionsException {
            if (!(tpc instanceof Bindable))
                clauses.add(column + "=" + getId(tpc));
        }

        public ArrayList<String> getConstantRestrictions() throws NoSolutionsException {
            ArrayList<String> clauses = new ArrayList<String>();
            addRestrictionIfConstant(this.s, this.tripleTableAlias + ".SUBJECT", clauses);
            addRestrictionIfConstant(this.p, this.tripleTableAlias + ".PREDICATE", clauses);
            addRestrictionIfConstant(this.o, this.tripleTableAlias + ".OBJECT", clauses);
            return clauses;
        }

        public String getTripleTableAlias() {
            return this.tripleTableAlias;
        }
    }
}

/**
 * if (!bypassAcls() || ) { !bypassAcls() = (!useDefaultDataset() && getNamedGraphsType() == GraphSetType.LISTED) = (Is in graph clause) AND (Going against a
 * list of named graphs)
 */
