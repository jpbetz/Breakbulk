/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.boca.endpoint/src/com/ibm/adtech/boca/endpoint/QueryServlet.java,v $
 * Created by:  Wing Yung ( <a href="mailto:wingyung@us.ibm.com">wingyung@us.ibm.com </a>)
 * Created on:  01/23/2007
 * Revision:    $Id: QueryServlet.java 166 2007-07-31 14:11:12Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.servlet.sparql;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openanzo.client.pool.AnzoClientPool;
import org.openanzo.client.pool.RestrictedAnzoClient;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.query.QueryResults;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.URI;
import org.openanzo.services.AnzoPrincipal;
import org.openanzo.services.serialization.CommonSerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Very simple SPARQL servlet.
 * 
 * Parameters: query default-graph-uri named-graph-uri
 * 
 * output: rdf-xml, xml, json
 * 
 * callback
 * 
 * xslt
 * 
 * Optionally, pass output=json and callback=jsFuncName for AJAX.
 */
public class QueryServlet extends HttpServlet {
    private static final Logger log              = LoggerFactory.getLogger(QueryServlet.class);

    private static final long   serialVersionUID = 1L;

    AnzoClientPool              clientPool;

    QueryServlet(AnzoClientPool clientPool) {
        this.clientPool = clientPool;
    }

    @Override
    public void init() throws ServletException {
        super.init();

    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getUserPrincipal() == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        try {
            RestrictedAnzoClient client = clientPool.getAnzoClient(false, "QueryServlet");
            try {
                client.setServiceUser(((AnzoPrincipal) req.getUserPrincipal()).getName());
                String query = URLDecoder.decode(req.getParameter("query"), Constants.byteEncoding);
                if (query != null) {
                    String[] defaultGraphs = req.getParameterValues("default-graph-uri");
                    String[] namedGraphs = req.getParameterValues("named-graph-uri");
                    String[] namedDatasets = req.getParameterValues("named-dataset-uri");
                    String charSet = req.getHeader("Accept-Charset");
                    if (charSet == null) {
                        charSet = Constants.byteEncoding;
                    }
                    String baseURI = req.getParameter("base-uri");
                    String format = req.getParameter("format");
                    if (format == null) {
                        format = req.getHeader("Accept");
                        if (format != null && format.contains(",")) {
                            format = format.substring(0, format.indexOf(','));
                        }
                    }
                    if (format != null && format.equals("*/*")) {
                        format = null;
                    }
                    Set<URI> dgs = null;
                    Set<URI> ngs = null;
                    Set<URI> nds = null;
                    if (defaultGraphs != null) {
                        dgs = new HashSet<URI>();
                        for (String uri : defaultGraphs) {
                            dgs.add(Constants.valueFactory.createURI(uri));
                        }
                    }
                    if (namedGraphs != null) {
                        ngs = new HashSet<URI>();
                        for (String uri : namedGraphs) {
                            ngs.add(Constants.valueFactory.createURI(uri));
                        }
                    }
                    if (namedDatasets != null) {
                        nds = new HashSet<URI>();
                        for (String uri : namedDatasets) {
                            nds.add(Constants.valueFactory.createURI(uri));
                        }
                    }
                    QueryResults result = client.serverQuery(dgs, ngs, nds, query, baseURI != null ? Constants.valueFactory.createURI(baseURI) : null);
                    if (format == null) {
                        format = RDFFormat.SPARQL.getDefaultMIMEType();
                    }
                    resp.setCharacterEncoding(charSet);
                    resp.setStatus(200);
                    if ((result.isConstructResult() || result.isDescribeResult()) && RDFFormat.SPARQL.getDefaultMIMEType().equals(format)) {
                        format = result.doStatementsContainQuads() ? RDFFormat.TRIG.getDefaultMIMEType() : RDFFormat.N3.getDefaultMIMEType();
                    }
                    resp.setContentType(format);
                    CommonSerializationUtils.writeQueryResults(result, resp.getWriter(), format, charSet);
                } else {
                    int errorCode = 400;
                    String msg = "No query parameter specified";
                    resp.setCharacterEncoding(Constants.byteEncoding);
                    resp.setStatus(errorCode);
                    log.error(LogUtils.DATASOURCE_MARKER, msg);

                    try {
                        resp.getWriter().write(msg);
                    } catch (IOException ex) {
                        resp.sendError(errorCode, msg);
                    }
                }
            } catch (AnzoException e) {
                resp.setStatus(400);
                log.error(LogUtils.DATASOURCE_MARKER, "Error in sparql servlet", e);
                try {
                    resp.getWriter().write(e.getMessage());
                } catch (Exception ex) {
                    resp.sendError((int) e.getErrorCode(), e.getMessage());
                }
            } finally {
                clientPool.returnAnzoClient(client);
            }
        } catch (AnzoException e) {
            resp.setStatus(400);
            log.error(LogUtils.DATASOURCE_MARKER, "Error in sparql servlet", e);
            try {
                resp.getWriter().write(e.getMessage());
            } catch (Exception ex) {
                resp.sendError((int) e.getErrorCode(), e.getMessage());
            }
        } finally {
            resp.getWriter().flush();
            resp.getWriter().close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
