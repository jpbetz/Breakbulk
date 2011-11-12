/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.notification.web/JavaSource/com/ibm/adtech/boca/notification/web/NotificationControlListener.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  3/22/2006
 * Revision:	$Id: NotificationControlListener.java 163 2007-07-31 14:11:08Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.combus.endpoint;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.openanzo.analysis.RequestAnalysis;
import org.openanzo.analysis.RequestRecorder;
import org.openanzo.combus.MessageUtils;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Constants.OPTIONS;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.impl.BaseOperationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BaseServiceListener is the base MessageListener
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 */
abstract public class BaseServiceListener implements ICombusEndpointListener, MessageListener {
    private static final Logger          log               = LoggerFactory.getLogger(BaseServiceListener.class);

    private final IAuthenticationService authenticationService;

    protected MessageProducer            mp                = null;

    protected Session                    session           = null;

    private MessageConsumer              consumer          = null;

    private MessageConsumer              lowConsumer       = null;

    private final Lock                   lock              = new ReentrantLock();

    private int                          minThreadPoolSize = 1;

    private int                          maxThreadPoolSize = 10;

    private final String                 name;

    protected boolean                    started           = false;

    protected GenericObjectPool          threadPool        = null;

    protected RequestRecorder            recorder          = null;

    /**
     * Create a new BaseServiceListener
     * 
     * @param name
     *            name of listener, used for thread name
     * @param authenticationService
     *            authenticationService for the listener
     */
    public BaseServiceListener(String name, IAuthenticationService authenticationService) {
        this(name, 2, 4, authenticationService);
    }

