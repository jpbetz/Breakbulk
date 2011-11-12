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
package org.openanzo.client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.cookie.CookieSpec;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.ByteArrayPartSource;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.exceptions.Messages;
import org.openanzo.ontologies.openanzo.NamedGraph;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.INamedGraph;
import org.openanzo.rdf.IStatementListener;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.utils.StatementUtils;
import org.openanzo.rdf.utils.UriGenerator;
import org.openanzo.rdf.vocabulary.RDF;
import org.openanzo.services.BinaryStoreConstants;
import org.openanzo.services.EncryptedTokenAuthenticatorConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Binary Store Client
 * 
 * @author Simon Martin ( <a href="mailto:simon@cambridgesemantics.com">simon@cambridgesemantics.com </a>)
 * 
 */

public class BinaryStoreClient implements BinaryStoreConstants {

    private static final Logger                                       log          = LoggerFactory.getLogger(BinaryStoreClient.class);

    private final HashMap<URI, BinaryStoreItem>                       fileList     = new HashMap<URI, BinaryStoreItem>();

    private final AnzoClient                                          anzoClient;

    private final String                                              url;

    private final String                                              authentication_url;

    private final HttpClient                                          httpclient   = new HttpClient(new MultiThreadedHttpConnectionManager());

    private final HashMap<Resource, IBinaryStoreItemProgressListener> feedbackURIs = new HashMap<Resource, IBinaryStoreItemProgressListener>();

    /**
     * Create a new BinaryStoreClient
     * 
     * @param url
     *            URL for binary store server
     * @param anzoClient
     *            AnzoClient for this connection to the binary store
     * @throws AnzoException
     */
    public BinaryStoreClient(String url, AnzoClient anzoClient) throws AnzoException {
        this(url, anzoClient, url + EncryptedTokenAuthenticatorConstants.LOGIN_URI_SUFFIX);
    }

    /**
     * Create a new BinaryStoreClient
     * 
     * @param url
     *            URL for binary store server
     * @param anzoClient
     *            AnzoClient for this connection to the binary store
     * @param authentication_url
     *            Non-standard URL for the authentication endpoint on the binary store server
     * @throws AnzoException
     */
    public BinaryStoreClient(String url, AnzoClient anzoClient, String authentication_url) throws AnzoException {
        this.url = url;
        this.anzoClient = anzoClient;
        this.authentication_url = authentication_url;
        final URI feedbackURI = Constants.valueFactory.createURI(createFeedbackURI(this.anzoClient));
        try {
            final IStatementChannel sc = anzoClient.getStatementChannel(feedbackURI, AnzoClient.NON_REVISIONED_NAMED_GRAPH);
            IStatementChannelListener statementChannelListener = new IStatementChannelListener() {
                public void statementsReceived(Map<String, Object> messagePropertes, Collection<Statement> statements) {
                    Value operation = null;
                    long jobCompleted = -1;
                    long jobComplete = -1;
                    List<Statement> additionalStatements = new ArrayList<Statement>();
                    Resource item = null;
                    for (Statement st : statements) {
                        if (st.getPredicate().equals(BINARYSTORE_ITEM_PROGRESS_JOB_COMPLETED_URI)) {
                            Object obj = StatementUtils.getNativeValue((Literal) st.getObject());
                            if (obj instanceof Number) {
                                jobComplete = ((Number) obj).longValue();
                            }
                        } else if (st.getPredicate().equals(BINARYSTORE_ITEM_PROGRESS_JOB_COMPLETE_URI)) {
                            Object obj = StatementUtils.getNativeValue((Literal) st.getObject());
                            if (obj instanceof Number) {
                                jobCompleted = ((Number) obj).longValue();
                            }
                        } else if (st.getPredicate().equals(BINARYSTORE_ITEM_PROGRESS_JOB_URI)) {
                            operation = st.getObject();
                            item = st.getSubject();
                        } else {
                            additionalStatements.add(st);
                        }

                    }
                    notifyChannelListeners(item, operation, jobCompleted, jobComplete, additionalStatements);
                }

                public void channelClosed() {
                }
            };

            anzoClient.updateRepository();
            sc.registerListener(statementChannelListener);

        } finally {

        }

    }

    private void addChannelListener(Resource item, IBinaryStoreItemProgressListener listener) {
        feedbackURIs.put(item, listener);
    }

    private void removeChannelListener(Resource item) {
        feedbackURIs.remove(item);
    }

    private void notifyChannelListeners(Resource item, Value job, long jobCompleted, long jobComplete, List<Statement> additionalStatements) {
        IBinaryStoreItemProgressListener listener = feedbackURIs.get(item);
        if (listener != null)
            listener.progress(job, jobCompleted, jobComplete, additionalStatements);

    }

