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
 * Implementations of this listener may be registered with instances of org.openanzo.ontologies.system.Datasource to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface DatasourceListener extends org.openanzo.rdf.jastor.ThingListener {


	/**
	 * Called when credentials has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Datasource
	 */
	public void credentialsChanged(org.openanzo.ontologies.system.Datasource source);

	/**
	 * Called when className has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Datasource
	 */
	public void classNameChanged(org.openanzo.ontologies.system.Datasource source);

	/**
	 * Called when enabled has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Datasource
	 */
	public void enabledChanged(org.openanzo.ontologies.system.Datasource source);

	/**
	 * Called when initOrder has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Datasource
	 */
	public void initOrderChanged(org.openanzo.ontologies.system.Datasource source);

	/**
	 * Called when a value of dependency has been added
	 * @param source the affected instance of org.openanzo.ontologies.system.Datasource
	 * @param newValue the object representing the new value
	 */	
	public void dependencyAdded(org.openanzo.ontologies.system.Datasource source, org.openanzo.ontologies.system.Component newValue);

	/**
	 * Called when a value of dependency has been removed
	 * @param source the affected instance of org.openanzo.ontologies.system.Datasource
	 * @param oldValue the object representing the removed value
	 */
	public void dependencyRemoved(org.openanzo.ontologies.system.Datasource source, org.openanzo.ontologies.system.Component oldValue);
		
	/**
	 * Called when a value of uriPattern has been added
	 * @param source the affected instance of org.openanzo.ontologies.system.Datasource
	 * @param newValue the object representing the new value
	 */	
	public void uriPatternAdded(org.openanzo.ontologies.system.Datasource source, java.lang.String newValue);

	/**
	 * Called when a value of uriPattern has been removed
	 * @param source the affected instance of org.openanzo.ontologies.system.Datasource
	 * @param oldValue the object representing the removed value
	 */	
	public void uriPatternRemoved(org.openanzo.ontologies.system.Datasource source, java.lang.String oldValue);

	/**
	 * Called when enableCaching has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Datasource
	 */
	public void enableCachingChanged(org.openanzo.ontologies.system.Datasource source);

	/**
	 * Called when enableIndexing has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Datasource
	 */
	public void enableIndexingChanged(org.openanzo.ontologies.system.Datasource source);

	/**
	 * Called when isPrimary has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Datasource
	 */
	public void isPrimaryChanged(org.openanzo.ontologies.system.Datasource source);

	/**
	 * Called when resetEnabled has changed
	 * @param source the affected instance of org.openanzo.ontologies.system.Datasource
	 */
	public void resetEnabledChanged(org.openanzo.ontologies.system.Datasource source);

	/**
	 * Called when a value of authorizationRule has been added
	 * @param source the affected instance of org.openanzo.ontologies.system.Datasource
	 * @param newValue the object representing the new value
	 */	
	public void authorizationRuleAdded(org.openanzo.ontologies.system.Datasource source, org.openanzo.ontologies.system.AuthorizationRule newValue);

	/**
	 * Called when a value of authorizationRule has been removed
	 * @param source the affected instance of org.openanzo.ontologies.system.Datasource
	 * @param oldValue the object representing the removed value
	 */
	public void authorizationRuleRemoved(org.openanzo.ontologies.system.Datasource source, org.openanzo.ontologies.system.AuthorizationRule oldValue);
		
	/**
	 * Called when a value of datasourceCapability has been added
	 * @param source the affected instance of org.openanzo.ontologies.system.Datasource
	 * @param newValue the object representing the new value
	 */	
	public void datasourceCapabilityAdded(org.openanzo.ontologies.system.Datasource source, org.openanzo.ontologies.system.DatasourceCapability newValue);

	/**
	 * Called when a value of datasourceCapability has been removed
	 * @param source the affected instance of org.openanzo.ontologies.system.Datasource
	 * @param oldValue the object representing the removed value
	 */
	public void datasourceCapabilityRemoved(org.openanzo.ontologies.system.Datasource source, org.openanzo.ontologies.system.DatasourceCapability oldValue);
		
}