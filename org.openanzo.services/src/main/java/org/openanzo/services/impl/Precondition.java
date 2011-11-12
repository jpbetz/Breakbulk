/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/commands/Attic/Precondition.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  7/17/2006
 * Revision:	$Id: Precondition.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.services.impl;

import java.util.Set;

import org.openanzo.rdf.URI;
import org.openanzo.services.IPrecondition;
import org.openanzo.services.IResult;

/**
 * Implementation of IPrecondition
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class Precondition implements IPrecondition {

    private Set<URI> defaultUris    = null;

    private Set<URI> namedGraphUris = null;

    private IResult  result         = null;

    private String   queryString    = null;

    /**
     * Create a new Precondition
     * 
     * @param defaultUris
     *            set of default graph URIs used during precondition query
     * @param namedGraphUris
     *            set of named graph URIs used during precondition query
     * @param queryString
     *            Sparql query string to run as precondition
     * @param expectTrue
     *            Expected results of running query
     */
    public Precondition(Set<URI> defaultUris, Set<URI> namedGraphUris, String queryString, boolean expectTrue) {
        this.defaultUris = defaultUris;
        this.namedGraphUris = namedGraphUris;
        this.queryString = queryString;
        this.result = AskResult.getAskResult(expectTrue);
    }

    /**
     * Create a new Precondition
     */
    public Precondition() {
        this.result = AskResult.getAskResult(true);

    }

    public String getQuery() {
        return queryString;
    }

    public IResult getResult() {
        return result;
    }

    public Set<URI> getDefaultGraphUris() {
        return defaultUris;
    }

    public Set<URI> getNamedGraphUris() {
        return namedGraphUris;
    }

    public void setDefaultGraphUris(Set<URI> defaultUris) {
        this.defaultUris = defaultUris;
    }

    public void setNamedGraphUris(Set<URI> namedGraphUris) {
        this.namedGraphUris = namedGraphUris;
    }

    public void setQuery(String queryString) {
        this.queryString = queryString;
    }

    public void setResult(boolean result) {
        this.result = AskResult.getAskResult(result);
    }
}
