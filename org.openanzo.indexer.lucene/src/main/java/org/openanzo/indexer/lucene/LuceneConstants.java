/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.indexer.lucene/src/com/ibm/adtech/indexer/lucene/Attic/LuceneConstants.java,v $
 * Created by:  Wing Yung (<a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com</a>)
 * Created on:  12/19/2006
 * Revision:	$Id: LuceneConstants.java 169 2007-07-31 14:11:15Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/

package org.openanzo.indexer.lucene;

/**
 * Constants used within indexer package
 * 
 * @author Wing Yung (<a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com</a>)
 * 
 */
public class LuceneConstants {
    /** String used in Lock Exception Message */
    protected static final String LockExceptionMessage       = "Lock obtain timed out";

    /** String used in Lock File Expression */
    protected static final String LockFileExpression         = "Lock@(.+)";

    /** Lucene indexer field name to store last modified time */
    public static final String    INDEXER_FIELD_MODIFIED     = "modified";

    /** Lucene indexer field name to store object value */
    public static final String    INDEXER_FIELD_OBJECT       = "object";

    /** Lucene indexer field name to store datatype value */
    public static final String    INDEXER_FIELD_DATATYPE     = "datatype";

    /** Lucene indexer field name to store datatype language */
    public static final String    INDEXER_FIELD_LANGUAGE     = "lang";

    /** Lucene indexer field name to store value of who created statement */
    public static final String    INDEXER_FIELD_CREATED_BY   = "createdBy";

    /** Lucene indexer field name to store ID of object */
    public static final String    INDEXER_FIELD_OBJ_NODE_ID  = "objNodeId";

    /** Lucene indexer field name to store ID of predicate */
    public static final String    INDEXER_FIELD_PREDICATE_ID = "predicateId";

    /** Lucene indexer field name to store ID of subject */
    public static final String    INDEXER_FIELD_SUBJECT_ID   = "subjectId";

    /** Lucene indexer field name to store ID of Named Graph */
    public static final String    INDEXER_FIELD_GRAPH_ID     = "graphId";

    /** Lucene indexer field name to store ID of statement */
    public static final String    INDEXER_FIELD_STMT_ID      = "id";
}
