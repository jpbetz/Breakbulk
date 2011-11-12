/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.test/src/com/ibm/adtech/boca/test/server/TestBocaReplication.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  2/25/2005
 * Revision:	$Id: TestReplication.java 171 2007-07-31 14:11:17Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.test.client;

import java.util.ArrayList;
import java.util.Iterator;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.AnzoClientDatasource;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.AnzoGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.MemQuadStore;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.impl.BaseOperationContext;
import org.openanzo.services.serialization.IReplicationHandler;
import org.openanzo.test.AbstractTest;

/**
 * Test replication service
 * 
 */
public class TestReplication extends AbstractTest {

    static final URI defaultUser         = Constants.valueFactory.createURI("http://openanzo.org/users/default");

    static final URI namedGraphUri       = createTestUri("namedGraph1");

    static final URI namedGraphUri2      = createTestUri("namedGraph2");

    static final URI metaNamedGraphUri   = UriGenerator.generateMetadataGraphUri(namedGraphUri);

    static final URI metaNamedGraphUri2  = UriGenerator.generateMetadataGraphUri(namedGraphUri2);

    static final URI acl                 = Constants.valueFactory.createURI("http://openanzo.org/ACL/1");

    static final URI defaultRole         = Constants.valueFactory.createURI("ldap://cn=users,ou=groups,dc=openanzo,dc=org");

    static final URI defaultSysAdminRole = Constants.valueFactory.createURI("ldap://cn=sysadmins,ou=groups,dc=openanzo,dc=org");

    class SimpleReplicaUpdater implements IReplicationHandler {
        MemQuadStore additions = new MemQuadStore();

        MemQuadStore removals  = new MemQuadStore();

        SimpleReplicaUpdater() {
        }

        SimpleReplicaUpdater clear() {
            additions.clear();
            removals.clear();
            return this;
        }

        public void start(int totalSize) throws AnzoException {
        }

        public void end() throws AnzoException {
        }

        public boolean handleNamedGraph(URI namedGraphUri, URI uuid, long revision) throws AnzoException {
            return false;
        }

        public boolean handleStatement(boolean metadata, boolean addition, Resource subject, URI predicate, Value object, URI namedGraphURI) throws AnzoException {
            if (addition) {
                additions.add(subject, predicate, object, namedGraphURI);
            } else {
                removals.add(subject, predicate, object, namedGraphURI);
            }
            return true;
        }

        public MemQuadStore getAdditions() {
            return additions;
        }

        public MemQuadStore getDeletions() {
            return removals;
        }
    }

