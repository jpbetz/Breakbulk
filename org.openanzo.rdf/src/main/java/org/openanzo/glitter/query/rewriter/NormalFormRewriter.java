/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/rewriter/NormalFormRewriter.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: NormalFormRewriter.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query.rewriter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.openanzo.glitter.exception.FeatureNotImplementedException;
import org.openanzo.glitter.query.TreeRewriter;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.glitter.syntax.abstrakt.GraphPattern;
import org.openanzo.glitter.syntax.abstrakt.Group;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;
import org.openanzo.glitter.syntax.abstrakt.Union;
import org.openanzo.rdf.Variable;

/**
 *
 * <pre>
 * From the Semantics and Complexity of SPARQL paper, some equivalences:
 *
 * 2.3.1
 *  (1) P1 AND P2 === P2 AND P1 ; P1 UNION P2 === P2 UNION P1
 *  (2) P1 AND (P2 UNION P3) === (P1 AND P2) UNION (P1 AND P3)
 *  	similarly: AND(P1, P2, UNION(P3, P4)) === UNION(AND(P1, P2, P3), AND(P1, P2, P4))
 *  	similarly: AND(P1, UNION(P2, P3, ..., Pk) === UNION(AND(P1, P2), AND(P1, P3), ..., AND(P1, Pk))
 *  	similarly: AND(P1, UNION(P2, P3), UNION(P4, P5)) ===
 *  		UNION(AND(P1, P2, P4), AND(P1, P2, P5), AND(P1, P3, P4), AND(P1, P3, P5))
 *      similarly: AND(P1, P2, ..., Pi, UNION(Q11, Q12, ..., Q1j), UNION(Q21, Q22, ..., Q2k), ..., UNION(Qm1, Qm2, ..., Qmn))
 *        ===  UNION(For Each (x1, x2, ..., xm) in CartesianProduct(Q11...Q1j, Q21...Q2k, Qm1...Qmn) AND(P1, P2, ..., Pi, x1, x2, ..., xm))
 *  (3) P1 OPT (P2 UNION P3) === (P1 OPT P2) UNION (P1 OPT P3)
 *      Similarly:
 *        OPT(P1, UNION(P2, P3, ..., Pk)) ===
 *        	UNION(OPT(P1, P2), OPT(P1, P3), ..., OPT(P1, Pk))
 * NOTE WELL: (3) DOES NOT HOLD. See http://www.w3.org/2001/sw/DataAccess/tests/data-r2/optional/manifest#dawg-optional-complex-2
 *
 *  We also take advantage of associativity properties:
 *    P1 UNION (P2 UNION P3) = (P1 UNION P2) UNION P3 = (for that matter)
 *      UNION(P1, P2, P3) if naryUnion is allowed.
 *
 * TODO there's a bit more of a normal form in Theorem 6 (labelled (4)) in the
 * paper; we may want to investigate that.
 *
 * TODO @@ Do these identities hold with FILTERs having Group scope?
 *
 * </pre>
 *
 * @author Lee
 *
 */
public class NormalFormRewriter implements TreeRewriter {
    private final boolean allowNaryUnion;

    /**
     * Constructor.
     *
     * @param allowNaryUnion
     */
    public NormalFormRewriter(boolean allowNaryUnion) {
        this.allowNaryUnion = allowNaryUnion;
    }

    public TreeNode rewriteTreeNode(TreeNode node) {
        // TODO -- bug when a Group just has a single union (end up with an extra group)
        // On second thought I don't think this is a bug -- the ConjunctiveRewriter will
        // fix these extra groups
        if (node instanceof Group) {
            // we need to find out if there's any unions as children of this group
            Group g = (Group) node;
            ArrayList<GraphPattern> nonUnionGPs = new ArrayList<GraphPattern>(), unionGPs = new ArrayList<GraphPattern>();

            for (GraphPattern gp : g.getPatterns()) {
                if (gp instanceof Union)
                    unionGPs.add(gp);
                else
                    nonUnionGPs.add(gp);
            }

            if (unionGPs.size() > 0) {
                // implement rewrite (2)
                Union u = new Union();
                Group initialGroup = new Group(nonUnionGPs);

                // Preserve filters and assignments from our group
                for (Expression filter : g.getFilters())
                    initialGroup.addFilter(filter);
                for (Variable v : g.getAssignments().keySet())
                    for (Expression e : g.getAssignments().get(v))
                        initialGroup.addAssignment(v, e);


                // I need to iterate through the cross product of the elements of the unions
                // and then for each of those sets, combine them with the non-union GPs in
                // a group and add that group to the union

                // first, turn each union into a collection of its graph patterns
                ArrayList<Collection<GraphPattern>> unions = new ArrayList<Collection<GraphPattern>>();
                for (GraphPattern cur : unionGPs)
                    unions.add(((Union) cur).getGraphPatterns());
                Set<Collection<GraphPattern>> unionCombos = org.openanzo.rdf.utils.Collections.cartesianProduct(unions);
                // TODO -- rewrite this to support nested binary unions
                if (unionCombos.size() > 2 && !this.allowNaryUnion)
                    throw new FeatureNotImplementedException("Can't raise more than 2 unions to the top without nary union support");
                for (Collection<GraphPattern> combo : unionCombos) {
                    // clone the initial group
                    Group current = initialGroup.clone();
                    // add this combination of required patterns that have been distributed
                    // from the various unions
                    for (Iterator<GraphPattern> it = combo.iterator(); it.hasNext();) {
                        current.addGraphPattern((GraphPattern)it.next().clone());
                    }
                    // union it with all the others
                    u.addGraphPattern(current);
                }
                return u;
            }

        }
        /* identity (3) does not hold, see note above */
        /*
        else if (node instanceof Optional) {
        	// implement rewrite (3) from above
        	Optional opt = (Optional) node;
        	GraphPattern mayMatch = opt.getMayMatchPattern();
        	if (mayMatch instanceof Union) {
        		GraphPattern p1 = opt.getMustMatchPattern();
        		Union u = new Union();
        		Union oldUnion = (Union) mayMatch;
        		for (Iterator<GraphPattern> it = oldUnion.getChildren(); it.hasNext();) {
        			Optional new_opt = new Optional(p1, it.next(), opt.getFilters());
        			u.addGraphPattern(new_opt);
        		}
        		return u;
        	}
        }*/else if (this.allowNaryUnion && node instanceof Union) {
            // UNION is associative (and can be Nary)
            ArrayList<GraphPattern> toAdd = new ArrayList<GraphPattern>();
            for (Iterator<? extends TreeNode> it = node.getChildren().iterator(); it.hasNext();) {
                GraphPattern child = (GraphPattern) it.next();
                if (child instanceof Union) {
                    // Lee: the following code (well, part of it) is courtesy of my
                    // niece, Julia Marshall.
                    for (TreeNode XAZsdgdfhbit2 : child.getChildren()) {
                        toAdd.add((GraphPattern) XAZsdgdfhbit2);
                    }
                    it.remove();
                }
            }
            for (GraphPattern gp : toAdd)
                ((Union) node).addGraphPattern(gp);
        }
        return node;
    }

}
