#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/sql/nodecentric/common/initGraphTables/initGraphTables.ddl,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:    $Id: initGraphTables.ddl 229 2007-08-07 15:22:00Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
#
#
# {0} - THE NAME OF THE GRAPH TO BE CREATED.
# {5} - SMALLINT
# {6} - BIGINT
# {7} - VARCHAR

CREATE TABLE {0}_S (
    METADATA    {5} NOT NULL,
    NAMEDGRAPHID {6} NOT NULL,
    SUBJ           {6} NOT NULL,
    PROP           {6} NOT NULL,
    OBJ            {6} NOT NULL
) {2};
#

CREATE TABLE {0}_ST (
    NA            {5} DEFAULT 0 NOT NULL ,
    ND            {5} DEFAULT 0 NOT NULL ,
    TS_ID        {6},
    TE_ID        {6},
    CS_ID        {6},
    CE_ID        {6},
    METADATA    {5} NOT NULL,
    NAMEDGRAPHID {6} NOT NULL,
    SUBJ           {6} NOT NULL,
    PROP           {6} NOT NULL,
    OBJ            {6} NOT NULL
) {2};

# Columns that might be used to do transaction inline with statements
#   REP            {5} DEFAULT 0  NOT NULL ,
#    NA            {5} DEFAULT 0 NOT NULL,
#    ND            {5} DEFAULT 0 NOT NULL,
#    TS_ID        {6},
#    TE_ID        {6},
#    CS_ID        {6},
#    CE_ID        {6} 

#
# EACH NODE TYPE RECIEVES ITS OWN STORAGE TABLE THAT IS INDEXED ON
# THE ID AND THE ACTUAL NODE VALUE.
#
CREATE TABLE {0}_U (
    ID          BIGINT IDENTITY (1152921504606846977,1),
    VALUE        {7}({4}) {3},
	REF			{6} NOT NULL,
    PRIMARY KEY(ID)
)  {2};


CREATE TABLE {0}_B (
    ID         BIGINT IDENTITY (1,1),
    VALUE        {7}({4}) {3},
	REF			{6} NOT NULL,
    PRIMARY KEY(ID)
)  {2};
#
#
CREATE TABLE {0}_L (
	ID			 BIGINT IDENTITY (2305843009213693953,1),
	VALUE		{7}({4}) {3},
	MODIFIER_ID	{6}  NOT NULL,
	REF			{6} NOT NULL,
	PRIMARY KEY(ID)
)  {2};

# LITERALS ARE COMPLICATED 
#
CREATE TABLE {0}_TL (
	ID			 BIGINT IDENTITY (4611686018427387905,1),
	VALUE		{7}({4}) {3},
	MODIFIER_ID	{6}  NOT NULL,
	REF			{6} NOT NULL,
	PRIMARY KEY(ID)
)  {2};
#
#
#
CREATE TABLE {0}_LL (
	ID			BIGINT IDENTITY (3458764513820540929,1),
	HASH		{6} NOT NULL,
	VALUE		{8},
	MODIFIER_ID	{6},
	REF			{6} NOT NULL,
	PRIMARY KEY	(ID)
) {2};

CREATE TABLE {0}_LTL (
	ID			BIGINT IDENTITY (5764607523034234881,1),
	HASH		{6} NOT NULL,
	VALUE		{8},
	MODIFIER_ID	{6},
	REF			{6} NOT NULL,
	PRIMARY KEY	(ID)
) {2};

CREATE TABLE {0}_USED_IDS (
    ID            {6} NOT NULL,
   	TRANSACTIONID {6} NOT NULL
)  {2};


CREATE TABLE {0}_LU (
	ID			BIGINT IDENTITY (6917529027641081857,1),
	HASH		BIGINT NOT NULL,
	VALUE		NVARCHAR(4000) NOT LOGGED,
	REF			BIGINT NOT NULL,
	PRIMARY KEY(ID)
)   ;

CREATE TABLE {0}_DATATYPE (
	ID			BIGINT IDENTITY (0,1),
	VALUE		{7}({4}) {3},
	PRIMARY KEY(ID)
)  {2} ;

CREATE TABLE {0}_LANGUAGE (
	ID			BIGINT IDENTITY (0,1),
	VALUE		{7}({4}) {3},
	PRIMARY KEY(ID)
)  {2};

