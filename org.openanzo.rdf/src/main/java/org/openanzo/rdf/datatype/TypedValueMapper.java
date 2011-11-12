/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/rdf/datatype/TypedValueMapper.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: TypedValueMapper.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.datatype;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.xml.datatype.DatatypeConstants;

import org.apache.commons.collections15.MultiMap;
import org.apache.commons.collections15.multimap.MultiHashMap;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.Pair;

/**
 * The typed value mapper uses a series of {@link TypeMaps}s to convert between lexical forms of literal values and native Java values.
 * 
 * The mapping from datatype URI to a native Java class must be a single-value function. That is, the a particular datatype URI cannot map to multiple Java
 * classes. However, the reverse mapping is not so restricted. A single Java class may map to multiple datatype URIs. For example, the XMLGregorianCalendar
 * class can map to xsd:date, xsd:time, xsd:gMonth, etc. based on the data in the particular instance of the class. This restriction that the URI->Class map be
 * a single-valued function is in place for Jastor which must map from datatype URI to Java class for generating classes from ontologies.
 * 
 * @author Lee
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
 * 
 */
final public class TypedValueMapper {

    /**
     * Converts the lexical form of a value to a native Java value using the given XML schema type to inform the conversion.
     * 
     * @param value
     *            value to convert
     * @param datatype
     *            XML schema type of value
     * @return the native object value for the given XML schema type
     * @throws IllegalArgumentException
     */
    static public Object getNativeObject(String value, URI datatype) throws IllegalArgumentException {
        Object obj = null;
        LexicalToNativeTypeMap tm = xs2j.get(datatype);
        if (tm != null) {
            obj = tm.convertToNativeObject(value);
        }
        return obj;
    }

    /**
     * Returns the Class to which values of the given datatype are converted by the {@link #getNativeObject(String, URI)} method.
     * 
     * @param datatype
     *            XML schema type
     * @return the Class which maps to the given XML schema type
     */
    static public Class<?> getNativeClass(URI datatype) {
        Class<?> clazz = null;
        LexicalToNativeTypeMap tm = xs2j.get(datatype);
        if (tm != null) {
            clazz = tm.getOutputJavaClass();
        }
        return clazz;
    }

    /**
     * Returns the lexical form of the given native value, as informed by the type of the value. And also return the XML Schema type corresponding to the class
     * of the native Java object given.
     * 
     * @param o
     *            native object to convert
     * @return A pair consisting of a string and a URI. The first string is the lexical form of the given native value. The second element, the URI, is the XML
     *         Schema type corresponding to the class of the native Java object given.
     */
    static public Pair<String, URI> getLexicalValue(Object o) {
        return getLexicalValue(o, null);
    }

    /**
     * @param o
     *            native object to convert
     * @param desiredDatatype
     *            an optional datatype. If supplied, object will only attempt to be converted to a lexical value of the desiredDatatype. If the object can't be
     *            converted to that datatype, then null will be returned.
     * @return A pair consisting of a string and a URI. The first string is the lexical form of the given native value. The second element, the URI, is the XML
     *         Schema type corresponding to the class of the native Java object given.
     */
    static public Pair<String, URI> getLexicalValue(Object o, URI desiredDatatype) {
        Pair<String, URI> ret = null;
        NativeToLexicalTypeMap tm = getTypeMapForObject(o, desiredDatatype);
        if (tm != null) {
            ret = new Pair<String, URI>(tm.convertToLexicalValue(o), tm.getOutputDatatype());
        }
        return ret;
    }

