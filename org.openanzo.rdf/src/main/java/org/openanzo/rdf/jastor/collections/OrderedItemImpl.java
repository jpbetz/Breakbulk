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
 * Implementation of {@link org.openanzo.rdf.jastor.collections.OrderedItem}
 * Use the org.openanzo.rdf.jastor.collections.CollectionsFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/Collections#OrderedItem)</p>
 * <br>
 */
public class OrderedItemImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.rdf.jastor.collections.OrderedItem {

	protected static final org.openanzo.rdf.URI nextItemProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Collections#nextItem");
	protected static final org.openanzo.rdf.URI previousItemProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Collections#previousItem");

	OrderedItemImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
	}   
	   
    	
	static OrderedItemImpl getOrderedItem(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, OrderedItem.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new OrderedItemImpl(resource, namedGraphUri, dataset);
	}
	    
	static OrderedItemImpl createOrderedItem(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		OrderedItemImpl impl = new OrderedItemImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, OrderedItem.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, OrderedItem.TYPE, namedGraphUri);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	void addSuperTypes() {
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.collections.Item.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.collections.Item.TYPE,_graph.getNamedGraphUri());     
	}
   
	void addHasValueValues() {
	}
   
	public java.util.Collection<org.openanzo.rdf.Statement> listStatements() {
		java.util.Collection<org.openanzo.rdf.Statement> list = new java.util.HashSet<org.openanzo.rdf.Statement>();
		
		list.addAll(_dataset.find(_resource, nextItemProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, previousItemProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.collections.OrderedItem.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.collections.Item.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'nextItem'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			OrderedItem#nextItemProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearNextItem(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, nextItemProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Collections#nextItem

	public org.openanzo.rdf.jastor.collections.OrderedItem getNextItem(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, nextItemProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": nextItem getProperty() in org.openanzo.rdf.jastor.collections.OrderedItem model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.jastor.collections.CollectionsFactory.getOrderedItem(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.jastor.collections.OrderedItem getNextItem() throws org.openanzo.rdf.jastor.JastorException {
		return getNextItem(false);
	}

	public void setNextItem(org.openanzo.rdf.jastor.collections.OrderedItem nextItem) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, nextItemProperty, null,_graph.getNamedGraphUri());
		if (nextItem != null) {
			_dataset.add(_resource, nextItemProperty, nextItem.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.jastor.collections.OrderedItem setNextItem() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, nextItemProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.jastor.collections.OrderedItem nextItem = org.openanzo.rdf.jastor.collections.CollectionsFactory.createOrderedItem(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, nextItemProperty, nextItem.resource(),_graph.getNamedGraphUri());
		return nextItem;
	}
	
	public org.openanzo.rdf.jastor.collections.OrderedItem setNextItem(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, nextItemProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, nextItemProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.jastor.collections.OrderedItem nextItem = org.openanzo.rdf.jastor.collections.CollectionsFactory.getOrderedItem(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, nextItemProperty, nextItem.resource(),_graph.getNamedGraphUri());
		return nextItem;
	}
	
	/**
	 * Clears all values for 'previousItem'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			OrderedItem#previousItemProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearPreviousItem(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, previousItemProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Collections#previousItem

	public org.openanzo.rdf.jastor.collections.OrderedItem getPreviousItem(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, previousItemProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": previousItem getProperty() in org.openanzo.rdf.jastor.collections.OrderedItem model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.jastor.collections.CollectionsFactory.getOrderedItem(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.jastor.collections.OrderedItem getPreviousItem() throws org.openanzo.rdf.jastor.JastorException {
		return getPreviousItem(false);
	}

	public void setPreviousItem(org.openanzo.rdf.jastor.collections.OrderedItem previousItem) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, previousItemProperty, null,_graph.getNamedGraphUri());
		if (previousItem != null) {
			_dataset.add(_resource, previousItemProperty, previousItem.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.jastor.collections.OrderedItem setPreviousItem() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, previousItemProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.jastor.collections.OrderedItem previousItem = org.openanzo.rdf.jastor.collections.CollectionsFactory.createOrderedItem(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, previousItemProperty, previousItem.resource(),_graph.getNamedGraphUri());
		return previousItem;
	}
	
	public org.openanzo.rdf.jastor.collections.OrderedItem setPreviousItem(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, previousItemProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, previousItemProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.jastor.collections.OrderedItem previousItem = org.openanzo.rdf.jastor.collections.CollectionsFactory.getOrderedItem(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, previousItemProperty, previousItem.resource(),_graph.getNamedGraphUri());
		return previousItem;
	}
	 




}