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
package org.openanzo.ontologies.foaf;

/**
 * Implementations of this listener may be registered with instances of org.openanzo.ontologies.foaf.Document to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface DocumentListener extends org.openanzo.rdf.jastor.ThingListener {


	/**
	 * Called when a value of sha1 has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param newValue the object representing the new value
	 */	
	public void sha1Added(org.openanzo.ontologies.foaf.Document source, org.openanzo.rdf.Literal newValue);

	/**
	 * Called when a value of sha1 has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param oldValue the object representing the removed value
	 */	
	public void sha1Removed(org.openanzo.ontologies.foaf.Document source, org.openanzo.rdf.Literal oldValue);

	/**
	 * Called when primaryTopic has changed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 */
	public void primaryTopicChanged(org.openanzo.ontologies.foaf.Document source);

	/**
	 * Called when a value of topic has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param newValue the object representing the new value
	 */	
	public void topicAdded(org.openanzo.ontologies.foaf.Document source, org.openanzo.rdf.jastor.Thing newValue);

	/**
	 * Called when a value of topic has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param oldValue the object representing the removed value
	 */
	public void topicRemoved(org.openanzo.ontologies.foaf.Document source, org.openanzo.rdf.jastor.Thing oldValue);
		
	/**
	 * Called when a value of depiction has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param newValue the object representing the new value
	 */	
	public void depictionAdded(org.openanzo.ontologies.foaf.Document source, org.openanzo.ontologies.foaf.Image newValue);

	/**
	 * Called when a value of depiction has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param oldValue the object representing the removed value
	 */
	public void depictionRemoved(org.openanzo.ontologies.foaf.Document source, org.openanzo.ontologies.foaf.Image oldValue);
		
	/**
	 * Called when a value of fundedBy has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param newValue the object representing the new value
	 */	
	public void fundedByAdded(org.openanzo.ontologies.foaf.Document source, org.openanzo.rdf.jastor.Thing newValue);

	/**
	 * Called when a value of fundedBy has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param oldValue the object representing the removed value
	 */
	public void fundedByRemoved(org.openanzo.ontologies.foaf.Document source, org.openanzo.rdf.jastor.Thing oldValue);
		
	/**
	 * Called when a value of homepage has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param newValue the object representing the new value
	 */	
	public void homepageAdded(org.openanzo.ontologies.foaf.Document source, org.openanzo.ontologies.foaf.Document newValue);

	/**
	 * Called when a value of homepage has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param oldValue the object representing the removed value
	 */
	public void homepageRemoved(org.openanzo.ontologies.foaf.Document source, org.openanzo.ontologies.foaf.Document oldValue);
		
	/**
	 * Called when a value of logo has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param newValue the object representing the new value
	 */	
	public void logoAdded(org.openanzo.ontologies.foaf.Document source, org.openanzo.rdf.jastor.Thing newValue);

	/**
	 * Called when a value of logo has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param oldValue the object representing the removed value
	 */
	public void logoRemoved(org.openanzo.ontologies.foaf.Document source, org.openanzo.rdf.jastor.Thing oldValue);
		
	/**
	 * Called when a value of maker has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param newValue the object representing the new value
	 */	
	public void makerAdded(org.openanzo.ontologies.foaf.Document source, org.openanzo.ontologies.foaf.Agent newValue);

	/**
	 * Called when a value of maker has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param oldValue the object representing the removed value
	 */
	public void makerRemoved(org.openanzo.ontologies.foaf.Document source, org.openanzo.ontologies.foaf.Agent oldValue);
		
	/**
	 * Called when a value of page has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param newValue the object representing the new value
	 */	
	public void pageAdded(org.openanzo.ontologies.foaf.Document source, org.openanzo.ontologies.foaf.Document newValue);

	/**
	 * Called when a value of page has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param oldValue the object representing the removed value
	 */
	public void pageRemoved(org.openanzo.ontologies.foaf.Document source, org.openanzo.ontologies.foaf.Document oldValue);
		
	/**
	 * Called when a value of theme has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param newValue the object representing the new value
	 */	
	public void themeAdded(org.openanzo.ontologies.foaf.Document source, org.openanzo.rdf.jastor.Thing newValue);

	/**
	 * Called when a value of theme has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param oldValue the object representing the removed value
	 */
	public void themeRemoved(org.openanzo.ontologies.foaf.Document source, org.openanzo.rdf.jastor.Thing oldValue);
		
	/**
	 * Called when a value of dnaChecksum has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param newValue the object representing the new value
	 */	
	public void dnaChecksumAdded(org.openanzo.ontologies.foaf.Document source, org.openanzo.rdf.Literal newValue);

	/**
	 * Called when a value of dnaChecksum has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param oldValue the object representing the removed value
	 */	
	public void dnaChecksumRemoved(org.openanzo.ontologies.foaf.Document source, org.openanzo.rdf.Literal oldValue);

	/**
	 * Called when a value of nick has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param newValue the object representing the new value
	 */	
	public void nickAdded(org.openanzo.ontologies.foaf.Document source, org.openanzo.rdf.Literal newValue);

	/**
	 * Called when a value of nick has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param oldValue the object representing the removed value
	 */	
	public void nickRemoved(org.openanzo.ontologies.foaf.Document source, org.openanzo.rdf.Literal oldValue);

	/**
	 * Called when a value of title has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param newValue the object representing the new value
	 */	
	public void titleAdded(org.openanzo.ontologies.foaf.Document source, org.openanzo.rdf.Literal newValue);

	/**
	 * Called when a value of title has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param oldValue the object representing the removed value
	 */	
	public void titleRemoved(org.openanzo.ontologies.foaf.Document source, org.openanzo.rdf.Literal oldValue);

	/**
	 * Called when a value of phone has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param newValue the object representing the new value
	 */	
	public void phoneAdded(org.openanzo.ontologies.foaf.Document source, org.openanzo.rdf.jastor.Thing newValue);

	/**
	 * Called when a value of phone has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Document
	 * @param oldValue the object representing the removed value
	 */
	public void phoneRemoved(org.openanzo.ontologies.foaf.Document source, org.openanzo.rdf.jastor.Thing oldValue);
		
}