/*******************************************************************************
 * Copyright (c) 2007-2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */

dojo.provide("anzo.tests.client.LdapQueryTest");

dojo.require("anzo.client.ClientGraph");
dojo.require("anzo.client.AnzoClient");
dojo.require("anzo.tests.properties");
dojo.require("anzo.tests.utilities");
dojo.require("anzo.tests.client.TestData");
dojo.require("anzo.log");
dojo.require("anzo.client.Serialization");
dojo.require("anzo.client.Vocabulary");
dojo.require("anzo.rdf.vocabulary.RDF");

(function() {
var log = anzo.log.getLogger("anzo.tests.client.LdapQueryTest");

tests.register("anzo.tests.client.LdapQueryTest",
    [

        {
           name: "test_LdapQuery",
           timeout: 40000,
           setUp: function() {
           },
           runTest: function test_LdapQuery() {
                // summary: Testing that we can send a query directly to a particular datasource rather than to all of them.
                var TestData = new anzo.tests.client.TestData();
                var d = new doh.Deferred();
                var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties.sysadmin);

                log.debug("Connecting...");
                anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                    log.debug("Connected...");

                    // First we'll add some data to the main RDF store that would come back in the query
                    // we are about to ask. This lets us make sure that the data really only went to the specific data source
                    // rather than going to all of the datasources.
                    anzoClient.begin();
                    anzoClient.getReplicaGraph(TestData.graph1, null, d.getTestErrorWrapper(function namedGraphComplete(graph, error) {
                        log.debug("got replica graph");
                        var statement = anzo.createStatement(TestData.subj1, anzo.rdf.vocabulary.RDF.type, TestData.subj2);
                        graph.add(statement);
                        anzoClient.commit();

                        tests.assertTrue(graph.contains(statement));

                        var handle = dojo.connect(anzoClient, "updateRepositoryComplete", d.getTestErrorWrapper(function(success, errors) {
                            log.debug("Done updating repository.");
                            tests.assertTrue(success);
                            dojo.disconnect(handle);
                            handle = null;

                            var queryStr = 'select ?s ?o where { ?s a ?o }';
                            var options = {};
                            options[anzo.client.OPTION_DATASOURCE] = anzo.createURI("http://cambridgesemantics.com/datasource/ldap/openanzo");
                            anzoClient.serverQuery([anzo.client.Vocabulary.allNamedGraphsUri], null, null, queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
                                log.debug("query done...");
                                if (!success) {
                                    log.debug("Query execution failed: " + dojo.toJson(error));
                                }
                                log.debug("query successful...");
                                tests.assertTrue(success);
                                tests.assertTrue(msg != null);
                                log.debug("msg not null...")

                                // results
                                tests.assertTrue(msg.results != null);
                                
                                log.debug(dojo.toJson(msg.results));
                                tests.assertTrue(msg.results.bindings != null);
                                tests.assertTrue(msg.results.bindings[0] != null);

                                log.debug("Query results..");
                                var foundSysadmins = false;
                                var foundStatement = false;
                                var bindings = msg.results.bindings;
                                for (var i = 0; i < bindings.length; i++) {
                                    if (bindings[i].s.value == "ldap://cn=sysadmins,ou=groups,dc=openanzo,dc=org" && bindings[i].o.value == "http://xmlns.com/foaf/0.1/Group") {
                                        foundSysadmins = true;
                                    } else if (bindings[i].s.value == TestData.subj1.toString() && bindings[i].o.value == TestData.subj2.toString()) {
                                        foundStatement = true;
                                    }
                                    log.debug("s=" + bindings[i].s.value + "  " + "o=" + bindings[i].o.value);
                                }
                                tests.assertTrue(foundSysadmins);
                                tests.assertFalse(foundStatement); // We shouldn't have seen this statement since it was added to the main datasource not the LDAP datasource.

                                anzoClient.close(d.getTestErrorWrapper(function(status) {
                                    tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                    d.callback(true);
                                }));
                            }), options);
                        }));
                        anzoClient.updateRepository();
                    }));
                }));

                return d;
            }
        },

        {
            name: "test_ServerQuery_QueryWithNonsystemDatasourceIsNotCached",
            timeout: 40000,
            setUp: function() {
            },
            runTest: function test_ServerQuery_QueryWithNonsystemDatasourceIsNotCached() {
                // summary: Test that queries sent to another datasource aren't cached.
                //   Note: We reach into private state to check if the cache was used.
                
                 var TestData = new anzo.tests.client.TestData();
                
                 var d = new doh.Deferred();
             
                 var anzoClient = new anzo.client.AnzoClient(anzo.tests.properties.sysadmin);

                 var options = {};
                 options[anzo.client.OPTION_DATASOURCE] = anzo.createURI("http://cambridgesemantics.com/datasource/ldap/openanzo");

                 anzoClient.connect(d.getTestErrorWrapper(function connected(status, message) {
                     tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_CONNECTED);
                     
                     // First do a query against all graphs find the URI of a graph with some resource information.
                     // This query won't be cached since it goes against all graphs. We'll use that graph URI so that
                     // we can issue a query against the specific graph.
                     var queryStr = 'select ?g where { GRAPH ?g { ?s a ?o } }';
                     anzoClient.serverQuery(null, anzo.client.Vocabulary.allNamedGraphsUri, null, queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
                         log.debug("First query finished. success:" + success);
                         if (!success) {
                             log.debug("Query execution failed: " + dojo.toJson(error));
                         }
                         tests.assertTrue(success);
                         tests.assertTrue(msg != null);
 
                         // We expect this first query to have been a cache miss and for it not to have been cached
                         tests.assertEqual(0, anzoClient.queryService._cacheHits);
                         tests.assertEqual(1, anzoClient.queryService._cacheMisses);
                         tests.assertEqual(0, anzoClient.queryService._resultsCache.size());
 
                         log.debug("Graph URI discovered from initial all-graphs query:" + msg.results.bindings[0].g.value);
                         tests.assertTrue(msg.results.bindings[0].g.value != null);
                        
                         log.debug("About to send second query against the discovered graph.");
                        
                         // This query isn't against all graphs...but it is against a non-default datasource, so we are testing that it doesn't get cached.
                         var discoveredGraphUri = anzo.createURI(msg.results.bindings[0].g.value);
                         queryStr = 'select ?s where { ?s a ?o }';
                         anzoClient.serverQuery(discoveredGraphUri, null, null, queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
                             log.debug("Second query finished. success:" + success);
                             if (!success) {
                                 log.debug("Query execution failed: " + dojo.toJson(error));
                             }
                             tests.assertTrue(success);
                             tests.assertTrue(msg != null);
 
                             // We expect this second query to have also been a cache miss since the first query shouldn't have been cached due to it being against all-graphs
                             tests.assertEqual(0, anzoClient.queryService._cacheHits);
                             tests.assertEqual(2, anzoClient.queryService._cacheMisses);
                             tests.assertEqual(0, anzoClient.queryService._resultsCache.size());
                             
                             anzoClient.serverQuery(discoveredGraphUri, null, null, queryStr, null, d.getTestErrorWrapper(function(msg, success, error) {
                                 log.debug("Second query finished. success:" + success);
                                 if (!success) {
                                     log.debug("Query execution failed: " + dojo.toJson(error));
                                 }
                                 tests.assertTrue(success);
                                 tests.assertTrue(msg != null);
     
                                 // We expect this third query to have also been a cache miss since the second query shouldn't have been cached due to it using a non-default datasource.
                                 tests.assertEqual(0, anzoClient.queryService._cacheHits);
                                 tests.assertEqual(3, anzoClient.queryService._cacheMisses);
                                 tests.assertEqual(0, anzoClient.queryService._resultsCache.size());
                                 
                                 anzoClient.close(d.getTestErrorWrapper(function(status) {
                                     tests.assertTrue(status == anzo.messaging.CONNECTION_STATUS_DISCONNECTED);
                                     d.callback(true);
                                 }));
                             }), options);
                         }), options);
                     }), options);
                 }));
                 
                 return d;
             }
         }
    ]
);

})();
