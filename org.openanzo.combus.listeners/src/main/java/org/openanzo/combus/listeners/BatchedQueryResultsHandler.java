/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 9, 2008
 * Revision:	$Id$
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.combus.listeners;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.openanzo.analysis.RequestAnalysis;
import org.openanzo.analysis.RequestRecorder;
import org.openanzo.combus.MessageUtils;
import org.openanzo.combus.endpoint.BaseServiceListener;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryType;
import org.openanzo.rdf.Bindable;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IRDFHandler;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Variable;
import org.openanzo.rdf.adapter.BasicNodeConverter;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.services.serialization.IQueryResultsHandler;
import org.openrdf.query.TupleQueryResultHandlerException;
import org.openrdf.query.resultio.TupleQueryResultWriter;
import org.openrdf.query.resultio.sparqljson.SPARQLResultsJSONWriter;
import org.openrdf.query.resultio.sparqlxml.SPARQLResultsXMLWriter;
import org.openrdf.rio.UnsupportedRDFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Batch replication handler
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class BatchedQueryResultsHandler implements IQueryResultsHandler {
    private static final Logger    log            = LoggerFactory.getLogger(BaseServiceListener.class);

    private ByteArrayOutputStream  stream;

    private StringWriter           out;

    private List<String>           bindings;

    private TupleQueryResultWriter tqrw;

    private IRDFHandler            rdfWriter;

    private QueryType              queryType;

    private final int              batchSize;

    private final Destination      replyTo;

    private final String           operation;

    private final Session          session;

    private final MessageProducer  mp;

    private final TextMessage      request;

    private int                    totalSolutions = 0;

    private int                    size           = 0;

    private int                    totalSeen      = 0;

    private int                    sequence       = 0;

    private long                   totalWriteTime = 0;

    private BasicNodeConverter     converter      = new BasicNodeConverter();

    private RDFFormat              format;

    protected RequestRecorder      recorder       = null;

    BatchedQueryResultsHandler(int batchSize, Destination replyTo, String resultFormat, String operation, TextMessage request, Session session, MessageProducer mp, RequestRecorder recorder) {
        this.batchSize = batchSize;
        this.replyTo = replyTo;
        this.operation = operation;
        this.session = session;
        this.mp = mp;
        this.request = request;
        this.format = RDFFormat.forMIMEType(resultFormat);
        this.recorder = recorder;

    }

    public void start(QueryType queryType, int totalSolutions) throws AnzoException {
        this.totalWriteTime = 0;
        this.queryType = queryType;
        this.totalSolutions = totalSolutions;
        startMessage();
    }

    public void end() throws AnzoException {
        endMessage(true);
        if (RequestAnalysis.isAnalysisEnabled()) {
            RequestAnalysis.addAnalysisProperty("replicationWriteResults", totalWriteTime);
        }
    }

    public boolean handleStatement(Resource subject, URI predicate, Value object, URI namedGraphURI) throws AnzoException {
        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        if (namedGraphURI != null) {
            rdfWriter.handleStatement(Constants.valueFactory.createStatement(subject, predicate, object, namedGraphURI));
        } else {
            rdfWriter.handleStatement(Constants.valueFactory.createStatement(subject, predicate, object));
        }
        if (RequestAnalysis.isAnalysisEnabled()) {
            long end = System.currentTimeMillis();
            long time = end - start;
            totalWriteTime += time;
        }
        totalSeen++;
        if (batchSize > 0 && (size++ > batchSize)) {
            endMessage(false);
            startMessage();
            size = 0;
        }
        return true;
    }

    public boolean handleAskResult(boolean askResult) throws AnzoException {
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
        }
        return true;
    }

    private void startMessage() throws AnzoException {
        switch (queryType) {
        case ASK:
            out = new StringWriter();
            break;
        case DESCRIBE:
        case DESCRIBE_QUADS:
        case CONSTRUCT:
        case CONSTRUCT_QUADS:
            if (RDFFormat.SPARQL.equals(format)) {
                format = (queryType == QueryType.DESCRIBE_QUADS || queryType == QueryType.CONSTRUCT_QUADS) ? RDFFormat.TRIG : RDFFormat.N3;
            }
            out = new StringWriter();
            rdfWriter = ReadWriteUtils.getWriter(out, format);
            if (rdfWriter != null) {
                try {
                    rdfWriter.startRDF();
                } catch (UnsupportedRDFormatException e) {
                    throw new AnzoException(ExceptionConstants.IO.UNSUPPORTED_FORMAT_ERROR, e, format.getDefaultMIMEType());
                }
            }
            break;
        case SELECT:
            stream = new ByteArrayOutputStream();
            if (RDFFormat.JSON.equals(format)) {
                tqrw = new SPARQLResultsJSONWriter(stream);
            } else if (RDFFormat.SPARQL.equals(format)) {
                tqrw = new SPARQLResultsXMLWriter(stream);
            } else {
                throw new AnzoException(ExceptionConstants.IO.UNSUPPORTED_FORMAT_ERROR, format.getDefaultMIMEType());
            }
            if (bindings != null) {
                try {
                    tqrw.startQueryResult(bindings);
                } catch (TupleQueryResultHandlerException e) {
                    throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e);
                }
            }
            break;
        }
    }

    public boolean handleBindings(Collection<Bindable> bindables) throws AnzoException {
        bindings = new ArrayList<String>();
        for (Bindable binding : bindables) {
            String name;
            if (binding instanceof Variable) {
                name = ((Variable) binding).getName();
            } else {
                name = binding.toString();

            }
            bindings.add(name);
        }
        try {
            tqrw.startQueryResult(bindings);
        } catch (TupleQueryResultHandlerException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e);
        }
        return true;
    }

    public boolean handleSolution(PatternSolution solution) throws AnzoException {
        try {
            tqrw.handleSolution(converter.convert(solution));
            totalSeen++;
            if (batchSize > 0 && (++size > batchSize)) {
                endMessage(false);
                startMessage();
                size = 0;
            }
        } catch (TupleQueryResultHandlerException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e);
        }
        return true;
    }

    private void endMessage(boolean done) throws AnzoException {
        String results = null;
        if (tqrw != null) {
            try {
                tqrw.endQueryResult();
                results = new String(stream.toByteArray(), Constants.byteEncoding);
                stream.reset();
            } catch (TupleQueryResultHandlerException e) {
                throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e);
            } catch (IOException e) {
                throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e);
            }
        } else if (rdfWriter != null) {
            rdfWriter.endRDF();
            results = out.toString();
        } else if (out != null) {
            out.flush();
            results = out.toString();
        }
        try {

            TextMessage response = session.createTextMessage();
            response.setBooleanProperty(SerializationConstants.operationFailed, false);
            long start = 0;
            if (RequestAnalysis.isAnalysisEnabled()) {
                start = System.currentTimeMillis();
            }
            if (results != null && results.length() > 0) {
                response.setText(results);
            }
            if (replyTo != null) {
                response.setStringProperty(SerializationConstants.query, queryType.name());
                response.setJMSCorrelationID(request.getJMSCorrelationID());
                response.setIntProperty(SerializationConstants.protocolVersion, Constants.VERSION);
                response.setIntProperty(SerializationConstants.totalSolutions, totalSolutions);
                if (operation != null) {
                    response.setStringProperty(SerializationConstants.operation, operation);
                }
                if (log.isDebugEnabled()) {
                    log.debug(MessageUtils.prettyPrint(response, "Sending Response to [" + replyTo + "]"));
                }
                response.setBooleanProperty("done", done);

                if (!done || sequence > 0) {
                    response.setIntProperty("sequence", sequence);
                }
                if (RequestAnalysis.isAnalysisEnabled()) {
                    start = System.currentTimeMillis();
                    for (String name : RequestAnalysis.getAnalysisPropertyNames()) {
                        response.setStringProperty(name, RequestAnalysis.getAnalysisProperty(name).toString());
                    }
                }

                mp.send(replyTo, response);
                if (RequestAnalysis.isAnalysisEnabled()) {
                    long end = System.currentTimeMillis();
                    long time = end - start;
                    RequestAnalysis.addAnalysisProperty("sendReplicationBatch", time);
                }
                if (recorder != null) {
                    recorder.recordResponse(response);
                }
            }
        } catch (JMSException jmsex) {
            log.error(LogUtils.COMBUS_MARKER, "Error sending batched query service end message", jmsex);
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_SERVICE_EXCEPTION, jmsex);
        }
        sequence++;
    }
}
