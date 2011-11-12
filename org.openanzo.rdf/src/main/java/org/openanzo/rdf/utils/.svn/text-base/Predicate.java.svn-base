/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.java.util/src/com/ibm/adtech/java/util/Predicate.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: Predicate.java 167 2007-07-31 14:11:13Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.utils;

/**
 * 
 * @author Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * 
 * @param <T>
 *            Type of objects being filtered
 */
public interface Predicate<T> {

	/**
	 * Determine if the object satisfies this filter
	 * 
	 * @param thing
	 *            object to test
	 * @return true if object satisfies this filter
	 */
	public boolean satisfies(T thing);
}
