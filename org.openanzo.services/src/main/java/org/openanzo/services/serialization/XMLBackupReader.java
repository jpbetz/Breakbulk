/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Mar 4, 2008
 * Revision:	$Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services.serialization;

import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.commons.codec.binary.Base64;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.services.serialization.CommonSerializationUtils.NodeType;

/**
 * XML parser for backup data
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class XMLBackupReader {
    private Collection<BackupRevision> revisions            = null;

    private String                     graphUri             = null;

    private URI                        namedGraphUri        = null;

    private URI                        uuid                 = null;

    private URI                        metaURI              = null;

    private URI                        lastModified         = null;

    private Long                       start                = null;

    private Long                       end                  = null;

    private boolean                    revisioned           = false;

    private boolean                    metadata             = false;

    private boolean                    processGraph         = false;

    private Resource                   currentSubject       = null;

    private URI                        currentPredicate     = null;

    private Value                      currentObject        = null;

    private URI                        currentNamedGraphURI = null;

    private String                     currentValue         = null;

    private String                     nodeType             = null;

    private String                     language             = null;

    private String                     datatype             = null;

    private final Reader               reader;

    /**
     * Create a new XML parser for given reader data
     * 
     * @param reader
     */
    public XMLBackupReader(Reader reader) {
        this.reader = reader;
    }

    /**
     * Read data from reader, and pass data to handler
     * 
     * @param handler
     *            handler that handles data
     * @throws AnzoException
     */
    public void read(final IBackupHandler handler) throws AnzoException {
        parseBackup(reader, handler);
    }

    /**
     * Parse the data within the reader, passing the results to the IRepositoryHandler
     * 
     * @param reader
     *            reader containing the data
     * @param handler
     *            Handler which will handle the elements within the data
     * @throws AnzoException
     */
    private void parseBackup(Reader reader, final IBackupHandler handler) throws AnzoException {
        try {
            XMLStreamReader parser = XMLFactoryFinder.getXMLInputFactory().createXMLStreamReader(reader);

            for (int event = parser.next(); event != XMLStreamConstants.END_DOCUMENT; event = parser.next()) {
                switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    if (SerializationConstants.namedGraph.equals(parser.getLocalName())) {
                        graphUri = parser.getAttributeValue(null, SerializationConstants.namedGraphUri);
                        String meta = parser.getAttributeValue(null, SerializationConstants.metadataGraphUri);
                        String uuidString = parser.getAttributeValue(null, SerializationConstants.namedGraphUUID);
                        namedGraphUri = Constants.valueFactory.createURI(graphUri);
                        metaURI = Constants.valueFactory.createURI(meta);
                        uuid = Constants.valueFactory.createURI(uuidString);
                        revisioned = Boolean.parseBoolean(parser.getAttributeValue(null, SerializationConstants.revisioned));
                    } else if (SerializationConstants.revisions.equals(parser.getLocalName())) {
                        revisions = new ArrayList<BackupRevision>();
                    } else if (SerializationConstants.revisionInfo.equals(parser.getLocalName())) {
                        long revision = Long.parseLong(parser.getAttributeValue(null, SerializationConstants.revision));
                        Long start = Long.valueOf(parser.getAttributeValue(null, SerializationConstants.start));
                        String endString = parser.getAttributeValue(null, SerializationConstants.end);
                        Long end = (endString != null) ? Long.valueOf(endString) : -1;
                        lastModified = Constants.valueFactory.createURI(parser.getAttributeValue(null, SerializationConstants.lastModifiedBy));
                        revisions.add(new BackupRevision(revision, start, end, lastModified));
                    } else if (SerializationConstants.statement.equals(parser.getLocalName())) {
                        if (processGraph) {
                            if (revisioned) {
                                String startString = parser.getAttributeValue(null, SerializationConstants.start);
                                String endString = parser.getAttributeValue(null, SerializationConstants.end);
                                if (startString != null)
                                    start = Long.valueOf(startString);
                                if (endString != null)
                                    end = Long.valueOf(endString);
                            }
                        }
                    } else if (SerializationConstants.statements.equals(parser.getLocalName())) {
                        if (processGraph) {
                            metadata = !parser.getAttributeValue(null, SerializationConstants.namedGraphUri).equals(graphUri);
                        }
                    } else if (SerializationConstants.subject.equals(parser.getLocalName())) {
                        if (processGraph) {
                            nodeType = parser.getAttributeValue(null, SerializationConstants.subjectType);
                        }
                    } else if (SerializationConstants.predicate.equals(parser.getLocalName())) {
                    } else if (SerializationConstants.object.equals(parser.getLocalName())) {
                        if (processGraph) {
                            nodeType = parser.getAttributeValue(null, SerializationConstants.objectType);
                            language = parser.getAttributeValue(null, SerializationConstants.language);
                            datatype = parser.getAttributeValue(null, SerializationConstants.dataType);
                        }
                    } else if (SerializationConstants.namedGraphUri.equals(parser.getLocalName())) {
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if (SerializationConstants.namedGraph.equals(parser.getLocalName())) {
                        graphUri = null;
                        namedGraphUri = null;
                        metaURI = null;
                        uuid = null;
                        revisioned = true;
                        revisions = null;
                    } else if (SerializationConstants.revisionInfo.equals(parser.getLocalName())) {
                    } else if (SerializationConstants.revisions.equals(parser.getLocalName())) {
                        processGraph = handler.handleNamedGraph(revisioned, namedGraphUri, metaURI, uuid, revisions);
                        revisions = null;
                    } else if (SerializationConstants.statement.equals(parser.getLocalName())) {
                        if (processGraph) {
                            handler.handleStatement(metadata, revisioned, Constants.valueFactory.createStatement(currentSubject, currentPredicate, currentObject, currentNamedGraphURI), start, end);
                            start = null;
                            end = null;
                        }
                    } else if (SerializationConstants.subject.equals(parser.getLocalName())) {
                        if (processGraph) {
                            if (NodeType.BNODE.name().equals(nodeType)) {
                                currentSubject = Constants.valueFactory.createBNode(currentValue);
                            } else {
                                currentSubject = Constants.valueFactory.createURI(currentValue);
                            }
                            currentValue = null;
                            nodeType = null;
                        }
                    } else if (SerializationConstants.predicate.equals(parser.getLocalName())) {
                        if (processGraph) {
                            currentPredicate = Constants.valueFactory.createURI(currentValue);
                            currentValue = null;
                        }
                    } else if (SerializationConstants.object.equals(parser.getLocalName())) {
                        if (processGraph) {
                            if (NodeType.BNODE.name().equals(nodeType)) {
                                currentObject = Constants.valueFactory.createBNode(currentValue);
                            } else if (NodeType.URI.name().equals(nodeType)) {
                                currentObject = Constants.valueFactory.createURI(currentValue);
                            } else if (NodeType.LITERAL.name().equals(nodeType)) {
                                if (currentValue == null) {
                                    currentValue = "";
                                } else if (Base64.isArrayByteBase64(currentValue.getBytes(Constants.byteEncoding))) {
                                    currentValue = new String(Base64.decodeBase64(currentValue.getBytes(Constants.byteEncoding)), Constants.byteEncoding);
                                }
                                if (datatype != null) {
                                    currentObject = Constants.valueFactory.createLiteral(currentValue, Constants.valueFactory.createURI(datatype));
                                } else if (language != null) {
                                    currentObject = Constants.valueFactory.createLiteral(currentValue, language);
                                } else {
                                    currentObject = Constants.valueFactory.createLiteral(currentValue);
                                }
                            }
                            currentValue = null;
                            nodeType = null;
                            language = null;
                            datatype = null;
                        }
                    } else if (SerializationConstants.namedGraphUri.equals(parser.getLocalName())) {
                        if (processGraph) {
                            currentNamedGraphURI = Constants.valueFactory.createURI(currentValue);
                            currentValue = null;
                        }
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    if (parser.hasText())
                        currentValue = parser.getText();
                    break;
                case XMLStreamConstants.CDATA:
                    if (parser.hasText())
                        currentValue = parser.getText();
                    break;
                }
            }
            parser.close();
        } catch (XMLStreamException ex) {
            throw new AnzoException(ExceptionConstants.IO.READ_ERROR, ex, ex.getMessage());
        } catch (UnsupportedEncodingException uee) {
            throw new AnzoException(ExceptionConstants.IO.ENCODING_ERROR, uee);
        }
    }

}
