/*******************************************************************************
 * Copyright (c) 2008-2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.openanzo.analysis;

import java.io.PrintStream;

/**
 * Output Handler Provider
 * 
 * @author Lee Feigenbaum ( <a href="mailto:Lee@cambridgesemantics.com">Lee@cambridgesemantics.com </a>)
 * 
 */

public interface RequestHandlerOutputProvider extends RequestHandler {
    /**
     * Set the output stream for the handler
     * 
     * @param out
     *            output stream
     */
    public void setOutputStream(PrintStream out);

    /**
     * Start the writing
     */
    public void start();

    /**
     * End the writing
     */
    public void end();
}
