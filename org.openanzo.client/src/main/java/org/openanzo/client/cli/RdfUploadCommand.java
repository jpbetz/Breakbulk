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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.lang.ObjectUtils;
import org.openanzo.client.AnzoClient;
import org.openanzo.client.ClientGraph;
import org.openanzo.client.INamedGraphInitializer;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Dataset;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.rdf.vocabulary.RDF;
import org.openanzo.services.UpdateServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base for commands that upload rdf from local files and streams.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
abstract class RdfUploadCommand extends RdfIOCommand {
    private static final Logger   log            = LoggerFactory.getLogger(RdfUploadCommand.class);

    private static final Option   NON_REVISIONED = new Option("nr", "non-revisioned", false, "When creating a graph, make it non-revisioned.");

    private static final Option   BASE           = new Option("b", "base", true, "Set the base URI of the input RDF file(s) or URI(s)");

    protected static final Option GRAPH          = new Option("g", "graph", true, "Named graph uri to use for rdf inputs that do not support named graph serialization");

    protected static final Option INPUT_FORMAT   = new Option("i", "input-format", true, "Override the default RDF format associated with RDF input(s).");

    protected static final Option ENCODING       = new Option("e", "encoding", true, "Override the default charset for uploading RDF files.");

    static {
        BASE.setArgName("URI");
        GRAPH.setArgName("URI");
        INPUT_FORMAT.setArgName("format");
    }

    public Options getOptions() {
        Options options = new Options();
        options.addOption(NON_REVISIONED);
        options.addOption(BASE);
        options.addOption(GRAPH);
        options.addOption(INPUT_FORMAT);
        options.addOption(ENCODING);
        options.addOption(VERBOSE);
        options.addOption(RECURSE);
        return options;
    }

    public int invoke(CommandLine cl, CommandContext context, AnzoClient client) throws AnzoException {
        return invoke(cl, context, client, true);
    }

    public int invoke(CommandLine cl, CommandContext context, AnzoClient client, boolean defaultToStdin) throws AnzoException {
        String[] args = cl.getArgs();

        boolean nonRevisioned = isFlagSet(cl, NON_REVISIONED);
        RDFFormat overrideFormat = getFormatOption(cl, INPUT_FORMAT);
        String charsetName = getEncodingOption(cl, ENCODING);
        Collection<RdfInputArgument> inputs = getArgumentsAsStreams(cl, context, args, 0, args.length, overrideFormat, charsetName);
        URI defaultNamedGraphUri = getURIOption(cl, GRAPH, context);
        URI base = getURIOption(cl, BASE, context);

        if (args.length == 0 && defaultToStdin) {
            if (overrideFormat == null) {
                inputs.add(new RdfInputArgument(System.in, RDFFormat.forFileName("." + CommandLineInterface.DEFAULT_RDF_FORMAT), charsetName));
            } else {
                inputs.add(new RdfInputArgument(System.in, overrideFormat, charsetName));
            }
        }

        return update(cl, context, client, inputs, defaultNamedGraphUri, base, nonRevisioned);
    }

