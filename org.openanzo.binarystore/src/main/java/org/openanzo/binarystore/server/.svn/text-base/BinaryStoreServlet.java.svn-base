/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     
 *     Cambridge Semantics Incorporated - Initial Implementation
 *******************************************************************************/
package org.openanzo.binarystore.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.eclipse.jetty.http.HttpContent;
import org.eclipse.jetty.http.HttpHeaders;
import org.json.JSONException;
import org.json.JSONWriter;
import org.openanzo.binarystore.BinaryStoreDictionary;
import org.openanzo.client.AnzoClient;
import org.openanzo.client.ClientGraph;
import org.openanzo.client.IStatementChannel;
import org.openanzo.client.pool.AnzoClientPool;
import org.openanzo.client.pool.RestrictedAnzoClient;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IAnzoGraph;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.IStatementListener;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Constants.GRAPHS;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.rdf.utils.SerializationUtils;
import org.openanzo.rdf.utils.StatementUtils;
import org.openanzo.rdf.vocabulary.DC;
import org.openanzo.rdf.vocabulary.RDF;
import org.openanzo.services.BinaryStoreConstants;
import org.openanzo.services.ITracker;
import org.openanzo.servlet.ResourceServerServlet;
import org.openanzo.servlet.ServletDictionary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * Binary Store Servlet
 * 
 * @author Simon Martin ( <a href="mailto:simon@cambridgesemantics.com">simon@cambridgesemantics.com </a>)
 * 
 */

public class BinaryStoreServlet extends ResourceServerServlet implements BinaryStoreConstants {

    private static final long    serialVersionUID        = 1L;

    private static final Logger  log                     = LoggerFactory.getLogger(BinaryStoreServlet.class);

    private String               serverNodeRootPath      = null;

    private String               serverRootPath          = null;

    private String               servletPath             = null;

    private String               serverNode              = null;

    private static Integer       directoryIncrementer    = 0;

    private static Boolean       directoryIncrementerSet = false;

    private static Calendar      currentCal              = null;

    private DiskFileItemFactory  factory                 = null;

    private static final int     MAX_MEMORY_SIZE         = 1048576;

    private long                 progressUpdateFrequency = 0;

    private LockFileUpdater      lockFileUpdater         = null;

    private String               nodelockid              = null;

    private File                 varDirFile              = null;

    private String               docRoot                 = null;

    private AnzoClientPool       clientPool              = null;

    private RestrictedAnzoClient anzoClient              = null;

    BinaryStoreServlet(AnzoClientPool clientPool) {
        this.clientPool = clientPool;
    }

    @Override
    public String getServletInfo() {
        return "Binary Store Servlet";
    }

