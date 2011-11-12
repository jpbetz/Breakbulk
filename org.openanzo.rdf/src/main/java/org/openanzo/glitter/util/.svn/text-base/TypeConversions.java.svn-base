/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/util/TypeConversions.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: TypeConversions.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.util;

import org.openanzo.glitter.exception.IncompatibleTypeException;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.PlainLiteral;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.vocabulary.XMLSchema;

/**
 * A collection of utility methods related to type conversions.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class TypeConversions {

    /**
     * Extract native boolean value from a literal with type boolean.
     * 
     * @param term
     *            TriplePatternComponent to convert
     * @return native boolean value from a literal with type boolean.
     * @throws IncompatibleTypeException
     */
    static public boolean booleanValue(TriplePatternComponent term) throws IncompatibleTypeException {
        if (term instanceof TypedLiteral && ((TypedLiteral) term).getDatatypeURI().equals(XMLSchema.BOOLEAN))
            return (Boolean) ((TypedLiteral) term).getNativeValue();
        throw new IncompatibleTypeException(term, "xsd:boolean");
    }

    /**
     * Extract native boolean value from a literal by using the SPARQL effective boolean value.
     * 
     * @param term
     *            TriplePatternComponent to convert
     * @return native boolean value from a literal by using the SPARQL effective boolean value
     * @throws IncompatibleTypeException
     */
    static public boolean effectiveBooleanValue(TriplePatternComponent term) throws IncompatibleTypeException {
        if (term == Constants.TRUE)
            return true;
        else if (term == Constants.FALSE)
            return false;
        // This implements the rules in Sec. 11.2.2 of the SPARQL QL spec
        if (term instanceof Literal) {
            Literal litTerm = (Literal) term;
            // anzo uses a single literal class that claims to be both a plain literal and a typed literal
            // so we check for a non-empty datatype
            boolean hasDatatype = litTerm instanceof TypedLiteral && ((TypedLiteral) term).getDatatypeURI() != null && ((TypedLiteral) term).getDatatypeURI().toString().length() > 0;
            if ((!hasDatatype && litTerm instanceof PlainLiteral) || (hasDatatype && ((TypedLiteral) term).getDatatypeURI().equals(XMLSchema.STRING))) {
                return litTerm instanceof PlainLiteral ? ((PlainLiteral) term).getLabel().length() > 0 : ((String) ((TypedLiteral) term).getNativeValue()).length() > 0;
            }
            if (hasDatatype && ((TypedLiteral) term).getDatatypeURI().equals(XMLSchema.BOOLEAN))
                return (Boolean) ((TypedLiteral) term).getNativeValue();
            if (isNumeric(term)) {
                TypedLiteral tl = (TypedLiteral) term;
                Object oVal = tl.getNativeValue();
                if (oVal == null || !(oVal instanceof Number))
                    return false;
                if (PolymorphicNumber.ZERO.compareTo(new PolymorphicNumber((Number) oVal)) == 0)
                    return false;
                return true;
            }
        }
        throw new IncompatibleTypeException(term, "boolean");
    }

    /**
     * 
     * @param term
     * @return Whether or not the given term is a plain literal with no language tag
     */
    static public boolean isSimpleLiteral(TriplePatternComponent term) {
        return term instanceof PlainLiteral && (((Literal) term) instanceof PlainLiteral) && !(((PlainLiteral) term).hasLanguage());
    }

    /**
     * 
     * @param term
     * @return Whether or not the given term is a typed literal with a numeric type
     */
    static public boolean isNumeric(TriplePatternComponent term) {
        if (!(term instanceof TypedLiteral))
            return false;
        TypedLiteral tl = (TypedLiteral) term;
        org.openanzo.rdf.URI dt = tl.getDatatypeURI();
        return dt != null && (dt.equals(XMLSchema.INTEGER) || dt.equals(XMLSchema.DECIMAL) || dt.equals(XMLSchema.FLOAT) || dt.equals(XMLSchema.DOUBLE) || dt.equals(XMLSchema.NON_POSITIVE_INTEGER) || dt.equals(XMLSchema.NEGATIVE_INTEGER) || dt.equals(XMLSchema.NON_NEGATIVE_INTEGER) || dt.equals(XMLSchema.POSITIVE_INTEGER) || dt.equals(XMLSchema.UNSIGNED_LONG) || dt.equals(XMLSchema.UNSIGNED_INT) || dt.equals(XMLSchema.UNSIGNED_SHORT) || dt.equals(XMLSchema.UNSIGNED_BYTE) || dt.equals(XMLSchema.LONG) || dt.equals(XMLSchema.INT) || dt.equals(XMLSchema.SHORT) || dt.equals(XMLSchema.BYTE));
    }

    /**
     * @param term
     * @return Whether or not the given term is a typed literal with a datetime or date type
     */
    static public boolean isDateTimeType(TriplePatternComponent term) {
        if (!(term instanceof TypedLiteral))
            return false;
        TypedLiteral tl = (TypedLiteral) term;
        org.openanzo.rdf.URI dt = tl.getDatatypeURI();
        return dt != null && (dt.equals(XMLSchema.DATETIME) || dt.equals(XMLSchema.DATE) || dt.equals(XMLSchema.TIME) || dt.equals(XMLSchema.GYEAR) || dt.equals(XMLSchema.GDAY) || dt.equals(XMLSchema.GMONTH) || dt.equals(XMLSchema.GMONTHDAY) || dt.equals(XMLSchema.GYEARMONTH));
    }

    /**
     * @param term
     * @return Whether or not the given term is a typed literal of type xsd:date
     */
    static public boolean isDateType(TriplePatternComponent term) {
        if (!(term instanceof TypedLiteral))
            return false;
        TypedLiteral tl = (TypedLiteral) term;
        org.openanzo.rdf.URI dt = tl.getDatatypeURI();
        return dt != null && dt.equals(XMLSchema.DATE);
    }

    /**
     * @param term
     * @return Whether or not the given term is a typed literal with a duration type
     */
    static public boolean isDuration(TriplePatternComponent term) {
        if (!(term instanceof TypedLiteral))
            return false;
        TypedLiteral tl = (TypedLiteral) term;
        org.openanzo.rdf.URI dt = tl.getDatatypeURI();
        return dt != null && (dt.equals(XMLSchema.DURATION) || dt.equals(XMLSchema.DURATION_DAYTIME) || dt.equals(XMLSchema.DURATION_YEARMONTH));
    }

    private TypeConversions() {
    }
}
