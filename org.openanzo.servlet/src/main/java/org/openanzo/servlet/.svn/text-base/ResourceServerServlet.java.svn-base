/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Simon Martin ( <a href="mailto:simon@cambridgesemantics.com">jordi@cambridgesemantics.com </a>)
 * 
 * Contributors:
 *     Mort Bay Consulting Pty. Ltd. - the Jetty DefaultServlet is the basis of the Cambridge Semantics ResourceServerServlet.
 *     Cambridge Semantics Incorporated - modified for use by the OpenAnzo Binary Store Servlet.
 *     
 *  This code is based on Jetty's org.eclipse.jetty.servlet.DefaultServlet class
 *  as modified by Cambridge Semantics Incorporated 
 *  The original copyright statement from the DefaultServlet is reproduced below.
 *  The DefaultServlet authors were listed in the source as:
 *  Greg Wilkins (gregw) and Nigel Canonizado

 *  ========================================================================
 *  Copyright 199-2004 Mort Bay Consulting Pty. Ltd.
 *  ------------------------------------------------------------------------
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  ========================================================================
 * 
 *******************************************************************************/

package org.openanzo.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpContent;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeaderValues;
import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.http.HttpMethods;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.io.Buffer;
import org.eclipse.jetty.io.ByteArrayBuffer;
import org.eclipse.jetty.io.WriterOutputStream;
import org.eclipse.jetty.server.HttpConnection;
import org.eclipse.jetty.server.InclusiveByteRange;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.IO;
import org.eclipse.jetty.util.MultiPartOutputStream;
import org.eclipse.jetty.util.TypeUtil;

