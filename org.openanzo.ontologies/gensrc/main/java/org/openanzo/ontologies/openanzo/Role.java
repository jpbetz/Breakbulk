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
 * Revision:	$Id: Role.java 5125 2010-02-11 16:33:03Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *	   Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.ontologies.openanzo;

/**
 * Interface for Role ontology class<br>
 * Use the org.openanzo.ontologies.openanzo.AnzoFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/Anzo#Role)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Role <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface Role extends org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#Role");
	

	/**
	 * The Anzo Property for member 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/Anzo#member)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Member of role. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI memberProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#member");




	/**
	 * Get an Iterator the 'member' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.openanzo.User}
	 * @see			#memberProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.User> getMember() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'member' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.ontologies.openanzo.User}
	 * @see			#memberProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.ontologies.openanzo.User> getMember(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'member' property
	 * @param	member	The {@link org.openanzo.ontologies.openanzo.User} to add
	 * @see			#memberProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addMember(org.openanzo.ontologies.openanzo.User member) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'member' property
	 * @return		The anoymous {@link org.openanzo.ontologies.openanzo.User} created
	 * @see			#memberProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.openanzo.User addMember() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'member' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.openanzo.User} with the factory
	 * and calling addMember(org.openanzo.ontologies.openanzo.User member)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/Anzo#User.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.ontologies.openanzo.User, value added
	 * @see			#memberProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.openanzo.User addMember(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'member' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	member	The {@link org.openanzo.ontologies.openanzo.User} to remove
	 * @see			#memberProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMember(org.openanzo.ontologies.openanzo.User member) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'member' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	member	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#memberProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeMember(org.openanzo.rdf.Resource member) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'member'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#memberProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearMember(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}