    /**
     * Test simple adds and removes
     * 
     * @throws Throwable
     */
    public void testAddRemoveStatements() throws Throwable {
        // it works if we use the sysadmin role, but we don't want to do that.
        // ModelServiceProperties.setUser(props,
        // "http://openanzo.org/users/sysadmin");
        // ModelServiceProperties.setPassword(props, "123");
        AnzoClient anzoClient = null;
        AnzoClient containerClient = null;
        org.openanzo.client.AnzoClientDatasource container = null;
        try {
            anzoClient = new AnzoClient(getDefaultClientConfiguration());
            anzoClient.connect();
            anzoClient.reset(loadStatements("initialize.trig"), null);
            Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"), namedGraphUri);
            Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object2"), namedGraphUri);
            Statement stmt3 = Constants.valueFactory.createStatement(createTestUri("subject3"), createTestUri("predicate3"), createTestUri("object3"), namedGraphUri);

            Statement stmt6 = Constants.valueFactory.createStatement(namedGraphUri, org.openanzo.ontologies.openanzo.NamedGraph.canBeAddedToByProperty, defaultRole, namedGraphUri);
            Statement stmt7 = Constants.valueFactory.createStatement(namedGraphUri, org.openanzo.ontologies.openanzo.NamedGraph.canBeReadByProperty, defaultRole, namedGraphUri);
            Statement stmt8 = Constants.valueFactory.createStatement(namedGraphUri, org.openanzo.ontologies.openanzo.NamedGraph.canBeRemovedFromByProperty, defaultRole, namedGraphUri);

            Statement stmt9 = Constants.valueFactory.createStatement(namedGraphUri2, org.openanzo.ontologies.openanzo.NamedGraph.canBeAddedToByProperty, defaultRole, namedGraphUri2);
            Statement stmt10 = Constants.valueFactory.createStatement(namedGraphUri2, org.openanzo.ontologies.openanzo.NamedGraph.canBeReadByProperty, defaultRole, namedGraphUri2);
            Statement stmt11 = Constants.valueFactory.createStatement(namedGraphUri2, org.openanzo.ontologies.openanzo.NamedGraph.canBeRemovedFromByProperty, defaultRole, namedGraphUri2);

            anzoClient.begin();
            AnzoGraph serverModel1 = anzoClient.getServerGraph(namedGraphUri);
            serverModel1.getMetadataGraph().add(stmt6);
            serverModel1.getMetadataGraph().add(stmt7);
            serverModel1.getMetadataGraph().add(stmt8);
            serverModel1.add(stmt1);
            serverModel1.add(stmt2);
            anzoClient.commit();
            anzoClient.updateRepository();

            anzoClient.begin();
            AnzoGraph serverModel2 = anzoClient.getServerGraph(namedGraphUri2);
            serverModel2.getMetadataGraph().add(stmt9);
            serverModel2.getMetadataGraph().add(stmt10);
            serverModel2.getMetadataGraph().add(stmt11);
            anzoClient.commit();
            anzoClient.updateRepository();
            containerClient = new AnzoClient(getDefaultClientConfiguration());
            container = containerClient.getAnzoClientDatasource();
            containerClient.connect();

            ArrayList<Statement> trackers = new ArrayList<Statement>();
            Long revision = Long.valueOf(-1);
            trackers.add(Constants.valueFactory.createStatement(namedGraphUri, org.openanzo.ontologies.openanzo.NamedGraph.revisionProperty, Constants.valueFactory.createTypedLiteral(revision), metaNamedGraphUri));
            SimpleReplicaUpdater results = new SimpleReplicaUpdater();
            container.getReplicationService().replicate(createContext("execReplicate", anzoClient), trackers, results.clear(), 200);

            assertTrue(results.getDeletions().size() == 0);
            assertTrue(results.getAdditions().contains(stmt1));
            assertTrue(results.getAdditions().contains(stmt2));
            assertFalse(results.getAdditions().contains(stmt3));

            anzoClient.begin();
            serverModel1.add(stmt3);
            anzoClient.commit();
            anzoClient.updateRepository();
            trackers.clear();
            Iterator<Statement> statements = results.getAdditions().find(namedGraphUri, org.openanzo.ontologies.openanzo.NamedGraph.revisionProperty, null, metaNamedGraphUri).iterator();
            if (statements.hasNext()) {
                Statement stmt = statements.next();
                trackers.add(stmt);
            }
            container.getReplicationService().replicate(createContext("execReplicate", anzoClient), trackers, results.clear(), 200);
            assertTrue(results.getDeletions().size(namedGraphUri) == 0);
            assertFalse(results.getAdditions().contains(stmt1));
            assertFalse(results.getAdditions().contains(stmt2));
            assertTrue(results.getAdditions().contains(stmt3));

            anzoClient.begin();
            serverModel1.remove(stmt3);
            anzoClient.commit();
            anzoClient.updateRepository();
            trackers.clear();
            statements = results.getAdditions().find(namedGraphUri, org.openanzo.ontologies.openanzo.NamedGraph.revisionProperty, null, metaNamedGraphUri).iterator();
            if (statements.hasNext()) {
                Statement stmt = statements.next();
                trackers.add(stmt);
            }
            container.getReplicationService().replicate(createContext("execReplicate", anzoClient), trackers, results.clear(), 200);

            assertTrue(results.getAdditions().size(namedGraphUri) == 0);
            assertTrue(results.getDeletions().size(namedGraphUri) > 0);
            assertFalse(results.getDeletions().contains(stmt1));
            assertFalse(results.getDeletions().contains(stmt2));
            assertTrue(results.getDeletions().contains(stmt3));

            anzoClient.begin();
            serverModel1.remove(stmt2);
            serverModel1.remove(stmt1);
            anzoClient.commit();
            anzoClient.updateRepository();
            trackers.clear();
            statements = results.getAdditions().find(namedGraphUri, org.openanzo.ontologies.openanzo.NamedGraph.revisionProperty, null, metaNamedGraphUri).iterator();
            if (statements.hasNext()) {
                Statement stmt = statements.next();
                trackers.add(stmt);
            }
            container.getReplicationService().replicate(createContext("execReplicate", anzoClient), trackers, results.clear(), 200);
            assertTrue(results.getAdditions().size(namedGraphUri) == 0);
            assertTrue(results.getDeletions().contains(stmt1));
            assertTrue(results.getDeletions().contains(stmt2));
            assertFalse(results.getDeletions().contains(stmt3));

            trackers.clear();
            statements = results.getAdditions().find(namedGraphUri, org.openanzo.ontologies.openanzo.NamedGraph.revisionProperty, null, metaNamedGraphUri).iterator();
            if (statements.hasNext()) {
                Statement stmt = statements.next();
                trackers.add(stmt);
            }
            container.getReplicationService().replicate(createContext("execReplicate", anzoClient), trackers, results.clear(), 200);
            assertTrue(results.getAdditions().size(namedGraphUri) == 0);
            assertTrue(results.getDeletions().size(namedGraphUri) == 0);

            anzoClient.begin();
            serverModel2.add(stmt3);
            anzoClient.commit();
            anzoClient.updateRepository();
            trackers.clear();
            statements = results.getAdditions().find(namedGraphUri, org.openanzo.ontologies.openanzo.NamedGraph.revisionProperty, null, metaNamedGraphUri).iterator();
            if (statements.hasNext()) {
                Statement stmt = statements.next();
                trackers.add(stmt);
            }
            container.getReplicationService().replicate(createContext("execReplicate", anzoClient), trackers, results.clear(), 200);
            assertTrue(results.getDeletions().size(namedGraphUri) == 0);
            assertTrue(results.getAdditions().size(namedGraphUri) == 0);
        } finally {
            if (anzoClient != null)
                anzoClient.close();
            if (containerClient != null) {
                containerClient.close();
            }
        }
    }

