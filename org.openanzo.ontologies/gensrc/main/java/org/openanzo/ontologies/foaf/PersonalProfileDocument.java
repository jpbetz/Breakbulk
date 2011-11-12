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
 * Interface for PersonalProfileDocument ontology class<br>
 * Use the org.openanzo.ontologies.foaf.FOAFFactory to create instances of this interface.
 * <p>(URI: http://xmlns.com/foaf/0.1/PersonalProfileDocument)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	label : PersonalProfileDocument <br>
 * 	comment : A personal profile RDF document. <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface PersonalProfileDocument extends 
org.openanzo.ontologies.foaf.Document, org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/PersonalProfileDocument");
	

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
	 * Clears all values for 'sha1'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#sha1Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSha1(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'primaryTopic'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#primaryTopicProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearPrimaryTopic(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'topic' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	topic	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#topicProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeTopic(org.openanzo.rdf.Resource topic) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'topic'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#topicProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearTopic(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
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

}