    protected int executeAuthenticatedHttpClientMethod(HttpMethod method) throws HttpException, IOException, AnzoException {

        method.addRequestHeader("X-Requested-With", "XMLHttpRequest");
        String serviceUser = anzoClient.getServiceUser();
        if (serviceUser != null && serviceUser.equals(anzoClient.clientDatasource.getServiceUser()))
            method.addRequestHeader(AUTHRUNAS_HEADER, anzoClient.clientDatasource.getServiceUser());

        int rc = httpclient.executeMethod(method);
        if (rc == HttpStatus.SC_FORBIDDEN) {
            method.releaseConnection();
            authenticate();
            rc = httpclient.executeMethod(method);
        }
        return rc;

    }

    private void authenticate() throws AnzoException {
        try {
            URL aURL = new URL(authentication_url);
            httpclient.getHostConfiguration().setHost(aURL.getHost(), aURL.getPort(), aURL.getProtocol());

            PostMethod authpost = new PostMethod(aURL.getPath());
            NameValuePair formUserid = new NameValuePair(EncryptedTokenAuthenticatorConstants.USERNAME_PARAMETER_NAME, anzoClient.clientDatasource.getServiceUser());
            NameValuePair formPassword = new NameValuePair(EncryptedTokenAuthenticatorConstants.PASSWORD_PARAMETER_NAME, anzoClient.clientDatasource.getServicePassword());
            authpost.setRequestBody(new NameValuePair[] { formUserid, formPassword });
            authpost.addRequestHeader("X-Requested-With", "XMLHttpRequest");
            authpost.setDoAuthentication(false);
            httpclient.executeMethod(authpost);
            if (authpost.getStatusCode() == HttpStatus.SC_FORBIDDEN) {
                throw new AnzoException(ExceptionConstants.SERVER.BAD_USER_PASSWORD);
            }
            authpost.releaseConnection();
            CookieSpec cookiespec = CookiePolicy.getDefaultSpec();
            Cookie[] logoncookies = cookiespec.match(aURL.getHost(), aURL.getPort() == -1 ? aURL.getDefaultPort() : aURL.getPort(), "/", false, httpclient.getState().getCookies());
            boolean authenticated = false;
            for (int i = 0; i < logoncookies.length; i++) {
                if (logoncookies[i].getName().equals(EncryptedTokenAuthenticatorConstants.ANZO_TOKEN_COOKIE_NAME))
                    authenticated = true;
            }
            if (!authenticated)
                throw new AnzoException(ExceptionConstants.SERVER.BAD_USER_PASSWORD);
        } catch (IOException e) {
            throw new AnzoException(ExceptionConstants.BINARYSTORECLIENT.BINARYSTORECLIENT_ERROR, e);
        }
    }

    /**
     * Add a new Item to the binary store
     * 
     * @param revisioned
     *            true if the item and its metadata should be revisioned
     * @return the new {@link BinaryStoreItem}
     */
    public BinaryStoreItem addItem(boolean revisioned) {
        BinaryStoreItem bsi = new BinaryStoreItem(revisioned);
        return bsi;
    }

    /**
     * Get the {@link BinaryStoreItem} for the given uri
     * 
     * @param uri
     *            URI of the {@link BinaryStoreItem} to retrieve
     * @return the {@link BinaryStoreItem} for the given uri
     * @throws AnzoException
     *             Throws exception if there is no item with the given URI
     */
    public BinaryStoreItem getItem(URI uri) throws AnzoException {
        if (fileList.containsKey(uri)) {
            return fileList.get(uri);
        } else {
            if (!anzoClient.namedGraphExists(uri)) {
                throw new AnzoException(ExceptionConstants.BINARYSTORECLIENT.BINARYSTORECLIENT_INVALIDITEMURI, uri.toString());
            }
            ClientGraph graph = anzoClient.getServerGraph(uri);

            //check its a binary store item
            if (!graph.contains(uri, RDF.TYPE, BINARYSTORE_ITEM_URI)) {
                throw new AnzoException(ExceptionConstants.BINARYSTORECLIENT.BINARYSTORECLIENT_INVALIDITEMURI, uri.toString());
            }

            BinaryStoreItem bsi = new BinaryStoreItem(graph);
            fileList.put(uri, bsi);
            return bsi;
        }

    }

