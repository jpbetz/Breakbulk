/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/rdf/BlankNodeManager.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: BlankNodeManager.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf;

import java.util.HashSet;
import java.util.Stack;
import java.util.UUID;

import org.apache.commons.collections15.BidiMap;
import org.apache.commons.collections15.bidimap.DualHashBidiMap;
import org.openanzo.glitter.exception.InvalidBlankNodeLabelException;

/**
 * The {@link BlankNodeManager} is a factory for creating blank nodes. It allows the creation of a stack of scopes for blank node labels - blank nodes across
 * different scopes can share labels while maintaining their distinct identity.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class BlankNodeManager {

    private final Stack<BlankNodeLabelScope> labelScopes;

    private final HashSet<String>            allLabels;

    private final boolean                    prohibitLabelReuse;

    private static final String              USCORE = "_";

    private static final String              DASH   = "\\-";

    /**
     * 
     * @param prohibitLabelReuse
     *            If <tt>true</tt>, throws an {@link InvalidBlankNodeLabelException} if a blank node is created with a duplicate label to another blank node
     *            from a different scope.
     */
    public BlankNodeManager(boolean prohibitLabelReuse) {
        this.labelScopes = new Stack<BlankNodeLabelScope>();
        this.allLabels = new HashSet<String>();
        this.prohibitLabelReuse = prohibitLabelReuse;
        enterLabelScope();
    }

    /**
     * Push a new label scope onto the stack. Should be paired with {@link #exitLabelScope()}.
     */
    public void enterLabelScope() {
        this.labelScopes.push(new BlankNodeLabelScope());
    }

    /**
     * Pop a label scope off of the stack. Should pair with a previous call to {@link #enterLabelScope()}.
     */
    public void exitLabelScope() {
        this.labelScopes.pop();
    }

    private BlankNodeLabelScope currentLabelScope() {
        return this.labelScopes.peek();
    }

    /**
     * Returns a {@link BlankNode} for the given label. If there is an existing blank node in this scope with this label, that {@link BlankNode} gets returned.
     * Otherwise, a new blank node gets minted for this scope with this label.
     * 
     * @param label
     *            label of blanknode to convert
     * @return a {@link BlankNode} for the given label
     * @throws InvalidBlankNodeLabelException
     *             If this {@link BlankNodeManager} prohibits blank node label reuse and this <tt>label</tt> occurs in some other scope already.
     */
    public BlankNode getBlankNode(String label) throws InvalidBlankNodeLabelException {
        BlankNode bnode = currentLabelScope().label2bnode.get(label);
        if (bnode == null) {
            // SPARQL prohibits different label scopes from having
            // the same label
            if (this.prohibitLabelReuse && this.allLabels.contains(label))
                throw new InvalidBlankNodeLabelException(label);
            this.allLabels.add(label);
            if (label.startsWith(Constants.ANZO_BNODE_PREFIX) || label.startsWith(Constants.ANZO_BNODE)) {
                bnode = MemValueFactory.defaultFactory.createBNode(label);
            } else {
                if (prohibitLabelReuse) {
                    bnode = new MemBlankNode((label.startsWith(Constants.BNODE_PREFIX)) ? label.substring(Constants.BNODE_PREFIX.length()) : label);
                } else {
                    bnode = getBlankNode();
                }
            }
            currentLabelScope().label2bnode.put(label, bnode);
        }
        return bnode;
    }

    protected String getLabel(BlankNode blankNode) {
        return currentLabelScope().label2bnode.getKey(blankNode);
    }

    /**
     * A new {@link BlankNode} with an auto-generated label.
     * 
     * @return A new {@link BlankNode} with an auto-generated label.
     */
    public BlankNode getBlankNode() {
        BlankNode bnode = null;
        String label = generateBnodeString();
        bnode = new MemBlankNode(label);
        return bnode;
    }

    private static class BlankNodeLabelScope {

        private final BidiMap<String, BlankNode> label2bnode;

        private BlankNodeLabelScope() {
            this.label2bnode = new DualHashBidiMap<String, BlankNode>();
        }
    }

    protected static String generateBnodeString() {
        return (Constants.ANZO_BNODE + UUID.randomUUID().toString()).replaceAll(DASH, USCORE);
    }
}
