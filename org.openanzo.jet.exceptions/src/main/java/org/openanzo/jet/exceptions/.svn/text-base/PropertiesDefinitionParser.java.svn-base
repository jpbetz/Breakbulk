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
public class PropertiesDefinitionParser extends DefaultHandler {

    /** The current char buffer for the current element being processed */
    StringBuffer             currentChars       = null;

    static final String      propertiesGroup    = "propertiesGroup";

    static final String      property           = "property";

    static final String      example            = "example";

    static final String      description        = "description";

    static final String      tag                = "tag";

    PropertyGroup            currentGroup       = null;

    Property                 currentProperty    = null;

    Description              currentDescription = null;

    Example                  currentExample     = null;

    Tag                      currentTag         = null;

    ArrayList<PropertyGroup> groups             = new ArrayList<PropertyGroup>();

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
     * Get the PropertyGroup for this parser
     * 
     * @return the PropertyGroup for this parser
     */
    public PropertyGroup getGroup() {
        return currentGroup;
    }

    /** Class representing a Property */
    public class Property {

        String                 name;

        String                 key;

        PropType               type;

        String                 defaultValue;

        boolean                isRestartRequired = true;

        boolean                quoteDefault      = true;

        boolean                passDefault       = false;

        String                 parentProperty    = null;

        ArrayList<Description> generalDescription;

        Description            clientDescription;

        Description            serverDescription;

        Description            embeddedDescription;

        ArrayList<Tag>         tags              = new ArrayList<Tag>();

        ArrayList<Example>     generalExample;

        Example                clientExample;

        Example                serverExample;

        Example                embeddedExample;

        String                 minValue;

        String                 maxValue;

        /**
         * Determine if this property has a description
         * 
         * @return true if this property has a description
         */
        public boolean hasDescription() {
            return generalDescription != null || clientDescription != null || serverDescription != null || embeddedDescription != null;
        }

        /**
         * Determine if this property has an example
         * 
         * @return true if this property has an example
         */
        public boolean hasExample() {
            return generalExample != null || clientExample != null || serverExample != null || embeddedExample != null;
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
         * Get the key string for this property
         * 
         * @return the key string for this property
         */
        public String getKey() {
            return key;
        }

        /**
         * Get the property value type
         * 
         * @return the property value type
         */
        public PropType getType() {
            return type;
        }

        /**
         * Get the default value for this property
         * 
         * @return the default value for this property
         */
        public String getDefaultValue() {
            return defaultValue;
        }

        /**
         * Should get method take a default value as a parameter
         * 
         * @return if method should take a default value as a parameter
         */
        public boolean getPassDefault() {
            return passDefault;
        }

        /**
         * Get the general description for this property
         * 
         * @return the general description for this property
         */
        public ArrayList<Description> getGeneralDescription() {
            return generalDescription;
        }

        /**
         * Return special description information when this property is being used in client mode
         * 
         * @return special description information when this property is being used in client mode
         */
        public Description getClientDescription() {
            return clientDescription;
        }

        /**
         * Return special description information when this property is being used in server mode
         * 
         * @return special description information when this property is being used in server mode
         */
        public Description getServerDescription() {
            return serverDescription;
        }

        /**
         * Return special description information when this property is being used in embedded mode
         * 
         * @return special description information when this property is being used in embedded mode
         */
        public Description getEmbeddedDescription() {
            return embeddedDescription;
        }

        /**
         * Return example information for this property
         * 
         * @return example information for this property
         */
        public ArrayList<Example> getGeneralExample() {
            return generalExample;
        }

        /**
         * Return special example information when this property is being used in client mode
         * 
         * @return special example information when this property is being used in client mode
         */
        public Example getClientExample() {
            return clientExample;
        }

        /**
         * Return special example information when this property is being used in server mode
         * 
         * @return special example information when this property is being used in server mode
         */
        public Example getServerExample() {
            return serverExample;
        }

        /**
         * Return special example information when this property is being used in embedded mode
         * 
         * @return special example information when this property is being used in embedded mode
         */
        public Example getEmbeddedExample() {
            return embeddedExample;
        }

        /**
         * Return if quote characters should be placed around the default value string
         * 
         * @return true if quote characters should be placed around the default value string
         */
        public boolean getQuoteDefault() {
            return quoteDefault;
        }

        /**
         * Return any special tags for this property like &#064;see
         * 
         * @return any special tags for this property like &#064;see
         */
        public ArrayList<Tag> getTags() {
            return tags;
        }

        /**
         * Return the minimum value constraint on this property
         * 
         * @return the minimum value constraint on this property
         */
        public String getMinValue() {
            return minValue;
        }

        /**
         * Return the maximum value constraint on this property
         * 
         * @return the maximum value constraint on this property
         */
        public String getMaxValue() {
            return maxValue;
        }

        /**
         * Fallback property to check if property not present
         * 
         * @return fallback property to check if property not present
         */
        public String getParentProperty() {
            return parentProperty;
        }

        /**
         * Fallback property to check if property not present
         * 
         * @return fallback property to check if property not present, with last . replaced with #
         */
        public String getParentPropertyLink() {
            if (parentProperty != null) {
                int lastIndex = parentProperty.lastIndexOf('.');
                if (lastIndex > -1) {
                    return parentProperty.substring(0, lastIndex).concat("#").concat(parentProperty.substring(lastIndex + 1));
                }
            }
            return null;
        }

        /**
         * Set fallback property to check if property not present
         * 
         * @param parentProperty
         *            Fallback property to check if property not present
         */
        public void setParentProperty(String parentProperty) {
            this.parentProperty = parentProperty;
        }

        /**
         * @return the isRestartRequired
         */
        public boolean isRestartRequired() {
            return isRestartRequired;
        }

        /**
         * @param isRestartRequired
         *            the isRestartRequired to set
         */
        public void setRestartRequired(boolean isRestartRequired) {
            this.isRestartRequired = isRestartRequired;
        }

    }

