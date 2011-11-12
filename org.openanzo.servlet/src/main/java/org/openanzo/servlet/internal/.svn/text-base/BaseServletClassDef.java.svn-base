/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Aug 4, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.servlet.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.openanzo.osgi.attributes.ServicesAttributes;
import org.openanzo.servlet.attributes.ServletAttributes;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;

/**
 * Abstract class def for servlets
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class BaseServletClassDef implements ObjectClassDefinition {

    ArrayList<AttributeDefinition> required    = new ArrayList<AttributeDefinition>() {
                                                   private static final long serialVersionUID = 1L;

                                                   {
                                                       this.add(ServicesAttributes.Enabled);
                                                       this.add(ServletAttributes.AuthorizationType);
                                                       this.add(ServletAttributes.ContextPath);
                                                       this.add(ServletAttributes.PathSpec);
                                                   }
                                               };

    ArrayList<AttributeDefinition> optional    = new ArrayList<AttributeDefinition>();

    ArrayList<AttributeDefinition> all         = null;

    private String                 name        = null;

    private String                 pid         = null;

    private String                 description = null;

    /**
     * Base classdef for servlet
     * 
     * @param pid
     *            pid for servlet
     * @param name
     *            name of servlet
     * @param description
     *            description of servlet
     * @param additionalRequired
     *            additional required attributes that must be in config
     * @param additionalOptional
     *            additional optional attributes that may be in config
     */
    public BaseServletClassDef(String pid, String name, String description, Collection<AttributeDefinition> additionalRequired, Collection<AttributeDefinition> additionalOptional) {
        this.pid = pid;
        this.name = name;
        this.description = description;
        if (additionalRequired != null)
            this.required.addAll(additionalRequired);
        if (additionalOptional != null)
            this.optional.addAll(additionalOptional);
        all = new ArrayList<AttributeDefinition>() {
            private static final long serialVersionUID = 1L;

            {
                this.addAll(required);
                this.addAll(optional);
            }
        };
    }

    public AttributeDefinition[] getAttributeDefinitions(int type) {
        switch (type) {
        case ObjectClassDefinition.ALL:
            return all.toArray(new AttributeDefinition[0]);
        case ObjectClassDefinition.REQUIRED:
            return required.toArray(new AttributeDefinition[0]);
        case ObjectClassDefinition.OPTIONAL:
            return optional.toArray(new AttributeDefinition[0]);
        default:
            return null;
        }
    }

    public String getDescription() {
        return description;
    }

    public String getID() {
        return pid;
    }

    public InputStream getIcon(int arg0) throws IOException {
        return null;
    }

    public String getName() {
        return name;
    }
}
