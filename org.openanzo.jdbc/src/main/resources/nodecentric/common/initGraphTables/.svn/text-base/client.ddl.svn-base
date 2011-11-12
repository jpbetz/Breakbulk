#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/sql/nodecentric/db2/initGraphTables/boca-client.ddl,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id:client.ddl 229 2007-08-07 15:22:00Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
#
#
# CART Client tables
CREATE TABLE {0}_TRANSACTIONS(
 ID			{9},
 CREATED	{6}
)  ;
CREATE UNIQUE INDEX {0}_TID ON {0}_TRANSACTIONS(ID)  {1} ;
#
CREATE TABLE {0}_COMMANDS(
 ID					{9},
 TransactionID		{6},
 commandType		{7}(1024) {3},
 preReq				{8},
 context			{8}
)  ;
CREATE UNIQUE INDEX {0}_CID ON {0}_COMMANDS(ID)  {1} ;
CREATE INDEX {0}_CTID on {0}_COMMANDS(TRANSACTIONID) {1}  ;
#
CREATE TABLE {0}_CHANGESETS(
 ID					{9},
 CommandID			{6},
 addGraph			{8},
 removeGraph		{8},
 metaAddGraph			{8},
 metaRemoveGraph		{8}
)  ;
CREATE UNIQUE INDEX {0}_CSID ON {0}_CHANGESETS(ID) {1}  ;
CREATE INDEX {0}_CSTID on {0}_CHANGESETS(CommandID) {1}  ;