    /**
     * Class representing a group of properties that get combined into a class
     */
    public class PropertyGroup {

        String name;

        String packageName;

        /**
         * @param packageName
         *            the packageName to set
         */
        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }

        String              prefix;

        ArrayList<Tag>      tags       = new ArrayList<Tag>();

        Description         description;

        ArrayList<Property> properties = new ArrayList<Property>();

        /**
         * Get the class name that all the properties in this group are a member
         * 
         * @return the class name that all the properties in this group are a member
         */
        public String getClassName() {
            return name;
        }

        /**
         * Get the package name for the class
         * 
         * @return the package name for the class
         */
        public String getPackageName() {
            return packageName;
        }

        /**
         * Get the prefix for the property keys
         * 
         * @return the prefix for the property keys
         */
        public String getPrefix() {
            return prefix;
        }

        /**
         * Get the description of the class
         * 
         * @return the description of the class
         */
        public Description getDescription() {
            return description;
        }

        /**
         * Get the set of properties for this class
         * 
         * @return the set of properties for this class
         */
        public ArrayList<Property> getProperties() {
            return properties;
        }

        /**
         * Get any special tags for this class
         * 
         * @return any special tags for this class
         */
        public ArrayList<Tag> getTags() {
            return tags;
        }
    }

    /**
     * Representation of a description value
     */
    public class Description {

        String value;

        Type   type;

        /**
         * Get the value of the description
         * 
         * @return the value of the description
         */
        public String getValue() {
            return value;
        }

        /**
         * Get the type of description
         * 
         * @return the type of description
         */
        public Type getType() {
            return type;
        }
    }

    /**
     * Representation of a tag value
     */
    public class Tag {

        String value;

        String type;

        /**
         * Get the value of the tag
         * 
         * @return the value of the tag
         */
        public String getValue() {
            return value;
        }

        /**
         * Get the type of tag
         * 
         * @return the type of tag
         */
        public String getType() {
            return type;
        }
    }

    /**
     * Representation of an Example
     */
    public class Example {

        String value;

        Type   type;

        /**
         * Get the value of the example
         * 
         * @return the value of the example
         */
        public String getValue() {
            return value;
        }

        /**
         * Get the type of the example
         * 
         * @return the type of the example
         */
        public Type getType() {
            return type;
        }
    }

    /**
     * Types of examples and descriptions
     */
    public enum Type {
        /** Client example or description */
        CLIENT,
        /** Server example or description */
        SERVER,
        /** Embedded example or description */
        EMBEDDED,
        /** General example or description */
        GENERAL
    }

    /**
     * Types of property values
     */
    public enum PropType {
        /** String property value */
        STRING,
        /** Boolean property value */
        BOOLEAN,
        /** Long property value */
        LONG,
        /** Integer property value */
        INTEGER,
        /** ENCRYPTED string property value */
        ENCRYPTED
    }

