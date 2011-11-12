/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/validator/WellDesignedOptionalsValidator.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: WellDesignedOptionalsValidator.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query.validator;

import java.util.HashSet;
import java.util.Set;

import org.openanzo.glitter.query.QueryInformation;
import org.openanzo.glitter.query.QueryValidator;
import org.openanzo.glitter.syntax.abstrakt.BGP;
import org.openanzo.glitter.syntax.abstrakt.GraphPattern;
import org.openanzo.glitter.syntax.abstrakt.Optional;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;
import org.openanzo.rdf.Variable;

/**
 * Rejects queries that contain an OPTIONAL that contains a variable that is not in the required part of the OPTIONAL but does appear some other place in the
 * query.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class WellDesignedOptionalsValidator implements QueryValidator {

    private String error = null;

    public String getValidationError() {
        return this.error;
    }

    public String getValidatorDescription() {
        return "Validates that the query does not contain an OPTIONAL clause with an optional part containing a variable not appearing in the required part yet appearing in the rest of the query.";
    }

    public boolean validateQuery(QueryInformation query) {
        return validateQueryNode(query.getQueryPattern(), null, query.getQueryPattern());
    }

    protected boolean validateQueryNode(TreeNode n, TreeNode parent, GraphPattern query) {
        boolean valid = true;
        if (n == null)
            return true;
        if (n instanceof Optional) {
            Optional opt = (Optional) n;
            Set<Variable> mustVars = opt.getMustMatchPattern() != null ? opt.getMustMatchPattern().getReferencedVariables() : new HashSet<Variable>(), mayVars = opt.getMayMatchPattern().getReferencedVariables();
            mayVars.removeAll(mustVars);
            if (mayVars.size() > 0) {
                // we need to determine if any of these variables occurs outside of this
                // node of the AST. in lieu (TODO) of any better way to do this, we
                // substitute out this optional node for a dummy node and then check
                // if the overall tree contains any of these variables
                //
                // TODO -- I think that this coarse test is not strictly true; instead,
                // I think that this is malformed only if the variable occurs elsewhere
                // within the same context that this optional appears (that is, not within
                // a disjunctive alternative to the one that this optional appears in). As
                // currently written, then, this test is too restrictive and will restrict
                // constructs such as:
                //   { ?s <b> <c> OPTONAL {?s <e> ?x}]
                //     UNION
                //   { ?s <h> <i> OPTONAL {?s <k> ?x}]
                // which should not be restricted. This is captured in the (currently
                // failing) test QueryValidatorsTest.testWellDesignedOptionalsValidator5

                // It also rejects repeated OPTIONALs such as:
                //   { ?s ?p ?o OPTIONAL {?o dc:title ?lbl } OPTIONAL {?o rdfs:label ?lbl }
                // TODO Should it?
                // Opt(Opt(n, y), y)
                TreeNode dummy = new BGP();
                parent.replaceChild(n, dummy);
                for (Variable v : mayVars) {
                    if (query.mightBindVariable(v)) {
                        this.error = "Variable " + v + " appears in optional pattern but not in required part.";
                        valid = false;
                        break;
                    }
                }
                parent.replaceChild(dummy, n);
            }
        }
        for (TreeNode tn : n.getChildren()) {
            valid = validateQueryNode(tn, n, query);
            if (!valid)
                break;
        }

        return valid;
    }

}
