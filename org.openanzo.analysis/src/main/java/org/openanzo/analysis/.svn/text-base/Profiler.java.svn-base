/*******************************************************************************
 * Copyright (c) 2008-2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.openanzo.analysis;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.openanzo.exceptions.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Profiler uses a logger to write profile information to the log
 */
public class Profiler {
    /** Default Profiler Logger */
    public static final String DEFAULT_PROFILER_LOGGER = "org.openanzo.analysis.profiling.DefaultProfilerLogger";

    Map<Long, TimerData>       timers                  = new HashMap<Long, TimerData>();

    long                       count                   = 0;

    Logger                     log                     = null;

    Stack<Long>                list                    = new Stack<Long>();

    /**
     * Create a profiler that uses the default logger
     */
    public Profiler() {
        this.log = LoggerFactory.getLogger(DEFAULT_PROFILER_LOGGER);
    }

    /**
     * Create a profiler that uses a specific logger
     * 
     * @param log
     *            logger to use
     */
    public Profiler(Logger log) {
        this.log = log;
    }

    /**
     * Start timing with a specific title
     * 
     * @param title
     *            title for starting a timer
     * @return id for timer
     */
    public long start(String title) {
        if (!log.isDebugEnabled()) {
            return -1;
        }
        return start(title, null);
    }

    /**
     * Start a timer with a title and an object that is passed to the title as a parameter
     * 
     * @param title
     *            title for starting a timer
     * @param titleObj
     *            object that is passed to the logger as a param to the title
     * @return the id of the timer
     */
    public synchronized long start(String title, Object titleObj) {
        if (!log.isDebugEnabled()) {
            return -1;
        }
        long id = count++;
        TimerData timer = new TimerData(title, titleObj);
        timers.put(id, timer);
        timer.start();
        list.push(id);
        return id;
    }

    /**
     * Pop the last timer of the stack and stop it
     */
    public void stop() {
        if (!log.isDebugEnabled()) {
            return;
        }
        try {
            long id = list.pop();
            stop(id);
        } catch (EmptyStackException e) {
            log.warn(LogUtils.INTERNAL_MARKER, "stop called too many times. Profiler measurements may be incorrect!", e);
        }
    }

    /**
     * Stop a specific timer
     * 
     * @param id
     *            id of timer to stop
     */
    public synchronized void stop(long id) {
        if (!log.isDebugEnabled()) {
            return;
        }
        TimerData timer = timers.get(id);
        if (timer == null) {
            return;
        } else {
            timer.stop();
            timers.remove(id);
        }
    }

    class TimerData {

        String title    = null;

        Object titleObj = null;

        long   start    = -1;

        long   stop     = -1;

        TimerData(String title) {
            this.title = title;
        }

        TimerData(String title, Object titleObj) {
            this.title = title;
            this.titleObj = titleObj;
        }

        void start() {
            if (titleObj == null) {
                log.debug(LogUtils.INTERNAL_MARKER, START, title);
            } else {
                log.debug(LogUtils.INTERNAL_MARKER, START2, title, titleObj);
            }
            start = System.currentTimeMillis();
        }

        void stop() {
            stop = System.currentTimeMillis();
            if (titleObj == null) {
                log.debug(LogUtils.INTERNAL_MARKER, STOP, Long.toString(stop - start), title);
            } else {
                log.debug(LogUtils.INTERNAL_MARKER, STOP2, new Object[] { Long.toString(stop - start), title, titleObj });
            }
        }

        static final String START  = "START:{}";

        static final String START2 = "START:{}";

        static final String STOP   = "STOP: [{}] {}";

        static final String STOP2  = "STOP: [{}] {} {}";
    }

}
