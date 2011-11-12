/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.jdbc.utils/src/com/ibm/adtech/jdbc/utils/FileLineIterator.java,v $
 * Created by:  Joe Betz
 * Created on:  1/30/2006
 * Revision:	$Id: FileLineIterator.java 176 2007-07-31 14:22:30Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.utils;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.apache.commons.lang.UnhandledException;

/**
 * Wrapper for iterating over the lines of an input stream.
 * 
 * @author Joe Betz
 * 
 */
class FileLineIterator implements ClosableIterator<String> {

    private final Reader           reader;

    private final LineNumberReader lnr;

    private String                 line;

    private boolean                fetchedNext = false;

    private boolean                hasNext     = false;

    /**
     * Create an Iterator for an InputStreamReader
     * 
     * @param reader
     *            source of data
     */
    protected FileLineIterator(Reader reader) {
        this.reader = reader;
        this.lnr = new LineNumberReader(reader);
    }

    public void close() {
        try {
            if (reader != null)
                reader.close();
            if (lnr != null)
                lnr.close();
        } catch (IOException e) {
            throw new UnhandledException(e);
        }
    }

    public boolean hasNext() {
        if (fetchedNext)
            return hasNext;
        fetchedNext = true;
        try {
            line = lnr.readLine();
            return hasNext = (line != null);
        } catch (IOException e) {
            throw new UnhandledException(e);
        }
    }

    public String next() {
        if (!hasNext())
            throw new NoSuchElementException();
        fetchedNext = false;
        return line;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public Iterator<String> iterator() {
        return this;
    }
}
