/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/src/com/ibm/adtech/boca/model/repository/update/ServerUpdatesProcessor.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  5/5/2006
 * Revision:    $Id: ServerUpdatesProcessor.java 180 2007-07-31 14:24:13Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.datasource.update;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import org.openanzo.datasource.IAuthorizationService;
import org.openanzo.datasource.IServerQuadStore;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.ontologies.openanzo.Dataset;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.datatype.TypeMaps;
import org.openanzo.rdf.utils.Collections;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.rdf.vocabulary.RDF;
import org.openanzo.services.Privilege;

/**
 * ServerUpdatesProcessor handles updates sent from the client, and applies them to the server
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class ServerQuadStoreUpdateHandler implements MultiStageUpdatesProcessor.NamedGraphUpdateHandler {

    //private static final Logger     log                             = LoggerFactory.getLogger(ServerQuadStoreUpdateHandler.class);

    private final IServerQuadStore        quadStore;

    private final ServerUpdateTransaction currentTransactionUpdateResults;

    private final boolean                 isReseting;

    private final HashMap<URI, Boolean>   canAdd               = new HashMap<URI, Boolean>();

    private final HashMap<URI, Boolean>   canRemove            = new HashMap<URI, Boolean>();

    private Boolean                       canInsertNamedGraphs = null;

    private Boolean                       canRemoveNamedGraphs = null;

    private final IAuthorizationService   authorizationService;

    private final HashMap<URI, URI>       namedGraphUUID       = new HashMap<URI, URI>();

    /**
     * ServerQuadStoreUpdateHandler
     * 
     * @param quadStore
     * @param currentTransactionUpdateResults
     * @param authorizationService
     * @param isReseting
     */
    public ServerQuadStoreUpdateHandler(IServerQuadStore quadStore, ServerUpdateTransaction currentTransactionUpdateResults, IAuthorizationService authorizationService, boolean isReseting) {
        this.quadStore = quadStore;
        this.currentTransactionUpdateResults = currentTransactionUpdateResults;
        this.isReseting = isReseting;
        this.authorizationService = authorizationService;
    }

    public boolean handleStatement(boolean additions, boolean noAclCheck, Statement statement) throws AnzoException {
        if (currentTransactionUpdateResults.hasError()) {
            return false;
        }
        if (additions) {
            if (noAclCheck || isReseting || currentTransactionUpdateResults.getServerPrincipal().isSysadmin() || checkAddAccess(statement.getNamedGraphUri())) {
                quadStore.add(statement);
                return true;
            } else {
                throw new AnzoException(ExceptionConstants.DATASOURCE.NO_ADD_ERROR, statement.getSubject().toString(), statement.getPredicate().toString(), statement.getObject().toString(), statement.getNamedGraphUri().toString());
            }
        } else {
            if (noAclCheck || isReseting || currentTransactionUpdateResults.getServerPrincipal().isSysadmin() || checkRemoveAccess(statement.getNamedGraphUri())) {
                quadStore.remove(statement);
                return true;
            } else {
                throw new AnzoException(ExceptionConstants.DATASOURCE.NO_REMOVE_ERROR, statement.getSubject().toString(), statement.getPredicate().toString(), statement.getObject().toString(), statement.getNamedGraphUri().toString());
            }
        }

    }

    public boolean handleAddPrivilege(Statement statement) throws AnzoException {
        currentTransactionUpdateResults.getAclAdditions().add(statement);
        URI namedGraphUri = (URI) statement.getSubject();
        URI privilege = statement.getPredicate();
        URI role = (URI) statement.getObject();

        if (privilege.equals(NamedGraph.canBeAddedToByProperty) && currentTransactionUpdateResults.getServerPrincipal().getRoles().contains(role)) {
            canAdd.put(namedGraphUri, Boolean.valueOf(true));
        } else if (privilege.equals(NamedGraph.canBeRemovedFromByProperty) && currentTransactionUpdateResults.getServerPrincipal().getRoles().contains(role)) {
            canRemove.put(namedGraphUri, Boolean.valueOf(true));
        }
        quadStore.addAcl(namedGraphUri, role, privilege.equals(NamedGraph.canBeAddedToByProperty) ? Privilege.ADD : privilege.equals(NamedGraph.canBeRemovedFromByProperty) ? Privilege.REMOVE : Privilege.READ);
        return true;
    }

    public boolean handleRemovePrivilege(Statement statement) throws AnzoException {
        currentTransactionUpdateResults.getAclRemovals().add(statement);
        URI namedGraphUri = (URI) statement.getSubject();
        URI privilege = statement.getPredicate();
        URI role = (URI) statement.getObject();
        if (privilege.equals(NamedGraph.canBeAddedToByProperty) && currentTransactionUpdateResults.getServerPrincipal().getRoles().contains(role)) {
            canAdd.remove(namedGraphUri);
        } else if (privilege.equals(NamedGraph.canBeRemovedFromByProperty) && currentTransactionUpdateResults.getServerPrincipal().getRoles().contains(role)) {
            canRemove.remove(namedGraphUri);
        }
        quadStore.removeAcl(namedGraphUri, role, privilege.equals(NamedGraph.canBeAddedToByProperty) ? Privilege.ADD : privilege.equals(NamedGraph.canBeRemovedFromByProperty) ? Privilege.REMOVE : Privilege.READ);
        return true;
    }

    private URI getNamedGraphUUID(URI namedGraphUri) throws AnzoException {
        URI uuid = namedGraphUUID.get(namedGraphUri);
        if (uuid == null) {
            uuid = quadStore.getNamedGraphUUID(namedGraphUri);
            if (uuid != null) {
                namedGraphUUID.put(namedGraphUri, uuid);
            }
        }
        return uuid;
    }

    public boolean handleAddNamedGraph(URI namedGraphUri, URI metadataGraphUri, MultiStageUpdatesProcessor.AclSet aclSet, MultiStageUpdatesProcessor.AclSet metaAclSet, boolean revisioned, boolean persisted, Collection<Statement> extraStatements) throws AnzoException {
        if (currentTransactionUpdateResults.hasError()) {
            return false;
        }
        if (namedGraphUri.toString().startsWith(NAMESPACES.NAMEDGRAPH_PREFIX + "reserved/")) {
            throw new AnzoException(ExceptionConstants.DATASOURCE.NO_ADD_RESERVED_URI, namedGraphUri.toString());
        }
        URI uuid = getNamedGraphUUID(namedGraphUri);

        boolean canAddTo = false;
        if (uuid == null) {
            boolean canAdd = isReseting || currentTransactionUpdateResults.getServerPrincipal().isSysadmin() || checkInsertNamedGraphAccess(GRAPHS.GRAPHS_DATASET);
            if (canAdd) {
                if (metadataGraphUri == null) {
                    metadataGraphUri = UriGenerator.generateMetadataGraphUri(namedGraphUri);
                }
                this.canAdd.put(namedGraphUri, true);
                this.canAdd.put(metadataGraphUri, true);
                this.canRemove.put(namedGraphUri, true);
                this.canRemove.put(metadataGraphUri, true);
                uuid = (revisioned) ? UriGenerator.generateNamedGraphUUIDRevisioned() : UriGenerator.generateNamedGraphUUIDNonRevisioned();
                quadStore.addNewNamedGraph(namedGraphUri, metadataGraphUri, uuid, revisioned ? NamedGraphType.REVISIONED : (persisted ? NamedGraphType.NON_REVISIONED_PERSISTED : NamedGraphType.NON_REVISIONED_NON_PERSISTED));
                if (!namedGraphUri.equals(GRAPHS.GRAPHS_DATASET) && !namedGraphUri.equals(GRAPHS.METADATA_GRAPHS_DATASET)) {
                    handleStatement(true, true, Constants.valueFactory.createStatement(GRAPHS.GRAPHS_DATASET, Dataset.namedGraphProperty, namedGraphUri, GRAPHS.GRAPHS_DATASET));
                    handleStatement(true, true, Constants.valueFactory.createStatement(GRAPHS.METADATA_GRAPHS_DATASET, Dataset.namedGraphProperty, metadataGraphUri, GRAPHS.METADATA_GRAPHS_DATASET));
                }
                URI userUri = null;
                if (isReseting) {
                    userUri = (currentTransactionUpdateResults.getServerPrincipal() == null) ? Constants.DEFAULT_INTERNAL_USER : currentTransactionUpdateResults.getServerPrincipal().getUserURI();
                } else {
                    userUri = currentTransactionUpdateResults.getServerPrincipal().getUserURI();
                }

                namedGraphUUID.put(namedGraphUri, uuid);
                quadStore.add(Constants.valueFactory.createStatement(namedGraphUri, RDF.TYPE, NamedGraph.TYPE, metadataGraphUri));
                quadStore.add(Constants.valueFactory.createStatement(namedGraphUri, NamedGraph.hasMetadataGraphProperty, metadataGraphUri, metadataGraphUri));
                quadStore.add(Constants.valueFactory.createStatement(namedGraphUri, org.openanzo.ontologies.openanzo.NamedGraph.uuidProperty, uuid, metadataGraphUri));
                quadStore.add(Constants.valueFactory.createStatement(namedGraphUri, org.openanzo.ontologies.openanzo.NamedGraph.createdProperty, Constants.valueFactory.createTypedLiteral(TypeMaps.getXMLCaledar(currentTransactionUpdateResults.getTransactionTimestamp())), metadataGraphUri));
                quadStore.add(Constants.valueFactory.createStatement(namedGraphUri, org.openanzo.ontologies.openanzo.NamedGraph.createdByProperty, userUri, metadataGraphUri));
                quadStore.add(Constants.valueFactory.createStatement(namedGraphUri, org.openanzo.ontologies.openanzo.NamedGraph.datasourceProperty, quadStore.getInstanceURI(), metadataGraphUri));

                if (!metaAclSet.aclMap.containsKey(NamedGraph.canBeReadByProperty) && !Constants.DEFAULT_SYSADMIN.equals(currentTransactionUpdateResults.getServerPrincipal().getUserURI())) {
                    handleStatement(true, true, Constants.valueFactory.createStatement(metadataGraphUri, NamedGraph.canBeReadByProperty, currentTransactionUpdateResults.getServerPrincipal().getUserURI(), metadataGraphUri));
                    quadStore.addAcl(metadataGraphUri, currentTransactionUpdateResults.getServerPrincipal().getUserURI(), Privilege.READ);
                }
                if (!metaAclSet.aclMap.containsKey(NamedGraph.canBeAddedToByProperty) && !Constants.DEFAULT_SYSADMIN.equals(currentTransactionUpdateResults.getServerPrincipal().getUserURI())) {
                    handleStatement(true, true, Constants.valueFactory.createStatement(metadataGraphUri, NamedGraph.canBeAddedToByProperty, currentTransactionUpdateResults.getServerPrincipal().getUserURI(), metadataGraphUri));
                    quadStore.addAcl(metadataGraphUri, currentTransactionUpdateResults.getServerPrincipal().getUserURI(), Privilege.ADD);
                }
                if (!metaAclSet.aclMap.containsKey(NamedGraph.canBeRemovedFromByProperty) && !Constants.DEFAULT_SYSADMIN.equals(currentTransactionUpdateResults.getServerPrincipal().getUserURI())) {
                    handleStatement(true, true, Constants.valueFactory.createStatement(metadataGraphUri, NamedGraph.canBeRemovedFromByProperty, currentTransactionUpdateResults.getServerPrincipal().getUserURI(), metadataGraphUri));
                    quadStore.addAcl(metadataGraphUri, currentTransactionUpdateResults.getServerPrincipal().getUserURI(), Privilege.REMOVE);
                }
                if (!aclSet.aclMap.containsKey(NamedGraph.canBeReadByProperty) && !Constants.DEFAULT_SYSADMIN.equals(currentTransactionUpdateResults.getServerPrincipal().getUserURI())) {
                    handleStatement(true, true, Constants.valueFactory.createStatement(namedGraphUri, NamedGraph.canBeReadByProperty, currentTransactionUpdateResults.getServerPrincipal().getUserURI(), metadataGraphUri));
                    quadStore.addAcl(namedGraphUri, currentTransactionUpdateResults.getServerPrincipal().getUserURI(), Privilege.READ);
                }
                if (!aclSet.aclMap.containsKey(NamedGraph.canBeAddedToByProperty) && !Constants.DEFAULT_SYSADMIN.equals(currentTransactionUpdateResults.getServerPrincipal().getUserURI())) {
                    handleStatement(true, true, Constants.valueFactory.createStatement(namedGraphUri, NamedGraph.canBeAddedToByProperty, currentTransactionUpdateResults.getServerPrincipal().getUserURI(), metadataGraphUri));
                    quadStore.addAcl(namedGraphUri, currentTransactionUpdateResults.getServerPrincipal().getUserURI(), Privilege.ADD);
                }
                if (!aclSet.aclMap.containsKey(NamedGraph.canBeRemovedFromByProperty) && !Constants.DEFAULT_SYSADMIN.equals(currentTransactionUpdateResults.getServerPrincipal().getUserURI())) {
                    handleStatement(true, true, Constants.valueFactory.createStatement(namedGraphUri, NamedGraph.canBeRemovedFromByProperty, currentTransactionUpdateResults.getServerPrincipal().getUserURI(), metadataGraphUri));
                    quadStore.addAcl(namedGraphUri, currentTransactionUpdateResults.getServerPrincipal().getUserURI(), Privilege.REMOVE);
                }

                for (Statement stmt : aclSet.aclMap.values()) {
                    quadStore.addAcl((URI) stmt.getSubject(), (URI) stmt.getObject(), stmt.getPredicate().equals(NamedGraph.canBeAddedToByProperty) ? Privilege.ADD : stmt.getPredicate().equals(NamedGraph.canBeRemovedFromByProperty) ? Privilege.REMOVE : Privilege.READ);
                }
                for (Statement stmt : metaAclSet.aclMap.values()) {
                    quadStore.addAcl((URI) stmt.getSubject(), (URI) stmt.getObject(), stmt.getPredicate().equals(NamedGraph.canBeAddedToByProperty) ? Privilege.ADD : stmt.getPredicate().equals(NamedGraph.canBeRemovedFromByProperty) ? Privilege.REMOVE : Privilege.READ);
                }
                canAddTo = true;
            } else {
                throw new AnzoException(ExceptionConstants.DATASOURCE.NO_INSERT_NAMEDGRAPH_ACL_ERROR, namedGraphUri.toString());
            }
        } else {
            if (metadataGraphUri == null) {
                metadataGraphUri = UriGenerator.generateMetadataGraphUri(namedGraphUri);
            }
            canAddTo = isReseting || currentTransactionUpdateResults.getServerPrincipal().isSysadmin() || checkAddAccess(metadataGraphUri);
            for (Statement stmt : aclSet.aclMap.values()) {
                handleAddPrivilege(stmt);

            }
            for (Statement stmt : metaAclSet.aclMap.values()) {
                handleAddPrivilege(stmt);
            }
        }
        if (canAddTo && extraStatements != null) {
            for (Statement stmt : extraStatements) {
                handleStatement(true, true, stmt);
            }
        }
        return true;
    }

    public boolean handleRemoveNamedGraph(URI namedGraphUri) throws AnzoException {
        if (currentTransactionUpdateResults.hasError()) {
            return false;
        }
        URI uuid = getNamedGraphUUID(namedGraphUri);
        if (uuid != null) {
            URI metadataGraphUri = UriGenerator.generateMetadataGraphUri(namedGraphUri);

            if (isReseting || currentTransactionUpdateResults.getServerPrincipal().isSysadmin() || checkRemoveNamedGraphAccess(metadataGraphUri, GRAPHS.GRAPHS_DATASET)) {
                quadStore.removeNamedGraph(namedGraphUri, uuid, currentTransactionUpdateResults.getTransactionTimestamp());
                if (!namedGraphUri.equals(GRAPHS.GRAPHS_DATASET) && !namedGraphUri.equals(GRAPHS.METADATA_GRAPHS_DATASET)) {
                    handleStatement(false, true, Constants.valueFactory.createStatement(GRAPHS.GRAPHS_DATASET, Dataset.namedGraphProperty, namedGraphUri, GRAPHS.GRAPHS_DATASET));
                    handleStatement(false, true, Constants.valueFactory.createStatement(GRAPHS.METADATA_GRAPHS_DATASET, Dataset.namedGraphProperty, metadataGraphUri, GRAPHS.METADATA_GRAPHS_DATASET));
                }
                return true;
            } else {
                throw new AnzoException(ExceptionConstants.DATASOURCE.NO_REMOVE_NAMEDGRAPH_ACL_ERROR, namedGraphUri.toString());
            }
        }
        return false;
    }

    private boolean checkAddAccess(URI namedGraphUri) throws AnzoException {
        if (isReseting) {
            return true;
        }
        Boolean can = canAdd.get(namedGraphUri);
        if (can == null) {
            Set<URI> roles = authorizationService.getRolesForGraph(currentTransactionUpdateResults.getContext(), namedGraphUri, Privilege.ADD);
            can = Boolean.valueOf(Collections.memberOf(roles, currentTransactionUpdateResults.getServerPrincipal().getRoles()));
            canAdd.put(namedGraphUri, can);
        }

        return can;
    }

    private boolean checkRemoveAccess(URI namedGraphUri) throws AnzoException {
        if (isReseting) {
            return true;
        }
        Boolean can = canRemove.get(namedGraphUri);
        if (can == null) {
            Set<URI> roles = authorizationService.getRolesForGraph(currentTransactionUpdateResults.getContext(), namedGraphUri, Privilege.REMOVE);
            can = Boolean.valueOf(Collections.memberOf(roles, currentTransactionUpdateResults.getServerPrincipal().getRoles()));
            canRemove.put(namedGraphUri, can);
        }

        return can;
    }

    private Boolean checkInsertNamedGraphAccess(URI datasetUri) throws AnzoException {
        if (isReseting) {
            return true;
        }
        if (canInsertNamedGraphs == null) {
            Set<URI> roles = authorizationService.getRolesForGraph(currentTransactionUpdateResults.getContext(), datasetUri, Privilege.ADD);
            canInsertNamedGraphs = Boolean.valueOf(Collections.memberOf(roles, currentTransactionUpdateResults.getServerPrincipal().getRoles()));
        }
        return canInsertNamedGraphs;
    }

    private boolean checkRemoveNamedGraphAccess(URI namedGraphUri, URI datasetUri) throws AnzoException {
        if (isReseting) {
            return true;
        }
        if (currentTransactionUpdateResults.getContext().getOperationPrincipal().isSysadmin()) {
            return true;
        }
        if (canRemoveNamedGraphs == null) {
            Set<URI> roles = authorizationService.getRolesForGraph(currentTransactionUpdateResults.getContext(), datasetUri, Privilege.REMOVE);
            canRemoveNamedGraphs = Boolean.valueOf(Collections.memberOf(roles, currentTransactionUpdateResults.getServerPrincipal().getRoles()));
        }
        if (canRemoveNamedGraphs) {
            Boolean can = canRemove.get(namedGraphUri);
            if (can == null) {
                Set<URI> roles = authorizationService.getRolesForGraph(currentTransactionUpdateResults.getContext(), namedGraphUri, Privilege.REMOVE);
                can = Boolean.valueOf(Collections.memberOf(roles, currentTransactionUpdateResults.getServerPrincipal().getRoles()));
                canRemove.put(namedGraphUri, can);
            }
            return can;
        }
        return false;
    }
}
