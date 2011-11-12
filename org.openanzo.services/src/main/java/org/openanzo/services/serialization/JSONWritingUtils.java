/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Mar 3, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services.serialization;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.JSONRdfWriter;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.INamedGraphUpdate;
import org.openanzo.services.IPrecondition;
import org.openanzo.services.IUpdateTransaction;
import org.openanzo.services.impl.AskResult;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class JSONWritingUtils {
    private final static JsonFactory factory = new JsonFactory();

    static protected void writeTransaction(JsonGenerator JsonGenerator, boolean includeContents, IUpdateTransaction transaction) throws AnzoException {
        try {
            JsonGenerator.writeStartObject();
            if (transaction.getURI() != null)
                JsonGenerator.writeStringField(SerializationConstants.transactionURI, transaction.getURI().toString());
            if (transaction.getUpdatedNamedGraphRevisions() != null && transaction.getUpdatedNamedGraphRevisions().size() > 0)
                JsonGenerator.writeStringField(SerializationConstants.namedGraphUpdates, CommonSerializationUtils.writeNamedGraphRevisions(transaction.getUpdatedNamedGraphRevisions()));
            if (transaction.getTransactionContext() != null) {
                JsonGenerator.writeFieldName(SerializationConstants.transactionContext);
                JsonGenerator.writeStartArray();
                for (Statement statement : transaction.getTransactionContext()) {
                    JSONRdfWriter.writeStatement(JsonGenerator, statement);
                }
                JsonGenerator.writeEndArray();
            }
            if (transaction.getErrors() != null && transaction.getErrors().size() > 0) {
                JsonGenerator.writeFieldName(SerializationConstants.errorResult);
                JsonGenerator.writeStartArray();
                for (AnzoException exception : transaction.getErrors()) {
                    writeError(JsonGenerator, exception.getErrorCode(), exception.getMessage(false), exception.getArgs());
                }
                JsonGenerator.writeEndArray();
            } else {
                if (includeContents) {
                    writePreconditions(JsonGenerator, transaction.getPreconditions());
                    writeNamedGraphUpdates(JsonGenerator, transaction.getNamedGraphUpdates());
                }
            }
            JsonGenerator.writeEndObject();
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    static private void writeNamedGraphUpdates(JsonGenerator JsonGenerator, Collection<INamedGraphUpdate> namedGraphUpdates) throws AnzoException {
        try {
            JsonGenerator.writeFieldName(SerializationConstants.namedGraphs);
            JsonGenerator.writeStartArray();
            for (INamedGraphUpdate update : namedGraphUpdates) {
                writeNamedGraphUpdate(JsonGenerator, update);
            }
            JsonGenerator.writeEndArray();
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    static protected void writeNamedGraphUpdate(JsonGenerator JsonGenerator, INamedGraphUpdate namedGraphUpdates) throws AnzoException {
        writeNamedGraphUpdate(JsonGenerator, namedGraphUpdates.getNamedGraphURI(), namedGraphUpdates.getUUID(), namedGraphUpdates.getRevision(), namedGraphUpdates.getAdditions(), namedGraphUpdates.getRemovals(), namedGraphUpdates.getMetaAdditions(), namedGraphUpdates.getMetaRemovals());
    }

    static private void writeNamedGraphUpdate(JsonGenerator JsonGenerator, URI namedGraphURI, URI uuid, long revision, Collection<Statement> additions, Collection<Statement> removals, Collection<Statement> metaAdditions, Collection<Statement> metaRemovals) throws AnzoException {
        try {
            JsonGenerator.writeStartObject();
            JsonGenerator.writeStringField(SerializationConstants.namedGraphUri, namedGraphURI.toString());
            if (uuid != null)
                JsonGenerator.writeStringField(SerializationConstants.namedGraphUUID, uuid.toString());
            JsonGenerator.writeStringField(SerializationConstants.revision, Long.toString(revision));
            JsonGenerator.writeFieldName(SerializationConstants.removals);
            JsonGenerator.writeStartArray();
            for (Statement stmt : removals) {
                JSONRdfWriter.writeStatement(JsonGenerator, stmt);
            }
            JsonGenerator.writeEndArray();
            JsonGenerator.writeFieldName(SerializationConstants.metaRemovals);
            JsonGenerator.writeStartArray();
            for (Statement stmt : metaRemovals) {
                JSONRdfWriter.writeStatement(JsonGenerator, stmt);
            }
            JsonGenerator.writeEndArray();
            JsonGenerator.writeFieldName(SerializationConstants.additions);
            JsonGenerator.writeStartArray();
            for (Statement stmt : additions) {
                JSONRdfWriter.writeStatement(JsonGenerator, stmt);
            }
            JsonGenerator.writeEndArray();
            JsonGenerator.writeFieldName(SerializationConstants.metaAdditions);
            JsonGenerator.writeStartArray();
            for (Statement stmt : metaAdditions) {
                JSONRdfWriter.writeStatement(JsonGenerator, stmt);
            }
            JsonGenerator.writeEndArray();
            JsonGenerator.writeEndObject();
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    static private void writeError(JsonGenerator JsonGenerator, long errorCode, String message, String... errorMessageArgs) throws AnzoException {
        try {
            JsonGenerator.writeStartObject();
            JsonGenerator.writeStringField(SerializationConstants.errorTags, "0");
            JsonGenerator.writeStringField(SerializationConstants.errorCode, errorCode + "");
            if (message != null) {
                JsonGenerator.writeStringField(SerializationConstants.errorMessage, message);
            }
            JsonGenerator.writeFieldName(SerializationConstants.errorMessageArg);
            JsonGenerator.writeStartArray();
            for (String arg : errorMessageArgs) {
                JsonGenerator.writeString(arg);
            }
            JsonGenerator.writeEndArray();
            JsonGenerator.writeEndObject();
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    /**
     * Write a set of IPreconditions to a JsonGenerator
     * 
     * @param preconditions
     *            to serialize
     * @param writer
     *            JSON writer to which precoditions are written
     * @throws AnzoException
     */
    static private void writePreconditions(JsonGenerator JsonGenerator, Collection<IPrecondition> preconditions) throws AnzoException {
        if (preconditions != null) {
            try {
                JsonGenerator.writeFieldName(SerializationConstants.preconditions);
                JsonGenerator.writeStartArray();
                for (IPrecondition precondition : preconditions) {
                    JsonGenerator.writeStartObject();
                    if (precondition.getDefaultGraphUris() != null) {
                        JsonGenerator.writeFieldName(SerializationConstants.defaultGraphs);
                        JsonGenerator.writeStartArray();
                        for (URI uri : precondition.getDefaultGraphUris()) {
                            JsonGenerator.writeString(uri.toString());
                        }
                        JsonGenerator.writeEndArray();
                    }
                    if (precondition.getNamedGraphUris() != null) {
                        JsonGenerator.writeFieldName(SerializationConstants.namedGraphs);
                        JsonGenerator.writeStartArray();
                        for (URI uri : precondition.getNamedGraphUris()) {
                            JsonGenerator.writeString(uri.toString());
                        }
                        JsonGenerator.writeEndArray();
                    }

                    JsonGenerator.writeFieldName(SerializationConstants.query);
                    JsonGenerator.writeStartObject();
                    JsonGenerator.writeStringField(SerializationConstants.queryString, precondition.getQuery());
                    JsonGenerator.writeBooleanField(SerializationConstants.askQueryResult, ((AskResult) precondition.getResult()).getResultValue());
                    JsonGenerator.writeEndObject();
                    JsonGenerator.writeEndObject();
                }
                JsonGenerator.writeEndArray();
            } catch (IOException e) {
                throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e);
            }
        }
    }

    static protected void writeAnzoPrincipal(Writer out, AnzoPrincipal principal) throws AnzoException {
        try {
            JsonGenerator jsonWriter = factory.createJsonGenerator(out);
            writeAnzoPrincipal(jsonWriter, principal);
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException ioe) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, ioe, ioe.getMessage());
        }
    }

    static private void writeAnzoPrincipal(JsonGenerator JsonGenerator, AnzoPrincipal principal) throws AnzoException {
        try {
            JsonGenerator.writeStartObject();
            JsonGenerator.writeStringField(SerializationConstants.user, principal.getName());
            JsonGenerator.writeStringField(SerializationConstants.userUri, principal.getUserURI().toString());
            JsonGenerator.writeStringField(SerializationConstants.isSysAdmin, Boolean.toString(principal.isSysadmin()));
            JsonGenerator.writeObjectFieldStart(SerializationConstants.role);
            JsonGenerator.writeStartArray();
            for (URI role : principal.getRoles()) {
                JsonGenerator.writeString(role.toString());
            }
            JsonGenerator.writeEndArray();
            JsonGenerator.writeEndObject();
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e, e.getMessage());
        }
    }
}
