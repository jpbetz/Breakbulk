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
import org.openanzo.services.INamedGraphUpdate;

/**
 * Provides XML serialization of transport messages.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
class XMLNamedGraphUpdatesWriter implements INamedGraphUpdateHandler {

    /** Stream to which output is written */
    final private Writer out;

    /**
     * New XMLNodeWriter that writes to out
     * 
     * @param out
     *            Stream to which output is written
     */
    protected XMLNamedGraphUpdatesWriter(Writer out) {
        this.out = out;
    }

    public void start() throws AnzoException {
        XMLWritingUtils.start(out);
    }

    public void end() throws AnzoException {
        XMLWritingUtils.end(out);
    }

    public boolean handleNamedGraphUpdate(INamedGraphUpdate namedGraphUpdate) throws AnzoException {
        XMLWritingUtils.handleNamedGraphUpdate(out, namedGraphUpdate);
        return true;
    }
}
