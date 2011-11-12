/*******************************************************************************
 * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/rdf/datatype/TypeMaps.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: TypeMaps.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.datatype;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.DatatypeConverter;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.apache.commons.lang.time.DateUtils;
import org.apache.ws.jaxme.impl.DatatypeConverterImpl;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.vocabulary.RDF;
import org.openanzo.rdf.vocabulary.XMLSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
/**
 * A singleton collection of {@link LexicalToNativeTypeMap}s and {@link NativeToLexicalTypeMap}s for converting between XML Schema types and Java classes.
 *
 * @author lee
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
 */
public class TypeMaps {

    private static final Logger         log         = LoggerFactory.getLogger(TypeMaps.class);

    /*
     * WARNING: JAXP doesn't mandate that DatatypeFactory implementations be thread-safe but all implementations
     * I've seen are indeed thread-safe on account of being stateless.
     *
     * Future JAXP edits might mandate thread safety since this bug has been accepted:
     * http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6466177
     */
    /** Datatype factory */
    public static final DatatypeFactory datatypeFactory;

    static {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean              initialized = false;

    /**
     * This method should be called the constructor of each type map so that the DatatypeConverter is initialized. It is important to do this in every class
     * since we can't predict which will be loaded first. And the outer class isn't necessarily loaded when a static inner class is loaded. So putting this in
     * the outer class's static initializer isn't enough. See
     */
    private static void initializeDatatypeConverter() {
        if (!initialized) {
            DatatypeConverter.setDatatypeConverter(new DatatypeConverterImpl());
            initialized = true;
        }
    }

    /**
     * Creates a URI in the XSD namespace ending in <tt>base</tt>.
     * 
     * @param base
     * @return a URI in the XSD namespace ending in <tt>base</tt>.
     */
    static public String xsd(String base) {
        return XMLSchema.NAMESPACE + base;
    }

    private static final Date MIN_DATE = new Date(Long.MIN_VALUE);

    /**
     * Create an XML Calendar for the time in millis
     * 
     * @param millis
     * @return XML Calendar
     */
    public static XMLGregorianCalendar getXMLCaledar(long millis) {
        GregorianCalendar cal = new GregorianCalendar(DateUtils.UTC_TIME_ZONE);
        cal.clear();
        cal.setGregorianChange(MIN_DATE);
        cal.setTimeInMillis(millis);
        return TypeMaps.datatypeFactory.newXMLGregorianCalendar(cal);
    }

    /**
     * Create an XML Calendar for the time in millis
     * 
     * @param millis
     * @return XML Calendar
     */
    public static XMLGregorianCalendar getXMLCaledar(Date date) {
        GregorianCalendar cal = new GregorianCalendar(DateUtils.UTC_TIME_ZONE);
        cal.clear();
        cal.setGregorianChange(MIN_DATE);
        cal.setTime(date);
        return TypeMaps.datatypeFactory.newXMLGregorianCalendar(cal);
    }

    private TypeMaps() {
    }

    /**
     * Type map for string data.
     * 
     * @author lee <lee@cambridgesemantics.com>
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMString implements LexicalToNativeTypeMap, NativeToLexicalTypeMap {

        public TMString() {
            initializeDatatypeConverter();
        }

        public Class<?> getJavaClass() {
            return String.class;
        }

        public URI getOutputDatatype() {
            return XMLSchema.STRING;
        }

        public boolean canConvertToLexicalValue(Object obj) {
            return obj instanceof String;
        }

        public String convertToLexicalValue(Object obj) {
            return (String) obj;
        }

        public URI getDatatype() {
            return XMLSchema.STRING;
        }

        public Class<?> getOutputJavaClass() {
            return String.class;
        }

        public Object convertToNativeObject(String value) {
            return value;
        }
    }

    /**
     * Type map for xsd:integer <--> BigInteger.
     * 
     * @author lee <lee@cambridgesemantics.com>
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMInteger implements LexicalToNativeTypeMap, NativeToLexicalTypeMap {
        public TMInteger() {
            initializeDatatypeConverter();
        }

        public Class<?> getJavaClass() {
            return BigInteger.class;
        }

        public URI getOutputDatatype() {
            return XMLSchema.INTEGER;
        }

        public boolean canConvertToLexicalValue(Object obj) {
            return obj instanceof BigInteger;
        }

        public String convertToLexicalValue(Object obj) {
            return DatatypeConverter.printInteger((BigInteger) obj);
        }

        public URI getDatatype() {
            return XMLSchema.INTEGER;
        }

        public Class<?> getOutputJavaClass() {
            return BigInteger.class;
        }

        public Object convertToNativeObject(String value) {
            // strip off leading +'s since our impl. doesn't handle them
            if (value.charAt(0) == '+')
                value = value.substring(1);
            return DatatypeConverter.parseInteger(value);
        }
    }

    /**
     * Type map for xsd:int <--> Integer.
     * 
     * @author lee <lee@cambridgesemantics.com>
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMInt implements LexicalToNativeTypeMap, NativeToLexicalTypeMap {
        public TMInt() {
            initializeDatatypeConverter();
        }

        public Class<?> getJavaClass() {
            return Integer.class;
        }

        public URI getOutputDatatype() {
            return XMLSchema.INT;
        }

        public boolean canConvertToLexicalValue(Object obj) {
            return obj instanceof Integer;
        }

        public String convertToLexicalValue(Object obj) {
            return DatatypeConverter.printInt((Integer) obj);
        }

        public URI getDatatype() {
            return XMLSchema.INT;
        }

        public Class<?> getOutputJavaClass() {
            return Integer.class;
        }

        public Object convertToNativeObject(String value) {
            return DatatypeConverter.parseInt(value);
        }
    }

    /**
     * Type map for xsd:long <--> Long.
     * 
     * @author lee <lee@cambridgesemantics.com>
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMLong implements LexicalToNativeTypeMap, NativeToLexicalTypeMap {
        public TMLong() {
            initializeDatatypeConverter();
        }

        public Class<?> getJavaClass() {
            return Long.class;
        }

        public URI getOutputDatatype() {
            return XMLSchema.LONG;
        }

        public boolean canConvertToLexicalValue(Object obj) {
            return obj instanceof Long;
        }

        public String convertToLexicalValue(Object obj) {
            return DatatypeConverter.printLong((Long) obj);
        }

        public URI getDatatype() {
            return XMLSchema.LONG;
        }

        public Class<?> getOutputJavaClass() {
            return Long.class;
        }

        public Object convertToNativeObject(String value) {
            return DatatypeConverter.parseLong(value);
        }
    }

    /**
     * Type map for xsd:short <--> Short.
     * 
     * @author lee <lee@cambridgesemantics.com>
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMShort implements LexicalToNativeTypeMap, NativeToLexicalTypeMap {
        public TMShort() {
            initializeDatatypeConverter();
        }

        public Class<?> getJavaClass() {
            return Short.class;
        }

        public URI getOutputDatatype() {
            return XMLSchema.SHORT;
        }

        public boolean canConvertToLexicalValue(Object obj) {
            return obj instanceof Short;
        }

        public String convertToLexicalValue(Object obj) {
            return DatatypeConverter.printShort((Short) obj);
        }

        public URI getDatatype() {
            return XMLSchema.SHORT;
        }

        public Class<?> getOutputJavaClass() {
            return Short.class;
        }

        public Object convertToNativeObject(String value) {
            return DatatypeConverter.parseShort(value);
        }
    }

    /**
     * Type map for xsd:decimal <--> BigDecimal.
     * 
     * @author lee <lee@cambridgesemantics.com>
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMDecimal implements LexicalToNativeTypeMap, NativeToLexicalTypeMap {
        public TMDecimal() {
            initializeDatatypeConverter();
        }

        public Class<?> getJavaClass() {
            return BigDecimal.class;
        }

        public URI getOutputDatatype() {
            return XMLSchema.DECIMAL;
        }

        public boolean canConvertToLexicalValue(Object obj) {
            return obj instanceof BigDecimal;
        }

        public String convertToLexicalValue(Object obj) {
            return DatatypeConverter.printDecimal((BigDecimal) obj);
        }

        public URI getDatatype() {
            return XMLSchema.DECIMAL;
        }

        public Class<?> getOutputJavaClass() {
            return BigDecimal.class;
        }

        public Object convertToNativeObject(String value) {
            return DatatypeConverter.parseDecimal(value);
        }
    }

    /**
     * Type map for xsd:float <--> Float.
     * 
     * @author lee <lee@cambridgesemantics.com>
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMFloat implements LexicalToNativeTypeMap, NativeToLexicalTypeMap {
        public TMFloat() {
            initializeDatatypeConverter();
        }

        public Class<?> getJavaClass() {
            return Float.class;
        }

        public URI getOutputDatatype() {
            return XMLSchema.FLOAT;
        }

        public boolean canConvertToLexicalValue(Object obj) {
            return obj instanceof Float;
        }

        public String convertToLexicalValue(Object obj) {
            return DatatypeConverter.printFloat((Float) obj);
        }

        public URI getDatatype() {
            return XMLSchema.FLOAT;
        }

        public Class<?> getOutputJavaClass() {
            return Float.class;
        }

        public Object convertToNativeObject(String value) {
            return DatatypeConverter.parseFloat(value);
        }
    }

    /**
     * Type map for xsd:double <--> Double.
     * 
     * @author lee <lee@cambridgesemantics.com>
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMDouble implements LexicalToNativeTypeMap, NativeToLexicalTypeMap {
        public TMDouble() {
            initializeDatatypeConverter();
        }

        public Class<?> getJavaClass() {
            return Double.class;
        }

        public URI getOutputDatatype() {
            return XMLSchema.DOUBLE;
        }

        public boolean canConvertToLexicalValue(Object obj) {
            return obj instanceof Double;
        }

        public String convertToLexicalValue(Object obj) {
            return DatatypeConverter.printDouble((Double) obj);
        }

        public URI getDatatype() {
            return XMLSchema.DOUBLE;
        }

        public Class<?> getOutputJavaClass() {
            return Double.class;
        }

        public Object convertToNativeObject(String value) {
            return DatatypeConverter.parseDouble(value);
        }
    }

    /**
     * Type map for xsd:boolean <--> Boolean.
     * 
     * @author lee <lee@cambridgesemantics.com>
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMBoolean implements LexicalToNativeTypeMap, NativeToLexicalTypeMap {
        public TMBoolean() {
            initializeDatatypeConverter();
        }

        public Class<?> getJavaClass() {
            return Boolean.class;
        }

        public URI getOutputDatatype() {
            return XMLSchema.BOOLEAN;
        }

        public boolean canConvertToLexicalValue(Object obj) {
            return obj instanceof Boolean;
        }

        public String convertToLexicalValue(Object obj) {
            return DatatypeConverter.printBoolean((Boolean) obj);
        }

        public URI getDatatype() {
            return XMLSchema.BOOLEAN;
        }

        public Class<?> getOutputJavaClass() {
            return Boolean.class;
        }

        public Object convertToNativeObject(String value) {
            return DatatypeConverter.parseBoolean(value);
        }
    }

    /**
     * Type map for xsd:byte <--> Byte.
     * 
     * @author lee <lee@cambridgesemantics.com>
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMByte implements LexicalToNativeTypeMap, NativeToLexicalTypeMap {
        public TMByte() {
            initializeDatatypeConverter();
        }

        public Class<?> getJavaClass() {
            return Byte.class;
        }

        public URI getOutputDatatype() {
            return XMLSchema.BYTE;
        }

        public boolean canConvertToLexicalValue(Object obj) {
            return obj instanceof Byte;
        }

        public String convertToLexicalValue(Object obj) {
            return DatatypeConverter.printByte((Byte) obj);
        }

        public URI getDatatype() {
            return XMLSchema.BYTE;
        }

        public Class<?> getOutputJavaClass() {
            return Byte.class;
        }

        public Object convertToNativeObject(String value) {
            return DatatypeConverter.parseByte(value);
        }
    }

    /**
     * Type map for xsd:base64Binary <--> byte[].
     * 
     * @author lee <lee@cambridgesemantics.com>
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMBase64Binary implements LexicalToNativeTypeMap, NativeToLexicalTypeMap {
        public TMBase64Binary() {
            initializeDatatypeConverter();
        }

        public Class<?> getJavaClass() {
            return byte[].class;
        }

        public URI getOutputDatatype() {
            return XMLSchema.BASE64BINARY;
        }

        public boolean canConvertToLexicalValue(Object obj) {
            return obj instanceof byte[];
        }

        public String convertToLexicalValue(Object obj) {
            return DatatypeConverter.printBase64Binary((byte[]) obj);
        }

        public URI getDatatype() {
            return XMLSchema.BASE64BINARY;
        }

        public Class<?> getOutputJavaClass() {
            return byte[].class;
        }

        public Object convertToNativeObject(String value) {
            return DatatypeConverter.parseBase64Binary(value);
        }
    }

    /**
     * Type map for xsd:anyURI <--> org.openanzo.rdf.URI.
     * 
     * @author lee <lee@cambridgesemantics.com>
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMAnyUri implements LexicalToNativeTypeMap, NativeToLexicalTypeMap {
        public TMAnyUri() {
            initializeDatatypeConverter();
        }

        public Class<?> getJavaClass() {
            return URI.class;
        }

        public URI getOutputDatatype() {
            return XMLSchema.ANYURI;
        }

        public boolean canConvertToLexicalValue(Object obj) {
            return obj instanceof URI;
        }

        public String convertToLexicalValue(Object obj) {
            return ((URI) obj).toString();
        }

        public URI getDatatype() {
            return XMLSchema.ANYURI;
        }

        public Class<?> getOutputJavaClass() {
            return URI.class;
        }

        public Object convertToNativeObject(String value) {
            return MemURI.create(value);
        }
    }

    /**
     * Type map for xsd:hexBinary --> byte[].
     * 
     * @author lee <lee@cambridgesemantics.com>
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMHexBinary implements LexicalToNativeTypeMap {
        public TMHexBinary() {
            initializeDatatypeConverter();
        }

        public URI getDatatype() {
            return XMLSchema.HEXBINARY;
        }

        public Class<?> getOutputJavaClass() {
            return byte[].class;
        }

        public Object convertToNativeObject(String value) {
            return DatatypeConverter.parseHexBinary(value);
        }
    }

    /**
     * Type map for xsd:unsignedInt --> Long.
     * 
     * @author lee <lee@cambridgesemantics.com>
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMUnsignedInt implements LexicalToNativeTypeMap {
        public TMUnsignedInt() {
            initializeDatatypeConverter();
        }

        public URI getDatatype() {
            return XMLSchema.UNSIGNED_INT;
        }

        public Class<?> getOutputJavaClass() {
            return Long.class;
        }

        public Object convertToNativeObject(String value) {
            return DatatypeConverter.parseUnsignedInt(value);
        }
    }

    /**
     * Type map for xsd:unsignedShort --> Integer.
     * 
     * @author lee <lee@cambridgesemantics.com>
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMUnsignedShort implements LexicalToNativeTypeMap {
        public TMUnsignedShort() {
            initializeDatatypeConverter();
        }

        public URI getDatatype() {
            return XMLSchema.UNSIGNED_SHORT;
        }

        public Class<?> getOutputJavaClass() {
            return Integer.class;
        }

        public Object convertToNativeObject(String value) {
            return DatatypeConverter.parseUnsignedShort(value);
        }
    }

    /**
     * Type map for xsd:unsignedByte --> Short.
     * 
     * @author lee <lee@cambridgesemantics.com>
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMUnsignedByte implements LexicalToNativeTypeMap {
        public TMUnsignedByte() {
            initializeDatatypeConverter();
        }

        public URI getDatatype() {
            return XMLSchema.UNSIGNED_BYTE;
        }

        public Class<?> getOutputJavaClass() {
            return Short.class;
        }

        public Object convertToNativeObject(String value) {
            int val = DatatypeConverter.parseUnsignedShort(value);
            if (val >= 0 && val <= 255) {
                return val;
            } else {
                throw new NumberFormatException("Value out of range. Value:\"" + value);
            }
        }
    }

    /**
     * Maps java.util.Date --> xsd:dateTime using UTC as the time zone.
     * 
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMJavaDate implements NativeToLexicalTypeMap {
        public TMJavaDate() {
            initializeDatatypeConverter();
        }

        public Class<?> getJavaClass() {
            return Date.class;
        }

        public URI getOutputDatatype() {
            return XMLSchema.DATETIME;
        }

        public boolean canConvertToLexicalValue(Object obj) {
            // Even though Timestamp, java.sql.Date, and java.sql.Time extend java.util.Date, their documentation
            // warns that they should not be treated as java.util.Date instances. The extension is used for
            // implementation inheritance rather than subtyping. We'll add a check here to prevent nasty issues
            // related to that. In particular, the most common issue is that the Timetamp's precision would
            // appear to drop from nanoseconds to seconds...not even milliseconds...seconds.
            return obj instanceof Date && !(obj instanceof Timestamp) && !(obj instanceof Time) && !(obj instanceof java.sql.Date);
        }

        public String convertToLexicalValue(Object obj) {
            Calendar cal = Calendar.getInstance(DateUtils.UTC_TIME_ZONE);
            cal.setTime((Date) obj);
            return DatatypeConverter.printDateTime(cal);
        }
    }

    /**
     * Maps java.sql.Timestamp --> xsd:dateTime using UTC as the time zone and preserving the Timestamp's nanosecond precision.
     * 
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMSQLTimestamp implements NativeToLexicalTypeMap {
        public TMSQLTimestamp() {
            initializeDatatypeConverter();
        }

        private static final Date MIN_DATE = new Date(Long.MIN_VALUE);

        public Class<?> getJavaClass() {
            return Timestamp.class;
        }

        public URI getOutputDatatype() {
            return XMLSchema.DATETIME;
        }

        public boolean canConvertToLexicalValue(Object obj) {
            return obj instanceof Timestamp;
        }

        public String convertToLexicalValue(Object obj) {
            Timestamp timestamp = (Timestamp) obj;
            // Truncate the time to seconds precision since we'll get the fractional seconds from the Timestamp#getNanos()
            // method below. Thus preventing loss of precision in the final lexical value.
            long wholeSecondTime = (timestamp.getTime() / 1000) * 1000;

            // It's annoyingly round-about to create a java.util.Calendar just to get an XMLGregorianCalendar.
            // This wouldn't be needed if you could create an XMLGregorianCalendar using 'milliseconds since the epoch'.
            // Oh well.
            GregorianCalendar cal = new GregorianCalendar(DateUtils.UTC_TIME_ZONE);
            cal.clear();
            cal.setGregorianChange(MIN_DATE);
            cal.setTimeInMillis(wholeSecondTime);

            XMLGregorianCalendar xmlCal = datatypeFactory.newXMLGregorianCalendar(cal);
            int nanoseconds = timestamp.getNanos();
            String xmlval;
            if (nanoseconds > 0) {
                // The toXMLFormat() method of XMLGregorianCalendar can generate
                // an invalid string when using fractional seconds in JDK5 and JDK6. See
                // http://bugs.sun.com/view_bug.do?bug_id=2154623 which was originally filed as
                // http://bugs.sun.com/view_bug.do?bug_id=6608696.
                // The problem is that JDK5 changed the semantics of BigDecimal#toString() from underneath the
                // XMLGregorianCalendar code. So you can end up with fractional seconds in scientific notation (ex. 5E-9).
                // Looks like it will be fixed in JDK7 according to those bug reports.
                // So we write a workaround here to output the fractional seconds ourselves using
                // to correct BigDecimal#toPlainString() method.

                // First set the time zone to undefined so and the fractional seconds to null so that the string ends
                // string generated by the XMLGregorianCalendar will stop at the seconds field. We'll then
                // Add the fractional seconds string and the time zone string ourselves.
                xmlCal.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
                xmlCal.setFractionalSecond(null);
                BigDecimal fractionalSecond = BigDecimal.valueOf(timestamp.getNanos(), 9).stripTrailingZeros(); // nano is 10^-9
                String fractionalSecondStr = fractionalSecond.toPlainString(); // This will always be something like "0.043" so we get rid of the first character when appending to the XML string.
                xmlval = xmlCal.toXMLFormat() + fractionalSecondStr.substring(1) + "Z";
            } else if (nanoseconds == 0) {
                xmlCal.setFractionalSecond(null); // Doing this makes it so that no trailing zeroes are output.
                xmlval = xmlCal.toXMLFormat();
            } else {
                throw new AnzoRuntimeException(ExceptionConstants.IO.INVALID_DATETIME);
            }

            return xmlval;
        }
    }

    /**
     * Maps java.sql.Time --> xsd:time without any time zone.
     * 
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMSQLTime implements NativeToLexicalTypeMap {
        public TMSQLTime() {
            initializeDatatypeConverter();
        }

        public Class<?> getJavaClass() {
            return Time.class;
        }

        public URI getOutputDatatype() {
            return XMLSchema.TIME;
        }

        public boolean canConvertToLexicalValue(Object obj) {
            return obj instanceof Time;
        }

        public String convertToLexicalValue(Object obj) {
            return ((Time) obj).toString();
        }
    }

    /**
     * Maps java.sql.Date --> xsd:date without any time zone.
     * 
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMSQLDate implements NativeToLexicalTypeMap {
        public TMSQLDate() {
            initializeDatatypeConverter();
        }

        public Class<?> getJavaClass() {
            return java.sql.Date.class;
        }

        public URI getOutputDatatype() {
            return XMLSchema.DATE;
        }

        public boolean canConvertToLexicalValue(Object obj) {
            return obj instanceof java.sql.Date;
        }

        public String convertToLexicalValue(Object obj) {
            return ((java.sql.Date) obj).toString();
        }
    }

    /**
     * Maps java.util.Calendar --> xsd:dateTime using UTC as the time zone and preserving the Timestamp's nanosecond precision.
     * 
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMJavaCalendar implements NativeToLexicalTypeMap {
        public TMJavaCalendar() {
            initializeDatatypeConverter();
        }

        public Class<?> getJavaClass() {
            return Calendar.class;
        }

        public URI getOutputDatatype() {
            return XMLSchema.DATETIME;
        }

        public boolean canConvertToLexicalValue(Object obj) {
            return obj instanceof Calendar;
        }

        public String convertToLexicalValue(Object obj) {
            return DatatypeConverter.printDateTime((Calendar) obj);
        }
    }

    /**
     * Generic type map for types that convert to and from XMLGregorianCalendar. In particular, the XML Schema types xsd:dateTime, xsd:date, xsd:time,
     * xsd:gYearMonth, xsd:gYear, xsd:gMonthDay, xsd:gDay, or xsd:gMonth.
     * 
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMXMLGregorianCalendar implements LexicalToNativeTypeMap, NativeToLexicalTypeMap {

        private final QName xsdType;

        private final URI   xsdDatatypeUri;

        protected TMXMLGregorianCalendar(QName xsdType) {
            if (xsdType.equals(DatatypeConstants.DATETIME)) {
                xsdDatatypeUri = XMLSchema.DATETIME;
            } else if (xsdType.equals(DatatypeConstants.DATE)) {
                xsdDatatypeUri = XMLSchema.DATE;
            } else if (xsdType.equals(DatatypeConstants.TIME)) {
                xsdDatatypeUri = XMLSchema.TIME;
            } else if (xsdType.equals(DatatypeConstants.GDAY)) {
                xsdDatatypeUri = XMLSchema.GDAY;
            } else if (xsdType.equals(DatatypeConstants.GMONTH)) {
                xsdDatatypeUri = XMLSchema.GMONTH;
            } else if (xsdType.equals(DatatypeConstants.GMONTHDAY)) {
                xsdDatatypeUri = XMLSchema.GMONTHDAY;
            } else if (xsdType.equals(DatatypeConstants.GYEAR)) {
                xsdDatatypeUri = XMLSchema.GYEAR;
            } else if (xsdType.equals(DatatypeConstants.GYEARMONTH)) {
                xsdDatatypeUri = XMLSchema.GYEARMONTH;
            } else {
                throw new AnzoRuntimeException(ExceptionConstants.IO.UNSUPPORTED_DATATYPE, "xsd:dateTime, xsd:date, xsd:time, xsd:gYearMonth, xsd:gYear, xsd:gMonthDay, xsd:gDay, or xsd:gMonth");
            }
            this.xsdType = xsdType;
        }

        public Class<?> getJavaClass() {
            return XMLGregorianCalendar.class;
        }

        public URI getOutputDatatype() {
            return xsdDatatypeUri;
        }

        public boolean canConvertToLexicalValue(Object obj) {
            if (obj instanceof XMLGregorianCalendar) {
                try {
                    return ((XMLGregorianCalendar) obj).getXMLSchemaType().equals(xsdType);
                } catch (IllegalStateException e) {
                    // Thrown by XMLGregorianCalendar#getXMLSchemaType() if the object doesn't have the appropriate
                    // fields to be one of the XML Schema built-in types.
                    log.debug(LogUtils.GLITTER_MARKER, "Native value does not apply to this mapper.", e);
                }
            }
            return false;
        }

        public String convertToLexicalValue(Object obj) {
            return ((XMLGregorianCalendar) obj).toXMLFormat();
        }

        public URI getDatatype() {
            return xsdDatatypeUri;
        }

        public Class<?> getOutputJavaClass() {
            return XMLGregorianCalendar.class;
        }

        public Object convertToNativeObject(String value) {
            XMLGregorianCalendar cal = datatypeFactory.newXMLGregorianCalendar(value);
            if (cal.getXMLSchemaType().equals(xsdType)) {
                return cal;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * Generic type map for types that convert to and from javax.xml.datatype.Duration. In particular, the XML Schema types xsd:duration, xsd:yearMonthDuration,
     * and xsd:dayTimeDuration.
     * 
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMDuration implements LexicalToNativeTypeMap, NativeToLexicalTypeMap {
        private final QName xsdType;

        private final URI   xsdDatatypeUri;

        protected TMDuration(QName xsdType) {
            if (xsdType.equals(DatatypeConstants.DURATION)) {
                xsdDatatypeUri = XMLSchema.DURATION;
            } else if (xsdType.equals(DatatypeConstants.DURATION_DAYTIME)) {
                xsdDatatypeUri = XMLSchema.DURATION_DAYTIME;
            } else if (xsdType.equals(DatatypeConstants.DURATION_YEARMONTH)) {
                xsdDatatypeUri = XMLSchema.DURATION_YEARMONTH;
            } else {
                throw new AnzoRuntimeException(ExceptionConstants.IO.UNSUPPORTED_DATATYPE, "xsd:duration, xsd:yearMonthDuration, or xsd:dayTimeDuration");
            }
            this.xsdType = xsdType;
        }

        public Class<?> getJavaClass() {
            return Duration.class;
        }

        public URI getOutputDatatype() {
            return xsdDatatypeUri;
        }

        public boolean canConvertToLexicalValue(Object obj) {
            if (obj instanceof Duration) {
                try {
                    return ((Duration) obj).getXMLSchemaType().equals(xsdType);
                } catch (IllegalStateException e) {
                    // Thrown by Duration#getXMLSchemaType() if the object doesn't have the appropriate
                    // fields to be one of the XML Schema built-in types.
                    log.debug(LogUtils.GLITTER_MARKER, "Native value does not apply to this mapper.", e);
                }
            }
            return false;
        }

        public String convertToLexicalValue(Object obj) {
            return ((Duration) obj).toString();
        }

        public URI getDatatype() {
            return xsdDatatypeUri;
        }

        public Class<?> getOutputJavaClass() {
            return Duration.class;
        }

        public Object convertToNativeObject(String value) {
            Duration duration = datatypeFactory.newDuration(value);
            if (DatatypeConstants.DURATION.equals(xsdType))
                return duration;
            try {
                if (duration.getXMLSchemaType().equals(xsdType)) {
                    return duration;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalStateException ise) {
                throw new IllegalArgumentException(ise);
            }
        }
    }

    /**
     * Type map for http://www.w3.org/1999/02/22-rdf-syntax-ns#XMLLiteral --> String.
     * 
     * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
     */
    static class TMXmlLiteralString implements LexicalToNativeTypeMap {
        public TMXmlLiteralString() {
            initializeDatatypeConverter();
        }

        public URI getDatatype() {
            return RDF.XMLLiteral;
        }

        public Class<?> getOutputJavaClass() {
            return String.class;
        }

        public Object convertToNativeObject(String value) {
            return value;
        }
    }
}
