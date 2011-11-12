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
package org.openanzo.ontologies.system;

/**
 * Implementations of this listener may be registered with instances of org.openanzo.ontologies.system.JastorOntology to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface JastorOntologyListener extends org.openanzo.rdf.jastor.ThingListener {


	/**
	 * Called when generate has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.JastorOntology
	 */
	public void generateChanged(org.openanzo.ontologies.system.JastorOntology source);

	/**
	 * Called when ontologyUri has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.JastorOntology
	 */
	public void ontologyUriChanged(org.openanzo.ontologies.system.JastorOntology source);

	/**
	 * Called when _package has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.JastorOntology
	 */
	public void _packageChanged(org.openanzo.ontologies.system.JastorOntology source);

}