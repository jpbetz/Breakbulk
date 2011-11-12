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

import org.apache.commons.cli.Options;
import org.openanzo.client.AnzoClient;
import org.openanzo.client.INamedGraphInitializer;

/**
 * Overrides RdfUploadCommand to only allow graph uploads if the graphs do not yet exist.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
class CreateCommand extends RdfUploadCommand {

    @Override
    public INamedGraphInitializer[] getNamedGraphInitializers() {
        return new INamedGraphInitializer[] { AnzoClient.GRAPH_MUST_NOT_EXIST };
    }

    public String getName() {
        return "create";
    }

    public void printHelp(IConsole consoleWriter) {
        String header = "Creates named graphs in the repository from the provided RDF. Reads RDF from the arguments, or from STDIN if no input arguments are provided.  This operation will fail is any of the graph already exist in the repository.";
        String syntax = "anzo create [options] [RDF-INPUT-FILE-OR-URI ...]";
        String footer = "RDF format options are: " + CommandLineInterface.getRDFFormatOptionsString();
        Options options = getOptions();
        CommandLineInterface.appendGlobalOptions(options);
        consoleWriter.printHelp( syntax, header, options, footer);
    }
}
