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
package org.openanzo.rdf;

import java.util.Map;

import javax.xml.datatype.XMLGregorianCalendar;

import org.openanzo.exceptions.AnzoRuntimeException;

/**
 * RDF Node value factory. Provides methods for creating the various types of RDF nodes.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
abstract class ValueFactory {
    /**
     * Purge any memory caches
     */
    public abstract void purgeCaches();

    /**
     * Creates a blank node.
     * 
     * @return new blank node.
     */
    public abstract BlankNode createBNode();

    /**
     * Creates a blank node using the provided id.
     * 
     * @param id
     * @return a blank node using the provided id.
     */
    public abstract BlankNode createBNode(String id);

    /**
     * Create either a BNode or URI based on contents of value
     * 
     * @param value
     *            Value to convert to resource
     * @return Value converted to URI
     */
    public abstract Resource createResource(String value);

    /**
     * Create a literal with its datatype derived from the type of object passed in.
     * 
     * @param value
     *            Value to convert to literal
     * @return Literal representation of value
     */
    public abstract TypedLiteral createTypedLiteral(Object value);

    /**
     * Create a plain literal with the provided label.
     * 
     * @param label
     *            A literal label.
     * @return A plain literal.
     */
    public abstract PlainLiteral createLiteral(String label);

    /**
     * Create a plain literal with a language tag.
     * 
     * @param label
     *            A literal label string.
     * @param lang
     *            An RFC 3066 language tag.
     * @return A plain literal.
     */
    public abstract PlainLiteral createLiteral(String label, String lang);

    /**
     * Create a typed literal.
     * 
     * @param label
     *            The literal label.
     * @param dataType
     *            The XML Schema datatype URI.
     * @return A typed literal.
     */
    public abstract TypedLiteral createLiteral(String label, URI dataType);

    /**
     * Creates an RDF statement tuple.
     * 
     * @param subj
     *            An RDF statement subject.
     * @param prop
     *            An RDf statement predicate.
     * @param obj
     *            An RDF statement object.
     * @return An RDF statement.
     */
    public abstract Statement createStatement(Resource subj, URI prop, Value obj);

    /**
     * Creates an RDF statement tuple that includes a namedGraphUri.
     * 
     * @param subj
     *            An RDF statement subject.
     * @param prop
     *            An RDf statement predicate.
     * @param obj
     *            An RDF statement object.
     * @param namedGraphUri
     *            An RDF statement namedGraphUri.
     * @return An RDF statement.
     */
    public abstract Statement createStatement(Resource subj, URI prop, Value obj, URI namedGraphUri);

    /**
     * Create a statement, replacing any null values with Constants.ANY_URI
     * 
     * @param subj
     *            Subject of statement, or null which is replaced with ANY_URI
     * @param prop
     *            Property of statement, or null which is replaced with ANY_URI
     * @param obj
     *            Object of statement, or null which is replaced with ANY_URI
     * @param context
     *            Context of statement, or null which is replaced with ANY_URI
     * @return Statement with nulls replaced with ANY_URI
     */
    public abstract Statement createMatchStatement(Resource subj, URI prop, Value obj, URI context);

    /**
     * Create a statement, replacing any null values with Constants.ANY_URI
     * 
     * @param subj
     *            Subject of statement, or null which is replaced with ANY_URI
     * @param prop
     *            Property of statement, or null which is replaced with ANY_URI
     * @param obj
     *            Object of statement, or null which is replaced with ANY_URI
     * @return Statement with nulls replaced with ANY_URI
     */
    public abstract Statement createMatchStatement(Resource subj, URI prop, Value obj);

    /**
     * Registers a prefix with this value factory.
     * 
     * @param shortName
     * @param uriPrefix
     */
    public abstract void registerPrefix(String shortName, String uriPrefix);

    /**
     * Prepends "PREFIX" declarations for all prefix-to-uri mappings registred with this factory to the provided SPARQL query string.
     * 
     * @param queryString
     *            A SPARQL query string.
     * @return The provided SPARQL query string with the "PREFIX" declarations prepended to it.
     */
    public abstract String prefixQuery(String queryString);

    /**
     * Creates a URI from the provided CURIE using the registered prefixes to expand it to a URI.
     * 
     * @param curie
     *            A CURIE.
     * @return A URI.
     */
    public abstract URI createURIFromCURIE(String curie);

    public abstract Map<String, String> getRegisteredPrefixes();

    /**
     * Create URI based on uri value.
     * 
     * @param uri
     *            string representation of URI
     * @return URI representation of passed in value
     * @throws AnzoRuntimeException
     *             if there are any spaces in the URI
     */
    public abstract URI createURI(String uri);

    public URI createURI(String namespace, String uri) {
        return createURI(namespace + uri);
    }

    public TypedLiteral createLiteral(boolean value) {
        return createTypedLiteral(value);
    }

    public TypedLiteral createLiteral(byte value) {
        return createTypedLiteral(value);
    }

    public TypedLiteral createLiteral(short value) {
        return createTypedLiteral(value);
    }

    public TypedLiteral createLiteral(int value) {
        return createTypedLiteral(value);
    }

    public TypedLiteral createLiteral(long value) {
        return createTypedLiteral(value);
    }

    public TypedLiteral createLiteral(float value) {
        return createTypedLiteral(value);
    }

    public TypedLiteral createLiteral(double value) {
        return createTypedLiteral(value);
    }

    public TypedLiteral createLiteral(XMLGregorianCalendar value) {
        return createTypedLiteral(value);
    }
}
