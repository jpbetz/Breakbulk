
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
package org.openanzo.combus.endpoint.attributes;
import org.openanzo.osgi.AnzoAttributeDefinition;

/**
 *   Bayeux Bridge Config Properties.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class CombusEndpointAttributes{
 	
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.combus.endpoint.recorder.enabled"
	 * True to enabled analysis recording
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  RecorderEnabled = new AnzoAttributeDefinition() {
            public String getName() {
                return "recorder.enabled";
            }
			public boolean isRestartRequired() {
                return false;
            }
            public String getID() {
                return "org.openanzo.combus.endpoint.recorder.enabled";
            }

            public String getDescription() {
                return ""+"True to enabled analysis recording";
            }

            public String validate(String value) {
            	return "";
            }

            public int getType() {
                return AnzoAttributeDefinition.BOOLEAN;
            }

            public String[] getOptionValues() {
                return null;
            }

            public String[] getOptionLabels() {
                return null;
            }

            public String[] getDefaultValue() {
                return  null;
            }

            public int getCardinality() {
                return 0;
            }
        };
        
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.combus.endpoint.recorder.output"
	 * Recorder output file location
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  RecorderOutput = new AnzoAttributeDefinition() {
            public String getName() {
                return "recorder.output";
            }
			public boolean isRestartRequired() {
                return false;
            }
            public String getID() {
                return "org.openanzo.combus.endpoint.recorder.output";
            }

            public String getDescription() {
                return ""+"Recorder output file location";
            }

            public String validate(String value) {
            	return "";
            }

            public int getType() {
                return AnzoAttributeDefinition.STRING;
            }

            public String[] getOptionValues() {
                return null;
            }

            public String[] getOptionLabels() {
                return null;
            }

            public String[] getDefaultValue() {
                return  null;
            }

            public int getCardinality() {
                return 0;
            }
        };
        
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.combus.endpoint.recorder.excludedQueues"
	 * Queue names to exclude from recorder
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  RecorderExcludedQueues = new AnzoAttributeDefinition() {
            public String getName() {
                return "recorder.excludedQueues";
            }
			public boolean isRestartRequired() {
                return false;
            }
            public String getID() {
                return "org.openanzo.combus.endpoint.recorder.excludedQueues";
            }

            public String getDescription() {
                return ""+"Queue names to exclude from recorder";
            }

            public String validate(String value) {
            	return "";
            }

            public int getType() {
                return AnzoAttributeDefinition.STRING;
            }

            public String[] getOptionValues() {
                return null;
            }

            public String[] getOptionLabels() {
                return null;
            }

            public String[] getDefaultValue() {
                return  null;
            }

            public int getCardinality() {
                return 0;
            }
        };
         
 }
 	