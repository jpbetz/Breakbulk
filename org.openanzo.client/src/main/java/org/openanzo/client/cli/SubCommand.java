/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.client.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.openanzo.client.AnzoClient;
import org.openanzo.exceptions.AnzoException;

/**
 * Handles invocation of command line operations for a sub command type.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
interface SubCommand {

    /**
     * Gets the name of this subcommand.
     * 
     * @return the name of this command
     */
    String getName();

    /**
     * Gets the command line options used by this command.
     * 
     * @return the options used by this command
     */
    Options getOptions();

    /**
     * Invokes the sub command. If the subcommand is successful it must call {@link System#exit(int)} with value 1, otherwise exit value 0 will be assumed.
     * 
     * @param cl
     *            Command line that is invoking this command
     * @param context
     *            Context for the command being executed
     * @param client
     *            AnzoClient used by this invocation
     * 
     * @return resultCode
     * @throws AnzoException
     */
    int invoke(CommandLine cl, CommandContext context, AnzoClient client) throws AnzoException;

    /**
     * Prints help information for this sub command.
     */
    void printHelp(IConsole consoleWriter);
}
