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
package org.openanzo.ontologies.openanzo;

/**
 * Implementation of {@link org.openanzo.ontologies.openanzo.StatementStream}
 * Use the org.openanzo.ontologies.openanzo.AnzoFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/Anzo#StatementStream)</p>
 * <br>
 */
public class StatementStreamImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.openanzo.StatementStream {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI createdProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#created");
	protected static final org.openanzo.rdf.URI hasMetadataGraphProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#hasMetadataGraph");
	protected static final org.openanzo.rdf.URI modifiedProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#modified");
	protected static final org.openanzo.rdf.URI persistedProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#persisted");
	protected static final org.openanzo.rdf.URI revisionProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#revision");
	protected static final org.openanzo.rdf.URI revisionedProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#revisioned");
	protected static final org.openanzo.rdf.URI uuidProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#uuid");
	protected static final org.openanzo.rdf.URI canBeAddedToByProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#canBeAddedToBy");
	protected static final org.openanzo.rdf.URI canBeReadByProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#canBeReadBy");
	protected static final org.openanzo.rdf.URI canBeRemovedFromByProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#canBeRemovedFromBy");
	protected static final org.openanzo.rdf.URI createdByProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#createdBy");
	protected static final org.openanzo.rdf.URI datasourceProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#datasource");
	protected static final org.openanzo.rdf.URI inheritsFromProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#inheritsFrom");
	protected static final org.openanzo.rdf.URI lastModifiedByUserProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#lastModifiedByUser");

	StatementStreamImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static StatementStreamImpl getStatementStream(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, StatementStream.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new StatementStreamImpl(resource, namedGraphUri, dataset);
	}
	    
