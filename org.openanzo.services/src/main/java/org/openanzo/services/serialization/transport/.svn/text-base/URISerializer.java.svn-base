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

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.URI;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class URISerializer {
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
    static public URI deserialize(String serialized, String format) throws AnzoException {
        if (serialized == null || serialized.length() == 0)
            return null;
        return Constants.valueFactory.createURI(serialized);
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
    static private String serialize(URI object, String format) throws AnzoException {
        return object.toString();
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
    static public void serialize(URI object, String propertyName, String format, IMessage message) throws AnzoException {
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
    static public URI deserialize(IMessage message, String propertyName, String format) throws AnzoException {
        String property = message.getProperty(propertyName);
        return deserialize(property, format);
    }
}
