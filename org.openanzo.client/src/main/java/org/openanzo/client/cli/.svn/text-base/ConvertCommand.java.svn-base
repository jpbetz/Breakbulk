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
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.lang.ObjectUtils;
import org.openanzo.client.AnzoClient;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.Pair;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.rdf.utils.ReadWriteUtils.StatementsAndPrefixes;

class ConvertCommand extends RdfIOCommand {

    private static final Option BASE              = new Option("b", "base", true, "Set the base URI of the input RDF file(s)");

    private static final Option OUTPUT_FORMAT     = new Option("o", "output-format", true, "Overide the default RDF format associated with the RDF outputs(s)");

    private static final Option INPUT_FORMAT      = new Option("i", "input-format", true, "Overide the default RDF format associated with the RDF inputs(s)");

    private static final Option GRAPH             = new Option("g", "graph", true, "Optional. Named graph URI to use for RDF input files that do not support named graph serialization.");

    private static final Option NO_INPUT_PREFIXES = new Option("xi", "exclude-input-prefixes", false, "Don't include prefixes from the input file in the output file.");

    private static final Option ENCODING          = new Option("e", "encoding", true, "Override the default charset for uploading RDF files.");

    static {
        BASE.setArgName("URI");
        GRAPH.setArgName("URI");
        OUTPUT_FORMAT.setArgName("format");
        INPUT_FORMAT.setArgName("format");
    }

    public String getName() {
        return "convert";
    }

    public Options getOptions() {
        Options options = new Options();
        options.addOption(NO_INPUT_PREFIXES);
        options.addOption(BASE);
        options.addOption(GRAPH);
        options.addOption(OUTPUT_FORMAT);
        options.addOption(INPUT_FORMAT);
        options.addOption(ENCODING);
        return options;
    }

    public int invoke(CommandLine cl, CommandContext context, AnzoClient client) throws AnzoException {

        String[] args = cl.getArgs();
        if (args.length > 2) {
            throw new InvalidArgumentException("Incorrect argument count.  At most an input file argument and an output file argument may be provided.");
        }

        RDFFormat overrideInputFormat = getFormatOption(cl, INPUT_FORMAT);
        RDFFormat overrideOutputFormat = getFormatOption(cl, OUTPUT_FORMAT);

        URI defaultNamedGraphUri = getURIOption(cl, GRAPH, context);
        URI base = getURIOption(cl, BASE, context);
        boolean excludeFilePrefixes = cl.hasOption(NO_INPUT_PREFIXES.getOpt());
        String charsetName = getEncodingOption(cl, ENCODING);

        RdfInputArgument input;
        if (args.length > 0) {
            input = getArgumentAsInputStream(context, args[0], overrideInputFormat, charsetName);
        } else {
            if (overrideInputFormat == null) {
                input = new RdfInputArgument(System.in, RDFFormat.forFileName("." + CommandLineInterface.DEFAULT_RDF_FORMAT), charsetName);
            } else {
                input = new RdfInputArgument(System.in, overrideInputFormat, charsetName);
            }
        }

        RDFFormat outputFormat = null;
        Writer out = null;
        if (args.length > 1) {
            Pair<Writer, RDFFormat> output = getFileArgumentAsOutputStream(context, args[1], overrideOutputFormat);
            out = output.first;
            outputFormat = output.second;
        } else {
            out = new OutputStreamWriter(System.out);
            if (overrideOutputFormat == null) {
                outputFormat = RDFFormat.forFileName("." + CommandLineInterface.DEFAULT_RDF_FORMAT);
            } else {
                outputFormat = overrideOutputFormat;
            }
        }

        if (base == null) {
            base = input.getDefaultGraphURI();
        }

        return convert(context, client, input, out, outputFormat, defaultNamedGraphUri, base, excludeFilePrefixes);

    }

    // TODO: optimize by connecting reader directly to writer instead of loading everything into memory before writing.
    int convert(CommandContext context, AnzoClient client, RdfInputArgument input, Writer writer, RDFFormat outputFormat, URI defaultNamedGraphUri, URI base, boolean excludeFilePrefixes) throws AnzoException {
        int result = 1;

        RDFFormat inputFormat = input.getFormat();
        Reader in = input.getReader();
        Map<String, String> prefixes = Collections.emptyMap();
        Collection<Statement> statements = new HashSet<Statement>();
        if (!inputFormat.supportsNamedGraphs()) {
            if (defaultNamedGraphUri == null) {
                defaultNamedGraphUri = input.getDefaultGraphURI();
            }
            if (defaultNamedGraphUri == null && outputFormat.supportsNamespaces()) {
                defaultNamedGraphUri = UriGenerator.generateNamedGraphUri();
            }
            StatementsAndPrefixes sP = ReadWriteUtils.loadStatementsAndPrefixes(in, inputFormat, ObjectUtils.toString(base), defaultNamedGraphUri);
            prefixes = sP.getPrefixes();
            statements.addAll(sP.getStatements());
        } else {
            StatementsAndPrefixes stmtsAndPrefixes = ReadWriteUtils.loadStatementsAndPrefixes(in, inputFormat, ObjectUtils.toString(base), null);
            statements.addAll(stmtsAndPrefixes.getStatements());
            prefixes = stmtsAndPrefixes.getPrefixes();
        }
        context.outputRdf(statements, outputFormat, writer, excludeFilePrefixes ? Collections.<String, String> emptyMap() : prefixes);
        result = 0;

        return result;
    }

    public void printHelp(IConsole consoleWriter) {

        String header = "Converts between the various RDF file formats.  Read from STDIN or the filename from the first argument, if present.  Writes to STDOUT or the second argument, if present.";
        String syntax = "anzo convert [options] [RDF-INPUT-FILE-OR-URI [RDF-OUTPUT-FILE] ]";
        String footer = "RDF format options are: " + CommandLineInterface.getRDFFormatOptionsString();
        Options options = getOptions();
        CommandLineInterface.appendGlobalOptions(options);
        consoleWriter.printHelp( syntax, header, options, footer);
    }

}
