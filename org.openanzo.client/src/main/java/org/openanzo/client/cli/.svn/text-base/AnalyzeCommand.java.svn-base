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

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.openanzo.analysis.CsvOutputRequestHandler;
import org.openanzo.analysis.RequestHandlerOutputProvider;
import org.openanzo.analysis.RequestParser;
import org.openanzo.client.AnzoClient;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.utils.SmartEncodingInputStream;

/**
 * Command to analyze performance information
 * 
 */
class AnalyzeCommand extends RdfIOCommand {

    private static final Option REQUEST_INPUT_OPTION = new Option("f", "analysis-input", true, "Analyze the information in the given file");

    private static final Option OUTPUT_FORMAT        = new Option("o", "output-format", true, "Override the default format associated with the Anzo analysis outputs");

    private static final Option ENCODING             = new Option("e", "encoding", true, "Override the default charset for uploading RDF files.");

    // right now we can only parse the "raw" analysis format
    //private static final Option INPUT_FORMAT      = new Option("i", "input-format", true, "Override the default RDF format associated with the RDF inputs(s)");
    static {
        OUTPUT_FORMAT.setArgName("format");
        REQUEST_INPUT_OPTION.setArgName("file | URI");
        //        INPUT_FORMAT.setArgName("format");
    }

    public String getName() {
        return "analyze";
    }

    public Options getOptions() {
        Options options = new Options();
        options.addOption(REQUEST_INPUT_OPTION);
        options.addOption(OUTPUT_FORMAT);
        //        options.addOption(INPUT_FORMAT);
        options.addOption(ENCODING);
        return options;
    }

    static enum AnalysisFormat {
        RAW(null, "Raw output from analysis package"), CSV(CsvOutputRequestHandler.class, "CSV suitable for importing into a spreadsheet"), TRIG(null, "RDF suitable for advanced visualization & analysis");

        private RequestHandlerOutputProvider rhop = null;

        private String                       description;

        private AnalysisFormat(Class<? extends RequestHandlerOutputProvider> rhopClass, String description) {
            try {
                this.rhop = rhopClass != null ? rhopClass.newInstance() : null;
                this.description = description;
            } catch (Exception e) {
                this.rhop = null;
            }
        }

        public static AnalysisFormat fromString(String s) {
            for (AnalysisFormat af : AnalysisFormat.values())
                if (af.toString().equalsIgnoreCase(s))
                    return af;
            return null;
        }

        public static String getAllFormatsString() {
            StringBuilder builder = new StringBuilder();
            for (AnalysisFormat af : AnalysisFormat.values()) {
                builder.append("\t'" + af.toString() + "' (" + af.description + ")");
                builder.append("\n");
            }
            return builder.toString();
        }
    }

    public int invoke(CommandLine cl, CommandContext context, AnzoClient client) throws AnzoException {
        AnalysisFormat outputFormat = AnalysisFormat.CSV;
        Reader input = null;
        try {
            if (cl.hasOption(OUTPUT_FORMAT.getOpt()))
                outputFormat = AnalysisFormat.fromString(cl.getOptionValue(OUTPUT_FORMAT.getOpt()));

            String charsetName = getEncodingOption(cl, ENCODING);
            if (!cl.hasOption(REQUEST_INPUT_OPTION.getOpt())) {
                input = SmartEncodingInputStream.createSmartReader(System.in);
            } else {
                input = getRdfInputOption(context, cl, REQUEST_INPUT_OPTION, null, charsetName).getReader();
            }
        } catch (AnzoException e) {
            throw new InvalidArgumentException(e);
        }
        RequestParser parser = new RequestParser();
        RequestHandlerOutputProvider rhop = outputFormat.rhop;
        rhop.setOutputStream(System.out);
        rhop.start();
        try {
            parser.parseRequest(input, rhop);
        } catch (Exception e) {
            throw new CommandException(e, "Error parsing request");
        }
        rhop.end();
        return 0;
    }

    public void printHelp(IConsole consoleWriter) {
        HelpFormatter formatter = new HelpFormatter();
        String header = "Provides several flavors of analysis for Anzo request/response logs.";
        String syntax = "anzo analyze [options] [-o OUTPUT_FORMAT] [-f INPUT-FILE]";
        String footer = "Analysis log format options are: \n" + AnalysisFormat.getAllFormatsString() + "\n";
        Options options = getOptions();
        CommandLineInterface.appendGlobalOptions(options);
        consoleWriter.printHelp( syntax, header, options, footer);
    }

}
