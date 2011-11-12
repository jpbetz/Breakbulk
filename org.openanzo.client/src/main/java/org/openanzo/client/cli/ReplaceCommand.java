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
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.openanzo.client.AnzoClient;
import org.openanzo.client.INamedGraphInitializer;
import org.openanzo.exceptions.AnzoException;

class ReplaceCommand extends RdfUploadCommand {

    private static final Option FORCE_CREATE = new Option("f", "force-create", false, "Create graphs if they do not exist already.");

    INamedGraphInitializer[]    inits        = new INamedGraphInitializer[] { AnzoClient.GRAPH_MUST_EXIST };

    @Override
    public INamedGraphInitializer[] getNamedGraphInitializers() {
        return inits;
    }

    @Override
    public Options getOptions() {
        Options options = super.getOptions();
        options.addOption(FORCE_CREATE);
        return options;
    }

    public String getName() {
        return "replace";
    }

    @Override
    public int invoke(CommandLine cl, CommandContext context, AnzoClient client) throws AnzoException {
        if (isFlagSet(cl, FORCE_CREATE)) {
            inits = new INamedGraphInitializer[] {};
        }
        return super.invoke(cl, context, client);
    }

    public void printHelp(IConsole consoleWriter) {
        String header = "Replaces named graphs in the repository with the provided RDF. Reads RDF from the arguments, or from STDIN if no input arguments are provided.  This operation will fail if any of the graphs do not already exist in the repository.";
        String syntax = "anzo replace [options] [RDF-INPUT-FILE-OR-URI ...]";
        String footer = "RDF format options are: " + CommandLineInterface.getRDFFormatOptionsString();
        Options options = getOptions();
        CommandLineInterface.appendGlobalOptions(options);
        consoleWriter.printHelp( syntax, header, options, footer);
    }
}
