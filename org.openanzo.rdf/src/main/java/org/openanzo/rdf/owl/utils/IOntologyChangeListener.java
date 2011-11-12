/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.owl/src/com/ibm/adtech/boca/utils/Attic/IOntologyChangeListener.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  May 14, 2007
 * Revision:	$Id: IOntologyChangeListener.java 165 2007-07-31 14:11:11Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.owl.utils;

import org.openanzo.rdf.Resource;

/**
 * Listener that handles events about super and sub classes changing as well as properties changing
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public interface IOntologyChangeListener {

	/**
	 * A Class's super class changed
	 * 
	 * @param clazz
	 *            class whose hierarchy changed
	 * @param superClass
	 *            superClass which changed
	 */
	public void superClassChanged(Resource clazz, Resource superClass);

	/**
	 * A Class's sub class changed
	 * 
	 * @param clazz
	 *            class whose hierarchy changed
	 * @param subClass
	 *            subClass which changed
	 */
	public void subClassChanged(Resource clazz, Resource subClass);

	/**
	 * Class's property changed
	 * 
	 * @param clazz
	 *            class whose property changed
	 * @param property
	 *            property which changed
	 */
	public void propertyChanged(Resource clazz, Resource property);
}
