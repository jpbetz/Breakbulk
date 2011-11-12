/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/services/impl/JMSNotificationService.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  5/20/2006
 * Revision:	$Id: JMSNotificationService.java 178 2007-07-31 14:22:33Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.openanzo.combus.MessageUtils;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.rdf.utils.SerializationUtils;
import org.openanzo.services.INamedGraphUpdate;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.IUpdateResultListener;
import org.openanzo.services.IUpdateTransaction;
import org.openanzo.services.IUpdates;
import org.openanzo.services.impl.UpdateTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Core class that process updates to and from the server
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 */
class NamedGraphUpdateManager implements MessageListener, IUpdateResultListener {
    private static final Logger              log              = LoggerFactory.getLogger(NamedGraphUpdateManager.class);

    /** Registered listeners for named graph updates */

    private final HashSet<URI>               namedGraphTopics = new HashSet<URI>();

    private NamedGraphUpdateMessageProcessor namedGraphUpdateProcessor;

    private final AnzoClient                 anzoClient;

    /**
     * Create new JMSNotificationService with configuration properties provided in properties object
     */
    NamedGraphUpdateManager(AnzoClient client) {
        this.anzoClient = client;
    }

    void addNamedGraphUpdateTopic(URI namedGraphUUIDUri) throws AnzoException {
        if (namedGraphTopics.contains(namedGraphUUIDUri)) {
            return;
        } else {
            anzoClient.clientDatasource.registerTopicListener(this, namedGraphUUIDUri);
            namedGraphTopics.add(namedGraphUUIDUri);
        }
    }

    void removeNamedGraphUpdateTopic(URI namedGraphUri) throws AnzoException {
        if (namedGraphTopics.remove(namedGraphUri)) {
            anzoClient.clientDatasource.unregisterTopicListener(this, namedGraphUri);
        }
    }

    void clear() {
        if (this.namedGraphUpdateProcessor != null) {
            this.namedGraphUpdateProcessor.interrupt();
            connect();
        }
    }

    void connect() {
        this.namedGraphUpdateProcessor = new NamedGraphUpdateMessageProcessor(anzoClient);
        this.namedGraphUpdateProcessor.start();
    }

    void disconnect() {
        if (namedGraphUpdateProcessor != null) {
            namedGraphUpdateProcessor.disconnect();
            namedGraphUpdateProcessor = null;
        }
        this.namedGraphTopics.clear();

    }

    public void updateComplete(IOperationContext context, IUpdates updates) throws AnzoException {
        if (namedGraphUpdateProcessor != null) {
            namedGraphUpdateProcessor.lock.lock();
            try {
                for (IUpdateTransaction transaction : updates.getTransactions()) {
                    if (transaction.getErrors().size() == 0) {
                        boolean found = false;
                        if (namedGraphUpdateProcessor != null && namedGraphUpdateProcessor.updateMessages != null) {
                            synchronized (namedGraphUpdateProcessor.updateMessages) {
                                for (INamedGraphUpdate update : transaction.getNamedGraphUpdates()) {
                                    if (namedGraphTopics.contains(update.getUUID())) {
                                        namedGraphUpdateProcessor.updateMessages.add(update);
                                        found = true;
                                    }
                                }
                            }
                        }
                        if (found) {
                            namedGraphUpdateProcessor.newUpdateMessage.signalAll();
                        }
                    }
                }
            } finally {
                if (namedGraphUpdateProcessor != null) {
                    namedGraphUpdateProcessor.lock.unlock();
                }
            }
        }
    }

    public void onMessage(Message topicMessage) {
        if (namedGraphUpdateProcessor != null && !namedGraphUpdateProcessor.disconnect && !namedGraphUpdateProcessor.disconnected) {
            namedGraphUpdateProcessor.lock.lock();
            try {
                String method = topicMessage.getStringProperty(SerializationConstants.type);
                if (method != null) {
                    if (log.isTraceEnabled()) {
                        log.trace(LogUtils.COMBUS_MARKER, MessageUtils.prettyPrint(topicMessage, "Topic Message Recieved: "));
                    }
                    if (method.equals(SerializationConstants.namedGraphUpdate)) {
                        synchronized (namedGraphUpdateProcessor.updateMessages) {
                            namedGraphUpdateProcessor.updateMessages.add(MessageUtils.processNamedGraphUpdateMessage(topicMessage));
                        }
                        namedGraphUpdateProcessor.newUpdateMessage.signalAll();
                    }
                }
            } catch (JMSException jmsex) {
                log.error(LogUtils.COMBUS_MARKER, Messages.formatString(ExceptionConstants.COMBUS.ERROR_PROCESSING_MESSGE, "namedgraph update"), jmsex);
            } catch (AnzoException jmsex) {
                log.error(LogUtils.COMBUS_MARKER, Messages.formatString(ExceptionConstants.COMBUS.ERROR_PROCESSING_MESSGE, "namedgraph update"), jmsex);
            } finally {
                if (namedGraphUpdateProcessor != null) {
                    namedGraphUpdateProcessor.lock.unlock();
                }
            }
        }
    }

