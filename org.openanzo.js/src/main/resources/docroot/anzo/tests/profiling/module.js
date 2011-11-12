/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

dojo.provide("anzo.tests.profiling.module");

try {
    
    // http://localhost:8080/openanzo-js/anzo/tests/profiling/runTests.html

    if (!dojo.isRhino) {
        dojo.require("anzo.tests.profiling.ProfilingTest");
    }
    
} catch(e) {
    doh.debug(e);
}
