/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.core/src/com/ibm/adtech/boca/common/exceptions/Attic/Messages.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  5/15/2006
 * Revision:	$Id: Messages.java 168 2007-07-31 14:11:14Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     C Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.exceptions;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Message bundle for AnzoException messages.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class Messages {

    private static final String         DEFAULT_BUNDLE_NAME = "org.openanzo.exceptions.messages";

    private static final ResourceBundle RESOURCE_BUNDLE     = ResourceBundle.getBundle(DEFAULT_BUNDLE_NAME);

    private static final String         EXCEPTIONCONSTANTS  = "ExceptionConstants.";

    /**
     * Based on given a set of error tags, an error code, get the text of the error message from the resource bundle
     * 
     * @param errorTags
     *            Error tags
     * @param errorCode
     *            Error code
     * @return Text of error message
     */
    public static final String getString(final long errorCode) {
        try {
            final StringBuilder message = new StringBuilder();

            message.append(RESOURCE_BUNDLE.getString(EXCEPTIONCONSTANTS + errorCode));
            return message.toString();
        } catch (MissingResourceException e) {
            return "![" + errorCode + "]!";
        }
    }

    /**
     * Based on given a set of error tags, an error code, get the text of the error message from the resource bundle
     * 
     * @param errorCode
     * @param args
     * @return
     */
    public static final String formatString(final long errorCode, String... args) {
        return MessageFormat.format(Messages.getString(errorCode), (Object[]) args);
    }

    /**
     * Based on given exceptionName, get the text of the error message from the resource bundle
     * 
     * @param exceptionName
     *            Name of exception to find error message
     * @return Text of error message
     */
    public static final String getString(final String exceptionName) {
        try {
            return RESOURCE_BUNDLE.getString(EXCEPTIONCONSTANTS + exceptionName);
        } catch (MissingResourceException e) {
            return '!' + EXCEPTIONCONSTANTS + exceptionName + '!';
        }
    }
}
