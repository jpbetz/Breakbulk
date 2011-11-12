/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.jdbc.utils/src/com/ibm/adtech/jdbc/utils/Attic/Transformer.java,v $
 * Created by:  Joe Betz
 * Created on:  9/30/2005
 * Revision:	$Id: Transformer.java 176 2007-07-31 14:22:30Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.utils;

import java.sql.ResultSet;

/**
 * Transform a ResultSet into an object of type E
 * 
 * @author Joe Betz
 * 
 * @param <E>
 *            Type of object to which ResultSet is transformed
 */
public interface Transformer<E> {

	/**
	 * Transform ResultSet to type E
	 * 
	 * @param rs
	 *            ResultSet to transform
	 * @return transformed ResultSet
	 */
	public E transform(ResultSet rs);
}
