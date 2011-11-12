/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 14, 2007
 * Revision:	$Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services.serialization;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.JSONRdfParser;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.services.INamedGraphUpdate;
import org.openanzo.services.IPrecondition;
import org.openanzo.services.impl.Precondition;
import org.openanzo.services.impl.UpdateTransaction;

/**
 * Parse JSON formatted repository update messages
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * 
 */
public class JSONUpdatesReader implements IUpdatesReader {
    private final static JsonFactory factory = new JsonFactory();

    private final String             input;

    /**
     * Create a new updates reader from given input
     * 
     * @param input
     *            input containg update data
     */
    public JSONUpdatesReader(String input) {
        this.input = input;
    }

    public void read(final IUpdatesHandler handler) throws AnzoException {
        JSONUpdatesReader.parseUpdateTransactions(input, handler);
    }

    /**
     * Parse the data within the reader, passing the results to the IRepositoryHandler
     * 
     * @param reader
     *            reader containing the data
     * @return collection of namedgraph updates
     * @throws AnzoException
     */
    public static Collection<INamedGraphUpdate> parseUpdates(Reader reader) throws AnzoException {
        try {
            JsonParser parser = factory.createJsonParser(reader);
            boolean doneInternal = false;
            Collection<INamedGraphUpdate> updates = new ArrayList<INamedGraphUpdate>();
            while (!doneInternal && parser.nextToken() != null) {
                JsonToken objectToken = parser.getCurrentToken();
                switch (objectToken) {
                case START_OBJECT:
                    updates.add(readNamedGraphUpdate(parser));
                    break;
                case END_OBJECT:
                    doneInternal = true;
                    break;
                case END_ARRAY:
                    doneInternal = true;
                    break;
                }
            }
            return updates;
        } catch (JsonParseException ioe) {
            throw new AnzoException(ExceptionConstants.IO.READ_ERROR, ioe, ioe.getMessage());
        } catch (IOException ioe) {
            throw new AnzoException(ExceptionConstants.IO.READ_ERROR, ioe, ioe.getMessage());
        } catch (AnzoException ae) {
            throw ae;
        }
    }

    /**
     * Parse the data within the reader, passing the results to the IRepositoryHandler
     * 
     * @param input
     *            input string containing the data
     * @param handler
     *            Handler which will handle the elements within the data
     * @throws AnzoException
     */
    public static void parseUpdateTransactions(String input, final IUpdatesHandler handler) throws AnzoException {
        try {
            JsonParser parser = factory.createJsonParser(input);
            while (parser.nextToken() != null) {
                JsonToken token = parser.getCurrentToken();
                switch (token) {
                case START_ARRAY:
                    handleTransactionArray(parser, handler);
                    break;
                }
            }
        } catch (JsonParseException ioe) {
            throw new AnzoException(ExceptionConstants.IO.READ_ERROR, ioe, ioe.getMessage());
        } catch (IOException ioe) {
            throw new AnzoException(ExceptionConstants.IO.READ_ERROR, ioe, ioe.getMessage());
        } catch (AnzoException ae) {
            throw ae;
        }
    }

    static Collection<Statement> parseStatements(JsonParser parser) throws AnzoException, IOException, JsonParseException {
        boolean doneInternal = false;
        ArrayList<Statement> stmts = new ArrayList<Statement>();
        while (!doneInternal && parser.nextToken() != null) {
            JsonToken objectToken = parser.getCurrentToken();
            switch (objectToken) {
            case START_OBJECT:
                stmts.add(JSONRdfParser.parseStatement(parser));
                break;
            case END_OBJECT:
                doneInternal = true;
                break;
            case END_ARRAY:
                doneInternal = true;
                break;
            }
        }
        return stmts;
    }

