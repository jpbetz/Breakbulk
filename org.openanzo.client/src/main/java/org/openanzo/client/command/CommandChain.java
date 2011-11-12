/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/commands/Attic/CommandChain.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  4/14/2006
 * Revision:    $Id: CommandChain.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.client.command;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.services.IPrecondition;

/**
 * An CommandChain is an Command that is made up of a chain of Commands that get executed in order. The output of each command is placed in the input properties
 * of the next command to reference if needed.
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class CommandChain implements ICommand {

    /** List of commands that make up this chain */
    ArrayList<ICommand>                              commands     = new ArrayList<ICommand>();

    /** Set of links between commands */
    Hashtable<ICommand, Hashtable<String, ICommand>> links        = new Hashtable<ICommand, Hashtable<String, ICommand>>();

    /** Results of running the commands that makeup this chain */
    Hashtable<ICommand, Object>                      outputValues = new Hashtable<ICommand, Object>();

    /** Set of preconditions that are evaluated on the server before this command is committed */
    Set<IPrecondition>                               preconditions;

    /** Source of data for this command, and destination of additions and deletions */
    IDataset                                         dataset;

    CommandManager                                   manager;

    CommandChain(CommandManager manager) {
        this.manager = manager;
    }

    /**
     * Add a command to the end of this command chain
     * 
     * @param command
     *            Command to add to end of chain.
     */
    public void addCommand(ICommand command) {
        if (!commands.contains(command)) {
            commands.add(command);
        }
    }

    /**
     * Linking commands allows for linking the output of one command to the input of another command.
     * 
     * @param targetCommand
     *            Command on which input property is being set
     * @param propertyName
     *            Name of the property under which to store the output of the source command
     * @param sourceCommand
     *            Command whose output is used as input to the target command's input properties
     * @throws AnzoException
     *             if the source command is not a member of this chain
     */
    public void linkCommand(ICommand targetCommand, String propertyName, ICommand sourceCommand) throws AnzoException {
        if (!commands.contains(sourceCommand)) {
            throw new AnzoException(ExceptionConstants.CLIENT.XCOMMAND_LINK_ERROR, sourceCommand.getCommandType().toString());
        }
        Hashtable<String, ICommand> commandLinks = links.get(targetCommand);
        if (commandLinks == null) {
            commandLinks = new Hashtable<String, ICommand>();
            links.put(targetCommand, commandLinks);
        }
        commandLinks.put(propertyName, sourceCommand);
    }

    public Object execute() throws Exception {
        manager.execute(this);
        return null;
    }

    public IDataset getDataset() {
        return dataset;
    }

    public void setDataset(IDataset dataset) {
        this.dataset = dataset;
    }

    public URI getCommandType() {
        return Constants.valueFactory.createURI(NAMESPACES.COMMAND_PREFIX + "#chain");
    }

    public void setInputProperty(String name, Object value) {
        throw new UnsupportedOperationException();
    }

    public void addPrecondition(IPrecondition precondition) {
        if (preconditions == null) {
            preconditions = new HashSet<IPrecondition>();
        }
        preconditions.add(precondition);
    }

    public Set<IPrecondition> getPreconditions() {
        return preconditions;
    }

    public void setPreconditions(Set<IPrecondition> preconditions) {
        this.preconditions = preconditions;
    }

}
