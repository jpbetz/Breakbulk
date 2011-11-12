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
 * Interface for Type ontology class<br>
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#Type)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Type of parameter <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface Type extends org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#Type");
	

	/**
	 * The Anzo Property for javaType 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#javaType)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI javaTypeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#javaType");


	/**
	 * The Anzo Property for name 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#name)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI nameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#name");


	/**
	 * The Anzo Property for defaultValue 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#defaultValue)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI defaultValueProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#defaultValue");


	/**
	 * The Anzo Property for javaTransportType 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#javaTransportType)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI javaTransportTypeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#javaTransportType");


	/**
	 * The Anzo Property for serializer 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#serializer)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI serializerProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#serializer");


	/**
	 * The Anzo Property for defaultJMSFormat 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#defaultJMSFormat)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI defaultJMSFormatProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#defaultJMSFormat");


	/**
	 * The Anzo Property for defaultRestFormat 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#defaultRestFormat)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI defaultRestFormatProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#defaultRestFormat");


	/**
	 * The Anzo Property for defaultWSFormat 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#defaultWSFormat)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI defaultWSFormatProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#defaultWSFormat");


	/**
	 * The Anzo Property for validFormat 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#validFormat)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI validFormatProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#validFormat");




	/**
	 * Gets the 'javaType' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#javaTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getJavaType() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'javaType' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#javaTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getJavaType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'javaType' property value
	 * @param	javaType	{@link java.lang.String}, the value to set
	 * @see			#javaTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setJavaType(java.lang.String javaType) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'javaType'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#javaTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearJavaType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
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
	 * Gets the 'defaultValue' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#defaultValueProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getDefaultValue() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'defaultValue' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#defaultValueProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getDefaultValue(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'defaultValue' property value
	 * @param	defaultValue	{@link java.lang.String}, the value to set
	 * @see			#defaultValueProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setDefaultValue(java.lang.String defaultValue) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'defaultValue'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#defaultValueProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDefaultValue(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'javaTransportType' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#javaTransportTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getJavaTransportType() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'javaTransportType' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#javaTransportTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getJavaTransportType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'javaTransportType' property value
	 * @param	javaTransportType	{@link java.lang.String}, the value to set
	 * @see			#javaTransportTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setJavaTransportType(java.lang.String javaTransportType) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'javaTransportType'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#javaTransportTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearJavaTransportType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'serializer' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#serializerProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getSerializer() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'serializer' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#serializerProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getSerializer(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'serializer' property value
	 * @param	serializer	{@link java.lang.String}, the value to set
	 * @see			#serializerProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setSerializer(java.lang.String serializer) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'serializer'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#serializerProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSerializer(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'defaultJMSFormat' property value
	 * @return		{@link org.openanzo.ontologies.system.Format}
	 * @see			#defaultJMSFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Format getDefaultJMSFormat() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'defaultJMSFormat' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.ontologies.system.Format}
	 * @see			#defaultJMSFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Format getDefaultJMSFormat(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'defaultJMSFormat' property value
	 * @param	defaultJMSFormat	{@link org.openanzo.ontologies.system.Format}, value to set
	 * @see			#defaultJMSFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setDefaultJMSFormat(org.openanzo.ontologies.system.Format defaultJMSFormat) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'defaultJMSFormat' property value to an anonymous node
	 * @return		{@link org.openanzo.ontologies.system.Format}, the created value
	 * @see			#defaultJMSFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.ontologies.system.Format setDefaultJMSFormat() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'defaultJMSFormat' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.system.Format} with the factory.
	 * and calling setDefaultJMSFormat(org.openanzo.ontologies.system.Format defaultJMSFormat)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/System#Format.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.ontologies.system.Format}, the newly created value
	 * @see			#defaultJMSFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Format setDefaultJMSFormat(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'defaultJMSFormat'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#defaultJMSFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDefaultJMSFormat(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'defaultRestFormat' property value
	 * @return		{@link org.openanzo.ontologies.system.Format}
	 * @see			#defaultRestFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Format getDefaultRestFormat() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'defaultRestFormat' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.ontologies.system.Format}
	 * @see			#defaultRestFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Format getDefaultRestFormat(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'defaultRestFormat' property value
	 * @param	defaultRestFormat	{@link org.openanzo.ontologies.system.Format}, value to set
	 * @see			#defaultRestFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setDefaultRestFormat(org.openanzo.ontologies.system.Format defaultRestFormat) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'defaultRestFormat' property value to an anonymous node
	 * @return		{@link org.openanzo.ontologies.system.Format}, the created value
	 * @see			#defaultRestFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.ontologies.system.Format setDefaultRestFormat() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'defaultRestFormat' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.system.Format} with the factory.
	 * and calling setDefaultRestFormat(org.openanzo.ontologies.system.Format defaultRestFormat)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/System#Format.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.ontologies.system.Format}, the newly created value
	 * @see			#defaultRestFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Format setDefaultRestFormat(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'defaultRestFormat'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#defaultRestFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDefaultRestFormat(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'defaultWSFormat' property value
	 * @return		{@link org.openanzo.ontologies.system.Format}
	 * @see			#defaultWSFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Format getDefaultWSFormat() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'defaultWSFormat' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.ontologies.system.Format}
	 * @see			#defaultWSFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Format getDefaultWSFormat(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'defaultWSFormat' property value
	 * @param	defaultWSFormat	{@link org.openanzo.ontologies.system.Format}, value to set
	 * @see			#defaultWSFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setDefaultWSFormat(org.openanzo.ontologies.system.Format defaultWSFormat) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'defaultWSFormat' property value to an anonymous node
	 * @return		{@link org.openanzo.ontologies.system.Format}, the created value
	 * @see			#defaultWSFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.ontologies.system.Format setDefaultWSFormat() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'defaultWSFormat' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.system.Format} with the factory.
	 * and calling setDefaultWSFormat(org.openanzo.ontologies.system.Format defaultWSFormat)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/System#Format.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.ontologies.system.Format}, the newly created value
	 * @see			#defaultWSFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Format setDefaultWSFormat(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'defaultWSFormat'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#defaultWSFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDefaultWSFormat(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'validFormat' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.system.Format}
	 * @see			#validFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Format> getValidFormat() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'validFormat' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.system.Format}
	 * @see			#validFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Format> getValidFormat(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'validFormat' property
	 * @param	validFormat	The {@link org.openanzo.ontologies.system.Format} to add
	 * @see			#validFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addValidFormat(org.openanzo.ontologies.system.Format validFormat) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'validFormat' property
	 * @return		The anoymous {@link org.openanzo.ontologies.system.Format} created
	 * @see			#validFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Format addValidFormat() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'validFormat' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.system.Format} with the factory
	 * and calling addValidFormat(org.openanzo.ontologies.system.Format validFormat)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/System#Format.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.ontologies.system.Format, value added
	 * @see			#validFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Format addValidFormat(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'validFormat' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	validFormat	The {@link org.openanzo.ontologies.system.Format} to remove
	 * @see			#validFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeValidFormat(org.openanzo.ontologies.system.Format validFormat) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'validFormat' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	validFormat	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#validFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeValidFormat(org.openanzo.rdf.Resource validFormat) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'validFormat'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#validFormatProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearValidFormat(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}