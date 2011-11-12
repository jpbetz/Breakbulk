/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.test.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.ClientGraph;
import org.openanzo.client.IStatementChannel;
import org.openanzo.client.IStatementChannelListener;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.execution.SemanticServiceExecutionService;
import org.openanzo.execution.echo.LongRunningServiceFactory;
import org.openanzo.ontologies.execution.JavaSemanticService;
import org.openanzo.ontologies.execution.JavascriptSemanticService;
import org.openanzo.ontologies.execution.SemanticServiceFactory;
import org.openanzo.ontologies.execution.StateStyleEnum;
import org.openanzo.ontologies.openanzo.Dataset;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.IQuadStore;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.MemQuadStore;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.test.Condition;
import org.openanzo.rdf.utils.test.TestUtilities;
import org.openanzo.rdf.utils.test.TestUtilities.TestData;
import org.openanzo.test.AbstractTest;

/**
 * Test semantic services
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 */
public class TestSemanticServiceExecution extends AbstractTest {

    static URI LOAD_SERVICES = Constants.valueFactory.createURI("http://openanzo.org/semanticServices/execution#loadServices");

    /**
     * Test executing the echo service
     * 
     * @throws Exception
     */
    public void testExecuteService() throws Exception {
        AnzoClient client = null;
        try {
            client = new AnzoClient(getSystemClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);

            final AnzoClient fClient = client;
            TestUtilities.waitFor(2000, new Condition() {
                @Override
                public boolean check() {
                    try {
                        URI serviceUri = Constants.valueFactory.createURI("http://openanzo.org/semanticServices/echoService#echo");
                        Set<Statement> statements = new HashSet<Statement>();
                        statements.add(TestData.stmt1);
                        statements.add(TestData.stmt2);
                        statements.add(TestData.stmt3);
                        statements.add(TestData.stmt4);
                        Collection<Statement> result = fClient.executeService(serviceUri, statements);
                        assertTrue(result.contains(TestData.stmt1));
                        assertTrue(result.contains(TestData.stmt2));
                        assertTrue(result.contains(TestData.stmt3));
                        assertTrue(result.contains(TestData.stmt4));
                        return true;
                    } catch (Exception e) {
                        //e.printStackTrace();
                        return false;
                    }
                }
            });

            URI serviceUri = Constants.valueFactory.createURI("http://openanzo.org/semanticServices/echoService#echo");
            Set<Statement> statements = new HashSet<Statement>();
            statements.add(TestData.stmt1);
            statements.add(TestData.stmt2);
            statements.add(TestData.stmt3);
            statements.add(TestData.stmt4);
            Collection<Statement> result = client.executeService(serviceUri, statements);
            assertTrue(result.contains(TestData.stmt1));
            assertTrue(result.contains(TestData.stmt2));
            assertTrue(result.contains(TestData.stmt3));
            assertTrue(result.contains(TestData.stmt4));

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test getting the count of how many times echo service has been run
     * 
     * @throws Exception
     */
    public void testExecuteServiceCount() throws Exception {
        AnzoClient client = null;
        try {
            client = new AnzoClient(getSystemClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);

            final AnzoClient fClient = client;
            TestUtilities.waitFor(10000, new Condition() {
                @Override
                public boolean check() {
                    try {
                        URI serviceUri = Constants.valueFactory.createURI("http://openanzo.org/semanticServices/echoService#count");

                        Collection<Statement> result = fClient.executeService(serviceUri, new HashSet<Statement>());
                        assertFalse(result.isEmpty());
                        Iterator<Statement> itr = result.iterator();
                        Statement stmt = itr.next();
                        while (!(stmt.getObject() instanceof Literal)) {
                            stmt = itr.next();
                        }
                        Literal lit = (Literal) stmt.getObject();
                        int count = Integer.parseInt(lit.getLabel());
                        assertEquals(1, count);
                        result = fClient.executeService(serviceUri, new HashSet<Statement>());
                        itr = result.iterator();
                        stmt = itr.next();
                        while (!(stmt.getObject() instanceof Literal)) {
                            stmt = itr.next();
                        }
                        lit = (Literal) stmt.getObject();
                        count = Integer.parseInt(lit.getLabel());
                        assertEquals(2, count);
                        result = fClient.executeService(serviceUri, new HashSet<Statement>());
                        itr = result.iterator();
                        stmt = itr.next();
                        while (!(stmt.getObject() instanceof Literal)) {
                            stmt = itr.next();
                        }
                        lit = (Literal) stmt.getObject();
                        count = Integer.parseInt(lit.getLabel());
                        assertEquals(3, count);
                        return true;
                    } catch (Exception e) {
                        //e.printStackTrace();
                        return false;
                    }
                }
            });

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test running a service without config
     * 
     * @throws Exception
     */
    public void testExecuteServiceMethodWithoutConfig() throws Exception {
        AnzoClient client = null;
        try {
            client = new AnzoClient(getSystemClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);

            final AnzoClient fClient = client;
            TestUtilities.waitFor(10000, new Condition() {
                @Override
                public boolean check() {
                    try {
                        URI serviceUri = Constants.valueFactory.createURI("http://openanzo.org/semanticServices/echoService#secret");

                        Collection<Statement> result = fClient.executeService(serviceUri, new HashSet<Statement>());
                        assertFalse(result.isEmpty());

                        Literal obj = (Literal) result.iterator().next().getObject();
                        assertEquals("secret", obj.getLabel());
                        return true;
                    } catch (Exception e) {
                        //e.printStackTrace();
                        return false;
                    }
                }
            });

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test to ensure that an exception is thrown if a service is called when the user doesn't have permission
     * 
     * @throws Exception
     */
    public void testExecuteServiceNoPermission() throws Exception {
        
        AnzoClient adminClient = null;
        try {
            adminClient = new AnzoClient(getSystemClientConfiguration());
            adminClient.connect();
            adminClient.reset(loadStatements("initialize.trig"), null);
            URI serviceUri = Constants.valueFactory.createURI("http://openanzo.org/semanticServices/echoService");
            adminClient.begin();
            ClientGraph graph = adminClient.getReplicaGraph(serviceUri);
            graph.getMetadataGraph().remove(graph.getMetadataGraph().find(serviceUri,NamedGraph.canBeReadByProperty,null));
            graph.getMetadataGraph().add(serviceUri,NamedGraph.canBeReadByProperty,Constants.valueFactory.createURI("http://openanzo.org/system/internal/sysadmin"));
            adminClient.commit();
            adminClient.updateRepository();
        } finally {
            if (adminClient != null) {
                adminClient.close();
            }
        }
        
        AnzoClient client = null;
        try {
            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            

            URI serviceUri = Constants.valueFactory.createURI("http://openanzo.org/semanticServices/echoService#echo");
            Set<Statement> statements = new HashSet<Statement>();
            statements.add(TestData.stmt1);
            statements.add(TestData.stmt2);
            statements.add(TestData.stmt3);
            statements.add(TestData.stmt4);
            boolean caught = false;
            try {
                client.executeService(serviceUri, statements);
            } catch (AnzoException e) {
                caught = true;
                assertEquals(ExceptionConstants.EXECUTION.UNKNOWN_SERVICE_ERROR, e.getErrorCode());
            }
            assertTrue(caught);

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test execution a long running service
     * 
     * @throws Exception
     */
    public void testExecuteLongRunningService() throws Exception {
        final AnzoClient client = new AnzoClient(getSystemClientConfiguration());
        try {
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);

            final URI activateUri = Constants.valueFactory.createURI("http://openanzo.org/semanticServices/longRunningService#activate");
            URI countUri = Constants.valueFactory.createURI("http://openanzo.org/semanticServices/longRunningService#count");
            final URI serviceUri = Constants.valueFactory.createURI("http://openanzo.org/semanticServices/longRunningService");

            // first configure the service in the registry
            // the factory will already be registered via OSGi
            client.begin();
            IDataset dataset = client.createServerDataset(true, SemanticServiceExecutionService.registryUri, null, null);
            JavaSemanticService javaService = SemanticServiceFactory.createJavaSemanticService(serviceUri, dataset);
            javaService.setServiceFactoryPid(LongRunningServiceFactory.class.getName());
            javaService.setStateStyle(StateStyleEnum.LongRunningStyle);
            client.commit();
            client.updateRepository();
            //
            final AnzoClient fClient = client;
            TestUtilities.waitFor(10000, new Condition() {
                @Override
                public boolean check() {
                    try {
                        return fClient.namedGraphExists(serviceUri);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                }
            });

            URI channelUri = Constants.valueFactory.createURI(serviceUri.toString() + "#channel");
            IStatementChannel channel = client.getStatementChannel(channelUri, AnzoClient.NON_REVISIONED_NAMED_GRAPH);
            client.updateRepository();
            final int[] count = new int[1];
            channel.registerListener(new IStatementChannelListener() {
                public void statementsReceived(Map<String, Object> messageProperties, Collection<Statement> statements) {
                    count[0]++;
                }

                public void channelClosed() {
                }
            });

            final Collection<Statement> result = new ArrayList<Statement>();
            TestUtilities.waitFor(10000, new Condition() {
                @Override
                public boolean check() {
                    try {
                        Collection<Statement> results = client.executeService(activateUri, new HashSet<Statement>());
                        result.addAll(results);
                        return true;
                    } catch (AnzoException ae) {
                        return false;
                    }
                }
            });
            assertFalse(result.isEmpty());
            Statement stmt = result.iterator().next();
            Literal literal = (Literal) stmt.getObject();
            String status = literal.getLabel();
            assertEquals("activationSuccessful", status);
            result.clear();
            Collection<Statement> results = client.executeService(activateUri, new HashSet<Statement>());
            assertFalse(results.isEmpty());
            stmt = results.iterator().next();
            literal = (Literal) stmt.getObject();
            status = literal.getLabel();
            assertEquals("alreadyActivated", status);

            client.executeService(countUri, new HashSet<Statement>());

            TestUtilities.waitFor(10000, new Condition() {
                @Override
                public boolean check() {
                    return count[0] == 1;
                }
            });

        } finally {
            client.close();
        }
    }

    /**
     * Test running a javascript service
     * 
     * @throws Exception
     */
    public void testExecuteJavascriptService() throws Exception {
        AnzoClient client = null;
        try {
            final URI serviceUri = Constants.valueFactory.createURI("http://openanzo.org/semanticServices/storageAndRetrieval");

            client = new AnzoClient(getSystemClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);

            // first configure the service in the registry
            // the factory will already be registered via OSGi
            client.begin();
            IDataset dataset = client.createServerDataset(true, SemanticServiceExecutionService.registryUri, null, null);
            JavascriptSemanticService javascriptService = SemanticServiceFactory.createJavascriptSemanticService(serviceUri, dataset);
            javascriptService.setScriptResource("/org/openanzo/execution/javascript/test/StorageAndRetrievalService.js");
            javascriptService.setStateStyle(StateStyleEnum.ConnectionStyle);
            client.commit();
            client.updateRepository();
            //

            //Thread.sleep(5000);
            final AnzoClient fClient = client;
            TestUtilities.waitFor(10000, new Condition() {
                @Override
                public boolean check() {
                    try {
                        URI operationUri = Constants.valueFactory.createURI("http://openanzo.org/semanticServices/storageAndRetrieval#storeStatements");
                        Set<Statement> statements = new HashSet<Statement>();
                        statements.add(TestData.stmt1);
                        statements.add(TestData.stmt2);
                        statements.add(TestData.stmt3);
                        statements.add(TestData.stmt4);
                        Collection<Statement> result = fClient.executeService(operationUri, statements);

                        operationUri = Constants.valueFactory.createURI("http://openanzo.org/semanticServices/storageAndRetrieval#retrieveStatements");
                        Set<URI> graphUris = new HashSet<URI>();
                        graphUris.add(TestData.stmt1.getNamedGraphUri());
                        graphUris.add(TestData.stmt2.getNamedGraphUri());
                        graphUris.add(TestData.stmt3.getNamedGraphUri());
                        graphUris.add(TestData.stmt4.getNamedGraphUri());
                        statements = new HashSet<Statement>();
                        for (URI uri : graphUris) {
                            statements.add(Constants.valueFactory.createStatement(operationUri, Dataset.namedGraphProperty, uri, uri));
                        }
                        result = fClient.executeService(operationUri, statements);
                        IQuadStore quadStore = new MemQuadStore();
                        quadStore.add(result);
                        assertTrue(result.contains(TestData.stmt1));
                        assertTrue(result.contains(TestData.stmt2));
                        assertTrue(result.contains(TestData.stmt3));
                        assertTrue(result.contains(TestData.stmt4));
                        return true;
                    } catch (Exception e) {
                        //e.printStackTrace();
                        return false;
                    }
                }
            });

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

}
