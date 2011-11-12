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
 * Represents a map from a Java type (like {@link java.lang.Integer}, etc.) to a lexical datatype (like xsd:dateTime, xsd:integer, etc.).
 * 
 * Implementations must be thread-safe.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
 */
interface NativeToLexicalTypeMap {
    /**
     * Get the Class which this mapper supports for conversion into lexical values.
     * 
     * @return the Java Class which this type mapper knows how to convert to lexical values. Will never be null.
     */
    public Class<?> getJavaClass();

    /**
     * Retrieves the datatype that this mapper converts objects into.
     * 
     * @return the datatype that this mapper converts objects into. Will never be null.
     */
    public URI getOutputDatatype();

    /**
     * Transform from a native value to a lexical form of the value.
     * 
     * @param obj
     *            native value to convert
     * @return the lexical form of a native value
     */
    public String convertToLexicalValue(Object obj);

    @SuppressWarnings("all")
    /**
     * Check if this mapper supports the given object for converting into a lexical value.
     * 
     * @param obj
     *            the object instance to check.
     * @return true if the mapper supports conversion via {@link #convertToLexicalValue(Object)}.
     */
    public boolean canConvertToLexicalValue(Object obj);

}
