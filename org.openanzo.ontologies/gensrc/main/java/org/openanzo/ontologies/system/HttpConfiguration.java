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
 * Interface for HttpConfiguration ontology class<br>
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#HttpConfiguration)</p>
 * <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface HttpConfiguration extends 
org.openanzo.ontologies.system.NetworkComponent, org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#HttpConfiguration");
	



/**
	 * Clears all values for 'credentials'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#credentialsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearCredentials(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'className'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#classNameProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearClassName(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'enabled'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#enabledProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearEnabled(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'initOrder'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#initOrderProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearInitOrder(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
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
/**
	 * Clears all values for 'networkTimeout'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#networkTimeoutProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearNetworkTimeout(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'connection'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#connectionProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearConnection(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}