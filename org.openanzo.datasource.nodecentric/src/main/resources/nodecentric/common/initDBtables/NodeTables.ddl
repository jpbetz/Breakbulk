#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/sql/nodecentric/hsql/initDBtables/Attic/NodeTables.ddl,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: NodeTables.ddl 180 2007-07-31 14:24:13Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
#
#
#
# Each node type recieves its own storage table that is indexed on
# the id and the actual node value.
#
#
# EACH NODE TYPE RECIEVES ITS OWN STORAGE TABLE THAT IS INDEXED ON
# THE ID AND THE ACTUAL NODE VALUE.
#
CREATE TABLE {0}_U (
	ID			{6} NOT NULL,
	VALUE		{7}({4}) {3},
	REF			{6} NOT NULL,
	PRIMARY KEY(ID)
)  {2};


CREATE TABLE {0}_B (
	ID			{6} NOT NULL,
	VALUE		{7}({4}) {3},
	REF			{6} NOT NULL,
	PRIMARY KEY(ID)
)  {2};
#
#
# LITERALS ARE COMPLICATED 
#
CREATE TABLE {0}_L (
	ID			{6} NOT NULL,
	VALUE		{7}({4}) {3},
	MODIFIER_ID {6}  NOT NULL,
	REF			{6} NOT NULL,
	PRIMARY KEY(ID)
)  {2};

CREATE TABLE {0}_TL (
    ID          {6} NOT NULL,
    VALUE       {7}({4}) {3},
    MODIFIER_ID	{6}  NOT NULL,
	REF			{6} NOT NULL,
    PRIMARY KEY(ID)
)  {2};
#
#
#
CREATE TABLE {0}_LL (
	ID			{6} NOT NULL,
	HASH		{6} NOT NULL,
	VALUE		{8},
	MODIFIER_ID {6},
	REF			{6} NOT NULL,
	PRIMARY KEY	(ID)
) {2};

CREATE TABLE {0}_LTL (
	ID			{6} NOT NULL,
	HASH		{6} NOT NULL,
	VALUE		{8},
	MODIFIER_ID	{6},
	REF			{6} NOT NULL,
	PRIMARY KEY	(ID)
) {2};
#
#
#
CREATE TABLE {0}_LU (
	ID			{6} NOT NULL,
	HASH		{6} NOT NULL,
	VALUE		{8},
	REF			{6} NOT NULL,
	PRIMARY KEY	(ID)
) {2};

CREATE TABLE {0}_USED_IDS (
    ID            {6} NOT NULL,
   	TRANSACTIONID {6} NOT NULL
)  {2};

CREATE TABLE {0}_DATATYPE (
	ID			{6} NOT NULL,
	VALUE		{7}({4}) {3},
	PRIMARY KEY(ID)
)  {2} ;

CREATE TABLE {0}_LANGUAGE (
	ID			{6} NOT NULL,
	VALUE		{7}({4}) {3},
	PRIMARY KEY(ID)
)  {2};
