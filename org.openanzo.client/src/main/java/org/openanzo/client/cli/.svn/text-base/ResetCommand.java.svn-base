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

import java.util.Collections;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.openanzo.client.AnzoClient;
import org.openanzo.client.INamedGraphInitializer;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ResetCommand extends RdfUploadCommand {

    private static final Option REPOSITORY_INITIALIZE = new Option("r", "re-initialize", false, "Re-initialize the repository from it's default initialization files, replacing all existing data.");

    private static final Logger log                   = LoggerFactory.getLogger(ResetCommand.class);

    boolean                     repositoryInitialize  = false;

    @Override
    public INamedGraphInitializer[] getNamedGraphInitializers() {
        return new INamedGraphInitializer[] {};
    }

    @Override
    public Options getOptions() {
        Options options = super.getOptions();
        options.addOption(REPOSITORY_INITIALIZE);
        return options;
    }

    public String getName() {
        return "reset";
    }

    @Override
    public int invoke(CommandLine cl, CommandContext context, AnzoClient client) throws AnzoException {
        repositoryInitialize = isFlagSet(cl, REPOSITORY_INITIALIZE);

        if (repositoryInitialize) {
            if (cl.getArgs().length > 0) {
                context.writeOutput("No file arguments may be provided when using the " + REPOSITORY_INITIALIZE.getLongOpt() + " option.");
            }
        }

        return super.invoke(cl, context, client, !repositoryInitialize);
    }

    @Override
    protected int update(CommandLine cl, CommandContext context, AnzoClient client, IDataset store, URI base, boolean nonRevisioned) throws AnzoException {
        int result = 1;
        boolean owns = false;
        try {
            owns = !client.isConnected();
            if (owns) {
                client.connect();
                printOnConnectionSuccess(context);
            }

            if (repositoryInitialize) {
                client.reset(Collections.<Statement> emptySet(), null);
            } else {
                client.reset(store.getStatements(), null);
            }
            result = 0;
        } finally {
            try {
                if (owns)
                    client.close();
            } catch (AnzoRuntimeException e) {
                log.error("Error closing connection", e);
            }
        }
        return result;
    }

    public void printHelp(IConsole consoleWriter) {
        String header = "Resets the repository, replacing all contents of repository with rdf provided in the arguments, or STDIN if no input arguments are provided.";
        String syntax = "anzo reset [options] [ RDF-INPUT-FILE-OR-URI... ]";
        String footer = "RDF format options are: " + CommandLineInterface.getRDFFormatOptionsString();
        Options options = getOptions();
        CommandLineInterface.appendGlobalOptions(options);
        consoleWriter.printHelp( syntax, header, options, footer);
    }

}