    /**
     * Performs the commit operation.
     * 
     * Reads through the provided files, constructs diffs by computing the differences between the file and the server graphs and commits those diffs in a
     * transaction to the repository.
     * 
     * @throws AnzoException
     */
    protected int update(CommandLine cl, CommandContext context, AnzoClient client, Collection<RdfInputArgument> inputs, URI defaultNamedGraphUri, URI base, boolean nonRevisioned) throws AnzoException {

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
            try {
                Reader in = input.getReader();
                RDFFormat fileFormat = input.getFormat();

                URI inputBase = base;
                if (inputBase == null) {
                    inputBase = input.getDefaultGraphURI();
                }
                if (fileFormat == null) {
                    throw new InvalidArgumentException(input.inputName + " is not a valid RDF format file type. Use a proper file type or STDIN.");
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

                    if (defaultNamedGraphUri == null) {
                        throw new InvalidArgumentException(GRAPH.getLongOpt() + " option must be set for format " + fileFormat + " since this format does not support named graphs");
                    }
                    ReadWriteUtils.loadGraph(inputNamedGraph, in, fileFormat, ObjectUtils.toString(inputBase));
                } else {
                    ReadWriteUtils.loadQuadStore(store, in, fileFormat, ObjectUtils.toString(inputBase));
                }
            } catch (AnzoException e) {
                context.writeError("Error loading RDF Input: " + input.inputName);
                throw e;
            }

        }
        return update(cl, context, client, store, base, nonRevisioned);
    }

    public abstract INamedGraphInitializer[] getNamedGraphInitializers();

    public INamedGraphInitializer[] getNamedGraphInitializers(boolean nonRevisioned) {
        INamedGraphInitializer[] initializers = getNamedGraphInitializers();

        if (nonRevisioned) {
            ArrayList<INamedGraphInitializer> list = new ArrayList<INamedGraphInitializer>();
            list.addAll(Arrays.asList(initializers));
            list.remove(AnzoClient.REVISIONED_NAMED_GRAPH);
            list.add(AnzoClient.NON_REVISIONED_NAMED_GRAPH);
            initializers = list.toArray(new INamedGraphInitializer[0]);
        }
        return initializers;
    }

    protected int update(CommandLine cl, CommandContext context, AnzoClient client, IDataset store, URI base, boolean nonRevisioned) throws AnzoException {

        int result = 1;
        boolean owns = false;
        try {
            owns = !client.isConnected();
            if (owns) {
                client.connect();
                printOnConnectionSuccess(context);
            }
            for (URI uri : store.getNamedGraphUris()) {
                client.begin();
                if (UriGenerator.isMetadataGraphUri(uri)) {
                    // get the uri of the named graph that is associated with this metadata
                    URI uri_ng = UriGenerator.stripEncapsulatedURI(Constants.NAMESPACES.METADATAGRAPH_PREFIX, uri);
                    ClientGraph graph = client.getReplicaGraph(uri_ng, getNamedGraphInitializers(nonRevisioned)); // get the named graph object
                    INamedGraph metaG = graph.getMetadataGraph();
                    for (Statement statement : metaG.getStatements()) {
                        if (!hasReservedPredicate(statement))
                            metaG.remove(statement);
                    }
                    Collection<Statement> stmts = store.getNamedGraph(uri).getStatements();
                    metaG.add(stmts);
                } else {
                    ClientGraph graph = client.getReplicaGraph(uri, getNamedGraphInitializers(nonRevisioned));
                    Collection<Statement> stmts = store.getNamedGraph(uri).getStatements();

                    graph.clear();
                    graph.add(stmts);
                }
                client.commit();
            }
            client.updateRepository();
            result = 0;
        } catch (UpdateServerException e) {
            context.writeError("Update failed due to validation error(s): ");
            for (List<AnzoException> list : e.getErrors()) {
                if (list != null) {
                    for (AnzoException ex : list) {
                        if (ex.getErrorCode() == ExceptionConstants.VALIDATION.INVALID_TYPEDLITERAL_LABEL) {
                            context.writeError("\t" + ex.getArgs()[0]);
                        } else {
                            context.writeError("unknown transaction error:" + ex.getMessage(false));
                            context.getConsoleWriter().printException(ex, context.getShowTrace());
                        }
                    }
                }
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

    /**
     * Returns true if the statement contains one of the metadata properties that cannot be modified.
     */
    static boolean hasReservedPredicate(Statement statement) {
        boolean retval = false;
        URI uri = statement.getPredicate();
        retval = (uri.equals(NamedGraph.lastModifiedByUserProperty) || uri.equals(NamedGraph.modifiedProperty) || uri.equals(NamedGraph.createdProperty) || uri.equals(NamedGraph.createdByProperty) || uri.equals(NamedGraph.uuidProperty) || uri.equals(NamedGraph.revisionProperty) || uri.equals(NamedGraph.datasourceProperty) || uri.equals(NamedGraph.persistedProperty) || uri.equals(NamedGraph.revisionedProperty) || uri.equals(NamedGraph.hasMetadataGraphProperty));
        return retval || (uri.equals(RDF.TYPE) && statement.getObject().equals(NamedGraph.TYPE));
    }
}
