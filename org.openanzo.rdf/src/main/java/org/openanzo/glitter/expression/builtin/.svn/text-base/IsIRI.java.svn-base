/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/builtin/IsIRI.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: IsIRI.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression.builtin;

import org.openanzo.glitter.exception.IncompatibleTypeException;
import org.openanzo.glitter.expression.UnaryFunction;
import org.openanzo.glitter.util.Constants;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.NAMESPACES;

/**
 * Implements <a href="http://www.w3.org/TR/rdf-sparql-query/#func-isIri">the SPARQL isIri function</a>.
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class IsIRI extends UnaryFunction {
		@Override
	public Value call(Value arg1)
			throws IncompatibleTypeException {
		return (arg1 != null && arg1 instanceof URI)?Constants.TRUE:Constants.FALSE;
	}

	public org.openanzo.rdf.URI getIdentifier() {
		return Glitter.createURI(NAMESPACES.BUILTIN_NAMESPACE + "isIRI");
	}

}
