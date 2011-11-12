/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/Function.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: Function.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression;

import java.util.List;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Variable;

/**
 * The base interface representing all SPARQL aggregate functions. SPARQL functions are identified by a {@link URI}, and operate on sets of solutions.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
//TODO: Aggregates could be structured to calculate their values by being passed one solution at a time for a group, and then asking for the aggregate value. This would allow us to calculate aggregates in parallel. This probably doesn't save us anything substantial.
public interface AggregateFunction extends Function {
    /**
     * Invokes the function and determines a return value.
     * 
     * @param arguments
     *            The ordered list of variable arguments to this instance of the aggregate. If the aggregate is invoked with a * (e.g. COUNT(*), then arguments
     *            is empty.
     * @param group
     *            The set of solutions for which an aggregate is computed.
     * @return The result of evaluating this function against the given arguments
     * @throws ExpressionEvaluationException
     *             For invalid types, or other expression evalutaion problems
     */
    public Value call(List<Variable> arguments, SolutionSet group) throws ExpressionEvaluationException;

}
