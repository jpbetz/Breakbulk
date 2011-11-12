/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

dojo.provide("anzo.tests.module");

try{
    // http://localhost:8080/openanzo-js/src/anzo/tests/runTests.html
    
    dojo.require("anzo.tests.log.module");
    dojo.require("anzo.tests.utils.module");
    dojo.require("anzo.tests.rdf.module");
    dojo.require("anzo.tests.client.module");
    dojo.require("anzo.tests.messaging.module");
    dojo.require("anzo.tests.profiling.module");

}catch(e){
    doh.debug(e);
}
