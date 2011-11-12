/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/commands/AskResult.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  7/17/2006
 * Revision:	$Id: AskResult.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.services.impl;

import org.openanzo.services.IResult;

/**
 * AskResult is used as the expected precondition result from an Sparql Ask Query.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 */
public class AskResult implements IResult {

    /** Expected ResultValue */
    final private boolean resultValue;

    /**
     * Get either the static TRUE or FALSE AskResult object
     * 
     * @param resultValue
     *            which AskResult object to get
     * @return AskResult for resultValue
     */
    static protected AskResult getAskResult(boolean resultValue) {
        if (resultValue) {
            return trueResult;
        }
        return falseResult;
    }

    private AskResult(boolean resultValue) {
        this.resultValue = resultValue;
    }

    /**
     * Return boolean value for this result
     * 
     * @return boolean value for this result
     */
    public boolean getResultValue() {
        return resultValue;
    }

    private final static AskResult trueResult  = new AskResult(true);

    private final static AskResult falseResult = new AskResult(false);
}