    @SuppressWarnings("unchecked")
    static void handleTransactionObject(JsonParser parser, final IUpdatesHandler handler) throws AnzoException, IOException, JsonParseException {
        Map<String, Object> transaction = new HashMap<String, Object>();
        String objectName = null;

        boolean done = false;
        String currentName = null;
        while (!done && parser.nextToken() != null) {
            JsonToken token = parser.getCurrentToken();
            switch (token) {
            case START_ARRAY:
                objectName = currentName;
                if (objectName.equals(SerializationConstants.transactionContext)) {
                    transaction.put(objectName, parseStatements(parser));
                } else if (objectName.equals(SerializationConstants.errorResult)) {
                    boolean doneInternal = false;
                    ArrayList<AnzoException> anzoExceptions = new ArrayList<AnzoException>();
                    while (!doneInternal && parser.nextToken() != null) {
                        JsonToken objectToken = parser.getCurrentToken();
                        switch (objectToken) {
                        case START_OBJECT:
                            anzoExceptions.add(readError(parser));
                            break;
                        case END_OBJECT:
                            doneInternal = true;
                            break;
                        case END_ARRAY:
                            transaction.put(objectName, anzoExceptions);
                            doneInternal = true;
                            break;
                        }
                    }
                } else if (objectName.equals(SerializationConstants.preconditions)) {
                    boolean doneInternal = false;
                    ArrayList<IPrecondition> preconditions = new ArrayList<IPrecondition>();
                    while (!doneInternal && parser.nextToken() != null) {
                        JsonToken objectToken = parser.getCurrentToken();
                        switch (objectToken) {
                        case START_OBJECT:
                            preconditions.add(readPrecondition(parser));
                            break;
                        case END_OBJECT:
                            doneInternal = true;
                            break;
                        case END_ARRAY:
                            transaction.put(objectName, preconditions);
                            doneInternal = true;
                            break;
                        }
                    }
                } else if (objectName.equals(SerializationConstants.namedGraphs)) {
                    boolean doneInternal = false;
                    Collection<INamedGraphUpdate> updates = new ArrayList<INamedGraphUpdate>();
                    while (!doneInternal && parser.nextToken() != null) {
                        JsonToken objectToken = parser.getCurrentToken();
                        switch (objectToken) {
                        case START_OBJECT:
                            updates.add(readNamedGraphUpdate(parser));
                            break;
                        case END_OBJECT:
                            doneInternal = true;
                            break;
                        case END_ARRAY:
                            transaction.put(objectName, updates);
                            doneInternal = true;
                            break;
                        }
                    }
                }
                break;
            case END_OBJECT:
                done = true;
                break;
            case END_ARRAY:
                break;
            case FIELD_NAME:
                currentName = parser.getText();
                break;
            case VALUE_FALSE:
                transaction.put(parser.getCurrentName(), false);
                break;
            case VALUE_TRUE:
                transaction.put(parser.getCurrentName(), true);
                break;
            case VALUE_NULL:
                break;
            case VALUE_NUMBER_FLOAT:
                transaction.put(parser.getCurrentName(), parser.getNumberValue());
                break;
            case VALUE_NUMBER_INT:
                transaction.put(parser.getCurrentName(), parser.getNumberValue());
                break;
            case VALUE_STRING:
                transaction.put(parser.getCurrentName(), parser.getText());
                break;
            }
        }

        String transactionUri = transaction.containsKey(SerializationConstants.transactionURI) ? (String) transaction.get(SerializationConstants.transactionURI) : null;
        String namedGraphRevisions = transaction.containsKey(SerializationConstants.namedGraphUpdates) ? (String) transaction.get(SerializationConstants.namedGraphUpdates) : null;
        long transactionTimestamp = transaction.containsKey(SerializationConstants.transactionTimestamp) ? ((Number) transaction.get(SerializationConstants.transactionTimestamp)).longValue() : -1;
        URI uri = (transactionUri != null) ? MemURI.create(transactionUri) : null;
        Collection<Statement> contextStatements = null;
        if (transaction.containsKey(SerializationConstants.transactionContext)) {
            contextStatements = (ArrayList<Statement>) transaction.get(SerializationConstants.transactionContext);
        }
        UpdateTransaction updateTransaction = new UpdateTransaction(uri, transactionTimestamp, contextStatements, new HashSet<IPrecondition>(), namedGraphRevisions);
        if (transaction.containsKey(SerializationConstants.errorResult)) {
            List<AnzoException> exceptions = (List<AnzoException>) transaction.get(SerializationConstants.errorResult);
            updateTransaction.getErrors().addAll(exceptions);
        }
        if (transaction.containsKey(SerializationConstants.preconditions)) {
            List<IPrecondition> preconditions = (List<IPrecondition>) transaction.get(SerializationConstants.preconditions);
            updateTransaction.getPreconditions().addAll(preconditions);
        }
        if (transaction.containsKey(SerializationConstants.namedGraphs)) {
            List<INamedGraphUpdate> updates = (List<INamedGraphUpdate>) transaction.get(SerializationConstants.namedGraphs);
            for (INamedGraphUpdate update : updates) {
                updateTransaction.addNamedGraphUpdate(update);
            }
        }
        handler.handleTransaction(updateTransaction);
    }

