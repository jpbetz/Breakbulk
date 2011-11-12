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

import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.openanzo.client.AnzoClient;
import org.openanzo.client.ClientGraph;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.vocabulary.RDF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class RemoveCommand extends RdfIOCommand {
    private static final Logger log = LoggerFactory.getLogger(RemoveCommand.class);

    public String getName() {
        return "remove";
    }

    public Options getOptions() {
        Options options = new Options();
        return options;
    }

    public int invoke(CommandLine cl, CommandContext context, AnzoClient client) throws AnzoException {
        String[] args = cl.getArgs();
        List<URI> uris = getURIArguments(args, 0, args.length, context);

        int result = 1;
        boolean owns = false;
        try {
            owns = !client.isConnected();
            if (owns) {
                client.connect();
                printOnConnectionSuccess(context);
            }
            client.begin();
            {
                for (URI uri : uris) {
                    ClientGraph serverGraph = client.getServerGraph(uri, AnzoClient.GRAPH_MUST_EXIST);
                    serverGraph.getMetadataGraph().remove(serverGraph.getNamedGraphUri(), RDF.TYPE, null);
                }
            }
            client.commit();
            client.updateRepository();

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
        String header = "Removes named graphs from the repository.";
        String syntax = "anzo remove [options] [NAMED-GRAPH-URI ...]";
        Options options = getOptions();
        CommandLineInterface.appendGlobalOptions(options);
        consoleWriter.printHelp( syntax, header, options, null);
    }

}
