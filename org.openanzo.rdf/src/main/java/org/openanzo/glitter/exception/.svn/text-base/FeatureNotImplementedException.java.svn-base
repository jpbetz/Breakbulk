/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/exception/FeatureNotImplementedException.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: FeatureNotImplementedException.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
  *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.exception;

import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;

/**
 * General exception used for unimplemented Glitter features.
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class FeatureNotImplementedException extends AnzoRuntimeException {
	private static final long serialVersionUID = 6686515659365947192L;

	/**
	 * 
	 * @param feature Description of the unimplemented feature.
	 */
	public FeatureNotImplementedException(String feature) {
		super(ExceptionConstants.GLITTER.FEATURE_NOT_IMPLEMENTED,feature);
	}
}
