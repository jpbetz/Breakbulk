#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/sql/nodecentric/db2/createTemporaryTables/tempTables.ddl,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:    $Id: tempTables.ddl 178 2007-07-31 14:22:33Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
#
CREATE #TABLE ID_TMP (
	ID		{6},
	ENTRYID	{6},
	TYPE 	{5}
)   ;


CREATE #TABLE RES_TMP (
	ENTRYID	{6},
	VALUE	{7}({4}) {3}
)   ;

CREATE #TABLE LIT_TMP (
	ENTRYID	{6},
	VALUE		{7}({4}) {3},
	MODIFIER_ID	{6}
)   ;


CREATE #TABLE STMT_TMP (
    ID                BIGINT,
    METADATA        SMALLINT NOT NULL,
    NAMEDGRAPHID    BIGINT NOT NULL,
    SUBJ               BIGINT NOT NULL,
    PROP               BIGINT NOT NULL,
    OBJ                BIGINT NOT NULL
)   ;;

CREATE #TABLE QUERY (
    NAMEDGRAPHID    BIGINT,
    SUBJ               BIGINT,
    PROP               BIGINT,
    OBJ                BIGINT
)   ;;
#CREATE INDEX #QUERY_TMP_IDX ON #QUERY (NAMEDGRAPHID,SUBJ,PROP,OBJ);

CREATE #TABLE TEMP_COLUMNS(
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
)  ;;
CREATE INDEX #TC0_IDX ON #TEMP_COLUMNS (C0);
CREATE INDEX #TC1_IDX ON #TEMP_COLUMNS (C1);
CREATE INDEX #TC2_IDX ON #TEMP_COLUMNS (C2);
CREATE INDEX #TC3_IDX ON #TEMP_COLUMNS (C3);
CREATE INDEX #TC4_IDX ON #TEMP_COLUMNS (C4);
CREATE INDEX #TC5_IDX ON #TEMP_COLUMNS (C5);
CREATE INDEX #TC6_IDX ON #TEMP_COLUMNS (C6);
CREATE INDEX #TC7_IDX ON #TEMP_COLUMNS (C7);
CREATE INDEX #TC8_IDX ON #TEMP_COLUMNS (C8);
CREATE INDEX #TC9_IDX ON #TEMP_COLUMNS (C9);
CREATE INDEX #TC10_IDX ON #TEMP_COLUMNS (C10);
CREATE INDEX #TC11_IDX ON #TEMP_COLUMNS (C11);
CREATE INDEX #TC12_IDX ON #TEMP_COLUMNS (C12);
CREATE INDEX #TC13_IDX ON #TEMP_COLUMNS (C13);
CREATE INDEX #TC14_IDX ON #TEMP_COLUMNS (C14);
CREATE INDEX #TC15_IDX ON #TEMP_COLUMNS (C15);


CREATE #TABLE DEFAULTGRAPHS_TMP ( 
  ID BIGINT NOT NULL
)  ;
CREATE INDEX #DEFAULTGRAPHS_IDX ON #DEFAULTGRAPHS_TMP (ID);


CREATE #TABLE NAMEDGRAPHS_TMP ( 
  ID BIGINT NOT NULL
)  ;
CREATE INDEX #NAMEDGRAPHS_IDX ON #NAMEDGRAPHS_TMP (ID);

CREATE #TABLE TEMPGRAPHS ( 
  ID BIGINT NOT NULL
) ;
CREATE INDEX #TEMPGRAPHS_IDX ON #TEMPGRAPHS(ID);

CREATE TABLE #TEMP_CONSTRAINT0(
	ID				{6}
);

CREATE TABLE #TEMP_CONSTRAINT1(
	ID				{6}
);

CREATE TABLE #TEMP_CONSTRAINT2(
	ID				{6}
);

CREATE TABLE #TEMP_CONSTRAINT3(
	ID				{6}
);
