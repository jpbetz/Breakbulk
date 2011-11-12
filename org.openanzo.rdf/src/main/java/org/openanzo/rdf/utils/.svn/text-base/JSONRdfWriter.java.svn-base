/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 9, 2007
 * Revision:	$Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.rdf.utils;

import java.io.IOException;
import java.io.Writer;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.IRDFWriter;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.PlainLiteral;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;

/**
 * RDFHandler that outputs RDF to a JSON stream
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class JSONRdfWriter implements IRDFWriter {
    /** RDFFormat object for JSON objects */
    final private JsonGenerator      jsonWriter;

    static final private JsonFactory factory = new JsonFactory();

    /**
     * Create a new JSONRdfHandler that writes output the writer
     * 
     * @param writer
     *            writer to which data written
     */
    public JSONRdfWriter(Writer writer) {
        try {
            this.jsonWriter = factory.createJsonGenerator(writer);
        } catch (IOException e) {
            throw new AnzoRuntimeException(ExceptionConstants.IO.WRITE_ERROR, e);
        }
    }

    public RDFFormat getRDFFormat() {
        return RDFFormat.JSON;
    }

    public void startRDF() throws AnzoException {
        try {
            jsonWriter.writeStartArray();
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e);
        }
    }

    public void endRDF() throws AnzoException {
        try {
            jsonWriter.writeEndArray();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e);
        }
    }

    public void handleComment(String comment) throws AnzoException {
    }

    public void handleNamespace(String prefix, String uri) throws AnzoException {
    }

    public void handleStatement(Statement statement) throws AnzoException {
        Resource namedGraphUri = statement.getNamedGraphUri();
        Resource subject = statement.getSubject();
        URI predicate = statement.getPredicate();
        Value object = statement.getObject();
        try {
            jsonWriter.writeStartObject();
            if (namedGraphUri != null) {
                jsonWriter.writeStringField(SerializationConstants.namedGraphUri, namedGraphUri.toString());
            }
            jsonWriter.writeFieldName(SerializationConstants.subject);
            //jsonWriter.value(subject.toString());
            writeValue(jsonWriter, subject);
            jsonWriter.writeStringField(SerializationConstants.predicate, predicate.toString());
            jsonWriter.writeFieldName(SerializationConstants.object);
            writeValue(jsonWriter, object);
            jsonWriter.writeEndObject();
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e);
        }
    }

    /**
     * Handle writing a Value to a writer
     * 
     * @param value
     *            value to write
     * @throws AnzoException
     */
    protected void handleValue(Value value) throws AnzoException {
        try {
            writeValue(jsonWriter, value);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e);
        }
    }

    /**
     * Write a statement to json
     * 
     * @param jsonWriter
     *            json writer
     * @param statement
     *            statement to write
     * @throws AnzoException
     */
    static public void writeStatement(JsonGenerator jsonWriter, Statement statement) throws AnzoException {
        writeStatement(jsonWriter, statement.getSubject(), statement.getPredicate(), statement.getObject(), statement.getNamedGraphUri());
    }

    /**
     * Write a statement to json
     * 
     * @param jsonWriter
     *            json writer
     * @param subject
     * @param predicate
     * @param object
     * @param namedGraphUri
     * @throws AnzoException
     */
    static public void writeStatement(JsonGenerator jsonWriter, Resource subject, URI predicate, Value object, URI namedGraphUri) throws AnzoException {
        try {
            jsonWriter.writeStartObject();
            jsonWriter.writeStringField(SerializationConstants.namedGraphUri, namedGraphUri.toString());
            jsonWriter.writeFieldName(SerializationConstants.subject);
            writeValue(jsonWriter, subject);
            jsonWriter.writeStringField(SerializationConstants.predicate, predicate.toString());
            jsonWriter.writeFieldName(SerializationConstants.object);
            writeValue(jsonWriter, object);
            jsonWriter.writeEndObject();
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    /**
     * Write a {@link Value} to the provided {@link JsonGenerator}
     * 
     * @param value
     * @param jsonWriter
     * @throws IOException
     */
    private static void writeValue(JsonGenerator jsonWriter, Value value) throws IOException {
        jsonWriter.writeStartObject();
        if (value instanceof URI) {
            jsonWriter.writeStringField(SerializationConstants.objectType, SerializationConstants.uri);
            jsonWriter.writeStringField(SerializationConstants.value, value.toString());
        } else if (value instanceof BlankNode) {
            jsonWriter.writeStringField(SerializationConstants.objectType, SerializationConstants.bnode);
            String nodeLabel = (((BlankNode) value).getLabel());
            if (nodeLabel == null) {
                throw new AnzoRuntimeException(ExceptionConstants.IO.NODE_LABEL_ERROR, value.toString());
            }
            jsonWriter.writeStringField(SerializationConstants.value, nodeLabel);

        } else if (value instanceof Literal) {
            Literal lit = (Literal) value;
            jsonWriter.writeStringField(SerializationConstants.objectType, SerializationConstants.literal);
            jsonWriter.writeStringField(SerializationConstants.value, lit.getLabel());

            if (lit instanceof TypedLiteral) {
                URI dt = ((TypedLiteral) lit).getDatatypeURI();
                jsonWriter.writeStringField(SerializationConstants.dataType, dt.toString());
            } else if (lit instanceof PlainLiteral) {
                String lang = ((PlainLiteral) lit).getLanguage();
                if (lang != null) {
                    jsonWriter.writeStringField(SerializationConstants.language, lang);
                }
            }
        } else {

        }
        jsonWriter.writeEndObject();
    }

}
