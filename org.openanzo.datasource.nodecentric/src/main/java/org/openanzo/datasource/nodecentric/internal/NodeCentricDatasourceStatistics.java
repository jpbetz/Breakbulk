/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Mar 13, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.internal;

import javax.management.j2ee.statistics.Statistic;

import org.apache.activemq.management.CountStatisticImpl;
import org.apache.activemq.management.StatisticImpl;
import org.apache.activemq.management.StatsImpl;
import org.apache.activemq.management.TimeStatisticImpl;
import org.openanzo.services.DynamicServiceStats;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
class NodeCentricDatasourceStatistics extends DynamicServiceStats {
    private final CountStatisticImpl getWriteConnectionUse;

    private final TimeStatisticImpl  getWriteConnectionDuration;

    private final CountStatisticImpl getQueryConnectionUse;

    private final TimeStatisticImpl  getQueryConnectionDuration;

    private final CountStatisticImpl beginUse;

    private final TimeStatisticImpl  beginDuration;

    private final CountStatisticImpl commitUse;

    private final TimeStatisticImpl  commitDuration;

    private final CountStatisticImpl abortUse;

    private final TimeStatisticImpl  abortDuration;

    /**
     * Create a new Statistics object for an AuthenticationService
     */
    public NodeCentricDatasourceStatistics() {
        super();
        getWriteConnectionUse = new CountStatisticImpl("getWriteConnectionUse", "Number of calls to getWriteConnection method.");
        getWriteConnectionDuration = new TimeStatisticImpl("getWriteConnectionDuration", "Duration of calls to getWriteConnection method.");
        addStatistic(getWriteConnectionUse.getName(), getWriteConnectionUse);
        addStatistic(getWriteConnectionDuration.getName(), getWriteConnectionDuration);
        getQueryConnectionUse = new CountStatisticImpl("getQueryConnectionUse", "Number of calls to getQueryConnection method.");
        getQueryConnectionDuration = new TimeStatisticImpl("getQueryConnectionDuration", "Duration of calls to getQueryConnection method.");
        addStatistic(getQueryConnectionUse.getName(), getQueryConnectionUse);
        addStatistic(getQueryConnectionDuration.getName(), getQueryConnectionDuration);

        beginUse = new CountStatisticImpl("beginUse", "Number of calls to begin method.");
        beginDuration = new TimeStatisticImpl("beginDuration", "Duration of calls to begin method.");
        addStatistic(beginUse.getName(), beginUse);
        addStatistic(beginDuration.getName(), beginDuration);

        abortUse = new CountStatisticImpl("abortUse", "Number of calls to abort method.");
        abortDuration = new TimeStatisticImpl("abortDuration", "Duration of calls to abort method.");
        addStatistic(abortUse.getName(), abortUse);
        addStatistic(abortDuration.getName(), abortDuration);

        commitUse = new CountStatisticImpl("commitUse", "Number of calls to commit method.");
        commitDuration = new TimeStatisticImpl("commitDuration", "Duration of calls to commit method.");
        addStatistic(commitUse.getName(), commitUse);
        addStatistic(commitDuration.getName(), commitDuration);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        getWriteConnectionUse.setEnabled(enabled);
        getWriteConnectionDuration.setEnabled(enabled);
        getQueryConnectionUse.setEnabled(enabled);
        getQueryConnectionDuration.setEnabled(enabled);
        beginUse.setEnabled(enabled);
        beginDuration.setEnabled(enabled);
        abortUse.setEnabled(enabled);
        abortDuration.setEnabled(enabled);
        commitUse.setEnabled(enabled);
        commitDuration.setEnabled(enabled);
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder(" ");
        buffer.append(getWriteConnectionUse);
        buffer.append(" ");
        buffer.append(getWriteConnectionDuration);
        buffer.append(" ");
        buffer.append(getQueryConnectionUse);
        buffer.append(" ");
        buffer.append(getQueryConnectionDuration);
        buffer.append(" ");
        buffer.append(beginUse);
        buffer.append(" ");
        buffer.append(beginDuration);
        buffer.append(" ");
        buffer.append(abortUse);
        buffer.append(" ");
        buffer.append(abortDuration);
        buffer.append(" ");
        buffer.append(commitUse);
        buffer.append(" ");
        buffer.append(commitDuration);
        buffer.append(" ");
        return buffer.toString();
    }

    /**
     * @return the getWriteConnectionUse
     */
    public CountStatisticImpl getGetWriteConnectionUse() {
        return getWriteConnectionUse;
    }

    /**
     * @return the getWriteConnectionDuration
     */
    public TimeStatisticImpl getGetWriteConnectionDuration() {
        return getWriteConnectionDuration;
    }

    /**
     * @return the getQueryConnectionUse
     */
    public CountStatisticImpl getGetQueryConnectionUse() {
        return getQueryConnectionUse;
    }

    /**
     * @return the getQueryConnectionDuration
     */
    public TimeStatisticImpl getGetQueryConnectionDuration() {
        return getQueryConnectionDuration;
    }

    /**
     * @return the beginUse
     */
    public CountStatisticImpl getBeginUse() {
        return beginUse;
    }

    /**
     * @return the beginDuration
     */
    public TimeStatisticImpl getBeginDuration() {
        return beginDuration;
    }

    /**
     * @return the commitUse
     */
    public CountStatisticImpl getCommitUse() {
        return commitUse;
    }

    /**
     * @return the commitDuration
     */
    public TimeStatisticImpl getCommitDuration() {
        return commitDuration;
    }

    /**
     * @return the abortUse
     */
    public CountStatisticImpl getAbortUse() {
        return abortUse;
    }

    /**
     * @return the abortDuration
     */
    public TimeStatisticImpl getAbortDuration() {
        return abortDuration;
    }

    public void addStatistic(StatsImpl statsImpl) {
        if (statsImpl != null) {
            for (Statistic stat : statsImpl.getStatistics()) {
                if (stat instanceof StatisticImpl) {
                    addStatistic(stat.getName(), (StatisticImpl) stat);
                }
            }
        }
    }

    public void addStatistic(StatisticImpl statsImpl) {
        if (statsImpl != null) {
            addStatistic(statsImpl.getName(), statsImpl);
        }
    }
}
