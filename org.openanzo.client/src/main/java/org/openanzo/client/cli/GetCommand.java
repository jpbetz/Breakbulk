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
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.openanzo.client.AnzoClient;
import org.openanzo.client.ClientGraph;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.ontologies.openanzo.AnzoFactory;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IAnzoGraph;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.Pair;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.rdf.vocabulary.RDF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Gets graphs from the anzo repository and prints them in serialized rdf formats.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
class GetCommand extends RdfIOCommand {
    private static final Logger log                = LoggerFactory.getLogger(GetCommand.class);

    private static final Option REVISION           = new Option("r", "revision", true, "Gets a specific revision of the graph.  Returns an error if the graph is non-revisioned.");

    private static final Option OUTPUT_FORMAT      = new Option("o", "output-format", true, "Overide the default RDF format associated with the RDF output(s)");

    private static final Option METADATA           = new Option("m", "metadata", false, "include metadata graph (TRIX and TRIG only)");

    private static final Option OUTPUT_FILE        = new Option("f", "output-file", true, "write the get results to a file");

    private static final Option EXPAND_DATASET     = new Option("e", "expand-dataset", false, "Expand the given dataset according to the SPARQL dataset definition.");

    private static final Option EXPORT_DATASET     = new Option("E", "export-dataset", false, "Export the given dataset for backup or sharing.");

    private static final int    DEFAULT_BATCH_SIZE = 1000;

    static {
        REVISION.setArgName("int");
        OUTPUT_FORMAT.setArgName("format");
        OUTPUT_FILE.setArgName("file");
    }

    public String getName() {
        return "get";
    }

    public Options getOptions() {
        Options options = new Options();
        options.addOption(REVISION);
        options.addOption(OUTPUT_FORMAT);
        options.addOption(METADATA);
        options.addOption(OUTPUT_FILE);
        options.addOption(EXPAND_DATASET);
        options.addOption(EXPORT_DATASET);
        return options;
    }

