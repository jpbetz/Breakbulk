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
package org.openanzo.ontologies.execution;

/**
 * Implementation of {@link org.openanzo.ontologies.execution.JavascriptSemanticService}
 * Use the org.openanzo.ontologies.execution.SemanticServiceFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/SemanticService#JavascriptSemanticService)</p>
 * <br>
 */
public class JavascriptSemanticServiceImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.execution.JavascriptSemanticService {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI serviceUserProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/SemanticService#serviceUser");
	protected static final org.openanzo.rdf.URI operationProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/SemanticService#operation");
	protected static final org.openanzo.rdf.URI stateStyleProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/SemanticService#stateStyle");
	protected static final org.openanzo.rdf.URI scriptResourceProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/SemanticService#scriptResource");
	protected static final org.openanzo.rdf.URI scriptLocationProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/SemanticService#scriptLocation");

	JavascriptSemanticServiceImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static JavascriptSemanticServiceImpl getJavascriptSemanticService(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, JavascriptSemanticService.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new JavascriptSemanticServiceImpl(resource, namedGraphUri, dataset);
	}
	    
	static JavascriptSemanticServiceImpl createJavascriptSemanticService(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		JavascriptSemanticServiceImpl impl = new JavascriptSemanticServiceImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, JavascriptSemanticService.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, JavascriptSemanticService.TYPE, namedGraphUri);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	void addSuperTypes() {
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.execution.SemanticService.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.execution.SemanticService.TYPE,_graph.getNamedGraphUri());     
	}
   
	void addHasValueValues() {
	}
   
	public java.util.Collection<org.openanzo.rdf.Statement> listStatements() {
		java.util.Collection<org.openanzo.rdf.Statement> list = new java.util.HashSet<org.openanzo.rdf.Statement>();
		
		list.addAll(_dataset.find(_resource, serviceUserProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, operationProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, stateStyleProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, scriptResourceProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, scriptLocationProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.execution.JavascriptSemanticService.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.execution.SemanticService.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'serviceUser'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearServiceUser(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, serviceUserProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/SemanticService#serviceUser
	public java.lang.String getServiceUser(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, serviceUserProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": serviceUser getProperty() in org.openanzo.ontologies.execution.JavascriptSemanticService model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal serviceUser in JavascriptSemanticService is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getServiceUser() throws org.openanzo.rdf.jastor.JastorException {
		return getServiceUser(false);
	}
	
	public void setServiceUser(java.lang.String serviceUser) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, serviceUserProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (serviceUser != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(serviceUser,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, serviceUserProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'operation'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearOperation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, operationProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/SemanticService#operation

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.execution.SemanticOperation> propertyCollectionOperation = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.execution.SemanticOperation>() {
		public org.openanzo.ontologies.execution.SemanticOperation getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.execution.SemanticServiceFactory.getSemanticOperation((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.execution.SemanticOperation 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.execution.SemanticOperation> getOperation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionOperation.getPropertyCollection(_dataset, _graph, _resource,operationProperty, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/SemanticService#SemanticOperation"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.execution.SemanticOperation  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.execution.SemanticOperation> getOperation() throws org.openanzo.rdf.jastor.JastorException {
		return getOperation(false);
	}

/**
     * 
     * @param operation value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addOperation(org.openanzo.ontologies.execution.SemanticOperation operation) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, operationProperty,operation.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.execution.SemanticOperation addOperation() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.execution.SemanticOperation operation = org.openanzo.ontologies.execution.SemanticServiceFactory.createSemanticOperation(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, operationProperty,operation.resource(),_graph.getNamedGraphUri());
		return operation;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.execution.SemanticOperation addOperation(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.execution.SemanticOperation operation = org.openanzo.ontologies.execution.SemanticServiceFactory.getSemanticOperation(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, operationProperty,operation.resource(),_graph.getNamedGraphUri());
		return operation;
	}
	
	/**
	 * Remove object
	 * @param operation object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeOperation(org.openanzo.ontologies.execution.SemanticOperation operation) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, operationProperty, operation.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, operationProperty, operation.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeOperation(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, operationProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, operationProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'stateStyle'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearStateStyle(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, stateStyleProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/SemanticService#stateStyle

	public org.openanzo.ontologies.execution.StateStyleEnum getStateStyle(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, stateStyleProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": stateStyle getProperty() in org.openanzo.ontologies.execution.JavascriptSemanticService model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.execution.SemanticServiceFactory.getStateStyleEnum(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.execution.StateStyleEnum getStateStyle() throws org.openanzo.rdf.jastor.JastorException {
		return getStateStyle(false);
	}

	public void setStateStyle(org.openanzo.ontologies.execution.StateStyleEnum stateStyle) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, stateStyleProperty, null,_graph.getNamedGraphUri());
		if (stateStyle != null) {
			_dataset.add(_resource, stateStyleProperty, stateStyle.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.execution.StateStyleEnum setStateStyle() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, stateStyleProperty, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.execution.StateStyleEnum stateStyle = org.openanzo.ontologies.execution.SemanticServiceFactory.createStateStyleEnum(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, stateStyleProperty, stateStyle.resource(),_graph.getNamedGraphUri());
		return stateStyle;
	}
	
	public org.openanzo.ontologies.execution.StateStyleEnum setStateStyle(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, stateStyleProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, stateStyleProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.execution.StateStyleEnum stateStyle = org.openanzo.ontologies.execution.SemanticServiceFactory.getStateStyleEnum(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, stateStyleProperty, stateStyle.resource(),_graph.getNamedGraphUri());
		return stateStyle;
	}
	
	/**
	 * Clears all values for 'scriptResource'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearScriptResource(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, scriptResourceProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/SemanticService#scriptResource
	public java.lang.String getScriptResource(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, scriptResourceProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": scriptResource getProperty() in org.openanzo.ontologies.execution.JavascriptSemanticService model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal scriptResource in JavascriptSemanticService is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getScriptResource() throws org.openanzo.rdf.jastor.JastorException {
		return getScriptResource(false);
	}
	
	public void setScriptResource(java.lang.String scriptResource) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, scriptResourceProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (scriptResource != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(scriptResource,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, scriptResourceProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'scriptLocation'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearScriptLocation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, scriptLocationProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/SemanticService#scriptLocation

	public org.openanzo.rdf.jastor.Thing getScriptLocation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, scriptLocationProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": scriptLocation getProperty() in org.openanzo.ontologies.execution.JavascriptSemanticService model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.jastor.ThingFactory.getThing(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.jastor.Thing getScriptLocation() throws org.openanzo.rdf.jastor.JastorException {
		return getScriptLocation(false);
	}

	public void setScriptLocation(org.openanzo.rdf.jastor.Thing scriptLocation) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, scriptLocationProperty, null,_graph.getNamedGraphUri());
		if (scriptLocation != null) {
			_dataset.add(_resource, scriptLocationProperty, scriptLocation.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.jastor.Thing setScriptLocation() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, scriptLocationProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.jastor.Thing scriptLocation = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, scriptLocationProperty, scriptLocation.resource(),_graph.getNamedGraphUri());
		return scriptLocation;
	}
	
	public org.openanzo.rdf.jastor.Thing setScriptLocation(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, scriptLocationProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, scriptLocationProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.jastor.Thing scriptLocation = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, scriptLocationProperty, scriptLocation.resource(),_graph.getNamedGraphUri());
		return scriptLocation;
	}
	 


	protected java.util.concurrent.CopyOnWriteArraySet<JavascriptSemanticServiceListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<JavascriptSemanticServiceListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof JavascriptSemanticServiceListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	JavascriptSemanticServiceListener list = (JavascriptSemanticServiceListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof JavascriptSemanticServiceListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		JavascriptSemanticServiceListener list = (JavascriptSemanticServiceListener)listener;
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
			if (statement.getPredicate().equals(serviceUserProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(JavascriptSemanticServiceListener listener : listeners){
					listener.serviceUserChanged(org.openanzo.ontologies.execution.JavascriptSemanticServiceImpl.this);
				}			
			}
			if (statement.getPredicate().equals(operationProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.execution.SemanticOperation _operation = org.openanzo.ontologies.execution.SemanticServiceFactory.getSemanticOperation(resource,_graph.getNamedGraphUri(),dataset());
				if (_operation != null) {
					for(JavascriptSemanticServiceListener listener : listeners){
						listener.operationAdded(org.openanzo.ontologies.execution.JavascriptSemanticServiceImpl.this,_operation);
					}
				}			
			}
			if (statement.getPredicate().equals(stateStyleProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(JavascriptSemanticServiceListener listener : listeners){
					listener.stateStyleChanged(org.openanzo.ontologies.execution.JavascriptSemanticServiceImpl.this);
				}			
			}
			if (statement.getPredicate().equals(scriptResourceProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(JavascriptSemanticServiceListener listener : listeners){
					listener.scriptResourceChanged(org.openanzo.ontologies.execution.JavascriptSemanticServiceImpl.this);
				}			
			}
			if (statement.getPredicate().equals(scriptLocationProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(JavascriptSemanticServiceListener listener : listeners){
					listener.scriptLocationChanged(org.openanzo.ontologies.execution.JavascriptSemanticServiceImpl.this);
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(serviceUserProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(JavascriptSemanticServiceListener listener : listeners) {
					listener.serviceUserChanged(org.openanzo.ontologies.execution.JavascriptSemanticServiceImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(operationProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.execution.SemanticOperation _operation = org.openanzo.ontologies.execution.SemanticServiceFactory.getSemanticOperation(resource,_graph.getNamedGraphUri(),dataset());
				if (_operation != null) {
					for(JavascriptSemanticServiceListener listener : listeners){
						listener.operationRemoved(org.openanzo.ontologies.execution.JavascriptSemanticServiceImpl.this,_operation);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(stateStyleProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(JavascriptSemanticServiceListener listener : listeners){
					listener.stateStyleChanged(org.openanzo.ontologies.execution.JavascriptSemanticServiceImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(scriptResourceProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(JavascriptSemanticServiceListener listener : listeners) {
					listener.scriptResourceChanged(org.openanzo.ontologies.execution.JavascriptSemanticServiceImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(scriptLocationProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(JavascriptSemanticServiceListener listener : listeners){
					listener.scriptLocationChanged(org.openanzo.ontologies.execution.JavascriptSemanticServiceImpl.this);
				}
				return;
			}
		}
		}}
	}
	


}