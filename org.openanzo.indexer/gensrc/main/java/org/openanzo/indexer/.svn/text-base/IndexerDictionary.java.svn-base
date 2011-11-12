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
package org.openanzo.indexer;
import java.util.Dictionary;
/**
 *   Configuration properties for the Indexing API
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class IndexerDictionary{
 	
	/**
	 * Key for property "org.openanzo.indexer.indexerFactoryType"
	 * The class name for the implementation of the indexer factory to use.
	 * <li><b>Server:</b>The class name for the implementation of the indexer factory to use.</li>
	 * <li><b>Embedded:</b>See server.</li>
	 *
	 * Examples:
	 * org.openanzo.model.indexer.lucene.ModelIndexerFactory
	 */
	public static final String	KEY_INDEXER_FACTORY_CLASS	= "org.openanzo.indexer.indexerFactoryType";
 	
	/**
	 * Key for property "org.openanzo.indexer.rebuildIndex"
	 * Should the indexer be rebuilt on startup.
	 * <li><b>Server:</b>When persistence is enabled and this property is true, the index will rebuild the indexer when the container is started.</li>
	 * <li><b>Embedded:</b>See server</li>
	 *
	 */
	public static final String	KEY_INDEXER_REBUILD	= "org.openanzo.indexer.rebuildIndex";
 	
	/**
	 * Key for property "org.openanzo.indexer.indexClear"
	 * Clear the index on startup.
	 * <li><b>Server:</b>When persistence is enabled and this property is true, the index will clear the indexer when the container is started.</li>
	 * <li><b>Embedded:</b>See server</li>
	 *
	 */
	public static final String	KEY_INDEXER_CLEAR	= "org.openanzo.indexer.indexClear";
 	
	/**
	 * Key for property "org.openanzo.indexer.enabled"
	 * Should the indexer be enabled.
	 * <li><b>Server:</b>When persistence is enabled, the indexer allows for the use of text index predicates as part of Sparql queries.</li>
	 * <li><b>Embedded:</b>See server</li>
	 *
	 */
	public static final String	KEY_INDEX_ENABLED	= "org.openanzo.indexer.enabled";
 	
	/**
	 * Key for property "org.openanzo.indexer.async"
	 * Should indexer add items to index in an asynchronous manor
	 * <li><b>Server:</b></li>
	 * <li><b>Embedded:</b></li>
	 *
	 */
	public static final String	KEY_INDEXER_ASYNCHRONOUS	= "org.openanzo.indexer.async";
 	
	/**
	 * Key for property "org.openanzo.indexer.pageSize"
	 * The index pagesize
	 *
	 */
	public static final String	KEY_INDEXER_PAGE_SIZE	= "org.openanzo.indexer.pageSize";
 	
 	/**
	 * Get {@link #KEY_INDEXER_FACTORY_CLASS} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_INDEXER_FACTORY_CLASS} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getIndexerFactoryType(Dictionary properties) {
		Object _prop = properties.get(KEY_INDEXER_FACTORY_CLASS);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_INDEXER_FACTORY_CLASS} property to indexerFactoryType in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param indexerFactoryType
	 *            value for indexerFactoryType
	 */
	 @SuppressWarnings("unchecked")
	static public void setIndexerFactoryType(Dictionary properties, String indexerFactoryType) {
		if(indexerFactoryType==null){
			properties.remove(KEY_INDEXER_FACTORY_CLASS);
		}else{
			properties.put(KEY_INDEXER_FACTORY_CLASS, indexerFactoryType);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_INDEXER_REBUILD} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_INDEXER_REBUILD},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getRebuildIndex(Dictionary properties) {
		Object _prop=properties.get(KEY_INDEXER_REBUILD);
		if(_prop==null){
			_prop=Boolean.valueOf(false);
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_INDEXER_REBUILD} property to rebuildIndex in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param rebuildIndex
	 *           value for rebuildIndex
	 */
	 @SuppressWarnings("unchecked")
	static public void setRebuildIndex(Dictionary properties, Boolean rebuildIndex) {
		if(rebuildIndex==null){
			properties.remove(KEY_INDEXER_REBUILD);
		}else{
			properties.put(KEY_INDEXER_REBUILD, rebuildIndex.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_INDEXER_CLEAR} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_INDEXER_CLEAR},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getIndexClear(Dictionary properties) {
		Object _prop=properties.get(KEY_INDEXER_CLEAR);
		if(_prop==null){
			_prop=Boolean.valueOf(false);
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_INDEXER_CLEAR} property to indexClear in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param indexClear
	 *           value for indexClear
	 */
	 @SuppressWarnings("unchecked")
	static public void setIndexClear(Dictionary properties, Boolean indexClear) {
		if(indexClear==null){
			properties.remove(KEY_INDEXER_CLEAR);
		}else{
			properties.put(KEY_INDEXER_CLEAR, indexClear.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_INDEX_ENABLED} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_INDEX_ENABLED},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getEnabled(Dictionary properties) {
		Object _prop=properties.get(KEY_INDEX_ENABLED);
		if(_prop==null){
			_prop=Boolean.valueOf(false);
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_INDEX_ENABLED} property to enabled in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param enabled
	 *           value for enabled
	 */
	 @SuppressWarnings("unchecked")
	static public void setEnabled(Dictionary properties, Boolean enabled) {
		if(enabled==null){
			properties.remove(KEY_INDEX_ENABLED);
		}else{
			properties.put(KEY_INDEX_ENABLED, enabled.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_INDEXER_ASYNCHRONOUS} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_INDEXER_ASYNCHRONOUS},or "false"  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getAsync(Dictionary properties) {
		Object _prop=properties.get(KEY_INDEXER_ASYNCHRONOUS);
		if(_prop==null){
			_prop=Boolean.valueOf(false);
		}
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_INDEXER_ASYNCHRONOUS} property to async in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param async
	 *           value for async
	 */
	 @SuppressWarnings("unchecked")
	static public void setAsync(Dictionary properties, Boolean async) {
		if(async==null){
			properties.remove(KEY_INDEXER_ASYNCHRONOUS);
		}else{
			properties.put(KEY_INDEXER_ASYNCHRONOUS, async.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_INDEXER_PAGE_SIZE} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param defaultValue defaultValue for pageSize
	 * @return value of {@link #KEY_INDEXER_PAGE_SIZE}or defaultValue if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Integer getPageSize(Dictionary properties,Integer defaultValue) {
		Object _prop= properties.get(KEY_INDEXER_PAGE_SIZE);
		Integer value= (_prop!=null)?Integer.valueOf(_prop.toString()):defaultValue;
		return value;
	}

	/**
	 * Set {@link #KEY_INDEXER_PAGE_SIZE} property to pageSize in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param pageSize
	 *           value for pageSize
	 */
	 @SuppressWarnings("unchecked")
	static public void setPageSize(Dictionary properties, Integer pageSize) {
		if(pageSize==null){
			properties.remove(KEY_INDEXER_PAGE_SIZE);
		}else{
		properties.put(KEY_INDEXER_PAGE_SIZE, Integer.toString(pageSize));
		}
	}
 	
 	
 }
 	