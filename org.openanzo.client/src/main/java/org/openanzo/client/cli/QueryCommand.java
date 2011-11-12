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

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ObjectUtils;
import org.openanzo.client.AnzoClient;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.Engine;
import org.openanzo.glitter.EngineConfig;
import org.openanzo.glitter.MockEngineConfig;
import org.openanzo.glitter.ParseOnlyEngineConfig;
import org.openanzo.glitter.dataset.DefaultQueryDataset;
import org.openanzo.glitter.query.QueryController;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.glitter.query.QueryController.QueryStringPrintOptions;
import org.openanzo.glitter.syntax.concrete.ParseException;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Dataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.rdf.Constants.OPTIONS;
import org.openanzo.rdf.query.QuadStoreEngineConfig;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.services.serialization.CommonSerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Executes a SPARQL query against the server.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
class QueryCommand extends RdfIOCommand {
    private static final String NEWLINE_PATTERN             = "\r\n|\r|\n";

    private static final String GLITTER_LINE_COLUMN_PATTERN = "at line (\\d+), column (\\d+).";

    private static final Logger log                         = LoggerFactory.getLogger(QueryCommand.class);

    private static final Option BASE_OPTION                 = new Option("b", "base", true, "Set the base URI of the input RDF file(s) or URI(s)");

    private static final Option QUERY_INPUT_OPTION          = new Option("f", "query-input", true, "Run the query in the file or URI");

    private static final Option DATASET_INPUT_OPTION        = new Option("d", "dataset-input", true, "Query against the dataset from the file or URI");

    private static final Option ALL_GRAPHS_DEFAULT          = new Option("a", "add-default-graphs", false, "Query against a default graph composed of the merge of all named graphs in the repository");

    private static final Option ALL_GRAPHS_NAMED            = new Option("A", "add-named-graphs", false, "Query against a dataset composed of all named graphs in the repository");

    private static final Option ALL_METADATA_GRAPHS_DEFAULT = new Option("m", "add-metadata-default-graphs", false, "Query against a default graph composed of the merge of all metadata graphs in the repository");

    private static final Option ALL_METADATA_GRAPHS_NAMED   = new Option("M", "add-metadata-named-graphs", false, "Query against a dataset composed of all metadata graphs in the repository");

    private static final Option OUTPUT_FORMAT               = new Option("o", "output-format", true, "Overide the default RDF format associated with the RDF output(s)");

    private static final Option INPUT_FORMAT                = new Option("i", "input-format", true, "Overide the default RDF format associated with the RDF input(s)");

    private static final Option QUERY_TIME_OPTION           = new Option("y", "query-time", false, "Print query time in milliseconds to STDERR.");

    private static final Option DATASET_FROM_STDIN          = new Option("s", "dataset-stdin", false, "Query the dataset from STDIN.");

    private static final Option PARSE_AND_PRINT             = new Option("P", "pretty-print", false, "Parses and pretty-prints the query, without running it");

    private static final Option REWRITE_AND_PRINT           = new Option("R", "rewrite", false, "Rewrites the query via standard optimizations and then pretty-prints it, without running it");

    private static final Option DATASOURCE_OPTION           = new Option("r", "datasource", true, "URI of the datasource to query, if other than primary datasource.  Option not available for dataset queries.");

    private static final Option SKIP_CACHE_OPTION           = new Option("k", "skipCache", false, "Skip server cache for query.");

    private static final Option ENCODING                    = new Option("e", "encoding", true, "Override the default charset for uploading RDF files.");

    static {
        BASE_OPTION.setArgName("URI");
        QUERY_INPUT_OPTION.setArgName("file | URI");
        DATASET_INPUT_OPTION.setArgName("file | URI");
        OUTPUT_FORMAT.setArgName("format");
        INPUT_FORMAT.setArgName("format");
    }

    public String getName() {
        return "query";
    }

    public Options getOptions() {
        Options options = new Options();
        options.addOption(BASE_OPTION);
        options.addOption(QUERY_INPUT_OPTION);
        options.addOption(DATASET_INPUT_OPTION);
        options.addOption(ALL_GRAPHS_DEFAULT);
        options.addOption(ALL_GRAPHS_NAMED);
        options.addOption(ALL_METADATA_GRAPHS_DEFAULT);
        options.addOption(ALL_METADATA_GRAPHS_NAMED);
        options.addOption(OUTPUT_FORMAT);
        options.addOption(INPUT_FORMAT);
        options.addOption(DATASET_FROM_STDIN);
        options.addOption(QUERY_TIME_OPTION);
        options.addOption(PARSE_AND_PRINT);
        options.addOption(REWRITE_AND_PRINT);
        options.addOption(DATASOURCE_OPTION);
        options.addOption(SKIP_CACHE_OPTION);
        options.addOption(ENCODING);
        return options;
    }

