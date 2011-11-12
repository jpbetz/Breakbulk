/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/rewriter/ConjunctiveRewriter.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: ConjunctiveRewriter.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query.rewriter;

import java.util.ArrayList;
import java.util.List;

import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.exception.GlitterRuntimeException;
import org.openanzo.glitter.expression.builtin.LogicalAnd;
import org.openanzo.glitter.query.TreeRewriter;
import org.openanzo.glitter.syntax.abstrakt.BGP;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.glitter.syntax.abstrakt.FunctionCall;
import org.openanzo.glitter.syntax.abstrakt.GraphPattern;
import org.openanzo.glitter.syntax.abstrakt.Group;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;
import org.openanzo.glitter.syntax.abstrakt.TriplePatternNode;
import org.openanzo.glitter.syntax.concrete.ParseException;

/**
 * The ConjunctiveRewriter takes advantage of the following equalities: { t1 t2 { t3 } } = t1 t2 t3
 * 
 * That is, triples within a single BGP are conjoined, as are GraphPatterns within a group. By flattening out nested groups and then merging multiple BGPs
 * within a group, we take a great deal of complexity out of the AST and enable other query-plan optimizations.
 * 
 * This also conjoins multiple filtered basic graph patterns.
 * 
 * (Note that on the surface {t1 {t2} } is not identical to {t1 t2} because the two triples have different blank node scopes. At this point (the AST rewriting
 * point), distinct blank nodes for identical labels in different scopes have already be created, so we can lose that difference.)
 * 
 * (Note also that this equivalence might not hold for entaiments other than simple entailment, and as such a backend that implements other entailments should
 * be wary in its use of the ConjunctiveRewriter.)
 * 
 * ConjunctiveRewriter only operates on Group nodes, and only manipulates Group, BGP, and Filter nodes.
 * 
 * TODO @@ ConjunctiveRewriter also needs to ensure that every Group has a BGP.
 * 
 * TODO @@ This could be improved to flatten single element groups regardless of filters in children { { ?s ?p ?o. FILTER (...) } }.
 * 
 * @author Lee
 * 
 */
public class ConjunctiveRewriter implements TreeRewriter {
    protected void conjoinSecondBGP(BGP one, BGP two) {
        for (TriplePatternNode tpn : two.getTriplePatterns())
            one.addTriplePattern(tpn);
    }

    protected Expression conjoinExpressions(Expression one, Expression two) {
        if (one == null)
            return two;
        if (two == null)
            return one;
        ArrayList<Expression> args = new ArrayList<Expression>();
        args.add(one);
        args.add(two);
        try {
            return new FunctionCall(new LogicalAnd(), args);
        } catch (ParseException e) {
            throw new GlitterRuntimeException(ExceptionConstants.GLITTER.PARSE_EXCEPTION, e, "LogicalAnd is not an aggregate function", e.getMessage());
        }
    }

    private boolean conjoinGraphPattern(BGP theBGP, Group parent, GraphPattern gp, List<GraphPattern> toAdd) {
        if (gp instanceof BGP) {
            conjoinSecondBGP(theBGP, (BGP) gp);
            return true;
        } else if (gp instanceof Group) {
            return conjoinSecondGroup(theBGP, parent, (Group) gp, toAdd);
        } else {
            // any other graph pattern just gets added on to the parent
            toAdd.add(gp);
            return true;
        }
    }

    /**
     * If possible, flattens the child group into the parent group.
     * 
     * @param theBGP
     *            The single BGP for the parent group. All triples get added here.
     * @param parent
     *            The parent group to which we are trying to add everything.
     * @param child
     *            The child group which we are hoping to eliminate.
     * @param toAdd
     *            A list of graph patterns that need to be added to the parent group. This list is kept on its own so as not to affect the iterations in
     *            progress.
     * @return true if the child group was successfully eliminated, false otherwise
     */
    protected boolean conjoinSecondGroup(BGP theBGP, Group parent, Group child, List<GraphPattern> toAdd) {
        boolean b = true;
        // if the child group has its own filters or assignments, then we can't conjoin it
        // (since those  are limited to the scope of that group)
        if (child.getFilters().size() == 0 && child.getAssignments().size() == 0) {
            // we can only remove this child group if we were able to eliminate
            // all of its children
            for (GraphPattern gp : child.getPatterns())
                b = conjoinGraphPattern(theBGP, parent, gp, toAdd) && b;
            // the caller of this function is responsible for removing the child group
            return b;
        }
        return false;
    }

    public TreeNode rewriteTreeNode(TreeNode node) {
        // our goal is to make each group contain only a single
        // BGP; we could also conjoin all of the filters into a single
        // filter, but that seems less important for the moment.
        if (node instanceof Group) {
            BGP theBGP = new BGP(new ArrayList<TriplePatternNode>());
            Group g = (Group) node;
            ArrayList<GraphPattern> toAdd = new ArrayList<GraphPattern>(), toRemove = new ArrayList<GraphPattern>();

            for (GraphPattern pattern : g.getPatterns()) {
                if (pattern instanceof BGP || pattern instanceof Group) {
                    if (conjoinGraphPattern(theBGP, g, pattern, toAdd))
                        toRemove.add(pattern);
                }
            }

            for (GraphPattern gp : toRemove)
                g.removeGraphPattern(gp);
            for (GraphPattern gp : toAdd)
                g.addGraphPattern(gp);

            // we used to only add a BGP if it was non-empty
            // the special case of empty groups made backends more difficult
            // to implement in some cases, so now we ensure a single BGP for
            // every group, even if it is empty
            g.addGraphPattern(theBGP);
        }
        return node;
    }

}
