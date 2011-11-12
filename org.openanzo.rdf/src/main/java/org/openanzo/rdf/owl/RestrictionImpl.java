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
 * Implementation of {@link org.openanzo.rdf.owl.Restriction}
 * Use the org.openanzo.rdf.owl.OWL11Factory to create instances of this class.
 * <p>(URI: http://www.w3.org/2002/07/owl#Restriction)</p>
 * <br>
 */
public class RestrictionImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.rdf.owl.Restriction {

	protected static final org.openanzo.rdf.URI maxCardinalityProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#maxCardinality");
	protected static final org.openanzo.rdf.URI minCardinalityProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#minCardinality");
	protected static final org.openanzo.rdf.URI cardinalityProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#cardinality");
	protected static final org.openanzo.rdf.URI onPropertyProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#onProperty");
	protected static final org.openanzo.rdf.URI hasValueProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#hasValue");
	protected static final org.openanzo.rdf.URI allValuesFromProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#allValuesFrom");
	protected static final org.openanzo.rdf.URI someValuesFromProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#someValuesFrom");

	RestrictionImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
	}   
	   
    	
	static RestrictionImpl getRestriction(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Restriction.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new RestrictionImpl(resource, namedGraphUri, dataset);
	}
	    
	static RestrictionImpl createRestriction(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		RestrictionImpl impl = new RestrictionImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Restriction.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Restriction.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, hasValueProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, allValuesFromProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, someValuesFromProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.owl.Restriction.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'maxCardinality'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.Restriction#maxCardinalityProperty
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
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://www.w3.org/2002/07/owl#maxCardinality properties in Restriction model not a Literal",value);
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
	 * @see			org.openanzo.rdf.owl.Restriction#minCardinalityProperty
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
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://www.w3.org/2002/07/owl#minCardinality properties in Restriction model not a Literal",value);
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
	 * @see			org.openanzo.rdf.owl.Restriction#cardinalityProperty
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
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://www.w3.org/2002/07/owl#cardinality properties in Restriction model not a Literal",value);
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
	 * @see			org.openanzo.rdf.owl.Restriction#onPropertyProperty
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": onProperty getProperty() in org.openanzo.rdf.owl.Restriction model not Resource", statement.getObject());
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
	 * Clears all values for 'hasValue'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.Restriction#hasValueProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearHasValue(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, hasValueProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2002/07/owl#hasValue
	public org.openanzo.rdf.URI getHasValue(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, hasValueProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;
		if (!(statement.getObject() instanceof org.openanzo.rdf.URI))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": hasValue getProperty() in org.openanzo.rdf.owl.Restriction model not URI", statement.getObject());
		return (org.openanzo.rdf.URI)statement.getObject();
		
	}
	
	public org.openanzo.rdf.URI getHasValue() throws org.openanzo.rdf.jastor.JastorException {
		return getHasValue(false);
	}
	
	public void setHasValue(org.openanzo.rdf.URI hasValue) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, hasValueProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (hasValue != null) {
	
			_dataset.add(_resource, hasValueProperty, hasValue,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'allValuesFrom'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.Restriction#allValuesFromProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearAllValuesFrom(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, allValuesFromProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2002/07/owl#allValuesFrom

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing> propertyCollectionAllValuesFrom = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing>() {
		public org.openanzo.rdf.jastor.Thing getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.jastor.ThingFactory.getThing((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getAllValuesFrom(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionAllValuesFrom.getPropertyCollection(_dataset, _graph, _resource,allValuesFromProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#Entity"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getAllValuesFrom() throws org.openanzo.rdf.jastor.JastorException {
		return getAllValuesFrom(false);
	}

	public void addAllValuesFrom(org.openanzo.rdf.jastor.Thing allValuesFrom) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, allValuesFromProperty,allValuesFrom.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.jastor.Thing addAllValuesFrom() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing allValuesFrom = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, allValuesFromProperty,allValuesFrom.resource(),_graph.getNamedGraphUri());
		return allValuesFrom;
	}
	
	public org.openanzo.rdf.jastor.Thing addAllValuesFrom(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing allValuesFrom = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, allValuesFromProperty,allValuesFrom.resource(),_graph.getNamedGraphUri());
		return allValuesFrom;
	}
	
	public void removeAllValuesFrom(org.openanzo.rdf.jastor.Thing allValuesFrom) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, allValuesFromProperty, allValuesFrom.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, allValuesFromProperty, allValuesFrom.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeAllValuesFrom(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, allValuesFromProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, allValuesFromProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'someValuesFrom'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.Restriction#someValuesFromProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSomeValuesFrom(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, someValuesFromProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2002/07/owl#someValuesFrom

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing> propertyCollectionSomeValuesFrom = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing>() {
		public org.openanzo.rdf.jastor.Thing getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.jastor.ThingFactory.getThing((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getSomeValuesFrom(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionSomeValuesFrom.getPropertyCollection(_dataset, _graph, _resource,someValuesFromProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#Entity"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getSomeValuesFrom() throws org.openanzo.rdf.jastor.JastorException {
		return getSomeValuesFrom(false);
	}

	public void addSomeValuesFrom(org.openanzo.rdf.jastor.Thing someValuesFrom) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, someValuesFromProperty,someValuesFrom.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.jastor.Thing addSomeValuesFrom() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing someValuesFrom = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, someValuesFromProperty,someValuesFrom.resource(),_graph.getNamedGraphUri());
		return someValuesFrom;
	}
	
	public org.openanzo.rdf.jastor.Thing addSomeValuesFrom(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing someValuesFrom = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, someValuesFromProperty,someValuesFrom.resource(),_graph.getNamedGraphUri());
		return someValuesFrom;
	}
	
	public void removeSomeValuesFrom(org.openanzo.rdf.jastor.Thing someValuesFrom) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, someValuesFromProperty, someValuesFrom.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, someValuesFromProperty, someValuesFrom.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeSomeValuesFrom(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, someValuesFromProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, someValuesFromProperty, resource,_graph.getNamedGraphUri());
	}
  




}