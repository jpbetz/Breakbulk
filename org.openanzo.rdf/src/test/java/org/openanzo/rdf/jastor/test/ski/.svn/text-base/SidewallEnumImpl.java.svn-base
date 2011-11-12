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
package org.openanzo.rdf.jastor.test.ski;

/**
 * Implementation of {@link org.openanzo.rdf.jastor.test.ski.SidewallEnum}
 * Use the org.openanzo.rdf.jastor.test.ski.SkiFactory to create instances of this class.
 * <p>(URI: http://jastor.openanzo.org/gen#SidewallEnum)</p>
 * <br>
 */
public class SidewallEnumImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.rdf.jastor.test.ski.SidewallEnum {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI isAlpineProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#isAlpine");
	protected static final org.openanzo.rdf.URI isFreestyleProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#isFreestyle");
	protected static final org.openanzo.rdf.URI preferredStanceProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#preferredStance");
	protected static final org.openanzo.rdf.URI complimentBoardProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#complimentBoard");

	SidewallEnumImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	
	private static java.util.Set<org.openanzo.rdf.Resource> oneOfClasses = new java.util.HashSet<org.openanzo.rdf.Resource>();
	static {
		oneOfClasses.add(Vertical);
		oneOfClasses.add(Cap);
		oneOfClasses.add(Angled);
	}   
    	
	static SidewallEnumImpl getSidewallEnum(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, SidewallEnum.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		if (!dataset.contains(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, SidewallEnum.TYPE, namedGraphUri))
			return null;
		return new SidewallEnumImpl(resource, namedGraphUri, dataset);
	}
	    
	static SidewallEnumImpl createSidewallEnum(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if (!oneOfClasses.contains(resource)) {
			throw new org.openanzo.rdf.jastor.JastorException("Resource " + resource + " not a member of enumeration class http://jastor.openanzo.org/gen#SidewallEnum"); 
		} 
		
		SidewallEnumImpl impl = new SidewallEnumImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, SidewallEnum.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, SidewallEnum.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, isAlpineProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, isFreestyleProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, preferredStanceProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, complimentBoardProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.test.ski.SidewallEnum.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'isAlpine'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearIsAlpine(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, isAlpineProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#isAlpine


	org.openanzo.rdf.jastor.PropertyCollection<java.lang.Boolean> propertyCollectionIsAlpine = new org.openanzo.rdf.jastor.PropertyCollection<java.lang.Boolean>() {
		public java.lang.Boolean getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://jastor.openanzo.org/testonts/predicates#isAlpine properties in SidewallEnum model not a Literal",value);
				}
			}
	};

