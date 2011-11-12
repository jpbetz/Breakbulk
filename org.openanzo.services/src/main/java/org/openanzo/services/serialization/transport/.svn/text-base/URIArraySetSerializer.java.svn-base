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

import java.util.HashSet;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.URI;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class URIArraySetSerializer {
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
    static private org.openanzo.rdf.URI[] deserialize(String serialized, String format) throws AnzoException {
        if (serialized == null || serialized.length() == 0)
            return null;
        return org.openanzo.rdf.utils.SerializationUtils.convertStringToSet(serialized, format).toArray(new org.openanzo.rdf.URI[0]);
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
    static private String serialize(org.openanzo.rdf.URI[] object, String format) throws AnzoException {
        return org.openanzo.rdf.utils.SerializationUtils.convertToList(object, format);
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
    static public void serialize(org.openanzo.rdf.URI[] object, String propertyName, String format, IMessage message) throws AnzoException {
        if (message.getUseMultiValueProperties()) {
            for (URI obj : object) {
                message.setProperty(propertyName, obj.toString());
            }
        } else {
            message.setProperty(propertyName, serialize(object, format));
        }
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
    static public org.openanzo.rdf.URI[] deserialize(IMessage message, String propertyName, String format) throws AnzoException {
        if (message.getUseMultiValueProperties()) {

            String[] properties = message.getProperties(propertyName);
            HashSet<org.openanzo.rdf.URI> result = new HashSet<org.openanzo.rdf.URI>();
            for (String property : properties) {
                result.add(Constants.valueFactory.createURI(property));
            }
            return result.toArray(new org.openanzo.rdf.URI[0]);
        } else {
            String property = message.getProperty(propertyName);
            return deserialize(property, format);
        }
    }
}
