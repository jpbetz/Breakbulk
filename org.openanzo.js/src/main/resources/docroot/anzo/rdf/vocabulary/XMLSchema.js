/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>)
 * Created on:  Oct 10, 2007
 * Revision:
 $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 */
 
dojo.provide("anzo.rdf.vocabulary.XMLSchema");

dojo.require("anzo.rdf.Statement");

anzo.rdf.registerNamespace('xmls', "http://www.w3.org/2001/XMLSchema#");

anzo.rdf.vocabulary.XMLSchema = {
	
	
	/** http://www.w3.org/2001/XMLSchema#duration */
    xsDuration     :  anzo.createURI("xmls:duration"),

    /** http://www.w3.org/2001/XMLSchema#dateTime */
    xsDateTime     :  anzo.createURI("xmls:dateTime"),

    /** http://www.w3.org/2001/XMLSchema#time */
    xsTime     :  anzo.createURI("xmls:time"),

    /** http://www.w3.org/2001/XMLSchema#date */
    xsDate     :  anzo.createURI("xmls:date"),

    /** http://www.w3.org/2001/XMLSchema#gYearMonth */
    xsGYearMonth     :  anzo.createURI("xmls:gYearMonth"),

    /** http://www.w3.org/2001/XMLSchema#gYear */
    xsGYear     :  anzo.createURI("xmls:gYear"),

    /** http://www.w3.org/2001/XMLSchema#gMonthDay */
    xsGMonthDay     :  anzo.createURI("xmls:gMonthDay"),

    /** http://www.w3.org/2001/XMLSchema#gDay */
    xsGDay     :  anzo.createURI("xmls:gDay"),

    /** http://www.w3.org/2001/XMLSchema#gMonth */
    xsGMonth     :  anzo.createURI("xmls:gMonth"),

    /** http://www.w3.org/2001/XMLSchema#string */
    xsString     :  anzo.createURI("xmls:string"),

    /** http://www.w3.org/2001/XMLSchema#boolean */
    xsBoolean     :  anzo.createURI("xmls:boolean"),

    /** http://www.w3.org/2001/XMLSchema#base64Binary */
    xsBase64Binary     :  anzo.createURI("xmls:base64Binary"),

    /** http://www.w3.org/2001/XMLSchema#hexBinary */
    xsHexBinary     :  anzo.createURI("xmls:hexBinary"),

    /** http://www.w3.org/2001/XMLSchema#float */
    xsFloat     :  anzo.createURI("xmls:float"),

    /** http://www.w3.org/2001/XMLSchema#decimal */
    xsDecimal     :  anzo.createURI("xmls:decimal"),

    /** http://www.w3.org/2001/XMLSchema#double */
    xsDouble     :  anzo.createURI("xmls:double"),

    /** http://www.w3.org/2001/XMLSchema#anyxs*/
    xsAnyxs    :  anzo.createURI("xmls:anyURI"),

    /** http://www.w3.org/2001/XMLSchema#QName */
    xsQName     :  anzo.createURI("xmls:QName"),

    /** http://www.w3.org/2001/XMLSchema#NOTATION */
    xsNOTATION     :  anzo.createURI("xmls:NOTATION"),

    /*
     * Derived datatypes
     */

    /** http://www.w3.org/2001/XMLSchema#normalizedString */
    xsNormalizedString     :  anzo.createURI("xmls:normalizedString"),

    /** http://www.w3.org/2001/XMLSchema#token */
    xsToken    :  anzo.createURI("xmls:token"),

    /** http://www.w3.org/2001/XMLSchema#language */
    xsLanguage     :  anzo.createURI("xmls:language"),

    /** http://www.w3.org/2001/XMLSchema#NMTOKEN */
    xsNMTOKEN     :  anzo.createURI("xmls:NMTOKEN"),

    /** http://www.w3.org/2001/XMLSchema#NMTOKENS */
    xsNMTOKENS     :  anzo.createURI("xmls:NMTOKENS"),

    /** http://www.w3.org/2001/XMLSchema#Name */
    xsName     :  anzo.createURI("xmls:Name"),

    /** http://www.w3.org/2001/XMLSchema#NCName */
    xsNCName    :  anzo.createURI("xmls:NCName"),

    /** http://www.w3.org/2001/XMLSchema#ID */
    xsID     :  anzo.createURI("xmls:ID"),

    /** http://www.w3.org/2001/XMLSchema#IDREF */
    xsIDREF     :  anzo.createURI("xmls:IDREF"),

    /** http://www.w3.org/2001/XMLSchema#IDREFS */
    xsIDREFS     :  anzo.createURI("xmls:IDREFS"),

    /** http://www.w3.org/2001/XMLSchema#ENTITY */
    xsENTITY     :  anzo.createURI("xmls:ENTITY"),

    /** http://www.w3.org/2001/XMLSchema#ENTITIES */
    xsENTITIES     :  anzo.createURI("xmls:ENTITIES"),

    /** http://www.w3.org/2001/XMLSchema#integer */
    xsInteger     :  anzo.createURI("xmls:integer"),

    /** http://www.w3.org/2001/XMLSchema#long */
    xsLong     :  anzo.createURI("xmls:long"),

    /** http://www.w3.org/2001/XMLSchema#int */
    xsInt     :  anzo.createURI("xmls:int"),

    /** http://www.w3.org/2001/XMLSchema#short */
    xsShort     :  anzo.createURI("xmls:short"),

    /** http://www.w3.org/2001/XMLSchema#byte */
    xsByte     :  anzo.createURI("xmls:byte"),

    /** http://www.w3.org/2001/XMLSchema#nonPositiveInteger */
    xsNonPositiveInteger     :  anzo.createURI("xmls:nonPositiveInteger"),

    /** http://www.w3.org/2001/XMLSchema#negativeInteger */
    xsNegativeInteger     :  anzo.createURI("xmls:negativeInteger"),

    /** http://www.w3.org/2001/XMLSchema#nonNegativeInteger */
    xsNonNegativeInteger     :  anzo.createURI("xmls:nonNegativeInteger"),

    /** http://www.w3.org/2001/XMLSchema#positiveInteger */
    xsPositiveInteger     :  anzo.createURI("xmls:positiveInteger"),

    /** http://www.w3.org/2001/XMLSchema#unsignedLong */
    xsUnsignedLong     :  anzo.createURI("xmls:unsignedLong"),

    /** http://www.w3.org/2001/XMLSchema#unsignedInt */
    xsUnsignedInt     :  anzo.createURI("xmls:unsignedInt"),

    /** http://www.w3.org/2001/XMLSchema#unsignedShort */
    xsUnsignedShort     :  anzo.createURI("xmls:unsignedShort"),

    /** http://www.w3.org/2001/XMLSchema#unsignedByte */
    xsUnsignedByte     :  anzo.createURI("xmls:unsignedByte"),

    /*
     * XQuery 1.0 and XPath 2.0 spec adds two duration datatypes to the XML Schema namespace.
     */

    /** http://www.w3.org/2001/XMLSchema#dayTimeDuration */
    xsDayTimeDuration     :  anzo.createURI("xmls:dayTimeDuration"),

    /** http://www.w3.org/2001/XMLSchema#yearMonthDuration */
    xsYearMonthDuration     :  anzo.createURI("xmls:yearMonthDuration")
	
	
};
