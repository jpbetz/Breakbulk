/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.util.ArrayList;
import java.util.Collections;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.expression.builtin.Bound;
import org.openanzo.glitter.expression.builtin.IsLiteral;
import org.openanzo.glitter.expression.builtin.Lang;
import org.openanzo.glitter.expression.builtin.LangMatches;
import org.openanzo.glitter.expression.builtin.LogicalOr;
import org.openanzo.glitter.expression.builtin.Not;
import org.openanzo.glitter.expression.builtin.PolymorphicEq;
import org.openanzo.glitter.syntax.abstrakt.BGP;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.glitter.syntax.abstrakt.FunctionCall;
import org.openanzo.glitter.syntax.abstrakt.Group;
import org.openanzo.glitter.syntax.abstrakt.SimpleExpression;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;
import org.openanzo.glitter.syntax.abstrakt.TriplePatternNode;
import org.openanzo.glitter.syntax.concrete.ParseException;
import org.openanzo.rdf.MemPlainLiteral;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.Variable;

/**
 * Filters out all plain literals containing a language tag that does not match the provided RFC 3066 language tag.
 * 
 * The filter is of the form:
 * 
 * !bound(?var) || !isLiteral(?var) || lang(?var) == '' || langMatches(lang(?var), '<lang>')
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public class LangFilteringRewriter implements TreeRewriter {

    private final String lang;

    /**
     * Rewriter that uses the lang tags of literals
     * 
     * @param lang
     */
    public LangFilteringRewriter(String lang) {
        this.lang = lang;
    }

    public TreeNode rewriteTreeNode(TreeNode node) {
        try {
            if (node instanceof BGP) {
                BGP bgp = (BGP) node;
                BGP newBgp = bgp.clone();
                TreeNode parent = newBgp.getParent();

                boolean returnParent = false;
                Group parentGroup = null;
                if (parent instanceof Group) {
                    parentGroup = (Group) parent;
                } else {
                    parentGroup = new Group();
                    parentGroup.addChild(bgp);
                    returnParent = true;
                }

                for (TriplePatternNode tp : bgp.getTriplePatterns()) {
                    TriplePatternComponent obj = tp.getTriplePattern().getObject();
                    if (obj instanceof Variable) {
                        Variable var = (Variable) obj;

                        ArrayList<Expression> langMatchParams = new ArrayList<Expression>();
                        langMatchParams.add(new FunctionCall(new Lang(), Collections.<Expression> singletonList(new SimpleExpression(var))));
                        langMatchParams.add(new SimpleExpression(MemPlainLiteral.create(lang)));

                        FunctionCall langMatches = new FunctionCall(new LangMatches(), langMatchParams);

                        FunctionCall isLiteral = new FunctionCall(new Not(), Collections.<Expression> singletonList(new FunctionCall(new IsLiteral(), Collections.<Expression> singletonList(new SimpleExpression(var)))));

                        ArrayList<Expression> equalsParams = new ArrayList<Expression>();
                        equalsParams.add(new FunctionCall(new Lang(), Collections.<Expression> singletonList(new SimpleExpression(var))));
                        equalsParams.add(new SimpleExpression(MemPlainLiteral.create("")));
                        FunctionCall langEquals = new FunctionCall(new PolymorphicEq(), equalsParams);

                        FunctionCall bound = new FunctionCall(new Not(), Collections.<Expression> singletonList(new FunctionCall(new Bound(), Collections.<Expression> singletonList(new SimpleExpression(var)))));

                        ArrayList<Expression> orParams = new ArrayList<Expression>();
                        ArrayList<Expression> or2Params = new ArrayList<Expression>();
                        ArrayList<Expression> or3Params = new ArrayList<Expression>();

                        or3Params.add(langEquals);
                        or3Params.add(langMatches);
                        FunctionCall or3 = new FunctionCall(new LogicalOr(), or3Params);

                        or2Params.add(isLiteral);
                        or2Params.add(or3);
                        FunctionCall or2 = new FunctionCall(new LogicalOr(), or2Params);

                        orParams.add(bound);
                        orParams.add(or2);
                        FunctionCall or = new FunctionCall(new LogicalOr(), orParams);

                        parentGroup.addFilter(or);

                    }
                    if (returnParent) {
                        return parentGroup;
                    } else {
                        return newBgp;
                    }
                }

            }
            return node;
        } catch (ParseException e) {
            throw new AnzoRuntimeException(new AnzoException(ExceptionConstants.GLITTER.REWRITE_EXCEPTION, e, node.toString()));
        }
    }
}