	public java.util.Collection<java.lang.Boolean> getIsAlpine(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionIsAlpine.getPropertyCollection(_dataset, _graph, _resource,isAlpineProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#boolean"), includeEntireDataset);
	}
	
	public java.util.Collection<java.lang.Boolean> getIsAlpine() throws org.openanzo.rdf.jastor.JastorException {
		return getIsAlpine(false);
	}

	public void addIsAlpine(java.lang.Boolean isAlpine) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(isAlpine,"http://www.w3.org/2001/XMLSchema#boolean");
		//if (_dataset.contains(_resource, isAlpineProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (isAlpine != null) {
			_dataset.add(_resource, isAlpineProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeIsAlpine(java.lang.Boolean isAlpine) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(isAlpine,"http://www.w3.org/2001/XMLSchema#boolean");
		if (!_dataset.contains(_resource, isAlpineProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, isAlpineProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'isFreestyle'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearIsFreestyle(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, isFreestyleProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#isFreestyle

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing> propertyCollectionIsFreestyle = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing>() {
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
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getIsFreestyle(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionIsFreestyle.getPropertyCollection(_dataset, _graph, _resource,isFreestyleProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#boolean"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.rdf.jastor.Thing  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getIsFreestyle() throws org.openanzo.rdf.jastor.JastorException {
		return getIsFreestyle(false);
	}

/**
     * 
     * @param isFreestyle value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addIsFreestyle(org.openanzo.rdf.jastor.Thing isFreestyle) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, isFreestyleProperty,isFreestyle.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.rdf.jastor.Thing addIsFreestyle() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing isFreestyle = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, isFreestyleProperty,isFreestyle.resource(),_graph.getNamedGraphUri());
		return isFreestyle;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.rdf.jastor.Thing addIsFreestyle(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing isFreestyle = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, isFreestyleProperty,isFreestyle.resource(),_graph.getNamedGraphUri());
		return isFreestyle;
	}
	
	/**
	 * Remove object
	 * @param isFreestyle object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeIsFreestyle(org.openanzo.rdf.jastor.Thing isFreestyle) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, isFreestyleProperty, isFreestyle.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, isFreestyleProperty, isFreestyle.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeIsFreestyle(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, isFreestyleProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, isFreestyleProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'preferredStance'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearPreferredStance(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, preferredStanceProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#preferredStance


	org.openanzo.rdf.jastor.PropertyCollection<java.lang.String> propertyCollectionPreferredStance = new org.openanzo.rdf.jastor.PropertyCollection<java.lang.String>() {
		public java.lang.String getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://jastor.openanzo.org/testonts/predicates#preferredStance properties in SidewallEnum model not a Literal",value);
				}
			}
	};

	public java.util.Collection<java.lang.String> getPreferredStance(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionPreferredStance.getPropertyCollection(_dataset, _graph, _resource,preferredStanceProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#string"), includeEntireDataset);
	}
	
	public java.util.Collection<java.lang.String> getPreferredStance() throws org.openanzo.rdf.jastor.JastorException {
		return getPreferredStance(false);
	}

	public void addPreferredStance(java.lang.String preferredStance) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(preferredStance,"http://www.w3.org/2001/XMLSchema#string");
		//if (_dataset.contains(_resource, preferredStanceProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (preferredStance != null) {
			_dataset.add(_resource, preferredStanceProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removePreferredStance(java.lang.String preferredStance) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(preferredStance,"http://www.w3.org/2001/XMLSchema#string");
		if (!_dataset.contains(_resource, preferredStanceProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, preferredStanceProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'complimentBoard'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearComplimentBoard(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, complimentBoardProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#complimentBoard

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing> propertyCollectionComplimentBoard = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing>() {
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
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getComplimentBoard(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionComplimentBoard.getPropertyCollection(_dataset, _graph, _resource,complimentBoardProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Resource"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.rdf.jastor.Thing  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getComplimentBoard() throws org.openanzo.rdf.jastor.JastorException {
		return getComplimentBoard(false);
	}

/**
     * 
     * @param complimentBoard value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addComplimentBoard(org.openanzo.rdf.jastor.Thing complimentBoard) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, complimentBoardProperty,complimentBoard.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.rdf.jastor.Thing addComplimentBoard() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing complimentBoard = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, complimentBoardProperty,complimentBoard.resource(),_graph.getNamedGraphUri());
		return complimentBoard;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.rdf.jastor.Thing addComplimentBoard(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing complimentBoard = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, complimentBoardProperty,complimentBoard.resource(),_graph.getNamedGraphUri());
		return complimentBoard;
	}
	
	/**
	 * Remove object
	 * @param complimentBoard object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeComplimentBoard(org.openanzo.rdf.jastor.Thing complimentBoard) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, complimentBoardProperty, complimentBoard.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, complimentBoardProperty, complimentBoard.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeComplimentBoard(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, complimentBoardProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, complimentBoardProperty, resource,_graph.getNamedGraphUri());
	}
  


	protected java.util.concurrent.CopyOnWriteArraySet<SidewallEnumListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<SidewallEnumListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof SidewallEnumListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	SidewallEnumListener list = (SidewallEnumListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof SidewallEnumListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		SidewallEnumListener list = (SidewallEnumListener)listener;
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
			if (statement.getPredicate().equals(isAlpineProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.Boolean) {
					for(SidewallEnumListener listener : listeners){
						listener.isAlpineAdded(org.openanzo.rdf.jastor.test.ski.SidewallEnumImpl.this,(java.lang.Boolean)obj);
					}
				}			
			}
			if (statement.getPredicate().equals(isFreestyleProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _isFreestyle = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_isFreestyle != null) {
					for(SidewallEnumListener listener : listeners){
						listener.isFreestyleAdded(org.openanzo.rdf.jastor.test.ski.SidewallEnumImpl.this,_isFreestyle);
					}
				}			
			}
			if (statement.getPredicate().equals(preferredStanceProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.String) {
					for(SidewallEnumListener listener : listeners){
						listener.preferredStanceAdded(org.openanzo.rdf.jastor.test.ski.SidewallEnumImpl.this,(java.lang.String)obj);
					}
				}			
			}
			if (statement.getPredicate().equals(complimentBoardProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _complimentBoard = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_complimentBoard != null) {
					for(SidewallEnumListener listener : listeners){
						listener.complimentBoardAdded(org.openanzo.rdf.jastor.test.ski.SidewallEnumImpl.this,_complimentBoard);
					}
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(isAlpineProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.Boolean) {
					for(SidewallEnumListener listener : listeners){
						listener.isAlpineRemoved(org.openanzo.rdf.jastor.test.ski.SidewallEnumImpl.this,(java.lang.Boolean)obj);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(isFreestyleProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _isFreestyle = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_isFreestyle != null) {
					for(SidewallEnumListener listener : listeners){
						listener.isFreestyleRemoved(org.openanzo.rdf.jastor.test.ski.SidewallEnumImpl.this,_isFreestyle);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(preferredStanceProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.String) {
					for(SidewallEnumListener listener : listeners){
						listener.preferredStanceRemoved(org.openanzo.rdf.jastor.test.ski.SidewallEnumImpl.this,(java.lang.String)obj);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(complimentBoardProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _complimentBoard = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_complimentBoard != null) {
					for(SidewallEnumListener listener : listeners){
						listener.complimentBoardRemoved(org.openanzo.rdf.jastor.test.ski.SidewallEnumImpl.this,_complimentBoard);
					}
				}
				return;
			}
		}
		}}
	}
	


}