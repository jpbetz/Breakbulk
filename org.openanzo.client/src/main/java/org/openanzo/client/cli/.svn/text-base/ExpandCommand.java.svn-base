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

import java.net.URISyntaxException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.openanzo.client.AnzoClient;
import org.openanzo.client.cli.CommandContext.URINotCURIEOrKnownScheme;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.URI;

/**
 * Uses the prefix map in the user settings to expand CURIEs to URIs. If no map entry if found, the CURIE is returned unchanged.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
class ExpandCommand implements SubCommand {

    public String getName() {
        return "expand";
    }

    public Options getOptions() {
        Options options = new Options();
        return options;
    }

    public int invoke(CommandLine cl, CommandContext context, AnzoClient client) throws AnzoException {
        for (String arg : cl.getArgs()) {
            if (!context.isURI(arg) && !context.isCURIE(arg)) {
                throw new InvalidArgumentException("parameter is not a valid URI or prefixed URI: " + arg);
            }
            try {
                if (context.isCURIE(arg)) {
                    URI uri = null;
                    try {
                        uri = context.getURI(arg);
                    } catch (URINotCURIEOrKnownScheme e) {
                    }
                    if (uri == null) {
                        System.out.println("[" + context.getCURIE(arg) + "]");
                    } else {
                        System.out.println(uri);
                    }
                } else {
                    System.out.println(context.getURI(arg));
                }
            } catch (URISyntaxException e) {
                throw new CommandException(e, "expand");
            }
        }
        return 0;
    }

    public void printHelp(IConsole consoleWriter) {
        String header = "Expands all prefixed URI (CURIE) arguments to expanded URIs using user defined prefix map.  Prefixed URIs that have no matching prefix entry will be returned unchanged.";
        String syntax = "anzo expand [options] [PREFIXED-URI ...]";
        Options options = getOptions();
        CommandLineInterface.appendGlobalOptions(options);
        consoleWriter.printHelp( syntax, header, options, null);
    }

}
