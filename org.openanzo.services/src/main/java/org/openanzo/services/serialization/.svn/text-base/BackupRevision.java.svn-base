/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Feb 14, 2009
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services.serialization;

import org.openanzo.rdf.URI;

/**
 * Object containing the information about a specific revison of a graph, used during backup/restore
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class BackupRevision {
    /** Revision of graph */
    public final long revision;

    /** When revision was started */
    public final Long start;

    /** When revision stopped being current revision */
    public final Long end;

    /** Who created this revision */
    public final URI  lastModifiedBy;

    /**
     * @param revision
     * @param start
     * @param end
     * @param lastModifiedBy
     */
    public BackupRevision(long revision, Long start, Long end, URI lastModifiedBy) {
        super();
        this.revision = revision;
        this.start = start;
        this.end = (end != null && end.longValue() > 0) ? end : null;
        this.lastModifiedBy = lastModifiedBy;
    }
}
