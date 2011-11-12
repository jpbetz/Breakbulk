/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.notification.web/JavaSource/com/ibm/adtech/boca/notification/web/NotificationServer.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  3/22/2006
 * Revision:	$Id: NotificationServer.java 163 2007-07-31 14:11:08Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.combus.endpoint.internal;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashSet;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.broker.BrokerStoppedException;
import org.apache.activemq.transport.TransportDisposedIOException;
import org.openanzo.analysis.RequestRecorder;
import org.openanzo.combus.IJmsProvider;
import org.openanzo.combus.endpoint.ICombusEndpointListener;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.services.ServicesDictionary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NotificationServer connects to JMS server to handle update messages from model server, and sends updates to notification clients
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
class CombusEndpoint {
    private static final Logger                                  log               = LoggerFactory.getLogger(CombusEndpoint.class);

    /** End-point Listeners */
    private HashSet<ICombusEndpointListener>                     endpointListeners = null;

    /** CombusListener listeners */
    private ArrayList<CombusListener>                            combusListeners   = null;

    /** JMS connection */
    private Connection                                           connection        = null;

    /** Retries to connect to JMS server */
    private int                                                  retries           = 0;

    /** IJmsProvider */
    private final IJmsProvider                                   jmsProvider;

    // private ThreadGroup                                          threadGroup       = null;

    private final Dictionary<? extends Object, ? extends Object> configProperties;

    private RequestRecorder                                      recorder;

    /**
     * Create new NotificationServer
     * 
     */
    protected CombusEndpoint(IJmsProvider jmsProvider, Dictionary<? extends Object, ? extends Object> configProperties, RequestRecorder recorder) {
        this.configProperties = configProperties;
        this.jmsProvider = jmsProvider;
        this.recorder = recorder;
    }

    protected void setRecorder(RequestRecorder recorder) {
        this.recorder = recorder;
    }

    protected void start() throws AnzoException {
        combusListeners = new ArrayList<CombusListener>();
        // this.threadGroup = new ThreadGroup("ComBusThreads");
        endpointListeners = new HashSet<ICombusEndpointListener>();
        Thread connectThread = new Thread("CombusEndpointConnect") {
            @Override
            public void run() {
                try {
                    connect();
                } catch (AnzoException ae) {
                    log.error(LogUtils.COMBUS_MARKER, "Error in connect:", ae);
                }
            }
        };
        connectThread.setDaemon(true);
        connectThread.start();
    }

    protected void stop() throws AnzoException {
        disconnect(true);
    }

    void connect() throws AnzoException {
        if (retries > 5)
            return;
        String user = ServicesDictionary.getUser(configProperties, null);
        String password = ServicesDictionary.getPassword(configProperties, null);

        try {
            ConnectionFactory factory = jmsProvider.createConnectionFactory(configProperties);
            connection = factory.createConnection(user, password);
            connection.start();

            connection.setExceptionListener(new ExceptionListener() {

                public void onException(JMSException exception) {
                    if (exception.getCause() instanceof BrokerStoppedException || exception.getCause() instanceof TransportDisposedIOException) {
                        disconnect(false);
                    } else {
                        disconnect(true);
                        log.error(LogUtils.COMBUS_MARKER, "Closing combus endpoint connection due to jms exception", exception);
                        try {
                            connect();
                        } catch (AnzoException ae) {
                            log.error(LogUtils.COMBUS_MARKER, "Error in connect:", ae);
                        }
                    }
                }
            });
            synchronized (endpointListeners) {
                for (ICombusEndpointListener listener : endpointListeners) {
                    setupConsumer(listener);
                }
            }
            retries = 0;
        } catch (JMSException jmsex) {
            log.error(LogUtils.COMBUS_MARKER, "Error connecting combus endpoint connection", jmsex);
            retries++;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ie) {
            }
            connect();
        }
    }

    private void setupConsumer(ICombusEndpointListener listener) throws JMSException {
        if (recorder != null) {
            listener.setRecorder(recorder);
        }
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(listener.getQueueName());
        MessageConsumer consumer = session.createConsumer(queue, "JMSPriority >= 4");
        MessageConsumer lowConsumer = session.createConsumer(queue, "JMSPriority < 4");
        CombusListener combusListener = new CombusListener(session, listener, consumer, lowConsumer);
        combusListeners.add(combusListener);
        listener.setConsumer(consumer, lowConsumer);
        log.info(LogUtils.COMBUS_MARKER, "Created listener on queue:{} ", listener.getQueueName());
    }

    synchronized void disconnect(boolean clean) {
        if (connection != null) {
            try {
                for (CombusListener listener : combusListeners) {
                    listener.close(clean);
                }
                combusListeners.clear();
            } finally {
                try {
                    connection.close();
                } catch (JMSException jmsex) {
                    if (clean) {
                        log.warn(LogUtils.COMBUS_MARKER, "Error disconnecting combus endpoint connection", jmsex);
                    } else {
                        log.debug(LogUtils.COMBUS_MARKER, "Error disconnecting combus endpoint connection", jmsex);
                    }
                } finally {
                    connection = null;
                }
            }
        }
    }

    protected void registerListener(ICombusEndpointListener listener) {
        synchronized (endpointListeners) {
            endpointListeners.add(listener);
            if (connection != null) {
                try {
                    setupConsumer(listener);
                } catch (JMSException jmsex) {
                    log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error registering combus endpoint listener", jmsex);
                }
            }
        }
    }

    protected void unregisterListener(ICombusEndpointListener listener) {
        synchronized (endpointListeners) {
            endpointListeners.remove(listener);
            if (connection != null) {
                try {
                    listener.stop();
                } catch (AnzoException jmsex) {
                    log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error unregistering combus endpoint listener", jmsex);
                }
            }
        }
    }

    static class CombusListener {
        private final Session                 session;

        private final MessageConsumer[]       messageConsumers;

        private final ICombusEndpointListener messageListener;

        CombusListener(Session session, ICombusEndpointListener messageListener, MessageConsumer... messageConsumers) {
            this.session = session;
            this.messageConsumers = messageConsumers;
            this.messageListener = messageListener;
            this.messageListener.setSession(session);
        }

        void close(boolean clean) {
            try {
                messageListener.stop();
            } catch (AnzoException ae) {
                log.warn(LogUtils.COMBUS_MARKER, "Error stopping combus endpoint listener", ae);
            }
            if (clean) {
                for (MessageConsumer messageConsumer : messageConsumers) {
                    try {
                        messageConsumer.close();
                    } catch (NullPointerException npe) {
                        //Catch exception due to defect within activemq's ActiveMQMessageConsumer.dispose() method
                    } catch (JMSException jmsex) {
                        log.warn(LogUtils.COMBUS_MARKER, "Error closing combus endpoint listener consumer", jmsex);
                    }
                }
                try {
                    session.close();
                } catch (JMSException jmsex) {
                    log.warn(LogUtils.COMBUS_MARKER, "Error closing combus endpoint listener session", jmsex);
                }
            }
        }
    }

}
