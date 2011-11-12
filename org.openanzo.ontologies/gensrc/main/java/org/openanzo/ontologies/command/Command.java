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
package org.openanzo.ontologies.command;

/**
 * Interface for Command ontology class<br>
 * Use the org.openanzo.ontologies.command.CommandFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/Command#Command)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Anzo Client Command.  The Ontology class should be applied to transaction URIs in 
			transaction context graphs to indicate command types for the transaction. <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface Command extends org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Command#Command");
	

	/**
	 * The Anzo Property for commandType 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/Command#commandType)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : The command type <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI commandTypeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Command#commandType");




	/**
	 * Gets the 'commandType' property value
	 * @return		{@link org.openanzo.rdf.jastor.Thing}
	 * @see			#commandTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing getCommandType() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'commandType' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.rdf.jastor.Thing}
	 * @see			#commandTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing getCommandType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'commandType' property value
	 * @param	commandType	{@link org.openanzo.rdf.jastor.Thing}, value to set
	 * @see			#commandTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setCommandType(org.openanzo.rdf.jastor.Thing commandType) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'commandType' property value to an anonymous node
	 * @return		{@link org.openanzo.rdf.jastor.Thing}, the created value
	 * @see			#commandTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.rdf.jastor.Thing setCommandType() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'commandType' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.Thing} with the factory.
	 * and calling setCommandType(org.openanzo.rdf.jastor.Thing commandType)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.rdf.jastor.Thing}, the newly created value
	 * @see			#commandTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing setCommandType(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'commandType'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#commandTypeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearCommandType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}