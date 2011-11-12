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

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.utils.SerializationConstants;

/**
 * Provides XML serialization of transport messages.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class XMLReplicationWriter implements IReplicationHandler {

    /** Stream to which output is written */
    final private Writer out;

    private Boolean      lastMetadata;

    private Boolean      lastAddition;

    private URI          lastNamedGraphUri;

    /**
     * New XMLNodeWriter that writes to out
     * 
     * @param out
     *            Stream to which output is written
     */
    public XMLReplicationWriter(Writer out) {
        this.out = out;
    }

    public void start(int totalSize) throws AnzoException {
        XMLWritingUtils.start(out);
    }

    public void end() throws AnzoException {
        try {
            if (lastNamedGraphUri != null) {
                endStatementSet();
                XMLWritingUtils.handleNamedGraphEnd(out);
            }
            XMLWritingUtils.end(out);
        } catch (IOException ioe) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, ioe.getMessage());
        }
    }

    public boolean handleNamedGraph(URI namedGraphUri, URI uuid, long revision) throws AnzoException {
        try {
            if (lastNamedGraphUri != null) {
                endStatementSet();
                XMLWritingUtils.handleNamedGraphEnd(out);
            }
            XMLWritingUtils.handleNamedGraphStart(out, namedGraphUri, uuid, revision);
            lastNamedGraphUri = namedGraphUri;
            return true;
        } catch (IOException ioe) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, ioe.getMessage());
        }
    }

    private void startStatementSet(boolean metadata, boolean addition) throws IOException {
        lastMetadata = metadata;
        lastAddition = addition;
        if (lastMetadata && lastAddition) {
            XMLWritingUtils.writeStartElement(out, SerializationConstants.metaAdditions);
        } else if (lastMetadata) {
            XMLWritingUtils.writeStartElement(out, SerializationConstants.metaRemovals);
        } else if (!lastMetadata && lastAddition) {
            XMLWritingUtils.writeStartElement(out, SerializationConstants.additions);
        } else {
            XMLWritingUtils.writeStartElement(out, SerializationConstants.removals);
        }
        XMLWritingUtils.writeCloseElement(out, true);
    }

    private void endStatementSet() throws IOException {
        if (lastMetadata != null && lastAddition != null) {
            if (lastMetadata && lastAddition) {
                XMLWritingUtils.writeEndElement(out, SerializationConstants.metaAdditions);
            } else if (lastMetadata) {
                XMLWritingUtils.writeEndElement(out, SerializationConstants.metaRemovals);
            } else if (!lastMetadata && lastAddition) {
                XMLWritingUtils.writeEndElement(out, SerializationConstants.additions);
            } else {
                XMLWritingUtils.writeEndElement(out, SerializationConstants.removals);
            }
            lastMetadata = null;
            lastAddition = null;
        }
    }

    public boolean handleStatement(boolean metadata, boolean addition, Resource subject, URI predicate, Value object, URI namedGraphURI) throws AnzoException {
        try {
            if (lastMetadata != null && lastAddition != null && (lastMetadata.booleanValue() != metadata || lastAddition.booleanValue() != addition)) {
                endStatementSet();
                startStatementSet(metadata, addition);
            } else if (lastMetadata == null || lastAddition == null) {
                startStatementSet(metadata, addition);
            }
            XMLWritingUtils.handleStatement(out, subject, predicate, object, namedGraphURI);
        } catch (IOException ioe) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, ioe.getMessage());
        }
        return true;
    }

}
