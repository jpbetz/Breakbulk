/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/utils/Attic/GraphUtils.java,v $
 * Created by: Ben Szekely ( <a href="mailto:bhszekel@us.ibm.com">bhszekel@us.ibm.com </a>)
 * Created on: November 8, 2006
 * Revision: $Id: GraphUtils.java 168 2007-07-31 14:11:14Z mroy $
 *
 * Contributors:
 * IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import org.apache.commons.collections15.MultiMap;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Dataset;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.IRDFHandler;
import org.openanzo.rdf.IRDFParser;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.SegmentedStatementCollector;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.StatementCollector;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.adapter.AnzoToRioHandlerAdapter;
import org.openanzo.rdf.adapter.BasicNodeConverter;
import org.openanzo.rdf.adapter.RioToAnzoWriterAdapter;
import org.openrdf.rio.RDFHandlerException;
import org.openrdf.rio.RDFParseException;
import org.openrdf.rio.RDFParser;
import org.openrdf.rio.Rio;
import org.openrdf.rio.UnsupportedRDFormatException;
import org.openrdf.rio.RDFParser.DatatypeHandling;

/**
 * Set of utility methods for graph operations, mainly dealing with reading and writing data.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class ReadWriteUtils {

    /**
     * Creates a new reader using a SmartEncodingInputStream
     * 
     * @param filename
     *            name of file
     * @return reader for file
     * @throws AnzoException
     */
    public static Reader createSmartFileReader(String filename) throws AnzoException {
        try {
            SmartEncodingInputStream stream = SmartEncodingInputStream.createSmartStream(new FileInputStream(filename));
            return stream.getReader();
        } catch (IOException ioe) {
            throw new AnzoException(ExceptionConstants.IO.ENCODING_ERROR, ioe);
        }
    }

    /**
     * Creates a new reader using a SmartEncodingInputStream
     * 
     * @param file
     *            file
     * @return reader for file
     * @throws AnzoException
     */
    public static Reader createSmartFileReader(File file) throws AnzoException {
        try {
            SmartEncodingInputStream stream = SmartEncodingInputStream.createSmartStream(new FileInputStream(file));
            return stream.getReader();
        } catch (IOException ioe) {
            throw new AnzoException(ExceptionConstants.IO.ENCODING_ERROR, ioe);
        }
    }

    /**
     * Get an IRDFHandler used for writing data
     * 
     * @param output
     *            writer to where data is written
     * @param format
     *            format for data
     * @return handler for writing
     */
    public static IRDFHandler getWriter(Writer output, RDFFormat format) {
        if (RDFFormat.JSON.equals(format)) {
            return new JSONRdfWriter(output);
        } else if (!RDFFormat.TBL.equals(format)) {
            return new RioToAnzoWriterAdapter(output, format);
        } else {
            throw new AnzoRuntimeException(ExceptionConstants.IO.NO_WRITER_FOR_MIMETYPE_ERROR, format.getDefaultMIMEType());
        }
    }

    /**
     * Write the contents of the graph to a string in RDFXML format
     * 
     * @param graph
     *            Graph to write
     * @return String containing contents of graph in RDFXML
     * @throws Exception
     */
    public static String graphToString(INamedGraph graph) throws Exception {
        StringWriter sw = new StringWriter();
        writeGraph(graph, sw, RDFFormat.TRIG);
        return sw.getBuffer().toString();
    }

    /**
     * Write the contents of the given named graph to the given writer, using RDFXML
     * 
     * @param graph
     *            Graph to write
     * @param writer
     *            Writer to which data is written
     * @throws AnzoException
     *             if there are exceptions writing the data
     */
    public static void writeGraph(INamedGraph graph, Writer writer) throws AnzoException {
        writeGraph(graph, writer, RDFFormat.TRIG);
    }

    /**
     * Write the contents of the given named graph to the given writer, using RDFXML
     * 
     * @param graph
     *            Graph to write
     * @param writer
     *            Writer to which data is written
     * @param format
     *            Format to write
     * @throws AnzoException
     *             if there are exceptions writing the data
     */
    public static void writeGraph(INamedGraph graph, Writer writer, RDFFormat format) throws AnzoException {
        Collection<Statement> itr = graph.getStatements();
        writeStatements(itr, writer, format, null, false);
    }

    /**
     * Load data from given file into a graph.
     * 
     * @param graph
     *            Graph to which data is loaded
     * @param file
     *            File containing graph data.
     */
    public static void loadGraph(INamedGraph graph, File file) {
        try {
            RDFFormat format = RDFFormat.forFileName(file.getName());
            loadGraph(graph, createSmartFileReader(file), format, "");
        } catch (Exception e) {
            throw new AnzoRuntimeException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e, file.getAbsolutePath());
        }
    }

    /**
     * Load the contents of an input stream into a collection of statements, using parser for given format,batching additions into chunks of given size
     * 
     * @param inputStream
     *            Reader containing data
     * @param format
     *            Format which data is stored
     * @param baseURI
     *            BaseURI of data within stream
     * @param handler
     *            Handler to which statements from input stream are passed
     * @throws AnzoException
     *             if there is an error parsing data
     */
    public static void parseStatements(InputStream inputStream, RDFFormat format, String baseURI, IRDFHandler handler) throws AnzoException {
        parseStatements(SmartEncodingInputStream.createSmartStream(inputStream).getReader(), format, baseURI, handler);
    }

    /**
     * Load the contents of an input stream into a collection of statements, using parser for given format,batching additions into chunks of given size
     * 
     * @param rdf
     *            Reader containing data
     * @param format
     *            Format which data is stored
     * @param baseURI
     *            BaseURI of data within stream
     * @param handler
     *            Handler to which statements from input stream are passed
     * @throws AnzoException
     *             if there is an error parsing data
     */
    public static void parseStatements(Reader rdf, RDFFormat format, String baseURI, IRDFHandler handler) throws AnzoException {
        try {
            if (RDFFormat.JSON.equals(format)) {
                IRDFParser parser = new JSONRdfParser(handler);
                parser.parse(rdf, baseURI != null ? baseURI : "");
            } else {
                RDFParser parser = Rio.createParser(BasicNodeConverter.convert(format));
                parser.setRDFHandler(new AnzoToRioHandlerAdapter(handler));
                parser.setPreserveBNodeIDs(true);
                parser.setValueFactory(BasicNodeConverter.valueFactory);
                parser.setDatatypeHandling(DatatypeHandling.IGNORE);
                parser.parse(rdf, baseURI != null ? baseURI : "");
            }
        } catch (RDFParseException pe) {
            throw new AnzoException(ExceptionConstants.IO.RDF_PARSER_ERROR, pe, format.getDefaultMIMEType());
        } catch (RDFHandlerException e) {
            throw new AnzoException(ExceptionConstants.IO.RDF_HANDLER_ERROR, e, format.getDefaultMIMEType());
        } catch (IllegalStateException ise) {
            throw new AnzoException(ExceptionConstants.IO.RDF_HANDLER_ERROR, ise, format.getDefaultMIMEType());
        } catch (IOException e) {
            e.printStackTrace();
            throw new AnzoException(ExceptionConstants.IO.READ_ERROR, e);
        } catch (AnzoRuntimeException ae) {
            throw ae.getAnzoException();
        }
    }

    /**
     * Load the contents of an input stream into a collection of statements, using parser for given format,batching additions into chunks of given size
     * 
     * @param rdf
     *            Reader containing data
     * @param format
     *            Format which data is stored
     * @param baseURI
     *            BaseURI of data within stream
     * @param defaultNamedGraphURI
     *            URI of the graph to which statements with no graph are added
     * @param batchSize
     *            Size of chunks used during data loading
     * @param handler
     *            Handler to which statements from input stream are passed
     * @return Number of loaded statements
     * @throws AnzoException
     *             if there is an error parsing data
     */
    public static int batchLoadStatements(Reader rdf, RDFFormat format, String baseURI, URI defaultNamedGraphURI, int batchSize, IStatementsHandler handler) throws AnzoException {
        try {
            StatementCollection sc = new StatementCollection(batchSize, defaultNamedGraphURI, handler);
            parseStatements(rdf, format, baseURI, sc);
            return sc.totalSize;
        } catch (AnzoRuntimeException ae) {
            throw ae.getAnzoException();
        }
    }

    /**
     * Load the contents of an input stream into a collection of statements, using parser for given format,batching additions into chunks of given size
     * 
     * @param rdf
     *            Reader containing data
     * @param format
     *            Format which data is stored
     * @param baseURI
     *            BaseURI of data within stream
     * @param defaultNamedGraphURI
     *            URI of the graph to which statements with no graph are added
     * @param batchSize
     *            Size of chunks used during data loading
     * @param handler
     *            Handler to which statements from input stream are passed
     * @return Number of loaded statements
     * @throws AnzoException
     *             if there is an error parsing data
     */
    public static int batchLoadStatementsWithSubjectToNamedGraph(Reader rdf, RDFFormat format, String baseURI, int batchSize, IStatementsHandler handler) throws AnzoException {
        try {
            SubjectToNamedGraphCollection sc = new SubjectToNamedGraphCollection(batchSize, handler);
            parseStatements(rdf, format, baseURI, sc);
            return sc.totalSize;
        } catch (AnzoRuntimeException ae) {
            throw ae.getAnzoException();
        }
    }

    /**
     * Load the contents of an input stream into given graph, using parser for given format,batching additions into chunks of given size
     * 
     * @param graph
     *            Graph to which data is loaded
     * @param stream
     *            Reader containing data
     * @param format
     *            Format which data is stored
     * @param baseUri
     *            BaseURI of data within stream
     * @return Number of loaded statements
     * @throws AnzoException
     *             if there is an error parsing data
     */
    public static int loadGraph(INamedGraph graph, Reader stream, RDFFormat format, String baseUri) throws AnzoException {
        if (graph.getNamedGraphUri() == null) {
            throw new AnzoException(ExceptionConstants.CORE.NULL_PARAMETER, "NamedGraphUri");
        }
        GraphStatementCollection sc = new GraphStatementCollection(graph);
        parseStatements(stream, format, baseUri, sc);

        return sc.totalSize;
    }

    /**
     * Load statements and the prefixes an input stream
     * 
     * @param rdf
     *            input containing data
     * @param format
     *            format of data
     * @param baseURI
     *            base uri of data
     * @param defaultGraphUri
     *            default graph for unbound statements
     * @return statements and prefixes
     * @throws AnzoException
     */
    public static StatementsAndPrefixes loadStatementsAndPrefixes(Reader rdf, RDFFormat format, String baseURI, URI defaultGraphUri) throws AnzoException {
        PrefixCollector sc = new PrefixCollector(defaultGraphUri);
        parseStatements(rdf, format, baseURI, sc);
        return new StatementsAndPrefixes(sc.getPrefixes(), sc.getStatements());
    }

    /**
     * Load the contents of an input stream and return the loaded statements
     * 
     * @param rdf
     *            Reader containing data
     * @param format
     *            Format which data is stored
     * @param baseURI
     *            BaseURI of data within stream
     * @return the loaded data
     * @throws AnzoException
     *             if there is an error parsing data
     */
    public static Collection<Statement> loadStatements(Reader rdf, RDFFormat format, String baseURI) throws AnzoException {
        StatementCollector sc = new StatementCollector();
        parseStatements(rdf, format, baseURI, sc);
        return sc.getStatements();
    }

    /**
     * Load the contents of a file and return a sets of statements for the different graphs
     * 
     * @param file
     *            file containing data
     * @return the loaded data
     * @throws AnzoException
     *             if there is an error parsing data
     * @throws FileNotFoundException
     *             if there is an error parsing data
     * @throws UnsupportedEncodingException
     *             if there is an error with the encoding type
     */
    public static MultiMap<URI, Statement> loadStatementSets(File file) throws UnsupportedEncodingException, FileNotFoundException, AnzoException {
        RDFFormat format = RDFFormat.forFileName(file.getName());
        return loadStatementSets(createSmartFileReader(file), format, "");
    }

    /**
     * Add all statements from src graph to destination graph
     * 
     * @param src
     *            Graph from which statements are added
     * @param dest
     *            Graph to which statements are added
     */
    public static void addGraph(INamedGraph src, INamedGraph dest) {
        dest.add(src.getStatements());
    }

    /**
     * Write statements to an output writer
     * 
     * @param statements
     *            statements to write out to writer
     * @param writer
     *            writer to which statements are written
     * @param format
     *            format of statements to write
     * @throws AnzoException
     */
    public static void writeStatements(Collection<Statement> statements, Writer writer, RDFFormat format) throws AnzoException {
        writeStatements(statements, writer, format, null, false);
    }

    /**
     * Write statements to an output writer
     * 
     * @param statements
     *            statements to write out to writer
     * @param writer
     *            writer to which statements are written
     * @param format
     *            format of statements to write
     * @param prefixes
     *            prefixes to write
     * @param sorted
     *            whether or not statements should be sorted before the are written
     * @throws AnzoException
     */
    public static void writeStatements(Collection<Statement> statements, Writer writer, RDFFormat format, Map<String, String> prefixes, boolean sorted) throws AnzoException {
        if (format.equals(RDFFormat.SPARQL)) {
            format = RDFFormat.N3;
        }
        IRDFHandler rdfWriter = getWriter(writer, format);
        if (rdfWriter != null) {
            try {
                rdfWriter.startRDF();
                if (prefixes != null && format.supportsNamespaces()) {
                    for (Map.Entry<String, String> prefix : prefixes.entrySet()) {
                        rdfWriter.handleNamespace(prefix.getKey(), prefix.getValue());
                    }
                }
                if (sorted) {
                    statements = new TreeSet<Statement>(statements);
                }
                for (Statement stmt : statements) {
                    rdfWriter.handleStatement(stmt);
                }
                rdfWriter.endRDF();
            } catch (UnsupportedRDFormatException e) {
                throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e);
            }
        }
    }

    /**
     * Write statements to an output writer
     * 
     * @param store
     *            statements to write out to writer
     * @param writer
     *            writer to which statements are written
     * @param format
     *            format of statements to write
     * @throws AnzoException
     */
    public static void writeQuadStore(org.openanzo.rdf.IQuadStore store, Writer writer, RDFFormat format) throws AnzoException {
        writeStatements(store.getStatements(), writer, format, null, true);
    }

    /**
     * Load data from a file into a dataset
     * 
     * @param store
     *            dataset to which statements are added
     * @param file
     *            source of data
     * @return total number of statements processed
     * @throws FileNotFoundException
     * @throws AnzoException
     * @throws UnsupportedEncodingException
     */
    public static int loadQuadStore(IDataset store, File file) throws UnsupportedEncodingException, FileNotFoundException, AnzoException {
        RDFFormat format = RDFFormat.forFileName(file.getName());
        return ReadWriteUtils.loadQuadStore(store, createSmartFileReader(file), format, "");
    }

    /**
     * Load data from a file into a dataset
     * 
     * @param store
     *            dataset to which statements are added
     * @param rdf
     *            source of data
     * @param format
     *            format of data
     * @param baseURI
     *            base uri for data
     * @return total number of statements processed
     * @throws AnzoException
     */
    public static int loadQuadStore(IDataset store, Reader rdf, RDFFormat format, String baseURI) throws AnzoException {
        if (!format.supportsNamedGraphs()) {
            throw new AnzoException(ExceptionConstants.IO.RDF_PARSER_ERROR, format.getDefaultMIMEType());
        }
        DatasetStatementCollection sc = new DatasetStatementCollection(store);
        parseStatements(rdf, format, baseURI, sc);
        return sc.totalSize;
    }

    /**
     * Statements and prefixes loaded from input
     */
    public static class StatementsAndPrefixes {
        private final Map<String, String>   prefixes;

        private final Collection<Statement> statements;

        /**
         * Create a new set of statements and prefixes
         * 
         * @param prefixes
         *            prefixes loaded from input
         * @param statements
         *            statements loaded
         */
        protected StatementsAndPrefixes(Map<String, String> prefixes, Collection<Statement> statements) {
            this.prefixes = prefixes;
            this.statements = statements;
        }

        /**
         * Get the prefixes loaded from input
         * 
         * @return the prefixes loaded from input
         */
        public Map<String, String> getPrefixes() {
            return prefixes;
        }

        /**
         * Get the statements loaded from input
         * 
         * @return the prefixes loaded from input
         */
        public Collection<Statement> getStatements() {
            return statements;
        }
    }

    static private class PrefixCollector extends StatementCollector {
        private final Map<String, String> prefixes = new HashMap<String, String>();

        private final URI                 defaultNamedGraphUri;

        /**
         * @param defaultNamedGraphUri
         *            URI of graph to which unbound statements are added
         */
        protected PrefixCollector(URI defaultNamedGraphUri) {
            super();
            this.defaultNamedGraphUri = defaultNamedGraphUri;
        }

        @Override
        public void handleNamespace(String prefix, String uri) throws AnzoException {
            prefixes.put(prefix, uri);
        }

        public Map<String, String> getPrefixes() {
            return prefixes;
        }

        @Override
        public void handleStatement(Statement statement) throws AnzoException {
            if (statement.getNamedGraphUri() == null && defaultNamedGraphUri != null) {
                super.handleStatement(Constants.valueFactory.createStatement(statement.getSubject(), statement.getPredicate(), statement.getObject(), defaultNamedGraphUri));
            } else {
                super.handleStatement(statement);
            }
        }
    }

    /**
     * Internal RDFHandler class that can batch additions to underlying graph. If no batch size is given, all statements are loaded into memory first, and then
     * added as one large batch.
     */
    static private class GraphStatementCollection implements IRDFHandler {

        private final INamedGraph graph;

        int                       totalSize = 0;

        GraphStatementCollection(INamedGraph graph) {
            this.graph = graph;
        }

        public void endRDF() throws AnzoException {
        }

        public void handleComment(String arg0) throws AnzoException {
        }

        public void handleNamespace(String arg0, String arg1) throws AnzoException {
        }

        public void handleStatement(Statement stmt) {
            if (stmt.getSubject() == null || stmt.getPredicate() == null || stmt.getObject() == null)
                throw new IllegalStateException("statement cannot contain nulls");
            graph.add(stmt);
            totalSize++;
        }

        public void startRDF() throws AnzoException {
        }
    }

    /**
     * Internal RDFHandler class that can batch additions to underlying graph. If no batch size is given, all statements are loaded into memory first, and then
     * added as one large batch.
     */
    static private class StatementCollection implements IRDFHandler {
        /** Batch Size */
        private final int                  batchSize;

        int                                totalSize  = 0;

        /** ArrayList of statements to add */
        private final ArrayList<Statement> statements = new ArrayList<Statement>();

        private final URI                  defaultGraphUri;

        private final IStatementsHandler   handler;

        StatementCollection(int batchSize, URI defaultGraphUri, IStatementsHandler handler) {
            this.batchSize = batchSize;
            this.defaultGraphUri = defaultGraphUri;
            this.handler = handler;
        }

        public void endRDF() throws AnzoException {
            if (statements.size() > 0) {
                handler.handleStatements(statements);
            }
        }

        public void handleComment(String arg0) throws AnzoException {
        }

        public void handleNamespace(String arg0, String arg1) throws AnzoException {
        }

        public void handleStatement(Statement stmt) {
            if (stmt.getSubject() == null || stmt.getPredicate() == null || stmt.getObject() == null)
                throw new IllegalStateException("statement cannot contain nulls");
            if (stmt.getNamedGraphUri() == null && defaultGraphUri == null) {
                throw new IllegalStateException("statement's namedGraphUri is null, and no defaultNamedGraphURI set");
            }
            if (stmt.getNamedGraphUri() == null) {
                statements.add(org.openanzo.rdf.Constants.valueFactory.createStatement(stmt.getSubject(), stmt.getPredicate(), stmt.getObject(), defaultGraphUri));
            } else {
                statements.add(stmt);
            }
            totalSize++;
            if (batchSize > -1 && statements.size() > batchSize) {
                try {
                    handler.handleStatements(statements);
                } catch (AnzoException ae) {
                    throw new AnzoRuntimeException(ae);
                }
                statements.clear();
            }
        }

        public void startRDF() throws AnzoException {
        }
    }

    /**
     * Internal RDFHandler class that can batch additions to underlying graph. If no batch size is given, all statements are loaded into memory first, and then
     * added as one large batch.
     */
    static private class SubjectToNamedGraphCollection implements IRDFHandler {
        /** Batch Size */
        private final int                  batchSize;

        int                                totalSize  = 0;

        /** ArrayList of statements to add */
        private final ArrayList<Statement> statements = new ArrayList<Statement>();

        private final IStatementsHandler   handler;

        SubjectToNamedGraphCollection(int batchSize, IStatementsHandler handler) {
            this.batchSize = batchSize;
            this.handler = handler;
        }

        public void endRDF() throws AnzoException {
            if (statements.size() > 0) {
                handler.handleStatements(statements);
            }
        }

        public void handleComment(String arg0) throws AnzoException {
        }

        public void handleNamespace(String arg0, String arg1) throws AnzoException {
        }

        public void handleStatement(Statement stmt) {
            if (stmt.getSubject() == null || stmt.getPredicate() == null || stmt.getObject() == null)
                throw new IllegalStateException("statement cannot contain nulls");
            if (stmt.getNamedGraphUri() == null && (stmt.getSubject() == null || !(stmt.getSubject() instanceof URI))) {
                throw new IllegalStateException("statement's namedGraphUri is null, and subject is null or not instance of URI");
            }
            if (stmt.getNamedGraphUri() == null) {
                statements.add(org.openanzo.rdf.Constants.valueFactory.createStatement(stmt.getSubject(), stmt.getPredicate(), stmt.getObject(), (URI) stmt.getSubject()));
            } else {
                statements.add(stmt);
            }
            totalSize++;
            if (batchSize > -1 && statements.size() > batchSize) {
                try {
                    handler.handleStatements(statements);
                } catch (AnzoException ae) {
                    throw new AnzoRuntimeException(ae);
                }
                statements.clear();
            }
        }

        public void startRDF() throws AnzoException {
        }
    }

    /**
     * Internal RDFHandler class that can batch additions to underlying graph. If no batch size is given, all statements are loaded into memory first, and then
     * added as one large batch.
     */
    static public class DatasetStatementCollection implements IRDFHandler {

        /** Graph to which statements are added */
        private final IDataset dataset;

        int                    totalSize = 0;

        /**
         * Create an IRDFHandler that added statements to a dataset
         * 
         * @param dataset
         */
        public DatasetStatementCollection(IDataset dataset) {
            this.dataset = dataset;
        }

        public void endRDF() throws AnzoException {
        }

        public void handleComment(String arg0) throws AnzoException {
        }

        public void handleNamespace(String arg0, String arg1) throws AnzoException {
        }

        public void handleStatement(Statement stmt) {
            if (!dataset.getNamedGraphUris().contains(stmt.getNamedGraphUri())) {
                dataset.addNamedGraph(stmt.getNamedGraphUri());
            }
            dataset.add(stmt);
            totalSize++;
        }

        public void startRDF() throws AnzoException {
        }
    }

    /**
     * Main Method converts owl files to trig
     * 
     * @param args
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("2 args: source dest");
            return;
        }
        File inputfile = new File(args[0]);
        if (inputfile.isDirectory()) {
            File[] owlFiles = inputfile.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.endsWith(".owl");
                }
            });
            File outputDir = new File(args[1]);
            for (File file : owlFiles) {
                URI uri = Constants.valueFactory.createURI(file.toURI().toString());
                try {
                    StatementsAndPrefixes sp = loadStatementsAndPrefixes(createSmartFileReader(file), RDFFormat.RDFXML, "", uri);
                    sp.getPrefixes().put("xsd", "http://www.w3.org/2001/XMLSchema#");
                    sp.getPrefixes().put("ont", "http://openanzo.org/ontologies/2008/07/");

                    ReadWriteUtils.writeStatements(sp.getStatements(), new OutputStreamWriter(new FileOutputStream(new File(outputDir, file.getName().replace(".owl", ".trig"))), "UTF-8"), RDFFormat.TRIG, sp.getPrefixes(), true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            URI uri = Constants.valueFactory.createURI(inputfile.toURI().toString());
            IDataset dataset = new Dataset();

            dataset.addNamedGraph(uri);
            try {
                StatementsAndPrefixes sp = loadStatementsAndPrefixes(createSmartFileReader(inputfile), RDFFormat.forFileName(inputfile.getName()), "", uri);
                ReadWriteUtils.writeStatements(sp.getStatements(), new OutputStreamWriter(new FileOutputStream(args[1]), "UTF-8"), RDFFormat.TRIG, sp.getPrefixes(), true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Read statements from an input source
     * 
     * @param reader
     *            input source of data
     * @param format
     *            format of RDF data
     * @param baseUri
     *            base URI for rdf data with no prefix
     * @return Iterator of statements
     * @throws AnzoException
     */
    public static MultiMap<URI, Statement> loadStatementSets(Reader reader, RDFFormat format, String baseUri) throws AnzoException {
        if (format.supportsNamedGraphs() || format.equals(RDFFormat.JSON)) {
            try {
                final SegmentedStatementCollector sc = new SegmentedStatementCollector();
                parseStatements(reader, format, baseUri, sc);
                return sc.getStatements();
            } catch (UnsupportedRDFormatException e) {
                throw new AnzoException(ExceptionConstants.IO.READ_ERROR, e);
            }
        } else {
            return new AnzoMultiMap<URI, Statement>();
        }
    }

    /**
     * Read statements from an input source
     * 
     * @param input
     *            input source of data
     * @param format
     *            format of RDF data
     * @return Iterator of statements
     * @throws AnzoException
     */
    public static MultiMap<URI, Statement> readStatementSets(String input, String format) throws AnzoException {
        return loadStatementSets(new StringReader(input), RDFFormat.forMIMEType(format), "");
    }

    /**
     * Read statements from an input source
     * 
     * @param input
     *            input source of data
     * @param format
     *            format of RDF data
     * @return Iterator of statements
     * @throws AnzoException
     */
    public static Collection<Statement> readStatements(String input, RDFFormat format) throws AnzoException {
        return loadStatements(new StringReader(input), format, "");
    }

}