    public int invoke(CommandLine cl, CommandContext context, AnzoClient client) throws AnzoException {
        // add query only formats

        RDFFormat outputFormat = getFormatOption(cl, OUTPUT_FORMAT, CommandLineInterface.DEFAULT_RDF_FORMAT);
        RDFFormat inputFormat = getFormatOption(cl, INPUT_FORMAT);
        String charsetName = getEncodingOption(cl, ENCODING);
        RdfInputArgument datasetInput = getRdfInputOption(context, cl, DATASET_INPUT_OPTION, inputFormat, charsetName);
        RdfInputArgument queryInput = getRdfInputOption(context, cl, QUERY_INPUT_OPTION, null, charsetName);
        URI base = getURIOption(cl, BASE_OPTION, context);
        boolean allDefaultGraphs = isFlagSet(cl, ALL_GRAPHS_DEFAULT);
        boolean allNamedGraphs = isFlagSet(cl, ALL_GRAPHS_NAMED);
        boolean allMetadataDefaultGraphs = isFlagSet(cl, ALL_METADATA_GRAPHS_DEFAULT);
        boolean allMetadataNamedGraphs = isFlagSet(cl, ALL_METADATA_GRAPHS_NAMED);

        boolean queryTime = isFlagSet(cl, QUERY_TIME_OPTION);

        boolean datasetFromStdin = isFlagSet(cl, DATASET_FROM_STDIN);

        boolean prettyPrint = isFlagSet(cl, PARSE_AND_PRINT);
        boolean rewriteAndPrint = isFlagSet(cl, REWRITE_AND_PRINT);
        boolean skipcache = isFlagSet(cl, SKIP_CACHE_OPTION);

        URI datasource = getURIOption(cl, DATASOURCE_OPTION, context);

        String[] args = cl.getArgs();

        if (datasetFromStdin) {
            if (datasetInput != null) {
                throw new InvalidArgumentException("Cannot set both " + DATASET_FROM_STDIN.getLongOpt() + " and " + DATASET_INPUT_OPTION.getLongOpt() + " options.");
            }
            if (queryInput == null && args.length == 0) {
                throw new InvalidArgumentException("Query must be provided in arguments or by " + QUERY_INPUT_OPTION.getLongOpt() + " option if " + DATASET_FROM_STDIN + " option is set.");
            }

            if (inputFormat == null) {
                datasetInput = new RdfInputArgument(System.in, RDFFormat.forFileName("." + CommandLineInterface.DEFAULT_RDF_FORMAT), charsetName);
            } else {
                datasetInput = new RdfInputArgument(System.in, inputFormat, charsetName);
            }

        }

        String query = null;

        if (args.length == 0) {
            try {
                if (queryInput == null) {
                    query = IOUtils.toString(System.in, Constants.byteEncoding);
                } else {
                    query = IOUtils.toString(queryInput.getReader());
                }
            } catch (IOException ioe) {
                throw new InvalidArgumentException(ioe, "Unable to read query");
            }
        } else {
            if (queryInput != null) {
                throw new InvalidArgumentException("Cannot set both query string arguments and the " + QUERY_INPUT_OPTION + " option.");
            }

            // create a string from all arguments
            StringBuilder builder = new StringBuilder();
            for (String arg : args) {
                builder.append(arg);
                builder.append(" ");
            }
            query = builder.toString();
        }

        if (base == null && datasetInput != null) {
            base = datasetInput.getDefaultGraphURI();
        }
        return query(context, client, query, outputFormat, allDefaultGraphs, allNamedGraphs, allMetadataDefaultGraphs, allMetadataNamedGraphs, datasetInput, queryTime, base, prettyPrint, rewriteAndPrint, skipcache, datasource);

    }

