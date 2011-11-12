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
package org.openanzo.ontologies.system;

/**
 * Implementation of {@link org.openanzo.ontologies.system.Type}
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#Type)</p>
 * <br>
 */
public class TypeImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.system.Type {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI javaTypeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#javaType");
	protected static final org.openanzo.rdf.URI nameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#name");
	protected static final org.openanzo.rdf.URI defaultValueProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#defaultValue");
	protected static final org.openanzo.rdf.URI javaTransportTypeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#javaTransportType");
	protected static final org.openanzo.rdf.URI serializerProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#serializer");
	protected static final org.openanzo.rdf.URI defaultJMSFormatProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#defaultJMSFormat");
	protected static final org.openanzo.rdf.URI defaultRestFormatProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#defaultRestFormat");
	protected static final org.openanzo.rdf.URI defaultWSFormatProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#defaultWSFormat");
	protected static final org.openanzo.rdf.URI validFormatProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#validFormat");

	TypeImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static TypeImpl getType(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Type.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new TypeImpl(resource, namedGraphUri, dataset);
	}
	    
	static TypeImpl createType(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		TypeImpl impl = new TypeImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Type.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Type.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, javaTypeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, nameProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, defaultValueProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, javaTransportTypeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, serializerProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, defaultJMSFormatProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, defaultRestFormatProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, defaultWSFormatProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, validFormatProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.Type.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'javaType'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearJavaType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, javaTypeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#javaType
	public java.lang.String getJavaType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, javaTypeProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": javaType getProperty() in org.openanzo.ontologies.system.Type model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal javaType in Type is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getJavaType() throws org.openanzo.rdf.jastor.JastorException {
		return getJavaType(false);
	}
	
