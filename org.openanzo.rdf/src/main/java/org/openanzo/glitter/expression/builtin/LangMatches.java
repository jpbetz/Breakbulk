/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/builtin/LangMatches.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: LangMatches.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
  *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression.builtin;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.exception.IncompatibleTypeException;
import org.openanzo.glitter.expression.BinaryFunction;
import org.openanzo.glitter.util.Constants;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.glitter.util.TypeConversions;
import org.openanzo.rdf.PlainLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.NAMESPACES;

/**
 * Implements <a href="http://www.w3.org/TR/rdf-sparql-query/#func-langMatches">the SPARQL langMatches function</a>.
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class LangMatches extends BinaryFunction {
	@Override
	public Value call(Value arg1, Value arg2)
			throws ExpressionEvaluationException {
		if (!TypeConversions.isSimpleLiteral(arg1))
			throw new IncompatibleTypeException(arg1, "simple literal");
		if (!TypeConversions.isSimpleLiteral(arg2))
			throw new IncompatibleTypeException(arg2, "simple literal");
		String languageTag = ((PlainLiteral)arg1).getLabel();
		String languageRange = ((PlainLiteral)arg2).getLabel();
		if (languageRange.equals("*") && languageTag.length() > 0)
			return Constants.TRUE;
		return (
			languageTag.equalsIgnoreCase(languageRange) || 
			(
				languageTag.length() > languageRange.length() && 
				languageTag.substring(0, languageRange.length()).equalsIgnoreCase(languageRange) &&
				languageTag.charAt(languageRange.length()) == '-'	
			)
		)?Constants.TRUE:Constants.FALSE;
	}
	
	public URI getIdentifier() {
		return Glitter.createURI(NAMESPACES.BUILTIN_NAMESPACE + "langMatches");
	}

}
