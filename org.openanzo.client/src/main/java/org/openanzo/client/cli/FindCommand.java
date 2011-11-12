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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.openanzo.client.AnzoClient;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.utils.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Find statements from the anzo repository and prints them in serialized rdf formats.
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
class FindCommand extends RdfIOCommand {
    private static final Logger log              = LoggerFactory.getLogger(FindCommand.class);

    private String              wildcard         = "w";

    private static final Option OUTPUT_FORMAT    = new Option("o", "output-format", true, "Overide the default RDF format associated with the RDF output(s)");

    private static final Option SUBJECT          = new Option("sub", "subject", true, "The subject of find pattern, w indicates a wildcard match");

    private static final Option PREDICATE        = new Option("pred", "predicate", true, "The predicate of find pattern, w indicates a wildcard match");

    private static final Option URI_OBJECT       = new Option("uri", "uri-object", true, "The uri object of find pattern, w indicates a wildcard match");

    private static final Option LITERAL_OBJECT   = new Option("lit", "literal-object", true, "The literal object of find pattern, w indicates a wildcard match");

    private static final Option LITERAL_DATATYPE = new Option("type", "literal-datatype", true, "The literal datatype");

    private static final Option LITERAL_LANGUAGE = new Option("lang", "literal-language", true, "The literal language");

    private static final Option OUTPUT_FILE      = new Option("f", "output-file", true, "write the find results to a file");

    private static final Option COUNT_STMTS      = new Option("n", "count", false, "Outputs only the total number of matching statements");

    static {
        OUTPUT_FORMAT.setArgName("format");
        OUTPUT_FILE.setArgName("file");
    }

    public String getName() {
        return "find";
    }

    public Options getOptions() {
        Options options = new Options();
        options.addOption(OUTPUT_FORMAT);
        options.addOption(OUTPUT_FILE);
        options.addOption(SUBJECT);
        options.addOption(PREDICATE);
        options.addOption(URI_OBJECT);
        options.addOption(LITERAL_OBJECT);
        options.addOption(LITERAL_DATATYPE);
        options.addOption(LITERAL_LANGUAGE);
        options.addOption(COUNT_STMTS);
        return options;
    }

    public int invoke(CommandLine cl, CommandContext context, AnzoClient client) throws AnzoException {

        int result = 1;
        RDFFormat outputFormatOverride = getFormatOption(cl, OUTPUT_FORMAT);
        Pair<File, RDFFormat> output = getFileOption(cl, OUTPUT_FILE, outputFormatOverride, false);

        Writer out = null;
        RDFFormat outputFormat = null;
        if (output == null) {
            out = new OutputStreamWriter(System.out);
            if (outputFormatOverride == null) {
                outputFormat = RDFFormat.forFileName("." + CommandLineInterface.DEFAULT_RDF_FORMAT);
            } else {
                outputFormat = outputFormatOverride;
            }
        } else {
            try {
                out = new OutputStreamWriter(new FileOutputStream(output.first), Constants.byteEncoding);
            } catch (FileNotFoundException e) {
                throw new InvalidArgumentException("Output file not found:" + output.first.getAbsolutePath());
            } catch (IOException e) {
                throw new InvalidArgumentException("Error writing to output file:" + output.first.getAbsolutePath() + " [" + e.getMessage() + "]");
            }
            outputFormat = output.second;
        }

        String subStr = cl.getOptionValue("sub");
        if (subStr == null) {
            subStr = wildcard;
        }
        String predStr = cl.getOptionValue("pred");
        if (predStr == null) {
            predStr = wildcard;
        }
        String litStr = cl.getOptionValue("lit");
        String uriStr = null;
        if (litStr == null) {
            uriStr = cl.getOptionValue("uri");
        }

        try {
            URI subject = subStr.equals(wildcard) ? null : context.getURI(subStr);
            URI predicate = predStr.equals(wildcard) ? null : context.getURI(predStr);

            Value object = null;

            if (litStr != null) {
                if (!litStr.equals(wildcard)) {
                    String datatype = cl.getOptionValue("type");
                    String lang = cl.getOptionValue("lang");
                    if (datatype != null) {
                        object = Constants.valueFactory.createLiteral(litStr, context.getURI(datatype));
                    } else if (lang != null) {
                        object = Constants.valueFactory.createLiteral(litStr, lang);
                    } else {
                        object = Constants.valueFactory.createLiteral(litStr);
                    }
                }
            } else if (uriStr != null) {
                object = uriStr.equals(wildcard) ? null : context.getURI(uriStr);
            }

            List<URI> graphs = getURIArguments(cl.getArgs(), 0, cl.getArgs().length, context);

            boolean owns = false;
            try {
                owns = !client.isConnected();
                if (owns) {
                    client.connect();
                    printOnConnectionSuccess(context);
                }
                Collection<Statement> stmts = client.serverFind(subject, predicate, object, graphs.toArray(new URI[graphs.size()]));
                if (cl.hasOption("n")) {
                    System.out.println(stmts.size());
                } else {
                    context.outputRdf(stmts, outputFormat, out);
                }
                result = 0;
            } finally {
                try {
                    if (owns)
                        client.close();
                } catch (AnzoRuntimeException e) {
                    log.error("Error closing connection", e);
                }
            }
        } catch (URISyntaxException e) {
            throw new CommandException(e, "play");
        }
        return result;
    }

    public void printHelp(IConsole consoleWriter) {
        String header = "Retrieves statements from the server via simple pattern find.";
        String syntax = "anzo find [options] [NAMED-GRAPH-URI...]";
        String footer = "RDF format options are: " + CommandLineInterface.getRDFFormatOptionsString();
        Options options = getOptions();
        CommandLineInterface.appendGlobalOptions(options);
        consoleWriter.printHelp( syntax, header, options, footer);
    }

}
