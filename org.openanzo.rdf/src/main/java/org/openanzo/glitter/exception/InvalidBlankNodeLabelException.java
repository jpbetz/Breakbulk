/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
  * All rights reserved. This program and the accompanying materials 
  * are made available under the terms of the Eclipse Public License v1.0 
  * which accompanies this distribution, and is available at 
  * http://www.eclipse.org/legal/epl-v10.html 
  * 
  * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/exception/Attic/InvalidBlankNodeLabelException.java,v $ 
  * Created by: Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>) 
  * Created on: February 13, 2007 
  * Revision: $Id: InvalidBlankNodeLabelException.java 164 2007-07-31 14:11:09Z mroy $ 
  * 
  * Contributors: 
  * IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
  *******************************************************************************/ 
package org.openanzo.glitter.exception;

import org.openanzo.glitter.syntax.concrete.ParseException;

/**
 * Indicates that a blank node label was reused in a context where blank node label reuse is
 * prohibited (such as between multiple SPARQL BGPs) 
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class InvalidBlankNodeLabelException extends ParseException {
	private static final long serialVersionUID = -6868855579574094882L;

	/**
	 * 
	 * @param label The blank node label that was duplicated
	 */
	public InvalidBlankNodeLabelException(String label) {
		super("The blank node label '" + label + "' can not occur in two different basic graph patterns.");
	}
}
