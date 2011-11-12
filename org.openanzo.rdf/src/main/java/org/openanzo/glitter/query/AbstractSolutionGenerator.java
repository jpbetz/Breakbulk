/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Sep 7, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.glitter.query;

import org.openanzo.glitter.dataset.QueryDataset;

/**
 * Handles POJO getters and setters for solution generator implementations.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public abstract class AbstractSolutionGenerator implements SolutionGenerator {

    protected QueryDataset         dataset;

    private QueryExecutionPlan     plan;

    private QueryExecutionServices services;

    protected QueryInformation     information;

    public QueryInformation getQueryInformation() {
        return this.information;
    }

    public void setQueryInformation(QueryInformation queryInformation) {
        this.information = queryInformation;
    }

    public QueryDataset getQueryDataset() {
        return this.dataset;
    }

    public void setQueryDataset(QueryDataset dataset) {
        this.dataset = dataset;
    }

    public QueryExecutionServices getQueryExecutionServices() {
        return this.services;
    }

    public void setQueryExecutionServices(QueryExecutionServices services) {
        this.services = services;
    }

    public QueryExecutionPlan getQueryExecutionPlan() {
        return this.plan;
    }

    public void setQueryExecutionPlan(QueryExecutionPlan plan) {
        this.plan = plan;
    }
}
