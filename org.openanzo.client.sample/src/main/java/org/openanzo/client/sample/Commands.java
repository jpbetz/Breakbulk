/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.client.sample;

import java.util.List;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.AnzoClientConfigurationFactory;
import org.openanzo.client.command.Command;
import org.openanzo.client.command.CommandManager;
import org.openanzo.client.command.ICommand;
import org.openanzo.client.command.ICommandListener;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.IAnzoGraph;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.test.TestUtilities.TestData;

/**
 * 
 * This simple example instantiates a client AnzoClient that connects to the server. This example works against the ready-to-run standalone server.
 * <p>
 * In this example, we demonstrate the basics of the Command API
 * <p>
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>
 * 
 */
public class Commands {
    /**
     * Run commands
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        AnzoClient anzoClient = null;

        // use a try-finally to make sure the anzoClients are closed properly
        try {

            // prepare the configuration for the client
            String username = "default";
            String password = "123";
            String host = "localhost";
            int port = 61616;
            boolean useSsl = false;

            // instantiate a anzo client
            anzoClient = new AnzoClient(AnzoClientConfigurationFactory.createJMSConfiguration(username, password, host, port, useSsl));
            // connect the client
            anzoClient.connect();

            final IAnzoGraph graph = anzoClient.getReplicaGraph(TestData.graph1);

            // commands are defined by extending the abstract Command class
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

            // we could also set preconditions on a command if necessary
            // addCommand.addPrecondition(...);

            // The CommandManager, instantiated using a client instance,
            // provides all command functionality
            CommandManager manager = new CommandManager(anzoClient);

            class CommandListener implements ICommandListener {

                public void commandCompleted(URI commandType, INamedGraph commandContext) {
                    System.err.println("Command completed: " + commandType);
                    System.err.println("Command context: " + commandContext.getStatements());
                }

                public void commandFailed(URI commandType, INamedGraph commandContext, List<AnzoException> errors) {

                }
            }

            final CommandListener listener = new CommandListener();
            manager.registerCommandListener(listener);
            manager.execute(addCommand);
            anzoClient.updateRepository();

        } finally {
            if (anzoClient != null)
                anzoClient.close();
        }
    }

}
