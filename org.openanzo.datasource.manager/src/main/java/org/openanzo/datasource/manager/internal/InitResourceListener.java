/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Aug 19, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.datasource.manager.internal;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.concurrent.locks.ReentrantLock;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.pool.AnzoClientPool;
import org.openanzo.client.pool.RestrictedAnzoClient;
import org.openanzo.datasource.DatasourceDictionary;
import org.openanzo.datasource.IDatasourceListener;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.osgi.IServiceTrackerListener;
import org.openanzo.osgi.IStatusProvider;
import org.openanzo.osgi.OsgiConfigurationUtils;
import org.openanzo.osgi.OsgiServiceTracker;
import org.openanzo.osgi.ServiceLifecycleState;
import org.openanzo.osgi.registry.IRegistryProvider;
import org.openanzo.osgi.registry.RegistryDataset;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.SmartEncodingInputStream;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;
import org.osgi.framework.Constants;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class InitResourceListener implements BundleListener, IDatasourceListener, IStatusProvider {
    private static final Logger                log                              = LoggerFactory.getLogger(InitResourceListener.class);

    private static final String                REGISTRY_INITIALIZATION_RESOURCE = "Instance-Init-Resources";

    private static final String                TEMPLATE_FILE                    = "template.trig";

    private OsgiServiceTracker<AnzoClientPool> clientPoolTracker                = null;

    private final BundleContext                context;

    AnzoClientPool                             clientPool                       = null;

    private HashSet<Long>                      bundles                          = new HashSet<Long>();

    private static final String                FILE_EXTENSION                   = ".trig";

    protected final ReentrantLock              lock                             = new ReentrantLock();

    protected ServiceLifecycleState            state                            = ServiceLifecycleState.CREATED;

    protected Thread                           startThread                      = null;

    private final StartRunner                  startRunner                      = new StartRunner();

    String                                     currentlyLoading                 = null;

    private final ArrayList<String>            loadedFiles                      = new ArrayList<String>();

    ServiceRegistration                        reg                              = null;

    private RegistryDataset                    registry                         = null;

    private boolean                            testing                          = false;

    InitResourceListener(BundleContext context, IRegistryProvider registryProvider) {
        this.context = context;
        testing = context.getProperty("regressionTesting") != null;
        if (!testing) {
            try {
                this.registry = registryProvider.openRegistry(org.openanzo.rdf.Constants.OSGI.OSGI, "InitResourcesManifestLoader");
                this.registry.addNamedGraph(org.openanzo.rdf.Constants.OSGI.OSGI);
            } catch (AnzoException ae) {
                log.error(LogUtils.DATASOURCE_MARKER, "Error creating init resources manifest loader's registry", ae);
                throw new AnzoRuntimeException(ae);
            }
        }
        IServiceTrackerListener<AnzoClientPool> listener = new IServiceTrackerListener<AnzoClientPool>() {

            public void unregisterService(AnzoClientPool service) {
                if (clientPool != null) {
                    clientPool.unregisterDatasourceListener(InitResourceListener.this);
                }
                clientPool = service;
                stopLocked(false);
            }

            public void registerService(AnzoClientPool service) {
                if (clientPool == null) {
                    clientPool = service;
                    startLocked();
                }
            }

            public Class<AnzoClientPool> getComponentType() {
                return AnzoClientPool.class;
            }

        };
        String filterString = "(&(" + Constants.OBJECTCLASS + "=" + listener.getComponentType().getName() + ")(!(" + DatasourceDictionary.KEY_DATASOURCE_URI + " =*)))";
        try {
            Filter filter = context.createFilter(filterString);
            clientPoolTracker = new OsgiServiceTracker<AnzoClientPool>(listener, filter, context);
            clientPoolTracker.open();
        } catch (InvalidSyntaxException ise) {
            log.error(LogUtils.LIFECYCLE_MARKER, Messages.formatString(ExceptionConstants.OSGI.INVALID_SERVICE_SYNTAX, filterString), ise);
        }
        reg = context.registerService(IStatusProvider.class.getName(), this, null);
    }

    void stop(boolean bundleStopping) {
        state = ServiceLifecycleState.STOPPING;
        if (!bundleStopping) {
            context.removeBundleListener(this);
            reg.unregister();
            reg = null;
        }
        clientPoolTracker.close();
        state = ServiceLifecycleState.STOPPED;
    }

    public String getCurrentStatus(boolean html) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        if (html) {
            String statusString = null;
            switch (state) {
            case CREATED:
                statusString = "<font color='#0000cc'>" + state.toString() + "</font>";
                break;
            case STARTED:
                statusString = "<font color='#00cc00'>" + state.toString() + "</font>";
                break;
            case STARTING:
                statusString = "<font color='#FFFF00'>" + state.toString() + "</font>";
                break;
            case STOPPED:
                statusString = "<font color='#cc0000'>" + state.toString() + "</font>";
                break;
            case STOPPING:
                statusString = "<font color='#FF9900'>" + state.toString() + "</font>";
                break;
            }

            pw.println("<div id='initResourceProvider'>");
            pw.println("<h2>org.openanzo.datasource.manager.InitResourceDataLoader" + " - " + statusString + "</h2><div id='subInitResourceProvider'> Loads init resource data into server");
            pw.println("<br/>Bundle: [" + context.getBundle().getBundleId() + "] " + context.getBundle().getLocation());
            if (currentlyLoading != null) {
                pw.println("<br/>Currently Loading:<br/>");
                pw.println(currentlyLoading);
            }
            if (loadedFiles.size() > 0) {
                pw.println("<br/>Loaded Files:<br/>");
                for (String file : loadedFiles) {
                    pw.println("<li>" + file + "</li>");
                }
            }
            pw.println("</div></div><hr width='100%' size='1' />");
        } else {
            pw.println("**********************************************************");
            pw.println("InitResourceListener:");
            pw.println(getState());
            if (currentlyLoading != null) {
                pw.println("Currently Loading:\n");
                pw.println(currentlyLoading);
            }
            if (loadedFiles.size() > 0) {
                pw.println("Loaded Files:\n");
                for (String file : loadedFiles) {
                    pw.println(file + "\n");
                }
            }
        }
        pw.flush();
        sw.flush();
        return sw.toString();
    }

    public ServiceLifecycleState getState() {
        return state;
    }

    private void start() {
        state = ServiceLifecycleState.STARTING;
        clientPool.registerDatasourceListener(this);
        processBundles();
        context.addBundleListener(this);
        state = ServiceLifecycleState.STARTED;
    }

    public void reset() throws AnzoException {
        //clear the bundles list, since data has been reset
        bundles.clear();
    }

    public void resetStarting() throws AnzoException {
    }

    public void resetFinished() throws AnzoException {

    }

    public void postReset() throws AnzoException {
        this.registry.addNamedGraph(org.openanzo.rdf.Constants.OSGI.OSGI);
        processBundles();
    }

    public void bundleChanged(BundleEvent event) {
        Bundle bundle = event.getBundle();
        if (Bundle.ACTIVE == bundle.getState()) {
            try {
                registry.beginUpdatingRegistry();
                addingBundle(bundle);
                registry.commitRegistry();
            } catch (AnzoException ae) {
                log.error(LogUtils.LIFECYCLE_MARKER, "Error processing bundle changed information", ae);
            }
        }
    }

    private void processBundles() {
        try {
            registry.beginUpdatingRegistry();
            Bundle[] bundles = context.getBundles();
            for (Bundle bundle : bundles) {
                if (Bundle.ACTIVE == bundle.getState()) {
                    addingBundle(bundle);
                }
            }
            registry.commitRegistry();
        } catch (AnzoException ae) {
            log.error(LogUtils.LIFECYCLE_MARKER, "Error processing bundle information", ae);
        }
    }

    static final URI loaded     = org.openanzo.rdf.Constants.valueFactory.createURI("http://openanzo.org/internal/initResourcesManifest#isLoaded");

    static final URI fileLoaded = org.openanzo.rdf.Constants.valueFactory.createURI("http://openanzo.org/internal/registryManifest#fileLoaded");

    static final URI irm        = org.openanzo.rdf.Constants.valueFactory.createURI("http://openanzo.org/internal/initResourcesManifest");

    @SuppressWarnings("unchecked")
    void addingBundle(Bundle bundle) {
        if (!bundles.contains(bundle.getBundleId())) {
            bundles.add(bundle.getBundleId());
            try {
                Dictionary<String, String> headers = bundle.getHeaders();
                String initPath = headers.get(REGISTRY_INITIALIZATION_RESOURCE);
                if (initPath != null) {
                    String symbolicName = bundle.getSymbolicName();
                    URI uri = org.openanzo.rdf.Constants.valueFactory.createURI(org.openanzo.rdf.Constants.OSGI.BUNDLE + symbolicName);
                    if (registry.contains(irm, loaded, uri, org.openanzo.rdf.Constants.OSGI.OSGI)) {
                        return;
                    }
                    RestrictedAnzoClient client = this.clientPool.getAnzoClient(false, "InitResourceListener");
                    StringTokenizer st = new StringTokenizer(initPath, ",");
                    try {
                        Collection<Statement> stmts = new HashSet<Statement>();
                        Collection<Statement> templateStatements = new HashSet<Statement>();
                        while (st.hasMoreTokens()) {
                            String token = st.nextToken();
                            token = OsgiConfigurationUtils.preprocessString(token, bundle.getBundleContext());
                            if (token.endsWith(".trig")) {
                                log.info(LogUtils.LIFECYCLE_MARKER, "Loading instance data in file '{}' for bundle {}.", token, bundle.getSymbolicName());
                                processFile(bundle, token, stmts, templateStatements);
                                log.info(LogUtils.LIFECYCLE_MARKER, "Done loading instance data in file '{}' for bundle {}.", token, bundle.getSymbolicName());
                            } else if (token.endsWith("/")) {
                                log.info(LogUtils.LIFECYCLE_MARKER, "Loading instance data from directory '{}' (excluding subdirectories) for bundle {}.", token, bundle.getSymbolicName());
                                processDirectory(bundle, token, false, client);
                                log.info(LogUtils.LIFECYCLE_MARKER, "Done loading instance data from directory '{}' (excluding subdirectories) for bundle {}.", token, bundle.getSymbolicName());
                            } else if (token.endsWith("/*")) {
                                log.info(LogUtils.LIFECYCLE_MARKER, "Loading instance data from directory '{}' (including subdirectories) for bundle {}.", token, bundle.getSymbolicName());
                                processDirectory(bundle, token, true, client);
                                log.info(LogUtils.LIFECYCLE_MARKER, "Done loading instance data from directory '{}' (including subdirectories) for bundle {}.", token, bundle.getSymbolicName());
                            } else {
                                log.warn(LogUtils.LIFECYCLE_MARKER, "Ignoring entry in {} property for bundle {}. Entry must be a file with .trig extension, a directory ending in '/', or a directory ending in '/*'.", REGISTRY_INITIALIZATION_RESOURCE, bundle.getSymbolicName());
                            }
                        }
                        importStatements(client, stmts, templateStatements);

                        registry.add(irm, loaded, uri, org.openanzo.rdf.Constants.OSGI.OSGI);
                    } finally {
                        this.clientPool.returnAnzoClient(client);
                        currentlyLoading = null;
                    }
                }
            } catch (AnzoException ae) {
                log.error(LogUtils.LIFECYCLE_MARKER, "Error adding bundle inforation to registry", ae);
            }
        }
    }

    private void importStatements(AnzoClient client, Collection<Statement> statements, Collection<Statement> templateStatements) throws AnzoException {
        if (templateStatements == null || templateStatements.size() == 0) {
            client.importStatements(statements, AnzoClient.REVISIONED_NAMED_GRAPH);
        } else {

            client.importStatements(statements, templateStatements);
        }
    }

    @SuppressWarnings("unchecked")
    private void processDirectory(Bundle bundle, String directoryName, boolean subDirs, AnzoClient client) throws AnzoException {
        Enumeration entries = bundle.getEntryPaths(directoryName);
        if (entries != null) {
            Collection<Statement> stmts = new HashSet<Statement>();
            Collection<Statement> templateStatements = new HashSet<Statement>();

            while (entries.hasMoreElements()) {
                String entry = (String) entries.nextElement();
                if (entry.endsWith(FILE_EXTENSION)) {
                    processFile(bundle, entry, stmts, templateStatements);
                } else if (subDirs && entry.endsWith("/")) {
                    processDirectory(bundle, entry, subDirs, client);
                }
            }
            importStatements(client, stmts, templateStatements);

        }
    }

    private void processFile(Bundle bundle, String file, Collection<Statement> stmts, Collection<Statement> templateStatements) {
        try {
            currentlyLoading = file;

            URL initResource = bundle.getEntry(file);
            if (initResource != null) {
                if (file.endsWith(TEMPLATE_FILE)) {
                    templateStatements.addAll(ReadWriteUtils.loadStatements(SmartEncodingInputStream.createSmartReader(initResource.openStream()), RDFFormat.forFileName(file), ""));
                } else {
                    stmts.addAll(ReadWriteUtils.loadStatements(SmartEncodingInputStream.createSmartReader(initResource.openStream()), RDFFormat.forFileName(file), ""));
                }
                loadedFiles.add(file);
                registry.add(irm, fileLoaded, org.openanzo.rdf.Constants.valueFactory.createURI(initResource.toURI().toString()), org.openanzo.rdf.Constants.OSGI.OSGI);
            }
        } catch (URISyntaxException ae) {
            log.error(LogUtils.LIFECYCLE_MARKER, "IOException while loading " + file, ae);
        } catch (IOException ae) {
            log.error(LogUtils.LIFECYCLE_MARKER, "IOException while loading " + file, ae);
        } catch (AnzoException ae) {
            log.error(LogUtils.LIFECYCLE_MARKER, "AnzoException loading " + file, ae);
        } finally {
            currentlyLoading = null;
        }
    }

    final protected void startLocked() {
        lock.lock();
        try {
            if (startThread == null) {
                startThread = new Thread(startRunner, "ServiceInitializer: InitResourceListener");
                startThread.start();
            }
        } finally {
            lock.unlock();
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
                if (state == ServiceLifecycleState.STARTED) {

                } else if (state != ServiceLifecycleState.STARTING) {
                    state = ServiceLifecycleState.STARTING;
                    start();
                    state = ServiceLifecycleState.STARTED;
                }
            } catch (Throwable t) {
                state = prevState;
            } finally {
                startThread = null;
                lock.unlock();
            }
        }
    }

    class StopRunner implements Runnable {
        boolean bundleStopping = false;

        StopRunner(boolean bundleStopping) {
            this.bundleStopping = bundleStopping;
        }

        public void run() {
            lock.lock();
            try {
                if (state == ServiceLifecycleState.STARTED) {
                    state = ServiceLifecycleState.STOPPING;
                    stop(bundleStopping);
                }
            } finally {
                state = ServiceLifecycleState.STOPPED;
                lock.unlock();
            }
        }
    }
}
