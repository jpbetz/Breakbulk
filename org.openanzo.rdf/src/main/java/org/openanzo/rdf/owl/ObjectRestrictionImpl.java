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
package org.openanzo.rdf.owl;

/**
 * Implementation of {@link org.openanzo.rdf.owl.ObjectRestriction}
 * Use the org.openanzo.rdf.owl.OWL11Factory to create instances of this class.
 * <p>(URI: http://www.w3.org/2006/12/owl11#ObjectRestriction)</p>
 * <br>
 */
public class ObjectRestrictionImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.rdf.owl.ObjectRestriction {

	protected static final org.openanzo.rdf.URI maxCardinalityProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#maxCardinality");
	protected static final org.openanzo.rdf.URI minCardinalityProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#minCardinality");
	protected static final org.openanzo.rdf.URI cardinalityProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#cardinality");
	protected static final org.openanzo.rdf.URI onPropertyProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#onProperty");
	protected static final org.openanzo.rdf.URI onClassProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2006/12/owl11#onClass");

	ObjectRestrictionImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
	}   
	   
    	
	static ObjectRestrictionImpl getObjectRestriction(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, ObjectRestriction.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new ObjectRestrictionImpl(resource, namedGraphUri, dataset);
	}
	    
	static ObjectRestrictionImpl createObjectRestriction(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		ObjectRestrictionImpl impl = new ObjectRestrictionImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, ObjectRestriction.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, ObjectRestriction.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, maxCardinalityProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, minCardinalityProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, cardinalityProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, onPropertyProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, onClassProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.owl.ObjectRestriction.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'maxCardinality'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.ObjectRestriction#maxCardinalityProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearMaxCardinality(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, maxCardinalityProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2002/07/owl#maxCardinality


	org.openanzo.rdf.jastor.PropertyCollection<java.lang.Integer> propertyCollectionMaxCardinality = new org.openanzo.rdf.jastor.PropertyCollection<java.lang.Integer>() {
		public java.lang.Integer getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#int");
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://www.w3.org/2002/07/owl#maxCardinality properties in ObjectRestriction model not a Literal",value);
				}
			}
	};

	public java.util.Collection<java.lang.Integer> getMaxCardinality(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionMaxCardinality.getPropertyCollection(_dataset, _graph, _resource,maxCardinalityProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#int"), includeEntireDataset);
	}
	
	public java.util.Collection<java.lang.Integer> getMaxCardinality() throws org.openanzo.rdf.jastor.JastorException {
		return getMaxCardinality(false);
	}

	public void addMaxCardinality(java.lang.Integer maxCardinality) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(maxCardinality,"http://www.w3.org/2001/XMLSchema#int");
		if (_dataset.contains(_resource, maxCardinalityProperty,_literal,_graph.getNamedGraphUri()))
			return;
	
		if (maxCardinality != null) {
			_dataset.add(_resource, maxCardinalityProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeMaxCardinality(java.lang.Integer maxCardinality) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(maxCardinality,"http://www.w3.org/2001/XMLSchema#int");
		if (!_dataset.contains(_resource, maxCardinalityProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, maxCardinalityProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'minCardinality'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.ObjectRestriction#minCardinalityProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearMinCardinality(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, minCardinalityProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2002/07/owl#minCardinality


	org.openanzo.rdf.jastor.PropertyCollection<java.lang.Integer> propertyCollectionMinCardinality = new org.openanzo.rdf.jastor.PropertyCollection<java.lang.Integer>() {
		public java.lang.Integer getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#int");
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://www.w3.org/2002/07/owl#minCardinality properties in ObjectRestriction model not a Literal",value);
				}
			}
	};

	public java.util.Collection<java.lang.Integer> getMinCardinality(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionMinCardinality.getPropertyCollection(_dataset, _graph, _resource,minCardinalityProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#int"), includeEntireDataset);
	}
	
	public java.util.Collection<java.lang.Integer> getMinCardinality() throws org.openanzo.rdf.jastor.JastorException {
		return getMinCardinality(false);
	}

	public void addMinCardinality(java.lang.Integer minCardinality) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(minCardinality,"http://www.w3.org/2001/XMLSchema#int");
		if (_dataset.contains(_resource, minCardinalityProperty,_literal,_graph.getNamedGraphUri()))
			return;
	
		if (minCardinality != null) {
			_dataset.add(_resource, minCardinalityProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeMinCardinality(java.lang.Integer minCardinality) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(minCardinality,"http://www.w3.org/2001/XMLSchema#int");
		if (!_dataset.contains(_resource, minCardinalityProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, minCardinalityProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'cardinality'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.ObjectRestriction#cardinalityProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearCardinality(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, cardinalityProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2002/07/owl#cardinality


	org.openanzo.rdf.jastor.PropertyCollection<java.lang.Integer> propertyCollectionCardinality = new org.openanzo.rdf.jastor.PropertyCollection<java.lang.Integer>() {
		public java.lang.Integer getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#int");
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://www.w3.org/2002/07/owl#cardinality properties in ObjectRestriction model not a Literal",value);
				}
			}
	};

	public java.util.Collection<java.lang.Integer> getCardinality(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionCardinality.getPropertyCollection(_dataset, _graph, _resource,cardinalityProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#int"), includeEntireDataset);
	}
	
	public java.util.Collection<java.lang.Integer> getCardinality() throws org.openanzo.rdf.jastor.JastorException {
		return getCardinality(false);
	}

	public void addCardinality(java.lang.Integer cardinality) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(cardinality,"http://www.w3.org/2001/XMLSchema#int");
		if (_dataset.contains(_resource, cardinalityProperty,_literal,_graph.getNamedGraphUri()))
			return;
	
		if (cardinality != null) {
			_dataset.add(_resource, cardinalityProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeCardinality(java.lang.Integer cardinality) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(cardinality,"http://www.w3.org/2001/XMLSchema#int");
		if (!_dataset.contains(_resource, cardinalityProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, cardinalityProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'onProperty'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.ObjectRestriction#onPropertyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearOnProperty(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, onPropertyProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2002/07/owl#onProperty

	public org.openanzo.rdf.rdfs._Property getOnProperty(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, onPropertyProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": onProperty getProperty() in org.openanzo.rdf.owl.ObjectRestriction model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.rdfs.RDFSFactory.get_Property(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.rdfs._Property getOnProperty() throws org.openanzo.rdf.jastor.JastorException {
		return getOnProperty(false);
	}

	public void setOnProperty(org.openanzo.rdf.rdfs._Property onProperty) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, onPropertyProperty, null,_graph.getNamedGraphUri());
		if (onProperty != null) {
			_dataset.add(_resource, onPropertyProperty, onProperty.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.rdfs._Property setOnProperty() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, onPropertyProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.rdfs._Property onProperty = org.openanzo.rdf.rdfs.RDFSFactory.create_Property(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, onPropertyProperty, onProperty.resource(),_graph.getNamedGraphUri());
		return onProperty;
	}
	
	public org.openanzo.rdf.rdfs._Property setOnProperty(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, onPropertyProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, onPropertyProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.rdfs._Property onProperty = org.openanzo.rdf.rdfs.RDFSFactory.get_Property(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, onPropertyProperty, onProperty.resource(),_graph.getNamedGraphUri());
		return onProperty;
	}
	
	/**
	 * Clears all values for 'onClass'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.ObjectRestriction#onClassProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearOnClass(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, onClassProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2006/12/owl11#onClass

	public org.openanzo.rdf.owl.Class getOnClass(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, onClassProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": onClass getProperty() in org.openanzo.rdf.owl.ObjectRestriction model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.owl.OWL11Factory.getClass(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.owl.Class getOnClass() throws org.openanzo.rdf.jastor.JastorException {
		return getOnClass(false);
	}

	public void setOnClass(org.openanzo.rdf.owl.Class onClass) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, onClassProperty, null,_graph.getNamedGraphUri());
		if (onClass != null) {
			_dataset.add(_resource, onClassProperty, onClass.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.owl.Class setOnClass() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, onClassProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.owl.Class onClass = org.openanzo.rdf.owl.OWL11Factory.createClass(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, onClassProperty, onClass.resource(),_graph.getNamedGraphUri());
		return onClass;
	}
	
	public org.openanzo.rdf.owl.Class setOnClass(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, onClassProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, onClassProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.owl.Class onClass = org.openanzo.rdf.owl.OWL11Factory.getClass(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, onClassProperty, onClass.resource(),_graph.getNamedGraphUri());
		return onClass;
	}
	 




}