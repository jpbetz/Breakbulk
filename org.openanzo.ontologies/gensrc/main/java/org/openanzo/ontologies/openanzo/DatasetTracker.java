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
 * Interface for DatasetTracker ontology class<br>
 * Use the org.openanzo.ontologies.openanzo.AnzoFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/Anzo#DatasetTracker)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : A DatasetTracker <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface DatasetTracker extends 
org.openanzo.ontologies.openanzo.Dataset, 
org.openanzo.ontologies.openanzo.Tracker, org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#DatasetTracker");
	

	/**
	 * The Anzo Property for namedDataset 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/Anzo#namedDataset)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI namedDatasetProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#namedDataset");




/**
	 * Clears all values for 'includeMetadataGraphs'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#includeMetadataGraphsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearIncludeMetadataGraphs(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'defaultGraph' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	defaultGraph	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#defaultGraphProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDefaultGraph(org.openanzo.rdf.Resource defaultGraph) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'defaultGraph'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#defaultGraphProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDefaultGraph(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'defaultNamedGraph' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	defaultNamedGraph	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#defaultNamedGraphProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDefaultNamedGraph(org.openanzo.rdf.Resource defaultNamedGraph) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'defaultNamedGraph'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#defaultNamedGraphProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDefaultNamedGraph(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'namedGraph' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	namedGraph	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#namedGraphProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeNamedGraph(org.openanzo.rdf.Resource namedGraph) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'namedGraph'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#namedGraphProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearNamedGraph(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'namedDataset' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.openanzo.NamedGraph}
	 * @see			#namedDatasetProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.NamedGraph> getNamedDataset() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'namedDataset' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.openanzo.NamedGraph}
	 * @see			#namedDatasetProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.NamedGraph> getNamedDataset(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'namedDataset' property
	 * @param	namedDataset	The {@link org.openanzo.ontologies.openanzo.NamedGraph} to add
	 * @see			#namedDatasetProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addNamedDataset(org.openanzo.ontologies.openanzo.NamedGraph namedDataset) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'namedDataset' property
	 * @return		The anoymous {@link org.openanzo.ontologies.openanzo.NamedGraph} created
	 * @see			#namedDatasetProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.openanzo.NamedGraph addNamedDataset() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'namedDataset' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.openanzo.NamedGraph} with the factory
	 * and calling addNamedDataset(org.openanzo.ontologies.openanzo.NamedGraph namedDataset)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/Anzo#NamedGraph.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.ontologies.openanzo.NamedGraph, value added
	 * @see			#namedDatasetProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.openanzo.NamedGraph addNamedDataset(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'namedDataset' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	namedDataset	The {@link org.openanzo.ontologies.openanzo.NamedGraph} to remove
	 * @see			#namedDatasetProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeNamedDataset(org.openanzo.ontologies.openanzo.NamedGraph namedDataset) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'namedDataset' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	namedDataset	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#namedDatasetProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeNamedDataset(org.openanzo.rdf.Resource namedDataset) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'namedDataset'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#namedDatasetProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearNamedDataset(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}