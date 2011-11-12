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
 * Implementation of {@link org.openanzo.rdf.owl.DatatypeProperty}
 * Use the org.openanzo.rdf.owl.OWL11Factory to create instances of this class.
 * <p>(URI: http://www.w3.org/2002/07/owl#DatatypeProperty)</p>
 * <br>
 */
public class DatatypePropertyImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.rdf.owl.DatatypeProperty {

	protected static final org.openanzo.rdf.URI commentProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2000/01/rdf-schema#comment");
	protected static final org.openanzo.rdf.URI labelProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2000/01/rdf-schema#label");
	protected static final org.openanzo.rdf.URI typeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
	protected static final org.openanzo.rdf.URI valueProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/1999/02/22-rdf-syntax-ns#value");
	protected static final org.openanzo.rdf.URI isDefinedByProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2000/01/rdf-schema#isDefinedBy");
	protected static final org.openanzo.rdf.URI memberProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2000/01/rdf-schema#member");
	protected static final org.openanzo.rdf.URI seeAlsoProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2000/01/rdf-schema#seeAlso");
	protected static final org.openanzo.rdf.URI domainProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2000/01/rdf-schema#domain");
	protected static final org.openanzo.rdf.URI rangeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2000/01/rdf-schema#range");
	protected static final org.openanzo.rdf.URI subPropertyOfProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2000/01/rdf-schema#subPropertyOf");
	protected static final org.openanzo.rdf.URI equivalentPropertyProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#equivalentProperty");
	protected static final org.openanzo.rdf.URI dataPropertyDomainProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2006/12/owl11#dataPropertyDomain");
	protected static final org.openanzo.rdf.URI dataPropertyRangeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2006/12/owl11#dataPropertyRange");
	protected static final org.openanzo.rdf.URI disjointDataPropertiesProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2006/12/owl11#disjointDataProperties");
	protected static final org.openanzo.rdf.URI equivalentDataPropertyProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2006/12/owl11#equivalentDataProperty");
	protected static final org.openanzo.rdf.URI subDataPropertyOfProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2006/12/owl11#subDataPropertyOf");

	DatatypePropertyImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
	}   
	   
    	
	static DatatypePropertyImpl getDatatypeProperty(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, DatatypeProperty.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new DatatypePropertyImpl(resource, namedGraphUri, dataset);
	}
	    
	static DatatypePropertyImpl createDatatypeProperty(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		DatatypePropertyImpl impl = new DatatypePropertyImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, DatatypeProperty.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, DatatypeProperty.TYPE, namedGraphUri);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	void addSuperTypes() {
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.rdfs._Resource.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.rdfs._Resource.TYPE,_graph.getNamedGraphUri());     
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.rdfs._Property.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.rdfs._Property.TYPE,_graph.getNamedGraphUri());     
	}
   
	void addHasValueValues() {
	}
   
	public java.util.Collection<org.openanzo.rdf.Statement> listStatements() {
		java.util.Collection<org.openanzo.rdf.Statement> list = new java.util.HashSet<org.openanzo.rdf.Statement>();
		
		list.addAll(_dataset.find(_resource, commentProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, labelProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, typeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, valueProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, isDefinedByProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, memberProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, seeAlsoProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, domainProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, rangeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, subPropertyOfProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, equivalentPropertyProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, dataPropertyDomainProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, dataPropertyRangeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, disjointDataPropertiesProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, equivalentDataPropertyProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, subDataPropertyOfProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.owl.DatatypeProperty.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.rdfs._Resource.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.rdfs._Property.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'comment'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.DatatypeProperty#commentProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearComment(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, commentProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2000/01/rdf-schema#comment


	org.openanzo.rdf.jastor.PropertyCollection<java.lang.String> propertyCollectionComment = new org.openanzo.rdf.jastor.PropertyCollection<java.lang.String>() {
		public java.lang.String getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://www.w3.org/2000/01/rdf-schema#comment properties in DatatypeProperty model not a Literal",value);
				}
			}
	};

	public java.util.Collection<java.lang.String> getComment(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionComment.getPropertyCollection(_dataset, _graph, _resource,commentProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#string"), includeEntireDataset);
	}
	
	public java.util.Collection<java.lang.String> getComment() throws org.openanzo.rdf.jastor.JastorException {
		return getComment(false);
	}

	public void addComment(java.lang.String comment) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(comment,"http://www.w3.org/2001/XMLSchema#string");
		if (_dataset.contains(_resource, commentProperty,_literal,_graph.getNamedGraphUri()))
			return;
	
		if (comment != null) {
			_dataset.add(_resource, commentProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeComment(java.lang.String comment) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(comment,"http://www.w3.org/2001/XMLSchema#string");
		if (!_dataset.contains(_resource, commentProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, commentProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'label'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.DatatypeProperty#labelProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearLabel(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, labelProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2000/01/rdf-schema#label


	org.openanzo.rdf.jastor.PropertyCollection<java.lang.String> propertyCollectionLabel = new org.openanzo.rdf.jastor.PropertyCollection<java.lang.String>() {
		public java.lang.String getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://www.w3.org/2000/01/rdf-schema#label properties in DatatypeProperty model not a Literal",value);
				}
			}
	};

	public java.util.Collection<java.lang.String> getLabel(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionLabel.getPropertyCollection(_dataset, _graph, _resource,labelProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#string"), includeEntireDataset);
	}
	
	public java.util.Collection<java.lang.String> getLabel() throws org.openanzo.rdf.jastor.JastorException {
		return getLabel(false);
	}

	public void addLabel(java.lang.String label) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(label,"http://www.w3.org/2001/XMLSchema#string");
		if (_dataset.contains(_resource, labelProperty,_literal,_graph.getNamedGraphUri()))
			return;
	
		if (label != null) {
			_dataset.add(_resource, labelProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeLabel(java.lang.String label) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(label,"http://www.w3.org/2001/XMLSchema#string");
		if (!_dataset.contains(_resource, labelProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, labelProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'type'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.DatatypeProperty#typeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, typeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/1999/02/22-rdf-syntax-ns#type

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.rdfs.Class> propertyCollectionType = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.rdfs.Class>() {
		public org.openanzo.rdf.rdfs.Class getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.rdfs.RDFSFactory.getClass((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.rdfs.Class> getType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionType.getPropertyCollection(_dataset, _graph, _resource,typeProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Class"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.rdfs.Class> getType() throws org.openanzo.rdf.jastor.JastorException {
		return getType(false);
	}

	public void addType(org.openanzo.rdf.rdfs.Class type) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, typeProperty,type.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.rdfs.Class addType() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.rdfs.Class type = org.openanzo.rdf.rdfs.RDFSFactory.createClass(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, typeProperty,type.resource(),_graph.getNamedGraphUri());
		return type;
	}
	
	public org.openanzo.rdf.rdfs.Class addType(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.rdfs.Class type = org.openanzo.rdf.rdfs.RDFSFactory.getClass(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, typeProperty,type.resource(),_graph.getNamedGraphUri());
		return type;
	}
	
	public void removeType(org.openanzo.rdf.rdfs.Class type) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, typeProperty, type.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, typeProperty, type.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeType(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, typeProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, typeProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'value'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.DatatypeProperty#valueProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearValue(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, valueProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/1999/02/22-rdf-syntax-ns#value

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.rdfs._Resource> propertyCollectionValue = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.rdfs._Resource>() {
		public org.openanzo.rdf.rdfs._Resource getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.rdfs.RDFSFactory.get_Resource((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.rdfs._Resource> getValue(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionValue.getPropertyCollection(_dataset, _graph, _resource,valueProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Resource"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.rdfs._Resource> getValue() throws org.openanzo.rdf.jastor.JastorException {
		return getValue(false);
	}

	public void addValue(org.openanzo.rdf.rdfs._Resource value) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, valueProperty,value.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.rdfs._Resource addValue() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.rdfs._Resource value = org.openanzo.rdf.rdfs.RDFSFactory.create_Resource(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, valueProperty,value.resource(),_graph.getNamedGraphUri());
		return value;
	}
	
	public org.openanzo.rdf.rdfs._Resource addValue(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.rdfs._Resource value = org.openanzo.rdf.rdfs.RDFSFactory.get_Resource(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, valueProperty,value.resource(),_graph.getNamedGraphUri());
		return value;
	}
	
	public void removeValue(org.openanzo.rdf.rdfs._Resource value) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, valueProperty, value.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, valueProperty, value.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeValue(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, valueProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, valueProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'isDefinedBy'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.DatatypeProperty#isDefinedByProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearIsDefinedBy(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, isDefinedByProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2000/01/rdf-schema#isDefinedBy

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.rdfs._Resource> propertyCollectionIsDefinedBy = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.rdfs._Resource>() {
		public org.openanzo.rdf.rdfs._Resource getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.rdfs.RDFSFactory.get_Resource((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.rdfs._Resource> getIsDefinedBy(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionIsDefinedBy.getPropertyCollection(_dataset, _graph, _resource,isDefinedByProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Resource"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.rdfs._Resource> getIsDefinedBy() throws org.openanzo.rdf.jastor.JastorException {
		return getIsDefinedBy(false);
	}

	public void addIsDefinedBy(org.openanzo.rdf.rdfs._Resource isDefinedBy) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, isDefinedByProperty,isDefinedBy.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.rdfs._Resource addIsDefinedBy() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.rdfs._Resource isDefinedBy = org.openanzo.rdf.rdfs.RDFSFactory.create_Resource(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, isDefinedByProperty,isDefinedBy.resource(),_graph.getNamedGraphUri());
		return isDefinedBy;
	}
	
	public org.openanzo.rdf.rdfs._Resource addIsDefinedBy(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.rdfs._Resource isDefinedBy = org.openanzo.rdf.rdfs.RDFSFactory.get_Resource(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, isDefinedByProperty,isDefinedBy.resource(),_graph.getNamedGraphUri());
		return isDefinedBy;
	}
	
	public void removeIsDefinedBy(org.openanzo.rdf.rdfs._Resource isDefinedBy) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, isDefinedByProperty, isDefinedBy.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, isDefinedByProperty, isDefinedBy.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeIsDefinedBy(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, isDefinedByProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, isDefinedByProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'member'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.DatatypeProperty#memberProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearMember(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, memberProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2000/01/rdf-schema#member

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.rdfs._Resource> propertyCollectionMember = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.rdfs._Resource>() {
		public org.openanzo.rdf.rdfs._Resource getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.rdfs.RDFSFactory.get_Resource((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.rdfs._Resource> getMember(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionMember.getPropertyCollection(_dataset, _graph, _resource,memberProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Resource"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.rdfs._Resource> getMember() throws org.openanzo.rdf.jastor.JastorException {
		return getMember(false);
	}

	public void addMember(org.openanzo.rdf.rdfs._Resource member) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, memberProperty,member.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.rdfs._Resource addMember() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.rdfs._Resource member = org.openanzo.rdf.rdfs.RDFSFactory.create_Resource(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, memberProperty,member.resource(),_graph.getNamedGraphUri());
		return member;
	}
	
	public org.openanzo.rdf.rdfs._Resource addMember(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.rdfs._Resource member = org.openanzo.rdf.rdfs.RDFSFactory.get_Resource(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, memberProperty,member.resource(),_graph.getNamedGraphUri());
		return member;
	}
	
	public void removeMember(org.openanzo.rdf.rdfs._Resource member) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, memberProperty, member.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, memberProperty, member.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeMember(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, memberProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, memberProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'seeAlso'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.DatatypeProperty#seeAlsoProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSeeAlso(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, seeAlsoProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2000/01/rdf-schema#seeAlso

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.rdfs._Resource> propertyCollectionSeeAlso = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.rdfs._Resource>() {
		public org.openanzo.rdf.rdfs._Resource getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.rdfs.RDFSFactory.get_Resource((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.rdfs._Resource> getSeeAlso(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionSeeAlso.getPropertyCollection(_dataset, _graph, _resource,seeAlsoProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Resource"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.rdfs._Resource> getSeeAlso() throws org.openanzo.rdf.jastor.JastorException {
		return getSeeAlso(false);
	}

	public void addSeeAlso(org.openanzo.rdf.rdfs._Resource seeAlso) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, seeAlsoProperty,seeAlso.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.rdfs._Resource addSeeAlso() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.rdfs._Resource seeAlso = org.openanzo.rdf.rdfs.RDFSFactory.create_Resource(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, seeAlsoProperty,seeAlso.resource(),_graph.getNamedGraphUri());
		return seeAlso;
	}
	
	public org.openanzo.rdf.rdfs._Resource addSeeAlso(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.rdfs._Resource seeAlso = org.openanzo.rdf.rdfs.RDFSFactory.get_Resource(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, seeAlsoProperty,seeAlso.resource(),_graph.getNamedGraphUri());
		return seeAlso;
	}
	
	public void removeSeeAlso(org.openanzo.rdf.rdfs._Resource seeAlso) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, seeAlsoProperty, seeAlso.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, seeAlsoProperty, seeAlso.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeSeeAlso(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, seeAlsoProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, seeAlsoProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'domain'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.DatatypeProperty#domainProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDomain(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, domainProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2000/01/rdf-schema#domain

	public org.openanzo.rdf.rdfs.Class getDomain(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, domainProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": domain getProperty() in org.openanzo.rdf.owl.DatatypeProperty model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.rdfs.RDFSFactory.getClass(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.rdfs.Class getDomain() throws org.openanzo.rdf.jastor.JastorException {
		return getDomain(false);
	}

	public void setDomain(org.openanzo.rdf.rdfs.Class domain) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, domainProperty, null,_graph.getNamedGraphUri());
		if (domain != null) {
			_dataset.add(_resource, domainProperty, domain.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.rdfs.Class setDomain() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, domainProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.rdfs.Class domain = org.openanzo.rdf.rdfs.RDFSFactory.createClass(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, domainProperty, domain.resource(),_graph.getNamedGraphUri());
		return domain;
	}
	
	public org.openanzo.rdf.rdfs.Class setDomain(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, domainProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, domainProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.rdfs.Class domain = org.openanzo.rdf.rdfs.RDFSFactory.getClass(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, domainProperty, domain.resource(),_graph.getNamedGraphUri());
		return domain;
	}
	
	/**
	 * Clears all values for 'range'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.DatatypeProperty#rangeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearRange(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, rangeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2000/01/rdf-schema#range

	public org.openanzo.rdf.rdfs.Class getRange(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, rangeProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": range getProperty() in org.openanzo.rdf.owl.DatatypeProperty model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.rdfs.RDFSFactory.getClass(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.rdfs.Class getRange() throws org.openanzo.rdf.jastor.JastorException {
		return getRange(false);
	}

	public void setRange(org.openanzo.rdf.rdfs.Class range) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, rangeProperty, null,_graph.getNamedGraphUri());
		if (range != null) {
			_dataset.add(_resource, rangeProperty, range.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.rdfs.Class setRange() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, rangeProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.rdfs.Class range = org.openanzo.rdf.rdfs.RDFSFactory.createClass(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, rangeProperty, range.resource(),_graph.getNamedGraphUri());
		return range;
	}
	
	public org.openanzo.rdf.rdfs.Class setRange(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, rangeProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, rangeProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.rdfs.Class range = org.openanzo.rdf.rdfs.RDFSFactory.getClass(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, rangeProperty, range.resource(),_graph.getNamedGraphUri());
		return range;
	}
	
	/**
	 * Clears all values for 'subPropertyOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.DatatypeProperty#subPropertyOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSubPropertyOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, subPropertyOfProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2000/01/rdf-schema#subPropertyOf

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.rdfs._Property> propertyCollectionSubPropertyOf = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.rdfs._Property>() {
		public org.openanzo.rdf.rdfs._Property getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.rdfs.RDFSFactory.get_Property((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.rdfs._Property> getSubPropertyOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionSubPropertyOf.getPropertyCollection(_dataset, _graph, _resource,subPropertyOfProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/1999/02/22-rdf-syntax-ns#Property"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.rdfs._Property> getSubPropertyOf() throws org.openanzo.rdf.jastor.JastorException {
		return getSubPropertyOf(false);
	}

	public void addSubPropertyOf(org.openanzo.rdf.rdfs._Property subPropertyOf) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, subPropertyOfProperty,subPropertyOf.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.rdfs._Property addSubPropertyOf() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.rdfs._Property subPropertyOf = org.openanzo.rdf.rdfs.RDFSFactory.create_Property(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, subPropertyOfProperty,subPropertyOf.resource(),_graph.getNamedGraphUri());
		return subPropertyOf;
	}
	
	public org.openanzo.rdf.rdfs._Property addSubPropertyOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.rdfs._Property subPropertyOf = org.openanzo.rdf.rdfs.RDFSFactory.get_Property(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, subPropertyOfProperty,subPropertyOf.resource(),_graph.getNamedGraphUri());
		return subPropertyOf;
	}
	
	public void removeSubPropertyOf(org.openanzo.rdf.rdfs._Property subPropertyOf) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, subPropertyOfProperty, subPropertyOf.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, subPropertyOfProperty, subPropertyOf.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeSubPropertyOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, subPropertyOfProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, subPropertyOfProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'equivalentProperty'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.DatatypeProperty#equivalentPropertyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearEquivalentProperty(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, equivalentPropertyProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2002/07/owl#equivalentProperty

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.DatatypeProperty> propertyCollectionEquivalentProperty = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.DatatypeProperty>() {
		public org.openanzo.rdf.owl.DatatypeProperty getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.owl.OWL11Factory.getDatatypeProperty((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.owl.DatatypeProperty> getEquivalentProperty(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionEquivalentProperty.getPropertyCollection(_dataset, _graph, _resource,equivalentPropertyProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#DatatypeProperty"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.owl.DatatypeProperty> getEquivalentProperty() throws org.openanzo.rdf.jastor.JastorException {
		return getEquivalentProperty(false);
	}

	public void addEquivalentProperty(org.openanzo.rdf.owl.DatatypeProperty equivalentProperty) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, equivalentPropertyProperty,equivalentProperty.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.owl.DatatypeProperty addEquivalentProperty() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.DatatypeProperty equivalentProperty = org.openanzo.rdf.owl.OWL11Factory.createDatatypeProperty(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, equivalentPropertyProperty,equivalentProperty.resource(),_graph.getNamedGraphUri());
		return equivalentProperty;
	}
	
	public org.openanzo.rdf.owl.DatatypeProperty addEquivalentProperty(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.DatatypeProperty equivalentProperty = org.openanzo.rdf.owl.OWL11Factory.getDatatypeProperty(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, equivalentPropertyProperty,equivalentProperty.resource(),_graph.getNamedGraphUri());
		return equivalentProperty;
	}
	
	public void removeEquivalentProperty(org.openanzo.rdf.owl.DatatypeProperty equivalentProperty) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, equivalentPropertyProperty, equivalentProperty.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, equivalentPropertyProperty, equivalentProperty.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeEquivalentProperty(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, equivalentPropertyProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, equivalentPropertyProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'dataPropertyDomain'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.DatatypeProperty#dataPropertyDomainProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDataPropertyDomain(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, dataPropertyDomainProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2006/12/owl11#dataPropertyDomain

	public org.openanzo.rdf.owl.Class getDataPropertyDomain(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, dataPropertyDomainProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": dataPropertyDomain getProperty() in org.openanzo.rdf.owl.DatatypeProperty model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.owl.OWL11Factory.getClass(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.owl.Class getDataPropertyDomain() throws org.openanzo.rdf.jastor.JastorException {
		return getDataPropertyDomain(false);
	}

	public void setDataPropertyDomain(org.openanzo.rdf.owl.Class dataPropertyDomain) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, dataPropertyDomainProperty, null,_graph.getNamedGraphUri());
		if (dataPropertyDomain != null) {
			_dataset.add(_resource, dataPropertyDomainProperty, dataPropertyDomain.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.owl.Class setDataPropertyDomain() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, dataPropertyDomainProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.owl.Class dataPropertyDomain = org.openanzo.rdf.owl.OWL11Factory.createClass(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, dataPropertyDomainProperty, dataPropertyDomain.resource(),_graph.getNamedGraphUri());
		return dataPropertyDomain;
	}
	
	public org.openanzo.rdf.owl.Class setDataPropertyDomain(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, dataPropertyDomainProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, dataPropertyDomainProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.owl.Class dataPropertyDomain = org.openanzo.rdf.owl.OWL11Factory.getClass(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, dataPropertyDomainProperty, dataPropertyDomain.resource(),_graph.getNamedGraphUri());
		return dataPropertyDomain;
	}
	
	/**
	 * Clears all values for 'dataPropertyRange'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.DatatypeProperty#dataPropertyRangeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDataPropertyRange(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, dataPropertyRangeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2006/12/owl11#dataPropertyRange

	public org.openanzo.rdf.owl.DataRange getDataPropertyRange(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, dataPropertyRangeProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": dataPropertyRange getProperty() in org.openanzo.rdf.owl.DatatypeProperty model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.owl.OWL11Factory.getDataRange(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.owl.DataRange getDataPropertyRange() throws org.openanzo.rdf.jastor.JastorException {
		return getDataPropertyRange(false);
	}

	public void setDataPropertyRange(org.openanzo.rdf.owl.DataRange dataPropertyRange) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, dataPropertyRangeProperty, null,_graph.getNamedGraphUri());
		if (dataPropertyRange != null) {
			_dataset.add(_resource, dataPropertyRangeProperty, dataPropertyRange.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.owl.DataRange setDataPropertyRange() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, dataPropertyRangeProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.owl.DataRange dataPropertyRange = org.openanzo.rdf.owl.OWL11Factory.createDataRange(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, dataPropertyRangeProperty, dataPropertyRange.resource(),_graph.getNamedGraphUri());
		return dataPropertyRange;
	}
	
	public org.openanzo.rdf.owl.DataRange setDataPropertyRange(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, dataPropertyRangeProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, dataPropertyRangeProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.owl.DataRange dataPropertyRange = org.openanzo.rdf.owl.OWL11Factory.getDataRange(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, dataPropertyRangeProperty, dataPropertyRange.resource(),_graph.getNamedGraphUri());
		return dataPropertyRange;
	}
	
	/**
	 * Clears all values for 'disjointDataProperties'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.DatatypeProperty#disjointDataPropertiesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDisjointDataProperties(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, disjointDataPropertiesProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2006/12/owl11#disjointDataProperties

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.DatatypeProperty> propertyCollectionDisjointDataProperties = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.DatatypeProperty>() {
		public org.openanzo.rdf.owl.DatatypeProperty getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.owl.OWL11Factory.getDatatypeProperty((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.owl.DatatypeProperty> getDisjointDataProperties(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionDisjointDataProperties.getPropertyCollection(_dataset, _graph, _resource,disjointDataPropertiesProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#DatatypeProperty"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.owl.DatatypeProperty> getDisjointDataProperties() throws org.openanzo.rdf.jastor.JastorException {
		return getDisjointDataProperties(false);
	}

	public void addDisjointDataProperties(org.openanzo.rdf.owl.DatatypeProperty disjointDataProperties) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, disjointDataPropertiesProperty,disjointDataProperties.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.owl.DatatypeProperty addDisjointDataProperties() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.DatatypeProperty disjointDataProperties = org.openanzo.rdf.owl.OWL11Factory.createDatatypeProperty(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, disjointDataPropertiesProperty,disjointDataProperties.resource(),_graph.getNamedGraphUri());
		return disjointDataProperties;
	}
	
	public org.openanzo.rdf.owl.DatatypeProperty addDisjointDataProperties(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.DatatypeProperty disjointDataProperties = org.openanzo.rdf.owl.OWL11Factory.getDatatypeProperty(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, disjointDataPropertiesProperty,disjointDataProperties.resource(),_graph.getNamedGraphUri());
		return disjointDataProperties;
	}
	
	public void removeDisjointDataProperties(org.openanzo.rdf.owl.DatatypeProperty disjointDataProperties) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, disjointDataPropertiesProperty, disjointDataProperties.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, disjointDataPropertiesProperty, disjointDataProperties.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeDisjointDataProperties(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, disjointDataPropertiesProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, disjointDataPropertiesProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'equivalentDataProperty'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.DatatypeProperty#equivalentDataPropertyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearEquivalentDataProperty(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, equivalentDataPropertyProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2006/12/owl11#equivalentDataProperty

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.DatatypeProperty> propertyCollectionEquivalentDataProperty = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.DatatypeProperty>() {
		public org.openanzo.rdf.owl.DatatypeProperty getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.owl.OWL11Factory.getDatatypeProperty((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.owl.DatatypeProperty> getEquivalentDataProperty(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionEquivalentDataProperty.getPropertyCollection(_dataset, _graph, _resource,equivalentDataPropertyProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#DatatypeProperty"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.owl.DatatypeProperty> getEquivalentDataProperty() throws org.openanzo.rdf.jastor.JastorException {
		return getEquivalentDataProperty(false);
	}

	public void addEquivalentDataProperty(org.openanzo.rdf.owl.DatatypeProperty equivalentDataProperty) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, equivalentDataPropertyProperty,equivalentDataProperty.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.owl.DatatypeProperty addEquivalentDataProperty() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.DatatypeProperty equivalentDataProperty = org.openanzo.rdf.owl.OWL11Factory.createDatatypeProperty(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, equivalentDataPropertyProperty,equivalentDataProperty.resource(),_graph.getNamedGraphUri());
		return equivalentDataProperty;
	}
	
	public org.openanzo.rdf.owl.DatatypeProperty addEquivalentDataProperty(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.DatatypeProperty equivalentDataProperty = org.openanzo.rdf.owl.OWL11Factory.getDatatypeProperty(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, equivalentDataPropertyProperty,equivalentDataProperty.resource(),_graph.getNamedGraphUri());
		return equivalentDataProperty;
	}
	
	public void removeEquivalentDataProperty(org.openanzo.rdf.owl.DatatypeProperty equivalentDataProperty) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, equivalentDataPropertyProperty, equivalentDataProperty.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, equivalentDataPropertyProperty, equivalentDataProperty.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeEquivalentDataProperty(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, equivalentDataPropertyProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, equivalentDataPropertyProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'subDataPropertyOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.DatatypeProperty#subDataPropertyOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSubDataPropertyOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, subDataPropertyOfProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2006/12/owl11#subDataPropertyOf

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.DatatypeProperty> propertyCollectionSubDataPropertyOf = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.DatatypeProperty>() {
		public org.openanzo.rdf.owl.DatatypeProperty getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.owl.OWL11Factory.getDatatypeProperty((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.owl.DatatypeProperty> getSubDataPropertyOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionSubDataPropertyOf.getPropertyCollection(_dataset, _graph, _resource,subDataPropertyOfProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#DatatypeProperty"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.owl.DatatypeProperty> getSubDataPropertyOf() throws org.openanzo.rdf.jastor.JastorException {
		return getSubDataPropertyOf(false);
	}

	public void addSubDataPropertyOf(org.openanzo.rdf.owl.DatatypeProperty subDataPropertyOf) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, subDataPropertyOfProperty,subDataPropertyOf.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.owl.DatatypeProperty addSubDataPropertyOf() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.DatatypeProperty subDataPropertyOf = org.openanzo.rdf.owl.OWL11Factory.createDatatypeProperty(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, subDataPropertyOfProperty,subDataPropertyOf.resource(),_graph.getNamedGraphUri());
		return subDataPropertyOf;
	}
	
	public org.openanzo.rdf.owl.DatatypeProperty addSubDataPropertyOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.DatatypeProperty subDataPropertyOf = org.openanzo.rdf.owl.OWL11Factory.getDatatypeProperty(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, subDataPropertyOfProperty,subDataPropertyOf.resource(),_graph.getNamedGraphUri());
		return subDataPropertyOf;
	}
	
	public void removeSubDataPropertyOf(org.openanzo.rdf.owl.DatatypeProperty subDataPropertyOf) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, subDataPropertyOfProperty, subDataPropertyOf.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, subDataPropertyOfProperty, subDataPropertyOf.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeSubDataPropertyOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, subDataPropertyOfProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, subDataPropertyOfProperty, resource,_graph.getNamedGraphUri());
	}
  




}