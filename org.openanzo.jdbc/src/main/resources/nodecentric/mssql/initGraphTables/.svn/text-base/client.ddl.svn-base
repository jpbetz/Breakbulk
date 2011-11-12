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
 ID			INTEGER GENERATED ALWAYS AS IDENTITY,
 CREATED	TIMESTAMP
)  ;
CREATE UNIQUE INDEX {0}_TID ON {0}_TRANSACTIONS(ID)  ;
#
CREATE TABLE {0}_COMMANDS(
 ID					INTEGER GENERATED ALWAYS AS IDENTITY,
 TransactionID		INTEGER,
 commandType		VARCHAR(1024),
 preReq			NVARCHAR(4000) NOT LOGGED,
 context		NVARCHAR(4000) NOT LOGGED
)  ;
CREATE UNIQUE INDEX {0}_CID ON {0}_COMMANDS(ID)  ;
CREATE INDEX {0}_CTID on {0}_COMMANDS(TRANSACTIONID)  ;
#
CREATE TABLE {0}_CHANGESETS(
 ID					INTEGER GENERATED ALWAYS AS IDENTITY,
 CommandID			INTEGER,
 addGraph			NVARCHAR(4000) NOT LOGGED,
 removeGraph		NVARCHAR(4000) NOT LOGGED,
 metaAddGraph			NVARCHAR(4000) NOT LOGGED,
 metaRemoveGraph		NVARCHAR(4000) NOT LOGGED
)  ;
CREATE UNIQUE INDEX {0}_CSID ON {0}_CHANGESETS(ID)  ;
CREATE INDEX {0}_CSTID on {0}_CHANGESETS(CommandID)  ;