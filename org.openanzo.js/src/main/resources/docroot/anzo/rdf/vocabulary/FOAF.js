/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>)
 * Created on:  Oct 10, 2007
 * Revision:
 $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 */
 
dojo.provide("anzo.rdf.vocabulary.FOAF");

dojo.require("anzo.rdf.Statement");

anzo.rdf.registerNamespace('foaf', "http://xmlns.com/foaf/0.1/");


/**
 * The standard FOAF vocabulary.
 */
anzo.rdf.vocabulary.FOAF = {
	
	jabberID			: anzo.createURI("foaf:jabberID"),
	knows				: anzo.createURI("foaf:knows"),
    depiction			: anzo.createURI("foaf:depiction"),
	homepage			: anzo.createURI("foaf:homepage"),
    thumbnail			: anzo.createURI("foaf:thumbnail"),
    schoolHomepage		: anzo.createURI("foaf:schoolHomepage"),
    phone				: anzo.createURI("foaf:phone"),
    based_near			: anzo.createURI("foaf:based_near"),
    geekcode			: anzo.createURI("foaf:geekcode"),
    topic_interest		: anzo.createURI("foaf:topic_interest"),
	interest			: anzo.createURI("foaf:interest"),
	maker				: anzo.createURI("foaf:maker"),
	depicts				: anzo.createURI("foaf:depicts"),
	mbox_sha1sum		: anzo.createURI("foaf:mbox_sha1sum"),
	made				: anzo.createURI("foaf:made"),
	givenname			: anzo.createURI("foaf:givenname"),
    plan				: anzo.createURI("foaf:plan"),
	img					: anzo.createURI("foaf:img"),
	logo				: anzo.createURI("foaf:logo"),
	weblog				: anzo.createURI("foaf:weblog"),	
	title				: anzo.createURI("foaf:title"),
	sha1				: anzo.createURI("foaf:sha1"),
	surname				: anzo.createURI("foaf:surname"),
    workInfoHomepage	: anzo.createURI("foaf:workInfoHomepage"),
	firstName			: anzo.createURI("foaf:firstName"),
	name				: anzo.createURI("foaf:name"),
	theme				: anzo.createURI("foaf:theme"),
    workplaceHomepage 	: anzo.createURI("foaf:workplaceHomepage"),
   	publications		: anzo.createURI("foaf:publications"),
   	aimChatID			: anzo.createURI("foaf:aimChatID"),
   	mbox				: anzo.createURI("foaf:mbox"),
    fundedBy			: anzo.createURI("foaf:fundedBy"),
   	myersBriggs			: anzo.createURI("foaf:myersBriggs"),
   	currentProject		: anzo.createURI("foaf:currentProject"),
   	pastProject			: anzo.createURI("foaf:pastProject"),
   	yahooChatID			: anzo.createURI("foaf:yahooChatID"),
   	dnaChecksum			: anzo.createURI("foaf:dnaChecksum"),
   	family_name			: anzo.createURI("foaf:family_name"),
   	page				: anzo.createURI("foaf:page"),
   	msnChatID			: anzo.createURI("foaf:msnChatID"),
   	topic				: anzo.createURI("foaf:topic"),
   	icqChatID			: anzo.createURI("foaf:icqChatID"),
   	nick				: anzo.createURI("foaf:nick"),
	Organization		: anzo.createURI("foaf:Organization"),
	Image				: anzo.createURI("foaf:Image"),
	Document			: anzo.createURI("foaf:Document"),
	Agent				: anzo.createURI("foaf:Agent"),
	Project				: anzo.createURI("foaf:Project"),
	Person				: anzo.createURI("foaf:Person"),
	Group				: anzo.createURI("foaf:Group")
    
};