    static void handleTransactionArray(JsonParser parser, final IUpdatesHandler handler) throws AnzoException, JsonParseException, IOException {
        while (parser.nextToken() != null) {
            JsonToken token = parser.getCurrentToken();
            switch (token) {
            case START_OBJECT:
                handleTransactionObject(parser, handler);
                break;
            case END_ARRAY:
                return;
            }
        }
    }

    @SuppressWarnings("null")
    static AnzoException readError(JsonParser parser) throws AnzoException, IOException, JsonParseException {
        boolean doneInternal = false;
        Map<String, Object> errorObject = new HashMap<String, Object>();
        ArrayList<String> args = null;
        List<String> errorMessageArgs = null;
        String currentName = null;

        while (!doneInternal && parser.nextToken() != null) {
            JsonToken objectToken = parser.getCurrentToken();
            switch (objectToken) {
            case FIELD_NAME:
                currentName = parser.getText();
                break;
            case START_OBJECT:
                break;
            case END_OBJECT:
                doneInternal = true;
                break;
            case START_ARRAY:
                if (currentName.equals(SerializationConstants.errorMessageArg)) {
                    args = new ArrayList<String>();
                }
                break;
            case END_ARRAY:
                if (args != null) {
                    errorMessageArgs = args;
                }
                args = null;
                break;
            case VALUE_NUMBER_FLOAT:
                errorObject.put(parser.getCurrentName(), parser.getNumberValue());
                break;
            case VALUE_NUMBER_INT:
                errorObject.put(parser.getCurrentName(), parser.getNumberValue());
                break;
            case VALUE_STRING:
                if (args != null) {
                    args.add(parser.getText());
                } else {
                    errorObject.put(parser.getCurrentName(), parser.getText());
                }
                break;
            }
        }
        String errorSubNumber = (String) errorObject.get(SerializationConstants.errorCode);
        long errorSubNum = (errorSubNumber != null) ? Long.parseLong(errorSubNumber) : 0;
        if (errorMessageArgs == null)
            errorMessageArgs = Collections.<String> emptyList();
        return new AnzoException(errorSubNum, errorMessageArgs.toArray(new String[0]));

    }

    @SuppressWarnings( { "unchecked", "null" })
    static INamedGraphUpdate readNamedGraphUpdate(JsonParser parser) throws AnzoException, IOException, JsonParseException {
        boolean doneInternal = false;
        Map<String, Object> updateMap = new HashMap<String, Object>();
        String currentName = null;
        while (!doneInternal && parser.nextToken() != null) {
            JsonToken objectToken = parser.getCurrentToken();
            switch (objectToken) {
            case FIELD_NAME:
                currentName = parser.getText();
                break;
            case START_OBJECT:
                break;
            case END_OBJECT:
                doneInternal = true;
                break;
            case START_ARRAY:
                if (currentName.equals(SerializationConstants.metaRemovals) || currentName.equals(SerializationConstants.removals) || currentName.equals(SerializationConstants.metaAdditions) || currentName.equals(SerializationConstants.additions)) {
                    updateMap.put(currentName, parseStatements(parser));
                }
                break;
            case END_ARRAY:
                break;
            case VALUE_NUMBER_FLOAT:
                updateMap.put(parser.getCurrentName(), parser.getNumberValue());
                break;
            case VALUE_NUMBER_INT:
                updateMap.put(parser.getCurrentName(), parser.getNumberValue());
                break;
            case VALUE_STRING:
                updateMap.put(parser.getCurrentName(), parser.getText());
                break;
            }
        }
        String uri = (String) updateMap.get(SerializationConstants.namedGraphUri);
        URI namedGraphURI = Constants.valueFactory.createURI(uri);
        String uuid = (updateMap.containsKey(SerializationConstants.namedGraphUUID)) ? (String) updateMap.get(SerializationConstants.namedGraphUUID) : null;
        URI uuidURI = (uuid != null) ? Constants.valueFactory.createURI(uuid) : null;
        Collection<Statement> removeStatements = (updateMap.containsKey(SerializationConstants.removals)) ? (Collection<Statement>) updateMap.get(SerializationConstants.removals) : null;
        Collection<Statement> metaRemoveStatements = (updateMap.containsKey(SerializationConstants.metaRemovals)) ? (Collection<Statement>) updateMap.get(SerializationConstants.metaRemovals) : null;
        Collection<Statement> additionStatements = (updateMap.containsKey(SerializationConstants.additions)) ? (Collection<Statement>) updateMap.get(SerializationConstants.additions) : null;
        Collection<Statement> metaAdditionStatements = (updateMap.containsKey(SerializationConstants.metaAdditions)) ? (Collection<Statement>) updateMap.get(SerializationConstants.metaAdditions) : null;

        return new NamedGraphUpdate(namedGraphURI, uuidURI, additionStatements, removeStatements, metaAdditionStatements, metaRemoveStatements);

    }

