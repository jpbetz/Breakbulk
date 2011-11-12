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
 * Implementation of {@link org.openanzo.rdf.owl.SymmetricProperty}
 * Use the org.openanzo.rdf.owl.OWL11Factory to create instances of this class.
 * <p>(URI: http://www.w3.org/2002/07/owl#SymmetricProperty)</p>
 * <br>
 */
public class SymmetricPropertyImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.rdf.owl.SymmetricProperty {

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
	protected static final org.openanzo.rdf.URI inverseOfProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#inverseOf");
	protected static final org.openanzo.rdf.URI disjointObjectPropertiesProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2006/12/owl11#disjointObjectProperties");
	protected static final org.openanzo.rdf.URI equivalentObjectPropertyProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2006/12/owl11#equivalentObjectProperty");
	protected static final org.openanzo.rdf.URI objectPropertyDomainProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2006/12/owl11#objectPropertyDomain");
	protected static final org.openanzo.rdf.URI objectPropertyRangeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2006/12/owl11#objectPropertyRange");
	protected static final org.openanzo.rdf.URI subObjectPropertyOfProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2006/12/owl11#subObjectPropertyOf");

	SymmetricPropertyImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
	}   
	   
    	
	static SymmetricPropertyImpl getSymmetricProperty(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, SymmetricProperty.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new SymmetricPropertyImpl(resource, namedGraphUri, dataset);
	}
	    
	static SymmetricPropertyImpl createSymmetricProperty(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		SymmetricPropertyImpl impl = new SymmetricPropertyImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, SymmetricProperty.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, SymmetricProperty.TYPE, namedGraphUri);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	void addSuperTypes() {
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.rdfs._Resource.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.rdfs._Resource.TYPE,_graph.getNamedGraphUri());     
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.rdfs._Property.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.rdfs._Property.TYPE,_graph.getNamedGraphUri());     
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.owl.ObjectProperty.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.owl.ObjectProperty.TYPE,_graph.getNamedGraphUri());     
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
		
		list.addAll(_dataset.find(_resource, inverseOfProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, disjointObjectPropertiesProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, equivalentObjectPropertyProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, objectPropertyDomainProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, objectPropertyRangeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, subObjectPropertyOfProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.owl.SymmetricProperty.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.rdfs._Resource.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.rdfs._Property.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.owl.ObjectProperty.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'comment'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.SymmetricProperty#commentProperty
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
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://www.w3.org/2000/01/rdf-schema#comment properties in SymmetricProperty model not a Literal",value);
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
	 * @see			org.openanzo.rdf.owl.SymmetricProperty#labelProperty
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
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://www.w3.org/2000/01/rdf-schema#label properties in SymmetricProperty model not a Literal",value);
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
	 * @see			org.openanzo.rdf.owl.SymmetricProperty#typeProperty
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
	 * @see			org.openanzo.rdf.owl.SymmetricProperty#valueProperty
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
	 * @see			org.openanzo.rdf.owl.SymmetricProperty#isDefinedByProperty
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
	 * @see			org.openanzo.rdf.owl.SymmetricProperty#memberProperty
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
	 * @see			org.openanzo.rdf.owl.SymmetricProperty#seeAlsoProperty
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
	 * @see			org.openanzo.rdf.owl.SymmetricProperty#domainProperty
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": domain getProperty() in org.openanzo.rdf.owl.SymmetricProperty model not Resource", statement.getObject());
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
	 * @see			org.openanzo.rdf.owl.SymmetricProperty#rangeProperty
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": range getProperty() in org.openanzo.rdf.owl.SymmetricProperty model not Resource", statement.getObject());
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
	 * @see			org.openanzo.rdf.owl.SymmetricProperty#subPropertyOfProperty
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
	 * Clears all values for 'inverseOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.SymmetricProperty#inverseOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearInverseOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, inverseOfProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2002/07/owl#inverseOf

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.ObjectProperty> propertyCollectionInverseOf = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.ObjectProperty>() {
		public org.openanzo.rdf.owl.ObjectProperty getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.owl.OWL11Factory.getObjectProperty((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.owl.ObjectProperty> getInverseOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionInverseOf.getPropertyCollection(_dataset, _graph, _resource,inverseOfProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#ObjectProperty"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.owl.ObjectProperty> getInverseOf() throws org.openanzo.rdf.jastor.JastorException {
		return getInverseOf(false);
	}

	public void addInverseOf(org.openanzo.rdf.owl.ObjectProperty inverseOf) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, inverseOfProperty,inverseOf.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.owl.ObjectProperty addInverseOf() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.ObjectProperty inverseOf = org.openanzo.rdf.owl.OWL11Factory.createObjectProperty(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, inverseOfProperty,inverseOf.resource(),_graph.getNamedGraphUri());
		return inverseOf;
	}
	
	public org.openanzo.rdf.owl.ObjectProperty addInverseOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.ObjectProperty inverseOf = org.openanzo.rdf.owl.OWL11Factory.getObjectProperty(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, inverseOfProperty,inverseOf.resource(),_graph.getNamedGraphUri());
		return inverseOf;
	}
	
	public void removeInverseOf(org.openanzo.rdf.owl.ObjectProperty inverseOf) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, inverseOfProperty, inverseOf.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, inverseOfProperty, inverseOf.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeInverseOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, inverseOfProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, inverseOfProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'disjointObjectProperties'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.SymmetricProperty#disjointObjectPropertiesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDisjointObjectProperties(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, disjointObjectPropertiesProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2006/12/owl11#disjointObjectProperties

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.ObjectProperty> propertyCollectionDisjointObjectProperties = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.ObjectProperty>() {
		public org.openanzo.rdf.owl.ObjectProperty getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.owl.OWL11Factory.getObjectProperty((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.owl.ObjectProperty> getDisjointObjectProperties(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionDisjointObjectProperties.getPropertyCollection(_dataset, _graph, _resource,disjointObjectPropertiesProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#ObjectProperty"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.owl.ObjectProperty> getDisjointObjectProperties() throws org.openanzo.rdf.jastor.JastorException {
		return getDisjointObjectProperties(false);
	}

	public void addDisjointObjectProperties(org.openanzo.rdf.owl.ObjectProperty disjointObjectProperties) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, disjointObjectPropertiesProperty,disjointObjectProperties.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.owl.ObjectProperty addDisjointObjectProperties() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.ObjectProperty disjointObjectProperties = org.openanzo.rdf.owl.OWL11Factory.createObjectProperty(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, disjointObjectPropertiesProperty,disjointObjectProperties.resource(),_graph.getNamedGraphUri());
		return disjointObjectProperties;
	}
	
	public org.openanzo.rdf.owl.ObjectProperty addDisjointObjectProperties(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.ObjectProperty disjointObjectProperties = org.openanzo.rdf.owl.OWL11Factory.getObjectProperty(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, disjointObjectPropertiesProperty,disjointObjectProperties.resource(),_graph.getNamedGraphUri());
		return disjointObjectProperties;
	}
	
	public void removeDisjointObjectProperties(org.openanzo.rdf.owl.ObjectProperty disjointObjectProperties) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, disjointObjectPropertiesProperty, disjointObjectProperties.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, disjointObjectPropertiesProperty, disjointObjectProperties.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeDisjointObjectProperties(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, disjointObjectPropertiesProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, disjointObjectPropertiesProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'equivalentObjectProperty'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.SymmetricProperty#equivalentObjectPropertyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearEquivalentObjectProperty(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, equivalentObjectPropertyProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2006/12/owl11#equivalentObjectProperty

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.ObjectProperty> propertyCollectionEquivalentObjectProperty = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.ObjectProperty>() {
		public org.openanzo.rdf.owl.ObjectProperty getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.owl.OWL11Factory.getObjectProperty((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.owl.ObjectProperty> getEquivalentObjectProperty(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionEquivalentObjectProperty.getPropertyCollection(_dataset, _graph, _resource,equivalentObjectPropertyProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#ObjectProperty"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.owl.ObjectProperty> getEquivalentObjectProperty() throws org.openanzo.rdf.jastor.JastorException {
		return getEquivalentObjectProperty(false);
	}

	public void addEquivalentObjectProperty(org.openanzo.rdf.owl.ObjectProperty equivalentObjectProperty) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, equivalentObjectPropertyProperty,equivalentObjectProperty.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.owl.ObjectProperty addEquivalentObjectProperty() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.ObjectProperty equivalentObjectProperty = org.openanzo.rdf.owl.OWL11Factory.createObjectProperty(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, equivalentObjectPropertyProperty,equivalentObjectProperty.resource(),_graph.getNamedGraphUri());
		return equivalentObjectProperty;
	}
	
	public org.openanzo.rdf.owl.ObjectProperty addEquivalentObjectProperty(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.ObjectProperty equivalentObjectProperty = org.openanzo.rdf.owl.OWL11Factory.getObjectProperty(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, equivalentObjectPropertyProperty,equivalentObjectProperty.resource(),_graph.getNamedGraphUri());
		return equivalentObjectProperty;
	}
	
	public void removeEquivalentObjectProperty(org.openanzo.rdf.owl.ObjectProperty equivalentObjectProperty) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, equivalentObjectPropertyProperty, equivalentObjectProperty.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, equivalentObjectPropertyProperty, equivalentObjectProperty.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeEquivalentObjectProperty(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, equivalentObjectPropertyProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, equivalentObjectPropertyProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'objectPropertyDomain'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.SymmetricProperty#objectPropertyDomainProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearObjectPropertyDomain(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, objectPropertyDomainProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2006/12/owl11#objectPropertyDomain

	public org.openanzo.rdf.owl.Class getObjectPropertyDomain(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, objectPropertyDomainProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": objectPropertyDomain getProperty() in org.openanzo.rdf.owl.SymmetricProperty model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.owl.OWL11Factory.getClass(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.owl.Class getObjectPropertyDomain() throws org.openanzo.rdf.jastor.JastorException {
		return getObjectPropertyDomain(false);
	}

	public void setObjectPropertyDomain(org.openanzo.rdf.owl.Class objectPropertyDomain) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, objectPropertyDomainProperty, null,_graph.getNamedGraphUri());
		if (objectPropertyDomain != null) {
			_dataset.add(_resource, objectPropertyDomainProperty, objectPropertyDomain.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.owl.Class setObjectPropertyDomain() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, objectPropertyDomainProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.owl.Class objectPropertyDomain = org.openanzo.rdf.owl.OWL11Factory.createClass(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, objectPropertyDomainProperty, objectPropertyDomain.resource(),_graph.getNamedGraphUri());
		return objectPropertyDomain;
	}
	
	public org.openanzo.rdf.owl.Class setObjectPropertyDomain(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, objectPropertyDomainProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, objectPropertyDomainProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.owl.Class objectPropertyDomain = org.openanzo.rdf.owl.OWL11Factory.getClass(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, objectPropertyDomainProperty, objectPropertyDomain.resource(),_graph.getNamedGraphUri());
		return objectPropertyDomain;
	}
	
	/**
	 * Clears all values for 'objectPropertyRange'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.SymmetricProperty#objectPropertyRangeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearObjectPropertyRange(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, objectPropertyRangeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2006/12/owl11#objectPropertyRange

	public org.openanzo.rdf.owl.Class getObjectPropertyRange(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, objectPropertyRangeProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": objectPropertyRange getProperty() in org.openanzo.rdf.owl.SymmetricProperty model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.owl.OWL11Factory.getClass(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.owl.Class getObjectPropertyRange() throws org.openanzo.rdf.jastor.JastorException {
		return getObjectPropertyRange(false);
	}

	public void setObjectPropertyRange(org.openanzo.rdf.owl.Class objectPropertyRange) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, objectPropertyRangeProperty, null,_graph.getNamedGraphUri());
		if (objectPropertyRange != null) {
			_dataset.add(_resource, objectPropertyRangeProperty, objectPropertyRange.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.owl.Class setObjectPropertyRange() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, objectPropertyRangeProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.owl.Class objectPropertyRange = org.openanzo.rdf.owl.OWL11Factory.createClass(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, objectPropertyRangeProperty, objectPropertyRange.resource(),_graph.getNamedGraphUri());
		return objectPropertyRange;
	}
	
	public org.openanzo.rdf.owl.Class setObjectPropertyRange(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, objectPropertyRangeProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, objectPropertyRangeProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.owl.Class objectPropertyRange = org.openanzo.rdf.owl.OWL11Factory.getClass(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, objectPropertyRangeProperty, objectPropertyRange.resource(),_graph.getNamedGraphUri());
		return objectPropertyRange;
	}
	
	/**
	 * Clears all values for 'subObjectPropertyOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.SymmetricProperty#subObjectPropertyOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSubObjectPropertyOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, subObjectPropertyOfProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2006/12/owl11#subObjectPropertyOf

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.ObjectProperty> propertyCollectionSubObjectPropertyOf = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.ObjectProperty>() {
		public org.openanzo.rdf.owl.ObjectProperty getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.owl.OWL11Factory.getObjectProperty((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.owl.ObjectProperty> getSubObjectPropertyOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionSubObjectPropertyOf.getPropertyCollection(_dataset, _graph, _resource,subObjectPropertyOfProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#ObjectProperty"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.owl.ObjectProperty> getSubObjectPropertyOf() throws org.openanzo.rdf.jastor.JastorException {
		return getSubObjectPropertyOf(false);
	}

	public void addSubObjectPropertyOf(org.openanzo.rdf.owl.ObjectProperty subObjectPropertyOf) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, subObjectPropertyOfProperty,subObjectPropertyOf.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.owl.ObjectProperty addSubObjectPropertyOf() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.ObjectProperty subObjectPropertyOf = org.openanzo.rdf.owl.OWL11Factory.createObjectProperty(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, subObjectPropertyOfProperty,subObjectPropertyOf.resource(),_graph.getNamedGraphUri());
		return subObjectPropertyOf;
	}
	
	public org.openanzo.rdf.owl.ObjectProperty addSubObjectPropertyOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.ObjectProperty subObjectPropertyOf = org.openanzo.rdf.owl.OWL11Factory.getObjectProperty(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, subObjectPropertyOfProperty,subObjectPropertyOf.resource(),_graph.getNamedGraphUri());
		return subObjectPropertyOf;
	}
	
	public void removeSubObjectPropertyOf(org.openanzo.rdf.owl.ObjectProperty subObjectPropertyOf) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, subObjectPropertyOfProperty, subObjectPropertyOf.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, subObjectPropertyOfProperty, subObjectPropertyOf.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeSubObjectPropertyOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, subObjectPropertyOfProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, subObjectPropertyOfProperty, resource,_graph.getNamedGraphUri());
	}
  




}