    @Override
    public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, name, attributes);
        if (propertiesGroup.equals(name)) {
            currentGroup = new PropertyGroup();
            currentGroup.packageName = attributes.getValue("packageName");
            currentGroup.prefix = attributes.getValue("groupPrefix");
            currentGroup.name = attributes.getValue("className");
            groups.add(currentGroup);
        } else if (tag.equals(name)) {
            currentTag = new Tag();
            currentTag.type = attributes.getValue("type");
            currentChars = new StringBuffer();
        } else if (property.equals(name)) {
            currentProperty = new Property();
            currentProperty.name = attributes.getValue("name");
            currentProperty.key = attributes.getValue("key");
            currentProperty.parentProperty = attributes.getValue("parentProperty");
            currentProperty.passDefault = Boolean.parseBoolean(attributes.getValue("passDefault"));
            currentProperty.quoteDefault = Boolean.parseBoolean(attributes.getValue("quoteDefault"));
            currentProperty.defaultValue = attributes.getValue("defaultValue");
            currentProperty.minValue = attributes.getValue("min");
            currentProperty.maxValue = attributes.getValue("max");
            String type = attributes.getValue("type");
            if (type != null) {
                if ("String".equals(type)) {
                    currentProperty.type = PropType.STRING;
                } else if ("Encrypted".equals(type)) {
                    currentProperty.type = PropType.ENCRYPTED;
                } else if ("Long".equals(type)) {
                    currentProperty.type = PropType.LONG;
                } else if ("Integer".equals(type)) {
                    currentProperty.type = PropType.INTEGER;
                } else if ("Boolean".equals(type)) {
                    currentProperty.type = PropType.BOOLEAN;
                }
            }
            String rr = attributes.getValue("restartRequired");
            if (rr != null) {
                currentProperty.isRestartRequired = Boolean.parseBoolean(rr);
            }
            currentGroup.properties.add(currentProperty);
        } else if (example.equals(name)) {
            currentExample = new Example();
            String type = attributes.getValue("type");
            if (type == null) {
                type = "";
            }
            if ("Client".equals(type)) {
                currentExample.type = Type.CLIENT;
                currentProperty.clientExample = currentExample;
            } else if ("Server".equals(type)) {
                currentExample.type = Type.SERVER;
                currentProperty.serverExample = currentExample;
            } else if ("Embedded".equals(type)) {
                currentExample.type = Type.EMBEDDED;
                currentProperty.embeddedExample = currentExample;
            } else {
                currentExample.type = Type.GENERAL;
                if (currentProperty.generalExample == null) {
                    currentProperty.generalExample = new ArrayList<Example>();
                }
                currentProperty.generalExample.add(currentExample);
            }
            currentChars = new StringBuffer();
        } else if (description.equals(name)) {
            currentDescription = new Description();
            String type = attributes.getValue("type");
            if (type == null) {
                type = "";
            }
            if ("Client".equals(type)) {
                currentDescription.type = Type.CLIENT;
                if (currentProperty != null) {
                    currentProperty.clientDescription = currentDescription;
                }
            } else if ("Server".equals(type)) {
                currentDescription.type = Type.SERVER;
                if (currentProperty != null) {
                    currentProperty.serverDescription = currentDescription;
                }
            } else if ("Embedded".equals(type)) {
                currentDescription.type = Type.EMBEDDED;
                if (currentProperty != null) {
                    currentProperty.embeddedDescription = currentDescription;
                }
            } else {
                currentDescription.type = Type.GENERAL;
                if (currentProperty != null) {
                    if (currentProperty.generalDescription == null) {
                        currentProperty.generalDescription = new ArrayList<Description>();
                    }
                    currentProperty.generalDescription.add(currentDescription);
                } else {
                    currentGroup.description = currentDescription;
                }
            }
            currentChars = new StringBuffer();
        }
    }

    @Override
    public void endElement(String uri, String localName, String name) throws SAXException {
        super.endElement(uri, localName, name);
        if (example.equals(name)) {
            currentExample.value = currentChars.toString();
        } else if (description.equals(name)) {
            currentDescription.value = currentChars.toString();
        } else if (property.equals(name)) {
            currentProperty = null;
        } else if (tag.equals(name)) {
            currentTag.value = currentChars.toString();
            if (currentProperty != null) {
                currentProperty.tags.add(currentTag);
            } else {
                currentGroup.tags.add(currentTag);
            }
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
     * Get the set of property groups that were parsed
     * 
     * @return the set of property groups that were parsed
     */
    public ArrayList<PropertyGroup> getGroups() {
        return groups;
    }
}
