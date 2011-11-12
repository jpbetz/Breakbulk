package org.openanzo.combus.listeners;

import java.util.HashMap;
import java.util.Map;

import org.openanzo.combus.endpoint.ICombusEndpointListener;
import org.openanzo.datasource.IDatasource;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.osgi.IServiceTrackerListener;
import org.openanzo.osgi.OsgiServiceTracker;
import org.openanzo.osgi.ServiceActivator;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.IExecutionService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Combus datasource listener activator
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class CombusListenersActivator extends ServiceActivator {
    protected static final Logger                                log                           = LoggerFactory.getLogger(CombusListenersActivator.class);

    private OsgiServiceTracker<IDatasource>                      datasourceTracker             = null;

    private OsgiServiceTracker<IExecutionService>                executionTracker              = null;

    private IExecutionService                                    executionService              = null;

    private final HashMap<IDatasource, CombusDatasourceListener> datasources                   = new HashMap<IDatasource, CombusDatasourceListener>();

    private CombusAuthenticationServiceListener                  authenticationServiceListener = null;

    private ServiceRegistration                                  reg                           = null;

    static final String                                          SERVICE_PID                   = "org.openanzo.combus.Listeners";

    @Override
    public String getServicePid() {
        return SERVICE_PID;
    }

    @Override
    public boolean registerService() {
        return false;
    }

    @Override
    public String[] getDependencies() {
        return new String[] { IAuthenticationService.class.getName() };
    }

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        super.start(bundleContext);
        datasourceTracker = new OsgiServiceTracker<IDatasource>(new IServiceTrackerListener<IDatasource>() {
            public Class<IDatasource> getComponentType() {
                return IDatasource.class;
            }

            public void unregisterService(IDatasource datasource) {
                lock.lock();
                try {
                    CombusDatasourceListener listener = datasources.remove(datasource);
                    if (listener != null) {
                        listener.close();
                    }
                } finally {
                    lock.unlock();
                }
            }

            public void registerService(IDatasource datasource) {
                lock.lock();
                try {
                    if (!datasources.containsKey(datasource)) {
                        CombusDatasourceListener listener = new CombusDatasourceListener(context, datasource);
                        datasources.put(datasource, listener);
                        if (getDependency(IAuthenticationService.class) != null) {
                            listener.initialize(getDependency(IAuthenticationService.class));
                        }
                    }
                } finally {
                    lock.unlock();
                }

            }

        }, context);
        datasourceTracker.open();
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        datasourceTracker.close();
        super.stop(context);
    }

    @Override
    public void stop(boolean bundleStopping) {
        for (Map.Entry<IDatasource, CombusDatasourceListener> entry : datasources.entrySet()) {
            entry.getValue().close();
        }
        if (reg != null && !bundleStopping) {
            reg.unregister();
            reg = null;
        }
    }

    @Override
    public void start() {
        for (Map.Entry<IDatasource, CombusDatasourceListener> entry : datasources.entrySet()) {
            entry.getValue().initialize(getDependency(IAuthenticationService.class));
        }

        authenticationServiceListener = new CombusAuthenticationServiceListener(getDependency(IAuthenticationService.class), getDependency(IAuthenticationService.class), null);
        try {
            authenticationServiceListener.start();
        } catch (AnzoException ae) {
            log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error starting the authentication service combus listeners", ae);
            throw new AnzoRuntimeException(ae);
        }
        reg = context.registerService(ICombusEndpointListener.class.getName(), authenticationServiceListener, null);

        log.debug(LogUtils.LIFECYCLE_MARKER, "Registering IExecutionService tracker");
        executionTracker = new OsgiServiceTracker<IExecutionService>(new IServiceTrackerListener<IExecutionService>() {

            public void unregisterService(IExecutionService service) {
                executionService = null;
            }

            public void registerService(IExecutionService service) {
                lock.lock();
                try {
                    log.debug(LogUtils.LIFECYCLE_MARKER, "Registering execution service: {}", service.toString());
                    if (executionService != null) {
                        log.warn(LogUtils.LIFECYCLE_MARKER, "Multiple execution services registered: " + service);
                    } else {
                        try {
                            executionService = service;
                            CombusExecutionServiceListener executionServiceListener = new CombusExecutionServiceListener(getDependency(IAuthenticationService.class), executionService, "");
                            executionServiceListener.start();
                            context.registerService(new String[] { ICombusEndpointListener.class.getName() }, executionServiceListener, null);
                        } catch (AnzoException e) {
                            log.error(LogUtils.SERVER_INTERNAL_MARKER, "Exception registering execution service combus listener", e);
                            throw new AnzoRuntimeException(e);
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }

            public Class<IExecutionService> getComponentType() {
                return IExecutionService.class;
            }

        }, context);
        executionTracker.open();

    }
}
