/*******************************************************************************
 * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Generated Source from org.openanzo.jdbc.utils.opgen.jet
 * Created on:  Generated Source from org.openanzo.jdbc.utils.opgen.jet
 * Revision:	$Id$
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *	   Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.ontologies.command;

/**
 * Implementations of this listener may be registered with instances of org.openanzo.ontologies.command.Command to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface CommandListener extends org.openanzo.rdf.jastor.ThingListener {


	/**
	 * Called when commandType has changed
	 * @param source the affected instance of org.openanzo.ontologies.command.Command
	 */
	public void commandTypeChanged(org.openanzo.ontologies.command.Command source);

}