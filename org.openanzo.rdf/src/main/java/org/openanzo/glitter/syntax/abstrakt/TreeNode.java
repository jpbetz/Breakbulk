/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/syntax/abstrakt/TreeNode.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: TreeNode.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.syntax.abstrakt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.openanzo.glitter.query.QueryPart;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Variable;
import org.openanzo.rdf.utils.NullIterator;
import org.openanzo.rdf.utils.PrettyPrintable;

/**
 * A TreeNode is the (abstract) base class for all nodes in the abstract syntax of a SPARQL query.
 *
 * TreeNodes also maintain a cache of properties calculated recursively over a node and its descendants.
 *
 * @author Lee Feigenbaum <lee@cambridgesemantics.com>
 *
 */
public abstract class TreeNode implements PrettyPrintable, QueryPart {

    static private final String               varsetKey           = "varset";

    static private final String               bindableVarsetKey   = "bindable-varset";

    static private final String               urisKey             = "uris";

    static private final String               inScopeFilterSetKey = "filterset";

    static final protected Iterator<TreeNode> emptyIterator       = new NullIterator<TreeNode>();

    private TreeNode                          parent              = null;

    private final HashMap<String, Object>   cache               = new HashMap<String, Object>();

    private final void clearCacheData(String key) {
        if (key == null)
            this.cache.clear();
        else
            this.cache.remove(key);
    }

    /**
     * Clear the cache corresponding to the given <tt>key</tt>
     *
     * @param key
     */
    private final void invalidateCache(String key) {
        for (TreeNode node = this; node != null; node = node.getParent())
            node.clearCacheData(key);
    }

    /**
     * Invalidate the entire cache.
     */
    public final void invalidateCache() {
        invalidateCache((String) null);
    }

    /**
     * Set the parent of this node
     *
     * @param p
     *            parent node
     */
    public void setParent(TreeNode p) {
        // Currently, all mutations of the tree touch on this point,
        // so we can safely just put our calls to invalidate the cache
        // here
        this.parent = p;
        if (p != null)
            p.invalidateCache();
        else
            // setting this node as the root - do we need to invalidate the cache?
            invalidateCache();
    }

    /**
     * @return The parent of this {@link TreeNode}. If this is the root of a query, returns <tt>null</tt>.
     */
    public TreeNode getParent() {
        return this.parent;
    }

    /**
     * Find all the ancestors for this node
     *
     * @param <T>
     *            type of ancestors to find
     * @param clazz
     *            ancestor type
     * @return ancestors of a certain type
     */
    public final <T extends TreeNode> List<T> findAncestors(Class<T> clazz) {
        List<T> matches = new ArrayList<T>();
        TreeNode current = this.getParent();
        while (current != null) {
            if (clazz.isInstance(current)) {
                matches.add(clazz.cast(current));
            }
            current = current.getParent();
        }
        return matches;
    }

    /**
     *
     * @return An {@link Iterator} over the children of this node.
     */
    public abstract List<? extends TreeNode> getChildren();

    /**
     * Clone the tree node to produce an equivalent node that does not share references.
     *
     * @return the clone
     */
    @Override
    public abstract TreeNode clone();

    /**
     * Changes the tree below this node by replacing <tt>oldChild</tt> with <tt>newChild</tt>
     *
     * @param oldChild
     * @param newChild
     * @return <tt>true</tt> if the <tt>oldChild</tt> was found and replaced; <tt>false</tt> otherwise.
     */
    public abstract boolean replaceChild(TreeNode oldChild, TreeNode newChild);

    /**
     * Removes the given <tt>child</tt> from the collection of children
     *
     * @param child
     * @return <tt>true</tt> if the <tt>child</tt> was found and removed; <tt>false</tt> otherwise.
     */
    public abstract boolean removeChild(TreeNode child);

    /**
     * Adds the given <tt>child</tt> at the end of this node's children.
     *
     * @param child
     */
    public abstract void addChild(TreeNode child);

    /**
     * @param v
     * @return whether or not this node and its subtree contains {@link Variable} <tt>v</tt>.
     */
    final public boolean containsVariable(Variable v) {
        return containsVariable(v, false);
    }

    /**
     * @param v
     * @return whether or not this node and its subtree contains {@link Variable} <tt>v</tt> in a position that it could receive bindings (e.g., a variable in a
     *         FILTER cannot receive bindings, but a variable in the GRAPH clause can.
     */
    final public boolean mightBindVariable(Variable v) {
        return containsVariable(v, true);
    }

    final private boolean containsVariable(Variable v, boolean canAddBindings) {
        Integer c = getVariableCount(canAddBindings).get(v);
        return c != null && c > 0;
    }

