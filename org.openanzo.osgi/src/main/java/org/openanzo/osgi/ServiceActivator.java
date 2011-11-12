/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.osgi;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.utils.CopyOnWriteMultiHashMap;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.Constants;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.SynchronousBundleListener;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.LoggerFactory;

/**
 * Abstract service activator that doesn't start until all dependencies are met via trackers
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public abstract class ServiceActivator implements BundleActivator, IStatusProvider {
    private static final org.slf4j.Logger log     = LoggerFactory.getLogger(ServiceActivator.class);

    protected BundleContext               context = null;

    protected ServiceLifecycleState       state   = ServiceLifecycleState.CREATED;

    /**
     * @return the state
     */
    public ServiceLifecycleState getState() {
        return state;
    }

    protected final ReentrantLock                                   lock                       = new ReentrantLock();

    private final StartRunner                                       startRunner                = new StartRunner();

    protected Thread                                                startThread                = null;

    private final Map<String, ServiceTracker>                       trackers                   = new ConcurrentHashMap<String, ServiceTracker>();

    protected EventAdmin                                            eventAdmin                 = null;

    private final CopyOnWriteMultiHashMap<String, ServiceReference> dependentServiceReferences = new CopyOnWriteMultiHashMap<String, ServiceReference>();

    private final Hashtable<ServiceReference, Object>               dependentServices          = new Hashtable<ServiceReference, Object>();

    /** Topic for event admin messages about status of service */
    public static final String                                      TOPIC                      = "org/openanzo/serviceActivator";

    String                                                          bundleName;

    String                                                          bundleDescription;

    /**
     * Should this service be started in its own thread
     * 
     * @return true if this service should be started in its own thread
     */
    public boolean startThreaded() {
        return true;
    }

    /**
     * 
     * @return True if this activator wants to listener for the framework stopping events
     */
    public boolean registerFrameworkStoppingListener() {
        return false;
    }

    /**
     * Does this service depend on the system config service before it can start
     * 
     * @return true if this service depends on the system config service before it can start
     */
    public boolean dependsOnSysconfig() {
        return true;
    }

    static final private Set<String> serviceClassNames = new HashSet<String>();
    static {
        serviceClassNames.add(ServiceActivator.class.getName());
        serviceClassNames.add(IStatusProvider.class.getName());
    }

    protected Collection<String> getServiceClassNames() {
        HashSet<String> scn = new HashSet<String>(serviceClassNames);
        scn.add(this.getClass().getName());
        return scn;
    }

    private void addTracker(final String dependency) {
        ServiceTracker tracker = new ServiceTracker(context, dependency, null) {
            @Override
            public Object addingService(ServiceReference reference) {
                Object service = context.getService(reference);
                lock.lock();
                try {
                    dependentServiceReferences.put(dependency, reference);
                    dependentServices.put(reference, service);
                } finally {
                    lock.unlock();
                }
                serviceAdded(dependency, reference, service);
                return service;

            }

            @Override
            public void removedService(ServiceReference reference, Object serviceObject) {
                lock.lock();
                try {
                    dependentServiceReferences.remove(dependency, reference);
                    dependentServices.remove(reference);
                } finally {
                    lock.unlock();
                }
                context.ungetService(reference);
                serviceRemoved(dependency, reference, serviceObject);
            }
        };
        tracker.open();
        trackers.put(dependency, tracker);
    }

    private void addFilteredTracker(final FilteredDependency dependency) {
        try {
            ServiceTracker tracker = new ServiceTracker(context, context.createFilter(dependency.filter), null) {
                @Override
                public Object addingService(ServiceReference reference) {
                    Object service = context.getService(reference);
                    lock.lock();
                    try {
                        dependentServiceReferences.put(dependency.type, reference);
                        dependentServices.put(reference, service);
                    } finally {
                        lock.unlock();
                    }
                    serviceAdded(dependency.type, reference, service);
                    return service;

                }

                @Override
                public void removedService(ServiceReference reference, Object serviceObject) {
                    lock.lock();
                    try {
                        dependentServiceReferences.remove(dependency.type, reference);
                        dependentServices.remove(reference);
                    } finally {
                        lock.unlock();
                    }
                    context.ungetService(reference);
                    serviceRemoved(dependency.type, reference, serviceObject);
                }
            };
            tracker.open();
            trackers.put(dependency.filter, tracker);
        } catch (InvalidSyntaxException ise) {
            log.error(LogUtils.LIFECYCLE_MARKER, "Error registering filtered dependency", ise);
        }
    }

    public void start(BundleContext bundleContext) throws Exception {
        context = bundleContext;
        Dictionary<?, ?> dictionary = context.getBundle().getHeaders();
        bundleName = (String) dictionary.get(Constants.BUNDLE_NAME);
        bundleDescription = (String) dictionary.get(Constants.BUNDLE_DESCRIPTION);
        if (bundleName == null) {
            bundleName = context.getBundle().getSymbolicName();
        }
        if (bundleDescription == null) {
            bundleDescription = "Bundle for " + bundleName;
        }

        for (String dependency : getDependencies()) {
            addTracker(dependency);
        }
        for (FilteredDependency dependency : getFilteredDependencies()) {
            addFilteredTracker(dependency);
        }
        addTracker(EventAdmin.class.getName());
        if (dependsOnSysconfig()) {
            ServiceTracker tracker = new ServiceTracker(bundleContext, ISystemConfig.class.getName(), null) {
                @Override
                public Object addingService(ServiceReference reference) {
                    Object service = context.getService(reference);
                    lock.lock();
                    try {
                        dependentServiceReferences.put(ISystemConfig.class.getName(), reference);
                        dependentServices.put(reference, service);
                    } finally {
                        lock.unlock();
                    }
                    serviceAdded(ISystemConfig.class.getName(), reference, service);
                    if (registerService()) {
                        lock.lock();
                        try {
                            Properties props = new Properties();
                            props.put(org.osgi.framework.Constants.SERVICE_PID, getServicePid());
                            props.put(org.osgi.framework.Constants.SERVICE_DESCRIPTION, getBundleDescription());
                            context.registerService(getServiceClassNames().toArray(new String[0]), ServiceActivator.this, props);
                        } finally {
                            lock.unlock();
                        }
                    }
                    return service;

                }

                @Override
                public void removedService(ServiceReference reference, Object serviceObject) {
                    lock.lock();
                    try {
                        dependentServiceReferences.remove(ISystemConfig.class.getName(), reference);
                        dependentServices.remove(reference);
                    } finally {
                        lock.unlock();
                    }
                    context.ungetService(reference);
                    serviceRemoved(ISystemConfig.class.getName(), reference, serviceObject);
                }
            };
            tracker.open();
            trackers.put(ISystemConfig.class.getName(), tracker);
        } else {
            if (registerService()) {
                lock.lock();
                try {
                    Properties props = new Properties();
                    props.put(org.osgi.framework.Constants.SERVICE_PID, getServicePid());
                    props.put(org.osgi.framework.Constants.SERVICE_DESCRIPTION, getBundleDescription());
                    context.registerService(getServiceClassNames().toArray(new String[0]), ServiceActivator.this, props);
                } finally {
                    lock.unlock();
                }
            }
        }
        if (registerFrameworkStoppingListener()) {
            final Bundle systemBundle = context.getBundle(0);
            systemBundle.getBundleContext().addBundleListener(new SynchronousBundleListener() {
                public void bundleChanged(BundleEvent event) {
                    if (event.getBundle().equals(systemBundle) && event.getType() == BundleEvent.STOPPING) {
                        frameworkStopping();
                    }
                }
            });
        }
        if (isInitialized()) {
            startLocked();
        }
    }

    /**
     * Override if bundle needs to do something when framework is stopping
     */
    protected void frameworkStopping() {

    }

    @SuppressWarnings("unchecked")
    protected <Service> Service getDependency(Class<Service> type) {
        lock.lock();
        try {
            Collection<ServiceReference> depdencies = dependentServiceReferences.get(type.getName());
            if (depdencies != null && depdencies.size() > 0) {
                Service srv = (Service) dependentServices.get(depdencies.iterator().next());
                return srv;
            } else {
                return null;
            }
        } finally {
            lock.unlock();
        }
    }

    @SuppressWarnings("unchecked")
    protected <Service> Map<ServiceReference, Service> getDependencies(Class<Service> type) {
        lock.lock();
        try {
            Collection<ServiceReference> refs = dependentServiceReferences.get(type.getName());
            HashMap<ServiceReference, Service> map = new HashMap<ServiceReference, Service>();
            if (refs != null) {
                for (ServiceReference ref : refs) {
                    map.put(ref, (Service) dependentServices.get(ref));
                }
            }
            return map;
        } finally {
            lock.unlock();
        }
    }

    private void serviceAdded(String type, ServiceReference reference, Object service) {
        if (type.equals(EventAdmin.class.getName())) {
            eventAdmin = (EventAdmin) service;
        }
        serviceAvailable(type, reference, service);
        if (isInitialized()) {
            startLocked();
        } else {
            fireEvent();
        }
    }

    private void serviceRemoved(String type, ServiceReference reference, Object service) {
        serviceUnAvailable(type, reference, service);
        if (isInitialized()) {
            stopLocked(false);
        } else {
            fireEvent();
        }
    }

    public void stop(BundleContext context) throws Exception {
        for (ServiceTracker tracker : trackers.values()) {
            tracker.close();
        }
        trackers.clear();
        dependentServices.clear();
        stopLocked(true);
    }

    /**
     * Are all the requirements for starting this service met
     * 
     * @return true if all the requirements for starting this service met
     */
    public boolean isInitialized() {
        lock.lock();
        try {
            for (String dependency : getDependencies()) {
                if (dependentServiceReferences.get(dependency) == null || dependentServiceReferences.get(dependency).size() == 0)
                    return false;
            }
            for (FilteredDependency dependency : getFilteredDependencies()) {
                if (dependentServiceReferences.get(dependency.type) == null || dependentServiceReferences.get(dependency.type).size() == 0)
                    return false;
            }
            if (dependsOnSysconfig() && dependentServiceReferences.get(ISystemConfig.class.getName()) == null) {
                return false;
            }
            if (eventAdmin == null) {
                return false;
            }
        } finally {
            lock.unlock();
        }
        return true;
    }

    /**
     * Get all the required dependencies that are satisfied
     * 
     * @return all the required dependencies that are satisfied
     */
    public List<String> getOkServices() {
        ArrayList<String> ok = new ArrayList<String>();
        for (String dependency : getDependencies()) {
            if (dependentServiceReferences.get(dependency) != null && dependentServiceReferences.get(dependency).size() > 0) {
                ok.add(dependency);
            }
        }
        for (FilteredDependency dependency : getFilteredDependencies()) {
            if (dependentServiceReferences.get(dependency.type) != null && dependentServiceReferences.get(dependency.type).size() > 0) {
                ok.add(dependency.type);
            }
        }
        return ok;
    }

    /**
     * Get all the required dependencies that are not yet satisfied
     * 
     * @return all the required dependencies that are not yet satisfied
     */
    public List<String> getWaitingServices() {
        ArrayList<String> waiting = new ArrayList<String>();
        for (String dependency : getDependencies()) {
            if (dependentServiceReferences.get(dependency) == null || dependentServiceReferences.get(dependency).size() == 0) {
                waiting.add(dependency);
            }
        }
        for (FilteredDependency dependency : getFilteredDependencies()) {
            if (dependentServiceReferences.get(dependency.type) == null || dependentServiceReferences.get(dependency.type).size() == 0) {
                waiting.add(dependency.type);
            }
        }
        return waiting;
    }

    /**
     * Get all the optional dependencies that are satisfied
     * 
     * @return all the optional dependencies that are satisfied
     */
    public List<String> getOptionalOkServices() {
        ArrayList<String> ok = new ArrayList<String>();
        return ok;
    }

    /**
     * Get all the optional dependencies that are not yet satisfied
     * 
     * @return all the optional dependencies that are not yet satisfied
     */
    public List<String> getOptionalWaitingServices() {
        ArrayList<String> waiting = new ArrayList<String>();
        return waiting;
    }

    /**
     * Get any extra status text to append to the default status text
     * 
     * @param html
     *            true if the status text should be formated in html
     * @return any extra status text for this service
     */
    public String getExtraStatus(boolean html) {
        return null;
    }

    protected void fireEvent() {
        if (eventAdmin != null) {
            Properties props = new Properties();
            props.put("className", ServiceActivator.this.getClass().getName());
            eventAdmin.postEvent(new Event(TOPIC, (Dictionary<Object, Object>) props));
        }
    }

    public String getCurrentStatus(boolean html) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        Object pid = getServicePid();
        Object serviceDesc = context.getBundle().getHeaders().get(Constants.SERVICE_DESCRIPTION);

        if (html) {
            List<String> ok = getOkServices();
            List<String> waiting = getWaitingServices();
            List<String> okOptional = getOptionalOkServices();
            List<String> waitingOptional = getOptionalWaitingServices();

            ServiceLifecycleState state = getState();
            String status = null;
            switch (state) {
            case CREATED:
                status = "<font color='#0000cc'>" + state.toString() + "</font>";
                break;
            case STARTED:
                status = "<font color='#00cc00'>" + state.toString() + "</font>";
                break;
            case STARTING:
                status = "<font color='#FFFF00'>" + state.toString() + "</font>";
                break;
            case STOPPED:
                status = "<font color='#cc0000'>" + state.toString() + "</font>";
                break;
            case NOT_ENABLED:
                status = "<font color='#cc0000'>" + state.toString() + "</font>";
                break;
            case STOPPING:
                status = "<font color='#FF9900'>" + state.toString() + "</font>";
                break;
            }

            pw.println("<div id='" + pid + "'>");
            pw.println("<h2>" + ((pid != null) ? pid : "") + " - " + status + "</h2><div id='sub" + pid + "'>" + ((serviceDesc != null) ? serviceDesc : ""));
            pw.println("<br/>Bundle: [" + context.getBundle().getBundleId() + "] " + context.getBundle().getLocation());
            pw.println("<br/>Version: [" + context.getBundle().getVersion().toString() + "] LastModified: [" + DateFormat.getDateTimeInstance().format(new Date(context.getBundle().getLastModified())) + "]");

            if (ok != null && ok.size() > 0) {
                pw.println("<h4><font color='#00cc00'>Services that are already available:</font></h4>");
                TreeSet<String> set = new TreeSet<String>(ok);
                for (String srv : set) {
                    pw.println("<li>" + srv + "</li>");
                }
            }
            if (okOptional != null && okOptional.size() > 0) {
                pw.println("<h4><font color='#00cc00'>Optional services that are already available:</font></h4>");
                TreeSet<String> set = new TreeSet<String>(okOptional);
                for (String srv : set) {
                    pw.println("<li>" + srv + "</li>");
                }
            }
            if (waiting != null && waiting.size() > 0) {
                pw.println("<h4><font color='#cc0000'>Services that are not available yet:</font></h4>");
                TreeSet<String> set = new TreeSet<String>(waiting);
                for (String srv : set) {
                    pw.println("<li>" + srv + "</li>");
                }
            }
            if (waitingOptional != null && waitingOptional.size() > 0) {
                pw.println("<h4><font color='#cc0000'>Optional services that are not available yet:</font></h4>");
                TreeSet<String> set = new TreeSet<String>(waitingOptional);
                for (String srv : set) {
                    pw.println("<li>" + srv + "</li>");
                }
            }
            String cs = getExtraStatus(true);
            if (cs != null) {
                pw.println(cs);
            }
            pw.println("</div></div><hr width='100%' size='1' />");

        } else {
            pw.println("**********************************************************");
            pw.println("Bundle: [" + context.getBundle().getBundleId() + "] " + context.getBundle().getLocation());
            pw.println("Service: [" + ((pid != null) ? pid : "") + "] " + ((serviceDesc != null) ? serviceDesc : ""));
            pw.println("Version: [" + context.getBundle().getVersion().toString() + "] LastModified: [" + DateFormat.getDateTimeInstance().format(new Date(context.getBundle().getLastModified())) + "]");
            pw.println(getServiceStatus());
        }
        pw.flush();
        sw.flush();
        return sw.toString();
    }

    private String getServiceStatus() {
        StringBuilder result = new StringBuilder();
        List<String> ok = getOkServices();
        List<String> waiting = getWaitingServices();
        List<String> okOptional = getOptionalOkServices();
        List<String> waitingOptional = getOptionalWaitingServices();

        result.append("State:" + getState() + "\n");
        if (ok != null && ok.size() > 0) {
            result.append("Available Required Services:\n");
            for (String serv : ok) {
                result.append("\t");
                result.append(serv);
                result.append("\n");
            }
        }
        if (waiting != null && waiting.size() > 0) {
            result.append("Waiting for Required Services:\n");
            for (String serv : waiting) {
                result.append("\t");
                result.append(serv);
                result.append("\n");
            }
        }
        if (okOptional != null && okOptional.size() > 0) {
            result.append("Available Optional Services:\n");
            for (String serv : okOptional) {
                result.append("\t");
                result.append(serv);
                result.append("\n");
            }
        }
        if (waitingOptional != null && waitingOptional.size() > 0) {
            result.append("Unavailable Optional Services:\n");
            for (String serv : waitingOptional) {
                result.append("\t");
                result.append(serv);
                result.append("\n");
            }
        }

        result.append("\n");
        String status = getExtraStatus(false);
        if (status != null && status.length() > 0) {
            result.append("Extra Status Info:\n");
            result.append(status);
            result.append("\n");

        }
        return result.toString();
    }

    final protected void startLocked() {
        if (startThreaded()) {
            lock.lock();
            try {
                if (startThread == null) {
                    startThread = new Thread(startRunner, "ServiceInitializer:" + getServicePid());
                    startThread.start();
                }
            } finally {
                lock.unlock();
            }
        } else {
            startRunner.run();
        }
    }

    final protected void stopLocked(boolean bundleStopping) {
        StopRunner runner = new StopRunner(bundleStopping);
        runner.run();
    }

    class StartRunner implements Runnable {
        public void run() {
            lock.lock();
            ServiceLifecycleState prevState = state;
            try {
                if (state != ServiceLifecycleState.STARTED && state != ServiceLifecycleState.STARTING) {
                    state = ServiceLifecycleState.STARTING;
                    log.info(LogUtils.LIFECYCLE_MARKER, "Starting " + ServiceActivator.this.getClass().getName());
                    start();
                    log.info(LogUtils.LIFECYCLE_MARKER, "Started " + ServiceActivator.this.getClass().getName());
                    state = ServiceLifecycleState.STARTED;
                }
                fireEvent();
            } catch (Throwable t) {
                log.error(LogUtils.LIFECYCLE_MARKER, "Error starting bundle activator:" + ServiceActivator.this.getClass().getName(), t);
                state = prevState;
            } finally {
                startThread = null;
                lock.unlock();
            }
        }
    }

    class StopRunner implements Runnable {
        private final boolean bundleStopping;

        StopRunner(boolean bundleStopping) {
            this.bundleStopping = bundleStopping;
        }

        public void run() {
            lock.lock();
            try {
                if (state == ServiceLifecycleState.STARTED) {
                    state = ServiceLifecycleState.STOPPING;
                    log.info(LogUtils.LIFECYCLE_MARKER, "Stopping " + ServiceActivator.this.getClass().getName());
                    stop(bundleStopping);
                    log.info(LogUtils.LIFECYCLE_MARKER, "Stopped " + ServiceActivator.this.getClass().getName());
                }
                fireEvent();
            } catch (Throwable t) {
                log.error(LogUtils.LIFECYCLE_MARKER, "Error stopping bundle activator:" + ServiceActivator.this.getClass().getName(), t);
            } finally {
                state = ServiceLifecycleState.STOPPED;
                lock.unlock();
            }
        }
    }

    public String getBundleName() {
        return bundleName;
    }

    public String getBundleDescription() {
        return bundleDescription;
    }

    /**
     * Start the service
     */
    public abstract void start() throws AnzoException;

    /**
     * Stop the service
     * 
     * @param bundleStopping
     *            true if bundle is being specifically stopped
     */
    public abstract void stop(boolean bundleStopping) throws AnzoException;

    /**
     * A dependent service of the given type is available
     * 
     * @param type
     *            type of service available
     * @param service
     *            service object
     */
    public void serviceAvailable(String type, ServiceReference reference, Object service) {

    }

    /**
     * A dependent service of the given type is available
     * 
     * @param type
     *            type of service available
     * @param service
     *            service object
     */
    public void serviceUnAvailable(String type, ServiceReference reference, Object service) {

    }

    /**
     * Provide the list of dependencies
     * 
     * @return the list of dependencies
     */
    public abstract String[] getDependencies();

    /**
     * Provide the list of dependencies
     * 
     * @return the list of dependencies
     */
    public FilteredDependency[] getFilteredDependencies() {
        return new FilteredDependency[0];
    }

    /**
     * Get the service pid for this service
     * 
     * @return the service pid for this service
     */
    public abstract String getServicePid();

    /**
     * Should this service register itself with the osgi system as a service
     * 
     * @return true if this service register itself with the osgi system as a service
     */
    public boolean registerService() {
        return true;
    }

    public class FilteredDependency {
        String type;

        String filter;

        public FilteredDependency(String type, String filter) {
            this.type = type;
            this.filter = filter;
        }
    }
}
