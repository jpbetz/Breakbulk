/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/exception/ConfigurationException.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: ConfigurationException.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.exception;

import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.Engine;
import org.openanzo.glitter.EngineConfig;

/**
 * The Glitter {@link Engine} throws this exception if it is unable to access
 * or instantiate any of the classes referenced in an {@link EngineConfig}.
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class ConfigurationException extends GlitterException {

	private static final long serialVersionUID = -1902958809339051237L;

	/**
	 * 
	 * @param cause The underlying cause of the configuration exception.
	 */
	public ConfigurationException(Throwable cause) {
		super(ExceptionConstants.GLITTER.CONFIG_EXCEPTION,cause);
	}
	
}
