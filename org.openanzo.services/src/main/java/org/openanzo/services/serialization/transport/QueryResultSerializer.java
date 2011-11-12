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
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.glitter.query.QueryType;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class QueryResultSerializer {
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
    static public QueryResults deserialize(String serialized, String format) throws AnzoException {
        if (serialized == null || serialized.length() == 0)
            return null;
        return org.openanzo.services.serialization.CommonSerializationUtils.readQueryResult(serialized, format);
    }

    /**
     * Deserialize from a String to type T
     * 
     * @param queryType
     *            queryType
     * @param serialized
     *            String representation of object type T
     * @param format
     *            Format of the String
     * @return T deserialized object
     * @throws AnzoException
     *             if there was a problem deserializing the object
     */
    static public QueryResults deserialize(QueryType queryType, String serialized, String format) throws AnzoException {
        if (serialized == null)
            return null;
        return org.openanzo.services.serialization.CommonSerializationUtils.readQueryResult(queryType, serialized, format);
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
     * 
     *             static private String serialize(QueryResults object, String format) throws AnzoException { StringWriter writer = new StringWriter();
     *             org.openanzo.services.serialization.CommonSerializationUtils.writeQueryResults(object, writer, format); return writer.toString(); }
     */

}
