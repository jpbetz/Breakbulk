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
 * Interface for Class ontology class<br>
 * Use the org.openanzo.rdf.owl.OWL11Factory to create instances of this interface.
 * <p>(URI: http://www.w3.org/2002/07/owl#Class)</p>
 * <br>
 * <br>
 * <br>
 */
public interface Class extends 
org.openanzo.rdf.rdfs.Class, org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#Class");
	

	/**
	 * The Anzo Property for oneOf 
	 * <p>(URI: http://www.w3.org/2002/07/owl#oneOf)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI oneOfProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#oneOf");


	/**
	 * The Anzo Property for disjointWith 
	 * <p>(URI: http://www.w3.org/2002/07/owl#disjointWith)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI disjointWithProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#disjointWith");


	/**
	 * The Anzo Property for equivalentClass 
	 * <p>(URI: http://www.w3.org/2002/07/owl#equivalentClass)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI equivalentClassProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#equivalentClass");


	/**
	 * The Anzo Property for intersectionOf 
	 * <p>(URI: http://www.w3.org/2002/07/owl#intersectionOf)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI intersectionOfProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#intersectionOf");


	/**
	 * The Anzo Property for unionOf 
	 * <p>(URI: http://www.w3.org/2002/07/owl#unionOf)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI unionOfProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2002/07/owl#unionOf");


	/**
	 * The Anzo Property for disjointUnionOf 
	 * <p>(URI: http://www.w3.org/2006/12/owl11#disjointUnionOf)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI disjointUnionOfProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://www.w3.org/2006/12/owl11#disjointUnionOf");


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
	 * Individual for URI: http://www.w3.org/2006/12/owl11#IrreflexiveProperty
	 */
	public static org.openanzo.rdf.URI IrreflexiveProperty = org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#IrreflexiveProperty");


	/**
	 * Individual for URI: http://www.w3.org/2006/12/owl11#ObjectRestriction
	 */
	public static org.openanzo.rdf.URI ObjectRestriction = org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#ObjectRestriction");


	/**
	 * Individual for URI: http://www.w3.org/2006/12/owl11#AntisymmetricProperty
	 */
	public static org.openanzo.rdf.URI AntisymmetricProperty = org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#AntisymmetricProperty");


	/**
	 * Individual for URI: http://www.w3.org/2006/12/owl11#DataRestriction
	 */
	public static org.openanzo.rdf.URI DataRestriction = org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#DataRestriction");


	/**
	 * Individual for URI: http://www.w3.org/2006/12/owl11#ReflexiveProperty
	 */
	public static org.openanzo.rdf.URI ReflexiveProperty = org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#ReflexiveProperty");


	/**
	 * Individual for URI: http://www.w3.org/2006/12/owl11#FunctionalObjectProperty
	 */
	public static org.openanzo.rdf.URI FunctionalObjectProperty = org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#FunctionalObjectProperty");


	/**
	 * Individual for URI: http://www.w3.org/2006/12/owl11#FunctionalDataPropety
	 */
	public static org.openanzo.rdf.URI FunctionalDataPropety = org.openanzo.rdf.MemURI.create("http://www.w3.org/2006/12/owl11#FunctionalDataPropety");



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
	 * Removes a value for the 'subClassOf' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	subClassOf	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#subClassOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeSubClassOf(org.openanzo.rdf.Resource subClassOf) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'subClassOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#subClassOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSubClassOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'oneOf' property value
	 * @return		{@link org.openanzo.rdf.jastor.Thing}
	 * @see			#oneOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing getOneOf() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'oneOf' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.rdf.jastor.Thing}
	 * @see			#oneOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing getOneOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'oneOf' property value
	 * @param	oneOf	{@link org.openanzo.rdf.jastor.Thing}, value to set
	 * @see			#oneOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setOneOf(org.openanzo.rdf.jastor.Thing oneOf) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'oneOf' property value to an anonymous node
	 * @return		{@link org.openanzo.rdf.jastor.Thing}, the created value
	 * @see			#oneOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.rdf.jastor.Thing setOneOf() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'oneOf' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.Thing} with the factory.
	 * and calling setOneOf(org.openanzo.rdf.jastor.Thing oneOf)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.rdf.jastor.Thing}, the newly created value
	 * @see			#oneOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing setOneOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'oneOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#oneOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearOneOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'disjointWith' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.owl.Class}
	 * @see			#disjointWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.owl.Class> getDisjointWith() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'disjointWith' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.owl.Class}
	 * @see			#disjointWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.owl.Class> getDisjointWith(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'disjointWith' property
	 * @param	disjointWith	The {@link org.openanzo.rdf.owl.Class} to add
	 * @see			#disjointWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addDisjointWith(org.openanzo.rdf.owl.Class disjointWith) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'disjointWith' property
	 * @return		The anoymous {@link org.openanzo.rdf.owl.Class} created
	 * @see			#disjointWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.Class addDisjointWith() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'disjointWith' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.owl.Class} with the factory
	 * and calling addDisjointWith(org.openanzo.rdf.owl.Class disjointWith)
	 * The resource argument have rdf:type http://www.w3.org/2002/07/owl#Class.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.rdf.owl.Class, value added
	 * @see			#disjointWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.Class addDisjointWith(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'disjointWith' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	disjointWith	The {@link org.openanzo.rdf.owl.Class} to remove
	 * @see			#disjointWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDisjointWith(org.openanzo.rdf.owl.Class disjointWith) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'disjointWith' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	disjointWith	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#disjointWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDisjointWith(org.openanzo.rdf.Resource disjointWith) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'disjointWith'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#disjointWithProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDisjointWith(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'equivalentClass' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.owl.Class}
	 * @see			#equivalentClassProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.owl.Class> getEquivalentClass() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'equivalentClass' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.owl.Class}
	 * @see			#equivalentClassProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.owl.Class> getEquivalentClass(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'equivalentClass' property
	 * @param	equivalentClass	The {@link org.openanzo.rdf.owl.Class} to add
	 * @see			#equivalentClassProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addEquivalentClass(org.openanzo.rdf.owl.Class equivalentClass) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'equivalentClass' property
	 * @return		The anoymous {@link org.openanzo.rdf.owl.Class} created
	 * @see			#equivalentClassProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.Class addEquivalentClass() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'equivalentClass' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.owl.Class} with the factory
	 * and calling addEquivalentClass(org.openanzo.rdf.owl.Class equivalentClass)
	 * The resource argument have rdf:type http://www.w3.org/2002/07/owl#Class.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.rdf.owl.Class, value added
	 * @see			#equivalentClassProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.Class addEquivalentClass(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'equivalentClass' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	equivalentClass	The {@link org.openanzo.rdf.owl.Class} to remove
	 * @see			#equivalentClassProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeEquivalentClass(org.openanzo.rdf.owl.Class equivalentClass) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'equivalentClass' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	equivalentClass	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#equivalentClassProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeEquivalentClass(org.openanzo.rdf.Resource equivalentClass) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'equivalentClass'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#equivalentClassProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearEquivalentClass(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'intersectionOf' property value
	 * @return		{@link org.openanzo.rdf.jastor.Thing}
	 * @see			#intersectionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing getIntersectionOf() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'intersectionOf' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.rdf.jastor.Thing}
	 * @see			#intersectionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing getIntersectionOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'intersectionOf' property value
	 * @param	intersectionOf	{@link org.openanzo.rdf.jastor.Thing}, value to set
	 * @see			#intersectionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setIntersectionOf(org.openanzo.rdf.jastor.Thing intersectionOf) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'intersectionOf' property value to an anonymous node
	 * @return		{@link org.openanzo.rdf.jastor.Thing}, the created value
	 * @see			#intersectionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.rdf.jastor.Thing setIntersectionOf() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'intersectionOf' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.Thing} with the factory.
	 * and calling setIntersectionOf(org.openanzo.rdf.jastor.Thing intersectionOf)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.rdf.jastor.Thing}, the newly created value
	 * @see			#intersectionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing setIntersectionOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'intersectionOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#intersectionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearIntersectionOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'unionOf' property value
	 * @return		{@link org.openanzo.rdf.jastor.Thing}
	 * @see			#unionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing getUnionOf() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'unionOf' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link org.openanzo.rdf.jastor.Thing}
	 * @see			#unionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing getUnionOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'unionOf' property value
	 * @param	unionOf	{@link org.openanzo.rdf.jastor.Thing}, value to set
	 * @see			#unionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setUnionOf(org.openanzo.rdf.jastor.Thing unionOf) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'unionOf' property value to an anonymous node
	 * @return		{@link org.openanzo.rdf.jastor.Thing}, the created value
	 * @see			#unionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */	
	public org.openanzo.rdf.jastor.Thing setUnionOf() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Sets the 'unionOf' property value to the given resource, and add's rdf:type properties.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.jastor.Thing} with the factory.
	 * and calling setUnionOf(org.openanzo.rdf.jastor.Thing unionOf)
	 * The resource argument have rdf:type http://www.w3.org/2000/01/rdf-schema#Resource.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	{@link org.openanzo.rdf.Resource} must not be be null.
	 * @return		{@link org.openanzo.rdf.jastor.Thing}, the newly created value
	 * @see			#unionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.jastor.Thing setUnionOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
