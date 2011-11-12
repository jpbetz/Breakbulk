#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/sql/nodecentric/hsql/createTemporaryTables/tempTables.ddl,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:    $Id: tempTables.ddl 229 2007-08-07 15:22:00Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
#
CREATE TEMPORARY TABLE ID_TMP (
	ID		{6},
	ENTRYID	{6},
	TYPE 	{5}
) ON COMMIT PRESERVE ROWS;

CREATE TEMPORARY TABLE RES_TMP (
	ENTRYID	{6},
	VALUE	{7}({4}) {3}
) ON COMMIT PRESERVE ROWS;

CREATE TEMPORARY TABLE LIT_TMP (
	ENTRYID	{6},
	VALUE		{7}({4}) {3},
	MODIFIER_ID	{6}
) ON COMMIT PRESERVE ROWS;

CREATE TEMPORARY TABLE STMT_TMP (
    ID                BIGINT,
    METADATA        SMALLINT NOT NULL,
    NAMEDGRAPHID    BIGINT NOT NULL,
    SUBJ               BIGINT NOT NULL,
    PROP               BIGINT NOT NULL,
    OBJ                BIGINT NOT NULL
) ON COMMIT PRESERVE ROWS;

CREATE TEMPORARY TABLE QUERY (
    NAMEDGRAPHID    BIGINT,
    SUBJ               BIGINT,
    PROP               BIGINT,
    OBJ                BIGINT
) ON COMMIT PRESERVE ROWS;


CREATE TEMPORARY TABLE DEFAULTGRAPHS_TMP ( 
  ID BIGINT NOT NULL
) ON COMMIT PRESERVE ROWS;

CREATE INDEX DEFAULTGRAPHS_IDX ON DEFAULTGRAPHS_TMP (ID);

CREATE TEMPORARY TABLE NAMEDGRAPHS_TMP ( 
  ID BIGINT NOT NULL
) ON COMMIT PRESERVE ROWS;

CREATE INDEX NAMEDGRAPHS_IDX ON NAMEDGRAPHS_TMP (ID);

CREATE TEMPORARY TABLE TEMPGRAPHS ( 
  ID BIGINT NOT NULL
) ON COMMIT PRESERVE ROWS;



CREATE TEMPORARY TABLE TEMP_COLUMNS(
    C0                BIGINT,
    C1                BIGINT,
    C2                BIGINT,
    C3                BIGINT,
    C4                BIGINT,
    C5                BIGINT,
    C6                BIGINT,
    C7                BIGINT,
    C8                BIGINT,
    C9                BIGINT,
    C10                BIGINT,
    C11                BIGINT,
    C12                BIGINT,
    C13                BIGINT,
    C14                BIGINT,
    C15                BIGINT
)ON COMMIT PRESERVE ROWS;

CREATE TEMPORARY TABLE TEMP_CONSTRAINT0(
	ID				{6}
)ON COMMIT PRESERVE ROWS;

CREATE TEMPORARY TABLE TEMP_CONSTRAINT1(
	ID				{6}
)ON COMMIT PRESERVE ROWS;

CREATE TEMPORARY TABLE TEMP_CONSTRAINT2(
	ID				{6}
)ON COMMIT PRESERVE ROWS;

CREATE TEMPORARY TABLE TEMP_CONSTRAINT3(
	ID				{6}
)ON COMMIT PRESERVE ROWS;
