/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/util/CURIE.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: CURIE.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.util;

/**
 * See http://www.w3.org/2001/sw/BestPractices/HTML/2005-10-27-CURIE
 * 
 * @author Lee
 * 
 */
public class CURIE {
    private final String prefix;

    private final String local;

    /**
     * Create a CURIE from a prefix and a local name.
     * 
     * @param prefix
     * @param local
     *            public CURIE(String prefix, String local) { this.prefix = prefix; this.local = local; }
     */
    /**
     * Create a CURIE by splitting a prefixed name on a colon.
     * 
     * @param curie
     */
    public CURIE(String curie) {
        int colon = curie.indexOf(":");
        if (colon == -1) {
            this.prefix = "";
            this.local = curie;
        } else {
            this.prefix = curie.substring(0, colon);
            this.local = colon + 1 >= curie.length() ? "" : curie.substring(colon + 1);
        }
    }

    /**
     * 
     * @return The CURIE's prefix
     */
    public String getPrefix() {
        return this.prefix;
    }

    /**
     * 
     * @return The CURIE's local name
     */
    public String getLocal() {
        return this.local;
    }

    @Override
    public String toString() {
        return this.prefix + ":" + this.local;
    }
}
