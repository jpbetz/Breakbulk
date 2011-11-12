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
 * Interface for JastorOntology ontology class<br>
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#JastorOntology)</p>
 * <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface JastorOntology extends org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#JastorOntology");
	

	/**
	 * The Anzo Property for generate 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#generate)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI generateProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#generate");


	/**
	 * The Anzo Property for ontologyUri 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#ontologyUri)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI ontologyUriProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#ontologyUri");


	/**
	 * The Anzo Property for _package 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#package)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI _packageProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#package");




	/**
	 * Gets the 'generate' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#generateProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getGenerate() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'generate' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#generateProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getGenerate(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'generate' property value
	 * @param	generate	{@link java.lang.Boolean}, the value to set
	 * @see			#generateProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setGenerate(java.lang.Boolean generate) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'generate'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#generateProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearGenerate(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'ontologyUri' property value from the given graph
	 * @return		{@link org.openanzo.rdf.URI}
	 * @see			#ontologyUriProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.URI getOntologyUri() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'ontologyUri' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.rdf.URI}
	 * @see			#ontologyUriProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.URI getOntologyUri(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'ontologyUri' property value
	 * @param	ontologyUri	{@link org.openanzo.rdf.URI}, the value to set
	 * @see			#ontologyUriProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setOntologyUri(org.openanzo.rdf.URI ontologyUri) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'ontologyUri'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#ontologyUriProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearOntologyUri(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the '_package' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#_packageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String get_package() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the '_package' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#_packageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String get_package(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the '_package' property value
	 * @param	_package	{@link java.lang.String}, the value to set
	 * @see			#_packageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void set_package(java.lang.String _package) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for '_package'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#_packageProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clear_package(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}