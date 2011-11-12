/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Feb 14, 2009
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services.serialization;

import java.io.IOException;
import java.io.Writer;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.SerializationConstants;

/**
 * XML writer for backup data
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class XMLGraphBackupWriter {
    /**
     * Start writing backup
     * 
     * @param out
     *            writer for data
     * @throws AnzoException
     */
    static public void writeBackupsStart(Writer out) throws AnzoException {
        try {
            XMLWritingUtils.writeStartElement(out, SerializationConstants.backup);
            XMLWritingUtils.writeCloseElement(out, true);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    /**
     * End writing backup
     * 
     * @param out
     *            writer for data
     * @throws AnzoException
     */
    static public void writeBackupsEnd(Writer out) throws AnzoException {
        try {
            XMLWritingUtils.writeEndElement(out, SerializationConstants.backup);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    /**
     * Start namedgraph element
     * 
     * @param out
     *            writer for data
     * @param namedGraphUri
     *            uri of namedgraph
     * @param metadataURI
     *            metadata uri of namedgraph
     * @param uuid
     *            uuid of namedgraph
     * @param revisioned
     *            true if graph is revisioned
     * @throws AnzoException
     */
    static public void writeNamedGraphBackupStart(Writer out, URI namedGraphUri, URI metadataURI, URI uuid, boolean revisioned) throws AnzoException {
        try {
            XMLWritingUtils.writeStartElement(out, SerializationConstants.namedGraph);
            XMLWritingUtils.writeAttribute(out, SerializationConstants.namedGraphUri, namedGraphUri.toString());
            XMLWritingUtils.writeAttribute(out, SerializationConstants.metadataGraphUri, metadataURI.toString());
            XMLWritingUtils.writeAttribute(out, SerializationConstants.namedGraphUUID, uuid.toString());
            XMLWritingUtils.writeAttribute(out, SerializationConstants.revisioned, Boolean.toString(revisioned));
            XMLWritingUtils.writeCloseElement(out, true);

        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    /**
     * End writing the namedgraph section
     * 
     * @param out
     *            writer for data
     * @throws AnzoException
     */
    static public void writeNamedGraphBackupEnd(Writer out) throws AnzoException {
        try {
            XMLWritingUtils.writeEndElement(out, SerializationConstants.namedGraph);

        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    /**
     * Start the revisions element
     * 
     * @param out
     *            writer for data
     * @throws AnzoException
     */
    static public void writeRevisionsStart(Writer out) throws AnzoException {
        try {
            XMLWritingUtils.writeStartElement(out, SerializationConstants.revisions);
            XMLWritingUtils.writeCloseElement(out, true);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    /**
     * End the revisions element
     * 
     * @param out
     *            writer for data
     * @throws AnzoException
     */
    static public void writeRevisionsEnd(Writer out) throws AnzoException {
        try {
            XMLWritingUtils.writeEndElement(out, SerializationConstants.revisions);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    /**
     * Write the revision element data
     * 
     * @param out
     *            writer for data
     * @param revision
     *            revision number
     * @param start
     *            when revision started
     * @param end
     *            when revision ended
     * @param lastModifiedBy
     *            who created revision
     * @throws AnzoException
     */
    static public void writeRevisionInfo(Writer out, long revision, long start, long end, URI lastModifiedBy) throws AnzoException {
        try {
            XMLWritingUtils.writeStartElement(out, SerializationConstants.revisionInfo);
            XMLWritingUtils.writeAttribute(out, SerializationConstants.revision, Long.toString(revision));
            XMLWritingUtils.writeAttribute(out, SerializationConstants.start, Long.toString(start));
            if (end != -1) {
                XMLWritingUtils.writeAttribute(out, SerializationConstants.end, Long.toString(end));
            }
            XMLWritingUtils.writeAttribute(out, SerializationConstants.lastModifiedBy, lastModifiedBy.toString());
            XMLWritingUtils.writeCloseEndElement(out);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    /**
     * Start statement element
     * 
     * @param out
     *            writer for data
     * @param uri
     *            uri of statement
     * @throws AnzoException
     */
    static public void writeStatementsStart(Writer out, String uri) throws AnzoException {
        try {
            XMLWritingUtils.writeStartElement(out, SerializationConstants.statements);
            XMLWritingUtils.writeAttribute(out, SerializationConstants.namedGraphUri, uri);
            XMLWritingUtils.writeCloseElement(out, true);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    /**
     * End statement element
     * 
     * @param out
     *            writer for data
     * @throws AnzoException
     */
    static public void writeStatementsEnd(Writer out) throws AnzoException {
        try {
            XMLWritingUtils.writeEndElement(out, SerializationConstants.statements);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }
}
