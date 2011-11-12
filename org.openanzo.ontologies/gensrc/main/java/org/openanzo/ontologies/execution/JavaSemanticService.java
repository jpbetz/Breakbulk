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
package org.openanzo.ontologies.execution;

/**
 * Interface for JavaSemanticService ontology class<br>
 * Use the org.openanzo.ontologies.execution.SemanticServiceFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/SemanticService#JavaSemanticService)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Java Semantic Service <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface JavaSemanticService extends 
org.openanzo.ontologies.execution.SemanticService, org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/SemanticService#JavaSemanticService");
	

	/**
	 * The Anzo Property for serviceFactoryPid 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/SemanticService#serviceFactoryPid)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : The PID of bundle containing the factory for the service <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI serviceFactoryPidProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/SemanticService#serviceFactoryPid");




/**
	 * Clears all values for 'serviceUser'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#serviceUserProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearServiceUser(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'operation' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	operation	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#operationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeOperation(org.openanzo.rdf.Resource operation) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'operation'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#operationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearOperation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'stateStyle'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#stateStyleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearStateStyle(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'serviceFactoryPid' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#serviceFactoryPidProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getServiceFactoryPid() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'serviceFactoryPid' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#serviceFactoryPidProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getServiceFactoryPid(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'serviceFactoryPid' property value
	 * @param	serviceFactoryPid	{@link java.lang.String}, the value to set
	 * @see			#serviceFactoryPidProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setServiceFactoryPid(java.lang.String serviceFactoryPid) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'serviceFactoryPid'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#serviceFactoryPidProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearServiceFactoryPid(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}