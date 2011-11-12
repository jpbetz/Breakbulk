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

import java.io.StringWriter;
import java.util.Collections;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.RDFFormat;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class StatementsSerializer {
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
    static public java.util.Collection<org.openanzo.rdf.Statement> deserialize(String serialized, String format) throws AnzoException {
        if (serialized == null || serialized.length() == 0)
            return Collections.<org.openanzo.rdf.Statement> emptySet();
        return org.openanzo.rdf.utils.ReadWriteUtils.readStatements(serialized, RDFFormat.forMIMEType(format));
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
    static public String serialize(java.util.Collection<org.openanzo.rdf.Statement> object, String format) throws AnzoException {
        StringWriter writer = new StringWriter();
        org.openanzo.rdf.utils.ReadWriteUtils.writeStatements(object, writer, RDFFormat.forMIMEType(format));
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
    static public void serialize(java.util.Collection<org.openanzo.rdf.Statement> object, String propertyName, String format, IMessage message) throws AnzoException {
        message.setProperty(propertyName, serialize(object, format));
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
    static public java.util.Collection<org.openanzo.rdf.Statement> deserialize(IMessage message, String propertyName, String format) throws AnzoException {
        String property = message.getProperty(propertyName);
        return deserialize(property, format);
    }
}
