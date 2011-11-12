/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.exceptions;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * Set of utility methods to log information about the running system
 * 
 * @author
 * 
 */
public class LogUtils {
    /** Security Marker */
    public static final Marker SECURITY_MARKER        = MarkerFactory.getMarker("security");

    /** Config Marker */
    public static final Marker LIFECYCLE_MARKER       = MarkerFactory.getMarker("services");

    /** Combus Marker */
    public static final Marker COMBUS_MARKER          = MarkerFactory.getMarker("combus");

    /** Datasource Marker */
    public static final Marker DATASOURCE_MARKER      = MarkerFactory.getMarker("datasource");

    /** Execution Marker */
    public static final Marker EXECUTION_MARKER       = MarkerFactory.getMarker("execution");

    /** RDB Marker */
    public static final Marker RDB_MARKER             = MarkerFactory.getMarker("rdb");

    /** Binary Marker */
    public static final Marker BINARY_MARKER          = MarkerFactory.getMarker("binarystore");

    /** Internal Server Log Marker */
    public static final Marker SERVER_INTERNAL_MARKER = MarkerFactory.getMarker("server");

    /** Client Log Marker */
    public static final Marker INTERNAL_MARKER        = MarkerFactory.getMarker("internal");

    /** Client Log Marker */
    public static final Marker GLITTER_MARKER         = MarkerFactory.getMarker("internal");

    /** Timing Log Marker */
    public static final Marker TIMING_MARKER          = MarkerFactory.getMarker("timing");

    /** remote address attribute */
    public static final String REMOTE_ADDRESS         = "remoteAddress";

    /** userid attribute */
    public static final String USER                   = "userId";

}
