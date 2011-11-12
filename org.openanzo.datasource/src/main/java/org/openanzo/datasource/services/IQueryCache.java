/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jan 25, 2010
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.services;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.glitter.dataset.QueryDataset;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.IUpdateResultListener;
import org.openanzo.services.IUpdates;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface IQueryCache extends IUpdateResultListener {

    public abstract void updateComplete(IOperationContext context, IUpdates results) throws AnzoException;

    public QueryResults findResults(String queryString, QueryDataset dataset);

    public void cacheResults(String queryString, QueryResults result, QueryDataset dataset);

    public void reset();
}
