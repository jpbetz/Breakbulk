
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
package org.openanzo.combus.bayeux.attributes;
import org.openanzo.osgi.AnzoAttributeDefinition;

/**
 *   Bayeux Bridge Config Properties.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class BayeuxBridgeAttributes{
 	
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.combus.bayeuxBridge.threadPoolSize"
	 * Max size of pool to handle bayeux to jms bridging
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  ThreadPoolSize = new AnzoAttributeDefinition() {
            public String getName() {
                return "threadPoolSize";
            }
			public boolean isRestartRequired() {
                return false;
            }
            public String getID() {
                return "org.openanzo.combus.bayeuxBridge.threadPoolSize";
            }

            public String getDescription() {
                return ""+"Max size of pool to handle bayeux to jms bridging";
            }

            public String validate(String value) {
            	return "";
            }

            public int getType() {
                return AnzoAttributeDefinition.INTEGER;
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
 	