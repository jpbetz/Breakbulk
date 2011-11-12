/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 6, 2007
 * Revision:	$Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services.serialization;

import info.aduna.xml.XMLWriter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.jms.JMSException;
import javax.jms.Message;

import org.openanzo.analysis.RequestAnalysis;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryController;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.glitter.query.QueryType;
import org.openanzo.ontologies.openanzo.AnzoFactory;
import org.openanzo.ontologies.openanzo.Dataset;
import org.openanzo.ontologies.openanzo.Query;
import org.openanzo.ontologies.openanzo.Result;
import org.openanzo.rdf.AnzoGraph;
import org.openanzo.rdf.BlankNode;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IAnzoGraph;
import org.openanzo.rdf.IRDFWriter;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.NamedGraph;
import org.openanzo.rdf.PlainLiteral;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.adapter.BasicNodeConverter;
import org.openanzo.rdf.adapter.ResultHandler;
import org.openanzo.rdf.adapter.RioResultHandler;
import org.openanzo.rdf.adapter.RioToAnzoWriterAdapter;
import org.openanzo.rdf.utils.JSONRdfWriter;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.rdf.vocabulary.RDF;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.IPrecondition;
import org.openanzo.services.IUpdateTransaction;
import org.openanzo.services.IUpdates;
import org.openanzo.services.impl.AskResult;
import org.openanzo.services.impl.Precondition;
import org.openanzo.services.impl.Updates;
import org.openanzo.services.serialization.handlers.ClientUpdatesHandler;
import org.openrdf.query.TupleQueryResultHandlerException;
import org.openrdf.query.resultio.QueryResultParseException;
import org.openrdf.query.resultio.TupleQueryResultWriter;
import org.openrdf.query.resultio.sparqljson.SPARQLResultsJSONWriter;
import org.openrdf.query.resultio.sparqlxml.SPARQLResultsXMLParser;
import org.openrdf.query.resultio.sparqlxml.SPARQLResultsXMLWriter;

