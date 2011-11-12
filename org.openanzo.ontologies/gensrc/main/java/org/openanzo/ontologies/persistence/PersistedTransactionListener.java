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
 * Implementations of this listener may be registered with instances of org.openanzo.ontologies.persistence.PersistedTransaction to 
 * receive notification when properties changed, added or removed.
 * <br>
 */
public interface PersistedTransactionListener extends org.openanzo.rdf.jastor.ThingListener {


	/**
	 * Called when transactionContext has changed
	 * @param source the affected instance of org.openanzo.ontologies.persistence.PersistedTransaction
	 */
	public void transactionContextChanged(org.openanzo.ontologies.persistence.PersistedTransaction source);

	/**
	 * Called when additionsStore has changed
	 * @param source the affected instance of org.openanzo.ontologies.persistence.PersistedTransaction
	 */
	public void additionsStoreChanged(org.openanzo.ontologies.persistence.PersistedTransaction source);

	/**
	 * Called when childTransaction has changed
	 * @param source the affected instance of org.openanzo.ontologies.persistence.PersistedTransaction
	 */
	public void childTransactionChanged(org.openanzo.ontologies.persistence.PersistedTransaction source);

	/**
	 * Called when deletionsStore has changed
	 * @param source the affected instance of org.openanzo.ontologies.persistence.PersistedTransaction
	 */
	public void deletionsStoreChanged(org.openanzo.ontologies.persistence.PersistedTransaction source);

	/**
	 * Called when next has changed
	 * @param source the affected instance of org.openanzo.ontologies.persistence.PersistedTransaction
	 */
	public void nextChanged(org.openanzo.ontologies.persistence.PersistedTransaction source);

	/**
	 * Called when nextTransaction has changed
	 * @param source the affected instance of org.openanzo.ontologies.persistence.PersistedTransaction
	 */
	public void nextTransactionChanged(org.openanzo.ontologies.persistence.PersistedTransaction source);

	/**
	 * Called when parentTransaction has changed
	 * @param source the affected instance of org.openanzo.ontologies.persistence.PersistedTransaction
	 */
	public void parentTransactionChanged(org.openanzo.ontologies.persistence.PersistedTransaction source);

	/**
	 * Called when a value of preconditions has been added
	 * @param source the affected instance of org.openanzo.ontologies.persistence.PersistedTransaction
	 * @param newValue the object representing the new value
	 */	
	public void preconditionsAdded(org.openanzo.ontologies.persistence.PersistedTransaction source, org.openanzo.ontologies.persistence.PersistedPrecondition newValue);

	/**
	 * Called when a value of preconditions has been removed
	 * @param source the affected instance of org.openanzo.ontologies.persistence.PersistedTransaction
	 * @param oldValue the object representing the removed value
	 */
	public void preconditionsRemoved(org.openanzo.ontologies.persistence.PersistedTransaction source, org.openanzo.ontologies.persistence.PersistedPrecondition oldValue);
		
	/**
	 * Called when previousTransaction has changed
	 * @param source the affected instance of org.openanzo.ontologies.persistence.PersistedTransaction
	 */
	public void previousTransactionChanged(org.openanzo.ontologies.persistence.PersistedTransaction source);

	/**
	 * Called when transactionUri has changed
	 * @param source the affected instance of org.openanzo.ontologies.persistence.PersistedTransaction
	 */
	public void transactionUriChanged(org.openanzo.ontologies.persistence.PersistedTransaction source);

}