/**
 * Sevlet to serve out resources from a bundle
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class ResourceServerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private boolean           _acceptRanges    = true;

    ByteArrayBuffer           _cacheControl;

    private MimeTypes         _mimeTypes;

    @Override
    public void init() throws UnavailableException {
        ServletContext config = getServletContext();
        ServletContextHandler.Context context = (ServletContextHandler.Context) config;
        _mimeTypes = context.getContextHandler().getMimeTypes();

        _acceptRanges = getInitBoolean("acceptRanges", _acceptRanges);
        String t = getInitParameter("cacheControl");
        if (t != null)
            _cacheControl = new ByteArrayBuffer(t);
    }

    /* ------------------------------------------------------------ */
    private boolean getInitBoolean(String name, boolean dft) {
        String value = getInitParameter(name);
        if (value == null || value.length() == 0)
            return dft;
        return (value.startsWith("t") || value.startsWith("T") || value.startsWith("y") || value.startsWith("Y") || value.startsWith("1"));
    }

    /* ------------------------------------------------------------ */
    /* Check modification date headers.
     */

    protected boolean passConditionalHeaders(HttpServletRequest request, HttpServletResponse response, org.eclipse.jetty.util.resource.Resource resource, HttpContent content) throws IOException {
        if (!request.getMethod().equals(HttpMethods.HEAD)) {
            String ifms = request.getHeader(HttpHeaders.IF_MODIFIED_SINCE);
            if (ifms != null) {
                if (content != null) {
                    Buffer mdlm = content.getLastModified();
                    if (mdlm != null) {
                        if (ifms.equals(mdlm.toString())) {
                            response.reset();
                            response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
                            response.flushBuffer();
                            return false;
                        }
                    }
                }

                long ifmsl = request.getDateHeader(HttpHeaders.IF_MODIFIED_SINCE);
                if (ifmsl != -1) {
                    if (resource.lastModified() / 1000 <= ifmsl / 1000) {
                        response.reset();
                        response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
                        response.flushBuffer();
                        return false;
                    }
                }
            }

            // Parse the if[un]modified dates and compare to resource
            long date = request.getDateHeader(HttpHeaders.IF_UNMODIFIED_SINCE);

            if (date != -1) {
                if (resource.lastModified() / 1000 > date / 1000) {
                    response.sendError(HttpServletResponse.SC_PRECONDITION_FAILED);
                    return false;
                }
            }

        }
        return true;
    }

    /* ------------------------------------------------------------ */
    @SuppressWarnings("unchecked")
    protected void sendData(HttpServletRequest request, HttpServletResponse response, boolean include, org.eclipse.jetty.util.resource.Resource resource, HttpContent content, Enumeration reqRanges) throws IOException {
        long content_length = resource.length();

        // Get the output stream (or writer)
        OutputStream out = null;
        try {
            out = response.getOutputStream();
        } catch (IllegalStateException e) {
            out = new WriterOutputStream(response.getWriter());
        }

        if (reqRanges == null || !reqRanges.hasMoreElements()) {
            //  if there were no ranges, send entire entity
            if (include) {
                resource.writeTo(out, 0, content_length);
            } else {
                // See if a short direct method can be used?
                if (out instanceof HttpConnection.Output) {
                    if (_cacheControl != null) {
                        if (response instanceof Response)
                            ((Response) response).getHttpFields().put(HttpHeaders.CACHE_CONTROL_BUFFER, _cacheControl);
                        else
                            response.setHeader(HttpHeaders.CACHE_CONTROL, _cacheControl.toString());
                    }
                    ((HttpConnection.Output) out).sendContent(content);
                } else {

                    // Write content normally
                    writeHeaders(response, content, content_length);
                    resource.writeTo(out, 0, content_length);
                }
            }
        } else {
            // Parse the satisfiable ranges
            List ranges = InclusiveByteRange.satisfiableRanges(reqRanges, true, content_length);

            //  if there are no satisfiable ranges, send 416 response
            if (ranges == null || ranges.size() == 0) {
                writeHeaders(response, content, content_length);
                response.setStatus(HttpServletResponse.SC_REQUESTED_RANGE_NOT_SATISFIABLE);
                response.setHeader(HttpHeaders.CONTENT_RANGE, InclusiveByteRange.to416HeaderRangeString(content_length));
                resource.writeTo(out, 0, content_length);
                return;
            }

            //  if there is only a single valid range (must be satisfiable 
            //  since were here now), send that range with a 216 response
            if (ranges.size() == 1) {
                InclusiveByteRange singleSatisfiableRange = (InclusiveByteRange) ranges.get(0);
                long singleLength = singleSatisfiableRange.getSize(content_length);
                writeHeaders(response, content, singleLength);
                response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
                response.setHeader(HttpHeaders.CONTENT_RANGE, singleSatisfiableRange.toHeaderRangeString(content_length));
                resource.writeTo(out, singleSatisfiableRange.getFirst(content_length), singleLength);
                return;
            }

            //  multiple non-overlapping valid ranges cause a multipart
            //  216 response which does not require an overall 
            //  content-length header
            //
            writeHeaders(response, content, -1);
            String mimetype = content.getContentType().toString();
            MultiPartOutputStream multi = new MultiPartOutputStream(out);
            response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);

            // If the request has a "Request-Range" header then we need to
            // send an old style multipart/x-byteranges Content-Type. This
            // keeps Netscape and acrobat happy. This is what Apache does.
            String ctp;
            if (request.getHeader(HttpHeaders.REQUEST_RANGE) != null)
                ctp = "multipart/x-byteranges; boundary=";
            else
                ctp = "multipart/byteranges; boundary=";
            response.setContentType(ctp + multi.getBoundary());

            InputStream in = resource.getInputStream();
            long pos = 0;

            for (int i = 0; i < ranges.size(); i++) {
                InclusiveByteRange ibr = (InclusiveByteRange) ranges.get(i);
                String header = HttpHeaders.CONTENT_RANGE + ": " + ibr.toHeaderRangeString(content_length);
                multi.startPart(mimetype, new String[] { header });

                long start = ibr.getFirst(content_length);
                long size = ibr.getSize(content_length);
                if (in != null) {
                    // Handle non cached resource
                    if (start < pos) {
                        in.close();
                        in = resource.getInputStream();
                        pos = 0;
                    }
                    if (pos < start) {
                        in.skip(start - pos);
                        pos = start;
                    }
                    IO.copy(in, multi, size);
                    pos += size;
                } else
                    // Handle cached resource
                    (resource).writeTo(multi, start, size);

            }
            if (in != null)
                in.close();
            multi.close();
        }
        return;
    }

    /* ------------------------------------------------------------ */
    protected void writeHeaders(HttpServletResponse response, HttpContent content, long count) throws IOException {
        if (content.getContentType() != null)
            response.setContentType(content.getContentType().toString());

        if (response instanceof Response) {
            Response r = (Response) response;
            HttpFields fields = r.getHttpFields();

            if (content.getLastModified() != null)
                fields.put(HttpHeaders.LAST_MODIFIED_BUFFER, content.getLastModified(), content.getResource().lastModified());
            else if (content.getResource() != null) {
                long lml = content.getResource().lastModified();
                if (lml != -1)
                    fields.putDateField(HttpHeaders.LAST_MODIFIED_BUFFER, lml);
            }

            if (count != -1)
                r.setLongContentLength(count);

            if (_acceptRanges)
                fields.put(HttpHeaders.ACCEPT_RANGES_BUFFER, HttpHeaderValues.BYTES_BUFFER);

            if (_cacheControl != null)
                fields.put(HttpHeaders.CACHE_CONTROL_BUFFER, _cacheControl);

        } else {
            long lml = content.getResource().lastModified();
            if (lml >= 0)
                response.setDateHeader(HttpHeaders.LAST_MODIFIED, lml);

            if (count != -1) {
                if (count < Integer.MAX_VALUE)
                    response.setContentLength((int) count);
                else
                    response.setHeader(HttpHeaders.CONTENT_LENGTH, TypeUtil.toString(count));
            }

            if (_acceptRanges)
                response.setHeader(HttpHeaders.ACCEPT_RANGES, "bytes");

            if (_cacheControl != null)
                response.setHeader(HttpHeaders.CACHE_CONTROL, _cacheControl.toString());
        }
    }

    protected class UnCachedContent implements HttpContent {
        org.eclipse.jetty.util.resource.Resource _resource;

        String                                   _contentType;

        public UnCachedContent(org.eclipse.jetty.util.resource.Resource resource) {
            _resource = resource;
            _contentType = null;
        }

        public UnCachedContent(org.eclipse.jetty.util.resource.Resource resource, String contentType) {
            _resource = resource;
            _contentType = contentType;
        }

        /* ------------------------------------------------------------ */
        public Buffer getContentType() {
            if (_contentType != null) {
                return new ByteArrayBuffer(_contentType);
            } else
                return _mimeTypes.getMimeByExtension(_resource.toString());

        }

        /* ------------------------------------------------------------ */
        public Buffer getLastModified() {
            return null;
        }

        /* ------------------------------------------------------------ */
        public Buffer getBuffer() {
            return null;
        }

        /* ------------------------------------------------------------ */
        public long getContentLength() {
            return _resource.length();
        }

        /* ------------------------------------------------------------ */
        public InputStream getInputStream() throws IOException {
            return _resource.getInputStream();
        }

        /* ------------------------------------------------------------ */
        public org.eclipse.jetty.util.resource.Resource getResource() {
            return _resource;
        }

        /* ------------------------------------------------------------ */
        public void release() {
            _resource.release();
            _resource = null;
        }

    }

}
