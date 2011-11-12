/*******************************************************************************
 * Copyright (c) 2008-2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.openanzo.analysis;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.AsyncContinuation;
import org.eclipse.jetty.server.Request;
import org.openanzo.exceptions.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter that profiles servlets
 */
public class ProfilingServletFilter implements Filter {

    private static final Logger log                          = LoggerFactory.getLogger(ProfilingServletFilter.class);

    /** Attribute for the start time for a request */
    private static final String START_TIME_REQUEST_ATTRIBUTE = "org.openanzo.analysis.ProfilingServletFilter.requestStartTime";

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        doFilter((HttpServletRequest) request, (HttpServletResponse) response, chain);
    }

    private void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String did = request.getHeader("debugid");
        String ctime = request.getHeader("clientTime");
        response.setHeader("debugid", did);

        Long requestStartTime = (Long) request.getAttribute(START_TIME_REQUEST_ATTRIBUTE);
        if (requestStartTime == null) {
            // We haven't seen this request before so we'll set the time at which we first saw the request
            Long now = System.currentTimeMillis();
            request.setAttribute(START_TIME_REQUEST_ATTRIBUTE, now);
            if (log.isDebugEnabled()) {
                log.debug(LogUtils.LIFECYCLE_MARKER, "START CometD Servlet Request (" + did + ") start time: " + now + " (client sent time: " + ctime + ")");
            }
            requestStartTime = now;
        }

        try {
            chain.doFilter(request, response);
        } finally {

            // If this is truly the end of processing this request, then output the time information
            // about how long the request took. Just because we are here doesn't mean we are
            // done with this request. The request could have been suspended with a Jetty Continuation.
            // We must ignore any 'suspended' requests at this point. We'll see that request again once
            // it's resumed.
            boolean completedRequest = true;
            if (request instanceof Request) {
                Request jettyRequest = (Request) request;
                AsyncContinuation continuation = jettyRequest.getAsyncContinuation();
                if (continuation != null && continuation.isSuspended()) {
                    completedRequest = false;
                }
            }
            if (completedRequest) {
                if (log.isDebugEnabled()) {
                    long now = System.currentTimeMillis();
                    long duration = now - requestStartTime;
                    log.debug(LogUtils.LIFECYCLE_MARKER, "STOP [" + duration + "] CometD Servlet Request (" + did + ") stop time:" + now);
                }
                response.setHeader("serverTime", String.valueOf(System.currentTimeMillis()));
            }
        }
    }

}
