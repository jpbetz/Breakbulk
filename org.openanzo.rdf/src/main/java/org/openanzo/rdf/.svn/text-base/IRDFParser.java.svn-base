/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.rdf;

import java.io.IOException;
import java.io.Reader;

import org.openanzo.exceptions.AnzoException;

/**
 * Parser methods for RDF.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public interface IRDFParser {
    /**
     * Parse reader
     * 
     * @param reader
     *            reader to parse
     * @param baseURI
     *            base uri for data in reader
     * @throws IOException
     * @throws AnzoException
     */
    public void parse(Reader reader, String baseURI) throws IOException, AnzoException;

    /**
     * Get the RDFFormat for the reader
     * 
     * @return the RDFFormat for the reader
     */
    public RDFFormat getRDFFormat();

}
