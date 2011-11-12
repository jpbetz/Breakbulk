/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/Projection.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: Projection.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.collections15.CollectionUtils;
import org.apache.commons.collections15.Transformer;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.openanzo.analysis.RequestAnalysis;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.exception.GlitterRuntimeException;
import org.openanzo.glitter.exception.UnnamedProjectionException;
import org.openanzo.glitter.expression.AggregateFunction;
import org.openanzo.glitter.query.QueryController.QueryStringPrintOptions;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.glitter.syntax.abstrakt.FunctionCall;
import org.openanzo.glitter.syntax.abstrakt.SimpleExpression;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Variable;
import org.openanzo.rdf.utils.PrettyPrinter;

/**
 * {@link Projection} handles the <tt>SELECT</tt> SPARQL query form, in which the result set is returned after being projected out to only the selected
 * variables.
 * 
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class Projection implements QueryResultForm {
    //static private Variable countVariable = MemVariable.createVariable("count");

    // these two lists are parallel. That is, projectedExpression[i] gets projected as projectedAs[i]
    private final List<Expression>          projectedExpressions;

    private final List<Variable>            projectedAs;

    private final List<Variable>            groupByVars;

    private final Map<Variable, Expression> aliasMap;

    private final boolean                   isSelectStar;

    private final boolean                   distinct;

    private final boolean                   reduced;

    private boolean                         isAggregate;

    /**
     * This constructor takes ownership of the lists passed in to it.
     * 
     * @param expressions
     *            The expressions being selected; should be filled in even if isSelectStar is true
     * @param variables
     *            The variable names for the expressions being selected
     * @param groupByVars
     *            If non-null and non-empty, solutions are generated once per unique set of values identified by these variables. Note that the presence of a
     *            single aggregate function call in <tt>expressions</tt> indicates that solutions are grouped; if an aggregate occurs and groupByVars is null or
     *            empty, then the solutions are processed as a single group.
     * @param isSelectStar
     *            If <tt>true</tt>, this is a <tt>SELECT *</tt> projection; used for serialization.
     * @param distinct
     *            If <tt>true</tt>, return only distinct resultset rows
     * @param reduced
     *            If <tt>true</tt> (and <tt>distinct</tt> is <tt>false</tt>), indicates that the implementation is free to return anywhere between 1 and the
     *            standard (algebra-defined) cardinality of each solution.
     * @throws UnnamedProjectionException
     * @throws UnnamedProjectionException
     */
    public Projection(List<Expression> expressions, List<Variable> variables, List<Variable> groupByVars, boolean isSelectStar, boolean distinct, boolean reduced) throws UnnamedProjectionException {
        this.projectedExpressions = expressions;
        this.projectedAs = variables;
        this.aliasMap = new HashMap<Variable, Expression>();
        this.groupByVars = groupByVars != null ? groupByVars : new ArrayList<Variable>();
        this.isSelectStar = isSelectStar;
        this.distinct = distinct;
        this.reduced = reduced;
        initialize();
    }

    private void initialize() throws UnnamedProjectionException {
        // determine if this is an aggregate
        if (!this.groupByVars.isEmpty()) {
            this.isAggregate = true;
        } else {
            // see if any aggregate functions are involved, which means we're grouping in one big (happy) group
            LinkedList<Expression> expressions = new LinkedList<Expression>(this.projectedExpressions);
            while (!expressions.isEmpty()) {
                Expression e = expressions.removeFirst();
                if (e instanceof FunctionCall) {
                    FunctionCall fc = (FunctionCall) e;
                    if (fc.getFunction() instanceof AggregateFunction) {
                        this.isAggregate = true;
                        break;
                    }
                    expressions.addAll(fc.getArguments());
                }
            }
        }
        // check that we have an output name for every projected expression
        if (this.projectedAs.size() < this.projectedExpressions.size())
            throw new UnnamedProjectionException(this.projectedExpressions.get(this.projectedAs.size()));
        if (this.projectedAs.size() > this.projectedExpressions.size())
            throw new GlitterRuntimeException(ExceptionConstants.GLITTER.MORE_NAMES);
        int i;
        if ((i = this.projectedAs.indexOf(null)) != -1)
            throw new UnnamedProjectionException(this.projectedExpressions.get(i));
        for (i = 0; i < this.projectedAs.size(); i++)
            this.aliasMap.put(this.projectedAs.get(i), this.projectedExpressions.get(i));
    }

    /**
     * 
     * @return Whether this projection deals with aggregated solutions
     */
    public boolean isAggregateProjection() {
        return this.isAggregate;
    }

    /**
     * 
     * @return Whether this projection eliminates duplicate result rows
     */
    public boolean isDistinct() {
        return this.distinct;
    }

    /**
     * Return true if this projection is reduced
     * 
     * @return Whether this is a <tt>REDUCED</tt> query.
     */
    public boolean isReduced() {
        return this.reduced;
    }

    /**
     * 
     * @return The list of variables that form the result columns for this projection.
     */
    public List<Variable> getResultVariables() {
        return new ArrayList<Variable>(this.projectedAs);
    }

    /**
     * 
     * @return The expressions projected from this query.
     */
    public List<Expression> getProjectedExpressions() {
        return new ArrayList<Expression>(this.projectedExpressions);
    }

    /**
     * @return The variables that contribute to the projected results.
     */
    public Set<Variable> getReferencedVariables() {
        // @@ this could be memo'ized if helpful
        HashSet<Variable> vars = new HashSet<Variable>();
        for (Expression e : this.projectedExpressions) {
            vars.addAll(e.getReferencedVariables());
        }
        return vars;
    }

    public Collection<Variable> getBindableVariables() {
        return Collections.emptyList();
    }

    public Collection<URI> getReferencedURIs() {
        HashSet<URI> uris = new HashSet<URI>();
        for (Expression e : this.projectedExpressions)
            uris.addAll(e.getReferencedURIs());
        return uris;
    }

    /**
     * 
     * @return The list of group by variables.
     */
    public List<Variable> getGroupByVariables() {
        return new ArrayList<Variable>(this.groupByVars);
    }

    public Object serializeResults(SolutionSet results) {
        return serializeResultsAsResultSet(results);
    }

    /**
     * Serializing a {@link Projection} is a no-op.
     * 
     * @param solutions
     *            The refined {@link SolutionSet}
     * @return The refined {@link SolutionSet}
     */
    private SolutionSet serializeResultsAsResultSet(SolutionSet solutions) {
        return solutions;
    }

    public SolutionSet refineSolutionsBeforeOrdering(SolutionSet results) {
        boolean isEnabled = RequestAnalysis.getAnalysisLogger().isDebugEnabled();
        long start = 0;
        if (isEnabled) {
            start = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            this.prettyPrint(sb);
            RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_Projection_refiningSolutions] [{}] {}", sb.toString(), results.size());
        }
        SolutionList projection = new SolutionList();
        if (isAggregateProjection()) {
            // Create groups based on GROUP BY variables
            HashMap<GroupKey, SolutionSet> groups = new HashMap<GroupKey, SolutionSet>();
            if (this.groupByVars == null || this.groupByVars.isEmpty()) {
                groups.put(new GroupKey(), results);
            } else {
                for (PatternSolution solution : results) {
                    GroupKey key = null;
                    try {
                        key = new GroupKey(solution);
                    } catch (ExpressionEvaluationException eee) {
                        continue;
                    }
                    if (!groups.containsKey(key))
                        groups.put(key, new SolutionList());
                    SolutionSet groupSolutions = groups.get(key);
                    groupSolutions.add(solution);
                }
            }
            // For each group, process (evaluate) the aggregates and simple variables and fill out the solution
            for (Entry<GroupKey, SolutionSet> entry : groups.entrySet()) {
                // representative has all the proper values for the GROUP BY variables
                PatternSolution representative = entry.getValue().size() > 0 ? entry.getValue().get(0) : null;
                for (int i = 0; i < this.projectedExpressions.size(); i++) {
                    Expression e = this.projectedExpressions.get(i);
                    Variable var = this.projectedAs.get(i);
                    Value val;
                    try {
                        val = e.evaluate(representative, entry.getValue());
                    } catch (ExpressionEvaluationException eee) {
                        val = null;
                    }
                    if (val != null)
                        entry.getKey().aggregateSolution.setBinding(var, val);
                }
                // @@ if we add a HAVING clause, this is where those expressions are checked to be true
                // before including this aggregate solution
                projection.add(entry.getKey().aggregateSolution);
            }
        } else {
            // Evaluate any expressions (a variable simply looks its value up in the environment)
            for (PatternSolution solution : results) {
                PatternSolutionImpl projected = new PatternSolutionImpl(solution);
                boolean keepSolution = true;
                for (int i = 0; i < this.projectedExpressions.size(); i++) {
                    Expression e = this.projectedExpressions.get(i);
                    Variable var = this.projectedAs.get(i);
                    Value val = null;
                    try {
                        val = e.evaluate(solution, null);
                    } catch (ExpressionEvaluationException eee) {
                        keepSolution = false;
                        break;
                    }
                    if (val != null)
                        projected.setBinding(var, val);
                }
                if (keepSolution)
                    projection.add(projected);
            }
        }
        if (isEnabled) {
            RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_Projection_evaluatedAndProjectedSolutions] {}:{}", projection.size(), System.currentTimeMillis() - start);
            RequestAnalysis.getAnalysisLogger().debug(LogUtils.TIMING_MARKER, "glitter_Projection_evaluatedAndProjectedSolutions,{},{}", System.currentTimeMillis() - start, projection.size());
        }
        return projection;
    }

    public SolutionSet refineSolutionsAfterOrdering(SolutionSet solutions, List<OrderingCondition> sortedByConditions) {
        SolutionList projection = new SolutionList();
        int projectedBindings = this.projectedAs.size();
        for (PatternSolution solution : solutions) {
            if (solution.size() == projectedBindings) {
                projection.add(solution);
            } else {
                PatternSolutionImpl newSolution = new PatternSolutionImpl();
                for (Variable v : this.projectedAs) {
                    Value val = solution.getBinding(v);
                    if (val != null)
                        newSolution.setBinding(v, val);
                }
                projection.add(newSolution);
            }
        }

        if (this.distinct) {
            projection = projectDistinctSolutions(projection, this.projectedExpressions, sortedByConditions);
        }

        // the solutions as we were given them may already be ordered - we need to
        // preserve that order. given that, how do we efficiently find duplicates?
        // for now, we inefficiently find duplicates :-/
        return projection;
    }

    /**
     * Project distinct solutions
     * 
     * @param projection
     * @param sortedByConditions
     * @param projectedExpressiond
     * @return distinct solutions list
     */
    public static SolutionList projectDistinctSolutions(SolutionSet projection, List<Expression> projectedExpressions, List<OrderingCondition> sortedByConditions) {
        SolutionList distinctProjection = new SolutionList();
        PatternSolution solutions[] = projection.toArray(new PatternSolution[0]);
        if (solutions.length == 1) {
            distinctProjection.add(solutions[0]);
        } else {
            boolean solutionsAreSorted = false;
            if (projectedExpressions != null && sortedByConditions != null) {
                // we only care that the solutions are sorted if the sorting conditions lead to a total order
                // on the projected solutions - this is the case if all the projected expressions are involved
                // in the sorting, and no other sorting condition pre-empts them
                int matchedExpressions = 0;
                for (OrderingCondition oc : sortedByConditions) {
                    if (projectedExpressions.contains(oc.getCondition()))
                        matchedExpressions++;
                    else
                        break;
                }
                if (matchedExpressions == projectedExpressions.size())
                    solutionsAreSorted = true;
            }
            // If you sort the solutions then you can shortcut a lot of comparisons:
            // a.) you only compare up until the other solution compares greater than you
            // But we can only do this if we don't need to maintain the order of a pre-projection sort!
            if (!solutionsAreSorted && sortedByConditions == null) {
                Arrays.sort(solutions, 0, solutions.length);
                solutionsAreSorted = true;
            }
            if (solutionsAreSorted) {
                PatternSolution current = null;
                for (int i = 0; i < solutions.length; i++) {
                    if (current == null || !current.equals(solutions[i])) {
                        distinctProjection.add(solutions[i]);
                        current = solutions[i];
                    }
                }
            } else {
                // this is the slow (n^2) way of finding dupes
                for (int i = 0; i < projection.size(); i++) {
                    boolean dupe_later = false;
                    PatternSolution pi = projection.get(i);
                    for (int j = i + 1; j < projection.size(); j++) {
                        PatternSolution pj = projection.get(j);
                        if (PatternSolutionImpl.containMatchingBindings(pj, pi)) {
                            dupe_later = true;
                            break;
                        }
                    }
                    if (!dupe_later)
                        distinctProjection.add(pi);
                }
            }
        }
        return distinctProjection;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT");
        if (this.distinct)
            builder.append(" DISTINCT");
        if (this.reduced)
            builder.append(" REDUCED");
        if (this.isSelectStar) {
            builder.append(" *");
        } else {
            for (int i = 0; i < this.projectedExpressions.size(); i++) {
                Expression e = this.projectedExpressions.get(i);
                Variable var = this.projectedAs.get(i);
                if (expressionWrapsVariable(e, var)) {
                    builder.append(" " + var);
                } else {
                    builder.append(" (");
                    builder.append(e);
                    builder.append(" AS ");
                    builder.append(var);
                    builder.append(")");
                }
            }
        }
        return builder.toString();
    }

    private boolean expressionWrapsVariable(Expression e, Variable v) {
        return e instanceof SimpleExpression && ((SimpleExpression) e).getTerm().equals(v);
    }

    public void prettyPrint(StringBuilder buffer) {
        buffer.append("Projection(");

        if (this.isDistinct())
            buffer.append("DISTINCT, ");

        if (this.isReduced())
            buffer.append("REDUCED, ");

        if (this.isSelectStar)
            buffer.append("*");
        else {
            for (int i = 0; i < this.projectedExpressions.size(); i++) {
                Expression e = this.projectedExpressions.get(i);
                Variable var = this.projectedAs.get(i);
                if (i > 0)
                    buffer.append(", ");
                if (expressionWrapsVariable(e, var)) {
                    buffer.append(PrettyPrinter.print(var));
                } else {
                    buffer.append("ProjectAs(");
                    buffer.append(PrettyPrinter.print(e));
                    buffer.append(", ");
                    buffer.append(PrettyPrinter.print(var));
                    buffer.append(")");
                }
            }
        }

        if (groupByVars != null && !groupByVars.isEmpty()) {
            buffer.append(", ");
            buffer.append("GroupBy(");
            buffer.append(StringUtils.join(CollectionUtils.collect(this.groupByVars, new Transformer<Variable, String>() {
                public String transform(Variable input) {
                    return PrettyPrinter.print(input);
                }
            }), ", "));
            buffer.append(")");
        }
        buffer.append(")");
    }

    public void prettyPrintQueryPart(EnumSet<QueryStringPrintOptions> printFlags, int indentLevel, Map<String, String> uri2prefix, StringBuilder s) {
        s.append("SELECT");
        if (this.isDistinct())
            s.append(" DISTINCT");
        if (this.isReduced())
            s.append(" REDUCED");
        if (this.isSelectStar)
            s.append(" *");
        else {
            for (int i = 0; i < this.projectedExpressions.size(); i++) {
                Expression e = this.projectedExpressions.get(i);
                Variable var = this.projectedAs.get(i);
                s.append(" ");
                if (expressionWrapsVariable(e, var)) {
                    QueryController.printTriplePatternComponent(var, printFlags, uri2prefix, s);
                } else {
                    s.append("(");
                    e.prettyPrintQueryPart(printFlags, indentLevel, uri2prefix, s);
                    s.append(" AS ");
                    QueryController.printTriplePatternComponent(var, printFlags, uri2prefix, s);
                    s.append(")");
                }
            }
        }
    }

    protected void prettyPrintGroupByQueryPart(EnumSet<QueryStringPrintOptions> printFlags, int indentLevel, Map<String, String> uri2prefix, StringBuilder s) {
        if (groupByVars != null && !groupByVars.isEmpty()) {
            s.append("GROUP BY");
            for (Variable v : this.groupByVars) {
                s.append(" ");
                QueryController.printTriplePatternComponent(v, printFlags, uri2prefix, s);
            }
        }
    }

    private class GroupKey {
        // the bindings that define the group; for a particular query, the keySet of bindings will be the same for
        // all instances of GroupKey
        private final PatternSolution     bindings;

        private final int                 hashCode;

        // each group has a single (aggregate/grouped) solution, which is maintained in the GroupKey
        private final PatternSolutionImpl aggregateSolution = new PatternSolutionImpl();

        // this constructor is for a group of all solutions
        public GroupKey() {
            this.hashCode = 0;
            this.bindings = null;
        }

        protected GroupKey(final PatternSolution bindings) {
            this.bindings = bindings;

            HashCodeBuilder builder = new HashCodeBuilder();

            for (Variable var : Projection.this.groupByVars) {
                // check if we're grouping by an alias, in which case we actually need to evalutae
                // the associated expression to find the grouping value here
                Expression e = Projection.this.aliasMap.get(var);
                Value val = null;
                if (e != null)
                    val = e.evaluate(bindings, null);
                else
                    val = bindings.getBinding(var);
                if (val != null) {
                    builder.append(val.hashCode());
                }
            }

            this.hashCode = builder.toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof GroupKey))
                return false;
            GroupKey other = (GroupKey) obj;

            if (this.hashCode == 0)
                return other.hashCode == 0;
            if (other.hashCode == 0)
                return false;

            for (Variable var : Projection.this.groupByVars) {
                Value thisTerm = this.bindings.getBinding(var);
                Value otherTerm = other.bindings.getBinding(var);
                if (thisTerm == null && otherTerm == null)
                    continue;
                else if (thisTerm == null || otherTerm == null) {
                    return false;
                } else if (!thisTerm.equals(otherTerm))
                    return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            return hashCode;
        }
    }
}
