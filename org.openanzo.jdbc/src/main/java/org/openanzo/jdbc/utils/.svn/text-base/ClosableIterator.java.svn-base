/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.jdbc.utils/src/com/ibm/adtech/jdbc/utils/ClosableIterator.java,v $
 * Created by:  Joe Betz
 * Created on:  9/30/2005
 * Revision:	$Id: ClosableIterator.java 176 2007-07-31 14:22:30Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.utils;

import java.util.Iterator;

//QUESTION:Does this belong in the javautils project
/**
 * The iterator that holds resources that need to be released explicitly by calling close() when the iterator is no longer
 * needed.
 * 
 * @param <E>
 *            Type of object to iterate
 * @author Joe Betz
 * 
 */
public interface ClosableIterator<E> extends Iterator<E>, Iterable<E> {

	/**
	 * Close the iterator
	 */
	void close();
}
