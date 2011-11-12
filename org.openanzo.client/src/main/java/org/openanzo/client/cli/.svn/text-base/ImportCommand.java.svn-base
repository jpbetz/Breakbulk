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

import java.io.Reader;
import java.util.Collection;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.openanzo.client.AnzoClient;
import org.openanzo.client.INamedGraphInitializer;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.IStatementsHandler;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Imports statement into the server.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
class ImportCommand extends RdfUploadCommand {
    private static final Logger log             = LoggerFactory.getLogger(ImportCommand.class);

    private static final Option TEMPLATE_OPTION = new Option("l", "template", true, "Template File.");

    private static final Option VERBOSE_OPTION  = new Option("v", "verbose", false, "Verbose output during import.");

    private static final Option ENCODING        = new Option("e", "encoding", true, "Override the default charset for uploading RDF files.");

    private static final Option BATCH_SIZE      = new Option("s", "batch", true, "Batch size for import operation.");

    static {
        TEMPLATE_OPTION.setArgName("file | URI");
    }

    @Override
    public Options getOptions() {
        Options options = super.getOptions();
        options.addOption(TEMPLATE_OPTION);
        options.addOption(VERBOSE_OPTION);
        options.addOption(ENCODING);
        options.addOption(BATCH_SIZE);
        return options;
    }

    public String getName() {
        return "import";
    }

    private class VerboseHandler implements IStatementsHandler {
        long totalHandled   = 0;

        long last10kPrinted = 0;

        public void handleStatements(Collection<Statement> statements) throws AnzoException {
            totalHandled += statements.size();
            if (totalHandled / 10000 != last10kPrinted) {
                last10kPrinted = totalHandled / 10000;
                System.out.println(" [" + totalHandled + "] statements imported");
            } else {
                System.out.print(".");
                System.out.flush();
            }
        }
    }

    @Override
    protected int update(CommandLine cl, CommandContext context, AnzoClient client, Collection<RdfInputArgument> inputs, URI defaultNamedGraphUri, URI base, boolean nonRevisioned) throws AnzoException {
        RDFFormat templateFormat = getFormatOption(cl, INPUT_FORMAT);
        boolean verbose = cl.hasOption(VERBOSE_OPTION.getOpt());
        String charsetName = getEncodingOption(cl, ENCODING);
        if (defaultNamedGraphUri == null && inputs.size() == 1) {
            defaultNamedGraphUri = inputs.iterator().next().getDefaultGraphURI();
        }
        RdfInputArgument templateInput = getRdfInputOption(context, cl, TEMPLATE_OPTION, templateFormat, charsetName);
        Collection<Statement> templateStatements = null;
        if (templateInput != null) {
            templateStatements = ReadWriteUtils.loadStatements(templateInput.getReader(), templateInput.getFormat(), (base != null) ? base.toString() : null);
        }

        int batchSize = 20000;
        if (cl.hasOption(BATCH_SIZE.getOpt())) {
            String bs = cl.getOptionValue(BATCH_SIZE.getOpt());
            try {
                batchSize = Integer.parseInt(bs);
            } catch (NumberFormatException nfe) {

            }
        }
        int result = 1;
        boolean owns = false;
        try {
            owns = !client.isConnected();
            if (owns) {
                client.connect();
                printOnConnectionSuccess(context);
            }
            for (RdfInputArgument input : inputs) {
                try {
                    if (verbose && input.inputName != null)
                        System.out.println("Importing: " + input.inputName);
                    Reader in = input.getReader();
                    RDFFormat fileFormat = input.getFormat();

                    URI inputBase = base;
                    if (inputBase == null) {
                        inputBase = input.getDefaultGraphURI();
                    }

                    if (!fileFormat.supportsNamedGraphs() && defaultNamedGraphUri == null) {
                        throw new InvalidArgumentException(GRAPH.getLongOpt() + " option must be set for format " + fileFormat + " since this format does not support named graphs");
                    }

                    if (templateStatements != null) {
                        client.importStatements(in, fileFormat, (base != null) ? base.toString() : null, defaultNamedGraphUri, batchSize, templateStatements, ((verbose) ? new VerboseHandler() : null));
                    } else {
                        client.importStatements(in, fileFormat, (base != null) ? base.toString() : null, defaultNamedGraphUri, batchSize, ((verbose) ? new VerboseHandler() : null), getNamedGraphInitializers(nonRevisioned));
                    }
                    if (verbose)
                        System.out.println();

                } catch (AnzoException e) {
                    context.writeError("Error loading RDF Input: " + input.inputName);
                    context.getConsoleWriter().printException(e, context.getShowTrace());
                    throw e;
                }

            }
            result = 0;

            return result;
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
        String header = "Imports statements into the repository, creating graphs in the repository as needed. Reads from the arguments or from STDIN if no input arguments are provided.";
        String syntax = "anzo import [options] [RDF-INPUT-FILE-OR-URI...]";
        String footer = "RDF format options are: " + CommandLineInterface.getRDFFormatOptionsString();
        Options options = getOptions();
        CommandLineInterface.appendGlobalOptions(options);
        consoleWriter.printHelp( syntax, header, options, footer);
    }

    @Override
    public INamedGraphInitializer[] getNamedGraphInitializers() {
        return new INamedGraphInitializer[] {};
    }

}
