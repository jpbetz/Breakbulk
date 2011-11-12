/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/rdf/TriplePatternComponent.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: TriplePatternComponent.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf;

import java.io.Serializable;

/**
 * A {@link TriplePatternComponent} is either an {@link Value} or a {@link Variable}.
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public interface TriplePatternComponent extends Serializable, Comparable<TriplePatternComponent> {
    public abstract boolean equals(Object other);

    /**
     * Compares to TriplePatternComponents for ordering.
     *
     * @param other
     * @return -1 if <tt>this</tt> comes before <tt>other</tt>; 0 if {@link #equals(Object)} is <tt>true</tt>, and 1 otherwise.
     */
    public abstract int compareTo(TriplePatternComponent other);
}
