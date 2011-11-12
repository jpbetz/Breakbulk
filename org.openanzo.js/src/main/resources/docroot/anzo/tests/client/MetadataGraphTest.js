/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 */

dojo.provide("anzo.tests.client.MetadataGraphTest");
dojo.require("anzo.client.MetadataGraph");
dojo.require("anzo.client.Vocabulary");

tests.register("anzo.tests.client.MetadataGraphTest", 
	[
		
		function test_MetadataGraphAllowsStatementsAboutTheGraphAndIgnoresOthers() {
		    // summary: The meatadata graph is a regular graph except that it only allows statements
		    //  to be added that are about the graph or meta graph.
		    
			
			var namedGraphUri = anzo.createURI('http://graph');
			var metaGraphUri  = anzo.utils.UriGenerator.getMetadataGraphUri(namedGraphUri);
			
			var graph = new anzo.client.MetadataGraph(metaGraphUri);
			
			graph.add(namedGraphUri, anzo.client.Vocabulary.lastModifiedByUserProperty, 'http://obj');
			graph.add(metaGraphUri, anzo.client.Vocabulary.createdByProperty, 'http://obj');
			graph.add('http://subj', anzo.client.Vocabulary.revisionProperty, 'http://obj');
			
            tests.assertEqual(2, graph.size());

		}
	]
);
