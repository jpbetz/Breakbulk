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
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.lang.ObjectUtils;
import org.openanzo.client.AnzoClient;
import org.openanzo.client.ClientGraph;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.ontologies.system.JastorGeneration;
import org.openanzo.ontologies.system.JastorOntology;
import org.openanzo.ontologies.system.SystemFactory;
import org.openanzo.rdf.Dataset;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.NamedGraph;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.jastor.JastorContext;
import org.openanzo.rdf.jastor.JastorGenerator;
import org.openanzo.rdf.utils.Pair;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Generates Java classes for
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
class GenCommand extends RdfIOCommand {
    private static final Logger log              = LoggerFactory.getLogger(GenCommand.class);

    private static final Option BASE             = new Option("b", "base", true, "Set the base URI of the input RDF file(s) or URI(s)");

    private static final Option INPUT_FORMAT     = new Option("i", "input-format", true, "Overide the default RDF format associated with the RDF input(s)");

    private static final Option GEN_INPUT_OPTION = new Option("f", "gen-input", true, "Generate code based on the given input file, overrides all other options");

    private static final Option PACKAGE_OPTION   = new Option("k", "package", true, "Generate code into the given package");

    private static final Option DESTDIR_OPTION   = new Option("d", "destdir", true, "Generate code into the given directory");

    private static final Option ENCODING         = new Option("e", "encoding", true, "Override the default charset for uploading RDF files.");

    static {
        BASE.setArgName("URI");
        INPUT_FORMAT.setArgName("format");
        GEN_INPUT_OPTION.setArgName("file | URI");
        PACKAGE_OPTION.setArgName("package");
        DESTDIR_OPTION.setArgName("destdir");
    }

    public String getName() {
        return "gen";
    }

    public Options getOptions() {
        Options options = new Options();
        options.addOption(BASE);
        options.addOption(INPUT_FORMAT);
        options.addOption(GEN_INPUT_OPTION);
        options.addOption(PACKAGE_OPTION);
        options.addOption(DESTDIR_OPTION);
        options.addOption(ENCODING);
        return options;
    }

    public int invoke(CommandLine cl, CommandContext context, AnzoClient client) throws AnzoException {

        boolean owns = false;
        try {
            owns = !client.isConnected();
            if (owns) {
                client.connect();
                printOnConnectionSuccess(context);
            }

            String[] args = cl.getArgs();

            RDFFormat inputOverrideFormat = getFormatOption(cl, INPUT_FORMAT);
            URI base = getURIOption(cl, BASE, context);
            String charsetName = getEncodingOption(cl, ENCODING);

            if (cl.hasOption(GEN_INPUT_OPTION.getOpt())) {
                RdfInputArgument input = getRdfInputOption(context, cl, GEN_INPUT_OPTION, null, charsetName);
                return gen(context, client, input, new OutputStreamWriter(System.out), base);
            }

            if (!cl.hasOption(PACKAGE_OPTION.getOpt())) {
                throw new InvalidArgumentException(PACKAGE_OPTION.getLongOpt() + " option must be specified");
            }

            if (!cl.hasOption(DESTDIR_OPTION.getOpt())) {
                throw new InvalidArgumentException(DESTDIR_OPTION.getLongOpt() + " option must be specified");
            }

            String pkg = cl.getOptionValue(PACKAGE_OPTION.getOpt());
            String destdir = cl.getOptionValue(DESTDIR_OPTION.getOpt());

            if (args.length < 1) {
                throw new InvalidArgumentException("At least one ontology must be specified");
            }

            List<INamedGraph> ontGraphs = new ArrayList<INamedGraph>();
            for (int i = 0; i < args.length; i++) {
                if (!new File(args[i]).exists() && (context.isURI(args[i]) || context.isCURIE(args[i]))) {
                    try {
                        URI uri = context.getURI(args[i]);
                        ClientGraph graph = client.getServerGraph(uri);
                        ontGraphs.add(graph);
                    } catch (URISyntaxException e) {
                        throw new InvalidArgumentException("URI Syntax Exception: " + args[i] + "\n" + e.getMessage());
                    }
                } else {
                    Pair<File, RDFFormat> file = getFileArgument(context, args[i], inputOverrideFormat, true);

                    if (!file.second.supportsNamedGraphs()) {
                        try {
                            i++;
                            URI graphUri = context.getURI(args[i]);
                            INamedGraph ontGraph = new NamedGraph(graphUri);
                            ReadWriteUtils.loadGraph(ontGraph, file.first);
                            ontGraphs.add(ontGraph);
                        } catch (URISyntaxException e) {
                            throw new InvalidArgumentException("URI Syntax Exception: " + args[i] + "\n" + e.getMessage());
                        }
                    } else {
                        IDataset dataset = new Dataset();
                        try {
                            ReadWriteUtils.loadQuadStore(dataset, file.first);
                            if (dataset.getNamedGraphUris().size() > 1) {
                                throw new IllegalArgumentException("Ontology file may contain only a single graph: " + file.first);
                            }
                            ontGraphs.add(dataset.getNamedGraph(dataset.getNamedGraphUris().iterator().next()));
                        } catch (Exception e) {
                            throw new IllegalArgumentException("Could not load ontology file: " + file.first);
                        }
                    }
                }
            }

            JastorContext ctx = new JastorContext();
            for (INamedGraph ontGraph : ontGraphs) {
                ctx.addOntologyToGenerate(ontGraph, ontGraph.getNamedGraphUri().toString(), pkg);
            }
            JastorGenerator gen = new JastorGenerator(new File(destdir), ctx);
            gen.run();

        } finally {
            try {
                if (owns) {
                    client.close();
                }
            } catch (AnzoRuntimeException e) {
                log.error("Error closing connection", e);
            }
        }
        return 0;

    }

