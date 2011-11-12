/******************************************************************************* 
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * This code is based on Jetty's org.eclipse.cometd.continuation.ContinuationBayeux class
 * as modified by Cambridge Semantics Incorporated to implement the encrypted
 * token authentication as described at:
 * http://www.openanzo.org/projects/openanzo/wiki/AnzoJsSessionKeyAuthenticationDesign
 * The original copyright statement from the ContinuationBayeux is reproduced below.
 * The ContinuationBayeux's authors were listed in the source as:
 * Greg Wilkins (gregw)
 * 
 * ========================================================================
 * Copyright 2006 Mort Bay Consulting Pty. Ltd.
 * ------------------------------------------------------------------------
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================================
 * 
 *******************************************************************************/

package org.openanzo.combus.bayeux;

import java.util.Map;

import org.cometd.server.ClientImpl;
import org.cometd.server.Transport;
import org.cometd.server.continuation.ContinuationBayeux;
import org.openanzo.exceptions.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A specialization of ContinuationBayeuxBayeux that always uses the EncryptedTokenAuthenticationJSONTransport for the Bayeux transport. This is simply here as
 * a way to get a custom transport implementation into the cometd framework.
 * 
 * @author Jordi A. Albornoz Mulligan <a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>
 */
class EncryptedTokenAuthenticationContinuationBayeux extends ContinuationBayeux implements HttpRequestBayeux {

    private static final Logger log = LoggerFactory.getLogger(EncryptedTokenAuthenticationContinuationBayeux.class);

    @Override
    public Transport newTransport(ClientImpl client, Map<?, ?> message) {

        if (log.isDebugEnabled()) {
            log.debug(LogUtils.COMBUS_MARKER, "newTransport: client={}, message= {}", client, message);
        }

        Transport result = null;

        try {
            result = new EncryptedTokenAuthenticationJSONTransport(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (log.isDebugEnabled()) {
            log.debug(LogUtils.COMBUS_MARKER, "newTransport: result={}", result);
        }

        return result;
    }

}
