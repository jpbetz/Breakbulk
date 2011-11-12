/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/query/Attic/QueryEncoder.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Oct 31, 2006
 * Revision:	$Id: QueryEncoder.java 200 2007-08-01 16:25:35Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.query;

import org.openanzo.rdf.Literal;
import org.openanzo.rdf.PlainLiteral;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;

/**
 * Encodes a Literal for use in a SPARQL query.
 * 
 * @author Joe Betz
 */
public class QueryEncoder {

    private static final String LANG_PREFIX  = "\"@";

    private static final String TYPE_PREFIX  = "^^";

    private static final String DOUBLE_SLASH = "\\\\";

    private static final String QUAD_SLASH   = "\\\\\\\\";

    private static final String B            = "\b";

    private static final String ESC_B        = "\\\\b";

    private static final String TAB          = "\t";

    private static final String ESC_TAB      = "\\\\t";

    private static final String NEW_LINE     = "\n";

    private static final String ESC_NEW_LINE = "\\\\n";

    private static final String RETURN       = "\r";

    private static final String ESC_RETURN   = "\\\\r";

    private static final String QUOTE        = "\"";

    private static final String ESC_QUOTE    = "\\\\\"";

    private static final String APOS         = "\'";

    private static final String ESC_APOS     = "\\\\'";

    /**
     * Encapsulate Value into string representation valid for SPARQL query
     * 
     * @param value
     *            Value to convert
     * @return String representation of value
     */
    public static String encodeForQuery(Value value) {

        if (value instanceof URI) {
            return '<' + value.toString() + '>';
        } else if (value instanceof Literal) {
            return encodeLiteral((Literal) value);
        } else {
            return value.toString();
        }
    }

    private static String encodeLiteral(Literal literal) {
        if (literal instanceof TypedLiteral) {
            URI dt = ((TypedLiteral) literal).getDatatypeURI();
            return '\"' + literal.getLabel() + '\"' + TYPE_PREFIX + encodeForQuery(dt);
        } else if (literal instanceof PlainLiteral) {
            String lang = ((PlainLiteral) literal).getLanguage();
            if (lang != null) {
                return '\"' + literal.getLabel() + LANG_PREFIX + lang;
            }
        }
        return '\"' + literal.getLabel() + '\"';
    }

    /**
     * Encodes a String instance of the xsd:String type for use in SPARQL.
     * 
     * @param literalString
     *            string to encode with escaped values
     * @return literal string encoded with escaped values
     */
    public static String encodeForQuery(String literalString) {
        return literalString.replaceAll(DOUBLE_SLASH, QUAD_SLASH).replaceAll(B, ESC_B).replaceAll(TAB, ESC_TAB).replaceAll(NEW_LINE, ESC_NEW_LINE).replaceAll(RETURN, ESC_RETURN).replaceAll(QUOTE, ESC_QUOTE).replaceAll(APOS, ESC_APOS);
    }
}
