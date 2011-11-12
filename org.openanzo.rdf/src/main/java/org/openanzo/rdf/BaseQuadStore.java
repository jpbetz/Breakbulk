/*******************************************************************************
 * Copyright (c) 2007-2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Dec 4, 2007
 * Revision: $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

package org.openanzo.rdf;

import java.util.Collection;

/**
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public abstract class BaseQuadStore implements IQuadStore {

    public void remove(Resource subj, URI pred, Value obj, URI... namedGraphUri) {
        if (subj == null || pred == null || obj == null || (namedGraphUri == null || namedGraphUri.length > 1)) {
            remove(find(subj, pred, obj, namedGraphUri));
        } else {
            remove(Constants.valueFactory.createStatement(subj, pred, obj, namedGraphUri[0]));
        }
    }

    public void remove(Collection<Statement> statements) {
        if (statements != null) {
            for (Statement stmt : statements) {
                remove(stmt);
            }
        }
    }

    public void add(Resource subj, URI pred, Value obj, URI namedGraphUri) {
        add(Constants.valueFactory.createStatement(subj, pred, obj, namedGraphUri));
    }

    public void add(Collection<Statement> statements) {
        if (statements != null) {
            for (Statement stmt : statements) {
                add(stmt);
            }
        }
    }

}
