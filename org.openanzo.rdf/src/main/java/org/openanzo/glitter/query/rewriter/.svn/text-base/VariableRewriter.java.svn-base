/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/rewriter/VariableRewriter.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: VariableRewriter.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query.rewriter;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.query.TreeRewriter;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.glitter.syntax.abstrakt.Graph;
import org.openanzo.glitter.syntax.abstrakt.GraphPattern;
import org.openanzo.glitter.syntax.abstrakt.Optional;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;
import org.openanzo.glitter.syntax.abstrakt.TriplePatternNode;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.rdf.Bindable;
import org.openanzo.rdf.TriplePattern;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Variable;

/**
 * The {@link VariableRewriter} rewrites a triple pattern that contains a variable which is bound to only a single value in the supplied bindings.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class VariableRewriter implements TreeRewriter {
    private final Map<Bindable, Value> bindings;

    /**
     * Constructor.
     * 
     * @param bindings
     *            Current bindings.
     */
    public VariableRewriter(Map<Bindable, Value> bindings) {
        this.bindings = bindings;
    }

    private boolean bindableBoundInOptionalOnly(Bindable b, TreeNode node) {
        if (!(b instanceof Variable))
            return false;
        Variable v = (Variable) b;
        ArrayList<Optional> optionalAncestors = new ArrayList<Optional>();
        TreeNode p = node.getParent();
        while (p != null) {
            if (p instanceof Optional)
                optionalAncestors.add((Optional) p);
            p = p.getParent();
        }
        for (Optional o : optionalAncestors) {
            GraphPattern must = o.getMustMatchPattern();
            if (must == null || must.mightBindVariable(v))
                return true;
        }
        return false;
    }

    public TreeNode rewriteTreeNode(TreeNode node) {
        if (node instanceof Graph) {
            Graph graph = (Graph) node;
            TriplePatternComponent context = graph.getGraphContext();
            if (context instanceof Bindable) {
                Value value = this.bindings.get(context);
                if (value != null && !inScopeFilterReferencesBindable(node, (Bindable) context) && !bindableBoundInOptionalOnly((Bindable) context, node)) {
                    Glitter.getLog().debug(LogUtils.GLITTER_MARKER, "Replacing graph variable with bound value");
                    return new Graph(value, graph.getGraphPattern());
                }
            }
        } else if (node instanceof TriplePatternNode) {
            TriplePattern pattern = ((TriplePatternNode) node).getTriplePattern();
            TriplePatternComponent subject = pattern.getSubject(), predicate = pattern.getPredicate(), object = pattern.getObject();
            boolean buildNewPattern = false;
            if (subject instanceof Bindable) {
                Value value = this.bindings.get(subject);
                if (value != null && !inScopeFilterReferencesBindable(node, (Bindable) subject) && !bindableBoundInOptionalOnly((Bindable) subject, node)) {
                    Glitter.getLog().debug(LogUtils.GLITTER_MARKER, "Replacing subject variable ({}) with bound value", subject);
                    subject = value;
                    buildNewPattern = true;
                }
            }
            if (predicate instanceof Bindable) {
                Value value = this.bindings.get(predicate);
                if (value != null && !inScopeFilterReferencesBindable(node, (Bindable) predicate) && !bindableBoundInOptionalOnly((Bindable) predicate, node)) {
                    Glitter.getLog().debug(LogUtils.GLITTER_MARKER, "Replacing predicate variable with bound value");
                    predicate = value;
                    buildNewPattern = true;
                }
            }
            if (object instanceof Bindable) {
                Value value = this.bindings.get(object);
                if (value != null && !inScopeFilterReferencesBindable(node, (Bindable) object) && !bindableBoundInOptionalOnly((Bindable) object, node)) {
                    Glitter.getLog().debug(LogUtils.GLITTER_MARKER, "Replacing object variable with bound value");
                    object = value;
                    buildNewPattern = true;
                }
            }
            if (buildNewPattern)
                return new TriplePatternNode(subject, predicate, object);
        }
        return node;
    }

    private boolean inScopeFilterReferencesBindable(TreeNode n, Bindable b) {
        Set<Expression> filters = n.getInScopeFilterSet();
        for (Expression filter : filters)
            if (filter.getReferencedVariables().contains(b))
                return true;
        return false;
    }
}
