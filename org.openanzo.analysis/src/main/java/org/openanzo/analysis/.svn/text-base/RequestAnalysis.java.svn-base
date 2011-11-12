/*******************************************************************************
 * Copyright (c) 2008-2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.openanzo.analysis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Analysis of requests
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public class RequestAnalysis {
    /** Recorder is Enabled property */
    public static final String                      CONTEXT_PROP_RECORDER_ENABLED = "recorderAnalysisEnabled";

    /** Request Analysis is Enabled property */
    public static final String                      CONTEXT_PROP_REQUEST_ENABLED  = "requestAnalysisEnabled";

    /** Analysis property prefix */
    public static final String                      ANS_PROP_PREFIX               = "ans_";

    /** Cache Hit property */
    public static final String                      ANS_PROP_CACHE_HIT            = "ans_cacheHit";

    /** Dataset cache hit property */
    public static final String                      ANS_PROP_DATASET_CACHE_HIT    = "ans_datasetCacheHit";

    /** Operation time property */
    public static final String                      ANS_PROP_OPERATION_TIME       = "ans_operationTime";

    private static Map<Thread, Map<String, Object>> atts                          = new HashMap<Thread, Map<String, Object>>();

    private static final Logger                     analysisLogger                = LoggerFactory.getLogger("AnalysisLogger");

    /**
     * Set the current context to a thread local
     * 
     * @param contextAttributes
     *            attributes of current context
     */
    public static void setCurrentContext(Map<String, Object> contextAttributes) {
        atts.put(Thread.currentThread(), contextAttributes);
    }

    private static Map<String, Object> getCurrentContext() {
        return atts.get(Thread.currentThread());
    }

    /**
     * @return the logger used for Analysis
     */
    public static Logger getAnalysisLogger() {
        return analysisLogger;
    }

    /**
     * Is analysis enabled
     * 
     * @param contextAttributes
     *            attributes of current context
     * @return true if analysis is enabled
     */
    public static boolean isAnalysisEnabled(Map<String, Object> contextAttributes) {
        if (contextAttributes == null) {
            contextAttributes = getCurrentContext();
        }
        if (contextAttributes == null) {
            return false;
        }
        return (contextAttributes.get(CONTEXT_PROP_RECORDER_ENABLED) != null && ((Boolean) contextAttributes.get(CONTEXT_PROP_RECORDER_ENABLED))) || (contextAttributes.get(CONTEXT_PROP_REQUEST_ENABLED) != null && ((Boolean) contextAttributes.get(CONTEXT_PROP_REQUEST_ENABLED)));
    }

    /**
     * is analysis enabled for current thread
     * 
     * @return true if analysis enabled
     */
    public static boolean isAnalysisEnabled() {
        return isAnalysisEnabled(null);
    }

    /**
     * Set if recorder is enabled
     * 
     * @param enabled
     *            true if analysis is enabled
     */
    public static void setRecorderAnalysisEnabled(boolean enabled) {
        Map<String, Object> contextAttributes = getCurrentContext();
        contextAttributes.put(CONTEXT_PROP_RECORDER_ENABLED, enabled);
    }

    /**
     * Set if request analysis is enabled
     * 
     * @param enabled
     *            true if request analysis is enabled
     */
    public static void setRequestAnalysisEnabled(boolean enabled) {
        Map<String, Object> contextAttributes = getCurrentContext();
        contextAttributes.put(CONTEXT_PROP_REQUEST_ENABLED, enabled);
    }

    /**
     * Add analysis property
     * 
     * @param name
     *            name of analysis property
     * @param value
     *            value of property
     */
    public static void addAnalysisProperty(String name, Object value) {
        Map<String, Object> contextAttributes = getCurrentContext();
        if (name.startsWith(ANS_PROP_PREFIX)) {
            if (value == null) {
                contextAttributes.remove(name);
            } else {
                contextAttributes.put(name, value);
            }
        } else {
            if (value == null) {
                contextAttributes.remove(ANS_PROP_PREFIX + name);
            } else {
                contextAttributes.put(ANS_PROP_PREFIX + name, value);
            }
        }
    }

    /**
     * Increment the value of a counter property
     * 
     * @param name
     *            name of analysis property
     * @param inc
     *            amount to increment
     */
    public static void incrementAnalysisPropertyCount(String name, long inc) {
        Long count = (Long) getAnalysisProperty(name);
        if (count == null) {
            count = inc;
        } else {
            count += inc;
        }
        addAnalysisProperty(name, count);
    }

    /**
     * Get analysis property names
     * 
     * @return analysis property names
     */
    public static Set<String> getAnalysisPropertyNames() {
        Map<String, Object> contextAttributes = getCurrentContext();
        HashSet<String> names = new HashSet<String>();
        if (contextAttributes == null) {
            return names;
        }
        for (String name : contextAttributes.keySet()) {
            if (name.startsWith(RequestAnalysis.ANS_PROP_PREFIX)) {
                names.add(name);
            }
        }
        return names;
    }

    /**
     * Get analysis property
     * 
     * @param name
     *            name of property to get
     * @return value of analysis property
     */
    public static Object getAnalysisProperty(String name) {
        Map<String, Object> contextAttributes = getCurrentContext();
        return contextAttributes.get((name.startsWith(ANS_PROP_PREFIX) ? "" : ANS_PROP_PREFIX) + name);
    }

}
