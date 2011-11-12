/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 8, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.services.serialization;

import java.io.IOException;
import java.io.Writer;

import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.utils.SerializationConstants;

/**
 * Handler that writes values to an output writer
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * 
 */
public class WriterStringValueSetHandler implements IValueSetHandler<String> {

    final private Writer  writer;

    final private String  format;

    final private char    delimitor;

    final private boolean quoteValues;

    private boolean       first = true;

    /**
     * Create a new WriterValueSetHandler that writes values to an output writer
     * 
     * @param writer
     *            output writer
     * @param format
     *            format used to determine deliminator
     */
    public WriterStringValueSetHandler(Writer writer, String format) {
        this.writer = writer;
        this.format = format;
        if (SerializationConstants.MIMETYPE_TEXT.equals(this.format)) {
            delimitor = '\n';
            quoteValues = false;
        } else if (SerializationConstants.MIMETYPE_CSV.equals(this.format)) {
            delimitor = ',';
            quoteValues = false;
        } else if (RDFFormat.JSON.getDefaultMIMEType().equals(this.format)) {
            delimitor = ',';
            quoteValues = true;
        } else {
            delimitor = ' ';
            quoteValues = false;
        }
    }

    public void handleValue(String value) throws IOException {
        if (first) {
            first = false;
        } else {
            hasAnotherValue();
        }

        if (quoteValues)
            writer.write('"');
        writer.write(value.toString());
        if (quoteValues)
            writer.write('"');
    }

    private void hasAnotherValue() throws IOException {
        writer.write(delimitor);
    }

    public void start() throws IOException {
        if (RDFFormat.JSON.getDefaultMIMEType().equals(this.format)) {
            writer.write('[');
        }
    }

    public void end() throws IOException {
        if (RDFFormat.JSON.getDefaultMIMEType().equals(this.format)) {
            writer.write(']');
        }
    }
}
