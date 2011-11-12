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
package org.openanzo.rdf.jastor.collections;

/**
 * Implementation of {@link org.openanzo.rdf.jastor.collections.Collection}
 * Use the org.openanzo.rdf.jastor.collections.CollectionsFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/Collections#Collection)</p>
 * <br>
 */
public class CollectionImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.rdf.jastor.collections.Collection {

	protected static final org.openanzo.rdf.URI itemProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Collections#item");

	CollectionImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
	}   
	   
    	
	static CollectionImpl getCollection(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Collection.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new CollectionImpl(resource, namedGraphUri, dataset);
	}
	    
	static CollectionImpl createCollection(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		CollectionImpl impl = new CollectionImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Collection.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Collection.TYPE, namedGraphUri);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	void addSuperTypes() {
	}
   
	void addHasValueValues() {
	}
   
	public java.util.Collection<org.openanzo.rdf.Statement> listStatements() {
		java.util.Collection<org.openanzo.rdf.Statement> list = new java.util.HashSet<org.openanzo.rdf.Statement>();
		
		list.addAll(_dataset.find(_resource, itemProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.collections.Collection.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'item'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			Collection#itemProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearItem(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, itemProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Collections#item

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.collections.Item> propertyCollectionItem = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.collections.Item>() {
		public org.openanzo.rdf.jastor.collections.Item getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.jastor.collections.CollectionsFactory.getItem((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.jastor.collections.Item> getItem(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionItem.getPropertyCollection(_dataset, _graph, _resource,itemProperty, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Collections#Item"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.jastor.collections.Item> getItem() throws org.openanzo.rdf.jastor.JastorException {
		return getItem(false);
	}

	public void addItem(org.openanzo.rdf.jastor.collections.Item item) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, itemProperty,item.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.jastor.collections.Item addItem() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.collections.Item item = org.openanzo.rdf.jastor.collections.CollectionsFactory.createItem(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, itemProperty,item.resource(),_graph.getNamedGraphUri());
		return item;
	}
	
	public org.openanzo.rdf.jastor.collections.Item addItem(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.collections.Item item = org.openanzo.rdf.jastor.collections.CollectionsFactory.getItem(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, itemProperty,item.resource(),_graph.getNamedGraphUri());
		return item;
	}
	
	public void removeItem(org.openanzo.rdf.jastor.collections.Item item) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, itemProperty, item.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, itemProperty, item.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeItem(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, itemProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, itemProperty, resource,_graph.getNamedGraphUri());
	}
  




}