    int query(CommandContext context, AnzoClient client, String query, RDFFormat outputFormat, boolean allDefaultGraphs, boolean allNamedGraphs, boolean allMetadataDefaultGraphs, boolean allMetadataNamedGraphs, RdfInputArgument datasetInput, boolean queryTime, URI base, boolean prettyPrint, boolean rewriteAndPrint, boolean skipCache, URI datasource) throws AnzoException {

        QueryResults queryResults = null;

        String fullQuery = null;
        StringBuilder builder = new StringBuilder();

        int hiddenPrefixCount = 0;
        if (!context.getExcludePrefixes()) {
            hiddenPrefixCount = context.getPrefixes().size();
            for (Map.Entry<String, String> prefix : context.getPrefixes().entrySet()) {
                builder.append("PREFIX ");
                builder.append(prefix.getKey());
                builder.append(": <");
                builder.append(prefix.getValue());
                builder.append(">\n");
            }
        }
        builder.append(query);

        fullQuery = builder.toString();

        if (prettyPrint || rewriteAndPrint) {
            try {
                EngineConfig config = rewriteAndPrint ? new MockEngineConfig(null) : new ParseOnlyEngineConfig();
                QueryController qc = new Engine(config).prepareQuery(null, fullQuery);
                //StringBuilder outputBuilder = new StringBuilder();
                //qc.prettyPrint(outputBuilder);
                System.out.println(qc.prettyPrintQueryString(EnumSet.of(QueryStringPrintOptions.GENERATE_NEW_PREFIXES, QueryStringPrintOptions.INDENT, QueryStringPrintOptions.USE_PREFIXES, QueryStringPrintOptions.REMOVE_UNUSED_PREFIXES)));
            } catch (ParseException e) {
                // hack, create an anzo exception from the parse exception since we know how to render that
                prettyPrintGlitterParseError(context, fullQuery, new AnzoException(ExceptionConstants.GLITTER.PARSE_EXCEPTION, e, query, e.getMessage()), hiddenPrefixCount);
                throw new CommandException(e, "query");
            }
            return 0;
        }
        if (datasetInput != null) {
            Reader inputDatasetStream = datasetInput.getReader();
            RDFFormat datasetFileFormat = datasetInput.getFormat();

            Dataset dataset = new Dataset();

            try {
                if (!datasetFileFormat.supportsNamedGraphs()) {
                    INamedGraph namedGraph = dataset.addDefaultGraph(CommandContext.defaultNamedGraph);
                    ReadWriteUtils.loadGraph(namedGraph, inputDatasetStream, datasetFileFormat, ObjectUtils.toString(base));
                    queryResults = dataset.executeQuery(Collections.singleton(CommandContext.defaultNamedGraph), null, null, fullQuery, null);
                } else {
                    ReadWriteUtils.loadQuadStore(dataset, inputDatasetStream, datasetFileFormat, ObjectUtils.toString(base));
                    DefaultQueryDataset queryDataset = new DefaultQueryDataset(allDefaultGraphs ? dataset.getDefaultGraphUris() : null, allNamedGraphs ? dataset.getNamedGraphUris() : null);
                    queryResults = new Engine(new QuadStoreEngineConfig(dataset)).executeQuery(null, fullQuery, queryDataset, null);
                }

            } catch (ParseException e) {
                // hack, create an anzo exception from the parse exception since we know how to render that
                prettyPrintGlitterParseError(context, fullQuery, new AnzoException(ExceptionConstants.GLITTER.PARSE_EXCEPTION, e, query, e.getMessage()), hiddenPrefixCount);
                throw new CommandException("query failed");
            }
        } else {
            boolean owns = false;
            try {
                owns = !client.isConnected();
                if (owns) {
                    client.connect();
                    printOnConnectionSuccess(context);
                }
                long start = 0;
                if (queryTime) {
                    start = System.currentTimeMillis();
                }

                Map<String, Object> options = new HashMap<String, Object>();

                if (datasource != null) {
                    options.put(OPTIONS.DATASOURCE, datasource);
                }
                if (skipCache) {
                    options.put(OPTIONS.SKIPCACHE, Boolean.TRUE);
                }
                if (true) {
                    options.put(OPTIONS.INCLUDEMETADATAGRAPHS, Boolean.TRUE);
                }
                Set<URI> defaultGraphs = null;
                if (allDefaultGraphs || allMetadataDefaultGraphs) {
                    defaultGraphs = new HashSet<URI>();
                    if (allDefaultGraphs) {
                        defaultGraphs.add(GRAPHS.ALL_NAMEDGRAPHS);
                    }
                    if (allMetadataDefaultGraphs) {
                        defaultGraphs.add(GRAPHS.ALL_METADATAGRAPHS);
                    }
                }

                Set<URI> namedGraphs = null;
                if (allNamedGraphs || allMetadataNamedGraphs) {
                    namedGraphs = new HashSet<URI>();
                    if (allNamedGraphs) {
                        namedGraphs.add(GRAPHS.ALL_NAMEDGRAPHS);
                    }
                    if (allMetadataNamedGraphs) {
                        namedGraphs.add(GRAPHS.ALL_METADATAGRAPHS);
                    }
                }

                queryResults = client.serverQuery(defaultGraphs, namedGraphs, null, fullQuery, null, options);

                if (queryTime) {
                    context.writeOutput("server query time (ms): " + (System.currentTimeMillis() - start));
                }
            } catch (AnzoException e) {
                if (e.getErrorCode() == ExceptionConstants.GLITTER.PARSE_EXCEPTION) {
                    prettyPrintGlitterParseError(context, fullQuery, e, hiddenPrefixCount);
                    throw new CommandException("query failed");
                }
                throw new CommandException(e, "query failed");
            } finally {
                try {
                    if (owns)
                        client.close();
                } catch (AnzoRuntimeException e) {
                    log.error("Error closing connection", e);
                }
            }
        }
        try {
            if (queryResults.isConstructResult() || queryResults.isDescribeResult()) {
                Collection<Statement> resultSet = (queryResults.isConstructResult()) ? queryResults.getConstructResults() : queryResults.getDescribeResults();
                Dataset dataset = new Dataset();

                // anzo datasets are not expressive enough to serialize out a default graph to TriG properly.
                // so populateDataset and outputRdf hack their way around the problem.
                context.populateDataset(dataset, resultSet);
                context.outputRdf(dataset, outputFormat);
            } else {

                OutputStreamWriter writer = new OutputStreamWriter(System.out, "UTF-8");

                if (outputFormat.equals(RDFFormat.SPARQL)) {
                    CommonSerializationUtils.writeQueryResults(queryResults, writer, RDFFormat.SPARQL.getDefaultMIMEType());
                } else {
                    if (queryResults.isAskResult()) {
                        System.out.println(queryResults.getAskResults());
                    } else {
                        SolutionTextWriter.write(context, queryResults.getSelectResults());
                    }
                }

                writer.flush();
            }

        } catch (IOException e) {
            throw new CommandException(e, "query");
        }
        return 0;
    }

