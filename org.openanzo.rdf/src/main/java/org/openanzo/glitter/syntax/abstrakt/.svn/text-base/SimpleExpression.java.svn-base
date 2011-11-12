/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/syntax/abstrakt/SimpleExpression.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: SimpleExpression.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.syntax.abstrakt;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryController;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.glitter.query.QueryController.QueryStringPrintOptions;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Variable;

/**
 * A SimpleExpression represents an expression (i.e., in a FILTER or ORDER BY) which is simply a TriplePatternComponent (a variable, IRI ref., bnode, or
 * literal).
 *
 * @author Lee
 *
 */
public class SimpleExpression implements Expression {
    private final TriplePatternComponent term;
    private int hashCode = -1;

    /**
     * Constructs a {@link SimpleExpression} from an {@link Value} or {@link Variable}.
     *
     * @param tpc
     */
    public SimpleExpression(TriplePatternComponent tpc) {
        this.term = tpc;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SimpleExpression && this.term != null && ((SimpleExpression)obj).term != null && this.term.equals(((SimpleExpression)obj).term);
    }

    @Override
    public int hashCode() {
        if (hashCode == -1)
            hashCode = this.term.hashCode();
        return hashCode;
    }

    public Value evaluate(PatternSolution environment, SolutionSet group) throws ExpressionEvaluationException {
        // TODO - what to do with bnodes here? this is still
        // an open question on the DAWG (Lee, 2006-07-14)
        if (this.term instanceof Variable)
            return environment.getBinding((Variable) this.term);
        return (Value) this.term;
    }

    /**
     *
     * @return The triple pattern component that comprises this expression.
     */
    public TriplePatternComponent getTerm() {
        return this.term;
    }

    public Set<Variable> getReferencedVariables() {
        HashSet<Variable> vars = new HashSet<Variable>();
        if (this.term instanceof Variable)
            vars.add((Variable) this.term);
        return vars;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getTerm());
        return builder.toString();
    }

    public void prettyPrintQueryPart(EnumSet<QueryStringPrintOptions> printFlags, int indentLevel, Map<String, String> uri2prefix, StringBuilder s) {
        QueryController.printTriplePatternComponent(this.term, printFlags, uri2prefix, s);
    }

    public void prettyPrint(StringBuilder output) {
        output.append(this.getTerm());
    }

    public Collection<Variable> getBindableVariables() {
        return Collections.emptyList();
    }

    public Collection<URI> getReferencedURIs() {
        if (this.term instanceof URI)
            return Collections.singletonList((URI) this.term);
        return Collections.emptyList();
    }
}
