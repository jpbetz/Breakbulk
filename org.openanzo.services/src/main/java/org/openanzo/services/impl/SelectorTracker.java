/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/services/trackers/SelectorTracker.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  5/19/2005
 * Revision:	$Id: SelectorTracker.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     C Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.services.impl;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IStatementListener;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.services.ITracker;

/**
 * Used to track statements which match a specified selector pattern.
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * @author Jordi A. Albornoz Mulligan
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 */
public class SelectorTracker implements ITracker {

    protected final Set<URI>                                        namedGraphUri;

    protected final Set<Resource>                                   subject;

    protected final Set<URI>                                        predicate;

    protected final Set<Value>                                      object;

    private final CopyOnWriteArraySet<IStatementListener<ITracker>> listeners = new CopyOnWriteArraySet<IStatementListener<ITracker>>();

    /**
     * Create a new SelectorTracker
     * 
     * @param namedGraphUri
     *            URIs of graphs of match statement
     * @param subject
     *            Subject of match statement
     * @param predicate
     *            Predicate of match statement
     * @param object
     *            Object of match statement
     */
    public SelectorTracker(Set<Resource> subject, Set<URI> predicate, Set<Value> object, Set<URI> namedGraphUri) {
        this.namedGraphUri = namedGraphUri;
        this.subject = subject;
        this.predicate = predicate;
        this.object = object;
    }

    /**
     * Create a new SelectorTracker
     * 
     * @param namedGraphUri
     *            URIs of graphs of match statement
     * @param subject
     *            Subject of match statement
     * @param predicate
     *            Predicate of match statement
     * @param object
     *            Object of match statement
     */
    public SelectorTracker(Resource subject, URI predicate, Value object, URI namedGraphUri) {
        this.namedGraphUri = toSet(namedGraphUri);
        this.subject = toSet(subject);
        this.predicate = toSet(predicate);
        this.object = toSet(object);
    }

    private <K> Set<K> toSet(K value) {
        if (value == null) {
            return Collections.<K> emptySet();
        } else if (Constants.ANY_URI.equals(value)) {
            return Collections.<K> emptySet();
        } else {
            return Collections.<K> singleton(value);
        }
    }

