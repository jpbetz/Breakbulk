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
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.IStatementListener;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Listens for named graph events and prints them to the console.
 * 
 * <pre>
 * 
 * &#064;prefix : &lt;http://.../watchEvents&gt; .
 * :addition { &lt;...&gt; &lt;...&gt; &quot;1&quot; . }
 * :removal  { &lt;...&gt; &lt;...&gt; &quot;Smith&quot; . }
 * 
 * Not sure how to incorporate named graph in such a scheme cleanly yet...
 * 
 * See also: http://esw.w3.org/topic/Rdb2RdfXG/LinkedDataUpdateLogs
 * </pre>
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
class WatchCommand extends RdfIOCommand {
    private static final Logger log = LoggerFactory.getLogger(WatchCommand.class);

    public String getName() {
        return "watch";
    }

    public Options getOptions() {
        Options options = new Options();

        return options;
    }

    public int invoke(CommandLine cl, CommandContext context, AnzoClient client) throws AnzoException {
        String[] args = cl.getArgs();
        if (args.length < 1) {
            throw new CommandException("Illegal argument count. At least one named graph URI required.");
        }

        List<URI> uris = getURIArguments(args, 0, args.length, context);

        boolean owns = false;
        try {
            owns = !client.isConnected();
            if (owns) {
                client.connect();
                printOnConnectionSuccess(context);
            }

            final CommandContext ctx = context;
            final boolean applyPrefixes = !context.getExcludePrefixes();

            IStatementListener<INamedGraph> listener = new IStatementListener<INamedGraph>() {

                public void statementsAdded(INamedGraph source, Statement... statements) {
                    for (Statement stmt : statements) {
                        System.out.println("++\t" + (applyPrefixes ? ctx.applyPrefixes(stmt) : stmt));
                    }

                }

                public void statementsRemoved(INamedGraph source, Statement... statements) {
                    for (Statement stmt : statements) {
                        System.out.println("--\t" + (applyPrefixes ? ctx.applyPrefixes(stmt) : stmt));
                    }
                }

            };

            for (URI uri : uris) {
                ClientGraph replica = client.getReplicaGraph(uri);
                replica.registerListener(listener);
            }

            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    return 0;
                }
            }
        } finally {
            try {
                if (owns)
                    client.close();
            } catch (AnzoRuntimeException e) {
                log.error("Error closing connection", e);
            }
        }
    }

    public void printHelp(IConsole consoleWriter) {
        String header = "Listens for changes to a graph and prints them out.";
        String syntax = "anzo watch [options] [NAMED-GRAPH-URI...]";
        Options options = getOptions();
        CommandLineInterface.appendGlobalOptions(options);
        consoleWriter.printHelp( syntax, header, options, null);
    }

}
