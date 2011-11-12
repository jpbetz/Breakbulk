/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.jdbc.utils/src/com/ibm/adtech/jdbc/utils/ResultSetIterator.java,v $
 * Created by:  Joe Betz
 * Created on:  9/30/2005
 * Revision:	$Id: ResultSetIterator.java 176 2007-07-31 14:22:30Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements iterator support over query result sets, which JDBC was lacking. By default each row in a result set is transformed to a Map where key is the
 * column name and object is the value. However, any iterator Transform may be supplied to instances of this class which will convert rows in a result set to
 * whatever Java type is most convenient.
 * 
 * Example transforms are included. see: toMapTransform and toArrayTransform.
 * 
 * @param <E>
 *            type of object that iterator will return
 * 
 * @author Joe Betz
 * 
 */
public class ResultSetIterator<E> implements ClosableIterator<E> {
    private static final Logger     log      = LoggerFactory.getLogger(ResultSetIterator.class);

    private final ResultSet         rs;

    private final PreparedStatement ps;

    private boolean                 checked  = false;

    private boolean                 isClosed = false;

    private final Transformer<E>    transformer;

    private boolean                 done     = false;

    /**
     * Construct a new iterator over the results in the provided ResultSet. In addition to closing the ResultSet when this iterator is closed, the provided
     * PreparedStatement will be returned to the provided PreparedStatementCache. Also, the iterator transforms the rows of the result set using the supplied
     * transformer.
     * 
     * @param rs
     *            A JDBC ResultSet to iterate over.
     * @param ps
     *            PreparedStatement to return to the given PreparedStatementCache when the iterator closes.
     * @param cache
     *            A cache to return the given PreparedStatement to.
     * @param transformer
     *            A Transformer for converting rows in the ResultSet to some type.
     * @throws UnhandledRdbException
     *             {@link ExceptionConstants.RDB#FAILED_GETTING_RESULT} if there was an error getting the next result from the result set
     */
    public ResultSetIterator(ResultSet rs, PreparedStatement ps, PreparedStatementProvider cache, Transformer<E> transformer) throws UnhandledRdbException {
        this.rs = rs;
        this.ps = ps;
        try {
            done = !rs.next();
            checked = true;
        } catch (SQLException e) {
            throw new UnhandledRdbException(ExceptionConstants.RDB.FAILED_GETTING_RESULT, e);
        }
        this.transformer = transformer;
    }

    /**
     * @see java.util.Iterator#hasNext()
     */
    public boolean hasNext() {
        if (isClosed)
            return false;
        try {
            if (checked) {
                return !done;
            }
            done = !rs.next();
            if (done) {
                close();
            }
            checked = true;
            return !done;
        } catch (SQLException e) {
            throw new UnhandledRdbException(ExceptionConstants.RDB.FAILED_GETTING_RESULT, e);
        }
    }

    /**
     * @see java.util.Iterator#next()
     */
    public E next() {
        if (isClosed)
            throw new UnsupportedOperationException("Iterator already closed.");
        if (done)
            throw new NoSuchElementException();
        if (!checked) {
            try {
                done = !rs.next();
                if (done) {
                    close();
                    throw new UnsupportedOperationException("Iterator already closed.");
                }
            } catch (SQLException e) {
                throw new UnhandledRdbException(ExceptionConstants.RDB.FAILED_GETTING_RESULT, e);
            }
        }
        checked = false;
        return transformer.transform(rs);
    }

    /**
     * @see java.util.Iterator#remove()
     */
    public void remove() {
        throw new UnsupportedOperationException();
    }

    /**
     * @see ClosableIterator#close()
     */
    public void close() {
        if (isClosed)
            return;
        isClosed = true;
        try {
            rs.close();
        } catch (SQLException e) {
            log.debug(LogUtils.RDB_MARKER, "Error closing result set", e);
        }
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            throw new UnhandledRdbException(ExceptionConstants.RDB.FAILED_CLOSING_PREPAREDSTATEMENT, e);
        }
    }

    public Iterator<E> iterator() {
        return this;
    }
}
