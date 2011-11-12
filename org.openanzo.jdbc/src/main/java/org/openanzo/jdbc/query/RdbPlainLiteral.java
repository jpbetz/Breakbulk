/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdb/glitter/Literal.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: Literal.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.query;

import java.sql.Connection;

import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.jdbc.layout.CompositeNodeLayout;
import org.openanzo.jdbc.utils.RdbException;
import org.openanzo.rdf.PlainLiteral;
import org.openanzo.rdf.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of ILiteralTerm that maps an Anzo Litera to a Glitter ILiteralTerm
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
class RdbPlainLiteral extends RdbLiteral<PlainLiteral> implements PlainLiteral {
    private static final long             serialVersionUID = -3402369074843383266L;

    transient private static final Logger log              = LoggerFactory.getLogger(RdbPlainLiteral.class);

    /**
     * Create a new Literal for value stored in database with given ID
     * 
     * @param connection
     *            connection to jdbc database
     * @param nodeLayout
     *            source of data
     * @param id
     *            id of Literal in the database
     */
    protected RdbPlainLiteral(CompositeNodeLayout nodeLayout, Connection connection, long id) {
        super(nodeLayout, connection, id);
    }

    public String getLanguage() {
        populateNode();
        return this.literal.getLanguage();
    }

    public boolean hasLanguage() {
        populateNode();
        return this.literal.hasLanguage();
    }

    @Override
    protected void populateNode() {
        if (literal == null) {
            try {
                literal = nodeLayout.getPlainNodeLiteralLayout().fetchValue(getId(), connection);
            } catch (RdbException rdbe) {
                log.error(LogUtils.RDB_MARKER, "error loading plain literal: " + getId(), rdbe);
                throw new AnzoRuntimeException(rdbe);
            }
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof RdbPlainLiteral && nodeLayout == ((RdbPlainLiteral) other).nodeLayout) {
            long otherId = ((RdbPlainLiteral) other).getId();
            return otherId == this.getId();
        }
        return super.equals(other);
    }

    public boolean populated() {
        return literal != null;
    }

    public void setValue(Value value) {
        this.literal = (PlainLiteral) value;
    }
}
