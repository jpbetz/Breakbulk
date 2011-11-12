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
package org.openanzo.combus.realtime;

import java.io.Writer;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.jms.Destination;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.SerializationUtils;
import org.openanzo.services.DynamicServiceStats;
import org.openanzo.services.INotificationRegistrationService;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.impl.DatasetTracker;
import org.openanzo.services.impl.SelectorTracker;

/**
 * NotificationRegistrationServiceListener is a MessageListener that listens for notification control messages. Registration of client destination with server,
 * and in the future registration of subscriptions.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 */
class NotificationRegistrationService implements INotificationRegistrationService {
    private final RealtimeUpdatePublisher realtimeUpdatePublisher;

    private DynamicServiceStats           stats = new DynamicServiceStats(REGISTER_SUBSCRIBER, REGISTER_TRACKERS, UNREGISTER_SUBSCRIBER, UNREGISTER_TRACKERS);

    /**
     * Create a new NotificationServiceListener
     * 
     * @param realtimeUpdatePublisher
     */
    public NotificationRegistrationService(RealtimeUpdatePublisher realtimeUpdatePublisher) {
        this.realtimeUpdatePublisher = realtimeUpdatePublisher;
    }

    public DynamicServiceStats getStatistics() {
        return stats;
    }

    public String getName() {
        return "Service=NotificationRegistrationService";
    }

    public String getDescription() {
        return "Notification Registration Service";
    }

    public boolean registerSubscriber(IOperationContext context, Destination replyTo) throws AnzoException {
        realtimeUpdatePublisher.registerClient(context.getOperationPrincipal(), replyTo);
        return true;
    }

    public void registerSubscriber(IOperationContext context, Destination replyTo, Writer output) throws AnzoException {
        boolean result = registerSubscriber(context, replyTo);
        SerializationUtils.writeValue(result, output, null);
    }

    public boolean registerTrackers(IOperationContext context, Set<SelectorTracker> trackers, Set<DatasetTracker> datasetTrackers, Set<URI> namedGraphTrackers, Destination replyTo) throws AnzoException {
        realtimeUpdatePublisher.registerTracker(context, trackers, datasetTrackers, namedGraphTrackers, replyTo);
        return true;
    }

    public void registerTrackers(IOperationContext context, Set<SelectorTracker> trackers, Set<DatasetTracker> datasetTrackers, Set<URI> namedGraphTrackers, Destination replyTo, Writer output) throws AnzoException {
        boolean result = registerTrackers(context, trackers, datasetTrackers, namedGraphTrackers, replyTo);
        SerializationUtils.writeValue(result, output, null);
    }

    public boolean unregisterSubscriber(IOperationContext context, Destination replyTo) throws AnzoException {
        realtimeUpdatePublisher.deregisterClient(context.getOperationPrincipal(), replyTo);
        return true;
    }

    public void unregisterSubscriber(IOperationContext context, Destination replyTo, Writer output) throws AnzoException {
        boolean result = unregisterSubscriber(context, replyTo);
        SerializationUtils.writeValue(result, output, null);
    }

    public boolean unregisterTrackers(IOperationContext context, Set<SelectorTracker> trackers, Set<DatasetTracker> datasetTrackers, Set<URI> namedGraphTrackers, Destination replyTo) throws AnzoException {
        realtimeUpdatePublisher.unregisterTracker(context, trackers, datasetTrackers, namedGraphTrackers, replyTo);
        return true;
    }

    public void unregisterTrackers(IOperationContext context, Set<SelectorTracker> trackers, Set<DatasetTracker> datasetTrackers, Set<URI> namedGraphTrackers, Destination replyTo, Writer output) throws AnzoException {
        boolean result = unregisterTrackers(context, trackers, datasetTrackers, namedGraphTrackers, replyTo);
        SerializationUtils.writeValue(result, output, null);
    }

    public ReentrantReadWriteLock getLockProvider() {
        return null;
    }

    public void logEntry() {
    }

    public void logExit() {
    }
}
