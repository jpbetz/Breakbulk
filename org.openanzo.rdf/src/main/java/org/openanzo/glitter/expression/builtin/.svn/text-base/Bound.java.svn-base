/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/builtin/Bound.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: Bound.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression.builtin;

import java.util.List;

import org.openanzo.glitter.exception.IncompatibleTypeException;
import org.openanzo.glitter.exception.InvalidArgumentCountException;
import org.openanzo.glitter.expression.ScalarFunctionOnTerms;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.glitter.syntax.abstrakt.SimpleExpression;
import org.openanzo.glitter.util.Constants;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Variable;
import org.openanzo.rdf.Constants.NAMESPACES;

/**
 * Implements <a href="http://www.w3.org/TR/rdf-sparql-query/#func-bound">the SPARQL bound function</a>.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class Bound implements ScalarFunctionOnTerms {

    public Value call(List<Expression> args, PatternSolution environment) throws IncompatibleTypeException, InvalidArgumentCountException {
        if (args.size() != 1)
            throw new InvalidArgumentCountException(args.size(), 1);
        Expression arg = args.get(0);
        if (!(arg instanceof SimpleExpression))
            throw new IncompatibleTypeException(arg, "variable");
        TriplePatternComponent tpc = ((SimpleExpression) arg).getTerm();
        if (!(tpc instanceof Variable))
            throw new IncompatibleTypeException(tpc, "variable");
        return (environment.getBinding((Variable) tpc) != null) ? Constants.TRUE : Constants.FALSE;
    }

    public URI getIdentifier() {
        return Glitter.createURI(NAMESPACES.BUILTIN_NAMESPACE + "bound");
    }

    public boolean operatesOnValues() {
        return false;
    }

    public boolean operatesOnTypeErrors() {
        return false;
    }

    @Override
    public String toString() {
        return getIdentifier().getLocalName();
    }
}
