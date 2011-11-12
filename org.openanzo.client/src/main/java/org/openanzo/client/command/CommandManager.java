/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Jan 3, 2008
 * Revision: $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

package org.openanzo.client.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.ITransactionListener;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.ontologies.command.CommandFactory;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.services.IPrecondition;

/**
 * Command manager allows one to augment transaction contexts with a command metadata structure
 * 
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 * 
 */
public class CommandManager implements ITransactionListener {

    private HashMap<URI, ArrayList<ICommandListener>> commandListeners = new HashMap<URI, ArrayList<ICommandListener>>();

    private static final URI                          ALL_COMMANDS     = Constants.valueFactory.createURI(NAMESPACES.COMMAND_PREFIX + "#allCommands");

    private AnzoClient                                client           = null;

    /**
     * Get create a uri for command type
     * 
     * @param basicCommandType
     *            command type to wrap
     * @return wrapped uri
     */
    public static URI getBasicCommandType(String basicCommandType) {
        return Constants.valueFactory.createURI(NAMESPACES.COMMAND_PREFIX + "#" + basicCommandType);
    }

    /**
     * Create a new command manager for the given client
     * 
     * @param client
     *            client for the command
     */
    public CommandManager(AnzoClient client) {
        this.client = client;
        client.registerTransactionListener(this);
    }

    /**
     * Execute the given command
     * 
     * @param command
     *            command to execute
     * @throws AnzoException
     */
    public void execute(ICommand command) throws AnzoException {
        begin(client, command.getCommandType(), command.getPreconditions());
        try {
            command.execute();
            client.commit();
        } catch (Exception e) {
            client.abort();
            throw new AnzoException(0, e);
        }
    }

    private void begin(AnzoClient client, URI commandType, Set<IPrecondition> preconditions) {
        client.begin(preconditions);
        INamedGraph contextGraph = client.getTransactionContext();
        org.openanzo.ontologies.command.Command owlCommand = CommandFactory.createCommand(contextGraph.getNamedGraphUri(), contextGraph);
        owlCommand.setCommandType(commandType);
    }

    private void begin(AnzoClient client, URI commandType) {
        client.begin();
        INamedGraph contextGraph = client.getTransactionContext();
        org.openanzo.ontologies.command.Command owlCommand = CommandFactory.createCommand(contextGraph.getNamedGraphUri(), contextGraph);
        owlCommand.setCommandType(commandType);
    }

    /**
     * Execute a command chain
     * 
     * @param chain
     *            chain of commands to execute
     * @throws Exception
     */
    public void execute(CommandChain chain) throws Exception {

        if (chain.preconditions != null && chain.preconditions.size() > 0) {
            begin(client, chain.getCommandType(), chain.getPreconditions());
        } else {
            begin(client, chain.getCommandType());
        }

        try {
            for (ICommand command : chain.commands) {
                begin(client, command.getCommandType(), command.getPreconditions());
                try {
                    if (chain.links.containsKey(command)) {
                        Hashtable<String, ICommand> commandLinks = chain.links.get(command);
                        for (Map.Entry<String, ICommand> entry : commandLinks.entrySet()) {
                            Object obj = chain.outputValues.get(entry.getValue());
                            command.setInputProperty(entry.getKey(), obj);
                        }
                    }
                    command.setDataset(chain.dataset);
                    Object obj = command.execute();
                    if (obj != null) {
                        chain.outputValues.put(command, obj);
                    }
                } catch (Exception e) {
                    client.abort();
                    throw (e);
                }

                client.commit();
            }
        } catch (Exception e) {
            client.abort();
            throw (e);
        }

        client.commit();

    }

    /**
     * Create a command chain
     * 
     * @return new command chain
     */
    public CommandChain createCommandChain() {
        return new CommandChain(this);
    }

    /**
     * Notifies when the notification system triggers or whenever a client code calls, manager.notifyCommandStarted
     * 
     * @param listener
     *            listener to register
     */
    public void registerCommandListener(ICommandListener listener) {
        registerCommandListener(listener, ALL_COMMANDS);
    }

    /**
     * Register a listener for the given command
     * 
     * @param listener
     *            lister to register
     * @param commandType
     * 
     */
    public void registerCommandListener(ICommandListener listener, URI commandType) {
        ArrayList<ICommandListener> listeners = commandListeners.get(commandType);
        if (listeners == null) {
            listeners = new ArrayList<ICommandListener>();
            commandListeners.put(commandType, listeners);
        }
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    /**
     * Unregister command listener
     * 
     * @param listener
     *            listener to unregister
     */
    public void unregisterCommandListener(ICommandListener listener) {
        unregisterCommandListener(listener, ALL_COMMANDS);
    }

    /**
     * Unregister command listener for given command type
     * 
     * @param listener
     *            listener to unregister
     * @param commandType
     */
    public void unregisterCommandListener(ICommandListener listener, URI commandType) {
        ArrayList<ICommandListener> listeners = commandListeners.get(commandType);
        if (listeners != null) {
            if (listeners.contains(listener)) {
                listeners.remove(listener);
            }
        }
    }

    public void transactionComplete(URI transactionURI, long transactionTimestamp, Set<URI> transactionGraphs, IDataset transactionContext) {

        List<org.openanzo.ontologies.command.Command> commands = CommandFactory.getAllCommand(transactionContext);
        for (org.openanzo.ontologies.command.Command command : commands) {
            URI commandType = (URI) command.getCommandType().resource();
            ArrayList<ICommandListener> listeners = commandListeners.get(commandType);
            if (listeners != null) {
                for (ICommandListener listener : listeners) {
                    listener.commandCompleted(commandType, transactionContext.getNamedGraph((URI) command.resource()));
                }
            }
            listeners = commandListeners.get(ALL_COMMANDS);
            if (listeners != null) {
                for (ICommandListener listener : listeners) {
                    listener.commandCompleted(commandType, transactionContext.getNamedGraph((URI) command.resource()));
                }
            }
        }
    }

    public void transactionFailed(URI transactionURI, Set<URI> transactionGraphs, IDataset transactionContext, List<AnzoException> errors) {

        List<org.openanzo.ontologies.command.Command> commands = CommandFactory.getAllCommand(transactionContext);
        for (org.openanzo.ontologies.command.Command command : commands) {
            URI commandType = (URI) command.getCommandType().resource();
            ArrayList<ICommandListener> listeners = commandListeners.get(commandType);
            if (listeners != null) {
                for (ICommandListener listener : listeners) {
                    listener.commandFailed(commandType, transactionContext.getNamedGraph((URI) command.resource()), errors);
                }
            }
            listeners = commandListeners.get(ALL_COMMANDS);
            if (listeners != null) {
                for (ICommandListener listener : listeners) {
                    listener.commandFailed(commandType, transactionContext.getNamedGraph((URI) command.resource()), errors);
                }
            }
        }

    }

}
