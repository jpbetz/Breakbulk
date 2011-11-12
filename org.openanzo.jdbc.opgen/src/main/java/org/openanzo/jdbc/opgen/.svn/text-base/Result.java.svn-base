/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.jdbc.utils/src/com/ibm/adtech/jdbc/utils/opgen/Result.java,v $
 * Created by:  Joe Betz
 * Created on:  9/30/2005
 * Revision:	$Id: Result.java 176 2007-07-31 14:22:30Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.opgen;

import java.security.InvalidParameterException;

import org.w3c.dom.Node;

/**
 * Enumerates the result formats a SQL statement wrapper may return.
 * 
 * @author Joe Betz
 * 
 */
public class Result {

    /**
     * No results returned by statement. The default.
     */
    public static final Result NONE     = new Result("NONE");

    /**
     * A single value (single entry in the table).
     */
    public static final Result VALUE    = new Result("VALUE");

    /**
     * One row in the table is returned by the statement.
     */
    public static final Result ROW      = new Result("ROW");

    /**
     * Many rows are returned by the statement.
     */
    public static final Result ITERATOR = new Result("ITERATOR");

    /**
     * Many rows are returned by the statement.
     */
    public static final Result COUNTER  = new Result("COUNTER");

    /**
     * Many rows are returned by the statement.
     */
    public static final Result IDENTITY = new Result("IDENTITY");

    /**
     * Get the type of result set
     * 
     * @param node
     *            node value for which to determine result set type
     * @return the type of result set
     */
    public static Result getResultsEnum(Node node) {
        if (node.getNodeValue().equals(NONE.getValue())) {
            return NONE;
        } else if (node.getNodeValue().equals(VALUE.getValue())) {
            return VALUE;
        } else if (node.getNodeValue().equals(ROW.getValue())) {
            return ROW;
        } else if (node.getNodeValue().equals(ITERATOR.getValue())) {
            return ITERATOR;
        } else if (node.getNodeValue().equals(COUNTER.getValue())) {
            return COUNTER;
        } else if (node.getNodeValue().equals(IDENTITY.getValue())) {
            return IDENTITY;
        } else {
            throw new InvalidParameterException("'results' XML node must be valid enumeration value: (" + ROW + " | " + ITERATOR + ")");
        }
    }

    String value;

    Result(String value) {
        this.value = value;
    }

    /**
     * Get the value of the result
     * 
     * @return the value of the result
     */
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof Result) {
            return value.equals(((Result) obj).value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
