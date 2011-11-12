/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.rdf.vocabulary;

import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.URI;

/**
 *XML Schema vocab
 */
public class XMLSchema {
    /** XML Schema Namespace */
    public static final String NAMESPACE = "http://www.w3.org/2001/XMLSchema#";

    protected static URI createProperty(String localName) {
        return MemURI.create(NAMESPACE + localName);
    }

    /** http://www.w3.org/2001/XMLSchema#duration */
    public final static URI DURATION             = createProperty("duration");

    /** http://www.w3.org/2001/XMLSchema#dateTime */
    public final static URI DATETIME             = createProperty("dateTime");

    /** http://www.w3.org/2001/XMLSchema#time */
    public final static URI TIME                 = createProperty("time");

    /** http://www.w3.org/2001/XMLSchema#date */
    public final static URI DATE                 = createProperty("date");

    /** http://www.w3.org/2001/XMLSchema#gYearMonth */
    public final static URI GYEARMONTH           = createProperty("gYearMonth");

    /** http://www.w3.org/2001/XMLSchema#gYear */
    public final static URI GYEAR                = createProperty("gYear");

    /** http://www.w3.org/2001/XMLSchema#gMonthDay */
    public final static URI GMONTHDAY            = createProperty("gMonthDay");

    /** http://www.w3.org/2001/XMLSchema#gDay */
    public final static URI GDAY                 = createProperty("gDay");

    /** http://www.w3.org/2001/XMLSchema#gMonth */
    public final static URI GMONTH               = createProperty("gMonth");

    /** http://www.w3.org/2001/XMLSchema#string */
    public final static URI STRING               = createProperty("string");

    /** http://www.w3.org/2001/XMLSchema#boolean */
    public final static URI BOOLEAN              = createProperty("boolean");

    /** http://www.w3.org/2001/XMLSchema#base64Binary */
    public final static URI BASE64BINARY         = createProperty("base64Binary");

    /** http://www.w3.org/2001/XMLSchema#hexBinary */
    public final static URI HEXBINARY            = createProperty("hexBinary");

    /** http://www.w3.org/2001/XMLSchema#float */
    public final static URI FLOAT                = createProperty("float");

    /** http://www.w3.org/2001/XMLSchema#decimal */
    public final static URI DECIMAL              = createProperty("decimal");

    /** http://www.w3.org/2001/XMLSchema#double */
    public final static URI DOUBLE               = createProperty("double");

    /** http://www.w3.org/2001/XMLSchema#anyURI */
    public final static URI ANYURI               = createProperty("anyURI");

    /** http://www.w3.org/2001/XMLSchema#QName */
    public final static URI QNAME                = createProperty("QName");

    /** http://www.w3.org/2001/XMLSchema#NOTATION */
    public final static URI NOTATION             = createProperty("NOTATION");

    /*
     * Derived datatypes
     */

    /** http://www.w3.org/2001/XMLSchema#normalizedString */
    public final static URI NORMALIZEDSTRING     = createProperty("normalizedString");

    /** http://www.w3.org/2001/XMLSchema#token */
    public final static URI TOKEN                = createProperty("token");

    /** http://www.w3.org/2001/XMLSchema#language */
    public final static URI LANGUAGE             = createProperty("language");

    /** http://www.w3.org/2001/XMLSchema#NMTOKEN */
    public final static URI NMTOKEN              = createProperty("NMTOKEN");

    /** http://www.w3.org/2001/XMLSchema#NMTOKENS */
    public final static URI NMTOKENS             = createProperty("NMTOKENS");

    /** http://www.w3.org/2001/XMLSchema#Name */
    public final static URI NAME                 = createProperty("Name");

    /** http://www.w3.org/2001/XMLSchema#NCName */
    public final static URI NCNAME               = createProperty("NCName");

    /** http://www.w3.org/2001/XMLSchema#ID */
    public final static URI ID                   = createProperty("ID");

    /** http://www.w3.org/2001/XMLSchema#IDREF */
    public final static URI IDREF                = createProperty("IDREF");

    /** http://www.w3.org/2001/XMLSchema#IDREFS */
    public final static URI IDREFS               = createProperty("IDREFS");

    /** http://www.w3.org/2001/XMLSchema#ENTITY */
    public final static URI ENTITY               = createProperty("ENTITY");

    /** http://www.w3.org/2001/XMLSchema#ENTITIES */
    public final static URI ENTITIES             = createProperty("ENTITIES");

    /** http://www.w3.org/2001/XMLSchema#integer */
    public final static URI INTEGER              = createProperty("integer");

    /** http://www.w3.org/2001/XMLSchema#long */
    public final static URI LONG                 = createProperty("long");

    /** http://www.w3.org/2001/XMLSchema#int */
    public final static URI INT                  = createProperty("int");

    /** http://www.w3.org/2001/XMLSchema#short */
    public final static URI SHORT                = createProperty("short");

    /** http://www.w3.org/2001/XMLSchema#byte */
    public final static URI BYTE                 = createProperty("byte");

    /** http://www.w3.org/2001/XMLSchema#nonPositiveInteger */
    public final static URI NON_POSITIVE_INTEGER = createProperty("nonPositiveInteger");

    /** http://www.w3.org/2001/XMLSchema#negativeInteger */
    public final static URI NEGATIVE_INTEGER     = createProperty("negativeInteger");

    /** http://www.w3.org/2001/XMLSchema#nonNegativeInteger */
    public final static URI NON_NEGATIVE_INTEGER = createProperty("nonNegativeInteger");

    /** http://www.w3.org/2001/XMLSchema#positiveInteger */
    public final static URI POSITIVE_INTEGER     = createProperty("positiveInteger");

    /** http://www.w3.org/2001/XMLSchema#unsignedLong */
    public final static URI UNSIGNED_LONG        = createProperty("unsignedLong");

    /** http://www.w3.org/2001/XMLSchema#unsignedInt */
    public final static URI UNSIGNED_INT         = createProperty("unsignedInt");

    /** http://www.w3.org/2001/XMLSchema#unsignedShort */
    public final static URI UNSIGNED_SHORT       = createProperty("unsignedShort");

    /** http://www.w3.org/2001/XMLSchema#unsignedByte */
    public final static URI UNSIGNED_BYTE        = createProperty("unsignedByte");

    /*
     * XQuery 1.0 and XPath 2.0 spec adds two duration datatypes to the XML Schema namespace.
     */

    /** http://www.w3.org/2001/XMLSchema#dayTimeDuration */
    public final static URI DURATION_DAYTIME     = createProperty("dayTimeDuration");

    /** http://www.w3.org/2001/XMLSchema#yearMonthDuration */
    public final static URI DURATION_YEARMONTH   = createProperty("yearMonthDuration");

}
