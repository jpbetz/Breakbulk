package org.openanzo.jmx.internal;

import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryManagerMXBean;
import java.lang.management.MemoryNotificationInfo;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryType;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.security.AccessController;
import java.security.Principal;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Properties;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.JMException;
import javax.management.MBeanException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.Notification;
import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;
import javax.management.remote.JMXAuthenticator;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import javax.security.auth.Subject;

import org.apache.activemq.management.StatisticImpl;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.jmx.DynamicStatsMBean;
import org.openanzo.jmx.IJMXServiceEndpoint;
import org.openanzo.jmx.JMXDictionary;
import org.openanzo.osgi.IServiceTrackerListener;
import org.openanzo.osgi.OsgiServiceTracker;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.IOperationContext;
import org.openanzo.services.IStatisticsProvider;
import org.openanzo.services.impl.BaseOperationContext;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.management.HotSpotDiagnosticMXBean;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * 
 */
class JMXService {
    /** JMX_DOMAIN */
    public static final String                        JMX_DOMAIN      = "openanzo.org";

    private int                                       port            = 5000;

    private static final Logger                       log             = LoggerFactory.getLogger(JMXService.class);

    protected Registry                                registry        = null;

    protected MBeanServer                             mbServer        = null;

    private JMXConnectorServer                        connectorServer = null;

    private final BundleContext                       context;

    private OsgiServiceTracker<IJMXServiceEndpoint>   tracker         = null;

    private OsgiServiceTracker<IStatisticsProvider>   statsTracker    = null;

    protected final IAuthenticationService            authService;

    protected final EventAdmin                        eventAdmin;

    protected final HashMap<String, MemoryPoolMXBean> pools           = new HashMap<String, MemoryPoolMXBean>();

    /**
     * 
     */
    protected JMXService(BundleContext context, Dictionary<? extends Object, ? extends Object> configProperties, EventAdmin eventAdmin, IAuthenticationService authService) {
        this.context = context;
        this.eventAdmin = eventAdmin;
        this.port = JMXDictionary.getPort(configProperties, 5000);
        this.authService = authService;
    }

    public StatisticImpl getStatistics() {
        return null;
    }

    private void registerBean(MBeanServer mbServer, Object bean, ObjectName name) throws MBeanRegistrationException, NotCompliantMBeanException, InstanceAlreadyExistsException {
        if (!mbServer.isRegistered(name)) {
            if (bean != null && name != null) {
                mbServer.registerMBean(bean, name);
            }
        }
    }

    private static final String HOTSPOT_BEAN_NAME = "com.sun.management:type=HotSpotDiagnostic";

