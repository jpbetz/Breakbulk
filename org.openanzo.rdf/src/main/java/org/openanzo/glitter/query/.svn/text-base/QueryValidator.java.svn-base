/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/QueryValidator.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: QueryValidator.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;


/**
 * A QueryValidator is a stateful class that determines whether or not the
 * engine will accept a given query. A single query might have to pass multiple
 * QueryValidators before being evaluated against an RDF dataset.
 * @author Lee
 *
 */
public interface QueryValidator {
	/**
	 * @param query The query to be validated
	 * @return True, if the query is OK; False, otherwise. If false, then
	 * getValidationError() may be called to return the reason for the failure
	 * to validate.
	 */
	public abstract boolean validateQuery(QueryInformation query);
	/**
	 * This method's return value is only valid after a call to validateQuery on the
	 * same instance returns false.
	 * @return The reason for a failure to validate.
	 */
	public abstract String getValidationError();
	/**
	 * Returns a human-readable description of what this QueryValidator checks for.
	 * @return A human-readable description of what this QueryValidator checks for.
	 */
	public abstract String getValidatorDescription();
}
