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
import org.openanzo.services.INamedGraphUpdate;

/**
 * Provides XML serialization of transport messages.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
class JSONNamedGraphUpdatesWriter implements INamedGraphUpdateHandler {
    private final static JsonFactory factory = new JsonFactory();

    /** Stream to which output is written */
    private final JsonGenerator      jsonWriter;

    /**
     * New XMLNodeWriter that writes to out
     * 
     * @param out
     *            Stream to which output is written
     */
    protected JSONNamedGraphUpdatesWriter(Writer out) {
        try {
            this.jsonWriter = factory.createJsonGenerator(out);
        } catch (IOException e) {
            throw new AnzoRuntimeException(ExceptionConstants.IO.WRITE_ERROR, e, e.getMessage());
        }
    }

    public void start() throws AnzoException {
        try {
            jsonWriter.writeStartArray();
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    public void end() throws AnzoException {
        try {
            jsonWriter.writeEndArray();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, e.getMessage());
        }
    }

    public boolean handleNamedGraphUpdate(INamedGraphUpdate namedGraphUpdate) throws AnzoException {
        JSONWritingUtils.writeNamedGraphUpdate(jsonWriter, namedGraphUpdate);
        return true;
    }
}
