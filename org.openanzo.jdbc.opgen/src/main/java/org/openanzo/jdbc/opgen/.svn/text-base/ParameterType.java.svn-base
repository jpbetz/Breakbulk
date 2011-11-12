/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Mar 3, 2009
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.jdbc.opgen;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public enum ParameterType {
    /** String */
    String("VARCHAR", "String"),
    /** */
    CHAR("CHAR", "String"),
    /** */
    VARCHAR("VARCHAR", "String"),
    /** */
    LONGVARCHAR("LONGVARCHAR", "String"),
    /** */
    NUMERIC("NUMERIC", "java.math.BigDecimal"),
    /** */
    DECIMAL("DECIMAL", "java.math.BigDecimal"),
    /** */
    BIT("BIT", "Boolean"),
    /** */
    BOOLEAN("BOOLEAN", "Boolean"),
    /** */
    TINYINT("TINYINT", "Byte"),
    /** */
    SMALLINT("SMALLINT", "Short"),
    /** */
    INTEGER("INTEGER", "Integer"),
    /** */
    BIGINT("BIGINT", "Long"),
    /** */
    REAL("REAL", "Float"),
    /** */
    FLOAT("FLOAT", "Double"),
    /** */
    DOUBLE("DOUBLE", "Double"),
    /** */
    BINARY("BINARY", "Byte[]"),
    /** */
    VARBINARY("VARBINARY", "Byte[]"),
    /** */
    LONGVARBINARY("LONGVARBINARY", "Byte[]"),
    /** */
    Date("DATE", "java.sql.Date"),
    /** */
    DATE("DATE", "java.sql.Date"),
    /** */
    Time("TIME", "java.sql.Time"),
    /** */
    TIME("TIME", "java.sql.Time"),
    /** */
    Timestamp("TIMESTAMP", "java.sql.Timestamp"),
    /** */
    TIMESTAMP("TIMESTAMP", "java.sql.Timestamp"),
    /** */
    Clob("CLOB", "java.sql.Clob"),
    /** */
    CLOB("CLOB", "java.sql.Clob"),
    /** */
    BLOB("BLOB", "Blob"),
    /** */
    ARRAY("ARRAY", "Array"),
    /** */
    REF("REF", "Ref"),
    /** */
    URL("DATALINK", "java.net.URL"),
    /** */
    DATALINK("DATALINK", "java.net.URL"),
    /** */
    Short("SMALLINT", "Short"),
    /** */
    Long("BIGINT", "Long"),
    /** */
    Integer("INT", "Integer"),
    /** */
    Character("CHAR", "Character"),
    /** */
    Boolean("BOOLEAN", "Boolean"),
    /** */
    Byte("BINARY", "Byte"),
    /** */
    Double("DOUBLE", "Double"),
    /** */
    Float("Float", "Float");

    private final String jdbcType;

    private final String javaType;

    private final String resultSetType;

    ParameterType(String jdbcType, String javaType) {
        this.jdbcType = jdbcType;
        this.javaType = javaType;
        if (javaType.equals("byte[]"))
            resultSetType = "Bytes";
        else if (javaType.equals("Integer")) {
            resultSetType = "Int";
        } else {
            resultSetType = org.apache.commons.lang.StringUtils.capitalize(unqualify(javaType));
        }
    }

    private static String unqualify(String javaName) {
        if (javaName.contains(".")) {
            return javaName.substring(javaName.lastIndexOf('.') + 1);
        }
        return javaName;
    }

    /**
     * @return the resultSetParam
     */
    public String getResultSetType() {
        return resultSetType;
    }

    /**
     * @return the javaType
     */
    public String getJavaType() {
        return javaType;
    }

    /**
     * @return the jdbcType
     */
    public String getJdbcType() {
        return jdbcType;
    }
}
