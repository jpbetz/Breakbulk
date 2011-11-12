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
package org.openanzo.osgi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Dictionary;

import org.openanzo.exceptions.AnzoException;
import org.osgi.framework.BundleContext;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;

/**
 * Generic ObjectClassDef used for metatype services that don't need a custom class def
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class GenericObjectClassDef implements ObjectClassDefinition {

    private final AttributeDefinition[] required;

    private final AttributeDefinition[] optional;

    private final AttributeDefinition[] all;

    private final String                pid;

    private final String                description;

    private final String                name;

    /**
     * Create class def for given info
     * 
     * @param pid
     *            pid of the service
     * @param name
     *            name of the service
     * @param description
     *            description of the service
     * @param required
     * @param optional
     */
    public GenericObjectClassDef(String pid, String name, String description, AttributeDefinition[] required, AttributeDefinition[] optional) {
        this.pid = pid;
        this.description = description;
        this.name = name;
        this.required = required != null ? required : new AttributeDefinition[0];
        this.optional = optional != null ? optional : new AttributeDefinition[0];
        this.all = OsgiConfigurationUtils.union(this.required, this.optional);

    }

    public AttributeDefinition[] getAttributeDefinitions(int type) {
        switch (type) {
        case ObjectClassDefinition.ALL:
            return all;
        case ObjectClassDefinition.REQUIRED:
            return required;
        case ObjectClassDefinition.OPTIONAL:
            return optional;
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

    /**
     * @param context
     * @param config
     * @return if configuration is valid
     * @throws AnzoException
     */
    @SuppressWarnings("unchecked")
    public boolean validateConfiguration(BundleContext context, Dictionary config) throws AnzoException {
        return true;
    }
}
