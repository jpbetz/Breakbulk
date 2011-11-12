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
 * Implementation of {@link org.openanzo.ontologies.system.StatisticsProvider}
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#StatisticsProvider)</p>
 * <br>
 */
public class StatisticsProviderImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.system.StatisticsProvider {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI titleProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://purl.org/dc/elements/1.1/title");
	protected static final org.openanzo.rdf.URI descriptionProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://purl.org/dc/elements/1.1/description");
	protected static final org.openanzo.rdf.URI statisticsEnabledProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticsEnabled");
	protected static final org.openanzo.rdf.URI statisticProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statistic");

	StatisticsProviderImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static StatisticsProviderImpl getStatisticsProvider(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, StatisticsProvider.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new StatisticsProviderImpl(resource, namedGraphUri, dataset);
	}
	    
	static StatisticsProviderImpl createStatisticsProvider(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		StatisticsProviderImpl impl = new StatisticsProviderImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, StatisticsProvider.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, StatisticsProvider.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, titleProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, descriptionProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, statisticsEnabledProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, statisticProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.StatisticsProvider.TYPE, _graph.getNamedGraphUri()));
		return list;
	}

	/**
	 * Clears all values for 'title'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearTitle(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, titleProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://purl.org/dc/elements/1.1/title
	public java.lang.String getTitle(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, titleProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": title getProperty() in org.openanzo.ontologies.system.StatisticsProvider model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal title in StatisticsProvider is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getTitle() throws org.openanzo.rdf.jastor.JastorException {
		return getTitle(false);
	}
	
	public void setTitle(java.lang.String title) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, titleProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (title != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(title,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, titleProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'description'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearDescription(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, descriptionProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://purl.org/dc/elements/1.1/description
	public java.lang.String getDescription(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, descriptionProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": description getProperty() in org.openanzo.ontologies.system.StatisticsProvider model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal description in StatisticsProvider is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getDescription() throws org.openanzo.rdf.jastor.JastorException {
		return getDescription(false);
	}
	
	public void setDescription(java.lang.String description) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, descriptionProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (description != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(description,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, descriptionProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'statisticsEnabled'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearStatisticsEnabled(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, statisticsEnabledProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#statisticsEnabled
	public java.lang.Boolean getStatisticsEnabled(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, statisticsEnabledProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": statisticsEnabled getProperty() in org.openanzo.ontologies.system.StatisticsProvider model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal statisticsEnabled in StatisticsProvider is not of type java.lang.Boolean", literal);
		return (java.lang.Boolean)obj;
		
	}
	
	public java.lang.Boolean getStatisticsEnabled() throws org.openanzo.rdf.jastor.JastorException {
		return getStatisticsEnabled(false);
	}
	
	public void setStatisticsEnabled(java.lang.Boolean statisticsEnabled) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, statisticsEnabledProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (statisticsEnabled != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(statisticsEnabled,"http://www.w3.org/2001/XMLSchema#boolean");
			_dataset.add(_resource, statisticsEnabledProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'statistic'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearStatistic(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, statisticProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#statistic

// generating range: http://jastor.adtech.ibm.com/defaultRange

	org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.system.Statistic> propertyCollectionStatistic = new org.openanzo.rdf.jastor.PropertyCollection<org.openanzo.ontologies.system.Statistic>() {
		public org.openanzo.ontologies.system.Statistic getPropertyValue(org.openanzo.rdf.Value resource) {
			try {
				return org.openanzo.ontologies.system.SystemFactory.getStatistic((org.openanzo.rdf.Resource)resource,_graph.getNamedGraphUri(),dataset());
			} catch (org.openanzo.rdf.jastor.JastorException e) {
				throw new java.util.NoSuchElementException(e.getMessage());
			}
		}
	};

	/**
	 * 
	 * @param includeEntireDataset
	 * @return collection of org.openanzo.ontologies.system.Statistic 
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Statistic> getStatistic(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionStatistic.getPropertyCollection(_dataset, _graph, _resource,statisticProperty, org.openanzo.rdf.MemURI.create("http://openanzo.org/ontologies/2008/07/System#Statistic"), includeEntireDataset);
	}
	
	/**
	 * 
	 * @return collection of org.openanzo.ontologies.system.Statistic  not including entire dataset during search
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Statistic> getStatistic() throws org.openanzo.rdf.jastor.JastorException {
		return getStatistic(false);
	}

/**
     * 
     * @param statistic value to add
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public void addStatistic(org.openanzo.ontologies.system.Statistic statistic) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.add(_resource, statisticProperty,statistic.resource(),_graph.getNamedGraphUri());
	}
	
	/**
     * Add anonymous object
     * @return generated object
     * @throws org.openanzo.rdf.jastor.JastorException
     */	
	public org.openanzo.ontologies.system.Statistic addStatistic() throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.system.Statistic statistic = org.openanzo.ontologies.system.SystemFactory.createStatistic(org.openanzo.rdf.jastor.ThingFactory.valueFactory.createBNode(),_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, statisticProperty,statistic.resource(),_graph.getNamedGraphUri());
		return statistic;
	}
	
	 /**
     * Add resource 
     * @param resource resource to add
     * @return jastor object for resource
     * @throws org.openanzo.rdf.jastor.JastorException
     */
	public org.openanzo.ontologies.system.Statistic addStatistic(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		org.openanzo.ontologies.system.Statistic statistic = org.openanzo.ontologies.system.SystemFactory.getStatistic(resource,_graph.getNamedGraphUri(),_dataset);
		_dataset.add(_resource, statisticProperty,statistic.resource(),_graph.getNamedGraphUri());
		return statistic;
	}
	
	/**
	 * Remove object
	 * @param statistic object to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeStatistic(org.openanzo.ontologies.system.Statistic statistic) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, statisticProperty, statistic.resource(),_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, statisticProperty, statistic.resource(),_graph.getNamedGraphUri());
	}

	/**
	 * Remove resource
	 * @param resource resource to remove
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeStatistic(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException {
		if (!_dataset.contains(_resource, statisticProperty, resource,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, statisticProperty, resource,_graph.getNamedGraphUri());
	}
  


	protected java.util.concurrent.CopyOnWriteArraySet<StatisticsProviderListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<StatisticsProviderListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof StatisticsProviderListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	StatisticsProviderListener list = (StatisticsProviderListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof StatisticsProviderListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		StatisticsProviderListener list = (StatisticsProviderListener)listener;
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
			if (statement.getPredicate().equals(titleProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(StatisticsProviderListener listener : listeners){
					listener.titleChanged(org.openanzo.ontologies.system.StatisticsProviderImpl.this);
				}			
			}
			if (statement.getPredicate().equals(descriptionProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(StatisticsProviderListener listener : listeners){
					listener.descriptionChanged(org.openanzo.ontologies.system.StatisticsProviderImpl.this);
				}			
			}
			if (statement.getPredicate().equals(statisticsEnabledProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(StatisticsProviderListener listener : listeners){
					listener.statisticsEnabledChanged(org.openanzo.ontologies.system.StatisticsProviderImpl.this);
				}			
			}
			if (statement.getPredicate().equals(statisticProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.system.Statistic _statistic = org.openanzo.ontologies.system.SystemFactory.getStatistic(resource,_graph.getNamedGraphUri(),dataset());
				if (_statistic != null) {
					for(StatisticsProviderListener listener : listeners){
						listener.statisticAdded(org.openanzo.ontologies.system.StatisticsProviderImpl.this,_statistic);
					}
				}			
			}
		}}
		}
		
		public void statementsRemoved(org.openanzo.rdf.IDataset dataset, org.openanzo.rdf.Statement...statements) {
		for(org.openanzo.rdf.Statement statement:statements){
			if (statement.getSubject().equals(resource())){
			if (statement.getPredicate().equals(titleProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(StatisticsProviderListener listener : listeners) {
					listener.titleChanged(org.openanzo.ontologies.system.StatisticsProviderImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(descriptionProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(StatisticsProviderListener listener : listeners) {
					listener.descriptionChanged(org.openanzo.ontologies.system.StatisticsProviderImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(statisticsEnabledProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(StatisticsProviderListener listener : listeners) {
					listener.statisticsEnabledChanged(org.openanzo.ontologies.system.StatisticsProviderImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(statisticProperty)) {
				if (!(statement.getObject() instanceof org.openanzo.rdf.Resource))
					return;
				org.openanzo.rdf.Resource resource = (org.openanzo.rdf.Resource)statement.getObject();
				org.openanzo.ontologies.system.Statistic _statistic = org.openanzo.ontologies.system.SystemFactory.getStatistic(resource,_graph.getNamedGraphUri(),dataset());
				if (_statistic != null) {
					for(StatisticsProviderListener listener : listeners){
						listener.statisticRemoved(org.openanzo.ontologies.system.StatisticsProviderImpl.this,_statistic);
					}
				}
				return;
			}
		}
		}}
	}
	


}