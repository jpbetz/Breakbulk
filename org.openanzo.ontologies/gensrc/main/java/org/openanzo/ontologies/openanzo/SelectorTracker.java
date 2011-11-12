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
 * Interface for SelectorTracker ontology class<br>
 * Use the org.openanzo.ontologies.openanzo.AnzoFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/Anzo#SelectorTracker)</p>
 * <br>
 * RDF Schema Standard Properties <br>
 * 	comment : A SelectorTracker <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface SelectorTracker extends 
org.openanzo.ontologies.openanzo.Tracker, org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#SelectorTracker");
	

	/**
	 * The Anzo Property for namedGraphUri 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/Anzo#namedGraphUri)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI namedGraphUriProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#namedGraphUri");


	/**
	 * The Anzo Property for object 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/Anzo#object)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI objectProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#object");


	/**
	 * The Anzo Property for predicate 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/Anzo#predicate)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI predicateProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#predicate");


	/**
	 * The Anzo Property for subject 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/Anzo#subject)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI subjectProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/Anzo#subject");




	/**
	 * Iterates through the 'namedGraphUri' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.URI}
	 * @see			#namedGraphUriProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.URI> getNamedGraphUri() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Iterates through the 'namedGraphUri' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.URI}
	 * @see			#namedGraphUriProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.URI> getNamedGraphUri(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Add a 'namedGraphUri' property value
	 * @param	namedGraphUri	{@link org.openanzo.rdf.URI}, the value to add
	 * @see			#namedGraphUriProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addNamedGraphUri(org.openanzo.rdf.URI namedGraphUri) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Remove a 'namedGraphUri' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	namedGraphUri	{@link org.openanzo.rdf.URI}, the value to remove
	 * @see			#namedGraphUriProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeNamedGraphUri(org.openanzo.rdf.URI namedGraphUri) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'namedGraphUri'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#namedGraphUriProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearNamedGraphUri(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Iterates through the 'object' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.URI}
	 * @see			#objectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.URI> getObject() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Iterates through the 'object' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.URI}
	 * @see			#objectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.URI> getObject(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Add a 'object' property value
	 * @param	object	{@link org.openanzo.rdf.URI}, the value to add
	 * @see			#objectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addObject(org.openanzo.rdf.URI object) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Remove a 'object' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	object	{@link org.openanzo.rdf.URI}, the value to remove
	 * @see			#objectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeObject(org.openanzo.rdf.URI object) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'object'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#objectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearObject(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Iterates through the 'predicate' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.URI}
	 * @see			#predicateProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.URI> getPredicate() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Iterates through the 'predicate' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.URI}
	 * @see			#predicateProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.URI> getPredicate(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Add a 'predicate' property value
	 * @param	predicate	{@link org.openanzo.rdf.URI}, the value to add
	 * @see			#predicateProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addPredicate(org.openanzo.rdf.URI predicate) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Remove a 'predicate' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	predicate	{@link org.openanzo.rdf.URI}, the value to remove
	 * @see			#predicateProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removePredicate(org.openanzo.rdf.URI predicate) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'predicate'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#predicateProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearPredicate(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Iterates through the 'subject' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.URI}
	 * @see			#subjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.URI> getSubject() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Iterates through the 'subject' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.URI}
	 * @see			#subjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.URI> getSubject(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Add a 'subject' property value
	 * @param	subject	{@link org.openanzo.rdf.URI}, the value to add
	 * @see			#subjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addSubject(org.openanzo.rdf.URI subject) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Remove a 'subject' property value. This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	subject	{@link org.openanzo.rdf.URI}, the value to remove
	 * @see			#subjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeSubject(org.openanzo.rdf.URI subject) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'subject'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#subjectProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSubject(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}