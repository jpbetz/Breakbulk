/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/FunctionalPredicate.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: FunctionalPredicate.java 198 2007-08-01 16:25:33Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import org.openanzo.glitter.exception.FunctionalPredicateInvocationException;
import org.openanzo.glitter.exception.GlitterException;
import org.openanzo.rdf.TriplePattern;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Variable;

/**
 * A {@link FunctionalPredicate} is a URI that generates bindings/solutions to a query in a different
 * fashion from the standard graph-pattern matching.
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public interface FunctionalPredicate {
	/**
	 * 
	 * @param qi Information on the current query executing
	 */
	public abstract void initialize(QueryInformation qi);
	/**
	 * 
	 * @return <b>true</b> if this FP will handle binding graph variables.
	 */
	public abstract boolean canBindGraphVariables();
	/**
	 * 
	 * @return <b>true</b> if this FP needs to examine graphs to get at data
	 */
	public abstract boolean usesDataFromGraphs();
	
	/**
	 * This is the first method invoked on a FunctionalPredicate. It sets the
	 * triple pattern which contains the functional predicate. The FunctionalPredicate
	 * implementation should save this information; it can also throw a FunctionalPredicateInvocationException
	 * if it does not wish to handle this triple pattern (for example, if it can not handle
	 * subject variables and this is a ?s ex:pred ?o triple pattern.
	 * @param pattern the triple pattern which contains the functional predicate
	 * @throws FunctionalPredicateInvocationException
	 */
	public abstract void setFunctionalTriplePattern(TriplePattern pattern) throws FunctionalPredicateInvocationException;
	
	/**
	 * Accessor for the triple pattern set with {@link #setFunctionalTriplePattern(TriplePattern)}. 
	 * @return The {@link TriplePattern} that contains this functional predicate.
	 */
	public abstract TriplePattern getFunctionalTriplePattern() ;
	
	/**
	 * After setFunctionalTriplePattern has been called, this method is called once
	 * for every triple pattern in the functional triple pattern's basic graph pattern
	 * (BGP). 
	 * @param pattern A triple pattern from the same BGP that the functional triple 
	 * pattern came from.
	 * @return <b>true</b> if this FunctionalPredicate will handle (and generate bindings for) this
	 * triple pattern; <b>false</b> otherwise.
	 * @throws FunctionalPredicateInvocationException
	 */
	public abstract boolean handlesTriplePattern(TriplePattern pattern) throws FunctionalPredicateInvocationException;
	
	/**
	 * Requests that solutions be generated against the default graph, a particular named graph, or spanning the named
	 * graphs (with a named graph variable). 
	 * @param namedGraph If not <tt>null</tt>, the named graph to use for generating bindings
	 * @param namedGraphVariable If not <tt>null</tt>, the functional predicate should generate solutions
	 * that bind this variable to the appropriate graph IRI for each solution generated.
	 * @param bindingConstraints Existing constraints on variables. This {@link FunctionalPredicate} can assume
	 * that the engine will conjoin the solutions it returns with these constraints. (And so can eliminate any
	 * solutions that would not add to a result set, if it wishes.)
	 * @return A {@link SolutionSet} from generating bindings using the logic of this functional predicate.
	 * @throws GlitterException
	 */
	public abstract SolutionSet generateSolutions(URI namedGraph, Variable namedGraphVariable, SolutionSet bindingConstraints) throws GlitterException;
	
	/**
	 * 
	 * @param costModel The cost model being used to generate an execution plan. This functional
	 * predicate can investigate the cost of various other types of nodes using this supplied
	 * cost model in order to generate its own estimate. 
	 * @return An estimated cost of evaluating this functional-predicate node. 
	 */
	public abstract double getCost(NodeCostModel costModel);
}
