/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/ant/BaseTypesElement.java,v $
 * Created by:  
 * Created on:  01/23/2007
 * Revision:	$Id: BaseTypesElement.java 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor.ant;

import org.apache.tools.ant.Task;

/**
 * @author Ben Szekely (<a href="mailto:bhszekel@us.ibm.com">bhszekel@us.ibm.com</a>)
 */
public class BaseTypesElement extends Task {

    private String baseLiteralClass;

    /**
     * Get the base literal class for this element
     * 
     * @return the base literal class for this element
     */
    public String getBaseLiteralClass() {
        return baseLiteralClass;
    }

    /**
     * Set the base literal class for this element
     * 
     * @param baseLiteralClass
     *            the base literal class for this element
     */
    public void setBaseLiteralClass(String baseLiteralClass) {
        this.baseLiteralClass = baseLiteralClass;
    }
}
