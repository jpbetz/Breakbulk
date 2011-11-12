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
 * Interface for SemanticService ontology class<br>
 * Use the org.openanzo.ontologies.execution.SemanticServiceFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/SemanticService#SemanticService)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Semantic Service <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface SemanticService extends org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/SemanticService#SemanticService");
	

	/**
	 * The Anzo Property for serviceUser 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/SemanticService#serviceUser)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : The username under which the service operates on the repository <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI serviceUserProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/SemanticService#serviceUser");


	/**
	 * The Anzo Property for operation 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/SemanticService#operation)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : operations of the service <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI operationProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/SemanticService#operation");


	/**
	 * The Anzo Property for stateStyle 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/SemanticService#stateStyle)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Indicates the state requirements of a service.
							StatelessStyle - no state requirements
							ConnectionStyle - requests require on-off connection the repository
											  to perform transactions
							LongRunningStyle - The service makes use of long-running instances of AnzoClient, answers
							                   requests using the in-memory replica, reacts to events, etc... <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI stateStyleProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/SemanticService#stateStyle");




	/**
	 * Gets the 'serviceUser' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#serviceUserProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getServiceUser() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'serviceUser' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#serviceUserProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getServiceUser(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'serviceUser' property value
	 * @param	serviceUser	{@link java.lang.String}, the value to set
	 * @see			#serviceUserProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setServiceUser(java.lang.String serviceUser) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'serviceUser'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#serviceUserProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearServiceUser(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'operation' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.execution.SemanticOperation}
	 * @see			#operationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.execution.SemanticOperation> getOperation() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'operation' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.execution.SemanticOperation}
	 * @see			#operationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.execution.SemanticOperation> getOperation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'operation' property
	 * @param	operation	The {@link org.openanzo.ontologies.execution.SemanticOperation} to add
	 * @see			#operationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addOperation(org.openanzo.ontologies.execution.SemanticOperation operation) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'operation' property
	 * @return		The anoymous {@link org.openanzo.ontologies.execution.SemanticOperation} created
	 * @see			#operationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.execution.SemanticOperation addOperation() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'operation' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.execution.SemanticOperation} with the factory
	 * and calling addOperation(org.openanzo.ontologies.execution.SemanticOperation operation)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/SemanticService#SemanticOperation.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.ontologies.execution.SemanticOperation, value added
	 * @see			#operationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.execution.SemanticOperation addOperation(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'operation' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	operation	The {@link org.openanzo.ontologies.execution.SemanticOperation} to remove
	 * @see			#operationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeOperation(org.openanzo.ontologies.execution.SemanticOperation operation) throws org.openanzo.rdf.jastor.JastorException;

		
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
	 * Gets the 'stateStyle' property value
	 * @return		{@link org.openanzo.ontologies.execution.StateStyleEnum}
	 * @see			#stateStyleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.execution.StateStyleEnum getStateStyle() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'stateStyle' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.ontologies.execution.StateStyleEnum}
	 * @see			#stateStyleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.execution.StateStyleEnum getStateStyle(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'stateStyle' property value
	 * @param	stateStyle	{@link org.openanzo.ontologies.execution.StateStyleEnum}, value to set
	 * @see			#stateStyleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setStateStyle(org.openanzo.ontologies.execution.StateStyleEnum stateStyle) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'stateStyle' property value to an anonymous node
	 * @return		{@link org.openanzo.ontologies.execution.StateStyleEnum}, the created value
	 * @see			#stateStyleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.ontologies.execution.StateStyleEnum setStateStyle() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'stateStyle' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.execution.StateStyleEnum} with the factory.
	 * and calling setStateStyle(org.openanzo.ontologies.execution.StateStyleEnum stateStyle)
	 * The resource argument have rdf:type http://jastor.openanzo.org/gen#StateStyleEnum.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.ontologies.execution.StateStyleEnum}, the newly created value
	 * @see			#stateStyleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.execution.StateStyleEnum setStateStyle(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'stateStyle'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#stateStyleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearStateStyle(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}