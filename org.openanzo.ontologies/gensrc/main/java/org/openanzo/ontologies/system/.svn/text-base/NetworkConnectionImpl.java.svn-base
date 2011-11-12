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
 * Implementation of {@link org.openanzo.ontologies.system.NetworkConnection}
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#NetworkConnection)</p>
 * <br>
 */
public class NetworkConnectionImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.system.NetworkConnection {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI hostProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#host");
	protected static final org.openanzo.rdf.URI keystoreFileProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#keystoreFile");
	protected static final org.openanzo.rdf.URI keystorePasswordProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#keystorePassword");
	protected static final org.openanzo.rdf.URI keystoreTypeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#keystoreType");
	protected static final org.openanzo.rdf.URI portProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#port");
	protected static final org.openanzo.rdf.URI timeoutProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#timeout");
	protected static final org.openanzo.rdf.URI truststoreFileProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#truststoreFile");
	protected static final org.openanzo.rdf.URI truststorePasswordProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#truststorePassword");
	protected static final org.openanzo.rdf.URI truststoreTypeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#truststoreType");
	protected static final org.openanzo.rdf.URI useSslProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#useSsl");

	NetworkConnectionImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static NetworkConnectionImpl getNetworkConnection(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, NetworkConnection.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new NetworkConnectionImpl(resource, namedGraphUri, dataset);
	}
	    
