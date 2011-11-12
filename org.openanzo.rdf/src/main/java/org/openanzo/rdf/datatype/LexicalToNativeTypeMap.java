/******************************************************************************* 
 * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/rdf/datatype/ITypeMap.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: ITypeMap.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.datatype;

import org.openanzo.rdf.URI;

/**
 * Represents a map between an lexical datatype (like xsd:dateTime, xsd:integer, etc.) to a Java type (like {@link java.lang.Integer}, etc.).
 * 
 * Implementations must be thread-safe.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
 */
interface LexicalToNativeTypeMap {

    /**
     * Get the datatype URI which designates the types of lexical literal values that this mapper supports converting.
     * 
     * @return The datatype URI for this map. Will never be null.
     */
    public URI getDatatype();

    /**
     * When lexical values are converted into Java object instances by this mapper, those instances will be instances of the Class returned by this method.
     * 
     * @return the Java Class of which this type mapper creates instances. Will never be null.
     */
    public Class<?> getOutputJavaClass();

    @SuppressWarnings("all")
    /**
     * Transform from the lexical form of a value into a native Java object. The object will be of the class designated by {@link #getOutputJavaClass()}.
     * 
     * @param value
     *            lexical value to convert
     * @return a native Java object derived from the lexical value.
     */
    public Object convertToNativeObject(String value);

}
