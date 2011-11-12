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

import org.openanzo.exceptions.AnzoException;
import org.openanzo.glitter.dataset.DefaultQueryDataset;
import org.openanzo.glitter.dataset.QueryDataset;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class QueryUriSetSerializer {
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
    static public QueryDataset deserialize(String serialized, String format) throws AnzoException {
        DefaultQueryDataset queryUriSet = new DefaultQueryDataset();
        if (serialized == null || serialized.length() == 0)
            return queryUriSet;
        BufferedReader br = new BufferedReader(new StringReader(serialized));
        try {
            String line = br.readLine();
            int i = 0;
            while (line != null) {
                switch (i++) {
                case 0:
                    queryUriSet.setDefaultGraphs(org.openanzo.rdf.utils.SerializationUtils.convertStringToSet(serialized, format));
                    break;
                case 1:
                    queryUriSet.setNamedGraphs(org.openanzo.rdf.utils.SerializationUtils.convertStringToSet(serialized, format));
                    break;
                case 2:
                    queryUriSet.allGraphs = Boolean.parseBoolean(line);
                    break;
                case 3:
                    queryUriSet.allNamedGraphs = Boolean.parseBoolean(line);
                    break;
                case 4:
                    queryUriSet.allMetadataGraphs = Boolean.parseBoolean(line);
                    break;
                case 5:
                    queryUriSet.defaultAllGraphs = Boolean.parseBoolean(line);
                    break;
                case 6:
                    queryUriSet.defaultAllNamedGraphs = Boolean.parseBoolean(line);
                    break;
                case 7:
                    queryUriSet.defaultAllMetadataGraphs = Boolean.parseBoolean(line);
                    break;
                case 8:
                    queryUriSet.fullyExpandedDatasets = Boolean.parseBoolean(line);
                    break;
                case 9:
                    queryUriSet.datasetFullyResolved = Boolean.parseBoolean(line);
                    break;

                }
            }

        } catch (IOException ioe) {

        }
        return queryUriSet;
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
    static public String serialize(QueryDataset querySet, String format) throws AnzoException {
        StringBuilder sb = new StringBuilder();
        sb.append(org.openanzo.rdf.utils.SerializationUtils.convertToList(querySet.getDefaultGraphURIs(), format));
        sb.append("\n");
        sb.append(org.openanzo.rdf.utils.SerializationUtils.convertToList(querySet.getNamedGraphURIs(), format));
        sb.append("\n");
        sb.append(Boolean.toString(querySet.allGraphs));
        sb.append("\n");
        sb.append(Boolean.toString(querySet.allNamedGraphs));
        sb.append("\n");
        sb.append(Boolean.toString(querySet.allMetadataGraphs));
        sb.append("\n");
        sb.append(Boolean.toString(querySet.defaultAllGraphs));
        sb.append("\n");
        sb.append(Boolean.toString(querySet.defaultAllNamedGraphs));
        sb.append("\n");
        sb.append(Boolean.toString(querySet.defaultAllMetadataGraphs));
        sb.append("\n");
        sb.append(Boolean.toString(querySet.fullyExpandedDatasets));
        sb.append("\n");
        sb.append(Boolean.toString(querySet.datasetFullyResolved));
        sb.append("\n");
        return sb.toString();
    }

}
