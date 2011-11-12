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
 * Implementation of {@link org.openanzo.ontologies.foaf.Person}
 * Use the org.openanzo.ontologies.foaf.FOAFFactory to create instances of this class.
 * <p>(URI: http://xmlns.com/foaf/0.1/Person)</p>
 * <br>
 */
public class PersonImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.foaf.Person {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI based__nearProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/based_near");
	protected static final org.openanzo.rdf.URI depictionProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/depiction");
	protected static final org.openanzo.rdf.URI fundedByProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/fundedBy");
	protected static final org.openanzo.rdf.URI homepageProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/homepage");
	protected static final org.openanzo.rdf.URI isPrimaryTopicOfProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/isPrimaryTopicOf");
	protected static final org.openanzo.rdf.URI logoProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/logo");
	protected static final org.openanzo.rdf.URI makerProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/maker");
	protected static final org.openanzo.rdf.URI pageProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/page");
	protected static final org.openanzo.rdf.URI themeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/theme");
	protected static final org.openanzo.rdf.URI dnaChecksumProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/dnaChecksum");
	protected static final org.openanzo.rdf.URI nickProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/nick");
	protected static final org.openanzo.rdf.URI titleProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/title");
	protected static final org.openanzo.rdf.URI phoneProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/phone");
	protected static final org.openanzo.rdf.URI descriptionProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://purl.org/dc/elements/1.1/description");
	protected static final org.openanzo.rdf.URI aimChatIDProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/aimChatID");
	protected static final org.openanzo.rdf.URI birthdayProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/birthday");
	protected static final org.openanzo.rdf.URI genderProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/gender");
	protected static final org.openanzo.rdf.URI icqChatIDProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/icqChatID");
	protected static final org.openanzo.rdf.URI jabberIDProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/jabberID");
	protected static final org.openanzo.rdf.URI mbox__sha1sumProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/mbox_sha1sum");
	protected static final org.openanzo.rdf.URI msnChatIDProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/msnChatID");
	protected static final org.openanzo.rdf.URI yahooChatIDProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/yahooChatID");
	protected static final org.openanzo.rdf.URI holdsAccountProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/holdsAccount");
	protected static final org.openanzo.rdf.URI madeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/made");
	protected static final org.openanzo.rdf.URI mboxProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/mbox");
	protected static final org.openanzo.rdf.URI tipjarProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/tipjar");
	protected static final org.openanzo.rdf.URI weblogProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/weblog");
	protected static final org.openanzo.rdf.URI family__nameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/family_name");
	protected static final org.openanzo.rdf.URI firstNameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/firstName");
	protected static final org.openanzo.rdf.URI geekcodeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/geekcode");
	protected static final org.openanzo.rdf.URI givennameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/givenname");
	protected static final org.openanzo.rdf.URI nameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/name");
	protected static final org.openanzo.rdf.URI planProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/plan");
	protected static final org.openanzo.rdf.URI surnameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/surname");
	protected static final org.openanzo.rdf.URI currentProjectProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/currentProject");
	protected static final org.openanzo.rdf.URI imgProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/img");
	protected static final org.openanzo.rdf.URI interestProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/interest");
	protected static final org.openanzo.rdf.URI knowsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/knows");
	protected static final org.openanzo.rdf.URI myersBriggsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/myersBriggs");
	protected static final org.openanzo.rdf.URI pastProjectProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/pastProject");
	protected static final org.openanzo.rdf.URI publicationsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/publications");
	protected static final org.openanzo.rdf.URI schoolHomepageProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/schoolHomepage");
	protected static final org.openanzo.rdf.URI topic__interestProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/topic_interest");
	protected static final org.openanzo.rdf.URI workInfoHomepageProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/workInfoHomepage");
	protected static final org.openanzo.rdf.URI workplaceHomepageProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/workplaceHomepage");

	PersonImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static PersonImpl getPerson(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Person.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new PersonImpl(resource, namedGraphUri, dataset);
	}
	    
	static PersonImpl createPerson(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		PersonImpl impl = new PersonImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Person.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Person.TYPE, namedGraphUri);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	void addSuperTypes() {
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.foaf.SpatialThing.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.foaf.SpatialThing.TYPE,_graph.getNamedGraphUri());     
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.foaf.Agent.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.foaf.Agent.TYPE,_graph.getNamedGraphUri());     
	}
   
	void addHasValueValues() {
	}
   
	public java.util.Collection<org.openanzo.rdf.Statement> listStatements() {
		java.util.Collection<org.openanzo.rdf.Statement> list = new java.util.HashSet<org.openanzo.rdf.Statement>();
		
		list.addAll(_dataset.find(_resource, based__nearProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, depictionProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, fundedByProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, homepageProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, isPrimaryTopicOfProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, logoProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, makerProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, pageProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, themeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, dnaChecksumProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, nickProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, titleProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, phoneProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, descriptionProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, aimChatIDProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, birthdayProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, genderProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, icqChatIDProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, jabberIDProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, mbox__sha1sumProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, msnChatIDProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, yahooChatIDProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, holdsAccountProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, madeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, mboxProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, tipjarProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, weblogProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, family__nameProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, firstNameProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, geekcodeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, givennameProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, nameProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, planProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, surnameProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, currentProjectProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, imgProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, interestProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, knowsProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, myersBriggsProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, pastProjectProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, publicationsProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, schoolHomepageProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, topic__interestProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, workInfoHomepageProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, workplaceHomepageProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.foaf.Person.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.foaf.SpatialThing.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.foaf.Agent.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'based__near'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearBased__near(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, based__nearProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/based_near

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.SpatialThing> propertyCollectionBased__near = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.SpatialThing>() {
		public org.openanzo.ontologies.foaf.SpatialThing getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.foaf.FOAFFactory.getSpatialThing((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.foaf.SpatialThing 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.SpatialThing> getBased__near(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionBased__near.getPropertyCollection(_dataset, _graph, _resource,based__nearProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2003/01/geo/wgs84_pos#SpatialThing"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.foaf.SpatialThing  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.SpatialThing> getBased__near() throws org.openanzo.rdf.jastor.JastorException {
		return getBased__near(false);
	}

/**
     * 
     * @param based__near value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addBased__near(org.openanzo.ontologies.foaf.SpatialThing based__near) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, based__nearProperty,based__near.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.foaf.SpatialThing addBased__near() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.SpatialThing based__near = org.openanzo.ontologies.foaf.FOAFFactory.createSpatialThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, based__nearProperty,based__near.resource(),_graph.getNamedGraphUri());
		return based__near;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.foaf.SpatialThing addBased__near(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.SpatialThing based__near = org.openanzo.ontologies.foaf.FOAFFactory.getSpatialThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, based__nearProperty,based__near.resource(),_graph.getNamedGraphUri());
		return based__near;
	}
	
	/**
	 * Remove object
	 * @param based__near object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeBased__near(org.openanzo.ontologies.foaf.SpatialThing based__near) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, based__nearProperty, based__near.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, based__nearProperty, based__near.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeBased__near(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, based__nearProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, based__nearProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'depiction'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDepiction(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, depictionProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/depiction

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Image> propertyCollectionDepiction = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Image>() {
		public org.openanzo.ontologies.foaf.Image getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.foaf.FOAFFactory.getImage((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.foaf.Image 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Image> getDepiction(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionDepiction.getPropertyCollection(_dataset, _graph, _resource,depictionProperty, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/Image"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.foaf.Image  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Image> getDepiction() throws org.openanzo.rdf.jastor.JastorException {
		return getDepiction(false);
	}

/**
     * 
     * @param depiction value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addDepiction(org.openanzo.ontologies.foaf.Image depiction) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, depictionProperty,depiction.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.foaf.Image addDepiction() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Image depiction = org.openanzo.ontologies.foaf.FOAFFactory.createImage(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, depictionProperty,depiction.resource(),_graph.getNamedGraphUri());
		return depiction;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.foaf.Image addDepiction(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Image depiction = org.openanzo.ontologies.foaf.FOAFFactory.getImage(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, depictionProperty,depiction.resource(),_graph.getNamedGraphUri());
		return depiction;
	}
	
	/**
	 * Remove object
	 * @param depiction object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDepiction(org.openanzo.ontologies.foaf.Image depiction) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, depictionProperty, depiction.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, depictionProperty, depiction.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDepiction(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, depictionProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, depictionProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'fundedBy'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearFundedBy(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, fundedByProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/fundedBy

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing> propertyCollectionFundedBy = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing>() {
		public org.openanzo.rdf.jastor.Thing getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.jastor.ThingFactory.getThing((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.rdf.jastor.Thing 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getFundedBy(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionFundedBy.getPropertyCollection(_dataset, _graph, _resource,fundedByProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#Thing"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.rdf.jastor.Thing  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getFundedBy() throws org.openanzo.rdf.jastor.JastorException {
		return getFundedBy(false);
	}

/**
     * 
     * @param fundedBy value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addFundedBy(org.openanzo.rdf.jastor.Thing fundedBy) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, fundedByProperty,fundedBy.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.rdf.jastor.Thing addFundedBy() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing fundedBy = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, fundedByProperty,fundedBy.resource(),_graph.getNamedGraphUri());
		return fundedBy;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.rdf.jastor.Thing addFundedBy(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing fundedBy = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, fundedByProperty,fundedBy.resource(),_graph.getNamedGraphUri());
		return fundedBy;
	}
	
	/**
	 * Remove object
	 * @param fundedBy object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeFundedBy(org.openanzo.rdf.jastor.Thing fundedBy) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, fundedByProperty, fundedBy.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, fundedByProperty, fundedBy.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeFundedBy(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, fundedByProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, fundedByProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'homepage'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearHomepage(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, homepageProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/homepage

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Document> propertyCollectionHomepage = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Document>() {
		public org.openanzo.ontologies.foaf.Document getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.foaf.FOAFFactory.getDocument((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.foaf.Document 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getHomepage(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionHomepage.getPropertyCollection(_dataset, _graph, _resource,homepageProperty, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/Document"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.foaf.Document  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getHomepage() throws org.openanzo.rdf.jastor.JastorException {
		return getHomepage(false);
	}

/**
     * 
     * @param homepage value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addHomepage(org.openanzo.ontologies.foaf.Document homepage) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, homepageProperty,homepage.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.foaf.Document addHomepage() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Document homepage = org.openanzo.ontologies.foaf.FOAFFactory.createDocument(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, homepageProperty,homepage.resource(),_graph.getNamedGraphUri());
		return homepage;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.foaf.Document addHomepage(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Document homepage = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, homepageProperty,homepage.resource(),_graph.getNamedGraphUri());
		return homepage;
	}
	
	/**
	 * Remove object
	 * @param homepage object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeHomepage(org.openanzo.ontologies.foaf.Document homepage) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, homepageProperty, homepage.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, homepageProperty, homepage.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeHomepage(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, homepageProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, homepageProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'isPrimaryTopicOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearIsPrimaryTopicOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, isPrimaryTopicOfProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/isPrimaryTopicOf

	/**
	 * Clears all values for 'logo'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearLogo(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, logoProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/logo

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing> propertyCollectionLogo = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing>() {
		public org.openanzo.rdf.jastor.Thing getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.jastor.ThingFactory.getThing((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.rdf.jastor.Thing 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getLogo(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionLogo.getPropertyCollection(_dataset, _graph, _resource,logoProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#Thing"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.rdf.jastor.Thing  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getLogo() throws org.openanzo.rdf.jastor.JastorException {
		return getLogo(false);
	}

/**
     * 
     * @param logo value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addLogo(org.openanzo.rdf.jastor.Thing logo) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, logoProperty,logo.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.rdf.jastor.Thing addLogo() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing logo = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, logoProperty,logo.resource(),_graph.getNamedGraphUri());
		return logo;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.rdf.jastor.Thing addLogo(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing logo = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, logoProperty,logo.resource(),_graph.getNamedGraphUri());
		return logo;
	}
	
	/**
	 * Remove object
	 * @param logo object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeLogo(org.openanzo.rdf.jastor.Thing logo) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, logoProperty, logo.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, logoProperty, logo.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeLogo(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, logoProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, logoProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'maker'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearMaker(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, makerProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/maker

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Agent> propertyCollectionMaker = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Agent>() {
		public org.openanzo.ontologies.foaf.Agent getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.foaf.FOAFFactory.getAgent((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.foaf.Agent 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Agent> getMaker(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionMaker.getPropertyCollection(_dataset, _graph, _resource,makerProperty, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/Agent"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.foaf.Agent  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Agent> getMaker() throws org.openanzo.rdf.jastor.JastorException {
		return getMaker(false);
	}

/**
     * 
     * @param maker value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addMaker(org.openanzo.ontologies.foaf.Agent maker) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, makerProperty,maker.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.foaf.Agent addMaker() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Agent maker = org.openanzo.ontologies.foaf.FOAFFactory.createAgent(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, makerProperty,maker.resource(),_graph.getNamedGraphUri());
		return maker;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.foaf.Agent addMaker(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Agent maker = org.openanzo.ontologies.foaf.FOAFFactory.getAgent(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, makerProperty,maker.resource(),_graph.getNamedGraphUri());
		return maker;
	}
	
	/**
	 * Remove object
	 * @param maker object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMaker(org.openanzo.ontologies.foaf.Agent maker) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, makerProperty, maker.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, makerProperty, maker.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMaker(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, makerProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, makerProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'page'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearPage(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, pageProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/page

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Document> propertyCollectionPage = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Document>() {
		public org.openanzo.ontologies.foaf.Document getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.foaf.FOAFFactory.getDocument((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.foaf.Document 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getPage(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionPage.getPropertyCollection(_dataset, _graph, _resource,pageProperty, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/Document"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.foaf.Document  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getPage() throws org.openanzo.rdf.jastor.JastorException {
		return getPage(false);
	}

/**
     * 
     * @param page value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addPage(org.openanzo.ontologies.foaf.Document page) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, pageProperty,page.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.foaf.Document addPage() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Document page = org.openanzo.ontologies.foaf.FOAFFactory.createDocument(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, pageProperty,page.resource(),_graph.getNamedGraphUri());
		return page;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.foaf.Document addPage(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Document page = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, pageProperty,page.resource(),_graph.getNamedGraphUri());
		return page;
	}
	
	/**
	 * Remove object
	 * @param page object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePage(org.openanzo.ontologies.foaf.Document page) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, pageProperty, page.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, pageProperty, page.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePage(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, pageProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, pageProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'theme'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearTheme(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, themeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/theme

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing> propertyCollectionTheme = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing>() {
		public org.openanzo.rdf.jastor.Thing getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.jastor.ThingFactory.getThing((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.rdf.jastor.Thing 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getTheme(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionTheme.getPropertyCollection(_dataset, _graph, _resource,themeProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#Thing"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.rdf.jastor.Thing  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getTheme() throws org.openanzo.rdf.jastor.JastorException {
		return getTheme(false);
	}

/**
     * 
     * @param theme value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addTheme(org.openanzo.rdf.jastor.Thing theme) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, themeProperty,theme.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.rdf.jastor.Thing addTheme() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing theme = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, themeProperty,theme.resource(),_graph.getNamedGraphUri());
		return theme;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.rdf.jastor.Thing addTheme(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing theme = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, themeProperty,theme.resource(),_graph.getNamedGraphUri());
		return theme;
	}
	
	/**
	 * Remove object
	 * @param theme object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeTheme(org.openanzo.rdf.jastor.Thing theme) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, themeProperty, theme.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, themeProperty, theme.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeTheme(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, themeProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, themeProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'dnaChecksum'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDnaChecksum(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, dnaChecksumProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/dnaChecksum


	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal> propertyCollectionDnaChecksum = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal>() {
		public org.openanzo.rdf.Literal getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return literal;
	
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://xmlns.com/foaf/0.1/dnaChecksum properties in Person model not a Literal",value);
				}
			}
	};

	public java.util.Collection<org.openanzo.rdf.Literal> getDnaChecksum(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionDnaChecksum.getPropertyCollection(_dataset, _graph, _resource,dnaChecksumProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Literal"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.Literal> getDnaChecksum() throws org.openanzo.rdf.jastor.JastorException {
		return getDnaChecksum(false);
	}

	public void addDnaChecksum(org.openanzo.rdf.Literal dnaChecksum) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(dnaChecksum,"http://www.w3.org/2000/01/rdf-schema#Literal");
		//if (_dataset.contains(_resource, dnaChecksumProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (dnaChecksum != null) {
			_dataset.add(_resource, dnaChecksumProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeDnaChecksum(org.openanzo.rdf.Literal dnaChecksum) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(dnaChecksum,"http://www.w3.org/2000/01/rdf-schema#Literal");
		if (!_dataset.contains(_resource, dnaChecksumProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, dnaChecksumProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'nick'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearNick(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, nickProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/nick


	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal> propertyCollectionNick = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal>() {
		public org.openanzo.rdf.Literal getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return literal;
	
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://xmlns.com/foaf/0.1/nick properties in Person model not a Literal",value);
				}
			}
	};

	public java.util.Collection<org.openanzo.rdf.Literal> getNick(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionNick.getPropertyCollection(_dataset, _graph, _resource,nickProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Literal"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.Literal> getNick() throws org.openanzo.rdf.jastor.JastorException {
		return getNick(false);
	}

	public void addNick(org.openanzo.rdf.Literal nick) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(nick,"http://www.w3.org/2000/01/rdf-schema#Literal");
		//if (_dataset.contains(_resource, nickProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (nick != null) {
			_dataset.add(_resource, nickProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeNick(org.openanzo.rdf.Literal nick) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(nick,"http://www.w3.org/2000/01/rdf-schema#Literal");
		if (!_dataset.contains(_resource, nickProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, nickProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'title'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearTitle(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, titleProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/title


	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal> propertyCollectionTitle = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal>() {
		public org.openanzo.rdf.Literal getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return literal;
	
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://xmlns.com/foaf/0.1/title properties in Person model not a Literal",value);
				}
			}
	};

	public java.util.Collection<org.openanzo.rdf.Literal> getTitle(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionTitle.getPropertyCollection(_dataset, _graph, _resource,titleProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Literal"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.Literal> getTitle() throws org.openanzo.rdf.jastor.JastorException {
		return getTitle(false);
	}

	public void addTitle(org.openanzo.rdf.Literal title) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(title,"http://www.w3.org/2000/01/rdf-schema#Literal");
		//if (_dataset.contains(_resource, titleProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (title != null) {
			_dataset.add(_resource, titleProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeTitle(org.openanzo.rdf.Literal title) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(title,"http://www.w3.org/2000/01/rdf-schema#Literal");
		if (!_dataset.contains(_resource, titleProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, titleProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'phone'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearPhone(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, phoneProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/phone

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing> propertyCollectionPhone = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing>() {
		public org.openanzo.rdf.jastor.Thing getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.jastor.ThingFactory.getThing((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.rdf.jastor.Thing 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getPhone(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionPhone.getPropertyCollection(_dataset, _graph, _resource,phoneProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Resource"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.rdf.jastor.Thing  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getPhone() throws org.openanzo.rdf.jastor.JastorException {
		return getPhone(false);
	}

/**
     * 
     * @param phone value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addPhone(org.openanzo.rdf.jastor.Thing phone) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, phoneProperty,phone.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.rdf.jastor.Thing addPhone() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing phone = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, phoneProperty,phone.resource(),_graph.getNamedGraphUri());
		return phone;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.rdf.jastor.Thing addPhone(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing phone = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, phoneProperty,phone.resource(),_graph.getNamedGraphUri());
		return phone;
	}
	
	/**
	 * Remove object
	 * @param phone object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePhone(org.openanzo.rdf.jastor.Thing phone) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, phoneProperty, phone.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, phoneProperty, phone.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePhone(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, phoneProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, phoneProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'description'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDescription(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, descriptionProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://purl.org/dc/elements/1.1/description


	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal> propertyCollectionDescription = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal>() {
		public org.openanzo.rdf.Literal getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return literal;
	
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://purl.org/dc/elements/1.1/description properties in Person model not a Literal",value);
				}
			}
	};

	public java.util.Collection<org.openanzo.rdf.Literal> getDescription(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionDescription.getPropertyCollection(_dataset, _graph, _resource,descriptionProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Literal"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.Literal> getDescription() throws org.openanzo.rdf.jastor.JastorException {
		return getDescription(false);
	}

	public void addDescription(org.openanzo.rdf.Literal description) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(description,"http://www.w3.org/2000/01/rdf-schema#Literal");
		//if (_dataset.contains(_resource, descriptionProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (description != null) {
			_dataset.add(_resource, descriptionProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeDescription(org.openanzo.rdf.Literal description) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(description,"http://www.w3.org/2000/01/rdf-schema#Literal");
		if (!_dataset.contains(_resource, descriptionProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, descriptionProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'aimChatID'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearAimChatID(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, aimChatIDProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/aimChatID


	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal> propertyCollectionAimChatID = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal>() {
		public org.openanzo.rdf.Literal getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return literal;
	
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://xmlns.com/foaf/0.1/aimChatID properties in Person model not a Literal",value);
				}
			}
	};

	public java.util.Collection<org.openanzo.rdf.Literal> getAimChatID(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionAimChatID.getPropertyCollection(_dataset, _graph, _resource,aimChatIDProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Literal"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.Literal> getAimChatID() throws org.openanzo.rdf.jastor.JastorException {
		return getAimChatID(false);
	}

	public void addAimChatID(org.openanzo.rdf.Literal aimChatID) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(aimChatID,"http://www.w3.org/2000/01/rdf-schema#Literal");
		//if (_dataset.contains(_resource, aimChatIDProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (aimChatID != null) {
			_dataset.add(_resource, aimChatIDProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeAimChatID(org.openanzo.rdf.Literal aimChatID) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(aimChatID,"http://www.w3.org/2000/01/rdf-schema#Literal");
		if (!_dataset.contains(_resource, aimChatIDProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, aimChatIDProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'birthday'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearBirthday(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, birthdayProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/birthday
	public org.openanzo.rdf.Literal getBirthday(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, birthdayProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": birthday getProperty() in org.openanzo.ontologies.foaf.Person model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		return literal;
		
	}
	
	public org.openanzo.rdf.Literal getBirthday() throws org.openanzo.rdf.jastor.JastorException {
		return getBirthday(false);
	}
	
	public void setBirthday(org.openanzo.rdf.Literal birthday) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, birthdayProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (birthday != null) {
	
			_dataset.add(_resource, birthdayProperty, birthday,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'gender'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearGender(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, genderProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/gender
	public org.openanzo.rdf.Literal getGender(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, genderProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": gender getProperty() in org.openanzo.ontologies.foaf.Person model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		return literal;
		
	}
	
	public org.openanzo.rdf.Literal getGender() throws org.openanzo.rdf.jastor.JastorException {
		return getGender(false);
	}
	
	public void setGender(org.openanzo.rdf.Literal gender) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, genderProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (gender != null) {
	
			_dataset.add(_resource, genderProperty, gender,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'icqChatID'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearIcqChatID(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, icqChatIDProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/icqChatID


	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal> propertyCollectionIcqChatID = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal>() {
		public org.openanzo.rdf.Literal getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return literal;
	
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://xmlns.com/foaf/0.1/icqChatID properties in Person model not a Literal",value);
				}
			}
	};

	public java.util.Collection<org.openanzo.rdf.Literal> getIcqChatID(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionIcqChatID.getPropertyCollection(_dataset, _graph, _resource,icqChatIDProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Literal"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.Literal> getIcqChatID() throws org.openanzo.rdf.jastor.JastorException {
		return getIcqChatID(false);
	}

	public void addIcqChatID(org.openanzo.rdf.Literal icqChatID) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(icqChatID,"http://www.w3.org/2000/01/rdf-schema#Literal");
		//if (_dataset.contains(_resource, icqChatIDProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (icqChatID != null) {
			_dataset.add(_resource, icqChatIDProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeIcqChatID(org.openanzo.rdf.Literal icqChatID) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(icqChatID,"http://www.w3.org/2000/01/rdf-schema#Literal");
		if (!_dataset.contains(_resource, icqChatIDProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, icqChatIDProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'jabberID'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearJabberID(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, jabberIDProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/jabberID


	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal> propertyCollectionJabberID = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal>() {
		public org.openanzo.rdf.Literal getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return literal;
	
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://xmlns.com/foaf/0.1/jabberID properties in Person model not a Literal",value);
				}
			}
	};

	public java.util.Collection<org.openanzo.rdf.Literal> getJabberID(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionJabberID.getPropertyCollection(_dataset, _graph, _resource,jabberIDProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Literal"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.Literal> getJabberID() throws org.openanzo.rdf.jastor.JastorException {
		return getJabberID(false);
	}

	public void addJabberID(org.openanzo.rdf.Literal jabberID) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(jabberID,"http://www.w3.org/2000/01/rdf-schema#Literal");
		//if (_dataset.contains(_resource, jabberIDProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (jabberID != null) {
			_dataset.add(_resource, jabberIDProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeJabberID(org.openanzo.rdf.Literal jabberID) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(jabberID,"http://www.w3.org/2000/01/rdf-schema#Literal");
		if (!_dataset.contains(_resource, jabberIDProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, jabberIDProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'mbox__sha1sum'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearMbox__sha1sum(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, mbox__sha1sumProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/mbox_sha1sum


	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal> propertyCollectionMbox__sha1sum = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal>() {
		public org.openanzo.rdf.Literal getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return literal;
	
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://xmlns.com/foaf/0.1/mbox_sha1sum properties in Person model not a Literal",value);
				}
			}
	};

	public java.util.Collection<org.openanzo.rdf.Literal> getMbox__sha1sum(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionMbox__sha1sum.getPropertyCollection(_dataset, _graph, _resource,mbox__sha1sumProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Literal"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.Literal> getMbox__sha1sum() throws org.openanzo.rdf.jastor.JastorException {
		return getMbox__sha1sum(false);
	}

	public void addMbox__sha1sum(org.openanzo.rdf.Literal mbox__sha1sum) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(mbox__sha1sum,"http://www.w3.org/2000/01/rdf-schema#Literal");
		//if (_dataset.contains(_resource, mbox__sha1sumProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (mbox__sha1sum != null) {
			_dataset.add(_resource, mbox__sha1sumProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeMbox__sha1sum(org.openanzo.rdf.Literal mbox__sha1sum) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(mbox__sha1sum,"http://www.w3.org/2000/01/rdf-schema#Literal");
		if (!_dataset.contains(_resource, mbox__sha1sumProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, mbox__sha1sumProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'msnChatID'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearMsnChatID(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, msnChatIDProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/msnChatID


	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal> propertyCollectionMsnChatID = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal>() {
		public org.openanzo.rdf.Literal getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return literal;
	
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://xmlns.com/foaf/0.1/msnChatID properties in Person model not a Literal",value);
				}
			}
	};

	public java.util.Collection<org.openanzo.rdf.Literal> getMsnChatID(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionMsnChatID.getPropertyCollection(_dataset, _graph, _resource,msnChatIDProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Literal"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.Literal> getMsnChatID() throws org.openanzo.rdf.jastor.JastorException {
		return getMsnChatID(false);
	}

	public void addMsnChatID(org.openanzo.rdf.Literal msnChatID) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(msnChatID,"http://www.w3.org/2000/01/rdf-schema#Literal");
		//if (_dataset.contains(_resource, msnChatIDProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (msnChatID != null) {
			_dataset.add(_resource, msnChatIDProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeMsnChatID(org.openanzo.rdf.Literal msnChatID) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(msnChatID,"http://www.w3.org/2000/01/rdf-schema#Literal");
		if (!_dataset.contains(_resource, msnChatIDProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, msnChatIDProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'yahooChatID'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearYahooChatID(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, yahooChatIDProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/yahooChatID


	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal> propertyCollectionYahooChatID = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal>() {
		public org.openanzo.rdf.Literal getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return literal;
	
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://xmlns.com/foaf/0.1/yahooChatID properties in Person model not a Literal",value);
				}
			}
	};

	public java.util.Collection<org.openanzo.rdf.Literal> getYahooChatID(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionYahooChatID.getPropertyCollection(_dataset, _graph, _resource,yahooChatIDProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Literal"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.Literal> getYahooChatID() throws org.openanzo.rdf.jastor.JastorException {
		return getYahooChatID(false);
	}

	public void addYahooChatID(org.openanzo.rdf.Literal yahooChatID) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(yahooChatID,"http://www.w3.org/2000/01/rdf-schema#Literal");
		//if (_dataset.contains(_resource, yahooChatIDProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (yahooChatID != null) {
			_dataset.add(_resource, yahooChatIDProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeYahooChatID(org.openanzo.rdf.Literal yahooChatID) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(yahooChatID,"http://www.w3.org/2000/01/rdf-schema#Literal");
		if (!_dataset.contains(_resource, yahooChatIDProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, yahooChatIDProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'holdsAccount'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearHoldsAccount(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, holdsAccountProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/holdsAccount

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.OnlineAccount> propertyCollectionHoldsAccount = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.OnlineAccount>() {
		public org.openanzo.ontologies.foaf.OnlineAccount getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.foaf.FOAFFactory.getOnlineAccount((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.foaf.OnlineAccount 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.OnlineAccount> getHoldsAccount(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionHoldsAccount.getPropertyCollection(_dataset, _graph, _resource,holdsAccountProperty, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/OnlineAccount"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.foaf.OnlineAccount  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.OnlineAccount> getHoldsAccount() throws org.openanzo.rdf.jastor.JastorException {
		return getHoldsAccount(false);
	}

/**
     * 
     * @param holdsAccount value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addHoldsAccount(org.openanzo.ontologies.foaf.OnlineAccount holdsAccount) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, holdsAccountProperty,holdsAccount.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.foaf.OnlineAccount addHoldsAccount() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.OnlineAccount holdsAccount = org.openanzo.ontologies.foaf.FOAFFactory.createOnlineAccount(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, holdsAccountProperty,holdsAccount.resource(),_graph.getNamedGraphUri());
		return holdsAccount;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.foaf.OnlineAccount addHoldsAccount(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.OnlineAccount holdsAccount = org.openanzo.ontologies.foaf.FOAFFactory.getOnlineAccount(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, holdsAccountProperty,holdsAccount.resource(),_graph.getNamedGraphUri());
		return holdsAccount;
	}
	
	/**
	 * Remove object
	 * @param holdsAccount object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeHoldsAccount(org.openanzo.ontologies.foaf.OnlineAccount holdsAccount) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, holdsAccountProperty, holdsAccount.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, holdsAccountProperty, holdsAccount.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeHoldsAccount(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, holdsAccountProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, holdsAccountProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'made'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearMade(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, madeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/made

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing> propertyCollectionMade = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing>() {
		public org.openanzo.rdf.jastor.Thing getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.jastor.ThingFactory.getThing((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.rdf.jastor.Thing 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getMade(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionMade.getPropertyCollection(_dataset, _graph, _resource,madeProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#Thing"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.rdf.jastor.Thing  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getMade() throws org.openanzo.rdf.jastor.JastorException {
		return getMade(false);
	}

/**
     * 
     * @param made value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addMade(org.openanzo.rdf.jastor.Thing made) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, madeProperty,made.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.rdf.jastor.Thing addMade() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing made = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, madeProperty,made.resource(),_graph.getNamedGraphUri());
		return made;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.rdf.jastor.Thing addMade(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing made = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, madeProperty,made.resource(),_graph.getNamedGraphUri());
		return made;
	}
	
	/**
	 * Remove object
	 * @param made object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMade(org.openanzo.rdf.jastor.Thing made) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, madeProperty, made.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, madeProperty, made.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMade(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, madeProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, madeProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'mbox'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearMbox(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, mboxProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/mbox

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing> propertyCollectionMbox = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing>() {
		public org.openanzo.rdf.jastor.Thing getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.jastor.ThingFactory.getThing((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.rdf.jastor.Thing 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getMbox(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionMbox.getPropertyCollection(_dataset, _graph, _resource,mboxProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#Thing"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.rdf.jastor.Thing  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getMbox() throws org.openanzo.rdf.jastor.JastorException {
		return getMbox(false);
	}

/**
     * 
     * @param mbox value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addMbox(org.openanzo.rdf.jastor.Thing mbox) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, mboxProperty,mbox.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.rdf.jastor.Thing addMbox() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing mbox = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, mboxProperty,mbox.resource(),_graph.getNamedGraphUri());
		return mbox;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.rdf.jastor.Thing addMbox(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing mbox = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, mboxProperty,mbox.resource(),_graph.getNamedGraphUri());
		return mbox;
	}
	
	/**
	 * Remove object
	 * @param mbox object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMbox(org.openanzo.rdf.jastor.Thing mbox) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, mboxProperty, mbox.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, mboxProperty, mbox.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMbox(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, mboxProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, mboxProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'tipjar'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearTipjar(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, tipjarProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/tipjar

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Document> propertyCollectionTipjar = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Document>() {
		public org.openanzo.ontologies.foaf.Document getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.foaf.FOAFFactory.getDocument((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.foaf.Document 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getTipjar(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionTipjar.getPropertyCollection(_dataset, _graph, _resource,tipjarProperty, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/Document"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.foaf.Document  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getTipjar() throws org.openanzo.rdf.jastor.JastorException {
		return getTipjar(false);
	}

/**
     * 
     * @param tipjar value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addTipjar(org.openanzo.ontologies.foaf.Document tipjar) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, tipjarProperty,tipjar.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.foaf.Document addTipjar() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Document tipjar = org.openanzo.ontologies.foaf.FOAFFactory.createDocument(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, tipjarProperty,tipjar.resource(),_graph.getNamedGraphUri());
		return tipjar;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.foaf.Document addTipjar(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Document tipjar = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, tipjarProperty,tipjar.resource(),_graph.getNamedGraphUri());
		return tipjar;
	}
	
	/**
	 * Remove object
	 * @param tipjar object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeTipjar(org.openanzo.ontologies.foaf.Document tipjar) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, tipjarProperty, tipjar.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, tipjarProperty, tipjar.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeTipjar(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, tipjarProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, tipjarProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'weblog'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearWeblog(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, weblogProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/weblog

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Document> propertyCollectionWeblog = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Document>() {
		public org.openanzo.ontologies.foaf.Document getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.foaf.FOAFFactory.getDocument((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.foaf.Document 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getWeblog(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionWeblog.getPropertyCollection(_dataset, _graph, _resource,weblogProperty, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/Document"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.foaf.Document  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getWeblog() throws org.openanzo.rdf.jastor.JastorException {
		return getWeblog(false);
	}

/**
     * 
     * @param weblog value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addWeblog(org.openanzo.ontologies.foaf.Document weblog) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, weblogProperty,weblog.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.foaf.Document addWeblog() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Document weblog = org.openanzo.ontologies.foaf.FOAFFactory.createDocument(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, weblogProperty,weblog.resource(),_graph.getNamedGraphUri());
		return weblog;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.foaf.Document addWeblog(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Document weblog = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, weblogProperty,weblog.resource(),_graph.getNamedGraphUri());
		return weblog;
	}
	
	/**
	 * Remove object
	 * @param weblog object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeWeblog(org.openanzo.ontologies.foaf.Document weblog) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, weblogProperty, weblog.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, weblogProperty, weblog.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeWeblog(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, weblogProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, weblogProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'family__name'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearFamily__name(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, family__nameProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/family_name


	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal> propertyCollectionFamily__name = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal>() {
		public org.openanzo.rdf.Literal getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return literal;
	
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://xmlns.com/foaf/0.1/family_name properties in Person model not a Literal",value);
				}
			}
	};

	public java.util.Collection<org.openanzo.rdf.Literal> getFamily__name(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionFamily__name.getPropertyCollection(_dataset, _graph, _resource,family__nameProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Literal"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.Literal> getFamily__name() throws org.openanzo.rdf.jastor.JastorException {
		return getFamily__name(false);
	}

	public void addFamily__name(org.openanzo.rdf.Literal family__name) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(family__name,"http://www.w3.org/2000/01/rdf-schema#Literal");
		//if (_dataset.contains(_resource, family__nameProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (family__name != null) {
			_dataset.add(_resource, family__nameProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeFamily__name(org.openanzo.rdf.Literal family__name) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(family__name,"http://www.w3.org/2000/01/rdf-schema#Literal");
		if (!_dataset.contains(_resource, family__nameProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, family__nameProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'firstName'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearFirstName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, firstNameProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/firstName


	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal> propertyCollectionFirstName = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal>() {
		public org.openanzo.rdf.Literal getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return literal;
	
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://xmlns.com/foaf/0.1/firstName properties in Person model not a Literal",value);
				}
			}
	};

	public java.util.Collection<org.openanzo.rdf.Literal> getFirstName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionFirstName.getPropertyCollection(_dataset, _graph, _resource,firstNameProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Literal"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.Literal> getFirstName() throws org.openanzo.rdf.jastor.JastorException {
		return getFirstName(false);
	}

	public void addFirstName(org.openanzo.rdf.Literal firstName) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(firstName,"http://www.w3.org/2000/01/rdf-schema#Literal");
		//if (_dataset.contains(_resource, firstNameProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (firstName != null) {
			_dataset.add(_resource, firstNameProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeFirstName(org.openanzo.rdf.Literal firstName) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(firstName,"http://www.w3.org/2000/01/rdf-schema#Literal");
		if (!_dataset.contains(_resource, firstNameProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, firstNameProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'geekcode'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearGeekcode(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, geekcodeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/geekcode


	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal> propertyCollectionGeekcode = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal>() {
		public org.openanzo.rdf.Literal getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return literal;
	
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://xmlns.com/foaf/0.1/geekcode properties in Person model not a Literal",value);
				}
			}
	};

	public java.util.Collection<org.openanzo.rdf.Literal> getGeekcode(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionGeekcode.getPropertyCollection(_dataset, _graph, _resource,geekcodeProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Literal"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.Literal> getGeekcode() throws org.openanzo.rdf.jastor.JastorException {
		return getGeekcode(false);
	}

	public void addGeekcode(org.openanzo.rdf.Literal geekcode) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(geekcode,"http://www.w3.org/2000/01/rdf-schema#Literal");
		//if (_dataset.contains(_resource, geekcodeProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (geekcode != null) {
			_dataset.add(_resource, geekcodeProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeGeekcode(org.openanzo.rdf.Literal geekcode) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(geekcode,"http://www.w3.org/2000/01/rdf-schema#Literal");
		if (!_dataset.contains(_resource, geekcodeProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, geekcodeProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'givenname'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearGivenname(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, givennameProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/givenname


	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal> propertyCollectionGivenname = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal>() {
		public org.openanzo.rdf.Literal getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return literal;
	
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://xmlns.com/foaf/0.1/givenname properties in Person model not a Literal",value);
				}
			}
	};

	public java.util.Collection<org.openanzo.rdf.Literal> getGivenname(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionGivenname.getPropertyCollection(_dataset, _graph, _resource,givennameProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Literal"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.Literal> getGivenname() throws org.openanzo.rdf.jastor.JastorException {
		return getGivenname(false);
	}

	public void addGivenname(org.openanzo.rdf.Literal givenname) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(givenname,"http://www.w3.org/2000/01/rdf-schema#Literal");
		//if (_dataset.contains(_resource, givennameProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (givenname != null) {
			_dataset.add(_resource, givennameProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeGivenname(org.openanzo.rdf.Literal givenname) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(givenname,"http://www.w3.org/2000/01/rdf-schema#Literal");
		if (!_dataset.contains(_resource, givennameProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, givennameProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'name'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, nameProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/name


	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal> propertyCollectionName = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal>() {
		public org.openanzo.rdf.Literal getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return literal;
	
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://xmlns.com/foaf/0.1/name properties in Person model not a Literal",value);
				}
			}
	};

	public java.util.Collection<org.openanzo.rdf.Literal> getName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionName.getPropertyCollection(_dataset, _graph, _resource,nameProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Literal"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.Literal> getName() throws org.openanzo.rdf.jastor.JastorException {
		return getName(false);
	}

	public void addName(org.openanzo.rdf.Literal name) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(name,"http://www.w3.org/2000/01/rdf-schema#Literal");
		//if (_dataset.contains(_resource, nameProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (name != null) {
			_dataset.add(_resource, nameProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeName(org.openanzo.rdf.Literal name) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(name,"http://www.w3.org/2000/01/rdf-schema#Literal");
		if (!_dataset.contains(_resource, nameProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, nameProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'plan'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearPlan(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, planProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/plan


	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal> propertyCollectionPlan = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal>() {
		public org.openanzo.rdf.Literal getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return literal;
	
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://xmlns.com/foaf/0.1/plan properties in Person model not a Literal",value);
				}
			}
	};

	public java.util.Collection<org.openanzo.rdf.Literal> getPlan(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionPlan.getPropertyCollection(_dataset, _graph, _resource,planProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Literal"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.Literal> getPlan() throws org.openanzo.rdf.jastor.JastorException {
		return getPlan(false);
	}

	public void addPlan(org.openanzo.rdf.Literal plan) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(plan,"http://www.w3.org/2000/01/rdf-schema#Literal");
		//if (_dataset.contains(_resource, planProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (plan != null) {
			_dataset.add(_resource, planProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removePlan(org.openanzo.rdf.Literal plan) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(plan,"http://www.w3.org/2000/01/rdf-schema#Literal");
		if (!_dataset.contains(_resource, planProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, planProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'surname'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearSurname(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, surnameProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/surname


	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal> propertyCollectionSurname = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal>() {
		public org.openanzo.rdf.Literal getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return literal;
	
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://xmlns.com/foaf/0.1/surname properties in Person model not a Literal",value);
				}
			}
	};

	public java.util.Collection<org.openanzo.rdf.Literal> getSurname(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionSurname.getPropertyCollection(_dataset, _graph, _resource,surnameProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Literal"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.Literal> getSurname() throws org.openanzo.rdf.jastor.JastorException {
		return getSurname(false);
	}

	public void addSurname(org.openanzo.rdf.Literal surname) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(surname,"http://www.w3.org/2000/01/rdf-schema#Literal");
		//if (_dataset.contains(_resource, surnameProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (surname != null) {
			_dataset.add(_resource, surnameProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeSurname(org.openanzo.rdf.Literal surname) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(surname,"http://www.w3.org/2000/01/rdf-schema#Literal");
		if (!_dataset.contains(_resource, surnameProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, surnameProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'currentProject'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearCurrentProject(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, currentProjectProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/currentProject

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing> propertyCollectionCurrentProject = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing>() {
		public org.openanzo.rdf.jastor.Thing getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.jastor.ThingFactory.getThing((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.rdf.jastor.Thing 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getCurrentProject(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionCurrentProject.getPropertyCollection(_dataset, _graph, _resource,currentProjectProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#Thing"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.rdf.jastor.Thing  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getCurrentProject() throws org.openanzo.rdf.jastor.JastorException {
		return getCurrentProject(false);
	}

/**
     * 
     * @param currentProject value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addCurrentProject(org.openanzo.rdf.jastor.Thing currentProject) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, currentProjectProperty,currentProject.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.rdf.jastor.Thing addCurrentProject() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing currentProject = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, currentProjectProperty,currentProject.resource(),_graph.getNamedGraphUri());
		return currentProject;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.rdf.jastor.Thing addCurrentProject(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing currentProject = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, currentProjectProperty,currentProject.resource(),_graph.getNamedGraphUri());
		return currentProject;
	}
	
	/**
	 * Remove object
	 * @param currentProject object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCurrentProject(org.openanzo.rdf.jastor.Thing currentProject) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, currentProjectProperty, currentProject.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, currentProjectProperty, currentProject.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCurrentProject(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, currentProjectProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, currentProjectProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'img'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearImg(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, imgProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/img

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Image> propertyCollectionImg = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Image>() {
		public org.openanzo.ontologies.foaf.Image getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.foaf.FOAFFactory.getImage((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.foaf.Image 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Image> getImg(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionImg.getPropertyCollection(_dataset, _graph, _resource,imgProperty, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/Image"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.foaf.Image  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Image> getImg() throws org.openanzo.rdf.jastor.JastorException {
		return getImg(false);
	}

/**
     * 
     * @param img value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addImg(org.openanzo.ontologies.foaf.Image img) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, imgProperty,img.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.foaf.Image addImg() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Image img = org.openanzo.ontologies.foaf.FOAFFactory.createImage(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, imgProperty,img.resource(),_graph.getNamedGraphUri());
		return img;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.foaf.Image addImg(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Image img = org.openanzo.ontologies.foaf.FOAFFactory.getImage(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, imgProperty,img.resource(),_graph.getNamedGraphUri());
		return img;
	}
	
	/**
	 * Remove object
	 * @param img object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeImg(org.openanzo.ontologies.foaf.Image img) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, imgProperty, img.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, imgProperty, img.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeImg(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, imgProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, imgProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'interest'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearInterest(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, interestProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/interest

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Document> propertyCollectionInterest = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Document>() {
		public org.openanzo.ontologies.foaf.Document getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.foaf.FOAFFactory.getDocument((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.foaf.Document 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getInterest(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionInterest.getPropertyCollection(_dataset, _graph, _resource,interestProperty, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/Document"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.foaf.Document  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getInterest() throws org.openanzo.rdf.jastor.JastorException {
		return getInterest(false);
	}

/**
     * 
     * @param interest value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addInterest(org.openanzo.ontologies.foaf.Document interest) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, interestProperty,interest.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.foaf.Document addInterest() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Document interest = org.openanzo.ontologies.foaf.FOAFFactory.createDocument(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, interestProperty,interest.resource(),_graph.getNamedGraphUri());
		return interest;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.foaf.Document addInterest(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Document interest = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, interestProperty,interest.resource(),_graph.getNamedGraphUri());
		return interest;
	}
	
	/**
	 * Remove object
	 * @param interest object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeInterest(org.openanzo.ontologies.foaf.Document interest) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, interestProperty, interest.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, interestProperty, interest.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeInterest(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, interestProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, interestProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'knows'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearKnows(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, knowsProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/knows

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Person> propertyCollectionKnows = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Person>() {
		public org.openanzo.ontologies.foaf.Person getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.foaf.FOAFFactory.getPerson((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.foaf.Person 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Person> getKnows(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionKnows.getPropertyCollection(_dataset, _graph, _resource,knowsProperty, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/Person"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.foaf.Person  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Person> getKnows() throws org.openanzo.rdf.jastor.JastorException {
		return getKnows(false);
	}

/**
     * 
     * @param knows value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addKnows(org.openanzo.ontologies.foaf.Person knows) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, knowsProperty,knows.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.foaf.Person addKnows() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Person knows = org.openanzo.ontologies.foaf.FOAFFactory.createPerson(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, knowsProperty,knows.resource(),_graph.getNamedGraphUri());
		return knows;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.foaf.Person addKnows(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Person knows = org.openanzo.ontologies.foaf.FOAFFactory.getPerson(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, knowsProperty,knows.resource(),_graph.getNamedGraphUri());
		return knows;
	}
	
	/**
	 * Remove object
	 * @param knows object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeKnows(org.openanzo.ontologies.foaf.Person knows) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, knowsProperty, knows.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, knowsProperty, knows.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeKnows(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, knowsProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, knowsProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'myersBriggs'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearMyersBriggs(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, myersBriggsProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/myersBriggs

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing> propertyCollectionMyersBriggs = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing>() {
		public org.openanzo.rdf.jastor.Thing getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.jastor.ThingFactory.getThing((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.rdf.jastor.Thing 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getMyersBriggs(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionMyersBriggs.getPropertyCollection(_dataset, _graph, _resource,myersBriggsProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Literal"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.rdf.jastor.Thing  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getMyersBriggs() throws org.openanzo.rdf.jastor.JastorException {
		return getMyersBriggs(false);
	}

/**
     * 
     * @param myersBriggs value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addMyersBriggs(org.openanzo.rdf.jastor.Thing myersBriggs) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, myersBriggsProperty,myersBriggs.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.rdf.jastor.Thing addMyersBriggs() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing myersBriggs = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, myersBriggsProperty,myersBriggs.resource(),_graph.getNamedGraphUri());
		return myersBriggs;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.rdf.jastor.Thing addMyersBriggs(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing myersBriggs = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, myersBriggsProperty,myersBriggs.resource(),_graph.getNamedGraphUri());
		return myersBriggs;
	}
	
	/**
	 * Remove object
	 * @param myersBriggs object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMyersBriggs(org.openanzo.rdf.jastor.Thing myersBriggs) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, myersBriggsProperty, myersBriggs.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, myersBriggsProperty, myersBriggs.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMyersBriggs(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, myersBriggsProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, myersBriggsProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'pastProject'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearPastProject(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, pastProjectProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/pastProject

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing> propertyCollectionPastProject = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing>() {
		public org.openanzo.rdf.jastor.Thing getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.jastor.ThingFactory.getThing((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.rdf.jastor.Thing 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getPastProject(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionPastProject.getPropertyCollection(_dataset, _graph, _resource,pastProjectProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#Thing"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.rdf.jastor.Thing  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getPastProject() throws org.openanzo.rdf.jastor.JastorException {
		return getPastProject(false);
	}

/**
     * 
     * @param pastProject value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addPastProject(org.openanzo.rdf.jastor.Thing pastProject) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, pastProjectProperty,pastProject.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.rdf.jastor.Thing addPastProject() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing pastProject = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, pastProjectProperty,pastProject.resource(),_graph.getNamedGraphUri());
		return pastProject;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.rdf.jastor.Thing addPastProject(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing pastProject = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, pastProjectProperty,pastProject.resource(),_graph.getNamedGraphUri());
		return pastProject;
	}
	
	/**
	 * Remove object
	 * @param pastProject object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePastProject(org.openanzo.rdf.jastor.Thing pastProject) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, pastProjectProperty, pastProject.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, pastProjectProperty, pastProject.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePastProject(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, pastProjectProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, pastProjectProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'publications'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearPublications(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, publicationsProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/publications

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Document> propertyCollectionPublications = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Document>() {
		public org.openanzo.ontologies.foaf.Document getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.foaf.FOAFFactory.getDocument((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.foaf.Document 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getPublications(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionPublications.getPropertyCollection(_dataset, _graph, _resource,publicationsProperty, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/Document"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.foaf.Document  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getPublications() throws org.openanzo.rdf.jastor.JastorException {
		return getPublications(false);
	}

/**
     * 
     * @param publications value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addPublications(org.openanzo.ontologies.foaf.Document publications) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, publicationsProperty,publications.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.foaf.Document addPublications() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Document publications = org.openanzo.ontologies.foaf.FOAFFactory.createDocument(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, publicationsProperty,publications.resource(),_graph.getNamedGraphUri());
		return publications;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.foaf.Document addPublications(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Document publications = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, publicationsProperty,publications.resource(),_graph.getNamedGraphUri());
		return publications;
	}
	
	/**
	 * Remove object
	 * @param publications object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePublications(org.openanzo.ontologies.foaf.Document publications) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, publicationsProperty, publications.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, publicationsProperty, publications.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePublications(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, publicationsProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, publicationsProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'schoolHomepage'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearSchoolHomepage(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, schoolHomepageProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/schoolHomepage

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Document> propertyCollectionSchoolHomepage = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Document>() {
		public org.openanzo.ontologies.foaf.Document getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.foaf.FOAFFactory.getDocument((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.foaf.Document 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getSchoolHomepage(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionSchoolHomepage.getPropertyCollection(_dataset, _graph, _resource,schoolHomepageProperty, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/Document"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.foaf.Document  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getSchoolHomepage() throws org.openanzo.rdf.jastor.JastorException {
		return getSchoolHomepage(false);
	}

/**
     * 
     * @param schoolHomepage value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addSchoolHomepage(org.openanzo.ontologies.foaf.Document schoolHomepage) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, schoolHomepageProperty,schoolHomepage.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.foaf.Document addSchoolHomepage() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Document schoolHomepage = org.openanzo.ontologies.foaf.FOAFFactory.createDocument(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, schoolHomepageProperty,schoolHomepage.resource(),_graph.getNamedGraphUri());
		return schoolHomepage;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.foaf.Document addSchoolHomepage(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Document schoolHomepage = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, schoolHomepageProperty,schoolHomepage.resource(),_graph.getNamedGraphUri());
		return schoolHomepage;
	}
	
	/**
	 * Remove object
	 * @param schoolHomepage object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeSchoolHomepage(org.openanzo.ontologies.foaf.Document schoolHomepage) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, schoolHomepageProperty, schoolHomepage.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, schoolHomepageProperty, schoolHomepage.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeSchoolHomepage(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, schoolHomepageProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, schoolHomepageProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'topic__interest'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearTopic__interest(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, topic__interestProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/topic_interest

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing> propertyCollectionTopic__interest = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing>() {
		public org.openanzo.rdf.jastor.Thing getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.jastor.ThingFactory.getThing((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.rdf.jastor.Thing 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getTopic__interest(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionTopic__interest.getPropertyCollection(_dataset, _graph, _resource,topic__interestProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#Thing"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.rdf.jastor.Thing  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getTopic__interest() throws org.openanzo.rdf.jastor.JastorException {
		return getTopic__interest(false);
	}

/**
     * 
     * @param topic__interest value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addTopic__interest(org.openanzo.rdf.jastor.Thing topic__interest) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, topic__interestProperty,topic__interest.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.rdf.jastor.Thing addTopic__interest() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing topic__interest = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, topic__interestProperty,topic__interest.resource(),_graph.getNamedGraphUri());
		return topic__interest;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.rdf.jastor.Thing addTopic__interest(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing topic__interest = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, topic__interestProperty,topic__interest.resource(),_graph.getNamedGraphUri());
		return topic__interest;
	}
	
	/**
	 * Remove object
	 * @param topic__interest object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeTopic__interest(org.openanzo.rdf.jastor.Thing topic__interest) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, topic__interestProperty, topic__interest.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, topic__interestProperty, topic__interest.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeTopic__interest(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, topic__interestProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, topic__interestProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'workInfoHomepage'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearWorkInfoHomepage(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, workInfoHomepageProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/workInfoHomepage

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Document> propertyCollectionWorkInfoHomepage = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Document>() {
		public org.openanzo.ontologies.foaf.Document getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.foaf.FOAFFactory.getDocument((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.foaf.Document 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getWorkInfoHomepage(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionWorkInfoHomepage.getPropertyCollection(_dataset, _graph, _resource,workInfoHomepageProperty, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/Document"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.foaf.Document  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getWorkInfoHomepage() throws org.openanzo.rdf.jastor.JastorException {
		return getWorkInfoHomepage(false);
	}

/**
     * 
     * @param workInfoHomepage value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addWorkInfoHomepage(org.openanzo.ontologies.foaf.Document workInfoHomepage) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, workInfoHomepageProperty,workInfoHomepage.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.foaf.Document addWorkInfoHomepage() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Document workInfoHomepage = org.openanzo.ontologies.foaf.FOAFFactory.createDocument(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, workInfoHomepageProperty,workInfoHomepage.resource(),_graph.getNamedGraphUri());
		return workInfoHomepage;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.foaf.Document addWorkInfoHomepage(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Document workInfoHomepage = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, workInfoHomepageProperty,workInfoHomepage.resource(),_graph.getNamedGraphUri());
		return workInfoHomepage;
	}
	
	/**
	 * Remove object
	 * @param workInfoHomepage object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeWorkInfoHomepage(org.openanzo.ontologies.foaf.Document workInfoHomepage) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, workInfoHomepageProperty, workInfoHomepage.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, workInfoHomepageProperty, workInfoHomepage.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeWorkInfoHomepage(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, workInfoHomepageProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, workInfoHomepageProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'workplaceHomepage'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearWorkplaceHomepage(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, workplaceHomepageProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/workplaceHomepage

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Document> propertyCollectionWorkplaceHomepage = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Document>() {
		public org.openanzo.ontologies.foaf.Document getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.foaf.FOAFFactory.getDocument((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.foaf.Document 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getWorkplaceHomepage(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionWorkplaceHomepage.getPropertyCollection(_dataset, _graph, _resource,workplaceHomepageProperty, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/Document"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.foaf.Document  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getWorkplaceHomepage() throws org.openanzo.rdf.jastor.JastorException {
		return getWorkplaceHomepage(false);
	}

/**
     * 
     * @param workplaceHomepage value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addWorkplaceHomepage(org.openanzo.ontologies.foaf.Document workplaceHomepage) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, workplaceHomepageProperty,workplaceHomepage.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.foaf.Document addWorkplaceHomepage() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Document workplaceHomepage = org.openanzo.ontologies.foaf.FOAFFactory.createDocument(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, workplaceHomepageProperty,workplaceHomepage.resource(),_graph.getNamedGraphUri());
		return workplaceHomepage;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.foaf.Document addWorkplaceHomepage(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Document workplaceHomepage = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, workplaceHomepageProperty,workplaceHomepage.resource(),_graph.getNamedGraphUri());
		return workplaceHomepage;
	}
	
	/**
	 * Remove object
	 * @param workplaceHomepage object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeWorkplaceHomepage(org.openanzo.ontologies.foaf.Document workplaceHomepage) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, workplaceHomepageProperty, workplaceHomepage.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, workplaceHomepageProperty, workplaceHomepage.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeWorkplaceHomepage(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, workplaceHomepageProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, workplaceHomepageProperty, resource,_graph.getNamedGraphUri());
	}
  


	protected java.util.concurrent.CopyOnWriteArraySet<PersonListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<PersonListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof PersonListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	PersonListener list = (PersonListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof PersonListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		PersonListener list = (PersonListener)listener;
		if(listeners.contains(list)){
			listeners.remove(list);
		}
		if(listeners.size()==0){	
    		_dataset.unregisterListener(_listener);
    	}
	}
	



	protected class ThingStatementListener implements org.openanzo.rdf.IStatementListener<org.openanzo.rdf.IDataset> {
	
		public void statementsAdded(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(based__nearProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.SpatialThing _based__near = org.openanzo.ontologies.foaf.FOAFFactory.getSpatialThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_based__near != null) {
					for(PersonListener listener : listeners){
						listener.based__nearAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_based__near);
					}
				}			
			}
			if (statement.getPredicate().equals(depictionProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Image _depiction = org.openanzo.ontologies.foaf.FOAFFactory.getImage(resource,_graph.getNamedGraphUri(),dataset());
				if (_depiction != null) {
					for(PersonListener listener : listeners){
						listener.depictionAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_depiction);
					}
				}			
			}
			if (statement.getPredicate().equals(fundedByProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _fundedBy = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_fundedBy != null) {
					for(PersonListener listener : listeners){
						listener.fundedByAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_fundedBy);
					}
				}			
			}
			if (statement.getPredicate().equals(homepageProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Document _homepage = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),dataset());
				if (_homepage != null) {
					for(PersonListener listener : listeners){
						listener.homepageAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_homepage);
					}
				}			
			}
			if (statement.getPredicate().equals(isPrimaryTopicOfProperty)) {			
			}
			if (statement.getPredicate().equals(logoProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _logo = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_logo != null) {
					for(PersonListener listener : listeners){
						listener.logoAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_logo);
					}
				}			
			}
			if (statement.getPredicate().equals(makerProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Agent _maker = org.openanzo.ontologies.foaf.FOAFFactory.getAgent(resource,_graph.getNamedGraphUri(),dataset());
				if (_maker != null) {
					for(PersonListener listener : listeners){
						listener.makerAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_maker);
					}
				}			
			}
			if (statement.getPredicate().equals(pageProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Document _page = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),dataset());
				if (_page != null) {
					for(PersonListener listener : listeners){
						listener.pageAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_page);
					}
				}			
			}
			if (statement.getPredicate().equals(themeProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _theme = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_theme != null) {
					for(PersonListener listener : listeners){
						listener.themeAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_theme);
					}
				}			
			}
			if (statement.getPredicate().equals(dnaChecksumProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				for(PersonListener listener : listeners){
					listener.dnaChecksumAdded(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}			
			}
			if (statement.getPredicate().equals(nickProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				for(PersonListener listener : listeners){
					listener.nickAdded(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}			
			}
			if (statement.getPredicate().equals(titleProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				for(PersonListener listener : listeners){
					listener.titleAdded(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}			
			}
			if (statement.getPredicate().equals(phoneProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _phone = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_phone != null) {
					for(PersonListener listener : listeners){
						listener.phoneAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_phone);
					}
				}			
			}
			if (statement.getPredicate().equals(descriptionProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				for(PersonListener listener : listeners){
					listener.descriptionAdded(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}			
			}
			if (statement.getPredicate().equals(aimChatIDProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				for(PersonListener listener : listeners){
					listener.aimChatIDAdded(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}			
			}
			if (statement.getPredicate().equals(birthdayProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(PersonListener listener : listeners){
					listener.birthdayChanged(org.openanzo.ontologies.foaf.PersonImpl.this);
				}			
			}
			if (statement.getPredicate().equals(genderProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(PersonListener listener : listeners){
					listener.genderChanged(org.openanzo.ontologies.foaf.PersonImpl.this);
				}			
			}
			if (statement.getPredicate().equals(icqChatIDProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				for(PersonListener listener : listeners){
					listener.icqChatIDAdded(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}			
			}
			if (statement.getPredicate().equals(jabberIDProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				for(PersonListener listener : listeners){
					listener.jabberIDAdded(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}			
			}
			if (statement.getPredicate().equals(mbox__sha1sumProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				for(PersonListener listener : listeners){
					listener.mbox__sha1sumAdded(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}			
			}
			if (statement.getPredicate().equals(msnChatIDProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				for(PersonListener listener : listeners){
					listener.msnChatIDAdded(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}			
			}
			if (statement.getPredicate().equals(yahooChatIDProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				for(PersonListener listener : listeners){
					listener.yahooChatIDAdded(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}			
			}
			if (statement.getPredicate().equals(holdsAccountProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.OnlineAccount _holdsAccount = org.openanzo.ontologies.foaf.FOAFFactory.getOnlineAccount(resource,_graph.getNamedGraphUri(),dataset());
				if (_holdsAccount != null) {
					for(PersonListener listener : listeners){
						listener.holdsAccountAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_holdsAccount);
					}
				}			
			}
			if (statement.getPredicate().equals(madeProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _made = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_made != null) {
					for(PersonListener listener : listeners){
						listener.madeAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_made);
					}
				}			
			}
			if (statement.getPredicate().equals(mboxProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _mbox = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_mbox != null) {
					for(PersonListener listener : listeners){
						listener.mboxAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_mbox);
					}
				}			
			}
			if (statement.getPredicate().equals(tipjarProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Document _tipjar = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),dataset());
				if (_tipjar != null) {
					for(PersonListener listener : listeners){
						listener.tipjarAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_tipjar);
					}
				}			
			}
			if (statement.getPredicate().equals(weblogProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Document _weblog = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),dataset());
				if (_weblog != null) {
					for(PersonListener listener : listeners){
						listener.weblogAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_weblog);
					}
				}			
			}
			if (statement.getPredicate().equals(family__nameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				for(PersonListener listener : listeners){
					listener.family__nameAdded(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}			
			}
			if (statement.getPredicate().equals(firstNameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				for(PersonListener listener : listeners){
					listener.firstNameAdded(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}			
			}
			if (statement.getPredicate().equals(geekcodeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				for(PersonListener listener : listeners){
					listener.geekcodeAdded(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}			
			}
			if (statement.getPredicate().equals(givennameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				for(PersonListener listener : listeners){
					listener.givennameAdded(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}			
			}
			if (statement.getPredicate().equals(nameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				for(PersonListener listener : listeners){
					listener.nameAdded(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}			
			}
			if (statement.getPredicate().equals(planProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				for(PersonListener listener : listeners){
					listener.planAdded(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}			
			}
			if (statement.getPredicate().equals(surnameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				for(PersonListener listener : listeners){
					listener.surnameAdded(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}			
			}
			if (statement.getPredicate().equals(currentProjectProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _currentProject = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_currentProject != null) {
					for(PersonListener listener : listeners){
						listener.currentProjectAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_currentProject);
					}
				}			
			}
			if (statement.getPredicate().equals(imgProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Image _img = org.openanzo.ontologies.foaf.FOAFFactory.getImage(resource,_graph.getNamedGraphUri(),dataset());
				if (_img != null) {
					for(PersonListener listener : listeners){
						listener.imgAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_img);
					}
				}			
			}
			if (statement.getPredicate().equals(interestProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Document _interest = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),dataset());
				if (_interest != null) {
					for(PersonListener listener : listeners){
						listener.interestAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_interest);
					}
				}			
			}
			if (statement.getPredicate().equals(knowsProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Person _knows = org.openanzo.ontologies.foaf.FOAFFactory.getPerson(resource,_graph.getNamedGraphUri(),dataset());
				if (_knows != null) {
					for(PersonListener listener : listeners){
						listener.knowsAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_knows);
					}
				}			
			}
			if (statement.getPredicate().equals(myersBriggsProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _myersBriggs = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_myersBriggs != null) {
					for(PersonListener listener : listeners){
						listener.myersBriggsAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_myersBriggs);
					}
				}			
			}
			if (statement.getPredicate().equals(pastProjectProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _pastProject = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_pastProject != null) {
					for(PersonListener listener : listeners){
						listener.pastProjectAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_pastProject);
					}
				}			
			}
			if (statement.getPredicate().equals(publicationsProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Document _publications = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),dataset());
				if (_publications != null) {
					for(PersonListener listener : listeners){
						listener.publicationsAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_publications);
					}
				}			
			}
			if (statement.getPredicate().equals(schoolHomepageProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Document _schoolHomepage = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),dataset());
				if (_schoolHomepage != null) {
					for(PersonListener listener : listeners){
						listener.schoolHomepageAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_schoolHomepage);
					}
				}			
			}
			if (statement.getPredicate().equals(topic__interestProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _topic__interest = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_topic__interest != null) {
					for(PersonListener listener : listeners){
						listener.topic__interestAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_topic__interest);
					}
				}			
			}
			if (statement.getPredicate().equals(workInfoHomepageProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Document _workInfoHomepage = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),dataset());
				if (_workInfoHomepage != null) {
					for(PersonListener listener : listeners){
						listener.workInfoHomepageAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_workInfoHomepage);
					}
				}			
			}
			if (statement.getPredicate().equals(workplaceHomepageProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Document _workplaceHomepage = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),dataset());
				if (_workplaceHomepage != null) {
					for(PersonListener listener : listeners){
						listener.workplaceHomepageAdded(org.openanzo.ontologies.foaf.PersonImpl.this,_workplaceHomepage);
					}
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(based__nearProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.SpatialThing _based__near = org.openanzo.ontologies.foaf.FOAFFactory.getSpatialThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_based__near != null) {
					for(PersonListener listener : listeners){
						listener.based__nearRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_based__near);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(depictionProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Image _depiction = org.openanzo.ontologies.foaf.FOAFFactory.getImage(resource,_graph.getNamedGraphUri(),dataset());
				if (_depiction != null) {
					for(PersonListener listener : listeners){
						listener.depictionRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_depiction);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(fundedByProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _fundedBy = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_fundedBy != null) {
					for(PersonListener listener : listeners){
						listener.fundedByRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_fundedBy);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(homepageProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Document _homepage = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),dataset());
				if (_homepage != null) {
					for(PersonListener listener : listeners){
						listener.homepageRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_homepage);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(isPrimaryTopicOfProperty)) {
				return;
			}
			if (statement.getPredicate().equals(logoProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _logo = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_logo != null) {
					for(PersonListener listener : listeners){
						listener.logoRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_logo);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(makerProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Agent _maker = org.openanzo.ontologies.foaf.FOAFFactory.getAgent(resource,_graph.getNamedGraphUri(),dataset());
				if (_maker != null) {
					for(PersonListener listener : listeners){
						listener.makerRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_maker);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(pageProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Document _page = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),dataset());
				if (_page != null) {
					for(PersonListener listener : listeners){
						listener.pageRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_page);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(themeProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _theme = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_theme != null) {
					for(PersonListener listener : listeners){
						listener.themeRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_theme);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(dnaChecksumProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				for(PersonListener listener:listeners){
					listener.dnaChecksumRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}
				return;
			}
			if (statement.getPredicate().equals(nickProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				for(PersonListener listener:listeners){
					listener.nickRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}
				return;
			}
			if (statement.getPredicate().equals(titleProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				for(PersonListener listener:listeners){
					listener.titleRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}
				return;
			}
			if (statement.getPredicate().equals(phoneProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _phone = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_phone != null) {
					for(PersonListener listener : listeners){
						listener.phoneRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_phone);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(descriptionProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				for(PersonListener listener:listeners){
					listener.descriptionRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}
				return;
			}
			if (statement.getPredicate().equals(aimChatIDProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				for(PersonListener listener:listeners){
					listener.aimChatIDRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}
				return;
			}
			if (statement.getPredicate().equals(birthdayProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(PersonListener listener : listeners) {
					listener.birthdayChanged(org.openanzo.ontologies.foaf.PersonImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(genderProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(PersonListener listener : listeners) {
					listener.genderChanged(org.openanzo.ontologies.foaf.PersonImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(icqChatIDProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				for(PersonListener listener:listeners){
					listener.icqChatIDRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}
				return;
			}
			if (statement.getPredicate().equals(jabberIDProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				for(PersonListener listener:listeners){
					listener.jabberIDRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}
				return;
			}
			if (statement.getPredicate().equals(mbox__sha1sumProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				for(PersonListener listener:listeners){
					listener.mbox__sha1sumRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}
				return;
			}
			if (statement.getPredicate().equals(msnChatIDProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				for(PersonListener listener:listeners){
					listener.msnChatIDRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}
				return;
			}
			if (statement.getPredicate().equals(yahooChatIDProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				for(PersonListener listener:listeners){
					listener.yahooChatIDRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}
				return;
			}
			if (statement.getPredicate().equals(holdsAccountProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.OnlineAccount _holdsAccount = org.openanzo.ontologies.foaf.FOAFFactory.getOnlineAccount(resource,_graph.getNamedGraphUri(),dataset());
				if (_holdsAccount != null) {
					for(PersonListener listener : listeners){
						listener.holdsAccountRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_holdsAccount);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(madeProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _made = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_made != null) {
					for(PersonListener listener : listeners){
						listener.madeRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_made);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(mboxProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _mbox = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_mbox != null) {
					for(PersonListener listener : listeners){
						listener.mboxRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_mbox);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(tipjarProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Document _tipjar = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),dataset());
				if (_tipjar != null) {
					for(PersonListener listener : listeners){
						listener.tipjarRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_tipjar);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(weblogProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Document _weblog = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),dataset());
				if (_weblog != null) {
					for(PersonListener listener : listeners){
						listener.weblogRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_weblog);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(family__nameProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				for(PersonListener listener:listeners){
					listener.family__nameRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}
				return;
			}
			if (statement.getPredicate().equals(firstNameProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				for(PersonListener listener:listeners){
					listener.firstNameRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}
				return;
			}
			if (statement.getPredicate().equals(geekcodeProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				for(PersonListener listener:listeners){
					listener.geekcodeRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}
				return;
			}
			if (statement.getPredicate().equals(givennameProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				for(PersonListener listener:listeners){
					listener.givennameRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}
				return;
			}
			if (statement.getPredicate().equals(nameProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				for(PersonListener listener:listeners){
					listener.nameRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}
				return;
			}
			if (statement.getPredicate().equals(planProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				for(PersonListener listener:listeners){
					listener.planRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}
				return;
			}
			if (statement.getPredicate().equals(surnameProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				for(PersonListener listener:listeners){
					listener.surnameRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,literal);
				}
				return;
			}
			if (statement.getPredicate().equals(currentProjectProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _currentProject = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_currentProject != null) {
					for(PersonListener listener : listeners){
						listener.currentProjectRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_currentProject);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(imgProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Image _img = org.openanzo.ontologies.foaf.FOAFFactory.getImage(resource,_graph.getNamedGraphUri(),dataset());
				if (_img != null) {
					for(PersonListener listener : listeners){
						listener.imgRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_img);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(interestProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Document _interest = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),dataset());
				if (_interest != null) {
					for(PersonListener listener : listeners){
						listener.interestRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_interest);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(knowsProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Person _knows = org.openanzo.ontologies.foaf.FOAFFactory.getPerson(resource,_graph.getNamedGraphUri(),dataset());
				if (_knows != null) {
					for(PersonListener listener : listeners){
						listener.knowsRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_knows);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(myersBriggsProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _myersBriggs = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_myersBriggs != null) {
					for(PersonListener listener : listeners){
						listener.myersBriggsRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_myersBriggs);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(pastProjectProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _pastProject = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_pastProject != null) {
					for(PersonListener listener : listeners){
						listener.pastProjectRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_pastProject);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(publicationsProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Document _publications = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),dataset());
				if (_publications != null) {
					for(PersonListener listener : listeners){
						listener.publicationsRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_publications);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(schoolHomepageProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Document _schoolHomepage = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),dataset());
				if (_schoolHomepage != null) {
					for(PersonListener listener : listeners){
						listener.schoolHomepageRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_schoolHomepage);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(topic__interestProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _topic__interest = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_topic__interest != null) {
					for(PersonListener listener : listeners){
						listener.topic__interestRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_topic__interest);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(workInfoHomepageProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Document _workInfoHomepage = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),dataset());
				if (_workInfoHomepage != null) {
					for(PersonListener listener : listeners){
						listener.workInfoHomepageRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_workInfoHomepage);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(workplaceHomepageProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Document _workplaceHomepage = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),dataset());
				if (_workplaceHomepage != null) {
					for(PersonListener listener : listeners){
						listener.workplaceHomepageRemoved(org.openanzo.ontologies.foaf.PersonImpl.this,_workplaceHomepage);
					}
				}
				return;
			}
		}
		}}
	}
	


}