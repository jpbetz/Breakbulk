/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Dec 26, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.combus;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.services.serialization.transport.IMessage;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class JMSMessageWrapper implements IMessage {
    private final TextMessage message;

    /**
     * Create new wrapper around a JMS message
     * 
     * @param message
     */
    public JMSMessageWrapper(TextMessage message) {
        this.message = message;
    }

    public String getBody() throws AnzoException {
        try {
            return message.getText();
        } catch (JMSException jmsex) {
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER, jmsex);
        }
    }

    public void setBody(String bodyString) throws AnzoException {
        try {
            message.setText(bodyString);
        } catch (JMSException jmsex) {
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_FAILED_SETTING_MESSAGE_PARAMETER, jmsex);
        }
    }

    public String getProperty(String name) throws AnzoException {
        try {
            return message.getStringProperty(name);
        } catch (JMSException jmsex) {
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER, jmsex, name);
        }
    }

    public String[] getProperties(String name) throws AnzoException {
        throw new UnsupportedOperationException();
    }

    public boolean hasProperty(String name) throws AnzoException {
        try {
            return message.propertyExists(name);
        } catch (JMSException jmsex) {
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_MISSING_MESSAGE_PARAMETER, jmsex, name);
        }
    }

    public void setProperty(String name, String value) throws AnzoException {
        try {
            message.setStringProperty(name, value);
        } catch (JMSException jmsex) {
            throw new AnzoException(ExceptionConstants.COMBUS.JMS_FAILED_SETTING_MESSAGE_PARAMETER, jmsex);
        }
    }

    public boolean getUseMultiValueProperties() {
        return false;
    }

}
