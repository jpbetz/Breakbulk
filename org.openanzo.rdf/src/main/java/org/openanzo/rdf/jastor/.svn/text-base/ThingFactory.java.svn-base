/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/jastor/Attic/DatasetThingFactory.java,v $
 * Created by:  Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 * Created on:  5/15/2006
 * Revision:	$Id: DatasetThingFactory.java 168 2007-07-31 14:11:14Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor;

import java.util.Hashtable;
import java.util.Map;

import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.MemValueFactory;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.URI;

/**
 * A basic factory that provides create methods for building block OWL types.
 * 
 * @author Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 */
/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class ThingFactory {

    /** Reference to static Anzo valueFactory */
    public static final MemValueFactory       valueFactory = Constants.valueFactory;

    /** Cache of DatasetThing objects */
    protected static final Map<String, Thing> objects      = new Hashtable<String, Thing>();

    /**
     * Create a new DatasetThing if one doesn't already exist
     * 
     * @param resource
     *            Resource of object
     * @param _namedGraphUri
     *            NamedGraph's URI where resource resides
     * @param dataset
     *            Dataset containing data
     * @return new DatasetThingImpl
     * @throws JastorException
     *             if dataset or resource parameter is null
     */

    public static Thing createThing(Resource resource, URI _namedGraphUri, IDataset dataset) throws JastorException {
        return new ThingImpl(resource, _namedGraphUri, dataset);
    }

    /**
     * Create a new DatasetThing if one doesn't already exist
     * 
     * @param resource
     *            Resource of object
     * @param _namedGraphUri
     *            NamedGraph's URI where resource resides
     * @param dataset
     *            Dataset containing data
     * @return new DatasetThingImpl
     * @throws JastorException
     *             if dataset or resource parameter is null
     */

    public static Thing getThing(Resource resource, URI _namedGraphUri, IDataset dataset) throws JastorException {
        return createThing(resource, _namedGraphUri, dataset);
    }

    /**
     * @param resource
     * @param dataset
     * @return thing
     * @throws JastorException
     */
    public static Thing createThing(URI resource, IDataset dataset) throws JastorException {
        return getThing(resource, resource, dataset);
    }

}