    public TrackerType getType() {
        return TrackerType.STATEMENT;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof SelectorTracker) {
            SelectorTracker tracker = (SelectorTracker) o;
            return (tracker.getNamedGraphUri() == null && getNamedGraphUri() == null) || (tracker.getNamedGraphUri() != null && tracker.getNamedGraphUri().equals(getNamedGraphUri())) || (getNamedGraphUri() != null && getNamedGraphUri().equals(tracker.getNamedGraphUri())) && (tracker.getSubject() == null && getSubject() == null) || (tracker.getSubject() != null && tracker.getSubject().equals(getSubject())) || (getSubject() != null && getSubject().equals(tracker.getSubject()))
                    && (tracker.getPredicate() == null && getPredicate() == null) || (tracker.getPredicate() != null && tracker.getPredicate().equals(getPredicate())) || (getPredicate() != null && getPredicate().equals(tracker.getPredicate())) && (tracker.getObject() == null && getObject() == null) || (tracker.getObject() != null && tracker.getObject().equals(getObject())) || (getObject() != null && getObject().equals(tracker.getObject()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        // hard-coded, randomly chosen, non-zero, odd numbers to seed the hash (ideally prime numbers)
        int code = new HashCodeBuilder(23, 59).append(namedGraphUri).append(subject).append(predicate).append(object).toHashCode();
        return code;
    }

    @Override
    public String toString() {
        return "SelectorTracker (matchStatement= ' " + subject + " " + predicate + " " + object + "' " + namedGraphUri + ")";
    }

    /*    public static String buildMessageSelector(Resource subject, URI predicate, Value object, URI[] namedGraphUri) {
            String messageSelector = "";
            if (namedGraphUri != null) {
                messageSelector = "(";

                for (int i = 0; i < namedGraphUri.length; i++) {
                    messageSelector += SerializationConstants.namedGraphUri + " = '" + namedGraphUri[i].toString() + "'";
                    if (i < (namedGraphUri.length - 1)) {
                        messageSelector += " OR ";
                    }
                }
                messageSelector = ")";
            }
            if (subject != null) {
                if (messageSelector.length() > 0) {
                    messageSelector += " AND ";
                }
                String uri = subject.toString();
                messageSelector = SerializationConstants.subject + " = '" + uri + "'";
            }
            if (predicate != null) {
                if (messageSelector.length() > 0) {
                    messageSelector += " AND ";
                }
                String uri = predicate.toString();
                messageSelector += SerializationConstants.predicate + " = '" + uri + "'";
            }
            if (object != null) {
                boolean appending = false;
                if (messageSelector.length() > 0) {
                    messageSelector += " AND (";
                    appending = true;
                }
                if (object instanceof URI) {
                    String uri = object.toString();
                    messageSelector += "(" + SerializationConstants.object + " = '" + uri + "' AND " + SerializationConstants.objectType + " = '" + CommonSerializationUtils.NodeType.URI.name() + "')";
                } else if (object instanceof BlankNode) {
                    String uri = object.toString();
                    messageSelector += "(" + SerializationConstants.object + " = '" + uri + "' AND " + SerializationConstants.objectType + " = '" + CommonSerializationUtils.NodeType.BNODE.name() + "')";
                } else {
                    Literal literal = (Literal) object;
                    String objectValue = literal.getLabel();
                    messageSelector += "(" + SerializationConstants.object + " = '" + objectValue + "' AND " + SerializationConstants.objectType + " = '" + CommonSerializationUtils.NodeType.LITERAL.name() + "'";
                    if (literal instanceof TypedLiteral) {
                        URI dt = ((TypedLiteral) literal).getDatatype();
                        messageSelector += " " + SerializationConstants.dataType + " = '" + dt.toString() + "')";
                    } else if (literal instanceof PlainLiteral) {
                        String lang = ((PlainLiteral) literal).getLanguage();
                        if (lang != null) {
                            messageSelector += " " + SerializationConstants.language + " = '" + lang + "')";
                        }
                    }
                    messageSelector += ")";
                }
                if (appending) {
                    messageSelector += ")";
                }
            }
            return messageSelector;
        }
    */

    /**
     * Get the namedGraph URIS this tracker is monitoring
     * 
     * @return URIs
     */
    public Set<URI> getNamedGraphUri() {
        return namedGraphUri;
    }

    /*public String getMessageSelector() {
        return messageSelector;
    }*/

    /**
     * The tracker's object value
     * 
     * @return the object
     */
    public Set<Value> getObject() {
        return object;
    }

    /**
     * The tracker's predicate value
     * 
     * @return the predicate
     */
    public Set<URI> getPredicate() {
        return predicate;
    }

    /**
     * The tracker's subject value
     * 
     * @return the subject
     */
    public Set<Resource> getSubject() {
        return subject;
    }

    /**
     * Add a tracker listener
     * 
     * @param listener
     *            listener to add
     */
    public void addListener(IStatementListener<ITracker> listener) {
        listeners.add(listener);
    }

    /**
     * Remove a tracker listener
     * 
     * @param listener
     *            listener to remove
     */
    public void removeListener(IStatementListener<ITracker> listener) {
        listeners.remove(listener);
    }

    /**
     * Notify listeners of a change
     * 
     * @param addition
     *            was a statement added or removed
     * @param statements
     *            statements added
     */
    public void notifyListeners(boolean addition, Statement... statements) {
        for (IStatementListener<ITracker> listener : listeners) {
            if (addition) {
                listener.statementsAdded(this, statements);
            } else {
                listener.statementsRemoved(this, statements);
            }
        }
    }

    /**
     * Get the set of listeners
     * 
     * @return the set of listeners
     */
    public Set<IStatementListener<ITracker>> getListeners() {
        return Collections.unmodifiableSet(listeners);
    }

}
