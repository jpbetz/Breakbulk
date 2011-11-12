/*******************************************************************************
 * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Generated Source from org.openanzo.jdbc.utils.opgen.jet
 * Created on:  Generated Source from org.openanzo.jdbc.utils.opgen.jet
 * Revision:	$Id$
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *	   Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.services;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Constants;
import org.openanzo.services.IStatisticsProvider;
import org.openanzo.services.IOperationContext;
import org.openanzo.rdf.URI;

 /**
 * Notification Registration Service interface
 * Operations related to managing notification subscribers and their subscriptions.
 * @author Generated Code
 *
 */
public interface INotificationRegistrationService extends IStatisticsProvider {
	/** Service's Name in {@link String} form */
    public static final String SERVICE_NAME = Constants.NAMESPACES.SERVICE_PREFIX + "NotificationRegistrationService";

    /** Service's Name in {@link URI} form */
    public static final URI    SERVICE_URI  = Constants.valueFactory.createURI(SERVICE_NAME);

    /* Statistics object for this service
    public org.openanzo.services.stats.NotificationRegistrationServiceStats getStatistics();
    */
	/**Constant for parameter datasettrackers */
	public static final String PARAM_DATASETTRACKERS = "datasettrackers";
	/**Constant for parameter namedgraphTrackers */
	public static final String PARAM_NAMEDGRAPH_TRACKERS = "namedgraphTrackers";
	/**Constant for parameter replyTo */
	public static final String PARAM_REPLY_TO = "replyTo";
	/**Constant for parameter trackers */
	public static final String PARAM_TRACKERS = "trackers";
	/**Constant for parameter datasettrackers format */
	public static final String PARAM_DATASETTRACKERSFormat = "datasettrackersFormat";
	/**Constant for parameter namedgraphTrackers format */
	public static final String PARAM_NAMEDGRAPH_TRACKERSFormat = "namedgraphTrackersFormat";
	/**Constant for parameter trackers format */
	public static final String PARAM_TRACKERSFormat = "trackersFormat";
	/**registerSubscriber operation name constant */
    public static final String REGISTER_SUBSCRIBER = "registerSubscriber";
    /**
     * Register a subscriber with the server.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param replyTo
     *            Reply To destination.
     * @return True if registration successful .
     * @throws AnzoException
     */
    public boolean registerSubscriber(IOperationContext context,javax.jms.Destination replyTo) throws AnzoException;

    /**
     * Register a subscriber with the server.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param replyTo
     *            Reply To destination.
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @throws AnzoException
     */
    public void registerSubscriber(IOperationContext context,javax.jms.Destination replyTo, java.io.Writer output) throws AnzoException;
	/**registerTrackers operation name constant */
    public static final String REGISTER_TRACKERS = "registerTrackers";
    /**
     * Register trackers with the notification server.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param trackers
     *            Set of trackers to register.
     * @param datasettrackers
     *            Set of dataset trackers to register.
     * @param namedgraphTrackers
     *            Set of namedgraph trackers to register.
     * @param replyTo
     *            Reply To destination.
     * @return True if registration successful .
     * @throws AnzoException
     */
    public boolean registerTrackers(IOperationContext context,java.util.Set<org.openanzo.services.impl.SelectorTracker> trackers,java.util.Set<org.openanzo.services.impl.DatasetTracker> datasettrackers,java.util.Set<org.openanzo.rdf.URI> namedgraphTrackers,javax.jms.Destination replyTo) throws AnzoException;

    /**
     * Register trackers with the notification server.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param trackers
     *            Set of trackers to register.
     * @param datasettrackers
     *            Set of dataset trackers to register.
     * @param namedgraphTrackers
     *            Set of namedgraph trackers to register.
     * @param replyTo
     *            Reply To destination.
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @throws AnzoException
     */
    public void registerTrackers(IOperationContext context,java.util.Set<org.openanzo.services.impl.SelectorTracker> trackers,java.util.Set<org.openanzo.services.impl.DatasetTracker> datasettrackers,java.util.Set<org.openanzo.rdf.URI> namedgraphTrackers,javax.jms.Destination replyTo, java.io.Writer output) throws AnzoException;
	/**unregisterSubscriber operation name constant */
    public static final String UNREGISTER_SUBSCRIBER = "unregisterSubscriber";
    /**
     * Unregister a subscriber with the server.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param replyTo
     *            Reply To destination.
     * @return True if unregistration successful .
     * @throws AnzoException
     */
    public boolean unregisterSubscriber(IOperationContext context,javax.jms.Destination replyTo) throws AnzoException;

    /**
     * Unregister a subscriber with the server.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param replyTo
     *            Reply To destination.
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @throws AnzoException
     */
    public void unregisterSubscriber(IOperationContext context,javax.jms.Destination replyTo, java.io.Writer output) throws AnzoException;
	/**unregisterTrackers operation name constant */
    public static final String UNREGISTER_TRACKERS = "unregisterTrackers";
    /**
     * Unregister trackers with the notification server.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param trackers
     *            Set of trackers to unregister.
     * @param datasettrackers
     *            Set of dataset trackers to unregister.
     * @param namedgraphTrackers
     *            Set of namedgraph trackers to unregister.
     * @param replyTo
     *            Reply To destination.
     * @return True if registration successful .
     * @throws AnzoException
     */
    public boolean unregisterTrackers(IOperationContext context,java.util.Set<org.openanzo.services.impl.SelectorTracker> trackers,java.util.Set<org.openanzo.services.impl.DatasetTracker> datasettrackers,java.util.Set<org.openanzo.rdf.URI> namedgraphTrackers,javax.jms.Destination replyTo) throws AnzoException;

    /**
     * Unregister trackers with the notification server.
     *
     * @param context
     *            {@link IOperationContext} context for this operation
     * @param trackers
     *            Set of trackers to unregister.
     * @param datasettrackers
     *            Set of dataset trackers to unregister.
     * @param namedgraphTrackers
     *            Set of namedgraph trackers to unregister.
     * @param replyTo
     *            Reply To destination.
     * @param output
     *            {@link java.io.Writer} onto which output is written
     * @throws AnzoException
     */
    public void unregisterTrackers(IOperationContext context,java.util.Set<org.openanzo.services.impl.SelectorTracker> trackers,java.util.Set<org.openanzo.services.impl.DatasetTracker> datasettrackers,java.util.Set<org.openanzo.rdf.URI> namedgraphTrackers,javax.jms.Destination replyTo, java.io.Writer output) throws AnzoException;
}
