/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.jdbc.utils/src/com/ibm/adtech/jdbc/utils/opgen/RdbStatement.java,v $
 * Created by:  Joe Betz
 * Created on:  9/30/2005
 * Revision:	$Id: RdbStatement.java 176 2007-07-31 14:22:30Z mroy $
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.jdbc.opgen;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Provides XML deserialization and accessors for rdf statements (SQL, DDL, etc.) for use in composing PreparedStatementProvider compatable .sql files and
 * generating java rdf statement wrappers.
 * 
 * @author Joe Betz
 * 
 */
public class RdbStatement {

    static final String element                 = "preparedstatement";

    static final String nameAttribute           = "name";

    static final String inputsAttribute         = "inputs";

    static final String outputsAttribute        = "outputs";

    static final String resultsAttribute        = "results";

    static final String templateParamsAttribute = "templateParams";

    static final String PREPARE                 = "prepare";

    String              name;

    String              sqlPackageName;

    String              sql;

    List<Parameter>     inputs;

    List<Parameter>     outputs;

    List<Parameter>     templateParams;

    Result              results;

    boolean             prepare                 = true;

    /**
     * Create a new RdbStatement
     * 
     * @param sqlPackageName
     *            name of package
     * @param name
     *            name of prepared statement
     * @param sql
     *            SQL query text
     * @param inputs
     *            inputs to the query
     * @param outputs
     *            outputs expected from the query
     * @param templateParams
     *            set of template parameters for the query
     * @param results
     *            results type for query
     * @param prepare
     *            true if statement should be prepared, otherwise use callable statement
     */
    public RdbStatement(String sqlPackageName, String name, String sql, List<Parameter> inputs, List<Parameter> outputs, List<Parameter> templateParams, Result results, boolean prepare) {
        this.sqlPackageName = sqlPackageName;
        this.name = name;
        this.sql = sql;
        this.inputs = inputs;
        this.outputs = outputs;
        this.templateParams = templateParams;
        this.results = results;
        this.prepare = prepare;
        initialize();
    }

