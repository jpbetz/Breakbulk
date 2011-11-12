/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/rdf/IPlainLiteralTerm.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Dec 7, 2006
 * Revision:	$Id: IPlainLiteralTerm.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf;

/**
 * Plain literal with optional language
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public interface PlainLiteral extends Literal {
    /**
     * Gets the RFC-3066 language tag for this plain literal.
     * 
     * @return The language tag for this plain literal. May be <tt>null</tt>, unless {@link #hasLanguage()} returns <tt>true</tt>.
     */
    public String getLanguage();

    /**
     * Checks if a language tag is set for this plain literal.
     * 
     * @return whether or not this literal has a language tag
     */
    public boolean hasLanguage();
}
