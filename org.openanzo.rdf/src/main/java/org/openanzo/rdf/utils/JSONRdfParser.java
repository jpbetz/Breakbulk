/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 12, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.rdf.utils;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IRDFHandler;
import org.openanzo.rdf.IRDFParser;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;

/**
 * Parse JSON RDF input stream
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * 
 */
public class JSONRdfParser implements IRDFParser {
    private final static JsonFactory factory = new JsonFactory();

    private final IRDFHandler        rdfHandler;

    /**
     * Create a new JSON RDF parser
     * 
     * @param rdfHandler
     *            Handler for this parser
     */
    public JSONRdfParser(IRDFHandler rdfHandler) {
        this.rdfHandler = rdfHandler;
    }

    public RDFFormat getRDFFormat() {
        return RDFFormat.JSON;
    }

    public void parse(Reader inputStream, String baseURI) throws IOException, AnzoException {
        parse(inputStream, baseURI, rdfHandler);
    }

    /**
     * Parser data from a reader to a handler
     * 
     * @param reader
     *            source of data
     * @param baseURI
     *            base uri for data
     * @param rdfHandler
     *            handler for data
     * @throws IOException
     * @throws AnzoException
     */
    static private void parse(Reader reader, String baseURI, IRDFHandler rdfHandler) throws IOException, AnzoException {
        try {
            rdfHandler.startRDF();
            JsonParser parser = factory.createJsonParser(reader);
            while (parser.nextToken() != null) {
                JsonToken token = parser.getCurrentToken();
                switch (token) {
                case START_ARRAY:
                    break;
                case START_OBJECT:
                    rdfHandler.handleStatement(parseStatement(parser));
                    break;
                }
            }
            rdfHandler.endRDF();
        } catch (JsonParseException e) {
            throw new AnzoException(ExceptionConstants.IO.DESERIALIZATION_ERROR, e);
        }
    }

    /**
     * Parse a statement object from json
     * 
     * @param parser
     * @return Parsed statement
     * @throws JsonParseException
     * @throws AnzoException
     */
    @SuppressWarnings("unchecked")
    static public Statement parseStatement(JsonParser parser) throws JsonParseException, AnzoException {
        try {
            Map<String, Object> statement = new HashMap<String, Object>();
            String currentName = null;
            String objectName = null;
            Map<String, Object> currentObject = null;
            boolean done = false;
            while (!done && parser.nextToken() != null) {
                JsonToken token = parser.getCurrentToken();
                switch (token) {
                case START_OBJECT:
                    currentObject = new HashMap<String, Object>();
                    objectName = currentName;
                    break;
                case END_OBJECT:
                    if (currentObject != null) {
                        statement.put(objectName, currentObject);
                        objectName = null;
                        currentObject = null;
                    } else {
                        done = true;
                    }
                    break;
                case END_ARRAY:
                    done = true;
                    break;
                case FIELD_NAME:
                    currentName = parser.getText();
                    break;
                case VALUE_FALSE:
                    if (currentObject != null) {
                        currentObject.put(parser.getCurrentName(), false);
                    } else {
                        statement.put(parser.getCurrentName(), false);
                    }
                    break;
                case VALUE_TRUE:
                    if (currentObject != null) {
                        currentObject.put(parser.getCurrentName(), true);
                    } else {
                        statement.put(parser.getCurrentName(), true);
                    }
                    break;
                case VALUE_NULL:
                    break;
                case VALUE_NUMBER_FLOAT:
                    if (currentObject != null) {
                        currentObject.put(parser.getCurrentName(), parser.getNumberValue());
                    } else {
                        statement.put(parser.getCurrentName(), parser.getNumberValue());
                    }
                    break;
                case VALUE_NUMBER_INT:
                    if (currentObject != null) {
                        currentObject.put(parser.getCurrentName(), parser.getNumberValue());
                    } else {
                        statement.put(parser.getCurrentName(), parser.getNumberValue());
                    }
                    break;
                case VALUE_STRING:
                    if (currentObject != null) {
                        currentObject.put(parser.getCurrentName(), parser.getText());
                    } else {
                        statement.put(parser.getCurrentName(), parser.getText());
                    }
                    break;
                }
            }
            String namedGraph = (statement.containsKey(SerializationConstants.namedGraphUri)) ? (String) statement.get(SerializationConstants.namedGraphUri) : null;
            Map<String, Object> subject = (statement.containsKey(SerializationConstants.subject)) ? (Map<String, Object>) statement.get(SerializationConstants.subject) : null;
            String predicate = (statement.containsKey(SerializationConstants.predicate)) ? (String) statement.get(SerializationConstants.predicate) : null;
            Map<String, Object> object = (statement.containsKey(SerializationConstants.object)) ? (Map<String, Object>) statement.get(SerializationConstants.object) : null;
            if (subject != null && predicate != null && object != null) {
                URI namedGraphURI = (namedGraph != null) ? Constants.valueFactory.createURI(namedGraph) : null;

                String subjectType = subject.containsKey(SerializationConstants.objectType) ? (String) subject.get(SerializationConstants.objectType) : null;
                String subjectValue = subject.containsKey(SerializationConstants.value) ? (String) subject.get(SerializationConstants.value) : null;
                if (subjectType == null || subjectValue == null) {
                    throw new AnzoException(ExceptionConstants.IO.DESERIALIZATION_ERROR);
                }
                Resource subjectResource = null;
                if (SerializationConstants.uri.equals(subjectType)) {
                    subjectResource = Constants.valueFactory.createURI(subjectValue);
                } else {
                    subjectResource = Constants.valueFactory.createBNode(subjectValue);
                }
                URI predicateURI = Constants.valueFactory.createURI(predicate);

                String type = object.containsKey(SerializationConstants.objectType) ? (String) object.get(SerializationConstants.objectType) : null;
                String value = object.containsKey(SerializationConstants.value) ? (String) object.get(SerializationConstants.value) : null;
                if (type == null || value == null) {
                    throw new AnzoException(ExceptionConstants.IO.DESERIALIZATION_ERROR);
                }
                if (SerializationConstants.uri.equals(type)) {
                    Statement stmt = Constants.valueFactory.createStatement(subjectResource, predicateURI, Constants.valueFactory.createURI(value), namedGraphURI);
                    return stmt;
                } else if (SerializationConstants.literal.equals(type)) {
                    String lang = object.containsKey(SerializationConstants.language) ? (String) object.get(SerializationConstants.language) : null;
                    String datatype = object.containsKey(SerializationConstants.dataType) ? (String) object.get(SerializationConstants.dataType) : null;
                    Literal literal = null;
                    if (datatype != null) {
                        literal = Constants.valueFactory.createLiteral(value, Constants.valueFactory.createURI(datatype));
                    } else if (lang != null) {
                        literal = Constants.valueFactory.createLiteral(value, lang);
                    } else {
                        literal = Constants.valueFactory.createLiteral(value);
                    }
                    Statement stmt = Constants.valueFactory.createStatement(subjectResource, predicateURI, literal, namedGraphURI);
                    return stmt;
                } else if (SerializationConstants.bnode.equals(type)) {
                    Statement stmt = Constants.valueFactory.createStatement(subjectResource, predicateURI, Constants.valueFactory.createBNode(value), namedGraphURI);
                    return stmt;
                }
            }
        } catch (IOException ioe) {
            throw new AnzoException(ExceptionConstants.IO.DESERIALIZATION_ERROR);
        }
        throw new AnzoException(ExceptionConstants.IO.DESERIALIZATION_ERROR);
    }
}
