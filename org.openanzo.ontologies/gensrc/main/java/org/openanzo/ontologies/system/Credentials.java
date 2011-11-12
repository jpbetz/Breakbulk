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
 * Interface for Credentials ontology class<br>
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#Credentials)</p>
 * <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface Credentials extends org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#Credentials");
	

	/**
	 * The Anzo Property for password 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#password)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : User for network service. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI passwordProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#password");


	/**
	 * The Anzo Property for user 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#user)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : User for network service. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI userProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#user");




	/**
	 * Gets the 'password' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#passwordProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getPassword() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'password' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#passwordProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getPassword(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'password' property value
	 * @param	password	{@link java.lang.String}, the value to set
	 * @see			#passwordProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setPassword(java.lang.String password) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'password'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#passwordProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearPassword(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'user' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#userProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getUser() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'user' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#userProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getUser(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'user' property value
	 * @param	user	{@link java.lang.String}, the value to set
	 * @see			#userProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setUser(java.lang.String user) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'user'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#userProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearUser(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}