    @SuppressWarnings("unchecked")
    protected Map<Variable, Integer> getVariableCount(boolean onlyBindableVariables) {
        String k = onlyBindableVariables ? bindableVarsetKey : varsetKey;
        Object o = this.cache.get(k);
        if (o != null)
            return (Map<Variable, Integer>) o;
        HashMap<Variable, Integer> vars = new HashMap<Variable, Integer>();
        for (TreeNode n: getChildren()) {
            if (n != null) {
                Map<Variable, Integer> childVars = n.getVariableCount(onlyBindableVariables);
                for (Entry<Variable, Integer> e : childVars.entrySet())
                    incrementVariableCount(vars, e.getKey(), e.getValue());
            }
        }
        this.cache.put(k, vars);
        return vars;
    }

    @SuppressWarnings("unchecked")
    public Collection<URI> getReferencedURIs() {
        Object o = this.cache.get(TreeNode.urisKey);
        if (o != null)
            return (Collection<URI>) o;
        HashSet<URI> uris = new HashSet<URI>();
        for (TreeNode n: getChildren()) {
            if (n != null)
                uris.addAll(n.getReferencedURIs());
        }
        this.cache.put(TreeNode.urisKey, uris);
        return uris;
    }

    static protected void incrementVariableCount(Map<Variable, Integer> m, Variable v, int incrementBy) {
        Integer current = m.get(v);
        m.put(v, (current != null ? current : 0) + incrementBy);
    }

    /**
     * @return A map from variables to counts for all variables that appear in this node and its descendants.
     */
    final public Map<Variable, Integer> getVariableCount() {
        return getVariableCount(false);
    }

    /**
     * @return A map from variables to counts for all variables that appear in this node and its descendants. This only counts instances of {@link Variable}s
     *         that can receive bindings. (As in {@link #mightBindVariable(Variable)}.
     */
    final public Map<Variable, Integer> getBindableVariableCount() {
        return getVariableCount(true);
    }

    /**
     * @return A set of all variables that occur in this node and its descendants.
     */
    final public Set<Variable> getReferencedVariables() {
        return getVariableCount().keySet();
    }

    /**
     * @return A set of all variables that occur in this node and its descendants that may receive bindings.
     */
    final public Set<Variable> getBindableVariables() {
        return getBindableVariableCount().keySet();
    }

    /**
     *
     * @return The root of the tree that contains this {@link TreeNode}.
     */
    final public TreeNode getRoot() {
        TreeNode root = this;
        while (root.parent != null)
            root = root.parent;
        return root;
    }

    /**
     *
     * @return A set of all filters {@link Expression}s that are in scope (act on the bindings) for this tree node.
     */
    @SuppressWarnings("unchecked")
    final public Set<Expression> getInScopeFilterSet() {
        Object o = this.cache.get(inScopeFilterSetKey);
        if (o != null)
            return (Set<Expression>) o;
        HashSet<Expression> filters = new HashSet<Expression>();
        CollectionUtils.addAll(filters, this.getFilters().iterator());
        if (this.getParent() != null)
            filters.addAll(this.getParent().getInScopeFilterSet());
        this.cache.put(inScopeFilterSetKey, filters);
        return filters;
    }

    /**
     * Default implementation of {@link #getFilters()}. Most tree nodes cannot contain filters.
     *
     * @return Default implementation of {@link #getFilters()}.
     */
    public Set<Expression> getFilters() {
        return new HashSet<Expression>();
    }

    /**
     * Pretty prints this tree node to the given {@link StringBuffer}.
     *
     * @param output
     */
    public void prettyPrint(StringBuilder output) {
        this.prettyPrint(output, true);
    }

    /**
     * Pretty prints this tree node to the given {@link StringBuffer}.
     *
     * @param output
     * @param deep
     *            If <tt>true</tt>, recurse into descendants. Otherwise, includes an elipsis ("...") for any children.
     */
    public void prettyPrint(StringBuilder output, boolean deep) {
        output.append(this.getClass().getSimpleName());
        output.append("(");

        List<? extends TreeNode> it = getChildren();
        if (prettyPrintParams(output) && deep) {
            if (it.size()>0)
                output.append(",");
            output.append(" ");
        }
        if (deep) {
            int i = 0;
            for (TreeNode tn:getChildren()) {
                if (i++ > 0)
                    output.append(", ");
                if (tn == null)
                    output.append("null");
                else
                    tn.prettyPrint(output);
            }
        } else {
            output.append("...");
        }
        output.append(")");
    }

    protected boolean prettyPrintParams(StringBuilder output) {
        return false;
    }
}
