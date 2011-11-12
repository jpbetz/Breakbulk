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
 * Interface for Group ontology class<br>
 * Use the org.openanzo.ontologies.foaf.FOAFFactory to create instances of this interface.
 * <p>(URI: http://xmlns.com/foaf/0.1/Group)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	label : Group <br>
 * 	comment : A class of Agents. <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface Group extends 
org.openanzo.ontologies.foaf.Agent, org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/Group");
	

	/**
	 * The Anzo Property for member 
	 * <p>(URI: http://xmlns.com/foaf/0.1/member)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : member <br>
	 * 	comment : Indicates a member of a Group <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI memberProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/member");


	/**
	 * The Anzo Property for depiction 
	 * <p>(URI: http://xmlns.com/foaf/0.1/depiction)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : depiction <br>
	 * 	comment : A depiction of some thing. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI depictionProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/depiction");


	/**
	 * The Anzo Property for fundedBy 
	 * <p>(URI: http://xmlns.com/foaf/0.1/fundedBy)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : funded by <br>
	 * 	comment : An organization funding a project or person. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI fundedByProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/fundedBy");


	/**
	 * The Anzo Property for homepage 
	 * <p>(URI: http://xmlns.com/foaf/0.1/homepage)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : homepage <br>
	 * 	comment : A homepage for some thing. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI homepageProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/homepage");


	/**
	 * The Anzo Property for isPrimaryTopicOf 
	 * <p>(URI: http://xmlns.com/foaf/0.1/isPrimaryTopicOf)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : is primary topic of <br>
	 * 	comment : A document that this thing is the primary topic of. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI isPrimaryTopicOfProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/isPrimaryTopicOf");


	/**
	 * The Anzo Property for logo 
	 * <p>(URI: http://xmlns.com/foaf/0.1/logo)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : logo <br>
	 * 	comment : A logo representing some thing. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI logoProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/logo");


	/**
	 * The Anzo Property for maker 
	 * <p>(URI: http://xmlns.com/foaf/0.1/maker)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : maker <br>
	 * 	comment : An agent that  made this thing. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI makerProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/maker");


	/**
	 * The Anzo Property for page 
	 * <p>(URI: http://xmlns.com/foaf/0.1/page)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : page <br>
	 * 	comment : A page or document about this thing. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI pageProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/page");


	/**
	 * The Anzo Property for theme 
	 * <p>(URI: http://xmlns.com/foaf/0.1/theme)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : theme <br>
	 * 	comment : A theme. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI themeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/theme");


	/**
	 * The Anzo Property for dnaChecksum 
	 * <p>(URI: http://xmlns.com/foaf/0.1/dnaChecksum)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : DNA checksum <br>
	 * 	comment : A checksum for the DNA of some thing. Joke. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI dnaChecksumProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/dnaChecksum");


	/**
	 * The Anzo Property for nick 
	 * <p>(URI: http://xmlns.com/foaf/0.1/nick)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : nickname <br>
	 * 	comment : A short informal nickname characterising an agent (includes login identifiers, IRC and other chat nicknames). <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI nickProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/nick");


	/**
	 * The Anzo Property for title 
	 * <p>(URI: http://xmlns.com/foaf/0.1/title)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : title <br>
	 * 	comment : Title (Mr, Mrs, Ms, Dr. etc) <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI titleProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/title");


	/**
	 * The Anzo Property for phone 
	 * <p>(URI: http://xmlns.com/foaf/0.1/phone)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : phone <br>
	 * 	comment : A phone,  specified using fully qualified tel: URI scheme (refs: http://www.w3.org/Addressing/schemes.html#tel). <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI phoneProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/phone");




/**
	 * Clears all values for 'description'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#descriptionProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDescription(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'aimChatID'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#aimChatIDProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearAimChatID(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'birthday'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#birthdayProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearBirthday(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'gender'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#genderProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearGender(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'icqChatID'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#icqChatIDProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearIcqChatID(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'jabberID'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#jabberIDProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearJabberID(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'mbox__sha1sum'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#mbox__sha1sumProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearMbox__sha1sum(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'msnChatID'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#msnChatIDProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearMsnChatID(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'yahooChatID'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#yahooChatIDProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearYahooChatID(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'holdsAccount' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	holdsAccount	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#holdsAccountProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeHoldsAccount(org.openanzo.rdf.Resource holdsAccount) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'holdsAccount'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#holdsAccountProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearHoldsAccount(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'made' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	made	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#madeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMade(org.openanzo.rdf.Resource made) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'made'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#madeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearMade(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'mbox' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	mbox	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#mboxProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMbox(org.openanzo.rdf.Resource mbox) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'mbox'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#mboxProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearMbox(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'tipjar' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	tipjar	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#tipjarProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeTipjar(org.openanzo.rdf.Resource tipjar) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'tipjar'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#tipjarProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearTipjar(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'weblog' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	weblog	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#weblogProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeWeblog(org.openanzo.rdf.Resource weblog) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'weblog'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#weblogProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearWeblog(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'depiction' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	depiction	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#depictionProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDepiction(org.openanzo.rdf.Resource depiction) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'depiction'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#depictionProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDepiction(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'fundedBy' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	fundedBy	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#fundedByProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeFundedBy(org.openanzo.rdf.Resource fundedBy) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'fundedBy'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#fundedByProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearFundedBy(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'homepage' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	homepage	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#homepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeHomepage(org.openanzo.rdf.Resource homepage) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'homepage'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#homepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearHomepage(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'isPrimaryTopicOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#isPrimaryTopicOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearIsPrimaryTopicOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'logo' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	logo	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#logoProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeLogo(org.openanzo.rdf.Resource logo) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'logo'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#logoProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearLogo(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'maker' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	maker	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#makerProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMaker(org.openanzo.rdf.Resource maker) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'maker'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#makerProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearMaker(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'page' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	page	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#pageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePage(org.openanzo.rdf.Resource page) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'page'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#pageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearPage(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'theme' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	theme	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#themeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeTheme(org.openanzo.rdf.Resource theme) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'theme'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#themeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearTheme(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'dnaChecksum'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#dnaChecksumProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDnaChecksum(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'nick'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#nickProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearNick(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'title'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#titleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearTitle(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'phone' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	phone	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#phoneProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePhone(org.openanzo.rdf.Resource phone) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'phone'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#phoneProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearPhone(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'member' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.foaf.Agent}
	 * @see			#memberProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Agent> getMember() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'member' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.foaf.Agent}
	 * @see			#memberProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Agent> getMember(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'member' property
	 * @param	member	The {@link org.openanzo.ontologies.foaf.Agent} to add
	 * @see			#memberProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addMember(org.openanzo.ontologies.foaf.Agent member) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'member' property
	 * @return		The anoymous {@link org.openanzo.ontologies.foaf.Agent} created
	 * @see			#memberProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.foaf.Agent addMember() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'member' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.foaf.Agent} with the factory
	 * and calling addMember(org.openanzo.ontologies.foaf.Agent member)
	 * The resource argument have rdf:type http://xmlns.com/foaf/0.1/Agent.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.ontologies.foaf.Agent, value added
	 * @see			#memberProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.foaf.Agent addMember(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'member' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	member	The {@link org.openanzo.ontologies.foaf.Agent} to remove
	 * @see			#memberProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMember(org.openanzo.ontologies.foaf.Agent member) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'member' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	member	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#memberProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMember(org.openanzo.rdf.Resource member) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'member'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#memberProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearMember(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}