    /**
     * Remove the given {@link BinaryStoreItem} from the binary store
     * 
     * @param bsi
     *            {@link BinaryStoreItem} to remove
     * @throws AnzoException
     *             Throw exception if the {@link BinaryStoreItem} in question does not have a stored uri
     */
    public void removeItem(BinaryStoreItem bsi) throws AnzoException {
        URI uri = bsi.getSrc();
        if (uri == null) {
            throw new AnzoException(ExceptionConstants.BINARYSTORECLIENT.BINARYSTORECLIENT_INVALIDITEMURI, "null");
        }
        removeItem(uri);
    }

    /**
     * Remove the binary item with the given URI from the binary store
     * 
     * @param uri
     *            URI of the item to remove
     * @throws AnzoException
     *             Throw exception if this is no item with the given URI
     */
    public void removeItem(URI uri) throws AnzoException {
        if (!anzoClient.namedGraphExists(uri)) {
            throw new AnzoException(ExceptionConstants.BINARYSTORECLIENT.BINARYSTORECLIENT_INVALIDITEMURI, uri.toString());
        }
        //check its a binary store item
        ClientGraph graph = anzoClient.getServerGraph(uri);

        //check its a binary store item
        if (!graph.contains(uri, RDF.TYPE, BINARYSTORE_ITEM_URI)) {
            throw new AnzoException(ExceptionConstants.BINARYSTORECLIENT.BINARYSTORECLIENT_INVALIDITEMURI, uri.toString());
        }

        anzoClient.begin();
        graph.remove(uri, RDF.TYPE, BINARYSTORE_ITEM_URI);
        anzoClient.commit();
        anzoClient.begin();
        graph.getMetadataGraph().remove(uri, RDF.TYPE, NamedGraph.TYPE);
        anzoClient.commit();
        anzoClient.updateRepository();

        graph.close();

        fileList.remove(uri);
    }

    private String createFeedbackURI(AnzoClient ac) {
        String user = ac.getServiceUser();
        return BINARYSTORE_ITEM_PROGRESS_CHANNEL_PREFIX + user;
    }

    /**
     * Object which defines an item stored in the binary store server
     * 
     */
    public class BinaryStoreItem {

        private final boolean                                         revisioned;

        private long                                                  revision        = -1;

        private URI                                                   src             = null;

        //  private boolean                                               isValid         = false;

        private ClientGraph                                           graph           = null;

        private IStatementListener<INamedGraph>                       graphConnection = null;

        private boolean                                               updating        = false;

        private CopyOnWriteArraySet<IBinaryStoreItemProgressListener> listeners       = new CopyOnWriteArraySet<IBinaryStoreItemProgressListener>();

        protected BinaryStoreItem(boolean revisioned) {
            this.revisioned = revisioned;
        }

        protected BinaryStoreItem(ClientGraph graph) {
            boolean revisioned = false;
            long revision = 0;
            Collection<Statement> stmts = graph.getMetadataGraph().find(graph.getNamedGraphUri(), NamedGraph.revisionedProperty, null);
            if (!stmts.isEmpty()) {
                Value obj = stmts.iterator().next().getObject();
                Literal lit = (Literal) obj;
                revisioned = Boolean.parseBoolean(lit.getLabel());
            }
            if (revisioned == true) {
                stmts = graph.getMetadataGraph().find(graph.getNamedGraphUri(), NamedGraph.revisionProperty, null);
                if (!stmts.isEmpty()) {
                    Statement revStmt = stmts.iterator().next();
                    Literal rev = (Literal) revStmt.getObject();
                    try {
                        revision = Long.parseLong(rev.getLabel());
                    } catch (NumberFormatException nfe) {
                        if (log.isDebugEnabled()) {
                            log.debug(LogUtils.INTERNAL_MARKER, Messages.formatString(ExceptionConstants.CORE.NFE, rev.getLabel()), nfe);
                        }
                    }
                }
            } else
                revision = -1;

            this.revisioned = revisioned;
            this.revision = revision;
            this.src = graph.getNamedGraphUri();
            this.graph = graph;
            this.hookGraph();
        }

        /**
         * Register an {@link IBinaryStoreItemProgressListener} with this item
         * 
         * @param listener
         *            {@link IBinaryStoreItemProgressListener} to register
         */
        public void registerProgressListener(IBinaryStoreItemProgressListener listener) {
            listeners.add(listener);
        }

        /**
         * Unregister an {@link IBinaryStoreItemProgressListener} from this item
         * 
         * @param listener
         *            {@link IBinaryStoreItemProgressListener} to unregister
         * 
         */
        public void unregisterProgressListener(IBinaryStoreItemProgressListener listener) {
            listeners.remove(listener);
        }

