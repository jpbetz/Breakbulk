/*******************************************************************************
 * Copyright (c) 2008-2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.openanzo.analysis.test;

import junit.framework.TestCase;

import org.openanzo.analysis.Profiler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class TestProfiler extends TestCase {

    private static final Logger   log  = LoggerFactory.getLogger(TestProfiler.class);

    private static final Profiler prof = new Profiler(log);

    /**
     * 
     * @throws Exception
     */
    public void testProfiler() throws Exception {

        prof.start("test profiler....");
        Thread.sleep(70);
        prof.start("test inner");
        Thread.sleep(100);
        prof.stop();
        prof.stop();
    }

}
