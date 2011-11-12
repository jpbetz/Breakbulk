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
 * Implementation of {@link org.openanzo.ontologies.system.TimerStatistic}
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this class.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#TimerStatistic)</p>
 * <br>
 */
public class TimerStatisticImpl extends org.openanzo.rdf.jastor.ThingImpl implements org.openanzo.ontologies.system.TimerStatistic {
	private ThingStatementListener _listener = null;

	protected static final org.openanzo.rdf.URI titleProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://purl.org/dc/elements/1.1/title");
	protected static final org.openanzo.rdf.URI descriptionProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://purl.org/dc/elements/1.1/description");
	protected static final org.openanzo.rdf.URI statisticsEnabledProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticsEnabled");
	protected static final org.openanzo.rdf.URI statisticCountProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticCount");
	protected static final org.openanzo.rdf.URI statisticLastSampleTimeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticLastSampleTime");
	protected static final org.openanzo.rdf.URI statisticStartTimeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticStartTime");
	protected static final org.openanzo.rdf.URI statisticUnitProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticUnit");
	protected static final org.openanzo.rdf.URI statisticAverageExcludingMinMaxProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticAverageExcludingMinMax");
	protected static final org.openanzo.rdf.URI statisticAveragePerSecondProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticAveragePerSecond");
	protected static final org.openanzo.rdf.URI statisticAveragePerSecondExcludingMinMaxProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticAveragePerSecondExcludingMinMax");
	protected static final org.openanzo.rdf.URI statisticAverageTimeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticAverageTime");
	protected static final org.openanzo.rdf.URI statisticMaxTimeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticMaxTime");
	protected static final org.openanzo.rdf.URI statisticMinTimeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticMinTime");
	protected static final org.openanzo.rdf.URI statisticTotalTimeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticTotalTime");

