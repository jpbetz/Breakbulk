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
 * Interface for LdapConfiguration ontology class<br>
 * Use the org.openanzo.ontologies.system.SystemFactory to create instances of this interface.
 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#LdapConfiguration)</p>
 * <br>
 * <br>
 * <br>
 */
 @SuppressWarnings("all")
public interface LdapConfiguration extends 
org.openanzo.ontologies.system.NetworkComponent, org.openanzo.rdf.jastor.Thing {
	
	/**
	 * The rdf:type for this ontology class
     */
	public static final org.openanzo.rdf.URI TYPE = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#LdapConfiguration");
	

	/**
	 * The Anzo Property for dnToUriTemplate 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#dnToUriTemplate)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI dnToUriTemplateProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#dnToUriTemplate");


	/**
	 * The Anzo Property for ldapCN 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#ldapCN)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Ldap Common Name. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI ldapCNProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#ldapCN");


	/**
	 * The Anzo Property for ldapId 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#ldapId)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Ldap Host ID. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI ldapIdProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#ldapId");


	/**
	 * The Anzo Property for ldapInitFile 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#ldapInitFile)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Ldap Init File. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI ldapInitFileProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#ldapInitFile");


	/**
	 * The Anzo Property for ldapInternalCredentials 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#ldapInternalCredentials)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Ldap Organization. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI ldapInternalCredentialsProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#ldapInternalCredentials");


	/**
	 * The Anzo Property for ldapInternalPrincipal 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#ldapInternalPrincipal)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Ldap Organization. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI ldapInternalPrincipalProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#ldapInternalPrincipal");


	/**
	 * The Anzo Property for ldapO 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#ldapO)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Ldap Organization. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI ldapOProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#ldapO");


	/**
	 * The Anzo Property for ldapSearchBaseDN 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#ldapSearchBaseDN)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Ldap Search Base DN. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI ldapSearchBaseDNProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#ldapSearchBaseDN");


	/**
	 * The Anzo Property for ldapSuffix 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#ldapSuffix)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Ldap Suffix. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI ldapSuffixProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#ldapSuffix");


	/**
	 * The Anzo Property for ldapUseInternal 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#ldapUseInternal)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Use an internal ldap server. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI ldapUseInternalProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#ldapUseInternal");


	/**
	 * The Anzo Property for roleBaseDN 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#roleBaseDN)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI roleBaseDNProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#roleBaseDN");


	/**
	 * The Anzo Property for rolesSearch 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#rolesSearch)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI rolesSearchProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#rolesSearch");


	/**
	 * The Anzo Property for sysadminRole 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#sysadminRole)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI sysadminRoleProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#sysadminRole");


	/**
	 * The Anzo Property for userBaseDN 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#userBaseDN)</p>
	 * <br>
	 * <br>
	 * RDF Schema Standard Properties <br>
	 * 	comment : Ldap Search Base DN. <br>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI userBaseDNProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#userBaseDN");


	/**
	 * The Anzo Property for userIdAttribute 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#userIdAttribute)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI userIdAttributeProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#userIdAttribute");


	/**
	 * The Anzo Property for userSearch 
	 * <p>(URI: http://openanzo.org/ontologies/2008/07/System#userSearch)</p>
	 * <br>  
	 */
	public static org.openanzo.rdf.URI userSearchProperty = org.openanzo.rdf.jastor.ThingFactory.valueFactory.createURI("http://openanzo.org/ontologies/2008/07/System#userSearch");




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
	/**
	 * Gets the 'dnToUriTemplate' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#dnToUriTemplateProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getDnToUriTemplate() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'dnToUriTemplate' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#dnToUriTemplateProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getDnToUriTemplate(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'dnToUriTemplate' property value
	 * @param	dnToUriTemplate	{@link java.lang.String}, the value to set
	 * @see			#dnToUriTemplateProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setDnToUriTemplate(java.lang.String dnToUriTemplate) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'dnToUriTemplate'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#dnToUriTemplateProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearDnToUriTemplate(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'ldapCN' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#ldapCNProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getLdapCN() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'ldapCN' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#ldapCNProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getLdapCN(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'ldapCN' property value
	 * @param	ldapCN	{@link java.lang.String}, the value to set
	 * @see			#ldapCNProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setLdapCN(java.lang.String ldapCN) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'ldapCN'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#ldapCNProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearLdapCN(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'ldapId' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#ldapIdProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getLdapId() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'ldapId' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#ldapIdProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getLdapId(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'ldapId' property value
	 * @param	ldapId	{@link java.lang.String}, the value to set
	 * @see			#ldapIdProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setLdapId(java.lang.String ldapId) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'ldapId'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#ldapIdProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearLdapId(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'ldapInitFile' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#ldapInitFileProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getLdapInitFile() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'ldapInitFile' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#ldapInitFileProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getLdapInitFile(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'ldapInitFile' property value
	 * @param	ldapInitFile	{@link java.lang.String}, the value to set
	 * @see			#ldapInitFileProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setLdapInitFile(java.lang.String ldapInitFile) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'ldapInitFile'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#ldapInitFileProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearLdapInitFile(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'ldapInternalCredentials' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#ldapInternalCredentialsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getLdapInternalCredentials() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'ldapInternalCredentials' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#ldapInternalCredentialsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getLdapInternalCredentials(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'ldapInternalCredentials' property value
	 * @param	ldapInternalCredentials	{@link java.lang.String}, the value to set
	 * @see			#ldapInternalCredentialsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setLdapInternalCredentials(java.lang.String ldapInternalCredentials) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'ldapInternalCredentials'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#ldapInternalCredentialsProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearLdapInternalCredentials(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'ldapInternalPrincipal' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#ldapInternalPrincipalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getLdapInternalPrincipal() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'ldapInternalPrincipal' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#ldapInternalPrincipalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getLdapInternalPrincipal(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'ldapInternalPrincipal' property value
	 * @param	ldapInternalPrincipal	{@link java.lang.String}, the value to set
	 * @see			#ldapInternalPrincipalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setLdapInternalPrincipal(java.lang.String ldapInternalPrincipal) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'ldapInternalPrincipal'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#ldapInternalPrincipalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearLdapInternalPrincipal(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'ldapO' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#ldapOProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getLdapO() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'ldapO' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#ldapOProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getLdapO(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'ldapO' property value
	 * @param	ldapO	{@link java.lang.String}, the value to set
	 * @see			#ldapOProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setLdapO(java.lang.String ldapO) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'ldapO'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#ldapOProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearLdapO(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'ldapSearchBaseDN' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#ldapSearchBaseDNProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getLdapSearchBaseDN() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'ldapSearchBaseDN' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#ldapSearchBaseDNProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getLdapSearchBaseDN(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'ldapSearchBaseDN' property value
	 * @param	ldapSearchBaseDN	{@link java.lang.String}, the value to set
	 * @see			#ldapSearchBaseDNProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setLdapSearchBaseDN(java.lang.String ldapSearchBaseDN) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'ldapSearchBaseDN'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#ldapSearchBaseDNProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearLdapSearchBaseDN(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'ldapSuffix' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#ldapSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getLdapSuffix() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'ldapSuffix' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#ldapSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getLdapSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'ldapSuffix' property value
	 * @param	ldapSuffix	{@link java.lang.String}, the value to set
	 * @see			#ldapSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setLdapSuffix(java.lang.String ldapSuffix) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'ldapSuffix'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#ldapSuffixProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearLdapSuffix(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'ldapUseInternal' property value from the given graph
	 * @return		{@link java.lang.Boolean}
	 * @see			#ldapUseInternalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getLdapUseInternal() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'ldapUseInternal' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.Boolean}
	 * @see			#ldapUseInternalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.Boolean getLdapUseInternal(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'ldapUseInternal' property value
	 * @param	ldapUseInternal	{@link java.lang.Boolean}, the value to set
	 * @see			#ldapUseInternalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setLdapUseInternal(java.lang.Boolean ldapUseInternal) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'ldapUseInternal'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#ldapUseInternalProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearLdapUseInternal(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'roleBaseDN' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#roleBaseDNProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getRoleBaseDN() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'roleBaseDN' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#roleBaseDNProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getRoleBaseDN(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'roleBaseDN' property value
	 * @param	roleBaseDN	{@link java.lang.String}, the value to set
	 * @see			#roleBaseDNProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setRoleBaseDN(java.lang.String roleBaseDN) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'roleBaseDN'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#roleBaseDNProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearRoleBaseDN(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'rolesSearch' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#rolesSearchProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getRolesSearch() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'rolesSearch' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#rolesSearchProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getRolesSearch(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'rolesSearch' property value
	 * @param	rolesSearch	{@link java.lang.String}, the value to set
	 * @see			#rolesSearchProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setRolesSearch(java.lang.String rolesSearch) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'rolesSearch'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#rolesSearchProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearRolesSearch(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'sysadminRole' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#sysadminRoleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getSysadminRole() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'sysadminRole' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#sysadminRoleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getSysadminRole(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'sysadminRole' property value
	 * @param	sysadminRole	{@link java.lang.String}, the value to set
	 * @see			#sysadminRoleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setSysadminRole(java.lang.String sysadminRole) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'sysadminRole'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#sysadminRoleProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearSysadminRole(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'userBaseDN' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#userBaseDNProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getUserBaseDN() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'userBaseDN' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#userBaseDNProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getUserBaseDN(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'userBaseDN' property value
	 * @param	userBaseDN	{@link java.lang.String}, the value to set
	 * @see			#userBaseDNProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setUserBaseDN(java.lang.String userBaseDN) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'userBaseDN'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#userBaseDNProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearUserBaseDN(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'userIdAttribute' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#userIdAttributeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getUserIdAttribute() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'userIdAttribute' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#userIdAttributeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getUserIdAttribute(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'userIdAttribute' property value
	 * @param	userIdAttribute	{@link java.lang.String}, the value to set
	 * @see			#userIdAttributeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setUserIdAttribute(java.lang.String userIdAttribute) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'userIdAttribute'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#userIdAttributeProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearUserIdAttribute(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;
	/**
	 * Gets the 'userSearch' property value from the given graph
	 * @return		{@link java.lang.String}
	 * @see			#userSearchProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getUserSearch() throws org.openanzo.rdf.jastor.JastorException;
	
	/**
	 * Gets the 'userSearch' property value
	 * @param 		includeEntireDataset Get the properties from the entire dataset, and not just the namedgraph
	 * @return		{@link java.lang.String}
	 * @see			#userSearchProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public java.lang.String getUserSearch(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

	/**
	 * Sets the 'userSearch' property value
	 * @param	userSearch	{@link java.lang.String}, the value to set
	 * @see			#userSearchProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void setUserSearch(java.lang.String userSearch) throws org.openanzo.rdf.jastor.JastorException;

/**
	 * Clears all values for 'userSearch'. 
	 * @param 		includeEntireDataset Delete the properties from the entire dataset, and not just the namedgraph
	 * @see			#userSearchProperty
	 * @throws org.openanzo.rdf.jastor.JastorException
	 */
	public void clearUserSearch(boolean includeEntireDataset) throws org.openanzo.rdf.jastor.JastorException;

}