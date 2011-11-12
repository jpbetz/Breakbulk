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
import org.openanzo.exceptions.AnzoException;
import org.openanzo.glitter.util.CURIE;

/**
 * Uses the prefix map in the user settings to convert provided URIs to CURIEs. If no map entry if found, the URI is returned unchanged.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
class CollapseCommand implements SubCommand {

    public String getName() {
        return "collapse";
    }

    public Options getOptions() {
        Options options = new Options();
        return options;
    }

    public int invoke(CommandLine cl, CommandContext context, AnzoClient client) throws AnzoException {
        for (String arg : cl.getArgs()) {
            if (!context.isCURIE(arg) && !context.isURI(arg)) {
                throw new InvalidArgumentException("parameter is not a valid uri or prefixed URI: " + arg);
            }
            if (context.isURI(arg)) {
                CURIE curie = context.getCURIE(arg);
                if (curie == null) {
                    try {
                        System.out.println(context.getURI(arg));
                    } catch (URISyntaxException e) {
                        throw new InvalidArgumentException(e);
                    }
                } else {
                    System.out.println("[" + curie + "]");
                }
            } else {
                System.out.println("[" + context.getCURIE(arg) + "]");
            }
        }
        return 0;
    }

    public void printHelp(IConsole consoleWriter) {

        String header = "Collapse all URI arguments to prefixed URIs (CURIEs) using user defined prefixes.  URIs that have no matching prefix will be returned unchanged.";
        String syntax = "anzo collapse [options] [URI...]";
        Options options = getOptions();
        CommandLineInterface.appendGlobalOptions(options);
        consoleWriter.printHelp( syntax, header, options, null);
    }

}
