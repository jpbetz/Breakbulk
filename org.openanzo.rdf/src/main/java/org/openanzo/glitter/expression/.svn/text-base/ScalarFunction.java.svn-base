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

import org.openanzo.glitter.expression.builtin.Bound;

/**
 * The interface representing all SPARQL functions that operate on simple values and terms, rather than on aggregates
 * of solutions. These functions either operate on evaluated values (variables bindings) or on terms (e.g. {@link Bound}). Also,
 * while most functions return a type error if any argument is a type error, some functions may choose to
 * operate on type error arguments.
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public interface ScalarFunction extends Function {
	/**
	 *
	 * @return <tt>true</tt> if this function's arguments should be values evaluated in the context of
	 * the environment created from each set of bindings (solution); <tt>false</tt> if the function operates
	 * directly on the surface term (e.g. a hypothetical function <tt>isVariable</tt> would operate on terms
	 * and return <tt>false</tt>)
	 */
	public boolean operatesOnValues(); // as opposed to on terms
	/**
	 *
	 * @return <tt>true</tt> if the function can process type errors as arguments; <tt>false</tt> if the function
	 * simply propagates type errors
	 */
	public boolean operatesOnTypeErrors(); // as opposed to propagating errors blindly
}
