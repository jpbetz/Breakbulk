#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/sql/nodecentric/postgres/createTemporaryTables/tempTables.ddl,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:    $Id: tempTables.ddl 178 2007-07-31 14:22:33Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
#
CREATE GLOBAL TEMPORARY TABLE ID_TMP (
	ID		{6},
	ENTRYID	{6},
	TYPE 	{5}
) ON COMMIT PRESERVE ROWS;

CREATE GLOBAL TEMPORARY TABLE RES_TMP (
	ENTRYID	{6},
	VALUE	{7}({4}) {3}
) ON COMMIT PRESERVE ROWS;

CREATE GLOBAL TEMPORARY TABLE LIT_TMP (
	ENTRYID	{6},
	VALUE		{7}({4}) {3},
	MODIFIER_ID	{6}
) ON COMMIT PRESERVE ROWS;

CREATE GLOBAL TEMPORARY TABLE STMT_TMP (
    ID                NUMBER,
    METADATA        NUMBER(1) NOT NULL,
    NAMEDGRAPHID    NUMBER NOT NULL,
    SUBJ               NUMBER NOT NULL,
    PROP               NUMBER NOT NULL,
    OBJ                NUMBER NOT NULL
) ON COMMIT PRESERVE ROWS ;

CREATE GLOBAL TEMPORARY TABLE LIT_TMP (
    ID            NUMBER,
    TYPE        NUMBER(1),
    VALUE        VARCHAR2({4}) {3},
    MODIFIER_ID    NUMBER
) ON COMMIT PRESERVE ROWS;

CREATE GLOBAL TEMPORARY TABLE DEFAULTGRAPHS_TMP ( 
  ID NUMBER NOT NULL
) ON COMMIT PRESERVE ROWS;

#CREATE INDEX DEFAULTGRAPHS_IDX ON DEFAULTGRAPHS_TMP (ID);

CREATE GLOBAL TEMPORARY TABLE QUERY (
    NAMEDGRAPHID    NUMBER,
    SUBJ               NUMBER,
    PROP               NUMBER,
    OBJ                NUMBER
) ON COMMIT PRESERVE ROWS;

CREATE GLOBAL TEMPORARY TABLE NAMEDGRAPHS_TMP ( 
  ID NUMBER NOT NULL
) ON COMMIT PRESERVE ROWS;

#CREATE INDEX NAMEDGRAPHS_IDX ON NAMEDGRAPHS_TMP (ID);

CREATE GLOBAL TEMPORARY TABLE TEMPGRAPHS ( 
  ID NUMBER NOT NULL
) ON COMMIT PRESERVE ROWS;


CREATE GLOBAL TEMPORARY TABLE TEMP_COLUMNS(
    C0                NUMBER,
    C1                NUMBER,
    C2                NUMBER,
    C3                NUMBER,
    C4                NUMBER,
    C5                NUMBER,
    C6                NUMBER,
    C7                NUMBER,
    C8                NUMBER,
    C9                NUMBER,
    C10                NUMBER,
    C11                NUMBER,
    C12                NUMBER,
    C13                NUMBER,
    C14                NUMBER,
    C15                NUMBER
)ON COMMIT PRESERVE ROWS;

CREATE GLOBAL TEMPORARY TABLE TEMP_CONSTRAINT0(
	ID				{6}
)ON COMMIT PRESERVE ROWS;

CREATE GLOBAL TEMPORARY TABLE TEMP_CONSTRAINT1(
	ID				{6}
)ON COMMIT PRESERVE ROWS;

CREATE GLOBAL TEMPORARY TABLE TEMP_CONSTRAINT2(
	ID				{6}
)ON COMMIT PRESERVE ROWS;

CREATE GLOBAL TEMPORARY TABLE TEMP_CONSTRAINT3(
	ID				{6}
)ON COMMIT PRESERVE ROWS;