    private void prettyPrintGlitterParseError(CommandContext context, String fullQuery, AnzoException e, int hiddenPrefixCount) {
        if (e.getErrorCode() != ExceptionConstants.GLITTER.PARSE_EXCEPTION) {
            throw new AnzoRuntimeException(ExceptionConstants.GLITTER.PRINTING_EXCEPTION_FAILED);
        }

        if (e.getArgs().length < 1) {
            return;
        }
        String error = (e.getArgs().length == 2) ? e.getArgs()[1] : e.toString();
        Matcher matcher = Pattern.compile(GLITTER_LINE_COLUMN_PATTERN).matcher(error);

        // if no line and column numbers are in the parse error, just print it
        if (!matcher.find()) {
            context.writeError(error);
            return;
        }

        // got a line and column number
        // use them to print a more detailed error message, showing the actual line where the error occurred and putting a caret under the
        // column where the error occurred.
        int line = Integer.parseInt(matcher.group(1));
        int column = Integer.parseInt(matcher.group(2));

        // adjust the line number to match the input query.  If prefixes were implicitly added, reduce the line number to account for them.
        context.writeError("Parse error: " + matcher.replaceFirst("at line " + (line - hiddenPrefixCount) + ", column " + column + "."));

        // print the line that caused the error.
        String[] lines = fullQuery.split(NEWLINE_PATTERN);
        if (lines.length >= line) {
            context.writeError(lines[line - 1]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < column; i++) {
            sb.append(" ");
        }
        sb.append("^");
        context.writeError(sb.toString());
    }

    public void printHelp(IConsole consoleWriter) {
        String header = "Executes a SPARQL query against the repository or a local RDF file.  The query is read from the command line arguments ";
        header += " or from the " + QUERY_INPUT_OPTION.getLongOpt() + " option, if set.  If neither are provided, the query is read from STDIN. ";
        header += " If the " + DATASET_INPUT_OPTION.getLongOpt() + " option is set, the RDF in the file is queried instead of the repository.";
        String syntax = "anzo query [options] [ \"sparql query..\" | -f RDF-INPUT-FILE ]";
        String footer = "RDF format options are: " + CommandLineInterface.getRDFFormatOptionsString();

        footer += "\nSolution Set output format options are: Solution Table (tbl) and SPARQL Result XML(srx)";
        Options options = getOptions();
        CommandLineInterface.appendGlobalOptions(options);
        consoleWriter.printHelp( syntax, header, options, footer);
    }

}
