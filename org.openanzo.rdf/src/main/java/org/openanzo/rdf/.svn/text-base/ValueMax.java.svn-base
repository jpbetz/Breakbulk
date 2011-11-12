/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/rdf/RDFTerm.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: RDFTerm.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf;

/**
 * This is an artificial Anzo RDF value that compares > any other value.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class ValueMax implements Value {
    private static final long     serialVersionUID = 5534495797533399823L;

    static final private ValueMax theValueMax      = new ValueMax();

    private ValueMax() {
    }

    /**
     * Get the static instance of Valuemax
     * 
     * @return the static instance of Valuemax
     */
    static public ValueMax getInstance() {
        return theValueMax;
    }

    public int compareTo(TriplePatternComponent other) {
        if (other instanceof ValueMax)
            return 0;
        return 1;
    }
}
