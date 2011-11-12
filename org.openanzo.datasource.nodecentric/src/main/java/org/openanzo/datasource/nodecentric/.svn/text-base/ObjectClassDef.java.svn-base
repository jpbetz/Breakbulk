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
package org.openanzo.datasource.nodecentric;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Dictionary;

import org.openanzo.datasource.attributes.DatasourceAttributes;
import org.openanzo.datasource.nodecentric.attributes.RDBAttributes;
import org.openanzo.datasource.nodecentric.internal.NodeCentricDatasourceFactory;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.jdbc.container.CoreDBConfiguration;
import org.openanzo.osgi.GenericObjectClassDef;
import org.openanzo.osgi.attributes.ServicesAttributes;
import org.osgi.framework.BundleContext;
import org.osgi.service.metatype.AttributeDefinition;

/**
 * Object class def for nodecentric datasource
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class ObjectClassDef extends GenericObjectClassDef {
    /** Factory PID for NodecentricDatasource */
    public static final String FACTORY_PID = "org.openanzo.datasource.nodecentric.Factory";

    /**
     * Create new ObjectClassDef
     */
    public ObjectClassDef() {
        super(NodeCentricDatasourceFactory.FACTORY_PID, "Anzo Nodecentric Datasource Instance", "Instance of RDB backed nodecentric Datasource", new AttributeDefinition[] { ServicesAttributes.Enabled, ServicesAttributes.InstanceURI, RDBAttributes.Url, RDBAttributes.User, RDBAttributes.Password, RDBAttributes.Type }, new AttributeDefinition[] { DatasourceAttributes.MaxWriteConnections, DatasourceAttributes.MaxQueryConnections, DatasourceAttributes.InitFiles });
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean validateConfiguration(BundleContext context, Dictionary config) throws AnzoException {
        CoreDBConfiguration dbConfig = CoreDBConfiguration.createConfiguration(config);
        if (dbConfig.getJdbcUrl() == null || dbConfig.getJdbcUrl().isEmpty()) {
            throw new AnzoException(ExceptionConstants.SERVER.INSTALL_DATABASE_JDBC_URL_NOT_SET);
        }
        if (dbConfig.getUser() == null || dbConfig.getUser().isEmpty()) {
            throw new AnzoException(ExceptionConstants.SERVER.INSTALL_DATABASE_USER_NOT_SET);
        }
        if (dbConfig.getDriverClassName() == null || dbConfig.getDriverClassName().isEmpty()) {
            throw new AnzoException(ExceptionConstants.SERVER.INSTALL_DATABASE_TYPE_NOT_SET);
        }
        try {
            Class.forName(dbConfig.getDriverClassName());
            Connection connection = DriverManager.getConnection(dbConfig.getJdbcUrl(), dbConfig.getUser(), dbConfig.getPassword());
            connection.close();
            return true;
        } catch (SQLException e) {
            throw new AnzoException(ExceptionConstants.SERVER.INSTALL_DATABASE_CANNOT_CONNECT);
        } catch (ClassNotFoundException e) {
            throw new AnzoException(ExceptionConstants.SERVER.INSTALL_DATABASE_CANNOT_CONNECT);
        }
    }
}