	static StatementStreamImpl createStatementStream(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		StatementStreamImpl impl = new StatementStreamImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, StatementStream.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, StatementStream.TYPE, namedGraphUri);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	void addSuperTypes() {
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.openanzo.NamedGraph.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.openanzo.NamedGraph.TYPE,_graph.getNamedGraphUri());     
	}
   
	void addHasValueValues() {
	}
   
	public java.util.Collection<org.openanzo.rdf.Statement> listStatements() {
		java.util.Collection<org.openanzo.rdf.Statement> list = new java.util.HashSet<org.openanzo.rdf.Statement>();
		
		list.addAll(_dataset.find(_resource, createdProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, hasMetadataGraphProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, modifiedProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, persistedProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, revisionProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, revisionedProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, uuidProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, canBeAddedToByProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, canBeReadByProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, canBeRemovedFromByProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, createdByProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, datasourceProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, inheritsFromProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, lastModifiedByUserProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.openanzo.StatementStream.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.openanzo.NamedGraph.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'created'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearCreated(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, createdProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#created
	public javax.xml.datatype.XMLGregorianCalendar getCreated(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, createdProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": created getProperty() in org.openanzo.ontologies.openanzo.StatementStream model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#dateTime");
		if (!(obj instanceof javax.xml.datatype.XMLGregorianCalendar))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal created in StatementStream is not of type javax.xml.datatype.XMLGregorianCalendar", literal);
		return (javax.xml.datatype.XMLGregorianCalendar)obj;
		
	}
	
	public javax.xml.datatype.XMLGregorianCalendar getCreated() throws org.openanzo.rdf.jastor.JastorException {
		return getCreated(false);
	}
	
	public void setCreated(javax.xml.datatype.XMLGregorianCalendar created) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, createdProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (created != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(created,"http://www.w3.org/2001/XMLSchema#dateTime");
			_dataset.add(_resource, createdProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'hasMetadataGraph'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearHasMetadataGraph(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, hasMetadataGraphProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#hasMetadataGraph
	public org.openanzo.rdf.URI getHasMetadataGraph(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, hasMetadataGraphProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;
		if (!(statement.getObject() instanceof org.openanzo.rdf.URI))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": hasMetadataGraph getProperty() in org.openanzo.ontologies.openanzo.StatementStream model not URI", statement.getObject());
		return (org.openanzo.rdf.URI)statement.getObject();
		
	}
	
	public org.openanzo.rdf.URI getHasMetadataGraph() throws org.openanzo.rdf.jastor.JastorException {
		return getHasMetadataGraph(false);
	}
	
	public void setHasMetadataGraph(org.openanzo.rdf.URI hasMetadataGraph) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, hasMetadataGraphProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (hasMetadataGraph != null) {
	
			_dataset.add(_resource, hasMetadataGraphProperty, hasMetadataGraph,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'modified'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearModified(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, modifiedProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#modified
	public javax.xml.datatype.XMLGregorianCalendar getModified(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, modifiedProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": modified getProperty() in org.openanzo.ontologies.openanzo.StatementStream model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#dateTime");
		if (!(obj instanceof javax.xml.datatype.XMLGregorianCalendar))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal modified in StatementStream is not of type javax.xml.datatype.XMLGregorianCalendar", literal);
		return (javax.xml.datatype.XMLGregorianCalendar)obj;
		
	}
	
	public javax.xml.datatype.XMLGregorianCalendar getModified() throws org.openanzo.rdf.jastor.JastorException {
		return getModified(false);
	}
	
	public void setModified(javax.xml.datatype.XMLGregorianCalendar modified) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, modifiedProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (modified != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(modified,"http://www.w3.org/2001/XMLSchema#dateTime");
			_dataset.add(_resource, modifiedProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'persisted'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearPersisted(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, persistedProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#persisted
	public java.lang.Boolean getPersisted(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, persistedProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": persisted getProperty() in org.openanzo.ontologies.openanzo.StatementStream model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal persisted in StatementStream is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getPersisted() throws org.openanzo.rdf.jastor.JastorException {
		return getPersisted(false);
	}
	
	public void setPersisted(java.lang.Boolean persisted) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, persistedProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (persisted != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(persisted,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, persistedProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'revision'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearRevision(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, revisionProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#revision
	public java.lang.Long getRevision(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, revisionProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": revision getProperty() in org.openanzo.ontologies.openanzo.StatementStream model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#long");
		if (!(obj instanceof java.lang.Long))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal revision in StatementStream is not of type java.lang.Long", literal);
		return (java.lang.Long)obj;
		
	}
	
	public java.lang.Long getRevision() throws org.openanzo.rdf.jastor.JastorException {
		return getRevision(false);
	}
	
	public void setRevision(java.lang.Long revision) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, revisionProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (revision != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(revision,"http://www.w3.org/2001/XMLSchema#long");
			_dataset.add(_resource, revisionProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'revisioned'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearRevisioned(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, revisionedProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#revisioned
	public java.lang.Boolean getRevisioned(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, revisionedProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": revisioned getProperty() in org.openanzo.ontologies.openanzo.StatementStream model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal revisioned in StatementStream is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getRevisioned() throws org.openanzo.rdf.jastor.JastorException {
		return getRevisioned(false);
	}
	
	public void setRevisioned(java.lang.Boolean revisioned) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, revisionedProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (revisioned != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(revisioned,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, revisionedProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'uuid'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearUuid(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, uuidProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#uuid
	public org.openanzo.rdf.URI getUuid(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, uuidProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;
		if (!(statement.getObject() instanceof org.openanzo.rdf.URI))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": uuid getProperty() in org.openanzo.ontologies.openanzo.StatementStream model not URI", statement.getObject());
		return (org.openanzo.rdf.URI)statement.getObject();
		
	}
	
	public org.openanzo.rdf.URI getUuid() throws org.openanzo.rdf.jastor.JastorException {
		return getUuid(false);
	}
	
	public void setUuid(org.openanzo.rdf.URI uuid) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, uuidProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (uuid != null) {
	
			_dataset.add(_resource, uuidProperty, uuid,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'canBeAddedToBy'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearCanBeAddedToBy(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, canBeAddedToByProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#canBeAddedToBy

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.openanzo.Role> propertyCollectionCanBeAddedToBy = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.openanzo.Role>() {
		public org.openanzo.ontologies.openanzo.Role getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.openanzo.AnzoFactory.getRole((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.openanzo.Role 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.Role> getCanBeAddedToBy(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionCanBeAddedToBy.getPropertyCollection(_dataset, _graph, _resource,canBeAddedToByProperty, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#Role"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.openanzo.Role  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.Role> getCanBeAddedToBy() throws org.openanzo.rdf.jastor.JastorException {
		return getCanBeAddedToBy(false);
	}

/**
     * 
     * @param canBeAddedToBy value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addCanBeAddedToBy(org.openanzo.ontologies.openanzo.Role canBeAddedToBy) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, canBeAddedToByProperty,canBeAddedToBy.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.openanzo.Role addCanBeAddedToBy() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.openanzo.Role canBeAddedToBy = org.openanzo.ontologies.openanzo.AnzoFactory.createRole(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, canBeAddedToByProperty,canBeAddedToBy.resource(),_graph.getNamedGraphUri());
		return canBeAddedToBy;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.openanzo.Role addCanBeAddedToBy(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.openanzo.Role canBeAddedToBy = org.openanzo.ontologies.openanzo.AnzoFactory.getRole(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, canBeAddedToByProperty,canBeAddedToBy.resource(),_graph.getNamedGraphUri());
		return canBeAddedToBy;
	}
	
	/**
	 * Remove object
	 * @param canBeAddedToBy object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCanBeAddedToBy(org.openanzo.ontologies.openanzo.Role canBeAddedToBy) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, canBeAddedToByProperty, canBeAddedToBy.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, canBeAddedToByProperty, canBeAddedToBy.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCanBeAddedToBy(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, canBeAddedToByProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, canBeAddedToByProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'canBeReadBy'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearCanBeReadBy(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, canBeReadByProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#canBeReadBy

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.openanzo.Role> propertyCollectionCanBeReadBy = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.openanzo.Role>() {
		public org.openanzo.ontologies.openanzo.Role getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.openanzo.AnzoFactory.getRole((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.openanzo.Role 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.Role> getCanBeReadBy(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionCanBeReadBy.getPropertyCollection(_dataset, _graph, _resource,canBeReadByProperty, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#Role"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.openanzo.Role  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.Role> getCanBeReadBy() throws org.openanzo.rdf.jastor.JastorException {
		return getCanBeReadBy(false);
	}

/**
     * 
     * @param canBeReadBy value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addCanBeReadBy(org.openanzo.ontologies.openanzo.Role canBeReadBy) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, canBeReadByProperty,canBeReadBy.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.openanzo.Role addCanBeReadBy() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.openanzo.Role canBeReadBy = org.openanzo.ontologies.openanzo.AnzoFactory.createRole(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, canBeReadByProperty,canBeReadBy.resource(),_graph.getNamedGraphUri());
		return canBeReadBy;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.openanzo.Role addCanBeReadBy(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.openanzo.Role canBeReadBy = org.openanzo.ontologies.openanzo.AnzoFactory.getRole(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, canBeReadByProperty,canBeReadBy.resource(),_graph.getNamedGraphUri());
		return canBeReadBy;
	}
	
	/**
	 * Remove object
	 * @param canBeReadBy object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCanBeReadBy(org.openanzo.ontologies.openanzo.Role canBeReadBy) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, canBeReadByProperty, canBeReadBy.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, canBeReadByProperty, canBeReadBy.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCanBeReadBy(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, canBeReadByProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, canBeReadByProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'canBeRemovedFromBy'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearCanBeRemovedFromBy(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, canBeRemovedFromByProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#canBeRemovedFromBy

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.openanzo.Role> propertyCollectionCanBeRemovedFromBy = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.openanzo.Role>() {
		public org.openanzo.ontologies.openanzo.Role getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.openanzo.AnzoFactory.getRole((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.openanzo.Role 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.Role> getCanBeRemovedFromBy(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionCanBeRemovedFromBy.getPropertyCollection(_dataset, _graph, _resource,canBeRemovedFromByProperty, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#Role"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.openanzo.Role  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.Role> getCanBeRemovedFromBy() throws org.openanzo.rdf.jastor.JastorException {
		return getCanBeRemovedFromBy(false);
	}

/**
     * 
     * @param canBeRemovedFromBy value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addCanBeRemovedFromBy(org.openanzo.ontologies.openanzo.Role canBeRemovedFromBy) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, canBeRemovedFromByProperty,canBeRemovedFromBy.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.openanzo.Role addCanBeRemovedFromBy() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.openanzo.Role canBeRemovedFromBy = org.openanzo.ontologies.openanzo.AnzoFactory.createRole(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, canBeRemovedFromByProperty,canBeRemovedFromBy.resource(),_graph.getNamedGraphUri());
		return canBeRemovedFromBy;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.openanzo.Role addCanBeRemovedFromBy(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.openanzo.Role canBeRemovedFromBy = org.openanzo.ontologies.openanzo.AnzoFactory.getRole(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, canBeRemovedFromByProperty,canBeRemovedFromBy.resource(),_graph.getNamedGraphUri());
		return canBeRemovedFromBy;
	}
	
	/**
	 * Remove object
	 * @param canBeRemovedFromBy object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCanBeRemovedFromBy(org.openanzo.ontologies.openanzo.Role canBeRemovedFromBy) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, canBeRemovedFromByProperty, canBeRemovedFromBy.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, canBeRemovedFromByProperty, canBeRemovedFromBy.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCanBeRemovedFromBy(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, canBeRemovedFromByProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, canBeRemovedFromByProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'createdBy'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearCreatedBy(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, createdByProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#createdBy

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.openanzo.User> propertyCollectionCreatedBy = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.openanzo.User>() {
		public org.openanzo.ontologies.openanzo.User getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.openanzo.AnzoFactory.getUser((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.openanzo.User 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.User> getCreatedBy(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionCreatedBy.getPropertyCollection(_dataset, _graph, _resource,createdByProperty, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#User"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.openanzo.User  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.User> getCreatedBy() throws org.openanzo.rdf.jastor.JastorException {
		return getCreatedBy(false);
	}

/**
     * 
     * @param createdBy value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addCreatedBy(org.openanzo.ontologies.openanzo.User createdBy) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, createdByProperty,createdBy.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.openanzo.User addCreatedBy() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.openanzo.User createdBy = org.openanzo.ontologies.openanzo.AnzoFactory.createUser(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, createdByProperty,createdBy.resource(),_graph.getNamedGraphUri());
		return createdBy;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.openanzo.User addCreatedBy(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.openanzo.User createdBy = org.openanzo.ontologies.openanzo.AnzoFactory.getUser(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, createdByProperty,createdBy.resource(),_graph.getNamedGraphUri());
		return createdBy;
	}
	
	/**
	 * Remove object
	 * @param createdBy object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCreatedBy(org.openanzo.ontologies.openanzo.User createdBy) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, createdByProperty, createdBy.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, createdByProperty, createdBy.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeCreatedBy(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, createdByProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, createdByProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'datasource'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDatasource(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, datasourceProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#datasource

	public org.openanzo.ontologies.system.Datasource getDatasource(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, datasourceProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": datasource getProperty() in org.openanzo.ontologies.openanzo.StatementStream model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.system.SystemFactory.getDatasource(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.system.Datasource getDatasource() throws org.openanzo.rdf.jastor.JastorException {
		return getDatasource(false);
	}

	public void setDatasource(org.openanzo.ontologies.system.Datasource datasource) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, datasourceProperty, null,_graph.getNamedGraphUri());
		if (datasource != null) {
			_dataset.add(_resource, datasourceProperty, datasource.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.system.Datasource setDatasource() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, datasourceProperty, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.system.Datasource datasource = org.openanzo.ontologies.system.SystemFactory.createDatasource(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, datasourceProperty, datasource.resource(),_graph.getNamedGraphUri());
		return datasource;
	}
	
	public org.openanzo.ontologies.system.Datasource setDatasource(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, datasourceProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, datasourceProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.system.Datasource datasource = org.openanzo.ontologies.system.SystemFactory.getDatasource(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, datasourceProperty, datasource.resource(),_graph.getNamedGraphUri());
		return datasource;
	}
	
	/**
	 * Clears all values for 'inheritsFrom'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearInheritsFrom(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, inheritsFromProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#inheritsFrom

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.openanzo.NamedGraph> propertyCollectionInheritsFrom = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.openanzo.NamedGraph>() {
		public org.openanzo.ontologies.openanzo.NamedGraph getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.openanzo.AnzoFactory.getNamedGraph((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.openanzo.NamedGraph 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.NamedGraph> getInheritsFrom(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionInheritsFrom.getPropertyCollection(_dataset, _graph, _resource,inheritsFromProperty, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#NamedGraph"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.openanzo.NamedGraph  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.NamedGraph> getInheritsFrom() throws org.openanzo.rdf.jastor.JastorException {
		return getInheritsFrom(false);
	}

/**
     * 
     * @param inheritsFrom value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addInheritsFrom(org.openanzo.ontologies.openanzo.NamedGraph inheritsFrom) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, inheritsFromProperty,inheritsFrom.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.openanzo.NamedGraph addInheritsFrom() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.openanzo.NamedGraph inheritsFrom = org.openanzo.ontologies.openanzo.AnzoFactory.createNamedGraph(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, inheritsFromProperty,inheritsFrom.resource(),_graph.getNamedGraphUri());
		return inheritsFrom;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.openanzo.NamedGraph addInheritsFrom(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.openanzo.NamedGraph inheritsFrom = org.openanzo.ontologies.openanzo.AnzoFactory.getNamedGraph(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, inheritsFromProperty,inheritsFrom.resource(),_graph.getNamedGraphUri());
		return inheritsFrom;
	}
	
	/**
	 * Remove object
	 * @param inheritsFrom object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeInheritsFrom(org.openanzo.ontologies.openanzo.NamedGraph inheritsFrom) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, inheritsFromProperty, inheritsFrom.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, inheritsFromProperty, inheritsFrom.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeInheritsFrom(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, inheritsFromProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, inheritsFromProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'lastModifiedByUser'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearLastModifiedByUser(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, lastModifiedByUserProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/Anzo#lastModifiedByUser

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.openanzo.User> propertyCollectionLastModifiedByUser = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.openanzo.User>() {
		public org.openanzo.ontologies.openanzo.User getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.openanzo.AnzoFactory.getUser((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.openanzo.User 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.User> getLastModifiedByUser(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionLastModifiedByUser.getPropertyCollection(_dataset, _graph, _resource,lastModifiedByUserProperty, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#User"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.openanzo.User  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.User> getLastModifiedByUser() throws org.openanzo.rdf.jastor.JastorException {
		return getLastModifiedByUser(false);
	}

/**
     * 
     * @param lastModifiedByUser value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addLastModifiedByUser(org.openanzo.ontologies.openanzo.User lastModifiedByUser) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, lastModifiedByUserProperty,lastModifiedByUser.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.openanzo.User addLastModifiedByUser() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.openanzo.User lastModifiedByUser = org.openanzo.ontologies.openanzo.AnzoFactory.createUser(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, lastModifiedByUserProperty,lastModifiedByUser.resource(),_graph.getNamedGraphUri());
		return lastModifiedByUser;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.openanzo.User addLastModifiedByUser(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.openanzo.User lastModifiedByUser = org.openanzo.ontologies.openanzo.AnzoFactory.getUser(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, lastModifiedByUserProperty,lastModifiedByUser.resource(),_graph.getNamedGraphUri());
		return lastModifiedByUser;
	}
	
	/**
	 * Remove object
	 * @param lastModifiedByUser object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeLastModifiedByUser(org.openanzo.ontologies.openanzo.User lastModifiedByUser) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, lastModifiedByUserProperty, lastModifiedByUser.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, lastModifiedByUserProperty, lastModifiedByUser.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeLastModifiedByUser(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, lastModifiedByUserProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, lastModifiedByUserProperty, resource,_graph.getNamedGraphUri());
	}
  


	protected java.util.concurrent.CopyOnWriteArraySet<StatementStreamListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<StatementStreamListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof StatementStreamListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	StatementStreamListener list = (StatementStreamListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof StatementStreamListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		StatementStreamListener list = (StatementStreamListener)listener;
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
			if (statement.getPredicate().equals(createdProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(StatementStreamListener listener : listeners){
					listener.createdChanged(org.openanzo.ontologies.openanzo.StatementStreamImpl.this);
				}			
			}
			if (statement.getPredicate().equals(hasMetadataGraphProperty)) {
				for(StatementStreamListener listener : listeners){
					listener.hasMetadataGraphChanged(org.openanzo.ontologies.openanzo.StatementStreamImpl.this);
				}			
			}
			if (statement.getPredicate().equals(modifiedProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(StatementStreamListener listener : listeners){
					listener.modifiedChanged(org.openanzo.ontologies.openanzo.StatementStreamImpl.this);
				}			
			}
			if (statement.getPredicate().equals(persistedProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(StatementStreamListener listener : listeners){
					listener.persistedChanged(org.openanzo.ontologies.openanzo.StatementStreamImpl.this);
				}			
			}
			if (statement.getPredicate().equals(revisionProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(StatementStreamListener listener : listeners){
					listener.revisionChanged(org.openanzo.ontologies.openanzo.StatementStreamImpl.this);
				}			
			}
			if (statement.getPredicate().equals(revisionedProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(StatementStreamListener listener : listeners){
					listener.revisionedChanged(org.openanzo.ontologies.openanzo.StatementStreamImpl.this);
				}			
			}
			if (statement.getPredicate().equals(uuidProperty)) {
				for(StatementStreamListener listener : listeners){
					listener.uuidChanged(org.openanzo.ontologies.openanzo.StatementStreamImpl.this);
				}			
			}
			if (statement.getPredicate().equals(canBeAddedToByProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.openanzo.Role _canBeAddedToBy = org.openanzo.ontologies.openanzo.AnzoFactory.getRole(resource,_graph.getNamedGraphUri(),dataset());
				if (_canBeAddedToBy != null) {
					for(StatementStreamListener listener : listeners){
						listener.canBeAddedToByAdded(org.openanzo.ontologies.openanzo.StatementStreamImpl.this,_canBeAddedToBy);
					}
				}			
			}
			if (statement.getPredicate().equals(canBeReadByProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.openanzo.Role _canBeReadBy = org.openanzo.ontologies.openanzo.AnzoFactory.getRole(resource,_graph.getNamedGraphUri(),dataset());
				if (_canBeReadBy != null) {
					for(StatementStreamListener listener : listeners){
						listener.canBeReadByAdded(org.openanzo.ontologies.openanzo.StatementStreamImpl.this,_canBeReadBy);
					}
				}			
			}
			if (statement.getPredicate().equals(canBeRemovedFromByProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.openanzo.Role _canBeRemovedFromBy = org.openanzo.ontologies.openanzo.AnzoFactory.getRole(resource,_graph.getNamedGraphUri(),dataset());
				if (_canBeRemovedFromBy != null) {
					for(StatementStreamListener listener : listeners){
						listener.canBeRemovedFromByAdded(org.openanzo.ontologies.openanzo.StatementStreamImpl.this,_canBeRemovedFromBy);
					}
				}			
			}
			if (statement.getPredicate().equals(createdByProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.openanzo.User _createdBy = org.openanzo.ontologies.openanzo.AnzoFactory.getUser(resource,_graph.getNamedGraphUri(),dataset());
				if (_createdBy != null) {
					for(StatementStreamListener listener : listeners){
						listener.createdByAdded(org.openanzo.ontologies.openanzo.StatementStreamImpl.this,_createdBy);
					}
				}			
			}
			if (statement.getPredicate().equals(datasourceProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(StatementStreamListener listener : listeners){
					listener.datasourceChanged(org.openanzo.ontologies.openanzo.StatementStreamImpl.this);
				}			
			}
			if (statement.getPredicate().equals(inheritsFromProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.openanzo.NamedGraph _inheritsFrom = org.openanzo.ontologies.openanzo.AnzoFactory.getNamedGraph(resource,_graph.getNamedGraphUri(),dataset());
				if (_inheritsFrom != null) {
					for(StatementStreamListener listener : listeners){
						listener.inheritsFromAdded(org.openanzo.ontologies.openanzo.StatementStreamImpl.this,_inheritsFrom);
					}
				}			
			}
			if (statement.getPredicate().equals(lastModifiedByUserProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.openanzo.User _lastModifiedByUser = org.openanzo.ontologies.openanzo.AnzoFactory.getUser(resource,_graph.getNamedGraphUri(),dataset());
				if (_lastModifiedByUser != null) {
					for(StatementStreamListener listener : listeners){
						listener.lastModifiedByUserAdded(org.openanzo.ontologies.openanzo.StatementStreamImpl.this,_lastModifiedByUser);
					}
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(createdProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(StatementStreamListener listener : listeners) {
					listener.createdChanged(org.openanzo.ontologies.openanzo.StatementStreamImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(hasMetadataGraphProperty)) {
				for(StatementStreamListener listener : listeners) {
					listener.hasMetadataGraphChanged(org.openanzo.ontologies.openanzo.StatementStreamImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(modifiedProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(StatementStreamListener listener : listeners) {
					listener.modifiedChanged(org.openanzo.ontologies.openanzo.StatementStreamImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(persistedProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(StatementStreamListener listener : listeners) {
					listener.persistedChanged(org.openanzo.ontologies.openanzo.StatementStreamImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(revisionProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(StatementStreamListener listener : listeners) {
					listener.revisionChanged(org.openanzo.ontologies.openanzo.StatementStreamImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(revisionedProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(StatementStreamListener listener : listeners) {
					listener.revisionedChanged(org.openanzo.ontologies.openanzo.StatementStreamImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(uuidProperty)) {
				for(StatementStreamListener listener : listeners) {
					listener.uuidChanged(org.openanzo.ontologies.openanzo.StatementStreamImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(canBeAddedToByProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.openanzo.Role _canBeAddedToBy = org.openanzo.ontologies.openanzo.AnzoFactory.getRole(resource,_graph.getNamedGraphUri(),dataset());
				if (_canBeAddedToBy != null) {
					for(StatementStreamListener listener : listeners){
						listener.canBeAddedToByRemoved(org.openanzo.ontologies.openanzo.StatementStreamImpl.this,_canBeAddedToBy);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(canBeReadByProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.openanzo.Role _canBeReadBy = org.openanzo.ontologies.openanzo.AnzoFactory.getRole(resource,_graph.getNamedGraphUri(),dataset());
				if (_canBeReadBy != null) {
					for(StatementStreamListener listener : listeners){
						listener.canBeReadByRemoved(org.openanzo.ontologies.openanzo.StatementStreamImpl.this,_canBeReadBy);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(canBeRemovedFromByProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.openanzo.Role _canBeRemovedFromBy = org.openanzo.ontologies.openanzo.AnzoFactory.getRole(resource,_graph.getNamedGraphUri(),dataset());
				if (_canBeRemovedFromBy != null) {
					for(StatementStreamListener listener : listeners){
						listener.canBeRemovedFromByRemoved(org.openanzo.ontologies.openanzo.StatementStreamImpl.this,_canBeRemovedFromBy);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(createdByProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.openanzo.User _createdBy = org.openanzo.ontologies.openanzo.AnzoFactory.getUser(resource,_graph.getNamedGraphUri(),dataset());
				if (_createdBy != null) {
					for(StatementStreamListener listener : listeners){
						listener.createdByRemoved(org.openanzo.ontologies.openanzo.StatementStreamImpl.this,_createdBy);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(datasourceProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(StatementStreamListener listener : listeners){
					listener.datasourceChanged(org.openanzo.ontologies.openanzo.StatementStreamImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(inheritsFromProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.openanzo.NamedGraph _inheritsFrom = org.openanzo.ontologies.openanzo.AnzoFactory.getNamedGraph(resource,_graph.getNamedGraphUri(),dataset());
				if (_inheritsFrom != null) {
					for(StatementStreamListener listener : listeners){
						listener.inheritsFromRemoved(org.openanzo.ontologies.openanzo.StatementStreamImpl.this,_inheritsFrom);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(lastModifiedByUserProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.openanzo.User _lastModifiedByUser = org.openanzo.ontologies.openanzo.AnzoFactory.getUser(resource,_graph.getNamedGraphUri(),dataset());
				if (_lastModifiedByUser != null) {
					for(StatementStreamListener listener : listeners){
						listener.lastModifiedByUserRemoved(org.openanzo.ontologies.openanzo.StatementStreamImpl.this,_lastModifiedByUser);
					}
				}
				return;
			}
		}
		}}
	}
	


}