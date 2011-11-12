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
package org.openanzo.osgi.registry.internal;

import java.io.IOException;
import java.io.InputStreamReader;
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

import org.openanzo.client.AnzoClient;
import org.openanzo.client.pool.AnzoClientPool;
import org.openanzo.client.pool.RestrictedAnzoClient;
import org.openanzo.datasource.IDatasourceListener;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.osgi.IStatusProvider;
import org.openanzo.osgi.OsgiConfigurationUtils;
import org.openanzo.osgi.ServiceLifecycleState;
import org.openanzo.osgi.registry.RegistryDataset;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.OSGI;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
class RegistryManifestLoader implements BundleListener, IDatasourceListener, IStatusProvider {
    private static final Logger       log                              = LoggerFactory.getLogger(RegistryManifestLoader.class);

    private static final String       REGISTRY_INITIALIZATION_RESOURCE = "Registry-Init-Resources";

    private static final String       TEMPLATE_FILE                    = "template.trig";

    private static final String       FILE_EXTENSION                   = ".trig";

    private static final URI          loaded                           = Constants.valueFactory.createURI("http://openanzo.org/internal/registryManifest#isLoaded");

    private static final URI          fileLoaded                       = Constants.valueFactory.createURI("http://openanzo.org/internal/registryManifest#fileLoaded");

    private static final URI          rml                              = org.openanzo.rdf.Constants.valueFactory.createURI("http://openanzo.org/internal/registryManifest");

    private final BundleContext       context;

    private final AnzoClientPool      clientPool;

    private final HashSet<Long>       bundles                          = new HashSet<Long>();

    private ServiceLifecycleState     state                            = ServiceLifecycleState.CREATED;

    private final ServiceRegistration reg;

    private String                    currentlyLoading                 = null;

    private RegistryDataset           registry                         = null;

    private final ArrayList<String>   loadedFiles                      = new ArrayList<String>();

    protected RegistryManifestLoader(BundleContext context, AnzoClientPool clientPool, RegistryProvider registryProvider) {
        this.context = context;
        this.clientPool = clientPool;
        try {
            this.registry = registryProvider.openRegistry(OSGI.OSGI, "RegistryManifestLoader-Registry");
            this.registry.addNamedGraph(org.openanzo.rdf.Constants.OSGI.OSGI);
        } catch (AnzoException ae) {
            log.error(LogUtils.LIFECYCLE_MARKER, "Error loading osgi registry dataset", ae);
            throw new AnzoRuntimeException(ae);
        }
        reg = context.registerService(IStatusProvider.class.getName(), this, null);
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

            pw.println("<div id='registryResourceProvider'>");
            pw.println("<h2>org.openanzo.osgi.registry.RegistryResourceDataLoader" + " - " + statusString + "</h2><div id='subRegistryResourceProvider'> Loads registry init resource data into server");
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
            pw.println("RegistryResourceDataLoader:");
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

    protected void open() {
        state = ServiceLifecycleState.STARTING;
        clientPool.registerDatasourceListener(this);

        processBundles();
        context.addBundleListener(this);
        state = ServiceLifecycleState.STARTED;
    }

    public void resetStarting() throws AnzoException {
    }

    public void reset() throws AnzoException {
        bundles.clear();
    }

    public void postReset() throws AnzoException {
        this.registry.addNamedGraph(org.openanzo.rdf.Constants.OSGI.OSGI);
        processBundles();
    }

    public void resetFinished() throws AnzoException {

    }

    protected void close(boolean bundleStopping) {
        clientPool.unregisterDatasourceListener(this);
        context.removeBundleListener(this);
        state = ServiceLifecycleState.STOPPED;
        if (bundleStopping && reg != null) {
            reg.unregister();
        }
    }

    public void bundleChanged(BundleEvent event) {
        Bundle bundle = event.getBundle();
        if (Bundle.ACTIVE == bundle.getState()) {
            try {
                registry.beginUpdatingRegistry();
                addingBundle(bundle);
                registry.commitRegistry();
            } catch (AnzoException ae) {
                log.error(LogUtils.LIFECYCLE_MARKER, "Error updating bundle's registry data", ae);
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
            log.error(LogUtils.LIFECYCLE_MARKER, "Error processing bundles' registry data", ae);
        }
    }

    @SuppressWarnings("unchecked")
    private void addingBundle(Bundle bundle) {
        if (!bundles.contains(bundle.getBundleId())) {
            bundles.add(bundle.getBundleId());
            try {
                String symbolicName = bundle.getSymbolicName();
                URI uri = Constants.valueFactory.createURI(OSGI.BUNDLE + symbolicName);
                if (registry.contains(rml, loaded, uri, org.openanzo.rdf.Constants.OSGI.OSGI)) {
                    return;
                }
                Dictionary<String, String> headers = bundle.getHeaders();
                String initPath = headers.get(REGISTRY_INITIALIZATION_RESOURCE);

                if (initPath != null) {
                    log.info(LogUtils.LIFECYCLE_MARKER, "Loading registry init files: " + bundle.getSymbolicName() + " " + initPath);
                    RestrictedAnzoClient client = this.clientPool.getAnzoClient(false, "RegistryManifestLoader-BundleLoader");
                    try {
                        StringTokenizer st = new StringTokenizer(initPath, ",");
                        Collection<Statement> stmts = new HashSet<Statement>();
                        Collection<Statement> templateStatements = new HashSet<Statement>();
                        while (st.hasMoreTokens()) {
                            String token = st.nextToken();
                            token = OsgiConfigurationUtils.preprocessString(token, bundle.getBundleContext());
                            if (token.endsWith(".trig")) {
                                processFile(bundle, token, stmts, templateStatements);
                            } else if (token.endsWith("/")) {
                                processDirectory(bundle, token, false, client);
                            } else if (token.endsWith("/*")) {
                                processDirectory(bundle, token, true, client);
                            }
                        }
                        importStatements(client, stmts, templateStatements);

                    } finally {
                        this.clientPool.returnAnzoClient(client);
                        currentlyLoading = null;
                    }
                }
                registry.add(rml, loaded, uri, org.openanzo.rdf.Constants.OSGI.OSGI);
            } catch (AnzoException ae) {
                log.error(LogUtils.LIFECYCLE_MARKER, "Error loading bundle's registry data:" + bundle.getSymbolicName(), ae);
            }
        }
    }

    private void importStatements(AnzoClient client, Collection<Statement> statements, Collection<Statement> templateStatements) throws AnzoException {
        if (templateStatements.size() == 0) {
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
                    templateStatements.addAll(ReadWriteUtils.loadStatements(new InputStreamReader(initResource.openStream(), Constants.byteEncoding), RDFFormat.forFileName(file), ""));
                } else {
                    stmts.addAll(ReadWriteUtils.loadStatements(new InputStreamReader(initResource.openStream(), Constants.byteEncoding), RDFFormat.forFileName(file), ""));
                }
                registry.add(rml, fileLoaded, Constants.valueFactory.createURI(initResource.toURI().toString()), org.openanzo.rdf.Constants.OSGI.OSGI);
                loadedFiles.add(file);
            }
        } catch (URISyntaxException ae) {
            log.error(LogUtils.LIFECYCLE_MARKER, "IOException while loading registry file:" + file, ae);
        } catch (IOException ae) {
            log.error(LogUtils.LIFECYCLE_MARKER, "IOException while loading  registry file:" + file, ae);
        } catch (AnzoException ae) {
            log.error(LogUtils.LIFECYCLE_MARKER, "AnzoException loading registry file:" + file, ae);
        } finally {
            currentlyLoading = null;
        }
    }
}
