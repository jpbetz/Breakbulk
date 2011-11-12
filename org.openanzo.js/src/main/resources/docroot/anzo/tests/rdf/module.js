/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

dojo.provide("anzo.tests.rdf.module");

try{
	
	/*
	 http://localhost:8080/openanzo-js/src/anzo/tests/rdf/runTests.html
	 */

    dojo.require("anzo.tests.rdf.parser.TabulatorParserTest");
    dojo.require("anzo.tests.rdf.parser.NTripleParserTest");
    dojo.require("anzo.tests.rdf.serializer.NTripleSerializerTest");

    dojo.require("anzo.tests.rdf.DeltaGraphTest");
    dojo.require("anzo.tests.rdf.StatementTest");
    dojo.require("anzo.tests.rdf.NamedGraphTest");
    dojo.require("anzo.tests.rdf.QuadStoreTest"); 
    dojo.require("anzo.tests.rdf.GraphResourceTest");
    dojo.require("anzo.tests.rdf.DatasetTest");

}catch(e){
	doh.debug(e);
}
