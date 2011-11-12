/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/PatternSolution.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: PatternSolution.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.util.Collection;

import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.rdf.Bindable;
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Variable;

/**
 * See http://www.w3.org/TR/rdf-sparql-query/#PatternSolutions
 * 
 * A pattern solution is a potential single row in a result set. It maps variables as well as blank nodes (Bindable objets) to RDF terms.
 * 
 * @author Lee
 * 
 */
public interface PatternSolution extends Comparable<PatternSolution> {

    /**
     * Returns the domain of variables and blank nodes in this solution.
     * 
     * @param sort
     *            If <tt>true</tt>, the {@link Bindable}s will be sorted stably
     * @return A (possibly-sorted) collection representing the bound variables and blank nodes in this solution
     */
    public Bindable[] getBoundDomain(boolean sort);

    /**
     * Sort the bindings
     */
    public void sort();

    /**
     * 
     * @return The number of bindings in this solution.
     */
    public int size();

    /**
     * 
     * @return the domain of variables and blank nodes in this solution as an array.
     */
    public Bindable[] getBoundDomainArray();

    /**
     * @param sort
     * @return array of bound variables
     */
    public Value[] getBoundVariablesArray(boolean sort);

    /**
     * As in {@link #getBoundDomain(boolean)} with a <tt>false</tt> argument, but only returns {@link Variable}s, not {@link BlankNode}s.
     * 
     * @return set of {@link Variable}s
     */
    public Collection<Variable> getBoundVariables();

    /**
     * Returns the binding for the given variable or blank node.
     * 
     * @param variable
     * @return The value of this variable or blank node; <tt>null</tt> if the variable is not bound.
     */
    public Value getBinding(Bindable variable);

    /**
     * Get the value of the binding
     * 
     * @param variableName
     *            name of binding to retrieve
     * @return value of binding
     */
    public Value getBinding(String variableName);

    /**
     * Sets a {@link Bindable}+value pair in this solution
     * 
     * @param variable
     *            The key.
     * @param value
     *            The value.
     */
    public void setBinding(Bindable variable, Value value);

    /**
     * Removes a binding from a pattern solution
     * 
     * @param variable
     *            The key.
     * 
     *            public void removeBinding(Bindable variable);
     */

    /**
     * @param index
     *            index of binding
     * @return binding at location
     */
    public Bindable getBinding(int index);

    /**
     * @param index
     *            index of value
     * @return value at location
     */
    public Value getValue(int index);

    /**
     * Return if all the provided variables are bound within the solution
     * 
     * @param variables
     * @return true if all the provided variables are bound with the solution
     */
    public boolean bindsAllVariables(Collection<Variable> variables);

    /**
     * See: http://wiki.atg.ibm.com/index.php?title=SPARQL_algebra#Conjunction
     * 
     * @param other
     *            The second operand of the conjunction operation.
     * @return The result of conjoining these two pattern solutions, or null if the two solutions are mutually exclusive.
     * @throws UnsupportedOperationException
     *             if this implementation cannot be conjoined with another.
     */
    //public PatternSolution conjoin(PatternSolution other) throws UnsupportedOperationException;
    public void clearConditions();

    public Value getCondition(OrderingCondition condition);

    public Value setCondition(OrderingCondition condition, Value value);
}
