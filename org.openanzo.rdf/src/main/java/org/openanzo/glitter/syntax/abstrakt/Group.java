/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/syntax/abstrakt/Group.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: Group.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.syntax.abstrakt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.collections15.MultiMap;
import org.apache.commons.collections15.multimap.MultiHashMap;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.exception.GlitterRuntimeException;
import org.openanzo.glitter.query.QueryController;
import org.openanzo.glitter.query.QueryController.QueryStringPrintOptions;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Variable;

/**
 * A group represents an ordered collection of graph patterns delimited by curly braces in a SPARQL query. A group also contains a set of filters that apply to
 * the bindings generated from the patterns within the group.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class Group extends GraphPattern {

    private ArrayList<GraphPattern>            patterns;

    private HashSet<Expression>                filters;

    private MultiHashMap<Variable, Expression> assignments;

    @Override
    public Group clone() {
        ArrayList<GraphPattern> gps = new ArrayList<GraphPattern>();
        for (GraphPattern gp : this.patterns)
            gps.add((GraphPattern) gp.clone());
        return new Group(gps, this.filters, this.assignments);
    }

    /**
     * Default constructor.
     */
    public Group() {
        this.patterns = new ArrayList<GraphPattern>();
        this.filters = new HashSet<Expression>();
        this.assignments = new MultiHashMap<Variable, Expression>();
    }

    /**
     * Construct a group from a list of patterns and a set of filter expressions.
     * 
     * @param patterns
     * @param filters
     * @param assignments
     */
    @SuppressWarnings("unchecked")
    public Group(ArrayList<GraphPattern> patterns, HashSet<Expression> filters, MultiHashMap<Variable, Expression> assignments) {
        this.patterns = new ArrayList<GraphPattern>();
        for (GraphPattern gp : patterns) {
            this.patterns.add((GraphPattern) gp.clone());
        }
        this.filters = (HashSet<Expression>) filters.clone();
        this.assignments = (MultiHashMap<Variable, Expression>) assignments.clone();
        for (GraphPattern gp : this.patterns)
            gp.setParent(this);
    }

    /**
     * Construct a group with no filters from a list of graph patterns.
     * 
     * @param patterns
     *            graph patterns to add to group
     */
    public Group(ArrayList<GraphPattern> patterns) {
        this.patterns = new ArrayList<GraphPattern>();
        for (GraphPattern gp : patterns) {
            this.patterns.add((GraphPattern) gp.clone());
        }
        this.filters = new HashSet<Expression>();
        this.assignments = new MultiHashMap<Variable, Expression>();
        for (GraphPattern gp : this.patterns)
            gp.setParent(this);
    }

    /**
     * Remove the given filter from this group.
     * 
     * @param f
     *            expression to remove from group
     * @return true if given filter was removed from this group.
     */
    public boolean removeFilter(Expression f) {
        invalidateCache();
        return this.filters.remove(f);
    }

    /**
     * Remove all filters from this group.
     */
    private void removeAllFilters() {
        invalidateCache();
        this.filters.clear();
    }

    /**
     * Add the given filter to this group.
     * 
     * @param f
     *            expression to add group
     */
    public void addFilter(Expression f) {
        this.filters.add(f);
        invalidateCache();
    }

    @Override
    public Set<Expression> getFilters() {
        return this.filters;
    }

    /**
     * Remove the given assignment (variable, expression) pair from this group.
     * 
     * @param v
     * @param e
     * 
     * @return true if given assignment was removed from this group.
     */
    public boolean removeAssignment(Variable v, Expression e) {
        invalidateCache();
        return this.assignments.remove(v, e) != null;
    }

    /**
     * Removes all assignments to a given variable attached to this group
     * 
     * @param v
     * @return true if any assignments were removed from this group
     */
    public boolean removeVariableAssignments(Variable v) {
        invalidateCache();
        return this.assignments.remove(v) != null;
    }

    /**
     * Remove all assignments from this group.
     */
    private void removeAllAssignments() {
        invalidateCache();
        this.assignments.clear();
    }

    /**
     * Add the given assignment to this group.
     * 
     * @param v
     * @param e
     *            the variable and expression to add as an assignment
     */
    public void addAssignment(Variable v, Expression e) {
        invalidateCache();
        this.assignments.put(v, e);
    }

    /**
     * 
     * @return The assignments associated with this group.
     */
    public MultiMap<Variable, Expression> getAssignments() {
        return this.assignments;
    }

    /**
     * Removes the given graph pattern from this group.
     * 
     * @param gp
     *            graph pattern to remove from group
     * @return true if given patern was removed from the group
     */
    public boolean removeGraphPattern(GraphPattern gp) {
        boolean b = this.patterns.remove(gp);
        if (b)
            gp.setParent(null);
        return b;
    }

    /**
     * Adds the given graph pattern to this group.
     * 
     * @param gp
     *            graph pattern to add to group
     */
    public void addGraphPattern(GraphPattern gp) {
        this.patterns.add(gp);
        gp.setParent(this);
    }

    /**
     * Add all the graph patterns from another {@link Group} to this group.
     * 
     * @param other
     *            source group from which all patterns will be added to this group
     */
    public void addPatternsFrom(Group other) {
        for (GraphPattern gp : other.getPatterns())
            this.addGraphPattern(gp);
    }

    /**
     * Get an iterable collection of this group's graph patterns
     * 
     * @return an iterable collection of this group's graph patterns
     */
    public Collection<GraphPattern> getPatterns() {
        return this.patterns;
    }

    /**
     * Transforms the current patterns that comprise this group into the first parameter to an {@link Optional} construct, with <tt>mayMatch</tt> as the second.
     * Replaces those patterns with the optional as the only pattern in this group.
     * 
     * @param mayMatch
     *            The optional part of the new optional.
     */
    public void replaceCurrentContentsWithOptional(Group mayMatch) {
        /*
        		Optional opt = null;
        		if (this.patterns.size() > 0) {
        			opt = new Optional(this.patterns.get(this.patterns.size() - 1), mayMatch, mayMatch.getFilters());
        			this.patterns.remove(this.patterns.size() - 1);
        			mayMatch.removeAllFilters();
        		} else {
        			opt = new Optional(mayMatch);
        		}
        		addGraphPattern(opt);
        */
        // if we don't have any patterns yet, just add in an optional
        Optional opt = null;
        if (this.patterns.size() == 0) {
            opt = new Optional(mayMatch);
        } else {
            // filters & assignments must stay attached to the current group, not to the group inside the optional
            Group mustMatch = this.clone();
            mustMatch.removeAllFilters();
            mustMatch.removeAllAssignments();
            opt = new Optional(mustMatch, mayMatch, mayMatch.getFilters());
            mayMatch.removeAllFilters();
            this.patterns = new ArrayList<GraphPattern>();
        }

        // add in the optional
        addGraphPattern(opt);
    }

    public void prettyPrintQueryPart(EnumSet<QueryStringPrintOptions> printFlags, int indentLevel, Map<String, String> uri2prefix, StringBuilder s) {
        for (int i = 0; i < this.patterns.size(); i++) {
            if (i > 0) {
                if (patterns.get(i - 1) instanceof BGP) {
                    s.append(". ");
                }
                QueryController.printSeparator(printFlags, indentLevel, s);
            }
            GraphPattern gp = this.patterns.get(i);
            if (gp instanceof Group) {
                s.append("{");
                indentLevel++;
                QueryController.printSeparator(printFlags, indentLevel, s);
            }
            gp.prettyPrintQueryPart(printFlags, indentLevel, uri2prefix, s);
            if (gp instanceof Group) {
                indentLevel--;
                QueryController.printSeparator(printFlags, indentLevel, s);
                s.append("}");
            }
        }
        if (assignments.size() > 0) {
            for (Entry<Variable, Collection<Expression>> assignment : assignments.entrySet()) {
                Variable v = assignment.getKey();
                for (Expression e : assignment.getValue()) {
                    QueryController.printSeparator(printFlags, indentLevel, s);
                    s.append(" LET (");
                    s.append(v.toString());
                    s.append(" := ");
                    e.prettyPrintQueryPart(printFlags, indentLevel, uri2prefix, s);
                    s.append(")");
                }
            }
        }
        if (filters.size() > 0) {
            for (Expression filter : filters) {
                QueryController.printSeparator(printFlags, indentLevel, s);
                s.append("FILTER (");
                filter.prettyPrintQueryPart(printFlags, indentLevel, uri2prefix, s);
                s.append(")");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        //builder.append("{ ");
        for (int i = 0; i < this.patterns.size(); i++) {
            if (i > 0)
                builder.append(" ");
            GraphPattern gp = this.patterns.get(i);
            if (gp instanceof Group)
                builder.append("{ ");
            builder.append(gp);
            if (gp instanceof Group)
                builder.append(" }");
        }

        if (assignments.size() > 0) {
            for (Entry<Variable, Collection<Expression>> assignment : assignments.entrySet()) {
                Variable v = assignment.getKey();
                for (Expression e : assignment.getValue()) {
                    builder.append(" LET (");
                    builder.append(v.toString());
                    builder.append(" := ");
                    builder.append(e.toString());
                    builder.append(")");
                }
            }
        }

        if (filters.size() > 0) {
            for (Expression filter : filters) {
                builder.append(" FILTER (");
                builder.append(filter.toString());
                builder.append(")");
            }
        }
        //builder.append(" }");

        return builder.toString();
    }

    @Override
    public List<GraphPattern> getChildren() {
        return this.patterns;
    }

    @Override
    public boolean replaceChild(TreeNode oldChild, TreeNode newChild) {
        if (newChild instanceof GraphPattern) {
            for (ListIterator<GraphPattern> it = this.patterns.listIterator(); it.hasNext();) {
                GraphPattern cur = it.next();
                if (oldChild == cur) {
                    oldChild.setParent(null);
                    newChild.setParent(this);
                    it.set((GraphPattern) newChild);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected Map<Variable, Integer> getVariableCount(boolean onlyBindableVariables) {
        Map<Variable, Integer> vars = super.getVariableCount(onlyBindableVariables);
        // include variables on the LHS of LET-expressions
        for (Variable v : this.assignments.keySet())
            incrementVariableCount(vars, v, 1);
        // if we want all variables, regardless of whether they can be bound to,
        // we also include variables occuring inside filters and the RHS of LET-expressions
        if (!onlyBindableVariables) {
            for (Expression e : this.filters)
                for (Variable v : e.getReferencedVariables())
                    incrementVariableCount(vars, v, 1);
            for (Expression e : this.assignments.values())
                for (Variable v : e.getReferencedVariables())
                    incrementVariableCount(vars, v, 1);
        }
        return vars;
    }

    @Override
    public Collection<URI> getReferencedURIs() {
        Collection<URI> uris = super.getReferencedURIs();
        for (Expression e : this.filters)
            uris.addAll(e.getReferencedURIs());
        for (Expression e : this.assignments.values())
            uris.addAll(e.getReferencedURIs());
        return uris;
    }

    @Override
    public boolean removeChild(TreeNode child) {
        if (this.patterns.remove(child))
            return true;
        return (child instanceof Expression && this.filters.remove(child));
    }

    @Override
    public void addChild(TreeNode child) {
        if (child instanceof GraphPattern) {
            addGraphPattern((GraphPattern) child);
        } else
            throw new GlitterRuntimeException(ExceptionConstants.GLITTER.ONLY_ADD, "GraphPattern", "Group Query");
    }

    @Override
    protected boolean prettyPrintParams(StringBuilder output) {
        boolean printedSomething = false;
        if (filters.size() > 0) {
            output.append("Filters(");
            int i = 0;
            for (Expression filter : filters) {

                filter.prettyPrint(output);

                if (++i < filters.size())
                    output.append(", ");
            }
            output.append(")");
            printedSomething = true;
        }
        if (assignments.size() > 0) {
            output.append("Assignments(");
            int i = 0;
            int size = assignments.totalSize();
            for (Entry<Variable, Collection<Expression>> assignment : assignments.entrySet()) {
                Variable v = assignment.getKey();
                for (Expression e : assignment.getValue()) {
                    output.append(v.toString());
                    output.append(" := ");
                    e.prettyPrint(output);
                    if (++i < size)
                        output.append(", ");
                }
            }
            output.append(")");
            printedSomething = true;
        }

        return printedSomething;
    }
}
