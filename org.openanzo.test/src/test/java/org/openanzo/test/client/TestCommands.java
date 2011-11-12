/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.test/src/com/ibm/adtech/boca/test/client/TestCommands.java,v $
 * Created by:  Rouben Meschian (<a href="mailto:rmeschi@us.ibm.com">rmeschi@us.ibm.com</a>)
 * Created on:  9/22/2006
 * Revision:	$Id: TestCommands.java 171 2007-07-31 14:11:17Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.test.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.ClientGraph;
import org.openanzo.client.command.Command;
import org.openanzo.client.command.CommandChain;
import org.openanzo.client.command.CommandManager;
import org.openanzo.client.command.ICommand;
import org.openanzo.client.command.ICommandListener;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.ontologies.command.CommandFactory;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.test.Condition;
import org.openanzo.rdf.utils.test.TestUtilities;
import org.openanzo.rdf.utils.test.TestUtilities.TestData;
import org.openanzo.services.IPrecondition;
import org.openanzo.services.impl.Precondition;
import org.openanzo.test.AbstractTest;

/**
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public class TestCommands extends AbstractTest {

    final URI GRAPH_URI = Constants.valueFactory.createURI("http://graph1");

    /**
     * Test a single command
     * 
     * @throws Exception
     */
    public void testSingleCommand() throws Exception {
        AnzoClient client = null;
        try {

            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            final ClientGraph graph = client.getReplicaGraph(TestData.graph1);
            client.updateRepository();

            ICommand addCommand = new Command() {
                public Object execute() {
                    graph.add(TestData.stmt1);
                    graph.add(TestData.stmt2);
                    return null;
                }

                @Override
                public URI getCommandType() {
                    return CommandManager.getBasicCommandType("addCommand");
                }
            };

            CommandManager manager = new CommandManager(client);

            class CommandListener implements ICommandListener {

                int ccount = 0;

                int xcount = 0;

                URI type   = null;

                public void commandCompleted(URI commandType, INamedGraph commandContext) {
                    ccount++;
                    xcount += commandContext.size();
                    type = commandType;
                }

                public void commandFailed(URI commandType, INamedGraph commandContext, List<AnzoException> errors) {

                }
            }

            final CommandListener listener = new CommandListener();
            manager.registerCommandListener(listener);
            manager.execute(addCommand);
            client.updateRepository();

            TestUtilities.waitForStatement(5000, graph, TestData.stmt1, true);
            TestUtilities.waitForStatement(5000, graph, TestData.stmt2, true);

            assertTrue(graph.contains(TestData.stmt1));
            assertTrue(graph.contains(TestData.stmt2));

            TestUtilities.waitFor(5000, new Condition() {
                @Override
                public boolean check() {
                    return listener.ccount == 1;
                }
            });

            assertEquals(1, listener.ccount);

            TestUtilities.waitFor(5000, new Condition() {
                @Override
                public boolean check() {
                    return listener.xcount == 2;
                }
            });

            assertEquals(2, listener.xcount);
            assertEquals(addCommand.getCommandType(), listener.type);

        } finally {
            if (client != null) {
                client.close();
            }
        }

    }

    /**
     * Test a basic command chain
     * 
     * @throws Exception
     */
    public void testCommandChain() throws Exception {

        AnzoClient client = null;
        try {

            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            final ClientGraph graph = client.getReplicaGraph(TestData.graph1);
            client.updateRepository();

            ICommand addCommand = new Command() {

                public Object execute() {
                    graph.add(TestData.stmt1);
                    graph.add(TestData.stmt2);
                    return TestData.stmt3;
                }

                @Override
                public URI getCommandType() {
                    return CommandManager.getBasicCommandType("addCommand");
                }

            };

            ICommand addCommand2 = new Command() {

                public Object execute() {
                    graph.add((Statement) getInputProperty("stmt"));
                    return null;
                }

                @Override
                public URI getCommandType() {
                    return CommandManager.getBasicCommandType("addCommand2");
                }

            };

            CommandManager manager = new CommandManager(client);

            CommandChain chain = manager.createCommandChain();
            chain.addCommand(addCommand);
            chain.addCommand(addCommand2);
            chain.linkCommand(addCommand2, "stmt", addCommand);

            class CommandListener implements ICommandListener {

                int            ccount = 0;

                int            xcount = 0;

                ArrayList<URI> types  = new ArrayList<URI>();

                public void commandCompleted(URI commandType, INamedGraph commandContext) {
                    ccount++;
                    xcount += commandContext.size();
                    types.add(commandType);
                }

                public void commandFailed(URI commandType, INamedGraph commandContext, List<AnzoException> errors) {

                }

            }

            final CommandListener listener = new CommandListener();
            manager.registerCommandListener(listener);
            manager.execute(chain);
            client.updateRepository();

            assertTrue(graph.contains(TestData.stmt1));
            assertTrue(graph.contains(TestData.stmt2));
            assertTrue(graph.contains(TestData.stmt3));

            TestUtilities.waitFor(5000, new Condition() {
                @Override
                public boolean check() {
                    // 2 context statements for each command
                    return listener.xcount == 6;
                }
            });

            assertEquals(6, listener.xcount);

            TestUtilities.waitFor(5000, new Condition() {
                @Override
                public boolean check() {
                    return listener.ccount == 3;
                }
            });

            assertEquals(3, listener.ccount);

            assertTrue(listener.types.contains(addCommand.getCommandType()));
            assertTrue(listener.types.contains(addCommand2.getCommandType()));

        } finally {
            if (client != null) {
                client.close();
            }
        }

    }

    /**
     * Test command events
     * 
     * @throws Exception
     */
    public void testCommandEvents() throws Exception {

        AnzoClient client1 = null;
        AnzoClient client2 = null;
        try {

            client1 = new AnzoClient(getDefaultClientConfiguration());

            client2 = new AnzoClient(getDefaultClientConfiguration());

            client1.connect();
            client1.reset(loadStatements("initialize.trig"), null);
            client2.connect();

            ClientGraph replicaGraph1 = client1.getReplicaGraph(TestData.graph1);
            client1.updateRepository();

            final int[] ccount = new int[3];
            final int[] xcount = new int[3];

            class CommandListener implements ICommandListener {

                int ind = 0;

                CommandListener(int ind) {
                    this.ind = ind;
                }

                public void commandCompleted(URI commandType, INamedGraph commandContext) {
                    ccount[ind]++;
                    xcount[ind] += commandContext.size();
                }

                public void commandFailed(URI commandType, INamedGraph commandContext, List<AnzoException> errors) {

                }

            }

            CommandManager manager = new CommandManager(client1);

            manager.registerCommandListener(new CommandListener(0));
            manager.registerCommandListener(new CommandListener(1), CommandManager.getBasicCommandType("command1"));
            manager.registerCommandListener(new CommandListener(2), CommandManager.getBasicCommandType("badtype"));

            client1.begin();

            INamedGraph contextGraph = client1.getTransactionContext();
            org.openanzo.ontologies.command.Command owlCommand = CommandFactory.createCommand(contextGraph.getNamedGraphUri(), contextGraph);
            owlCommand.setCommandType(CommandManager.getBasicCommandType("command1"));

            replicaGraph1.add(TestData.stmt1);
            client1.commit();
            client1.updateRepository();

            TestUtilities.waitFor(5000, new Condition() {
                @Override
                public boolean check() {
                    return ccount[0] == 1 && xcount[0] == 2 && ccount[1] == 1 && xcount[1] == 2 && ccount[2] == 0 && xcount[2] == 0;
                }
            });

            assertEquals(1, ccount[0]);
            assertEquals(2, xcount[0]);
            assertEquals(1, ccount[1]);
            assertEquals(2, xcount[1]);
            assertEquals(0, ccount[2]);
            assertEquals(0, xcount[2]);
        } finally {
            if (client1 != null)
                client1.close();
            if (client2 != null)
                client2.close();
        }
    }

    /**
     * Test command preconditions.
     * 
     * @throws Exception
     */
    public void testCommandPrecondition() throws Exception {
        AnzoClient client = null;
        try {
            final Statement stmt0 = Constants.valueFactory.createStatement(createTestUri("subject0"), createTestUri("predicate0"), createTestUri("object0"));
            final Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"));
            final Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject2"), createTestUri("predicate2"), createTestUri("object2"));
            final Statement stmt3 = Constants.valueFactory.createStatement(createTestUri("subject3"), createTestUri("predicate3"), createTestUri("object3"));
            final Statement stmt4 = Constants.valueFactory.createStatement(createTestUri("subject4"), createTestUri("predicate4"), createTestUri("object4"));
            Properties props = new Properties(System.getProperties());
            props.putAll(getProperties());

            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            CommandManager manager = new CommandManager(client);

            final ClientGraph clientGraph = client.getReplicaGraph(GRAPH_URI);
            client.updateRepository();

            Command command1 = new Command() {

                public Object execute() {
                    clientGraph.add(stmt1);
                    return null;
                }
            };
            Command command2 = new Command() {

                public Object execute() {
                    clientGraph.add(stmt2);
                    return null;
                }
            };
            Command command3 = new Command() {

                public Object execute() {
                    clientGraph.add(stmt3);
                    return null;
                }
            };
            Command command4 = new Command() {

                public Object execute() {
                    clientGraph.add(stmt4);
                    return null;
                }
            };
            clientGraph.add(stmt0);
            client.updateRepository();

            // ---------------------------------------------------------------------------
            // Test using default graphs with a valid preconditon query
            IPrecondition precondition = new Precondition();
            precondition.setDefaultGraphUris(Collections.singleton(clientGraph.getNamedGraphUri()));
            precondition.setQuery("ASK  { <" + stmt0.getSubject() + "> <" + stmt0.getPredicate() + "> <" + stmt0.getObject() + "> }");
            command1.addPrecondition(precondition);

            manager.execute(command1);

            client.updateRepository();
            assertTrue(clientGraph.contains(stmt1));
            assertFalse(clientGraph.contains(stmt2));

            // ---------------------------------------------------------------------------
            // Test using default graphs with an invalid preconditon query
            IPrecondition precondition2 = new Precondition();
            precondition2.setDefaultGraphUris(Collections.singleton(clientGraph.getNamedGraphUri()));
            precondition2.setQuery("ASK  { <" + stmt2.getSubject() + "> <" + stmt1.getPredicate() + "> <" + stmt1.getObject() + "> }");
            command2.addPrecondition(precondition2);

            manager.execute(command2);
            boolean threwException = false;
            try {
                client.updateRepository();
            } catch (Exception e) {
                threwException = true;
            }
            assertTrue(threwException);
            assertTrue(clientGraph.contains(stmt1));
            assertFalse(clientGraph.contains(stmt2));

            // ---------------------------------------------------------------------------
            // Test using named graphs with a valid preconditon query
            IPrecondition precondition3 = new Precondition();
            precondition3.setNamedGraphUris(Collections.singleton(clientGraph.getNamedGraphUri()));
            precondition3.setQuery("ASK  WHERE { GRAPH ?g { <" + stmt0.getSubject() + "> <" + stmt0.getPredicate() + "> <" + stmt0.getObject() + "> } }");
            command3.addPrecondition(precondition3);
            manager.execute(command3);
            client.updateRepository();
            assertTrue(clientGraph.contains(stmt1));
            assertFalse(clientGraph.contains(stmt2));
            assertTrue(clientGraph.contains(stmt3));

            // ---------------------------------------------------------------------------
            // Test using named graphs with an invalid preconditon query
            IPrecondition precondition4 = new Precondition();
            precondition4.setNamedGraphUris(Collections.singleton(clientGraph.getNamedGraphUri()));
            precondition4.setQuery("ASK  WHERE { GRAPH ?g { <" + stmt4.getSubject() + "> <" + stmt4.getPredicate() + "> <" + stmt4.getObject() + "> } }");
            command4.addPrecondition(precondition4);
            manager.execute(command4);
            threwException = false;
            try {
                client.updateRepository();
            } catch (Exception e) {
                threwException = true;
            }
            assertTrue(threwException);
            assertTrue(clientGraph.contains(stmt1));
            assertFalse(clientGraph.contains(stmt2));
            assertTrue(clientGraph.contains(stmt3));
            assertFalse(clientGraph.contains(stmt4));
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test preconditions with chain commands.
     * 
     * @throws Exception
     */
    public void testCommandChainPrecondition() throws Exception {
        AnzoClient client = null;
        try {
            final Statement stmt0 = Constants.valueFactory.createStatement(createTestUri("subject0"), createTestUri("predicate0"), createTestUri("object0"));
            final Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"));
            final Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject2"), createTestUri("predicate2"), createTestUri("object2"));
            final Statement stmt3 = Constants.valueFactory.createStatement(createTestUri("subject3"), createTestUri("predicate3"), createTestUri("object3"));
            final Statement stmt4 = Constants.valueFactory.createStatement(createTestUri("subject4"), createTestUri("predicate4"), createTestUri("object4"));
            Properties props = new Properties(System.getProperties());
            props.putAll(getProperties());

            client = new AnzoClient(getDefaultClientConfiguration());
            client.connect();
            client.reset(loadStatements("initialize.trig"), null);
            CommandManager manager = new CommandManager(client);

            final ClientGraph clientGraph = client.getReplicaGraph(GRAPH_URI);
            client.updateRepository();
            Command command1 = new Command() {

                public Object execute() {
                    clientGraph.add(stmt1);
                    return null;
                }
            };
            Command command2 = new Command() {

                public Object execute() {
                    clientGraph.add(stmt2);
                    return null;
                }
            };
            Command command3 = new Command() {

                public Object execute() {
                    clientGraph.add(stmt3);
                    return null;
                }
            };
            Command command4 = new Command() {

                public Object execute() {
                    clientGraph.add(stmt4);
                    return null;
                }
            };
            // ---------------------------------------------------------------------------
            // Test using default graphs with an invalid preconditon query
            assertFalse(clientGraph.contains(stmt0));
            assertFalse(clientGraph.contains(stmt1));
            assertFalse(clientGraph.contains(stmt2));
            assertFalse(clientGraph.contains(stmt3));
            assertFalse(clientGraph.contains(stmt4));
            IPrecondition precondition = new Precondition();
            precondition.setDefaultGraphUris(Collections.singleton(clientGraph.getNamedGraphUri()));
            assertFalse(clientGraph.contains(stmt1)); // ASK should return FALSE
            precondition.setQuery("ASK  { <" + stmt0.getSubject() + "> <" + stmt0.getPredicate() + "> <" + stmt0.getObject() + "> }");
            command3.addPrecondition(precondition);
            CommandChain chain = manager.createCommandChain();
            chain.addCommand(command1);
            chain.addCommand(command2);
            chain.addCommand(command3);
            chain.addCommand(command4);
            chain.execute();

            boolean exceptionThrown = false;
            try {
                client.updateRepository();
            } catch (Exception e) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown);
            assertFalse(clientGraph.contains(stmt1));
            assertFalse(clientGraph.contains(stmt2));
            assertFalse(clientGraph.contains(stmt3));
            assertFalse(clientGraph.contains(stmt4));
            // ---------------------------------------------------------------------------
            // Test using default graphs with a valid preconditon query
            clientGraph.clear(); // clear the graph
            clientGraph.add(stmt0);
            client.updateRepository();
            assertTrue(clientGraph.contains(stmt0));
            assertFalse(clientGraph.contains(stmt1));
            assertFalse(clientGraph.contains(stmt2));
            assertFalse(clientGraph.contains(stmt3));
            assertFalse(clientGraph.contains(stmt4));
            precondition = new Precondition();
            precondition.setDefaultGraphUris(Collections.singleton(clientGraph.getNamedGraphUri()));
            // this validates that ASK should return FALSE
            assertFalse(clientGraph.contains(stmt1));
            precondition.setQuery("ASK  { <" + stmt0.getSubject() + "> <" + stmt0.getPredicate() + "> <" + stmt0.getObject() + "> }");
            command3.addPrecondition(precondition);
            chain = manager.createCommandChain();
            chain.addCommand(command1);
            chain.addCommand(command2);
            chain.addCommand(command3);
            chain.addCommand(command4);
            chain.execute();
            client.updateRepository();
            assertTrue(clientGraph.contains(stmt1));
            assertTrue(clientGraph.contains(stmt2));
            assertTrue(clientGraph.contains(stmt3));
            assertTrue(clientGraph.contains(stmt4));
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Test executing <code>CommandChain</code> with:
     * <UL>
     * <LI>TransactionQueueManager.executeInTransaction(...)
     * <LI>TransactionQueueManager.executeInTransaction(...)
     * </UL>
     * 
     * @throws Exception
     */
    public void testSimpleCommandChain() throws Exception {
        AnzoClient client1 = null;
        AnzoClient client2 = null;
        try {
            final Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"));
            final Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject2"), createTestUri("predicate2"), createTestUri("object2"));
            final Statement stmt3 = Constants.valueFactory.createStatement(createTestUri("subject3"), createTestUri("predicate3"), createTestUri("object3"));
            Properties props = new Properties(System.getProperties());
            props.putAll(getProperties());

            client1 = new AnzoClient(getDefaultClientConfiguration());
            client1.connect();
            client1.reset(loadStatements("initialize.trig"), null);
            CommandManager manager = new CommandManager(client1);

            client2 = new AnzoClient(getDefaultClientConfiguration());
            client2.connect();
            final ClientGraph clientGraph = client1.getReplicaGraph(GRAPH_URI);
            client1.updateRepository();
            final ClientGraph serverGraph = client2.getServerGraph(GRAPH_URI);
            //client2.updateRepository();

            // ------------------------------------------------------------------------
            // Test executeInTransaction(...) with chain command
            // -make sure the transaction queue has the correct number of transactions
            // -make sure the transactions work and take affect when necessary
            Command command1 = new Command() {

                public Object execute() {
                    clientGraph.add(stmt1);
                    return null;
                }
            };
            Command command2 = new Command() {

                public Object execute() {
                    clientGraph.add(stmt2);
                    return null;
                }
            };
            Command command3 = new Command() {

                public Object execute() {
                    clientGraph.add(stmt3);
                    return null;
                }
            };
            Command command4 = new Command() {

                public Object execute() {
                    clientGraph.remove(stmt3);
                    return null;
                }
            };
            CommandChain chain = manager.createCommandChain();
            chain.addCommand(command1);
            chain.addCommand(command2);
            chain.addCommand(command3);
            chain.addCommand(command4);
            chain.execute();
            assertTrue(clientGraph.contains(stmt1));
            assertFalse(serverGraph.contains(stmt1));
            assertTrue(clientGraph.contains(stmt2));
            assertFalse(serverGraph.contains(stmt2));
            assertFalse(clientGraph.contains(stmt3));
            assertFalse(serverGraph.contains(stmt3));
            client1.updateRepository();

            assertTrue(clientGraph.contains(stmt1));
            assertTrue(serverGraph.contains(stmt1));
            assertTrue(clientGraph.contains(stmt2));
            assertTrue(serverGraph.contains(stmt2));
            assertFalse(clientGraph.contains(stmt3));
            assertFalse(serverGraph.contains(stmt3));
            clientGraph.clear();
            client1.updateRepository();

            assertFalse(clientGraph.contains(stmt1));
            assertFalse(serverGraph.contains(stmt1));
            assertFalse(clientGraph.contains(stmt2));
            assertFalse(serverGraph.contains(stmt2));
            assertFalse(clientGraph.contains(stmt3));
            assertFalse(serverGraph.contains(stmt3));
            // ---------------------------------------------------------------
            // Test executeInTransaction(...) with a chain command
            CommandChain chain2 = manager.createCommandChain();
            chain2.addCommand(command1);
            chain2.addCommand(command2);
            assertFalse(clientGraph.contains(stmt1));
            assertFalse(clientGraph.contains(stmt2));
            chain2.execute();
            assertTrue(clientGraph.contains(stmt1));
            assertTrue(clientGraph.contains(stmt2));
        } finally {
            if (client1 != null) {
                client1.close();
            }
            if (client2 != null) {
                client2.close();
            }
        }
    }

    /**
     * Test the behavior of <code>CommandChain</code> with null commands and failing preconditions.
     * 
     * @throws Exception
     */
    @SuppressWarnings("unused")
    public void testCommandChainWithNullsAndFailingPreconditions() throws Exception {
        AnzoClient anzoClient1 = null;
        AnzoClient anzoClient2 = null;
        try {
            final Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"));
            final Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject2"), createTestUri("predicate2"), createTestUri("object2"));
            final Statement stmt3 = Constants.valueFactory.createStatement(createTestUri("subject3"), createTestUri("predicate3"), createTestUri("object3"));
            final Statement stmt4 = Constants.valueFactory.createStatement(createTestUri("subject4"), createTestUri("predicate4"), createTestUri("object4"));
            final Statement stmt5 = Constants.valueFactory.createStatement(createTestUri("subject5"), createTestUri("predicate5"), createTestUri("object5"));
            final Statement stmt6 = Constants.valueFactory.createStatement(createTestUri("subject6"), createTestUri("predicate6"), createTestUri("object6"));
            final Statement stmt7 = Constants.valueFactory.createStatement(createTestUri("subject7"), createTestUri("predicate7"), createTestUri("object7"));
            //
            // create DATASET SERVICE 1 (CLIENT 1)
            //
            anzoClient1 = new AnzoClient(getDefaultClientConfiguration());
            anzoClient1.connect();
            anzoClient1.reset(loadStatements("initialize.trig"), null);
            CommandManager manager = new CommandManager(anzoClient1);
            //anzoClient1.getDatasetReplicator().setReplicationMode(ReplicationMode.MANUAL);
            //
            // create DATASET SERVICE 2 (CLIENT 2)
            //
            anzoClient2 = new AnzoClient(getDefaultClientConfiguration());
            anzoClient2.connect();
            CommandManager manager2 = new CommandManager(anzoClient1);
            final ClientGraph replicaGraph1 = anzoClient1.getReplicaGraph(GRAPH_URI);
            anzoClient1.updateRepository();
            final ClientGraph replicaGraph2 = anzoClient2.getServerGraph(GRAPH_URI);
            //anzoClient2.updateRepository();
            // ------------------------------------------------------------------------
            // create three different transactions
            // -make sure the transaction queue has the correct number of transactions
            // -make sure the transactions work and take affect when necessary
            Command command1 = new Command() {

                public Object execute() {
                    replicaGraph1.add(stmt1);
                    return null;
                }
            };
            Command command2 = new Command() {

                public Object execute() {
                    replicaGraph1.add(stmt2);
                    return null;
                }
            };
            Command command3 = new Command() {

                public Object execute() {
                    replicaGraph1.add(stmt3);
                    return null;
                }
            };
            Command command4 = new Command() {

                public Object execute() {
                    replicaGraph1.remove(stmt3);
                    return null;
                }
            };
            Command command5 = new Command() {

                public Object execute() {
                    replicaGraph1.add(stmt5);
                    return null;
                }
            };
            Command command6 = new Command() {

                public Object execute() {
                    replicaGraph1.add(stmt6);
                    return null;
                }
            };
            Command command7 = new Command() {

                public Object execute() {
                    replicaGraph1.add(stmt7);
                    return null;
                }
            };
            replicaGraph1.clear();
            anzoClient1.updateRepository();
            TestUtilities.waitFor(5000, new Condition() {
                @Override
                public boolean check() {
                    return !replicaGraph2.contains(stmt1);
                }
            });
            assertFalse(replicaGraph1.contains(stmt1));
            assertFalse(replicaGraph2.contains(stmt1));
            assertFalse(replicaGraph1.contains(stmt2));
            assertFalse(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph1.contains(stmt3));
            assertFalse(replicaGraph2.contains(stmt3));
            // --------------------------------------------------------------------------------------
            // Test single level chained command
            CommandChain chain4 = manager.createCommandChain();
            chain4.addCommand(command1);
            chain4.addCommand(command2);
            chain4.addCommand(command3);
            chain4.addCommand(command4);
            chain4.execute();
            assertTrue(replicaGraph1.contains(stmt1));
            assertFalse(replicaGraph2.contains(stmt1));
            assertTrue(replicaGraph1.contains(stmt2));
            assertFalse(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph1.contains(stmt3));
            assertFalse(replicaGraph2.contains(stmt3));
            anzoClient1.updateRepository();
            TestUtilities.waitFor(5000, new Condition() {
                @Override
                public boolean check() {
                    return replicaGraph2.contains(stmt1);
                }
            });
            //	Thread.sleep(300);
            assertTrue(replicaGraph1.contains(stmt1));
            assertTrue(replicaGraph2.contains(stmt1));
            assertTrue(replicaGraph1.contains(stmt2));
            assertTrue(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph1.contains(stmt3));
            assertFalse(replicaGraph2.contains(stmt3));
            replicaGraph1.clear();
            anzoClient1.updateRepository();
            TestUtilities.waitFor(5000, new Condition() {
                @Override
                public boolean check() {
                    return !replicaGraph2.contains(stmt1);
                }
            });
            assertFalse(replicaGraph1.contains(stmt1));
            assertFalse(replicaGraph2.contains(stmt1));
            assertFalse(replicaGraph1.contains(stmt2));
            assertFalse(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph1.contains(stmt3));
            assertFalse(replicaGraph2.contains(stmt3));
            // --------------------------------------------------------------------------------------
            // Test single level chained command with a null command
            CommandChain chain = manager.createCommandChain();
            chain.addCommand(command1);
            chain.addCommand(command2);
            chain.addCommand(null);
            chain.addCommand(command3);
            chain.addCommand(command4);
            boolean exceptionThrown = false;
            try {
                chain.execute();
            } catch (Exception e) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown);
            assertFalse(replicaGraph1.contains(stmt1));
            assertFalse(replicaGraph2.contains(stmt1));
            assertFalse(replicaGraph1.contains(stmt2));
            assertFalse(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph1.contains(stmt3));
            assertFalse(replicaGraph2.contains(stmt3));
            CommandChain chain2 = manager.createCommandChain();
            chain2.addCommand(command1);
            chain2.addCommand(command2);
            chain2.addCommand(command3);
            chain2.addCommand(command4);
            chain2.addCommand(null);
            exceptionThrown = false;
            try {
                chain2.execute();
            } catch (Exception e) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown);
            assertFalse(replicaGraph1.contains(stmt1));
            assertFalse(replicaGraph2.contains(stmt1));
            assertFalse(replicaGraph1.contains(stmt2));
            assertFalse(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph1.contains(stmt3));
            assertFalse(replicaGraph2.contains(stmt3));
            CommandChain chain3 = manager.createCommandChain();
            chain3.addCommand(null);
            chain3.addCommand(command1);
            chain3.addCommand(command2);
            chain3.addCommand(command3);
            chain3.addCommand(command4);
            exceptionThrown = false;
            try {
                chain3.execute();
            } catch (Exception e) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown);
            assertFalse(replicaGraph1.contains(stmt1));
            assertFalse(replicaGraph2.contains(stmt1));
            assertFalse(replicaGraph1.contains(stmt2));
            assertFalse(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph1.contains(stmt3));
            assertFalse(replicaGraph2.contains(stmt3));
            anzoClient1.updateRepository();
            //	Thread.sleep(300);
            assertFalse(replicaGraph1.contains(stmt1));
            assertFalse(replicaGraph2.contains(stmt1));
            assertFalse(replicaGraph1.contains(stmt2));
            assertFalse(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph1.contains(stmt3));
            assertFalse(replicaGraph2.contains(stmt3));
            replicaGraph1.clear();
            anzoClient1.updateRepository();
            anzoClient2.updateRepository();
            assertFalse(replicaGraph1.contains(stmt1));
            assertFalse(replicaGraph2.contains(stmt1));
            assertFalse(replicaGraph1.contains(stmt2));
            assertFalse(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph1.contains(stmt3));
            assertFalse(replicaGraph2.contains(stmt3));
            // -------------------------------------------------------------------------------------
            // Test nested chained commands
            CommandChain rootChain = manager.createCommandChain();
            CommandChain firstLevelChain1 = manager.createCommandChain();
            CommandChain firstLevelChain2 = manager.createCommandChain();
            rootChain.addCommand(firstLevelChain1);
            rootChain.addCommand(firstLevelChain2);
            rootChain.addCommand(command5);
            CommandChain secondLevelChain1 = manager.createCommandChain();
            CommandChain secondLevelChain2 = manager.createCommandChain();
            CommandChain secondLevelChain3 = manager.createCommandChain();
            CommandChain secondLevelChain4 = manager.createCommandChain();
            firstLevelChain1.addCommand(secondLevelChain1);
            firstLevelChain1.addCommand(secondLevelChain2);
            firstLevelChain2.addCommand(secondLevelChain3);
            firstLevelChain2.addCommand(secondLevelChain4);
            firstLevelChain2.addCommand(command6);
            CommandChain thirdLevelChain1 = manager.createCommandChain();
            CommandChain thirdLevelChain2 = manager.createCommandChain();
            CommandChain thirdLevelChain3 = manager.createCommandChain();
            CommandChain thirdLevelChain4 = manager.createCommandChain();
            secondLevelChain1.addCommand(thirdLevelChain1);
            secondLevelChain2.addCommand(thirdLevelChain2);
            secondLevelChain3.addCommand(thirdLevelChain3);
            secondLevelChain4.addCommand(thirdLevelChain4);
            secondLevelChain4.addCommand(command7);
            thirdLevelChain1.addCommand(command1);
            thirdLevelChain1.addCommand(command2);
            thirdLevelChain1.addCommand(command3);
            thirdLevelChain1.addCommand(command4);
            rootChain.execute();
            assertEquals(1, anzoClient1.getQueuedTransactionCount());
            assertTrue(replicaGraph1.contains(stmt1));
            assertFalse(replicaGraph2.contains(stmt1));
            assertTrue(replicaGraph1.contains(stmt2));
            assertFalse(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph1.contains(stmt3));
            assertFalse(replicaGraph2.contains(stmt3));
            assertTrue(replicaGraph1.contains(stmt5));
            assertTrue(replicaGraph1.contains(stmt6));
            assertTrue(replicaGraph1.contains(stmt7));
            assertFalse(replicaGraph2.contains(stmt5));
            assertFalse(replicaGraph2.contains(stmt6));
            assertFalse(replicaGraph2.contains(stmt7));
            anzoClient1.updateRepository();
            TestUtilities.waitFor(5000, new Condition() {
                @Override
                public boolean check() {
                    return replicaGraph2.contains(stmt1);
                }
            });
            //Thread.sleep(300);
            assertTrue(replicaGraph1.contains(stmt1));
            assertTrue(replicaGraph2.contains(stmt1));
            assertTrue(replicaGraph1.contains(stmt2));
            assertTrue(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph1.contains(stmt3));
            assertFalse(replicaGraph2.contains(stmt3));
            assertTrue(replicaGraph1.contains(stmt5));
            assertTrue(replicaGraph1.contains(stmt6));
            assertTrue(replicaGraph1.contains(stmt7));
            assertTrue(replicaGraph2.contains(stmt5));
            assertTrue(replicaGraph2.contains(stmt6));
            assertTrue(replicaGraph2.contains(stmt7));
            replicaGraph1.clear();
            anzoClient1.updateRepository();
            assertEquals(0, anzoClient1.getQueuedTransactionCount());

            TestUtilities.waitFor(5000, new Condition() {
                @Override
                public boolean check() {
                    return !replicaGraph2.contains(stmt1);
                }
            });
            assertFalse(replicaGraph1.contains(stmt1));
            assertFalse(replicaGraph2.contains(stmt1));
            assertFalse(replicaGraph1.contains(stmt2));
            assertFalse(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph1.contains(stmt3));
            assertFalse(replicaGraph2.contains(stmt3));
            rootChain.execute();
            assertEquals(1, anzoClient1.getQueuedTransactionCount());
            assertTrue(replicaGraph1.contains(stmt1));
            assertFalse(replicaGraph2.contains(stmt1));
            assertTrue(replicaGraph1.contains(stmt2));
            assertFalse(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph1.contains(stmt3));
            assertFalse(replicaGraph2.contains(stmt3));
            assertTrue(replicaGraph1.contains(stmt5));
            assertTrue(replicaGraph1.contains(stmt6));
            assertTrue(replicaGraph1.contains(stmt7));
            assertFalse(replicaGraph2.contains(stmt5));
            assertFalse(replicaGraph2.contains(stmt6));
            assertFalse(replicaGraph2.contains(stmt7));
            anzoClient1.dropQueuedTransactions();
            assertEquals(0, anzoClient1.getQueuedTransactionCount());
            assertFalse(replicaGraph1.contains(stmt1));
            assertFalse(replicaGraph2.contains(stmt1));
            assertFalse(replicaGraph1.contains(stmt2));
            assertFalse(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph1.contains(stmt3));
            assertFalse(replicaGraph2.contains(stmt3));
            assertFalse(replicaGraph1.contains(stmt5));
            assertFalse(replicaGraph1.contains(stmt6));
            assertFalse(replicaGraph1.contains(stmt7));
            assertFalse(replicaGraph2.contains(stmt5));
            assertFalse(replicaGraph2.contains(stmt6));
            assertFalse(replicaGraph2.contains(stmt7));
            // -------------------------------------------------------------------------------------
            // Test nested chained commands with null
            thirdLevelChain4.addCommand(null);
            exceptionThrown = false;
            try {
                rootChain.execute();
            } catch (Exception e) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown);
            assertEquals(0, anzoClient1.getQueuedTransactionCount());
            assertFalse(replicaGraph1.contains(stmt1));
            assertFalse(replicaGraph2.contains(stmt1));
            assertFalse(replicaGraph1.contains(stmt2));
            assertFalse(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph1.contains(stmt3));
            assertFalse(replicaGraph2.contains(stmt3));
            assertFalse(replicaGraph1.contains(stmt5));
            assertFalse(replicaGraph1.contains(stmt6));
            assertFalse(replicaGraph1.contains(stmt7));
            assertFalse(replicaGraph2.contains(stmt5));
            assertFalse(replicaGraph2.contains(stmt6));
            assertFalse(replicaGraph2.contains(stmt7));
            anzoClient1.updateRepository();
            TestUtilities.waitFor(5000, new Condition() {
                @Override
                public boolean check() {
                    return !replicaGraph2.contains(stmt1);
                }
            });
            assertFalse(replicaGraph1.contains(stmt1));
            assertFalse(replicaGraph2.contains(stmt1));
            assertFalse(replicaGraph1.contains(stmt2));
            assertFalse(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph1.contains(stmt3));
            assertFalse(replicaGraph2.contains(stmt3));
            assertFalse(replicaGraph1.contains(stmt5));
            assertFalse(replicaGraph1.contains(stmt6));
            assertFalse(replicaGraph1.contains(stmt7));
            assertFalse(replicaGraph2.contains(stmt5));
            assertFalse(replicaGraph2.contains(stmt6));
            assertFalse(replicaGraph2.contains(stmt7));
            replicaGraph1.clear();
            anzoClient1.updateRepository();
            anzoClient2.updateRepository();
            TestUtilities.waitFor(5000, new Condition() {
                @Override
                public boolean check() {
                    return !replicaGraph2.contains(stmt1);
                }
            });
            assertFalse(replicaGraph1.contains(stmt1));
            assertFalse(replicaGraph2.contains(stmt1));
            assertFalse(replicaGraph1.contains(stmt2));
            assertFalse(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph1.contains(stmt3));
            assertFalse(replicaGraph2.contains(stmt3));
            assertFalse(replicaGraph1.contains(stmt5));
            assertFalse(replicaGraph1.contains(stmt6));
            assertFalse(replicaGraph1.contains(stmt7));
            assertFalse(replicaGraph2.contains(stmt5));
            assertFalse(replicaGraph2.contains(stmt6));
            assertFalse(replicaGraph2.contains(stmt7));
            // --------------------------------------------------------------------------------------
            // Test single level chained command with a failing precondition
            assertFalse(replicaGraph1.contains(stmt5));
            chain = manager.createCommandChain();
            chain.addCommand(command1);
            chain.addCommand(command2);
            chain.addCommand(command3);
            chain.addCommand(command4);
            IPrecondition precondition = new Precondition();
            Set<URI> defaults = new HashSet<URI>();
            defaults.add(replicaGraph1.getNamedGraphUri());
            precondition.setDefaultGraphUris(defaults);
            precondition.setQuery("ASK  { <" + stmt5.getSubject() + "> <" + stmt5.getPredicate() + "> <" + stmt5.getObject() + "> }");
            command3.addPrecondition(precondition);
            chain.execute();
            exceptionThrown = false;
            try {
                anzoClient1.updateRepository();
            } catch (Exception e) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown);
            assertFalse(replicaGraph1.contains(stmt1));
            assertFalse(replicaGraph2.contains(stmt1));
            assertFalse(replicaGraph1.contains(stmt2));
            assertFalse(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph1.contains(stmt3));
            assertFalse(replicaGraph2.contains(stmt3));
            // --------------------------------------------------------------------------------------
            // Test single level chained command with a succeeding precondition
            exceptionThrown = false;
            try {
                chain = manager.createCommandChain();
                chain.addCommand(command1);
                chain.addCommand(command2);
                chain.addCommand(command3);
                chain.addCommand(command4);
                chain.addCommand(command5);
                chain.addCommand(command6);
                chain.addCommand(command7);
                precondition = new Precondition();
                defaults = new HashSet<URI>();
                defaults.add(replicaGraph1.getNamedGraphUri());
                precondition.setDefaultGraphUris(defaults);
                precondition.setQuery("ASK  { <" + stmt2.getSubject() + "> <" + stmt2.getPredicate() + "> <" + stmt2.getObject() + "> }");
                precondition.setResult(false);
                command3.setPreconditions(Collections.singleton(precondition));
                chain.execute();
                anzoClient1.updateRepository();
            } catch (AnzoException ae) {
                exceptionThrown = true;
            }
            assertFalse(exceptionThrown);
            TestUtilities.waitFor(5000, new Condition() {
                @Override
                public boolean check() {
                    return replicaGraph2.contains(stmt1);
                }
            });
            assertTrue(replicaGraph1.contains(stmt1));
            assertTrue(replicaGraph2.contains(stmt1));
            assertTrue(replicaGraph1.contains(stmt2));
            assertTrue(replicaGraph2.contains(stmt2));
            assertFalse(replicaGraph1.contains(stmt3));
            assertFalse(replicaGraph2.contains(stmt3));
            assertTrue(replicaGraph1.contains(stmt5));
            assertTrue(replicaGraph1.contains(stmt6));
            assertTrue(replicaGraph1.contains(stmt7));
            assertTrue(replicaGraph2.contains(stmt5));
            assertTrue(replicaGraph2.contains(stmt6));
            assertTrue(replicaGraph2.contains(stmt7));
        } finally {
            if (anzoClient1 != null)
                anzoClient1.close();
            if (anzoClient2 != null)
                anzoClient2.close();
        }
    }

    /**
     * Test linking commands in an <code>CommandChain</code>.
     * 
     * @throws Exception
     */
    public void testCommandChainLinkingCommands() throws Exception {
        AnzoClient anzoClient1 = null;
        AnzoClient anzoClient2 = null;
        try {
            Properties props = new Properties(System.getProperties());
            props.putAll(getProperties());
            //
            // create DATASET SERVICE 1 (CLIENT 1)
            //
            anzoClient1 = new AnzoClient(getDefaultClientConfiguration());
            anzoClient1.connect();
            anzoClient1.reset(loadStatements("initialize.trig"), null);
            CommandManager manager = new CommandManager(anzoClient1);
            //anzoClient1.getDatasetReplicator().setReplicationMode(ReplicationMode.MANUAL);
            //
            // create DATASET SERVICE 2 (CLIENT 2)
            //
            anzoClient2 = new AnzoClient(getDefaultClientConfiguration());
            anzoClient2.connect();
            final ClientGraph replicaGraph1 = anzoClient1.getReplicaGraph(GRAPH_URI);
            anzoClient1.updateRepository();
            final String property = "output";
            final URI startSubject = (createTestUri("object" + Math.random()));
            final URI object1 = createTestUri("object" + Math.random());
            final URI object2 = createTestUri("object" + Math.random());
            final URI object3 = createTestUri("object" + Math.random());
            final URI object4 = createTestUri("object" + Math.random());
            final URI property1 = createTestUri("predicate" + Math.random());
            final URI property2 = createTestUri("predicate" + Math.random());
            final URI property3 = createTestUri("predicate" + Math.random());
            final URI property4 = createTestUri("predicate" + Math.random());
            Command command1 = new Command() {

                public Object execute() {
                    Statement stmt = Constants.valueFactory.createStatement(startSubject, property1, object1);
                    replicaGraph1.add(stmt);
                    return stmt.getObject();
                }
            };
            Command command2 = new Command() {

                public Object execute() {
                    URI subject = (URI) getInputProperty(property);
                    assertEquals(subject, object1);
                    Statement stmt = Constants.valueFactory.createStatement(subject, property2, object2);
                    replicaGraph1.add(stmt);
                    return stmt.getObject();
                }
            };
            Command command3 = new Command() {

                public Object execute() {
                    URI subject = (URI) getInputProperty(property);
                    assertEquals(subject, object2);
                    Statement stmt = Constants.valueFactory.createStatement(subject, property3, object3);
                    replicaGraph1.add(stmt);
                    return stmt.getObject();
                }
            };
            Command command4 = new Command() {

                public Object execute() {
                    URI subject = (URI) getInputProperty(property);
                    assertEquals(subject, object3);
                    Statement stmt = Constants.valueFactory.createStatement(subject, property4, object4);
                    replicaGraph1.add(stmt);
                    return stmt.getObject();
                }
            };
            // build chain
            CommandChain chain = manager.createCommandChain();
            chain.addCommand(command1);
            chain.addCommand(command2);
            chain.addCommand(command3);
            chain.addCommand(command4);
            // link commands
            chain.linkCommand(command2, property, command1);
            chain.linkCommand(command3, property, command2);
            chain.linkCommand(command4, property, command3);
            replicaGraph1.contains(startSubject, property1, object1);
            replicaGraph1.contains(object1, property2, object2);
            replicaGraph1.contains(object2, property2, object3);
            replicaGraph1.contains(object3, property2, object4);
            chain.execute();
            replicaGraph1.contains(startSubject, property1, object1);
            replicaGraph1.contains(object1, property2, object2);
            replicaGraph1.contains(object2, property2, object3);
            replicaGraph1.contains(object3, property2, object4);
        } finally {
            if (anzoClient1 != null) {
                anzoClient1.close();
            }
            if (anzoClient2 != null) {
                anzoClient2.close();
            }
        }
    }

    /**
     * Test linking commands in an <code>CommandChain</code>.
     * 
     * @throws Exception
     */
    public void testCommandType() throws Exception {
        AnzoClient anzoClient1 = null;
        AnzoClient anzoClient2 = null;
        try {
            //
            // create DATASET SERVICE 1 (CLIENT 1)
            //
            anzoClient1 = new AnzoClient(getDefaultClientConfiguration());
            anzoClient1.connect();
            anzoClient1.reset(loadStatements("initialize.trig"), null);
            //
            // create DATASET SERVICE 2 (CLIENT 2)
            //
            anzoClient2 = new AnzoClient(getDefaultClientConfiguration());
            anzoClient2.connect();
            CommandManager manager1 = new CommandManager(anzoClient1);
            CommandManager manager2 = new CommandManager(anzoClient2);
            final ClientGraph replicaGraph1 = anzoClient1.getReplicaGraph(GRAPH_URI);
            anzoClient1.updateRepository();
            final ClientGraph replicaGraph2 = anzoClient2.getReplicaGraph(GRAPH_URI);
            final URI startSubject = (createTestUri("object" + Math.random()));
            final URI object1 = createTestUri("object" + Math.random());
            final URI object2 = createTestUri("object" + Math.random());
            final URI object3 = createTestUri("object" + Math.random());
            final URI object4 = createTestUri("object" + Math.random());
            final URI property1 = createTestUri("predicate" + Math.random());
            final URI property2 = createTestUri("predicate" + Math.random());
            final URI property3 = createTestUri("predicate" + Math.random());
            final URI property4 = createTestUri("predicate" + Math.random());
            Command command1 = new Command() {

                @Override
                public URI getCommandType() {
                    return CommandManager.getBasicCommandType("TestCommandType");
                }

                public Object execute() {
                    Statement stmt = Constants.valueFactory.createStatement(startSubject, property1, object1);
                    replicaGraph1.add(stmt);
                    return stmt.getObject();
                }
            };
            Command command2 = new Command() {

                @Override
                public URI getCommandType() {
                    return CommandManager.getBasicCommandType("TestCommandType2");
                }

                public Object execute() {
                    Statement stmt = Constants.valueFactory.createStatement(startSubject, property2, object2);
                    replicaGraph1.add(stmt);
                    return stmt.getObject();
                }
            };
            Command command3 = new Command() {

                @Override
                public URI getCommandType() {
                    return CommandManager.getBasicCommandType("TestCommandType3");
                }

                public Object execute() {
                    Statement stmt = Constants.valueFactory.createStatement(startSubject, property3, object3);
                    replicaGraph1.add(stmt);
                    return stmt.getObject();
                }
            };
            Command command4 = new Command() {

                @Override
                public URI getCommandType() {
                    return CommandManager.getBasicCommandType("TestCommandType4");
                }

                public Object execute() {
                    Statement stmt = Constants.valueFactory.createStatement(startSubject, property4, object4);
                    replicaGraph1.add(stmt);
                    return stmt.getObject();
                }
            };
            // build chain
            CommandChain chain = manager1.createCommandChain();
            chain.addCommand(command1);
            chain.addCommand(command2);
            chain.addCommand(command3);
            chain.addCommand(command4);
            assertFalse(replicaGraph1.contains(startSubject, property1, object1));
            assertFalse(replicaGraph1.contains(startSubject, property2, object2));
            assertFalse(replicaGraph1.contains(startSubject, property3, object3));
            assertFalse(replicaGraph1.contains(startSubject, property4, object4));
            seenEvent = false;

            manager2.registerCommandListener(new ICommandListener() {

                public void commandCompleted(URI commandType, INamedGraph commandContext) {
                    assertNotNull(commandType);
                    seenEvent = true;
                }

                public void commandFailed(URI commandType, INamedGraph commandContext, List<AnzoException> errors) {
                }

            });

            chain.execute();
            assertTrue(replicaGraph1.contains(startSubject, property1, object1));
            assertTrue(replicaGraph1.contains(startSubject, property2, object2));
            assertTrue(replicaGraph1.contains(startSubject, property3, object3));
            assertTrue(replicaGraph1.contains(startSubject, property4, object4));
            anzoClient1.updateRepository();
            assertTrue(replicaGraph1.contains(startSubject, property1, object1));
            assertTrue(replicaGraph1.contains(startSubject, property2, object2));
            assertTrue(replicaGraph1.contains(startSubject, property3, object3));
            assertTrue(replicaGraph1.contains(startSubject, property4, object4));
            TestUtilities.waitFor(10000, new Condition() {
                @Override
                public boolean check() {
                    return seenEvent;
                }
            });
            assertTrue(replicaGraph2.contains(startSubject, property1, object1));
            assertTrue(replicaGraph2.contains(startSubject, property2, object2));
            assertTrue(replicaGraph2.contains(startSubject, property3, object3));
            assertTrue(replicaGraph2.contains(startSubject, property4, object4));

            assertTrue(seenEvent);
        } finally {
            if (anzoClient1 != null) {
                anzoClient1.close();
            }
            if (anzoClient2 != null) {
                anzoClient2.close();
            }
        }
    }

    boolean seenEvent = false;
}
