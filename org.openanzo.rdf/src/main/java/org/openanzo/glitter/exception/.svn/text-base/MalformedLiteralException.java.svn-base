/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.openanzo.glitter.exception;

import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.TriplePatternComponent;

/**
 * Indicates that a literal has an invalid lexical value. For example: <code>"verdad"^^xsd:boolean</code> is a malformed literal because the lexical form of
 * <code>xsd:boolean</code> only allows: "true", "false", "0", or "1".
 * 
 * Not all typed literals are checked for conformance to their prescribed lexical form. The check only happens when it is necessary as part of evaluating the
 * SPARQL query. As such, this exception is most often triggered when a literal must be interpreted for use in comparison operations and type conversions.
 * 
 * @author Jordi A. Albornoz Mulligan <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>
 */
public class MalformedLiteralException extends ExpressionEvaluationException {

    private static final long serialVersionUID = -833986558871191833L;

    /**
     * Malformed Literal Exception
     * 
     * @param value
     * @param required
     */
    public MalformedLiteralException(TriplePatternComponent value, String required) {
        super(ExceptionConstants.GLITTER.MALFORMED_LITERAL, value != null ? value.toString() : "null", required);
    }

}
