/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.execution.echo;

import java.util.Dictionary;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.execution.java.ISemanticService;
import org.openanzo.execution.java.ISemanticServiceFactory;
import org.openanzo.ontologies.execution.JavaSemanticService;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.URI;
import org.openanzo.services.ServicesDictionary;

/**
 * 
 * Simple service, deployed for testing.
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
public class LongRunningServiceFactory implements ISemanticServiceFactory {

    static final URI serviceURI = Constants.valueFactory.createURI("http://openanzo.org/semanticServices/echoService");

    String           user       = null;

    LongRunningServiceFactory(Dictionary<? extends Object, ? extends Object> configProperties) {
        user = ServicesDictionary.getUser(configProperties, null);
    }

    public ISemanticService createService(JavaSemanticService serviceConfig) throws AnzoException {
        return new LongRunningService();
    }

}
