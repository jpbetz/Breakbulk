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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;

import org.openanzo.exceptions.AnzoException;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class URISetArraySerializer {
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
    @SuppressWarnings("unchecked")
    static public java.util.Set<org.openanzo.rdf.URI>[] deserialize(String serialized, String format) throws AnzoException {
        if (serialized == null || serialized.length() == 0)
            return new java.util.Set[] { Collections.<org.openanzo.rdf.URI> emptySet(), Collections.<org.openanzo.rdf.URI> emptySet() };
        ArrayList<java.util.Set<org.openanzo.rdf.URI>> sets = new ArrayList<java.util.Set<org.openanzo.rdf.URI>>();
        BufferedReader br = new BufferedReader(new StringReader(serialized));
        try {
            String line = br.readLine();
            while (line != null) {
                sets.add(org.openanzo.rdf.utils.SerializationUtils.convertStringToSet(serialized, format));
                line = br.readLine();
            }
        } catch (IOException ioe) {

        }
        return sets.toArray(new java.util.Set[0]);
    }

    /**
     * Serialize the given object to a String
     * 
     * @param objects
     *            Objects to serialize
     * @param format
     *            If not null, the format of the serialized String
     * @return Serialized version of object
     * @throws AnzoException
     *             if there was a problem serializing the object
     */
    static public String serialize(java.util.Set<org.openanzo.rdf.URI>[] objects, String format) throws AnzoException {
        StringBuilder sb = new StringBuilder();
        for (java.util.Set<org.openanzo.rdf.URI> object : objects) {
            sb.append(org.openanzo.rdf.utils.SerializationUtils.convertToList(object, format));
            sb.append("\n");
        }
        return sb.toString();
    }

}
