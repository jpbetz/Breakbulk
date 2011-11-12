/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/utils/StatementUtils.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Dec 19, 2006
 * Revision:    $Id: StatementUtils.java 168 2007-07-31 14:11:14Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.utils;

import info.aduna.collections.iterators.Iterators;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.collections15.MultiMap;
import org.apache.commons.collections15.multimap.MultiHashMap;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.PlainLiteral;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.query.QueryEncoder;
import org.openanzo.rdf.vocabulary.RDF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Basic utilities for Statements and Literal
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class StatementUtils {

    private static final Logger log                 = LoggerFactory.getLogger(StatementUtils.class);

    private static final String containerItemPrefix = RDF.NAMESPACE + "_";

    /**
     * Determine if given statement matches given subject,prop,obj,namedgraph pattern
     * 
     * @param statement
     *            Statement to compare against match parameters
     * @param subj
     *            Subject to match, or null for any
     * @param prop
     *            Predicate to match, or null for any
     * @param obj
     *            Object to match, or null for any
     * @param context
     *            NamedGraph to match, or null for any
     * @return true if statement provided matches the 4 parameters passed
     */
    public static boolean match(Statement statement, Resource subj, org.openanzo.rdf.URI prop, Value obj, org.openanzo.rdf.URI context) {
        if (subj == null && prop == null && obj == null && context == null) {
            return true;
        } else {
            if (subj != null && !subj.equals(Constants.ANY_URI) && !subj.equals(statement.getSubject())) {
                return false;
            }
            if (prop != null && !prop.equals(Constants.ANY_URI) && !prop.equals(statement.getPredicate())) {
                return false;
            }
            if (obj != null && !obj.equals(Constants.ANY_URI) && !obj.equals(statement.getObject())) {
                return false;
            }
            if (context != null && !context.equals(Constants.ANY_URI) && !context.equals(statement.getNamedGraphUri())) {
                return false;
            }
            return true;
        }
    }

    /**
     * Try to convert Literal to native object based on datatype
     * 
     * @param literal
     *            Literal to convert
     * @return native value of object based on datatype, or a string containing the literal's label if no conversion exists.
     */
    static public Object getNativeValue(Literal literal) {
        if (literal instanceof PlainLiteral) {
            PlainLiteral pl = (PlainLiteral) literal;
            return pl.getLabel();
        } else {
            TypedLiteral pl = (TypedLiteral) literal;
            return pl.getNativeValue();
        }
    }

    /**
     * Convert an xsd:dateTime Literal to its long representation. Note that xsd:dateTime allows the time zone to be omitted. However, to convert a literal to a
     * millisecond value, requires a time zone. That's because the millisecond long value is supposed to represent an absolute time. that is, milliseconds since
     * January 1, 1970, 00:00:00 GMT. Without a time zone in the xsd:dateTime literal, that number cannot be derived.
     * 
     * Note that this may cause information loss. xsd:dateTime support arbitrary precision fractional seconds. This method reduces the precision to
     * milliseconds.
     * 
     * @param dateTime
     *            xsd:dateTime Literal to convert
     * @return long representation of literal. null if the literal couldn't be parsed into a long such as for lack of a time zone being specified in the
     *         literal.
     */
    protected static Long convertToMilliseconds(TypedLiteral dateTime) {
        Long ret = null;
        Object nativeValue = dateTime.getNativeValue();
        if (nativeValue instanceof XMLGregorianCalendar) {
            XMLGregorianCalendar xmlCal = (XMLGregorianCalendar) nativeValue;
            try {
                if (xmlCal.getXMLSchemaType().equals(DatatypeConstants.DATETIME) && xmlCal.getTimezone() != DatatypeConstants.FIELD_UNDEFINED) {
                    ret = xmlCal.toGregorianCalendar().getTimeInMillis();
                }
            } catch (IllegalStateException e) {
                // XMLGregorianCalendar#getXMLSchemaType() will throw an IllegalStateException if the XMLGregorianCalendar is invalid.
                log.debug(LogUtils.GLITTER_MARKER, "Error parsing dateTime literal into millisecond representation: {}", dateTime.toString());
            }
        }
        return ret;
    }

    /**
     * Convert {@link Constants#ANY_URI} to a null
     * 
     * @param node
     *            Value to convert to null if Constants.ANY_URI
     * @return value or null if equals {@link Constants#ANY_URI}
     */
    public static Value convertUriToAny(Value node) {
        if (node != null && node.equals(Constants.ANY_URI)) {
            return null;
        }
        return node;
    }

    /**
     * Build a string representing this find operation
     * 
     * @param subject
     * @param property
     * @param object
     * @param namedGraphUri
     * @return a string representing this find operation
     */
    public static String buildQueryString(Resource subject, org.openanzo.rdf.URI property, Value object, URI... namedGraphUri) {
        String subjectNode = createQueryNodeString(subject, "subject");
        String predicateNode = createQueryNodeString(property, "predicate");
        String objectNode = createQueryNodeString(object, "object");
        StringBuilder query = new StringBuilder("SELECT ");
        query.append("?graph ");
        if (subjectNode.startsWith("?")) {
            query.append(subjectNode + " ");
        }
        if (predicateNode.startsWith("?")) {
            query.append(predicateNode + " ");
        }
        if (objectNode.startsWith("?")) {
            query.append(objectNode + " ");
        }
        if (namedGraphUri != null) {
            for (URI uri : namedGraphUri) {
                query.append(" FROM NAMED " + QueryEncoder.encodeForQuery(uri));
            }
        }
        query.append(" WHERE { GRAPH ");
        query.append(" ?graph ");
        query.append(" {");
        query.append(subjectNode);
        query.append(" ");
        query.append(predicateNode);
        query.append(" ");
        query.append(objectNode);
        query.append(" }}");
        return query.toString();
    }

    private static String createQueryNodeString(Value value, String name) {
        if (value == null || value.equals(Constants.ANY_URI)) {
            return "?" + name + " ";
        }
        return QueryEncoder.encodeForQuery(value);
    }

    /**
     * Get an Collection for the members of the RDFContainer construct provided
     * 
     * @param container
     *            Resource of RDFContainer object
     * @param graph
     *            Graph containing data
     * @return Collection containing data contained within RDFContainer
     * @throws AnzoException
     */
    public static Collection<Value> getContainerMembers(Resource container, INamedGraph graph) throws AnzoException {
        ArrayList<Value> statements = new ArrayList<Value>();
        if (graph.contains(container, RDF.TYPE, RDF.ALT) || graph.contains(container, RDF.TYPE, RDF.Bag) || graph.contains(container, RDF.TYPE, RDF.Seq)) {
            Collection<Statement> containedStatements = graph.find(container, null, null);
            for (Statement stmt : containedStatements) {
                String predicate = stmt.getPredicate().toString();
                if (predicate.startsWith(containerItemPrefix)) {
                    String val = predicate.substring(containerItemPrefix.length());
                    try {
                        int li = Integer.parseInt(val);
                        statements.add(li, stmt.getObject());
                    } catch (NumberFormatException e) {
                        throw new AnzoException(ExceptionConstants.IO.USER_ENCODE_ERROR, e);
                    }
                }
            }
        }
        return statements;
    }

    /**
     * Get an Collection for the members of the RDFContainer construct provided
     * 
     * @param container
     *            Resource of RDFContainer object
     * @param dataset
     *            Dataset containing data
     * @return Collection containing data contained within RDFContainer
     * @throws AnzoException
     */
    public static Collection<Statement> getContainerMembers(Resource container, IDataset dataset) throws AnzoException { // NO_UCD
        ArrayList<Statement> statements = new ArrayList<Statement>();
        if (dataset.contains(container, RDF.TYPE, RDF.ALT) || dataset.contains(container, RDF.TYPE, RDF.Bag) || dataset.contains(container, RDF.TYPE, RDF.Seq)) {
            Collection<Statement> containedStatements = dataset.find(container, null, null);
            for (Statement stmt : containedStatements) {
                String predicate = stmt.getPredicate().toString();
                if (predicate.startsWith(containerItemPrefix)) {
                    String val = predicate.substring(containerItemPrefix.length());
                    try {
                        int li = Integer.parseInt(val);
                        statements.add(li, stmt);
                    } catch (NumberFormatException e) {
                        throw new AnzoException(ExceptionConstants.IO.USER_ENCODE_ERROR, e);
                    }
                }
            }
        }
        return statements;
    }

    /**
     * Get an Collection for the members of the RDFList construct provided
     * 
     * @param list
     *            Resource of RDFList object
     * @param graph
     *            Graph containing data
     * @return Collection containing data contained within RDFContainer
     */
    public static Collection<Value> getCollectionMembers(Resource list, INamedGraph graph) {
        ArrayList<Value> statements = new ArrayList<Value>();
        if (graph.contains(list, RDF.first, null) && graph.contains(list, RDF.rest, null)) {
            Collection<Statement> firstStatements = graph.find(list, RDF.first, null);
            if (!firstStatements.isEmpty()) {
                Statement first = firstStatements.iterator().next();
                if (!statements.contains(first.getObject())) {
                    statements.add(first.getObject());
                }
            }

            Collection<Statement> restStatements = graph.find(list, RDF.rest, null);
            if (!restStatements.isEmpty()) {
                Statement rest = restStatements.iterator().next();
                if (!statements.contains(rest.getObject()) && rest.getObject() instanceof Resource) {
                    Iterators.addAll(getCollectionMembers((Resource) rest.getObject(), graph).iterator(), statements);
                }
            }
        }
        return statements;
    }

    /**
     * Get an Collection for the members of the RDFList construct provided
     * 
     * @param list
     *            Resource of RDFList object
     * @param dataset
     *            Dataset containing data
     * @return Collection containing data contained within RDFContainer
     */
    public static MultiMap<URI, Value> getCollectionMembers(Resource list, IDataset dataset) { // NO_UCD
        MultiHashMap<URI, Value> statements = new MultiHashMap<URI, Value>();
        if (dataset.contains(list, RDF.first, null) && dataset.contains(list, RDF.rest, null)) {
            Collection<Statement> firstStatements = dataset.find(list, RDF.first, null);
            if (!firstStatements.isEmpty()) {
                Statement first = firstStatements.iterator().next();
                if (!statements.containsValue(first.getNamedGraphUri(), first.getObject())) {
                    statements.put(first.getNamedGraphUri(), first.getObject());
                }
            }

            Collection<Statement> restStatements = dataset.find(list, RDF.rest, null);
            if (!restStatements.isEmpty()) {
                Statement rest = restStatements.iterator().next();
                if (!statements.containsValue(rest.getNamedGraphUri(), rest.getObject()) && rest.getObject() instanceof Resource) {
                    statements.putAll(getCollectionMembers((Resource) rest.getObject(), dataset));
                }
            }
        }
        return statements;
    }
}
