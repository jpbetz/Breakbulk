/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Nov 1, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services.serialization.handlers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.openanzo.rdf.URI;
import org.openanzo.services.serialization.IValueSetHandler;

/**
 * URIStringValueSetHandler handles a set of {@link URI} objects and adds them into a set of {@link URI} objects
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class URIValueSetHandler implements IValueSetHandler<URI> {
    private final Set<URI> uris = new HashSet<URI>();

    /**
     * create a new URIValueSetHandler
     */
    public URIValueSetHandler() {
    }

    /**
     * Get the set of {@link URI} objects
     * 
     * @return the set of {@link URI} objects
     */
    public Set<URI> getURIs() {
        return uris;
    }

    public void handleValue(URI value) throws IOException {
        uris.add(value);
    }

    public void start() throws IOException {
    }

    public void end() throws IOException {
    }
}
