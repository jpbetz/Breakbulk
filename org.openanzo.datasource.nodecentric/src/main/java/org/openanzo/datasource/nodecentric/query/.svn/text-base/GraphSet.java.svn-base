/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jan 15, 2009
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.query;

import java.util.Collection;
import java.util.HashSet;

import org.openanzo.rdf.URI;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class GraphSet extends HashSet<URI> {
    private static final long serialVersionUID   = -6945558219681114507L;

    private long              revisionedCount    = -1;

    private long              nonRevisionedCount = -1;

    private long              setId              = -1;

    protected GraphSet(Collection<URI> entries) {
        super(entries);
    }

    /**
     * Create graphSet
     * 
     * @param setId
     *            setId
     */
    public GraphSet(long setId) {
        super();
        this.setId = setId;
    }

    /**
     * @return the revisionedCount
     */
    public long getRevisionedCount() {
        return revisionedCount;
    }

    /**
     * @param revisionedCount
     *            the revisionedCount to set
     */
    public void setRevisionedCount(long revisionedCount) {
        this.revisionedCount = revisionedCount;
    }

    /**
     * @return the nonRevisionedCount
     */
    public long getNonRevisionedCount() {
        return nonRevisionedCount;
    }

    /**
     * @param nonRevisionedCount
     *            the nonRevisionedCount to set
     */
    public void setNonRevisionedCount(long nonRevisionedCount) {
        this.nonRevisionedCount = nonRevisionedCount;
    }

    /**
     * @return the setId
     */
    public long getSetId() {
        return setId;
    }

    /**
     * @param setId
     *            the setId to set
     */
    public void setSetId(long setId) {
        this.setId = setId;
    }

}
