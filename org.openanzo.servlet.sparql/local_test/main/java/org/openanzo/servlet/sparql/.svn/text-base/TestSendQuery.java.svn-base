/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Feb 27, 2009
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.servlet.sparql;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.PostMethod;
import org.openanzo.rdf.Constants;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class TestSendQuery {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            HttpClient client = new HttpClient();
            client.getState().setCredentials(new AuthScope("localhost", 8080), new UsernamePasswordCredentials("sysadmin", "123"));

            PostMethod post = new PostMethod("http://localhost:8080/sparql");
            post.setDoAuthentication(true);
            post.addParameter("query", "SELECT * WHERE {?s ?p ?o}");
            post.addParameter("default-graph-uri", Constants.GRAPHS.ALL_NAMEDGRAPHS.toString());
            post.setRequestHeader("Accept-Charset", "utf-8");
            client.executeMethod(post);
            int statusCode = post.getStatusCode();
            System.err.println(statusCode);
            System.err.println(post.getResponseBodyAsString());
            System.err.println(post.getResponseCharSet());
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
