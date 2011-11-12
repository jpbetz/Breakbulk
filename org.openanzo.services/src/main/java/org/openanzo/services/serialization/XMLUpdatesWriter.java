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

import java.io.Writer;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.services.IUpdateTransaction;

/**
 * Provides XML serialization of transport messages.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
class XMLUpdatesWriter implements IUpdatesHandler {

    /** Stream to which output is written */
    private final Writer  output;

    private final boolean includeContents;

    /**
     * New XMLNodeWriter that writes to out
     * 
     * @param includeContents
     *            include contents of updates in output
     * @param out
     *            Stream to which output is written
     */
    protected XMLUpdatesWriter(boolean includeContents, Writer out) {
        this.output = out;
        this.includeContents = includeContents;
    }

    public void start() throws AnzoException {
        XMLWritingUtils.start(output);
    }

    public void end() throws AnzoException {
        XMLWritingUtils.end(output);
    }

    public void handleTransaction(IUpdateTransaction transaction) throws AnzoException {
        XMLWritingUtils.handleTransaction(output, includeContents, transaction);
    }
}
