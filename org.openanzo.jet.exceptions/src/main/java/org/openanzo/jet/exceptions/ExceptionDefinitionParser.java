/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Sep 18, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.jet.exceptions;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * PropertiesDefintionParser handles the parsed results of a properties definition file.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class ExceptionDefinitionParser extends DefaultHandler {

    /** The current char buffer for the current element being processed */
    StringBuffer          currentChars       = null;

    static final String   ERROR_GROUP        = "errorGroup";

    static final String   ERROR_CODE         = "errorCode";

    static final String   ERROR_TAG          = "errorTag";

    static final String   MESSAGE            = "message";

    static final String   DESCRIPTION        = "description";

    static final String   POSSIBLECAUSE      = "possibleCause";

    static final String   SUGGESTEDFIX       = "suggestedFix";

    static final String   NAME               = "name";

    static final String   MASK               = "mask";

    static final String   ID                 = "id";

    ErrorGroup            currentErrorGroup  = null;

    ErrorGroup            currentParentGroup = null;

    ErrorTag              currentErrorTag    = null;

    ErrorCode             currentErrorCode   = null;

    ArrayList<ErrorTag>   errorTags          = new ArrayList<ErrorTag>();

    ArrayList<ErrorGroup> errorGroups        = new ArrayList<ErrorGroup>();

    private String        javaPackage;

    /**
     * Capitalize the first Letter of a string, and the first letter following a .
     * 
     * @param value
     * @return new string where first Letter of the string is capitalized, as well the any letter following a .
     */
    public static String capFirstLetter(String value) {
        String newString = value.substring(0, 1).toUpperCase() + value.substring(1, value.length());
        if (newString.contains(".")) {
            newString = newString.substring(0, newString.indexOf('.')) + capFirstLetter(newString.substring(newString.indexOf('.') + 1));
        }
        return newString;
    }

    /**
     * Replace all '.', and capitalize the letters following the '.'s.
     * 
     * @param value
     * @return new string where any letter following a '.' is capitalized.
     */
    public static String replaceDots(String value) {
        String newString = value;
        if (newString.contains(".")) {
            newString = newString.substring(0, newString.indexOf('.')) + capFirstLetter(newString.substring(newString.indexOf('.') + 1));
        }
        return newString;
    }

    /**
     * Get the ErrorGroup for this parser
     * 
     * @return the ErrorGroup for this parser
     */
    public ArrayList<ErrorGroup> getErrorGroups() {
        return errorGroups;
    }

    /**
     * Get the Error tags for this parser
     * 
     * @return the Error tags for this parser
     */
    public ArrayList<ErrorTag> getErrorTags() {
        return errorTags;
    }

    /** Class representing an error code */
    public class ErrorCode {

        String name;

        long   id;

        String description;

        String message;

        String possibleCause;

        String suggestedFix;

        /**
         * Determine if this errorCode has a description
         * 
         * @return true if this errorCode has a description
         */
        public boolean hasDescription() {
            return description != null && description.length() > 0;
        }

        /**
         * Get the descriptions of this error code
         * 
         * @return the descriptions of this error code
         */
        public String getDescription() {
            return description;
        }

        /**
         * Get the message for this error code
         * 
         * @return the message for this error code
         */
        public String getMessage() {
            return message;
        }

        /**
         * Determine if this errorCode has an suggestedFix
         * 
         * @return true if this property has an suggestedFix
         */
        public boolean hasSuggestedFix() {
            return suggestedFix != null && suggestedFix.length() > 0;
        }

        /**
         * Get the suggestedFix of this error code
         * 
         * @return the suggestedFix of this error code
         */
        public String getSuggestedFix() {
            return suggestedFix;
        }

        /**
         * Determine if this errorCode has an possibleCause
         * 
         * @return true if this property has an possibleCause
         */
        public boolean hasPossibleCause() {
            return possibleCause != null && possibleCause.length() > 0;
        }

        /**
         * Get the possibleCause of this error code
         * 
         * @return the possibleCause of this error code
         */
        public String getPossibleCause() {
            return possibleCause;
        }

        /**
         * Get the name of this error code
         * 
         * @return the name of this error code
         */
        public String getName() {
            return name;
        }

        /**
         * Get the id string for this error code
         * 
         * @return the id string for this error code
         */
        public long getId() {
            return id;
        }

    }

    /** Class representing a Property */
    public class ErrorTag {

        String name;

        long   id;

        String description;

        /**
         * Determine if this error tag has a description
         * 
         * @return true if this error tag has a description
         */
        public boolean hasDescription() {
            return description != null && description.length() > 0;
        }

        /**
         * Get the descriptions of this error tag
         * 
         * @return the descriptions of this error tag
         */
        public String getDescription() {
            return description;
        }

        /**
         * Get the name of this error tag
         * 
         * @return the name of this error tag
         */
        public String getName() {
            return name;
        }

        /**
         * Get the id string for this error tag
         * 
         * @return the id string for this error tag
         */
        public long getId() {
            return id;
        }

    }

    /** Class representing a Property */
    public class ErrorGroup {

        String                name;

        long                  mask;

        String                description;

        ArrayList<ErrorGroup> subGroups  = new ArrayList<ErrorGroup>();

        ArrayList<ErrorCode>  errorCodes = new ArrayList<ErrorCode>();

        /**
         * Determine if this errorCode has a description
         * 
         * @return true if this errorCode has a description
         */
        public boolean hasDescription() {
            return description != null && description.length() > 0;
        }

        /**
         * Get the descriptions of this minor group
         * 
         * @return the descriptions of this minor group
         */
        public String getDescription() {
            return description;
        }

        /**
         * Get the name of this property
         * 
         * @return the name of this property
         */
        public String getName() {
            return name;
        }

        /**
         * Get the id string for this property
         * 
         * @return the id string for this property
         */
        public long getMask() {
            return mask;
        }

        /**
         * Get the subgroups for this minor group
         * 
         * @return the subgroups for this minor group
         */
        public ArrayList<ErrorGroup> getSubGroups() {
            return subGroups;
        }

        /**
         * Get the errorCodes for this ErrorGroup
         * 
         * @return the errorCodes for this minor group
         */
        public ArrayList<ErrorCode> getErrorCodes() {
            return errorCodes;
        }
    }

    @Override
    public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, name, attributes);
        if (ERROR_TAG.equals(name)) {
            currentErrorTag = new ErrorTag();
            currentErrorTag.name = attributes.getValue(NAME);
            currentErrorTag.id = Long.parseLong(attributes.getValue(ID));
            errorTags.add(currentErrorTag);
        } else if (ERROR_GROUP.equals(name)) {
            if (currentErrorGroup != null) {
                currentParentGroup = currentErrorGroup;
            }
            currentErrorGroup = new ErrorGroup();
            currentErrorGroup.name = attributes.getValue(NAME);
            currentErrorGroup.mask = Long.parseLong(attributes.getValue(MASK));
            if (currentParentGroup != null) {
                currentParentGroup.subGroups.add(currentErrorGroup);
            } else {
                errorGroups.add(currentErrorGroup);
            }
        } else if (ERROR_CODE.equals(name)) {
            currentErrorCode = new ErrorCode();
            currentErrorCode.name = attributes.getValue(NAME);
            currentErrorCode.id = Long.parseLong(attributes.getValue(ID));
            currentErrorGroup.errorCodes.add(currentErrorCode);
        } else if (DESCRIPTION.equals(name)) {
            currentChars = new StringBuffer();
        } else if (POSSIBLECAUSE.equals(name)) {
            currentChars = new StringBuffer();
        } else if (SUGGESTEDFIX.equals(name)) {
            currentChars = new StringBuffer();
        } else if (MESSAGE.equals(name)) {
            currentChars = new StringBuffer();
        }
    }

    @Override
    public void endElement(String uri, String localName, String name) throws SAXException {
        super.endElement(uri, localName, name);
        if (DESCRIPTION.equals(name)) {
            if (currentErrorCode != null) {
                currentErrorCode.description = currentChars.toString();
            } else if (currentErrorGroup != null) {
                currentErrorGroup.description = currentChars.toString();
            } else if (currentErrorTag != null) {
                currentErrorTag.description = currentChars.toString();
            }
        } else if (POSSIBLECAUSE.equals(name)) {
            if (currentErrorCode != null) {
                currentErrorCode.possibleCause = currentChars.toString();
            }
        } else if (SUGGESTEDFIX.equals(name)) {
            if (currentErrorCode != null) {
                currentErrorCode.suggestedFix = currentChars.toString();
            }
        } else if (MESSAGE.equals(name)) {
            if (currentErrorCode != null) {
                currentErrorCode.message = currentChars.toString();
            }
        } else if (ERROR_GROUP.equals(name)) {
            if (currentParentGroup != null) {
                currentErrorGroup = currentParentGroup;
                currentParentGroup = null;
            } else {
                currentErrorGroup = null;
            }
        } else if (ERROR_TAG.equals(name)) {
            currentErrorTag = null;
        } else if (ERROR_CODE.equals(name)) {
            currentErrorCode = null;
        }
        currentChars = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (currentChars != null) {
            currentChars.append(ch, start, length);
        }
    }

    /**
     * Set the java package for the generated code
     * 
     * @param javaPackage
     *            the java package for the generated code
     */
    public void setPackage(String javaPackage) {
        this.javaPackage = javaPackage;
    }

    /**
     * Get the java package for the generated code
     * 
     * @return the java package for the generated code
     */
    public String getPackage() {
        return javaPackage;
    }

}
