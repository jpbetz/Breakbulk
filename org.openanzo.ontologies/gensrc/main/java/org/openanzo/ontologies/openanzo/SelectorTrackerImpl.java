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
package org.openanzo.ontologies.openanzo;

/**
 * Implementation of {@link org.openanzo.ontologies.openanzo.SelectorTracker}
 * Use the org.openanzo.ontologies.openanzo.AnzoFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/Anzo#SelectorTracker)</p>
 * <br>
 */
public class SelectorTrackerImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.openanzo.SelectorTracker {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI namedGraphUriProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#namedGraphUri");
	protected static final org.openanzo.rdf.URI objectProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#object");
	protected static final org.openanzo.rdf.URI predicateProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#predicate");
	protected static final org.openanzo.rdf.URI subjectProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#subject");

	SelectorTrackerImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static SelectorTrackerImpl getSelectorTracker(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, SelectorTracker.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new SelectorTrackerImpl(resource, namedGraphUri, dataset);
	}
	    
	static SelectorTrackerImpl createSelectorTracker(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		SelectorTrackerImpl impl = new SelectorTrackerImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, SelectorTracker.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, SelectorTracker.TYPE, namedGraphUri);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	void addSuperTypes() {
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.openanzo.Tracker.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.openanzo.Tracker.TYPE,_graph.getNamedGraphUri());     
	}
   
	void addHasValueValues() {
	}
   
	public java.util.Collection<org.openanzo.rdf.Statement> listStatements() {
		java.util.Collection<org.openanzo.rdf.Statement> list = new java.util.HashSet<org.openanzo.rdf.Statement>();
		
		list.addAll(_dataset.find(_resource, namedGraphUriProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, objectProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, predicateProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, subjectProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.openanzo.SelectorTracker.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.openanzo.Tracker.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'namedGraphUri'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearNamedGraphUri(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, namedGraphUriProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#namedGraphUri


	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.URI> propertyCollectionNamedGraphUri = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.URI>() {
		public org.openanzo.rdf.URI getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.URI){ 
					return (org.openanzo.rdf.URI)value;
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://openanzo.org/ontologies/2008/07/Anzo#namedGraphUri properties in SelectorTracker model not a Literal",value);
				}
			}
	};

	public java.util.Collection<org.openanzo.rdf.URI> getNamedGraphUri(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionNamedGraphUri.getPropertyCollection(_dataset, _graph, _resource,namedGraphUriProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#anyURI"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.URI> getNamedGraphUri() throws org.openanzo.rdf.jastor.JastorException {
		return getNamedGraphUri(false);
	}

	public void addNamedGraphUri(org.openanzo.rdf.URI namedGraphUri) throws org.openanzo.rdf.jastor.JastorException {
	
		//if (_dataset.contains(_resource, namedGraphUriProperty,namedGraphUri,_graph.getNamedGraphUri()))
		//	return;
		_dataset.add(_resource, namedGraphUriProperty, namedGraphUri,_graph.getNamedGraphUri());
	
	}
	
	public void removeNamedGraphUri(org.openanzo.rdf.URI namedGraphUri) throws org.openanzo.rdf.jastor.JastorException {
		
		if (!_dataset.contains(_resource, namedGraphUriProperty, namedGraphUri,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, namedGraphUriProperty, namedGraphUri,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'object'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearObject(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, objectProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#object


	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.URI> propertyCollectionObject = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.URI>() {
		public org.openanzo.rdf.URI getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.URI){ 
					return (org.openanzo.rdf.URI)value;
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://openanzo.org/ontologies/2008/07/Anzo#object properties in SelectorTracker model not a Literal",value);
				}
			}
	};

	public java.util.Collection<org.openanzo.rdf.URI> getObject(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionObject.getPropertyCollection(_dataset, _graph, _resource,objectProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#anyURI"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.URI> getObject() throws org.openanzo.rdf.jastor.JastorException {
		return getObject(false);
	}

	public void addObject(org.openanzo.rdf.URI object) throws org.openanzo.rdf.jastor.JastorException {
	
		//if (_dataset.contains(_resource, objectProperty,object,_graph.getNamedGraphUri()))
		//	return;
		_dataset.add(_resource, objectProperty, object,_graph.getNamedGraphUri());
	
	}
	
	public void removeObject(org.openanzo.rdf.URI object) throws org.openanzo.rdf.jastor.JastorException {
		
		if (!_dataset.contains(_resource, objectProperty, object,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, objectProperty, object,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'predicate'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearPredicate(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, predicateProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#predicate


	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.URI> propertyCollectionPredicate = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.URI>() {
		public org.openanzo.rdf.URI getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.URI){ 
					return (org.openanzo.rdf.URI)value;
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://openanzo.org/ontologies/2008/07/Anzo#predicate properties in SelectorTracker model not a Literal",value);
				}
			}
	};

	public java.util.Collection<org.openanzo.rdf.URI> getPredicate(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionPredicate.getPropertyCollection(_dataset, _graph, _resource,predicateProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#anyURI"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.URI> getPredicate() throws org.openanzo.rdf.jastor.JastorException {
		return getPredicate(false);
	}

	public void addPredicate(org.openanzo.rdf.URI predicate) throws org.openanzo.rdf.jastor.JastorException {
	
		//if (_dataset.contains(_resource, predicateProperty,predicate,_graph.getNamedGraphUri()))
		//	return;
		_dataset.add(_resource, predicateProperty, predicate,_graph.getNamedGraphUri());
	
	}
	
	public void removePredicate(org.openanzo.rdf.URI predicate) throws org.openanzo.rdf.jastor.JastorException {
		
		if (!_dataset.contains(_resource, predicateProperty, predicate,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, predicateProperty, predicate,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'subject'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearSubject(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, subjectProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#subject


	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.URI> propertyCollectionSubject = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.URI>() {
		public org.openanzo.rdf.URI getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.URI){ 
					return (org.openanzo.rdf.URI)value;
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://openanzo.org/ontologies/2008/07/Anzo#subject properties in SelectorTracker model not a Literal",value);
				}
			}
	};

	public java.util.Collection<org.openanzo.rdf.URI> getSubject(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionSubject.getPropertyCollection(_dataset, _graph, _resource,subjectProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#anyURI"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.URI> getSubject() throws org.openanzo.rdf.jastor.JastorException {
		return getSubject(false);
	}

	public void addSubject(org.openanzo.rdf.URI subject) throws org.openanzo.rdf.jastor.JastorException {
	
		//if (_dataset.contains(_resource, subjectProperty,subject,_graph.getNamedGraphUri()))
		//	return;
		_dataset.add(_resource, subjectProperty, subject,_graph.getNamedGraphUri());
	
	}
	
	public void removeSubject(org.openanzo.rdf.URI subject) throws org.openanzo.rdf.jastor.JastorException {
		
		if (!_dataset.contains(_resource, subjectProperty, subject,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, subjectProperty, subject,_graph.getNamedGraphUri());
		
	}
 


	protected java.util.concurrent.CopyOnWriteArraySet<SelectorTrackerListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<SelectorTrackerListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof SelectorTrackerListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	SelectorTrackerListener list = (SelectorTrackerListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof SelectorTrackerListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		SelectorTrackerListener list = (SelectorTrackerListener)listener;
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
			if (statement.getPredicate().equals(namedGraphUriProperty)) {
			if (statement.getObject() instanceof org.openanzo.rdf.URI) {
					for(SelectorTrackerListener listener : listeners){
						listener.namedGraphUriAdded(org.openanzo.ontologies.openanzo.SelectorTrackerImpl.this,(org.openanzo.rdf.URI)statement.getObject());
					}
				}			
			}
			if (statement.getPredicate().equals(objectProperty)) {
			if (statement.getObject() instanceof org.openanzo.rdf.URI) {
					for(SelectorTrackerListener listener : listeners){
						listener.objectAdded(org.openanzo.ontologies.openanzo.SelectorTrackerImpl.this,(org.openanzo.rdf.URI)statement.getObject());
					}
				}			
			}
			if (statement.getPredicate().equals(predicateProperty)) {
			if (statement.getObject() instanceof org.openanzo.rdf.URI) {
					for(SelectorTrackerListener listener : listeners){
						listener.predicateAdded(org.openanzo.ontologies.openanzo.SelectorTrackerImpl.this,(org.openanzo.rdf.URI)statement.getObject());
					}
				}			
			}
			if (statement.getPredicate().equals(subjectProperty)) {
			if (statement.getObject() instanceof org.openanzo.rdf.URI) {
					for(SelectorTrackerListener listener : listeners){
						listener.subjectAdded(org.openanzo.ontologies.openanzo.SelectorTrackerImpl.this,(org.openanzo.rdf.URI)statement.getObject());
					}
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(namedGraphUriProperty)) {
			if (statement.getObject() instanceof org.openanzo.rdf.URI) {
					for(SelectorTrackerListener listener : listeners){
						listener.namedGraphUriAdded(org.openanzo.ontologies.openanzo.SelectorTrackerImpl.this,(org.openanzo.rdf.URI)statement.getObject());
					}
				}
				return;
			}
			if (statement.getPredicate().equals(objectProperty)) {
			if (statement.getObject() instanceof org.openanzo.rdf.URI) {
					for(SelectorTrackerListener listener : listeners){
						listener.objectAdded(org.openanzo.ontologies.openanzo.SelectorTrackerImpl.this,(org.openanzo.rdf.URI)statement.getObject());
					}
				}
				return;
			}
			if (statement.getPredicate().equals(predicateProperty)) {
			if (statement.getObject() instanceof org.openanzo.rdf.URI) {
					for(SelectorTrackerListener listener : listeners){
						listener.predicateAdded(org.openanzo.ontologies.openanzo.SelectorTrackerImpl.this,(org.openanzo.rdf.URI)statement.getObject());
					}
				}
				return;
			}
			if (statement.getPredicate().equals(subjectProperty)) {
			if (statement.getObject() instanceof org.openanzo.rdf.URI) {
					for(SelectorTrackerListener listener : listeners){
						listener.subjectAdded(org.openanzo.ontologies.openanzo.SelectorTrackerImpl.this,(org.openanzo.rdf.URI)statement.getObject());
					}
				}
				return;
			}
		}
		}}
	}
	


}