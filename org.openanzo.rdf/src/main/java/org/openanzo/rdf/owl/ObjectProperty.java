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
 * Interface for ObjectProperty ontology class<br>
 * Use the org.openanzo.rdf.owl.OWL11Factory to create instances of this interface.
 * <p>(URI: http://www.w3.org/2002/07/owl#ObjectProperty)</p>
 * <br>
 * <br>
 * <br>
 */
public interface ObjectProperty extends 
org.openanzo.rdf.rdfs._Property, org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#ObjectProperty");
	

	/**
	 * The Anzo Property for inverseOf 
	 * <p>(URI: http://www.w3.org/2002/07/owl#inverseOf)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI inverseOfProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#inverseOf");


	/**
	 * The Anzo Property for disjointObjectProperties 
	 * <p>(URI: http://www.w3.org/2006/12/owl11#disjointObjectProperties)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI disjointObjectPropertiesProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2006/12/owl11#disjointObjectProperties");


	/**
	 * The Anzo Property for equivalentObjectProperty 
	 * <p>(URI: http://www.w3.org/2006/12/owl11#equivalentObjectProperty)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI equivalentObjectPropertyProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2006/12/owl11#equivalentObjectProperty");


	/**
	 * The Anzo Property for objectPropertyDomain 
	 * <p>(URI: http://www.w3.org/2006/12/owl11#objectPropertyDomain)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI objectPropertyDomainProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2006/12/owl11#objectPropertyDomain");


	/**
	 * The Anzo Property for objectPropertyRange 
	 * <p>(URI: http://www.w3.org/2006/12/owl11#objectPropertyRange)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI objectPropertyRangeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2006/12/owl11#objectPropertyRange");


	/**
	 * The Anzo Property for subObjectPropertyOf 
	 * <p>(URI: http://www.w3.org/2006/12/owl11#subObjectPropertyOf)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI subObjectPropertyOfProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2006/12/owl11#subObjectPropertyOf");


	/**
	 * The Anzo Property for value 
	 * <p>(URI: http://www.w3.org/1999/02/22-rdf-syntax-ns#value)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	label : value <br>
	 * 	comment : Idiomatic property used for structured values. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI valueProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/1999/02/22-rdf-syntax-ns#value");


	/**
	 * The Anzo Property for member 
	 * <p>(URI: http://www.w3.org/2000/01/rdf-schema#member)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	label : member <br>
	 * 	comment : A member of the subject resource. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI memberProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2000/01/rdf-schema#member");


	/**
	 * The Anzo Property for type 
	 * <p>(URI: http://www.w3.org/1999/02/22-rdf-syntax-ns#type)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	label : type <br>
	 * 	comment : The subject is an instance of a class. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI typeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type");


	/**
	 * The Anzo Property for comment 
	 * <p>(URI: http://www.w3.org/2000/01/rdf-schema#comment)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	label : comment <br>
	 * 	comment : A description of the subject resource. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI commentProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2000/01/rdf-schema#comment");


	/**
	 * The Anzo Property for isDefinedBy 
	 * <p>(URI: http://www.w3.org/2000/01/rdf-schema#isDefinedBy)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	label : isDefinedBy <br>
	 * 	comment : The defininition of the subject resource. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI isDefinedByProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2000/01/rdf-schema#isDefinedBy");


	/**
	 * The Anzo Property for seeAlso 
	 * <p>(URI: http://www.w3.org/2000/01/rdf-schema#seeAlso)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	label : seeAlso <br>
	 * 	comment : Further information about the subject resource. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI seeAlsoProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2000/01/rdf-schema#seeAlso");


	/**
	 * The Anzo Property for label 
	 * <p>(URI: http://www.w3.org/2000/01/rdf-schema#label)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	label : label <br>
	 * 	comment : A human-readable name for the subject. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI labelProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2000/01/rdf-schema#label");



	/**
	 * Individual for URI: http://www.w3.org/2006/12/owl11#disjointUnionOf
	 */
	public static org.openanzo.rdf.URI disjointUnionOf = org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#disjointUnionOf");


	/**
	 * Individual for URI: http://www.w3.org/2006/12/owl11#disjointDataProperties
	 */
	public static org.openanzo.rdf.URI disjointDataProperties = org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#disjointDataProperties");


	/**
	 * Individual for URI: http://www.w3.org/2006/12/owl11#onClass
	 */
	public static org.openanzo.rdf.URI onClass = org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#onClass");


	/**
	 * Individual for URI: http://www.w3.org/2006/12/owl11#equivalentDataProperty
	 */
	public static org.openanzo.rdf.URI equivalentDataProperty = org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#equivalentDataProperty");


	/**
	 * Individual for URI: http://www.w3.org/2006/12/owl11#dataPropertyRange
	 */
	public static org.openanzo.rdf.URI dataPropertyRange = org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#dataPropertyRange");


	/**
	 * Individual for URI: http://www.w3.org/2006/12/owl11#subObjectPropertyOf
	 */
	public static org.openanzo.rdf.URI subObjectPropertyOf = org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#subObjectPropertyOf");


	/**
	 * Individual for URI: http://www.w3.org/2006/12/owl11#equivalentObjectProperty
	 */
	public static org.openanzo.rdf.URI equivalentObjectProperty = org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#equivalentObjectProperty");


	/**
	 * Individual for URI: http://www.w3.org/2006/12/owl11#subDataPropertyOf
	 */
	public static org.openanzo.rdf.URI subDataPropertyOf = org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#subDataPropertyOf");


	/**
	 * Individual for URI: http://www.w3.org/2006/12/owl11#objectPropertyDomain
	 */
	public static org.openanzo.rdf.URI objectPropertyDomain = org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#objectPropertyDomain");


	/**
	 * Individual for URI: http://www.w3.org/2006/12/owl11#objectPropertyRange
	 */
	public static org.openanzo.rdf.URI objectPropertyRange = org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#objectPropertyRange");


	/**
	 * Individual for URI: http://www.w3.org/2006/12/owl11#dataPropertyDomain
	 */
	public static org.openanzo.rdf.URI dataPropertyDomain = org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#dataPropertyDomain");


	/**
	 * Individual for URI: owl11xml:Imports
	 */
	public static org.openanzo.rdf.URI Imports = org.openanzo.rdf.MemURI.create("owl11xml:Imports");


	/**
	 * Individual for URI: http://www.w3.org/2006/12/owl11#disjointObjectProperties
	 */
	public static org.openanzo.rdf.URI disjointObjectProperties = org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#disjointObjectProperties");


	/**
	 * Individual for URI: http://www.w3.org/2006/12/owl11#onDataRange
	 */
	public static org.openanzo.rdf.URI onDataRange = org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#onDataRange");



/**
	 * Clears all values for 'comment'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#commentProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearComment(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'label'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#labelProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearLabel(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'type' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	type	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#typeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeType(org.openanzo.rdf.Resource type) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'type'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#typeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearType(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'value' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	value	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#valueProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeValue(org.openanzo.rdf.Resource value) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'value'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#valueProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearValue(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'isDefinedBy' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	isDefinedBy	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#isDefinedByProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeIsDefinedBy(org.openanzo.rdf.Resource isDefinedBy) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'isDefinedBy'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#isDefinedByProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearIsDefinedBy(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
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
		
	/**
	 * Removes a value for the 'seeAlso' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	seeAlso	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#seeAlsoProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeSeeAlso(org.openanzo.rdf.Resource seeAlso) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'seeAlso'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#seeAlsoProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSeeAlso(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'domain'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#domainProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDomain(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
/**
	 * Clears all values for 'range'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#rangeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearRange(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
		
	/**
	 * Removes a value for the 'subPropertyOf' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	subPropertyOf	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#subPropertyOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeSubPropertyOf(org.openanzo.rdf.Resource subPropertyOf) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'subPropertyOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#subPropertyOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSubPropertyOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'inverseOf' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.owl.ObjectProperty}
	 * @see			#inverseOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.owl.ObjectProperty> getInverseOf() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'inverseOf' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.owl.ObjectProperty}
	 * @see			#inverseOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.owl.ObjectProperty> getInverseOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'inverseOf' property
	 * @param	inverseOf	The {@link org.openanzo.rdf.owl.ObjectProperty} to add
	 * @see			#inverseOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addInverseOf(org.openanzo.rdf.owl.ObjectProperty inverseOf) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'inverseOf' property
	 * @return		The anoymous {@link org.openanzo.rdf.owl.ObjectProperty} created
	 * @see			#inverseOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.ObjectProperty addInverseOf() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'inverseOf' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.owl.ObjectProperty} with the factory
	 * and calling addInverseOf(org.openanzo.rdf.owl.ObjectProperty inverseOf)
	 * The resource argument have rdf:type http://www.w3.org/2002/07/owl#ObjectProperty.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.rdf.owl.ObjectProperty, value added
	 * @see			#inverseOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.ObjectProperty addInverseOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'inverseOf' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	inverseOf	The {@link org.openanzo.rdf.owl.ObjectProperty} to remove
	 * @see			#inverseOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeInverseOf(org.openanzo.rdf.owl.ObjectProperty inverseOf) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'inverseOf' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	inverseOf	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#inverseOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeInverseOf(org.openanzo.rdf.Resource inverseOf) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'inverseOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#inverseOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearInverseOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'disjointObjectProperties' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.owl.ObjectProperty}
	 * @see			#disjointObjectPropertiesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.owl.ObjectProperty> getDisjointObjectProperties() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'disjointObjectProperties' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.owl.ObjectProperty}
	 * @see			#disjointObjectPropertiesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.owl.ObjectProperty> getDisjointObjectProperties(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'disjointObjectProperties' property
	 * @param	disjointObjectProperties	The {@link org.openanzo.rdf.owl.ObjectProperty} to add
	 * @see			#disjointObjectPropertiesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addDisjointObjectProperties(org.openanzo.rdf.owl.ObjectProperty disjointObjectProperties) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'disjointObjectProperties' property
	 * @return		The anoymous {@link org.openanzo.rdf.owl.ObjectProperty} created
	 * @see			#disjointObjectPropertiesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.ObjectProperty addDisjointObjectProperties() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'disjointObjectProperties' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.owl.ObjectProperty} with the factory
	 * and calling addDisjointObjectProperties(org.openanzo.rdf.owl.ObjectProperty disjointObjectProperties)
	 * The resource argument have rdf:type http://www.w3.org/2002/07/owl#ObjectProperty.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.rdf.owl.ObjectProperty, value added
	 * @see			#disjointObjectPropertiesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.ObjectProperty addDisjointObjectProperties(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'disjointObjectProperties' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	disjointObjectProperties	The {@link org.openanzo.rdf.owl.ObjectProperty} to remove
	 * @see			#disjointObjectPropertiesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDisjointObjectProperties(org.openanzo.rdf.owl.ObjectProperty disjointObjectProperties) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'disjointObjectProperties' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	disjointObjectProperties	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#disjointObjectPropertiesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDisjointObjectProperties(org.openanzo.rdf.Resource disjointObjectProperties) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'disjointObjectProperties'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#disjointObjectPropertiesProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDisjointObjectProperties(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'equivalentObjectProperty' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.owl.ObjectProperty}
	 * @see			#equivalentObjectPropertyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.owl.ObjectProperty> getEquivalentObjectProperty() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'equivalentObjectProperty' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.owl.ObjectProperty}
	 * @see			#equivalentObjectPropertyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.owl.ObjectProperty> getEquivalentObjectProperty(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'equivalentObjectProperty' property
	 * @param	equivalentObjectProperty	The {@link org.openanzo.rdf.owl.ObjectProperty} to add
	 * @see			#equivalentObjectPropertyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addEquivalentObjectProperty(org.openanzo.rdf.owl.ObjectProperty equivalentObjectProperty) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'equivalentObjectProperty' property
	 * @return		The anoymous {@link org.openanzo.rdf.owl.ObjectProperty} created
	 * @see			#equivalentObjectPropertyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.ObjectProperty addEquivalentObjectProperty() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'equivalentObjectProperty' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.owl.ObjectProperty} with the factory
	 * and calling addEquivalentObjectProperty(org.openanzo.rdf.owl.ObjectProperty equivalentObjectProperty)
	 * The resource argument have rdf:type http://www.w3.org/2002/07/owl#ObjectProperty.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.rdf.owl.ObjectProperty, value added
	 * @see			#equivalentObjectPropertyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.ObjectProperty addEquivalentObjectProperty(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'equivalentObjectProperty' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	equivalentObjectProperty	The {@link org.openanzo.rdf.owl.ObjectProperty} to remove
	 * @see			#equivalentObjectPropertyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeEquivalentObjectProperty(org.openanzo.rdf.owl.ObjectProperty equivalentObjectProperty) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'equivalentObjectProperty' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	equivalentObjectProperty	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#equivalentObjectPropertyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeEquivalentObjectProperty(org.openanzo.rdf.Resource equivalentObjectProperty) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'equivalentObjectProperty'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#equivalentObjectPropertyProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearEquivalentObjectProperty(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'objectPropertyDomain' property value
	 * @return		{@link org.openanzo.rdf.owl.Class}
	 * @see			#objectPropertyDomainProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.Class getObjectPropertyDomain() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'objectPropertyDomain' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.rdf.owl.Class}
	 * @see			#objectPropertyDomainProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.Class getObjectPropertyDomain(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'objectPropertyDomain' property value
	 * @param	objectPropertyDomain	{@link org.openanzo.rdf.owl.Class}, value to set
	 * @see			#objectPropertyDomainProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setObjectPropertyDomain(org.openanzo.rdf.owl.Class objectPropertyDomain) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'objectPropertyDomain' property value to an anonymous node
	 * @return		{@link org.openanzo.rdf.owl.Class}, the created value
	 * @see			#objectPropertyDomainProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.rdf.owl.Class setObjectPropertyDomain() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'objectPropertyDomain' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.owl.Class} with the factory.
	 * and calling setObjectPropertyDomain(org.openanzo.rdf.owl.Class objectPropertyDomain)
	 * The resource argument have rdf:type http://www.w3.org/2002/07/owl#Class.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.rdf.owl.Class}, the newly created value
	 * @see			#objectPropertyDomainProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.Class setObjectPropertyDomain(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'objectPropertyDomain'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#objectPropertyDomainProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearObjectPropertyDomain(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'objectPropertyRange' property value
	 * @return		{@link org.openanzo.rdf.owl.Class}
	 * @see			#objectPropertyRangeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.Class getObjectPropertyRange() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'objectPropertyRange' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.rdf.owl.Class}
	 * @see			#objectPropertyRangeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.Class getObjectPropertyRange(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'objectPropertyRange' property value
	 * @param	objectPropertyRange	{@link org.openanzo.rdf.owl.Class}, value to set
	 * @see			#objectPropertyRangeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setObjectPropertyRange(org.openanzo.rdf.owl.Class objectPropertyRange) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'objectPropertyRange' property value to an anonymous node
	 * @return		{@link org.openanzo.rdf.owl.Class}, the created value
	 * @see			#objectPropertyRangeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.rdf.owl.Class setObjectPropertyRange() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'objectPropertyRange' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.owl.Class} with the factory.
	 * and calling setObjectPropertyRange(org.openanzo.rdf.owl.Class objectPropertyRange)
	 * The resource argument have rdf:type http://www.w3.org/2002/07/owl#Class.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.rdf.owl.Class}, the newly created value
	 * @see			#objectPropertyRangeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.Class setObjectPropertyRange(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'objectPropertyRange'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#objectPropertyRangeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearObjectPropertyRange(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'subObjectPropertyOf' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.owl.ObjectProperty}
	 * @see			#subObjectPropertyOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.owl.ObjectProperty> getSubObjectPropertyOf() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'subObjectPropertyOf' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.owl.ObjectProperty}
	 * @see			#subObjectPropertyOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.owl.ObjectProperty> getSubObjectPropertyOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'subObjectPropertyOf' property
	 * @param	subObjectPropertyOf	The {@link org.openanzo.rdf.owl.ObjectProperty} to add
	 * @see			#subObjectPropertyOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addSubObjectPropertyOf(org.openanzo.rdf.owl.ObjectProperty subObjectPropertyOf) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'subObjectPropertyOf' property
	 * @return		The anoymous {@link org.openanzo.rdf.owl.ObjectProperty} created
	 * @see			#subObjectPropertyOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.ObjectProperty addSubObjectPropertyOf() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'subObjectPropertyOf' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.owl.ObjectProperty} with the factory
	 * and calling addSubObjectPropertyOf(org.openanzo.rdf.owl.ObjectProperty subObjectPropertyOf)
	 * The resource argument have rdf:type http://www.w3.org/2002/07/owl#ObjectProperty.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.rdf.owl.ObjectProperty, value added
	 * @see			#subObjectPropertyOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.ObjectProperty addSubObjectPropertyOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'subObjectPropertyOf' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	subObjectPropertyOf	The {@link org.openanzo.rdf.owl.ObjectProperty} to remove
	 * @see			#subObjectPropertyOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeSubObjectPropertyOf(org.openanzo.rdf.owl.ObjectProperty subObjectPropertyOf) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'subObjectPropertyOf' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	subObjectPropertyOf	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#subObjectPropertyOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeSubObjectPropertyOf(org.openanzo.rdf.Resource subObjectPropertyOf) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'subObjectPropertyOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#subObjectPropertyOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSubObjectPropertyOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}