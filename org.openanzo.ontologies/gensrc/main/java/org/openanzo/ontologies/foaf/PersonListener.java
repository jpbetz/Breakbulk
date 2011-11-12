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
 * Implementations of this listener may be registered with instances of org.openanzo.ontologies.foaf.Person to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface PersonListener extends org.openanzo.rdf.jastor.ThingListener {


	/**
	 * Called when a value of based__near has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void based__nearAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.SpatialThing newValue);

	/**
	 * Called when a value of based__near has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void based__nearRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.SpatialThing oldValue);
		
	/**
	 * Called when a value of depiction has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void depictionAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Image newValue);

	/**
	 * Called when a value of depiction has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void depictionRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Image oldValue);
		
	/**
	 * Called when a value of fundedBy has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void fundedByAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.jastor.Thing newValue);

	/**
	 * Called when a value of fundedBy has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void fundedByRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.jastor.Thing oldValue);
		
	/**
	 * Called when a value of homepage has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void homepageAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Document newValue);

	/**
	 * Called when a value of homepage has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void homepageRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Document oldValue);
		
	/**
	 * Called when a value of logo has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void logoAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.jastor.Thing newValue);

	/**
	 * Called when a value of logo has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void logoRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.jastor.Thing oldValue);
		
	/**
	 * Called when a value of maker has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void makerAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Agent newValue);

	/**
	 * Called when a value of maker has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void makerRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Agent oldValue);
		
	/**
	 * Called when a value of page has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void pageAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Document newValue);

	/**
	 * Called when a value of page has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void pageRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Document oldValue);
		
	/**
	 * Called when a value of theme has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void themeAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.jastor.Thing newValue);

	/**
	 * Called when a value of theme has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void themeRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.jastor.Thing oldValue);
		
	/**
	 * Called when a value of dnaChecksum has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void dnaChecksumAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal newValue);

	/**
	 * Called when a value of dnaChecksum has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */	
	public void dnaChecksumRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal oldValue);

	/**
	 * Called when a value of nick has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void nickAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal newValue);

	/**
	 * Called when a value of nick has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */	
	public void nickRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal oldValue);

	/**
	 * Called when a value of title has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void titleAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal newValue);

	/**
	 * Called when a value of title has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */	
	public void titleRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal oldValue);

	/**
	 * Called when a value of phone has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void phoneAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.jastor.Thing newValue);

	/**
	 * Called when a value of phone has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void phoneRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.jastor.Thing oldValue);
		
	/**
	 * Called when a value of description has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void descriptionAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal newValue);

	/**
	 * Called when a value of description has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */	
	public void descriptionRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal oldValue);

	/**
	 * Called when a value of aimChatID has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void aimChatIDAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal newValue);

	/**
	 * Called when a value of aimChatID has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */	
	public void aimChatIDRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal oldValue);

	/**
	 * Called when birthday has changed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 */
	public void birthdayChanged(org.openanzo.ontologies.foaf.Person source);

	/**
	 * Called when gender has changed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 */
	public void genderChanged(org.openanzo.ontologies.foaf.Person source);

	/**
	 * Called when a value of icqChatID has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void icqChatIDAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal newValue);

	/**
	 * Called when a value of icqChatID has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */	
	public void icqChatIDRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal oldValue);

	/**
	 * Called when a value of jabberID has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void jabberIDAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal newValue);

	/**
	 * Called when a value of jabberID has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */	
	public void jabberIDRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal oldValue);

	/**
	 * Called when a value of mbox__sha1sum has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void mbox__sha1sumAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal newValue);

	/**
	 * Called when a value of mbox__sha1sum has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */	
	public void mbox__sha1sumRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal oldValue);

	/**
	 * Called when a value of msnChatID has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void msnChatIDAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal newValue);

	/**
	 * Called when a value of msnChatID has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */	
	public void msnChatIDRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal oldValue);

	/**
	 * Called when a value of yahooChatID has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void yahooChatIDAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal newValue);

	/**
	 * Called when a value of yahooChatID has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */	
	public void yahooChatIDRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal oldValue);

	/**
	 * Called when a value of holdsAccount has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void holdsAccountAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.OnlineAccount newValue);

	/**
	 * Called when a value of holdsAccount has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void holdsAccountRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.OnlineAccount oldValue);
		
	/**
	 * Called when a value of made has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void madeAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.jastor.Thing newValue);

	/**
	 * Called when a value of made has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void madeRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.jastor.Thing oldValue);
		
	/**
	 * Called when a value of mbox has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void mboxAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.jastor.Thing newValue);

	/**
	 * Called when a value of mbox has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void mboxRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.jastor.Thing oldValue);
		
	/**
	 * Called when a value of tipjar has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void tipjarAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Document newValue);

	/**
	 * Called when a value of tipjar has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void tipjarRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Document oldValue);
		
	/**
	 * Called when a value of weblog has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void weblogAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Document newValue);

	/**
	 * Called when a value of weblog has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void weblogRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Document oldValue);
		
	/**
	 * Called when a value of family__name has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void family__nameAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal newValue);

	/**
	 * Called when a value of family__name has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */	
	public void family__nameRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal oldValue);

	/**
	 * Called when a value of firstName has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void firstNameAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal newValue);

	/**
	 * Called when a value of firstName has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */	
	public void firstNameRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal oldValue);

	/**
	 * Called when a value of geekcode has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void geekcodeAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal newValue);

	/**
	 * Called when a value of geekcode has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */	
	public void geekcodeRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal oldValue);

	/**
	 * Called when a value of givenname has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void givennameAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal newValue);

	/**
	 * Called when a value of givenname has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */	
	public void givennameRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal oldValue);

	/**
	 * Called when a value of name has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void nameAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal newValue);

	/**
	 * Called when a value of name has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */	
	public void nameRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal oldValue);

	/**
	 * Called when a value of plan has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void planAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal newValue);

	/**
	 * Called when a value of plan has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */	
	public void planRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal oldValue);

	/**
	 * Called when a value of surname has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void surnameAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal newValue);

	/**
	 * Called when a value of surname has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */	
	public void surnameRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.Literal oldValue);

	/**
	 * Called when a value of currentProject has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void currentProjectAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.jastor.Thing newValue);

	/**
	 * Called when a value of currentProject has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void currentProjectRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.jastor.Thing oldValue);
		
	/**
	 * Called when a value of img has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void imgAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Image newValue);

	/**
	 * Called when a value of img has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void imgRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Image oldValue);
		
	/**
	 * Called when a value of interest has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void interestAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Document newValue);

	/**
	 * Called when a value of interest has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void interestRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Document oldValue);
		
	/**
	 * Called when a value of knows has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void knowsAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Person newValue);

	/**
	 * Called when a value of knows has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void knowsRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Person oldValue);
		
	/**
	 * Called when a value of myersBriggs has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void myersBriggsAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.jastor.Thing newValue);

	/**
	 * Called when a value of myersBriggs has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void myersBriggsRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.jastor.Thing oldValue);
		
	/**
	 * Called when a value of pastProject has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void pastProjectAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.jastor.Thing newValue);

	/**
	 * Called when a value of pastProject has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void pastProjectRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.jastor.Thing oldValue);
		
	/**
	 * Called when a value of publications has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void publicationsAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Document newValue);

	/**
	 * Called when a value of publications has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void publicationsRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Document oldValue);
		
	/**
	 * Called when a value of schoolHomepage has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void schoolHomepageAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Document newValue);

	/**
	 * Called when a value of schoolHomepage has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void schoolHomepageRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Document oldValue);
		
	/**
	 * Called when a value of topic__interest has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void topic__interestAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.jastor.Thing newValue);

	/**
	 * Called when a value of topic__interest has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void topic__interestRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.rdf.jastor.Thing oldValue);
		
	/**
	 * Called when a value of workInfoHomepage has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void workInfoHomepageAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Document newValue);

	/**
	 * Called when a value of workInfoHomepage has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void workInfoHomepageRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Document oldValue);
		
	/**
	 * Called when a value of workplaceHomepage has been added
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param newValue the object representing the new value
	 */	
	public void workplaceHomepageAdded(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Document newValue);

	/**
	 * Called when a value of workplaceHomepage has been removed
	 * @param source the affected instance of org.openanzo.ontologies.foaf.Person
	 * @param oldValue the object representing the removed value
	 */
	public void workplaceHomepageRemoved(org.openanzo.ontologies.foaf.Person source, org.openanzo.ontologies.foaf.Document oldValue);
		
}