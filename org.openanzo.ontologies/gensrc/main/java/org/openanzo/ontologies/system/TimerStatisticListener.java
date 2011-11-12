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
 * Implementations of this listener may be registered with instances of org.openanzo.ontologies.system.TimerStatistic to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface TimerStatisticListener extends org.openanzo.rdf.jastor.ThingListener {


	/**
	 * Called when title has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.TimerStatistic
	 */
	public void titleChanged(org.openanzo.ontologies.system.TimerStatistic source);

	/**
	 * Called when description has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.TimerStatistic
	 */
	public void descriptionChanged(org.openanzo.ontologies.system.TimerStatistic source);

	/**
	 * Called when statisticsEnabled has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.TimerStatistic
	 */
	public void statisticsEnabledChanged(org.openanzo.ontologies.system.TimerStatistic source);

	/**
	 * Called when a value of statisticCount has been added
	 * @param source the affected instance of org.openanzo.ontologies.system.TimerStatistic
	 * @param newValue the object representing the new value
	 */	
	public void statisticCountAdded(org.openanzo.ontologies.system.TimerStatistic source, java.lang.Long newValue);

	/**
	 * Called when a value of statisticCount has been removed
	 * @param source the affected instance of org.openanzo.ontologies.system.TimerStatistic
	 * @param oldValue the object representing the removed value
	 */	
	public void statisticCountRemoved(org.openanzo.ontologies.system.TimerStatistic source, java.lang.Long oldValue);

	/**
	 * Called when statisticLastSampleTime has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.TimerStatistic
	 */
	public void statisticLastSampleTimeChanged(org.openanzo.ontologies.system.TimerStatistic source);

	/**
	 * Called when statisticStartTime has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.TimerStatistic
	 */
	public void statisticStartTimeChanged(org.openanzo.ontologies.system.TimerStatistic source);

	/**
	 * Called when statisticUnit has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.TimerStatistic
	 */
	public void statisticUnitChanged(org.openanzo.ontologies.system.TimerStatistic source);

	/**
	 * Called when statisticAverageExcludingMinMax has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.TimerStatistic
	 */
	public void statisticAverageExcludingMinMaxChanged(org.openanzo.ontologies.system.TimerStatistic source);

	/**
	 * Called when statisticAveragePerSecond has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.TimerStatistic
	 */
	public void statisticAveragePerSecondChanged(org.openanzo.ontologies.system.TimerStatistic source);

	/**
	 * Called when statisticAveragePerSecondExcludingMinMax has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.TimerStatistic
	 */
	public void statisticAveragePerSecondExcludingMinMaxChanged(org.openanzo.ontologies.system.TimerStatistic source);

	/**
	 * Called when statisticAverageTime has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.TimerStatistic
	 */
	public void statisticAverageTimeChanged(org.openanzo.ontologies.system.TimerStatistic source);

	/**
	 * Called when statisticMaxTime has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.TimerStatistic
	 */
	public void statisticMaxTimeChanged(org.openanzo.ontologies.system.TimerStatistic source);

	/**
	 * Called when statisticMinTime has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.TimerStatistic
	 */
	public void statisticMinTimeChanged(org.openanzo.ontologies.system.TimerStatistic source);

	/**
	 * Called when statisticTotalTime has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.TimerStatistic
	 */
	public void statisticTotalTimeChanged(org.openanzo.ontologies.system.TimerStatistic source);

}