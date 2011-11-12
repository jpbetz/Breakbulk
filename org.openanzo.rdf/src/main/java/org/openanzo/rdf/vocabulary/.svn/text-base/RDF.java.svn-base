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
 *RDF Vocabulary file
 */
public class RDF {
    /** RDF Namespace */
    public static final String NAMESPACE = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";

    protected static URI createProperty(String localName) {
        return MemURI.create(NAMESPACE + localName);
    }

    /** http://www.w3.org/1999/02/22-rdf-syntax-ns#type */
    public static final URI TYPE       = createProperty("type");

    /** http://www.w3.org/1999/02/22-rdf-syntax-ns#Property */
    public static final URI Property   = createProperty("Property");

    /** http://www.w3.org/1999/02/22-rdf-syntax-ns#Statement */
    public static final URI Statement  = createProperty("Statement");

    /** http://www.w3.org/1999/02/22-rdf-syntax-ns#subject */
    public static final URI subject    = createProperty("subject");

    /** http://www.w3.org/1999/02/22-rdf-syntax-ns#predicate */
    public static final URI predicate  = createProperty("predicate");

    /** http://www.w3.org/1999/02/22-rdf-syntax-ns#object */
    public static final URI object     = createProperty("object");

    /** http://www.w3.org/1999/02/22-rdf-syntax-ns#Bag */
    public static final URI Bag        = createProperty("Bag");

    /** http://www.w3.org/1999/02/22-rdf-syntax-ns#Seq */
    public static final URI Seq        = createProperty("Seq");

    /** http://www.w3.org/1999/02/22-rdf-syntax-ns#Alt */
    public static final URI ALT        = createProperty("Alt");

    /** http://www.w3.org/1999/02/22-rdf-syntax-ns#value */
    public static final URI value      = createProperty("value");

    /** http://www.w3.org/1999/02/22-rdf-syntax-ns#List */
    public static final URI List       = createProperty("List");

    /** http://www.w3.org/1999/02/22-rdf-syntax-ns#nil */
    public static final URI nil        = createProperty("nil");

    /** http://www.w3.org/1999/02/22-rdf-syntax-ns#first */
    public static final URI first      = createProperty("first");

    /** http://www.w3.org/1999/02/22-rdf-syntax-ns#rest */
    public static final URI rest       = createProperty("rest");

    /** http://www.w3.org/1999/02/22-rdf-syntax-ns#XMLLiteral */
    public static final URI XMLLiteral = createProperty("XMLLiteral");
}
