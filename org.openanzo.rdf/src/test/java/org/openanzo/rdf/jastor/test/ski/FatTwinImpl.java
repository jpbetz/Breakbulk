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
 * Implementation of {@link org.openanzo.rdf.jastor.test.ski.FatTwin}
 * Use the org.openanzo.rdf.jastor.test.ski.SkiFactory to create instances of this class.
 * <p>(URI: http://jastor.openanzo.org/testonts/classes#FatTwin)</p>
 * <br>
 */
public class FatTwinImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.rdf.jastor.test.ski.FatTwin {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI designerProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#designer");
	protected static final org.openanzo.rdf.URI attributeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#attribute");
	protected static final org.openanzo.rdf.URI availableLengthProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#availableLength");
	protected static final org.openanzo.rdf.URI coreConstructionProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#coreConstruction");
	protected static final org.openanzo.rdf.URI coreMaterialProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#coreMaterial");
	protected static final org.openanzo.rdf.URI manufacturerProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#manufacturer");
	protected static final org.openanzo.rdf.URI modelProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#model");
	protected static final org.openanzo.rdf.URI partnumProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#partnum");
	protected static final org.openanzo.rdf.URI relatedPartnumProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#relatedPartnum");
	protected static final org.openanzo.rdf.URI websiteProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#website");
	protected static final org.openanzo.rdf.URI competesWithProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#competesWith");
	protected static final org.openanzo.rdf.URI identifierProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#identifier");
	protected static final org.openanzo.rdf.URI mostSimilarToProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#mostSimilarTo");
	protected static final org.openanzo.rdf.URI multiIdentifierProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#multiIdentifier");
	protected static final org.openanzo.rdf.URI previousModelProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#previousModel");
	protected static final org.openanzo.rdf.URI sidewallProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#sidewall");
	protected static final org.openanzo.rdf.URI isAlpineProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#isAlpine");
	protected static final org.openanzo.rdf.URI isFreestyleProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#isFreestyle");
	protected static final org.openanzo.rdf.URI preferredStanceProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#preferredStance");
	protected static final org.openanzo.rdf.URI complimentBoardProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#complimentBoard");
	protected static final org.openanzo.rdf.URI specialtyProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#specialty");
	protected static final org.openanzo.rdf.URI proRiderProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#proRider");
	protected static final org.openanzo.rdf.URI flotationProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#flotation");
	protected static final org.openanzo.rdf.URI ns1_modelProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/altnamespace/predicates#model");
	protected static final org.openanzo.rdf.URI pipeOrParkProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#pipeOrPark");
	protected static final org.openanzo.rdf.URI relativeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://jastor.openanzo.org/testonts/predicates#relative");

	FatTwinImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static FatTwinImpl getFatTwin(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, FatTwin.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		if (!dataset.contains(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, FatTwin.TYPE, namedGraphUri))
			return null;
		return new FatTwinImpl(resource, namedGraphUri, dataset);
	}
	    
	static FatTwinImpl createFatTwin(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		FatTwinImpl impl = new FatTwinImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, FatTwin.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, FatTwin.TYPE, namedGraphUri);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	void addSuperTypes() {
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.test.ski.Ski.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.test.ski.Ski.TYPE,_graph.getNamedGraphUri());     
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.test.ski.SpecialtySki.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.test.ski.SpecialtySki.TYPE,_graph.getNamedGraphUri());     
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.test.ski.PowderSki.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.test.ski.PowderSki.TYPE,_graph.getNamedGraphUri());     
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.test.ski.TwinTip.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.test.ski.TwinTip.TYPE,_graph.getNamedGraphUri());     
	}
   
	void addHasValueValues() {
		if (!_dataset.contains(_resource, pipeOrParkProperty, org.openanzo.rdf.jastor.ThingFactory.valueFactory.createLiteral("park"),_graph.getNamedGraphUri()))
			_dataset.add(_resource, pipeOrParkProperty, org.openanzo.rdf.jastor.ThingFactory.valueFactory.createLiteral("park"),_graph.getNamedGraphUri());
	}
   
	public java.util.Collection<org.openanzo.rdf.Statement> listStatements() {
		java.util.Collection<org.openanzo.rdf.Statement> list = new java.util.HashSet<org.openanzo.rdf.Statement>();
		
		list.addAll(_dataset.find(_resource, designerProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, attributeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, availableLengthProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, coreConstructionProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, coreMaterialProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, manufacturerProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, modelProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, partnumProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, relatedPartnumProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, websiteProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, competesWithProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, identifierProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, mostSimilarToProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, multiIdentifierProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, previousModelProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, sidewallProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, isAlpineProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, isFreestyleProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, preferredStanceProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, complimentBoardProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, specialtyProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, proRiderProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, flotationProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, ns1_modelProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, pipeOrParkProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, relativeProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.test.ski.FatTwin.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.test.ski.Ski.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.test.ski.SpecialtySki.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.test.ski.PowderSki.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.jastor.test.ski.TwinTip.TYPE, _graph.getNamedGraphUri()));
		return list;
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

	public org.openanzo.rdf.jastor.test.ski.Ski getDesigner(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, designerProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": designer getProperty() in org.openanzo.rdf.jastor.test.ski.FatTwin model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.jastor.test.ski.SkiFactory.getSki(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.jastor.test.ski.Ski getDesigner() throws org.openanzo.rdf.jastor.JastorException {
		return getDesigner(false);
	}

	public void setDesigner(org.openanzo.rdf.jastor.test.ski.Ski designer) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, designerProperty, null,_graph.getNamedGraphUri());
		if (designer != null) {
			_dataset.add(_resource, designerProperty, designer.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.jastor.test.ski.Ski setDesigner() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, designerProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.jastor.test.ski.Ski designer = org.openanzo.rdf.jastor.test.ski.SkiFactory.createSki(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, designerProperty, designer.resource(),_graph.getNamedGraphUri());
		return designer;
	}
	
	public org.openanzo.rdf.jastor.test.ski.Ski setDesigner(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(resource, org.openanzo.rdf.vocabulary.RDF.TYPE,org.openanzo.rdf.jastor.test.ski.Ski.TYPE,_graph.getNamedGraphUri())) {
			throw new org.openanzo.rdf.jastor.JastorException("Resource " + resource + " not of type " + org.openanzo.rdf.jastor.test.ski.Ski.TYPE);
		}
		if (_dataset.contains(_resource, designerProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, designerProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.jastor.test.ski.Ski designer = org.openanzo.rdf.jastor.test.ski.SkiFactory.getSki(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, designerProperty, designer.resource(),_graph.getNamedGraphUri());
		return designer;
	}
	
	/**
	 * Clears all values for 'attribute'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearAttribute(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, attributeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#attribute
	public org.openanzo.rdf.Literal getAttribute(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, attributeProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": attribute getProperty() in org.openanzo.rdf.jastor.test.ski.FatTwin model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		return literal;
		
	}
	
	public org.openanzo.rdf.Literal getAttribute() throws org.openanzo.rdf.jastor.JastorException {
		return getAttribute(false);
	}
	
	public void setAttribute(org.openanzo.rdf.Literal attribute) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, attributeProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (attribute != null) {
	
			_dataset.add(_resource, attributeProperty, attribute,_graph.getNamedGraphUri());
	
		}	
	}
	public java.lang.String getAttribute_asString(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, attributeProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": attribute_asString getProperty() in org.openanzo.rdf.jastor.test.ski.FatTwin model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal attribute_asString in FatTwin is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getAttribute_asString() throws org.openanzo.rdf.jastor.JastorException {
		return getAttribute_asString(false);
	}
	
	public void setAttribute(java.lang.String attribute) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, attributeProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (attribute != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(attribute,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, attributeProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'availableLength'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearAvailableLength(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, availableLengthProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#availableLength


	org.openanzo.rdf.jastor.PropertyCollection<java.lang.Integer> propertyCollectionAvailableLength = new org.openanzo.rdf.jastor.PropertyCollection<java.lang.Integer>() {
		public java.lang.Integer getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#int");
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://jastor.openanzo.org/testonts/predicates#availableLength properties in FatTwin model not a Literal",value);
				}
			}
	};

	public java.util.Collection<java.lang.Integer> getAvailableLength(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionAvailableLength.getPropertyCollection(_dataset, _graph, _resource,availableLengthProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#int"), includeEntireDataset);
	}
	
	public java.util.Collection<java.lang.Integer> getAvailableLength() throws org.openanzo.rdf.jastor.JastorException {
		return getAvailableLength(false);
	}

	public void addAvailableLength(java.lang.Integer availableLength) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(availableLength,"http://www.w3.org/2001/XMLSchema#int");
		//if (_dataset.contains(_resource, availableLengthProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (availableLength != null) {
			_dataset.add(_resource, availableLengthProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeAvailableLength(java.lang.Integer availableLength) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(availableLength,"http://www.w3.org/2001/XMLSchema#int");
		if (!_dataset.contains(_resource, availableLengthProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, availableLengthProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'coreConstruction'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearCoreConstruction(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, coreConstructionProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#coreConstruction
	public java.lang.String getCoreConstruction(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, coreConstructionProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": coreConstruction getProperty() in org.openanzo.rdf.jastor.test.ski.FatTwin model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal coreConstruction in FatTwin is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getCoreConstruction() throws org.openanzo.rdf.jastor.JastorException {
		return getCoreConstruction(false);
	}
	
	public void setCoreConstruction(java.lang.String coreConstruction) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, coreConstructionProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (coreConstruction != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(coreConstruction,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, coreConstructionProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'coreMaterial'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearCoreMaterial(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, coreMaterialProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#coreMaterial


	org.openanzo.rdf.jastor.PropertyCollection<java.lang.String> propertyCollectionCoreMaterial = new org.openanzo.rdf.jastor.PropertyCollection<java.lang.String>() {
		public java.lang.String getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://jastor.openanzo.org/testonts/predicates#coreMaterial properties in FatTwin model not a Literal",value);
				}
			}
	};

	public java.util.Collection<java.lang.String> getCoreMaterial(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionCoreMaterial.getPropertyCollection(_dataset, _graph, _resource,coreMaterialProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#string"), includeEntireDataset);
	}
	
	public java.util.Collection<java.lang.String> getCoreMaterial() throws org.openanzo.rdf.jastor.JastorException {
		return getCoreMaterial(false);
	}

	public void addCoreMaterial(java.lang.String coreMaterial) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(coreMaterial,"http://www.w3.org/2001/XMLSchema#string");
		//if (_dataset.contains(_resource, coreMaterialProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (coreMaterial != null) {
			_dataset.add(_resource, coreMaterialProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeCoreMaterial(java.lang.String coreMaterial) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(coreMaterial,"http://www.w3.org/2001/XMLSchema#string");
		if (!_dataset.contains(_resource, coreMaterialProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, coreMaterialProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'manufacturer'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearManufacturer(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, manufacturerProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#manufacturer
	public java.lang.String getManufacturer(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, manufacturerProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": manufacturer getProperty() in org.openanzo.rdf.jastor.test.ski.FatTwin model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal manufacturer in FatTwin is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getManufacturer() throws org.openanzo.rdf.jastor.JastorException {
		return getManufacturer(false);
	}
	
	public void setManufacturer(java.lang.String manufacturer) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, manufacturerProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (manufacturer != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(manufacturer,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, manufacturerProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'model'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearModel(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, modelProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#model
	public java.lang.String getModel(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, modelProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": model getProperty() in org.openanzo.rdf.jastor.test.ski.FatTwin model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal model in FatTwin is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getModel() throws org.openanzo.rdf.jastor.JastorException {
		return getModel(false);
	}
	
	public void setModel(java.lang.String model) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, modelProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (model != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(model,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, modelProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'partnum'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearPartnum(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, partnumProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#partnum
	public java.lang.Long getPartnum(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, partnumProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": partnum getProperty() in org.openanzo.rdf.jastor.test.ski.FatTwin model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#long");
		if (!(obj instanceof java.lang.Long))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal partnum in FatTwin is not of type java.lang.Long", literal);
		return (java.lang.Long)obj;
		
	}
	
	public java.lang.Long getPartnum() throws org.openanzo.rdf.jastor.JastorException {
		return getPartnum(false);
	}
	
	public void setPartnum(java.lang.Long partnum) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, partnumProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (partnum != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(partnum,"http://www.w3.org/2001/XMLSchema#long");
			_dataset.add(_resource, partnumProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'relatedPartnum'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearRelatedPartnum(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, relatedPartnumProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#relatedPartnum


	org.openanzo.rdf.jastor.PropertyCollection<java.lang.Long> propertyCollectionRelatedPartnum = new org.openanzo.rdf.jastor.PropertyCollection<java.lang.Long>() {
		public java.lang.Long getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#long");
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://jastor.openanzo.org/testonts/predicates#relatedPartnum properties in FatTwin model not a Literal",value);
				}
			}
	};

	public java.util.Collection<java.lang.Long> getRelatedPartnum(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionRelatedPartnum.getPropertyCollection(_dataset, _graph, _resource,relatedPartnumProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#long"), includeEntireDataset);
	}
	
	public java.util.Collection<java.lang.Long> getRelatedPartnum() throws org.openanzo.rdf.jastor.JastorException {
		return getRelatedPartnum(false);
	}

	public void addRelatedPartnum(java.lang.Long relatedPartnum) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(relatedPartnum,"http://www.w3.org/2001/XMLSchema#long");
		//if (_dataset.contains(_resource, relatedPartnumProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (relatedPartnum != null) {
			_dataset.add(_resource, relatedPartnumProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeRelatedPartnum(java.lang.Long relatedPartnum) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(relatedPartnum,"http://www.w3.org/2001/XMLSchema#long");
		if (!_dataset.contains(_resource, relatedPartnumProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, relatedPartnumProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'website'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearWebsite(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, websiteProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#website
	public org.openanzo.rdf.URI getWebsite(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, websiteProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;
		if (!(statement.getObject() instanceof org.openanzo.rdf.URI))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": website getProperty() in org.openanzo.rdf.jastor.test.ski.FatTwin model not URI", statement.getObject());
		return (org.openanzo.rdf.URI)statement.getObject();
		
	}
	
	public org.openanzo.rdf.URI getWebsite() throws org.openanzo.rdf.jastor.JastorException {
		return getWebsite(false);
	}
	
	public void setWebsite(org.openanzo.rdf.URI website) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, websiteProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (website != null) {
	
			_dataset.add(_resource, websiteProperty, website,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'competesWith'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearCompetesWith(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, competesWithProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#competesWith

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.test.ski.Ski> propertyCollectionCompetesWith = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.test.ski.Ski>() {
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
	public java.util.Collection<org.openanzo.rdf.jastor.test.ski.Ski> getCompetesWith(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionCompetesWith.getPropertyCollection(_dataset, _graph, _resource,competesWithProperty, org.openanzo.rdf.MemURI.create("http://jastor.openanzo.org/testonts/classes#Ski"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.rdf.jastor.test.ski.Ski  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.test.ski.Ski> getCompetesWith() throws org.openanzo.rdf.jastor.JastorException {
		return getCompetesWith(false);
	}

/**
     * 
     * @param competesWith value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addCompetesWith(org.openanzo.rdf.jastor.test.ski.Ski competesWith) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, competesWithProperty,competesWith.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.rdf.jastor.test.ski.Ski addCompetesWith() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.test.ski.Ski competesWith = org.openanzo.rdf.jastor.test.ski.SkiFactory.createSki(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, competesWithProperty,competesWith.resource(),_graph.getNamedGraphUri());
		return competesWith;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.rdf.jastor.test.ski.Ski addCompetesWith(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(resource, org.openanzo.rdf.vocabulary.RDF.TYPE,org.openanzo.rdf.jastor.test.ski.Ski.TYPE,_graph.getNamedGraphUri()))
			throw new org.openanzo.rdf.jastor.JastorException("Resource " + resource + " not of type " + org.openanzo.rdf.jastor.test.ski.Ski.TYPE);
		org.openanzo.rdf.jastor.test.ski.Ski competesWith = org.openanzo.rdf.jastor.test.ski.SkiFactory.getSki(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, competesWithProperty,competesWith.resource(),_graph.getNamedGraphUri());
		return competesWith;
	}
	
	/**
	 * Remove object
	 * @param competesWith object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCompetesWith(org.openanzo.rdf.jastor.test.ski.Ski competesWith) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, competesWithProperty, competesWith.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, competesWithProperty, competesWith.resource(),_graph.getNamedGraphUri());
	}
// generating range: http://jastor.openanzo.org/testonts/classes#TwinTip

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.test.ski.TwinTip> propertyCollectionCompetesWith_asTwinTip = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.test.ski.TwinTip>() {
		public org.openanzo.rdf.jastor.test.ski.TwinTip getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.jastor.test.ski.SkiFactory.getTwinTip((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.rdf.jastor.test.ski.TwinTip 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.test.ski.TwinTip> getCompetesWith_asTwinTip(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionCompetesWith_asTwinTip.getPropertyCollection(_dataset, _graph, _resource,competesWithProperty, org.openanzo.rdf.MemURI.create("http://jastor.openanzo.org/testonts/classes#TwinTip"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.rdf.jastor.test.ski.TwinTip  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.test.ski.TwinTip> getCompetesWith_asTwinTip() throws org.openanzo.rdf.jastor.JastorException {
		return getCompetesWith_asTwinTip(false);
	}

/**
     * 
     * @param competesWith value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addCompetesWith(org.openanzo.rdf.jastor.test.ski.TwinTip competesWith) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, competesWithProperty,competesWith.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.rdf.jastor.test.ski.TwinTip addCompetesWith_asTwinTip() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.test.ski.TwinTip competesWith = org.openanzo.rdf.jastor.test.ski.SkiFactory.createTwinTip(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, competesWithProperty,competesWith.resource(),_graph.getNamedGraphUri());
		return competesWith;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.rdf.jastor.test.ski.TwinTip addCompetesWith_asTwinTip(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(resource, org.openanzo.rdf.vocabulary.RDF.TYPE,org.openanzo.rdf.jastor.test.ski.TwinTip.TYPE,_graph.getNamedGraphUri()))
			throw new org.openanzo.rdf.jastor.JastorException("Resource " + resource + " not of type " + org.openanzo.rdf.jastor.test.ski.TwinTip.TYPE);
		org.openanzo.rdf.jastor.test.ski.TwinTip competesWith = org.openanzo.rdf.jastor.test.ski.SkiFactory.getTwinTip(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, competesWithProperty,competesWith.resource(),_graph.getNamedGraphUri());
		return competesWith;
	}
	
	/**
	 * Remove object
	 * @param competesWith object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCompetesWith(org.openanzo.rdf.jastor.test.ski.TwinTip competesWith) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, competesWithProperty, competesWith.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, competesWithProperty, competesWith.resource(),_graph.getNamedGraphUri());
	}
// generating range: http://jastor.openanzo.org/testonts/classes#PowderSki

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.test.ski.PowderSki> propertyCollectionCompetesWith_asPowderSki = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.test.ski.PowderSki>() {
		public org.openanzo.rdf.jastor.test.ski.PowderSki getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.jastor.test.ski.SkiFactory.getPowderSki((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.rdf.jastor.test.ski.PowderSki 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.test.ski.PowderSki> getCompetesWith_asPowderSki(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionCompetesWith_asPowderSki.getPropertyCollection(_dataset, _graph, _resource,competesWithProperty, org.openanzo.rdf.MemURI.create("http://jastor.openanzo.org/testonts/classes#PowderSki"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.rdf.jastor.test.ski.PowderSki  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.test.ski.PowderSki> getCompetesWith_asPowderSki() throws org.openanzo.rdf.jastor.JastorException {
		return getCompetesWith_asPowderSki(false);
	}

/**
     * 
     * @param competesWith value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addCompetesWith(org.openanzo.rdf.jastor.test.ski.PowderSki competesWith) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, competesWithProperty,competesWith.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.rdf.jastor.test.ski.PowderSki addCompetesWith_asPowderSki() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.test.ski.PowderSki competesWith = org.openanzo.rdf.jastor.test.ski.SkiFactory.createPowderSki(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, competesWithProperty,competesWith.resource(),_graph.getNamedGraphUri());
		return competesWith;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.rdf.jastor.test.ski.PowderSki addCompetesWith_asPowderSki(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(resource, org.openanzo.rdf.vocabulary.RDF.TYPE,org.openanzo.rdf.jastor.test.ski.PowderSki.TYPE,_graph.getNamedGraphUri()))
			throw new org.openanzo.rdf.jastor.JastorException("Resource " + resource + " not of type " + org.openanzo.rdf.jastor.test.ski.PowderSki.TYPE);
		org.openanzo.rdf.jastor.test.ski.PowderSki competesWith = org.openanzo.rdf.jastor.test.ski.SkiFactory.getPowderSki(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, competesWithProperty,competesWith.resource(),_graph.getNamedGraphUri());
		return competesWith;
	}
	
	/**
	 * Remove object
	 * @param competesWith object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCompetesWith(org.openanzo.rdf.jastor.test.ski.PowderSki competesWith) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, competesWithProperty, competesWith.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, competesWithProperty, competesWith.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCompetesWith(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, competesWithProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, competesWithProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'identifier'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearIdentifier(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, identifierProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#identifier

	public org.openanzo.rdf.jastor.Thing getIdentifier(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, identifierProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": identifier getProperty() in org.openanzo.rdf.jastor.test.ski.FatTwin model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.jastor.ThingFactory.getThing(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.jastor.Thing getIdentifier() throws org.openanzo.rdf.jastor.JastorException {
		return getIdentifier(false);
	}

	public void setIdentifier(org.openanzo.rdf.jastor.Thing identifier) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, identifierProperty, null,_graph.getNamedGraphUri());
		if (identifier != null) {
			_dataset.add(_resource, identifierProperty, identifier.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.jastor.Thing setIdentifier() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, identifierProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.jastor.Thing identifier = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, identifierProperty, identifier.resource(),_graph.getNamedGraphUri());
		return identifier;
	}
	
	public org.openanzo.rdf.jastor.Thing setIdentifier(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, identifierProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, identifierProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.jastor.Thing identifier = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, identifierProperty, identifier.resource(),_graph.getNamedGraphUri());
		return identifier;
	}
	
	/**
	 * Clears all values for 'mostSimilarTo'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearMostSimilarTo(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, mostSimilarToProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#mostSimilarTo

	public org.openanzo.rdf.jastor.test.ski.Ski getMostSimilarTo(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, mostSimilarToProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": mostSimilarTo getProperty() in org.openanzo.rdf.jastor.test.ski.FatTwin model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.jastor.test.ski.SkiFactory.getSki(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.jastor.test.ski.Ski getMostSimilarTo() throws org.openanzo.rdf.jastor.JastorException {
		return getMostSimilarTo(false);
	}

	public void setMostSimilarTo(org.openanzo.rdf.jastor.test.ski.Ski mostSimilarTo) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, mostSimilarToProperty, null,_graph.getNamedGraphUri());
		if (mostSimilarTo != null) {
			_dataset.add(_resource, mostSimilarToProperty, mostSimilarTo.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.jastor.test.ski.Ski setMostSimilarTo() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, mostSimilarToProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.jastor.test.ski.Ski mostSimilarTo = org.openanzo.rdf.jastor.test.ski.SkiFactory.createSki(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, mostSimilarToProperty, mostSimilarTo.resource(),_graph.getNamedGraphUri());
		return mostSimilarTo;
	}
	
	public org.openanzo.rdf.jastor.test.ski.Ski setMostSimilarTo(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(resource, org.openanzo.rdf.vocabulary.RDF.TYPE,org.openanzo.rdf.jastor.test.ski.Ski.TYPE,_graph.getNamedGraphUri())) {
			throw new org.openanzo.rdf.jastor.JastorException("Resource " + resource + " not of type " + org.openanzo.rdf.jastor.test.ski.Ski.TYPE);
		}
		if (_dataset.contains(_resource, mostSimilarToProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, mostSimilarToProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.jastor.test.ski.Ski mostSimilarTo = org.openanzo.rdf.jastor.test.ski.SkiFactory.getSki(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, mostSimilarToProperty, mostSimilarTo.resource(),_graph.getNamedGraphUri());
		return mostSimilarTo;
	}
	
	public org.openanzo.rdf.jastor.test.ski.TwinTip getMostSimilarTo_asTwinTip(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, mostSimilarToProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": mostSimilarTo_asTwinTip getProperty() in org.openanzo.rdf.jastor.test.ski.FatTwin model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.jastor.test.ski.SkiFactory.getTwinTip(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.jastor.test.ski.TwinTip getMostSimilarTo_asTwinTip() throws org.openanzo.rdf.jastor.JastorException {
		return getMostSimilarTo_asTwinTip(false);
	}

	public void setMostSimilarTo(org.openanzo.rdf.jastor.test.ski.TwinTip mostSimilarTo) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, mostSimilarToProperty, null,_graph.getNamedGraphUri());
		if (mostSimilarTo != null) {
			_dataset.add(_resource, mostSimilarToProperty, mostSimilarTo.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.jastor.test.ski.TwinTip setMostSimilarTo_asTwinTip() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, mostSimilarToProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.jastor.test.ski.TwinTip mostSimilarTo = org.openanzo.rdf.jastor.test.ski.SkiFactory.createTwinTip(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, mostSimilarToProperty, mostSimilarTo.resource(),_graph.getNamedGraphUri());
		return mostSimilarTo;
	}
	
	public org.openanzo.rdf.jastor.test.ski.TwinTip setMostSimilarTo_asTwinTip(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(resource, org.openanzo.rdf.vocabulary.RDF.TYPE,org.openanzo.rdf.jastor.test.ski.TwinTip.TYPE,_graph.getNamedGraphUri())) {
			throw new org.openanzo.rdf.jastor.JastorException("Resource " + resource + " not of type " + org.openanzo.rdf.jastor.test.ski.TwinTip.TYPE);
		}
		if (_dataset.contains(_resource, mostSimilarToProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, mostSimilarToProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.jastor.test.ski.TwinTip mostSimilarTo = org.openanzo.rdf.jastor.test.ski.SkiFactory.getTwinTip(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, mostSimilarToProperty, mostSimilarTo.resource(),_graph.getNamedGraphUri());
		return mostSimilarTo;
	}
	
	/**
	 * Clears all values for 'multiIdentifier'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearMultiIdentifier(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, multiIdentifierProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#multiIdentifier

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing> propertyCollectionMultiIdentifier = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing>() {
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
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getMultiIdentifier(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionMultiIdentifier.getPropertyCollection(_dataset, _graph, _resource,multiIdentifierProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Resource"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.rdf.jastor.Thing  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getMultiIdentifier() throws org.openanzo.rdf.jastor.JastorException {
		return getMultiIdentifier(false);
	}

/**
     * 
     * @param multiIdentifier value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addMultiIdentifier(org.openanzo.rdf.jastor.Thing multiIdentifier) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, multiIdentifierProperty,multiIdentifier.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.rdf.jastor.Thing addMultiIdentifier() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing multiIdentifier = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, multiIdentifierProperty,multiIdentifier.resource(),_graph.getNamedGraphUri());
		return multiIdentifier;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.rdf.jastor.Thing addMultiIdentifier(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing multiIdentifier = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, multiIdentifierProperty,multiIdentifier.resource(),_graph.getNamedGraphUri());
		return multiIdentifier;
	}
	
	/**
	 * Remove object
	 * @param multiIdentifier object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMultiIdentifier(org.openanzo.rdf.jastor.Thing multiIdentifier) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, multiIdentifierProperty, multiIdentifier.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, multiIdentifierProperty, multiIdentifier.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMultiIdentifier(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, multiIdentifierProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, multiIdentifierProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'previousModel'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearPreviousModel(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, previousModelProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#previousModel

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.test.ski.Ski> propertyCollectionPreviousModel = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.test.ski.Ski>() {
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
	public java.util.Collection<org.openanzo.rdf.jastor.test.ski.Ski> getPreviousModel(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionPreviousModel.getPropertyCollection(_dataset, _graph, _resource,previousModelProperty, org.openanzo.rdf.MemURI.create("http://jastor.openanzo.org/testonts/classes#Ski"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.rdf.jastor.test.ski.Ski  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.test.ski.Ski> getPreviousModel() throws org.openanzo.rdf.jastor.JastorException {
		return getPreviousModel(false);
	}

/**
     * 
     * @param previousModel value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addPreviousModel(org.openanzo.rdf.jastor.test.ski.Ski previousModel) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, previousModelProperty,previousModel.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.rdf.jastor.test.ski.Ski addPreviousModel() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.test.ski.Ski previousModel = org.openanzo.rdf.jastor.test.ski.SkiFactory.createSki(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, previousModelProperty,previousModel.resource(),_graph.getNamedGraphUri());
		return previousModel;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.rdf.jastor.test.ski.Ski addPreviousModel(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(resource, org.openanzo.rdf.vocabulary.RDF.TYPE,org.openanzo.rdf.jastor.test.ski.Ski.TYPE,_graph.getNamedGraphUri()))
			throw new org.openanzo.rdf.jastor.JastorException("Resource " + resource + " not of type " + org.openanzo.rdf.jastor.test.ski.Ski.TYPE);
		org.openanzo.rdf.jastor.test.ski.Ski previousModel = org.openanzo.rdf.jastor.test.ski.SkiFactory.getSki(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, previousModelProperty,previousModel.resource(),_graph.getNamedGraphUri());
		return previousModel;
	}
	
	/**
	 * Remove object
	 * @param previousModel object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePreviousModel(org.openanzo.rdf.jastor.test.ski.Ski previousModel) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, previousModelProperty, previousModel.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, previousModelProperty, previousModel.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePreviousModel(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, previousModelProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, previousModelProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'sidewall'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearSidewall(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, sidewallProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#sidewall

	public org.openanzo.rdf.jastor.test.ski.SidewallEnum getSidewall(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, sidewallProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": sidewall getProperty() in org.openanzo.rdf.jastor.test.ski.FatTwin model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.jastor.test.ski.SkiFactory.getSidewallEnum(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.jastor.test.ski.SidewallEnum getSidewall() throws org.openanzo.rdf.jastor.JastorException {
		return getSidewall(false);
	}

	public void setSidewall(org.openanzo.rdf.jastor.test.ski.SidewallEnum sidewall) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, sidewallProperty, null,_graph.getNamedGraphUri());
		if (sidewall != null) {
			_dataset.add(_resource, sidewallProperty, sidewall.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.jastor.test.ski.SidewallEnum setSidewall() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, sidewallProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.jastor.test.ski.SidewallEnum sidewall = org.openanzo.rdf.jastor.test.ski.SkiFactory.createSidewallEnum(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, sidewallProperty, sidewall.resource(),_graph.getNamedGraphUri());
		return sidewall;
	}
	
	public org.openanzo.rdf.jastor.test.ski.SidewallEnum setSidewall(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(resource, org.openanzo.rdf.vocabulary.RDF.TYPE,org.openanzo.rdf.jastor.test.ski.SidewallEnum.TYPE,_graph.getNamedGraphUri())) {
			throw new org.openanzo.rdf.jastor.JastorException("Resource " + resource + " not of type " + org.openanzo.rdf.jastor.test.ski.SidewallEnum.TYPE);
		}
		if (_dataset.contains(_resource, sidewallProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, sidewallProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.jastor.test.ski.SidewallEnum sidewall = org.openanzo.rdf.jastor.test.ski.SkiFactory.getSidewallEnum(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, sidewallProperty, sidewall.resource(),_graph.getNamedGraphUri());
		return sidewall;
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
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://jastor.openanzo.org/testonts/predicates#isAlpine properties in FatTwin model not a Literal",value);
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
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://jastor.openanzo.org/testonts/predicates#preferredStance properties in FatTwin model not a Literal",value);
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
 
	/**
	 * Clears all values for 'specialty'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearSpecialty(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, specialtyProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#specialty
	public java.lang.Integer getSpecialty(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, specialtyProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": specialty getProperty() in org.openanzo.rdf.jastor.test.ski.FatTwin model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#int");
		if (!(obj instanceof java.lang.Integer))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal specialty in FatTwin is not of type java.lang.Integer", literal);
		return (java.lang.Integer)obj;
		
	}
	
	public java.lang.Integer getSpecialty() throws org.openanzo.rdf.jastor.JastorException {
		return getSpecialty(false);
	}
	
	public void setSpecialty(java.lang.Integer specialty) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, specialtyProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (specialty != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(specialty,"http://www.w3.org/2001/XMLSchema#int");
			_dataset.add(_resource, specialtyProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'proRider'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearProRider(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, proRiderProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#proRider


	org.openanzo.rdf.jastor.PropertyCollection<java.lang.String> propertyCollectionProRider = new org.openanzo.rdf.jastor.PropertyCollection<java.lang.String>() {
		public java.lang.String getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://jastor.openanzo.org/testonts/predicates#proRider properties in FatTwin model not a Literal",value);
				}
			}
	};

	public java.util.Collection<java.lang.String> getProRider(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionProRider.getPropertyCollection(_dataset, _graph, _resource,proRiderProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#string"), includeEntireDataset);
	}
	
	public java.util.Collection<java.lang.String> getProRider() throws org.openanzo.rdf.jastor.JastorException {
		return getProRider(false);
	}

	public void addProRider(java.lang.String proRider) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(proRider,"http://www.w3.org/2001/XMLSchema#string");
		//if (_dataset.contains(_resource, proRiderProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (proRider != null) {
			_dataset.add(_resource, proRiderProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeProRider(java.lang.String proRider) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(proRider,"http://www.w3.org/2001/XMLSchema#string");
		if (!_dataset.contains(_resource, proRiderProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, proRiderProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'flotation'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearFlotation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, flotationProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#flotation
	public java.lang.Integer getFlotation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, flotationProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": flotation getProperty() in org.openanzo.rdf.jastor.test.ski.FatTwin model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#int");
		if (!(obj instanceof java.lang.Integer))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal flotation in FatTwin is not of type java.lang.Integer", literal);
		return (java.lang.Integer)obj;
		
	}
	
	public java.lang.Integer getFlotation() throws org.openanzo.rdf.jastor.JastorException {
		return getFlotation(false);
	}
	
	public void setFlotation(java.lang.Integer flotation) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, flotationProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (flotation != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(flotation,"http://www.w3.org/2001/XMLSchema#int");
			_dataset.add(_resource, flotationProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'ns1_model'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearNs1_Model(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, ns1_modelProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/altnamespace/predicates#model
	public java.lang.String getNs1_Model(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, ns1_modelProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": ns1_model getProperty() in org.openanzo.rdf.jastor.test.ski.FatTwin model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal ns1_model in FatTwin is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getNs1_Model() throws org.openanzo.rdf.jastor.JastorException {
		return getNs1_Model(false);
	}
	
	public void setNs1_Model(java.lang.String ns1_model) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, ns1_modelProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (ns1_model != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(ns1_model,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, ns1_modelProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'pipeOrPark'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearPipeOrPark(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, pipeOrParkProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#pipeOrPark
	public java.lang.String getPipeOrPark(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, pipeOrParkProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": pipeOrPark getProperty() in org.openanzo.rdf.jastor.test.ski.FatTwin model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal pipeOrPark in FatTwin is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getPipeOrPark() throws org.openanzo.rdf.jastor.JastorException {
		return getPipeOrPark(false);
	}
	
	public void setPipeOrPark(java.lang.String pipeOrPark) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, pipeOrParkProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (pipeOrPark != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(pipeOrPark,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, pipeOrParkProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'relative'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearRelative(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, relativeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://jastor.openanzo.org/testonts/predicates#relative

	public org.openanzo.rdf.jastor.test.ski.PowderSki getRelative_asPowderSki(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, relativeProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": relative_asPowderSki getProperty() in org.openanzo.rdf.jastor.test.ski.FatTwin model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.jastor.test.ski.SkiFactory.getPowderSki(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.jastor.test.ski.PowderSki getRelative_asPowderSki() throws org.openanzo.rdf.jastor.JastorException {
		return getRelative_asPowderSki(false);
	}

	public void setRelative(org.openanzo.rdf.jastor.test.ski.PowderSki relative) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, relativeProperty, null,_graph.getNamedGraphUri());
		if (relative != null) {
			_dataset.add(_resource, relativeProperty, relative.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.jastor.test.ski.PowderSki setRelative_asPowderSki() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, relativeProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.jastor.test.ski.PowderSki relative = org.openanzo.rdf.jastor.test.ski.SkiFactory.createPowderSki(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, relativeProperty, relative.resource(),_graph.getNamedGraphUri());
		return relative;
	}
	
	public org.openanzo.rdf.jastor.test.ski.PowderSki setRelative_asPowderSki(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(resource, org.openanzo.rdf.vocabulary.RDF.TYPE,org.openanzo.rdf.jastor.test.ski.PowderSki.TYPE,_graph.getNamedGraphUri())) {
			throw new org.openanzo.rdf.jastor.JastorException("Resource " + resource + " not of type " + org.openanzo.rdf.jastor.test.ski.PowderSki.TYPE);
		}
		if (_dataset.contains(_resource, relativeProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, relativeProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.jastor.test.ski.PowderSki relative = org.openanzo.rdf.jastor.test.ski.SkiFactory.getPowderSki(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, relativeProperty, relative.resource(),_graph.getNamedGraphUri());
		return relative;
	}
	
	public org.openanzo.rdf.jastor.test.ski.TwinTip getRelative_asTwinTip(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, relativeProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": relative_asTwinTip getProperty() in org.openanzo.rdf.jastor.test.ski.FatTwin model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.jastor.test.ski.SkiFactory.getTwinTip(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.jastor.test.ski.TwinTip getRelative_asTwinTip() throws org.openanzo.rdf.jastor.JastorException {
		return getRelative_asTwinTip(false);
	}

	public void setRelative(org.openanzo.rdf.jastor.test.ski.TwinTip relative) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, relativeProperty, null,_graph.getNamedGraphUri());
		if (relative != null) {
			_dataset.add(_resource, relativeProperty, relative.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.jastor.test.ski.TwinTip setRelative_asTwinTip() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, relativeProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.jastor.test.ski.TwinTip relative = org.openanzo.rdf.jastor.test.ski.SkiFactory.createTwinTip(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, relativeProperty, relative.resource(),_graph.getNamedGraphUri());
		return relative;
	}
	
	public org.openanzo.rdf.jastor.test.ski.TwinTip setRelative_asTwinTip(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(resource, org.openanzo.rdf.vocabulary.RDF.TYPE,org.openanzo.rdf.jastor.test.ski.TwinTip.TYPE,_graph.getNamedGraphUri())) {
			throw new org.openanzo.rdf.jastor.JastorException("Resource " + resource + " not of type " + org.openanzo.rdf.jastor.test.ski.TwinTip.TYPE);
		}
		if (_dataset.contains(_resource, relativeProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, relativeProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.jastor.test.ski.TwinTip relative = org.openanzo.rdf.jastor.test.ski.SkiFactory.getTwinTip(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, relativeProperty, relative.resource(),_graph.getNamedGraphUri());
		return relative;
	}
	 


	protected java.util.concurrent.CopyOnWriteArraySet<FatTwinListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<FatTwinListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof FatTwinListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	FatTwinListener list = (FatTwinListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof FatTwinListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		FatTwinListener list = (FatTwinListener)listener;
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
			if (statement.getPredicate().equals(designerProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(FatTwinListener listener : listeners){
					listener.designerChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}			
			}
			if (statement.getPredicate().equals(attributeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(FatTwinListener listener : listeners){
					listener.attributeChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}			
			}
			if (statement.getPredicate().equals(availableLengthProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.Integer) {
					for(FatTwinListener listener : listeners){
						listener.availableLengthAdded(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,(java.lang.Integer)obj);
					}
				}			
			}
			if (statement.getPredicate().equals(coreConstructionProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(FatTwinListener listener : listeners){
					listener.coreConstructionChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}			
			}
			if (statement.getPredicate().equals(coreMaterialProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.String) {
					for(FatTwinListener listener : listeners){
						listener.coreMaterialAdded(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,(java.lang.String)obj);
					}
				}			
			}
			if (statement.getPredicate().equals(manufacturerProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(FatTwinListener listener : listeners){
					listener.manufacturerChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}			
			}
			if (statement.getPredicate().equals(modelProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(FatTwinListener listener : listeners){
					listener.modelChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}			
			}
			if (statement.getPredicate().equals(partnumProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(FatTwinListener listener : listeners){
					listener.partnumChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}			
			}
			if (statement.getPredicate().equals(relatedPartnumProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.Long) {
					for(FatTwinListener listener : listeners){
						listener.relatedPartnumAdded(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,(java.lang.Long)obj);
					}
				}			
			}
			if (statement.getPredicate().equals(websiteProperty)) {
				for(FatTwinListener listener : listeners){
					listener.websiteChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}			
			}
			if (statement.getPredicate().equals(competesWithProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.test.ski.Ski _competesWith = org.openanzo.rdf.jastor.test.ski.SkiFactory.getSki(resource,_graph.getNamedGraphUri(),dataset());
				if (_competesWith != null) {
					for(FatTwinListener listener : listeners){
						listener.competesWithAdded(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,_competesWith);
					}
				}
				org.openanzo.rdf.jastor.test.ski.TwinTip _competesWith_asTwinTip = org.openanzo.rdf.jastor.test.ski.SkiFactory.getTwinTip(resource,_graph.getNamedGraphUri(),dataset());
				if (_competesWith_asTwinTip != null) {
					for(FatTwinListener listener : listeners){
						listener.competesWithAdded(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,_competesWith_asTwinTip);
					}
				}
				org.openanzo.rdf.jastor.test.ski.PowderSki _competesWith_asPowderSki = org.openanzo.rdf.jastor.test.ski.SkiFactory.getPowderSki(resource,_graph.getNamedGraphUri(),dataset());
				if (_competesWith_asPowderSki != null) {
					for(FatTwinListener listener : listeners){
						listener.competesWithAdded(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,_competesWith_asPowderSki);
					}
				}			
			}
			if (statement.getPredicate().equals(identifierProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(FatTwinListener listener : listeners){
					listener.identifierChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}			
			}
			if (statement.getPredicate().equals(mostSimilarToProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(FatTwinListener listener : listeners){
					listener.mostSimilarToChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}			
			}
			if (statement.getPredicate().equals(multiIdentifierProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _multiIdentifier = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_multiIdentifier != null) {
					for(FatTwinListener listener : listeners){
						listener.multiIdentifierAdded(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,_multiIdentifier);
					}
				}			
			}
			if (statement.getPredicate().equals(previousModelProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.test.ski.Ski _previousModel = org.openanzo.rdf.jastor.test.ski.SkiFactory.getSki(resource,_graph.getNamedGraphUri(),dataset());
				if (_previousModel != null) {
					for(FatTwinListener listener : listeners){
						listener.previousModelAdded(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,_previousModel);
					}
				}			
			}
			if (statement.getPredicate().equals(sidewallProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(FatTwinListener listener : listeners){
					listener.sidewallChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}			
			}
			if (statement.getPredicate().equals(isAlpineProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.Boolean) {
					for(FatTwinListener listener : listeners){
						listener.isAlpineAdded(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,(java.lang.Boolean)obj);
					}
				}			
			}
			if (statement.getPredicate().equals(isFreestyleProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _isFreestyle = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_isFreestyle != null) {
					for(FatTwinListener listener : listeners){
						listener.isFreestyleAdded(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,_isFreestyle);
					}
				}			
			}
			if (statement.getPredicate().equals(preferredStanceProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.String) {
					for(FatTwinListener listener : listeners){
						listener.preferredStanceAdded(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,(java.lang.String)obj);
					}
				}			
			}
			if (statement.getPredicate().equals(complimentBoardProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _complimentBoard = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_complimentBoard != null) {
					for(FatTwinListener listener : listeners){
						listener.complimentBoardAdded(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,_complimentBoard);
					}
				}			
			}
			if (statement.getPredicate().equals(specialtyProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(FatTwinListener listener : listeners){
					listener.specialtyChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}			
			}
			if (statement.getPredicate().equals(proRiderProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.String) {
					for(FatTwinListener listener : listeners){
						listener.proRiderAdded(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,(java.lang.String)obj);
					}
				}			
			}
			if (statement.getPredicate().equals(flotationProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(FatTwinListener listener : listeners){
					listener.flotationChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}			
			}
			if (statement.getPredicate().equals(ns1_modelProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(FatTwinListener listener : listeners){
					listener.ns1_modelChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}			
			}
			if (statement.getPredicate().equals(pipeOrParkProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(FatTwinListener listener : listeners){
					listener.pipeOrParkChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}			
			}
			if (statement.getPredicate().equals(relativeProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(FatTwinListener listener : listeners){
					listener.relativeChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(designerProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(FatTwinListener listener : listeners){
					listener.designerChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(attributeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(FatTwinListener listener : listeners) {
					listener.attributeChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(availableLengthProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.Integer) {
					for(FatTwinListener listener : listeners){
						listener.availableLengthRemoved(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,(java.lang.Integer)obj);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(coreConstructionProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(FatTwinListener listener : listeners) {
					listener.coreConstructionChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(coreMaterialProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.String) {
					for(FatTwinListener listener : listeners){
						listener.coreMaterialRemoved(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,(java.lang.String)obj);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(manufacturerProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(FatTwinListener listener : listeners) {
					listener.manufacturerChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(modelProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(FatTwinListener listener : listeners) {
					listener.modelChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(partnumProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(FatTwinListener listener : listeners) {
					listener.partnumChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(relatedPartnumProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.Long) {
					for(FatTwinListener listener : listeners){
						listener.relatedPartnumRemoved(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,(java.lang.Long)obj);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(websiteProperty)) {
				for(FatTwinListener listener : listeners) {
					listener.websiteChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(competesWithProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.test.ski.Ski _competesWith = org.openanzo.rdf.jastor.test.ski.SkiFactory.getSki(resource,_graph.getNamedGraphUri(),dataset());
				if (_competesWith != null) {
					for(FatTwinListener listener : listeners){
						listener.competesWithRemoved(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,_competesWith);
					}
				}
				org.openanzo.rdf.jastor.test.ski.TwinTip _competesWith_asTwinTip = org.openanzo.rdf.jastor.test.ski.SkiFactory.getTwinTip(resource,_graph.getNamedGraphUri(),dataset());
				if (_competesWith_asTwinTip != null) {
					for(FatTwinListener listener : listeners){
						listener.competesWithRemoved(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,_competesWith_asTwinTip);
					}
				}
				org.openanzo.rdf.jastor.test.ski.PowderSki _competesWith_asPowderSki = org.openanzo.rdf.jastor.test.ski.SkiFactory.getPowderSki(resource,_graph.getNamedGraphUri(),dataset());
				if (_competesWith_asPowderSki != null) {
					for(FatTwinListener listener : listeners){
						listener.competesWithRemoved(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,_competesWith_asPowderSki);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(identifierProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(FatTwinListener listener : listeners){
					listener.identifierChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(mostSimilarToProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(FatTwinListener listener : listeners){
					listener.mostSimilarToChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(multiIdentifierProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.Thing _multiIdentifier = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),dataset());
				if (_multiIdentifier != null) {
					for(FatTwinListener listener : listeners){
						listener.multiIdentifierRemoved(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,_multiIdentifier);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(previousModelProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.rdf.jastor.test.ski.Ski _previousModel = org.openanzo.rdf.jastor.test.ski.SkiFactory.getSki(resource,_graph.getNamedGraphUri(),dataset());
				if (_previousModel != null) {
					for(FatTwinListener listener : listeners){
						listener.previousModelRemoved(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,_previousModel);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(sidewallProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(FatTwinListener listener : listeners){
					listener.sidewallChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(isAlpineProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.Boolean) {
					for(FatTwinListener listener : listeners){
						listener.isAlpineRemoved(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,(java.lang.Boolean)obj);
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
					for(FatTwinListener listener : listeners){
						listener.isFreestyleRemoved(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,_isFreestyle);
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
					for(FatTwinListener listener : listeners){
						listener.preferredStanceRemoved(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,(java.lang.String)obj);
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
					for(FatTwinListener listener : listeners){
						listener.complimentBoardRemoved(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,_complimentBoard);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(specialtyProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(FatTwinListener listener : listeners) {
					listener.specialtyChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(proRiderProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.String) {
					for(FatTwinListener listener : listeners){
						listener.proRiderRemoved(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this,(java.lang.String)obj);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(flotationProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(FatTwinListener listener : listeners) {
					listener.flotationChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(ns1_modelProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(FatTwinListener listener : listeners) {
					listener.ns1_modelChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(pipeOrParkProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(FatTwinListener listener : listeners) {
					listener.pipeOrParkChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(relativeProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(FatTwinListener listener : listeners){
					listener.relativeChanged(org.openanzo.rdf.jastor.test.ski.FatTwinImpl.this);
				}
				return;
			}
		}
		}}
	}
	


}