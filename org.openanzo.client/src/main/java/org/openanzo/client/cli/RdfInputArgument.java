/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.client.cli;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;

import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.SmartEncodingInputStream;

/**
 * Everything the command line needs to know about an RDF input.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
class RdfInputArgument {
    Reader    inputReader;

    RDFFormat format;

    URI       defaultGraphURI;

    String    inputName = null;

    public RdfInputArgument(InputStream inputStream, RDFFormat format, String charsetName) {
        try {
            SmartEncodingInputStream smartStream = new SmartEncodingInputStream(inputStream, 4048, Charset.forName(charsetName), true);
            this.inputReader = smartStream.getReader();
        } catch (IOException ioe) {
            throw new RuntimeException("Unknown IO error reading input stream", ioe);
        }
        this.format = format;
    }

    public RdfInputArgument(InputStream inputStream, RDFFormat format, String inputName, URI defaultGraphURI, String charsetName) {
        this(inputStream, format, charsetName);
        this.defaultGraphURI = defaultGraphURI;
        this.inputName = inputName;
    }

    public Reader getReader() {
        return inputReader;
    }

    public RDFFormat getFormat() {
        return format;
    }

    public URI getDefaultGraphURI() {
        return defaultGraphURI;
    }
}