    protected void start() {
        log.info(LogUtils.LIFECYCLE_MARKER, "Initializing the JMXService component.");
        try {
            MBeanServer platformServer = ManagementFactory.getPlatformMBeanServer();
            mbServer = MBeanServerFactory.createMBeanServer();
            try {
                ObjectName name = new ObjectName(HOTSPOT_BEAN_NAME);
                if (!mbServer.isRegistered(name)) {
                    registerBean(mbServer, ManagementFactory.newPlatformMXBeanProxy(platformServer, HOTSPOT_BEAN_NAME, HotSpotDiagnosticMXBean.class), name);
                }
            } catch (Throwable t) {
                log.debug(LogUtils.LIFECYCLE_MARKER, "Error registering platform mbean", t);
            }
            registerBean(mbServer, ManagementFactory.getClassLoadingMXBean(), new ObjectName(ManagementFactory.CLASS_LOADING_MXBEAN_NAME));
            registerBean(mbServer, ManagementFactory.getCompilationMXBean(), new ObjectName(ManagementFactory.COMPILATION_MXBEAN_NAME));
            for (GarbageCollectorMXBean bean : ManagementFactory.getGarbageCollectorMXBeans()) {
                ObjectName name = new ObjectName(ManagementFactory.GARBAGE_COLLECTOR_MXBEAN_DOMAIN_TYPE + ",\"name\"=" + bean.getName());
                if (!mbServer.isRegistered(name)) {
                    try {
                        registerBean(mbServer, bean, name);
                    } catch (javax.management.InstanceAlreadyExistsException iaee) {
                        if (log.isDebugEnabled()) {
                            log.debug(LogUtils.LIFECYCLE_MARKER, "Error registering mbean:" + name, iaee);
                        }
                    }
                }
            }
            for (MemoryManagerMXBean bean : ManagementFactory.getMemoryManagerMXBeans()) {
                ObjectName name = new ObjectName(ManagementFactory.MEMORY_MANAGER_MXBEAN_DOMAIN_TYPE + ",\"name\"=" + bean.getName());
                if (!mbServer.isRegistered(name)) {
                    try {
                        registerBean(mbServer, bean, name);
                    } catch (javax.management.InstanceAlreadyExistsException iaee) {
                        if (log.isDebugEnabled()) {
                            log.debug(LogUtils.LIFECYCLE_MARKER, "Error registering mbean:" + name, iaee);
                        }
                    }
                }
            }
            for (MemoryPoolMXBean bean : ManagementFactory.getMemoryPoolMXBeans()) {
                pools.put(bean.getName(), bean);
                ObjectName name = new ObjectName(ManagementFactory.MEMORY_POOL_MXBEAN_DOMAIN_TYPE + ",\"name\"=" + bean.getName());
                if (!mbServer.isRegistered(name)) {
                    try {
                        registerBean(mbServer, bean, name);
                        if (bean.getType() == MemoryType.HEAP && bean.isUsageThresholdSupported()) {
                            long maxMemory = bean.getUsage().getMax();
                            long warningThreshold = (long) (maxMemory * 0.75);
                            bean.setUsageThreshold(warningThreshold);
                        }
                    } catch (javax.management.InstanceAlreadyExistsException iaee) {
                        if (log.isDebugEnabled()) {
                            log.debug(LogUtils.LIFECYCLE_MARKER, "Error registering mbean:" + name, iaee);
                        }
                    }
                }
            }
            MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
            NotificationEmitter emitter = (NotificationEmitter) memoryBean;
            emitter.addNotificationListener(new NotificationListener() {
                public void handleNotification(Notification notification, Object handback) {
                    String notifType = notification.getType();
                    if (notifType.equals(MemoryNotificationInfo.MEMORY_THRESHOLD_EXCEEDED) || notifType.equals(MemoryNotificationInfo.MEMORY_COLLECTION_THRESHOLD_EXCEEDED)) {
                        CompositeData cd = (CompositeData) notification.getUserData();
                        MemoryNotificationInfo info = MemoryNotificationInfo.from(cd);
                        Dictionary<Object, Object> props = new Properties();
                        props.put("poolName", info.getPoolName());
                        props.put("committed", info.getUsage().getCommitted());
                        props.put("init", info.getUsage().getInit());
                        props.put("max", info.getUsage().getMax());
                        props.put("used", info.getUsage().getUsed());
                        props.put("count", info.getCount());
                        eventAdmin.sendEvent(new Event("system/memory", props));
                        log.info(LogUtils.LIFECYCLE_MARKER, "Memory Usage greater than 75% of total:" + info.getUsage().getUsed());
                    }
                }
            }, null, null);
            registerBean(mbServer, memoryBean, new ObjectName(ManagementFactory.MEMORY_MXBEAN_NAME));
            registerBean(mbServer, ManagementFactory.getOperatingSystemMXBean(), new ObjectName(ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME));
            registerBean(mbServer, ManagementFactory.getRuntimeMXBean(), new ObjectName(ManagementFactory.RUNTIME_MXBEAN_NAME));
            registerBean(mbServer, ManagementFactory.getThreadMXBean(), new ObjectName(ManagementFactory.THREAD_MXBEAN_NAME));

            int port2 = port + 1;
            ClassLoader currentLoader = Thread.currentThread().getContextClassLoader();
            Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
            try {
                registry = LocateRegistry.createRegistry(port2);
            } catch (RemoteException re) {
                log.debug(LogUtils.LIFECYCLE_MARKER, "Error creating registry", re);
            }
            if (registry == null) {
                registry = LocateRegistry.getRegistry(port2);
            }
            HashMap<String, Object> env = new HashMap<String, Object>();
            env.put(JMXConnectorServer.AUTHENTICATOR, new JMXAuth());
            env.put("jmx.remote.protocol.provider.class.loader", this.getClass().getClassLoader());
            env.put("jmx.remote.default.class.loader", this.getClass().getClassLoader());
            env.put("java.rmi.server.hostname", "localhost");
            JMXServiceURL url = new JMXServiceURL("service:jmx:rmi://localhost:" + port + "/jndi/rmi://localhost:" + port2 + "/server");
            connectorServer = JMXConnectorServerFactory.newJMXConnectorServer(url, env, mbServer);
            connectorServer.start();
            try {

                final ObjectName objectName = new ObjectName(JMX_DOMAIN + ":AnzoType=AnzoServer");
                tracker = new OsgiServiceTracker<IJMXServiceEndpoint>(new IServiceTrackerListener<IJMXServiceEndpoint>() {
                    public void unregisterService(IJMXServiceEndpoint service) {
                    }

                    public void registerService(IJMXServiceEndpoint service) {
                        try {
                            service.registerWithJMX(mbServer, objectName);
                        } catch (AnzoException ae) {
                            log.warn(LogUtils.LIFECYCLE_MARKER, "Error registering mbean", ae);
                        }
                    }

                    public Class<IJMXServiceEndpoint> getComponentType() {
                        return IJMXServiceEndpoint.class;
                    }

                }, context);
                tracker.open();

                statsTracker = new OsgiServiceTracker<IStatisticsProvider>(new IServiceTrackerListener<IStatisticsProvider>() {
                    public void unregisterService(IStatisticsProvider service) {
                        try {
                            if (service.getStatistics() != null) {
                                String nameString = objectName.getKeyPropertyListString();
                                ObjectName name = new ObjectName(objectName.getDomain() + ":" + nameString + ",AnzoService=StatisticsProviders," + service.getName());
                                String nameStringService = name.getKeyPropertyListString();
                                ObjectName nameServiceStats = new ObjectName(name.getDomain() + ":" + nameStringService + ",ChildType=Stats");
                                mbServer.unregisterMBean(nameServiceStats);
                            }
                        } catch (MalformedObjectNameException e) {
                            log.debug(LogUtils.LIFECYCLE_MARKER, "Error unregistering mbean", e);
                        } catch (NullPointerException e) {
                            log.debug(LogUtils.LIFECYCLE_MARKER, "Error unregistering mbean", e);
                        } catch (InstanceNotFoundException e) {
                            log.debug(LogUtils.LIFECYCLE_MARKER, "Error unregistering mbean", e);
                        } catch (MBeanRegistrationException e) {
                            log.debug(LogUtils.LIFECYCLE_MARKER, "Error unregistering mbean", e);
                        }
                    }

                    public void registerService(IStatisticsProvider service) {
                        try {
                            if (service.getStatistics() != null) {
                                String nameString = objectName.getKeyPropertyListString();
                                ObjectName name = new ObjectName(objectName.getDomain() + ":" + nameString + ",AnzoService=StatisticsProviders," + service.getName());
                                String nameStringService = name.getKeyPropertyListString();
                                ObjectName nameServiceStats = new ObjectName(name.getDomain() + ":" + nameStringService + ",ChildType=Stats");
                                DynamicStatsMBean mbean = new DynamicStatsMBean(service.getStatistics());
                                registerBean(mbServer, mbean, nameServiceStats);
                            }
                        } catch (MalformedObjectNameException e) {
                            log.debug(LogUtils.LIFECYCLE_MARKER, "Error registering mbean", e);
                        } catch (NullPointerException e) {
                            log.debug(LogUtils.LIFECYCLE_MARKER, "Error registering mbean", e);
                        } catch (InstanceAlreadyExistsException e) {
                            log.debug(LogUtils.LIFECYCLE_MARKER, "Error registering mbean", e);
                        } catch (MBeanRegistrationException e) {
                            log.debug(LogUtils.LIFECYCLE_MARKER, "Error registering mbean", e);
                        } catch (NotCompliantMBeanException e) {
                            log.debug(LogUtils.LIFECYCLE_MARKER, "Error registering mbean", e);
                        }
                    }

                    public Class<IStatisticsProvider> getComponentType() {
                        return IStatisticsProvider.class;
                    }

                }, context);
                statsTracker.open();

            } catch (Exception e) {
                throw new AnzoException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
            }
            Thread.currentThread().setContextClassLoader(currentLoader);
        } catch (MBeanException e) {
            throw new AnzoRuntimeException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
        } catch (JMException e) {
            throw new AnzoRuntimeException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
        } catch (RemoteException e) {
            throw new AnzoRuntimeException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
        } catch (MalformedURLException e) {
            throw new AnzoRuntimeException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
        } catch (IOException e) {
            throw new AnzoRuntimeException(ExceptionConstants.OSGI.INTERNAL_COMPONENT_ERROR, e);
        } catch (AnzoException ae) {
            throw new AnzoRuntimeException(ae);
        }
    }

