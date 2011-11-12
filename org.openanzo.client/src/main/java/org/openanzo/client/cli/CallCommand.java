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

import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.lang.ObjectUtils;
import org.openanzo.client.AnzoClient;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.rdf.Dataset;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Executes a semantic service on the server.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
class CallCommand extends RdfIOCommand {
    private static final Logger log           = LoggerFactory.getLogger(CallCommand.class);

    private static final Option BASE          = new Option("b", "base", true, "Set the base URI of the input RDF file(s) or URI(s)");

    private static final Option OUTPUT_FORMAT = new Option("o", "output-format", true, "Overide the default RDF format associated with the RDF input(s)");

    private static final Option INPUT_FORMAT  = new Option("i", "input-format", true, "Overide the default RDF format associated with the RDF output(s)");

    private static final Option TIME_OPTION   = new Option("y", "time", false, "Print time in milliseconds to STDERR.");

    private static final Option ENCODING      = new Option("e", "encoding", true, "Override the default charset for uploading RDF files.");

    static {
        BASE.setArgName("URI");
        OUTPUT_FORMAT.setArgName("format");
        INPUT_FORMAT.setArgName("format");
    }

    public String getName() {
        return "call";
    }

    public Options getOptions() {
        Options options = new Options();
        options.addOption(BASE);
        options.addOption(OUTPUT_FORMAT);
        options.addOption(INPUT_FORMAT);
        options.addOption(TIME_OPTION);
        options.addOption(ENCODING);
        return options;
    }

    public int invoke(CommandLine cl, CommandContext context, AnzoClient client) throws AnzoException {
        String[] args = cl.getArgs();

        if (args.length > 2 || args.length < 1) {
            throw new InvalidArgumentException("Incorrect argument count.  A serviceGraph argument is required and an input file is optional.");
        }

        RDFFormat outputFormat = getFormatOption(cl, OUTPUT_FORMAT, CommandLineInterface.DEFAULT_RDF_FORMAT);
        RDFFormat inputOverrideFormat = getFormatOption(cl, INPUT_FORMAT);
        URI serviceUri = getURIArgument(args[0], context);
        URI base = getURIOption(cl, BASE, context);
        boolean time = isFlagSet(cl, TIME_OPTION);
        String charsetName = getEncodingOption(cl, ENCODING);

        RdfInputArgument input;
        if (args.length == 2) {
            input = getArgumentAsInputStream(context, args[1], inputOverrideFormat, charsetName);

        } else {
            if (inputOverrideFormat == null) {
                throw new InvalidArgumentException(INPUT_FORMAT.getLongOpt() + " option must be set when reading from STDIN.");
            }
            input = new RdfInputArgument(System.in, inputOverrideFormat, charsetName);
        }

        return call(context, client, time, serviceUri, input, new OutputStreamWriter(System.out), outputFormat, base);
    }

    private int call(CommandContext context, AnzoClient client, boolean time, URI serviceUri, RdfInputArgument input, Writer output, RDFFormat outputFormat, URI base) throws AnzoException {
        int result = 1;
        boolean owns = false;
        long start = (time) ? System.currentTimeMillis() : 0;
        try {
            owns = !client.isConnected();
            if (owns) {
                client.connect();
                printOnConnectionSuccess(context);
            }
            IDataset storeIn = new Dataset();

            Reader in = input.getReader();
            RDFFormat inputFormat = input.getFormat();

            if (base == null) {
                base = input.getDefaultGraphURI();
            }

            ReadWriteUtils.loadQuadStore(storeIn, in, inputFormat, ObjectUtils.toString(base));

            Collection<Statement> stmts = client.executeService(serviceUri, storeIn.getStatements());

            Dataset storeOut = new Dataset();
            context.populateDataset(storeOut, stmts);
            context.outputRdf(storeOut, outputFormat, output);
            if (time) {
                context.writeOutput("execution time (ms): " + (System.currentTimeMillis() - start));
            }
            result = 0;
        } finally {
            try {
                if (owns) {
                    client.close();
                }
            } catch (AnzoRuntimeException e) {
                log.error("Error closing connection", e);
            }
        }
        return result;
    }

    public void printHelp(IConsole consoleWriter) {

        String header = "Calls an anzo semantic service and prints the service response to the console.  Reads service request from the argument, or from STDIN if no input argument is provided.";
        String syntax = "anzo call [options] SERVICE-URI [RDF-REQUEST-FILE-OR-URI]";
        String footer = "RDF format options are: " + CommandLineInterface.getRDFFormatOptionsString();
        Options options = getOptions();
        CommandLineInterface.appendGlobalOptions(options);
        consoleWriter.printHelp( syntax, header, options, footer);
    }

}
