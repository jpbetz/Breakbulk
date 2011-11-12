/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/syntax/abstrakt/Union.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: Union.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.syntax.abstrakt;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.exception.GlitterRuntimeException;
import org.openanzo.glitter.query.QueryController;
import org.openanzo.glitter.query.QueryController.QueryStringPrintOptions;

/**
 * Represents a UNION construct from a SPARQL query. The algebra of the SPARQL specification dictates binary unions, but Glitter allows for the possibility of
 * n-ary unions.
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class Union extends GraphPattern {
    private final ArrayList<GraphPattern> patterns;

    @Override
    public Union clone() {
        Union u = new Union();
        for (GraphPattern gp : patterns)
            u.addGraphPattern((GraphPattern) gp.clone());
        return u;
    }

    /**
     * Construct a union from two operand graph patterns.
     *
     * @param p1
     * @param p2
     */
    public Union(GraphPattern p1, GraphPattern p2) {
        this.patterns = new ArrayList<GraphPattern>();
        this.patterns.add(p1);
        this.patterns.add(p2);
        for (GraphPattern gp : this.patterns)
            gp.setParent(this);
    }

    /**
     * Default constructor. (Contains no operands.)
     */
    public Union() {
        this.patterns = new ArrayList<GraphPattern>();
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.patterns.size(); i++) {
            if (i > 0)
                s += " UNION ";
            s += "{ " + this.patterns.get(i) + " }";
        }
        return s;
    }

    public void prettyPrintQueryPart(EnumSet<QueryStringPrintOptions> printFlags, int indentLevel, Map<String, String> uri2prefix, StringBuilder s) {
        for (int i = 0; i < this.patterns.size(); i++) {
            if (i > 0)
                s.append(" UNION ");
            s.append("{");
            indentLevel++;
            QueryController.printSeparator(printFlags, indentLevel, s);
            this.patterns.get(i).prettyPrintQueryPart(printFlags, indentLevel, uri2prefix, s);
            indentLevel--;
            QueryController.printSeparator(printFlags, indentLevel, s);
            s.append("}");
        }
    }

    /**
     * Add the given graph pattern to this {@link Union}.
     *
     * @param gp
     */
    public void addGraphPattern(GraphPattern gp) {
        this.patterns.add(gp);
        gp.setParent(this);
    }

    /**
     *
     * @return A list of {@link GraphPattern} that are the operands to this {@link Union}.
     */
    public ArrayList<GraphPattern> getGraphPatterns() {
        return this.patterns;
    }

    @Override
    public List<GraphPattern> getChildren() {
        return this.patterns;
    }

    @Override
    public boolean replaceChild(TreeNode oldChild, TreeNode newChild) {
        if (newChild instanceof GraphPattern) {
            for (ListIterator<GraphPattern> it = this.patterns.listIterator(); it.hasNext();) {
                GraphPattern current = it.next();
                if (current == oldChild) {
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
    public boolean removeChild(TreeNode child) {
        return this.patterns.remove(child);
    }

    @Override
    public void addChild(TreeNode child) {
        if (child instanceof GraphPattern) {
            this.patterns.add((GraphPattern) child);
            child.setParent(this);
        } else
            throw new GlitterRuntimeException(ExceptionConstants.GLITTER.ONLY_ADD, "GraphPattern", "Union Query");
    }
}
