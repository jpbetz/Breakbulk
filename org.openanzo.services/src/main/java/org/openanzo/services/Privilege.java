/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/src/com/ibm/adtech/boca/model/repository/structures/Privilege.java,v $
 * Created by:  Joe Betz
 * Created on:  3/22/2006
 * Revision:	$Id: Privilege.java 180 2007-07-31 14:24:13Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.services;

/**
 * Enumeration of the privileges available in Anzo.
 * 
 * @author Joe Betz
 * 
 */
public enum Privilege {
    /** User can read triples in NamedGraph */
    READ,
    /** User can add triples to NamedGraph */
    ADD,
    /** User can remove triples from NamedGraph */
    REMOVE
}
