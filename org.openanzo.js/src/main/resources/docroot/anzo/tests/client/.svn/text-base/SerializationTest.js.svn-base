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

/*
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */

dojo.provide("anzo.tests.client.SerializationTest");
dojo.require("anzo.client.Serialization");
dojo.require("anzo.client.TransactionQueue");
dojo.require("anzo.client.TransactionProxy");
dojo.require("anzo.client.Vocabulary");
dojo.require("anzo.rdf.vocabulary.RDF");
dojo.require("anzo.utils.JSUtil");
dojo.require("anzo.rdf.Statement");
dojo.require("anzo.client.Precondition");
dojo.require("anzo.tests.utilities");

tests.register("anzo.tests.client.SerializationTest", 
	[
		function test_writeStatementsToJson() {
			var rand = 50;
			var ng = anzo.createURI("http://openanzo.org/metadataGraphs/" + rand);
			var sub = anzo.createURI("http://openanzo.org/namedGraphs/defaultNamedGraph/" + rand);
			var pred1 = anzo.client.Vocabulary.hasMetadataGraphProperty;
			var obj1 = ng;
			var pred2 = anzo.rdf.vocabulary.RDF.type;
			var obj2 = anzo.client.Vocabulary.namedGraphType;
		    
		    var person = anzo.createURI("http://xmlns.com/foaf/0.1/Person");
		    var foafname = anzo.createURI("http://xmlns.com/foaf/0.1/name");

			var stmt1 = anzo.createStatement(sub,pred1,obj1,ng);
			var stmt2 = anzo.createStatement(sub,pred2,obj2,ng);
			var stmt3 = anzo.createStatement(sub,anzo.rdf.vocabulary.RDF.type,person, ng);
			var stmt4 = anzo.createStatement(sub,foafname,'Ben', ng);
			
			var store = new anzo.rdf.QuadStore();
			store.add(stmt1);
			store.add(stmt2);
			store.add(stmt3);
			store.add(stmt4);
			
			var stmts = store.find();
			var json = anzo.client.Serialization.writeStatementsToJson(stmts);
			
			//doh.debug(dojo.toJson(json));
			//doh.debug(dojo.toJson(anzo.tests.client.expectedStatements));
			
			// Ignore the order of the JSON statements array when comparing since the order isn't 
			// important and may differ between Rhino and Browsers.
			var wrapper = { unordered : json };
			tests.assertTrue(anzo.tests.utilities.deepCompareJSONObjects(wrapper, anzo.tests.client.expectedStatements, [], [ "unordered" ]));
		},
		
		function test_writeTransactionsToJson() {
			var rand = 50;
			var ng = anzo.createURI("http://openanzo.org/metadataGraphs/" + rand);
			var sub = anzo.createURI("http://openanzo.org/namedGraphs/defaultNamedGraph/" + rand);
			var pred1 = anzo.client.Vocabulary.hasMetadataGraphProperty;
			var obj1 = ng;
			var pred2 = anzo.rdf.vocabulary.RDF.type;
			var obj2 = anzo.client.Vocabulary.namedGraphType;
		    
		    var person = anzo.createURI("http://xmlns.com/foaf/0.1/Person");
		    var foafname = anzo.createURI("http://xmlns.com/foaf/0.1/name");

		 
			var stmt1 = anzo.createStatement(sub,pred1,obj1,ng);
			var stmt2 = anzo.createStatement(sub,pred2,obj2,ng);
			var stmt3 = anzo.createStatement(sub,anzo.rdf.vocabulary.RDF.type,person, ng);
			var stmt4 = anzo.createStatement(sub,foafname,'Ben', ng);
			
			var quadStore = new anzo.rdf.QuadStore();
			var transactionQueue = new anzo.client.TransactionQueue();
			
			var askQueryString = "ASK { <" + sub + "> <" + pred1 + "> <" + obj1 + ">}";
			var askResult = false;
			var defaultGraphUris = [];
			var namedGraphUris = [sub];
			
			var precondition = new anzo.client.Precondition(askQueryString, askResult, namedGraphUris, defaultGraphUris);
			
			transactionQueue.begin(precondition);
			var store = new anzo.client.TransactionProxy(quadStore, transactionQueue);
			
			store.add(stmt1);
			store.add(stmt2);
			store.add(stmt3);
			store.add(stmt4);
			
			transactionQueue.commit();
			
			var transactions = transactionQueue.committedTransactions;
			
			var json = anzo.client.Serialization.writeTransactionsToJson(transactions);
			
			//doh.debug(dojo.toJson(json));
			//doh.debug(dojo.toJson(anzo.tests.client.expectedTransactions));
			
			// Ignore the order of the Addition and Deletion arrays when comparing since the order isn't 
			// important and may differ between Rhino and Browsers.
			tests.assertTrue(anzo.tests.utilities.deepCompareJSONObjects(json, anzo.tests.client.expectedTransactions, ["transactionURI"], ["namedGraphs", "defaultNamedGraphs", "preconditions", "additions", "removals", "metaAdditions", "metaRemovals"]));
		},
		
		function test_convertToListAddsDelimiterWhenMoreThanOneValue() {
		    var list = [ "itemOne", "item two"];
		    var str = anzo.client.Serialization.convertToList(list);
		    tests.assertEqual("itemOne"+anzo.client.Serialization.TEXT_DELIM+"item two", str);
		},

		function test_convertToListDoesNotAddDelimiterWhenSingleValue() {
		    var list = [ "item one" ];
		    var str = anzo.client.Serialization.convertToList(list);
		    tests.assertEqual("item one", str);
		}

	]
);

