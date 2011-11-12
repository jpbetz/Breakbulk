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
 * Interface for StatisticsProvider ontology class<br>
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#StatisticsProvider)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : StatisticsProvider <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface StatisticsProvider extends org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#StatisticsProvider");
	

	/**
	 * The Anzo Property for title 
	 * <p>(URI: http://purl.org/dc/elements/1.1/title)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI titleProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://purl.org/dc/elements/1.1/title");


	/**
	 * The Anzo Property for description 
	 * <p>(URI: http://purl.org/dc/elements/1.1/description)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI descriptionProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://purl.org/dc/elements/1.1/description");


	/**
	 * The Anzo Property for statisticsEnabled 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#statisticsEnabled)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI statisticsEnabledProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticsEnabled");


	/**
	 * The Anzo Property for statistic 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#statistic)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI statisticProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statistic");




	/**
	 * Gets the 'title' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#titleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getTitle() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'title' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#titleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getTitle(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'title' property value
	 * @param	title	{@link java.lang.String}, the value to set
	 * @see			#titleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setTitle(java.lang.String title) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'title'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#titleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearTitle(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'description' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#descriptionProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getDescription() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'description' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#descriptionProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getDescription(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'description' property value
	 * @param	description	{@link java.lang.String}, the value to set
	 * @see			#descriptionProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setDescription(java.lang.String description) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'description'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#descriptionProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDescription(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'statisticsEnabled' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#statisticsEnabledProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getStatisticsEnabled() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'statisticsEnabled' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#statisticsEnabledProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getStatisticsEnabled(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'statisticsEnabled' property value
	 * @param	statisticsEnabled	{@link java.lang.Boolean}, the value to set
	 * @see			#statisticsEnabledProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setStatisticsEnabled(java.lang.Boolean statisticsEnabled) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'statisticsEnabled'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#statisticsEnabledProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearStatisticsEnabled(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'statistic' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.system.Statistic}
	 * @see			#statisticProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Statistic> getStatistic() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'statistic' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.system.Statistic}
	 * @see			#statisticProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Statistic> getStatistic(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'statistic' property
	 * @param	statistic	The {@link org.openanzo.ontologies.system.Statistic} to add
	 * @see			#statisticProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addStatistic(org.openanzo.ontologies.system.Statistic statistic) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'statistic' property
	 * @return		The anoymous {@link org.openanzo.ontologies.system.Statistic} created
	 * @see			#statisticProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Statistic addStatistic() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'statistic' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.system.Statistic} with the factory
	 * and calling addStatistic(org.openanzo.ontologies.system.Statistic statistic)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/System#Statistic.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.ontologies.system.Statistic, value added
	 * @see			#statisticProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Statistic addStatistic(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'statistic' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	statistic	The {@link org.openanzo.ontologies.system.Statistic} to remove
	 * @see			#statisticProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeStatistic(org.openanzo.ontologies.system.Statistic statistic) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'statistic' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	statistic	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#statisticProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeStatistic(org.openanzo.rdf.Resource statistic) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'statistic'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#statisticProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearStatistic(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}