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
 * Implementation of {@link org.openanzo.ontologies.system.Operation}
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#Operation)</p>
 * <br>
 */
public class OperationImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.system.Operation {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI nameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#name");
	protected static final org.openanzo.rdf.URI bypassPoolProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#bypassPool");
	protected static final org.openanzo.rdf.URI restEndpointProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#restEndpoint");
	protected static final org.openanzo.rdf.URI restTypeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#restType");
	protected static final org.openanzo.rdf.URI sysadminRequiredProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#sysadminRequired");
	protected static final org.openanzo.rdf.URI wsOperationProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#wsOperation");
	protected static final org.openanzo.rdf.URI requestParameterProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#requestParameter");
	protected static final org.openanzo.rdf.URI requestParameter0Property = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#requestParameter0");
	protected static final org.openanzo.rdf.URI requestParameter1Property = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#requestParameter1");
	protected static final org.openanzo.rdf.URI requestParameter2Property = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#requestParameter2");
	protected static final org.openanzo.rdf.URI requestParameter3Property = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#requestParameter3");
	protected static final org.openanzo.rdf.URI requestParameter4Property = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#requestParameter4");
	protected static final org.openanzo.rdf.URI requestParameter5Property = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#requestParameter5");
	protected static final org.openanzo.rdf.URI requestParameter6Property = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#requestParameter6");
	protected static final org.openanzo.rdf.URI requestParameter7Property = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#requestParameter7");
	protected static final org.openanzo.rdf.URI resultProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#result");

	OperationImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static OperationImpl getOperation(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Operation.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new OperationImpl(resource, namedGraphUri, dataset);
	}
	    
