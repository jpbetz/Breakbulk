/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.combus;

import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.SerializationConstants;
import org.openanzo.services.impl.UpdateTransaction;
import org.openanzo.services.serialization.CommonSerializationUtils;
import org.openanzo.services.serialization.NamedGraphUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides JMS Message related utility methods.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public class MessageUtils {
    private static final Logger log = LoggerFactory.getLogger(MessageUtils.class);

    /**
     * Creates a human readable string representing the provided message.
     * 
     * @param message
     *            The JMS Message
     * @param title
     *            A title to prefix the message text with.
     * @return Human readable string.
     * @throws JMSException
     */
    public static String prettyPrint(Message message, String title) throws JMSException {
        if (message == null)
            return "Null Message.";

        StringBuilder builder = new StringBuilder();

        builder.append(title);
        builder.append("\n");
        builder.append("[JMS-MESSAGE]-----------------------------------------------------------");
        builder.append("\n");

        Destination destination = message.getJMSDestination();
        if (destination != null) {
            builder.append("Destination = " + destination);
            builder.append("\n");
        }

        Destination replyTo = message.getJMSReplyTo();
        if (replyTo != null) {
            builder.append("ReplyTo = " + replyTo);
            builder.append("\n");
        }
        //builder.append("ElapsedTime: " + (currTime - messageTime) + "ms");
        //builder.append("\n");
        if (message.getJMSCorrelationID() != null) {
            builder.append("JMSCorrelationID = " + message.getJMSCorrelationID());
            builder.append("\n");
        }

        for (Enumeration<?> e = message.getPropertyNames(); e.hasMoreElements();) {
            String name = (String) e.nextElement();
            builder.append(name + " = " + message.getObjectProperty(name));
            builder.append("\n");
        }
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            String text = textMessage.getText();
            if (text != null) {
                builder.append("Text = \n");
                builder.append(text);
                builder.append("\n");
            }
        }

        builder.append("--------------------------------------------------------------------//");
        builder.append("\n");

        return builder.toString();
    }

    /**
     * 
     * @param topicMessage
     * @return whether or a not a replication is required after processing this message
     * @throws AnzoException
     * @throws JMSException
     */
    public static NamedGraphUpdate processNamedGraphUpdateMessage(Message topicMessage) throws AnzoException, JMSException {

        String transactionUri = topicMessage.propertyExists(SerializationConstants.transactionURI) ? topicMessage.getStringProperty(SerializationConstants.transactionURI) : null;

        String namedGraphUri = topicMessage.propertyExists(SerializationConstants.namedGraphUri) ? topicMessage.getStringProperty(SerializationConstants.namedGraphUri) : null;
        String uuid = topicMessage.propertyExists(SerializationConstants.namedGraphUUID) ? topicMessage.getStringProperty(SerializationConstants.namedGraphUUID) : null;
        String ngRevs = topicMessage.propertyExists(SerializationConstants.namedGraphUpdates) ? topicMessage.getStringProperty(SerializationConstants.namedGraphUpdates) : null;
        String additions = topicMessage.propertyExists(SerializationConstants.additions) ? topicMessage.getStringProperty(SerializationConstants.additions) : null;
        String removals = topicMessage.propertyExists(SerializationConstants.removals) ? topicMessage.getStringProperty(SerializationConstants.removals) : null;
        String metaAdditions = topicMessage.propertyExists(SerializationConstants.metaAdditions) ? topicMessage.getStringProperty(SerializationConstants.metaAdditions) : null;
        String metaRemovals = topicMessage.propertyExists(SerializationConstants.metaRemovals) ? topicMessage.getStringProperty(SerializationConstants.metaRemovals) : null;
        String transactionContext = topicMessage.propertyExists(SerializationConstants.transactionContext) ? topicMessage.getStringProperty(SerializationConstants.transactionContext) : null;
        long transactionTimestamp = topicMessage.propertyExists(SerializationConstants.transactionTimestamp) ? topicMessage.getLongProperty(SerializationConstants.transactionTimestamp) : 0;

        //System.err.println("Processing Message: " + additions);

        URI uri = Constants.valueFactory.createURI(transactionUri);

        URI uuidURI = Constants.valueFactory.createURI(uuid);

        Map<URI, Long> revs = CommonSerializationUtils.readNamedGraphRevisions(ngRevs);

        Collection<Statement> adds = null;
        Collection<Statement> removes = null;
        Collection<Statement> metaAdds = null;
        Collection<Statement> metaRemoves = null;
        try {
            adds = (additions != null) ? ReadWriteUtils.readStatements(additions, RDFFormat.JSON) : Collections.<Statement> emptySet();
            removes = (removals != null) ? ReadWriteUtils.readStatements(removals, RDFFormat.JSON) : Collections.<Statement> emptySet();
            metaAdds = (metaAdditions != null) ? ReadWriteUtils.readStatements(metaAdditions, RDFFormat.JSON) : Collections.<Statement> emptySet();
            metaRemoves = (metaRemovals != null) ? ReadWriteUtils.readStatements(metaRemovals, RDFFormat.JSON) : Collections.<Statement> emptySet();
        } catch (AnzoException e) {
            log.error(LogUtils.COMBUS_MARKER, Messages.formatString(ExceptionConstants.COMBUS.ERROR_PROCESSING_MESSGE, "namedgraph update message"), e);
            throw e;
        }
        URI ngUri = MemURI.create(namedGraphUri);

        Long revision = revs.get(uuidURI);
        NamedGraphUpdate update = new NamedGraphUpdate(ngUri, uuidURI, adds, removes, metaAdds, metaRemoves);
        if (revision != null) {
            update.setRevision(revision);
        }
        Collection<Statement> tc = null;
        if (transactionContext != null) {
            tc = ReadWriteUtils.readStatements(transactionContext, RDFFormat.JSON);
        }
        update.setTransaction(new UpdateTransaction(uri, transactionTimestamp, tc, revs));
        return update;
    }
}
