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

import java.io.StringWriter;

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
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.services.serialization.IReplicationHandler;
import org.openanzo.services.serialization.JSONReplicationWriter;
import org.openanzo.services.serialization.XMLReplicationWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Batch replication handler
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class BatchedReplicationHandler implements IReplicationHandler {
    private static final Logger   log            = LoggerFactory.getLogger(BaseServiceListener.class);

    private StringWriter          outputWriter;

    private IReplicationHandler   writer;

    private final boolean         xml;

    private final int             batchSize;

    private final Destination     replyTo;

    private final String          operation;

    private final Session         session;

    private final MessageProducer mp;

    private final TextMessage     request;

    private int                   size           = 0;

    private int                   totalSize      = 0;

    private int                   totalSeen      = 0;

    private int                   sequence       = 0;

    private URI                   lastNamedGraphUri;

    private URI                   lastUuid;

    private Long                  lastRevision   = null;

    private long                  totalWriteTime = 0;

    protected RequestRecorder     recorder       = null;

    BatchedReplicationHandler(int batchSize, Destination replyTo, String resultFormat, String operation, TextMessage request, Session session, MessageProducer mp, RequestRecorder recorder) {
        this.xml = (SerializationConstants.MIMETYPE_ANZO_XML.equals(resultFormat));
        this.batchSize = batchSize;
        this.replyTo = replyTo;
        this.operation = operation;
        this.session = session;
        this.mp = mp;
        this.request = request;
        this.recorder = recorder;
    }

    public void start(int totalSize) throws AnzoException {
        this.totalWriteTime = 0;
        this.totalSize = totalSize;
        startMessage();
    }

    public void end() throws AnzoException {
        endMessage(true);
        if (RequestAnalysis.isAnalysisEnabled()) {
            RequestAnalysis.addAnalysisProperty("replicationWriteResults", totalWriteTime);
        }
    }

    public boolean handleNamedGraph(URI namedGraphUri, URI uuid, long revision) throws AnzoException {
        lastNamedGraphUri = namedGraphUri;
        lastUuid = uuid;
        lastRevision = revision;
        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        boolean ret = writer.handleNamedGraph(namedGraphUri, uuid, revision);
        if (RequestAnalysis.isAnalysisEnabled()) {
            long end = System.currentTimeMillis();
            long time = end - start;
            totalWriteTime += time;
        }
        return ret;
    }

    public boolean handleStatement(boolean metadata, boolean addition, Resource subject, URI predicate, Value object, URI namedGraphURI) throws AnzoException {
        long start = 0;
        if (RequestAnalysis.isAnalysisEnabled()) {
            start = System.currentTimeMillis();
        }
        writer.handleStatement(metadata, addition, subject, predicate, object, namedGraphURI);
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

    private void startMessage() throws AnzoException {
        outputWriter = new StringWriter();
        if (xml) {
            writer = new XMLReplicationWriter(outputWriter);
        } else {
            writer = new JSONReplicationWriter(outputWriter);
        }
        writer.start(this.totalSize);
        if (lastNamedGraphUri != null) {
            writer.handleNamedGraph(lastNamedGraphUri, lastUuid, lastRevision);
        }
    }

    private void endMessage(boolean done) throws AnzoException {
        if (writer != null) {
            writer.end();

            try {
                TextMessage response = session.createTextMessage();
                response.setIntProperty(SerializationConstants.protocolVersion, Constants.VERSION);
                response.setBooleanProperty(SerializationConstants.operationFailed, false);
                long start = 0;
                if (RequestAnalysis.isAnalysisEnabled()) {
                    start = System.currentTimeMillis();
                }
                String out = outputWriter.toString();
                if (RequestAnalysis.isAnalysisEnabled()) {
                    long end = System.currentTimeMillis();
                    long time = end - start;
                    totalWriteTime += time;
                }
                if (out.length() > 0) {
                    response.setText(out);
                }
                if (replyTo != null) {
                    response.setJMSCorrelationID(request.getJMSCorrelationID());
                    if (operation != null) {
                        response.setStringProperty(SerializationConstants.operation, operation);
                    }
                    if (log.isDebugEnabled()) {
                        log.debug(MessageUtils.prettyPrint(response, "Sending Response to [" + replyTo + "]"));
                    }
                    response.setBooleanProperty("done", done);

                    if (!done || sequence > 0) {
                        response.setIntProperty("sequence", sequence);
                        response.setIntProperty("totalSize", totalSize);
                    }
                    if (RequestAnalysis.isAnalysisEnabled()) {
                        start = System.currentTimeMillis();
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
                log.error(LogUtils.COMBUS_MARKER, "Error sending batched replication service end message", jmsex);
                throw new AnzoException(ExceptionConstants.COMBUS.JMS_SERVICE_EXCEPTION, jmsex);
            }
        }
        sequence++;
    }
}
