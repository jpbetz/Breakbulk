
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
package org.openanzo.datasource.attributes;
import org.openanzo.osgi.AnzoAttributeDefinition;

/**
 *   Base configuration properties that are used by datasources.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class DatasourceAttributes{
 	
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.datasource.isPrimary"
	 * Is this the primary datasource
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  IsPrimary = new AnzoAttributeDefinition() {
            public String getName() {
                return "isPrimary";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.datasource.isPrimary";
            }

            public String getDescription() {
                return ""+"Is this the primary datasource";
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
	 * AnzoAttributeDefinition for "org.openanzo.datasource.initFiles"
	 * Init files for datasource initialization and reset
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  InitFiles = new AnzoAttributeDefinition() {
            public String getName() {
                return "initFiles";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.datasource.initFiles";
            }

            public String getDescription() {
                return ""+"Init files for datasource initialization and reset";
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
	 * AnzoAttributeDefinition for "org.openanzo.datasource.datasourceURI"
	 * URI for datasource
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  DatasourceURI = new AnzoAttributeDefinition() {
            public String getName() {
                return "datasourceURI";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.datasource.datasourceURI";
            }

            public String getDescription() {
                return ""+"URI for datasource";
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
	 * AnzoAttributeDefinition for "org.openanzo.datasource.uriPatterns"
	 * URI patterns for datasource
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  UriPatterns = new AnzoAttributeDefinition() {
            public String getName() {
                return "uriPatterns";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.datasource.uriPatterns";
            }

            public String getDescription() {
                return ""+"URI patterns for datasource";
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
	 * AnzoAttributeDefinition for "org.openanzo.datasource.enableCaching"
	 * Enable Caching
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  EnableCaching = new AnzoAttributeDefinition() {
            public String getName() {
                return "enableCaching";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.datasource.enableCaching";
            }

            public String getDescription() {
                return ""+"Enable Caching";
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
	 * AnzoAttributeDefinition for "org.openanzo.datasource.resetEnabled"
	 * Enable Reset
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  ResetEnabled = new AnzoAttributeDefinition() {
            public String getName() {
                return "resetEnabled";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.datasource.resetEnabled";
            }

            public String getDescription() {
                return ""+"Enable Reset";
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
	 * AnzoAttributeDefinition for "org.openanzo.datasource.maxWriteConnections"
	 * Maximum number of write connections.
	 *
	 * Examples:
	 * 
	 */
	 
	 public static final AnzoAttributeDefinition  MaxWriteConnections = new AnzoAttributeDefinition() {
            public String getName() {
                return "maxWriteConnections";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.datasource.maxWriteConnections";
            }

            public String getDescription() {
                return ""+"Maximum number of write connections.";
            }

            public String validate(String value) {
            	
                try {
                    int _val = Integer.valueOf(value);
                    	if(_val< 0){return "Value must be greater than 0";}
                    if(_val> 1600){return "Value must be less than 1600";}
                    return "";
                } catch (NumberFormatException nfe) {
                    return "Value is not an Integer";
                }
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
        
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.datasource.maxQueryConnections"
	 * Maximum number of query connections.
	 *
	 * Examples:
	 * 
	 */
	 
	 public static final AnzoAttributeDefinition  MaxQueryConnections = new AnzoAttributeDefinition() {
            public String getName() {
                return "maxQueryConnections";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.datasource.maxQueryConnections";
            }

            public String getDescription() {
                return ""+"Maximum number of query connections.";
            }

            public String validate(String value) {
            	
                try {
                    int _val = Integer.valueOf(value);
                    	if(_val< 0){return "Value must be greater than 0";}
                    if(_val> 1600){return "Value must be less than 1600";}
                    return "";
                } catch (NumberFormatException nfe) {
                    return "Value is not an Integer";
                }
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
 	