
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
package org.openanzo.indexer.lucene;
import java.util.Properties;
/**
 *   Configuration properties for the Lucene index
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class LuceneProperties{
 	
	/**
	 * Key for property "org.openanzo.indexer.lucene.indexLocation"
	 * Location of the Lucene index on disk
	 * <li><b>Server:</b>When indexing is enabled on the server, this property points to the location of the Lucene index on disk.</li>
	 * <li><b>Client:</b>The client uses its own Lucene index, so this property is not used.</li>
	 * <li><b>Embedded:</b>See server</li>
	 *
	 */
	public static final String	KEY_LUCENE_INDEX_LOCATION	= "org.openanzo.indexer.lucene.indexLocation";
 	
	/**
	 * Key for property "org.openanzo.indexer.lucene.field"
	 * Default field in index that is queried
	 * <li><b>Server:</b>This is the default field in the index that is queried.</li>
	 * <li><b>Client:</b>The client uses its own Lucene index, so this property is not used.</li>
	 * <li><b>Embedded:</b>See server</li>
	 *
	 */
	public static final String	KEY_LUCENE_QUERY_FIELD	= "org.openanzo.indexer.lucene.field";
 	
	/**
	 * Key for property "org.openanzo.indexer.lucene.text"
	 * Default query text
	 * <li><b>Server:</b>This is the default query text to use.</li>
	 * <li><b>Client:</b>The client uses its own Lucene index, so this property is not used.</li>
	 * <li><b>Embedded:</b>See server</li>
	 *
	 */
	public static final String	KEY_LUCENE_QUERY_TEXT	= "org.openanzo.indexer.lucene.text";
 	
	/**
	 * Key for property "org.openanzo.indexer.lucene.removeLockFile"
	 * Force a removal of a previous lock file on startup.
	 * <li><b>Server:</b>When indexing is enabled on the server and this property is true, the index will remove any previous Lucene lock files on disk.</li>
	 * <li><b>Client:</b>The client uses its own Lucene index, so this property is not used.</li>
	 * <li><b>Embedded:</b>See server</li>
	 *
	 */
	public static final String	KEY_LUCENE_REMOVE_LOCK_FILE	= "org.openanzo.indexer.lucene.removeLockFile";
 	
	/**
	 * Key for property "org.openanzo.indexer.lucene.indexerHome"
	 * Absolute directory location of the Lucene index on disk.
	 * <li><b>Server:</b>When indexing is enabled on the server, this property will be used to determine the Lucene directory on disk.</li>
	 * <li><b>Client:</b>The client uses its own Lucene index, so this property is not used.</li>
	 * <li><b>Embedded:</b>See server</li>
	 *
	 */
	public static final String	INDEXER_HOME	= "org.openanzo.indexer.lucene.indexerHome";
 	
 	/**
	 * Get {@link #KEY_LUCENE_INDEX_LOCATION} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_LUCENE_INDEX_LOCATION} if not present
	 */
	static public String getIndexLocation(Properties properties) {
		return properties.getProperty(KEY_LUCENE_INDEX_LOCATION);
	}
	
	/**
	 * Set {@link #KEY_LUCENE_INDEX_LOCATION} property to indexLocation in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param indexLocation
	 *            value for indexLocation
	 */
	static public void setIndexLocation(Properties properties, String indexLocation) {
		if(indexLocation==null){
			properties.remove(KEY_LUCENE_INDEX_LOCATION);
		}else{
			properties.setProperty(KEY_LUCENE_INDEX_LOCATION, indexLocation);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_LUCENE_QUERY_FIELD} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_LUCENE_QUERY_FIELD} if not present
	 */
	static public String getField(Properties properties) {
		return properties.getProperty(KEY_LUCENE_QUERY_FIELD);
	}
	
	/**
	 * Set {@link #KEY_LUCENE_QUERY_FIELD} property to field in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param field
	 *            value for field
	 */
	static public void setField(Properties properties, String field) {
		if(field==null){
			properties.remove(KEY_LUCENE_QUERY_FIELD);
		}else{
			properties.setProperty(KEY_LUCENE_QUERY_FIELD, field);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_LUCENE_QUERY_TEXT} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_LUCENE_QUERY_TEXT} if not present
	 */
	static public String getText(Properties properties) {
		return properties.getProperty(KEY_LUCENE_QUERY_TEXT);
	}
	
	/**
	 * Set {@link #KEY_LUCENE_QUERY_TEXT} property to text in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param text
	 *            value for text
	 */
	static public void setText(Properties properties, String text) {
		if(text==null){
			properties.remove(KEY_LUCENE_QUERY_TEXT);
		}else{
			properties.setProperty(KEY_LUCENE_QUERY_TEXT, text);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_LUCENE_REMOVE_LOCK_FILE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_LUCENE_REMOVE_LOCK_FILE},or "true"  if not present
	 */
	static public boolean getRemoveLockFile(Properties properties) {
		return Boolean.valueOf(properties.getProperty(KEY_LUCENE_REMOVE_LOCK_FILE,""+true)).booleanValue();		
	}

	/**
	 * Set {@link #KEY_LUCENE_REMOVE_LOCK_FILE} property to removeLockFile in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param removeLockFile
	 *           value for removeLockFile
	 */
	static public void setRemoveLockFile(Properties properties, boolean removeLockFile) {
		properties.setProperty(KEY_LUCENE_REMOVE_LOCK_FILE, Boolean.toString(removeLockFile));
	}
 	
 	
 	/**
	 * Get {@link #INDEXER_HOME} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #INDEXER_HOME} if not present
	 */
	static public String getIndexerHome(Properties properties) {
		return properties.getProperty(INDEXER_HOME);
	}
	
	/**
	 * Set {@link #INDEXER_HOME} property to indexerHome in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param indexerHome
	 *            value for indexerHome
	 */
	static public void setIndexerHome(Properties properties, String indexerHome) {
		if(indexerHome==null){
			properties.remove(INDEXER_HOME);
		}else{
			properties.setProperty(INDEXER_HOME, indexerHome);
		}
	}
 	
 	
 }
 	