    /**
     * Test simple adds and removes
     * 
     * @throws Throwable
     */
    public void testNewNamedGraphTracker() throws Throwable {
        // it works if we use the sysadmin role, but we don't want to do that.
        // ModelServiceProperties.setUser(props,
        // "http://openanzo.org/users/sysadmin");
        // ModelServiceProperties.setPassword(props, "123");
        AnzoClient anzoClient = null;
        AnzoClient containerClient = null;
        AnzoClientDatasource container = null;
        try {
            anzoClient = new AnzoClient(getDefaultClientConfiguration());
            anzoClient.connect();
            anzoClient.reset(loadStatements("initialize.trig"), null);

            Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"), namedGraphUri);
            Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object2"), namedGraphUri);
            Statement stmt3 = Constants.valueFactory.createStatement(createTestUri("subject3"), createTestUri("predicate3"), createTestUri("object3"), namedGraphUri);
            Statement stmt4 = Constants.valueFactory.createStatement(createTestUri("subject4"), createTestUri("predicate4"), createTestUri("object4"), namedGraphUri2);
            anzoClient.begin();
            AnzoGraph serverModel1 = anzoClient.getServerGraph(namedGraphUri);
            anzoClient.commit();
            anzoClient.updateRepository();
            anzoClient.begin();
            AnzoGraph serverModel2 = anzoClient.getServerGraph(namedGraphUri2);
            anzoClient.commit();
            anzoClient.updateRepository();
            containerClient = new AnzoClient(getDefaultClientConfiguration());
            container = containerClient.getAnzoClientDatasource();
            containerClient.connect();

            SimpleReplicaUpdater results = new SimpleReplicaUpdater();
            ArrayList<Statement> trackers = new ArrayList<Statement>();
            Long revision = Long.valueOf(-1);
            trackers.add(Constants.valueFactory.createStatement(namedGraphUri, org.openanzo.ontologies.openanzo.NamedGraph.revisionProperty, Constants.valueFactory.createTypedLiteral(revision), metaNamedGraphUri));

            container.getReplicationService().replicate(createContext("execReplicate", anzoClient), trackers, results.clear(), 200);
            assertTrue(results.getDeletions().size(namedGraphUri) == 0);
            assertTrue(results.getAdditions().size(namedGraphUri) == 0);
            assertTrue(results.getDeletions().size(namedGraphUri2) == 0);
            assertTrue(results.getAdditions().size(namedGraphUri2) == 0);

            anzoClient.begin();
            serverModel1.add(stmt1);
            serverModel1.add(stmt2);
            anzoClient.commit();
            anzoClient.updateRepository();

            container.getReplicationService().replicate(createContext("execReplicate", anzoClient), trackers, results.clear(), 200);
            assertTrue(results.getDeletions().size(namedGraphUri) == 0);
            assertNotNull(results.getAdditions());
            assertTrue(results.getAdditions().contains(stmt1));
            assertTrue(results.getAdditions().contains(stmt2));
            assertFalse(results.getAdditions().contains(stmt3));
            if (results.getAdditions() != null) {
                trackers.clear();
                Iterator<Statement> statements = results.getAdditions().find(namedGraphUri, org.openanzo.ontologies.openanzo.NamedGraph.revisionProperty, null, metaNamedGraphUri).iterator();
                if (statements.hasNext()) {
                    trackers.add(statements.next());
                }
            }
            assertTrue(results.getDeletions().size(namedGraphUri2) == 0);
            assertTrue(results.getAdditions().size(namedGraphUri2) == 0);

            anzoClient.begin();
            serverModel1.add(stmt3);
            anzoClient.commit();
            anzoClient.updateRepository();

            container.getReplicationService().replicate(createContext("execReplicate", anzoClient), trackers, results.clear(), 200);
            assertTrue(results.getDeletions().size(namedGraphUri) == 0);
            assertFalse(results.getAdditions().contains(stmt1));
            assertFalse(results.getAdditions().contains(stmt2));
            assertTrue(results.getAdditions().contains(stmt3));
            if (results.getAdditions() != null) {
                trackers.clear();
                Iterator<Statement> statements = results.getAdditions().find(namedGraphUri, org.openanzo.ontologies.openanzo.NamedGraph.revisionProperty, null, metaNamedGraphUri).iterator();
                if (statements.hasNext()) {
                    trackers.add(statements.next());
                }
            }
            assertTrue(results.getDeletions().size(namedGraphUri2) == 0);
            assertTrue(results.getAdditions().size(namedGraphUri2) == 0);

            anzoClient.begin();
            serverModel2.add(stmt4);
            anzoClient.commit();
            anzoClient.updateRepository();

            container.getReplicationService().replicate(createContext("execReplicate", anzoClient), trackers, results.clear(), 200);
            assertTrue(results.getDeletions().size(namedGraphUri2) == 0);
            assertTrue(results.getAdditions().size(namedGraphUri2) == 0);
            assertTrue(results.getDeletions().size(namedGraphUri) == 0);
            assertTrue(results.getAdditions().size(namedGraphUri) == 0);

            trackers.add(Constants.valueFactory.createStatement(namedGraphUri2, org.openanzo.ontologies.openanzo.NamedGraph.revisionProperty, Constants.valueFactory.createTypedLiteral(Long.valueOf(-1)), metaNamedGraphUri2));
            container.getReplicationService().replicate(createContext("execReplicate", anzoClient), trackers, results.clear(), 200);
            assertTrue(results.getDeletions().size(namedGraphUri2) == 0);
            assertTrue(results.getAdditions().size(namedGraphUri2) > 0);
            assertTrue(results.getAdditions().contains(stmt4));
            assertTrue(results.getDeletions().size(namedGraphUri) == 0);
            assertTrue(results.getAdditions().size(namedGraphUri) == 0);

        } finally {
            if (anzoClient != null)
                anzoClient.close();
            if (containerClient != null) {
                containerClient.close();
            }
        }
    }

