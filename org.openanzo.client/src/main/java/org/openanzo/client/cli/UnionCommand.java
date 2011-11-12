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
import org.apache.commons.lang.ObjectUtils;
import org.openanzo.client.AnzoClient;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Dataset;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.ReadWriteUtils;

/**
 * Unions together RDF from files and STDIN.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
class UnionCommand extends RdfIOCommand {

    private static final Option BASE          = new Option("b", "base", true, "Set the base URI of the input RDF file(s) or URI(s)");

    private static final Option INPUT_FORMAT  = new Option("i", "input-format", true, "Overide the default RDF format associated with RDF input(s).");

    private static final Option OUTPUT_FORMAT = new Option("o", "output-format", true, "Overide the default RDF format associated with the RDF output(s)");

    private static final Option GRAPH         = new Option("g", "graph", true, "Named graph uri to use for rdf inputs that do not support named graph serialization");

    private static final Option READ_STDIN    = new Option("s", "--read-stdin", false, "Read RDF from STDIN in addition to files and URIs.");

    private static final Option ENCODING      = new Option("e", "encoding", true, "Override the default charset for uploading RDF files.");

    static {
        BASE.setArgName("URI");
        INPUT_FORMAT.setArgName("format");
        OUTPUT_FORMAT.setArgName("format");
        GRAPH.setArgName("URI");
    }

    public String getName() {
        return "union";
    }

    public Options getOptions() {
        Options options = new Options();
        options.addOption(BASE);
        options.addOption(INPUT_FORMAT);
        options.addOption(OUTPUT_FORMAT);
        options.addOption(GRAPH);
        options.addOption(READ_STDIN);
        options.addOption(ENCODING);
        return options;
    }

    public int invoke(CommandLine cl, CommandContext context, AnzoClient client) throws AnzoException {
        String[] args = cl.getArgs();
        RDFFormat inputFormatOverride = getFormatOption(cl, INPUT_FORMAT);
        RDFFormat outputFormat = getFormatOption(cl, OUTPUT_FORMAT, CommandLineInterface.DEFAULT_RDF_FORMAT);
        String charsetName = getEncodingOption(cl, ENCODING);
        Collection<RdfInputArgument> inputs = getArgumentsAsStreams(cl, context, args, 0, args.length, inputFormatOverride, charsetName);

        URI defaultNamedGraphUri = getURIOption(cl, GRAPH, context);
        URI base = getURIOption(cl, BASE, context);

        if (args.length == 0) {
            if (inputFormatOverride == null) {
                inputs.add(new RdfInputArgument(System.in, RDFFormat.forFileName("." + CommandLineInterface.DEFAULT_RDF_FORMAT), charsetName));
            } else {
                inputs.add(new RdfInputArgument(System.in, inputFormatOverride, charsetName));
            }
        }

        return union(context, client, inputs, outputFormat, defaultNamedGraphUri, base);
    }

    public int union(CommandContext context, AnzoClient client, Collection<RdfInputArgument> inputs, RDFFormat outputFormat, URI defaultNamedGraphUri, URI base) throws AnzoException {
        IDataset store = new Dataset();
        INamedGraph defaultNamedGraph = null;

        if (defaultNamedGraphUri == null && inputs.size() == 1) {
            defaultNamedGraphUri = inputs.iterator().next().getDefaultGraphURI();
        }

        if (defaultNamedGraphUri != null) {
            store.addNamedGraph(defaultNamedGraphUri);
            defaultNamedGraph = store.getNamedGraph(defaultNamedGraphUri);
        }

        for (RdfInputArgument input : inputs) {
            Reader in = input.getReader();
            RDFFormat fileFormat = input.getFormat();

            URI inputBase = base;
            if (inputBase == null) {
                inputBase = input.getDefaultGraphURI();
            }
            if (!fileFormat.supportsNamedGraphs()) {

                INamedGraph inputNamedGraph = defaultNamedGraph;
                if (inputNamedGraph == null) {
                    URI uri = input.getDefaultGraphURI();
                    if (uri != null) {
                        store.addNamedGraph(uri);
                        inputNamedGraph = store.getNamedGraph(uri);
                    }
                }

                if (inputNamedGraph == null) {
                    throw new InvalidArgumentException(GRAPH.getLongOpt() + " option must be set for format " + fileFormat + " since this format does not support named graphs");
                }
                ReadWriteUtils.loadGraph(inputNamedGraph, in, fileFormat, ObjectUtils.toString(inputBase));
            } else {
                ReadWriteUtils.loadQuadStore(store, in, fileFormat, ObjectUtils.toString(inputBase));
            }

        }
        context.outputRdf(store, outputFormat);
        return 0;
    }

    public void printHelp(IConsole consoleWriter) {
        String header = "Unions RDF from the arguments and optionally from STDIN as well.";
        String syntax = "anzo union [options] [RDF-INPUT-FILE-OR-URI...]";
        String footer = "RDF format options are: " + CommandLineInterface.getRDFFormatOptionsString();
        Options options = getOptions();
        CommandLineInterface.appendGlobalOptions(options);
        consoleWriter.printHelp( syntax, header, options, footer);
    }

}
