/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/src/com/ibm/adtech/boca/model/repository/update/BocaServerWriter.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  5/4/2006
 * Revision:	$Id: ServerWriter.java 180 2007-07-31 14:24:13Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.services.serialization;

import java.io.Writer;

import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.utils.SerializationConstants;

/**
 * Implementation of IRepositoryHandler that handles writing updates from the server into an OutputStream that is sent to the client
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class Writers {

    /**
     * Create a new ServerWriter
     * 
     * @param output
     *            OutputStream to which results are written
     * @param format
     *            format of output stream
     * @return IRepositoryHandler for given format
     */
    protected static IUpdatesHandler getUpdatesWriter(boolean includeContent, Writer output, String format) {
        if (RDFFormat.JSON.getDefaultMIMEType().equals(format)) {
            return new JSONUpdatesWriter(includeContent, output);
        } else if (SerializationConstants.MIMETYPE_ANZO_XML.equals(format)) {
            return new XMLUpdatesWriter(includeContent, output);
        } else {
            throw new IllegalStateException("unsupported format: " + format);
        }
    }

    /**
     * Create a new ServerWriter
     * 
     * @param output
     *            OutputStream to which results are written
     * @param format
     *            format of output stream
     * @return IRepositoryHandler for given format
     */
    public static INamedGraphUpdateHandler getNamedGraphUpdatesWriter(Writer output, String format) {
        if (RDFFormat.JSON.getDefaultMIMEType().equals(format)) {
            return new JSONNamedGraphUpdatesWriter(output);
        } else if (SerializationConstants.MIMETYPE_ANZO_XML.equals(format)) {
            return new XMLNamedGraphUpdatesWriter(output);
        } else {
            throw new IllegalStateException("unsupported format: " + format);
        }
    }

}