	static OperationImpl createOperation(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		OperationImpl impl = new OperationImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Operation.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, Operation.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, nameProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, bypassPoolProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, restEndpointProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, restTypeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, sysadminRequiredProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, wsOperationProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, requestParameterProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, requestParameter0Property, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, requestParameter1Property, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, requestParameter2Property, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, requestParameter3Property, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, requestParameter4Property, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, requestParameter5Property, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, requestParameter6Property, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, requestParameter7Property, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, resultProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.Operation.TYPE, _graph.getNamedGraphUri()));
		return list;
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": name getProperty() in org.openanzo.ontologies.system.Operation model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal name in Operation is not of type java.lang.String", literal);
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
	 * Clears all values for 'bypassPool'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearBypassPool(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, bypassPoolProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#bypassPool
	public java.lang.Boolean getBypassPool(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, bypassPoolProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": bypassPool getProperty() in org.openanzo.ontologies.system.Operation model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal bypassPool in Operation is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getBypassPool() throws org.openanzo.rdf.jastor.JastorException {
		return getBypassPool(false);
	}
	
	public void setBypassPool(java.lang.Boolean bypassPool) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, bypassPoolProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (bypassPool != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(bypassPool,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, bypassPoolProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'restEndpoint'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearRestEndpoint(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, restEndpointProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#restEndpoint
	public java.lang.String getRestEndpoint(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, restEndpointProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": restEndpoint getProperty() in org.openanzo.ontologies.system.Operation model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal restEndpoint in Operation is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getRestEndpoint() throws org.openanzo.rdf.jastor.JastorException {
		return getRestEndpoint(false);
	}
	
	public void setRestEndpoint(java.lang.String restEndpoint) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, restEndpointProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (restEndpoint != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(restEndpoint,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, restEndpointProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'restType'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearRestType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, restTypeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#restType
	public java.lang.String getRestType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, restTypeProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": restType getProperty() in org.openanzo.ontologies.system.Operation model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal restType in Operation is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getRestType() throws org.openanzo.rdf.jastor.JastorException {
		return getRestType(false);
	}
	
	public void setRestType(java.lang.String restType) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, restTypeProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (restType != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(restType,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, restTypeProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'sysadminRequired'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearSysadminRequired(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, sysadminRequiredProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#sysadminRequired
	public java.lang.Boolean getSysadminRequired(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, sysadminRequiredProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": sysadminRequired getProperty() in org.openanzo.ontologies.system.Operation model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal sysadminRequired in Operation is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getSysadminRequired() throws org.openanzo.rdf.jastor.JastorException {
		return getSysadminRequired(false);
	}
	
	public void setSysadminRequired(java.lang.Boolean sysadminRequired) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, sysadminRequiredProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (sysadminRequired != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(sysadminRequired,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, sysadminRequiredProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'wsOperation'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearWsOperation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, wsOperationProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#wsOperation
	public java.lang.String getWsOperation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, wsOperationProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": wsOperation getProperty() in org.openanzo.ontologies.system.Operation model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal wsOperation in Operation is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getWsOperation() throws org.openanzo.rdf.jastor.JastorException {
		return getWsOperation(false);
	}
	
	public void setWsOperation(java.lang.String wsOperation) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, wsOperationProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (wsOperation != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(wsOperation,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, wsOperationProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'requestParameter'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearRequestParameter(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, requestParameterProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#requestParameter

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.system.Parameter> propertyCollectionRequestParameter = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.system.Parameter>() {
		public org.openanzo.ontologies.system.Parameter getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.system.SystemFactory.getParameter((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.system.Parameter 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Parameter> getRequestParameter(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionRequestParameter.getPropertyCollection(_dataset, _graph, _resource,requestParameterProperty, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#Parameter"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.system.Parameter  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Parameter> getRequestParameter() throws org.openanzo.rdf.jastor.JastorException {
		return getRequestParameter(false);
	}

/**
     * 
     * @param requestParameter value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addRequestParameter(org.openanzo.ontologies.system.Parameter requestParameter) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, requestParameterProperty,requestParameter.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.system.Parameter addRequestParameter() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.system.Parameter requestParameter = org.openanzo.ontologies.system.SystemFactory.createParameter(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, requestParameterProperty,requestParameter.resource(),_graph.getNamedGraphUri());
		return requestParameter;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.system.Parameter addRequestParameter(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.system.Parameter requestParameter = org.openanzo.ontologies.system.SystemFactory.getParameter(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, requestParameterProperty,requestParameter.resource(),_graph.getNamedGraphUri());
		return requestParameter;
	}
	
	/**
	 * Remove object
	 * @param requestParameter object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeRequestParameter(org.openanzo.ontologies.system.Parameter requestParameter) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, requestParameterProperty, requestParameter.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, requestParameterProperty, requestParameter.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeRequestParameter(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, requestParameterProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, requestParameterProperty, resource,_graph.getNamedGraphUri());
	}
 
	/**
	 * Clears all values for 'requestParameter0'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearRequestParameter0(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, requestParameter0Property, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#requestParameter0

	public org.openanzo.ontologies.system.Parameter getRequestParameter0(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, requestParameter0Property, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": requestParameter0 getProperty() in org.openanzo.ontologies.system.Operation model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.system.SystemFactory.getParameter(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.system.Parameter getRequestParameter0() throws org.openanzo.rdf.jastor.JastorException {
		return getRequestParameter0(false);
	}

	public void setRequestParameter0(org.openanzo.ontologies.system.Parameter requestParameter0) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, requestParameter0Property, null,_graph.getNamedGraphUri());
		if (requestParameter0 != null) {
			_dataset.add(_resource, requestParameter0Property, requestParameter0.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.system.Parameter setRequestParameter0() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, requestParameter0Property, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.system.Parameter requestParameter0 = org.openanzo.ontologies.system.SystemFactory.createParameter(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, requestParameter0Property, requestParameter0.resource(),_graph.getNamedGraphUri());
		return requestParameter0;
	}
	
	public org.openanzo.ontologies.system.Parameter setRequestParameter0(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, requestParameter0Property, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, requestParameter0Property, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.system.Parameter requestParameter0 = org.openanzo.ontologies.system.SystemFactory.getParameter(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, requestParameter0Property, requestParameter0.resource(),_graph.getNamedGraphUri());
		return requestParameter0;
	}
	
	/**
	 * Clears all values for 'requestParameter1'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearRequestParameter1(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, requestParameter1Property, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#requestParameter1

	public org.openanzo.ontologies.system.Parameter getRequestParameter1(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, requestParameter1Property, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": requestParameter1 getProperty() in org.openanzo.ontologies.system.Operation model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.system.SystemFactory.getParameter(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.system.Parameter getRequestParameter1() throws org.openanzo.rdf.jastor.JastorException {
		return getRequestParameter1(false);
	}

	public void setRequestParameter1(org.openanzo.ontologies.system.Parameter requestParameter1) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, requestParameter1Property, null,_graph.getNamedGraphUri());
		if (requestParameter1 != null) {
			_dataset.add(_resource, requestParameter1Property, requestParameter1.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.system.Parameter setRequestParameter1() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, requestParameter1Property, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.system.Parameter requestParameter1 = org.openanzo.ontologies.system.SystemFactory.createParameter(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, requestParameter1Property, requestParameter1.resource(),_graph.getNamedGraphUri());
		return requestParameter1;
	}
	
	public org.openanzo.ontologies.system.Parameter setRequestParameter1(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, requestParameter1Property, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, requestParameter1Property, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.system.Parameter requestParameter1 = org.openanzo.ontologies.system.SystemFactory.getParameter(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, requestParameter1Property, requestParameter1.resource(),_graph.getNamedGraphUri());
		return requestParameter1;
	}
	
	/**
	 * Clears all values for 'requestParameter2'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearRequestParameter2(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, requestParameter2Property, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#requestParameter2

	public org.openanzo.ontologies.system.Parameter getRequestParameter2(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, requestParameter2Property, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": requestParameter2 getProperty() in org.openanzo.ontologies.system.Operation model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.system.SystemFactory.getParameter(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.system.Parameter getRequestParameter2() throws org.openanzo.rdf.jastor.JastorException {
		return getRequestParameter2(false);
	}

	public void setRequestParameter2(org.openanzo.ontologies.system.Parameter requestParameter2) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, requestParameter2Property, null,_graph.getNamedGraphUri());
		if (requestParameter2 != null) {
			_dataset.add(_resource, requestParameter2Property, requestParameter2.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.system.Parameter setRequestParameter2() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, requestParameter2Property, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.system.Parameter requestParameter2 = org.openanzo.ontologies.system.SystemFactory.createParameter(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, requestParameter2Property, requestParameter2.resource(),_graph.getNamedGraphUri());
		return requestParameter2;
	}
	
	public org.openanzo.ontologies.system.Parameter setRequestParameter2(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, requestParameter2Property, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, requestParameter2Property, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.system.Parameter requestParameter2 = org.openanzo.ontologies.system.SystemFactory.getParameter(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, requestParameter2Property, requestParameter2.resource(),_graph.getNamedGraphUri());
		return requestParameter2;
	}
	
	/**
	 * Clears all values for 'requestParameter3'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearRequestParameter3(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, requestParameter3Property, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#requestParameter3

	public org.openanzo.ontologies.system.Parameter getRequestParameter3(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, requestParameter3Property, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": requestParameter3 getProperty() in org.openanzo.ontologies.system.Operation model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.system.SystemFactory.getParameter(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.system.Parameter getRequestParameter3() throws org.openanzo.rdf.jastor.JastorException {
		return getRequestParameter3(false);
	}

	public void setRequestParameter3(org.openanzo.ontologies.system.Parameter requestParameter3) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, requestParameter3Property, null,_graph.getNamedGraphUri());
		if (requestParameter3 != null) {
			_dataset.add(_resource, requestParameter3Property, requestParameter3.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.system.Parameter setRequestParameter3() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, requestParameter3Property, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.system.Parameter requestParameter3 = org.openanzo.ontologies.system.SystemFactory.createParameter(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, requestParameter3Property, requestParameter3.resource(),_graph.getNamedGraphUri());
		return requestParameter3;
	}
	
	public org.openanzo.ontologies.system.Parameter setRequestParameter3(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, requestParameter3Property, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, requestParameter3Property, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.system.Parameter requestParameter3 = org.openanzo.ontologies.system.SystemFactory.getParameter(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, requestParameter3Property, requestParameter3.resource(),_graph.getNamedGraphUri());
		return requestParameter3;
	}
	
	/**
	 * Clears all values for 'requestParameter4'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearRequestParameter4(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, requestParameter4Property, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#requestParameter4

	public org.openanzo.ontologies.system.Parameter getRequestParameter4(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, requestParameter4Property, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": requestParameter4 getProperty() in org.openanzo.ontologies.system.Operation model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.system.SystemFactory.getParameter(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.system.Parameter getRequestParameter4() throws org.openanzo.rdf.jastor.JastorException {
		return getRequestParameter4(false);
	}

	public void setRequestParameter4(org.openanzo.ontologies.system.Parameter requestParameter4) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, requestParameter4Property, null,_graph.getNamedGraphUri());
		if (requestParameter4 != null) {
			_dataset.add(_resource, requestParameter4Property, requestParameter4.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.system.Parameter setRequestParameter4() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, requestParameter4Property, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.system.Parameter requestParameter4 = org.openanzo.ontologies.system.SystemFactory.createParameter(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, requestParameter4Property, requestParameter4.resource(),_graph.getNamedGraphUri());
		return requestParameter4;
	}
	
	public org.openanzo.ontologies.system.Parameter setRequestParameter4(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, requestParameter4Property, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, requestParameter4Property, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.system.Parameter requestParameter4 = org.openanzo.ontologies.system.SystemFactory.getParameter(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, requestParameter4Property, requestParameter4.resource(),_graph.getNamedGraphUri());
		return requestParameter4;
	}
	
	/**
	 * Clears all values for 'requestParameter5'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearRequestParameter5(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, requestParameter5Property, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#requestParameter5

	public org.openanzo.ontologies.system.Parameter getRequestParameter5(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, requestParameter5Property, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": requestParameter5 getProperty() in org.openanzo.ontologies.system.Operation model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.system.SystemFactory.getParameter(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.system.Parameter getRequestParameter5() throws org.openanzo.rdf.jastor.JastorException {
		return getRequestParameter5(false);
	}

	public void setRequestParameter5(org.openanzo.ontologies.system.Parameter requestParameter5) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, requestParameter5Property, null,_graph.getNamedGraphUri());
		if (requestParameter5 != null) {
			_dataset.add(_resource, requestParameter5Property, requestParameter5.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.system.Parameter setRequestParameter5() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, requestParameter5Property, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.system.Parameter requestParameter5 = org.openanzo.ontologies.system.SystemFactory.createParameter(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, requestParameter5Property, requestParameter5.resource(),_graph.getNamedGraphUri());
		return requestParameter5;
	}
	
	public org.openanzo.ontologies.system.Parameter setRequestParameter5(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, requestParameter5Property, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, requestParameter5Property, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.system.Parameter requestParameter5 = org.openanzo.ontologies.system.SystemFactory.getParameter(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, requestParameter5Property, requestParameter5.resource(),_graph.getNamedGraphUri());
		return requestParameter5;
	}
	
	/**
	 * Clears all values for 'requestParameter6'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearRequestParameter6(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, requestParameter6Property, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#requestParameter6

	public org.openanzo.ontologies.system.Parameter getRequestParameter6(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, requestParameter6Property, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": requestParameter6 getProperty() in org.openanzo.ontologies.system.Operation model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.system.SystemFactory.getParameter(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.system.Parameter getRequestParameter6() throws org.openanzo.rdf.jastor.JastorException {
		return getRequestParameter6(false);
	}

	public void setRequestParameter6(org.openanzo.ontologies.system.Parameter requestParameter6) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, requestParameter6Property, null,_graph.getNamedGraphUri());
		if (requestParameter6 != null) {
			_dataset.add(_resource, requestParameter6Property, requestParameter6.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.system.Parameter setRequestParameter6() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, requestParameter6Property, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.system.Parameter requestParameter6 = org.openanzo.ontologies.system.SystemFactory.createParameter(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, requestParameter6Property, requestParameter6.resource(),_graph.getNamedGraphUri());
		return requestParameter6;
	}
	
	public org.openanzo.ontologies.system.Parameter setRequestParameter6(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, requestParameter6Property, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, requestParameter6Property, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.system.Parameter requestParameter6 = org.openanzo.ontologies.system.SystemFactory.getParameter(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, requestParameter6Property, requestParameter6.resource(),_graph.getNamedGraphUri());
		return requestParameter6;
	}
	
	/**
	 * Clears all values for 'requestParameter7'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearRequestParameter7(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, requestParameter7Property, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#requestParameter7

	public org.openanzo.ontologies.system.Parameter getRequestParameter7(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		java.util.Collection<org.openanzo.rdf.Statement> result = null;
		result=_dataset.find(includeEntireDataset, _resource, requestParameter7Property, null,_graph.getNamedGraphUri());
		if(result.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = result.iterator().next();
		if (statement == null)
			return null;
		if (!((statement.getObject() instanceof org.openanzo.rdf.URI)||(statement.getObject() instanceof org.openanzo.rdf.BlankNode)))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": requestParameter7 getProperty() in org.openanzo.ontologies.system.Operation model not Resource", statement.getObject());
		org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
		return org.openanzo.ontologies.system.SystemFactory.getParameter(resource,(includeEntireDataset)?null:_graph.getNamedGraphUri(),_dataset);
		
	}
	
	public org.openanzo.ontologies.system.Parameter getRequestParameter7() throws org.openanzo.rdf.jastor.JastorException {
		return getRequestParameter7(false);
	}

	public void setRequestParameter7(org.openanzo.ontologies.system.Parameter requestParameter7) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, requestParameter7Property, null,_graph.getNamedGraphUri());
		if (requestParameter7 != null) {
			_dataset.add(_resource, requestParameter7Property, requestParameter7.resource(),_graph.getNamedGraphUri());
		}			
	}
		
	public org.openanzo.ontologies.system.Parameter setRequestParameter7() throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, requestParameter7Property, null,_graph.getNamedGraphUri());
		org.openanzo.ontologies.system.Parameter requestParameter7 = org.openanzo.ontologies.system.SystemFactory.createParameter(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, requestParameter7Property, requestParameter7.resource(),_graph.getNamedGraphUri());
		return requestParameter7;
	}
	
	public org.openanzo.ontologies.system.Parameter setRequestParameter7(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (_dataset.contains(_resource, requestParameter7Property, null,_graph.getNamedGraphUri())) {
			_dataset.remove(_resource, requestParameter7Property, null,_graph.getNamedGraphUri());
		}
		org.openanzo.ontologies.system.Parameter requestParameter7 = org.openanzo.ontologies.system.SystemFactory.getParameter(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, requestParameter7Property, requestParameter7.resource(),_graph.getNamedGraphUri());
		return requestParameter7;
	}
	
	/**
	 * Clears all values for 'result'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearResult(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, resultProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#result

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.system.Parameter> propertyCollectionResult = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.system.Parameter>() {
		public org.openanzo.ontologies.system.Parameter getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.system.SystemFactory.getParameter((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.system.Parameter 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Parameter> getResult(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionResult.getPropertyCollection(_dataset, _graph, _resource,resultProperty, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#Parameter"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.system.Parameter  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Parameter> getResult() throws org.openanzo.rdf.jastor.JastorException {
		return getResult(false);
	}

/**
     * 
     * @param result value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addResult(org.openanzo.ontologies.system.Parameter result) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, resultProperty,result.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.system.Parameter addResult() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.system.Parameter result = org.openanzo.ontologies.system.SystemFactory.createParameter(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, resultProperty,result.resource(),_graph.getNamedGraphUri());
		return result;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.system.Parameter addResult(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.system.Parameter result = org.openanzo.ontologies.system.SystemFactory.getParameter(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, resultProperty,result.resource(),_graph.getNamedGraphUri());
		return result;
	}
	
	/**
	 * Remove object
	 * @param result object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeResult(org.openanzo.ontologies.system.Parameter result) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, resultProperty, result.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, resultProperty, result.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeResult(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, resultProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, resultProperty, resource,_graph.getNamedGraphUri());
	}
  


	protected java.util.concurrent.CopyOnWriteArraySet<OperationListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<OperationListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof OperationListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	OperationListener list = (OperationListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof OperationListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		OperationListener list = (OperationListener)listener;
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
			if (statement.getPredicate().equals(nameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(OperationListener listener : listeners){
					listener.nameChanged(org.openanzo.ontologies.system.OperationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(bypassPoolProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(OperationListener listener : listeners){
					listener.bypassPoolChanged(org.openanzo.ontologies.system.OperationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(restEndpointProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(OperationListener listener : listeners){
					listener.restEndpointChanged(org.openanzo.ontologies.system.OperationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(restTypeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(OperationListener listener : listeners){
					listener.restTypeChanged(org.openanzo.ontologies.system.OperationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(sysadminRequiredProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(OperationListener listener : listeners){
					listener.sysadminRequiredChanged(org.openanzo.ontologies.system.OperationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(wsOperationProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(OperationListener listener : listeners){
					listener.wsOperationChanged(org.openanzo.ontologies.system.OperationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(requestParameterProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.system.Parameter _requestParameter = org.openanzo.ontologies.system.SystemFactory.getParameter(resource,_graph.getNamedGraphUri(),dataset());
				if (_requestParameter != null) {
					for(OperationListener listener : listeners){
						listener.requestParameterAdded(org.openanzo.ontologies.system.OperationImpl.this,_requestParameter);
					}
				}			
			}
			if (statement.getPredicate().equals(requestParameter0Property)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(OperationListener listener : listeners){
					listener.requestParameter0Changed(org.openanzo.ontologies.system.OperationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(requestParameter1Property)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(OperationListener listener : listeners){
					listener.requestParameter1Changed(org.openanzo.ontologies.system.OperationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(requestParameter2Property)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(OperationListener listener : listeners){
					listener.requestParameter2Changed(org.openanzo.ontologies.system.OperationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(requestParameter3Property)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(OperationListener listener : listeners){
					listener.requestParameter3Changed(org.openanzo.ontologies.system.OperationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(requestParameter4Property)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(OperationListener listener : listeners){
					listener.requestParameter4Changed(org.openanzo.ontologies.system.OperationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(requestParameter5Property)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(OperationListener listener : listeners){
					listener.requestParameter5Changed(org.openanzo.ontologies.system.OperationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(requestParameter6Property)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(OperationListener listener : listeners){
					listener.requestParameter6Changed(org.openanzo.ontologies.system.OperationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(requestParameter7Property)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;				
				for(OperationListener listener : listeners){
					listener.requestParameter7Changed(org.openanzo.ontologies.system.OperationImpl.this);
				}			
			}
			if (statement.getPredicate().equals(resultProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.system.Parameter _result = org.openanzo.ontologies.system.SystemFactory.getParameter(resource,_graph.getNamedGraphUri(),dataset());
				if (_result != null) {
					for(OperationListener listener : listeners){
						listener.resultAdded(org.openanzo.ontologies.system.OperationImpl.this,_result);
					}
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(nameProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(OperationListener listener : listeners) {
					listener.nameChanged(org.openanzo.ontologies.system.OperationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(bypassPoolProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(OperationListener listener : listeners) {
					listener.bypassPoolChanged(org.openanzo.ontologies.system.OperationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(restEndpointProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(OperationListener listener : listeners) {
					listener.restEndpointChanged(org.openanzo.ontologies.system.OperationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(restTypeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(OperationListener listener : listeners) {
					listener.restTypeChanged(org.openanzo.ontologies.system.OperationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(sysadminRequiredProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(OperationListener listener : listeners) {
					listener.sysadminRequiredChanged(org.openanzo.ontologies.system.OperationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(wsOperationProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(OperationListener listener : listeners) {
					listener.wsOperationChanged(org.openanzo.ontologies.system.OperationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(requestParameterProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.system.Parameter _requestParameter = org.openanzo.ontologies.system.SystemFactory.getParameter(resource,_graph.getNamedGraphUri(),dataset());
				if (_requestParameter != null) {
					for(OperationListener listener : listeners){
						listener.requestParameterRemoved(org.openanzo.ontologies.system.OperationImpl.this,_requestParameter);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(requestParameter0Property)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(OperationListener listener : listeners){
					listener.requestParameter0Changed(org.openanzo.ontologies.system.OperationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(requestParameter1Property)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(OperationListener listener : listeners){
					listener.requestParameter1Changed(org.openanzo.ontologies.system.OperationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(requestParameter2Property)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(OperationListener listener : listeners){
					listener.requestParameter2Changed(org.openanzo.ontologies.system.OperationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(requestParameter3Property)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(OperationListener listener : listeners){
					listener.requestParameter3Changed(org.openanzo.ontologies.system.OperationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(requestParameter4Property)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(OperationListener listener : listeners){
					listener.requestParameter4Changed(org.openanzo.ontologies.system.OperationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(requestParameter5Property)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(OperationListener listener : listeners){
					listener.requestParameter5Changed(org.openanzo.ontologies.system.OperationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(requestParameter6Property)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(OperationListener listener : listeners){
					listener.requestParameter6Changed(org.openanzo.ontologies.system.OperationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(requestParameter7Property)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				for(OperationListener listener : listeners){
					listener.requestParameter7Changed(org.openanzo.ontologies.system.OperationImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(resultProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.system.Parameter _result = org.openanzo.ontologies.system.SystemFactory.getParameter(resource,_graph.getNamedGraphUri(),dataset());
				if (_result != null) {
					for(OperationListener listener : listeners){
						listener.resultRemoved(org.openanzo.ontologies.system.OperationImpl.this,_result);
					}
				}
				return;
			}
		}
		}}
	}
	


}