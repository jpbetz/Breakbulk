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
 * Interface for Query ontology class<br>
 * Use the org.openanzo.ontologies.openanzo.AnzoFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/Anzo#Query)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : A dataset for a precondition <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface Query extends org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#Query");
	

	/**
	 * The Anzo Property for queryString 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/Anzo#queryString)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI queryStringProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#queryString");




	/**
	 * Gets the 'queryString' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#queryStringProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getQueryString() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'queryString' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#queryStringProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getQueryString(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'queryString' property value
	 * @param	queryString	{@link java.lang.String}, the value to set
	 * @see			#queryStringProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setQueryString(java.lang.String queryString) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'queryString'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#queryStringProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearQueryString(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}