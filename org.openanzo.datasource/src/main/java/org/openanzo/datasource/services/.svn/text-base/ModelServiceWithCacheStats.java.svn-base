/*******************************************************************************
 * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Generated Source from org.openanzo.jdbc.utils.opgen.jet
 * Created on:  Generated Source from org.openanzo.jdbc.utils.opgen.jet
 * Revision:	$Id$
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *	   Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.datasource.services;

import org.apache.activemq.management.CountStatisticImpl;
import org.openanzo.services.DynamicServiceStats;

/**
 * Statistics object for Model Service interface
 * 
 * @author Generated Code
 * 
 */
public class ModelServiceWithCacheStats extends DynamicServiceStats {

    protected CountStatisticImpl findStatementsHit;

    protected CountStatisticImpl findStatementsMiss;

    /*protected CountStatisticImpl getStoredNamedGraphsMiss;
    protected CountStatisticImpl getStoredNamedGraphsMiss;
    */
    protected CountStatisticImpl containsNamedGraphHit;

    protected CountStatisticImpl containsNamedGraphMiss;

    protected CountStatisticImpl getNamedGraphRevisionHit;

    protected CountStatisticImpl getNamedGraphRevisionMiss;

    protected CountStatisticImpl getSizeHit;

    protected CountStatisticImpl getSizeMiss;

    protected CountStatisticImpl getUriForUUIDHit;

    protected CountStatisticImpl getUriForUUIDMiss;

    protected CountStatisticImpl getUUIDforUriHit;

    protected CountStatisticImpl getUUIDforUriMiss;

    protected CountStatisticImpl resolveNamedDatasetHit;

    protected CountStatisticImpl resolveNamedDatasetMiss;

    /**
     * Create a new Statistics object for an ModelService
     * 
     * @param methodNames
     *            method names
     */
    public ModelServiceWithCacheStats(String... methodNames) {
        super(methodNames);
        containsNamedGraphHit = new CountStatisticImpl("containsNamedGraphHit", "Number of hits for containsNamedGraph method.");
        containsNamedGraphMiss = new CountStatisticImpl("containsNamedGraphMiss", "Number of misses for containsNamedGraph method.");
        addStatistic(containsNamedGraphHit.getName(), containsNamedGraphHit);
        addStatistic(containsNamedGraphMiss.getName(), containsNamedGraphMiss);

        findStatementsHit = new CountStatisticImpl("findStatementsHit", "Number of hits for findStatements method.");
        findStatementsMiss = new CountStatisticImpl("findStatementsMiss", "Number of misses for findStatements method.");
        addStatistic(findStatementsHit.getName(), findStatementsHit);
        addStatistic(findStatementsMiss.getName(), findStatementsMiss);

        getNamedGraphRevisionHit = new CountStatisticImpl("getNamedGraphRevisionHit", "Number hits for  getNamedGraphRevision method.");
        getNamedGraphRevisionMiss = new CountStatisticImpl("getNamedGraphRevisionMiss", "Number of misses for getNamedGraphRevision method.");
        addStatistic(getNamedGraphRevisionHit.getName(), getNamedGraphRevisionHit);
        addStatistic(getNamedGraphRevisionMiss.getName(), getNamedGraphRevisionMiss);

        getSizeHit = new CountStatisticImpl("getSizeHit", "Number hits for getSize method.");
        getSizeMiss = new CountStatisticImpl("getSizeMiss", "Number of misses for getSize method.");
        addStatistic(getSizeHit.getName(), getSizeHit);
        addStatistic(getSizeMiss.getName(), getSizeMiss);

        getUriForUUIDHit = new CountStatisticImpl("getUriForUUIDHit", "Number hits for  getUriForUUID method.");
        getUriForUUIDMiss = new CountStatisticImpl("getUriForUUIDMiss", "Number of misses for getUriForUUID method.");
        addStatistic(getUriForUUIDHit.getName(), getUriForUUIDHit);
        addStatistic(getUriForUUIDMiss.getName(), getUriForUUIDMiss);

        getUUIDforUriHit = new CountStatisticImpl("getUUIDforUriHit", "Number hits for  getUUIDforUri method.");
        getUUIDforUriMiss = new CountStatisticImpl("getUUIDforUriMiss", "Number of misses for getUUIDforUri method.");
        addStatistic(getUUIDforUriHit.getName(), getUUIDforUriHit);
        addStatistic(getUUIDforUriMiss.getName(), getUUIDforUriMiss);

        resolveNamedDatasetHit = new CountStatisticImpl("resolveNamedDatasetHit", "Number of hits for resolveNamedDataset method.");
        resolveNamedDatasetMiss = new CountStatisticImpl("resolveNamedDatasetMiss", "Number of misses for resolveNamedDataset method.");
        addStatistic(resolveNamedDatasetHit.getName(), resolveNamedDatasetHit);
        addStatistic(resolveNamedDatasetMiss.getName(), resolveNamedDatasetMiss);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        containsNamedGraphHit.setEnabled(enabled);
        containsNamedGraphMiss.setEnabled(enabled);
        findStatementsHit.setEnabled(enabled);
        findStatementsMiss.setEnabled(enabled);
        getNamedGraphRevisionHit.setEnabled(enabled);
        getNamedGraphRevisionMiss.setEnabled(enabled);
        getSizeHit.setEnabled(enabled);
        getSizeMiss.setEnabled(enabled);
        getUriForUUIDHit.setEnabled(enabled);
        getUriForUUIDMiss.setEnabled(enabled);
        getUUIDforUriHit.setEnabled(enabled);
        getUUIDforUriMiss.setEnabled(enabled);
        resolveNamedDatasetHit.setEnabled(enabled);
        resolveNamedDatasetMiss.setEnabled(enabled);
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder(super.toString());
        buffer.append(findStatementsHit);
        buffer.append(" ");
        buffer.append(findStatementsMiss);
        buffer.append(" ");
        buffer.append(containsNamedGraphHit);
        buffer.append(" ");
        buffer.append(containsNamedGraphMiss);
        buffer.append(" ");
        buffer.append(getNamedGraphRevisionHit);
        buffer.append(" ");
        buffer.append(getNamedGraphRevisionMiss);
        buffer.append(" ");
        buffer.append(getSizeHit);
        buffer.append(" ");
        buffer.append(getSizeMiss);
        buffer.append(" ");
        buffer.append(getUriForUUIDHit);
        buffer.append(" ");
        buffer.append(getUriForUUIDMiss);
        buffer.append(" ");
        buffer.append(getUUIDforUriHit);
        buffer.append(" ");
        buffer.append(getUUIDforUriMiss);
        buffer.append(" ");
        buffer.append(resolveNamedDatasetHit);
        buffer.append(" ");
        buffer.append(resolveNamedDatasetMiss);
        buffer.append(" ");
        return buffer.toString();
    }

