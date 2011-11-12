/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jul 15, 2008
 * Revision:    $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.servlet.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Regression control servlet.
 * 
 * Simple Servlet used only during regression tests to kill the server process as well as to run specific tests.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * @author Jordi Albornoz Mulligan ( <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 * 
 */
public class ControlServlet extends HttpServlet {

    private static final Logger log                                = LoggerFactory.getLogger(ControlServlet.class);

    public static final String  OPERATION_URI_SUFFIX_COUNTER_RESET = "counterReset";

    public static final String  OPERATION_URI_SUFFIX_COUNTER_READ  = "counterRead";

    private static final long   serialVersionUID                   = 1L;

    /**
     * Counter which can be incremented, read, and reset by regression tests. This is typically used to test whether a request actually reached the intended
     * servlet. This is useful for testing authenticators and some filters. Make sure you acquire the counterLock before reading or writing this.
     */
    private int                 counter                            = 0;

    private Object              counterLock                        = new Object();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("handling client request: {}", req.getPathInfo());
        // for now, the only control is to shutdown the running server
        String path = req.getPathInfo();

        int responseStatus = HttpServletResponse.SC_OK;
        String outputString = "Unknown command sent to 'control' servlet. Command: " + path;

        if (path.endsWith("kill")) {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getOutputStream().flush();
            resp.getOutputStream().close();
            System.exit(0);
        } else if (path.endsWith(OPERATION_URI_SUFFIX_COUNTER_READ)) {
            synchronized (counterLock) {
                outputString = Integer.toString(counter);
            }
        } else if (path.endsWith(OPERATION_URI_SUFFIX_COUNTER_RESET)) {
            synchronized (counterLock) {
                counter = 0;
                outputString = Integer.toString(counter);
            }
        } else {
            // For any other kind of access to this servlet, increment the counter
            synchronized (counterLock) {
                counter++;
                outputString = Integer.toString(counter);
            }

        }

        resp.setStatus(responseStatus);
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw = null;
        try {
            pw = resp.getWriter();
            pw.write(outputString);
        } finally {
            if (pw != null) {
                pw.close();
                pw = null;
            }
        }

    }
}
