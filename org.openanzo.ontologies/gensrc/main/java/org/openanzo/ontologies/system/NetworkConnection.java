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
 * Interface for NetworkConnection ontology class<br>
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#NetworkConnection)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Network connection to a host <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface NetworkConnection extends org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#NetworkConnection");
	

	/**
	 * The Anzo Property for host 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#host)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Host name/address for network connection. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI hostProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#host");


	/**
	 * The Anzo Property for keystoreFile 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#keystoreFile)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Keystore file. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI keystoreFileProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#keystoreFile");


	/**
	 * The Anzo Property for keystorePassword 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#keystorePassword)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Keystore password. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI keystorePasswordProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#keystorePassword");


	/**
	 * The Anzo Property for keystoreType 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#keystoreType)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Keystore type. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI keystoreTypeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#keystoreType");


	/**
	 * The Anzo Property for port 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#port)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Port for network connection. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI portProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#port");


	/**
	 * The Anzo Property for timeout 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#timeout)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Timeout for network connection. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI timeoutProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#timeout");


	/**
	 * The Anzo Property for truststoreFile 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#truststoreFile)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Truststore file. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI truststoreFileProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#truststoreFile");


	/**
	 * The Anzo Property for truststorePassword 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#truststorePassword)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Truststore password. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI truststorePasswordProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#truststorePassword");


	/**
	 * The Anzo Property for truststoreType 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#truststoreType)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Truststore type. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI truststoreTypeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#truststoreType");


	/**
	 * The Anzo Property for useSsl 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#useSsl)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Use Ssl. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI useSslProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#useSsl");




	/**
	 * Gets the 'host' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#hostProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getHost() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'host' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#hostProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getHost(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'host' property value
	 * @param	host	{@link java.lang.String}, the value to set
	 * @see			#hostProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setHost(java.lang.String host) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'host'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#hostProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearHost(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'keystoreFile' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#keystoreFileProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getKeystoreFile() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'keystoreFile' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#keystoreFileProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getKeystoreFile(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'keystoreFile' property value
	 * @param	keystoreFile	{@link java.lang.String}, the value to set
	 * @see			#keystoreFileProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setKeystoreFile(java.lang.String keystoreFile) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'keystoreFile'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#keystoreFileProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearKeystoreFile(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'keystorePassword' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#keystorePasswordProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getKeystorePassword() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'keystorePassword' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#keystorePasswordProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getKeystorePassword(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'keystorePassword' property value
	 * @param	keystorePassword	{@link java.lang.String}, the value to set
	 * @see			#keystorePasswordProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setKeystorePassword(java.lang.String keystorePassword) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'keystorePassword'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#keystorePasswordProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearKeystorePassword(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'keystoreType' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#keystoreTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getKeystoreType() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'keystoreType' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#keystoreTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getKeystoreType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'keystoreType' property value
	 * @param	keystoreType	{@link java.lang.String}, the value to set
	 * @see			#keystoreTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setKeystoreType(java.lang.String keystoreType) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'keystoreType'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#keystoreTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearKeystoreType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'port' property value from the given graph
	 * @return		{@link java.lang.Integer}
	 * @see			#portProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Integer getPort() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'port' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Integer}
	 * @see			#portProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Integer getPort(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'port' property value
	 * @param	port	{@link java.lang.Integer}, the value to set
	 * @see			#portProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setPort(java.lang.Integer port) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'port'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#portProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearPort(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'timeout' property value from the given graph
	 * @return		{@link java.lang.Long}
	 * @see			#timeoutProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Long getTimeout() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'timeout' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Long}
	 * @see			#timeoutProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Long getTimeout(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'timeout' property value
	 * @param	timeout	{@link java.lang.Long}, the value to set
	 * @see			#timeoutProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setTimeout(java.lang.Long timeout) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'timeout'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#timeoutProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearTimeout(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'truststoreFile' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#truststoreFileProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getTruststoreFile() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'truststoreFile' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#truststoreFileProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getTruststoreFile(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'truststoreFile' property value
	 * @param	truststoreFile	{@link java.lang.String}, the value to set
	 * @see			#truststoreFileProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setTruststoreFile(java.lang.String truststoreFile) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'truststoreFile'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#truststoreFileProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearTruststoreFile(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'truststorePassword' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#truststorePasswordProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getTruststorePassword() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'truststorePassword' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#truststorePasswordProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getTruststorePassword(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'truststorePassword' property value
	 * @param	truststorePassword	{@link java.lang.String}, the value to set
	 * @see			#truststorePasswordProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setTruststorePassword(java.lang.String truststorePassword) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'truststorePassword'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#truststorePasswordProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearTruststorePassword(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'truststoreType' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#truststoreTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getTruststoreType() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'truststoreType' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#truststoreTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getTruststoreType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'truststoreType' property value
	 * @param	truststoreType	{@link java.lang.String}, the value to set
	 * @see			#truststoreTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setTruststoreType(java.lang.String truststoreType) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'truststoreType'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#truststoreTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearTruststoreType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'useSsl' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#useSslProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getUseSsl() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'useSsl' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#useSslProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getUseSsl(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'useSsl' property value
	 * @param	useSsl	{@link java.lang.Boolean}, the value to set
	 * @see			#useSslProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setUseSsl(java.lang.Boolean useSsl) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'useSsl'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#useSslProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearUseSsl(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}