	TimerStatisticImpl(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		super(resource, namedGraphUri, dataset);
		_listener = new ThingStatementListener();
	}   
	   
    	
	static TimerStatisticImpl getTimerStatistic(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException {
		if(namedGraphUri==null||!dataset.containsNamedGraph(namedGraphUri) ){
			namedGraphUri=null;
			for(org.openanzo.rdf.Statement stmt:dataset.find(resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, TimerStatistic.TYPE)){
				namedGraphUri=stmt.getNamedGraphUri();
			}
			if(namedGraphUri==null)return null;
		}
		return new TimerStatisticImpl(resource, namedGraphUri, dataset);
	}
	    
	static TimerStatisticImpl createTimerStatistic(org.openanzo.rdf.Resource resource,org.openanzo.rdf.URI namedGraphUri, org.openanzo.rdf.IDataset dataset) throws org.openanzo.rdf.jastor.JastorException { 
		
		TimerStatisticImpl impl = new TimerStatisticImpl(resource, namedGraphUri,dataset);
		if (!impl._dataset.contains(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, TimerStatistic.TYPE, namedGraphUri))
			impl._dataset.add(impl._resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, TimerStatistic.TYPE, namedGraphUri);
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
		
		list.addAll(_dataset.find(_resource, statisticAverageExcludingMinMaxProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, statisticAveragePerSecondProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, statisticAveragePerSecondExcludingMinMaxProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, statisticAverageTimeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, statisticMaxTimeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, statisticMinTimeProperty, null, _graph.getNamedGraphUri()));
		
		list.addAll(_dataset.find(_resource, statisticTotalTimeProperty, null, _graph.getNamedGraphUri()));
		
		
		list.addAll(_dataset.find(_resource,  org.openanzo.rdf.vocabulary.RDF.TYPE, org.openanzo.ontologies.system.TimerStatistic.TYPE, _graph.getNamedGraphUri()));
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": title getProperty() in org.openanzo.ontologies.system.TimerStatistic model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal title in TimerStatistic is not of type java.lang.String", literal);
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": description getProperty() in org.openanzo.ontologies.system.TimerStatistic model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal description in TimerStatistic is not of type java.lang.String", literal);
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": statisticsEnabled getProperty() in org.openanzo.ontologies.system.TimerStatistic model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#boolean");
		if (!(obj instanceof java.lang.Boolean))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal statisticsEnabled in TimerStatistic is not of type java.lang.Boolean", literal);
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
					throw new org.openanzo.rdf.jastor.InvalidNodeException (uri() + ": One of the http://openanzo.org/ontologies/2008/07/System#statisticCount properties in TimerStatistic model not a Literal",value);
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": statisticLastSampleTime getProperty() in org.openanzo.ontologies.system.TimerStatistic model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#long");
		if (!(obj instanceof java.lang.Long))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal statisticLastSampleTime in TimerStatistic is not of type java.lang.Long", literal);
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": statisticStartTime getProperty() in org.openanzo.ontologies.system.TimerStatistic model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#long");
		if (!(obj instanceof java.lang.Long))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal statisticStartTime in TimerStatistic is not of type java.lang.Long", literal);
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
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": statisticUnit getProperty() in org.openanzo.ontologies.system.TimerStatistic model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#string");
		if (!(obj instanceof java.lang.String))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal statisticUnit in TimerStatistic is not of type java.lang.String", literal);
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
	 * Clears all values for 'statisticAverageExcludingMinMax'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearStatisticAverageExcludingMinMax(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, statisticAverageExcludingMinMaxProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#statisticAverageExcludingMinMax
	public java.lang.Double getStatisticAverageExcludingMinMax(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, statisticAverageExcludingMinMaxProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": statisticAverageExcludingMinMax getProperty() in org.openanzo.ontologies.system.TimerStatistic model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#double");
		if (!(obj instanceof java.lang.Double))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal statisticAverageExcludingMinMax in TimerStatistic is not of type java.lang.Double", literal);
		return (java.lang.Double)obj;
		
	}
	
	public java.lang.Double getStatisticAverageExcludingMinMax() throws org.openanzo.rdf.jastor.JastorException {
		return getStatisticAverageExcludingMinMax(false);
	}
	
	public void setStatisticAverageExcludingMinMax(java.lang.Double statisticAverageExcludingMinMax) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, statisticAverageExcludingMinMaxProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (statisticAverageExcludingMinMax != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(statisticAverageExcludingMinMax,"http://www.w3.org/2001/XMLSchema#double");
			_dataset.add(_resource, statisticAverageExcludingMinMaxProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'statisticAveragePerSecond'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearStatisticAveragePerSecond(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, statisticAveragePerSecondProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#statisticAveragePerSecond
	public java.lang.Double getStatisticAveragePerSecond(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, statisticAveragePerSecondProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": statisticAveragePerSecond getProperty() in org.openanzo.ontologies.system.TimerStatistic model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#double");
		if (!(obj instanceof java.lang.Double))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal statisticAveragePerSecond in TimerStatistic is not of type java.lang.Double", literal);
		return (java.lang.Double)obj;
		
	}
	
	public java.lang.Double getStatisticAveragePerSecond() throws org.openanzo.rdf.jastor.JastorException {
		return getStatisticAveragePerSecond(false);
	}
	
	public void setStatisticAveragePerSecond(java.lang.Double statisticAveragePerSecond) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, statisticAveragePerSecondProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (statisticAveragePerSecond != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(statisticAveragePerSecond,"http://www.w3.org/2001/XMLSchema#double");
			_dataset.add(_resource, statisticAveragePerSecondProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'statisticAveragePerSecondExcludingMinMax'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearStatisticAveragePerSecondExcludingMinMax(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, statisticAveragePerSecondExcludingMinMaxProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#statisticAveragePerSecondExcludingMinMax
	public java.lang.Double getStatisticAveragePerSecondExcludingMinMax(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, statisticAveragePerSecondExcludingMinMaxProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": statisticAveragePerSecondExcludingMinMax getProperty() in org.openanzo.ontologies.system.TimerStatistic model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#double");
		if (!(obj instanceof java.lang.Double))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal statisticAveragePerSecondExcludingMinMax in TimerStatistic is not of type java.lang.Double", literal);
		return (java.lang.Double)obj;
		
	}
	
	public java.lang.Double getStatisticAveragePerSecondExcludingMinMax() throws org.openanzo.rdf.jastor.JastorException {
		return getStatisticAveragePerSecondExcludingMinMax(false);
	}
	
	public void setStatisticAveragePerSecondExcludingMinMax(java.lang.Double statisticAveragePerSecondExcludingMinMax) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, statisticAveragePerSecondExcludingMinMaxProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (statisticAveragePerSecondExcludingMinMax != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(statisticAveragePerSecondExcludingMinMax,"http://www.w3.org/2001/XMLSchema#double");
			_dataset.add(_resource, statisticAveragePerSecondExcludingMinMaxProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'statisticAverageTime'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearStatisticAverageTime(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, statisticAverageTimeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#statisticAverageTime
	public java.lang.Double getStatisticAverageTime(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, statisticAverageTimeProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": statisticAverageTime getProperty() in org.openanzo.ontologies.system.TimerStatistic model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#double");
		if (!(obj instanceof java.lang.Double))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal statisticAverageTime in TimerStatistic is not of type java.lang.Double", literal);
		return (java.lang.Double)obj;
		
	}
	
	public java.lang.Double getStatisticAverageTime() throws org.openanzo.rdf.jastor.JastorException {
		return getStatisticAverageTime(false);
	}
	
	public void setStatisticAverageTime(java.lang.Double statisticAverageTime) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, statisticAverageTimeProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (statisticAverageTime != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(statisticAverageTime,"http://www.w3.org/2001/XMLSchema#double");
			_dataset.add(_resource, statisticAverageTimeProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'statisticMaxTime'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearStatisticMaxTime(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, statisticMaxTimeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#statisticMaxTime
	public java.lang.Long getStatisticMaxTime(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, statisticMaxTimeProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": statisticMaxTime getProperty() in org.openanzo.ontologies.system.TimerStatistic model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#long");
		if (!(obj instanceof java.lang.Long))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal statisticMaxTime in TimerStatistic is not of type java.lang.Long", literal);
		return (java.lang.Long)obj;
		
	}
	
	public java.lang.Long getStatisticMaxTime() throws org.openanzo.rdf.jastor.JastorException {
		return getStatisticMaxTime(false);
	}
	
	public void setStatisticMaxTime(java.lang.Long statisticMaxTime) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, statisticMaxTimeProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (statisticMaxTime != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(statisticMaxTime,"http://www.w3.org/2001/XMLSchema#long");
			_dataset.add(_resource, statisticMaxTimeProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'statisticMinTime'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearStatisticMinTime(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, statisticMinTimeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#statisticMinTime
	public java.lang.Long getStatisticMinTime(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, statisticMinTimeProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": statisticMinTime getProperty() in org.openanzo.ontologies.system.TimerStatistic model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#long");
		if (!(obj instanceof java.lang.Long))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal statisticMinTime in TimerStatistic is not of type java.lang.Long", literal);
		return (java.lang.Long)obj;
		
	}
	
	public java.lang.Long getStatisticMinTime() throws org.openanzo.rdf.jastor.JastorException {
		return getStatisticMinTime(false);
	}
	
	public void setStatisticMinTime(java.lang.Long statisticMinTime) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, statisticMinTimeProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (statisticMinTime != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(statisticMinTime,"http://www.w3.org/2001/XMLSchema#long");
			_dataset.add(_resource, statisticMinTimeProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}

	/**
	 * Clears all values for 'statisticTotalTime'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	 @SuppressWarnings("all")
	public void clearStatisticTotalTime(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException{
		_dataset.remove(_resource, statisticTotalTimeProperty, null,(includeEntireDataset)?null:_graph.getNamedGraphUri());
	}
// generating for property: http://openanzo.org/ontologies/2008/07/System#statisticTotalTime
	public java.lang.Long getStatisticTotalTime(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException {

		java.util.Collection<org.openanzo.rdf.Statement> __valIter =null;
		__valIter =_dataset.find(includeEntireDataset, _resource, statisticTotalTimeProperty, null,_graph.getNamedGraphUri());
		if(__valIter.isEmpty()) return null;
		org.openanzo.rdf.Statement statement = __valIter.iterator().next();
		if (statement == null) return null;		
		if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
			throw new org.openanzo.rdf.jastor.InvalidNodeException(uri() + ": statisticTotalTime getProperty() in org.openanzo.ontologies.system.TimerStatistic model not Literal", statement.getObject());
		org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
		Object obj = getLiteralValue(literal, "http://www.w3.org/2001/XMLSchema#long");
		if (!(obj instanceof java.lang.Long))
			throw new org.openanzo.rdf.jastor.InvalidLiteralException (this.uri() + ": Literal statisticTotalTime in TimerStatistic is not of type java.lang.Long", literal);
		return (java.lang.Long)obj;
		
	}
	
	public java.lang.Long getStatisticTotalTime() throws org.openanzo.rdf.jastor.JastorException {
		return getStatisticTotalTime(false);
	}
	
	public void setStatisticTotalTime(java.lang.Long statisticTotalTime) throws org.openanzo.rdf.jastor.JastorException {
		_dataset.remove(_resource, statisticTotalTimeProperty, null,_graph.getNamedGraphUri());                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
		if (statisticTotalTime != null) {
	
			org.openanzo.rdf.Literal _literal = getLiteral(statisticTotalTime,"http://www.w3.org/2001/XMLSchema#long");
			_dataset.add(_resource, statisticTotalTimeProperty, _literal,_graph.getNamedGraphUri());
	
		}	
	}
 


	protected java.util.concurrent.CopyOnWriteArraySet<TimerStatisticListener> listeners = new  java.util.concurrent.CopyOnWriteArraySet<TimerStatisticListener>();
	
	public void registerListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof TimerStatisticListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		if(listeners.size()==0){
    		_dataset.registerListener(_listener);
    	}
    	TimerStatisticListener list = (TimerStatisticListener)listener;
		if(!listeners.contains(list)){
			listeners.add(list);
		}
	}
	
	public void unregisterListener(org.openanzo.rdf.jastor.ThingListener listener) {
		if (!(listener instanceof TimerStatisticListener)) {
			throw new org.openanzo.rdf.jastor.JastorException("Listener class not of proper type");
		}
		TimerStatisticListener list = (TimerStatisticListener)listener;
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
				for(TimerStatisticListener listener : listeners){
					listener.titleChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}			
			}
			if (statement.getPredicate().equals(descriptionProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners){
					listener.descriptionChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}			
			}
			if (statement.getPredicate().equals(statisticsEnabledProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners){
					listener.statisticsEnabledChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}			
			}
			if (statement.getPredicate().equals(statisticCountProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		

				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();

				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.Long) {
					for(TimerStatisticListener listener : listeners){
						listener.statisticCountAdded(org.openanzo.ontologies.system.TimerStatisticImpl.this,(java.lang.Long)obj);
					}
				}			
			}
			if (statement.getPredicate().equals(statisticLastSampleTimeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners){
					listener.statisticLastSampleTimeChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}			
			}
			if (statement.getPredicate().equals(statisticStartTimeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners){
					listener.statisticStartTimeChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}			
			}
			if (statement.getPredicate().equals(statisticUnitProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners){
					listener.statisticUnitChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}			
			}
			if (statement.getPredicate().equals(statisticAverageExcludingMinMaxProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners){
					listener.statisticAverageExcludingMinMaxChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}			
			}
			if (statement.getPredicate().equals(statisticAveragePerSecondProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners){
					listener.statisticAveragePerSecondChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}			
			}
			if (statement.getPredicate().equals(statisticAveragePerSecondExcludingMinMaxProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners){
					listener.statisticAveragePerSecondExcludingMinMaxChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}			
			}
			if (statement.getPredicate().equals(statisticAverageTimeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners){
					listener.statisticAverageTimeChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}			
			}
			if (statement.getPredicate().equals(statisticMaxTimeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners){
					listener.statisticMaxTimeChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}			
			}
			if (statement.getPredicate().equals(statisticMinTimeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners){
					listener.statisticMinTimeChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}			
			}
			if (statement.getPredicate().equals(statisticTotalTimeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners){
					listener.statisticTotalTimeChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
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
				for(TimerStatisticListener listener : listeners) {
					listener.titleChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(descriptionProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners) {
					listener.descriptionChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(statisticsEnabledProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners) {
					listener.statisticsEnabledChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(statisticCountProperty)) {	
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;
				org.openanzo.rdf.Literal literal=(org.openanzo.rdf.Literal)statement.getObject();
				Object obj = org.openanzo.rdf.utils.StatementUtils.getNativeValue(literal);
				if (obj instanceof java.lang.Long) {
					for(TimerStatisticListener listener : listeners){
						listener.statisticCountRemoved(org.openanzo.ontologies.system.TimerStatisticImpl.this,(java.lang.Long)obj);
					}
				}
				return;
			}
			if (statement.getPredicate().equals(statisticLastSampleTimeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners) {
					listener.statisticLastSampleTimeChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(statisticStartTimeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners) {
					listener.statisticStartTimeChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(statisticUnitProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners) {
					listener.statisticUnitChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(statisticAverageExcludingMinMaxProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners) {
					listener.statisticAverageExcludingMinMaxChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(statisticAveragePerSecondProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners) {
					listener.statisticAveragePerSecondChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(statisticAveragePerSecondExcludingMinMaxProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners) {
					listener.statisticAveragePerSecondExcludingMinMaxChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(statisticAverageTimeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners) {
					listener.statisticAverageTimeChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(statisticMaxTimeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners) {
					listener.statisticMaxTimeChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(statisticMinTimeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners) {
					listener.statisticMinTimeChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}
				return;
			}
			if (statement.getPredicate().equals(statisticTotalTimeProperty)) {				
				if (!(statement.getObject() instanceof org.openanzo.rdf.Literal))
					return;		
				for(TimerStatisticListener listener : listeners) {
					listener.statisticTotalTimeChanged(org.openanzo.ontologies.system.TimerStatisticImpl.this);
				}
				return;
			}
		}
		}}
	}
	


}