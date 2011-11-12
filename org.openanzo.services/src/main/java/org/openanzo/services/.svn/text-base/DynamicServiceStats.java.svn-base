/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Mar 18, 2009
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services;

import java.util.HashMap;
import java.util.Map;

import org.apache.activemq.management.CountStatisticImpl;
import org.apache.activemq.management.StatsImpl;
import org.apache.activemq.management.TimeStatisticImpl;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class DynamicServiceStats extends StatsImpl {

    protected Map<String, CountStatisticImpl> counterStats  = new HashMap<String, CountStatisticImpl>();

    protected Map<String, TimeStatisticImpl>  durationStats = new HashMap<String, TimeStatisticImpl>();

    /**
     * Create a new Statistics object for an AuthenticationService
     * 
     * @param methodNames
     *            names of methods to add
     */
    public DynamicServiceStats(String... methodNames) {
        super();
        if (methodNames != null) {
            for (String methodName : methodNames) {
                addMethod(methodName);
            }
        }
    }

    /**
     * Add a new method to the stats
     * 
     * @param methodName
     *            name of method to add
     */
    public void addMethod(String methodName) {
        CountStatisticImpl use = new CountStatisticImpl(methodName + "Use", "Number of calls to " + methodName + " method.");
        TimeStatisticImpl duration = new TimeStatisticImpl(methodName + "Duration", "Duration of calls to " + methodName + " method.");
        addStatistic(use.getName(), use);
        addStatistic(duration.getName(), duration);
    }

    /**
     * Increment the counter for the method
     * 
     * @param methodName
     *            name of method
     * @param duration
     *            duration of method call
     */
    public void use(String methodName, long duration) {
        CountStatisticImpl stat = getCounterStat(methodName);
        if (stat != null) {
            stat.increment();
        }
        TimeStatisticImpl timer = getDurationStat(methodName);
        if (timer != null) {
            timer.addTime(duration);
        }
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        for (CountStatisticImpl stat : counterStats.values()) {
            stat.setEnabled(enabled);
        }
        for (TimeStatisticImpl stat : durationStats.values()) {
            stat.setEnabled(enabled);
        }
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder(" ");
        for (CountStatisticImpl stat : counterStats.values()) {
            buffer.append(stat.toString());
            buffer.append(" ");
        }
        for (TimeStatisticImpl stat : durationStats.values()) {
            buffer.append(stat.toString());
            buffer.append(" ");
        }
        return buffer.toString();
    }

    /**
     * @param methodName
     *            name of method
     * @return the methods counter stats
     */
    public CountStatisticImpl getCounterStat(String methodName) {
        return counterStats.get(methodName);
    }

    /**
     * @param methodName
     *            name of method
     * @return the methods duration stats
     */
    public TimeStatisticImpl getDurationStat(String methodName) {
        return durationStats.get(methodName);
    }

}