/**
 * Set of serializtion utilities
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class CommonSerializationUtils {

    /**
     * Write statements of NamedGraph and Metadata to the outputStream based on the format specified
     * 
     * @param namedGraph
     *            NamedGraph and Metadata to write
     * @param out
     *            output writer for which to write statements
     * @param format
     *            output format for results
     * @throws AnzoException
     *             if there is an error writing statements to output writer
     */
    public static void writeINamedGraph(IAnzoGraph namedGraph, Writer out, String format) throws AnzoException {
        IRDFWriter writer = null;
        RDFFormat rdfFormat = RDFFormat.forMIMEType(format);
        if (rdfFormat == RDFFormat.JSON) {
            writer = new JSONRdfWriter(out);
        } else if (rdfFormat.supportsNamedGraphs()) {
            writer = new RioToAnzoWriterAdapter(out, rdfFormat);
        }
        if (writer != null && writer.getRDFFormat().supportsNamedGraphs()) {
            writer.startRDF();
            for (Statement statement : namedGraph.getStatements()) {
                writer.handleStatement(statement);
            }
            for (Statement statement : namedGraph.getMetadataGraph().getStatements()) {
                writer.handleStatement(statement);
            }
            writer.endRDF();
        }
    }

    /**
     * Read an INamedGraphWithMetaData from a results stream
     * 
     * @param in
     *            input stream
     * @param format
     *            format of input stream
     * @return INamedGraphWithMetaData created from a results stream
     * @throws AnzoException
     */
    public static IAnzoGraph readINamedGraph(String in, String format) throws AnzoException {
        Collection<Statement> statements = ReadWriteUtils.readStatements(in, RDFFormat.forMIMEType(format));
        if (statements != null) {
            URI namedGraphURI = null;
            URI metadataGraphUri = null;
            Collection<Statement> metaStatements = new ArrayList<Statement>();
            for (Iterator<Statement> stmtsIter = statements.iterator(); stmtsIter.hasNext();) {
                Statement statement = stmtsIter.next();
                if (statement.getNamedGraphUri() != null && UriGenerator.isMetadataGraphUri(statement.getNamedGraphUri())) {
                    stmtsIter.remove();
                    metaStatements.add(statement);
                    if (metadataGraphUri == null)
                        metadataGraphUri = statement.getNamedGraphUri();
                    if (namedGraphURI == null && statement.getPredicate().equals(RDF.TYPE) && statement.getObject().equals(org.openanzo.ontologies.openanzo.NamedGraph.TYPE)) {
                        namedGraphURI = (URI) statement.getSubject();
                    }
                } else if (namedGraphURI == null) {
                    namedGraphURI = statement.getNamedGraphUri();
                }
            }
            IAnzoGraph namedGraph = new AnzoGraph(namedGraphURI, metadataGraphUri);
            namedGraph.add(statements.toArray(new Statement[0]));
            namedGraph.getMetadataGraph().add(metaStatements.toArray(new Statement[0]));
            return namedGraph;
        }
        return null;
    }

    /**
     * Write a set of URIs to the output
     * 
     * @param results
     *            query results to write out
     * @param out
     *            writer on which to write data
     * @param formatString
     *            format of output stream
     * @throws AnzoException
     *             if there is an error writing URIs to output writer
     */
    public static void writeQueryResults(QueryResults results, Writer out, String formatString) throws AnzoException {
        writeQueryResults(results, out, formatString, Constants.byteEncoding);
    }

    /**
     * Write a set of URIs to the output
     * 
     * @param results
     *            query results to write out
     * @param out
     *            writer on which to write data
     * @param formatString
     *            format of output stream
     * @param charset
     *            charset for the output stream
     * @throws AnzoException
     *             if there is an error writing URIs to output writer
     */
    public static void writeQueryResults(QueryResults results, Writer out, String formatString, String charset) throws AnzoException {
        long start = -1;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        if (charset == null) {
            charset = Constants.byteEncoding;
        }
        BasicNodeConverter converter = new BasicNodeConverter();
        try {
            RDFFormat format = RDFFormat.forMIMEType(formatString);
            if (results.isAskResult()) {
                boolean askResult = results.getAskResults();
                if (RDFFormat.JSON.equals(format)) {
                    if (askResult) {
                        out.write(SerializationConstants.SparqlConstants.JSON_ASK_TRUE);
                    } else {
                        out.write(SerializationConstants.SparqlConstants.JSON_ASK_FALSE);
                    }
                } else if (RDFFormat.SPARQL.equals(format)) {
                    if (askResult) {
                        out.write(SerializationConstants.SparqlConstants.SPARQL_XML_ASK_TRUE);
                    } else {
                        out.write(SerializationConstants.SparqlConstants.SPARQL_XML_ASK_FALSE);
                    }
                } else {

                }
            } else if (results.isConstructResult() || results.isDescribeResult()) {
                if (RDFFormat.SPARQL.equals(format)) {
                    format = results.doStatementsContainQuads() ? RDFFormat.TRIG : RDFFormat.N3;
                }
                Collection<Statement> resultSet = (results.isConstructResult()) ? results.getConstructResults() : results.getDescribeResults();
                ReadWriteUtils.writeStatements(resultSet, out, format);
            } else {
                Iterator<PatternSolution> iter = results.getSelectResults().iterator();

                TupleQueryResultWriter tqrw = null;
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                if (RDFFormat.JSON.equals(format)) {
                    tqrw = new SPARQLResultsJSONWriter(stream);
                } else if (RDFFormat.SPARQL.equals(format)) {
                    tqrw = new SPARQLResultsXMLWriter(new XMLWriter(stream, charset));
                } else {
                    throw new AnzoException(ExceptionConstants.IO.UNSUPPORTED_FORMAT_ERROR, format.getDefaultMIMEType());
                }
                tqrw.startQueryResult(new ArrayList<String>(results.getSelectResults().getBindingNames()));
                while (iter.hasNext()) {
                    tqrw.handleSolution(converter.convert(iter.next()));
                }
                tqrw.endQueryResult();
                out.write(stream.toString(Constants.byteEncoding));
            }
        } catch (TupleQueryResultHandlerException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e);
        }
        if (RequestAnalysis.isAnalysisEnabled()) {
            long end = System.currentTimeMillis();
            long time = end - start;
            RequestAnalysis.addAnalysisProperty("writeQueryResults", time);
        }
    }

    /**
     * Read the query results object from an input reader. First char in input is the type ({@link QueryType#SELECT},{@link QueryType#CONSTRUCT},
     * {@link QueryType#DESCRIBE},{@link QueryType#ASK}), second is a \n.
     * 
     * @param input
     *            input reader containing data
     * @param format
     *            content/type of data in reader
     * @return QueryResults from data
     * @throws AnzoException
     */
    public static QueryResults readQueryResult(String input, String format) throws AnzoException {
        int index = input.indexOf('\n');
        String type = input.substring(0, index);
        QueryType qType = QueryType.valueOf(type);
        return readQueryResult(qType, input.substring(index + 1), format);
    }

    /**
     * Read the query results object from an input reader
     * 
     * @param type
     *            type of query results {@link QueryType#SELECT},{@link QueryType#CONSTRUCT},{@link QueryType#DESCRIBE},{@link QueryType#ASK}
     * @param input
     *            input reader containing data
     * @param format
     *            content/type of data in reader
     * @return QueryResults from data
     * @throws AnzoException
     */
    public static QueryResults readQueryResult(QueryType type, String input, String format) throws AnzoException {
        if (input == null) {
            input = "";
        }
        switch (type) {
        case SELECT:
            if (RDFFormat.SPARQL.getDefaultMIMEType().equals(format)) {
                try {
                    RioResultHandler handler = new RioResultHandler(new ResultHandler());
                    SPARQLResultsXMLParser parser = new SPARQLResultsXMLParser(BasicNodeConverter.valueFactory);
                    parser.setTupleQueryResultHandler(handler);
                    parser.parse(new ByteArrayInputStream(input.getBytes(Constants.byteEncoding)));
                    return handler.getQueryResults();
                } catch (TupleQueryResultHandlerException e) {
                    throw new AnzoException(ExceptionConstants.IO.READ_ERROR, e);
                } catch (QueryResultParseException e) {
                    throw new AnzoException(ExceptionConstants.IO.READ_ERROR, e);
                } catch (IOException e) {
                    throw new AnzoException(ExceptionConstants.IO.READ_ERROR, e);
                }
            }
            return null;
        case ASK:
            return new QueryResults(SerializationConstants.SparqlConstants.SPARQL_XML_ASK_TRUE.equals(input), new QueryController(), -1);
        case CONSTRUCT:
        case DESCRIBE:
            if (RDFFormat.SPARQL.getDefaultMIMEType().equals(format)) {
                format = RDFFormat.N3.getDefaultMIMEType();
            }
            return new QueryResults(ReadWriteUtils.readStatements(input, RDFFormat.forMIMEType(format)), new QueryController(), -1);
            /*case DESCRIBE:
                if (SerializationConstants.MIMETYPE_SPARQL_XML.equals(format)) {
                    format = RDFFormat.N3.getDefaultMIMEType();
                }
                return new QueryResults(SerializationUtils.readStatements(input, format), false);*/
        case CONSTRUCT_QUADS:
        case DESCRIBE_QUADS:
            if (RDFFormat.SPARQL.getDefaultMIMEType().equals(format)) {
                format = RDFFormat.TRIG.getDefaultMIMEType();
            }
            return new QueryResults(ReadWriteUtils.readStatements(input, RDFFormat.forMIMEType(format)), new QueryController(), -1);
            /*case DESCRIBE:
                if (SerializationConstants.MIMETYPE_SPARQL_XML.equals(format)) {
                    format = RDFFormat.N3.getDefaultMIMEType();
                }
                return new QueryResults(SerializationUtils.readStatements(input, format), false);*/
        default:
            return null;

        }
    }

    /**
     * Serialize an array of IUpdateTransactions to an output stream
     * 
     * @param includeContents
     *            include all the added and removed statements in serialized output, or else just the overall transaction structure
     * @param updates
     *            updates to serialize
     * @param output
     *            to which serialize data is written
     * @param format
     *            format of outputStream to write
     * @throws AnzoException
     *             if there was an error serializing transactions
     */
    public static void writeUpdates(boolean includeContents, IUpdates updates, Writer output, String format) throws AnzoException {
        IUpdatesHandler transactionWriter = Writers.getUpdatesWriter(includeContents, output, format);
        transactionWriter.start();
        for (IUpdateTransaction transaction : updates.getTransactions()) {
            transactionWriter.handleTransaction(transaction);
        }
        transactionWriter.end();

    }

    /**
     * Creates a reader for the transaction update input stream.
     * 
     * @param input
     *            The input stream containing transaction updates
     * @param inputFormat
     *            the mime-type must be either application/json or application/anzo-+xml
     * @return An UpdateReader
     */
    public static IUpdatesReader getUpdatesReader(String input, String inputFormat) {
        IUpdatesReader formatReader;
        if (RDFFormat.JSON.getDefaultMIMEType().equals(inputFormat)) {
            formatReader = new JSONUpdatesReader(input);
        } else if (SerializationConstants.MIMETYPE_ANZO_XML.equals(inputFormat)) {
            formatReader = new XMLUpdatesReader(new StringReader(input));
        } else {
            throw new IllegalStateException("unsupported format: " + inputFormat);
        }
        return formatReader;
    }

    /**
     * Read transactions from a reader
     * 
     * @param reader
     *            reader containing data
     * @param format
     *            format of data
     * @return update results from reader
     * @throws AnzoException
     */
    public static IUpdates readTransactionUpdates(String reader, String format) throws AnzoException {
        ClientUpdatesHandler handler = new ClientUpdatesHandler();
        if (RDFFormat.JSON.getDefaultMIMEType().equals(format)) {
            JSONUpdatesReader.parseUpdateTransactions(reader, handler);
        } else if (SerializationConstants.MIMETYPE_ANZO_XML.equals(format)) {
            new XMLUpdatesReader(new StringReader(reader)).read(handler);
        } else {
            throw new IllegalStateException("unsupported format: " + format);
        }
        return new Updates(handler.getTransactions());
    }

    /**
     * Serialize a set of IPreconditions to a set of statements
     * 
     * @param preconditions
     *            to serialize
     * @return if there was an error serializing data
     */
    protected static Collection<Statement> serializePreconditions(Collection<IPrecondition> preconditions) {
        NamedGraph basicGraph = new NamedGraph(Constants.valueFactory.createURI("http://graph"));
        if (preconditions != null) {
            for (IPrecondition precondition : preconditions) {
                org.openanzo.ontologies.openanzo.Precondition precond = AnzoFactory.createPrecondition(Constants.valueFactory.createBNode(), basicGraph);
                if (precondition.getDefaultGraphUris() != null) {
                    precond.setDataset();
                    for (URI uri : precondition.getDefaultGraphUris()) {
                        precond.getDataset().addDefaultGraph(uri);
                    }
                }
                if (precondition.getNamedGraphUris() != null) {
                    precond.setDataset();
                    for (URI uri : precondition.getNamedGraphUris()) {
                        precond.getDataset().addNamedGraph(uri);
                    }
                }
                Query query = precond.setQuery();
                query.setQueryString(precondition.getQuery());
                if (precondition.getResult() instanceof AskResult) {
                    org.openanzo.ontologies.openanzo.AskResult ar = AnzoFactory.createAskResult(Constants.valueFactory.createBNode(), basicGraph);
                    ar.set_boolean(((AskResult) precondition.getResult()).getResultValue());
                    precond.setResult(ar);
                }
            }
        }
        return basicGraph.getStatements();
    }

    /**
     * Pull an object Value from the message
     * 
     * @param message
     *            jms message containing object
     * @return Value for object
     * @throws JMSException
     */
    public static Value getObjectFromMessage(Message message) throws JMSException {
        Value object = null;
        if (message.propertyExists(SerializationConstants.object) && message.propertyExists(SerializationConstants.objectType)) {
            String objectValue = message.getStringProperty(SerializationConstants.object);
            String objectType = message.getStringProperty(SerializationConstants.objectType);
            NodeType nodeType = NodeType.valueOf(objectType);
            if (nodeType != null) {
                switch (nodeType) {
                case URI:
                    object = Constants.valueFactory.createURI(objectValue);
                    break;
                case BNODE:
                    object = Constants.valueFactory.createBNode(objectValue);
                    break;
                case LITERAL: {
                    String dataType = message.getStringProperty(SerializationConstants.dataType);
                    String lang = message.getStringProperty(SerializationConstants.language);
                    if (dataType != null) {
                        URI datatype = Constants.valueFactory.createURI(dataType);
                        object = Constants.valueFactory.createLiteral(objectValue, datatype);
                    } else if (lang != null) {
                        object = Constants.valueFactory.createLiteral(objectValue, lang);
                    } else {
                        object = Constants.valueFactory.createLiteral(objectValue);
                    }
                }
                    break;
                case ANY:
                    object = Constants.ANY_URI;
                    break;
                }
            }
        }
        return object;
    }

    /**
     * Add an RDF object to a JMS message
     * 
     * @param message
     *            message to which object is added
     * @param value
     *            value of object to add
     * @throws JMSException
     */
    public static void setObjectInMessage(Message message, Value value) throws JMSException {
        if (value instanceof Literal) {
            Literal literal = (Literal) value;
            String objectString = literal.getLabel();

            message.setStringProperty(SerializationConstants.objectType, NodeType.LITERAL.name());

            if (literal instanceof TypedLiteral) {
                URI dt = ((TypedLiteral) literal).getDatatypeURI();
                message.setStringProperty(SerializationConstants.dataType, dt.toString());
            } else if (literal instanceof PlainLiteral) {
                String lang = ((PlainLiteral) literal).getLanguage();
                if (lang != null) {
                    message.setStringProperty(SerializationConstants.language, lang);
                }
            }
            message.setStringProperty(SerializationConstants.object, objectString);
        } else if (value instanceof URI) {
            message.setStringProperty(SerializationConstants.objectType, NodeType.URI.name());
            message.setStringProperty(SerializationConstants.object, value.toString());
        } else if (value instanceof BlankNode) {
            message.setStringProperty(SerializationConstants.objectType, NodeType.BNODE.name());
            message.setStringProperty(SerializationConstants.object, value.toString());
        }
    }

    /**
     * Pull a resource from the subject in the message. This is for parsing the serialization format of real-time update statement messages.
     * 
     * @param message
     *            jms message containing object
     * @return Resource for subject
     * @throws JMSException
     */
    public static Resource getSubjectFromMessage(Message message) throws JMSException {
        Resource subject = null;
        if (message.propertyExists(SerializationConstants.subject) && message.propertyExists(SerializationConstants.subjectType)) {
            String subjectValue = message.getStringProperty(SerializationConstants.subject);
            String subjectType = message.getStringProperty(SerializationConstants.subjectType);
            NodeType nodeType = NodeType.valueOf(subjectType);
            if (nodeType != null) {
                switch (nodeType) {
                case URI:
                    subject = Constants.valueFactory.createURI(subjectValue);
                    break;
                case BNODE:
                    subject = Constants.valueFactory.createBNode(subjectValue);
                    break;
                case ANY:
                    subject = Constants.ANY_URI;
                    break;
                }
            }
        }
        return subject;
    }

    /**
     * Add an RDF resource to a JMS message as the subject. This is for the real-time updates style of serializing a statement into JMS.
     * 
     * @param message
     *            message to which object is added
     * @param resource
     *            resource to add
     * @throws JMSException
     */
    public static void setSubjectInMessage(Message message, Resource resource) throws JMSException {
        String subjectType = resource instanceof BlankNode ? NodeType.BNODE.name() : NodeType.URI.name();
        message.setStringProperty(SerializationConstants.subjectType, subjectType);
        message.setStringProperty(SerializationConstants.subject, resource.toString());
    }

    /**
     * Write an AnzoPrincipal to the output
     * 
     * @param principal
     *            principal to write out
     * @param out
     *            writer on which to write data
     * @param format
     *            format of output stream
     * @throws AnzoException
     *             if there is an error writing URIs to output writer
     */
    public static void writeAnzoPrincipal(AnzoPrincipal principal, Writer out, String format) throws AnzoException {
        try {
            if (RDFFormat.JSON.getDefaultMIMEType().equals(format)) {
                JSONWritingUtils.writeAnzoPrincipal(out, principal);
            } else if (SerializationConstants.MIMETYPE_TEXT.equals(format)) {
                if (principal != null) {
                    out.write(principal.getName());
                    out.write('\n');
                    out.write(principal.getUserURI().toString());
                    out.write('\n');
                    for (URI role : principal.getRoles()) {
                        out.write(role.toString());
                        out.write(' ');
                    }
                    out.write('\n');
                    out.write(Boolean.toString(principal.isSysadmin()));
                    out.write('\n');
                    out.write(Boolean.toString(principal.isAnonymous()));
                }
            }
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e);
        }
    }

    /**
     * Read the AnzoPrincipal from the input reader
     * 
     * @param input
     *            input reader containing data
     * @param format
     *            format of the data
     * @return AnzoPrincipal for data
     * @throws AnzoException
     */
    public static AnzoPrincipal readAnzoPrincipal(Reader input, String format) throws AnzoException {
        try {
            BufferedReader br = new BufferedReader(input);
            String name = br.readLine();
            String uri = null;
            boolean isSysAdmin = false;
            boolean isAnonymous = false;
            if (br.ready()) {
                uri = br.readLine();
            }
            Set<URI> roles = new HashSet<URI>();
            if (br.ready()) {
                String rolesString = br.readLine();
                if (rolesString != null) {
                    StringTokenizer st = new StringTokenizer(rolesString, " ");
                    while (st.hasMoreTokens()) {
                        roles.add(Constants.valueFactory.createURI(st.nextToken()));
                    }
                }
            }
            if (br.ready()) {
                isSysAdmin = Boolean.parseBoolean(br.readLine());
            }
            if (br.ready()) {
                isAnonymous = Boolean.parseBoolean(br.readLine());
            }
            return new AnzoPrincipal(name, (uri != null) ? MemURI.create(uri) : null, roles, isSysAdmin, isAnonymous);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.READ_ERROR, e);
        }
    }

    /** Type of Nodes */
    public enum NodeType {
        /** URI */
        URI,
        /** Blank Node */
        BNODE,
        /** Literal */
        LITERAL,
        /** Any */
        ANY
    }

    /**
     * Convert a comma separated list of graphs and their revisions to a map
     * 
     * @param updates
     *            comma separated list of graphs and their revisions
     * @return map of graph to their revisions
     */
    public static Map<URI, Long> readNamedGraphRevisions(String updates) {
        Map<URI, Long> updateMap = new HashMap<URI, Long>();
        if (updates == null || updates.length() == 0)
            return updateMap;
        StringTokenizer tokenizer = new StringTokenizer(updates, ",");
        while (tokenizer.hasMoreTokens()) {
            String next = tokenizer.nextToken().trim();
            if (next.length() > 0) {
                String uri = next.substring(0, next.indexOf('='));
                String rev = next.substring(next.indexOf('=') + 1);
                updateMap.put(MemURI.create(uri), Long.valueOf(rev));
            }
        }
        return updateMap;
    }

    /**
     * Serialize map of graphs and their revisions to a comma seperated string
     * 
     * @param updates
     *            map of graphs to their revisions
     * @return seralized version of map
     */
    public static String writeNamedGraphRevisions(Map<URI, Long> updates) {
        if (updates == null || updates.size() == 0)
            return "";
        StringBuilder ngRevs = new StringBuilder();
        for (Map.Entry<URI, Long> entry : updates.entrySet()) {
            ngRevs.append(entry.getKey().toString());
            ngRevs.append('=');
            ngRevs.append(entry.getValue());
            ngRevs.append(',');
        }
        return ngRevs.toString();
    }

    /**
     * Parse a set of statements into the Preconditions that are encoded within
     * 
     * @param statements
     *            containing data for preconditions
     * @return set of preconditions contained within statements
     */
    protected static Set<IPrecondition> parsePreconditionStatements(Collection<Statement> statements) {

        NamedGraph basicGraph = new NamedGraph(Constants.valueFactory.createURI("http://graph"));
        for (Statement statement : statements) {
            basicGraph.add(statement);
        }
        Set<IPrecondition> preconditions = new HashSet<IPrecondition>();
        Iterable<org.openanzo.ontologies.openanzo.Precondition> precons = AnzoFactory.getAllPrecondition(basicGraph);
        for (org.openanzo.ontologies.openanzo.Precondition precon : precons) {
            IPrecondition precondition = new Precondition();
            Set<URI> defaults = null;
            Set<URI> namedGraphs = null;
            Dataset ds = precon.getDataset();
            defaults = new HashSet<URI>();
            Iterable<org.openanzo.ontologies.openanzo.NamedGraph> defaultIter = ds.getDefaultGraph();
            for (org.openanzo.ontologies.openanzo.NamedGraph gt : defaultIter) {
                defaults.add(Constants.valueFactory.createURI(gt.uri()));
            }
            precondition.setDefaultGraphUris(defaults);
            namedGraphs = new HashSet<URI>();
            Iterable<org.openanzo.ontologies.openanzo.NamedGraph> ngIter = ds.getNamedGraph();
            for (org.openanzo.ontologies.openanzo.NamedGraph gt : ngIter) {
                namedGraphs.add(Constants.valueFactory.createURI(gt.uri()));
            }
            precondition.setNamedGraphUris(namedGraphs);
            String query = (precon.getQuery() != null) ? precon.getQuery().getQueryString() : null;
            precondition.setQuery(query);
            Result result = precon.getResult();
            if (result.isRDFType(org.openanzo.ontologies.openanzo.AskResult.TYPE)) {
                org.openanzo.ontologies.openanzo.AskResult ar = AnzoFactory.createAskResult(result.resource(), basicGraph);
                precondition.setResult(ar.get_boolean());
            }
            preconditions.add(precondition);
        }
        return preconditions;
    }
}
