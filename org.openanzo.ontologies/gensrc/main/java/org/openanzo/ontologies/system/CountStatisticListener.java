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
package org.openanzo.ontologies.system;

/**
 * Implementations of this listener may be registered with instances of org.openanzo.ontologies.system.CountStatistic to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface CountStatisticListener extends org.openanzo.rdf.jastor.ThingListener {


	/**
	 * Called when title has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.CountStatistic
	 */
	public void titleChanged(org.openanzo.ontologies.system.CountStatistic source);

	/**
	 * Called when description has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.CountStatistic
	 */
	public void descriptionChanged(org.openanzo.ontologies.system.CountStatistic source);

	/**
	 * Called when statisticsEnabled has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.CountStatistic
	 */
	public void statisticsEnabledChanged(org.openanzo.ontologies.system.CountStatistic source);

	/**
	 * Called when a value of statisticCount has been added
	 * @param source the affected instance of org.openanzo.ontologies.system.CountStatistic
	 * @param newValue the object representing the new value
	 */	
	public void statisticCountAdded(org.openanzo.ontologies.system.CountStatistic source, java.lang.Long newValue);

	/**
	 * Called when a value of statisticCount has been removed
	 * @param source the affected instance of org.openanzo.ontologies.system.CountStatistic
	 * @param oldValue the object representing the removed value
	 */	
	public void statisticCountRemoved(org.openanzo.ontologies.system.CountStatistic source, java.lang.Long oldValue);

	/**
	 * Called when statisticLastSampleTime has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.CountStatistic
	 */
	public void statisticLastSampleTimeChanged(org.openanzo.ontologies.system.CountStatistic source);

	/**
	 * Called when statisticStartTime has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.CountStatistic
	 */
	public void statisticStartTimeChanged(org.openanzo.ontologies.system.CountStatistic source);

	/**
	 * Called when statisticUnit has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.CountStatistic
	 */
	public void statisticUnitChanged(org.openanzo.ontologies.system.CountStatistic source);

	/**
	 * Called when statisticFrequency has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.CountStatistic
	 */
	public void statisticFrequencyChanged(org.openanzo.ontologies.system.CountStatistic source);

	/**
	 * Called when statisticPeriod has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.CountStatistic
	 */
	public void statisticPeriodChanged(org.openanzo.ontologies.system.CountStatistic source);

}