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
 * Implementation of {@link org.openanzo.rdf.jastor.test.ski.Snowboard}
 * Use the org.openanzo.rdf.jastor.test.ski.SkiFactory to create instances of this class.
 * <p>(URI: http://jastor.openanzo.org/testonts/classes#Snowboard)</p>
 * <br>
 */
public class SnowboardImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.rdf.jastor.test.ski.Snowboard {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI complimentBoardProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#complimentBoard");
	protected static final org.openanzo.rdf.URI preferredStanceProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#preferredStance");
	protected static final org.openanzo.rdf.URI isAlpineProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#isAlpine");
	protected static final org.openanzo.rdf.URI designerProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#designer");
	protected static final org.openanzo.rdf.URI availableBoardLengthProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#availableBoardLength");
	protected static final org.openanzo.rdf.URI extensionXMLProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#extensionXML");
	protected static final org.openanzo.rdf.URI isFreestyleProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#isFreestyle");

	SnowboardImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static SnowboardImpl getSnowboard(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Snowboard.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		if (!dataset.contains(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Snowboard.TYPE, namedGraphUri))
			return null;
		return new SnowboardImpl(resource, namedGraphUri, dataset);
	}
	    
	static SnowboardImpl createSnowboard(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		SnowboardImpl impl = new SnowboardImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Snowboard.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Snowboard.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, complimentBoardProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, preferredStanceProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, isAlpineProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, designerProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, availableBoardLengthProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, extensionXMLProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, isFreestyleProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.test.ski.Snowboard.TYPE, _graph.getNamedGraphUri()));
		return list;
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
// generating range: http://jastor.openanzo.org/testonts/classes#Snowboard

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.test.ski.Snowboard> propertyCollectionComplimentBoard_asSnowboard = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.test.ski.Snowboard>() {
		public org.openanzo.rdf.jastor.test.ski.Snowboard getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.jastor.test.ski.SkiFactory.getSnowboard((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.rdf.jastor.test.ski.Snowboard 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.test.ski.Snowboard> getComplimentBoard_asSnowboard(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionComplimentBoard_asSnowboard.getPropertyCollection(_dataset, _graph, _resource,complimentBoardProperty, org.openanzo.rdf.MemURI.create("http://jastor.openanzo.org/testonts/classes#Snowboard"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.rdf.jastor.test.ski.Snowboard  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.test.ski.Snowboard> getComplimentBoard_asSnowboard() throws org.openanzo.rdf.jastor.JastorException {
		return getComplimentBoard_asSnowboard(false);
	}

/**
     * 
     * @param complimentBoard value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addComplimentBoard(org.openanzo.rdf.jastor.test.ski.Snowboard complimentBoard) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, complimentBoardProperty,complimentBoard.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.rdf.jastor.test.ski.Snowboard addComplimentBoard_asSnowboard() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.test.ski.Snowboard complimentBoard = org.openanzo.rdf.jastor.test.ski.SkiFactory.createSnowboard(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, complimentBoardProperty,complimentBoard.resource(),_graph.getNamedGraphUri());
		return complimentBoard;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.rdf.jastor.test.ski.Snowboard addComplimentBoard_asSnowboard(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(resource, org.openanzo.rdf.vocabulary.RDF.TYPE,org.openanzo.rdf.jastor.test.ski.Snowboard.TYPE,_graph.getNamedGraphUri()))
			throw new org.openanzo.rdf.jastor.JastorException("Resource " + resource + " not of type " + org.openanzo.rdf.jastor.test.ski.Snowboard.TYPE);
		org.openanzo.rdf.jastor.test.ski.Snowboard complimentBoard = org.openanzo.rdf.jastor.test.ski.SkiFactory.getSnowboard(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, complimentBoardProperty,complimentBoard.resource(),_graph.getNamedGraphUri());
		return complimentBoard;
	}
	
	/**
	 * Remove object
	 * @param complimentBoard object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeComplimentBoard(org.openanzo.rdf.jastor.test.ski.Snowboard complimentBoard) throws org.openanzo.rdf.jastor.JastorException {
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
	public java.lang.String getPreferredStance(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, preferredStanceProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": preferredStance getProperty() in org.openanzo.rdf.jastor.test.ski.Snowboard model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal preferredStance in Snowboard is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getPreferredStance() throws org.openanzo.rdf.jastor.JastorException {
		return getPreferredStance(false);
	}
	
	public void setPreferredStance(java.lang.String preferredStance) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, preferredStanceProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (preferredStance != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(preferredStance,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, preferredStanceProperty, _literal,_graph.getNamedGraphUri());
	
		}	
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
	public java.lang.Boolean getIsAlpine(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, isAlpineProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": isAlpine getProperty() in org.openanzo.rdf.jastor.test.ski.Snowboard model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal isAlpine in Snowboard is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getIsAlpine() throws org.openanzo.rdf.jastor.JastorException {
		return getIsAlpine(false);
	}
	
	public void setIsAlpine(java.lang.Boolean isAlpine) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, isAlpineProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (isAlpine != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(isAlpine,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, isAlpineProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'designer'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDesigner(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, designerProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#designer

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.test.ski.Ski> propertyCollectionDesigner = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.test.ski.Ski>() {
		public org.openanzo.rdf.jastor.test.ski.Ski getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.jastor.test.ski.SkiFactory.getSki((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.rdf.jastor.test.ski.Ski 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.test.ski.Ski> getDesigner(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionDesigner.getPropertyCollection(_dataset, _graph, _resource,designerProperty, org.openanzo.rdf.MemURI.create("http://jastor.openanzo.org/testonts/classes#Ski"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.rdf.jastor.test.ski.Ski  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.test.ski.Ski> getDesigner() throws org.openanzo.rdf.jastor.JastorException {
		return getDesigner(false);
	}

/**
     * 
     * @param designer value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addDesigner(org.openanzo.rdf.jastor.test.ski.Ski designer) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, designerProperty,designer.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.rdf.jastor.test.ski.Ski addDesigner() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.test.ski.Ski designer = org.openanzo.rdf.jastor.test.ski.SkiFactory.createSki(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, designerProperty,designer.resource(),_graph.getNamedGraphUri());
		return designer;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.rdf.jastor.test.ski.Ski addDesigner(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(resource, org.openanzo.rdf.vocabulary.RDF.TYPE,org.openanzo.rdf.jastor.test.ski.Ski.TYPE,_graph.getNamedGraphUri()))
			throw new org.openanzo.rdf.jastor.JastorException("Resource " + resource + " not of type " + org.openanzo.rdf.jastor.test.ski.Ski.TYPE);
		org.openanzo.rdf.jastor.test.ski.Ski designer = org.openanzo.rdf.jastor.test.ski.SkiFactory.getSki(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, designerProperty,designer.resource(),_graph.getNamedGraphUri());
		return designer;
	}
	
	/**
	 * Remove object
	 * @param designer object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDesigner(org.openanzo.rdf.jastor.test.ski.Ski designer) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, designerProperty, designer.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, designerProperty, designer.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDesigner(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, designerProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, designerProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'availableBoardLength'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearAvailableBoardLength(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, availableBoardLengthProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#availableBoardLength


	org.openanzo.rdf.jastor.PropertyCollection<java.lang.Integer> propertyCollectionAvailableBoardLength = new org.openanzo.rdf.jastor.PropertyCollection<java.lang.Integer>() {
		public java.lang.Integer getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#int");
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://jastor.openanzo.org/testonts/predicates#availableBoardLength properties in Snowboard model not a Literal",value);
				}
			}
	};

	public java.util.Collection<java.lang.Integer> getAvailableBoardLength(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionAvailableBoardLength.getPropertyCollection(_dataset, _graph, _resource,availableBoardLengthProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#int"), includeEntireDataset);
	}
	
	public java.util.Collection<java.lang.Integer> getAvailableBoardLength() throws org.openanzo.rdf.jastor.JastorException {
		return getAvailableBoardLength(false);
	}

	public void addAvailableBoardLength(java.lang.Integer availableBoardLength) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(availableBoardLength,"http://www.w3.org/2001/XMLSchema#int");
		//if (_dataset.contains(_resource, availableBoardLengthProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (availableBoardLength != null) {
			_dataset.add(_resource, availableBoardLengthProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeAvailableBoardLength(java.lang.Integer availableBoardLength) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(availableBoardLength,"http://www.w3.org/2001/XMLSchema#int");
		if (!_dataset.contains(_resource, availableBoardLengthProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, availableBoardLengthProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'extensionXML'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearExtensionXML(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, extensionXMLProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#extensionXML
	public java.lang.String getExtensionXML(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, extensionXMLProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": extensionXML getProperty() in org.openanzo.rdf.jastor.test.ski.Snowboard model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/1999/02/22-rdf-syntax-ns#XMLLiteral");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal extensionXML in Snowboard is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getExtensionXML() throws org.openanzo.rdf.jastor.JastorException {
		return getExtensionXML(false);
	}
	
	public void setExtensionXML(java.lang.String extensionXML) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, extensionXMLProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (extensionXML != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(extensionXML,"http://www.w3.org/1999/02/22-rdf-syntax-ns#XMLLiteral");
			_dataset.add(_resource, extensionXMLProperty, _literal,_graph.getNamedGraphUri());
	
		}	
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
  


	protected java.util.concurrent.CopyOnWriteArraySet<SnowboardListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<SnowboardListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof SnowboardListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	SnowboardListener list = (SnowboardListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof SnowboardListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		SnowboardListener list = (SnowboardListener)listener;
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
			if (statement.getPredicate().equals(complimentBoardProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _complimentBoard = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_complimentBoard != null) {
					for(SnowboardListener listener : listeners){
						listener.complimentBoardAdded(org.openanzo.rdf.jastor.test.ski.SnowboardImpl.this,_complimentBoard);
					}
				}
				org.openanzo.rdf.jastor.test.ski.Snowboard _complimentBoard_asSnowboard = org.openanzo.rdf.jastor.test.ski.SkiFactory.getSnowboard(resource,_graph.getNamedGraphUri(),dataset());
				if (_complimentBoard_asSnowboard != null) {
					for(SnowboardListener listener : listeners){
						listener.complimentBoardAdded(org.openanzo.rdf.jastor.test.ski.SnowboardImpl.this,_complimentBoard_asSnowboard);
					}
				}			
			}
			if (statement.getPredicate().equals(preferredStanceProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(SnowboardListener listener : listeners){
					listener.preferredStanceChanged(org.openanzo.rdf.jastor.test.ski.SnowboardImpl.this);
				}			
			}
			if (statement.getPredicate().equals(isAlpineProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(SnowboardListener listener : listeners){
					listener.isAlpineChanged(org.openanzo.rdf.jastor.test.ski.SnowboardImpl.this);
				}			
			}
			if (statement.getPredicate().equals(designerProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.test.ski.Ski _designer = org.openanzo.rdf.jastor.test.ski.SkiFactory.getSki(resource,_graph.getNamedGraphUri(),dataset());
				if (_designer != null) {
					for(SnowboardListener listener : listeners){
						listener.designerAdded(org.openanzo.rdf.jastor.test.ski.SnowboardImpl.this,_designer);
					}
				}			
			}
			if (statement.getPredicate().equals(availableBoardLengthProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.Integer) {
					for(SnowboardListener listener : listeners){
						listener.availableBoardLengthAdded(org.openanzo.rdf.jastor.test.ski.SnowboardImpl.this,(java.lang.Integer)obj);
					}
				}			
			}
			if (statement.getPredicate().equals(extensionXMLProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(SnowboardListener listener : listeners){
					listener.extensionXMLChanged(org.openanzo.rdf.jastor.test.ski.SnowboardImpl.this);
				}			
			}
			if (statement.getPredicate().equals(isFreestyleProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _isFreestyle = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_isFreestyle != null) {
					for(SnowboardListener listener : listeners){
						listener.isFreestyleAdded(org.openanzo.rdf.jastor.test.ski.SnowboardImpl.this,_isFreestyle);
					}
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(complimentBoardProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _complimentBoard = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_complimentBoard != null) {
					for(SnowboardListener listener : listeners){
						listener.complimentBoardRemoved(org.openanzo.rdf.jastor.test.ski.SnowboardImpl.this,_complimentBoard);
					}
				}
				org.openanzo.rdf.jastor.test.ski.Snowboard _complimentBoard_asSnowboard = org.openanzo.rdf.jastor.test.ski.SkiFactory.getSnowboard(resource,_graph.getNamedGraphUri(),dataset());
				if (_complimentBoard_asSnowboard != null) {
					for(SnowboardListener listener : listeners){
						listener.complimentBoardRemoved(org.openanzo.rdf.jastor.test.ski.SnowboardImpl.this,_complimentBoard_asSnowboard);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(preferredStanceProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(SnowboardListener listener : listeners) {
					listener.preferredStanceChanged(org.openanzo.rdf.jastor.test.ski.SnowboardImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(isAlpineProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(SnowboardListener listener : listeners) {
					listener.isAlpineChanged(org.openanzo.rdf.jastor.test.ski.SnowboardImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(designerProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.test.ski.Ski _designer = org.openanzo.rdf.jastor.test.ski.SkiFactory.getSki(resource,_graph.getNamedGraphUri(),dataset());
				if (_designer != null) {
					for(SnowboardListener listener : listeners){
						listener.designerRemoved(org.openanzo.rdf.jastor.test.ski.SnowboardImpl.this,_designer);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(availableBoardLengthProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.Integer) {
					for(SnowboardListener listener : listeners){
						listener.availableBoardLengthRemoved(org.openanzo.rdf.jastor.test.ski.SnowboardImpl.this,(java.lang.Integer)obj);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(extensionXMLProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(SnowboardListener listener : listeners) {
					listener.extensionXMLChanged(org.openanzo.rdf.jastor.test.ski.SnowboardImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(isFreestyleProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _isFreestyle = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_isFreestyle != null) {
					for(SnowboardListener listener : listeners){
						listener.isFreestyleRemoved(org.openanzo.rdf.jastor.test.ski.SnowboardImpl.this,_isFreestyle);
					}
				}
				return;
			}
		}
		}}
	}
	


}