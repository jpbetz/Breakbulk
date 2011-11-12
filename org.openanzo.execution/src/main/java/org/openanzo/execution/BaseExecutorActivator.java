package org.openanzo.execution;

import java.util.Dictionary;

import org.openanzo.client.pool.ClientPoolDependentActivator;
import org.openanzo.datasource.IDatasourceListener;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.osgi.registry.IRegistryProvider;
import org.openanzo.osgi.registry.RegistryDataset;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base Executor Activator
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public abstract class BaseExecutorActivator extends ClientPoolDependentActivator {

    private static final Logger   log                 = LoggerFactory.getLogger(BaseExecutorActivator.class);

    protected BaseServiceExecutor executor            = null;

    protected RegistryDataset     registry            = null;

    protected ServiceRegistration serviceRegistration = null;

    /**
     * Get the Executor for this activator
     * 
     * @param configProperties
     *            configuration propertis for the executor
     * @return the executor for this activator
     */
    abstract public BaseServiceExecutor getExecutor(Dictionary<? extends Object, ? extends Object> configProperties);

    /**
     * Get the default config properties for this activator's executor
     * 
     * @return the default config properties for this activator's executor
     */
    abstract public Dictionary<? extends Object, ? extends Object> getDefaultConfigProperties();

    @Override
    public String[] getDependencies() {
        return new String[] { IRegistryProvider.class.getName() };
    }

    @Override
    public void start() {
        try {
            registry = getDependency(IRegistryProvider.class).openRegistry(SemanticServiceExecutionService.registryUri, getServicePid() + "Activator");
            registry.beginUpdatingRegistry();
            executor = getExecutor(configProperties);
            executor.setAnzoClientPool(clientPool);
            executor.loadServices(registry);
            registry.commitRegistry();
            serviceRegistration = context.registerService(ISemanticServiceExecutor.class.getName(), executor, configProperties);

            registry.registerDatasourceListener(new IDatasourceListener() {
                public void resetFinished() throws AnzoException {
                    registry.beginUpdatingRegistry();
                    executor.loadServices(registry);
                    executor.registryReset(registry);
                    registry.commitRegistry();
                }

                public void reset() throws AnzoException {
                }

                public void postReset() throws AnzoException {
                }

                public void resetStarting() throws AnzoException {
                    executor.stopServices(true);
                }
            });

        } catch (AnzoException e) {
            log.error(LogUtils.LIFECYCLE_MARKER, "Error starting execution service", e);
        }
    }

    @Override
    public void stop(boolean bundleStopping) {
        try {
            //Can only stop if the whole osgi framework isn't stopping, since order of shutdown is not deterministic 
            executor.stopServices(bundleStopping);
            if (registry != null) {
                registry.close();
            }
        } catch (AnzoException e) {
            log.error(LogUtils.LIFECYCLE_MARKER, "Error stopping execution service", e);
        }
        if (!bundleStopping && serviceRegistration != null) {
            serviceRegistration.unregister();
            serviceRegistration = null;
        }
    }
}
