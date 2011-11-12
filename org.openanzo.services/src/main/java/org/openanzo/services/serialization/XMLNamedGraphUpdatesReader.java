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
import java.util.Collection;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.commons.codec.binary.Base64;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.services.INamedGraphUpdate;
import org.openanzo.services.serialization.CommonSerializationUtils.NodeType;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class XMLNamedGraphUpdatesReader {

    private Collection<Statement> currentStatements       = null;

    private INamedGraphUpdate     currentNamedGraphUpdate = null;

    private Resource              currentSubject          = null;

    private URI                   currentPredicate        = null;

    private Value                 currentObject           = null;

    private URI                   currentNamedGraphURI    = null;

    private String                currentValue            = null;

    private String                nodeType                = null;

    private String                language                = null;

    private String                datatype                = null;

    /**
     * Parse the data within the reader, passing the results to the IRepositoryHandler
     * 
     * @param reader
     *            reader containing the data
     * @param handler
     *            Handler which will handle the elements within the data
     * @throws AnzoException
     */
    public void parseUpdates(Reader reader, final INamedGraphUpdateHandler handler) throws AnzoException {
        try {
            XMLStreamReader parser = XMLFactoryFinder.getXMLInputFactory().createXMLStreamReader(reader);

            for (int event = parser.next(); event != XMLStreamConstants.END_DOCUMENT; event = parser.next()) {
                switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    if (SerializationConstants.namedGraph.equals(parser.getLocalName())) {
                        String uri = parser.getAttributeValue(null, SerializationConstants.namedGraphUri);
                        String uuid = parser.getAttributeValue(null, SerializationConstants.namedGraphUUID);
                        currentNamedGraphUpdate = new NamedGraphUpdate(MemURI.create(uri));
                        if (uuid != null) {
                            currentNamedGraphUpdate.setUUID(MemURI.create(uuid));
                        }
                        String revision = parser.getAttributeValue(null, SerializationConstants.revision);
                        if (revision != null) {
                            currentNamedGraphUpdate.setRevision(Long.parseLong(revision));
                        }
                    } else if (SerializationConstants.additions.equals(parser.getLocalName())) {
                        currentStatements = currentNamedGraphUpdate.getAdditions();
                    } else if (SerializationConstants.metaAdditions.equals(parser.getLocalName())) {
                        currentStatements = currentNamedGraphUpdate.getMetaAdditions();
                    } else if (SerializationConstants.removals.equals(parser.getLocalName())) {
                        currentStatements = currentNamedGraphUpdate.getRemovals();
                    } else if (SerializationConstants.metaRemovals.equals(parser.getLocalName())) {
                        currentStatements = currentNamedGraphUpdate.getMetaRemovals();
                    } else if (SerializationConstants.statement.equals(parser.getLocalName())) {
                    } else if (SerializationConstants.subject.equals(parser.getLocalName())) {
                        nodeType = parser.getAttributeValue(null, SerializationConstants.subjectType);
                    } else if (SerializationConstants.predicate.equals(parser.getLocalName())) {
                    } else if (SerializationConstants.object.equals(parser.getLocalName())) {
                        nodeType = parser.getAttributeValue(null, SerializationConstants.objectType);
                        language = parser.getAttributeValue(null, SerializationConstants.language);
                        datatype = parser.getAttributeValue(null, SerializationConstants.dataType);
                    } else if (SerializationConstants.namedGraphUri.equals(parser.getLocalName())) {
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if (SerializationConstants.namedGraph.equals(parser.getLocalName())) {
                        handler.handleNamedGraphUpdate(currentNamedGraphUpdate);
                        currentNamedGraphUpdate = null;
                    } else if (SerializationConstants.additions.equals(parser.getLocalName())) {
                        currentStatements = null;
                    } else if (SerializationConstants.metaAdditions.equals(parser.getLocalName())) {
                        currentStatements = null;
                    } else if (SerializationConstants.removals.equals(parser.getLocalName())) {
                        currentStatements = null;
                    } else if (SerializationConstants.metaRemovals.equals(parser.getLocalName())) {
                        currentStatements = null;
                    } else if (SerializationConstants.statement.equals(parser.getLocalName())) {
                        currentStatements.add(Constants.valueFactory.createStatement(currentSubject, currentPredicate, currentObject, currentNamedGraphURI));
                    } else if (SerializationConstants.subject.equals(parser.getLocalName())) {
                        if (NodeType.BNODE.name().equals(nodeType)) {
                            currentSubject = Constants.valueFactory.createBNode(currentValue);
                        } else {
                            currentSubject = Constants.valueFactory.createURI(currentValue);
                        }
                        currentValue = null;
                        nodeType = null;
                    } else if (SerializationConstants.predicate.equals(parser.getLocalName())) {
                        currentPredicate = Constants.valueFactory.createURI(currentValue);
                        currentValue = null;
                    } else if (SerializationConstants.object.equals(parser.getLocalName())) {
                        if (NodeType.BNODE.name().equals(nodeType)) {
                            currentObject = Constants.valueFactory.createBNode(currentValue);
                        } else if (NodeType.URI.name().equals(nodeType)) {
                            currentObject = Constants.valueFactory.createURI(currentValue);
                        } else if (NodeType.LITERAL.name().equals(nodeType)) {
                            if (Base64.isArrayByteBase64(currentValue.getBytes(Constants.byteEncoding))) {
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
                    } else if (SerializationConstants.namedGraphUri.equals(parser.getLocalName())) {
                        currentNamedGraphURI = Constants.valueFactory.createURI(currentValue);
                        currentValue = null;
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    currentValue = parser.getText();
                    break;
                case XMLStreamConstants.CDATA:
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
