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
 * Implementation of {@link org.openanzo.rdf.owl.DataRange}
 * Use the org.openanzo.rdf.owl.OWL11Factory to create instances of this class.
 * <p>(URI: http://www.w3.org/2002/07/owl#DataRange)</p>
 * <br>
 */
public class DataRangeImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.rdf.owl.DataRange {

	protected static final org.openanzo.rdf.URI oneOfProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#oneOf");
	protected static final org.openanzo.rdf.URI complementOfProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#complementOf");

	DataRangeImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
	}   
	   
    	
	static DataRangeImpl getDataRange(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, DataRange.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new DataRangeImpl(resource, namedGraphUri, dataset);
	}
	    
	static DataRangeImpl createDataRange(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		DataRangeImpl impl = new DataRangeImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, DataRange.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, DataRange.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, oneOfProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, complementOfProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.owl.DataRange.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'oneOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.DataRange#oneOfProperty
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": oneOf getProperty() in org.openanzo.rdf.owl.DataRange model not Resource", statement.getObject());
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
	 * Clears all values for 'complementOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.DataRange#complementOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearComplementOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, complementOfProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://www.w3.org/2002/07/owl#complementOf

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.DataRange> propertyCollectionComplementOf = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.owl.DataRange>() {
		public org.openanzo.rdf.owl.DataRange getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.owl.OWL11Factory.getDataRange((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.owl.DataRange> getComplementOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionComplementOf.getPropertyCollection(_dataset, _graph, _resource,complementOfProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#DataRange"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.owl.DataRange> getComplementOf() throws org.openanzo.rdf.jastor.JastorException {
		return getComplementOf(false);
	}

	public void addComplementOf(org.openanzo.rdf.owl.DataRange complementOf) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, complementOfProperty,complementOf.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.owl.DataRange addComplementOf() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.DataRange complementOf = org.openanzo.rdf.owl.OWL11Factory.createDataRange(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, complementOfProperty,complementOf.resource(),_graph.getNamedGraphUri());
		return complementOf;
	}
	
	public org.openanzo.rdf.owl.DataRange addComplementOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.owl.DataRange complementOf = org.openanzo.rdf.owl.OWL11Factory.getDataRange(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, complementOfProperty,complementOf.resource(),_graph.getNamedGraphUri());
		return complementOf;
	}
	
	public void removeComplementOf(org.openanzo.rdf.owl.DataRange complementOf) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, complementOfProperty, complementOf.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, complementOfProperty, complementOf.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeComplementOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, complementOfProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, complementOfProperty, resource,_graph.getNamedGraphUri());
	}
  




}