    private int gen(CommandContext context, AnzoClient client, RdfInputArgument input, Writer output, URI base) throws AnzoException {
        int result = 1;
        try {

            IDataset storeIn = new Dataset();

            Reader in = input.getReader();
            RDFFormat inputFormat = input.getFormat();

            if (base == null) {
                base = input.getDefaultGraphURI();
            }

            ReadWriteUtils.loadQuadStore(storeIn, in, inputFormat, ObjectUtils.toString(base));

            for (JastorGeneration gen : SystemFactory.getAllJastorGeneration(storeIn)) {
                JastorContext ctx = new JastorContext();
                if (gen.getGenerateListeners() != null && gen.getGenerateListeners()) {
                    ctx.setGenerateListeners(true);
                } else {
                    ctx.setGenerateListeners(false);
                }
                for (JastorOntology ont : gen.getJastorOntology()) {
                    if (!client.namedGraphExists(ont.getOntologyUri())) {
                        context.writeError("Ontology does not exist: " + ont.getOntologyUri());
                    }
                    ClientGraph ontGraph = client.getReplicaGraph(ont.getOntologyUri());
                    if (ont.getGenerate()) {
                        ctx.addOntologyToGenerate(ontGraph, ont.getOntologyUri().toString(), ont.get_package());
                    } else {
                        ctx.addOntologyDependency(ontGraph, ont.getOntologyUri().toString(), ont.get_package());
                    }
                }
                JastorGenerator generator = new JastorGenerator(new File(gen.getDestDir()).getCanonicalFile(), ctx);
                generator.run();
            }

            result = 0;
        } catch (IOException e) {
            log.error("Error generating classes", e);
        }
        return result;
    }

    public void printHelp(IConsole consoleWriter) {
        String header = "Generates code for the ontologies as supplied by the input RDF or arguments. If arguments are used, a list of ontology URIs or files must be supplied.  If an ontology file does to support graphs, a graph URI must be insterted next in the argument list.";
        String syntax = "anzo gen [options] [ONTOLOGY-FILE-OR-URI1] [[ONTOLOGY-GRAPH-URI1]] ... [ONTOLOGY-FILE-OR-URIn]";
        String footer = "RDF format options are: " + CommandLineInterface.getRDFFormatOptionsString();
        Options options = getOptions();
        CommandLineInterface.appendGlobalOptions(options);
        consoleWriter.printHelp( syntax, header, options, footer);
    }

}
