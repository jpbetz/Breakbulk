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
package org.openanzo.ontologies.persistence;

/**
 * Interface for ClientPersistenceRoot ontology class<br>
 * Use the org.openanzo.ontologies.persistence.ClientPersistenceFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/ClientPersistence#ClientPersistenceRoot)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : Anzo Client Persistence <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface ClientPersistenceRoot extends org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#ClientPersistenceRoot");
	

	/**
	 * The Anzo Property for committedTransactions 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/ClientPersistence#committedTransactions)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : The transaction list <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI committedTransactionsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/ClientPersistence#committedTransactions");




	/**
	 * Gets the 'committedTransactions' property value
	 * @return		{@link org.openanzo.ontologies.persistence.PersistedTransaction}
	 * @see			#committedTransactionsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.persistence.PersistedTransaction getCommittedTransactions() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'committedTransactions' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.ontologies.persistence.PersistedTransaction}
	 * @see			#committedTransactionsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.persistence.PersistedTransaction getCommittedTransactions(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'committedTransactions' property value
	 * @param	committedTransactions	{@link org.openanzo.ontologies.persistence.PersistedTransaction}, value to set
	 * @see			#committedTransactionsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setCommittedTransactions(org.openanzo.ontologies.persistence.PersistedTransaction committedTransactions) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'committedTransactions' property value to an anonymous node
	 * @return		{@link org.openanzo.ontologies.persistence.PersistedTransaction}, the created value
	 * @see			#committedTransactionsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.ontologies.persistence.PersistedTransaction setCommittedTransactions() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'committedTransactions' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.ontologies.persistence.PersistedTransaction} with the factory.
	 * and calling setCommittedTransactions(org.openanzo.ontologies.persistence.PersistedTransaction committedTransactions)
	 * The resource argument have rdf:type http://openanzo.org/ontologies/2008/07/ClientPersistence#PersistedTransaction.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.ontologies.persistence.PersistedTransaction}, the newly created value
	 * @see			#committedTransactionsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.ontologies.persistence.PersistedTransaction setCommittedTransactions(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'committedTransactions'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#committedTransactionsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearCommittedTransactions(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}