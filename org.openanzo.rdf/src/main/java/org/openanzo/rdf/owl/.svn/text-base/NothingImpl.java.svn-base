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
 * Implementation of {@link org.openanzo.rdf.owl.Nothing}
 * Use the org.openanzo.rdf.owl.OWL11Factory to create instances of this class.
 * <p>(URI: http://www.w3.org/2002/07/owl#Nothing)</p>
 * <br>
 */
public class NothingImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.rdf.owl.Nothing {

	protected static final org.openanzo.rdf.URI commentProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2000/01/rdf-schema#comment");
	protected static final org.openanzo.rdf.URI labelProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2000/01/rdf-schema#label");
	protected static final org.openanzo.rdf.URI typeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
	protected static final org.openanzo.rdf.URI valueProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/1999/02/22-rdf-syntax-ns#value");
	protected static final org.openanzo.rdf.URI isDefinedByProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2000/01/rdf-schema#isDefinedBy");
	protected static final org.openanzo.rdf.URI memberProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2000/01/rdf-schema#member");
	protected static final org.openanzo.rdf.URI seeAlsoProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2000/01/rdf-schema#seeAlso");
	protected static final org.openanzo.rdf.URI subClassOfProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2000/01/rdf-schema#subClassOf");
	protected static final org.openanzo.rdf.URI oneOfProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#oneOf");
	protected static final org.openanzo.rdf.URI disjointWithProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#disjointWith");
	protected static final org.openanzo.rdf.URI equivalentClassProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#equivalentClass");
	protected static final org.openanzo.rdf.URI intersectionOfProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#intersectionOf");
	protected static final org.openanzo.rdf.URI unionOfProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#unionOf");
	protected static final org.openanzo.rdf.URI disjointUnionOfProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2006/12/owl11#disjointUnionOf");

	NothingImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
	}   
	   
    	
	static NothingImpl getNothing(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Nothing.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new NothingImpl(resource, namedGraphUri, dataset);
	}
	    
	static NothingImpl createNothing(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		NothingImpl impl = new NothingImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Nothing.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Nothing.TYPE, namedGraphUri);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	void addSuperTypes() {
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.rdfs._Resource.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.rdfs._Resource.TYPE,_graph.getNamedGraphUri());     
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.rdfs.Class.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.rdfs.Class.TYPE,_graph.getNamedGraphUri());     
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.owl.Class.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.owl.Class.TYPE,_graph.getNamedGraphUri());     
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.owl._Thing.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.owl._Thing.TYPE,_graph.getNamedGraphUri());     
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
		
		list.addAll(_dataset.find(_resource, subClassOfProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, oneOfProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, disjointWithProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, equivalentClassProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, intersectionOfProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, unionOfProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, disjointUnionOfProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.owl.Nothing.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.rdfs._Resource.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.rdfs.Class.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.owl.Class.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.owl._Thing.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'comment'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.Nothing#commentProperty
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
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://www.w3.org/2000/01/rdf-schema#comment properties in Nothing model not a Literal",value);
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
	 * @see			org.openanzo.rdf.owl.Nothing#labelProperty
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
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://www.w3.org/2000/01/rdf-schema#label properties in Nothing model not a Literal",value);
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
	 * @see			org.openanzo.rdf.owl.Nothing#typeProperty
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
	 * @see			org.openanzo.rdf.owl.Nothing#valueProperty
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
	 * @see			org.openanzo.rdf.owl.Nothing#isDefinedByProperty
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
	 * @see			org.openanzo.rdf.owl.Nothing#memberProperty
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
	 * @see			org.openanzo.rdf.owl.Nothing#seeAlsoProperty
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
	 * Clears all values for 'subClassOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.Nothing#subClassOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSubClassOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, subClassOfProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2000/01/rdf-schema#subClassOf

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.rdfs.Class> propertyCollectionSubClassOf = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.rdfs.Class>() {
		public org.openanzo.rdf.rdfs.Class getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.rdfs.RDFSFactory.getClass((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.rdfs.Class> getSubClassOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionSubClassOf.getPropertyCollection(_dataset, _graph, _resource,subClassOfProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2000/01/rdf-schema#Class"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.rdfs.Class> getSubClassOf() throws org.openanzo.rdf.jastor.JastorException {
		return getSubClassOf(false);
	}

	public void addSubClassOf(org.openanzo.rdf.rdfs.Class subClassOf) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, subClassOfProperty,subClassOf.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.rdfs.Class addSubClassOf() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.rdfs.Class subClassOf = org.openanzo.rdf.rdfs.RDFSFactory.createClass(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, subClassOfProperty,subClassOf.resource(),_graph.getNamedGraphUri());
		return subClassOf;
	}
	
	public org.openanzo.rdf.rdfs.Class addSubClassOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.rdfs.Class subClassOf = org.openanzo.rdf.rdfs.RDFSFactory.getClass(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, subClassOfProperty,subClassOf.resource(),_graph.getNamedGraphUri());
		return subClassOf;
	}
	
	public void removeSubClassOf(org.openanzo.rdf.rdfs.Class subClassOf) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, subClassOfProperty, subClassOf.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, subClassOfProperty, subClassOf.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeSubClassOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, subClassOfProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, subClassOfProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'oneOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.Nothing#oneOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearOneOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, oneOfProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2002/07/owl#oneOf

	public org.openanzo.rdf.jastor.Thing getOneOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, oneOfProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": oneOf getProperty() in org.openanzo.rdf.owl.Nothing model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.jastor.ThingFactory.getThing(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.jastor.Thing getOneOf() throws org.openanzo.rdf.jastor.JastorException {
		return getOneOf(false);
	}

	public void setOneOf(org.openanzo.rdf.jastor.Thing oneOf) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, oneOfProperty, null,_graph.getNamedGraphUri());
		if (oneOf != null) {
			_dataset.add(_resource, oneOfProperty, oneOf.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.jastor.Thing setOneOf() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, oneOfProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.jastor.Thing oneOf = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, oneOfProperty, oneOf.resource(),_graph.getNamedGraphUri());
		return oneOf;
	}
	
	public org.openanzo.rdf.jastor.Thing setOneOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, oneOfProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, oneOfProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.jastor.Thing oneOf = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, oneOfProperty, oneOf.resource(),_graph.getNamedGraphUri());
		return oneOf;
	}
	
	/**
	 * Clears all values for 'disjointWith'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.Nothing#disjointWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDisjointWith(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, disjointWithProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2002/07/owl#disjointWith

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.Class> propertyCollectionDisjointWith = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.Class>() {
		public org.openanzo.rdf.owl.Class getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.owl.OWL11Factory.getClass((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.owl.Class> getDisjointWith(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionDisjointWith.getPropertyCollection(_dataset, _graph, _resource,disjointWithProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#Class"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.owl.Class> getDisjointWith() throws org.openanzo.rdf.jastor.JastorException {
		return getDisjointWith(false);
	}

	public void addDisjointWith(org.openanzo.rdf.owl.Class disjointWith) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, disjointWithProperty,disjointWith.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.owl.Class addDisjointWith() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.Class disjointWith = org.openanzo.rdf.owl.OWL11Factory.createClass(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, disjointWithProperty,disjointWith.resource(),_graph.getNamedGraphUri());
		return disjointWith;
	}
	
	public org.openanzo.rdf.owl.Class addDisjointWith(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.Class disjointWith = org.openanzo.rdf.owl.OWL11Factory.getClass(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, disjointWithProperty,disjointWith.resource(),_graph.getNamedGraphUri());
		return disjointWith;
	}
	
	public void removeDisjointWith(org.openanzo.rdf.owl.Class disjointWith) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, disjointWithProperty, disjointWith.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, disjointWithProperty, disjointWith.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeDisjointWith(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, disjointWithProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, disjointWithProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'equivalentClass'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.Nothing#equivalentClassProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearEquivalentClass(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, equivalentClassProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2002/07/owl#equivalentClass

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.Class> propertyCollectionEquivalentClass = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.Class>() {
		public org.openanzo.rdf.owl.Class getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.owl.OWL11Factory.getClass((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.owl.Class> getEquivalentClass(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionEquivalentClass.getPropertyCollection(_dataset, _graph, _resource,equivalentClassProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#Class"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.owl.Class> getEquivalentClass() throws org.openanzo.rdf.jastor.JastorException {
		return getEquivalentClass(false);
	}

	public void addEquivalentClass(org.openanzo.rdf.owl.Class equivalentClass) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, equivalentClassProperty,equivalentClass.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.owl.Class addEquivalentClass() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.Class equivalentClass = org.openanzo.rdf.owl.OWL11Factory.createClass(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, equivalentClassProperty,equivalentClass.resource(),_graph.getNamedGraphUri());
		return equivalentClass;
	}
	
	public org.openanzo.rdf.owl.Class addEquivalentClass(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.Class equivalentClass = org.openanzo.rdf.owl.OWL11Factory.getClass(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, equivalentClassProperty,equivalentClass.resource(),_graph.getNamedGraphUri());
		return equivalentClass;
	}
	
	public void removeEquivalentClass(org.openanzo.rdf.owl.Class equivalentClass) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, equivalentClassProperty, equivalentClass.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, equivalentClassProperty, equivalentClass.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeEquivalentClass(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, equivalentClassProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, equivalentClassProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'intersectionOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.Nothing#intersectionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearIntersectionOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, intersectionOfProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2002/07/owl#intersectionOf

	public org.openanzo.rdf.jastor.Thing getIntersectionOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, intersectionOfProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": intersectionOf getProperty() in org.openanzo.rdf.owl.Nothing model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.jastor.ThingFactory.getThing(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.jastor.Thing getIntersectionOf() throws org.openanzo.rdf.jastor.JastorException {
		return getIntersectionOf(false);
	}

	public void setIntersectionOf(org.openanzo.rdf.jastor.Thing intersectionOf) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, intersectionOfProperty, null,_graph.getNamedGraphUri());
		if (intersectionOf != null) {
			_dataset.add(_resource, intersectionOfProperty, intersectionOf.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.jastor.Thing setIntersectionOf() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, intersectionOfProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.jastor.Thing intersectionOf = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, intersectionOfProperty, intersectionOf.resource(),_graph.getNamedGraphUri());
		return intersectionOf;
	}
	
	public org.openanzo.rdf.jastor.Thing setIntersectionOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, intersectionOfProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, intersectionOfProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.jastor.Thing intersectionOf = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, intersectionOfProperty, intersectionOf.resource(),_graph.getNamedGraphUri());
		return intersectionOf;
	}
	
	/**
	 * Clears all values for 'unionOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.Nothing#unionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearUnionOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, unionOfProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2002/07/owl#unionOf

	public org.openanzo.rdf.jastor.Thing getUnionOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, unionOfProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": unionOf getProperty() in org.openanzo.rdf.owl.Nothing model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.rdf.jastor.ThingFactory.getThing(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.rdf.jastor.Thing getUnionOf() throws org.openanzo.rdf.jastor.JastorException {
		return getUnionOf(false);
	}

	public void setUnionOf(org.openanzo.rdf.jastor.Thing unionOf) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, unionOfProperty, null,_graph.getNamedGraphUri());
		if (unionOf != null) {
			_dataset.add(_resource, unionOfProperty, unionOf.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.rdf.jastor.Thing setUnionOf() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, unionOfProperty, null,_graph.getNamedGraphUri());
		org.openanzo.rdf.jastor.Thing unionOf = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, unionOfProperty, unionOf.resource(),_graph.getNamedGraphUri());
		return unionOf;
	}
	
	public org.openanzo.rdf.jastor.Thing setUnionOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, unionOfProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, unionOfProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.rdf.jastor.Thing unionOf = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, unionOfProperty, unionOf.resource(),_graph.getNamedGraphUri());
		return unionOf;
	}
	
	/**
	 * Clears all values for 'disjointUnionOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.Nothing#disjointUnionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDisjointUnionOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, disjointUnionOfProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2006/12/owl11#disjointUnionOf

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.Class> propertyCollectionDisjointUnionOf = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.Class>() {
		public org.openanzo.rdf.owl.Class getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.owl.OWL11Factory.getClass((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.owl.Class> getDisjointUnionOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionDisjointUnionOf.getPropertyCollection(_dataset, _graph, _resource,disjointUnionOfProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#Class"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.owl.Class> getDisjointUnionOf() throws org.openanzo.rdf.jastor.JastorException {
		return getDisjointUnionOf(false);
	}

	public void addDisjointUnionOf(org.openanzo.rdf.owl.Class disjointUnionOf) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, disjointUnionOfProperty,disjointUnionOf.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.owl.Class addDisjointUnionOf() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.Class disjointUnionOf = org.openanzo.rdf.owl.OWL11Factory.createClass(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, disjointUnionOfProperty,disjointUnionOf.resource(),_graph.getNamedGraphUri());
		return disjointUnionOf;
	}
	
	public org.openanzo.rdf.owl.Class addDisjointUnionOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.Class disjointUnionOf = org.openanzo.rdf.owl.OWL11Factory.getClass(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, disjointUnionOfProperty,disjointUnionOf.resource(),_graph.getNamedGraphUri());
		return disjointUnionOf;
	}
	
	public void removeDisjointUnionOf(org.openanzo.rdf.owl.Class disjointUnionOf) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, disjointUnionOfProperty, disjointUnionOf.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, disjointUnionOfProperty, disjointUnionOf.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeDisjointUnionOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, disjointUnionOfProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, disjointUnionOfProperty, resource,_graph.getNamedGraphUri());
	}
  




}