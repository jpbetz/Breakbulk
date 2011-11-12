package org.openanzo.jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.openanzo.exceptions.AnzoException;

/**
 * IServiceEndpoint is the JMX endpoint service interface that allows services to be exposed via JMX
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public interface IJMXServiceEndpoint {
    /**
     * Called by the JMX end-point to register the service with the JMX server
     * 
     * @param mbeanServer
     *            MBeanServer onto which the service is registered
     * @param parentObjectName
     *            the parent's name in the JMX hierarchy
     * @throws AnzoException
     */
    public void registerWithJMX(MBeanServer mbeanServer, ObjectName parentObjectName) throws AnzoException;
}