    /**
     * Retrieves an ITypeMap which applies to the type of the given object.
     * 
     * @param o
     *            object for which a matching ITypeMap will be retrieved.
     * @param desiredDatatype
     *            an optional datatype. If supplied, the map returned must be a map that returns a value of this datatype.
     * @return a matching ITypeMap or null if none could be found.
     */
    static private NativeToLexicalTypeMap getTypeMapForObject(Object o, URI desiredDatatype) {
        NativeToLexicalTypeMap tm = null;
        Collection<NativeToLexicalTypeMap> tmList = j2xs.get(o.getClass());
        if (tmList == null) {
            // We didn't find a type map using simple comparison of the Object's class.
            // But the object may still apply to one of the maps via subclassing or
            // interface implementation. To check that, we iterate through
            // all of the type maps checking if the object is an instanceof each
            // ITypeMap's supported type AND it can convert the given object. If a desiredDatatype
            // was given, we also check that the type map outputs the desired datatype.
            for (Map.Entry<Class<?>, Collection<NativeToLexicalTypeMap>> currentTypeMaps : j2xs.entrySet()) {
                for (NativeToLexicalTypeMap currentTypeMap : currentTypeMaps.getValue()) {
                    Class<?> c = currentTypeMap.getJavaClass();
                    if (c != null && c.isInstance(o) && currentTypeMap.canConvertToLexicalValue(o) && (desiredDatatype == null || desiredDatatype.equals(currentTypeMap.getOutputDatatype()))) {
                        tm = currentTypeMap;
                        break;
                    }
                }
            }
        } else {
            for (NativeToLexicalTypeMap currentTypeMap : tmList) {
                if (currentTypeMap.canConvertToLexicalValue(o)) {
                    tm = currentTypeMap;
                    break;
                }
            }
        }

        return tm;
    }

    static private final Map<URI, LexicalToNativeTypeMap>           xs2j = new HashMap<URI, LexicalToNativeTypeMap>();

    static private final MultiMap<Class<?>, NativeToLexicalTypeMap> j2xs = new MultiHashMap<Class<?>, NativeToLexicalTypeMap>();

    static private void addLexicalToNativeMapping(LexicalToNativeTypeMap tm) {
        LexicalToNativeTypeMap old = xs2j.put(tm.getDatatype(), tm);
        if (old != null) {
            throw new RuntimeException("Invalid type map configuration. An datatype URI must map to only one Java class. Datatype URI <" + tm.getDatatype() + "> is already mapped to " + old.getOutputJavaClass() + " via " + old.toString());
        }
    }

    static private void addNativeToLexicalMapping(NativeToLexicalTypeMap tm) {
        j2xs.put(tm.getJavaClass(), tm);
    }

