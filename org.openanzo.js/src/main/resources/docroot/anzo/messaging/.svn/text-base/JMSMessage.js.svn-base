/*******************************************************************************
 * Copyright (c) 2007-2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Oct 10, 2007
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

dojo.provide("anzo.messaging.JMSMessage");

dojo.require("anzo.client.Serialization");

// summary: The message that is sent via JMS.
anzo.messaging.JMSMessage = function(body, responseFormat) {
    // summary: Creates a new message.
    // body: Object
    //  The message that is sent in the body of the JMS message.
    // responseFormat: String
    //  The format requested for the response.  If not specified, it is assumed that should be handled as a javacript object, and
    //  the responseFormat is "application/json".

    this.body = body;
	this.properties = {};
	if (responseFormat) {
		this.properties[anzo.client.Serialization.RESPONSE_FORMAT] = responseFormat;
	} else {
		this.properties[anzo.client.Serialization.RESPONSE_FORMAT] = "application/json";
	}
};