    private static class NamedGraphUpdates extends UpdateTransaction {

        long               firstMessageTimestamp = System.currentTimeMillis();

        HashMap<URI, Long> expectedGraphs        = new HashMap<URI, Long>();

        NamedGraphUpdates(URI transactionUri, long transactionTimestamp, Collection<Statement> transactionContext, Map<URI, Long> updatedNamedGraphs) {
            super(transactionUri, transactionTimestamp, transactionContext, updatedNamedGraphs);
        }
    }

    private static class NamedGraphUpdateMessageProcessor extends Thread {

        // transactionId > NamedGraphUpdates
        HashMap<URI, NamedGraphUpdates> updates               = new HashMap<URI, NamedGraphUpdates>();

        // list of processed transactions so we know that if we see a message for transaction that has
        // already been processed and removed from the updates map, we don't setup an entry for it there.
        // for now, we keep this list indefinitely. Since it is just a set of URI, this should not be a
        // concern.
        HashSet<URI>                    processedTransactions = new HashSet<URI>();

        List<INamedGraphUpdate>         updateMessages        = new LinkedList<INamedGraphUpdate>();

        final Lock                      lock                  = new ReentrantLock();

        final Condition                 newUpdateMessage      = lock.newCondition();

        final Condition                 finished              = lock.newCondition();

        long                            interval              = 1500;

        long                            transactionTimeout    = 2000;

        final AnzoClient                client;

        boolean                         disconnect            = false;

        boolean                         disconnected          = false;

        NamedGraphUpdateMessageProcessor(AnzoClient client) {
            super("NamedGraphUpdateMessageProcessor:" + client.userDescription);
            setDaemon(true);
            this.client = client;
        }

        public void disconnect() {
            disconnect = true;
            lock.lock();
            try {
                newUpdateMessage.signalAll();
                if (!disconnected) {
                    try {
                        finished.await();
                    } catch (InterruptedException ie) {
                    }
                }
            } finally {
                lock.unlock();
            }

            updateMessages.clear();
            updates.clear();
            disconnect = false;
            disconnected = false;
        }

        @Override
        public void run() {
            try {
                // the update message processor runs throughout the life of the client
                while (!disconnect) {
                    try {

                        // every interval period, wakeup to check if we have any transactions that we haven't
                        // received all the named graph updates for, and that we expect we never will
                        lock.lock();
                        ArrayList<INamedGraphUpdate> _updates = null;
                        try {
                            newUpdateMessage.await(interval, TimeUnit.MILLISECONDS);
                            if (disconnect) {
                                return;
                            }
                            synchronized (updateMessages) {
                                _updates = new ArrayList<INamedGraphUpdate>(updateMessages);
                                updateMessages.removeAll(_updates);
                            }
                        } catch (InterruptedException ie) {
                            return;
                        } finally {
                            lock.unlock();
                        }

                        if (_updates.size() > 0 || updates.size() > 0) {
                            client.clientLock.lock();
                            try {
                                processUpdates(_updates);
                            } finally {
                                client.clientLock.unlock();
                            }

                        }

                    } catch (Exception e) {
                        log.error(LogUtils.INTERNAL_MARKER, Messages.formatString(ExceptionConstants.COMBUS.ERROR_PROCESSING_MESSGE, "namedgraph update"), e);
                    }
                }
            } finally {
                lock.lock();
                try {
                    disconnected = true;
                    finished.signal();
                } finally {
                    lock.unlock();
                }
            }
        }

        private void processUpdates(Collection<INamedGraphUpdate> updateMessages) throws AnzoException {
            long timestamp = System.currentTimeMillis();
            boolean needsReplicate = false;
            // if we were notified of one or more update messages, process them.
            // process every update message received so far.
            if (updateMessages != null) {
                for (INamedGraphUpdate updateMessage : updateMessages) {
                    needsReplicate |= processNamedGraphUpdateMessage(updateMessage);
                    if (disconnect)
                        return;
                }
            }

            // check if we have been waiting on a particular transaction for more than the alloted transactionTimeout
            // if so, we know we need to replicate.
            if (!needsReplicate) {
                for (URI transactionURI : updates.keySet()) {
                    NamedGraphUpdates namedGraphUpdates = updates.get(transactionURI);
                    if (timestamp - namedGraphUpdates.firstMessageTimestamp > transactionTimeout) {
                        if (log.isDebugEnabled()) {
                            log.debug(LogUtils.INTERNAL_MARKER, Messages.formatString(ExceptionConstants.CLIENT.EXTRA_REPLICATION_NEEDED, SerializationUtils.convertToList(namedGraphUpdates.getNamedGraphs(), SerializationConstants.MIMETYPE_CSV)));
                        }
                        needsReplicate = true;
                        break;
                    }
                }
            }

            // if either we have timed-out transactions, or our replica is out of date, then we must perform a replicate.
            // Once we have replicated, there is no longer a need to wait for any more named graph updates for transactions
            // we already know about so we notify the transaction handle and mark the transaction as processed.
            if (disconnect)
                return;
            if (needsReplicate) {
                HashSet<URI> graphsToReplicate = new HashSet<URI>();
                for (URI transactionURI : updates.keySet()) {
                    NamedGraphUpdates namedGraphUpdates = updates.get(transactionURI);
                    graphsToReplicate.addAll(namedGraphUpdates.expectedGraphs.keySet());
                }
                if (log.isDebugEnabled())
                    log.debug(LogUtils.INTERNAL_MARKER, Messages.formatString(ExceptionConstants.CLIENT.EXTRA_REPLICATION, SerializationUtils.convertToList(graphsToReplicate, SerializationConstants.MIMETYPE_CSV)));

                if (disconnect)
                    return;
                client.replicator.replicate(graphsToReplicate);
                for (URI transactionURI : updates.keySet()) {
                    NamedGraphUpdates namedGraphUpdates = updates.get(transactionURI);
                    client.handleTransaction(new UpdateTransaction(transactionURI, namedGraphUpdates.getTransactionTimestamp(), namedGraphUpdates.getTransactionContext(), namedGraphUpdates.expectedGraphs));
                    processedTransactions.add(transactionURI);
                }
                updates.clear();
            }

        }

