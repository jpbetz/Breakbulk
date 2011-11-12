#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/sql/nodecentric/mysql/createBocaTemporaryTables/Attic/queryTempTables.ddl,v $
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
CREATE TEMPORARY TABLE SUBJECT_IDS_TEMP (
	ID		{6}
)ENGINE = MEMORY;
CREATE TEMPORARY TABLE PREDICATE_IDS_TEMP (
	ID		{6}
)ENGINE = MEMORY;
CREATE TEMPORARY TABLE OBJECT_IDS_TEMP (
	ID		{6}
)ENGINE = MEMORY;
CREATE TEMPORARY TABLE NAMEDGRAPH_IDS_TEMP (
	ID		{6}
)ENGINE = MEMORY;

CREATE TEMPORARY TABLE IF NOT EXISTS ID_TMP (
	ID		{6},
	ENTRYID	{6},
	TYPE 	{5}
) ENGINE = MEMORY;

CREATE TEMPORARY TABLE IF NOT EXISTS RES_TMP (
	ENTRYID	{6},
	VALUE	{7}({4}) {3}
)   ENGINE=MEMORY;

CREATE TEMPORARY TABLE IF NOT EXISTS LIT_TMP (
	ENTRYID	{6},
	VALUE		{7}({4}) {3},
	MODIFIER_ID	{6}
)  ENGINE=MEMORY ;


CREATE TEMPORARY TABLE IF NOT EXISTS  STMTS_TMP (
	OPERATION			{5} NOT NULL,
	ID					{7}({4}) {3} NOT NULL,
	STMTID				{6} NOT NULL,
	METADATA			{5} NOT NULL,
	UUID				{6} NOT NULL,
	NAMEDGRAPHID		{6} NOT NULL,
	SUBJECT 		    {6} NOT NULL,
	PREDICATE   		{6} NOT NULL,
	OBJECT     		   	{6} NOT NULL,
	MODIFIED			{6} NOT NULL
)  ENGINE=MEMORY;