    public int invoke(CommandLine cl, CommandContext context, AnzoClient client) throws AnzoException {

        log.debug("LOG: INVOKING GET COMMAND!");
        if (cl.getArgs().length < 1) {
            throw new InvalidArgumentException("Argument required");
        }

        boolean expandDataset = isFlagSet(cl, EXPAND_DATASET);
        boolean exportDataset = isFlagSet(cl, EXPORT_DATASET);
        RDFFormat outputFormatOverride = getFormatOption(cl, OUTPUT_FORMAT);
        Pair<File, RDFFormat> output = getFileOption(cl, OUTPUT_FILE, outputFormatOverride, false);

        Long revision = null;
        if (cl.hasOption(REVISION.getOpt())) {
            String revisionStr = cl.getOptionValue(REVISION.getOpt());
            try {
                revision = Long.valueOf(revisionStr);
            } catch (NumberFormatException e) {
                throw new InvalidArgumentException("Illegal revision option value: " + revisionStr + ". Revision must be a number.");
            }
            if (revision < 0) {
                throw new InvalidArgumentException("Illegal revision option value: " + revisionStr + ".  Revision must be non-negative.");
            }
        }

        Writer out = null;
        RDFFormat outputFormat = null;
        if (output == null) {
            try {
                out = new OutputStreamWriter(System.out, Constants.byteEncoding);
            } catch (UnsupportedEncodingException uee) {
                throw new RuntimeException("This exception should never occur since UTF-8 is always supported");
            }
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

        boolean getMetadata = false;
        if (isFlagSet(cl, METADATA)) {
            if (outputFormatOverride != null && !outputFormatOverride.supportsNamedGraphs()) {
                throw new CommandException("Metadata may only be retrieved for formats supporting named graphs: TRIX, TRIG");
            }
            getMetadata = true;
        }

        String[] args = cl.getArgs();

        List<URI> uris = getURIArguments(args, 0, args.length, context);

        if (uris.size() > 1 && outputFormatOverride != null && !outputFormatOverride.supportsNamedGraphs()) {
            throw new CommandException("multiple named graph inputs not supported for format: " + outputFormatOverride.name());
        }

        if (expandDataset || exportDataset) {
            if (uris.size() != 1) {
                throw new CommandException("Must provide exactly one named graph URI when " + EXPAND_DATASET.getLongOpt() + " option is set.");
            }
            if (getMetadata && expandDataset) {
                throw new CommandException(METADATA.getLongOpt() + " option and " + EXPAND_DATASET.getLongOpt() + " option may not both be set.");
            }
            if (expandDataset && exportDataset) {
                throw new CommandException(EXPAND_DATASET.getLongOpt() + " option and " + EXPORT_DATASET.getLongOpt() + " option may not both be set");
            }
            return getDataset(context, client, out, outputFormat, uris.get(0), exportDataset, getMetadata);
        } else {
            return get(context, client, getMetadata, out, outputFormat, uris, revision);
        }
    }

    private int get(CommandContext context, AnzoClient client, boolean getMetadata, Writer out, RDFFormat outputFormat, List<URI> uris, Long revision) throws AnzoException {
        int result = 1;
        boolean owns = false;
        try {
            owns = !client.isConnected();
            if (owns) {
                client.connect();
                printOnConnectionSuccess(context);
            }

            HashSet<Statement> store = new HashSet<Statement>();
            boolean foundAll = true;
            for (URI uri : uris) {
                IAnzoGraph graph = null;
                if (revision != null) {
                    graph = client.getNamedGraphRevision(uri, revision); // catch this? ExceptionConstants.DATASOURCE.NAMEDGRAPH.NON_REVISIONED_GRAPH
                } else {
                    graph = client.getCurrentNamedGraphRevision(uri);
                }
                if (graph != null) {
                    store.addAll(graph.getStatements());
                    if (getMetadata) {
                        store.addAll(graph.getMetadataGraph().getStatements());
                    }
                } else {
                    context.writeError("Graph does not exist or hidden due to access control: " + uri);
                    foundAll = false;
                }
            }
            context.outputRdf(store, outputFormat, out);
            if (foundAll) {
                result = 0;
            }
        } finally {
            try {
                if (owns)
                    client.close();
            } catch (AnzoRuntimeException e) {
                log.error("Error closing connection", e);
            }
        }
        return result;
    }

    private int getDataset(CommandContext context, AnzoClient client, Writer out, RDFFormat outputFormat, URI namedGraph, boolean export, boolean getMetadata) throws AnzoException {
        int result = 1;
        try {

            client.connect();
            ClientGraph graph = client.getServerGraph(namedGraph);

            Set<Statement> results = new HashSet<Statement>();
            Collection<Statement> find = graph.find(null, RDF.TYPE, org.openanzo.ontologies.openanzo.Dataset.TYPE);
            if (find.size() != 1) {
                throw new CommandException("Requested graph is not a valid Dataset.  Datasets must contain exactly one item of type " + org.openanzo.ontologies.openanzo.Dataset.TYPE);
            }
            Resource subject = find.iterator().next().getSubject();

            if (export) {
                results.addAll(graph.getStatements());
                if (getMetadata)
                    results.addAll(getEditableMetadataStatements(graph.getMetadataGraph().getStatements()));
            }

            org.openanzo.ontologies.openanzo.Dataset ds = AnzoFactory.getDataset(subject, graph);
            Set<NamedGraph> ngs = new HashSet<NamedGraph>();
            ngs.addAll(ds.getNamedGraph());
            ngs.addAll(ds.getDefaultNamedGraph());
            processGraphs(ngs, results, client, getMetadata, context, out, outputFormat);

            Set<NamedGraph> dgs = new HashSet<NamedGraph>();
            dgs.addAll(ds.getDefaultGraph());
            if (export)
                processGraphs(dgs, results, client, getMetadata, context, out, outputFormat);
            else {
                dgs.addAll(ds.getDefaultNamedGraph()); // only need to reprocess the default namedGraphs if the expand option is on
                URI[] namedGraphUris = new URI[DEFAULT_BATCH_SIZE];
                int count = 0;

                for (NamedGraph dg : dgs) {
                    namedGraphUris[count++] = getUri(dg);
                    if (count >= DEFAULT_BATCH_SIZE) {
                        for (Statement stmt : client.serverFind(null, null, null, namedGraphUris)) {
                            results.add(new Statement(stmt.getSubject(), stmt.getPredicate(), stmt.getObject()));
                        }
                        context.outputRdf(results, outputFormat, out);
                        results.clear();
                        count = 0;
                    }
                }

                if (count > 0) { // process the remaining dgs.size() % DEFAULT_BATCH_SIZE graphs
                    namedGraphUris = resizeURIArray(namedGraphUris, count);
                    for (Statement stmt : client.serverFind(null, null, null, namedGraphUris)) {
                        results.add(new Statement(stmt.getSubject(), stmt.getPredicate(), stmt.getObject()));
                    }
                    context.outputRdf(results, outputFormat, out);
                }
            }

            result = 0;
        } finally {
            try {
                client.close();
            } catch (AnzoRuntimeException e) {
                log.error("Error closing connection", e);
            }
        }
        return result;
    }

    private void processGraphs(Set<NamedGraph> ngs, Set<Statement> results, AnzoClient client, boolean getMetadata, CommandContext context, Writer out, RDFFormat outputFormat) throws AnzoException {
        URI[] namedGraphUris = new URI[DEFAULT_BATCH_SIZE];
        int count = 0;

        for (NamedGraph ng : ngs) {
            namedGraphUris[count++] = getUri(ng);
            if (count >= DEFAULT_BATCH_SIZE) {
                writeGraphStatements(namedGraphUris, results, client, getMetadata, context, out, outputFormat);
                count = 0;
            }
        }

        if (count > 0) {
            namedGraphUris = resizeURIArray(namedGraphUris, count);
            // adds the graph statements for the remaining ngs.size() % DEFAULT_BATCH_SIZE graphs
            writeGraphStatements(namedGraphUris, results, client, getMetadata, context, out, outputFormat);
        }
    }

    private void writeGraphStatements(URI[] namedGraphUris, Set<Statement> results, AnzoClient client, boolean getMetadata, CommandContext context, Writer out, RDFFormat outputFormat) throws AnzoException {
        results.addAll(client.serverFind(null, null, null, namedGraphUris));
        if (getMetadata) {
            for (int i = 0; i < namedGraphUris.length; i++) {
                namedGraphUris[i] = UriGenerator.generateMetadataGraphUri(namedGraphUris[i]);
            }
            results.addAll(getEditableMetadataStatements(client.serverFind(null, null, null, namedGraphUris)));
        }
        context.outputRdf(results, outputFormat, out);
        results.clear();
    }

    private Collection<Statement> getEditableMetadataStatements(Collection<Statement> metaStmts) {
        Collection<Statement> editableStmts = new HashSet<Statement>();

        for (Statement metaStmt : metaStmts) {
            if (!RdfUploadCommand.hasReservedPredicate(metaStmt))
                editableStmts.add(metaStmt);
        }
        return editableStmts;
    }

    private URI getUri(NamedGraph ng) throws AnzoException {
        Resource res = ng.resource();
        if (!(res instanceof URI)) {
            throw new CommandException("Requested graph is not a valid Dataset.  Referenced named graph is not a URI " + res);
        }
        return (URI) res;
    }

    private URI[] resizeURIArray(URI[] oldArray, int newSize) {
        URI[] newArray = new URI[newSize];
        for (int i = 0; i < newSize; i++) {
            newArray[i] = oldArray[i];
        }
        return newArray;
    }

    public void printHelp(IConsole consoleWriter) {
        String header = "Retrieves named graphs from the server.";
        String syntax = "anzo get [options] [NAMED-GRAPH-URI...]";
        String footer = "RDF format options are: " + CommandLineInterface.getRDFFormatOptionsString();
        Options options = getOptions();
        CommandLineInterface.appendGlobalOptions(options);
        consoleWriter.printHelp( syntax, header, options, footer);
    }

}