    protected void close() {
        if (connectorServer != null) {
            try {
                connectorServer.stop();
                tracker.close();
                UnicastRemoteObject.unexportObject(registry, true);
            } catch (IOException e) {
                if (log.isDebugEnabled()) {
                    log.debug(LogUtils.LIFECYCLE_MARKER, "Error closing jmx service", e);
                }
            }
        }
    }

    class JMXAuth implements JMXAuthenticator {

        public Subject authenticate(Object credentials) {
            if (!(credentials instanceof String[])) {
                if (credentials == null)
                    throw new SecurityException("Credentials required");

                final String message = "Credentials should be String[] instead of " + credentials.getClass().getName();
                throw new SecurityException(message);
            }
            final String[] aCredentials = (String[]) credentials;
            if (aCredentials.length != 2) {
                final String message = "Credentials should have 2 elements not " + aCredentials.length;
                throw new SecurityException(message);
            }
            String username = aCredentials[0];
            String password = aCredentials[1];
            if (username == null || password == null) {
                final String message = "Username or password is null";
                throw new SecurityException(message);
            }

            try {
                IOperationContext context = new BaseOperationContext("JMX Authenticate", BaseOperationContext.generateOperationId(), null);
                context.setMDC();

                AnzoPrincipal principal = authService.authenticateUser(context, username, password);
                if (principal != null && principal.isSysadmin()) {
                    final Subject subject = new Subject(false, Collections.<Principal> singleton(principal), Collections.EMPTY_SET, Collections.EMPTY_SET);
                    AccessController.doPrivileged(new PrivilegedAction<Void>() {
                        public Void run() {
                            subject.setReadOnly();
                            return null;
                        }
                    });

                    return subject;
                } else {
                    throw new SecurityException("User not found, or user is not in the sysadmin role");
                }

            } catch (AnzoException le) {
                throw new SecurityException(le);
            }
        }
    }
}