anzo.tests.client.expectedStatements = { unordered : [{"namedGraphUri": "http://openanzo.org/metadataGraphs/50", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/50"}, "predicate": "http://openanzo.org/ontologies/2008/07/Anzo#hasMetadataGraph", "object": {"objectType": "uri", "value": "http://openanzo.org/metadataGraphs/50"}}, {"namedGraphUri": "http://openanzo.org/metadataGraphs/50", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/50"}, "predicate": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "object": {"objectType": "uri", "value": "http://openanzo.org/ontologies/2008/07/Anzo#NamedGraph"}}, {"namedGraphUri": "http://openanzo.org/metadataGraphs/50", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/50"}, "predicate": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "object": {"objectType": "uri", "value": "http://xmlns.com/foaf/0.1/Person"}}, {"namedGraphUri": "http://openanzo.org/metadataGraphs/50", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/50"}, "predicate": "http://xmlns.com/foaf/0.1/name", "object": {"objectType": "literal", "value": "Ben"}}] };
anzo.tests.client.expectedTransactions = [{"transactionURI": "http://openanzo.org/namedGraphs//47078904-8f11-49b9-8219-8b9a7f4453f2", "preconditions": [{"namedGraphs": ["http://openanzo.org/namedGraphs/defaultNamedGraph/50"], "defaultNamedGraphs": [], "query": {"queryString": "ASK { <http://openanzo.org/namedGraphs/defaultNamedGraph/50> <http://openanzo.org/ontologies/2008/07/Anzo#hasMetadataGraph> <http://openanzo.org/metadataGraphs/50>}", "askQueryResult": false}}], "namedGraphs": [{"namedGraphUri": "/50", "revision": 0, "additions": [], "removals": [], "metaAdditions": [{"namedGraphUri": "http://openanzo.org/metadataGraphs/50", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/50"}, "predicate": "http://openanzo.org/ontologies/2008/07/Anzo#hasMetadataGraph", "object": {"objectType": "uri", "value": "http://openanzo.org/metadataGraphs/50"}}, {"namedGraphUri": "http://openanzo.org/metadataGraphs/50", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/50"}, "predicate": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "object": {"objectType": "uri", "value": "http://openanzo.org/ontologies/2008/07/Anzo#NamedGraph"}}, {"namedGraphUri": "http://openanzo.org/metadataGraphs/50", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/50"}, "predicate": "http://www.w3.org/1999/02/22-rdf-syntax-ns#type", "object": {"objectType": "uri", "value": "http://xmlns.com/foaf/0.1/Person"}}, {"namedGraphUri": "http://openanzo.org/metadataGraphs/50", "subject": {"objectType": "uri", "value": "http://openanzo.org/namedGraphs/defaultNamedGraph/50"}, "predicate": "http://xmlns.com/foaf/0.1/name", "object": {"objectType": "literal", "value": "Ben"}}], "metaRemovals": []}]}];
