/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/src/com/ibm/adtech/boca/indexer/StatementWrapper.java,v $
 * Created by:  Wing Yung (<a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com</a>)
 * Created on:  5/19/2006
 * Revision:	$Id: StatementWrapper.java 180 2007-07-31 14:24:13Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.internal;

import org.openanzo.rdf.Resource;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;

/**
 * Utility class for wrapping statements to be indexed.
 * 
 * @author Wing Yung (<a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com</a>)
 */
public class StatementWrapper {

    //private static Logger log         = LoggerFactory.getLogger(StatementWrapper.class.getName());

    private URI                 graphURI;

    private final Long          graphId;

    private Resource            subject;

    private final Long          subjectId;

    private URI                 predicate;

    private final Long          predicateId;

    private Value               object;

    private final Long          objectId;

    private final Long          modified;

    private static final String delim = "###";

    /**
     * Create a new StatementWrapper
     * 
     * @param graphURI
     *            NamedGraph's URI
     * @param graphId
     *            ID of NamedGraph's URI
     * @param subject
     *            Subject of statement
     * @param subjectId
     *            ID of subject
     * @param predicate
     *            Predicate of statement
     * @param predicateId
     *            ID of predicate
     * @param object
     *            Object of statement
     * @param objectId
     *            ID of object
     * @param modified
     *            Timestamp of modifiction
     */
    public StatementWrapper(URI graphURI, Long graphId, Resource subject, Long subjectId, URI predicate, Long predicateId, Value object, Long objectId, Long modified) {
        this.subject = subject;
        this.predicate = predicate;
        this.object = object;
        this.graphURI = graphURI;
        this.graphId = graphId;
        this.subjectId = subjectId;
        this.predicateId = predicateId;
        this.objectId = objectId;
        this.modified = modified;
    }

    /**
     * Create a new StatementWrapper
     * 
     * @param graphId
     *            ID of NamedGraph's URI
     * @param subjectId
     *            ID of subject
     * @param predicateId
     *            ID of predicate
     * @param objectId
     *            ID of object
     * @param modified
     *            Timestamp of modifiction
     */
    public StatementWrapper(Long graphId, Long subjectId, Long predicateId, Long objectId, Long modified) {
        this.graphId = graphId;
        this.subjectId = subjectId;
        this.predicateId = predicateId;
        this.objectId = objectId;
        this.modified = modified;
    }

    /**
     * Get the ID of this statement
     * 
     * @return the ID of this statement
     */
    public String getId() {
        String id = getGraphURI() + delim + getSubject() + delim + getPredicate() + delim + getObjectId().toString();
        return id;
    }

    /**
     * Get the statements object
     * 
     * @return the statements object
     */
    public Value getObject() {
        return object;
    }

    /**
     * Get the statements predicate
     * 
     * @return the statements predicate
     */
    public URI getPredicate() {
        return predicate;
    }

    /**
     * Get the statements subject
     * 
     * @return the statements subject
     */
    public Resource getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return graphURI + " " + subject + " " + predicate + " " + object;// + "(" + modified + ")";
    }

    /**
     * Get the NamedGraph URI
     * 
     * @return the NamedGraph URI
     */
    public URI getGraphURI() {
        return graphURI;
    }

    /**
     * Get the Object ID
     * 
     * @return the Object ID
     */
    public Long getObjectId() {
        return objectId;
    }

    /**
     * Get the modification timestamp
     * 
     * @return the modification timestamp
     */
    public Long getModified() {
        return modified;
    }

    /**
     * Get the NamedGraph URI ID
     * 
     * @return the NamedGraph URI ID
     */
    public Long getGraphId() {
        return graphId;
    }

    /**
     * Get the predicate ID
     * 
     * @return the predicate ID
     */
    public Long getPredicateId() {
        return predicateId;
    }

    /**
     * Get the subject ID
     * 
     * @return the subject ID
     */
    public Long getSubjectId() {
        return subjectId;
    }
}
