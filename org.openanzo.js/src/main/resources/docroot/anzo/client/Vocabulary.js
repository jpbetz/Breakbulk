/*******************************************************************************
 * Copyright (c) 2007-2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>)
 * Created on:  Oct 10, 2007
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

dojo.provide("anzo.client.Vocabulary");

dojo.require("anzo.rdf.Statement");
dojo.require("anzo.rdf.vocabulary.RDF");
dojo.require("anzo.utils.UriGenerator");

/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 */
 
anzo.client.Vocabulary = {
    
    // ==========================================================================
    // DATASET
    
    defaultGraphProperty        : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#defaultGraph"),
    
    namedGraphProperty          : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#namedGraph"),
    
    defaultDatasetUri           : anzo.createURI("http://openanzo.org/datasets/default"),
    
    namedDatasetType            : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#Dataset"),
    
    // ==========================================================================
    // NAMED GRAPH
    
    namedGraphType				: anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#NamedGraph"),
    
    lastModifiedByUserProperty  : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#lastModifiedByUser"),
    
    createdByProperty           : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#createdBy"),
    
    revisionProperty            : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#revision"),
    
    modifiedProperty            : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#modified"),
    
    hasMetadataGraphProperty    : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#hasMetadataGraph"),
    
    uuidProperty				: anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#uuid"),
    
    datasourceProperty			: anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#datasource"),
    
    revisionedProperty			: anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#revisioned"),
   
    canBeReadByProperty         : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#canBeReadBy"),
    
    canBeAddedToByProperty      : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#canBeAddedToBy"),
    
    canBeRemovedFromByProperty  : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#canBeRemovedFromBy"),
    
    persistedProperty           : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#persisted"),
    
    // ==========================================================================
    // USER
    
    userType					: anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#User"),
    
    inRoleProperty              : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#inRole"),
    
    defaultAclTemplateProperty  : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#defaultAclTemplate"),
    
    defaultRoleProperty         : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#defaultRole"),
    
    userIdProperty              : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#userId"),
    
    passwordProperty            : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#password"),

    // ==========================================================================
    // ROLE
    
    /** URI for sysadmin role */
    SYSADMIN_ROLE					    : anzo.createURI("http://openanzo.org/system/internal/sysadmin"),
    
    /** URI for everyone role */
    EVERYONE_ROLE   					: anzo.createURI("http://openanzo.org/Role/everyone"),
    
    /** URI for noone role */
    NOONE_ROLE   						: anzo.createURI("http://openanzo.org/Role/noone"),
    
    subRoleOfProperty                   : anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#subRoleOf"),
        
    /** JMX_DOMAIN */
	JMX_DOMAIN							: "openanzo.org",

	/** Prefix for all Open Anzo URIS */
	PREFIX								: anzo.createURI("http://openanzo.org"),

	/** Prefix for BlankNodes */
	BNODE_PREFIX						: "node",

	/** Prefix for Server URIs */
	SERVER_PREFIX						: anzo.createURI("http://openanzo.org/Server/"),

	/** Prefix for Statement URIs */
	STATEMENT_PREFIX					: anzo.createURI("http://openanzo.org/Statement/"),

	/** Prefix for ACL URIs */
	ACL_PREFIX							: anzo.createURI("http://openanzo.org/ACL/"),

	/** Prefix for ACI URIs */
	ACI_PREFIX							: anzo.createURI("http://openanzo.org/ACI/"),

	/** Prefix for Role URIs */
	ROLE_PREFIX							: anzo.createURI("http://openanzo.org/Role/"),

	/** Prefix for Selector Tracker URIs */
	SELECTOR_TRACKER_PREFIX				: anzo.createURI("http://openanzo.org/SelectorTracker/"),

	/** Prefix for Tracker URIs */
	TRACKER_PREFIX						: anzo.createURI("http://openanzo.org/tracker/"),

	/** Prefix for reserved predicate URIs */
	PREDICATE_PREFIX					: anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#"),

	/** Prefix for Open Anzo type URIs */
	TYPE_PREFIX							: anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#"),

	/** Prefix for RGAC URIs */
	RBAC_PREFIX							: anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#"),

	/** Prefix for NamedGraph URIs */
	NAMEDGRAPH_PREFIX					: anzo.createURI("http://openanzo.org/namedGraphs/"),

	/** Prefix for MetadataGraph URIs */
	METADATAGRAPH_PREFIX				: anzo.createURI("http://openanzo.org/metadataGraphs"),

	/** Prefix for AnonymousNode URIs */
	ANONYMOUSURI_PREFIX					: anzo.createURI("http://openanzo.org/reserved/anonymousURI/"),

	/** Prefix for event URIs */
	EVENT_PREFIX						: anzo.createURI("http://openanzo.org/reserved/event/"),

	/** Prefix for command URIs */
	COMMAND_PREFIX						: anzo.createURI("http://openanzo.org/reserved/command"),

	/** URI for resetGraph */
	resetGraph							: anzo.createURI("http://openanzo.org/namedGraphs#resetGraph"),

	/** URI for the "ANY" wildcard */
	ANY									: anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#ANY"),

	/** URI for all NamedGraphs */
	allNamedGraphsUri					: anzo.createURI("http://openanzo.org/namedGraphs/reserved/namedGraphs/ALL"),

	/**
	 * URI for all Metadata Graphs
	 * @see #allMetadataGraphsUri
	 * @deprecated
	 */
	allMetaDataGraphsUri				: anzo.createURI("http://openanzo.org/namedGraphs/reserved/metadataGraphs/ALL"),

	/** URI for all Metadata Graphs */
	allMetadataGraphsUri				: anzo.createURI("http://openanzo.org/namedGraphs/reserved/metadataGraphs/ALL"),

	/** URI for all NamedGraphs and Metadata Graphs */
	allGraphsUri						: anzo.createURI("http://openanzo.org/namedGraphs/reserved/graphs/ALL"),
	
    graphsDataset                       : anzo.createURI("http://openanzo.org/datasets#NamedGraphs"),

    metadataGraphsDataset               : anzo.createURI("http://openanzo.org/datasets#MetadataGraphs"),

	/** byte encoding used for serialization and hasing within system */
	byteEncoding						: "UTF-8",

	/** JNDI Name for JMS queue to which transaction update messages are queued upon */
	NOTIFICATION_UPDATES_QUEUE_JNDI		: "jms/AnzoUpdateQueue",

	/** JNDI Name for JMS queue to which transaction control messages are queued upon */
	NOTIFICATION_CONTROL_QUEUE_JNDI		: "jms/AnzoControlQueue",

	/** JNDI Name for JMS connection factory */
	STATIC_CONNECTION_FACTORY_REF_NAME	: "jms/AnzoConnectionFactory",

	/** Name of JMS queue to which transaction update messages are queued upon */
	NOTIFICATION_UPDATES_QUEUE			: "AnzoUpdateQueue",

	/** Name of JMS queue to which transaction control messages are queued upon */
	NOTIFICATION_CONTROL_QUEUE			: "AnzoControlQueue",

	/** Special SPARQL predicate for doing queries using sql like text search */
	TEXTLIKEPREDICATE					: anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#textlike"),

	/** Special SPARQL predicate for doing queries using text indexer */
	TEXTMATCHPREDICATE					: anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#textmatch"),

	/** Lucene indexer field name to store last modified time */
	INDEXER_FIELD_MODIFIED				: "modified",

	/** Lucene indexer field name to store predicate value */
	INDEXER_FIELD_PREDICATE				: "predicate",

	/** Lucene indexer field name to store object value */
	INDEXER_FIELD_OBJECT				: "object",

	/** Lucene indexer field name to store subject value */
	INDEXER_FIELD_SUBJECT				: "subject",

	/** Lucene indexer field name to store value of who created statement */
	INDEXER_FIELD_CREATED_BY			: "createdBy",

	/** Lucene indexer field name to store NamedGraph URI of statement */
	INDEXER_FIELD_GRAPH_URI				: "graph",

	/** Lucene indexer field name to store ID of object */
	INDEXER_FIELD_OBJ_NODE_ID			: "objNodeId",

	/** Lucene indexer field name to store ID of predicate */
	INDEXER_FIELD_PREDICATE_ID			: "predicateId",

	/** Lucene indexer field name to store ID of subject */
	INDEXER_FIELD_SUBJECT_ID			: "subjectId",

	/** Lucene indexer field name to store ID of Named Graph */
	INDEXER_FIELD_GRAPH_ID				: "graphId",

	/** Lucene indexer field name to store ID of statement */
	INDEXER_FIELD_STMT_ID				: "id",

	/** Lucene indexer field name to store language of literal object */
	INDEXER_FIELD_LANGUAGE				: "language",

	/** Lucene indexer field name to store datatype of literal object */
	INDEXER_FIELD_DATATYPE				: "datatype",
	
	/** Topic prefixes **/
	NAMEDGRAPH_TOPIC_PREFIX             : "namedgraphs/",

    STREAM_TOPIC_PREFIX                 : "streams/",	
    
    TRANSACTIONS_TOPIC					: "transactions/completed",
    
    statementStreamType					: anzo.createURI("http://openanzo.org/ontologies/2008/07/Anzo#StatementStream"),
    
    systemDatasourceUri                 : anzo.createURI("http://openanzo.org/datasource/systemDatasource")
    
}