	public void setJavaType(java.lang.String javaType) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, javaTypeProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (javaType != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(javaType,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, javaTypeProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'name'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, nameProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#name
	public java.lang.String getName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, nameProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": name getProperty() in org.openanzo.ontologies.system.Type model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal name in Type is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getName() throws org.openanzo.rdf.jastor.JastorException {
		return getName(false);
	}
	
	public void setName(java.lang.String name) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, nameProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (name != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(name,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, nameProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'defaultValue'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDefaultValue(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, defaultValueProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#defaultValue
	public java.lang.String getDefaultValue(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, defaultValueProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": defaultValue getProperty() in org.openanzo.ontologies.system.Type model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal defaultValue in Type is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getDefaultValue() throws org.openanzo.rdf.jastor.JastorException {
		return getDefaultValue(false);
	}
	
	public void setDefaultValue(java.lang.String defaultValue) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, defaultValueProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (defaultValue != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(defaultValue,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, defaultValueProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'javaTransportType'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearJavaTransportType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, javaTransportTypeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#javaTransportType
	public java.lang.String getJavaTransportType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, javaTransportTypeProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": javaTransportType getProperty() in org.openanzo.ontologies.system.Type model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal javaTransportType in Type is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getJavaTransportType() throws org.openanzo.rdf.jastor.JastorException {
		return getJavaTransportType(false);
	}
	
	public void setJavaTransportType(java.lang.String javaTransportType) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, javaTransportTypeProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (javaTransportType != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(javaTransportType,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, javaTransportTypeProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'serializer'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearSerializer(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, serializerProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#serializer
	public java.lang.String getSerializer(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, serializerProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": serializer getProperty() in org.openanzo.ontologies.system.Type model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal serializer in Type is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getSerializer() throws org.openanzo.rdf.jastor.JastorException {
		return getSerializer(false);
	}
	
	public void setSerializer(java.lang.String serializer) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, serializerProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (serializer != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(serializer,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, serializerProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'defaultJMSFormat'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDefaultJMSFormat(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, defaultJMSFormatProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#defaultJMSFormat

	public org.openanzo.ontologies.system.Format getDefaultJMSFormat(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, defaultJMSFormatProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": defaultJMSFormat getProperty() in org.openanzo.ontologies.system.Type model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.system.SystemFactory.getFormat(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.system.Format getDefaultJMSFormat() throws org.openanzo.rdf.jastor.JastorException {
		return getDefaultJMSFormat(false);
	}

	public void setDefaultJMSFormat(org.openanzo.ontologies.system.Format defaultJMSFormat) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, defaultJMSFormatProperty, null,_graph.getNamedGraphUri());
		if (defaultJMSFormat != null) {
			_dataset.add(_resource, defaultJMSFormatProperty, defaultJMSFormat.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.system.Format setDefaultJMSFormat() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, defaultJMSFormatProperty, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.system.Format defaultJMSFormat = org.openanzo.ontologies.system.SystemFactory.createFormat(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, defaultJMSFormatProperty, defaultJMSFormat.resource(),_graph.getNamedGraphUri());
		return defaultJMSFormat;
	}
	
	public org.openanzo.ontologies.system.Format setDefaultJMSFormat(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, defaultJMSFormatProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, defaultJMSFormatProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.system.Format defaultJMSFormat = org.openanzo.ontologies.system.SystemFactory.getFormat(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, defaultJMSFormatProperty, defaultJMSFormat.resource(),_graph.getNamedGraphUri());
		return defaultJMSFormat;
	}
	
	/**
	 * Clears all values for 'defaultRestFormat'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDefaultRestFormat(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, defaultRestFormatProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#defaultRestFormat

	public org.openanzo.ontologies.system.Format getDefaultRestFormat(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, defaultRestFormatProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": defaultRestFormat getProperty() in org.openanzo.ontologies.system.Type model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.system.SystemFactory.getFormat(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.system.Format getDefaultRestFormat() throws org.openanzo.rdf.jastor.JastorException {
		return getDefaultRestFormat(false);
	}

	public void setDefaultRestFormat(org.openanzo.ontologies.system.Format defaultRestFormat) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, defaultRestFormatProperty, null,_graph.getNamedGraphUri());
		if (defaultRestFormat != null) {
			_dataset.add(_resource, defaultRestFormatProperty, defaultRestFormat.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.system.Format setDefaultRestFormat() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, defaultRestFormatProperty, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.system.Format defaultRestFormat = org.openanzo.ontologies.system.SystemFactory.createFormat(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, defaultRestFormatProperty, defaultRestFormat.resource(),_graph.getNamedGraphUri());
		return defaultRestFormat;
	}
	
	public org.openanzo.ontologies.system.Format setDefaultRestFormat(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, defaultRestFormatProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, defaultRestFormatProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.system.Format defaultRestFormat = org.openanzo.ontologies.system.SystemFactory.getFormat(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, defaultRestFormatProperty, defaultRestFormat.resource(),_graph.getNamedGraphUri());
		return defaultRestFormat;
	}
	
	/**
	 * Clears all values for 'defaultWSFormat'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDefaultWSFormat(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, defaultWSFormatProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#defaultWSFormat

	public org.openanzo.ontologies.system.Format getDefaultWSFormat(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, defaultWSFormatProperty, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": defaultWSFormat getProperty() in org.openanzo.ontologies.system.Type model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.system.SystemFactory.getFormat(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.system.Format getDefaultWSFormat() throws org.openanzo.rdf.jastor.JastorException {
		return getDefaultWSFormat(false);
	}

	public void setDefaultWSFormat(org.openanzo.ontologies.system.Format defaultWSFormat) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, defaultWSFormatProperty, null,_graph.getNamedGraphUri());
		if (defaultWSFormat != null) {
			_dataset.add(_resource, defaultWSFormatProperty, defaultWSFormat.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.system.Format setDefaultWSFormat() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, defaultWSFormatProperty, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.system.Format defaultWSFormat = org.openanzo.ontologies.system.SystemFactory.createFormat(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, defaultWSFormatProperty, defaultWSFormat.resource(),_graph.getNamedGraphUri());
		return defaultWSFormat;
	}
	
	public org.openanzo.ontologies.system.Format setDefaultWSFormat(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, defaultWSFormatProperty, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, defaultWSFormatProperty, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.system.Format defaultWSFormat = org.openanzo.ontologies.system.SystemFactory.getFormat(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, defaultWSFormatProperty, defaultWSFormat.resource(),_graph.getNamedGraphUri());
		return defaultWSFormat;
	}
	
	/**
	 * Clears all values for 'validFormat'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearValidFormat(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, validFormatProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#validFormat

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.system.Format> propertyCollectionValidFormat = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.system.Format>() {
		public org.openanzo.ontologies.system.Format getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.system.SystemFactory.getFormat((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.system.Format 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Format> getValidFormat(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionValidFormat.getPropertyCollection(_dataset, _graph, _resource,validFormatProperty, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#Format"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.system.Format  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Format> getValidFormat() throws org.openanzo.rdf.jastor.JastorException {
		return getValidFormat(false);
	}

/**
     * 
     * @param validFormat value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addValidFormat(org.openanzo.ontologies.system.Format validFormat) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, validFormatProperty,validFormat.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.system.Format addValidFormat() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.system.Format validFormat = org.openanzo.ontologies.system.SystemFactory.createFormat(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, validFormatProperty,validFormat.resource(),_graph.getNamedGraphUri());
		return validFormat;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.system.Format addValidFormat(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.system.Format validFormat = org.openanzo.ontologies.system.SystemFactory.getFormat(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, validFormatProperty,validFormat.resource(),_graph.getNamedGraphUri());
		return validFormat;
	}
	
	/**
	 * Remove object
	 * @param validFormat object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeValidFormat(org.openanzo.ontologies.system.Format validFormat) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, validFormatProperty, validFormat.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, validFormatProperty, validFormat.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeValidFormat(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, validFormatProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, validFormatProperty, resource,_graph.getNamedGraphUri());
	}
  


	protected java.util.concurrent.CopyOnWriteArraySet<TypeListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<TypeListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof TypeListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	TypeListener list = (TypeListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof TypeListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		TypeListener list = (TypeListener)listener;
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
			if (statement.getPredicate().equals(javaTypeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TypeListener listener : listeners){
					listener.javaTypeChanged(org.openanzo.ontologies.system.TypeImpl.this);
				}			
			}
			if (statement.getPredicate().equals(nameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TypeListener listener : listeners){
					listener.nameChanged(org.openanzo.ontologies.system.TypeImpl.this);
				}			
			}
			if (statement.getPredicate().equals(defaultValueProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TypeListener listener : listeners){
					listener.defaultValueChanged(org.openanzo.ontologies.system.TypeImpl.this);
				}			
			}
			if (statement.getPredicate().equals(javaTransportTypeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TypeListener listener : listeners){
					listener.javaTransportTypeChanged(org.openanzo.ontologies.system.TypeImpl.this);
				}			
			}
			if (statement.getPredicate().equals(serializerProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TypeListener listener : listeners){
					listener.serializerChanged(org.openanzo.ontologies.system.TypeImpl.this);
				}			
			}
			if (statement.getPredicate().equals(defaultJMSFormatProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(TypeListener listener : listeners){
					listener.defaultJMSFormatChanged(org.openanzo.ontologies.system.TypeImpl.this);
				}			
			}
			if (statement.getPredicate().equals(defaultRestFormatProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(TypeListener listener : listeners){
					listener.defaultRestFormatChanged(org.openanzo.ontologies.system.TypeImpl.this);
				}			
			}
			if (statement.getPredicate().equals(defaultWSFormatProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(TypeListener listener : listeners){
					listener.defaultWSFormatChanged(org.openanzo.ontologies.system.TypeImpl.this);
				}			
			}
			if (statement.getPredicate().equals(validFormatProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.system.Format _validFormat = org.openanzo.ontologies.system.SystemFactory.getFormat(resource,_graph.getNamedGraphUri(),dataset());
				if (_validFormat != null) {
					for(TypeListener listener : listeners){
						listener.validFormatAdded(org.openanzo.ontologies.system.TypeImpl.this,_validFormat);
					}
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(javaTypeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TypeListener listener : listeners) {
					listener.javaTypeChanged(org.openanzo.ontologies.system.TypeImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(nameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TypeListener listener : listeners) {
					listener.nameChanged(org.openanzo.ontologies.system.TypeImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(defaultValueProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TypeListener listener : listeners) {
					listener.defaultValueChanged(org.openanzo.ontologies.system.TypeImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(javaTransportTypeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TypeListener listener : listeners) {
					listener.javaTransportTypeChanged(org.openanzo.ontologies.system.TypeImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(serializerProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TypeListener listener : listeners) {
					listener.serializerChanged(org.openanzo.ontologies.system.TypeImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(defaultJMSFormatProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(TypeListener listener : listeners){
					listener.defaultJMSFormatChanged(org.openanzo.ontologies.system.TypeImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(defaultRestFormatProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(TypeListener listener : listeners){
					listener.defaultRestFormatChanged(org.openanzo.ontologies.system.TypeImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(defaultWSFormatProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(TypeListener listener : listeners){
					listener.defaultWSFormatChanged(org.openanzo.ontologies.system.TypeImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(validFormatProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.system.Format _validFormat = org.openanzo.ontologies.system.SystemFactory.getFormat(resource,_graph.getNamedGraphUri(),dataset());
				if (_validFormat != null) {
					for(TypeListener listener : listeners){
						listener.validFormatRemoved(org.openanzo.ontologies.system.TypeImpl.this,_validFormat);
					}
				}
				return;
			}
		}
		}}
	}
	


}