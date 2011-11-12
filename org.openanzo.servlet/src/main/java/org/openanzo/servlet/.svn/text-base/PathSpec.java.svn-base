/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jul 7, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.servlet;

/**
 * Defines the pathspec for a registered servlet
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class PathSpec {
    String  spec;

    boolean wildCard = true;

    /**
     * Create a new pathspec
     * 
     * @param spec
     *            path string
     */
    public PathSpec(String spec) {
        if (spec.endsWith("/*")) {
            wildCard = true;
            this.spec = spec.substring(0, spec.length() - 2);
        } else if (spec.endsWith("*")) {
            wildCard = true;
            this.spec = spec.substring(0, spec.length() - 1);
        } else {
            wildCard = false;
            this.spec = spec;
        }
    }

    /**
     * Does the provided url match this path spec
     * 
     * @param url
     *            url to match
     * @return true if its a match
     */
    public boolean matches(String url) {
        if (wildCard) {
            return url.startsWith(spec);
        } else {
            return url.equals(spec);
        }
    }
}