    // make a best effort to get the text within a node.
    private static String getText(Node n) {
        NodeList nl = n.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node n2 = nl.item(i);
            if (n2.getNodeType() == Node.TEXT_NODE) {
                String text = n2.getNodeValue();
                if (text.trim().length() > 0) {
                    return text;
                }
            } else if (n2.getNodeType() == Node.CDATA_SECTION_NODE) {
                return n2.getNodeValue();
            } else {
                return getText(n);
            }
        }
        return null;
    }

    private static final Pattern pattern = Pattern.compile("(\\s+)");

    /**
     * Create a new RdbStatement from the given XML emement data
     * 
     * @param sqlPackageName
     *            package name for statement
     * @param xmlElement
     *            XML element containing data
     */
    public RdbStatement(String sqlPackageName, Element xmlElement) {
        this.sqlPackageName = sqlPackageName;
        if (!xmlElement.getNodeName().equals(element))
            throw new InvalidParameterException("XML element not of type '" + element + "'");
        sql = getText(xmlElement);
        if (sql == null)
            throw new InvalidParameterException("Node has no text: " + xmlElement);
        if (sql.trim().equals("EMPTY")) {
            sql = "";
        }
        Node nameNode = xmlElement.getAttributes().getNamedItem(nameAttribute);
        if (nameNode == null)
            throw new InvalidParameterException("'" + nameAttribute + "' is a required attribute for '" + element + "' element.");
        name = nameNode.getNodeValue();
        Node inputsNode = xmlElement.getAttributes().getNamedItem(inputsAttribute);
        if (inputsNode != null) {
            String paramList = inputsNode.getNodeValue();
            inputs = getParams(paramList);
        } else {
            inputs = new ArrayList<Parameter>(0);
        }
        Node templateParamsNode = xmlElement.getAttributes().getNamedItem(templateParamsAttribute);
        if (templateParamsNode != null) {
            String paramList = templateParamsNode.getNodeValue();
            templateParams = getParams(paramList);
        } else {
            templateParams = new ArrayList<Parameter>(0);
        }
        Node outputsNode = xmlElement.getAttributes().getNamedItem(outputsAttribute);
        if (outputsNode != null) {
            String paramList = outputsNode.getNodeValue();
            outputs = getParams(paramList);
        } else {
            outputs = new ArrayList<Parameter>(0);
        }
        Node resultsNode = xmlElement.getAttributes().getNamedItem(resultsAttribute);
        if (resultsNode != null) {
            results = Result.getResultsEnum(resultsNode);
        }
        Node dpNode = xmlElement.getAttributes().getNamedItem(PREPARE);
        if (dpNode != null) {
            prepare = Boolean.parseBoolean(dpNode.getNodeValue());
        }
        initialize();
    }

    private void initialize() {
        if (results == null)
            results = Result.NONE;
        if (results == Result.ROW && outputs.size() <= 1)
            throw new InvalidParameterException(name + ": ROW return type not allowed when there is zero or one outputs, use VALUE or ITERATOR instead.");
        if (results == Result.COUNTER && outputs.size() > 0)
            throw new InvalidParameterException(name + ": COUNTER return type not allowed when there is one our more outputs, use VALUE,ROW or ITERATOR instead.");
    }

    private static List<Parameter> getParams(String paramList) {
        List<Parameter> list = new ArrayList<Parameter>();
        if (paramList.length() > 0) {
            String[] params = paramList.split(",");
            for (int i = 0; i < params.length; i++) {
                String param = params[i].trim();
                String[] vals = pattern.split(param);
                String type = vals[0];
                String name = vals[1];
                boolean canBeNull = !type.startsWith("+");
                if (!canBeNull) {
                    type = type.substring(1);
                }
                ParameterType pType = ParameterType.valueOf(type);
                if (pType != null) {
                    list.add(new Parameter(name, pType, canBeNull));
                } else {
                    throw new RuntimeException(type + " type is invalid:" + paramList);
                }
            }
        }
        return list;
    }

    /**
     * Get the name of the statement
     * 
     * @return the name of the statement
     */
    public String getName() {
        return name;
    }

    /**
     * Get the qualified name of the statement
     * 
     * @return the qualified name of the statement
     */
    public String getQualifiedName() {
        if (sqlPackageName != "") {
            return sqlPackageName + "." + name;
        }
        return name;
    }

    /**
     * Capitalize the name of the statement
     * 
     * @return capitalized name of the statement
     */
    public String capitalizedName() {
        return org.apache.commons.lang.StringUtils.capitalize(name);
    }

    /**
     * Return if the provided string is a primitive value type
     * 
     * @param string
     *            type of value for which to determine primitive nature
     * @return if the provided string is a primitive value type
     */
    public static boolean isPrimitive(String string) {
        return string.equals("short") || string.equals("byte") || string.equals("boolean") || string.equals("long") || string.equals("int") || string.equals("char");
    }

    /**
     * Get the SQL query text for this statement
     * 
     * @return the SQL query text for this statement
     */
    public String getSql() {
        return sql;
    }

    /**
     * @return the dontPrepare
     */
    public boolean getPrepare() {
        return prepare;
    }

    /**
     * Get the input parameters for this statement
     * 
     * @return the input parameters for this statement
     */
    public List<Parameter> getInputs() {
        return inputs;
    }

    /**
     * Get the output parameters for this statement
     * 
     * @return the output parameters for this statement
     */
    public List<Parameter> getOutputs() {
        return outputs;
    }

    /**
     * Get the template parameters for this statement
     * 
     * @return the template parameters for this statement
     */
    public List<Parameter> getParams() {
        return templateParams;
    }

    /**
     * Get the return type for this statement
     * 
     * @return the return type for this statement
     */
    public String getReturnType() {
        if (results == Result.NONE) {
            return "void";
        } else if (results == Result.ITERATOR) {
            return "org.openanzo.jdbc.utils.ClosableIterator";
        } else if (results == Result.ROW) {
            return capitalizedName() + "Result";
        } else if (results == Result.VALUE) {
            return getValueReturnType(false);
        } else if (results == Result.COUNTER) {
            return "int";
        } else if (results == Result.IDENTITY) {
            return "Long";
        }
        throw new InvalidParameterException("Not a valid enumeration value: " + results.getValue());
    }

    /**
     * Determine if this statement has input parameters
     * 
     * @return if this statement has input parameters
     */
    public boolean hasInputParamType() {
        return (inputs.size() > 1);
    }

    /**
     * Get the Interface name for this statement's parameters
     * 
     * @return the Interface name for this statements parameters
     */
    public String getInputParamInterface() {
        return capitalizedName() + "Params";
    }

    /**
     * Get the Implementation name for this statement's parameters
     * 
     * @return the Implementation name for this statement's parameters
     */
    public String getInputParamImpl() {
        return capitalizedName() + "ParamsImpl";
    }

    /**
     * Get the interface name for this statement's results
     * 
     * @return the interface name for this statement's results
     */
    public String getResultsInterface() {
        return capitalizedName() + "Result";
    }

    /**
     * Get the implementation name for this statement's results
     * 
     * @return the implementation name for this statement's results
     */
    public String getResultsImpl() {
        return capitalizedName() + "ResultImpl";
    }

    String inputParamSigniture = null;

    /**
     * Get the full string representing for the input parameters to this statement
     * 
     * @return the full string representing for the input parameters to this statement
     */
    public String getInputParamSigniture() {
        if (inputParamSigniture == null) {
            inputParamSigniture = buildSignitureString(inputs);
        }
        return inputParamSigniture;
    }

    String inputExceptionSignature = null;

    /**
     * Get the full string representing for the input parameters to this statement
     * 
     * @return the full string representing for the input parameters to this statement
     */
    public String getInputExceptionSignature() {
        if (inputExceptionSignature == null) {
            inputExceptionSignature = buildExceptionSignitureString(inputs);
        }
        return inputExceptionSignature;
    }

    String templateExceptionSignature = null;

    /**
     * Get the full string representing for the input parameters to this statement
     * 
     * @return the full string representing for the input parameters to this statement
     */
    public String getTemplateExceptionSignature() {
        if (templateExceptionSignature == null) {
            templateExceptionSignature = buildExceptionSignitureString(templateParams);
        }
        return templateExceptionSignature;
    }

    String inputParams = null;

    /**
     * Get the string representing for the input parameters to this statement
     * 
     * @return the string representing for the input parameters to this statement
     */
    public String getInputParams() {
        if (inputParams == null) {
            inputParams = buildParamString(inputs);
        }
        return inputParams;
    }

    /**
     * Return true if this statement has template parameters
     * 
     * @return true if this statement has template parameters
     */
    public boolean hasTemplateParams() {
        return templateParams.size() > 0;
    }

    String templateParamSigniture = null;

    /**
     * Get the full string representing for the template parameters to this statement
     * 
     * @return the full string representing for the template parameters to this statement
     */
    public String getTemplateParamSigniture() {
        if (templateParamSigniture == null) {
            templateParamSigniture = buildSignitureString(templateParams);
        }
        return templateParamSigniture;
    }

    String templateParamsString = null;

    /**
     * Get the string representing for the template parameters to this statement
     * 
     * @return the string representing for the template parameters to this statement
     */
    public String getTemplateParams() {
        if (templateParamsString == null) {
            templateParamsString = buildParamString(templateParams);
        }
        return templateParamsString;
    }

    String templateParamsJavadocString = null;

    /**
     * Get the javadoc representing for the template parameters to this statement
     * 
     * @return the javadoc representing for the template parameters to this statement
     */
    public String getTemplateParamsJavadoc() {
        if (templateParamsJavadocString == null) {
            templateParamsJavadocString = buildJavadocParamString(templateParams);
        }
        return templateParamsJavadocString;
    }

    String inputParamsJavadocString = null;

    /**
     * Get the javadoc representing for the input parameters to this statement
     * 
     * @return the javadoc representing for the input parameters to this statement
     */
    public String getInputParamsJavadoc() {
        if (inputParamsJavadocString == null) {
            inputParamsJavadocString = buildJavadocParamString(inputs);
        }
        return inputParamsJavadocString;
    }

    /**
     * Return true if this statement has input parameters
     * 
     * @return true if this statement has input parameters
     */
    public boolean hasInputParams() {
        return inputs.size() > 0;
    }

    private String buildParamString(List<Parameter> params) {
        StringBuilder inputParamsBuf = new StringBuilder();
        for (Iterator<Parameter> inIter = params.iterator(); inIter.hasNext();) {
            Parameter param = inIter.next();
            inputParamsBuf.append(param.getName());
            if (inIter.hasNext()) {
                inputParamsBuf.append(", ");
            }
        }
        return inputParamsBuf.toString();
    }

    private String buildJavadocParamString(List<Parameter> params) {
        StringBuilder inputParamsBuf = new StringBuilder();
        for (Iterator<Parameter> inIter = params.iterator(); inIter.hasNext();) {
            Parameter param = inIter.next();
            inputParamsBuf.append("\n	 *@param ");
            inputParamsBuf.append(param.getName());
            inputParamsBuf.append(" template parameter");
        }
        return inputParamsBuf.toString();
    }

    private String buildSignitureString(List<Parameter> params) {
        StringBuilder inputParamSignitureBuf = new StringBuilder();
        for (Iterator<Parameter> inIter = params.iterator(); inIter.hasNext();) {
            Parameter param = inIter.next();
            inputParamSignitureBuf.append(param.getJavaType(false));
            inputParamSignitureBuf.append(" ");
            inputParamSignitureBuf.append(param.getName());
            if (inIter.hasNext()) {
                inputParamSignitureBuf.append(", ");
            }
        }
        return inputParamSignitureBuf.toString();
    }

    private String buildExceptionSignitureString(List<Parameter> params) {
        StringBuilder inputParamSignitureBuf = new StringBuilder();
        for (Iterator<Parameter> inIter = params.iterator(); inIter.hasNext();) {
            Parameter param = inIter.next();
            if (param.isPrimitive()) {
                inputParamSignitureBuf.append("\"" + param.getName() + "=\"+(" + param.getName() + ")");
            } else {
                inputParamSignitureBuf.append("\"" + param.getName() + "=\"+((");
                inputParamSignitureBuf.append(param.getName());
                inputParamSignitureBuf.append("!=null)?");
                inputParamSignitureBuf.append(param.getName());
                inputParamSignitureBuf.append(".toString():\"null\")");
            }
            if (inIter.hasNext()) {
                inputParamSignitureBuf.append(" + \",\" +");
            }
        }
        return inputParamSignitureBuf.toString();
    }

    /**
     * Return true if this statement expects results
     * 
     * @return true if this statement expects results
     */
    public boolean hasReturn() {
        return !getReturnType().equals("void");
    }

    /**
     * Get the return type for this statement
     * 
     * @param box
     *            should this type be boxed
     * @return the return type for this statement
     */
    public String getValueReturnType(boolean box) {
        Parameter param = getFirstOutput();
        return param.getJavaType(box);
    }

    /**
     * get the resultset property
     * 
     * @return resultset property
     */
    public String getResultSetProperty() {
        Parameter param = getFirstOutput();
        return param.getResultSetProperty();
    }

    /**
     * Get the javatype for this statement
     * 
     * @param box
     *            should the type be boxed
     * @return the javatype for this statement
     */
    public String getJavaType(boolean box) {
        return getFirstOutput().getJavaType(box);
    }

    /**
     * Get the jdbc type for this statement
     * 
     * @param box
     *            should the type be boxed
     * 
     * @return the jdbc type for this statement
     */
    public String getJdbcType(boolean box) {
        Parameter firstOutput = getFirstOutput();
        return firstOutput.getJdbcType();
    }

    /**
     * 
     * @return true if the result type is primitive
     */
    public boolean isPrimitive() {
        return getFirstOutput().isPrimitive();
    }

    private Parameter getFirstOutput() {
        Iterator<Parameter> iter = outputs.iterator();
        if (!iter.hasNext())
            throw new InvalidParameterException("No outputs specified");
        return iter.next();
    }

    /**
     * Get the result object for the statement
     * 
     * @return the result object for the statement
     */
    public Result getResults() {
        return results;
    }

    /**
     * Class the contains an input/output/template parameter
     */
    public static class Parameter {
        static HashMap<String, String> toPrimitive = new HashMap<String, String>();
        static {
            toPrimitive.put("Long", "long");
            toPrimitive.put("Integer", "int");
            toPrimitive.put("Byte", "byte");
            toPrimitive.put("Character", "char");
            toPrimitive.put("Short", "short");
            toPrimitive.put("Float", "float");
            toPrimitive.put("Boolean", "boolean");
            toPrimitive.put("Double", "double");
        }

        final String                   name;

        final ParameterType            type;

        final boolean                  canBeNull;

        /**
         * Create a new parameter with the given type
         * 
         * @param name
         *            name of the parameter
         * @param type
         *            type of the parameter
         * @param canBeNull
         *            can this parameter take null values
         */
        public Parameter(String name, ParameterType type, boolean canBeNull) {
            this.name = name;
            this.type = type;
            this.canBeNull = canBeNull;
        }

        /**
         * Get the name of the parameter
         * 
         * @return the name of the parameter
         */
        public String getName() {
            return name;
        }

        /**
         * Get the JavaType for the parameter
         * 
         * @param box
         *            should primitives be boxed
         * @return the JavaType for the parameter
         */
        public String getJavaType(boolean box) {
            if (!box && !canBeNull) {
                String jt = toPrimitive.get(type.getJavaType());
                if (jt == null) {
                    jt = type.getJavaType();
                }
                return jt;
            } else {
                return type.getJavaType();
            }
        }

        /**
         * Get the JdbcType for the parameter
         * 
         * @return the JdbcType for the parameter
         */
        public String getJdbcType() {
            return type.getJdbcType();
        }

        /**
         * Get the result set property
         * 
         * @return the result set property
         */
        public String getResultSetProperty() {
            return type.getResultSetType();
        }

        /**
         * Get the RDB property
         * 
         * @return the RDB property
         */
        public String getRdbProperty() {
            return org.apache.commons.lang.StringUtils.capitalize(name);
        }

        /**
         * Get whether or not this parameter can be bull
         * 
         * @return whether or not this parameter can be bull
         */
        public boolean canBeNull() {
            return canBeNull;
        }

        /**
         * Is this parameter a primitive
         * 
         * @return true if primitive
         */
        public boolean isPrimitive() {
            if (!canBeNull) {
                String jt = toPrimitive.get(type.getJavaType());
                return (jt != null);
            } else {
                return false;
            }
        }
    }
}