/**
	 * Clears all values for 'unionOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#unionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearUnionOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Get an Iterator the 'disjointUnionOf' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.owl.Class}
	 * @see			#disjointUnionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.owl.Class> getDisjointUnionOf() throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Get an Iterator the 'disjointUnionOf' property values.  This Iteartor
	 * may be used to remove all such values.
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.util.Collection} of {@link org.openanzo.rdf.owl.Class}
	 * @see			#disjointUnionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.util.Collection<org.openanzo.rdf.owl.Class> getDisjointUnionOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	

	/**
	 * Adds a value for the 'disjointUnionOf' property
	 * @param	disjointUnionOf	The {@link org.openanzo.rdf.owl.Class} to add
	 * @see			#disjointUnionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void addDisjointUnionOf(org.openanzo.rdf.owl.Class disjointUnionOf) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds an anonymous value for the 'disjointUnionOf' property
	 * @return		The anoymous {@link org.openanzo.rdf.owl.Class} created
	 * @see			#disjointUnionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.Class addDisjointUnionOf() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Adds a value for the 'disjointUnionOf' property.  This
	 * method is equivalent constructing a new instance of {@link org.openanzo.rdf.owl.Class} with the factory
	 * and calling addDisjointUnionOf(org.openanzo.rdf.owl.Class disjointUnionOf)
	 * The resource argument have rdf:type http://www.w3.org/2002/07/owl#Class.  That is, this method
	 * should not be used as a shortcut for creating new objects in the model.
	 * @param	resource	The {@link org.openanzo.rdf.Resource} to add
	 * @return org.openanzo.rdf.owl.Class, value added
	 * @see			#disjointUnionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public org.openanzo.rdf.owl.Class addDisjointUnionOf(org.openanzo.rdf.Resource resource) throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Removes a value for the 'disjointUnionOf' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	disjointUnionOf	The {@link org.openanzo.rdf.owl.Class} to remove
	 * @see			#disjointUnionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDisjointUnionOf(org.openanzo.rdf.owl.Class disjointUnionOf) throws org.openanzo.rdf.jastor.JastorException;

		
	/**
	 * Removes a value for the 'disjointUnionOf' property.  This method should not
	 * be invoked while iterator through values.  In that case, the remove() method of the Iterator
	 * itself should be used.
	 * @param	disjointUnionOf	The {@link org.openanzo.rdf.Resource} to remove
	 * @see			#disjointUnionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void removeDisjointUnionOf(org.openanzo.rdf.Resource disjointUnionOf) throws org.openanzo.rdf.jastor.JastorException;


/**
	 * Clears all values for 'disjointUnionOf'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#disjointUnionOfProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDisjointUnionOf(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}