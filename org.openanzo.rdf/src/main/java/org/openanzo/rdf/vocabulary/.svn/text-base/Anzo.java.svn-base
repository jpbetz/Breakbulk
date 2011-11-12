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
package org.openanzo.rdf.vocabulary;

import org.openanzo.rdf.Constants;
import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.URI;

/**
 * Anzo Vocabulary Object
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class Anzo {

    protected static URI createProperty(String localName) {
        return MemURI.create(Constants.NAMESPACES.OPENANZO_ONTOLOGY_PREFIX + localName);
    }

    /** Default graph property */
    public static final URI DEFAULTGRAPH      = createProperty("defaultGraph");

    /** Default named graph property */
    public static final URI DEFAULTNAMEDGRAPH = createProperty("defaultNamedGraph");

    /** NamedGraph property */
    public static final URI NAMEDGRAPH        = createProperty("namedGraph");

    /** Dataset type property */
    public static final URI DATASET_TYPE      = createProperty("Dataset");

}
