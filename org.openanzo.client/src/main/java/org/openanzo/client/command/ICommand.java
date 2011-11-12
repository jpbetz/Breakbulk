/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/commands/Attic/Command.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  4/14/2006
 * Revision:    $Id: Command.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     C Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.client.command;

import java.util.Set;

import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.URI;
import org.openanzo.services.IPrecondition;

/**
 * An Command is basic unit of work that can be executed within a transaction. Command's can be nested arbitrarily deep in a tree structure. When executed, it
 * is the responsibility of each command to, in turn, execute its children (if any).
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * @author Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public interface ICommand {

    /**
     * Returns a URI representing the command type encompassed by this command.
     * 
     * @return CommandType for this Command
     */
    URI getCommandType();

    /**
     * Set the Dataset used by this command, for example to create new resources.
     * 
     * @param dataset
     *            the dataset where statements are added or removed
     */
    public void setDataset(IDataset dataset);

    /**
     * Get the Dataset used by this command.
     * 
     * @return the Dataset used by this command
     */
    IDataset getDataset();

    /**
     * An input property is a name/value pair that can be used by the command during its execution.
     * 
     * @param name
     *            Name of input property
     * @param value
     *            Value of input property
     */
    public void setInputProperty(String name, Object value);

    /**
     * Add a precondition to this command that will get evaluated on the server to decide if the command can get commited.
     * 
     * @param precondition
     *            Precondition that is evaluated on the server
     */
    void addPrecondition(IPrecondition precondition);

    /**
     * Set this commands preconditions to the given set.
     * 
     * @param preconditions
     *            Set of preconditions that are evaluated on the server
     */
    void setPreconditions(Set<IPrecondition> preconditions);

    /**
     * Return the set of preconditions for this command.
     * 
     * @return Set of preconditions
     */
    Set<IPrecondition> getPreconditions();

    /**
     * Method that is executed by local transaction manager when this command is processed. Commands can return whatever object they choose, including null.
     * 
     * @return results of running command
     * @throws Exception
     *             Exception if there is an error executing command
     */
    public Object execute() throws Exception;

}
