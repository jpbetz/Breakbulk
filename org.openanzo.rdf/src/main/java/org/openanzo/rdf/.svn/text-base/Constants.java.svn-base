/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/model/Attic/Constants.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  3/22/2006
 * Revision:	$Id: Constants.java 200 2007-08-01 16:25:35Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf;

import org.openanzo.rdf.utils.UriGenerator;

/**
 * Constants for URL prefixes, RDF types, Predicate URIs and config property key names.
 * 
 * @author Joe Betz
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class Constants {
    /** Static final ValueFactory that Anzo classes use to create URIs,Statements,Literals and BlankNodes */
    public static final MemValueFactory valueFactory             = MemValueFactory.defaultFactory;

    /** OpenAnzo Version */
    public static final int             VERSION                  = 1;

    /** byte encoding used for serialization and hashing within system */
    public static final String          byteEncoding             = "UTF-8";

    /** Prefix for BlankNodes */
    public static final String          BNODE_PREFIX             = "_:";

    /** Prefix for BlankNodes */
    public static final String          ANZO_BNODE               = "node";

    /** Prefix for BlankNodes */
    public static final String          ANZO_BNODE_PREFIX        = BNODE_PREFIX + ANZO_BNODE;

    /** URI for sysadmin user */
    public static final URI             DEFAULT_SYSADMIN         = MemURI.create("http://openanzo.org/system/internal/sysadmin");

    /** URI for anonymous user */
    public static final URI             DEFAULT_ANONYMOUS        = MemURI.create("http://openanzo.org/system/internal/anonymous");

    /** URI for anonymous user */
    public static final String          DEFAULT_ANONYMOUS_USER   = "anzo_anonymous";

    /** URI for everyone role */
    public static final URI             EVERYONE_ROLE            = MemURI.create(NAMESPACES.PREFIX + "/Role/everyone");

    /** URI for noone role */
    public static final URI             NOONE_ROLE               = MemURI.create(NAMESPACES.PREFIX + "/Role/noone");

    /** URI for authenticated users role */
    public static final URI             AUTHENTICATED_USERS_ROLE = MemURI.create(NAMESPACES.PREFIX + "/Role/authenticatedUsers");

    /** URI for default internal user URI */
    public static final URI             DEFAULT_INTERNAL_USER    = MemURI.create(NAMESPACES.PREFIX + "/reserved/defaultInternalUser");

    /** URI for the "ANY" wildcard */
    public static final URI             ANY_URI                  = MemURI.create(NAMESPACES.OPENANZO_ONTOLOGY_PREFIX + "ANY");

    /** Namespace constants */
    public static class NAMESPACES {
        /** Prefix for all Open Anzo URIS */
        public static final String PREFIX                               = "http://openanzo.org";

        /** Openanzo ontologies use this prefix */
        public static final String OPENANZO_ONTOLOGY_PREFIX             = "http://openanzo.org/ontologies/2008/07/Anzo#";

        /** Prefix for Service URIs */
        public static final String SERVICE_PREFIX                       = PREFIX + "/service/";

        /** Prefix for Service URIs */
        public static final String COMPONENT_PREFIX                     = PREFIX + "/serviceContainer/component/";

        /** Prefix for Service Endpoint URIs */
        public static final String SERVICE_ENDPOINT_PREFIX              = PREFIX + "/service/endpoint/";

        /** Prefix for Backend URIs */
        public static final String DATASOURCE_PREFIX                    = PREFIX + "/datasource/";

        /** Prefix for Server URIs */
        public static final String SERVER_PREFIX                        = PREFIX + "/Server/";

        /** Prefix for Transaction URIs */
        public static final String TRANSACTION_PREFIX                   = PREFIX + "/transaction/";

        /** Prefix for NamedGraph URIs */
        public static final String NAMEDGRAPH_PREFIX                    = PREFIX + "/namedGraphs/";

        /** Prefix for NamedGraph URIs */
        public static final String NAMEDGRAPH_REVISIONED_UUID_PREFIX    = PREFIX + "/namedGraphUUID/revisioned/";

        /** Prefix for NamedGraph URIs */
        public static final String NAMEDGRAPH_NONREVISIONED_UUID_PREFIX = PREFIX + "/namedGraphUUID/nonrevisioned/";

        /** Prefix for MetadataGraph URIs */
        public static final String METADATAGRAPH_PREFIX                 = PREFIX + "/metadataGraphs";

        /** Prefix for command URIs */
        public static final String COMMAND_PREFIX                       = PREFIX + "/reserved/command";

        /** Prefix for NamedGraph pub/sub topics */
        public static final String NAMEDGRAPH_TOPIC_PREFIX              = "namedgraphs/";

        /** Prefix for NamedGraph pub/sub topics */
        public static final String STREAM_TOPIC_PREFIX                  = "streams/";

        /** The XPath functions namespace. */
        static public final String FN_NAMESPACE                         = "http://www.w3.org/2005/xpath-functions#";

        /** The XPath operators namespace. */
        static public final String OP_NAMESPACE                         = "http://www.w3.org/2005/xpath-functions#";

        /** The (artificial) namespace for builtin SPARQL functions. */
        static public final String BUILTIN_NAMESPACE                    = "http://www.w3.org/2006/sparql-functions#";

        /** The (artificial) namespace for builtin aggregate functions. */
        static public final String BUILTIN_AGGREGATE_NAMESPACE          = "http://openanzo.org/glitter/builtin/aggregates#";

        /** The namespace for standard basis Glitter fnuctions. */
        static public final String GLITTER_FUNCTION_NAMESPACE           = "http://openanzo.org/glitter/builtin/functions#";

        /** The namespace for standard basis Glitter fnuctions. */
        static public final String GLITTER_QUERYOPTION_NAMESPACE        = "http://openanzo.org/glitter/builtin/queryOption#";

    }

    /** Service Options Constants */
    public static class OPTIONS {

        /** Datasource message property */
        public static final String DATASOURCE            = "datasource";

        /** include MetadataGraph uris in dataset resolution */
        public static final String INCLUDEMETADATAGRAPHS = "includeMetadataGraphs";

        /** Priority message property */
        public static final String PRIORITY              = "priority";

        /** skip Cache */
        public static final String SKIPCACHE             = "skipCache";

    }

    /** Combus constants */
    public static class COMBUS {
        /** JMS correlation ID */
        public static final String JMS_CORRELATION_ID           = "jmsCorrelationId";

        /** Name of JMS queue to which transaction update messages are queued upon */
        public static final String NOTIFICATION_UPDATES_QUEUE   = "services/serverUpdates";

        /** Name of JMS queue to which transaction control messages are queued upon */
        public static final String NOTIFICATION_SERVICE_QUEUE   = "services/notification";

        /** Name of JMS queue to which authentication service messages are queued upon */
        public static final String AUTHENTICATION_SERVICE_QUEUE = "services/authentication";

        /** Name of JMS queue to which authentication service messages are queued upon */
        public static final String AUTHORIZATION_SERVICE_QUEUE  = "services/authorization";

        /** Name of JMS queue to which model service messages are queued upon */
        public static final String MODEL_SERVICE_QUEUE          = "services/model";

        /** Name of JMS queue to which reset service messages are queued upon */
        public static final String RESET_SERVICE_QUEUE          = "services/reset";

        /** Name of JMS queue to which update service messages are queued upon */
        public static final String UPDATE_SERVICE_QUEUE         = "services/update";

        /** Name of JMS queue to which query service messages are queued upon */
        public static final String QUERY_SERVICE_QUEUE          = "services/query";

        /** Name of JMS queue to which index service messages are queued upon */
        public static final String INDEX_SERVICE_QUEUE          = "services/index";

        /** Name of JMS queue to which execute service messages are queued upon */
        public static final String EXECUTION_SERVICE_QUEUE      = "services/execution";

        /** Name of JMS queue to which replication messages are queued upon */
        public static final String REPLICATION_SERVICE_QUEUE    = "services/replication";

        /** Prefix for NamedGraph pub/sub topics */
        public static final String TRANSACTIONS_TOPIC           = "transactions/completed";

        /** Timeout message property */
        public static final String TIMEOUT                      = "timeout";
    }

    /** Index constants */
    public static class INDEXER {

        /** Lucene indexer field name to store predicate value */
        public static final String INDEXER_FIELD_PREDICATE = "predicate";

        /** Lucene indexer field name to store subject value */
        public static final String INDEXER_FIELD_SUBJECT   = "subject";

        /** Lucene indexer field name to store NamedGraph URI of statement */
        public static final String INDEXER_FIELD_GRAPH_URI = "graph";

    }

    /** Standard registries */
    public static class REGISTRIES {
        /** Ontolgies registry */
        public static final URI ONTOLOGY_REGISTRY = Constants.valueFactory.createURI(Constants.NAMESPACES.PREFIX + "/registries/Ontologies");

    }

    /** OSGI constants */
    public static class OSGI {
        /** OSGI prefix */
        public static final URI    OSGI              = Constants.valueFactory.createURI("http://openanzo.org/internal/osgi");

        /** OSGI Bundle prefix */
        public static final String BUNDLE            = "http://openanzo.org/internal/osgi/bundle/";

        /** OSGI service prefix */
        public static final String SERVICE           = "http://openanzo.org/internal/osgi/service/";

        /** OSGI attribute prefix */
        public static final String OCD               = "http://openanzo.org/internal/osgi/service/objectClassDefinition/";

        /** OSGI attribute prefix */
        public static final String ATTRIBUTE         = "http://openanzo.org/internal/osgi/service/attribute/";

        /** OSGI attribute prefix */
        public static final String ATTRIBUTE_OPTION  = "http://openanzo.org/internal/osgi/service/attribute/option";

        /** OSGI property prefix */
        public static final String BUNDLE_PROPERTY   = "http://openanzo.org/internal/osgi/bundle/property/";

        /** OSGI property prefix */
        public static final String SERVICE_PROPERTY  = "http://openanzo.org/internal/osgi/service/property/";

        /** OSGI property prefix */
        public static final String CONFIG_PROPERTY   = "http://openanzo.org/internal/osgi/config/property/";

        /** OSGI config prefix */
        public static final String CONFIG            = "http://openanzo.org/internal/osgi/service/config/";

        /** OSGI Reset event admin topic */
        public static final String RESET_TOPIC       = "org/openanzo/internal/reset";

        /** OSGI ldap event admin topic */
        public static final String LDAP_SERVER_TOPIC = "org/openanzo/internal/ldap";

    }

    /** Graph constants */
    public static class GRAPHS {
        /** URI of dataset containing namedgraphs */
        public static final URI GRAPHS_DATASET                  = Constants.valueFactory.createURI(Constants.NAMESPACES.PREFIX + "/datasets#NamedGraphs");

        /** URI of dataset containing namedgraphs metdata */
        public static final URI GRAPHS_DATASET_META             = UriGenerator.generateMetadataGraphUri(GRAPHS_DATASET);

        /** URI of dataset containing metadata */
        public static final URI METADATA_GRAPHS_DATASET         = Constants.valueFactory.createURI(Constants.NAMESPACES.PREFIX + "/datasets#MetadataGraphs");

        /** URI of dataset containing metdata metdata */
        public static final URI METADATA_GRAPHS_DATASET_META    = UriGenerator.generateMetadataGraphUri(METADATA_GRAPHS_DATASET);

        /** URI for default system graph */
        public static final URI DEFAULT_SYSTEMGRAPH             = MemURI.create(UriGenerator.generateNamedGraphUriString("defaultSystemGraph"));

        /** URI for default system metadata graph */
        public static final URI DEFAULT_SYSTEM_METAGRAPH        = UriGenerator.generateMetadataGraphUri(DEFAULT_SYSTEMGRAPH);

        /** URI for all NamedGraphs */
        public static final URI ALL_NAMEDGRAPHS                 = MemURI.create(Constants.NAMESPACES.NAMEDGRAPH_PREFIX + "reserved/namedGraphs/ALL");

        /** URI for all Metadata Graphs */
        public static final URI ALL_METADATAGRAPHS              = MemURI.create(Constants.NAMESPACES.NAMEDGRAPH_PREFIX + "reserved/metadataGraphs/ALL");

        /** URI for all NamedGraphs and Metadata Graphs */
        public static final URI ALL_GRAPHS                      = MemURI.create(Constants.NAMESPACES.NAMEDGRAPH_PREFIX + "reserved/graphs/ALL");

        /** URI for all NamedGraphs */
        public static final URI DEFAULT_GRAPH_TEMPLATE          = MemURI.create(Constants.NAMESPACES.NAMEDGRAPH_PREFIX + "reserved/graphs/defaultGraphTemplate");

        /** URI for all NamedGraphs */
        public static final URI DEFAULT_METADATA_GRAPH_TEMPLATE = MemURI.create(Constants.NAMESPACES.NAMEDGRAPH_PREFIX + "reserved/graphs/defaultMetadataGraphTemplate");

    }

}
