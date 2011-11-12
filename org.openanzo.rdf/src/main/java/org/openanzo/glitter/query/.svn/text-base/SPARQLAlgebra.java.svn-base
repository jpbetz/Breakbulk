/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/SPARQLAlgebra.java,v $
 * Created by: Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on: February 13, 2007
 * Revision: $Id: SPARQLAlgebra.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors:
 * IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.collections15.MultiMap;
import org.openanzo.analysis.RequestAnalysis;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.exception.IncompatibleTypeException;
import org.openanzo.glitter.exception.MalformedLiteralException;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.glitter.util.TypeConversions;
import org.openanzo.rdf.Bindable;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Variable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A collection of static utility methods that implement the algebraic functions for composing sets of SPARQL solutions.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class SPARQLAlgebra {
    private static final Logger log = LoggerFactory.getLogger(SPARQLAlgebra.class);

    /**
     * Conjoins two solution sets.
     * 
     * (A null list of solutions functions equivalently to a solution set with a single bindings-less solution. This is shorthand and is COMPLETELY different
     * from a solution set with zero solutions (which conjoins with any other solution set to the empty solution set).)
     * 
     * 
     * @param set1
     * @param set2
     * @return The conjunction of the two solution sets.
     */
    static public SolutionSet join(SolutionSet set1, SolutionSet set2) {
        boolean isEnabled = RequestAnalysis.getAnalysisLogger().isDebugEnabled();
        log.trace(LogUtils.GLITTER_MARKER, "join");

        if (set1 == null) {
            if (isEnabled)
                RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SPARQLAlgebra_identityJoin-RHS] {}", Integer.toString(set2.size()));
            return set2;
        }
        if (set2 == null) {
            if (isEnabled)
                RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SPARQLAlgebra_identityJoin-LHS] {}", Integer.toString(set1.size()));
            return set1;
        }
        Comparator<Value> comparator = getComparator(set1, set2);

        if (set1.size() == 0 || set2.size() == 0) {
            if (isEnabled)
                RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SPARQLAlgebra_nullJoin]");
            return new SolutionList();
        }

        PatternSolution sol1[] = set1.toArray(new PatternSolution[0]);
        PatternSolution sol2[] = set2.toArray(new PatternSolution[0]);

        if (sol1.length == 1 && sol1[0].size() == 0) {
            if (isEnabled)
                RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SPARQLAlgebra_identityJoin-RHS] {}", Integer.toString(set2.size()));
            return set2;
        } else if (sol2.length == 1 && sol2[0].size() == 0) {
            if (isEnabled)
                RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SPARQLAlgebra_identityJoin-LHS] {}", Integer.toString(set1.size()));
            return set1;
        }

        SolutionSet newSolutions = new CustomCompareSolutionSet.ComparableSolutionList(comparator);

        long start = 0;

        if (isEnabled) {
            RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SPARQLAlgebra_startJoin] {}:{}", Integer.toString(set1.size()), Integer.toString(set2.size()));
            start = System.currentTimeMillis();
        }

        TreeSet<Bindable> count = new TreeSet<Bindable>();
        for (PatternSolution element : sol1) {
            for (Bindable bindable : element.getBoundDomain(true)) {
                count.add(bindable);
            }
        }
        TreeSet<Bindable> count2 = new TreeSet<Bindable>();
        for (PatternSolution element : sol2) {
            for (Bindable bindable : element.getBoundDomain(true)) {
                count2.add(bindable);
            }
        }

        TreeSet<Bindable> matchSet = new TreeSet<Bindable>();
        if (count.size() < count2.size()) {
            for (Bindable bindable : count) {
                if (count2.contains(bindable))
                    matchSet.add(bindable);
            }
        } else {
            for (Bindable bindable : count2) {
                if (count.contains(bindable)) {
                    matchSet.add(bindable);
                }
            }
        }
        Bindable matchedBindables[] = matchSet.toArray(new Bindable[0]);

        if (isEnabled) {
            StringBuilder sb = new StringBuilder();
            for (Bindable bindable : matchSet) {
                sb.append(bindable.toString());
                sb.append(",");
            }
            RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SPARQLAlgebra_matchingBindings] {}", sb.toString());
        }
        long startSort = 0;
        if (isEnabled) {
            startSort = System.currentTimeMillis();
        }
        Arrays.sort(sol1, 0, sol1.length, new PatternSolutionImpl.SetSolutionComparator(matchSet, comparator));
        if (isEnabled) {
            RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SPARQLAlgebra_leftSortTime] {}", Long.toString(System.currentTimeMillis() - startSort));
            startSort = System.currentTimeMillis();
        }
        Arrays.sort(sol2, 0, sol2.length, new PatternSolutionImpl.SetSolutionComparator(matchSet, comparator));
        if (isEnabled) {
            RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SPARQLAlgebra_rightSortTime] {}", Long.toString(System.currentTimeMillis() - startSort));
            startSort = System.currentTimeMillis();
        }
        //System.err.println("Joining:" + sol1.length + ":" + sol2.length);
        int j = 0;
        //long start = System.currentTimeMillis();
        if (matchSet.size() > 0) {
            for (PatternSolution solution : sol1) {
                Bindable sol1Bindables[] = solution.getBoundDomainArray();
                boolean done = false;
                for (int k = j; k < sol2.length && !done; k++) {
                    if (sol1Bindables.length == 0) {
                        newSolutions.add(sol2[k]);
                    } else {
                        boolean match = true;
                        boolean cloned = false;
                        PatternSolution solution2 = sol2[k];
                        boolean firstEmpty = true;
                        Bindable bindables2[] = solution2.getBoundDomainArray();
                        int m = 0;
                        if (bindables2.length > 0) {
                            boolean breaker = false;
                            for (Bindable element : matchedBindables) {
                                firstEmpty = false;
                                for (int mm = m; mm < bindables2.length && !breaker; mm++) {
                                    int comp1 = element.compareTo(bindables2[mm]);
                                    if (comp1 == 0) {
                                        Value term = solution.getBinding(element);
                                        Value term2 = solution2.getBinding(bindables2[mm]);
                                        //If term is null, this means that lh solution does not have a binding for a shared binding, so have to do slow conjoin
                                        if (term == null) {
                                            PatternSolution psNew = conjoin(solution, solution2);
                                            if (psNew != null) {
                                                newSolutions.add(psNew);
                                            }
                                            match = false;
                                            breaker = true;
                                        } else {
                                            int comp = comparator.compare(term, term2);
                                            if (comp > 0) {
                                                match = false;
                                                breaker = true;
                                                j = k;
                                                break;
                                            } else if (comp < 0) {
                                                match = false;
                                                done = true;
                                                breaker = true;
                                                break;
                                            } else {
                                                if (!cloned) {
                                                    bindables2 = bindables2.clone();
                                                    cloned = true;
                                                }
                                                // conjunction.put(bindables2[mm], term);
                                                bindables2[mm] = null;
                                                m = mm + 1;
                                                break;
                                            }
                                        }
                                    } else if (comp1 > 0) {
                                        m = mm;
                                    }
                                }
                                if (breaker)
                                    break;
                            }
                            if (match) {
                                if (firstEmpty) {
                                    newSolutions.add(solution2);
                                } else {
                                    PatternSolutionImpl newSolution = new PatternSolutionImpl(solution);
                                    for (Bindable element : bindables2) {
                                        if (element != null) {
                                            newSolution.setBinding(element, solution2.getBinding(element));
                                        }
                                    }
                                    newSolutions.add(new PatternSolutionImpl(newSolution));
                                }
                            }
                        } else {
                            newSolutions.add(solution);
                        }
                    }
                }
            }
        } else {
            for (PatternSolution solution : sol1) {
                for (PatternSolution solution2 : sol2) {
                    Bindable bindable[] = new Bindable[solution.getBoundDomainArray().length + solution2.getBoundDomainArray().length];
                    Value value[] = new Value[solution.getBoundDomainArray().length + solution2.getBoundDomainArray().length];
                    Bindable bs[] = solution.getBoundDomain(false);
                    Value vs[] = solution.getBoundVariablesArray(false);

                    System.arraycopy(bs, 0, bindable, 0, bs.length);
                    System.arraycopy(vs, 0, value, 0, vs.length);
                    int last = vs.length;
                    bs = solution2.getBoundDomain(false);
                    vs = solution2.getBoundVariablesArray(false);
                    System.arraycopy(bs, 0, bindable, last, bs.length);
                    System.arraycopy(vs, 0, value, last, vs.length);

                    newSolutions.add(new PatternSolutionImpl(bindable, value));
                }
            }
        }
        //System.err.println("Join:" + (System.currentTimeMillis() - start) + ":" + newSolutions.size());
        if (isEnabled) {
            RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SPARQLAlgebra_endJoin] {}:{}", Integer.toString(newSolutions.size()), Long.toString(System.currentTimeMillis() - start));
        }
        return newSolutions;
        /*	SolutionSet newSolutions2 = new SolutionList();
         for (PatternSolution ps1 : set1) {
         for (PatternSolution ps2 : set2) {
         PatternSolution psNew = ps1.conjoin(ps2);
         if (psNew != null)
         newSolutions2.add(psNew);
         }
         }
         return newSolutions;*/
    }

    /**
     * Returns whether or not the given solution contains values for all of the given variables.
     * 
     * @param solution
     * @param variables
     * @return whether or not the given solution contains values for all of the given variables
     */
    static private boolean solutionBindsAllVariables(PatternSolution solution, Collection<Variable> variables) {
        return solution.bindsAllVariables(variables);
    }

    /**
     * 
     * @param solution
     * @param filters
     * @return <tt>true</tt> if the given solution passes all of the supplied filters; <tt>false</tt> otherwise.
     * @throws ExpressionEvaluationException
     */
    static private boolean keepSolution(PatternSolution solution, Set<Expression> filters) throws ExpressionEvaluationException {
        return keepSolution(solution, filters, false);
    }

    /**
     * 
     * @param solution
     * @param filters
     * @param keepSolutionsWithUnboundVariables
     *            If <tt>true</tt>, a filter expression that acts on unbound variables is ignored. If <tt>false</tt>, such a filter expression evaluates to an
     *            error, which rejects the solution.
     * @return <tt>true</tt> if the given solution passes all of the supplied filters; <tt>false</tt> otherwise.
     * @throws ExpressionEvaluationException
     */
    static private boolean keepSolution(PatternSolution solution, Set<Expression> filters, boolean keepSolutionsWithUnboundVariables) throws ExpressionEvaluationException {
        for (Expression filter : filters) {
            try {
                // if we're OK with unbound variables and this filter has a variable that is unbound
                // in this solution, then just move on to the next filter
                if (keepSolutionsWithUnboundVariables && !solutionBindsAllVariables(solution, filter.getReferencedVariables()))
                    continue;
                Value result = filter.evaluate(solution, null);
                if (!TypeConversions.effectiveBooleanValue(result))
                    return false;
            } catch (IncompatibleTypeException e) {
                // type errors result in not keeping this solution
                return false;
            } catch (MalformedLiteralException e) {
                // type errors result in not keeping this solution
                return false;
            } catch (ExpressionEvaluationException e) {
                // anything else gets surfaced
                throw e;
            }
        }
        return true;
    }

    /**
     * Applies the given set of filters to a full solution set.
     * 
     * @param answers
     * @param filters
     * @return A solution set containing only those solutions from which apply filters returns <tt>true</tt>.
     * @throws ExpressionEvaluationException
     */
    static public SolutionSet filterSolutions(SolutionSet answers, Set<Expression> filters) throws ExpressionEvaluationException {
        for (ListIterator<PatternSolution> it = answers.listIterator(); it.hasNext();) {
            if (!keepSolution(it.next(), filters))
                it.remove();
        }
        return answers;
    }

    /**
     * Evaluates and binds the expressions in the given assignments to the corresponding variables.
     * 
     * @param answers
     * @param assignments
     * @return SolutionSet with assignments assigned
     * @throws ExpressionEvaluationException
     */
    static public SolutionSet processAssignments(SolutionSet answers, MultiMap<Variable, Expression> assignments) throws ExpressionEvaluationException {
        SolutionList newAnswers = new SolutionList();
        ListIterator<PatternSolution> it = answers.listIterator();
        while (it.hasNext()) {
            // TODO there are evaluation optimizations here if the LET expressions don't depend on variables in
            // the answers _and_ if the expressions are pure functional (no side effects/outside state involved)
            PatternSolution solution = it.next();
            PatternSolutionImpl newSolution = new PatternSolutionImpl(solution);
            boolean keepSolution = true;
            for (Variable v : assignments.keySet()) {
                for (Expression e : assignments.get(v)) {
                    // allow aggregates to operate over the given solutions
                    // evaluate in the context of the solution going in, but compare with the new solution
                    // we're building up (extending the original solution)
                    Value assignedVal = e.evaluate(solution, answers);
                    if (assignedVal == null)
                        continue;
                    Value currentVal = newSolution.getBinding(v);
                    if (currentVal != null && !currentVal.equals(assignedVal)) {
                        // joining this assignment to this solution results fails, so the solution
                        // is removed from the results
                        keepSolution = false;
                        break;
                    } else if (currentVal == null) {
                        newSolution.setBinding(v, assignedVal);
                    }
                }
                if (!keepSolution)
                    break;
            }
            if (keepSolution)
                newAnswers.add(newSolution);
        }
        return newAnswers;
    }

    /**
     * Implements the SPARQL LeftJoin operator. (For the SPARQL <tt>OPTIONAL</tt> keyword.)
     * 
     * @param set1
     *            The left-hand-side of the outer join. See the SPARQL spec. for precise semantics.
     * @param set2
     *            The right-hand-side of the outer join.
     * @param filters
     *            Filters that are scoped to this left join.
     * @return The results of applying the LeftJoin operator.
     */
    static public SolutionSet leftJoin(SolutionSet set1, SolutionSet set2, Set<Expression> filters) {
        Comparator<Value> comparator = getComparator(set1, set2);

        if (set1 == null)
            return filterSolutions(set2, filters);
        if (set2 == null)
            return filterSolutions(set1, filters);
        long start = 0;
        boolean isEnabled = RequestAnalysis.getAnalysisLogger().isDebugEnabled();
        if (isEnabled) {
            RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER,"[glitter_SPARQLAlgebra_startLeftJoin] {}:{}", Integer.toString(set1.size()), Integer.toString(set2.size()));
            start = System.currentTimeMillis();
        }
        SolutionSet newSolutions = new CustomCompareSolutionSet.ComparableSolutionList(comparator);
        PatternSolution sol1[] = set1.toArray(new PatternSolution[0]);
        // count1 contains all the variables (& bnodes) in the first (required)
        // solution set. count2 contains all the bindables that appear in the
        // second.
        TreeSet<Bindable> count1 = new TreeSet<Bindable>();
        for (PatternSolution element : sol1) {
            for (Bindable bindable : element.getBoundDomain(true)) {
                count1.add(bindable);
            }
        }

        PatternSolution sol2[] = set2.toArray(new PatternSolution[0]);
        TreeSet<Bindable> count2 = new TreeSet<Bindable>();
        for (PatternSolution element : sol2) {
            for (Bindable bindable : element.getBoundDomain(true)) {
                count2.add(bindable);
            }
        }
        // populate matchSet with all the bindables that are in common
        // between the two solution sets.  Order the Binding names in the matchSet
        TreeSet<Bindable> matchSet = new TreeSet<Bindable>();
        if (count1.size() < count2.size()) {
            for (Bindable bindable : count1) {
                if (count2.contains(bindable))
                    matchSet.add(bindable);
            }
        } else {
            for (Bindable bindable : count2) {
                if (count1.contains(bindable)) {
                    matchSet.add(bindable);
                }
            }
        }
        Bindable matchedBindables[] = matchSet.toArray(new Bindable[0]);
        //Matt:Sort the solutions in sol1+sol2 based on the ordered matchSet, ie
        //the matchSet is sorted alphabetically by the binding names, so sort the solutions in sol1 + sol2
        //by a progressive alphabetical sort based on the ordered binding names, ie
        //if you have binding "A" and binding "B", the solutions would get ordered first by
        //and alphabetical sort of the Binding "A" values, and when the values of Binding "A" match,
        //alphabetical sort of Biding "B" values.
        //
        //Example:  2 Binding "A" and "B"
        //
        // row 1:  A=adam  B=zebra
        // row 2:  A=charlie b=apple
        // row 3:  A=adam  B=david
        // row 4:  A=zed	B=arrow

        //Sort order would be
        // row 3:  A=adam  B=david   //since adam is alphabetically lower than charlie and zed, and then david is lower than zebra
        // row 1:  A=adam  B=zebra
        // row 2:  A=charlie b=apple //charlie is after adam, and before zed, apple isn't used in sort since there are no other values with a match on A
        // row 4:  A=zed	B=arrow  //zed is after adam and charlie, arrow isn't used in sort since there are no other values with a match on A

        long startSort = 0;
        if (isEnabled) {
            startSort = System.currentTimeMillis();
        }
        Arrays.sort(sol1, 0, sol1.length, new PatternSolutionImpl.SetSolutionComparator(matchSet, comparator));
        if (isEnabled) {
            RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER,"[glitter_SPARQLAlgebra_leftSortTime] {}", Long.toString(System.currentTimeMillis() - startSort));
            startSort = System.currentTimeMillis();
        }
        Arrays.sort(sol2, 0, sol2.length, new PatternSolutionImpl.SetSolutionComparator(matchSet, comparator));
        if (isEnabled) {
            RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER,"[glitter_SPARQLAlgebra_rightSortTime] {}", Long.toString(System.currentTimeMillis() - startSort));
            startSort = System.currentTimeMillis();
        }
        // j is our current starting position for iterating over the optional
        // solutions. we can skip optional solutions p..r if we know that all
        // of them are incompatible with required solutions
        // //Matt:You know they are incompatiable because the sort order of the 2 solution sets is the same
        int j = 0;
        //long start = System.currentTimeMillis();

        for (PatternSolution solution1 : sol1) {
            Bindable sol1Bindables[] = solution1.getBoundDomainArray();
            boolean oneMatch = false;
            boolean done = false;
            //Matt:Since the solutions in the 2 sets are in the same sort order, you know that if
            //you compare solution(k) from the right solution set with solution(i) from the left solution set and solution(k) is
            //lower in the sort order than solution(i), then all the remaining solutions in left solution set will also have a
            //higher sort order than solutions(0-k) in right solution set.
            for (int k = j; k < sol2.length && !done; k++) {
                if (sol1Bindables.length == 0) {
                    // the empty solution is the unit / identity solution
                    oneMatch = true;
                    newSolutions.add(sol2[k]);
                } else {
                    // match starts as false; if all the bindings in solution1
                    // match bindings in solution2 (i.e. solution1 is compatible
                    // with solution2), then match==true.
                    //
                    // Lee: There seems to be a bug here if the intersection of
                    // bindable1 and bindable2 is empty: in this case, solution1 does not get
                    // extended by solution2, as it should be. Would this be fixed
                    // by defaulting match to true?
                    boolean match = true;
                    boolean cloned = false;
                    PatternSolution solution2 = sol2[k];
                    // Map<Bindable, Value> conjunction = new HashMap<Bindable, Value>();
                    Bindable bindables2[] = solution2.getBoundDomainArray();
                    // we traverse the bindables in these solutions in parallel
                    // this counter is our current starting position in the optional bindables
                    //Matt:Since the bindables in the 2 arrays are in the same sort order, you know that if
                    //you compare bindable(m) from the right array with bindable(l) from the left array and bindable(m) is
                    //lower in the sort order than bindable(l), then all the remaining bindable in left array will also have a
                    //higher sort order than bindable(0-m) in right array.
                    int m = 0;
                    // breaker is true if solution1 and solution2 are not compatible;
                    // once one non-compatible binding has been found, the rest of
                    // the bindables in solution1 will be copied, but we won't bother
                    // checking them against solution2.
                    boolean breaker = false;
                    if (bindables2.length > 0) {
                        for (Bindable element : matchedBindables) {
                            // put in the required solution, unmodified, regardless of whether
                            // we've found any incompatibilities yet
                            //conjunction.put(element, solution1.getBinding(element));
                            for (int mm = m; mm < bindables2.length && !breaker; mm++) {
                                int comp1 = element.compareTo(bindables2[mm]);
                                if (comp1 == 0) {
                                    // the same bindable is in both solutions, check
                                    // the value its bound to; note that solutions in each
                                    // solution set are ordered by comparing terms (bound
                                    // values)
                                    Value term1 = solution1.getBinding(element);
                                    //If term is null, this means that lh solution does not have a binding for a shared binding, so have to do slow conjoin
                                    if (term1 == null) {
                                        PatternSolution newSolution = conjoin(solution1, solution2);
                                        if (newSolution != null) {
                                            if (keepSolution(newSolution, filters)) {
                                                // oneMatch indicates that solution1 (from the left-hand side)
                                                // was compatible with at least one solution from the right-hand
                                                // solution set
                                                oneMatch = true;
                                                newSolutions.add(newSolution);
                                            }
                                        }
                                        match = false;
                                        breaker = true;
                                    } else {
                                        Value term2 = solution2.getBinding(bindables2[mm]);
                                        int comp = comparator.compare(term1, term2);
                                        if (comp > 0) {
                                            // See note above - since the left solution has
                                            // a higher value for this term, we can skip all
                                            // right-hand solutions before this one when we
                                            // start with the next left-hand solution.
                                            match = false;
                                            breaker = true;
                                            j = k;
                                            break;
                                        } else if (comp < 0) {
                                            match = false;
                                            breaker = true;
                                            done = true;
                                            break;
                                        } else {
                                            if (!cloned) {
                                                bindables2 = bindables2.clone();
                                                cloned = true;
                                            }
                                            match = true;
                                            // conjunction.put(bindables2[mm], term);
                                            bindables2[mm] = null;
                                            m = mm + 1;
                                            break;
                                        }
                                    }
                                } else if (comp1 > 0) {
                                    m = mm;
                                }
                            }
                        }
                        // match is true if all of the terms in common between solution1
                        // and solution2 are bound to the same value in both solutions
                        if (match) {
                            PatternSolutionImpl newSolution = new PatternSolutionImpl(solution1);
                            // before we accept this conjoined solution, we need to make sure
                            // it passes the filter
                            for (Bindable element : bindables2) {
                                // bindings that match those in solution1 were nulled out above
                                // so if a binding is not null, it extends solution 1 and we copy
                                // it into the conjunction
                                if (element != null) {
                                    newSolution.setBinding(element, solution2.getBinding(element));
                                }
                            }
                            if (keepSolution(newSolution, filters)) {
                                // oneMatch indicates that solution1 (from the left-hand side)
                                // was compatible with at least one solution from the right-hand
                                // solution set
                                oneMatch = true;
                                newSolutions.add(newSolution);
                            }
                        }
                    }
                }
            }
            // if solution1 wasn't compatible with any solutions in the right-hand side, then we just
            // copy solution1 into our resultset untouched
            if (!oneMatch) {
                newSolutions.add(solution1);
            }
        }
        //System.err.println("LeftJoin:" + (System.currentTimeMillis() - start) + ":" + newSolutions.size());
        if (isEnabled) {
            RequestAnalysis.getAnalysisLogger().debug(LogUtils.GLITTER_MARKER, "[glitter_SPARQLAlgebra_endLeftJoin] {}:{}", Integer.toString(newSolutions.size()), Long.toString(System.currentTimeMillis() - start));
        }
        return newSolutions;
        /*if (set1 == null)
         return set2;
         if (set2 == null)
         return set1;
         SolutionSet newSolutions = new SolutionList();
         for (PatternSolution ps1 : set1) {
         boolean extendedPs1 = false;
         for (PatternSolution ps2 : set2) {
         PatternSolution psNew = ps1.conjoin(ps2);
         if (psNew != null) {
         extendedPs1 = true;
         newSolutions.add(psNew);
         }
         }
         // for this to be a left  outer join, we have to include the left-hand
         // pattern solution even if all of the right-hand solutions conflict
         // with it
         if (!extendedPs1)
         newSolutions.add(ps1);
         }
         return newSolutions;
         */
    }

    private static Comparator<Value> getComparator(SolutionSet set1, SolutionSet set2) {

        Comparator<Value> comparator = CustomCompareSolutionSet.LEXICAL_COMPARATOR;
        if (set1 instanceof CustomCompareSolutionSet && set2 instanceof CustomCompareSolutionSet && ((CustomCompareSolutionSet) set1).getComparator().equals(((CustomCompareSolutionSet) set2).getComparator())) {
            comparator = ((CustomCompareSolutionSet) set1).getComparator();
        }
        log.debug(LogUtils.GLITTER_MARKER, "using comparator: {}", comparator.getClass());
        return comparator;
    }

    private static PatternSolution conjoin(PatternSolution sol1, PatternSolution sol2) {
        Map<Bindable, Value> conjunction = new HashMap<Bindable, Value>();

        for (Bindable var : sol1.getBoundDomain(false)) {
            conjunction.put(var, sol1.getBinding(var));
        }

        for (Bindable var : sol2.getBoundDomain(false)) {
            Value thisVal = sol1.getBinding(var);
            Value otherVal = sol2.getBinding(var);
            // if this variable is bound in the other one and not bound to the
            // same term in this one, then the solutions are mutually exclusive
            if (otherVal != null && thisVal != null && !otherVal.equals(thisVal))
                return null;
            if (otherVal != null)
                conjunction.put(var, otherVal);
        }
        return new PatternSolutionImpl(conjunction);
    }
}
