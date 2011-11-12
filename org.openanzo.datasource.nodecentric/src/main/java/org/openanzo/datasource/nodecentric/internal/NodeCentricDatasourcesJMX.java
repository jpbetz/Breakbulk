/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Nov 28, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.internal;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.jmx.IJMXServiceEndpoint;
import org.openanzo.osgi.IServiceTrackerListener;
import org.openanzo.osgi.OsgiServiceTracker;
import org.openanzo.rdf.Constants;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * 
 */
class NodeCentricDatasourcesJMX implements IJMXServiceEndpoint {

    static final Logger                               log               = LoggerFactory.getLogger(NodeCentricDatasourcesJMX.class);

    private final BundleContext                       context;

    private OsgiServiceTracker<NodeCentricDatasource> datasourceTracker = null;

    public NodeCentricDatasourcesJMX(BundleContext context) {
        this.context = context;
    }

    public void registerWithJMX(final MBeanServer mbeanServer, ObjectName parentObjectName) throws AnzoException {
        try {
            String nameString = parentObjectName.getKeyPropertyListString();
            final ObjectName name = new ObjectName(parentObjectName.getDomain() + ":" + nameString + ",AnzoService=NodeCentricBackends");
            datasourceTracker = new OsgiServiceTracker<NodeCentricDatasource>(new IServiceTrackerListener<NodeCentricDatasource>() {
                public void unregisterService(NodeCentricDatasource service) {
                }

                public void registerService(NodeCentricDatasource service) {
                    try {
                        String nameStringService = name.getKeyPropertyListString();
                        ObjectName nameService = new ObjectName(name.getDomain() + ":" + nameStringService + ",NCBackend=" + URLEncoder.encode(service.getInstanceURI().toString(), Constants.byteEncoding));
                        if (!mbeanServer.isRegistered(nameService)) {
                            mbeanServer.registerMBean(new NodeCentricDatasourceJMX(NodeCentricDatasourcesJMX.this, service), nameService);
                        }
                    } catch (MalformedObjectNameException e) {
                        log.warn(LogUtils.LIFECYCLE_MARKER, "Error registering JMX bean for datasource", e);
                    } catch (NullPointerException e) {
                        log.warn(LogUtils.LIFECYCLE_MARKER, "Error registering JMX bean for datasource", e);
                    } catch (InstanceAlreadyExistsException e) {
                        log.warn(LogUtils.LIFECYCLE_MARKER, "Error registering JMX bean for datasource", e);
                    } catch (MBeanRegistrationException e) {
                        log.warn(LogUtils.LIFECYCLE_MARKER, "Error registering JMX bean for datasource", e);
                    } catch (NotCompliantMBeanException e) {
                        log.warn(LogUtils.LIFECYCLE_MARKER, "Error registering JMX bean for datasource", e);
                    } catch (UnsupportedEncodingException e) {
                        log.warn(LogUtils.LIFECYCLE_MARKER, "Error registering JMX bean for datasource", e);
                    }
                }

                public Class<NodeCentricDatasource> getComponentType() {
                    return NodeCentricDatasource.class;
                }

            }, context);
            datasourceTracker.open();
        } catch (MalformedObjectNameException e) {
            log.warn(LogUtils.LIFECYCLE_MARKER, "Error registering JMX bean for datasource", e);
        } catch (NullPointerException e) {
            log.warn(LogUtils.LIFECYCLE_MARKER, "Error registering JMX bean for datasource", e);
        }
    }

}
