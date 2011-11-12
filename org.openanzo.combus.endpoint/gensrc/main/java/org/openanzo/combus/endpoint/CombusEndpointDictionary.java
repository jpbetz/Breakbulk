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
package org.openanzo.combus.endpoint;
import java.util.Dictionary;
/**
 *   Bayeux Bridge Config Properties.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class CombusEndpointDictionary{
 	
	/**
	 * Key for property "org.openanzo.combus.endpoint.recorder.enabled"
	 * True to enabled analysis recording
	 *
	 */
	public static final String	KEY_RECORDER_ENABLED	= "org.openanzo.combus.endpoint.recorder.enabled";
 	
	/**
	 * Key for property "org.openanzo.combus.endpoint.recorder.output"
	 * Recorder output file location
	 *
	 */
	public static final String	KEY_RECORDER_OUTPUT	= "org.openanzo.combus.endpoint.recorder.output";
 	
	/**
	 * Key for property "org.openanzo.combus.endpoint.recorder.excludedQueues"
	 * Queue names to exclude from recorder
	 *
	 */
	public static final String	KEY_RECORDER_EXCLUDED_QUEUES	= "org.openanzo.combus.endpoint.recorder.excludedQueues";
 	
 	/**
	 * Get {@link #KEY_RECORDER_ENABLED} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_RECORDER_ENABLED}, or false  if not present
	 */
	 @SuppressWarnings("unchecked")
	static public Boolean getRecorderEnabled(Dictionary properties) {
		Object _prop=properties.get(KEY_RECORDER_ENABLED);
		return (_prop!=null)?Boolean.valueOf(_prop.toString()):null;
	}

	/**
	 * Set {@link #KEY_RECORDER_ENABLED} property to recorder.enabled in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param recorderEnabled
	 *           value for recorder.enabled
	 */
	 @SuppressWarnings("unchecked")
	static public void setRecorderEnabled(Dictionary properties, Boolean recorderEnabled) {
		if(recorderEnabled==null){
			properties.remove(KEY_RECORDER_ENABLED);
		}else{
			properties.put(KEY_RECORDER_ENABLED, recorderEnabled.toString());
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_RECORDER_OUTPUT} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_RECORDER_OUTPUT} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getRecorderOutput(Dictionary properties) {
		Object _prop = properties.get(KEY_RECORDER_OUTPUT);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_RECORDER_OUTPUT} property to recorder.output in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param recorderOutput
	 *            value for recorder.output
	 */
	 @SuppressWarnings("unchecked")
	static public void setRecorderOutput(Dictionary properties, String recorderOutput) {
		if(recorderOutput==null){
			properties.remove(KEY_RECORDER_OUTPUT);
		}else{
			properties.put(KEY_RECORDER_OUTPUT, recorderOutput);
		}
	}
 	
 	
 	/**
	 * Get {@link #KEY_RECORDER_EXCLUDED_QUEUES} property from properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * 
	 * @return value of {@link #KEY_RECORDER_EXCLUDED_QUEUES} if not present
	 */
	 @SuppressWarnings("unchecked")
	static public String getRecorderExcludedQueues(Dictionary properties) {
		Object _prop = properties.get(KEY_RECORDER_EXCLUDED_QUEUES);
		
				
		return (_prop!=null)?_prop.toString():null;
		
	}
	
	/**
	 * Set {@link #KEY_RECORDER_EXCLUDED_QUEUES} property to recorder.excludedQueues in properties
	 * 
	 * @param properties
	 *            containing configuration data
	 * @param recorderExcludedQueues
	 *            value for recorder.excludedQueues
	 */
	 @SuppressWarnings("unchecked")
	static public void setRecorderExcludedQueues(Dictionary properties, String recorderExcludedQueues) {
		if(recorderExcludedQueues==null){
			properties.remove(KEY_RECORDER_EXCLUDED_QUEUES);
		}else{
			properties.put(KEY_RECORDER_EXCLUDED_QUEUES, recorderExcludedQueues);
		}
	}
 	
 	
 }
 	