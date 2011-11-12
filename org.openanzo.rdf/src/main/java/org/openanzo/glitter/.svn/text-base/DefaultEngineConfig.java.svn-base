/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/DefaultEngineConfig.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: DefaultEngineConfig.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
  *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter;

import java.util.ArrayList;
import java.util.Collection;

import org.openanzo.glitter.query.ParallelQueryExecutor;
import org.openanzo.glitter.query.QueryExecutor;
import org.openanzo.glitter.query.QueryValidator;
import org.openanzo.glitter.query.SerialQueryExecutor;
import org.openanzo.glitter.query.SolutionGenerator;
import org.openanzo.glitter.query.TreeRewriter;
import org.openanzo.glitter.query.rewriter.ConjunctiveRewriter;
import org.openanzo.glitter.query.rewriter.NormalFormRewriter;
import org.openanzo.glitter.query.rewriter.SingletonGroupRewriter;
import org.openanzo.glitter.query.validator.AggregateVariableValidator;
import org.openanzo.glitter.query.validator.ScalarFunctionValidator;
import org.openanzo.glitter.query.validator.UnusedVariableProjectionValidator;
import org.openanzo.glitter.query.validator.VariableNameClashValidator;

/**
 * Base class for Glitter EngineConfig implementations. Provides a base configuration
 * that allows N-ary union, does substitute fixed bindings, and rewrites query trees
 * to with the {@link ConjunctiveRewriter} and the {@link NormalFormRewriter}.
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public abstract class DefaultEngineConfig implements EngineConfig {

    public boolean allowNaryUnion() {
        return true;
    }

    public Iterable<TreeRewriter> getTreeRewriters() {
        ArrayList<TreeRewriter> rewriters = new ArrayList<TreeRewriter>();
        rewriters.add(new ConjunctiveRewriter());
        rewriters.add(new NormalFormRewriter(this.allowNaryUnion()));
        rewriters.add(new SingletonGroupRewriter());
        return rewriters;
    }

    public Collection<QueryValidator> getQueryValidators() {
        ArrayList<QueryValidator> validators = new ArrayList<QueryValidator>();
        //validators.add(new WellDesignedOptionalsValidator());
        validators.add(new UnusedVariableProjectionValidator());
        validators.add(new VariableNameClashValidator());
        validators.add(new AggregateVariableValidator());
        validators.add(new ScalarFunctionValidator());
        return validators;
    }

    public boolean substituteFixedBindings() {
        return true;
    }

    public QueryExecutor getQueryExecutor(SolutionGenerator sg) {
        QueryExecutor qe = null;
        if (sg.canHandleSimultaneousRequests() && !sg.usesRequiredBindings())
            qe = new ParallelQueryExecutor();
        else
            qe = new SerialQueryExecutor();

        return qe;
    }
}
