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
 * Implementation of {@link org.openanzo.ontologies.foaf.OnlineEcommerceAccount}
 * Use the org.openanzo.ontologies.foaf.FOAFFactory to create instances of this class.
 * <p>(URI: http://xmlns.com/foaf/0.1/OnlineEcommerceAccount)</p>
 * <br>
 */
public class OnlineEcommerceAccountImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.foaf.OnlineEcommerceAccount {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI accountNameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/accountName");
	protected static final org.openanzo.rdf.URI accountServiceHomepageProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://xmlns.com/foaf/0.1/accountServiceHomepage");
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

	OnlineEcommerceAccountImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static OnlineEcommerceAccountImpl getOnlineEcommerceAccount(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, OnlineEcommerceAccount.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new OnlineEcommerceAccountImpl(resource, namedGraphUri, dataset);
	}
	    
	static OnlineEcommerceAccountImpl createOnlineEcommerceAccount(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		OnlineEcommerceAccountImpl impl = new OnlineEcommerceAccountImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, OnlineEcommerceAccount.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, OnlineEcommerceAccount.TYPE, namedGraphUri);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	void addSuperTypes() {
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.foaf.OnlineAccount.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.foaf.OnlineAccount.TYPE,_graph.getNamedGraphUri());     
	}
   
	void addHasValueValues() {
	}
   
	public java.util.Collection<org.openanzo.rdf.Statement> listStatements() {
		java.util.Collection<org.openanzo.rdf.Statement> list = new java.util.HashSet<org.openanzo.rdf.Statement>();
		
		list.addAll(_dataset.find(_resource, accountNameProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, accountServiceHomepageProperty, null, _graph.getNamedGraphUri()));
		
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
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.foaf.OnlineEcommerceAccount.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.foaf.OnlineAccount.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'accountName'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearAccountName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, accountNameProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/accountName


	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal> propertyCollectionAccountName = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.Literal>() {
		public org.openanzo.rdf.Literal getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return literal;
	
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://xmlns.com/foaf/0.1/accountName properties in OnlineEcommerceAccount model not a Literal",value);
				}
			}
	};

	public java.util.Collection<org.openanzo.rdf.Literal> getAccountName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionAccountName.getPropertyCollection(_dataset, _graph, _resource,accountNameProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Literal"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.Literal> getAccountName() throws org.openanzo.rdf.jastor.JastorException {
		return getAccountName(false);
	}

	public void addAccountName(org.openanzo.rdf.Literal accountName) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(accountName,"http://www.w3.org/2000/01/rdf-schema#Literal");
		//if (_dataset.contains(_resource, accountNameProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (accountName != null) {
			_dataset.add(_resource, accountNameProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeAccountName(org.openanzo.rdf.Literal accountName) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(accountName,"http://www.w3.org/2000/01/rdf-schema#Literal");
		if (!_dataset.contains(_resource, accountNameProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, accountNameProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'accountServiceHomepage'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearAccountServiceHomepage(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, accountServiceHomepageProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://xmlns.com/foaf/0.1/accountServiceHomepage

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Document> propertyCollectionAccountServiceHomepage = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.foaf.Document>() {
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
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getAccountServiceHomepage(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionAccountServiceHomepage.getPropertyCollection(_dataset, _graph, _resource,accountServiceHomepageProperty, org.openanzo.rdf.MemURI.create("http://xmlns.com/foaf/0.1/Document"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.foaf.Document  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.foaf.Document> getAccountServiceHomepage() throws org.openanzo.rdf.jastor.JastorException {
		return getAccountServiceHomepage(false);
	}

/**
     * 
     * @param accountServiceHomepage value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addAccountServiceHomepage(org.openanzo.ontologies.foaf.Document accountServiceHomepage) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, accountServiceHomepageProperty,accountServiceHomepage.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.foaf.Document addAccountServiceHomepage() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Document accountServiceHomepage = org.openanzo.ontologies.foaf.FOAFFactory.createDocument(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, accountServiceHomepageProperty,accountServiceHomepage.resource(),_graph.getNamedGraphUri());
		return accountServiceHomepage;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.foaf.Document addAccountServiceHomepage(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.foaf.Document accountServiceHomepage = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, accountServiceHomepageProperty,accountServiceHomepage.resource(),_graph.getNamedGraphUri());
		return accountServiceHomepage;
	}
	
	/**
	 * Remove object
	 * @param accountServiceHomepage object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeAccountServiceHomepage(org.openanzo.ontologies.foaf.Document accountServiceHomepage) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, accountServiceHomepageProperty, accountServiceHomepage.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, accountServiceHomepageProperty, accountServiceHomepage.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeAccountServiceHomepage(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, accountServiceHomepageProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, accountServiceHomepageProperty, resource,_graph.getNamedGraphUri());
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
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://xmlns.com/foaf/0.1/dnaChecksum properties in OnlineEcommerceAccount model not a Literal",value);
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
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://xmlns.com/foaf/0.1/nick properties in OnlineEcommerceAccount model not a Literal",value);
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
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://xmlns.com/foaf/0.1/title properties in OnlineEcommerceAccount model not a Literal",value);
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
  


	protected java.util.concurrent.CopyOnWriteArraySet<OnlineEcommerceAccountListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<OnlineEcommerceAccountListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof OnlineEcommerceAccountListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	OnlineEcommerceAccountListener list = (OnlineEcommerceAccountListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof OnlineEcommerceAccountListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		OnlineEcommerceAccountListener list = (OnlineEcommerceAccountListener)listener;
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
			if (statement.getPredicate().equals(accountNameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				for(OnlineEcommerceAccountListener listener : listeners){
					listener.accountNameAdded(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,literal);
				}			
			}
			if (statement.getPredicate().equals(accountServiceHomepageProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Document _accountServiceHomepage = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),dataset());
				if (_accountServiceHomepage != null) {
					for(OnlineEcommerceAccountListener listener : listeners){
						listener.accountServiceHomepageAdded(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,_accountServiceHomepage);
					}
				}			
			}
			if (statement.getPredicate().equals(depictionProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Image _depiction = org.openanzo.ontologies.foaf.FOAFFactory.getImage(resource,_graph.getNamedGraphUri(),dataset());
				if (_depiction != null) {
					for(OnlineEcommerceAccountListener listener : listeners){
						listener.depictionAdded(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,_depiction);
					}
				}			
			}
			if (statement.getPredicate().equals(fundedByProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _fundedBy = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_fundedBy != null) {
					for(OnlineEcommerceAccountListener listener : listeners){
						listener.fundedByAdded(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,_fundedBy);
					}
				}			
			}
			if (statement.getPredicate().equals(homepageProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Document _homepage = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),dataset());
				if (_homepage != null) {
					for(OnlineEcommerceAccountListener listener : listeners){
						listener.homepageAdded(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,_homepage);
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
					for(OnlineEcommerceAccountListener listener : listeners){
						listener.logoAdded(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,_logo);
					}
				}			
			}
			if (statement.getPredicate().equals(makerProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Agent _maker = org.openanzo.ontologies.foaf.FOAFFactory.getAgent(resource,_graph.getNamedGraphUri(),dataset());
				if (_maker != null) {
					for(OnlineEcommerceAccountListener listener : listeners){
						listener.makerAdded(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,_maker);
					}
				}			
			}
			if (statement.getPredicate().equals(pageProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Document _page = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),dataset());
				if (_page != null) {
					for(OnlineEcommerceAccountListener listener : listeners){
						listener.pageAdded(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,_page);
					}
				}			
			}
			if (statement.getPredicate().equals(themeProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _theme = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_theme != null) {
					for(OnlineEcommerceAccountListener listener : listeners){
						listener.themeAdded(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,_theme);
					}
				}			
			}
			if (statement.getPredicate().equals(dnaChecksumProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				for(OnlineEcommerceAccountListener listener : listeners){
					listener.dnaChecksumAdded(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,literal);
				}			
			}
			if (statement.getPredicate().equals(nickProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				for(OnlineEcommerceAccountListener listener : listeners){
					listener.nickAdded(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,literal);
				}			
			}
			if (statement.getPredicate().equals(titleProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				for(OnlineEcommerceAccountListener listener : listeners){
					listener.titleAdded(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,literal);
				}			
			}
			if (statement.getPredicate().equals(phoneProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _phone = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_phone != null) {
					for(OnlineEcommerceAccountListener listener : listeners){
						listener.phoneAdded(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,_phone);
					}
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(accountNameProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				for(OnlineEcommerceAccountListener listener:listeners){
					listener.accountNameRemoved(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,literal);
				}
				return;
			}
			if (statement.getPredicate().equals(accountServiceHomepageProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.foaf.Document _accountServiceHomepage = org.openanzo.ontologies.foaf.FOAFFactory.getDocument(resource,_graph.getNamedGraphUri(),dataset());
				if (_accountServiceHomepage != null) {
					for(OnlineEcommerceAccountListener listener : listeners){
						listener.accountServiceHomepageRemoved(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,_accountServiceHomepage);
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
					for(OnlineEcommerceAccountListener listener : listeners){
						listener.depictionRemoved(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,_depiction);
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
					for(OnlineEcommerceAccountListener listener : listeners){
						listener.fundedByRemoved(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,_fundedBy);
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
					for(OnlineEcommerceAccountListener listener : listeners){
						listener.homepageRemoved(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,_homepage);
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
					for(OnlineEcommerceAccountListener listener : listeners){
						listener.logoRemoved(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,_logo);
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
					for(OnlineEcommerceAccountListener listener : listeners){
						listener.makerRemoved(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,_maker);
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
					for(OnlineEcommerceAccountListener listener : listeners){
						listener.pageRemoved(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,_page);
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
					for(OnlineEcommerceAccountListener listener : listeners){
						listener.themeRemoved(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,_theme);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(dnaChecksumProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				for(OnlineEcommerceAccountListener listener:listeners){
					listener.dnaChecksumRemoved(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,literal);
				}
				return;
			}
			if (statement.getPredicate().equals(nickProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				for(OnlineEcommerceAccountListener listener:listeners){
					listener.nickRemoved(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,literal);
				}
				return;
			}
			if (statement.getPredicate().equals(titleProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				for(OnlineEcommerceAccountListener listener:listeners){
					listener.titleRemoved(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,literal);
				}
				return;
			}
			if (statement.getPredicate().equals(phoneProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _phone = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_phone != null) {
					for(OnlineEcommerceAccountListener listener : listeners){
						listener.phoneRemoved(org.openanzo.ontologies.foaf.OnlineEcommerceAccountImpl.this,_phone);
					}
				}
				return;
			}
		}
		}}
	}
	


}