        private void notifyListeners(Value job, long jobCompleted, long jobComplete, Collection<Statement> additionalStatements) {
            for (IBinaryStoreItemProgressListener listener : listeners) {
                try {
                    listener.progress(job, jobCompleted, jobComplete, additionalStatements);
                } catch (Throwable t) {
                    if (log.isWarnEnabled()) {
                        log.warn(LogUtils.INTERNAL_MARKER, Messages.formatString(ExceptionConstants.BINARYSTORE.BINARYSTORE_ERROR_PROCESSING_PROGRESS), t);
                    }
                }
            }
        }

        private void hookGraph() {
            graphConnection = new IStatementListener<INamedGraph>() {
                public void statementsAdded(INamedGraph source, Statement... statements) {
                }

                public void statementsRemoved(INamedGraph source, Statement... statements) {
                    graphStatementRemoved(source, statements);
                }
            };
            graph.registerListener(graphConnection);
            //this.isValid = true;
        }

        private void graphStatementRemoved(INamedGraph source, Statement... statements) {
            for (int i = 0; i < statements.length; i++) {
                if (statements[i].getObject().equals(BINARYSTORE_ITEM_URI)) {
                    if (graphConnection != null)
                        graph.unregisterListener(graphConnection);
                    //this.isValid = false;
                    this.graph.close();
                    this.graph = null;
                    if (fileList.containsKey(this.src)) {
                        fileList.remove(this.src);
                    }
                }
            }
        }

        /**
         * Get this items revision number
         * 
         * @return this items revision number
         */
        public long getRevision() {
            return this.revision;
        }

        /**
         * Get the source URI for this item
         * 
         * @return the source URI for this item
         */
        public URI getSrc() {
            return this.src;
        }

        /**
         * Return true if this item is revisioned
         * 
         * @return true if this item is revisioned
         */
        public boolean isRevisioned() {
            return this.revisioned;
        }

        /**
         * Get the ClientGraph for this item
         * 
         * @return the ClientGraph for this item
         */
        public ClientGraph getGraph() {
            return graph;
        }

        /**
         * Update the contents of this item with the given file
         * 
         * @param file
         *            file containing the contents for which ot update this item
         * @throws AnzoException
         */
        public void updateFromFile(File file) throws AnzoException {
            try {
                updateFromPart(new FilePart("file", file.getName(), file));
            } catch (IOException e) {
                throw new AnzoException(ExceptionConstants.BINARYSTORECLIENT.BINARYSTORECLIENT_ERROR, e);
            }
        }

        /**
         * Update the contents of this item with the given file
         * 
         * @param stream
         *            input stream containing data to upload to server
         * @param fileName
         *            name of the file in which to store the stream of data
         * @throws AnzoException
         */
        public void updateFromStream(InputStream stream, String fileName) throws AnzoException {
            try {
                updateFromPart(new FilePart("file", new ByteArrayPartSource(fileName, IOUtils.toByteArray(stream))));
            } catch (IOException e) {
                throw new AnzoException(ExceptionConstants.BINARYSTORECLIENT.BINARYSTORECLIENT_ERROR, e);
            }
        }

