/******************************************************************************* 
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * 
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/planning/SimpleCostExecutionPlan.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>) 
 * Created on: 10/23/06
 * Revision: $Id: SimpleCostExecutionPlan.java 164 2007-07-31 14:11:09Z mroy $
 * 
 * Contributors: IBM Corporation - initial API and implementation 
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query.planning;

@SuppressWarnings("all")
/**
 * A {@link SimpleCostExecutionPlan} uses the {@link SimpleCostModel} in concert with the
 * {@link GreedyCostBasedExecutionPlan} to provide an unsophisticated way to approach executing a query.
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class SimpleCostExecutionPlan extends GreedyCostBasedExecutionPlan {
    /**
     * Default constructor.
     */
    public SimpleCostExecutionPlan() {
        super(new SimpleCostModel());
    }
}