    void initialize(Dictionary<?, ?> configProperties) throws AnzoException {
        this.serverNode = BinaryStoreDictionary.getServerNode(configProperties);
        this.serverRootPath = BinaryStoreDictionary.getFileSystemRoot(configProperties);
        this.docRoot = ServletDictionary.getDocRoot(configProperties);
        if (docRoot.startsWith("./")) {
            String root = System.getProperty("ANZO_HOME");
            docRoot = root + docRoot.substring((root.endsWith("/") ? 2 : 1));
        }
        //  this.loginPageURL=URIUtil.addPaths(context, this.loginPageURL);
        //   this.errorPageURL=URIUtil.addPaths(context, this.errorPageURL);

        this.progressUpdateFrequency = BinaryStoreDictionary.getProgressUpdateFrequency(configProperties, Long.valueOf(0));

        File f = new File(serverRootPath);
        File serverNodeFile = new File(f, serverNode);
        if (!serverNodeFile.isDirectory()) {
            serverNodeFile.mkdirs();
        }
        serverNodeRootPath = serverNodeFile.getAbsolutePath();

        varDirFile = new File(f, BINARYSTORE_VAR_DIRECTORY);
        File varNodeDirFile = new File(varDirFile, serverNode);

        //remove any old uuid for this process.
        deleteDirectory(varNodeDirFile);
        varNodeDirFile.mkdirs();
        String lockid = UUID.randomUUID().toString();
        nodelockid = LOCKFILE_PREFIX + serverNode + LOCKFILE_DELIMETER + lockid;

        //create update thread to update process id in node var directory.
        try {
            lockFileUpdater = new LockFileUpdater(new File(varNodeDirFile, lockid).getAbsolutePath());
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_ERROR, e);
        }
        lockFileUpdater.start();
        try {
            serverNodeRootPath = serverNodeFile.getCanonicalPath();
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_ERROR, e);
        }
        currentCal = Calendar.getInstance();
        factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MAX_MEMORY_SIZE);
        setDirectoryIncrementer();

        Thread initThread = new Thread() {
            @Override
            public void run() {
                try {
                    anzoClient = clientPool.getAnzoClient(true, "BinaryStoreServlet");
                    anzoClient.getRealtimeUpdates().addTracker(null, RDF.TYPE, BINARYSTORE_ITEM_URI, null, new IStatementListener<ITracker>() {

                        public void statementsRemoved(ITracker source, Statement... stmts) {
                            for (Statement s : stmts) {
                                deleteFile(s.getNamedGraphUri(), -1);
                            }
                        }

                        public void statementsAdded(ITracker source, Statement... stmts) {
                        }
                    });
                } catch (AnzoException ae) {
                    log.error(LogUtils.SERVER_INTERNAL_MARKER, Messages.formatString(ExceptionConstants.COMBUS.JMS_REGISTER_SELECTOR_ERROR, " for Binary Store Servlet"), ae);
                }
            }
        };
        initThread.start();

    }

    void stop(boolean bundleStopping) throws AnzoException {
        lockFileUpdater.shutdown();
        if (bundleStopping) {
            try {
                anzoClient.getRealtimeUpdates().removeTracker(null, RDF.TYPE, BINARYSTORE_ITEM_URI, null);
            } catch (AnzoException ae) {
                if (!bundleStopping) {
                    log.error(LogUtils.SERVER_INTERNAL_MARKER, Messages.formatString(ExceptionConstants.COMBUS.JMS_UNREGISTER_SELECTOR_ERROR, " for Binary Store Servlet"), ae);
                } else {
                    log.debug(LogUtils.SERVER_INTERNAL_MARKER, Messages.formatString(ExceptionConstants.COMBUS.JMS_UNREGISTER_SELECTOR_ERROR, " for Binary Store Servlet"), ae);
                }
            }
        }
        clientPool.returnAnzoClient(anzoClient, bundleStopping);
    }

    void reset() throws AnzoException {
        synchronized (directoryIncrementer) {
            File dir = new File(serverNodeRootPath);
            deleteDirectory(dir);
            dir.mkdirs();
            directoryIncrementer = 0;
        }
    }

    private void setDirectoryIncrementer() {
        synchronized (directoryIncrementer) {
            if (!directoryIncrementerSet) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = (cal.get(Calendar.MONTH) + 1);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                String fn = serverNodeRootPath + File.separator;
                fn += year + File.separator;
                fn += month + File.separator;
                fn += day + File.separator;
                File dir = new File(fn);
                int inc = -1;
                if (dir.isDirectory()) {
                    File[] files = dir.listFiles();
                    for (File f : files) {
                        try {
                            int i = Integer.parseInt(f.getName());
                            if (i > inc)
                                inc = i;
                        } catch (NumberFormatException e) {
                        }
                    }
                }
                synchronized (directoryIncrementerSet) {
                    if (inc != -1)
                        directoryIncrementer = inc;
                    directoryIncrementerSet = true;
                }
            }
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (req.getUserPrincipal() == null) {
                resp.setHeader(AUTH_HEADER, String.valueOf(HttpServletResponse.SC_UNAUTHORIZED));
                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            if (servletPath == null)
                servletPath = req.getScheme() + "://" + req.getHeader("host") + req.getContextPath() + req.getServletPath();

            String pathInfo = req.getPathInfo();
            if (pathInfo.length() > 0 && pathInfo.startsWith("/"))
                pathInfo = pathInfo.substring(1);

            if (pathInfo.equals(NOOP)) {
                // Handle the NO-OP operation which is used to check proper authentication by clients before uploading a big file.
                // The 100-Continue HTTP dance unfortunately doesn't work too well due to poor support by clients and servers. So
                // this NOOP operation is an alternative.
                sendNOOPResponse(req, resp);
                return;
            }

            //a pool of anzoClients
            RestrictedAnzoClient ac = null;
            String user = null;
            try {
                try {
                    ac = clientPool.getAnzoClient(true, "BinaryStoreOperation");
                    user = req.getUserPrincipal().getName();
                    RestrictedAnzoClient rac = ac;
                    rac.setServiceUser(user);
                    String runAsUser = req.getHeader(AUTHRUNAS_HEADER);
                    if (runAsUser != null && runAsUser.length() > 0) {
                        if (ac.getServicePrincipal().isSysadmin()) {
                            rac.setServiceUser(runAsUser);
                        }
                    }
                } catch (AnzoException ae) {
                    MDC.put(LogUtils.REMOTE_ADDRESS, req.getRemoteAddr());
                    log.error(LogUtils.BINARY_MARKER, Messages.formatString(ExceptionConstants.BINARYSTORE.BINARYSTORE_ERROR_PROCESSING_REQUEST), ae);
                    MDC.clear();
                    resp.setContentType(RDFFormat.JSON.getDefaultMIMEType());
                    resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    try {
                        SerializationUtils.writeExceptionJSON(ae, resp.getWriter());
                    } catch (JSONException jsone) {
                        log.debug(LogUtils.BINARY_MARKER, Messages.formatString(ExceptionConstants.IO.ERROR_SERIALIZING_JSON), jsone);
                    }
                    return;
                }
                if (pathInfo.equals(CREATE) || pathInfo.equals(UPDATE)) {
                    try {
                        createUpdate(ac, req, resp, pathInfo.equals(UPDATE));
                    } catch (AnzoException e) {
                        MDC.put(LogUtils.REMOTE_ADDRESS, req.getRemoteAddr());
                        MDC.put(LogUtils.USER, user);
                        log.info(LogUtils.BINARY_MARKER, Messages.formatString(ExceptionConstants.BINARYSTORE.BINARYSTORE_ERROR_PROCESSING_REQUEST), e);
                        sendJSONError(req, resp, e);
                        MDC.clear();
                        return;
                    }
                } else if (pathInfo.equals(READ)) {
                    String uri = req.getParameter(GRAPH);
                    if (uri == null) {
                        resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                        return;
                    }
                    RequestDispatcher dispatcher = req.getRequestDispatcher(uri);
                    if (dispatcher != null) {
                        dispatcher.forward(req, resp);
                        return;
                    }
                } else if (pathInfo.equals(DELETE)) {
                    try {
                        delete(ac, req, resp);
                    } catch (AnzoException e) {
                        MDC.put(LogUtils.REMOTE_ADDRESS, req.getRemoteAddr());
                        MDC.put(LogUtils.USER, user);
                        log.info(LogUtils.BINARY_MARKER, Messages.formatString(ExceptionConstants.BINARYSTORE.BINARYSTORE_ERROR_PROCESSING_REQUEST), e);
                        sendJSONError(req, resp, e);
                        MDC.clear();
                        return;
                    }
                } else {
                    String uri = req.getRequestURL().toString();
                    int rc = HttpServletResponse.SC_NOT_FOUND;
                    if (uri != null) {
                        try {
                            rc = read(ac, uri, req, resp);
                        } catch (AnzoException e) {
                            MDC.put(LogUtils.REMOTE_ADDRESS, req.getRemoteAddr());
                            MDC.put(LogUtils.USER, user);
                            log.info(LogUtils.BINARY_MARKER, Messages.formatString(ExceptionConstants.BINARYSTORE.BINARYSTORE_ERROR_PROCESSING_REQUEST), e);
                            sendJSONError(req, resp, e);
                            MDC.clear();
                            return;
                        }
                    }
                    if (rc != HttpServletResponse.SC_OK)
                        resp.sendError(rc);
                }
            } finally {
                if (ac != null) {
                    clientPool.returnAnzoClient(ac, true);
                }
            }
        } catch (JSONException ae) {
            MDC.put(LogUtils.REMOTE_ADDRESS, req.getRemoteAddr());
            log.error(LogUtils.BINARY_MARKER, Messages.formatString(ExceptionConstants.BINARYSTORE.BINARYSTORE_ERROR_PROCESSING_REQUEST), ae);
            MDC.clear();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write(ae.getMessage());
        }
    }

    @SuppressWarnings( { "unchecked", "null" })
    private void createUpdate(AnzoClient ac, HttpServletRequest req, HttpServletResponse resp, boolean update) throws ServletException, AnzoException, IOException, JSONException {
        //check permissions before uploading the file.
        URI updateURI = null;
        if (update) {
            String graphURI = req.getParameter(GRAPH);
            if (graphURI == null) {
                throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_NO_GRAPHURI_SPECIFIED);
            }
            updateURI = Constants.valueFactory.createURI(graphURI);
            if (!ac.namedGraphExists(updateURI)) {
                throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_UPDATE_FILEDOESNOTEXIST, updateURI.toString());
            } else if (!ac.canAddToNamedGraph(updateURI) || (!ac.canRemoveFromNamedGraph(updateURI))) {
                throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_UPDATE_PERMISSION_DENIED, updateURI.toString());
            }
        } else {
            if (!ac.canAddToNamedGraph(GRAPHS.GRAPHS_DATASET))
                throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_UPDATE_PERMISSION_DENIED, GRAPHS.GRAPHS_DATASET.toString());
        }
        String feedbackId = req.getParameter(FEEDBACK_ID);
        if (!ServletFileUpload.isMultipartContent(req))
            throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_MULTIPART_FORM_REQUIRED);

        IStatementChannel scg = null;
        URI feedbackidURIg = null;
        ServletFileUpload upload = new ServletFileUpload(factory);
        if (feedbackId != null) {
            //Create a progress listener
            final URI feedbackURI = Constants.valueFactory.createURI(createFeedbackURI(ac));
            final URI feedbackidURI = Constants.valueFactory.createURI(feedbackId);
            try {
                final IStatementChannel sc = ac.getStatementChannel(feedbackURI, AnzoClient.NON_REVISIONED_NAMED_GRAPH);
                scg = sc;
                feedbackidURIg = feedbackidURI;
                ac.updateRepository();

                ProgressListener progressListener = new ProgressListener() {
                    Date prevTime = null;

                    public void update(long pBytesRead, long pContentLength, int pItems) {
                        Date nowTime = new Date();
                        if ((pContentLength != pBytesRead) && (prevTime != null && (nowTime.getTime() < (prevTime.getTime() + progressUpdateFrequency)))) {
                            return;
                        }

                        prevTime = nowTime;
                        Map<String, Object> messageProperties = new HashMap<String, Object>();
                        Collection<Statement> statements = new HashSet<Statement>();
                        statements.add(Constants.valueFactory.createStatement(feedbackidURI, BINARYSTORE_ITEM_PROGRESS_JOB_URI, BINARYSTORE_ITEM_UPLOAD_JOB_URI, feedbackidURI));
                        statements.add(Constants.valueFactory.createStatement(feedbackidURI, BINARYSTORE_ITEM_PROGRESS_JOB_COMPLETE_URI, Constants.valueFactory.createLiteral(pContentLength), feedbackidURI));
                        statements.add(Constants.valueFactory.createStatement(feedbackidURI, BINARYSTORE_ITEM_PROGRESS_JOB_COMPLETED_URI, Constants.valueFactory.createLiteral(pBytesRead), feedbackidURI));
                        try {
                            sc.sendMessage(messageProperties, statements);
                        } catch (AnzoException e) {
                            log.error(LogUtils.BINARY_MARKER, Messages.formatString(ExceptionConstants.BINARYSTORE.BINARYSTORE_ERROR_SENDING_PROGRESS), e);
                        }
                    }
                };
                upload.setProgressListener(progressListener);
            } catch (AnzoException e) {
                log.error(LogUtils.BINARY_MARKER, Messages.formatString(ExceptionConstants.BINARYSTORE.BINARYSTORE_ERROR_FINDING_STATEMENT_CHANNEL), e);
            }
        }
        long revision = -1;
        BinaryStoreFile bsf = null;
        ClientGraph graph = null;
        File target = null;
        File lockFile = null;

        try {
            if (update) {
                graph = ac.getServerGraph(updateURI);
                revision = graph.getRevision();

                if (!isRevisioned(graph))
                    revision = -1;

                //increase to the new revision; 
                if (revision != -1)
                    ++revision;
                bsf = getFileFromURI(updateURI, revision);
                target = new File(bsf.getFilename());

                lockFile = getLock(target);
                if (lockFile == null) {
                    graph.close();
                    throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_FILE_LOCKED, target.getAbsolutePath());
                }
            }

            FileItem file = null;
            try {
                List<FileItem> items = upload.parseRequest(req);
                for (FileItem item : items) {
                    if (!item.getFieldName().equals(FILENAME))
                        continue;
                    file = item;
                    break;
                }
            } catch (FileUploadException e) {
                throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_FILE_UPLOAD_ERROR, e);
            } catch (Exception e) {
                throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_FILE_UPLOAD_ERROR, e);
            }
            if (file == null || StringUtils.isEmpty(file.getName())) {
                throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_NO_FILE_SENT);
            }

            if (scg != null) {
                Map<String, Object> messageProperties = new HashMap<String, Object>();
                Collection<Statement> statements = new HashSet<Statement>();
                statements.add(Constants.valueFactory.createStatement(feedbackidURIg, BINARYSTORE_ITEM_PROGRESS_JOB_URI, BINARYSTORE_ITEM_CHECKSUM_JOB_URI, feedbackidURIg));
                statements.add(Constants.valueFactory.createStatement(feedbackidURIg, BINARYSTORE_ITEM_PROGRESS_JOB_COMPLETE_URI, Constants.valueFactory.createLiteral(1), feedbackidURIg));
                statements.add(Constants.valueFactory.createStatement(feedbackidURIg, BINARYSTORE_ITEM_PROGRESS_JOB_COMPLETED_URI, Constants.valueFactory.createLiteral(0), feedbackidURIg));
                scg.sendMessage(messageProperties, statements);
            }

            String sha1sum = null;
            try {
                sha1sum = createChecksum(file.getInputStream());
            } catch (IOException ioe) {
                throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_ERROR_CREATING_SHA1, file.getName());
            }
            if (scg != null) {
                Map<String, Object> messageProperties = new HashMap<String, Object>();
                Collection<Statement> statements = new HashSet<Statement>();
                statements.add(Constants.valueFactory.createStatement(feedbackidURIg, BINARYSTORE_ITEM_PROGRESS_JOB_URI, BINARYSTORE_ITEM_CHECKSUM_JOB_URI, feedbackidURIg));
                statements.add(Constants.valueFactory.createStatement(feedbackidURIg, BINARYSTORE_ITEM_PROGRESS_JOB_COMPLETE_URI, Constants.valueFactory.createLiteral(1), feedbackidURIg));
                statements.add(Constants.valueFactory.createStatement(feedbackidURIg, BINARYSTORE_ITEM_PROGRESS_JOB_COMPLETED_URI, Constants.valueFactory.createLiteral(1), feedbackidURIg));
                scg.sendMessage(messageProperties, statements);
            }
            String filename = new File(file.getName()).getName();
            String contentType = file.getContentType();
            long sizeInBytes = file.getSize();

            if (update) {
                Collection<Statement> statements = graph.find(updateURI, BINARYSTORE_ITEM_SHA_1_URI, null);
                if (statements.size() > 0) {
                    Statement s = statements.iterator().next();
                    String sum = ((Literal) s.getObject()).getLabel();
                    if (sum.equals(sha1sum)) {
                        // no need to make a new revision as file is identical to currently stored file.
                        if (revision != -1)
                            --revision;
                        bsf = getFileFromURI(updateURI, revision);
                        sendSuccessMsg(req, resp, bsf.getURI(), revision);
                        return;
                    }
                }
            } else {
                revision = (req.getParameter(REVISIONED).equals("true")) ? 0 : -1;
                bsf = generateFilename(filename, revision);
                target = new File(bsf.getFilename());

                //create the parent Directories
                File parentDir = target.getParentFile();
                if (parentDir != null)
                    parentDir.mkdirs();
            }
            try {
                //its a new file if it is a create operation or the binary file is revisioned.
                if ((!update || (update && revision != -1)) && target.createNewFile() == false) {
                    throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_FILE_ALREADY_EXISTS, target.getAbsolutePath());
                }
            } catch (IOException ioe) {
                throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_ERROR_CREATING_FILE, target.getAbsolutePath());
            }
            Resource fileURI = Constants.valueFactory.createResource(bsf.getURI().toString());
            ac.begin();
            if (!update) {
                if (revision == -1) {
                    graph = ac.getServerGraph(bsf.getURI(), AnzoClient.NON_REVISIONED_NAMED_GRAPH);
                } else {
                    graph = ac.getServerGraph(bsf.getURI(), AnzoClient.REVISIONED_NAMED_GRAPH);
                }
                graph.add(fileURI, RDF.TYPE, BINARYSTORE_ITEM_URI);
            } else {
                Collection<Statement> statements = graph.getStatements();
                for (Statement s : statements) {
                    if (s.getObject() != BINARYSTORE_ITEM_URI) {
                        graph.remove(s);
                    }
                }
            }
            //TODO: at this stage call out to any plugins which might want to add meta data to the graph.
            graph.add(fileURI, BINARYSTORE_ITEM_SIZE_URI, Constants.valueFactory.createLiteral(sizeInBytes));
            graph.add(fileURI, CONTENT_TYPE_URI, Constants.valueFactory.createLiteral(contentType));
            graph.add(fileURI, DC.TITLE, Constants.valueFactory.createLiteral(filename));
            graph.add(fileURI, BINARYSTORE_ITEM_SHA_1_URI, Constants.valueFactory.createLiteral(sha1sum));
            // copy the file to the correct place on the server.
            try {
                copy(file.getInputStream(), new FileOutputStream(target), scg);
            } catch (IOException ioe) {
                throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_ERROR_COPYING_FILE, file.getName(), target.getAbsolutePath());
            }
            ac.commit();
            ac.updateRepository();

        } finally {
            if (graph != null)
                graph.close();
            if (lockFile != null)
                lockFile.delete();
        }
        if (scg != null) {
            scg.close();
            try {
                //sleep so that the feedback events have enough time to send the final bytes complete event.
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
        sendSuccessMsg(req, resp, bsf.getURI(), revision);

    }

    private String createFeedbackURI(AnzoClient ac) {
        String user = ac.getServiceUser();
        return BINARYSTORE_ITEM_PROGRESS_CHANNEL_PREFIX + user;
    }

    private static boolean isRevisioned(ClientGraph graph) {
        INamedGraph metadata = graph.getMetadataGraph();
        if (metadata.contains(graph.getNamedGraphUri(), NamedGraph.revisionedProperty, Constants.valueFactory.createLiteral(true))) {
            return true;
        }
        return false;

    }

    private int read(AnzoClient ac, String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, AnzoException {

        IAnzoGraph graph = null;
        try {
            URI uri = Constants.valueFactory.createURI(url);

            if (!ac.namedGraphExists(uri)) {
                return HttpServletResponse.SC_NOT_FOUND;
            }
            if (!ac.canReadNamedGraph(uri)) {
                response.setHeader(AUTH_HEADER, String.valueOf(HttpServletResponse.SC_UNAUTHORIZED));
                return HttpServletResponse.SC_UNAUTHORIZED;
            }

            String requested_revision_str = request.getParameter(URL_QUERY_REVISION);
            long requested_revision = -1;
            if (requested_revision_str != null) {
                requested_revision = Long.parseLong(requested_revision_str);
            }

            long revision = -1;
            if (requested_revision == -1) {
                ClientGraph g = ac.getServerGraph(uri);
                revision = g.getRevision();
                if (!isRevisioned(g))
                    revision = -1;
                graph = g;
            } else {
                IAnzoGraph g = ac.getNamedGraphRevision(uri, requested_revision);
                if (g != null && g.size() > 0) // An empty graph (and with empty metadatagraph) is returned for revisions that don't exist
                    revision = requested_revision;
                else
                    throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_FILE_REVISION_DOES_NOT_EXIST, Long.toString(requested_revision), uri.toString());
                graph = g;
            }

            Boolean showMetaData = false;

            if (request.getParameter(URL_QUERY_ASPECT) != null && request.getParameter(URL_QUERY_ASPECT).equals(URL_ASPECT_METADATA)) {
                showMetaData = true;
            }
            //
            if (showMetaData) {
                String formatString = request.getParameter(URL_QUERY_FORMAT);
                formatString = (formatString != null) ? formatString : RDF_XMLFORMAT;
                try {
                    RDFFormat format = RDFFormat.forFileName("." + formatString);
                    if (format == null) {
                        throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_UNRECOGNIZEDRDFFORMAT, formatString);
                    }
                    StringWriter sw = new StringWriter();
                    ReadWriteUtils.writeGraph(graph, sw);
                    response.setContentType(format.getDefaultMIMEType());
                    response.getOutputStream().print(sw.getBuffer().toString());
                    response.getOutputStream().flush();
                    return HttpServletResponse.SC_OK;
                } catch (Exception e) {
                    throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_ERROR, e);
                }
            }

            BinaryStoreFile bsf = getFileFromURI(uri, revision);
            String filename = bsf.getFilename();

            Collection<Statement> cos = graph.find(uri, CONTENT_TYPE_URI, null);
            if (cos.size() != 1) {
                throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_NO_CONTENTTYPE_FOUND, uri.toString());
            }

            Statement s = cos.iterator().next();
            String contentType = (String) StatementUtils.getNativeValue((Literal) s.getObject());

            //TODO: at this stage run plugins to do transformations on the file.

            return serveStaticResource(request, response, filename, contentType);

        } finally {
            if (graph != null)
                graph.close();
        }
    }

    private void delete(AnzoClient ac, HttpServletRequest req, HttpServletResponse resp) throws AnzoException, ServletException {
        String graphURI = req.getParameter(GRAPH);
        if (graphURI == null) {
            throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_NO_GRAPHURI_SPECIFIED);
        }
        URI uri = Constants.valueFactory.createURI(graphURI);
        if (!ac.namedGraphExists(uri))
            throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_NO_GRAPHURI_SPECIFIED);
        if (!ac.canRemoveFromNamedGraph(uri))
            throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_UPDATE_PERMISSION_DENIED, uri.toString());

        ClientGraph graph = ac.getServerGraph(uri);

        if (!isRevisioned(graph)) {
            // if it is a non revisioned file then delete the file else just delete the graph
            if (!deleteFile(uri, -1))
                throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_FILE_LOCKED, uri.toString());
        }
        graph.getMetadataGraph().remove(uri, RDF.TYPE, NamedGraph.TYPE);
        ac.updateRepository();
    }

    private boolean deleteFile(URI uri, long revision) {
        BinaryStoreFile bsf = getFileFromURI(uri, revision);
        File target = new File(bsf.getFilename());
        File lockFile = getLock(target);
        if (lockFile == null)
            return false;

        if (target.exists()) {
            boolean success = target.delete();
            lockFile.delete();
            File parent = target;
            while (success && !parent.getParentFile().getAbsolutePath().equals(serverNodeRootPath) && parent.getParentFile().listFiles().length == 0) {
                parent = parent.getParentFile();
                success = parent.delete();
            }
        }
        return true;
    }

    private BinaryStoreFile generateFilename(String filename, long revision) {
        filename = removeIllegalURIChars(filename);
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = (cal.get(Calendar.MONTH) + 1);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int dirInt = 0;
        synchronized (directoryIncrementer) {
            if (day != currentCal.get(Calendar.DAY_OF_MONTH) && month != (currentCal.get(Calendar.MONTH) + 1) && year != currentCal.get(Calendar.YEAR)) {
                directoryIncrementer = 0;
            }
            currentCal = cal;
            dirInt = ++directoryIncrementer;
        }
        String fn = serverNodeRootPath + File.separator;
        fn += year + File.separator;
        fn += month + File.separator;
        fn += day + File.separator;
        fn += dirInt + File.separator;
        fn += filename;
        fn += (revision == -1) ? "" : "-0";

        String url = servletPath + "/";
        url += serverNode + "/";
        url += year + "/";
        url += month + "/";
        url += day + "/";
        url += dirInt + "/";
        url += filename;
        return new BinaryStoreFile(fn, url);
        //eg  "/binarystore/" + servernode + "/" + date_year + "/" + date_month + "/" + date_day + "/" + incremented_integer + "/" + filename
    }

    private BinaryStoreFile getFileFromURI(URI u, long revision) {
        String uri = u.toString();
        if (!uri.startsWith(servletPath))
            return null;
        String file = serverRootPath + uri.substring(servletPath.length());
        file += (revision != -1) ? "-" + revision : "";
        File f = new File(file);
        return new BinaryStoreFile(f.getAbsolutePath(), uri);
    }

    @SuppressWarnings("unchecked")
    private int serveStaticResource(HttpServletRequest request, HttpServletResponse response, String filename, String contentType) throws AnzoException, ServletException {
        // Find the resource and content
        HttpContent content = null;
        org.eclipse.jetty.util.resource.Resource resource = null;
        try {
            resource = org.eclipse.jetty.util.resource.Resource.newResource("file://" + filename);
            Enumeration reqRanges = null;

            // Is this a range request?
            reqRanges = request.getHeaders(HttpHeaders.RANGE);
            if (reqRanges != null && !reqRanges.hasMoreElements())
                reqRanges = null;

            // Handle resource
            if (resource == null || !resource.exists())
                return HttpServletResponse.SC_NOT_FOUND;

            if (!resource.isDirectory()) {
                // ensure we have content
                content = new UnCachedContent(resource, contentType);

                if (passConditionalHeaders(request, response, resource, content)) {
                    sendData(request, response, false, resource, content, reqRanges);
                }
            } else {
                return HttpServletResponse.SC_NOT_FOUND;
            }
        } catch (IllegalArgumentException e) {
            throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_SENDING_DATA_FAILED, e, filename);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.BINARYSTORE.BINARYSTORE_SENDING_DATA_FAILED, e, filename);
        } finally {
            if (content != null) {
                content.release();
            }
            if (resource != null) {
                resource.release();
            }
        }
        return HttpServletResponse.SC_OK;

    }

    Properties getInitProperties() {
        Properties properties = new Properties();
        @SuppressWarnings("unchecked")
        // javax.servlet.GenericServlet returns unchecked value
        Enumeration e = getInitParameterNames();
        String paramName;
        String paramValue;
        while (e.hasMoreElements()) {
            paramName = (String) e.nextElement();
            paramValue = getInitParameter(paramName);
            properties.put(paramName, paramValue);
        }
        return properties;
    }

    static private void sendNOOPResponse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        boolean addHTML = false;
        if ("application/json".equals(req.getHeader("Accept"))) {
            resp.setContentType("application/json");
        } else {
            addHTML = true;
            resp.setContentType("text/html");
        }
        resp.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = resp.getWriter();
        String response = "{ \"error\": false }";
        out.print(addHTML ? envelopeHTMLMessage(response) : response);
        out.flush();
        out.close();
    }

    static private void sendJSONError(HttpServletRequest req, HttpServletResponse resp, AnzoException exception) throws IOException, JSONException {
        boolean addHTML = false;
        if ("application/json".equals(req.getHeader("Accept"))) {
            resp.setContentType("application/json");
        } else {
            addHTML = true;
            resp.setContentType("text/html");
        }
        resp.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = resp.getWriter();
        String jsonError = createJSONError(exception);
        out.print(addHTML ? envelopeHTMLMessage(jsonError) : jsonError);
        out.flush();
        out.close();
    }

    static private String createJSONError(AnzoException exception) throws JSONException {
        StringWriter sw = new StringWriter();
        SerializationUtils.writeExceptionJSON(exception, sw);
        return sw.toString();
    }

    static private void sendSuccessMsg(HttpServletRequest req, HttpServletResponse resp, URI uri, long revision) throws IOException, JSONException {
        boolean addHTML = false;
        if ("application/json".equals(req.getHeader("Accept"))) {
            resp.setContentType("application/json");
        } else {
            addHTML = true;
            resp.setContentType("text/html");
        }
        resp.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = resp.getWriter();
        out.print(addHTML ? envelopeHTMLMessage(createReturnMessage(uri, revision)) : createReturnMessage(uri, revision));
        out.flush();
        out.close();

    }

    static private String createReturnMessage(URI uri, long revision) throws JSONException {
        StringWriter sw = new StringWriter();
        JSONWriter jj = new JSONWriter(sw);
        jj.object();
        jj.key("error");
        jj.value(false);
        jj.key("uri");
        jj.value(uri.toString());
        jj.key("revision");
        jj.value(revision);
        jj.endObject();
        return sw.toString();
    }

    static private String envelopeHTMLMessage(String str) {
        return ("<html> <head></head><body> <textarea style='width: 100%; height: 100%;'>" + str + "</textarea></body></html>");
    }

    static void copy(InputStream in, OutputStream out, IStatementChannel scg) throws IOException {

        // Do not allow other threads to read from the input
        // or write to the output while copying is taking place
        synchronized (in) {
            synchronized (out) {
                byte[] buffer = new byte[256];
                while (true) {
                    int bytesRead = in.read(buffer);
                    if (bytesRead == -1)
                        break;
                    out.write(buffer, 0, bytesRead);
                }
            }
        }
    }

    static String removeIllegalURIChars(String s) {
        char[] chars = s.toCharArray();
        StringBuilder b = new StringBuilder();
        for (char c : chars) {
            if (c == '\'' || c == '"' || c == ' ')
                b.append("_");
            else
                b.append(c);
        }

        return b.toString();
    }

    private File getLock(File target) {
        File parent = target.getParentFile();
        File lockfile = new File(parent, nodelockid);
        boolean exists = true;
        try {
            exists = lockfile.createNewFile();
        } catch (IOException e) {
            return null;
        }
        if (!exists) {
            return null;
        }
        File[] files = parent.listFiles();
        for (File f : files) {
            if (!f.equals(lockfile)) {
                if (f.getName().startsWith(LOCKFILE_PREFIX)) {
                    String lock = f.getName().substring(LOCKFILE_PREFIX.length());
                    String[] nodeid = lock.split(LOCKFILE_DELIMETER);
                    if (nodeid.length != 2)
                        continue;
                    boolean validLock = isLockValid(nodeid[0], nodeid[1]);
                    if (!validLock) {
                        //its an invalid lockfile - presumably created by a crashed or shutdown server so lets clean it up.
                        f.delete();
                    } else {
                        lockfile.delete();
                        return null;
                    }
                }
            }
        }

        return lockfile;
    }

    private boolean isLockValid(String node, String id) {
        File nodeDir = new File(varDirFile, node);
        if (nodeDir.exists()) {
            File idFile = new File(nodeDir, id);
            if (idFile.exists()) {
                Date d = new Date();
                if (d.getTime() < idFile.lastModified() + BINARYSTORE_HEARTBEAT_CHECKTIME) {
                    return true;
                } else {
                    //clean up the file as it is an old one.
                    idFile.delete();
                }
            }
        }
        return false;
    }

    static String createChecksum(InputStream fis) throws IOException {

        byte[] buffer = new byte[1024];
        MessageDigest complete = null;
        try {
            complete = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            log.warn(LogUtils.SERVER_INTERNAL_MARKER, Messages.formatString(ExceptionConstants.BINARYSTORE.BINARYSTORE_NO_SHA1));
            return null;
        }
        int numRead;
        do {
            numRead = fis.read(buffer);
            if (numRead > 0) {
                complete.update(buffer, 0, numRead);
            }
        } while (numRead != -1);
        fis.close();
        byte[] digest = complete.digest();

        String hash = "";

        for (int i = 0; i < digest.length; i++) {
            String hex = Integer.toHexString(digest[i]);
            if (hex.length() == 1)
                hex = "0" + hex;
            hex = hex.substring(hex.length() - 2);
            hash += hex;
        }

        return hash;

    }

    private void deleteDirectory(File file) {
        if (file.isDirectory()) {
            for (File subFile : file.listFiles()) {
                deleteDirectory(subFile);
            }
        }
        file.delete();
    }

    class BinaryStoreFile {
        private String _filename = null;

        private URI    _uri      = null;

        public BinaryStoreFile(String filename, String url) {
            _filename = filename;
            _uri = Constants.valueFactory.createURI(url);
        }

        public String getFilename() {
            return _filename;
        }

        public URI getURI() {
            return _uri;
        }

    }
}
