/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation,Cambridge Semantics Incorporated and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/src/com/ibm/adtech/boca/model/security/activemq/BocaAuthenticationPlugin.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Oct 4, 2006
 * Revision:	$Id: AuthenticationPlugin.java 180 2007-07-31 14:24:13Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.activemq.internal;

import java.util.Set;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerPlugin;
import org.openanzo.cache.ICacheProvider;
import org.openanzo.datasource.IDatasource;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.IAuthorizationEventListener;

/**
 * Authorization Plugin that provides the securityBroker to an ActiveMQ server
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class SecurityPlugin implements BrokerPlugin, IAuthorizationEventListener {

    private SecurityBroker               securityBroker    = null;

    private IDatasource                  primaryDatasource = null;

    private final IAuthenticationService authenticationService;

    private final ICacheProvider         cacheProvider;

    private final String                 userName;

    private final String                 password;

    /**
     * Create a new AuthenticationPlugin
     */
    SecurityPlugin(IAuthenticationService authenticationService, ICacheProvider cacheProvider, String userName, String password) {
        this.authenticationService = authenticationService;
        this.cacheProvider = cacheProvider;
        this.userName = userName;
        this.password = password;
    }

    void setDatasource(IDatasource datasource) {
        this.primaryDatasource = datasource;
        if (securityBroker != null) {
            securityBroker.setDatasource(datasource);
        }
    }

    public Broker installPlugin(Broker broker) throws Exception {
        securityBroker = new SecurityBroker(broker, authenticationService, cacheProvider, userName, password);
        securityBroker.setDatasource(this.primaryDatasource);
        securityBroker.connect();
        return securityBroker;
    }

    public void handleAuthorizationUpdates(Set<Statement> aclAdditions, Set<Statement> aclRemovals) throws AnzoException {
        for (Statement acl : aclRemovals) {
            URI namedGraphUri = (URI) acl.getSubject();
            if (!UriGenerator.isMetadataGraphUri(namedGraphUri)) {
                securityBroker.refreshNamedGraphAcl(namedGraphUri);
            }
        }
    }

}