    static {
        TypeMaps.TMAnyUri anyUriMap = new TypeMaps.TMAnyUri();
        addLexicalToNativeMapping(anyUriMap);
        addNativeToLexicalMapping(anyUriMap);

        TypeMaps.TMBase64Binary base64Map = new TypeMaps.TMBase64Binary();
        addLexicalToNativeMapping(base64Map);
        addNativeToLexicalMapping(base64Map);

        TypeMaps.TMBoolean booleanMap = new TypeMaps.TMBoolean();
        addLexicalToNativeMapping(booleanMap);
        addNativeToLexicalMapping(booleanMap);

        TypeMaps.TMByte byteMap = new TypeMaps.TMByte();
        addLexicalToNativeMapping(byteMap);
        addNativeToLexicalMapping(byteMap);

        TypeMaps.TMDecimal decimalMap = new TypeMaps.TMDecimal();
        addLexicalToNativeMapping(decimalMap);
        addNativeToLexicalMapping(decimalMap);

        TypeMaps.TMDouble doubleMap = new TypeMaps.TMDouble();
        addLexicalToNativeMapping(doubleMap);
        addNativeToLexicalMapping(doubleMap);

        TypeMaps.TMFloat floatMap = new TypeMaps.TMFloat();
        addLexicalToNativeMapping(floatMap);
        addNativeToLexicalMapping(floatMap);

        addLexicalToNativeMapping(new TypeMaps.TMHexBinary());

        TypeMaps.TMInt intMap = new TypeMaps.TMInt();
        addLexicalToNativeMapping(intMap);
        addNativeToLexicalMapping(intMap);

        TypeMaps.TMInteger integerMap = new TypeMaps.TMInteger();
        addLexicalToNativeMapping(integerMap);
        addNativeToLexicalMapping(integerMap);

        TypeMaps.TMLong longMap = new TypeMaps.TMLong();
        addLexicalToNativeMapping(longMap);
        addNativeToLexicalMapping(longMap);

        TypeMaps.TMShort shortMap = new TypeMaps.TMShort();
        addLexicalToNativeMapping(shortMap);
        addNativeToLexicalMapping(shortMap);

        TypeMaps.TMString stringMap = new TypeMaps.TMString();
        addLexicalToNativeMapping(stringMap);
        addNativeToLexicalMapping(stringMap);

        addLexicalToNativeMapping(new TypeMaps.TMUnsignedInt());

        addLexicalToNativeMapping(new TypeMaps.TMUnsignedShort());

        addLexicalToNativeMapping(new TypeMaps.TMUnsignedByte());

        addNativeToLexicalMapping(new TypeMaps.TMJavaDate());

        addNativeToLexicalMapping(new TypeMaps.TMJavaCalendar());

        addNativeToLexicalMapping(new TypeMaps.TMSQLTimestamp());

        addNativeToLexicalMapping(new TypeMaps.TMSQLTime());

        addNativeToLexicalMapping(new TypeMaps.TMSQLDate());

        TypeMaps.TMXMLGregorianCalendar datetimeMap = new TypeMaps.TMXMLGregorianCalendar(DatatypeConstants.DATETIME);
        addLexicalToNativeMapping(datetimeMap);
        addNativeToLexicalMapping(datetimeMap);

        TypeMaps.TMXMLGregorianCalendar dateMap = new TypeMaps.TMXMLGregorianCalendar(DatatypeConstants.DATE);
        addLexicalToNativeMapping(dateMap);
        addNativeToLexicalMapping(dateMap);

        TypeMaps.TMXMLGregorianCalendar timeMap = new TypeMaps.TMXMLGregorianCalendar(DatatypeConstants.TIME);
        addLexicalToNativeMapping(timeMap);
        addNativeToLexicalMapping(timeMap);

        TypeMaps.TMXMLGregorianCalendar gdayMap = new TypeMaps.TMXMLGregorianCalendar(DatatypeConstants.GDAY);
        addLexicalToNativeMapping(gdayMap);
        addNativeToLexicalMapping(gdayMap);

        TypeMaps.TMXMLGregorianCalendar gmonthMap = new TypeMaps.TMXMLGregorianCalendar(DatatypeConstants.GMONTH);
        addLexicalToNativeMapping(gmonthMap);
        addNativeToLexicalMapping(gmonthMap);

        TypeMaps.TMXMLGregorianCalendar gmonthdayMap = new TypeMaps.TMXMLGregorianCalendar(DatatypeConstants.GMONTHDAY);
        addLexicalToNativeMapping(gmonthdayMap);
        addNativeToLexicalMapping(gmonthdayMap);

        TypeMaps.TMXMLGregorianCalendar gyearMap = new TypeMaps.TMXMLGregorianCalendar(DatatypeConstants.GYEAR);
        addLexicalToNativeMapping(gyearMap);
        addNativeToLexicalMapping(gyearMap);

        TypeMaps.TMXMLGregorianCalendar gyearmonthMap = new TypeMaps.TMXMLGregorianCalendar(DatatypeConstants.GYEARMONTH);
        addLexicalToNativeMapping(gyearmonthMap);
        addNativeToLexicalMapping(gyearmonthMap);

        TypeMaps.TMDuration durationMap = new TypeMaps.TMDuration(DatatypeConstants.DURATION);
        addLexicalToNativeMapping(durationMap);
        addNativeToLexicalMapping(durationMap);

        TypeMaps.TMDuration durationDayTimeMap = new TypeMaps.TMDuration(DatatypeConstants.DURATION_DAYTIME);
        addLexicalToNativeMapping(durationDayTimeMap);
        addNativeToLexicalMapping(durationDayTimeMap);

        TypeMaps.TMDuration durationYearMonthMap = new TypeMaps.TMDuration(DatatypeConstants.DURATION_YEARMONTH);
        addLexicalToNativeMapping(durationYearMonthMap);
        addNativeToLexicalMapping(durationYearMonthMap);

        addLexicalToNativeMapping(new TypeMaps.TMXmlLiteralString());

        // TODO: what about positiveInteger, etc.?

    }
}
