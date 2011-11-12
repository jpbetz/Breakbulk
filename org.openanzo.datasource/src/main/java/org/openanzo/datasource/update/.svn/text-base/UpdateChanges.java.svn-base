/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Feb 28, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.update;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.openanzo.datasource.IStoredNamedGraph;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;

/**
 * Set of updates
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class UpdateChanges {
    /** The added statements */
    public final Collection<Statement>  addedStatements    = new ArrayList<Statement>();

    /** The removed statements */
    public final Collection<Statement>  removedStatements  = new ArrayList<Statement>();

    /** The graphs that changed */
    public final Set<IStoredNamedGraph> namedGraphs        = new HashSet<IStoredNamedGraph>();

    /** The graphs removed */
    public final Map<URI, URI>          removedNamedGraphs = new HashMap<URI, URI>();
}
