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
CREATE TABLE #SUBJECT_IDS_TEMP (
	ID		{6}
);

CREATE TABLE #PREDICATE_IDS_TEMP (
	ID		{6}
);

CREATE TABLE #OBJECT_IDS_TEMP (
	ID		{6}
);

CREATE TABLE #NAMEDGRAPH_IDS_TEMP (
	ID		{6}
);

CREATE TABLE #ID_TMP (
	ID		{6},
	ENTRYID	{6},
	TYPE 	{5}
) ;

CREATE TABLE #RES_TMP (
	ENTRYID	{6},
	VALUE	{7}({4}) {3}
) ;
CREATE INDEX  RES_TMP1 ON #RES_TMP(VALUE,ENTRYID);

CREATE TABLE #LIT_TMP (
	ENTRYID	{6},
	VALUE		{7}({4}) {3},
	MODIFIER_ID	{6}
) ;
CREATE INDEX LIT_TMP1 ON #LIT_TMP(VALUE,MODIFIER_ID,ENTRYID);

CREATE TABLE #STMTS_TMP (
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
CREATE INDEX STMTS1 ON #STMTS_TMP(OPERATION,ID);
CREATE INDEX STMTS2 ON #STMTS_TMP(ID,OPERATION);
CREATE INDEX STMTS3 ON #STMTS_TMP(STMTID,ID);

CREATE TABLE #STMT_ID_TMP (
	ID					{7}({4}) {3} NOT NULL,
	STMTID				{6} NOT NULL
) ;
CREATE INDEX STMT_ID_1 ON #STMT_ID_TMP(STMTID,ID);

CREATE TABLE #REMOVE_GRAPHS_TMP (
	ID					{6} NOT NULL,
	TYPE				{5} NOT NULL,
	REND				{6} NOT NULL
) ;
CREATE INDEX RG_ID ON #REMOVE_GRAPHS_TMP(TYPE,ID,REND);