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
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.services.ITracker;
import org.openanzo.services.impl.DatasetTracker;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class DatasetTrackerSerializer {
    /**
     * The Anzo Property for namedDataset
     * <p>
     * (URI: http://openanzo.org/ontologies/2008/07/Anzo#namedDataset)
     * </p>
     * <br>
     */
    public static org.openanzo.rdf.URI namedDatasetProperty = Constants.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#namedDataset");

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
    static private java.util.Set<DatasetTracker> deserialize(String serialized, String formatString) throws AnzoException {
        if (serialized == null || serialized.length() == 0)
            return null;
        org.openanzo.rdf.RDFFormat format = RDFFormat.forMIMEType(formatString);
        if (!org.openanzo.rdf.RDFFormat.JSON.equals(format)) {
            format = RDFFormat.TRIG;
        }
        Set<DatasetTracker> trackers = new HashSet<DatasetTracker>();
        Collection<Statement> statements = ReadWriteUtils.readStatements(serialized, format);
        org.openanzo.rdf.Dataset dataset = new org.openanzo.rdf.Dataset(ITracker.TRACKERS);
        dataset.addWithGraphs(statements);

        for (org.openanzo.ontologies.openanzo.DatasetTracker dst : AnzoFactory.getAllDatasetTracker(dataset)) {
            DatasetTracker tracker = new DatasetTracker((URI) dst.resource());
            for (NamedGraph uri : dst.getDefaultGraph()) {
                tracker.getDefaultGraphs().add((URI) uri.resource());
            }
            for (NamedGraph uri : dst.getNamedGraph()) {
                tracker.getNamedGraphs().add((URI) uri.resource());
            }
            for (NamedGraph uri : dst.getNamedDataset()) {
                tracker.getNamedDatasets().add((URI) uri.resource());
            }
            trackers.add(tracker);
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
    static private String serialize(java.util.Set<DatasetTracker> object, String format) throws AnzoException {
        org.openanzo.rdf.Dataset dataset = new org.openanzo.rdf.Dataset(ITracker.TRACKERS);
        for (DatasetTracker tracker : object) {
            org.openanzo.ontologies.openanzo.DatasetTracker ds = AnzoFactory.createDatasetTracker(tracker.getTrackerURI(), tracker.getTrackerURI(), dataset);
            for (URI uri : tracker.getDefaultGraphs()) {
                ds.addDefaultGraph(uri);
            }
            for (URI uri : tracker.getNamedGraphs()) {
                ds.addNamedGraph(uri);
            }
            for (URI uri : tracker.getNamedDatasets()) {
                ds.addNamedDataset(uri);
            }
        }
        java.io.StringWriter writer = new java.io.StringWriter();
        org.openanzo.rdf.utils.ReadWriteUtils.writeStatements(dataset.getStatements(), writer, RDFFormat.forMIMEType(format), null, false);
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
    static public void serialize(java.util.Set<DatasetTracker> object, String propertyName, String format, IMessage message) throws AnzoException {
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
    static public java.util.Set<DatasetTracker> deserialize(IMessage message, String propertyName, String format) throws AnzoException {
        String property = message.getProperty(propertyName);
        java.util.Set<DatasetTracker> results = deserialize(property, format);
        return results;
    }
}
