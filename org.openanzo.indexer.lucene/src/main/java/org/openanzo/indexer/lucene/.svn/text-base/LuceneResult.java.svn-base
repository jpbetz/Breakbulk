/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.indexer.lucene/src/com/ibm/adtech/indexer/lucene/LuceneResult.java,v $
 * Created by:  Wing Yung ( <a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com </a>)
 * Created on:  10/11/2005
 * Revision:	$Id: LuceneResult.java 169 2007-07-31 14:11:15Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.indexer.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.openanzo.indexer.IResult;

/**
 * Result implementation based on Lucene.
 * 
 * @author Wing Yung ( <a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com </a>)
 */
public class LuceneResult implements IResult {

    protected final Document document;

    /**
     * Create a new result object
     * 
     * @param document
     *            document containing results
     */
    public LuceneResult(Document document) {
        this.document = document;
    }

    /**
     * For debugging.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int lineno = 0;
        for (Object o : document.getFields()) {
            Field field = (Field) o;
            if (lineno > 0)
                sb.append("\t");
            sb.append(field.name());
            sb.append(": ");
            sb.append(field.stringValue());
            sb.append("\n");
            lineno++;
        }
        return sb.toString();
    }

    public String getFieldValue(String field) {
        if (field != null)
            return document.get(field);
        return null;
    }
}
