/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/FunctionBase.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:    $Id: FunctionBase.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.XMLGregorianCalendar;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.exception.IncompatibleTypeException;
import org.openanzo.glitter.exception.MalformedLiteralException;
import org.openanzo.glitter.util.PolymorphicNumber;
import org.openanzo.glitter.util.TypeConversions;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.PlainLiteral;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.datatype.TypedValueMapper;
import org.openanzo.rdf.vocabulary.XMLSchema;

/**
 * Base class for SPARQL functions. Provides a standard configuration for {@link #operatesOnValues()} (<tt>true</tt>) and for {@link #operatesOnTypeErrors()} (
 * <tt>false</tt>). Also provides a set of utility methods to perform -1/0/1 comparison functions on {@link Value}s for booleans, numerics, datetimes, and
 * strings.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public abstract class ScalarFunctionBase implements ScalarFunction {
    /** Comparison results */
    static public enum ComparisonResult {
        /** Equal */
        EQUAL,
        /** Greater */
        GREATER,
        /** Lesser */
        LESSER,
        /** Indeterminate */
        INDETERMINATE;

        /**
         * Converts DatatypeContants.GREATER into GREATER, DatatypeContants.EQUAL in EQUAL, DatatypeContants.LESSER into LESSER, and
         * DatatypeContants.INDETERMINATE into INDETERMINATE
         * 
         * @param c
         * @return
         */
        protected static ComparisonResult fromDatatypeConstant(int c) {
            switch (c) {
            case DatatypeConstants.EQUAL:
                return EQUAL;
            case DatatypeConstants.GREATER:
                return GREATER;
            case DatatypeConstants.LESSER:
                return LESSER;
            case DatatypeConstants.INDETERMINATE:
                return INDETERMINATE;
            default:
                return null;
            }
        }

        /**
         * Convert standard compare results to enum
         * 
         * @param i
         *            results from compare
         * @return enum version of comparison
         */
        public static ComparisonResult fromStandardCompareValue(int i) {
            if (i < 0)
                return LESSER;
            if (i == 0)
                return EQUAL;
            return GREATER;
        }
    }

    public boolean operatesOnValues() {
        return true;
    }

    public boolean operatesOnTypeErrors() {
        return false;
    }

    /**
     * Compares two numeric RDF terms
     * 
     * @param arg1
     *            First term
     * @param arg2
     *            Second term
     * @return -1 if <tt>arg1 &lt; arg2</tt>; 0 if <tt>arg1 == arg2</tt>; 1 if <tt>arg1 &gt; arg2</tt>
     * @throws ExpressionEvaluationException
     *             If either argument is not numeric
     */
    static private ComparisonResult compareNumerics(Value arg1, Value arg2) {
        if (!TypeConversions.isNumeric(arg1))
            return ComparisonResult.INDETERMINATE;
        if (!TypeConversions.isNumeric(arg2))
            return ComparisonResult.INDETERMINATE;
        try {
            return ComparisonResult.fromStandardCompareValue(new PolymorphicNumber(arg1).compareTo(new PolymorphicNumber(arg2)));
        } catch (IllegalArgumentException iae) {
            throw new MalformedLiteralException(arg1, "numeric values");
        }
    }

    /**
     * Compares two boolean RDF terms
     * 
     * @param arg1
     *            First term
     * @param arg2
     *            Second term
     * @return -1 if <tt>arg1</tt> is <tt>false</tt> and <tt>arg2</tt> is <tt>true</tt>; 1 if the other way around; 0 if both terms are the same boolean value
     * @throws ExpressionEvaluationException
     *             if either arguments is not a boolean
     */
    static private ComparisonResult compareBooleans(Value arg1, Value arg2) {
        try {
            return compareBooleans(arg1, arg2, false);
        } catch (IncompatibleTypeException ite) {
            return ComparisonResult.INDETERMINATE;
        }
    }

    /**
     * Compares two boolean RDF terms
     * 
     * @param arg1
     *            First term
     * @param arg2
     *            Second term
     * @param convert
     *            Should the effective boolean value rules be applied to derive boolean values from non-boolean arguments?
     * @return -1 if <tt>arg1</tt> is <tt>false</tt> and <tt>arg2</tt> is <tt>true</tt>; 1 if the other way around; 0 if both terms are the same boolean value
     * @throws ExpressionEvaluationException
     *             if either arguments is not a boolean and either <tt>convert</tt> is <tt>false</tt> or there are no rules for finding the EBV of an argument
     */
    static private ComparisonResult compareBooleans(Value arg1, Value arg2, boolean convert) {
        boolean b1, b2;
        if (convert) {
            b1 = TypeConversions.effectiveBooleanValue(arg1);
            b2 = TypeConversions.effectiveBooleanValue(arg2);
        } else {
            b1 = TypeConversions.booleanValue(arg1);
            b2 = TypeConversions.booleanValue(arg2);
        }
        return ComparisonResult.fromStandardCompareValue((!b1 && b2) ? -1 : ((b1 && !b2) ? 1 : 0));
    }

    /**
     * Compares two datetime RDF terms as defined in section 3.2.7.4 of http://www.w3.org/TR/xpath-functions/#xmlschema-2. Uses the
     * {@link XMLGregorianCalendar#compare(XMLGregorianCalendar)} method to perform the comparison. Note that the result is not always greater than, less than,
     * or equal. It can also be indeterminate.
     * 
     * @param arg1
     *            First term
     * @param arg2
     *            Second term
     * @return The relationship between arg1 and arg2 as DatatypeConstants.LESSER, DatatypeConstants.EQUAL, DatatypeConstants.GREATER or
     *         DatatypeConstants.INDETERMINATE.
     * 
     * @throws ExpressionEvaluationException
     *             if either arguments is not a <tt>xsd:dateTime</tt> or one of the arguments can't be parsed into a date/time.
     */
    static private ComparisonResult compareDateTimes(Value arg1, Value arg2) {
        if (!(arg1 instanceof TypedLiteral))
            return ComparisonResult.INDETERMINATE;
        if (!(arg2 instanceof TypedLiteral))
            return ComparisonResult.INDETERMINATE;
        URI dt1 = ((TypedLiteral) arg1).getDatatypeURI();
        URI dt2 = ((TypedLiteral) arg2).getDatatypeURI();
        Class<?> class1 = TypedValueMapper.getNativeClass(dt1);
        if (!XMLGregorianCalendar.class.equals(class1))
            return ComparisonResult.INDETERMINATE;
        Class<?> class2 = TypedValueMapper.getNativeClass(dt2);
        if (!XMLGregorianCalendar.class.equals(class2))
            return ComparisonResult.INDETERMINATE;

        XMLGregorianCalendar cal1;
        try {
            cal1 = (XMLGregorianCalendar) ((TypedLiteral) arg1).getNativeValue();
        } catch (IllegalArgumentException iae) {
            throw new MalformedLiteralException(arg1, XMLSchema.DATETIME.toString());
        }
        XMLGregorianCalendar cal2;
        try {
            cal2 = (XMLGregorianCalendar) ((TypedLiteral) arg2).getNativeValue();
        } catch (IllegalArgumentException iae) {
            throw new MalformedLiteralException(arg2, XMLSchema.DATETIME.toString());
        }
        if (cal1 == null)
            throw new MalformedLiteralException(arg1, XMLSchema.DATETIME.toString());
        if (cal2 == null)
            throw new MalformedLiteralException(arg2, XMLSchema.DATETIME.toString());

        return ComparisonResult.fromDatatypeConstant(cal1.compare(cal2));
    }

    /**
     * Compares two string RDF terms
     * 
     * @param arg1
     *            First term
     * @param arg2
     *            Second term
     * @return -1 if <tt>arg1 &lt; arg2</tt>; 0 if <tt>arg1 == arg2</tt>; 1 if <tt>arg1 &gt; arg2</tt>
     * @throws ExpressionEvaluationException
     *             if either argument is not an <tt>xsd:string</tt> or a plain literal with no language tag
     */
    static private ComparisonResult compareStringLiterals(Value arg1, Value arg2) {
        if (!(arg1 instanceof Literal))
            return ComparisonResult.INDETERMINATE;
        if (!(arg2 instanceof Literal))
            return ComparisonResult.INDETERMINATE;
        Literal lit1 = (Literal) arg1, lit2 = (Literal) arg2;
        if ((lit1 instanceof PlainLiteral && ((PlainLiteral) lit1).hasLanguage()) && lit2 instanceof PlainLiteral && ((PlainLiteral) lit2).hasLanguage())
            return compareStringLiteralsWithLanguage((PlainLiteral) lit1, (PlainLiteral) lit2);
        if ((lit1 instanceof PlainLiteral && ((PlainLiteral) lit1).hasLanguage()) || (lit1 instanceof TypedLiteral && !((TypedLiteral) lit1).getDatatypeURI().equals(XMLSchema.STRING)))
            return ComparisonResult.INDETERMINATE;
        if ((lit2 instanceof PlainLiteral && ((PlainLiteral) lit2).hasLanguage()) || (lit2 instanceof TypedLiteral && !((TypedLiteral) lit2).getDatatypeURI().equals(XMLSchema.STRING)))
            return ComparisonResult.INDETERMINATE;
        String s1 = lit1.getLabel(), s2 = lit2.getLabel();
        // TODO - I'm not positive that this correctly implements the codepoint collation
        // required by SPARQL (by proxy of XPath). But I think it does. :)
        return ComparisonResult.fromStandardCompareValue(s1.compareTo(s2));
    }

    static private ComparisonResult compareStringLiteralsWithLanguage(PlainLiteral lit1, PlainLiteral lit2) {
        if (lit1.getLanguage().equalsIgnoreCase(lit2.getLabel()))
            return ComparisonResult.INDETERMINATE;
        return ComparisonResult.fromStandardCompareValue(lit1.getLabel().compareTo(lit2.getLabel()));
    }

    /**
     * Determine if 2 terms are equal
     * 
     * @param v1
     *            value 1
     * @param v2
     *            value 2
     * @return comparison of 2 values
     */
    static public boolean rdfTermEquals(Value v1, Value v2) {
        return v1.equals(v2);
    }

    /**
     * Compare literal values
     * 
     * @param v1
     *            value 1
     * @param v2
     *            value 2
     * @return comparison of 2 values
     * @throws ExpressionEvaluationException
     */
    static public ComparisonResult compareLiteralValues(Value v1, Value v2) {
        boolean bothTyped = (v1 instanceof TypedLiteral && v2 instanceof TypedLiteral);
        // @@ how do we know what error is most appropriate if these all fail?
        ComparisonResult result = ComparisonResult.INDETERMINATE;
        if (bothTyped) {
            result = compareNumerics(v1, v2);
            if (result != ComparisonResult.INDETERMINATE) {
                return result;
            }
        }
        result = compareStringLiterals(v1, v2);
        if (result != ComparisonResult.INDETERMINATE) {
            return result;
        }
        if (bothTyped) {
            result = compareBooleans(v1, v2);
            if (result != ComparisonResult.INDETERMINATE) {
                return result;
            }
            result = compareDateTimes(v1, v2);
            if (result != ComparisonResult.INDETERMINATE) {
                return result;
            }
        }
        return ComparisonResult.INDETERMINATE;
    }

    @Override
    public String toString() {
        return getIdentifier().getLocalName();
    }
}
