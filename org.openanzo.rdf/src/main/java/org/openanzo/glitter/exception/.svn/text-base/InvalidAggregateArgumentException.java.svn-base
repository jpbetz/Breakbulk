/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/exception/UnknownFunctionException.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: UnknownFunctionException.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
  *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.exception;

import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.glitter.syntax.concrete.ParseException;

/**
 * Thrown if a query references (in a FILTER or ORDER BY) a URI that doesn't identify a known function.
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class InvalidAggregateArgumentException extends ParseException {
	private static final long serialVersionUID = -569451207412634664L;

	/**
	 *
	 * @param e The invalid argument expression.
	 */
	public InvalidAggregateArgumentException(Expression e) {
		super("Arguments to aggregate functions must be '*' or variables: " + e.toString());
	}

	/**
	 *
	 */
	public InvalidAggregateArgumentException() {
	    super("Aggregate functions must take at least one variable or '*' as arguments");
	}

}
