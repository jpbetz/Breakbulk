/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 10, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.combus;

import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.serialization.IReplicationHandler;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
class CombusBatchedReplicationServiceProxy extends BaseCombusProxyDatasourceService implements org.openanzo.datasource.IReplicationService {
    /** Stats for object */
    protected org.openanzo.services.DynamicServiceStats stats = null;

    /**
     * Create a new JMSReplicationServiceProxy
     * 
     */
    protected CombusBatchedReplicationServiceProxy(CombusDatasource datasource, org.openanzo.combus.CombusConnection combusConnection) {
        super(datasource, combusConnection);
        stats = new org.openanzo.services.DynamicServiceStats("replicate");
    }

    public org.openanzo.rdf.URI getURI() {
        return SERVICE_URI;
    }

    public String getName() {
        return "CombusBatchedReplicationServiceProxy";
    }

    public String getDescription() {
        return "Combus Batched Replication Service Proxy";
    }

    /** Statistics object for this service */
    public org.openanzo.services.DynamicServiceStats getStatistics() {
        return stats;
    }

    public void replicate(IOperationContext context, java.util.Collection<org.openanzo.rdf.Statement> namedGraphs, org.openanzo.services.serialization.IReplicationHandler handler, int batchSize) throws AnzoException {
        if (namedGraphs == null) {
            throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER, PARAM_NAMED_GRAPHS);
        }
        String _requestBody = null;
        _requestBody = org.openanzo.services.serialization.transport.StatementsSerializer.serialize(namedGraphs, org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType());
        String resultFormat = org.openanzo.rdf.utils.SerializationConstants.MIMETYPE_ANZO_XML;
        String namedGraphsFormat = org.openrdf.rio.RDFFormat.TRIG.getDefaultMIMEType();
        replicate(context, _requestBody, namedGraphsFormat, handler, batchSize, resultFormat);
    }

    public void replicate(IOperationContext context, String namedGraphs, String namedGraphsFormat, int batchSize, final java.io.Writer output, final String resultFormat) throws AnzoException {
        if (!combusConnection.isConnected()) {
            throw new AnzoException(ExceptionConstants.CLIENT.CLIENT_NOT_CONNECTED);
        }
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try {
            if (namedGraphs == null) {
                throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER, PARAM_NAMED_GRAPHS);
            }
            TextMessage request = combusConnection.createMessage();
            org.openanzo.combus.JMSMessageWrapper messageWrapper = new org.openanzo.combus.JMSMessageWrapper(request);

            messageWrapper.setProperty(SerializationConstants.resultFormat, resultFormat);
            messageWrapper.setProperty(SerializationConstants.operation, REPLICATE);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            org.openanzo.services.serialization.transport.IntSerializer.serialize(batchSize, PARAM_BATCH_SIZE, null, messageWrapper);

            messageWrapper.setProperty(PARAM_NAMED_GRAPHSFormat, namedGraphsFormat);
            messageWrapper.setBody(namedGraphs);

            combusConnection.requestMultipleResponse(context, org.openanzo.datasource.IReplicationService.SERVICE_NAME, request, getTimeout(), new CombusConnection.IMessageHandler() {
                public void handleMessage(TextMessage message, int seq, boolean done, int totalSize) throws AnzoException {
                    try {
                        String response = message.getText();
                        output.write(response);
                    } catch (IOException ioe) {
                        throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, ioe);
                    } catch (JMSException jmsex) {
                        throw new AnzoException(ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER, jmsex);
                    }
                }
            });
            try {
                output.flush();
            } catch (IOException ioe) {
                throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, ioe);
            }
        } finally {
            if (stats.isEnabled()) {
                stats.use("replicate", (System.currentTimeMillis() - start));
            }
        }
    }

    private void replicate(IOperationContext context, String namedGraphs, String namedGraphsFormat, final IReplicationHandler handler, int batchSize, final String resultFormat) throws AnzoException {
        if (!this.combusConnection.isConnected()) {
            throw new AnzoRuntimeException(ExceptionConstants.COMBUS.JMS_NOT_CONNECTED);
        }
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try {
            if (namedGraphs == null) {
                throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER, PARAM_NAMED_GRAPHS);
            }
            TextMessage request = combusConnection.createMessage();
            org.openanzo.combus.JMSMessageWrapper messageWrapper = new org.openanzo.combus.JMSMessageWrapper(request);

            messageWrapper.setProperty(SerializationConstants.resultFormat, resultFormat);
            messageWrapper.setProperty(SerializationConstants.operation, REPLICATE);
            if (context.getAttribute(SerializationConstants.userDescription) != null) {
                messageWrapper.setProperty(SerializationConstants.userDescription, context.getAttribute(SerializationConstants.userDescription, String.class));
            }
            org.openanzo.services.serialization.transport.IntSerializer.serialize(batchSize, PARAM_BATCH_SIZE, null, messageWrapper);

            messageWrapper.setProperty(PARAM_NAMED_GRAPHSFormat, namedGraphsFormat);
            messageWrapper.setBody(namedGraphs);

            combusConnection.requestMultipleResponse(context, org.openanzo.datasource.IReplicationService.SERVICE_NAME, request, getTimeout(), new CombusConnection.IMessageHandler() {
                public void handleMessage(TextMessage message, int seq, boolean done, int totalSize) throws AnzoException {
                    try {
                        String response = message.getText();
                        //   System.err.println("***********************************************************************************************");
                        //   System.err.println(response);

                        if (seq == 0) {
                            handler.start(totalSize);
                        }
                        org.openanzo.services.serialization.transport.ReplicationSerializer.deserialize(response, resultFormat, handler);
                        if (done) {
                            handler.end();
                        }
                    } catch (JMSException jmsex) {
                        throw new AnzoException(ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER, jmsex);
                    }
                }
            });
        } finally {
            if (stats.isEnabled()) {
                stats.use("replicate", (System.currentTimeMillis() - start));
            }
        }
    }
}
