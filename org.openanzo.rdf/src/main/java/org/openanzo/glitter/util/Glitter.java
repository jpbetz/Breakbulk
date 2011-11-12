/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/util/Glitter.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: Glitter.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.ObjectUtils;
import org.openanzo.glitter.query.Construct;
import org.openanzo.glitter.query.OrderingCondition;
import org.openanzo.glitter.query.Projection;
import org.openanzo.glitter.query.QueryInformation;
import org.openanzo.glitter.query.QueryType;
import org.openanzo.glitter.query.TreeRewriter;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.glitter.syntax.abstrakt.FunctionCall;
import org.openanzo.glitter.syntax.abstrakt.Graph;
import org.openanzo.glitter.syntax.abstrakt.Subquery;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;
import org.openanzo.glitter.syntax.abstrakt.TriplePatternNode;
import org.openanzo.glitter.syntax.abstrakt.Union;
import org.openanzo.rdf.Bindable;
import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Variable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link Glitter} class provides a variety of static utility methods.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class Glitter {

    private static final Logger log = LoggerFactory.getLogger(Glitter.class);

    /**
     * Provides access to a common log.
     * 
     * @return the common log for Glitter
     */
    public static Logger getLog() {
        return log;
    }

    /**
     * Synonym for {@link MemURI#create(String)}.
     * 
     * @param s
     *            String representation of URI
     * @return the URI representation of the given string
     */
    public static URI createURI(String s) {
        return MemURI.create(s);
    }

    private Glitter() {
    }

    /**
     * Implements a post-order traversal which rewrites tree nodes.
     * 
     * @param node
     *            The root of the nodes to rewrite.
     * @param rewriter
     *            A {@link TreeRewriter} that examines each node.
     * @return <tt>null</tt>, if <tt>node</tt> should be removed. Otherwise, the return value is substituted in-plcae for <tt>node</tt> in the query tree.
     */
    public static TreeNode rewriteTree(TreeNode node, TreeRewriter rewriter) {
        if (node == null)
            return node;
        // first, rewrite the children (we make a copy to allow modification of
        // the
        // original tree)
        ArrayList<TreeNode> children = new ArrayList<TreeNode>();
        if (node.getChildren() != null) {
            children.addAll(node.getChildren());
        }
        for (TreeNode child : children) {
            TreeNode newChild = rewriteTree(child, rewriter);
            if (newChild == null)
                node.removeChild(child);
            else if (newChild != child)
                node.replaceChild(child, newChild);
        }
        // next, rewrite the node itself
        return rewriter.rewriteTreeNode(node);
    }

    /**
     * Return true if a binding is needed outside of a specific treenode
     * 
     * @param b
     *            bindable to check
     * @param node
     *            node where binding lives
     * @param qc
     *            query information
     * @param checkFilters
     *            check if filters use binding
     * @return true if binding is needed outside a specific treenode
     */
    public static boolean isNeededOutsideOfNode(Bindable b, TreeNode node, QueryInformation qc, boolean checkFilters) {
        // 0) if there are union ancestors that can be safely be used to widen
        // the scope of 'here', use them.
        // NOTE: a small LRU cache around this call might be needed if
        // performance proves to be an issue
        TreeNode n = widenBindableIsolationScope(node, b);
        return isUsedOutsideOfNode(b, n, qc, checkFilters);
    }

    /**
     * Find the most specific query control for the node
     * 
     * @param node
     *            node for which to find controller
     * @param qc
     *            base controller
     * @return query info for node
     */
    public static QueryInformation getMostSpecificController(TreeNode node, QueryInformation qc) {
        if (node instanceof Subquery) {
            return ((Subquery) node).getSubqueryController();
        } else {
            if (node.getParent() == null) {
                return qc;
            } else {
                return getMostSpecificController(node.getParent(), qc);
            }
        }

    }

    /**
     * Tests if a given variable (or blank node) is needed outside of a given node and its descendants.
     * 
     * It may only be used outside the node and its children in a union that is a ancestor of the node, since unions do not require matching between their
     * children nodes.
     * 
     * To be conservative, this method is allowed return true for some cases (hopefully few) where the bindable is not actually needed outside the node, but
     * must never return false when bindable is needed outside the scope.
     * 
     * @param b
     *            The variable or blank node to test.
     * @param n
     *            The root node of the tree segment that should be excluded from a search
     * @param qc
     *            The {@link QueryInformation} that provides a look at the entire query
     * @return true if the given variable appears in the query outside of a given node and its descendants.
     */
    private static boolean isUsedOutsideOfNode(Bindable b, TreeNode n, QueryInformation qc, boolean checkFilters) {
        // TODO -- fix to work for blank nodes (for now, err conservatively)
        if (!(b instanceof Variable))
            return true;

        // 1) is the bindable used in the query pattern outside of the node?
        Integer here = n.getVariableCount().get(b);
        Integer everywhere = qc.getQueryPattern().getVariableCount().get(b);
        if (here == null)
            here = 0;
        if (everywhere == null)
            everywhere = 0;

        if (everywhere > here)
            return true;
        // 2) is it used in a SELECT list (or ORDER BY)? a CONSTRUCT template? a
        // DESCRIBE clause?
        // Lee: there can be filters in scope for n that are not in scope for
        // qc, so the
        // following check isn't sufficient

        if (checkFilters) {
            Set<org.openanzo.glitter.syntax.abstrakt.Expression> filters = n.getInScopeFilterSet();
            for (org.openanzo.glitter.syntax.abstrakt.Expression e : filters) {
                if (e.getReferencedVariables().contains(b)) {
                    return true;
                }
            }
        }

        QueryType queryType = qc.getQueryType();
        switch (queryType) {
        case SELECT: {
            Projection projection = (Projection) qc.getQueryResultForm();
            List<Expression> projectedExpressions = projection.getProjectedExpressions();
            for (Expression e : projectedExpressions) {
                if (e.getReferencedVariables().contains(b))
                    return true;
                if (e instanceof FunctionCall && ((FunctionCall) e).starArgument())
                    return true;
            }
            for (OrderingCondition oc : qc.getOrderingConditions())
                if (oc.getCondition().getReferencedVariables().contains(b))
                    return true;
            if (projection.getGroupByVariables() != null && projection.getGroupByVariables().contains(b))
                return true;
            break;
        }
        case CONSTRUCT: {
            Construct construct = (Construct) qc.getQueryResultForm();
            for (TriplePatternNode tpn : construct.getTemplate())
                if (tpn.containsVariable((Variable) b))
                    return true;
            for (TriplePatternComponent tpc : construct.getTemplateGraphComponents())
                if (tpc != null && tpc.equals(b))
                    return true;
            break;
        }
        case DESCRIBE:
        case ASK: {
            return false;
        }
        }
        return false;
    }

    /**
     * 
     * Searches for the greatest ancestor of the provided node where none of the descendants need or constrain the provided bindable from the provided node.
     * 
     * The logic behind this widening is that unioned graph patterns may share bindables by name but do not use the bindables to constrain between the unioned
     * graph patterns. So, these bindables *may* not need to be bound even though they are outside the tree node that is considering if they should be bound.
     * 
     * The current implementation searches up the tree from the provided node for the first union node and returns it if the provided node is the only leaf of
     * the union node. Otherwise the implementation returns the provided node.
     * 
     * NOTE: a more general approach would be to traverse up the tree, only allowing getVariableCount().get(b) to increase at UNION nodes and returning the
     * highest node where this condition remains true. This possible approach's heavy of getVariableCount() should be considered carefully by potential
     * implementers.
     * 
     * @param node
     *            The node to find a union ancestor for.
     * @param b
     *            The bindable from the node to find a wider scope for.
     * @return The Union ancestor, or the provided node if there is no union ancestor or the provided node is not the only leaf below the union node
     */
    private static TreeNode widenBindableIsolationScope(TreeNode node, Bindable b) {
        if (!(b instanceof Variable))
            return node; // this only applies to variables

        Variable var = (Variable) b;

        TreeNode current = node;
        TreeNode parent = node.getParent();

        while (parent != null) {
            if (parent instanceof Union) // found it
                return parent;

            // this is, conceptually, the most simple check to achieve what we
            // need here
            // if(parent.getVariableCount().get(b).intValue() !=
            // current.getVariableCount().get(b)) return null;
            //
            // ... but we'll do two quick, and slightly more conservative,
            // checks to avoid heavy use of getVariableCount():
            //
            // 1) make sure each ancestor below the union has only one child
            List<? extends TreeNode> iter = parent.getChildren();
            if (iter == null || iter.isEmpty() || !ObjectUtils.equals(iter.get(0), current) || iter.size() > 1)
                return node;

            // 2) if a ancestor is a Graph node, make sure it doesn't bind the
            // graph context to any variables in the provided node
            if (parent instanceof Graph) {
                TriplePatternComponent graphContext = ((Graph) parent).getGraphContext();
                if (graphContext instanceof Variable && var.equals(graphContext))
                    return node;
            }

            // 3) make sure the ancestor doesn't have filters
            if (parent.getFilters() != null && parent.getFilters().size() > 0)
                return node;

            current = parent;
            parent = parent.getParent();
        }

        return node;
    }

    /**
     * 
     * @param v
     *            Value to test.
     * @return True if the supplied value is a typed literal with a lexical form that is not valid for the datatype
     */
    public static boolean isMalformedLiteral(Value v) {
        if (v instanceof TypedLiteral) {
            try {
                ((TypedLiteral) v).getNativeValue();
            } catch (Exception e2) {
                return true;
            }
        }
        return false;
    }
}
