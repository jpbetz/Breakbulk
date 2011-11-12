/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/commands/Attic/CommandImpl.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  4/14/2006
 * Revision:    $Id: CommandImpl.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
  *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.client.command;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.services.IPrecondition;

/**
 * CommandImpl handles the general bookkeeping of the Command interface, including maintaining the dataset, the parent command,
 * and the list of child commands. It also implements execute() with the help of the abstract method executeThisCommand() which
 * derived classes must implement. It also assembles all command types together for this command and descendant commands, based
 * on derived classes' implementations of getCommandType()
 *
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * @author Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * 
 */
public abstract class Command implements ICommand {
    /**Source and destination of data for this Command*/
    protected IDataset          dataset;
    /**Set of name/value properties for this command*/
    Hashtable<String, Object>   properties;
    /**Set of preconditions for this command which are executed on the server prior to committing.*/
    Set<IPrecondition>          preconditions = new HashSet<IPrecondition>();

    public void setInputProperty(String name, Object value) {
        if (properties == null) {
            properties = new Hashtable<String, Object>();
        }
        properties.put(name, value);
    }

    /**
     * Retrieve the value of the given input property
     * @param name Name of value to retreive
     * @return Value for given name, or null if not stored
     */
    public Object getInputProperty(String name) {
        return (properties == null) ? null : properties.get(name);
    }

    public void setDataset(IDataset dataset) {
        this.dataset = dataset;
    }

    public IDataset getDataset() {
        return dataset;
    }

    /**
     * By default the command type is given by the Constants.COMMAND_PREFIX plus the class name.
     * @return Constants.COMMAND_PREFIX#classname
     */
    public URI getCommandType() {
        return Constants.valueFactory.createURI(NAMESPACES.COMMAND_PREFIX + "#" + getClass().getName());
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
