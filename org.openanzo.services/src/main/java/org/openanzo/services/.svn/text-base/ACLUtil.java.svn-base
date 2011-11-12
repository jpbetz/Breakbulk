/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/rdf/ACLUtil.java,v $
 * Created by:  Rouben Meschian (<a href="mailto:rmeschi@us.ibm.com">rmeschi@us.ibm.com</a>)
 * Created on:  6/5/2006
 * Revision:	$Id: ACLUtil.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.services;

import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IAnzoGraph;
import org.openanzo.rdf.URI;

/**
 * Convenience methods for accessing ACL data within ANZO metadata graphs
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class ACLUtil {

    /**
     * Sets the read permission on the given graph for the given role.
     * 
     * @param graph
     *            for which the ACL will be changed
     * @param role
     *            target role for which the permission is to be set
     * @param permission
     *            true to allow the given role permission to read statements from this graph, false otherwise
     */
    public static void setReadPermission(final IAnzoGraph graph, final URI role, final boolean permission) {
        if (permission)
            graph.getMetadataGraph().add(Constants.valueFactory.createStatement(graph.getNamedGraphUri(), NamedGraph.canBeReadByProperty, role));
        else
            graph.getMetadataGraph().remove(Constants.valueFactory.createStatement(graph.getNamedGraphUri(), NamedGraph.canBeReadByProperty, role));
    }

    /**
     * Sets the add permission on the given graph for the given role.
     * 
     * @param graph
     *            for which the ACL will be changed
     * @param role
     *            target role for which the permission is to be set
     * @param permission
     *            true to allow the given role permission to add statements to this graph, false otherwise
     */
    public static void setAddPermission(final IAnzoGraph graph, final URI role, final boolean permission) {
        if (permission)
            graph.getMetadataGraph().add(Constants.valueFactory.createStatement(graph.getNamedGraphUri(), NamedGraph.canBeAddedToByProperty, role));
        else
            graph.getMetadataGraph().remove(Constants.valueFactory.createStatement(graph.getNamedGraphUri(), NamedGraph.canBeAddedToByProperty, role));
    }

    /**
     * Sets the remove permission on the given graph for the given role.
     * 
     * @param graph
     *            for which the ACL will be changed
     * @param role
     *            target role for which the permission is to be set
     * @param permission
     *            true to allow the given role permission to remove statements from this graph, false otherwise
     */
    public static void setRemovePermission(final IAnzoGraph graph, final URI role, final boolean permission) {
        if (permission)
            graph.getMetadataGraph().add(Constants.valueFactory.createStatement(graph.getNamedGraphUri(), NamedGraph.canBeRemovedFromByProperty, role));
        else
            graph.getMetadataGraph().remove(Constants.valueFactory.createStatement(graph.getNamedGraphUri(), NamedGraph.canBeRemovedFromByProperty, role));
    }

    /**
     * Sets the read permission on the given graph for the given role.
     * 
     * @param graph
     *            for which the ACL will be changed
     * @param role
     *            target role for which the permission is to be set
     * @param permission
     *            true to allow the given role permission to read statements from this graph, false otherwise
     */
    public static void setReadMetadataPermission(final IAnzoGraph graph, final URI role, final boolean permission) {
        if (permission)
            graph.getMetadataGraph().add(Constants.valueFactory.createStatement(graph.getMetadataGraph().getNamedGraphUri(), NamedGraph.canBeReadByProperty, role));
        else
            graph.getMetadataGraph().remove(Constants.valueFactory.createStatement(graph.getMetadataGraph().getNamedGraphUri(), NamedGraph.canBeReadByProperty, role));
    }

    /**
     * Sets the add permission on the given graph for the given role.
     * 
     * @param graph
     *            for which the ACL will be changed
     * @param role
     *            target role for which the permission is to be set
     * @param permission
     *            true to allow the given role permission to add statements to this graph, false otherwise
     */
    public static void setAddMetadataPermission(final IAnzoGraph graph, final URI role, final boolean permission) {
        if (permission)
            graph.getMetadataGraph().add(Constants.valueFactory.createStatement(graph.getMetadataGraph().getNamedGraphUri(), NamedGraph.canBeAddedToByProperty, role));
        else
            graph.getMetadataGraph().remove(Constants.valueFactory.createStatement(graph.getMetadataGraph().getNamedGraphUri(), NamedGraph.canBeAddedToByProperty, role));
    }

    /**
     * Sets the remove permission on the given graph for the given role.
     * 
     * @param graph
     *            for which the ACL will be changed
     * @param role
     *            target role for which the permission is to be set
     * @param permission
     *            true to allow the given role permission to remove statements from this graph, false otherwise
     */
    public static void setRemoveMetadataPermission(final IAnzoGraph graph, final URI role, final boolean permission) {
        if (permission)
            graph.getMetadataGraph().add(Constants.valueFactory.createStatement(graph.getMetadataGraph().getNamedGraphUri(), NamedGraph.canBeRemovedFromByProperty, role));
        else
            graph.getMetadataGraph().remove(Constants.valueFactory.createStatement(graph.getMetadataGraph().getNamedGraphUri(), NamedGraph.canBeRemovedFromByProperty, role));
    }

    /**
     * Sets the permissions for the given role on the given named graph.
     * 
     * @param graph
     *            for which the ACL will be changed
     * @param role
     *            the target role for which permissions are being set for this graph
     * @param read
     *            true if role has permission to read, false otherwise
     * @param add
     *            true if role has permission to add statements, false otherwise
     * @param remove
     *            true if role has permission to remove statements, false otherwise
     * @param readMetadataGraph
     *            true if role has permission to create new NamedGraphs, false otherwise
     * @param addMetadataGraph
     *            true if role has permission to remove NamedGraphs, false otherwise
     * @param removeMetadataGraph
     *            true if role has permission to change the ACL of the NamedGraph, false otherwise
     */
    public static void setPermissions(final IAnzoGraph graph, URI role, boolean read, boolean add, boolean remove, boolean readMetadataGraph, boolean addMetadataGraph, boolean removeMetadataGraph) {
        setReadPermission(graph, role, read);
        setAddPermission(graph, role, add);
        setRemovePermission(graph, role, remove);
        setReadMetadataPermission(graph, role, readMetadataGraph);
        setAddMetadataPermission(graph, role, addMetadataGraph);
        setRemoveMetadataPermission(graph, role, removeMetadataGraph);

    }

}
