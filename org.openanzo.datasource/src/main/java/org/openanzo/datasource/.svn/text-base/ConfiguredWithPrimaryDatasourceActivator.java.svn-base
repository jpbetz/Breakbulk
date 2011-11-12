package org.openanzo.datasource;

import java.util.List;

import org.openanzo.osgi.ConfiguredServiceActivator;
import org.osgi.framework.BundleContext;

/**
 * Base Activator that depends on having the primary datasource available
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public abstract class ConfiguredWithPrimaryDatasourceActivator extends ConfiguredServiceActivator {
    PrimaryDatasourceTracker primaryDatasourceTracker = null;

    protected IDatasource    primaryDatasource        = null;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        super.start(bundleContext);
        primaryDatasourceTracker = new PrimaryDatasourceTracker(context, new IDatasourceRegistrationListener() {

            public void unregisterDatasource(IDatasource datasource) {
                if (primaryDatasource != null && datasource.equals(primaryDatasource)) {
                    primaryDatasource = null;
                    stopLocked(false);
                }
            }

            public void registerDatasource(IDatasource datasource) {
                lock.lock();
                try {
                    if (primaryDatasource == null) {
                        primaryDatasource = datasource;
                        if (isInitialized()) {
                            startLocked();
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }

        });
        primaryDatasourceTracker.open();
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        primaryDatasourceTracker.close();
        super.stop(context);

    }

    @Override
    public boolean isInitialized() {
        return super.isInitialized() && primaryDatasource != null;
    }

    @Override
    public List<String> getOkServices() {
        List<String> list = super.getOkServices();
        if (primaryDatasource != null) {
            list.add(IDatasource.class.getName());
        }
        return list;
    }

    @Override
    public List<String> getWaitingServices() {
        List<String> list = super.getWaitingServices();
        if (primaryDatasource == null) {
            list.add(IDatasource.class.getName());
        }
        return list;
    }
}
