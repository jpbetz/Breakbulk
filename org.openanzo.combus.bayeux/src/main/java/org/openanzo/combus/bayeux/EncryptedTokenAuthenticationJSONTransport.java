/******************************************************************************* 
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 *******************************************************************************/

package org.openanzo.combus.bayeux;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cometd.server.AbstractBayeux;
import org.cometd.server.JSONTransport;
import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.servlet.EncryptedTokenAuthenticator;

/**
 * A specialization of the basic cometd JSONTransport. The only difference in behavior is that this transport will inspect the messages being sent in the
 * response to make sure that the response represents real data flowing to the client. If an HTTP response only contains the polling acknowledgment and nothing
 * else, then the transport will ensure that the timeout on the authentication isn't reset.
 * 
 * Essentially this means that a cometd application will actually timeout even though the client keeps polling the server. Since we don't reset the timeout if a
 * response doesn't have any real data, then the client authentication will actually timeout after a series of empty poll responses.
 * 
 * @author Jordi A. Albornoz Mulligan <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>
 */
class EncryptedTokenAuthenticationJSONTransport extends JSONTransport {

    //private static final Logger                            log                             = LoggerFactory.getLogger(EncryptedTokenAuthenticationJSONTransport.class);

    private final HttpRequestBayeux bayeux;

    /**
     * Denotes if the auth cookie was already refreshed for this request. Used to avoid adding the cookie multiple times. If set, the value will be
     * {@link Boolean#TRUE}.
     */
    private static final String     AUTH_COOKIE_REFRESHED_ATTRIBUTE = "org.openanzo.server.combus.bayeux.EncryptedTokenAuthenticationJSONTransport.authCookieRefresh";

    protected EncryptedTokenAuthenticationJSONTransport(HttpRequestBayeux bayeux) {
        super();

        if (bayeux == null) {
            throw new AnzoRuntimeException(ExceptionConstants.COMBUS.BAYEUX_NULL);
        }
        this.bayeux = bayeux;
    }

    /* (non-Javadoc)
     * @see org.eclipse.cometd.JSONTransport#send(dojox.cometd.Message)
     */
    @Override
    public synchronized void send(org.cometd.Message message) throws IOException {
        if (!bayeux.isRequestAvailable() || bayeux.getCurrentRequest() == null) {
            throw new IllegalStateException("EncryptedTokenAuthenticationJSONTransport requires that the current HTTP request be available. Make sure the Bayeux 'requestAvailable' init parameter for the cometd servlet is true.");
        }

        HttpServletRequest currentRequest = bayeux.getCurrentRequest();
        Object attr = currentRequest.getAttribute(EncryptedTokenAuthenticator.ANZO_REFRESH_COOKIE_ATTRIBUTE);
        if (attr instanceof Cookie) {
            Cookie tokenCookie = (Cookie) attr;
            if (currentRequest.getAttribute(AUTH_COOKIE_REFRESHED_ATTRIBUTE) == null) { // If the cookie hasn't already been refreshed
                // The authenticator left us a cookie to use for refreshing the timeout. But we won't refresh
                // the timeout if this is a message sent to the "/meta/connect" channel since such messages
                // are simply poll request acknowledgments.
                String messageChannel = message.getChannel();
                if (!AbstractBayeux.META_CONNECT.equals(messageChannel)) {
                    HttpServletResponse response = getResponse();
                    response.addCookie(tokenCookie);
                    currentRequest.setAttribute(AUTH_COOKIE_REFRESHED_ATTRIBUTE, Boolean.TRUE);
                }
            }
        }

        super.send(message);
    }
}
