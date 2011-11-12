#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/sql/nodecentric/hsql/createBocaTemporaryTables/Attic/queryTempTables.ddl,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: queryTempTables.ddl 180 2007-07-31 14:24:13Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
#
#
CREATE LOCAL TEMPORARY TABLE SUBJECT_IDS_TEMP (
	ID		{6}
)ON COMMIT DELETE ROWS;

CREATE LOCAL TEMPORARY TABLE PREDICATE_IDS_TEMP (
	ID		{6}
)ON COMMIT DELETE ROWS;

CREATE LOCAL TEMPORARY TABLE OBJECT_IDS_TEMP (
	ID		{6}
)ON COMMIT DELETE ROWS;

CREATE LOCAL TEMPORARY TABLE NAMEDGRAPH_IDS_TEMP (
	ID		{6}
)ON COMMIT DELETE ROWS;
CREATE INDEX NGIDID ON NAMEDGRAPH_IDS_TEMP(ID);

CREATE LOCAL TEMPORARY TABLE ID_TMP (
	ID		{6},
	ENTRYID	{6},
	TYPE 	{5}
);

CREATE LOCAL TEMPORARY TABLE RES_TMP (
	ENTRYID	{6},
	VALUE	{7}({4}) {3}
) ;
CREATE INDEX  RES_TMP1 ON RES_TMP(VALUE,ENTRYID);

CREATE LOCAL TEMPORARY TABLE LIT_TMP (
	ENTRYID	{6},
	VALUE		{7}({4}) {3},
	MODIFIER_ID	{6}
) ;
CREATE INDEX LIT_TMP1 ON LIT_TMP(VALUE,MODIFIER_ID,ENTRYID);

CREATE LOCAL TEMPORARY TABLE STMTS_TMP (
	OPERATION			{5} NOT NULL,
	ID					{7}({4}) {3} NOT NULL,
	STMTID				{6} NOT NULL,
	METADATA			{5} NOT NULL,
	UUID				{6} NOT NULL,
	NAMEDGRAPHID		{6} NOT NULL,
	SUBJECT       		{6} NOT NULL,
	PREDICATE       	{6} NOT NULL,
	OBJECT        		{6} NOT NULL,
	REVISION			{6} ,
	COMMITTED			{6} NOT NULL
) ;
CREATE INDEX IF NOT EXISTS STMTS1 ON STMTS_TMP(OPERATION,ID);
CREATE INDEX IF NOT EXISTS STMTS2 ON STMTS_TMP(ID,OPERATION);
CREATE INDEX IF NOT EXISTS STMTS3 ON STMTS_TMP(STMTID,ID);

CREATE LOCAL TEMPORARY TABLE STMT_ID_TMP (
	ID					{7}({4}) {3} NOT NULL,
	STMTID				{6} NOT NULL
) ;
CREATE INDEX IF NOT EXISTS STMT_ID_1 ON STMT_ID_TMP(STMTID,ID);

CREATE LOCAL TEMPORARY TABLE REMOVE_GRAPHS_TMP (
	ID					{6} NOT NULL,
	TYPE				{5} NOT NULL,
	REND				{6} NOT NULL
	
) ;
CREATE INDEX IF NOT EXISTS RG_ID ON REMOVE_GRAPHS_TMP(TYPE,ID,REND);