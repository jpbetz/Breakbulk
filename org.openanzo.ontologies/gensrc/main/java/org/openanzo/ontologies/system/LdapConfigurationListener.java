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
 * Implementations of this listener may be registered with instances of org.openanzo.ontologies.system.LdapConfiguration to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface LdapConfigurationListener extends org.openanzo.rdf.jastor.ThingListener {


	/**
	 * Called when credentials has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 */
	public void credentialsChanged(org.openanzo.ontologies.system.LdapConfiguration source);

	/**
	 * Called when className has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 */
	public void classNameChanged(org.openanzo.ontologies.system.LdapConfiguration source);

	/**
	 * Called when enabled has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 */
	public void enabledChanged(org.openanzo.ontologies.system.LdapConfiguration source);

	/**
	 * Called when initOrder has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 */
	public void initOrderChanged(org.openanzo.ontologies.system.LdapConfiguration source);

	/**
	 * Called when a value of dependency has been added
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 * @param newValue the object representing the new value
	 */	
	public void dependencyAdded(org.openanzo.ontologies.system.LdapConfiguration source, org.openanzo.ontologies.system.Component newValue);

	/**
	 * Called when a value of dependency has been removed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 * @param oldValue the object representing the removed value
	 */
	public void dependencyRemoved(org.openanzo.ontologies.system.LdapConfiguration source, org.openanzo.ontologies.system.Component oldValue);
		
	/**
	 * Called when networkTimeout has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 */
	public void networkTimeoutChanged(org.openanzo.ontologies.system.LdapConfiguration source);

	/**
	 * Called when connection has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 */
	public void connectionChanged(org.openanzo.ontologies.system.LdapConfiguration source);

	/**
	 * Called when dnToUriTemplate has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 */
	public void dnToUriTemplateChanged(org.openanzo.ontologies.system.LdapConfiguration source);

	/**
	 * Called when ldapCN has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 */
	public void ldapCNChanged(org.openanzo.ontologies.system.LdapConfiguration source);

	/**
	 * Called when ldapId has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 */
	public void ldapIdChanged(org.openanzo.ontologies.system.LdapConfiguration source);

	/**
	 * Called when ldapInitFile has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 */
	public void ldapInitFileChanged(org.openanzo.ontologies.system.LdapConfiguration source);

	/**
	 * Called when ldapInternalCredentials has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 */
	public void ldapInternalCredentialsChanged(org.openanzo.ontologies.system.LdapConfiguration source);

	/**
	 * Called when ldapInternalPrincipal has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 */
	public void ldapInternalPrincipalChanged(org.openanzo.ontologies.system.LdapConfiguration source);

	/**
	 * Called when ldapO has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 */
	public void ldapOChanged(org.openanzo.ontologies.system.LdapConfiguration source);

	/**
	 * Called when ldapSearchBaseDN has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 */
	public void ldapSearchBaseDNChanged(org.openanzo.ontologies.system.LdapConfiguration source);

	/**
	 * Called when ldapSuffix has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 */
	public void ldapSuffixChanged(org.openanzo.ontologies.system.LdapConfiguration source);

	/**
	 * Called when ldapUseInternal has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 */
	public void ldapUseInternalChanged(org.openanzo.ontologies.system.LdapConfiguration source);

	/**
	 * Called when roleBaseDN has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 */
	public void roleBaseDNChanged(org.openanzo.ontologies.system.LdapConfiguration source);

	/**
	 * Called when rolesSearch has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 */
	public void rolesSearchChanged(org.openanzo.ontologies.system.LdapConfiguration source);

	/**
	 * Called when sysadminRole has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 */
	public void sysadminRoleChanged(org.openanzo.ontologies.system.LdapConfiguration source);

	/**
	 * Called when userBaseDN has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 */
	public void userBaseDNChanged(org.openanzo.ontologies.system.LdapConfiguration source);

	/**
	 * Called when userIdAttribute has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 */
	public void userIdAttributeChanged(org.openanzo.ontologies.system.LdapConfiguration source);

	/**
	 * Called when userSearch has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.LdapConfiguration
	 */
	public void userSearchChanged(org.openanzo.ontologies.system.LdapConfiguration source);

}