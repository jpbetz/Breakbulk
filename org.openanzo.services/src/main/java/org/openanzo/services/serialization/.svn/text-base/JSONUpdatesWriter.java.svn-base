/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/serialization/BocaXMLNodeWriter.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  5/1/2006
 * Revision:	$Id: XMLNodeWriter.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.services.serialization;

import java.io.IOException;
import java.io.Writer;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.services.IUpdateTransaction;

/**
 * Provides XML serialization of transport messages.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class JSONUpdatesWriter implements IUpdatesHandler {
    private final static JsonFactory factory         = new JsonFactory();

    /** Stream to which output is written */
    private final JsonGenerator      jsonWriter;

    private boolean                  includeContents = false;

    /**
     * New XMLNodeWriter that writes to out
     * 
     * @param includeContents
     *            true if all statements should be written, or just the transaction structure
     * @param out
     *            Stream to which output is written
     */
    public JSONUpdatesWriter(boolean includeContents, Writer out) {
        try {
            this.jsonWriter = factory.createJsonGenerator(out);
            this.includeContents = includeContents;
        } catch (IOException e) {
            throw new AnzoRuntimeException(ExceptionConstants.IO.WRITE_ERROR, e, e.getMessage());
        }
    }

    public void start() throws AnzoException {
        try {
            jsonWriter.writeStartArray();
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e, e.getMessage());
        }
    }

    public void end() throws AnzoException {
        try {
            jsonWriter.writeEndArray();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e, e.getMessage());
        }
    }

    public void handleTransaction(IUpdateTransaction transaction) throws AnzoException {
        JSONWritingUtils.writeTransaction(jsonWriter, includeContents, transaction);
    }
}
