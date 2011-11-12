/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Mar 12, 2008
 * Revision:	$Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.client;

import java.io.StringWriter;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.openanzo.combus.CombusConnection;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.ontologies.openanzo.AnzoFactory;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.AnzoGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.rdf.utils.UriGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class StatementChannel implements IStatementChannel {
    private final static Logger                                  log       = LoggerFactory.getLogger(StatementChannel.class);

    private final CopyOnWriteArraySet<IStatementChannelListener> listeners = new CopyOnWriteArraySet<IStatementChannelListener>();

    private final CombusConnection                               combusConnection;

    private final URI                                            uri;

    private String                                               topic;

    private final AnzoGraph                                      namedGraph;

    private final ChannelMessageListener                         messageListener;

    private boolean                                              closed    = false;

    private final AnzoClient                                     anzoClient;

    /**
     * Create a new StatementChannel with the given URI and AnzoGraph
     */
    StatementChannel(CombusConnection combusConnection, URI uri, AnzoGraph namedGraph, AnzoClient client) {
        this.anzoClient = client;
        this.combusConnection = combusConnection;
        if (!this.combusConnection.isConnected()) {
            throw new AnzoRuntimeException(ExceptionConstants.COMBUS.JMS_NOT_CONNECTED);
        }
        this.uri = uri;
        this.namedGraph = namedGraph;
        messageListener = new ChannelMessageListener();
    }

    public void close() throws AnzoException {
        closed = true;
        this.anzoClient.closeChannel(this);
        combusConnection.unregisterTopicListener(topic);
        this.namedGraph.close();
        for (IStatementChannelListener listener : listeners) {
            try {
                listener.channelClosed();
            } catch (Throwable t) {
                if (log.isWarnEnabled()) {
                    log.warn(LogUtils.COMBUS_MARKER, "Error closing statement channel", t);
                }
            }
        }
    }

    public AnzoGraph getNamedGraph() {
        return namedGraph;
    }

    public URI getURI() {
        return uri;
    }

    private void notifyListeners(Map<String, Object> messageProperties, Collection<Statement> statements) {
        for (IStatementChannelListener listener : listeners) {
            try {
                listener.statementsReceived(messageProperties, statements);
            } catch (Throwable t) {
                if (log.isWarnEnabled()) {
                    log.warn(LogUtils.INTERNAL_MARKER, Messages.formatString(ExceptionConstants.COMBUS.ERROR_CHANNEL_LISTENER, listener.getClass().getName()), t);
                }
            }
        }
    }

    protected void connect() throws AnzoException {
        combusConnection.registerTopicListener(getTopic(), messageListener);
    }

    public void registerListener(IStatementChannelListener listener) throws AnzoException {
        if (closed) {
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_NOT_CONNECTED);
        }
        listeners.add(listener);
        if (listeners.size() == 1) {
            connect();
        }
    }

    private String getTopic() throws AnzoException {
        if (topic == null) {
            NamedGraph ng = AnzoFactory.getNamedGraph(uri, namedGraph.getMetadataGraph());
            URI uuid = ng.getUuid();
            if (uuid != null) {
                topic = UriGenerator.generateEncapsulatedString(NAMESPACES.STREAM_TOPIC_PREFIX, uuid.toString());
            }
        }
        return topic;
    }

    public void sendMessage(Map<String, Object> messageProperties, Collection<Statement> statements) throws AnzoException {
        if (closed) {
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_NOT_CONNECTED);
        }
        if (statements.size() > 0) {
            try {
                TextMessage message = combusConnection.createMessage();
                message.setIntProperty(SerializationConstants.protocolVersion, Constants.VERSION);

                if (messageProperties != null) {
                    for (Map.Entry<String, Object> entry : messageProperties.entrySet()) {
                        if (!entry.getKey().equals(SerializationConstants.userUri)) {
                            message.setObjectProperty(entry.getKey(), entry.getValue());
                        }
                    }
                }
                StringWriter stmtsWriter = new StringWriter();
                org.openanzo.rdf.utils.ReadWriteUtils.writeStatements(statements, stmtsWriter, RDFFormat.JSON, null, false);
                message.setText(stmtsWriter.toString());
                combusConnection.publishMessage(getTopic(), message);
            } catch (JMSException jmsex) {
                throw new AnzoException(ExceptionConstants.COMBUS.COULD_NOT_PUBLISH, jmsex);
            }
        }
    }

    public void unregisterListener(IStatementChannelListener listener) throws AnzoException {
        if (closed) {
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_NOT_CONNECTED);
        }
        listeners.remove(listener);
        if (listeners.size() == 0) {
            combusConnection.unregisterTopicListener(topic);
        }
    }

    class ChannelMessageListener implements MessageListener {
        @SuppressWarnings("unchecked")
        public void onMessage(Message message) {
            try {
                String stmts = ((TextMessage) message).getText();
                Collection<Statement> statements = org.openanzo.rdf.utils.ReadWriteUtils.readStatements(stmts, RDFFormat.JSON);
                Map<String, Object> properties = new HashMap<String, Object>();
                for (Enumeration<String> keys = message.getPropertyNames(); keys.hasMoreElements();) {
                    String key = keys.nextElement();
                    properties.put(key, message.getObjectProperty(key));
                }
                notifyListeners(properties, statements);
            } catch (JMSException jmsex) {
                log.warn(LogUtils.COMBUS_MARKER, Messages.formatString(ExceptionConstants.COMBUS.ERROR_PROCESSING_MESSGE, "statement channel"), jmsex);
                throw new AnzoRuntimeException(ExceptionConstants.COMBUS.JMS_MESSAGE_PARSING, jmsex);
            } catch (AnzoException jmsex) {
                log.warn(LogUtils.COMBUS_MARKER, Messages.formatString(ExceptionConstants.COMBUS.ERROR_PROCESSING_MESSGE, "statement channel"), jmsex);
                throw new AnzoRuntimeException(ExceptionConstants.COMBUS.JMS_MESSAGE_PARSING, jmsex);
            }

        }
    }
}
