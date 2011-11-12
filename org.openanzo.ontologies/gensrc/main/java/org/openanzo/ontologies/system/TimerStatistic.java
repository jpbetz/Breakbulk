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
 * Interface for TimerStatistic ontology class<br>
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#TimerStatistic)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : TimerStatistic <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface TimerStatistic extends 
org.openanzo.ontologies.system.Statistic, org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#TimerStatistic");
	

	/**
	 * The Anzo Property for statisticAverageExcludingMinMax 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#statisticAverageExcludingMinMax)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI statisticAverageExcludingMinMaxProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticAverageExcludingMinMax");


	/**
	 * The Anzo Property for statisticAveragePerSecond 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#statisticAveragePerSecond)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI statisticAveragePerSecondProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticAveragePerSecond");


	/**
	 * The Anzo Property for statisticAveragePerSecondExcludingMinMax 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#statisticAveragePerSecondExcludingMinMax)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI statisticAveragePerSecondExcludingMinMaxProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticAveragePerSecondExcludingMinMax");


	/**
	 * The Anzo Property for statisticAverageTime 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#statisticAverageTime)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI statisticAverageTimeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticAverageTime");


	/**
	 * The Anzo Property for statisticMaxTime 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#statisticMaxTime)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI statisticMaxTimeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticMaxTime");


	/**
	 * The Anzo Property for statisticMinTime 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#statisticMinTime)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI statisticMinTimeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticMinTime");


	/**
	 * The Anzo Property for statisticTotalTime 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#statisticTotalTime)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI statisticTotalTimeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#statisticTotalTime");




/**
	 * Clears all values for 'title'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#titleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearTitle(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'description'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#descriptionProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDescription(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'statisticsEnabled'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#statisticsEnabledProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearStatisticsEnabled(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'statisticCount'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#statisticCountProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearStatisticCount(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'statisticLastSampleTime'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#statisticLastSampleTimeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearStatisticLastSampleTime(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'statisticStartTime'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#statisticStartTimeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearStatisticStartTime(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'statisticUnit'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#statisticUnitProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearStatisticUnit(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'statisticAverageExcludingMinMax' property value from the given graph
	 * @return		{@link java.lang.Double}
	 * @see			#statisticAverageExcludingMinMaxProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Double getStatisticAverageExcludingMinMax() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'statisticAverageExcludingMinMax' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Double}
	 * @see			#statisticAverageExcludingMinMaxProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Double getStatisticAverageExcludingMinMax(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'statisticAverageExcludingMinMax' property value
	 * @param	statisticAverageExcludingMinMax	{@link java.lang.Double}, the value to set
	 * @see			#statisticAverageExcludingMinMaxProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setStatisticAverageExcludingMinMax(java.lang.Double statisticAverageExcludingMinMax) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'statisticAverageExcludingMinMax'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#statisticAverageExcludingMinMaxProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearStatisticAverageExcludingMinMax(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'statisticAveragePerSecond' property value from the given graph
	 * @return		{@link java.lang.Double}
	 * @see			#statisticAveragePerSecondProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Double getStatisticAveragePerSecond() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'statisticAveragePerSecond' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Double}
	 * @see			#statisticAveragePerSecondProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Double getStatisticAveragePerSecond(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'statisticAveragePerSecond' property value
	 * @param	statisticAveragePerSecond	{@link java.lang.Double}, the value to set
	 * @see			#statisticAveragePerSecondProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setStatisticAveragePerSecond(java.lang.Double statisticAveragePerSecond) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'statisticAveragePerSecond'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#statisticAveragePerSecondProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearStatisticAveragePerSecond(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'statisticAveragePerSecondExcludingMinMax' property value from the given graph
	 * @return		{@link java.lang.Double}
	 * @see			#statisticAveragePerSecondExcludingMinMaxProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Double getStatisticAveragePerSecondExcludingMinMax() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'statisticAveragePerSecondExcludingMinMax' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Double}
	 * @see			#statisticAveragePerSecondExcludingMinMaxProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Double getStatisticAveragePerSecondExcludingMinMax(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'statisticAveragePerSecondExcludingMinMax' property value
	 * @param	statisticAveragePerSecondExcludingMinMax	{@link java.lang.Double}, the value to set
	 * @see			#statisticAveragePerSecondExcludingMinMaxProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setStatisticAveragePerSecondExcludingMinMax(java.lang.Double statisticAveragePerSecondExcludingMinMax) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'statisticAveragePerSecondExcludingMinMax'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#statisticAveragePerSecondExcludingMinMaxProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearStatisticAveragePerSecondExcludingMinMax(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'statisticAverageTime' property value from the given graph
	 * @return		{@link java.lang.Double}
	 * @see			#statisticAverageTimeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Double getStatisticAverageTime() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'statisticAverageTime' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Double}
	 * @see			#statisticAverageTimeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Double getStatisticAverageTime(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'statisticAverageTime' property value
	 * @param	statisticAverageTime	{@link java.lang.Double}, the value to set
	 * @see			#statisticAverageTimeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setStatisticAverageTime(java.lang.Double statisticAverageTime) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'statisticAverageTime'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#statisticAverageTimeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearStatisticAverageTime(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'statisticMaxTime' property value from the given graph
	 * @return		{@link java.lang.Long}
	 * @see			#statisticMaxTimeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Long getStatisticMaxTime() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'statisticMaxTime' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Long}
	 * @see			#statisticMaxTimeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Long getStatisticMaxTime(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'statisticMaxTime' property value
	 * @param	statisticMaxTime	{@link java.lang.Long}, the value to set
	 * @see			#statisticMaxTimeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setStatisticMaxTime(java.lang.Long statisticMaxTime) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'statisticMaxTime'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#statisticMaxTimeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearStatisticMaxTime(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'statisticMinTime' property value from the given graph
	 * @return		{@link java.lang.Long}
	 * @see			#statisticMinTimeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Long getStatisticMinTime() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'statisticMinTime' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Long}
	 * @see			#statisticMinTimeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Long getStatisticMinTime(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'statisticMinTime' property value
	 * @param	statisticMinTime	{@link java.lang.Long}, the value to set
	 * @see			#statisticMinTimeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setStatisticMinTime(java.lang.Long statisticMinTime) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'statisticMinTime'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#statisticMinTimeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearStatisticMinTime(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'statisticTotalTime' property value from the given graph
	 * @return		{@link java.lang.Long}
	 * @see			#statisticTotalTimeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Long getStatisticTotalTime() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'statisticTotalTime' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Long}
	 * @see			#statisticTotalTimeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Long getStatisticTotalTime(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'statisticTotalTime' property value
	 * @param	statisticTotalTime	{@link java.lang.Long}, the value to set
	 * @see			#statisticTotalTimeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setStatisticTotalTime(java.lang.Long statisticTotalTime) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'statisticTotalTime'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#statisticTotalTimeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearStatisticTotalTime(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}