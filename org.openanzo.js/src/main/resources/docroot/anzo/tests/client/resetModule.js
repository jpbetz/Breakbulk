/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Oct 10, 2007
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/


dojo.provide("anzo.tests.client.resetModule");

try {
    
    // http://localhost:8080/openanzo-js/src/anzo/tests/client/reset.html

    if (!dojo.isRhino) {
		dojo.require("anzo.tests.client.ResetTest");
    }
} catch(e) {
    doh.debug(e);
}