        /**
         * 
         * @param namedGraphUpdateMessage
         * @return whether or a not a replication is required after processing this message
         * @throws AnzoException
         */
        boolean processNamedGraphUpdateMessage(INamedGraphUpdate namedGraphUpdateMessage) throws AnzoException {
            if (processedTransactions.contains(namedGraphUpdateMessage.getTransaction().getURI())) {
                return false;
            }

            NamedGraphUpdates namedGraphUpdates = updates.get(namedGraphUpdateMessage.getTransaction().getURI());

            if (namedGraphUpdates == null) {
                namedGraphUpdates = new NamedGraphUpdates(namedGraphUpdateMessage.getTransaction().getURI(), transactionTimeout, namedGraphUpdateMessage.getTransaction().getTransactionContext(), namedGraphUpdateMessage.getTransaction().getUpdatedNamedGraphRevisions());

                updates.put(namedGraphUpdateMessage.getTransaction().getURI(), namedGraphUpdates);
                for (Map.Entry<URI, Long> entry : namedGraphUpdateMessage.getTransaction().getUpdatedNamedGraphRevisions().entrySet()) {

                    Collection<Statement> stmts = null;
                    stmts = client.quadStore.find((Resource) null, NamedGraph.uuidProperty, entry.getKey(), (URI) null);
                    if (!stmts.isEmpty()) {
                        Statement stmt = stmts.iterator().next();
                        URI ngUri = (URI) stmt.getSubject();
                        namedGraphUpdates.expectedGraphs.put(ngUri, entry.getValue());
                    } else {
                        log.debug(LogUtils.INTERNAL_MARKER, Messages.formatString(ExceptionConstants.DATASOURCE.NAMEDGRAPH.GRAPH_NOT_VALID, entry.getKey().toString()));
                    }
                }
            }

            Long rev = namedGraphUpdates.expectedGraphs.get(namedGraphUpdateMessage.getNamedGraphURI());
            // we received a namedgraph update in a transaction that we were not expecting....
            // this should not happen.
            if (rev == null) {
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.INTERNAL_MARKER, Messages.formatString(ExceptionConstants.CLIENT.NOT_EXPECTED, namedGraphUpdateMessage.getNamedGraphURI().toString(), SerializationUtils.convertToList(namedGraphUpdates.expectedGraphs.keySet(), SerializationConstants.MIMETYPE_CSV)));
                }
                return true;
            }
            if (log.isDebugEnabled())
                log.debug(LogUtils.INTERNAL_MARKER, Messages.formatString(ExceptionConstants.CLIENT.EXPECTED, namedGraphUpdateMessage.getTransaction().getURI().toString(), namedGraphUpdateMessage.getNamedGraphURI().toString(), SerializationUtils.convertToList(namedGraphUpdates.expectedGraphs.keySet(), SerializationConstants.MIMETYPE_CSV)));
            namedGraphUpdates.addNamedGraphUpdate(namedGraphUpdateMessage);
            if (namedGraphUpdates.getNamedGraphs().containsAll(namedGraphUpdates.expectedGraphs.keySet())) {
                boolean replicaInSync = true;
                for (INamedGraphUpdate entry : namedGraphUpdates.getNamedGraphUpdates()) {
                    boolean inSync = client.namedGraphUpdater.handleNamedGraphUpdate(entry);
                    if (!inSync) {
                        if (log.isDebugEnabled()) {
                            log.debug(LogUtils.INTERNAL_MARKER, Messages.formatString(ExceptionConstants.CLIENT.NOT_IN_SYNCH, namedGraphUpdateMessage.getNamedGraphURI().toString()));
                        }
                        replicaInSync = false;
                    }
                }

                if (replicaInSync) {
                    client.handleTransaction(namedGraphUpdateMessage.getTransaction());
                    this.updates.remove(namedGraphUpdateMessage.getTransaction().getURI());
                    this.processedTransactions.add(namedGraphUpdateMessage.getTransaction().getURI());
                    return false;
                } else {
                    return true;
                }

            }
            return false;
        }
    }

}