	static NetworkConnectionImpl createNetworkConnection(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		NetworkConnectionImpl impl = new NetworkConnectionImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, NetworkConnection.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, NetworkConnection.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, hostProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, keystoreFileProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, keystorePasswordProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, keystoreTypeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, portProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, timeoutProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, truststoreFileProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, truststorePasswordProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, truststoreTypeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, useSslProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.NetworkConnection.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'host'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearHost(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, hostProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#host
	public java.lang.String getHost(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, hostProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": host getProperty() in org.openanzo.ontologies.system.NetworkConnection model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal host in NetworkConnection is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getHost() throws org.openanzo.rdf.jastor.JastorException {
		return getHost(false);
	}
	
	public void setHost(java.lang.String host) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, hostProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (host != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(host,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, hostProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'keystoreFile'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearKeystoreFile(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, keystoreFileProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#keystoreFile
	public java.lang.String getKeystoreFile(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, keystoreFileProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": keystoreFile getProperty() in org.openanzo.ontologies.system.NetworkConnection model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal keystoreFile in NetworkConnection is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getKeystoreFile() throws org.openanzo.rdf.jastor.JastorException {
		return getKeystoreFile(false);
	}
	
	public void setKeystoreFile(java.lang.String keystoreFile) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, keystoreFileProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (keystoreFile != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(keystoreFile,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, keystoreFileProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'keystorePassword'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearKeystorePassword(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, keystorePasswordProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#keystorePassword
	public java.lang.String getKeystorePassword(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, keystorePasswordProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": keystorePassword getProperty() in org.openanzo.ontologies.system.NetworkConnection model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal keystorePassword in NetworkConnection is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getKeystorePassword() throws org.openanzo.rdf.jastor.JastorException {
		return getKeystorePassword(false);
	}
	
	public void setKeystorePassword(java.lang.String keystorePassword) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, keystorePasswordProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (keystorePassword != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(keystorePassword,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, keystorePasswordProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'keystoreType'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearKeystoreType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, keystoreTypeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#keystoreType
	public java.lang.String getKeystoreType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, keystoreTypeProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": keystoreType getProperty() in org.openanzo.ontologies.system.NetworkConnection model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal keystoreType in NetworkConnection is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getKeystoreType() throws org.openanzo.rdf.jastor.JastorException {
		return getKeystoreType(false);
	}
	
	public void setKeystoreType(java.lang.String keystoreType) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, keystoreTypeProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (keystoreType != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(keystoreType,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, keystoreTypeProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'port'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearPort(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, portProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#port
	public java.lang.Integer getPort(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, portProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": port getProperty() in org.openanzo.ontologies.system.NetworkConnection model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#int");
		if (!(obj instanceof java.lang.Integer))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal port in NetworkConnection is not of type java.lang.Integer", literal);
		return (java.lang.Integer)obj;
		
	}
	
	public java.lang.Integer getPort() throws org.openanzo.rdf.jastor.JastorException {
		return getPort(false);
	}
	
	public void setPort(java.lang.Integer port) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, portProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (port != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(port,"http://www.w3.org/2001/XMLSchema#int");
			_dataset.add(_resource, portProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'timeout'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearTimeout(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, timeoutProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#timeout
	public java.lang.Long getTimeout(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, timeoutProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": timeout getProperty() in org.openanzo.ontologies.system.NetworkConnection model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#long");
		if (!(obj instanceof java.lang.Long))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal timeout in NetworkConnection is not of type java.lang.Long", literal);
		return (java.lang.Long)obj;
		
	}
	
	public java.lang.Long getTimeout() throws org.openanzo.rdf.jastor.JastorException {
		return getTimeout(false);
	}
	
	public void setTimeout(java.lang.Long timeout) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, timeoutProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (timeout != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(timeout,"http://www.w3.org/2001/XMLSchema#long");
			_dataset.add(_resource, timeoutProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'truststoreFile'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearTruststoreFile(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, truststoreFileProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#truststoreFile
	public java.lang.String getTruststoreFile(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, truststoreFileProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": truststoreFile getProperty() in org.openanzo.ontologies.system.NetworkConnection model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal truststoreFile in NetworkConnection is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getTruststoreFile() throws org.openanzo.rdf.jastor.JastorException {
		return getTruststoreFile(false);
	}
	
	public void setTruststoreFile(java.lang.String truststoreFile) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, truststoreFileProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (truststoreFile != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(truststoreFile,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, truststoreFileProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'truststorePassword'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearTruststorePassword(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, truststorePasswordProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#truststorePassword
	public java.lang.String getTruststorePassword(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, truststorePasswordProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": truststorePassword getProperty() in org.openanzo.ontologies.system.NetworkConnection model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal truststorePassword in NetworkConnection is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getTruststorePassword() throws org.openanzo.rdf.jastor.JastorException {
		return getTruststorePassword(false);
	}
	
	public void setTruststorePassword(java.lang.String truststorePassword) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, truststorePasswordProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (truststorePassword != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(truststorePassword,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, truststorePasswordProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'truststoreType'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearTruststoreType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, truststoreTypeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#truststoreType
	public java.lang.String getTruststoreType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, truststoreTypeProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": truststoreType getProperty() in org.openanzo.ontologies.system.NetworkConnection model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal truststoreType in NetworkConnection is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getTruststoreType() throws org.openanzo.rdf.jastor.JastorException {
		return getTruststoreType(false);
	}
	
	public void setTruststoreType(java.lang.String truststoreType) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, truststoreTypeProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (truststoreType != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(truststoreType,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, truststoreTypeProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'useSsl'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearUseSsl(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, useSslProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#useSsl
	public java.lang.Boolean getUseSsl(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, useSslProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": useSsl getProperty() in org.openanzo.ontologies.system.NetworkConnection model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal useSsl in NetworkConnection is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getUseSsl() throws org.openanzo.rdf.jastor.JastorException {
		return getUseSsl(false);
	}
	
	public void setUseSsl(java.lang.Boolean useSsl) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, useSslProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (useSsl != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(useSsl,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, useSslProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}
 


	protected java.util.concurrent.CopyOnWriteArraySet<NetworkConnectionListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<NetworkConnectionListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof NetworkConnectionListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	NetworkConnectionListener list = (NetworkConnectionListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof NetworkConnectionListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		NetworkConnectionListener list = (NetworkConnectionListener)listener;
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
			if (statement.getPredicate().equals(hostProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(NetworkConnectionListener listener : listeners){
					listener.hostChanged(org.openanzo.ontologies.system.NetworkConnectionImpl.this);
				}			
			}
			if (statement.getPredicate().equals(keystoreFileProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(NetworkConnectionListener listener : listeners){
					listener.keystoreFileChanged(org.openanzo.ontologies.system.NetworkConnectionImpl.this);
				}			
			}
			if (statement.getPredicate().equals(keystorePasswordProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(NetworkConnectionListener listener : listeners){
					listener.keystorePasswordChanged(org.openanzo.ontologies.system.NetworkConnectionImpl.this);
				}			
			}
			if (statement.getPredicate().equals(keystoreTypeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(NetworkConnectionListener listener : listeners){
					listener.keystoreTypeChanged(org.openanzo.ontologies.system.NetworkConnectionImpl.this);
				}			
			}
			if (statement.getPredicate().equals(portProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(NetworkConnectionListener listener : listeners){
					listener.portChanged(org.openanzo.ontologies.system.NetworkConnectionImpl.this);
				}			
			}
			if (statement.getPredicate().equals(timeoutProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(NetworkConnectionListener listener : listeners){
					listener.timeoutChanged(org.openanzo.ontologies.system.NetworkConnectionImpl.this);
				}			
			}
			if (statement.getPredicate().equals(truststoreFileProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(NetworkConnectionListener listener : listeners){
					listener.truststoreFileChanged(org.openanzo.ontologies.system.NetworkConnectionImpl.this);
				}			
			}
			if (statement.getPredicate().equals(truststorePasswordProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(NetworkConnectionListener listener : listeners){
					listener.truststorePasswordChanged(org.openanzo.ontologies.system.NetworkConnectionImpl.this);
				}			
			}
			if (statement.getPredicate().equals(truststoreTypeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(NetworkConnectionListener listener : listeners){
					listener.truststoreTypeChanged(org.openanzo.ontologies.system.NetworkConnectionImpl.this);
				}			
			}
			if (statement.getPredicate().equals(useSslProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(NetworkConnectionListener listener : listeners){
					listener.useSslChanged(org.openanzo.ontologies.system.NetworkConnectionImpl.this);
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(hostProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(NetworkConnectionListener listener : listeners) {
					listener.hostChanged(org.openanzo.ontologies.system.NetworkConnectionImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(keystoreFileProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(NetworkConnectionListener listener : listeners) {
					listener.keystoreFileChanged(org.openanzo.ontologies.system.NetworkConnectionImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(keystorePasswordProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(NetworkConnectionListener listener : listeners) {
					listener.keystorePasswordChanged(org.openanzo.ontologies.system.NetworkConnectionImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(keystoreTypeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(NetworkConnectionListener listener : listeners) {
					listener.keystoreTypeChanged(org.openanzo.ontologies.system.NetworkConnectionImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(portProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(NetworkConnectionListener listener : listeners) {
					listener.portChanged(org.openanzo.ontologies.system.NetworkConnectionImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(timeoutProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(NetworkConnectionListener listener : listeners) {
					listener.timeoutChanged(org.openanzo.ontologies.system.NetworkConnectionImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(truststoreFileProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(NetworkConnectionListener listener : listeners) {
					listener.truststoreFileChanged(org.openanzo.ontologies.system.NetworkConnectionImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(truststorePasswordProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(NetworkConnectionListener listener : listeners) {
					listener.truststorePasswordChanged(org.openanzo.ontologies.system.NetworkConnectionImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(truststoreTypeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(NetworkConnectionListener listener : listeners) {
					listener.truststoreTypeChanged(org.openanzo.ontologies.system.NetworkConnectionImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(useSslProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(NetworkConnectionListener listener : listeners) {
					listener.useSslChanged(org.openanzo.ontologies.system.NetworkConnectionImpl.this);
				}
				return;
			}
		}
		}}
	}
	


}