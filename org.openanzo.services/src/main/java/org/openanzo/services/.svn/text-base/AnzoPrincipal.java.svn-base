/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation,Cambridge Semantics Incorporated and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/src/com/ibm/adtech/boca/model/security/BocaPrincipal.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Oct 4, 2006
 * Revision:	$Id: Principal.java 180 2007-07-31 14:24:13Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.services;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.rdf.URI;

/**
 * Basic name based Principal object
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class AnzoPrincipal implements java.security.Principal, Serializable {

    private static final long         serialVersionUID = 2221524293606734226L;

    private final String              name;

    private final URI                 userURI;

    private final Set<URI>            roles;

    private final boolean             isSysadmin;

    private final boolean             isAnonymous;

    private final Map<String, String> properties       = Collections.synchronizedMap(new LinkedHashMap<String, String>(1));

    /**
     * Create a new principal for the name
     * 
     * @param name
     *            name of principal
     * @param userURI
     *            URI of user
     * @param roles
     *            roles for user
     * @param isSysadmin
     *            is the user a sysadmin
     */
    public AnzoPrincipal(String name, URI userURI, Set<URI> roles, boolean isSysadmin, boolean isAnonymous) {
        if (name == null) {
            throw new AnzoRuntimeException(ExceptionConstants.CORE.NULL_PARAMETER, "name");
        }
        this.name = name;
        this.userURI = userURI;
        this.roles = roles;
        this.isSysadmin = isSysadmin;
        this.isAnonymous = isAnonymous;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Add a property to the principal
     * 
     * @param name
     *            name of property
     * @param value
     *            value of property
     */
    public void setProperty(String name, String value) {
        properties.put(name, value);
    }

    /**
     * Get a property from the principal
     * 
     * @param name
     *            name of property
     * @return value of property
     */
    public String getProperty(String name) {
        return properties.get(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof AnzoPrincipal))
            return false;
        AnzoPrincipal another = (AnzoPrincipal) obj;
        return name.equals(another.getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * Get the user's URI
     * 
     * @return the userURI
     */
    public URI getUserURI() {
        return userURI;
    }

    /**
     * Get the roles for a Principal
     * 
     * @return the roles for a Principal
     */
    public java.util.Set<URI> getRoles() {
        return roles;
    }

    /**
     * @return the isSysadmin
     */
    public boolean isSysadmin() {
        return isSysadmin;
    }

    /**
     * This flag indicates whether the user is an anonymous user or whether the user is an authenticated user.
     * 
     * @return true if the user is an unauthenticated, anonymous user.
     */
    public boolean isAnonymous() {
        return isAnonymous;
    }

}
