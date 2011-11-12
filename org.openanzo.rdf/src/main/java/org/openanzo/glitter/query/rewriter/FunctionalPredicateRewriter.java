/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/rewriter/FunctionalPredicateRewriter.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: FunctionalPredicateRewriter.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query.rewriter;

import java.util.ArrayList;
import java.util.Map;

import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.exception.FunctionalPredicateInvocationException;
import org.openanzo.glitter.exception.GlitterRuntimeException;
import org.openanzo.glitter.query.FunctionalPredicate;
import org.openanzo.glitter.query.QueryInformation;
import org.openanzo.glitter.query.TreeRewriter;
import org.openanzo.glitter.syntax.abstrakt.BGP;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;
import org.openanzo.glitter.syntax.abstrakt.TriplePatternNode;
import org.openanzo.rdf.TriplePattern;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A {@link FunctionalPredicateRewriter} takes a map from predicate URIs to {@link FunctionalPredicate} implementations and uses it to rewrite a query node that
 * contains a functional predicate by removing all triple patterns involved in the functional predicate and attaching the functional predicate to the BGP.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class FunctionalPredicateRewriter implements TreeRewriter {
    private static final Logger                                                   log              = LoggerFactory.getLogger(FunctionalPredicateRewriter.class);

    private final Map<org.openanzo.rdf.URI, Class<? extends FunctionalPredicate>> predicates;

    protected QueryInformation                                                    queryInformation = null;

    /**
     * Constructor
     * 
     * @param predicates
     *            Map from functional predicate URIs to functional predicate implementations.
     * @param qi
     *            The query information to pass on to the {@link FunctionalPredicate}
     */
    public FunctionalPredicateRewriter(Map<URI, Class<? extends FunctionalPredicate>> predicates, QueryInformation qi) {
        this.predicates = predicates;
        this.queryInformation = qi;
    }

    public TreeNode rewriteTreeNode(TreeNode node) {
        FunctionalPredicate fp;
        ArrayList<TriplePatternNode> toRemove;
        TriplePatternNode tpnFunctional;
        if (node instanceof BGP) {
            BGP bgp = (BGP) node;
            do {
                fp = null;
                toRemove = null;
                tpnFunctional = null;
                for (TriplePatternNode tpn : bgp.getTriplePatterns()) {
                    TriplePattern tp = tpn.getTriplePattern();
                    TriplePatternComponent tpc = tp.getPredicate();
                    if (tpc instanceof URI) {
                        Class<? extends FunctionalPredicate> fpClass = this.predicates.get(tpc);
                        if (fpClass != null) {
                            // This triple pattern involves a magic predicate
                            // We need to find out what other triple patterns in
                            // this BGP this particular functional predicate needs to
                            // work its magic.
                            try {
                                tpnFunctional = tpn;
                                fp = fpClass.newInstance();
                                if (this.queryInformation != null)
                                    fp.initialize(this.queryInformation);
                                fp.setFunctionalTriplePattern(tp);
                                toRemove = new ArrayList<TriplePatternNode>();
                                toRemove.add(tpn);
                                break;
                            } catch (FunctionalPredicateInvocationException e) {
                                log.debug(LogUtils.GLITTER_MARKER, "Error invoking functional predicate", e);
                            } catch (IllegalAccessException e) {
                                throw new GlitterRuntimeException(ExceptionConstants.GLITTER.UNEXPECTED, e);
                            } catch (InstantiationException e) {
                                throw new GlitterRuntimeException(ExceptionConstants.GLITTER.UNEXPECTED, e);
                            }
                        }
                    }
                }
                if (fp != null && toRemove != null && tpnFunctional != null) {
                    for (TriplePatternNode tpn : bgp.getTriplePatterns()) {
                        try {
                            if (tpn != tpnFunctional && fp.handlesTriplePattern(tpn.getTriplePattern()))
                                toRemove.add(tpn);
                        } catch (FunctionalPredicateInvocationException e) {
                            log.debug(LogUtils.GLITTER_MARKER, "Error invoking functional predicate", e);
                        }
                    }

                    BGP functionalBgp = new BGP();
                    for (TriplePatternNode tpn : toRemove) {
                        functionalBgp.addTriplePattern(tpn);
                        bgp.removeChild(tpn);
                    }
                    functionalBgp.setFunctionalPredicate(fp);
                    TreeNode parent = bgp.getParent();
                    parent.addChild(functionalBgp);
                }
            } while (fp != null); // continue as long as we pulled out a new functional predicate
            // see if there's anything left in the original BGP
            if (bgp.getChildren().isEmpty())
                return null;
            return node;
        }
        return node;
    }

}
