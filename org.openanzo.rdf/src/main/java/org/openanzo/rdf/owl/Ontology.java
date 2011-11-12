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
package org.openanzo.rdf.owl;

/**
 * Interface for Ontology ontology class<br>
 * Use the org.openanzo.rdf.owl.OWL11Factory to create instances of this interface.
 * <p>(URI: http://www.w3.org/2002/07/owl#Ontology)</p>
 * <br>
 * <br>
 * <br>
 */
public interface Ontology extends org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#Ontology");
	

	/**
	 * The Anzo Property for Imports 
	 * <p>(URI: owl11xml:Imports)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI ImportsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("owl11xml:Imports");



	/**
	 * Individual for URI: http://www.w3.org/2006/12/owl11#OWL11
	 */
	public static org.openanzo.rdf.URI OWL11 = org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#OWL11");



	/**
	 * Get an Iterator the 'Imports' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.jastor.Thing}
	 * @see			#ImportsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getImports() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'Imports' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.jastor.Thing}
	 * @see			#ImportsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.jastor.Thing> getImports(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'Imports' property
	 * @param	Imports	The {@link org.openanzo.rdf.jastor.Thing} to add
	 * @see			#ImportsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addImports(org.openanzo.rdf.jastor.Thing Imports) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'Imports' property
	 * @return		The anoymous {@link org.openanzo.rdf.jastor.Thing} created
	 * @see			#ImportsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing addImports() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'Imports' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.Thing} with the factory
	 * and calling addImports(org.openanzo.rdf.jastor.Thing Imports)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.rdf.jastor.Thing, value added
	 * @see			#ImportsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing addImports(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'Imports' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	Imports	The {@link org.openanzo.rdf.jastor.Thing} to remove
	 * @see			#ImportsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeImports(org.openanzo.rdf.jastor.Thing Imports) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'Imports' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	Imports	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#ImportsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeImports(org.openanzo.rdf.Resource Imports) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'Imports'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#ImportsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearImports(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}