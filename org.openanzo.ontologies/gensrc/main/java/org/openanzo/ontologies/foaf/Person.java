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
 * Interface for Person ontology class<br>
 * Use the org.openanzo.ontologies.foaf.FOAFFactory to create instances of this interface.
 * <p>(URI: http://xmlns.com/foaf/0.1/Person)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
 * 	label : Person <br>
 * 	comment : A person. <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface Person extends 
org.openanzo.ontologies.foaf.SpatialThing, 
org.openanzo.ontologies.foaf.Agent, org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/Person");
	

	/**
	 * The Anzo Property for family__name 
	 * <p>(URI: http://xmlns.com/foaf/0.1/family_name)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : family_name <br>
	 * 	comment : The family_name of some person. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI family__nameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/family_name");


	/**
	 * The Anzo Property for firstName 
	 * <p>(URI: http://xmlns.com/foaf/0.1/firstName)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : firstName <br>
	 * 	comment : The first name of a person. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI firstNameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/firstName");


	/**
	 * The Anzo Property for geekcode 
	 * <p>(URI: http://xmlns.com/foaf/0.1/geekcode)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : geekcode <br>
	 * 	comment : A textual geekcode for this person, see http://www.geekcode.com/geek.html <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI geekcodeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/geekcode");


	/**
	 * The Anzo Property for givenname 
	 * <p>(URI: http://xmlns.com/foaf/0.1/givenname)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : Given name <br>
	 * 	comment : The given name of some person. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI givennameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/givenname");


	/**
	 * The Anzo Property for name 
	 * <p>(URI: http://xmlns.com/foaf/0.1/name)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : name <br>
	 * 	comment : A name for some thing. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI nameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/name");


	/**
	 * The Anzo Property for plan 
	 * <p>(URI: http://xmlns.com/foaf/0.1/plan)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : plan <br>
	 * 	comment : A .plan comment, in the tradition of finger and '.plan' files. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI planProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/plan");


	/**
	 * The Anzo Property for surname 
	 * <p>(URI: http://xmlns.com/foaf/0.1/surname)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : Surname <br>
	 * 	comment : The surname of some person. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI surnameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/surname");


	/**
	 * The Anzo Property for currentProject 
	 * <p>(URI: http://xmlns.com/foaf/0.1/currentProject)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : current project <br>
	 * 	comment : A current project this person works on. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI currentProjectProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/currentProject");


	/**
	 * The Anzo Property for img 
	 * <p>(URI: http://xmlns.com/foaf/0.1/img)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : image <br>
	 * 	comment : An image that can be used to represent some thing (ie. those depictions which are particularly representative of something, eg. one's photo on a homepage). <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI imgProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/img");


	/**
	 * The Anzo Property for interest 
	 * <p>(URI: http://xmlns.com/foaf/0.1/interest)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : interest <br>
	 * 	comment : A page about a topic of interest to this person. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI interestProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/interest");


	/**
	 * The Anzo Property for knows 
	 * <p>(URI: http://xmlns.com/foaf/0.1/knows)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : knows <br>
	 * 	comment : A person known by this person (indicating some level of reciprocated interaction between the parties). <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI knowsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/knows");


	/**
	 * The Anzo Property for myersBriggs 
	 * <p>(URI: http://xmlns.com/foaf/0.1/myersBriggs)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : myersBriggs <br>
	 * 	comment : A Myers Briggs (MBTI) personality classification. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI myersBriggsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/myersBriggs");


	/**
	 * The Anzo Property for pastProject 
	 * <p>(URI: http://xmlns.com/foaf/0.1/pastProject)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : past project <br>
	 * 	comment : A project this person has previously worked on. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI pastProjectProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/pastProject");


	/**
	 * The Anzo Property for publications 
	 * <p>(URI: http://xmlns.com/foaf/0.1/publications)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : publications <br>
	 * 	comment : A link to the publications of this person. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI publicationsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/publications");


	/**
	 * The Anzo Property for schoolHomepage 
	 * <p>(URI: http://xmlns.com/foaf/0.1/schoolHomepage)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : schoolHomepage <br>
	 * 	comment : A homepage of a school attended by the person. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI schoolHomepageProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/schoolHomepage");


	/**
	 * The Anzo Property for topic__interest 
	 * <p>(URI: http://xmlns.com/foaf/0.1/topic_interest)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : interest_topic <br>
	 * 	comment : A thing of interest to this person. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI topic__interestProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/topic_interest");


	/**
	 * The Anzo Property for workInfoHomepage 
	 * <p>(URI: http://xmlns.com/foaf/0.1/workInfoHomepage)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : work info homepage <br>
	 * 	comment : A work info homepage of some person; a page about their work for some organization. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI workInfoHomepageProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/workInfoHomepage");


	/**
	 * The Anzo Property for workplaceHomepage 
	 * <p>(URI: http://xmlns.com/foaf/0.1/workplaceHomepage)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	isDefinedBy : http://xmlns.com/foaf/0.1/ <br>
	 * 	label : workplace homepage <br>
	 * 	comment : A workplace homepage of some person; the homepage of an organization they work for. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI workplaceHomepageProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/workplaceHomepage");


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
	 * Removes a value for the 'based__near' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	based__near	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#based__nearProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeBased__near(org.openanzo.rdf.Resource based__near) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'based__near'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#based__nearProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearBased__near(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
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
	 * Iterates through the 'family__name' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.Literal}
	 * @see			#family__nameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.Literal> getFamily__name() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Iterates through the 'family__name' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.Literal}
	 * @see			#family__nameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.Literal> getFamily__name(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Add a 'family__name' property value
	 * @param	family__name	{@link org.openanzo.rdf.Literal}, the value to add
	 * @see			#family__nameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addFamily__name(org.openanzo.rdf.Literal family__name) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Remove a 'family__name' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	family__name	{@link org.openanzo.rdf.Literal}, the value to remove
	 * @see			#family__nameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeFamily__name(org.openanzo.rdf.Literal family__name) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'family__name'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#family__nameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearFamily__name(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Iterates through the 'firstName' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.Literal}
	 * @see			#firstNameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.Literal> getFirstName() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Iterates through the 'firstName' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.Literal}
	 * @see			#firstNameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.Literal> getFirstName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Add a 'firstName' property value
	 * @param	firstName	{@link org.openanzo.rdf.Literal}, the value to add
	 * @see			#firstNameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addFirstName(org.openanzo.rdf.Literal firstName) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Remove a 'firstName' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	firstName	{@link org.openanzo.rdf.Literal}, the value to remove
	 * @see			#firstNameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeFirstName(org.openanzo.rdf.Literal firstName) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'firstName'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#firstNameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearFirstName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Iterates through the 'geekcode' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.Literal}
	 * @see			#geekcodeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.Literal> getGeekcode() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Iterates through the 'geekcode' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.Literal}
	 * @see			#geekcodeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.Literal> getGeekcode(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Add a 'geekcode' property value
	 * @param	geekcode	{@link org.openanzo.rdf.Literal}, the value to add
	 * @see			#geekcodeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addGeekcode(org.openanzo.rdf.Literal geekcode) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Remove a 'geekcode' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	geekcode	{@link org.openanzo.rdf.Literal}, the value to remove
	 * @see			#geekcodeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeGeekcode(org.openanzo.rdf.Literal geekcode) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'geekcode'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#geekcodeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearGeekcode(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Iterates through the 'givenname' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.Literal}
	 * @see			#givennameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.Literal> getGivenname() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Iterates through the 'givenname' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.Literal}
	 * @see			#givennameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.Literal> getGivenname(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Add a 'givenname' property value
	 * @param	givenname	{@link org.openanzo.rdf.Literal}, the value to add
	 * @see			#givennameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addGivenname(org.openanzo.rdf.Literal givenname) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Remove a 'givenname' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	givenname	{@link org.openanzo.rdf.Literal}, the value to remove
	 * @see			#givennameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeGivenname(org.openanzo.rdf.Literal givenname) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'givenname'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#givennameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearGivenname(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Iterates through the 'name' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.Literal}
	 * @see			#nameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.Literal> getName() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Iterates through the 'name' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.Literal}
	 * @see			#nameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.Literal> getName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Add a 'name' property value
	 * @param	name	{@link org.openanzo.rdf.Literal}, the value to add
	 * @see			#nameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addName(org.openanzo.rdf.Literal name) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Remove a 'name' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	name	{@link org.openanzo.rdf.Literal}, the value to remove
	 * @see			#nameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeName(org.openanzo.rdf.Literal name) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'name'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#nameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Iterates through the 'plan' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.Literal}
	 * @see			#planProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.Literal> getPlan() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Iterates through the 'plan' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.Literal}
	 * @see			#planProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.Literal> getPlan(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Add a 'plan' property value
	 * @param	plan	{@link org.openanzo.rdf.Literal}, the value to add
	 * @see			#planProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addPlan(org.openanzo.rdf.Literal plan) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Remove a 'plan' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	plan	{@link org.openanzo.rdf.Literal}, the value to remove
	 * @see			#planProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePlan(org.openanzo.rdf.Literal plan) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'plan'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#planProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearPlan(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Iterates through the 'surname' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.Literal}
	 * @see			#surnameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.Literal> getSurname() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Iterates through the 'surname' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.Literal}
	 * @see			#surnameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.Literal> getSurname(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Add a 'surname' property value
	 * @param	surname	{@link org.openanzo.rdf.Literal}, the value to add
	 * @see			#surnameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addSurname(org.openanzo.rdf.Literal surname) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Remove a 'surname' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	surname	{@link org.openanzo.rdf.Literal}, the value to remove
	 * @see			#surnameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeSurname(org.openanzo.rdf.Literal surname) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'surname'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#surnameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSurname(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'currentProject' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.jastor.Thing}
	 * @see			#currentProjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getCurrentProject() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'currentProject' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.jastor.Thing}
	 * @see			#currentProjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getCurrentProject(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'currentProject' property
	 * @param	currentProject	The {@link org.openanzo.rdf.jastor.Thing} to add
	 * @see			#currentProjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addCurrentProject(org.openanzo.rdf.jastor.Thing currentProject) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'currentProject' property
	 * @return		The anoymous {@link org.openanzo.rdf.jastor.Thing} created
	 * @see			#currentProjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing addCurrentProject() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'currentProject' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.Thing} with the factory
	 * and calling addCurrentProject(org.openanzo.rdf.jastor.Thing currentProject)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.rdf.jastor.Thing, value added
	 * @see			#currentProjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing addCurrentProject(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'currentProject' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	currentProject	The {@link org.openanzo.rdf.jastor.Thing} to remove
	 * @see			#currentProjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCurrentProject(org.openanzo.rdf.jastor.Thing currentProject) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'currentProject' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	currentProject	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#currentProjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCurrentProject(org.openanzo.rdf.Resource currentProject) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'currentProject'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#currentProjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearCurrentProject(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'img' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.foaf.Image}
	 * @see			#imgProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Image> getImg() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'img' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.foaf.Image}
	 * @see			#imgProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Image> getImg(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'img' property
	 * @param	img	The {@link org.openanzo.ontologies.foaf.Image} to add
	 * @see			#imgProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addImg(org.openanzo.ontologies.foaf.Image img) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'img' property
	 * @return		The anoymous {@link org.openanzo.ontologies.foaf.Image} created
	 * @see			#imgProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.foaf.Image addImg() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'img' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.foaf.Image} with the factory
	 * and calling addImg(org.openanzo.ontologies.foaf.Image img)
	 * The resource argument have rdf:type http://xmlns.com/foaf/0.1/Image.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.ontologies.foaf.Image, value added
	 * @see			#imgProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.foaf.Image addImg(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'img' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	img	The {@link org.openanzo.ontologies.foaf.Image} to remove
	 * @see			#imgProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeImg(org.openanzo.ontologies.foaf.Image img) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'img' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	img	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#imgProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeImg(org.openanzo.rdf.Resource img) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'img'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#imgProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearImg(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'interest' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.foaf.Document}
	 * @see			#interestProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getInterest() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'interest' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.foaf.Document}
	 * @see			#interestProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getInterest(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'interest' property
	 * @param	interest	The {@link org.openanzo.ontologies.foaf.Document} to add
	 * @see			#interestProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addInterest(org.openanzo.ontologies.foaf.Document interest) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'interest' property
	 * @return		The anoymous {@link org.openanzo.ontologies.foaf.Document} created
	 * @see			#interestProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.foaf.Document addInterest() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'interest' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.foaf.Document} with the factory
	 * and calling addInterest(org.openanzo.ontologies.foaf.Document interest)
	 * The resource argument have rdf:type http://xmlns.com/foaf/0.1/Document.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.ontologies.foaf.Document, value added
	 * @see			#interestProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.foaf.Document addInterest(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'interest' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	interest	The {@link org.openanzo.ontologies.foaf.Document} to remove
	 * @see			#interestProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeInterest(org.openanzo.ontologies.foaf.Document interest) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'interest' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	interest	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#interestProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeInterest(org.openanzo.rdf.Resource interest) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'interest'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#interestProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearInterest(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'knows' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.foaf.Person}
	 * @see			#knowsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Person> getKnows() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'knows' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.foaf.Person}
	 * @see			#knowsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Person> getKnows(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'knows' property
	 * @param	knows	The {@link org.openanzo.ontologies.foaf.Person} to add
	 * @see			#knowsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addKnows(org.openanzo.ontologies.foaf.Person knows) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'knows' property
	 * @return		The anoymous {@link org.openanzo.ontologies.foaf.Person} created
	 * @see			#knowsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.foaf.Person addKnows() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'knows' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.foaf.Person} with the factory
	 * and calling addKnows(org.openanzo.ontologies.foaf.Person knows)
	 * The resource argument have rdf:type http://xmlns.com/foaf/0.1/Person.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.ontologies.foaf.Person, value added
	 * @see			#knowsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.foaf.Person addKnows(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'knows' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	knows	The {@link org.openanzo.ontologies.foaf.Person} to remove
	 * @see			#knowsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeKnows(org.openanzo.ontologies.foaf.Person knows) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'knows' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	knows	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#knowsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeKnows(org.openanzo.rdf.Resource knows) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'knows'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#knowsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearKnows(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'myersBriggs' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.jastor.Thing}
	 * @see			#myersBriggsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getMyersBriggs() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'myersBriggs' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.jastor.Thing}
	 * @see			#myersBriggsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getMyersBriggs(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'myersBriggs' property
	 * @param	myersBriggs	The {@link org.openanzo.rdf.jastor.Thing} to add
	 * @see			#myersBriggsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addMyersBriggs(org.openanzo.rdf.jastor.Thing myersBriggs) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'myersBriggs' property
	 * @return		The anoymous {@link org.openanzo.rdf.jastor.Thing} created
	 * @see			#myersBriggsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing addMyersBriggs() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'myersBriggs' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.Thing} with the factory
	 * and calling addMyersBriggs(org.openanzo.rdf.jastor.Thing myersBriggs)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.rdf.jastor.Thing, value added
	 * @see			#myersBriggsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing addMyersBriggs(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'myersBriggs' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	myersBriggs	The {@link org.openanzo.rdf.jastor.Thing} to remove
	 * @see			#myersBriggsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMyersBriggs(org.openanzo.rdf.jastor.Thing myersBriggs) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'myersBriggs' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	myersBriggs	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#myersBriggsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMyersBriggs(org.openanzo.rdf.Resource myersBriggs) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'myersBriggs'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#myersBriggsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearMyersBriggs(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'pastProject' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.jastor.Thing}
	 * @see			#pastProjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getPastProject() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'pastProject' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.jastor.Thing}
	 * @see			#pastProjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getPastProject(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'pastProject' property
	 * @param	pastProject	The {@link org.openanzo.rdf.jastor.Thing} to add
	 * @see			#pastProjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addPastProject(org.openanzo.rdf.jastor.Thing pastProject) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'pastProject' property
	 * @return		The anoymous {@link org.openanzo.rdf.jastor.Thing} created
	 * @see			#pastProjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing addPastProject() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'pastProject' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.Thing} with the factory
	 * and calling addPastProject(org.openanzo.rdf.jastor.Thing pastProject)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.rdf.jastor.Thing, value added
	 * @see			#pastProjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing addPastProject(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'pastProject' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	pastProject	The {@link org.openanzo.rdf.jastor.Thing} to remove
	 * @see			#pastProjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePastProject(org.openanzo.rdf.jastor.Thing pastProject) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'pastProject' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	pastProject	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#pastProjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePastProject(org.openanzo.rdf.Resource pastProject) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'pastProject'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#pastProjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearPastProject(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'publications' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.foaf.Document}
	 * @see			#publicationsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getPublications() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'publications' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.foaf.Document}
	 * @see			#publicationsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getPublications(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'publications' property
	 * @param	publications	The {@link org.openanzo.ontologies.foaf.Document} to add
	 * @see			#publicationsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addPublications(org.openanzo.ontologies.foaf.Document publications) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'publications' property
	 * @return		The anoymous {@link org.openanzo.ontologies.foaf.Document} created
	 * @see			#publicationsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.foaf.Document addPublications() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'publications' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.foaf.Document} with the factory
	 * and calling addPublications(org.openanzo.ontologies.foaf.Document publications)
	 * The resource argument have rdf:type http://xmlns.com/foaf/0.1/Document.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.ontologies.foaf.Document, value added
	 * @see			#publicationsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.foaf.Document addPublications(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'publications' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	publications	The {@link org.openanzo.ontologies.foaf.Document} to remove
	 * @see			#publicationsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePublications(org.openanzo.ontologies.foaf.Document publications) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'publications' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	publications	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#publicationsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePublications(org.openanzo.rdf.Resource publications) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'publications'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#publicationsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearPublications(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'schoolHomepage' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.foaf.Document}
	 * @see			#schoolHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getSchoolHomepage() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'schoolHomepage' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.foaf.Document}
	 * @see			#schoolHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getSchoolHomepage(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'schoolHomepage' property
	 * @param	schoolHomepage	The {@link org.openanzo.ontologies.foaf.Document} to add
	 * @see			#schoolHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addSchoolHomepage(org.openanzo.ontologies.foaf.Document schoolHomepage) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'schoolHomepage' property
	 * @return		The anoymous {@link org.openanzo.ontologies.foaf.Document} created
	 * @see			#schoolHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.foaf.Document addSchoolHomepage() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'schoolHomepage' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.foaf.Document} with the factory
	 * and calling addSchoolHomepage(org.openanzo.ontologies.foaf.Document schoolHomepage)
	 * The resource argument have rdf:type http://xmlns.com/foaf/0.1/Document.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.ontologies.foaf.Document, value added
	 * @see			#schoolHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.foaf.Document addSchoolHomepage(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'schoolHomepage' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	schoolHomepage	The {@link org.openanzo.ontologies.foaf.Document} to remove
	 * @see			#schoolHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeSchoolHomepage(org.openanzo.ontologies.foaf.Document schoolHomepage) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'schoolHomepage' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	schoolHomepage	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#schoolHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeSchoolHomepage(org.openanzo.rdf.Resource schoolHomepage) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'schoolHomepage'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#schoolHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSchoolHomepage(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'topic__interest' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.jastor.Thing}
	 * @see			#topic__interestProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getTopic__interest() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'topic__interest' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.jastor.Thing}
	 * @see			#topic__interestProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getTopic__interest(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'topic__interest' property
	 * @param	topic__interest	The {@link org.openanzo.rdf.jastor.Thing} to add
	 * @see			#topic__interestProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addTopic__interest(org.openanzo.rdf.jastor.Thing topic__interest) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'topic__interest' property
	 * @return		The anoymous {@link org.openanzo.rdf.jastor.Thing} created
	 * @see			#topic__interestProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing addTopic__interest() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'topic__interest' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.Thing} with the factory
	 * and calling addTopic__interest(org.openanzo.rdf.jastor.Thing topic__interest)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.rdf.jastor.Thing, value added
	 * @see			#topic__interestProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing addTopic__interest(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'topic__interest' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	topic__interest	The {@link org.openanzo.rdf.jastor.Thing} to remove
	 * @see			#topic__interestProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeTopic__interest(org.openanzo.rdf.jastor.Thing topic__interest) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'topic__interest' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	topic__interest	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#topic__interestProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeTopic__interest(org.openanzo.rdf.Resource topic__interest) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'topic__interest'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#topic__interestProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearTopic__interest(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'workInfoHomepage' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.foaf.Document}
	 * @see			#workInfoHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getWorkInfoHomepage() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'workInfoHomepage' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.foaf.Document}
	 * @see			#workInfoHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getWorkInfoHomepage(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'workInfoHomepage' property
	 * @param	workInfoHomepage	The {@link org.openanzo.ontologies.foaf.Document} to add
	 * @see			#workInfoHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addWorkInfoHomepage(org.openanzo.ontologies.foaf.Document workInfoHomepage) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'workInfoHomepage' property
	 * @return		The anoymous {@link org.openanzo.ontologies.foaf.Document} created
	 * @see			#workInfoHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.foaf.Document addWorkInfoHomepage() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'workInfoHomepage' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.foaf.Document} with the factory
	 * and calling addWorkInfoHomepage(org.openanzo.ontologies.foaf.Document workInfoHomepage)
	 * The resource argument have rdf:type http://xmlns.com/foaf/0.1/Document.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.ontologies.foaf.Document, value added
	 * @see			#workInfoHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.foaf.Document addWorkInfoHomepage(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'workInfoHomepage' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	workInfoHomepage	The {@link org.openanzo.ontologies.foaf.Document} to remove
	 * @see			#workInfoHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeWorkInfoHomepage(org.openanzo.ontologies.foaf.Document workInfoHomepage) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'workInfoHomepage' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	workInfoHomepage	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#workInfoHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeWorkInfoHomepage(org.openanzo.rdf.Resource workInfoHomepage) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'workInfoHomepage'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#workInfoHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearWorkInfoHomepage(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'workplaceHomepage' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.foaf.Document}
	 * @see			#workplaceHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getWorkplaceHomepage() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'workplaceHomepage' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.foaf.Document}
	 * @see			#workplaceHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getWorkplaceHomepage(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'workplaceHomepage' property
	 * @param	workplaceHomepage	The {@link org.openanzo.ontologies.foaf.Document} to add
	 * @see			#workplaceHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addWorkplaceHomepage(org.openanzo.ontologies.foaf.Document workplaceHomepage) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'workplaceHomepage' property
	 * @return		The anoymous {@link org.openanzo.ontologies.foaf.Document} created
	 * @see			#workplaceHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.foaf.Document addWorkplaceHomepage() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'workplaceHomepage' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.foaf.Document} with the factory
	 * and calling addWorkplaceHomepage(org.openanzo.ontologies.foaf.Document workplaceHomepage)
	 * The resource argument have rdf:type http://xmlns.com/foaf/0.1/Document.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.ontologies.foaf.Document, value added
	 * @see			#workplaceHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.foaf.Document addWorkplaceHomepage(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'workplaceHomepage' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	workplaceHomepage	The {@link org.openanzo.ontologies.foaf.Document} to remove
	 * @see			#workplaceHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeWorkplaceHomepage(org.openanzo.ontologies.foaf.Document workplaceHomepage) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'workplaceHomepage' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	workplaceHomepage	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#workplaceHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeWorkplaceHomepage(org.openanzo.rdf.Resource workplaceHomepage) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'workplaceHomepage'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#workplaceHomepageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearWorkplaceHomepage(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}