    /**
     * Test simple adds and removes
     * 
     * @throws Throwable
     */
    public void testUsesCache() throws Throwable {
        AnzoClient anzoClient = null;
        AnzoClient containerClient = null;
        AnzoClientDatasource container = null;
        try {
            anzoClient = new AnzoClient(getDefaultClientConfiguration());
            anzoClient.connect();
            anzoClient.reset(loadStatements("initialize.trig"), null);

            Statement stmt1 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object1"), namedGraphUri);
            Statement stmt2 = Constants.valueFactory.createStatement(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object2"), namedGraphUri);
            Statement stmt3 = Constants.valueFactory.createStatement(createTestUri("subject3"), createTestUri("predicate3"), createTestUri("object3"), namedGraphUri);
            anzoClient.begin();
            AnzoGraph serverModel1 = anzoClient.getServerGraph(namedGraphUri);
            anzoClient.commit();
            anzoClient.updateRepository();

            containerClient = new AnzoClient(getDefaultClientConfiguration());
            container = containerClient.getAnzoClientDatasource();
            containerClient.connect();

            SimpleReplicaUpdater results = new SimpleReplicaUpdater();
            ArrayList<Statement> trackers = new ArrayList<Statement>();
            Long revision = Long.valueOf(-1);
            trackers.add(Constants.valueFactory.createStatement(namedGraphUri, org.openanzo.ontologies.openanzo.NamedGraph.revisionProperty, Constants.valueFactory.createTypedLiteral(revision), metaNamedGraphUri));

            container.getReplicationService().replicate(createContext("execReplicate", anzoClient), trackers, results.clear(), 200);
            assertTrue(results.getDeletions().size(namedGraphUri) == 0);
            assertTrue(results.getAdditions().size(namedGraphUri) == 0);
            assertTrue(results.getDeletions().size(namedGraphUri2) == 0);
            assertTrue(results.getAdditions().size(namedGraphUri2) == 0);

            anzoClient.begin();
            serverModel1.add(stmt1);
            serverModel1.add(stmt2);
            anzoClient.commit();
            anzoClient.updateRepository();

            container.getReplicationService().replicate(createContext("execReplicate", anzoClient), trackers, results.clear(), 200);
            assertTrue(results.getDeletions().size(namedGraphUri) == 0);
            assertNotNull(results.getAdditions());
            assertTrue(results.getAdditions().contains(stmt1));
            assertTrue(results.getAdditions().contains(stmt2));
            assertFalse(results.getAdditions().contains(stmt3));

            container.getReplicationService().replicate(createContext("execReplicate", anzoClient), trackers, results.clear(), 200);
            assertTrue(results.getDeletions().size(namedGraphUri) == 0);
            assertNotNull(results.getAdditions());
            assertTrue(results.getAdditions().contains(stmt1));
            assertTrue(results.getAdditions().contains(stmt2));
            assertFalse(results.getAdditions().contains(stmt3));

            container.getReplicationService().replicate(createContext("execReplicate", anzoClient), trackers, results.clear(), 200);
            assertTrue(results.getDeletions().size(namedGraphUri) == 0);
            assertNotNull(results.getAdditions());
            assertTrue(results.getAdditions().contains(stmt1));
            assertTrue(results.getAdditions().contains(stmt2));
            assertFalse(results.getAdditions().contains(stmt3));

            anzoClient.begin();
            serverModel1.remove(stmt1);
            serverModel1.remove(stmt2);
            anzoClient.commit();
            anzoClient.updateRepository();

            container.getReplicationService().replicate(createContext("execReplicate", anzoClient), trackers, results.clear(), 200);
            assertTrue(results.getDeletions().size(namedGraphUri) == 0);
            assertNotNull(results.getAdditions());
            assertFalse(results.getAdditions().contains(stmt1));
            assertFalse(results.getAdditions().contains(stmt2));
            assertFalse(results.getAdditions().contains(stmt3));

            container.getReplicationService().replicate(createContext("execReplicate", anzoClient), trackers, results.clear(), 200);
            assertTrue(results.getDeletions().size(namedGraphUri) == 0);
            assertNotNull(results.getAdditions());
            assertFalse(results.getAdditions().contains(stmt1));
            assertFalse(results.getAdditions().contains(stmt2));
            assertFalse(results.getAdditions().contains(stmt3));
        } finally {
            if (anzoClient != null)
                anzoClient.close();
            if (containerClient != null) {
                containerClient.close();
            }
        }
    }

    /**
     * Test simple adds and removes
     * 
     * @throws Throwable
     */
    public void testLargeNumberOfStatements() throws Throwable {
        // it works if we use the sysadmin role, but we don't want to do that.
        // ModelServiceProperties.setUser(props,
        // "http://openanzo.org/users/sysadmin");
        // ModelServiceProperties.setPassword(props, "123");
        AnzoClient anzoClient = null;
        AnzoClient containerClient = null;
        org.openanzo.client.AnzoClientDatasource container = null;
        try {
            anzoClient = new AnzoClient(getDefaultClientConfiguration());
            anzoClient.connect();
            anzoClient.reset(loadStatements("initialize.trig"), null);

            AnzoGraph serverModel1 = anzoClient.getServerGraph(namedGraphUri);
            for (int j = 0; j < 10; j++) {
                anzoClient.begin();
                for (int i = 0; i < 500; i++) {
                    serverModel1.add(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("object" + j + ":" + i));
                    serverModel1.add(createTestUri("subject1"), createTestUri("predicate1"), createTestUri("obj" + j + ":" + i));
                }
                anzoClient.commit();
                anzoClient.updateRepository();
            }

            containerClient = new AnzoClient(getDefaultClientConfiguration());
            container = containerClient.getAnzoClientDatasource();
            containerClient.connect();
            ArrayList<Statement> trackers = new ArrayList<Statement>();
            Long revision = Long.valueOf(-1);
            trackers.add(Constants.valueFactory.createStatement(namedGraphUri, org.openanzo.ontologies.openanzo.NamedGraph.revisionProperty, Constants.valueFactory.createTypedLiteral(revision), metaNamedGraphUri));
            SimpleReplicaUpdater results = new SimpleReplicaUpdater();
            container.getReplicationService().replicate(createContext("execReplicate", anzoClient), trackers, results.clear(), 500);
            assertTrue(results.getAdditions().size() > 10000);
        } finally {
            if (anzoClient != null)
                anzoClient.close();
            if (containerClient != null) {
                containerClient.close();
            }
        }
    }

    protected IOperationContext createContext(String name, AnzoClient client) throws AnzoException {
        return new BaseOperationContext(name, BaseOperationContext.generateOperationId(), client.getServicePrincipal());
    }

}
