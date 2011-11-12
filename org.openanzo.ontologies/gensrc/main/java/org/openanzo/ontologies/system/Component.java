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
 * Interface for Component ontology class<br>
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#Component)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Service Container Component <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface Component extends org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#Component");
	

	/**
	 * The Anzo Property for credentials 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#credentials)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Service Container Credentials <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI credentialsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#credentials");


	/**
	 * The Anzo Property for className 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#className)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : ClassName for this component. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI classNameProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#className");


	/**
	 * The Anzo Property for enabled 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#enabled)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Component is enabled. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI enabledProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#enabled");


	/**
	 * The Anzo Property for initOrder 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#initOrder)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Init order hint, lowest to highest. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI initOrderProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#initOrder");


	/**
	 * The Anzo Property for dependency 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#dependency)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI dependencyProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#dependency");




	/**
	 * Gets the 'credentials' property value
	 * @return		{@link org.openanzo.ontologies.system.Credentials}
	 * @see			#credentialsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Credentials getCredentials() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'credentials' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.ontologies.system.Credentials}
	 * @see			#credentialsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Credentials getCredentials(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'credentials' property value
	 * @param	credentials	{@link org.openanzo.ontologies.system.Credentials}, value to set
	 * @see			#credentialsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setCredentials(org.openanzo.ontologies.system.Credentials credentials) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'credentials' property value to an anonymous node
	 * @return		{@link org.openanzo.ontologies.system.Credentials}, the created value
	 * @see			#credentialsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.ontologies.system.Credentials setCredentials() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'credentials' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.system.Credentials} with the factory.
	 * and calling setCredentials(org.openanzo.ontologies.system.Credentials credentials)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/System#Credentials.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.ontologies.system.Credentials}, the newly created value
	 * @see			#credentialsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Credentials setCredentials(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'credentials'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#credentialsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearCredentials(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'className' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#classNameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getClassName() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'className' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#classNameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getClassName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'className' property value
	 * @param	className	{@link java.lang.String}, the value to set
	 * @see			#classNameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setClassName(java.lang.String className) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'className'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#classNameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearClassName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'enabled' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#enabledProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getEnabled() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'enabled' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#enabledProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getEnabled(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'enabled' property value
	 * @param	enabled	{@link java.lang.Boolean}, the value to set
	 * @see			#enabledProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setEnabled(java.lang.Boolean enabled) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'enabled'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#enabledProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearEnabled(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'initOrder' property value from the given graph
	 * @return		{@link java.lang.Integer}
	 * @see			#initOrderProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Integer getInitOrder() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'initOrder' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Integer}
	 * @see			#initOrderProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Integer getInitOrder(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'initOrder' property value
	 * @param	initOrder	{@link java.lang.Integer}, the value to set
	 * @see			#initOrderProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setInitOrder(java.lang.Integer initOrder) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'initOrder'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#initOrderProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearInitOrder(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'dependency' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.system.Component}
	 * @see			#dependencyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Component> getDependency() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'dependency' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.system.Component}
	 * @see			#dependencyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.system.Component> getDependency(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'dependency' property
	 * @param	dependency	The {@link org.openanzo.ontologies.system.Component} to add
	 * @see			#dependencyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addDependency(org.openanzo.ontologies.system.Component dependency) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'dependency' property
	 * @return		The anoymous {@link org.openanzo.ontologies.system.Component} created
	 * @see			#dependencyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Component addDependency() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'dependency' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.system.Component} with the factory
	 * and calling addDependency(org.openanzo.ontologies.system.Component dependency)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/System#Component.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.ontologies.system.Component, value added
	 * @see			#dependencyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.system.Component addDependency(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'dependency' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	dependency	The {@link org.openanzo.ontologies.system.Component} to remove
	 * @see			#dependencyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDependency(org.openanzo.ontologies.system.Component dependency) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'dependency' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	dependency	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#dependencyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDependency(org.openanzo.rdf.Resource dependency) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'dependency'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#dependencyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDependency(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}