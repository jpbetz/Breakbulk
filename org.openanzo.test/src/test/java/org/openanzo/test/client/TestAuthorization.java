/*******************************************************************************
 * Copyright (c) 2008-2010 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Feb 15, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.test.client;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.ClientGraph;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.AnzoGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.rdf.vocabulary.RDF;
import org.openanzo.services.ACLUtil;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.test.AbstractTest;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class TestAuthorization extends AbstractTest {
    static final URI              GRAPH_URI        = Constants.valueFactory.createURI("http://graph1");

    static final URI              GRAPH_URI_2      = Constants.valueFactory.createURI("http://graph2");

    static final URI              GRAPH_URI_3      = Constants.valueFactory.createURI("http://graph3");

    static final URI              GRAPH_URI_4      = Constants.valueFactory.createURI("http://graph4");

    static final URI              GRAPH_URI_5      = Constants.valueFactory.createURI("http://graph5");

    static final Statement        stmt1            = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://res1"), Constants.valueFactory.createURI("http://test.example.com/test#property"), Constants.valueFactory.createURI("http://res12"));

    static final Statement        stmt2            = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://res2"), Constants.valueFactory.createURI("http://test.example.com/test#property"), Constants.valueFactory.createURI("http://res22"));

    static final Statement        stmt3            = Constants.valueFactory.createStatement(Constants.valueFactory.createURI("http://res3"), Constants.valueFactory.createURI("http://test.example.com/test#property"), Constants.valueFactory.createURI("http://res33"));

    static final URI              USERS_ROLE_URI   = MemURI.create("ldap://cn=users,ou=groups,dc=openanzo,dc=org");

    private static final Set<URI> expectedAnonymousRoles;
    static {
        HashSet<URI> rolesSet = new HashSet<URI>();
        rolesSet.add(Constants.DEFAULT_ANONYMOUS);
        rolesSet.add(Constants.EVERYONE_ROLE);
        expectedAnonymousRoles = Collections.unmodifiableSet(rolesSet);
    }

    /**
     * The URI for the user called "default". That's just the name of the user and has nothing to do with any actual defaulting mechanism.
     */
    private static final URI      DEFAULT_USER_URI = Constants.valueFactory.createURI("ldap://uid=default,ou=users,dc=openanzo,dc=org");
    private static final Set<URI> expectedDefaultUserRoles;
    static {
        HashSet<URI> rolesSet = new HashSet<URI>();
        rolesSet.add(DEFAULT_USER_URI);
        rolesSet.add(Constants.AUTHENTICATED_USERS_ROLE);
        rolesSet.add(Constants.EVERYONE_ROLE);
        rolesSet.add(USERS_ROLE_URI);
        expectedDefaultUserRoles = Collections.unmodifiableSet(rolesSet);
    }

    private static final Set<URI> expectedSysadminUserRoles;
    static {
        HashSet<URI> rolesSet = new HashSet<URI>();
        rolesSet.add(Constants.DEFAULT_SYSADMIN);
        rolesSet.add(Constants.AUTHENTICATED_USERS_ROLE);
        rolesSet.add(Constants.EVERYONE_ROLE);
        expectedSysadminUserRoles = Collections.unmodifiableSet(rolesSet);
    }

    /**
     * Test basic writes to a namedGraph using the default acls created for a named graph
     * 
     * @throws Exception
     */
    public void testAddNamedGraphDefaultAclsPermission() throws Exception {

        AnzoClient defaultClient = null;
        AnzoClient sysadminClient = null;
        AnzoClient noAccessClient = null;
        try {

            defaultClient = new AnzoClient(getDefaultClientConfiguration());
            defaultClient.connect();
            defaultClient.reset(loadStatements("initialize.trig"), null);

            sysadminClient = new AnzoClient(getSystemClientConfiguration());
            sysadminClient.connect();

            noAccessClient = new AnzoClient(getClientConfiguration("defaultNoRights", "123"));
            noAccessClient.connect();

            ClientGraph sysAdminGraph = sysadminClient.getReplicaGraph(GRAPH_URI);
            sysAdminGraph.add(stmt1);
            sysadminClient.updateRepository();

            assertEquals(true, sysadminClient.namedGraphExists(GRAPH_URI));
            assertEquals(false, noAccessClient.namedGraphExists(GRAPH_URI));
            assertEquals(false, defaultClient.namedGraphExists(GRAPH_URI));

            Set<URI> sysAdminGraphs = sysadminClient.getNamedGraphs();
            assertTrue(sysAdminGraphs.contains(GRAPH_URI));
            Set<URI> noAccessGraphs = noAccessClient.getNamedGraphs();
            assertFalse(noAccessGraphs.contains(GRAPH_URI));
            Set<URI> defaultGraphs = defaultClient.getNamedGraphs();
            assertFalse(defaultGraphs.contains(GRAPH_URI));

            boolean exceptionThrown = false;
            ClientGraph defaultGraph = defaultClient.getServerGraph(GRAPH_URI);
            try {
                defaultClient.updateRepository();
            } catch (AnzoException ae) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown);
            assertTrue(sysAdminGraph.contains(stmt1));
            assertFalse(defaultGraph.contains(stmt1));

            exceptionThrown = false;
            ClientGraph defaultNoAccessGraph = noAccessClient.getServerGraph(GRAPH_URI);
            try {
                noAccessClient.updateRepository();
            } catch (AnzoException ae) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown);

            assertTrue(sysAdminGraph.contains(stmt1));
            assertFalse(defaultNoAccessGraph.contains(stmt1));

        } finally {
            if (defaultClient != null) {
                defaultClient.close();
            }

            if (sysadminClient != null) {
                sysadminClient.close();
            }

            if (noAccessClient != null) {
                noAccessClient.close();
            }
        }
    }

    /**
     * Test basic writes to a namedGraph using the custom acls created for a named graph
     * 
     * @throws Exception
     */
    public void testAddNamedGraphCustomAclsPermission() throws Exception {

        AnzoClient defaultClient = null;
        AnzoClient sysadminClient = null;
        AnzoClient noAccessClient = null;
        try {

            defaultClient = new AnzoClient(getDefaultClientConfiguration());
            defaultClient.connect();
            defaultClient.reset(loadStatements("initialize.trig"), null);

            sysadminClient = new AnzoClient(getSystemClientConfiguration());
            sysadminClient.connect();

            noAccessClient = new AnzoClient(getClientConfiguration("defaultNoRights", "123"));
            noAccessClient.connect();

            sysadminClient.begin();
            ClientGraph sysAdminGraph = sysadminClient.getReplicaGraph(GRAPH_URI);
            ACLUtil.setReadPermission(sysAdminGraph, USERS_ROLE_URI, true);
            ACLUtil.setAddPermission(sysAdminGraph, USERS_ROLE_URI, true);
            ACLUtil.setRemovePermission(sysAdminGraph, USERS_ROLE_URI, true);
            ACLUtil.setReadMetadataPermission(sysAdminGraph, USERS_ROLE_URI, true);
            ACLUtil.setAddMetadataPermission(sysAdminGraph, USERS_ROLE_URI, true);
            ACLUtil.setRemoveMetadataPermission(sysAdminGraph, USERS_ROLE_URI, true);
            sysAdminGraph.add(stmt1);
            sysadminClient.commit();
            sysadminClient.updateRepository();

            assertEquals(true, sysadminClient.namedGraphExists(GRAPH_URI));
            assertEquals(false, noAccessClient.namedGraphExists(GRAPH_URI));
            assertEquals(true, defaultClient.namedGraphExists(GRAPH_URI));

            Set<URI> sysAdminGraphs = sysadminClient.getNamedGraphs();
            assertTrue(sysAdminGraphs.contains(GRAPH_URI));
            Set<URI> noAccessGraphs = noAccessClient.getNamedGraphs();
            assertFalse(noAccessGraphs.contains(GRAPH_URI));
            Set<URI> defaultGraphs = defaultClient.getNamedGraphs();
            assertTrue(defaultGraphs.contains(GRAPH_URI));

            boolean exceptionThrown = false;
            ClientGraph defaultGraph = defaultClient.getServerGraph(GRAPH_URI);
            try {
                defaultClient.updateRepository();
                assertEquals(1, defaultGraph.size());
            } catch (AnzoException ae) {
                exceptionThrown = true;
            }
            assertFalse(exceptionThrown);
            exceptionThrown = false;
            ClientGraph defaultNoAccessGraph = noAccessClient.getServerGraph(GRAPH_URI);
            try {
                noAccessClient.updateRepository();
            } catch (AnzoException ae) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown);

            assertTrue(sysAdminGraph.contains(stmt1));
            assertFalse(defaultNoAccessGraph.contains(stmt1));

        } finally {
            if (defaultClient != null) {
                defaultClient.close();
            }

            if (sysadminClient != null) {
                sysadminClient.close();
            }

            if (noAccessClient != null) {
                noAccessClient.close();
            }
        }
    }

    /**
     * Test basic writes to a namedGraph using the default acls created for a named graph
     * 
     * @throws Exception
     */
    public void testAddNamedGraphNoAccess() throws Exception {

        AnzoClient noAccessClient = null;
        try {

            noAccessClient = new AnzoClient(getClientConfiguration("defaultNoRights", "123"));
            noAccessClient.connect();
            noAccessClient.reset(loadStatements("initialize.trig"), null);

            boolean exceptionThrown = false;
            ClientGraph defaultNoAccessGraph = noAccessClient.getServerGraph(GRAPH_URI);
            try {
                defaultNoAccessGraph.add(stmt1);
                noAccessClient.updateRepository();
            } catch (AnzoException ae) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown);

            assertFalse(defaultNoAccessGraph.contains(stmt1));

        } finally {

            if (noAccessClient != null) {
                noAccessClient.close();
            }
        }
    }

    /**
     * Test basic writes to a namedGraph using the custom acls created for a named graph
     * 
     * @throws Exception
     */
    public void testReadWritePermissions() throws Exception {

        AnzoClient defaultClient = null;
        AnzoClient sysadminClient = null;
        try {

            defaultClient = new AnzoClient(getDefaultClientConfiguration());
            defaultClient.connect();
            defaultClient.reset(loadStatements("initialize.trig"), null);

            sysadminClient = new AnzoClient(getSystemClientConfiguration());
            sysadminClient.connect();

            sysadminClient.begin();
            ClientGraph sysAdminGraph = sysadminClient.getReplicaGraph(GRAPH_URI);
            URI metaURI = UriGenerator.generateMetadataGraphUri(GRAPH_URI);
            ACLUtil.setReadPermission(sysAdminGraph, USERS_ROLE_URI, true);

            ACLUtil.setReadMetadataPermission(sysAdminGraph, USERS_ROLE_URI, true);
            ACLUtil.setAddMetadataPermission(sysAdminGraph, USERS_ROLE_URI, true);
            ACLUtil.setRemoveMetadataPermission(sysAdminGraph, USERS_ROLE_URI, true);

            sysAdminGraph.add(stmt1);
            sysadminClient.commit();
            sysadminClient.updateRepository();

            assertEquals(true, sysadminClient.namedGraphExists(GRAPH_URI));
            assertEquals(true, defaultClient.namedGraphExists(GRAPH_URI));

            Set<URI> sysAdminGraphs = sysadminClient.getNamedGraphs();
            assertTrue(sysAdminGraphs.contains(GRAPH_URI));
            Set<URI> defaultGraphs = defaultClient.getNamedGraphs();
            assertTrue(defaultGraphs.contains(GRAPH_URI));

            assertTrue(defaultClient.canReadNamedGraph(GRAPH_URI));
            assertFalse(defaultClient.canAddToNamedGraph(GRAPH_URI));
            assertFalse(defaultClient.canRemoveFromNamedGraph(GRAPH_URI));

            assertTrue(defaultClient.canReadNamedGraph(metaURI));
            assertTrue(defaultClient.canAddToNamedGraph(metaURI));
            assertTrue(defaultClient.canRemoveFromNamedGraph(metaURI));

            assertTrue(sysadminClient.canReadNamedGraph(GRAPH_URI));
            assertTrue(sysadminClient.canAddToNamedGraph(GRAPH_URI));
            assertTrue(sysadminClient.canRemoveFromNamedGraph(GRAPH_URI));

            boolean exceptionThrown = false;
            ClientGraph defaultGraph = defaultClient.getServerGraph(GRAPH_URI);
            try {
                defaultClient.updateRepository();
                assertEquals(1, defaultGraph.size());
            } catch (AnzoException ae) {
                exceptionThrown = true;
            }
            assertFalse(exceptionThrown);
            try {
                defaultGraph.add(stmt2);
                defaultClient.updateRepository();
            } catch (AnzoException ae) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown);

            exceptionThrown = false;
            ACLUtil.setAddPermission(sysAdminGraph, USERS_ROLE_URI, true);
            sysadminClient.updateRepository();
            try {
                defaultGraph.add(stmt2);
                defaultClient.updateRepository();
            } catch (AnzoException ae) {
                exceptionThrown = true;
            }
            assertFalse(exceptionThrown);
            assertTrue(defaultClient.canReadNamedGraph(GRAPH_URI));
            assertTrue(defaultClient.canAddToNamedGraph(GRAPH_URI));
            assertFalse(defaultClient.canRemoveFromNamedGraph(GRAPH_URI));

            try {
                defaultGraph.remove(stmt2);
                defaultClient.updateRepository();
            } catch (AnzoException ae) {
                exceptionThrown = true;
            }
            assertTrue(exceptionThrown);
            exceptionThrown = false;
            ACLUtil.setRemovePermission(sysAdminGraph, USERS_ROLE_URI, true);
            sysadminClient.updateRepository();
            try {
                defaultGraph.remove(stmt2);
                defaultClient.updateRepository();
            } catch (AnzoException ae) {
                exceptionThrown = true;
            }
            assertFalse(exceptionThrown);
            assertTrue(defaultClient.canReadNamedGraph(GRAPH_URI));
            assertTrue(defaultClient.canAddToNamedGraph(GRAPH_URI));
            assertTrue(defaultClient.canRemoveFromNamedGraph(GRAPH_URI));

            defaultGraph.close();
            ACLUtil.setReadPermission(sysAdminGraph, USERS_ROLE_URI, false);
            sysadminClient.updateRepository();
            assertFalse(defaultClient.canReadNamedGraph(GRAPH_URI));
            assertFalse(defaultClient.namedGraphExists(GRAPH_URI));
            try {
                defaultGraph = defaultClient.getServerGraph(GRAPH_URI);
                defaultClient.updateRepository();
                assertFalse(defaultClient.namedGraphExists(GRAPH_URI));
                defaultGraph.size();
            } catch (AnzoException ae) {
                exceptionThrown = true;
            }
            //assertTrue(exceptionThrown);
        } finally {
            if (defaultClient != null) {
                defaultClient.close();
            }

            if (sysadminClient != null) {
                sysadminClient.close();
            }

        }
    }

    /**
     * @throws Exception
     */
    public void testTemplateGraphAclsAreNotAppliedIfAclsAreAlreadySupplied() throws Exception {

        AnzoClient defaultClient = null;
        try {

            defaultClient = new AnzoClient(getDefaultClientConfiguration());
            defaultClient.connect();
            defaultClient.reset(loadStatements("initialize.trig"), null);

            // Get a graph to see what the template ACLs are like for the running server.            
            AnzoGraph graphA = defaultClient.getReplicaGraph(GRAPH_URI);
            defaultClient.updateRepository();

            // Verify that the template added ACLs for all actions (add/remove/read) for the graph just created.
            // This test assumes the server is configured with such a template and this verifies that that indeed is the case.
            assertTrue(graphA.getMetadataGraph().contains(graphA.getNamedGraphUri(), NamedGraph.canBeReadByProperty, null));
            assertTrue(graphA.getMetadataGraph().contains(graphA.getNamedGraphUri(), NamedGraph.canBeAddedToByProperty, null));
            assertTrue(graphA.getMetadataGraph().contains(graphA.getNamedGraphUri(), NamedGraph.canBeRemovedFromByProperty, null));
            int templateReadAclStatementCount = graphA.getMetadataGraph().find(graphA.getNamedGraphUri(), NamedGraph.canBeReadByProperty, null).size();
            int templateAddAclStatementCount = graphA.getMetadataGraph().find(graphA.getNamedGraphUri(), NamedGraph.canBeAddedToByProperty, null).size();
            int templateRemoveAclStatementCount = graphA.getMetadataGraph().find(graphA.getNamedGraphUri(), NamedGraph.canBeRemovedFromByProperty, null).size();

            // Now create a new graph which we'll prime with a custom read ACL.
            URI customUserUri = Constants.valueFactory.createURI("http://example.org/arbitraryUser");
            {
                defaultClient.begin();
                AnzoGraph graphB = defaultClient.getReplicaGraph(GRAPH_URI_2);
                Statement customReadAcl = new Statement(graphB.getNamedGraphUri(), NamedGraph.canBeReadByProperty, customUserUri);
                Statement currentUserRead = new Statement(graphB.getNamedGraphUri(), NamedGraph.canBeReadByProperty, USERS_ROLE_URI);
                // Ensure these custom ACLs are different than anything in the default template
                assertFalse(graphA.getMetadataGraph().contains(graphA.getNamedGraphUri(), NamedGraph.canBeReadByProperty, customUserUri));
                assertFalse(graphA.getMetadataGraph().contains(graphA.getNamedGraphUri(), NamedGraph.canBeReadByProperty, USERS_ROLE_URI));
                assertEquals(0, graphB.getMetadataGraph().find(graphB.getNamedGraphUri(), NamedGraph.canBeReadByProperty, null).size());
                graphB.getMetadataGraph().add(customReadAcl);
                graphB.getMetadataGraph().add(currentUserRead);
                defaultClient.commit();
                defaultClient.updateRepository();
                // Now verify that only the statements we added about read exist in the metadata graph
                assertTrue(graphB.getMetadataGraph().contains(customReadAcl));
                assertTrue(graphB.getMetadataGraph().contains(currentUserRead));
                assertEquals(2, graphB.getMetadataGraph().find(graphB.getNamedGraphUri(), NamedGraph.canBeReadByProperty, null).size());
                // Verify that the template triples were added for the actions for which we didn't give custom ACLs
                assertEquals(templateAddAclStatementCount, graphB.getMetadataGraph().find(graphB.getNamedGraphUri(), NamedGraph.canBeAddedToByProperty, null).size());
                assertEquals(templateRemoveAclStatementCount, graphB.getMetadataGraph().find(graphB.getNamedGraphUri(), NamedGraph.canBeRemovedFromByProperty, null).size());
            }

            {
                // Now create a new graph which we'll prime with a custom add ACL.
                defaultClient.begin();
                AnzoGraph graphC = defaultClient.getReplicaGraph(GRAPH_URI_3);
                Statement customAddAcl = new Statement(graphC.getNamedGraphUri(), NamedGraph.canBeAddedToByProperty, customUserUri);
                // Ensure these custom ACLs are different than anything in the default template
                assertFalse(graphA.getMetadataGraph().contains(graphA.getNamedGraphUri(), NamedGraph.canBeAddedToByProperty, customUserUri));
                assertEquals(0, graphC.getMetadataGraph().find(graphC.getNamedGraphUri(), NamedGraph.canBeAddedToByProperty, null).size());
                graphC.getMetadataGraph().add(customAddAcl);
                defaultClient.commit();
                defaultClient.updateRepository();
                // Now verify that only the statements we added about read exist in the metadata graph
                assertTrue(graphC.getMetadataGraph().contains(customAddAcl));
                assertEquals(1, graphC.getMetadataGraph().find(graphC.getNamedGraphUri(), NamedGraph.canBeAddedToByProperty, null).size());
                // Verify that the template triples were added for the actions for which we didn't give custom ACLs
                assertEquals(templateReadAclStatementCount, graphC.getMetadataGraph().find(graphC.getNamedGraphUri(), NamedGraph.canBeReadByProperty, null).size());
                assertEquals(templateRemoveAclStatementCount, graphC.getMetadataGraph().find(graphC.getNamedGraphUri(), NamedGraph.canBeRemovedFromByProperty, null).size());
            }

            {
                // Now create a new graph which we'll prime with a custom remove ACL.
                defaultClient.begin();
                AnzoGraph graphC = defaultClient.getReplicaGraph(GRAPH_URI_4);
                Statement customRemoveAcl = new Statement(graphC.getNamedGraphUri(), NamedGraph.canBeRemovedFromByProperty, customUserUri);
                // Ensure these custom ACLs are different than anything in the default template
                assertFalse(graphA.getMetadataGraph().contains(graphA.getNamedGraphUri(), NamedGraph.canBeRemovedFromByProperty, customUserUri));
                assertEquals(0, graphC.getMetadataGraph().find(graphC.getNamedGraphUri(), NamedGraph.canBeRemovedFromByProperty, null).size());
                graphC.getMetadataGraph().add(customRemoveAcl);
                defaultClient.commit();
                defaultClient.updateRepository();
                // Now verify that only the statements we added about read exist in the metadata graph
                assertTrue(graphC.getMetadataGraph().contains(customRemoveAcl));
                assertEquals(1, graphC.getMetadataGraph().find(graphC.getNamedGraphUri(), NamedGraph.canBeRemovedFromByProperty, null).size());
                // Verify that the template triples were added for the actions for which we didn't give custom ACLs
                assertEquals(templateReadAclStatementCount, graphC.getMetadataGraph().find(graphC.getNamedGraphUri(), NamedGraph.canBeReadByProperty, null).size());
                assertEquals(templateAddAclStatementCount, graphC.getMetadataGraph().find(graphC.getNamedGraphUri(), NamedGraph.canBeAddedToByProperty, null).size());
            }
        } finally {
            if (defaultClient != null) {
                defaultClient.close();
            }
        }
    }

    /**
     * Tests the ACL protection for graph removal to make sure you can only delete a graph if you have adequate permissions.
     * 
     * @throws Exception
     */
    public void testDeleteGraphProtection() throws Exception {

        AnzoClient defaultClient = null;
        try {

            defaultClient = new AnzoClient(getDefaultClientConfiguration());
            defaultClient.connect();
            defaultClient.reset(loadStatements("initialize.trig"), null);

            // First, let's make sure that a regular user can actually delete graphs.
            // For this, we need to give the user remove access to the graphs dataset
            AnzoClient sysadminClient = null;
            try {
                sysadminClient = new AnzoClient(getSystemClientConfiguration());
                sysadminClient.connect();
                AnzoGraph graph = sysadminClient.getServerGraph(Constants.GRAPHS.GRAPHS_DATASET);
                ACLUtil.setRemovePermission(graph, defaultClient.getServicePrincipal().getUserURI(), true);
                sysadminClient.updateRepository();
            } finally {
                if (sysadminClient != null) {
                    sysadminClient.close();
                    sysadminClient = null;
                }
            }

            {
                // Make a graph to which we only have Read access to the graph and only read access to the metadata graph.
                // We should NOT be able to delete this graph since we can't remove from the metadata graph.
                defaultClient.begin();
                AnzoGraph graph = defaultClient.getReplicaGraph(GRAPH_URI);
                URI metaURI = UriGenerator.generateMetadataGraphUri(graph.getNamedGraphUri());
                Statement stmt1 = new Statement(Constants.valueFactory.createURI("http://example.org/subj1"), Constants.valueFactory.createURI("http://example.org/pred1"), Constants.valueFactory.createURI("http://example.org/obj1"));
                graph.add(stmt1);
                ACLUtil.setReadPermission(graph, Constants.EVERYONE_ROLE, true);
                ACLUtil.setReadMetadataPermission(graph, Constants.EVERYONE_ROLE, true);
                ACLUtil.setAddPermission(graph, Constants.NOONE_ROLE, true);
                ACLUtil.setAddMetadataPermission(graph, Constants.NOONE_ROLE, true);
                ACLUtil.setRemovePermission(graph, Constants.NOONE_ROLE, true);
                ACLUtil.setRemoveMetadataPermission(graph, Constants.NOONE_ROLE, true);
                defaultClient.commit();
                defaultClient.updateRepository();
                assertTrue(graph.contains(stmt1));
                // Verify the access control is as we expect
                assertTrue(defaultClient.canReadNamedGraph(graph.getNamedGraphUri()));
                assertFalse(defaultClient.canAddToNamedGraph(graph.getNamedGraphUri()));
                assertFalse(defaultClient.canRemoveFromNamedGraph(graph.getNamedGraphUri()));
                assertTrue(defaultClient.canReadNamedGraph(metaURI));
                assertFalse(defaultClient.canAddToNamedGraph(metaURI));
                assertFalse(defaultClient.canRemoveFromNamedGraph(metaURI));
                // Now try to delete the graph
                graph.getMetadataGraph().remove(graph.getNamedGraphUri(), RDF.TYPE, NamedGraph.TYPE);
                boolean exceptionThrown = false;
                try {
                    defaultClient.updateRepository();
                } catch (AnzoException e) {
                    exceptionThrown = true;
                }
                assertTrue(exceptionThrown);
            }

            {
                // Make a graph to which we only have read and add access (no remove) to the graph and read plus remove (no add) access to the metadata graph.
                // We should be able to delete this graph since we can't remove from the graph.
                defaultClient.begin();
                AnzoGraph graph = defaultClient.getReplicaGraph(GRAPH_URI_2);
                URI metaURI = UriGenerator.generateMetadataGraphUri(graph.getNamedGraphUri());
                Statement stmt1 = new Statement(Constants.valueFactory.createURI("http://example.org/subj1"), Constants.valueFactory.createURI("http://example.org/pred1"), Constants.valueFactory.createURI("http://example.org/obj1"));
                graph.add(stmt1);
                ACLUtil.setReadPermission(graph, Constants.EVERYONE_ROLE, true);
                ACLUtil.setReadMetadataPermission(graph, Constants.EVERYONE_ROLE, true);
                ACLUtil.setAddPermission(graph, Constants.EVERYONE_ROLE, true);
                ACLUtil.setAddMetadataPermission(graph, Constants.NOONE_ROLE, true);
                ACLUtil.setRemovePermission(graph, Constants.NOONE_ROLE, true);
                ACLUtil.setRemoveMetadataPermission(graph, Constants.EVERYONE_ROLE, true);
                defaultClient.commit();
                defaultClient.updateRepository();
                assertTrue(graph.contains(stmt1));
                // Verify the access control is as we expect
                assertTrue(defaultClient.canReadNamedGraph(graph.getNamedGraphUri()));
                assertTrue(defaultClient.canAddToNamedGraph(graph.getNamedGraphUri()));
                assertFalse(defaultClient.canRemoveFromNamedGraph(graph.getNamedGraphUri()));
                assertTrue(defaultClient.canReadNamedGraph(metaURI));
                assertFalse(defaultClient.canAddToNamedGraph(metaURI));
                assertTrue(defaultClient.canRemoveFromNamedGraph(metaURI));
                // Now try to delete the graph
                graph.getMetadataGraph().remove(graph.getNamedGraphUri(), RDF.TYPE, NamedGraph.TYPE);
                boolean exceptionThrown = false;
                try {
                    defaultClient.updateRepository();
                } catch (AnzoException e) {
                    exceptionThrown = true;
                }
                assertFalse(exceptionThrown);
            }

            {
                // Make a graph to which we only have read and remove access (no add) to the graph and read plus add (no remove) access to the metadata graph.
                // We should Not be able to delete this graph since we have remove access to the graph and to the "graphs dataset".
                defaultClient.begin();
                AnzoGraph graph = defaultClient.getReplicaGraph(GRAPH_URI_3);
                URI metaURI = UriGenerator.generateMetadataGraphUri(graph.getNamedGraphUri());
                Statement stmt1 = new Statement(Constants.valueFactory.createURI("http://example.org/subj1"), Constants.valueFactory.createURI("http://example.org/pred1"), Constants.valueFactory.createURI("http://example.org/obj1"));
                graph.add(stmt1);
                ACLUtil.setReadPermission(graph, Constants.EVERYONE_ROLE, true);
                ACLUtil.setReadMetadataPermission(graph, Constants.EVERYONE_ROLE, true);
                ACLUtil.setAddPermission(graph, Constants.NOONE_ROLE, true);
                ACLUtil.setAddMetadataPermission(graph, Constants.EVERYONE_ROLE, true);
                ACLUtil.setRemovePermission(graph, Constants.EVERYONE_ROLE, true);
                ACLUtil.setRemoveMetadataPermission(graph, Constants.NOONE_ROLE, true);
                defaultClient.commit();
                defaultClient.updateRepository();
                assertTrue(graph.contains(stmt1));
                // Verify the access control is as we expect
                assertTrue(defaultClient.canReadNamedGraph(graph.getNamedGraphUri()));
                assertFalse(defaultClient.canAddToNamedGraph(graph.getNamedGraphUri()));
                assertTrue(defaultClient.canRemoveFromNamedGraph(graph.getNamedGraphUri()));
                assertTrue(defaultClient.canReadNamedGraph(metaURI));
                assertTrue(defaultClient.canAddToNamedGraph(metaURI));
                assertFalse(defaultClient.canRemoveFromNamedGraph(metaURI));
                // Now try to delete the graph
                graph.getMetadataGraph().remove(graph.getNamedGraphUri(), RDF.TYPE, NamedGraph.TYPE);
                boolean exceptionThrown = false;
                try {
                    defaultClient.updateRepository();
                } catch (AnzoException e) {
                    exceptionThrown = true;
                }
                assertTrue(exceptionThrown);
            }

            // Now remove the 'default' user's permission to remove from the "graphs dataset". This means that the
            // previously successful delete of a graph should now be unsuccessful. 
            try {
                sysadminClient = new AnzoClient(getSystemClientConfiguration());
                sysadminClient.connect();
                AnzoGraph graph = sysadminClient.getServerGraph(Constants.GRAPHS.GRAPHS_DATASET);
                ACLUtil.setRemovePermission(graph, defaultClient.getServicePrincipal().getUserURI(), false);
                sysadminClient.updateRepository();
            } finally {
                if (sysadminClient != null) {
                    sysadminClient.close();
                    sysadminClient = null;
                }
            }

            {
                // Make a graph to which we only have read and remove access (no add) to the graph and read plus add (no remove) access to the metadata graph.
                // While we have what we need to delete this graph, we don't have remove access to the "graphs dataset" so this should fail.
                defaultClient.begin();
                AnzoGraph graph = defaultClient.getReplicaGraph(GRAPH_URI_4);
                URI metaURI = UriGenerator.generateMetadataGraphUri(graph.getNamedGraphUri());
                Statement stmt1 = new Statement(Constants.valueFactory.createURI("http://example.org/subj1"), Constants.valueFactory.createURI("http://example.org/pred1"), Constants.valueFactory.createURI("http://example.org/obj1"));
                graph.add(stmt1);
                ACLUtil.setReadPermission(graph, Constants.EVERYONE_ROLE, true);
                ACLUtil.setReadMetadataPermission(graph, Constants.EVERYONE_ROLE, true);
                ACLUtil.setAddPermission(graph, Constants.NOONE_ROLE, true);
                ACLUtil.setAddMetadataPermission(graph, Constants.EVERYONE_ROLE, true);
                ACLUtil.setRemovePermission(graph, Constants.EVERYONE_ROLE, true);
                ACLUtil.setRemoveMetadataPermission(graph, Constants.NOONE_ROLE, true);
                defaultClient.commit();
                defaultClient.updateRepository();
                assertTrue(graph.contains(stmt1));
                // Verify the access control is as we expect
                assertTrue(defaultClient.canReadNamedGraph(graph.getNamedGraphUri()));
                assertFalse(defaultClient.canAddToNamedGraph(graph.getNamedGraphUri()));
                assertTrue(defaultClient.canRemoveFromNamedGraph(graph.getNamedGraphUri()));
                assertTrue(defaultClient.canReadNamedGraph(metaURI));
                assertTrue(defaultClient.canAddToNamedGraph(metaURI));
                assertFalse(defaultClient.canRemoveFromNamedGraph(metaURI));
                // Now try to delete the graph
                graph.getMetadataGraph().remove(graph.getNamedGraphUri(), RDF.TYPE, NamedGraph.TYPE);
                boolean exceptionThrown = false;
                try {
                    defaultClient.updateRepository();
                } catch (AnzoException e) {
                    exceptionThrown = true;
                }
                assertTrue(exceptionThrown);
            }
        } finally {
            if (defaultClient != null) {
                defaultClient.close();
            }
        }
    }

    /**
     * Authenticated users like "default" and "sysadmin" should be members of the "Authenticated Users" role and the "Everyone" role.
     * 
     * @throws Exception
     */
    public void testUsersGetAuthenticatedUsersRole() throws Exception {

        // Test user, "default"
        {
            AnzoClient client = null;
            try {
                client = new AnzoClient(getDefaultClientConfiguration());
                client.connect();
                AnzoPrincipal principal = client.getServicePrincipal();
                assertNotNull(principal);
                assertFalse(principal.isAnonymous());
                assertFalse(principal.isSysadmin());
                assertEquals(DEFAULT_USER_URI, principal.getUserURI());
                assertEquals("default", principal.getName());
                assertEquals(expectedDefaultUserRoles, principal.getRoles());
            } finally {
                if (client != null) {
                    client.close();
                }
            }
        }

        // Test user, "sysadmin"
        {
            AnzoClient client = null;
            try {
                client = new AnzoClient(getSystemClientConfiguration());
                client.connect();
                AnzoPrincipal principal = client.getServicePrincipal();
                assertNotNull(principal);
                assertFalse(principal.isAnonymous());
                assertTrue(principal.isSysadmin());
                assertEquals(Constants.DEFAULT_SYSADMIN, principal.getUserURI());
                assertEquals("sysadmin", principal.getName());
                assertEquals(expectedSysadminUserRoles, principal.getRoles());
            } finally {
                if (client != null) {
                    client.close();
                }
            }
        }
    }

    /**
     * Anonymous users should NOT be in the "Authenticated Users" role but ARE in the "Everyone" role.
     * 
     * @throws Exception
     */
    public void testAnonymousDoesNotGetAuthenticatedUsersRole() throws Exception {

        // Test user, "anonymous"
        AnzoClient client = null;
        try {
            client = new AnzoClient(getAnonymousClientConfiguration());
            client.connect();
            AnzoPrincipal principal = client.getServicePrincipal();
            assertNotNull(principal);
            assertTrue(principal.isAnonymous());
            assertFalse(principal.isSysadmin());
            assertEquals(Constants.DEFAULT_ANONYMOUS, principal.getUserURI());
            assertEquals(Constants.DEFAULT_ANONYMOUS_USER, principal.getName());
            assertEquals(expectedAnonymousRoles, principal.getRoles());
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Tests that anonymous users can't read something that is designated as only readable by authenticated users.
     * 
     * @throws Exception
     */
    public void testAnonymousCannotReadAuthenticatedUserContent() throws Exception {

        // First create the content that we'll try to read as anonymous
        {
            AnzoClient client = null;
            try {
                client = new AnzoClient(getDefaultClientConfiguration());
                client.connect();
                client.reset(loadStatements("initialize.trig"), null);

                client.begin();
                ClientGraph graph = client.getReplicaGraph(GRAPH_URI);
                graph.add(stmt1);
                graph.add(stmt2);
                ACLUtil.setReadPermission(graph, Constants.AUTHENTICATED_USERS_ROLE, true);
                client.commit();
                client.updateRepository();

            } finally {
                if (client != null) {
                    client.close();
                }
            }
        }

        // Now log in as anonymous and try to read the data
        AnzoClient client = null;
        try {
            client = new AnzoClient(getAnonymousClientConfiguration());
            client.connect();

            assertFalse(client.namedGraphExists(GRAPH_URI));

            ClientGraph graph = client.getReplicaGraph(GRAPH_URI);
            assertFalse(graph.contains(stmt1));
            assertFalse(graph.contains(stmt2));
            assertEquals(0, graph.size());

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Tests that anonymous users can read content designated for 'everyone'.
     * 
     * @throws Exception
     */
    public void testAnonymousCanReadContentForEveryone() throws Exception {

        // First create the content that we'll try to read as anonymous
        {
            AnzoClient client = null;
            try {
                client = new AnzoClient(getDefaultClientConfiguration());
                client.connect();
                client.reset(loadStatements("initialize.trig"), null);

                client.begin();
                ClientGraph graph = client.getReplicaGraph(GRAPH_URI);
                graph.add(stmt1);
                graph.add(stmt2);
                ACLUtil.setReadPermission(graph, Constants.EVERYONE_ROLE, true);
                client.commit();
                client.updateRepository();

            } finally {
                if (client != null) {
                    client.close();
                }
            }
        }

        // Now log in as anonymous and try to read the data
        AnzoClient client = null;
        try {
            client = new AnzoClient(getAnonymousClientConfiguration());
            client.connect();

            assertTrue(client.namedGraphExists(GRAPH_URI));

            ClientGraph graph = client.getReplicaGraph(GRAPH_URI);
            assertTrue(graph.contains(stmt1));
            assertTrue(graph.contains(stmt2));
            assertEquals(2, graph.size());

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

    /**
     * Tests that anonymous users cannot write updates regardless of the permissions on the graph.
     * 
     * @throws Exception
     */
    public void testAnonymousUsersCannotWrite() throws Exception {

        // First create the content that we'll try to modify as anonymous
        {
            AnzoClient client = null;
            try {
                client = new AnzoClient(getDefaultClientConfiguration());
                client.connect();
                client.reset(loadStatements("initialize.trig"), null);

                client.begin();

                ClientGraph graph = client.getReplicaGraph(GRAPH_URI);
                graph.add(stmt1);
                graph.add(stmt2);
                ACLUtil.setReadPermission(graph, Constants.EVERYONE_ROLE, true);
                ACLUtil.setAddPermission(graph, Constants.EVERYONE_ROLE, true);
                ACLUtil.setRemovePermission(graph, Constants.EVERYONE_ROLE, true);

                // Let's give the anonymous role permission explicitly to make sure we still can't modify things in this case 
                ClientGraph graph2 = client.getReplicaGraph(GRAPH_URI_2);
                graph2.add(stmt1);
                graph2.add(stmt2);
                ACLUtil.setReadPermission(graph2, Constants.DEFAULT_ANONYMOUS, true);
                ACLUtil.setReadPermission(graph2, DEFAULT_USER_URI, true);
                ACLUtil.setAddPermission(graph2, Constants.DEFAULT_ANONYMOUS, true);
                ACLUtil.setRemovePermission(graph2, Constants.DEFAULT_ANONYMOUS, true);

                // We definitely shouldn't be allowed to write to this graph since anonymous isn't an authenticated
                // user besides the fact that updates aren't allowed regardless of permissions for anonymous users.
                ClientGraph graph3 = client.getReplicaGraph(GRAPH_URI_3);
                graph3.add(stmt1);
                graph3.add(stmt2);
                ACLUtil.setReadPermission(graph3, Constants.EVERYONE_ROLE, true);
                ACLUtil.setAddPermission(graph3, Constants.AUTHENTICATED_USERS_ROLE, true);
                ACLUtil.setRemovePermission(graph3, Constants.AUTHENTICATED_USERS_ROLE, true);

                client.commit();
                client.updateRepository();

            } finally {
                if (client != null) {
                    client.close();
                }
            }
        }

        // Now log in as anonymous and try to write the data
        AnzoClient client = null;
        try {
            client = new AnzoClient(getAnonymousClientConfiguration());
            client.connect();

            {
                assertTrue(client.namedGraphExists(GRAPH_URI));
                ClientGraph graph = client.getReplicaGraph(GRAPH_URI);
                assertEquals(2, graph.size());

                graph.add(stmt3);

                boolean expectedExceptionThrown = false;
                try {
                    client.updateRepository();
                } catch (AnzoException e) {
                    assertEquals(ExceptionConstants.SERVER.ANONYMOUS_UPDATE_NOT_ALLOWED_ERROR, e.getErrorCode());
                    expectedExceptionThrown = true;
                }
                assertTrue(expectedExceptionThrown);

                graph.remove(stmt1);

                expectedExceptionThrown = false;
                try {
                    client.updateRepository();
                } catch (AnzoException e) {
                    assertEquals(ExceptionConstants.SERVER.ANONYMOUS_UPDATE_NOT_ALLOWED_ERROR, e.getErrorCode());
                    expectedExceptionThrown = true;
                }
                assertTrue(expectedExceptionThrown);
            }

            {
                assertTrue(client.namedGraphExists(GRAPH_URI_2));
                ClientGraph graph = client.getReplicaGraph(GRAPH_URI_2);
                assertEquals(2, graph.size());

                graph.add(stmt3);

                boolean expectedExceptionThrown = false;
                try {
                    client.updateRepository();
                } catch (AnzoException e) {
                    assertEquals(ExceptionConstants.SERVER.ANONYMOUS_UPDATE_NOT_ALLOWED_ERROR, e.getErrorCode());
                    expectedExceptionThrown = true;
                }
                assertTrue(expectedExceptionThrown);

                graph.remove(stmt1);

                expectedExceptionThrown = false;
                try {
                    client.updateRepository();
                } catch (AnzoException e) {
                    assertEquals(ExceptionConstants.SERVER.ANONYMOUS_UPDATE_NOT_ALLOWED_ERROR, e.getErrorCode());
                    expectedExceptionThrown = true;
                }
                assertTrue(expectedExceptionThrown);
            }

            {
                assertTrue(client.namedGraphExists(GRAPH_URI_3));
                ClientGraph graph = client.getReplicaGraph(GRAPH_URI_3);
                assertEquals(2, graph.size());

                graph.add(stmt3);

                boolean expectedExceptionThrown = false;
                try {
                    client.updateRepository();
                } catch (AnzoException e) {
                    assertEquals(ExceptionConstants.SERVER.ANONYMOUS_UPDATE_NOT_ALLOWED_ERROR, e.getErrorCode());
                    expectedExceptionThrown = true;
                }
                assertTrue(expectedExceptionThrown);

                graph.remove(stmt1);

                expectedExceptionThrown = false;
                try {
                    client.updateRepository();
                } catch (AnzoException e) {
                    assertEquals(ExceptionConstants.SERVER.ANONYMOUS_UPDATE_NOT_ALLOWED_ERROR, e.getErrorCode());
                    expectedExceptionThrown = true;
                }
                assertTrue(expectedExceptionThrown);
            }

            {
                // Test creating a new graph as anonymous. It shouldn't be allowed
                ClientGraph graph = client.getReplicaGraph(GRAPH_URI_4);
                graph.add(stmt1);
                graph.add(stmt2);
                boolean expectedExceptionThrown = false;
                try {
                    client.updateRepository();
                } catch (AnzoException e) {
                    assertEquals(ExceptionConstants.SERVER.ANONYMOUS_UPDATE_NOT_ALLOWED_ERROR, e.getErrorCode());
                    expectedExceptionThrown = true;
                }
                assertTrue(expectedExceptionThrown);
            }

        } finally {
            if (client != null) {
                client.close();
            }
        }
    }

}
