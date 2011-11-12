#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/sql/nodecentric/hsql/initDBtables/Attic/BocaTables.ddl,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: RepositoryTables.ddl 180 2007-07-31 14:24:13Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
#
#
# Statements table 
CREATE TABLE STATEMENTS (      
        ID  	  	            {7}({4}) {3} NOT NULL ,
        METADATA				{5} NOT NULL,
        UUID					{6} NOT NULL,
    	NAMEDGRAPHID			{6} NOT NULL,
        SUBJECT    				{6} NOT NULL,
		PREDICATE  				{6} NOT NULL,
		OBJECT     				{6} NOT NULL,
		RSTART	                {6} NOT NULL,
        REND					{6} ,
        COMMITTED               {6} NOT NULL 
);

CREATE TABLE STATEMENTS_NR (      
        ID  	  	            {7}({4}) {3} NOT NULL ,
        METADATA				{5} NOT NULL,
        NAMEDGRAPHID			{6} NOT NULL,
        SUBJECT    				{6} NOT NULL,
		PREDICATE  				{6} NOT NULL,
		OBJECT     				{6} NOT NULL,
        COMMITTED               {6} NOT NULL,
        PRIMARY KEY				(ID)
);

#NamedGraphs
CREATE TABLE NAMEDGRAPHS (
        ID              {6} NOT NULL,
        METAID			{6} NOT NULL,
        UUID			{6} NOT NULL,
        REVISION		{6} NOT NULL,
        HSTART	        {6} NOT NULL,
        HEND	        {6},
        LASTMODIFIEDBY	{6} NOT NULL,
        COMMITTED       {6} NOT NULL,
        PRIMARY KEY		(UUID,REVISION)
);

#NamedGraphs
CREATE TABLE NAMEDGRAPHS_NR (
        ID              {6} NOT NULL,
        METAID			{6} NOT NULL,
        UUID			{6} NOT NULL,
        REVISION		{6} NOT NULL,
        HSTART	        {6} NOT NULL,
        LASTMODIFIEDBY	{6} NOT NULL,
        COMMITTED       {6} NOT NULL,
        PRIMARY KEY		(UUID,REVISION)
);

# LASTCHANGETABLE
CREATE TABLE LASTTRANSACTIONTIME (
		ID				{6} NOT NULL,
		COMMITED		{6} NOT NULL,
		PRIMARY KEY (ID)
);

# LASTCHANGETABLE
CREATE TABLE TRANSACTIONTIME (
		ID				{6} NOT NULL,
		SERVERID		{7}({4}) {3} NOT NULL,
		COMMITED		{6},
		URI				{6},
		CONTEXT			{8},
		PRIMARY KEY (ID)
);

#NamedGraphs
CREATE TABLE LOCKED_GRAPHS (
        ID              {6} NOT NULL,
        TRANSACTIONID {6} NOT NULL,
        PRIMARY KEY		(ID)
);

CREATE TABLE QUERY_GRAPHS(
		ID			{6} NOT NULL,
		DSID		{6} NOT NULL,
		PRIMARY KEY (ID,DSID)
);