        private void updateFromPart(Part part) throws AnzoException {
            try {
                synchronized (this) {
                    if (this.updating) {
                        throw new AnzoException(ExceptionConstants.BINARYSTORECLIENT.BINARYSTORECLIENT_ALREADYUPDATING);
                    }
                    this.updating = true;
                }
                URI progressUri = null;
                if (listeners.size() > 0) {
                    progressUri = UriGenerator.generateAnonymousURI(PROGRESSURI_PREFIX);
                    addChannelListener(progressUri, new IBinaryStoreItemProgressListener() {
                        public void progress(Value job, long jobCompleted, long jobComplete, Collection<Statement> additionalStatements) {
                            notifyListeners(job, jobCompleted, jobComplete, additionalStatements);
                        }

                    });
                }
                String binStoreUrl = "";
                String binStoreQuery = "";
                if (this.src == null) {
                    //creating
                    binStoreUrl = url + "/" + CREATE;
                    binStoreQuery = REVISIONED + "=" + (revisioned ? "true" : "false") + (progressUri != null ? "&upload_uri=" + progressUri.toString() : "");
                } else {
                    //updating
                    binStoreUrl = url + "/" + UPDATE;
                    binStoreQuery = GRAPH + "=" + this.src.toString() + (progressUri != null ? "&upload_uri=" + progressUri.toString() : "");
                }

                PostMethod filePost = new PostMethod(binStoreUrl);
                filePost.addRequestHeader("Accept", "application/json");
                filePost.addRequestHeader("X-Requested-With", "XMLHttpRequest");
                filePost.getParams().setBooleanParameter(HttpMethodParams.USE_EXPECT_CONTINUE, true);
                filePost.setQueryString(binStoreQuery);
                Part[] parts = { part };
                filePost.setRequestEntity(new MultipartRequestEntity(parts, filePost.getParams()));
                httpclient.executeMethod(filePost);
                if (filePost.getStatusCode() == HttpStatus.SC_FORBIDDEN || filePost.getStatusCode() == HttpStatus.SC_UNAUTHORIZED) {
                    if (String.valueOf(HttpStatus.SC_UNAUTHORIZED).equals(filePost.getResponseHeader(AUTH_HEADER))) {
                        //permission was denied by the Binary Store.
                        throw new AnzoException(ExceptionConstants.BINARYSTORECLIENT.BINARYSTORECLIENT_ACCESSDENIED);
                    } else {
                        //re-authenticate and try again.
                        filePost.releaseConnection();
                        authenticate();
                        httpclient.executeMethod(filePost);
                    }
                }
                if (filePost.getStatusCode() != HttpStatus.SC_OK) {
                    filePost.releaseConnection();
                    throw new AnzoException(ExceptionConstants.BINARYSTORECLIENT.BINARYSTORECLIENT_HTTPERROR, String.valueOf(filePost.getStatusCode()));
                }

                String response = filePost.getResponseBodyAsString();
                filePost.releaseConnection();
                JSONObject jo = new JSONObject(response);
                if (jo.getBoolean("error")) {
                    //throw Exception received from server.
                    throw new AnzoException(jo.getLong("errorCode"));
                } else {
                    this.src = Constants.valueFactory.createURI(jo.getString("uri"));
                    this.revision = jo.getLong("revision");
                    //this.isValid = true;
                    fileList.put(this.src, this);
                    if (this.graph == null) {
                        this.graph = anzoClient.getReplicaGraph(this.src);
                        hookGraph();
                    }
                }
                if (progressUri != null) {
                    removeChannelListener(progressUri);
                }
            } catch (IOException e) {
                throw new AnzoException(ExceptionConstants.BINARYSTORECLIENT.BINARYSTORECLIENT_ERROR, e);
            } catch (JSONException e) {
                throw new AnzoException(ExceptionConstants.BINARYSTORECLIENT.BINARYSTORECLIENT_ERROR, e);
            } finally {
                synchronized (this) {
                    this.updating = false;
                }
            }
        }

        /**
         * Download the contents of this item to the given file
         * 
         * @param filename
         *            destination of downloaded file
         * @return the file object for the downloaded data
         * @throws AnzoException
         */
        public File downloadToFile(String filename) throws AnzoException {
            return downloadToFile(filename, null);
        }

        /**
         * Download the contents of this item to the given file
         * 
         * @param filename
         *            destination of downloaded file
         * @param revision
         *            revision of the item to retrieve
         * @return the file object for the downloaded data
         * @throws AnzoException
         */
        public File downloadToFile(String filename, Long revision) throws AnzoException {
            try {
                GetMethod method = new GetMethod(getSrc().toString());
                if (revision != null)
                    method.setQueryString("revision=" + revision);
                BinaryStoreClient.this.executeAuthenticatedHttpClientMethod(method);
                InputStream is = method.getResponseBodyAsStream();
                File file = new File(filename);
                Writer writer = new OutputStreamWriter(new FileOutputStream(file), Constants.byteEncoding);
                IOUtils.copy(is, writer);
                writer.flush();
                writer.close();
                return file;
            } catch (IOException ioe) {
                throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, ioe);
            }
        }

        /**
         * Download the contents of this item to an input stream
         * 
         * @return the inputstream for the given items data
         * @throws AnzoException
         */
        public InputStream downloadToStream() throws AnzoException {
            return downloadToStream(null);
        }

        /**
         * Download the contents of this item to an input stream
         * 
         * @param revision
         *            revision of the item to retrieve
         * @return the inputstream for the given items data
         * @throws AnzoException
         */
        public InputStream downloadToStream(Long revision) throws AnzoException {
            try {
                GetMethod method = new GetMethod(getSrc().toString());
                if (revision != null)
                    method.setQueryString("revision=" + revision);
                BinaryStoreClient.this.executeAuthenticatedHttpClientMethod(method);
                InputStream is = method.getResponseBodyAsStream();
                return is;
            } catch (IOException ioe) {
                throw new AnzoException(ExceptionConstants.IO.WRITE_ERROR, ioe);
            }
        }

    }

}
