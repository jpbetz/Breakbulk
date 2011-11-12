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
 * Implementation of {@link org.openanzo.ontologies.system.CountStatistic}
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#CountStatistic)</p>
 * <br>
 */
public class CountStatisticImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.system.CountStatistic {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI titleProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://purl.org/dc/elements/1.1/title");
	protected static final org.openanzo.rdf.URI descriptionProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://purl.org/dc/elements/1.1/description");
	protected static final org.openanzo.rdf.URI statisticsEnabledProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticsEnabled");
	protected static final org.openanzo.rdf.URI statisticCountProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticCount");
	protected static final org.openanzo.rdf.URI statisticLastSampleTimeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticLastSampleTime");
	protected static final org.openanzo.rdf.URI statisticStartTimeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticStartTime");
	protected static final org.openanzo.rdf.URI statisticUnitProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticUnit");
	protected static final org.openanzo.rdf.URI statisticFrequencyProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticFrequency");
	protected static final org.openanzo.rdf.URI statisticPeriodProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticPeriod");

	CountStatisticImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static CountStatisticImpl getCountStatistic(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, CountStatistic.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new CountStatisticImpl(resource, namedGraphUri, dataset);
	}
	    
	static CountStatisticImpl createCountStatistic(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		CountStatisticImpl impl = new CountStatisticImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, CountStatistic.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, CountStatistic.TYPE, namedGraphUri);
		impl.addSuperTypes();
		impl.addHasValueValues();
		return impl;
	}
	
	void addSuperTypes() {
		if (!_dataset.contains(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.Statistic.TYPE,_graph.getNamedGraphUri()))
			_dataset.add(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.Statistic.TYPE,_graph.getNamedGraphUri());     
	}
   
	void addHasValueValues() {
	}
   
	public java.util.Collection<org.openanzo.rdf.Statement> listStatements() {
		java.util.Collection<org.openanzo.rdf.Statement> list = new java.util.HashSet<org.openanzo.rdf.Statement>();
		
		list.addAll(_dataset.find(_resource, titleProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, descriptionProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, statisticsEnabledProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, statisticCountProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, statisticLastSampleTimeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, statisticStartTimeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, statisticUnitProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, statisticFrequencyProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, statisticPeriodProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.CountStatistic.TYPE, _graph.getNamedGraphUri()));
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.Statistic.TYPE, _graph.getNamedGraphUri()));
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": title getProperty() in org.openanzo.ontologies.system.CountStatistic model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal title in CountStatistic is not of type java.lang.String", literal);
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": description getProperty() in org.openanzo.ontologies.system.CountStatistic model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal description in CountStatistic is not of type java.lang.String", literal);
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": statisticsEnabled getProperty() in org.openanzo.ontologies.system.CountStatistic model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal statisticsEnabled in CountStatistic is not of type java.lang.Boolean", literal);
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
	 * Clears all values for 'statisticCount'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearStatisticCount(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, statisticCountProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#statisticCount


	org.openanzo.rdf.jastor.PropertyCollection<java.lang.Long> propertyCollectionStatisticCount = new org.openanzo.rdf.jastor.PropertyCollection<java.lang.Long>() {
		public java.lang.Long getPropertyValue(org.openanzo.rdf.Value value) {
		
				if(value instanceof org.openanzo.rdf.Literal){
					org.openanzo.rdf.Literal literal = (org.openanzo.rdf.Literal)value;
	
						return getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#long");
				}else{
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://openanzo.org/ontologies/2008/07/System#statisticCount properties in CountStatistic model not a Literal",value);
				}
			}
	};

	public java.util.Collection<java.lang.Long> getStatisticCount(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {
		return propertyCollectionStatisticCount.getPropertyCollection(_dataset, _graph, _resource,statisticCountProperty, org.openanzo.rdf.MemURI.create("http://www.w3.org/2001/XMLSchema#long"), includeEntireDataset);
	}
	
	public java.util.Collection<java.lang.Long> getStatisticCount() throws org.openanzo.rdf.jastor.JastorException {
		return getStatisticCount(false);
	}

	public void addStatisticCount(java.lang.Long statisticCount) throws org.openanzo.rdf.jastor.JastorException {
	
		org.openanzo.rdf.Literal _literal = getLiteral(statisticCount,"http://www.w3.org/2001/XMLSchema#long");
		//if (_dataset.contains(_resource, statisticCountProperty,_literal,_graph.getNamedGraphUri()))
		//	return;
	
		if (statisticCount != null) {
			_dataset.add(_resource, statisticCountProperty,_literal,_graph.getNamedGraphUri());
		}
	
	}
	
	public void removeStatisticCount(java.lang.Long statisticCount) throws org.openanzo.rdf.jastor.JastorException {
		
		org.openanzo.rdf.Literal _literal = getLiteral(statisticCount,"http://www.w3.org/2001/XMLSchema#long");
		if (!_dataset.contains(_resource, statisticCountProperty, _literal,_graph.getNamedGraphUri()))
			return;
		_dataset.remove(_resource, statisticCountProperty, _literal,_graph.getNamedGraphUri());
		
	}

	/**
	 * Clears all values for 'statisticLastSampleTime'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearStatisticLastSampleTime(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, statisticLastSampleTimeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#statisticLastSampleTime
	public java.lang.Long getStatisticLastSampleTime(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, statisticLastSampleTimeProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": statisticLastSampleTime getProperty() in org.openanzo.ontologies.system.CountStatistic model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#long");
		if (!(obj instanceof java.lang.Long))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal statisticLastSampleTime in CountStatistic is not of type java.lang.Long", literal);
		return (java.lang.Long)obj;
		
	}
	
	public java.lang.Long getStatisticLastSampleTime() throws org.openanzo.rdf.jastor.JastorException {
		return getStatisticLastSampleTime(false);
	}
	
	public void setStatisticLastSampleTime(java.lang.Long statisticLastSampleTime) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, statisticLastSampleTimeProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (statisticLastSampleTime != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(statisticLastSampleTime,"http://www.w3.org/2001/XMLSchema#long");
			_dataset.add(_resource, statisticLastSampleTimeProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'statisticStartTime'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearStatisticStartTime(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, statisticStartTimeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#statisticStartTime
	public java.lang.Long getStatisticStartTime(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, statisticStartTimeProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": statisticStartTime getProperty() in org.openanzo.ontologies.system.CountStatistic model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#long");
		if (!(obj instanceof java.lang.Long))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal statisticStartTime in CountStatistic is not of type java.lang.Long", literal);
		return (java.lang.Long)obj;
		
	}
	
	public java.lang.Long getStatisticStartTime() throws org.openanzo.rdf.jastor.JastorException {
		return getStatisticStartTime(false);
	}
	
	public void setStatisticStartTime(java.lang.Long statisticStartTime) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, statisticStartTimeProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (statisticStartTime != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(statisticStartTime,"http://www.w3.org/2001/XMLSchema#long");
			_dataset.add(_resource, statisticStartTimeProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'statisticUnit'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearStatisticUnit(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, statisticUnitProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#statisticUnit
	public java.lang.String getStatisticUnit(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, statisticUnitProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": statisticUnit getProperty() in org.openanzo.ontologies.system.CountStatistic model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal statisticUnit in CountStatistic is not of type java.lang.String", literal);
		return (java.lang.String)obj;
		
	}
	
	public java.lang.String getStatisticUnit() throws org.openanzo.rdf.jastor.JastorException {
		return getStatisticUnit(false);
	}
	
	public void setStatisticUnit(java.lang.String statisticUnit) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, statisticUnitProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (statisticUnit != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(statisticUnit,"http://www.w3.org/2001/XMLSchema#string");
			_dataset.add(_resource, statisticUnitProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'statisticFrequency'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearStatisticFrequency(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, statisticFrequencyProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#statisticFrequency
	public java.lang.Double getStatisticFrequency(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, statisticFrequencyProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": statisticFrequency getProperty() in org.openanzo.ontologies.system.CountStatistic model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#double");
		if (!(obj instanceof java.lang.Double))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal statisticFrequency in CountStatistic is not of type java.lang.Double", literal);
		return (java.lang.Double)obj;
		
	}
	
	public java.lang.Double getStatisticFrequency() throws org.openanzo.rdf.jastor.JastorException {
		return getStatisticFrequency(false);
	}
	
	public void setStatisticFrequency(java.lang.Double statisticFrequency) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, statisticFrequencyProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (statisticFrequency != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(statisticFrequency,"http://www.w3.org/2001/XMLSchema#double");
			_dataset.add(_resource, statisticFrequencyProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'statisticPeriod'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearStatisticPeriod(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, statisticPeriodProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#statisticPeriod
	public java.lang.Double getStatisticPeriod(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, statisticPeriodProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": statisticPeriod getProperty() in org.openanzo.ontologies.system.CountStatistic model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#double");
		if (!(obj instanceof java.lang.Double))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal statisticPeriod in CountStatistic is not of type java.lang.Double", literal);
		return (java.lang.Double)obj;
		
	}
	
	public java.lang.Double getStatisticPeriod() throws org.openanzo.rdf.jastor.JastorException {
		return getStatisticPeriod(false);
	}
	
	public void setStatisticPeriod(java.lang.Double statisticPeriod) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, statisticPeriodProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (statisticPeriod != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(statisticPeriod,"http://www.w3.org/2001/XMLSchema#double");
			_dataset.add(_resource, statisticPeriodProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}
 


	protected java.util.concurrent.CopyOnWriteArraySet<CountStatisticListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<CountStatisticListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof CountStatisticListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	CountStatisticListener list = (CountStatisticListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof CountStatisticListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		CountStatisticListener list = (CountStatisticListener)listener;
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
				for(CountStatisticListener listener : listeners){
					listener.titleChanged(org.openanzo.ontologies.system.CountStatisticImpl.this);
				}			
			}
			if (statement.getPredicate().equals(descriptionProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(CountStatisticListener listener : listeners){
					listener.descriptionChanged(org.openanzo.ontologies.system.CountStatisticImpl.this);
				}			
			}
			if (statement.getPredicate().equals(statisticsEnabledProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(CountStatisticListener listener : listeners){
					listener.statisticsEnabledChanged(org.openanzo.ontologies.system.CountStatisticImpl.this);
				}			
			}
			if (statement.getPredicate().equals(statisticCountProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.Long) {
					for(CountStatisticListener listener : listeners){
						listener.statisticCountAdded(org.openanzo.ontologies.system.CountStatisticImpl.this,(java.lang.Long)obj);
					}
				}			
			}
			if (statement.getPredicate().equals(statisticLastSampleTimeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(CountStatisticListener listener : listeners){
					listener.statisticLastSampleTimeChanged(org.openanzo.ontologies.system.CountStatisticImpl.this);
				}			
			}
			if (statement.getPredicate().equals(statisticStartTimeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(CountStatisticListener listener : listeners){
					listener.statisticStartTimeChanged(org.openanzo.ontologies.system.CountStatisticImpl.this);
				}			
			}
			if (statement.getPredicate().equals(statisticUnitProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(CountStatisticListener listener : listeners){
					listener.statisticUnitChanged(org.openanzo.ontologies.system.CountStatisticImpl.this);
				}			
			}
			if (statement.getPredicate().equals(statisticFrequencyProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(CountStatisticListener listener : listeners){
					listener.statisticFrequencyChanged(org.openanzo.ontologies.system.CountStatisticImpl.this);
				}			
			}
			if (statement.getPredicate().equals(statisticPeriodProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(CountStatisticListener listener : listeners){
					listener.statisticPeriodChanged(org.openanzo.ontologies.system.CountStatisticImpl.this);
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
				for(CountStatisticListener listener : listeners) {
					listener.titleChanged(org.openanzo.ontologies.system.CountStatisticImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(descriptionProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(CountStatisticListener listener : listeners) {
					listener.descriptionChanged(org.openanzo.ontologies.system.CountStatisticImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(statisticsEnabledProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(CountStatisticListener listener : listeners) {
					listener.statisticsEnabledChanged(org.openanzo.ontologies.system.CountStatisticImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(statisticCountProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.Long) {
					for(CountStatisticListener listener : listeners){
						listener.statisticCountRemoved(org.openanzo.ontologies.system.CountStatisticImpl.this,(java.lang.Long)obj);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(statisticLastSampleTimeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(CountStatisticListener listener : listeners) {
					listener.statisticLastSampleTimeChanged(org.openanzo.ontologies.system.CountStatisticImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(statisticStartTimeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(CountStatisticListener listener : listeners) {
					listener.statisticStartTimeChanged(org.openanzo.ontologies.system.CountStatisticImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(statisticUnitProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(CountStatisticListener listener : listeners) {
					listener.statisticUnitChanged(org.openanzo.ontologies.system.CountStatisticImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(statisticFrequencyProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(CountStatisticListener listener : listeners) {
					listener.statisticFrequencyChanged(org.openanzo.ontologies.system.CountStatisticImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(statisticPeriodProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(CountStatisticListener listener : listeners) {
					listener.statisticPeriodChanged(org.openanzo.ontologies.system.CountStatisticImpl.this);
				}
				return;
			}
		}
		}}
	}
	


}