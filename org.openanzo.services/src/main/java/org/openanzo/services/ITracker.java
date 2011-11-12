/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/src/com/ibm/adtech/boca/services/trackers/ITracker.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  5/5/2005
 * Revision:	$Id: ITracker.java 178 2007-07-31 14:22:33Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.services;

import org.openanzo.rdf.Constants;
import org.openanzo.rdf.URI;

/**
 * Used to specify what statements are tracked by AnzoClient
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 */
public interface ITracker {
    /** URI for trackers */
    public final static URI TRACKERS = Constants.valueFactory.createURI("http://openanzo.org/trackers");

    /** Type of trackers */
    enum TrackerType {
        /** Statement tracker */
        STATEMENT,
        /** Dataset structure tracker */
        DATASET
    }

    /**
     * Get type of tracker
     * 
     * @return type of tracker
     */
    public TrackerType getType();
}
