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
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.PlainLiteral;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.services.serialization.CommonSerializationUtils.NodeType;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class ValueSerializer {
    /**
     * Deserialize from a String to type T
     * 
     * @param message
     *            Message containing
     * @param propertyName
     *            Name of property within message
     * 
     * @param format
     *            Format of the String
     * @return T deserialized object
     * @throws AnzoException
     *             if there was a problem deserializing the object
     */
    static public Value deserialize(IMessage message, String propertyName, String format) throws AnzoException {
        Value object = null;
        if (message.hasProperty(SerializationConstants.object) && message.hasProperty(SerializationConstants.objectType)) {
            String objectValue = message.getProperty(SerializationConstants.object);
            String objectType = message.getProperty(SerializationConstants.objectType);
            NodeType nodeType = null;
            if (objectType.equals(SerializationConstants.literal)) {
                nodeType = NodeType.LITERAL;
            } else if (objectType.equals(SerializationConstants.bnode)) {
                nodeType = NodeType.BNODE;
            } else if (objectType.equals(SerializationConstants.uri)) {
                nodeType = NodeType.URI;
            } else {
                nodeType = NodeType.valueOf(objectType);
            }
            if (nodeType != null) {
                switch (nodeType) {
                case URI:
                    object = Constants.valueFactory.createURI(objectValue);
                    break;
                case BNODE:
                    object = Constants.valueFactory.createBNode(objectValue);
                    break;
                case LITERAL: {
                    String dataType = message.getProperty(SerializationConstants.dataType);
                    String lang = message.getProperty(SerializationConstants.language);
                    if (dataType != null) {
                        URI datatype = Constants.valueFactory.createURI(dataType);
                        object = Constants.valueFactory.createLiteral(objectValue, datatype);
                    } else if (lang != null) {
                        object = Constants.valueFactory.createLiteral(objectValue, lang);
                    } else {
                        object = Constants.valueFactory.createLiteral(objectValue);
                    }
                }
                    break;
                case ANY:
                    object = Constants.ANY_URI;
                    break;
                }
            }
        }
        return object;
    }

    /**
     * Serialize the given object to a String
     * 
     * @param value
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
    static public void serialize(Value value, String propertyName, String format, IMessage message) throws AnzoException {
        if (value instanceof Literal) {
            Literal literal = (Literal) value;
            String objectString = literal.getLabel();

            message.setProperty(SerializationConstants.objectType, NodeType.LITERAL.name());
            if (literal instanceof TypedLiteral) {
                URI dt = ((TypedLiteral) literal).getDatatypeURI();
                message.setProperty(SerializationConstants.dataType, dt.toString());
            } else if (literal instanceof PlainLiteral) {
                message.setProperty(SerializationConstants.language, ((PlainLiteral) literal).getLanguage());
            }
            message.setProperty(SerializationConstants.object, objectString);
        } else if (value instanceof URI) {
            message.setProperty(SerializationConstants.objectType, NodeType.URI.name());
            message.setProperty(SerializationConstants.object, value.toString());
        } else if (value instanceof BlankNode) {
            message.setProperty(SerializationConstants.objectType, NodeType.BNODE.name());
            message.setProperty(SerializationConstants.object, ((BlankNode) value).getLabel());
        }
    }

}
