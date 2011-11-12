/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Jul 15, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.ldap;

import org.openanzo.ldap.internal.LdapServerActivator;
import org.openanzo.osgi.GenericObjectClassDef;
import org.openanzo.osgi.attributes.LDAPAttributes;
import org.openanzo.osgi.attributes.ServicesAttributes;
import org.osgi.service.metatype.AttributeDefinition;

/**
 * Object cass def for ldap server
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class ObjectClassDef extends GenericObjectClassDef {

    /**
     * Create ObjectClassdef for ldap server
     */
    public ObjectClassDef() {
        super(LdapServerActivator.SERVICE_PID, "Embedded LDAP Server", "Embedded ApacheDS ldap server.", new AttributeDefinition[] { ServicesAttributes.Enabled, LDAPAttributes.Port, LDAPAttributes.Suffix, LDAPAttributes.Organization, LDAPAttributes.SearchBaseDN }, new AttributeDefinition[] { ServicesAttributes.Timeout, LDAPAttributes.LdapServerUser, LDAPAttributes.LdapServerPassword, LDAPAttributes.InitFile, LDAPAttributes.Id });
    }

}
