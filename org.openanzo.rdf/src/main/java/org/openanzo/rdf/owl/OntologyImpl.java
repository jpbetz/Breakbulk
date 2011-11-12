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
 * Implementation of {@link org.openanzo.rdf.owl.Ontology}
 * Use the org.openanzo.rdf.owl.OWL11Factory to create instances of this class.
 * <p>(URI: http://www.w3.org/2002/07/owl#Ontology)</p>
 * <br>
 */
public class OntologyImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.rdf.owl.Ontology {

	protected static final org.openanzo.rdf.URI ImportsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("owl11xml:Imports");

	OntologyImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
	}   
	   
    	
	static OntologyImpl getOntology(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Ontology.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new OntologyImpl(resource, namedGraphUri, dataset);
	}
	    
	static OntologyImpl createOntology(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		OntologyImpl impl = new OntologyImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Ontology.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Ontology.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, ImportsProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.rdf.owl.Ontology.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'Imports'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			org.openanzo.rdf.owl.Ontology#ImportsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearImports(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, ImportsProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: owl11xml:Imports

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing> propertyCollectionImports = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.rdf.jastor.Thing>() {
		public org.openanzo.rdf.jastor.Thing getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.rdf.jastor.ThingFactory.getThing((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getImports(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionImports.getPropertyCollection(_dataset, _graph, _resource,ImportsProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2002/07/owl#Imports"), includeEntireDataset);
	}
	
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getImports() throws org.openanzo.rdf.jastor.JastorException {
		return getImports(false);
	}

	public void addImports(org.openanzo.rdf.jastor.Thing Imports) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, ImportsProperty,Imports.resource(),_graph.getNamedGraphUri());
	}
	
	public org.openanzo.rdf.jastor.Thing addImports() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing Imports = org.openanzo.rdf.jastor.ThingFactory.createThing(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, ImportsProperty,Imports.resource(),_graph.getNamedGraphUri());
		return Imports;
	}
	
	public org.openanzo.rdf.jastor.Thing addImports(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.rdf.jastor.Thing Imports = org.openanzo.rdf.jastor.ThingFactory.getThing(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, ImportsProperty,Imports.resource(),_graph.getNamedGraphUri());
		return Imports;
	}
	
	public void removeImports(org.openanzo.rdf.jastor.Thing Imports) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, ImportsProperty, Imports.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, ImportsProperty, Imports.resource(),_graph.getNamedGraphUri());
	}
	

		

	public void removeImports(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, ImportsProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, ImportsProperty, resource,_graph.getNamedGraphUri());
	}
  




}