    /**
     * Parse a JSON array into the Preconditions that are encoded within
     * 
     * @param command
     *            JSONObject containing data for preconditions
     * @return set of preconditions contained within statements
     * @throws AnzoException
     */
    @SuppressWarnings( { "unchecked", "null" })
    static IPrecondition readPrecondition(JsonParser parser) throws AnzoException, IOException, JsonParseException {
        boolean doneInternal = false;
        boolean inQuery = false;
        Map<String, Object> preconditionMap = new HashMap<String, Object>();
        Set<URI> currentList = null;
        String currentName = null;
        String objectName = null;
        while (!doneInternal && parser.nextToken() != null) {
            JsonToken objectToken = parser.getCurrentToken();
            switch (objectToken) {
            case FIELD_NAME:
                currentName = parser.getText();
                break;
            case START_OBJECT:
                if (currentName.equals(SerializationConstants.query)) {
                    inQuery = true;
                }
                break;
            case END_OBJECT:
                if (!inQuery) {
                    doneInternal = true;
                } else {
                    inQuery = false;
                }
                break;
            case START_ARRAY:
                if (currentName.equals(SerializationConstants.defaultGraphs) || currentName.equals(SerializationConstants.namedGraphs)) {
                    currentList = new HashSet<URI>();
                    objectName = currentName;
                }
                break;
            case END_ARRAY:
                if (currentList != null) {
                    preconditionMap.put(objectName, currentList);
                }
                objectName = null;
                currentList = null;
                break;
            case VALUE_FALSE:
                preconditionMap.put(parser.getCurrentName(), Boolean.FALSE);
                break;
            case VALUE_TRUE:
                preconditionMap.put(parser.getCurrentName(), Boolean.TRUE);
                break;
            case VALUE_NUMBER_FLOAT:
                preconditionMap.put(parser.getCurrentName(), parser.getNumberValue());
                break;
            case VALUE_NUMBER_INT:
                preconditionMap.put(parser.getCurrentName(), parser.getNumberValue());
                break;
            case VALUE_STRING:
                if (currentList != null) {
                    currentList.add(Constants.valueFactory.createURI(parser.getText()));
                } else {
                    preconditionMap.put(parser.getCurrentName(), parser.getText());
                }
                break;
            }
        }

        IPrecondition precondition = new Precondition();
        if (preconditionMap.containsKey(SerializationConstants.defaultGraphs)) {
            precondition.setDefaultGraphUris((Set<URI>) preconditionMap.get(SerializationConstants.defaultGraphs));
        }
        if (preconditionMap.containsKey(SerializationConstants.namedGraphs)) {
            precondition.setNamedGraphUris((Set<URI>) preconditionMap.get(SerializationConstants.namedGraphs));
        }
        if (preconditionMap.containsKey(SerializationConstants.queryString))
            precondition.setQuery((String) preconditionMap.get(SerializationConstants.queryString));
        if (preconditionMap.containsKey(SerializationConstants.askQueryResult))
            precondition.setResult((Boolean) preconditionMap.get(SerializationConstants.askQueryResult));
        return precondition;

    }
}
