/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.openanzo.glitter.expression.builtin.PolymorphicEq;
import org.openanzo.glitter.expression.builtin.PolymorphicNe;
import org.openanzo.glitter.query.rewriter.VariableRewriter;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.glitter.syntax.abstrakt.FunctionCall;
import org.openanzo.glitter.syntax.abstrakt.SimpleExpression;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.rdf.Bindable;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.utils.Pair;

/**
 * Set of utilities for solution generation
 *
 */
public class SolutionUtils {
    protected static SolutionSet singletonSolution(Bindable k, Value v) {
        SolutionSet ss = new SolutionList();
        PatternSolution ps = new PatternSolutionImpl(k, v);
        ss.add(ps);
        return ss;
    }

    private static final SolutionSet unconstrainedSolutions;
    static {
        unconstrainedSolutions = new SolutionList();
        unconstrainedSolutions.add(new PatternSolutionImpl());
    }

    /**
     * Get the unconstrained solution set. This is different from no bindings.
     *
     * @return the unconstrained solution set. This is different from no bindings.
     */
    public static SolutionList unconstrainedSolutions() {
        return new SolutionList(unconstrainedSolutions);
    }

    /**
     * Get no bindings. This is different from the unconstrained solution set.
     *
     * @return a static solution list with no bindings
     */
    public static SolutionSet noSolutions() {
        return new SolutionList();
    }

    private static Map<Bindable, Value> extractFixedBindings(SolutionSet answers) {
        HashMap<Bindable, Pair<HashSet<Value>, Integer>> answersByVariable = new HashMap<Bindable, Pair<HashSet<Value>, Integer>>();
        for (PatternSolution solution : answers) {
            for (Bindable b : solution.getBoundDomain(false)) {
                Pair<HashSet<Value>, Integer> p = answersByVariable.get(b);
                if (p == null) {
                    p = new Pair<HashSet<Value>, Integer>(new HashSet<Value>(), 0);
                    answersByVariable.put(b, p);
                }
                p.first.add(solution.getBinding(b));
                p.second = Integer.valueOf(p.second.intValue() + 1);
            }
        }
        int goal = answers.size();
        HashMap<Bindable, Value> values = new HashMap<Bindable, Value>();
        for (Entry<Bindable, Pair<HashSet<Value>, Integer>> entry : answersByVariable.entrySet()) {
            Pair<HashSet<Value>, Integer> p = entry.getValue();
            if (p.first.size() == 1 && p.second == goal) {
                Value term = p.first.iterator().next();
                // We don't extract bindings for bindable objects, since that would
                // confuse further calls to the backend which would rebind this term
                if (!(term instanceof Bindable))
                    values.put(entry.getKey(), p.first.iterator().next());
            }

        }
        return values;
    }

    /**
     * Substitute the fixed bindings within the tree node
     *
     * @param n
     *            node to augment
     * @param answerConstraints
     *            fixed bindings used for augmenting the node
     * @return the augmented node
     */
    public static TreeNode substituteFixedBindings(TreeNode n, SolutionSet answerConstraints) {
        Map<Bindable, Value> fixedBindings = extractFixedBindings(answerConstraints);
        if (fixedBindings.size() > 0) {
            TreeNode node = Glitter.rewriteTree(n, new VariableRewriter(fixedBindings));
            if (node != n) {
                n.getParent().replaceChild(n, node);
                n = node; // for the rest of this function call
            }
        }
        return n;
    }

    /**
     * For any PolymorphicEq filter that replaces a bindable, then place it in the constraints
     *
     * @param n
     *            node to augment
     * @param answerConstraints
     *            constraints
     */
    public static void substituteFilterBindings(TreeNode n, SolutionSet answerConstraints) {
        Set<Expression> filters = n.getInScopeFilterSet();
        Set<Expression> removed = new HashSet<Expression>();
        for (Expression filter : filters) {
            if (filter instanceof FunctionCall) {
                FunctionCall fc = ((FunctionCall) filter);
                if (fc.getFunction() instanceof PolymorphicEq) {
                    if (fc.getArguments().size() == 2) {
                        Expression e1 = fc.getArguments().get(0);
                        Expression e2 = fc.getArguments().get(1);
                        if (e1 instanceof SimpleExpression && e2 instanceof SimpleExpression) {
                            TriplePatternComponent v1 = ((SimpleExpression) e1).getTerm();
                            TriplePatternComponent v2 = ((SimpleExpression) e2).getTerm();
                            if (v1 instanceof Bindable && v2 instanceof Resource) {
                                if (singleUseVariable((Bindable) v1, filters)) {
                                    answerConstraints.add(new PatternSolutionImpl((Bindable) v1, (Resource) v2));
                                    removed.add(filter);
                                }
                            } else if (v2 instanceof Bindable && v1 instanceof Resource) {
                                if (singleUseVariable((Bindable) v2, filters)) {
                                    answerConstraints.add(new PatternSolutionImpl((Bindable) v2, (Resource) v1));
                                    removed.add(filter);
                                }
                            }
                        }
                    }
                }
            }
        }
        for (Expression filter : removed) {
            n.getFilters().remove(filter);
        }
        if (removed.size() > 0) {
            n.invalidateCache();
        }
    }

    /**
     * Return true if given bindable is only referenced in one filter
     *
     * @param b
     *            bindable to check
     * @param filters
     *            filters in which to check bindable
     * @return true if given bindable is only referenced in one filter
     */
    public static boolean singleUseVariable(Bindable b, Set<Expression> filters) {
        int seen = 0;
        for (Expression filter : filters) {
            if (filter instanceof FunctionCall) {
                if (filter.getReferencedVariables().contains(b)) {
                    seen++;
                    if (seen > 1)
                        return false;
                }
            }
        }
        return true;
    }

    /**
     * Return true if given bindable is only referenced in equality filters
     *
     * @param b
     *            bindable to check
     * @param filters
     *            filters in which to check bindable
     * @return true if given bindable is only referenced in equality filters
     */
    public static boolean onlyEqualityBindings(Bindable b, Set<Expression> filters) {
        for (Expression filter : filters) {
            if (filter instanceof FunctionCall) {
                FunctionCall fc = ((FunctionCall) filter);
                for (Expression e : fc.getArguments()) {
                    if (e instanceof SimpleExpression) {
                        TriplePatternComponent v1 = ((SimpleExpression) e).getTerm();
                        if (v1.equals(b) && !((fc.getFunction() instanceof PolymorphicEq) || (fc.getFunction() instanceof PolymorphicNe))) {
                            return false;
                        }
                    }
                }
            } else if (filter.getReferencedVariables().contains(b)) {
                return false;
            }
        }
        return true;
    }
}
