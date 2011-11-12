/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.servlet.status;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openanzo.exceptions.LogUtils;
import org.openanzo.osgi.IStatusProvider;
import org.openanzo.osgi.ServiceLifecycleState;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet that gives status of services
 * 
 */
class StatusServlet extends HttpServlet {
    private static final Logger log              = LoggerFactory.getLogger(StatusServlet.class);

    private static final long   serialVersionUID = 1L;

    BundleContext               context          = null;

    StatusServlet(BundleContext context) {
        super();
        this.context = context;
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    final HashMap<ServiceReference, IStatusProvider> activatorsMap = new HashMap<ServiceReference, IStatusProvider>();

    public void close() {
        for (Entry<ServiceReference, IStatusProvider> entry : activatorsMap.entrySet()) {
            context.ungetService(entry.getKey());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (req.getQueryString() != null && req.getQueryString().equals("statusOnly")) {
                ServiceReference refs[] = context.getAllServiceReferences(IStatusProvider.class.getName(), null);
                if (refs != null) {
                    boolean allOk = true;
                    for (ServiceReference ref : refs) {
                        IStatusProvider service = (IStatusProvider) context.getService(ref);
                        if (service.getState() != ServiceLifecycleState.NOT_ENABLED && service.getState() != ServiceLifecycleState.STARTED) {
                            allOk = false;
                        }
                    }
                    if (!allOk) {
                        resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "notReady");
                    }
                }
                resp.getWriter().println("OK");
                return;
            } else if (req.getQueryString() != null && req.getQueryString().equals("bundles")) {
                Bundle[] bundles = context.getBundles();
                TreeSet<Bundle> sortedBundles = new TreeSet<Bundle>(new Comparator<Bundle>() {
                    public int compare(Bundle o1, Bundle o2) {
                        return o1.getSymbolicName().compareTo(o2.getSymbolicName());
                    }
                });
                Collections.addAll(sortedBundles, bundles);
                PrintWriter pw = new PrintWriter(resp.getWriter());
                pw.println("<html>");
                for (Bundle bundle : sortedBundles) {
                    pw.println("<h2>" + bundle.getSymbolicName() + "</h2>");
                    pw.println("<br/>Bundle ID: [" + bundle.getBundleId() + "]<br/> Location: " + bundle.getLocation());
                    pw.println("<br/>Version: [" + bundle.getVersion().toString() + "]<br/> LastModified: [" + DateFormat.getDateTimeInstance().format(new Date(bundle.getLastModified())) + "]");
                    pw.println("<br/>State: [" + getState(bundle.getState()) + "]");
                    pw.println("<hr/>");
                }
                pw.println("</html>");
                return;
            } else {
                ServiceReference refs[] = context.getAllServiceReferences(IStatusProvider.class.getName(), null);
                TreeSet<ServiceReference> activators = new TreeSet<ServiceReference>(new Comparator<ServiceReference>() {

                    public int compare(ServiceReference ref1, ServiceReference ref2) {
                        IStatusProvider service1 = activatorsMap.get(ref1);
                        if (service1 == null) {
                            service1 = (IStatusProvider) context.getService(ref1);
                            activatorsMap.put(ref1, service1);
                        }
                        IStatusProvider service2 = activatorsMap.get(ref2);
                        if (service2 == null) {
                            service2 = (IStatusProvider) context.getService(ref2);
                            activatorsMap.put(ref2, service2);
                        }
                        if (service1.getState().equals(service2.getState())) {
                            Object pid1 = ref1.getProperty(Constants.SERVICE_PID);
                            Object pid2 = ref2.getProperty(Constants.SERVICE_PID);
                            if (pid1 != null && pid2 != null) {
                                return pid1.toString().compareTo(pid2.toString());
                            } else if (pid1 != null) {
                                return -1;
                            } else {
                                return 1;
                            }
                        } else {
                            return service1.getState().compareTo(service2.getState());
                        }

                    }
                });
                if (refs != null) {
                    for (ServiceReference ref : refs) {
                        activators.add(ref);
                    }
                    StringWriter sb = new StringWriter();
                    PrintWriter pw = new PrintWriter(sb);
                    boolean allOk = true;
                    for (ServiceReference ref : activators) {
                        IStatusProvider service = activatorsMap.get(ref);
                        if (service == null) {
                            service = (IStatusProvider) context.getService(ref);
                            activatorsMap.put(ref, service);
                        }
                        allOk = allOk && (service.getState() == ServiceLifecycleState.NOT_ENABLED || service.getState().equals(ServiceLifecycleState.STARTED));
                        pw.println(service.getCurrentStatus(true));
                    }
                    StringWriter sw2 = new StringWriter();
                    PrintWriter pw2 = new PrintWriter(sw2);
                    pw2.println("<html>");
                    if (allOk) {
                        pw2.println("<h1><font color='#00cc00'>Overall Status: OK</font></h1>");
                    } else {
                        String auto = req.getParameter("auto_refresh");
                        boolean refresh = auto != null ? Boolean.valueOf(auto) : true;
                        pw2.println("<head>" + (refresh ? "<meta http-equiv='refresh' content='5'>" : "") + "</head>");
                        pw2.println("<span class=\"smallfont\"><a href=\"?auto_refresh=" + !refresh + "\">" + (refresh ? "DISABLE AUTO REFRESH" : "ENABLE AUTO REFRESH") + "</a></span>");
                        pw2.println("<h1><font color='#cc0000'>Overall Status: Not All Started</font></h1>");
                    }
                    pw2.print(sb.toString());
                    pw2.println("</html>");
                    resp.getWriter().println(sw2.toString());
                }
            }
        } catch (Exception e) {
            log.error(LogUtils.SERVER_INTERNAL_MARKER, "Error getting status", e);
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, sw.toString());
        } finally {
            resp.getWriter().flush();
            resp.getWriter().close();
        }
    }

    private final String getState(int state) {
        switch (state) {
        case 1:
            return "UNINSTALLED";
        case 2:
            return "INSTALLED";
        case 4:
            return "RESOLVED";
        case 8:
            return "STARTING";
        case 16:
            return "STOPPING";
        case 32:
            return "ACTIVE";
        default:
            return "UNKNOWN";
        }
    }
}
