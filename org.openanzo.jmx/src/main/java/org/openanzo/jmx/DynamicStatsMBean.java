/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Nov 29, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.jmx;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanOperationInfo;
import javax.management.ReflectionException;
import javax.management.j2ee.statistics.Statistic;

import org.apache.activemq.management.CountStatisticImpl;
import org.apache.activemq.management.StatsImpl;
import org.apache.activemq.management.TimeStatisticImpl;
import org.openanzo.exceptions.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DynamicMBean for a statistics object
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class DynamicStatsMBean implements javax.management.DynamicMBean {
    private static final Logger log = LoggerFactory.getLogger(DynamicStatsMBean.class);

    private final StatsImpl     stats;

    /**
     * Create a new DynamicMBean for the given statistics object
     * 
     * @param stats
     *            stats to expose in mbean
     */
    public DynamicStatsMBean(StatsImpl stats) {
        this.stats = stats;
    }

    enum StatType {
        /** Total time for execution of stat */
        TotalTime,
        /** Average time for execution of stat */
        TimeAverage
    }

    private final static String ENABLED = "enabled";

    public synchronized String getAttribute(String name) throws AttributeNotFoundException {
        StatType type = null;
        if (ENABLED.equals(name)) {
            return Boolean.toString(stats.isEnabled());
        }
        if (name.endsWith(StatType.TotalTime.name())) {
            type = StatType.TotalTime;
            name = name.substring(0, name.length() - StatType.TotalTime.name().length());
        } else if (name.endsWith(StatType.TimeAverage.name())) {
            type = StatType.TimeAverage;
            name = name.substring(0, name.length() - StatType.TimeAverage.name().length());
        }
        Statistic value = stats.getStatistic(name);
        if (value != null) {
            if (type != null) {
                switch (type) {
                case TotalTime:
                    if (value instanceof TimeStatisticImpl) {
                        return Double.toString(((TimeStatisticImpl) value).getTotalTime());
                    }
                    break;
                case TimeAverage:
                    if (value instanceof TimeStatisticImpl) {
                        return Double.toString(((TimeStatisticImpl) value).getAverageTime());
                    }
                    break;
                }
            }
        }
        if (value instanceof CountStatisticImpl) {
            return Long.toString(((CountStatisticImpl) value).getCount());
        }

        throw new AttributeNotFoundException("No such statistic: " + name);
    }

    public synchronized void setAttribute(Attribute attribute) throws InvalidAttributeValueException, MBeanException, AttributeNotFoundException {
        String name = attribute.getName();
        if (name.equals("enabled")) {
            stats.setEnabled(Boolean.parseBoolean(attribute.getValue().toString()));
        } else {
            throw new InvalidAttributeValueException("Attribute value not settable: " + name);
        }
    }

    public synchronized AttributeList getAttributes(String[] names) {
        AttributeList list = new AttributeList();
        for (String name : names) {
            try {
                String value = getAttribute(name);
                if (value != null)
                    list.add(new Attribute(name, value));
            } catch (AttributeNotFoundException exception) {
                if (log.isWarnEnabled()) {
                    log.warn(LogUtils.LIFECYCLE_MARKER, "Error getting jmx attribute", exception);
                }
            }
        }
        return list;
    }

    public synchronized AttributeList setAttributes(AttributeList list) {
        AttributeList retlist = new AttributeList();
        try {
            for (Object attrObject : list) {
                if (attrObject instanceof Attribute) {
                    Attribute attr = (Attribute) attrObject;
                    setAttribute(attr);

                    retlist.add(getAttribute(attr.getName()));
                }
            }
        } catch (MBeanException exception) {
            if (log.isWarnEnabled()) {
                log.warn(LogUtils.LIFECYCLE_MARKER, "Error setting JMX attribute", exception);
            }
            retlist = new AttributeList();
        } catch (InvalidAttributeValueException exception) {
            if (log.isWarnEnabled()) {
                log.warn(LogUtils.LIFECYCLE_MARKER, "Error setting JMX attribute", exception);
            }
            retlist = new AttributeList();
        } catch (AttributeNotFoundException exception) {
            if (log.isWarnEnabled()) {
                log.warn(LogUtils.LIFECYCLE_MARKER, "Error setting JMX attribute", exception);
            }
            retlist = new AttributeList();
        }
        return retlist;
    }

    public Object invoke(String name, Object[] args, String[] sig) throws MBeanException, ReflectionException {
        if (name.equals("reset") && (args == null || args.length == 0) && (sig == null || sig.length == 0)) {
            stats.reset();
            return null;
        }
        throw new ReflectionException(new NoSuchMethodException(name));
    }

    public synchronized MBeanInfo getMBeanInfo() {
        SortedSet<String> names = new TreeSet<String>();
        for (String statistic : stats.getStatisticNames()) {
            names.add(statistic);
        }
        ArrayList<MBeanAttributeInfo> attrs = new ArrayList<MBeanAttributeInfo>();
        for (String name : names) {
            Statistic statistic = stats.getStatistic(name);
            if (!(statistic instanceof StatsImpl)) {
                if (statistic instanceof CountStatisticImpl) {
                    attrs.add(new MBeanAttributeInfo(statistic.getName(), "java.lang.Long", statistic.getDescription(), true, false, false));
                } else if (statistic instanceof TimeStatisticImpl) {
                    attrs.add(new MBeanAttributeInfo(statistic.getName() + StatType.TimeAverage.name(), "java.lang.Double", statistic.getDescription(), true, false, false));
                    attrs.add(new MBeanAttributeInfo(statistic.getName() + StatType.TotalTime.name(), "java.lang.Double", statistic.getDescription(), true, false, false));
                }
            }
        }
        attrs.add(new MBeanAttributeInfo("enabled", "java.lang.Boolean", "Enable Statistics ", true, true, true));
        MBeanOperationInfo[] opers = { new MBeanOperationInfo("reset", "Reset the statistics", null, "void", MBeanOperationInfo.ACTION) };
        return new MBeanInfo(this.getClass().getName(), "Statistics MBean", attrs.toArray(new MBeanAttributeInfo[0]), null, opers, null);
    }
}
