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
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Dataset;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.UpdateServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class UpdateCommand extends RdfIOCommand {
    private static final Logger log           = LoggerFactory.getLogger(UpdateCommand.class);

    private static final Option BASE_OPTION   = new Option("b", "base", true, "Set the base URI of the input RDF file(s) or URI(s)");

    private static final Option ADD_OPTION    = new Option("a", "add", true, "RDF file or URI containing additions.");

    private static final Option REMOVE_OPTION = new Option("r", "remove", true, "RDF or URI containing removals.");

    private static final Option INPUT_FORMAT  = new Option("i", "input-format", true, "Overide the default RDF format associated with RDF input(s).");

    private static final Option GRAPH         = new Option("g", "graph", true, "Named graph uri to use for rdf inputs that do not support named graph serialization");

    private static final Option FORCE_CREATE  = new Option("f", "force-create", false, "Create graphs if they do not exist already.");

    private static final Option ENCODING      = new Option("e", "encoding", true, "Override the default charset for uploading RDF files.");

    INamedGraphInitializer[]    inits         = new INamedGraphInitializer[] { AnzoClient.GRAPH_MUST_EXIST };

    public INamedGraphInitializer[] getNamedGraphInitializers() {
        return inits;
    }

    static {
        BASE_OPTION.setArgName("URI");
        ADD_OPTION.setArgName("file | URI");
        REMOVE_OPTION.setArgName("file | URI");
        INPUT_FORMAT.setArgName("format");
        GRAPH.setArgName("URI");
    }

    public String getName() {
        return "update";
    }

    public Options getOptions() {
        Options options = new Options();
        options.addOption(BASE_OPTION);
        options.addOption(ADD_OPTION);
        options.addOption(REMOVE_OPTION);
        options.addOption(INPUT_FORMAT);
        options.addOption(GRAPH);
        options.addOption(FORCE_CREATE);
        options.addOption(ENCODING);

        return options;
    }

    public int invoke(CommandLine cl, CommandContext context, AnzoClient client) throws AnzoException {
        if (isFlagSet(cl, FORCE_CREATE)) {
            inits = new INamedGraphInitializer[] {};
        }

        RDFFormat overrideInputFormat = getFormatOption(cl, INPUT_FORMAT);
        String charsetName = getEncodingOption(cl, ENCODING);
        RdfInputArgument addsOption = getRdfInputOption(context, cl, ADD_OPTION, overrideInputFormat, charsetName);
        RdfInputArgument removesOption = getRdfInputOption(context, cl, REMOVE_OPTION, overrideInputFormat, charsetName);
        URI base = getURIOption(cl, BASE_OPTION, context);
        URI defaultNamedGraphUri = getURIOption(cl, GRAPH, context);

        return update(context, client, addsOption, removesOption, defaultNamedGraphUri, base);
    }

    public int update(CommandContext context, AnzoClient client, RdfInputArgument add, RdfInputArgument remove, URI defaultNamedGraphUri, URI base) throws AnzoException {
        int result = 1;

        IDataset adds = new Dataset();
        IDataset removes = new Dataset();

        INamedGraph addsDefaultNamedGraph = null;
        INamedGraph removesDefaultNamedGraph = null;

        URI addDefaultNamedGraphUri = defaultNamedGraphUri;
        if (addDefaultNamedGraphUri == null && add != null) {
            addDefaultNamedGraphUri = add.getDefaultGraphURI();
        }

        URI removeDefaultNamedGraphUri = defaultNamedGraphUri;
        if (removeDefaultNamedGraphUri == null && remove != null) {
            removeDefaultNamedGraphUri = remove.getDefaultGraphURI();
        }

        if (addDefaultNamedGraphUri != null) {
            adds.addNamedGraph(addDefaultNamedGraphUri);
            addsDefaultNamedGraph = adds.getNamedGraph(addDefaultNamedGraphUri);
        }
        if (removeDefaultNamedGraphUri != null) {
            removes.addNamedGraph(removeDefaultNamedGraphUri);
            removesDefaultNamedGraph = removes.getNamedGraph(removeDefaultNamedGraphUri);
        }

        if (add != null) {
            URI addBase = base;
            if (addBase == null) {
                addBase = add.getDefaultGraphURI();
            }
            RDFFormat addFileFormat = add.getFormat();
            if (addFileFormat == null) {
                throw new InvalidArgumentException(add.inputName + " is not a valid RDF format file type. Use a proper file type or STDIN.");
            }
            if (!addFileFormat.supportsNamedGraphs()) {

                if (addDefaultNamedGraphUri == null) {
                    throw new InvalidArgumentException(GRAPH.getLongOpt() + " option must be set for format " + addFileFormat + " since this format does not support named graphs");
                }
                ReadWriteUtils.loadGraph(addsDefaultNamedGraph, add.getReader(), addFileFormat, ObjectUtils.toString(addBase));
            } else {
                ReadWriteUtils.loadQuadStore(adds, add.getReader(), addFileFormat, ObjectUtils.toString(addBase));
            }
        }

        if (remove != null) {
            URI removeBase = base;
            if (removeBase == null) {
                removeBase = remove.getDefaultGraphURI();
            }
            RDFFormat removeFileFormat = remove.getFormat();
            if (removeFileFormat == null) {
                throw new InvalidArgumentException(remove.inputName + " is not a valid RDF format file type. Use a proper file type or STDIN.");
            }
            if (!removeFileFormat.supportsNamedGraphs()) {
                if (removeDefaultNamedGraphUri == null) {
                    throw new InvalidArgumentException(GRAPH.getLongOpt() + " option must be set for format " + removeFileFormat + " since this format does not support named graphs");
                }
                ReadWriteUtils.loadGraph(removesDefaultNamedGraph, remove.getReader(), removeFileFormat, ObjectUtils.toString(removeBase));
            } else {
                ReadWriteUtils.loadQuadStore(removes, remove.getReader(), removeFileFormat, ObjectUtils.toString(removeBase));
            }
        }

        boolean owns = false;
        try {
            owns = !client.isConnected();
            if (owns) {
                client.connect();
                printOnConnectionSuccess(context);
            }
            client.begin();
            int total = 0;
            for (URI uri : removes.getNamedGraphUris()) {
                ClientGraph graph;
                INamedGraph ng;

                if (UriGenerator.isMetadataGraphUri(uri)) {
                    URI uri_ng = UriGenerator.stripEncapsulatedURI(Constants.NAMESPACES.METADATAGRAPH_PREFIX, uri);
                    graph = client.getReplicaGraph(uri_ng, getNamedGraphInitializers());
                    ng = graph.getMetadataGraph();
                    total += removes.getNamedGraph(uri).getStatements().size();
                    ng.remove(removes.getNamedGraph(uri).getStatements()); // remove the listed statements from the metadata graph
                } else {
                    graph = client.getReplicaGraph(uri, getNamedGraphInitializers());
                    ng = removes.getNamedGraph(uri);
                    total += ng.getStatements().size();
                    graph.remove(ng.getStatements());
                }
                if (total > 20000) {
                    client.commit();
                    client.begin();
                    total = 0;
                }
            }
            for (URI uri : adds.getNamedGraphUris()) {
                ClientGraph graph;
                INamedGraph ng;

                if (UriGenerator.isMetadataGraphUri(uri)) {
                    // get the uri of the named graph that is associated with this metadata
                    URI uri_ng = UriGenerator.stripEncapsulatedURI(Constants.NAMESPACES.METADATAGRAPH_PREFIX, uri);
                    graph = client.getReplicaGraph(uri_ng, getNamedGraphInitializers()); // get the named graph object
                    ng = graph.getMetadataGraph();
                    total += adds.getNamedGraph(uri).getStatements().size();
                    ng.add(adds.getNamedGraph(uri).getStatements()); // add the new statements to the metadata graph
                } else {
                    graph = client.getReplicaGraph(uri, getNamedGraphInitializers());
                    ng = adds.getNamedGraph(uri);
                    total += ng.getStatements().size();
                    graph.add(ng.getStatements());
                }
                if (total > 20000) {
                    client.commit();
                    client.begin();
                }
            }
            client.commit();
            client.updateRepository();
            result = 0;
        } catch (UpdateServerException e) {
            context.writeError("Update failed due to validation error(s): ");
            for (List<AnzoException> list : e.getErrors()) {
                for (AnzoException ex : list) {
                    if (ex.getErrorCode() == ExceptionConstants.VALIDATION.INVALID_TYPEDLITERAL_LABEL) {
                        context.writeError("\t" + ex.getArgs()[0]);
                    } else {
                        context.writeError("unknown transaction error:" + ex.getMessage(false));
                        context.getConsoleWriter().printException(ex, context.getShowTrace());
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

    public void printHelp(IConsole consoleWriter) {
        String header = "Updates existing graphs in the repository, adding the statements from the adds option file and removing statements from the deletes option file.";
        String syntax = "anzo update [options] --add RDF-INPUT-FILE-OR-URI --remove RDF-INPUT-FILE-OR-URI";
        String footer = "RDF format options are: " + CommandLineInterface.getRDFFormatOptionsString();
        Options options = getOptions();
        CommandLineInterface.appendGlobalOptions(options);
        consoleWriter.printHelp( syntax, header, options, footer);
    }

}
