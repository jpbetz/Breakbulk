/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Dec 26, 2007
 * Revision:	$Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services.serialization.transport;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.ontologies.openanzo.AnzoFactory;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.NamedGraph;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.ITracker;
import org.openanzo.services.impl.SelectorTracker;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class SelectorTrackerSerializer {
    /**
     * Deserialize from a String to type T
     * 
     * @param serialized
     *            String representation of object type T
     * @param format
     *            Format of the String
     * @return T deserialized object
     * @throws AnzoException
     *             if there was a problem deserializing the object
     */
    static private java.util.Set<SelectorTracker> deserialize(String serialized, String format) throws AnzoException {
        if (serialized == null || serialized.length() == 0)
            return null;

        if (!RDFFormat.JSON.getDefaultMIMEType().equals(format)) {
            format = org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType();
        }
        Set<SelectorTracker> trackers = new HashSet<SelectorTracker>();
        Collection<Statement> statements = ReadWriteUtils.readStatements(serialized, RDFFormat.forMIMEType(format));
        org.openanzo.rdf.Dataset dataset = new org.openanzo.rdf.Dataset();
        dataset.addWithGraphs(statements);
        for (org.openanzo.ontologies.openanzo.SelectorTracker st : AnzoFactory.getAllSelectorTracker(dataset)) {
            Set<Resource> subject = new HashSet<Resource>();
            for (Value s : st.getPropertyValues(org.openanzo.ontologies.openanzo.SelectorTracker.subjectProperty)) {
                if (s instanceof Resource) {
                    subject.add((Resource) s);
                }
            }
            Set<URI> predicate = new HashSet<URI>();
            for (Value p : st.getPropertyValues(org.openanzo.ontologies.openanzo.SelectorTracker.predicateProperty)) {
                if (p instanceof URI) {
                    predicate.add((URI) p);
                }
            }
            Set<Value> object = new HashSet<Value>();
            for (Value o : st.getPropertyValues(org.openanzo.ontologies.openanzo.SelectorTracker.objectProperty)) {
                object.add(o);
            }
            Set<URI> namedGraph = new HashSet<URI>();
            for (Value g : st.getPropertyValues(org.openanzo.ontologies.openanzo.SelectorTracker.namedGraphUriProperty)) {
                if (g instanceof URI) {
                    namedGraph.add((URI) g);
                }
            }
            trackers.add(new SelectorTracker(subject, predicate, object, namedGraph));
        }
        for (URI namedGraphUri : dataset.getNamedGraphUris()) {
            if (!ITracker.TRACKERS.equals(namedGraphUri)) {
                for (Statement stmt : dataset.getNamedGraph(namedGraphUri).getStatements()) {
                    trackers.add(new SelectorTracker(stmt.getSubject(), stmt.getPredicate(), stmt.getObject(), stmt.getNamedGraphUri()));
                }
            }
        }
        return trackers;
    }

    /**
     * Serialize the given object to a String
     * 
     * @param object
     *            Object to serialize
     * @param format
     *            If not null, the format of the serialized String
     * @return Serialized version of object
     * @throws AnzoException
     *             if there was a problem serializing the object
     */
    static private String serialize(java.util.Set<SelectorTracker> object, String format) throws AnzoException {
        INamedGraph graph = new NamedGraph(ITracker.TRACKERS);
        for (SelectorTracker tracker : object) {
            org.openanzo.ontologies.openanzo.SelectorTracker st = AnzoFactory.createSelectorTracker(UriGenerator.generateAnonymousURI("http://openanzo.org/trackers"), graph);
            if (tracker.getSubject() != null) {
                for (Resource subject : tracker.getSubject()) {
                    if (subject != null) {
                        graph.add(st.resource(), org.openanzo.ontologies.openanzo.SelectorTracker.subjectProperty, subject);
                    }
                }
            }
            if (tracker.getPredicate() != null) {
                for (URI predicate : tracker.getPredicate()) {
                    if (predicate != null) {
                        graph.add(st.resource(), org.openanzo.ontologies.openanzo.SelectorTracker.predicateProperty, predicate);
                    }
                }
            }
            if (tracker.getObject() != null) {
                for (Value obj : tracker.getObject()) {
                    if (obj != null) {
                        graph.add(st.resource(), org.openanzo.ontologies.openanzo.SelectorTracker.objectProperty, obj);
                    }
                }
            }
            if (tracker.getNamedGraphUri() != null) {
                for (URI ngUri : tracker.getNamedGraphUri()) {
                    if (ngUri != null) {
                        st.addNamedGraphUri(ngUri);
                    }
                }
            }
        }
        java.io.StringWriter writer = new java.io.StringWriter();
        ReadWriteUtils.writeStatements(graph.getStatements(), writer, RDFFormat.forMIMEType(format));
        return writer.toString();
    }

    /**
     * Serialize the given object to a String
     * 
     * @param object
     *            Object to serialize
     * @param propertyName
     *            Name of property within message
     * @param format
     *            If not null, the format of the serialized String
     * @param message
     *            Message to which parameter is written
     * @throws AnzoException
     *             if there was a problem serializing the object
     */
    static public void serialize(java.util.Set<SelectorTracker> object, String propertyName, String format, IMessage message) throws AnzoException {
        String trackers = serialize(object, format);
        message.setProperty(propertyName, trackers);
    }

    /**
     * Deserialize from a String to type T
     * 
     * @param message
     *            Message containing
     * @param propertyName
     *            Name of property within message
     * @param format
     *            Format of the String
     * @return T deserialized object
     * @throws AnzoException
     *             if there was a problem deserializing the object
     */
    static public java.util.Set<SelectorTracker> deserialize(IMessage message, String propertyName, String format) throws AnzoException {
        String property = message.getProperty(propertyName);
        java.util.Set<SelectorTracker> results = deserialize(property, format);
        return results;
    }
}
