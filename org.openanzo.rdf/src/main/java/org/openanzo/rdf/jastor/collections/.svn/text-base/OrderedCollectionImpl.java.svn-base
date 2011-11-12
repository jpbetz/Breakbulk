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
 * Implementation of {@link org.openanzo.rdf.jastor.collections.OrderedCollection}
 * Use the org.openanzo.rdf.jastor.collections.CollectionsFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/Collections#OrderedCollection)</p>
 * <br>
 */
public class OrderedCollectionImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.rdf.jastor.collections.OrderedCollection {

	protected static final org.openanzo.rdf.URI itemProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Collections#item");
	protected static final org.openanzo.rdf.URI collectionSizeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Collections#collectionSize");
	protected static final org.openanzo.rdf.URI firstItemProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Collections#firstItem");

	OrderedCollectionImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
	}   
	   
    	
	static OrderedCollectionImpl getOrderedCollection(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, OrderedCollection.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new OrderedCollectionImpl(resource, namedGraphUri, dataset);
	}
	    
	static OrderedCollectionImpl createOrderedCollection(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		OrderedCollectionImpl impl = new OrderedCollectionImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, OrderedCollection.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, OrderedCollection.TYPE, namedGraphUri);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	void addSuperTypes() {
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.collections.Collection.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.collections.Collection.TYPE,_graph.getNamedGraphUri());     
	}
   
	void addHasValueValues() {
	}
   
	public java.util.Collection<org.openanzo.rdf.Statement> listStatements() {
		java.util.Collection<org.openanzo.rdf.Statement> list = new java.util.HashSet<org.openanzo.rdf.Statement>();
		
		list.addAll(_dataset.find(_resource, itemProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, collectionSizeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, firstItemProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.collections.OrderedCollection.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.collections.Collection.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'item'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			OrderedCollection#itemProperty
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
 
	/**
	 * Clears all values for 'collectionSize'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			OrderedCollection#collectionSizeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearCollectionSize(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, collectionSizeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Collections#collectionSize
	public java.lang.Integer getCollectionSize(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, collectionSizeProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": collectionSize getProperty() in org.openanzo.rdf.jastor.collections.OrderedCollection model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#int");
		if (!(obj instanceof java.lang.Integer))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal collectionSize in OrderedCollection is not of type java.lang.Integer", literal);
		return (java.lang.Integer)obj;
		
	}
	
	public java.lang.Integer getCollectionSize() throws org.openanzo.rdf.jastor.JastorException {
		return getCollectionSize(false);
	}
	
	public void setCollectionSize(java.lang.Integer collectionSize) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, collectionSizeProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (collectionSize != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(collectionSize,"http://www.w3.org/2001/XMLSchema#int");
			_dataset.add(_resource, collectionSizeProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'firstItem'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			OrderedCollection#firstItemProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearFirstItem(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, firstItemProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Collections#firstItem

	public org.openanzo.rdf.jastor.collections.OrderedItem getFirstItem(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, firstItemProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": firstItem getProperty() in org.openanzo.rdf.jastor.collections.OrderedCollection model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.jastor.collections.CollectionsFactory.getOrderedItem(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.jastor.collections.OrderedItem getFirstItem() throws org.openanzo.rdf.jastor.JastorException {
		return getFirstItem(false);
	}

	public void setFirstItem(org.openanzo.rdf.jastor.collections.OrderedItem firstItem) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, firstItemProperty, null,_graph.getNamedGraphUri());
		if (firstItem != null) {
			_dataset.add(_resource, firstItemProperty, firstItem.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.jastor.collections.OrderedItem setFirstItem() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, firstItemProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.jastor.collections.OrderedItem firstItem = org.openanzo.rdf.jastor.collections.CollectionsFactory.createOrderedItem(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, firstItemProperty, firstItem.resource(),_graph.getNamedGraphUri());
		return firstItem;
	}
	
	public org.openanzo.rdf.jastor.collections.OrderedItem setFirstItem(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, firstItemProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, firstItemProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.jastor.collections.OrderedItem firstItem = org.openanzo.rdf.jastor.collections.CollectionsFactory.getOrderedItem(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, firstItemProperty, firstItem.resource(),_graph.getNamedGraphUri());
		return firstItem;
	}
	 




}