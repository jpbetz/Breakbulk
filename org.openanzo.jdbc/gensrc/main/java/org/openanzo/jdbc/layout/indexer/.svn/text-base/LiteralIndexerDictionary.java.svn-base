/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Generated Source from org.openanzo.rdf.utils.properties.jet
 * Created on:  Generated Source from org.openanzo.rdf.utils.properties.jet
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.jdbc.layout.indexer;
import java.util.Dictionary;
/**
 *   Configuration properties used for setting up literal indexer.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class LiteralIndexerDictionary{
 	
	/**
	 * Key for property "org.openanzo.indexer.literals.enabled"
	 * Should the literal indexer be enabled.
	 * <li><b>Server:</b>The server uses its own Lucene index, so this property is not used.</li>
	 * <li><b>Client:</b>When persistence is enabled on the client, enabling the literal indexer allows for text index predicates as part of Sparql queries.</li>
	 * <li><b>Embedded:</b>See server</li>
	 *
	 */
	public static final String	KEY_LITERAL_INDEX_ENABLED	= "org.openanzo.indexer.literals.enabled";
 	
	/**
	 * Key for property "org.openanzo.indexer.literals.rebuildIndex"
	 * Should the literal indexer be rebuilt on startup.
	 * <li><b>Server:</b>The server uses its own Lucene index, so this property is not used.</li>
	 * <li><b>Client:</b>When persistence is enabled on the client and this property is true, the index will rebuild the indexer when the container is started.</li>
	 * <li><b>Embedded:</b>See server</li>
	 *
	 */
	public static final String	KEY_LITERAL_INDEXER_REBUILD	= "org.openanzo.indexer.literals.rebuildIndex";
 	
	/**
	 * Key for property "org.openanzo.indexer.literals.indexLocation"
	 * Location of the index files on disk.
	 * <li><b>Server:</b>The server uses its own Lucene index, so this property is not used.</li>
	 * <li><b>Client:</b>When persistence is enabled on the client, this property points to the location of the Lucene index on disk.</li>
	 * <li><b>Embedded:</b>See server</li>
	 *
	 */
	public static final String	KEY_LITERAL_INDEX_LOCATION	= "org.openanzo.indexer.literals.indexLocation";
 	
	/**
	 * Key for property "org.openanzo.indexer.literals.removeLockFile"
	 * Force a removal of a previous lock file on startup.
	 * <li><b>Server:</b>The server uses its own Lucene index, so this property is not used.</li>
	 * <li><b>Client:</b>When persistence is enabled on the client and this property is true, the index will remove any previous Lucene lock files on disk.</li>
	 * <li><b>Embedded:</b>See server</li>
	 *
	 */
	public static final String	KEY_LITERAL_INDEX_REMOVE_LOCK_FILE	= "org.openanzo.indexer.literals.removeLockFile";
 	
	/**
	 * Key for property "org.openanzo.indexer.literals.indexClear"
	 * Clear the index on startup.
	 * <li><b>Server:</b>The server uses its own Lucene index, so this property is not used.</li>
	 * <li><b>Client:</b>When persistence is enabled on the client and this property is true, the index will clear the indexer when the container is started.</li>
	 * <li><b>Embedded:</b>See server</li>
	 *
	 */
	public static final String	KEY_LITERAL_INDEXER_CLEAR	= "org.openanzo.indexer.literals.indexClear";
 	
 	/**
	 * Get {@link #KEY_LITERAL_INDEX_ENABLED} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_LITERAL_INDEX_ENABLED},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getEnabled(Dictionary properties) {
		Object _prop=properties.get(KEY_LITERAL_INDEX_ENABLED);
		if(_prop==null){
			_prop=Boolean.valueOf(false);
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_LITERAL_INDEX_ENABLED} property to enabled in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param enabled
	 *           value for enabled
	 */
	 @SuppressWarnings("unchecked")
	static public void setEnabled(Dictionary properties, Boolean enabled) {
		if(enabled==null){
			properties.remove(KEY_LITERAL_INDEX_ENABLED);
		}else{
			properties.put(KEY_LITERAL_INDEX_ENABLED, enabled.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_LITERAL_INDEXER_REBUILD} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_LITERAL_INDEXER_REBUILD},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getRebuildIndex(Dictionary properties) {
		Object _prop=properties.get(KEY_LITERAL_INDEXER_REBUILD);
		if(_prop==null){
			_prop=Boolean.valueOf(false);
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_LITERAL_INDEXER_REBUILD} property to rebuildIndex in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param rebuildIndex
	 *           value for rebuildIndex
	 */
	 @SuppressWarnings("unchecked")
	static public void setRebuildIndex(Dictionary properties, Boolean rebuildIndex) {
		if(rebuildIndex==null){
			properties.remove(KEY_LITERAL_INDEXER_REBUILD);
		}else{
			properties.put(KEY_LITERAL_INDEXER_REBUILD, rebuildIndex.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_LITERAL_INDEX_LOCATION} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_LITERAL_INDEX_LOCATION} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getIndexLocation(Dictionary properties) {
		Object _prop = properties.get(KEY_LITERAL_INDEX_LOCATION);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_LITERAL_INDEX_LOCATION} property to indexLocation in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param indexLocation
	 *            value for indexLocation
	 */
	 @SuppressWarnings("unchecked")
	static public void setIndexLocation(Dictionary properties, String indexLocation) {
		if(indexLocation==null){
			properties.remove(KEY_LITERAL_INDEX_LOCATION);
		}else{
			properties.put(KEY_LITERAL_INDEX_LOCATION, indexLocation);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_LITERAL_INDEX_REMOVE_LOCK_FILE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_LITERAL_INDEX_REMOVE_LOCK_FILE},or "true"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getRemoveLockFile(Dictionary properties) {
		Object _prop=properties.get(KEY_LITERAL_INDEX_REMOVE_LOCK_FILE);
		if(_prop==null){
			_prop=Boolean.valueOf(true);
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_LITERAL_INDEX_REMOVE_LOCK_FILE} property to removeLockFile in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param removeLockFile
	 *           value for removeLockFile
	 */
	 @SuppressWarnings("unchecked")
	static public void setRemoveLockFile(Dictionary properties, Boolean removeLockFile) {
		if(removeLockFile==null){
			properties.remove(KEY_LITERAL_INDEX_REMOVE_LOCK_FILE);
		}else{
			properties.put(KEY_LITERAL_INDEX_REMOVE_LOCK_FILE, removeLockFile.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_LITERAL_INDEXER_CLEAR} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_LITERAL_INDEXER_CLEAR},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getIndexClear(Dictionary properties) {
		Object _prop=properties.get(KEY_LITERAL_INDEXER_CLEAR);
		if(_prop==null){
			_prop=Boolean.valueOf(false);
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_LITERAL_INDEXER_CLEAR} property to indexClear in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param indexClear
	 *           value for indexClear
	 */
	 @SuppressWarnings("unchecked")
	static public void setIndexClear(Dictionary properties, Boolean indexClear) {
		if(indexClear==null){
			properties.remove(KEY_LITERAL_INDEXER_CLEAR);
		}else{
			properties.put(KEY_LITERAL_INDEXER_CLEAR, indexClear.toString());
		}
	}
 	
 	
 }
 	