    /**
     * @return the containsNamedGraphHit stats
     */
    public CountStatisticImpl getContainsNamedGraphHit() {
        return containsNamedGraphHit;
    }

    /**
     * @return the getHitrsForGraphMiss
     */
    public CountStatisticImpl getContainsNamedGraphMiss() {
        return containsNamedGraphMiss;
    }

    /**
     * @return the containsNamedGraphHit stats
     */
    public CountStatisticImpl getFindStatementsHit() {
        return findStatementsHit;
    }

    /**
     * @return the getHitrsForGraphMiss
     */
    public CountStatisticImpl getFindStatementsMiss() {
        return findStatementsMiss;
    }

    /**
     * @return the getNamedGraphRevisionHit stats
     */
    public CountStatisticImpl getGetNamedGraphRevisionHit() {
        return getNamedGraphRevisionHit;
    }

    /**
     * @return the getHitrsForGraphMiss
     */
    public CountStatisticImpl getGetNamedGraphRevisionMiss() {
        return getNamedGraphRevisionMiss;
    }

    /**
     * @return the getSizeHit stats
     */
    public CountStatisticImpl getGetSizeHit() {
        return getSizeHit;
    }

    /**
     * @return the getHitrsForGraphMiss
     */
    public CountStatisticImpl getGetSizeMiss() {
        return getSizeMiss;
    }

    /**
     * @return the getUriForUUIDHit stats
     */
    public CountStatisticImpl getGetUriForUUIDHit() {
        return getUriForUUIDHit;
    }

    /**
     * @return the getHitrsForGraphMiss
     */
    public CountStatisticImpl getGetUriForUUIDMiss() {
        return getUriForUUIDMiss;
    }

    /**
     * @return the getUriForUUIDHit stats
     */
    public CountStatisticImpl getGetUUIDforUriHit() {
        return getUUIDforUriHit;
    }

    /**
     * @return the getHitrsForGraphMiss
     */
    public CountStatisticImpl getGetUUIDforUriMiss() {
        return getUUIDforUriMiss;
    }

    /**
     * @return the resolveNamedDatasetHit stats
     */
    public CountStatisticImpl getResolveNamedDatasetHit() {
        return resolveNamedDatasetHit;
    }

    /**
     * @return the getHitrsForGraphMiss
     */
    public CountStatisticImpl getResolveNamedDatasetMiss() {
        return resolveNamedDatasetMiss;
    }
}
