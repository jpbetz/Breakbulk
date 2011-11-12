/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/Engine.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:lee@cambridgesemantics.com">lee@cambridgesemantics.com</a>)
 * Created on:  03/30/2009
 * Revision:    $Id: Engine.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.glitter.query.validator;

import java.util.Iterator;
import java.util.Set;

import org.openanzo.glitter.query.Projection;
import org.openanzo.glitter.query.QueryInformation;
import org.openanzo.glitter.query.QueryResultForm;
import org.openanzo.glitter.query.QueryValidator;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.glitter.syntax.abstrakt.SimpleExpression;
import org.openanzo.rdf.Variable;

/**
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class VariableNameClashValidator implements QueryValidator {

    private Variable v = null;

    public String getValidationError() {
        return "Variable " + this.v + " is used within the query and then masked as an alias.";
    }

    public String getValidatorDescription() {
        return "Checks whether any variable aliases in the SELECT clause are also used as regular variables in the query. This almost always indicates an error in the query.";
    }

    public boolean validateQuery(QueryInformation query) {
        QueryResultForm qrf = query.getQueryResultForm();
        if (qrf instanceof Projection) {
            Projection p = (Projection) qrf;
            Set<Variable> queryVariables = query.getQueryPattern().getBindableVariables();
            Iterator<Expression> projectedExpressions = p.getProjectedExpressions().iterator();
            Iterator<Variable> projectedVariables = p.getResultVariables().iterator();
            while (projectedVariables.hasNext()) {
                Variable v = projectedVariables.next();
                Expression e = projectedExpressions.next();
                if (queryVariables.contains(v)) {
                    // the one exception here is constructs such as (?foo AS ?foo) which
                    // are valid no-ops and may commonly occur from generated code.
                    if (e instanceof SimpleExpression && ((SimpleExpression)e).getTerm().equals(v))
                        continue;
                    this.v = v;
                    return false;
                }
            }
        }
        return true;
    }

}
