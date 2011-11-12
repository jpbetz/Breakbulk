/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/serialization/BocaXMLNodeWriter.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  5/1/2006
 * Revision:	$Id: XMLNodeWriter.java 178 2007-07-31 14:22:33Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.services.serialization;

import java.io.IOException;
import java.io.Writer;

import org.apache.commons.codec.binary.Base64;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.PlainLiteral;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.services.INamedGraphUpdate;
import org.openanzo.services.IUpdateTransaction;
import org.openanzo.services.serialization.CommonSerializationUtils.NodeType;

/**
 * Provides XML serialization of transport messages.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class XMLWritingUtils {

    protected static void handleTransaction(Writer out, boolean includeContents, IUpdateTransaction transaction) throws AnzoException {
        try {
            writeStartElement(out, SerializationConstants.transaction);
            writeAttribute(out, SerializationConstants.transactionURI, transaction.getURI().toString());
            writeAttribute(out, SerializationConstants.transactionTimestamp, Long.toString(transaction.getTransactionTimestamp()));
            writeCloseElement(out, true);
            if (transaction.getUpdatedNamedGraphRevisions() != null) {
                writeStartElement(out, SerializationConstants.namedGraphUpdates);
                writeCloseElement(out, false);
                writeValue(out, CommonSerializationUtils.writeNamedGraphRevisions(transaction.getUpdatedNamedGraphRevisions()));
                writeEndElement(out, SerializationConstants.namedGraphUpdates);
            }
            if (transaction.getTransactionContext() != null) {
                writeStartElement(out, SerializationConstants.transactionContext);
                writeCloseElement(out, false);
                for (Statement stmt : transaction.getTransactionContext()) {
                    handleStatement(out, stmt);
                }
                writeEndElement(out, SerializationConstants.transactionContext);
            }
            if (transaction.getErrors() != null && transaction.getErrors().size() > 0) {
                for (AnzoException ae : transaction.getErrors()) {
                    handleError(out, ae.getErrorCode(), ae.getArgs());
                }
            }
            if (includeContents) {
                if (transaction.getPreconditions() != null) {
                    handlePreconditionsStart(out);
                    for (Statement stmt : CommonSerializationUtils.serializePreconditions(transaction.getPreconditions())) {
                        handleStatement(out, stmt);
                    }
                    handlePreconditionsEnd(out);
                }
                for (INamedGraphUpdate update : transaction.getNamedGraphUpdates()) {
                    handleNamedGraphUpdate(out, update);
                }
            }
            writeEndElement(out, SerializationConstants.transaction);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    static protected void handleNamedGraphUpdate(Writer out, INamedGraphUpdate update) throws AnzoException {
        try {
            handleNamedGraphStart(out, update.getNamedGraphURI(), update.getUUID(), update.getRevision());
            writeStartElement(out, SerializationConstants.additions);
            writeCloseElement(out, true);
            for (Statement stmt : update.getAdditions()) {
                handleStatement(out, stmt);
            }
            writeEndElement(out, SerializationConstants.additions);

            writeStartElement(out, SerializationConstants.metaAdditions);
            writeCloseElement(out, true);
            for (Statement stmt : update.getMetaAdditions()) {
                handleStatement(out, stmt);
            }
            writeEndElement(out, SerializationConstants.metaAdditions);

            writeStartElement(out, SerializationConstants.removals);
            writeCloseElement(out, true);
            for (Statement stmt : update.getRemovals()) {
                handleStatement(out, stmt);
            }
            writeEndElement(out, SerializationConstants.removals);

            writeStartElement(out, SerializationConstants.metaRemovals);
            writeCloseElement(out, true);
            for (Statement stmt : update.getMetaRemovals()) {
                handleStatement(out, stmt);
            }
            writeEndElement(out, SerializationConstants.metaRemovals);
            handleNamedGraphEnd(out);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    static protected void start(Writer out) throws AnzoException {
        try {
            writeStartElement(out, SerializationConstants.payload);
            writeCloseElement(out, true);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    static protected void end(Writer out) throws AnzoException {
        try {
            writeEndElement(out, SerializationConstants.payload);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    static private void handlePreconditionsStart(Writer out) throws AnzoException {
        try {
            writeStartElement(out, SerializationConstants.preconditions);
            writeCloseElement(out, true);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }

    }

    static private void handlePreconditionsEnd(Writer out) throws AnzoException {
        try {
            writeEndElement(out, SerializationConstants.preconditions);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }

    }

    static protected void handleNamedGraphStart(Writer out, URI namedGraphUri, URI uuid, long revision) throws AnzoException {
        try {
            writeStartElement(out, SerializationConstants.namedGraph);
            writeAttribute(out, SerializationConstants.revision, Long.toString(revision));
            writeAttribute(out, SerializationConstants.namedGraphUri, namedGraphUri.toString());
            if (uuid != null)
                writeAttribute(out, SerializationConstants.namedGraphUUID, uuid.toString());
            writeCloseElement(out, true);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }

    }

    static protected void handleNamedGraphEnd(Writer out) throws AnzoException {
        try {
            writeEndElement(out, SerializationConstants.namedGraph);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }

    }

    static private void handleStatement(Writer out, Statement statement) throws AnzoException {
        handleStatement(out, statement.getSubject(), statement.getPredicate(), statement.getObject(), statement.getNamedGraphUri());
    }

    /**
     * Write out a statement
     * 
     * @param out
     *            writer for data
     * @param subject
     *            subject of statement
     * @param predicate
     *            predicate of statement
     * @param object
     *            object of statement
     * @param ngURI
     *            namedgraph URI of statement
     * @throws AnzoException
     */
    static public void handleStatement(Writer out, Resource subject, URI predicate, Value object, URI ngURI) throws AnzoException {
        handleStatement(out, subject, predicate, object, ngURI, null, null);
    }

    /**
     * Write out a statement
     * 
     * @param out
     *            writer for data
     * @param subject
     *            subject of statement
     * @param predicate
     *            predicate of statement
     * @param object
     *            object of statement
     * @param ngURI
     *            namedgraph URI of statement
     * @param start
     *            what revision this statement was added
     * @param end
     *            what revision this statement was removed
     * @throws AnzoException
     */
    static public void handleStatement(Writer out, Resource subject, URI predicate, Value object, URI ngURI, Long start, Long end) throws AnzoException {
        try {
            writeStartElement(out, SerializationConstants.statement);
            if (start != null) {
                writeAttribute(out, SerializationConstants.start, start.toString());
            }
            if (end != null) {
                writeAttribute(out, SerializationConstants.end, end.toString());
            }
            writeCloseElement(out, true);
            writeStartElement(out, SerializationConstants.subject);
            if (subject instanceof URI) {
                writeAttribute(out, SerializationConstants.subjectType, NodeType.URI.name());
                writeCloseElement(out, false);
                writeValue(out, subject.toString());
            } else {
                writeAttribute(out, SerializationConstants.subjectType, NodeType.BNODE.name());
                writeCloseElement(out, false);
                writeValue(out, (((BlankNode) subject).getLabel()));
            }
            writeEndElement(out, SerializationConstants.subject);
            writeStartElement(out, SerializationConstants.predicate);
            writeCloseElement(out, false);
            writeValue(out, predicate.toString());
            writeEndElement(out, SerializationConstants.predicate);
            writeStartElement(out, SerializationConstants.object);
            if (object instanceof Literal) {
                writeAttribute(out, SerializationConstants.objectType, NodeType.LITERAL.name());
                Literal literal = (Literal) object;
                if (literal instanceof TypedLiteral) {
                    URI dt = ((TypedLiteral) literal).getDatatypeURI();
                    writeAttribute(out, SerializationConstants.dataType, dt.toString());
                } else if (literal instanceof PlainLiteral) {
                    String lang = ((PlainLiteral) literal).getLanguage();
                    if (lang != null)
                        writeAttribute(out, SerializationConstants.language, lang);
                }
                writeCloseElement(out, false);
                writeEncodedValue(out, literal.getLabel());
            } else if (object instanceof URI) {
                writeAttribute(out, SerializationConstants.objectType, NodeType.URI.name());
                writeCloseElement(out, false);
                writeValue(out, object.toString());
            } else {
                writeAttribute(out, SerializationConstants.objectType, NodeType.BNODE.name());
                writeCloseElement(out, false);
                writeValue(out, (((BlankNode) object).getLabel()));
            }
            writeEndElement(out, SerializationConstants.object);
            if (ngURI != null) {
                writeStartElement(out, SerializationConstants.namedGraphUri);
                writeCloseElement(out, false);
                writeValue(out, ngURI.toString());
                writeEndElement(out, SerializationConstants.namedGraphUri);
            }
            writeEndElement(out, SerializationConstants.statement);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    private static void handleError(Writer out, long errorCode, String... errorMessageArgs) throws AnzoException {
        try {
            writeStartElement(out, SerializationConstants.errorResult);
            writeAttribute(out, SerializationConstants.errorTags, "0");
            writeAttribute(out, SerializationConstants.errorCode, errorCode + "");
            writeCloseElement(out, true);
            for (String arg : errorMessageArgs) {
                writeStartElement(out, SerializationConstants.errorMessageArg);
                writeCloseElement(out, true);
                writeValue(out, arg);
                writeEndElement(out, SerializationConstants.errorMessageArg);
            }
            writeEndElement(out, SerializationConstants.errorResult);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }

    }

    static protected void writeStartElement(Writer out, String elementName) throws IOException {
        out.write("<");
        out.write(elementName);
        out.write(" ");
    }

    static protected void writeCloseElement(Writer out, boolean newLine) throws IOException {
        out.write('>');
        if (newLine) {
            out.write('\n');
        }
    }

    static protected void writeCloseEndElement(Writer out) throws IOException {
        out.write("/>\n");
    }

    static protected void writeEndElement(Writer out, String elementName) throws IOException {
        out.write("</");
        out.write(elementName);
        out.write(">\n");
    }

    static protected void writeAttribute(Writer out, String attributeName, String value) throws IOException {
        out.write(attributeName);
        out.write("=\"");
        out.write(value);
        out.write("\" ");
    }

    static protected void writeValue(Writer out, String value) throws IOException {
        out.write("<![CDATA[");
        out.write(value);
        out.write("]]>");
    }

    static protected void writeEncodedValue(Writer out, String value) throws IOException {
        out.write("<![CDATA[");
        out.write(new String(Base64.encodeBase64(value.getBytes(Constants.byteEncoding)), Constants.byteEncoding));
        out.write("]]>");
    }
}
