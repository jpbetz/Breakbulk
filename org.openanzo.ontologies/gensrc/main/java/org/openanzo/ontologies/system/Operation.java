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
 * Interface for Operation ontology class<br>
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#Operation)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Operation on a Service <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface Operation extends org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#Operation");
	

	/**
	 * The Anzo Property for name 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#name)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI nameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#name");


	/**
	 * The Anzo Property for bypassPool 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#bypassPool)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Bypass Listening Pool. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI bypassPoolProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#bypassPool");


	/**
	 * The Anzo Property for restEndpoint 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#restEndpoint)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Rest Endpoint. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI restEndpointProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#restEndpoint");


	/**
	 * The Anzo Property for restType 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#restType)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Rest Type. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI restTypeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#restType");


	/**
	 * The Anzo Property for sysadminRequired 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#sysadminRequired)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Does a user need to be sysadmin to run this operation. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI sysadminRequiredProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#sysadminRequired");


	/**
	 * The Anzo Property for wsOperation 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#wsOperation)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : WebSerivice call name. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI wsOperationProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#wsOperation");


	/**
	 * The Anzo Property for requestParameter 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#requestParameter)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Request Paremeter. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI requestParameterProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#requestParameter");


	/**
	 * The Anzo Property for requestParameter0 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#requestParameter0)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Request Paremeter 0. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI requestParameter0Property = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#requestParameter0");


	/**
	 * The Anzo Property for requestParameter1 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#requestParameter1)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Request Paremeter 1. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI requestParameter1Property = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#requestParameter1");


	/**
	 * The Anzo Property for requestParameter2 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#requestParameter2)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Request Paremeter 2. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI requestParameter2Property = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#requestParameter2");


	/**
	 * The Anzo Property for requestParameter3 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#requestParameter3)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Request Paremeter 3. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI requestParameter3Property = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#requestParameter3");


	/**
	 * The Anzo Property for requestParameter4 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#requestParameter4)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Request Paremeter 4. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI requestParameter4Property = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#requestParameter4");


	/**
	 * The Anzo Property for requestParameter5 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#requestParameter5)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Request Paremeter 5. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI requestParameter5Property = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#requestParameter5");


	/**
	 * The Anzo Property for requestParameter6 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#requestParameter6)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Request Paremeter 6. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI requestParameter6Property = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#requestParameter6");


	/**
	 * The Anzo Property for requestParameter7 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#requestParameter7)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Request Paremeter 7. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI requestParameter7Property = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#requestParameter7");


	/**
	 * The Anzo Property for result 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#result)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI resultProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#result");




	/**
	 * Gets the 'name' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#nameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getName() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'name' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#nameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'name' property value
	 * @param	name	{@link java.lang.String}, the value to set
	 * @see			#nameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setName(java.lang.String name) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'name'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#nameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'bypassPool' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#bypassPoolProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getBypassPool() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'bypassPool' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#bypassPoolProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getBypassPool(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'bypassPool' property value
	 * @param	bypassPool	{@link java.lang.Boolean}, the value to set
	 * @see			#bypassPoolProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setBypassPool(java.lang.Boolean bypassPool) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'bypassPool'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#bypassPoolProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearBypassPool(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'restEndpoint' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#restEndpointProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getRestEndpoint() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'restEndpoint' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#restEndpointProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getRestEndpoint(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'restEndpoint' property value
	 * @param	restEndpoint	{@link java.lang.String}, the value to set
	 * @see			#restEndpointProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setRestEndpoint(java.lang.String restEndpoint) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'restEndpoint'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#restEndpointProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearRestEndpoint(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'restType' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#restTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getRestType() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'restType' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#restTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getRestType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'restType' property value
	 * @param	restType	{@link java.lang.String}, the value to set
	 * @see			#restTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setRestType(java.lang.String restType) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'restType'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#restTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearRestType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'sysadminRequired' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#sysadminRequiredProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getSysadminRequired() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'sysadminRequired' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#sysadminRequiredProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getSysadminRequired(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'sysadminRequired' property value
	 * @param	sysadminRequired	{@link java.lang.Boolean}, the value to set
	 * @see			#sysadminRequiredProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setSysadminRequired(java.lang.Boolean sysadminRequired) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'sysadminRequired'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#sysadminRequiredProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSysadminRequired(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'wsOperation' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#wsOperationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getWsOperation() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'wsOperation' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#wsOperationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getWsOperation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'wsOperation' property value
	 * @param	wsOperation	{@link java.lang.String}, the value to set
	 * @see			#wsOperationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setWsOperation(java.lang.String wsOperation) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'wsOperation'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#wsOperationProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearWsOperation(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'requestParameter' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.system.Parameter}
	 * @see			#requestParameterProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Parameter> getRequestParameter() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'requestParameter' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.system.Parameter}
	 * @see			#requestParameterProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Parameter> getRequestParameter(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'requestParameter' property
	 * @param	requestParameter	The {@link org.openanzo.ontologies.system.Parameter} to add
	 * @see			#requestParameterProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addRequestParameter(org.openanzo.ontologies.system.Parameter requestParameter) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'requestParameter' property
	 * @return		The anoymous {@link org.openanzo.ontologies.system.Parameter} created
	 * @see			#requestParameterProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter addRequestParameter() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'requestParameter' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.system.Parameter} with the factory
	 * and calling addRequestParameter(org.openanzo.ontologies.system.Parameter requestParameter)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/System#Parameter.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.ontologies.system.Parameter, value added
	 * @see			#requestParameterProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter addRequestParameter(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'requestParameter' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	requestParameter	The {@link org.openanzo.ontologies.system.Parameter} to remove
	 * @see			#requestParameterProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeRequestParameter(org.openanzo.ontologies.system.Parameter requestParameter) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'requestParameter' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	requestParameter	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#requestParameterProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeRequestParameter(org.openanzo.rdf.Resource requestParameter) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'requestParameter'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#requestParameterProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearRequestParameter(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'requestParameter0' property value
	 * @return		{@link org.openanzo.ontologies.system.Parameter}
	 * @see			#requestParameter0Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter getRequestParameter0() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'requestParameter0' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.ontologies.system.Parameter}
	 * @see			#requestParameter0Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter getRequestParameter0(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'requestParameter0' property value
	 * @param	requestParameter0	{@link org.openanzo.ontologies.system.Parameter}, value to set
	 * @see			#requestParameter0Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setRequestParameter0(org.openanzo.ontologies.system.Parameter requestParameter0) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'requestParameter0' property value to an anonymous node
	 * @return		{@link org.openanzo.ontologies.system.Parameter}, the created value
	 * @see			#requestParameter0Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.ontologies.system.Parameter setRequestParameter0() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'requestParameter0' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.system.Parameter} with the factory.
	 * and calling setRequestParameter0(org.openanzo.ontologies.system.Parameter requestParameter0)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/System#Parameter.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.ontologies.system.Parameter}, the newly created value
	 * @see			#requestParameter0Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter setRequestParameter0(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'requestParameter0'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#requestParameter0Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearRequestParameter0(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'requestParameter1' property value
	 * @return		{@link org.openanzo.ontologies.system.Parameter}
	 * @see			#requestParameter1Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter getRequestParameter1() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'requestParameter1' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.ontologies.system.Parameter}
	 * @see			#requestParameter1Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter getRequestParameter1(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'requestParameter1' property value
	 * @param	requestParameter1	{@link org.openanzo.ontologies.system.Parameter}, value to set
	 * @see			#requestParameter1Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setRequestParameter1(org.openanzo.ontologies.system.Parameter requestParameter1) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'requestParameter1' property value to an anonymous node
	 * @return		{@link org.openanzo.ontologies.system.Parameter}, the created value
	 * @see			#requestParameter1Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.ontologies.system.Parameter setRequestParameter1() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'requestParameter1' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.system.Parameter} with the factory.
	 * and calling setRequestParameter1(org.openanzo.ontologies.system.Parameter requestParameter1)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/System#Parameter.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.ontologies.system.Parameter}, the newly created value
	 * @see			#requestParameter1Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter setRequestParameter1(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'requestParameter1'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#requestParameter1Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearRequestParameter1(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'requestParameter2' property value
	 * @return		{@link org.openanzo.ontologies.system.Parameter}
	 * @see			#requestParameter2Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter getRequestParameter2() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'requestParameter2' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.ontologies.system.Parameter}
	 * @see			#requestParameter2Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter getRequestParameter2(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'requestParameter2' property value
	 * @param	requestParameter2	{@link org.openanzo.ontologies.system.Parameter}, value to set
	 * @see			#requestParameter2Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setRequestParameter2(org.openanzo.ontologies.system.Parameter requestParameter2) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'requestParameter2' property value to an anonymous node
	 * @return		{@link org.openanzo.ontologies.system.Parameter}, the created value
	 * @see			#requestParameter2Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.ontologies.system.Parameter setRequestParameter2() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'requestParameter2' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.system.Parameter} with the factory.
	 * and calling setRequestParameter2(org.openanzo.ontologies.system.Parameter requestParameter2)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/System#Parameter.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.ontologies.system.Parameter}, the newly created value
	 * @see			#requestParameter2Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter setRequestParameter2(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'requestParameter2'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#requestParameter2Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearRequestParameter2(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'requestParameter3' property value
	 * @return		{@link org.openanzo.ontologies.system.Parameter}
	 * @see			#requestParameter3Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter getRequestParameter3() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'requestParameter3' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.ontologies.system.Parameter}
	 * @see			#requestParameter3Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter getRequestParameter3(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'requestParameter3' property value
	 * @param	requestParameter3	{@link org.openanzo.ontologies.system.Parameter}, value to set
	 * @see			#requestParameter3Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setRequestParameter3(org.openanzo.ontologies.system.Parameter requestParameter3) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'requestParameter3' property value to an anonymous node
	 * @return		{@link org.openanzo.ontologies.system.Parameter}, the created value
	 * @see			#requestParameter3Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.ontologies.system.Parameter setRequestParameter3() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'requestParameter3' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.system.Parameter} with the factory.
	 * and calling setRequestParameter3(org.openanzo.ontologies.system.Parameter requestParameter3)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/System#Parameter.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.ontologies.system.Parameter}, the newly created value
	 * @see			#requestParameter3Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter setRequestParameter3(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'requestParameter3'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#requestParameter3Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearRequestParameter3(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'requestParameter4' property value
	 * @return		{@link org.openanzo.ontologies.system.Parameter}
	 * @see			#requestParameter4Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter getRequestParameter4() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'requestParameter4' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.ontologies.system.Parameter}
	 * @see			#requestParameter4Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter getRequestParameter4(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'requestParameter4' property value
	 * @param	requestParameter4	{@link org.openanzo.ontologies.system.Parameter}, value to set
	 * @see			#requestParameter4Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setRequestParameter4(org.openanzo.ontologies.system.Parameter requestParameter4) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'requestParameter4' property value to an anonymous node
	 * @return		{@link org.openanzo.ontologies.system.Parameter}, the created value
	 * @see			#requestParameter4Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.ontologies.system.Parameter setRequestParameter4() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'requestParameter4' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.system.Parameter} with the factory.
	 * and calling setRequestParameter4(org.openanzo.ontologies.system.Parameter requestParameter4)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/System#Parameter.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.ontologies.system.Parameter}, the newly created value
	 * @see			#requestParameter4Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter setRequestParameter4(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'requestParameter4'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#requestParameter4Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearRequestParameter4(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'requestParameter5' property value
	 * @return		{@link org.openanzo.ontologies.system.Parameter}
	 * @see			#requestParameter5Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter getRequestParameter5() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'requestParameter5' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.ontologies.system.Parameter}
	 * @see			#requestParameter5Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter getRequestParameter5(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'requestParameter5' property value
	 * @param	requestParameter5	{@link org.openanzo.ontologies.system.Parameter}, value to set
	 * @see			#requestParameter5Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setRequestParameter5(org.openanzo.ontologies.system.Parameter requestParameter5) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'requestParameter5' property value to an anonymous node
	 * @return		{@link org.openanzo.ontologies.system.Parameter}, the created value
	 * @see			#requestParameter5Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.ontologies.system.Parameter setRequestParameter5() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'requestParameter5' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.system.Parameter} with the factory.
	 * and calling setRequestParameter5(org.openanzo.ontologies.system.Parameter requestParameter5)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/System#Parameter.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.ontologies.system.Parameter}, the newly created value
	 * @see			#requestParameter5Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter setRequestParameter5(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'requestParameter5'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#requestParameter5Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearRequestParameter5(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'requestParameter6' property value
	 * @return		{@link org.openanzo.ontologies.system.Parameter}
	 * @see			#requestParameter6Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter getRequestParameter6() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'requestParameter6' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.ontologies.system.Parameter}
	 * @see			#requestParameter6Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter getRequestParameter6(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'requestParameter6' property value
	 * @param	requestParameter6	{@link org.openanzo.ontologies.system.Parameter}, value to set
	 * @see			#requestParameter6Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setRequestParameter6(org.openanzo.ontologies.system.Parameter requestParameter6) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'requestParameter6' property value to an anonymous node
	 * @return		{@link org.openanzo.ontologies.system.Parameter}, the created value
	 * @see			#requestParameter6Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.ontologies.system.Parameter setRequestParameter6() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'requestParameter6' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.system.Parameter} with the factory.
	 * and calling setRequestParameter6(org.openanzo.ontologies.system.Parameter requestParameter6)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/System#Parameter.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.ontologies.system.Parameter}, the newly created value
	 * @see			#requestParameter6Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter setRequestParameter6(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'requestParameter6'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#requestParameter6Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearRequestParameter6(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'requestParameter7' property value
	 * @return		{@link org.openanzo.ontologies.system.Parameter}
	 * @see			#requestParameter7Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter getRequestParameter7() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'requestParameter7' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.ontologies.system.Parameter}
	 * @see			#requestParameter7Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter getRequestParameter7(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'requestParameter7' property value
	 * @param	requestParameter7	{@link org.openanzo.ontologies.system.Parameter}, value to set
	 * @see			#requestParameter7Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setRequestParameter7(org.openanzo.ontologies.system.Parameter requestParameter7) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'requestParameter7' property value to an anonymous node
	 * @return		{@link org.openanzo.ontologies.system.Parameter}, the created value
	 * @see			#requestParameter7Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.ontologies.system.Parameter setRequestParameter7() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'requestParameter7' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.system.Parameter} with the factory.
	 * and calling setRequestParameter7(org.openanzo.ontologies.system.Parameter requestParameter7)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/System#Parameter.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.ontologies.system.Parameter}, the newly created value
	 * @see			#requestParameter7Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter setRequestParameter7(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'requestParameter7'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#requestParameter7Property
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearRequestParameter7(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'result' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.system.Parameter}
	 * @see			#resultProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Parameter> getResult() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'result' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.system.Parameter}
	 * @see			#resultProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Parameter> getResult(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'result' property
	 * @param	result	The {@link org.openanzo.ontologies.system.Parameter} to add
	 * @see			#resultProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addResult(org.openanzo.ontologies.system.Parameter result) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'result' property
	 * @return		The anoymous {@link org.openanzo.ontologies.system.Parameter} created
	 * @see			#resultProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter addResult() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'result' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.system.Parameter} with the factory
	 * and calling addResult(org.openanzo.ontologies.system.Parameter result)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/System#Parameter.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.ontologies.system.Parameter, value added
	 * @see			#resultProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Parameter addResult(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'result' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	result	The {@link org.openanzo.ontologies.system.Parameter} to remove
	 * @see			#resultProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeResult(org.openanzo.ontologies.system.Parameter result) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'result' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	result	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#resultProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeResult(org.openanzo.rdf.Resource result) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'result'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#resultProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearResult(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}