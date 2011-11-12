/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/serialization/BocaJSONNodeWriter.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  5/1/2006
 * Revision:	$Id: JSONNodeWriter.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.services.serialization;

import java.io.IOException;
import java.io.Writer;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.utils.JSONRdfWriter;
import org.openanzo.rdf.utils.SerializationConstants;

/**
 * Provides JSON serialization of transport messages.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class JSONReplicationWriter implements IReplicationHandler {
    private final static JsonFactory factory = new JsonFactory();

    /** Stream to which output is written */
    private final JsonGenerator      jsonWriter;

    private Boolean                  lastMetadata;

    private Boolean                  lastAddition;

    private URI                      lastNamedGraphUri;

    /**
     * New JSONNodeWriter that writes to out
     * 
     * @param out
     *            Stream to which output is written
     */
    public JSONReplicationWriter(Writer out) {
        try {
            this.jsonWriter = factory.createJsonGenerator(out);
        } catch (IOException e) {
            throw new AnzoRuntimeException(ExceptionConstants.IO.WRITE_ERROR, e, e.getMessage());
        }
    }

    public void start(int totalSize) throws AnzoException {
        try {
            jsonWriter.writeStartArray();
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    public void end() throws AnzoException {
        try {
            if (lastNamedGraphUri != null) {
                endStatementSet();
                jsonWriter.writeEndObject();
                lastNamedGraphUri = null;
            }
            jsonWriter.writeEndArray();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    public boolean handleNamedGraph(URI namedGraphUri, URI uuid, long revision) throws AnzoException {
        try {
            if (lastNamedGraphUri != null) {
                endStatementSet();
                jsonWriter.writeEndObject();
            }
            jsonWriter.writeStartObject();
            jsonWriter.writeStringField(SerializationConstants.namedGraphUri, namedGraphUri.toString());
            if (uuid != null)
                jsonWriter.writeStringField(SerializationConstants.namedGraphUUID, uuid.toString());
            jsonWriter.writeStringField(SerializationConstants.revision, Long.toString(revision));
            lastNamedGraphUri = namedGraphUri;
            return true;
        } catch (IOException ioe) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, ioe.getMessage());
        }
    }

    private void startStatementSet(boolean metadata, boolean addition) throws AnzoException {
        try {
            lastMetadata = metadata;
            lastAddition = addition;
            if (lastMetadata && lastAddition) {
                jsonWriter.writeFieldName(SerializationConstants.metaAdditions);
            } else if (lastMetadata) {
                jsonWriter.writeFieldName(SerializationConstants.metaRemovals);
            } else if (!lastMetadata && lastAddition) {
                jsonWriter.writeFieldName(SerializationConstants.additions);
            } else {
                jsonWriter.writeFieldName(SerializationConstants.removals);
            }
            jsonWriter.writeStartArray();
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    private void endStatementSet() throws AnzoException {
        try {
            if (lastMetadata != null && lastAddition != null) {
                jsonWriter.writeEndArray();
                lastMetadata = null;
                lastAddition = null;
            }
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    public boolean handleStatement(boolean metadata, boolean addition, Resource subject, URI predicate, Value object, URI namedGraphURI) throws AnzoException {
        if (lastMetadata != null && lastAddition != null && (lastMetadata.booleanValue() != metadata || lastAddition.booleanValue() != addition)) {
            endStatementSet();
            startStatementSet(metadata, addition);
        } else if (lastMetadata == null || lastAddition == null) {
            startStatementSet(metadata, addition);
        }
        JSONRdfWriter.writeStatement(jsonWriter, subject, predicate, object, namedGraphURI);
        return true;
    }
}
