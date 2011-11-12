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
 * Implementation of {@link org.openanzo.ontologies.system.AuthorizationRule}
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#AuthorizationRule)</p>
 * <br>
 */
public class AuthorizationRuleImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.system.AuthorizationRule {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI uriPatternProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#uriPattern");
	protected static final org.openanzo.rdf.URI privilegeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#privilege");
	protected static final org.openanzo.rdf.URI roleProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#role");

	AuthorizationRuleImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static AuthorizationRuleImpl getAuthorizationRule(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, AuthorizationRule.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new AuthorizationRuleImpl(resource, namedGraphUri, dataset);
	}
	    
	static AuthorizationRuleImpl createAuthorizationRule(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		AuthorizationRuleImpl impl = new AuthorizationRuleImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, AuthorizationRule.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, AuthorizationRule.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, uriPatternProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, privilegeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, roleProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.AuthorizationRule.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'uriPattern'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearUriPattern(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, uriPatternProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#uriPattern


	org.openanzo.rdf.jastor.PropertyCollection<java.lang.String> propertyCollectionUriPattern = new org.openanzo.rdf.jastor.PropertyCollection<java.lang.String>() {
		public java.lang.String getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://openanzo.org/ontologies/2008/07/System#uriPattern properties in AuthorizationRule model not a Literal",value);
				}
			}
	};

	public java.util.Collection<java.lang.String> getUriPattern(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionUriPattern.getPropertyCollection(_dataset, _graph, _resource,uriPatternProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#string"), includeEntireDataset);
	}
	
	public java.util.Collection<java.lang.String> getUriPattern() throws org.openanzo.rdf.jastor.JastorException {
		return getUriPattern(false);
	}

	public void addUriPattern(java.lang.String uriPattern) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(uriPattern,"http://www.w3.org/2001/XMLSchema#string");
		//if (_dataset.contains(_resource, uriPatternProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (uriPattern != null) {
			_dataset.add(_resource, uriPatternProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeUriPattern(java.lang.String uriPattern) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(uriPattern,"http://www.w3.org/2001/XMLSchema#string");
		if (!_dataset.contains(_resource, uriPatternProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, uriPatternProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'privilege'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearPrivilege(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, privilegeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#privilege
	public java.lang.String getPrivilege(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, privilegeProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": privilege getProperty() in org.openanzo.ontologies.system.AuthorizationRule model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal privilege in AuthorizationRule is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getPrivilege() throws org.openanzo.rdf.jastor.JastorException {
		return getPrivilege(false);
	}
	
	public void setPrivilege(java.lang.String privilege) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, privilegeProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (privilege != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(privilege,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, privilegeProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'role'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearRole(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, roleProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#role

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.openanzo.Role> propertyCollectionRole = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.openanzo.Role>() {
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
	public java.util.Collection<org.openanzo.ontologies.openanzo.Role> getRole(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionRole.getPropertyCollection(_dataset, _graph, _resource,roleProperty, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/Anzo#Role"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.openanzo.Role  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.Role> getRole() throws org.openanzo.rdf.jastor.JastorException {
		return getRole(false);
	}

/**
     * 
     * @param role value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addRole(org.openanzo.ontologies.openanzo.Role role) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, roleProperty,role.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.openanzo.Role addRole() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.openanzo.Role role = org.openanzo.ontologies.openanzo.AnzoFactory.createRole(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, roleProperty,role.resource(),_graph.getNamedGraphUri());
		return role;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.openanzo.Role addRole(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.openanzo.Role role = org.openanzo.ontologies.openanzo.AnzoFactory.getRole(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, roleProperty,role.resource(),_graph.getNamedGraphUri());
		return role;
	}
	
	/**
	 * Remove object
	 * @param role object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeRole(org.openanzo.ontologies.openanzo.Role role) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, roleProperty, role.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, roleProperty, role.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeRole(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, roleProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, roleProperty, resource,_graph.getNamedGraphUri());
	}
  


	protected java.util.concurrent.CopyOnWriteArraySet<AuthorizationRuleListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<AuthorizationRuleListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof AuthorizationRuleListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	AuthorizationRuleListener list = (AuthorizationRuleListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof AuthorizationRuleListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		AuthorizationRuleListener list = (AuthorizationRuleListener)listener;
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
			if (statement.getPredicate().equals(uriPatternProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.String) {
					for(AuthorizationRuleListener listener : listeners){
						listener.uriPatternAdded(org.openanzo.ontologies.system.AuthorizationRuleImpl.this,(java.lang.String)obj);
					}
				}			
			}
			if (statement.getPredicate().equals(privilegeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(AuthorizationRuleListener listener : listeners){
					listener.privilegeChanged(org.openanzo.ontologies.system.AuthorizationRuleImpl.this);
				}			
			}
			if (statement.getPredicate().equals(roleProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.openanzo.Role _role = org.openanzo.ontologies.openanzo.AnzoFactory.getRole(resource,_graph.getNamedGraphUri(),dataset());
				if (_role != null) {
					for(AuthorizationRuleListener listener : listeners){
						listener.roleAdded(org.openanzo.ontologies.system.AuthorizationRuleImpl.this,_role);
					}
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(uriPatternProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.String) {
					for(AuthorizationRuleListener listener : listeners){
						listener.uriPatternRemoved(org.openanzo.ontologies.system.AuthorizationRuleImpl.this,(java.lang.String)obj);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(privilegeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(AuthorizationRuleListener listener : listeners) {
					listener.privilegeChanged(org.openanzo.ontologies.system.AuthorizationRuleImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(roleProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.openanzo.Role _role = org.openanzo.ontologies.openanzo.AnzoFactory.getRole(resource,_graph.getNamedGraphUri(),dataset());
				if (_role != null) {
					for(AuthorizationRuleListener listener : listeners){
						listener.roleRemoved(org.openanzo.ontologies.system.AuthorizationRuleImpl.this,_role);
					}
				}
				return;
			}
		}
		}}
	}
	


}