    /**
     * Create a new BaseServiceListener
     * 
     * @param name
     *            name of listener, used for thread name
     * @param minimumThread
     *            minimum number of listener threads
     * @param maxThreads
     *            maximum number of listener threads
     * @param authenticationService
     *            authenticationService for the listener
     */
    public BaseServiceListener(String name, int minimumThread, int maxThreads, IAuthenticationService authenticationService) {
        this.name = name;
        this.minThreadPoolSize = minimumThread;
        this.maxThreadPoolSize = maxThreads;
        this.authenticationService = authenticationService;

    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void setRecorder(RequestRecorder recorder) {
        this.recorder = recorder;
    }

    public void start() throws AnzoException {
        lock.lock();
        try {
            if (maxThreadPoolSize > 1) {
                threadPool = new GenericObjectPool(new ThreadPoolFactory(), maxThreadPoolSize, GenericObjectPool.WHEN_EXHAUSTED_BLOCK, 0);
                threadPool.setMinIdle(minThreadPoolSize);
                threadPool.setMaxIdle(minThreadPoolSize);
                threadPool.setMinEvictableIdleTimeMillis(10000);
            }
            started = true;
            if (consumer != null) {
                try {
                    consumer.setMessageListener(this);
                    lowConsumer.setMessageListener(this);
                } catch (JMSException jmsex) {
                    log.error(LogUtils.COMBUS_MARKER, "Error setting up consumers", jmsex);
                    throw new AnzoException(ExceptionConstants.COMBUS.JMS_SERVICE_EXCEPTION, jmsex);
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void stop() throws AnzoException {
        lock.lock();
        try {
            started = false;
            try {
                if (threadPool != null)
                    threadPool.close();
                threadPool = null;
            } catch (Exception e) {
                log.error(LogUtils.COMBUS_MARKER, "Error closing thread pool", e);
            }
        } finally {
            lock.unlock();
        }
    }

    protected AnzoPrincipal getContextPrincipal(IOperationContext context, Message request) throws JMSException, AnzoException {
        String uid = request.getStringProperty("JMSXUserID");
        AnzoPrincipal credentials = authenticationService.getUserPrincipal(context, uid);
        String runAsUser = request.getStringProperty(SerializationConstants.runAsUser);
        if (credentials != null && runAsUser != null) {
            if (!credentials.isSysadmin()) {
                throw new AnzoException(ExceptionConstants.COMBUS.RUNAS_NOT_AUTHORIZED);
            }
            credentials = authenticationService.getUserPrincipal(context, runAsUser);
        }
        return credentials;
    }

    protected boolean verifyCaller(IOperationContext context) throws JMSException, AnzoException {
        if (context == null || context.getOperationPrincipal() == null || context.getOperationPrincipal().getUserURI() == null) {
            throw new AnzoException(ExceptionConstants.SERVER.NO_PRINCIPAL_ERROR);
        }
        return true;
    }

    /**
     * @param consumer
     *            the consumer to set
     */
    public void setConsumer(MessageConsumer consumer, MessageConsumer lowConsumer) throws JMSException {
        lock.lock();
        try {
            this.consumer = consumer;
            this.lowConsumer = lowConsumer;
            if (started) {
                this.consumer.setMessageListener(this);
                this.lowConsumer.setMessageListener(this);
            }
        } finally {
            lock.unlock();
        }
    }

    protected int highActive = 0;

    protected int lowActive  = 0;

    public void onMessage(Message message) {

        if (started) {
            try {
                if (threadPool != null) {
                    if (message.propertyExists(SerializationConstants.bypassPool) && message.getBooleanProperty(SerializationConstants.bypassPool)) {
                        processMessage(message);
                    } else {
                        if (message.getJMSPriority() < 4) {
                            while (threadPool.getNumActive() >= threadPool.getMaxActive() || (highActive > (threadPool.getNumActive() / 2) && lowActive > 1)) {
                                synchronized (threadPool) {
                                    threadPool.wait();
                                }
                            }
                            ProcessThread pt = (ProcessThread) threadPool.borrowObject();
                            pt.setRequest(message, false);

                        } else {
                            ProcessThread pt = (ProcessThread) threadPool.borrowObject();
                            pt.setRequest(message, true);
                        }
                    }
                } else {
                    processMessage(message);
                }
            } catch (Throwable jmex) {
                log.error(LogUtils.COMBUS_MARKER, "Error in BaseService Listener's process thread loop", jmex);
            }
        }
    }

    class ProcessThread extends Thread {
        private Message         request      = null;

        private final Lock      readLock     = new ReentrantLock();

        private final Condition waiter       = readLock.newCondition();

        boolean                 dead         = false;

        private boolean         highPriority = false;

        ProcessThread() {
            super(BaseServiceListener.this.name);
            setDaemon(true);
        }

        protected void setRequest(Message request, boolean highPriority) {
            readLock.lock();
            try {
                this.request = request;
                this.highPriority = highPriority;
                waiter.signal();
            } finally {
                readLock.unlock();
            }
        }

        @Override
        public void run() {
            boolean alive = false;
            while (started && !dead) {
                readLock.lock();
                try {
                    if (this.request == null) {
                        waiter.await();
                    }
                    alive = true;
                    if (highPriority)
                        highActive++;
                    else
                        lowActive++;
                    processMessage(request);
                    if (highPriority)
                        highActive--;
                    else
                        lowActive--;
                } catch (InterruptedException jmex) {
                    dead = true;
                } finally {
                    request = null;
                    readLock.unlock();
                    try {
                        if (threadPool != null) {
                            if (alive)
                                threadPool.returnObject(ProcessThread.this);
                            alive = false;
                        } else {
                            dead = true;
                        }
                    } catch (Exception e) {
                        log.error(LogUtils.COMBUS_MARKER, "Error in BaseService Listener's process thread loop", e);
                    }
                }
            }
        }
    }

    private void processMessage(Message request) {
        try {
            IOperationContext context = null;
            TextMessage response = null;
            String operation = request.getStringProperty(SerializationConstants.operation);
            try {
                Destination replyTo = null;
                try {
                    if (mp == null) {
                        mp = session.createProducer(null);
                        mp.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
                    }
                    replyTo = request.getJMSReplyTo();

                    String resultFormat = request.getStringProperty(SerializationConstants.resultFormat);
                    context = new BaseOperationContext(operation, request.getJMSCorrelationID(), null);
                    if (request.propertyExists(SerializationConstants.userDescription)) {
                        context.setAttribute(SerializationConstants.userDescription, request.getStringProperty(SerializationConstants.userDescription));
                    }
                    if (request.propertyExists(OPTIONS.SKIPCACHE)) {
                        context.setAttribute(OPTIONS.SKIPCACHE, request.getBooleanProperty(OPTIONS.SKIPCACHE));
                    }
                    if (request.propertyExists(OPTIONS.INCLUDEMETADATAGRAPHS)) {
                        context.setAttribute(OPTIONS.INCLUDEMETADATAGRAPHS, request.getBooleanProperty(OPTIONS.INCLUDEMETADATAGRAPHS));
                    }

                    AnzoPrincipal callerPrincipal = getContextPrincipal(context, request);
                    context.setOperationPrincipal(callerPrincipal);

                    if (log.isTraceEnabled()) {
                        log.trace(LogUtils.COMBUS_MARKER, MessageUtils.prettyPrint(request, "Message Recieved from [" + callerPrincipal.getName() + "]" + ((replyTo != null) ? (" with replyto [" + replyTo + "]") : "")));
                    } else if (log.isDebugEnabled()) {
                        log.debug(LogUtils.COMBUS_MARKER, "Message Recieved from [" + callerPrincipal.getName() + "]" + ((replyTo != null) ? (" with replyto [" + replyTo + "]") : ""));
                    }
                    context.setMDC();
                    Boolean analyzeRequest = request.getBooleanProperty(RequestAnalysis.CONTEXT_PROP_REQUEST_ENABLED);
                    if (analyzeRequest || recorder != null) {
                        RequestAnalysis.setCurrentContext(context.getAttributes());
                        RequestAnalysis.setRequestAnalysisEnabled(true);
                    }

                    if (recorder != null) {
                        recorder.recordRequest((TextMessage) request, request.getStringProperty("JMSXUserID"), request.getStringProperty(SerializationConstants.runAsUser));
                    }

                    long start = 0, end = 0;
                    if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                        start = System.currentTimeMillis();
                    }

                    response = handleMessage(context, replyTo, resultFormat, operation, (TextMessage) request, mp);
                    if (RequestAnalysis.isAnalysisEnabled(context.getAttributes())) {
                        end = System.currentTimeMillis();
                        RequestAnalysis.addAnalysisProperty(RequestAnalysis.ANS_PROP_OPERATION_TIME, String.valueOf(end - start));
                    }

                    if (response != null) {
                        response.setIntProperty(SerializationConstants.protocolVersion, Constants.VERSION);
                        if (operation != null) {
                            response.setStringProperty(SerializationConstants.operation, operation);
                        }
                        Integer totalSolutions = context.getAttribute(SerializationConstants.totalSolutions, Integer.class);
                        if (totalSolutions != null) {
                            response.setIntProperty(SerializationConstants.totalSolutions, totalSolutions.intValue());
                        }
                        if (analyzeRequest) {
                            for (String name : RequestAnalysis.getAnalysisPropertyNames()) {
                                response.setStringProperty(name, context.getAttribute(name).toString());
                            }
                        }
                    }

                    if (response != null && replyTo != null) {
                        response.setJMSCorrelationID(request.getJMSCorrelationID());
                        if (log.isTraceEnabled()) {
                            log.trace(LogUtils.COMBUS_MARKER, MessageUtils.prettyPrint(response, "Sending Response to [" + replyTo + "]"));
                        } else if (log.isDebugEnabled()) {
                            log.debug(LogUtils.COMBUS_MARKER, "Sending Response to [" + replyTo + "]");
                        }
                        mp.send(replyTo, response);
                    }

                } catch (JMSException jmex) {
                    response = sendJMSErrorMessage(replyTo, request, jmex, ExceptionConstants.COMBUS.JMS_SERVICE_EXCEPTION, jmex.toString());
                } catch (AnzoException jmex) {
                    response = sendJMSErrorMessage(replyTo, request, jmex, jmex.getErrorCode(), jmex.getArgs());
                } catch (AnzoRuntimeException jmex) {
                    response = sendJMSErrorMessage(replyTo, request, jmex, jmex.getErrorCode(), jmex.getArgs());
                } catch (RuntimeException jmex) {
                    response = sendJMSErrorMessage(replyTo, request, jmex, ExceptionConstants.COMBUS.JMS_SERVICE_EXCEPTION, jmex.toString());
                } catch (Throwable jmex) {
                    response = sendJMSErrorMessage(replyTo, request, jmex, ExceptionConstants.COMBUS.JMS_SERVICE_EXCEPTION, jmex.toString());
                }

                if (recorder != null) {
                    if (response != null) {
                        recorder.recordResponse(response);
                    } else {
                        recorder.recordResponse(request.getJMSCorrelationID(), operation);
                    }
                }
            } finally {
                if (context != null) {
                    context.clearMDC();
                }
            }
        } catch (JMSException jmsex) {
            if (jmsex.getCause() instanceof InterruptedException) {
                log.debug(LogUtils.COMBUS_MARKER, "Thread interrupted in order to stop.", jmsex);
            } else {
                log.error(LogUtils.COMBUS_MARKER, "Error in BaseService Listener's process thread loop", jmsex);
            }
        } catch (Throwable jmex) {
            log.error(LogUtils.COMBUS_MARKER, "Error in BaseService Listener's process thread loop", jmex);
        }
    }

    private TextMessage sendJMSErrorMessage(Destination replyTo, Message request, Throwable jmex, long errorCode, String... args) throws JMSException {
        try {
            if (replyTo != null) {
                if (log.isWarnEnabled()) {
                    log.warn(LogUtils.COMBUS_MARKER, "Exception while ServiceListener [" + name + "] was precessing request.", jmex);

                }
                String message = null;
                if (jmex instanceof AnzoException) {
                    message = ((AnzoException) jmex).getMessage(false);
                } else if (jmex instanceof AnzoRuntimeException) {
                    message = ((AnzoRuntimeException) jmex).getMessage(false);
                } else {
                    message = jmex.getMessage();
                }
                TextMessage response = session.createTextMessage(message);
                response.setJMSCorrelationID(request.getJMSCorrelationID());
                response.setBooleanProperty(SerializationConstants.operationFailed, true);
                response.setLongProperty(SerializationConstants.errorTags, 0);
                response.setLongProperty(SerializationConstants.errorCode, errorCode);
                response.setIntProperty(SerializationConstants.protocolVersion, Constants.VERSION);
                // send a single arg string for compat. with older readers
                response.setStringProperty(SerializationConstants.errorMessageArg, Arrays.toString(args));

                // send the individual error args for readers that can make use of them
                for (int i = 0; i < args.length; i++) {
                    response.setStringProperty(SerializationConstants.errorMessageArg + i, args[i]);
                }

                // we log all JMS messages, even errors.
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.COMBUS_MARKER, MessageUtils.prettyPrint(response, "Sending Response to " + replyTo));
                }
                mp.send(replyTo, response);
                return response;
            }
        } catch (JMSException jmsex) {
            log.debug(LogUtils.COMBUS_MARKER, "Error sending error message to client", jmsex);
        }
        return null;
    }

    class ThreadPoolFactory implements PoolableObjectFactory {
        public void activateObject(Object arg0) throws Exception {
        }

        public void destroyObject(Object arg0) throws Exception {
            ((ProcessThread) arg0).interrupt();
        }

        public Object makeObject() throws Exception {
            ProcessThread pt = new ProcessThread();
            pt.start();
            return pt;
        }

        public void passivateObject(Object arg0) throws Exception {
        }

        public boolean validateObject(Object arg0) {
            return !((ProcessThread) arg0).dead;
        }
    }
}
