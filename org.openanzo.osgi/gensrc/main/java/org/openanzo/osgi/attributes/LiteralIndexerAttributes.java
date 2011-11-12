
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
package org.openanzo.osgi.attributes;
import org.openanzo.osgi.AnzoAttributeDefinition;

/**
 *   Configuration properties used for setting up literal indexer.
 *	@author Generated Source from org.openanzo.rdf.utils.properties.jet
 */
 
 public class LiteralIndexerAttributes{
 	
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.indexer.literals.enabled"
	 * Should the literal indexer be enabled.
	 * <li><b>Server:</b>The server uses its own Lucene index, so this property is not used.</li>
	 * <li><b>Client:</b>When persistence is enabled on the client, enabling the literal indexer allows for text index predicates as part of Sparql queries.</li>
	 * <li><b>Embedded:</b>See server</li>
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  Enabled = new AnzoAttributeDefinition() {
            public String getName() {
                return "enabled";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.indexer.literals.enabled";
            }

            public String getDescription() {
                return ""+"Should the literal indexer be enabled.";
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
                return new String[] {Boolean.toString(false)};
            }

            public int getCardinality() {
                return 0;
            }
        };
        
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.indexer.literals.rebuildIndex"
	 * Should the literal indexer be rebuilt on startup.
	 * <li><b>Server:</b>The server uses its own Lucene index, so this property is not used.</li>
	 * <li><b>Client:</b>When persistence is enabled on the client and this property is true, the index will rebuild the indexer when the container is started.</li>
	 * <li><b>Embedded:</b>See server</li>
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  RebuildIndex = new AnzoAttributeDefinition() {
            public String getName() {
                return "rebuildIndex";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.indexer.literals.rebuildIndex";
            }

            public String getDescription() {
                return ""+"Should the literal indexer be rebuilt on startup.";
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
                return new String[] {Boolean.toString(false)};
            }

            public int getCardinality() {
                return 0;
            }
        };
        
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.indexer.literals.indexLocation"
	 * Location of the index files on disk.
	 * <li><b>Server:</b>The server uses its own Lucene index, so this property is not used.</li>
	 * <li><b>Client:</b>When persistence is enabled on the client, this property points to the location of the Lucene index on disk.</li>
	 * <li><b>Embedded:</b>See server</li>
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  IndexLocation = new AnzoAttributeDefinition() {
            public String getName() {
                return "indexLocation";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.indexer.literals.indexLocation";
            }

            public String getDescription() {
                return ""+"Location of the index files on disk.";
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
	 * AnzoAttributeDefinition for "org.openanzo.indexer.literals.removeLockFile"
	 * Force a removal of a previous lock file on startup.
	 * <li><b>Server:</b>The server uses its own Lucene index, so this property is not used.</li>
	 * <li><b>Client:</b>When persistence is enabled on the client and this property is true, the index will remove any previous Lucene lock files on disk.</li>
	 * <li><b>Embedded:</b>See server</li>
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  RemoveLockFile = new AnzoAttributeDefinition() {
            public String getName() {
                return "removeLockFile";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.indexer.literals.removeLockFile";
            }

            public String getDescription() {
                return ""+"Force a removal of a previous lock file on startup.";
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
                return new String[] {Boolean.toString(true)};
            }

            public int getCardinality() {
                return 0;
            }
        };
        
	 
 	/**
	 * AnzoAttributeDefinition for "org.openanzo.indexer.literals.indexClear"
	 * Clear the index on startup.
	 * <li><b>Server:</b>The server uses its own Lucene index, so this property is not used.</li>
	 * <li><b>Client:</b>When persistence is enabled on the client and this property is true, the index will clear the indexer when the container is started.</li>
	 * <li><b>Embedded:</b>See server</li>
	 *
	 */
	 
	 public static final AnzoAttributeDefinition  IndexClear = new AnzoAttributeDefinition() {
            public String getName() {
                return "indexClear";
            }
			public boolean isRestartRequired() {
                return true;
            }
            public String getID() {
                return "org.openanzo.indexer.literals.indexClear";
            }

            public String getDescription() {
                return ""+"Clear the index on startup.";
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
                return new String[] {Boolean.toString(false)};
            }

            public int getCardinality() {
                return 0;
            }
        };
         
 }
 	