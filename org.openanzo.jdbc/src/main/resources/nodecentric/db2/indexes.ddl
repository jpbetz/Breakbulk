#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/sql/nodecentric/db2/initGraphTables/initGraphTables.ddl,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: initGraphTables.ddl 178 2007-07-31 14:22:33Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
#


ALTER TABLE {0}_U VOLATILE;
CREATE UNIQUE INDEX {0}_U_V_I ON {0}_U(ID)   INCLUDE (VALUE)  {1};
CREATE UNIQUE INDEX {0}_U_V ON {0}_U(VALUE) INCLUDE (ID) {1} ;


ALTER TABLE {0}_B VOLATILE;
CREATE UNIQUE INDEX {0}_B_V_I ON {0}_B(ID)    INCLUDE (VALUE)  {1};
CREATE UNIQUE INDEX {0}_B_V ON {0}_B(VALUE)   INCLUDE (ID)  {1} ;


ALTER TABLE {0}_L VOLATILE;
CREATE UNIQUE INDEX {0}_L_V_I ON {0}_L(ID)   INCLUDE (VALUE,LANG)  {1};
CREATE UNIQUE INDEX {0}_L_V ON {0}_L(VALUE,LANG)  INCLUDE (ID)  {1} ;

ALTER TABLE {0}_TL VOLATILE;
CREATE UNIQUE INDEX {0}_TL_V_I ON {0}_TL(ID)   INCLUDE (VALUE,TYPE)  {1};
CREATE UNIQUE INDEX {0}_TL_V ON {0}_TL(VALUE,TYPE)  INCLUDE (ID)  {1} ;

ALTER TABLE {0}_LL VOLATILE;
CREATE UNIQUE INDEX {0}_LL_MHI ON {0}_LL(LANG,HASH,ID)   ALLOW REVERSE SCANS ;
CREATE UNIQUE INDEX {0}_LL_I ON {0}_LL(ID)   ALLOW REVERSE SCANS ;

ALTER TABLE {0}_LTL VOLATILE;
CREATE UNIQUE INDEX {0}_LTL_MHI ON {0}_LTL(TYPE,HASH,ID)   ALLOW REVERSE SCANS ;
CREATE UNIQUE INDEX {0}_LTL_I ON {0}_LTL(ID)   ALLOW REVERSE SCANS ;

ALTER TABLE {0}_LU VOLATILE;
CREATE UNIQUE INDEX {0}_LU_HI ON {0}_LU(HASH,ID)    ALLOW REVERSE SCANS ;
CREATE UNIQUE INDEX {0}_LU_I ON {0}_LU(ID)  ALLOW REVERSE SCANS ;


ALTER TABLE {0}_S VOLATILE;
CREATE INDEX {0}_S_S ON 	{0}_S(SUBJ,PROP)   {1};
CREATE INDEX {0}_S_P ON 	{0}_S(PROP,OBJ)   {1};
CREATE INDEX {0}_S_O ON 	{0}_S(OBJ)   {1};
CREATE UNIQUE INDEX {0}_S_SPOI ON {0}_S(METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ)   {1};


CREATE INDEX {0}_UIDS_TI ON 	{0}_USED_IDS(TRANSACTIONID,ID)   {1};
CREATE INDEX {0}_UIDS_IT ON 	{0}_USED_IDS(ID,TRANSACTIONID)   {1};

ALTER TABLE {0}_DATATYPE VOLATILE;
CREATE UNIQUE INDEX {0}_DATATYPE_IV ON {0}_DATATYPE(ID)   INCLUDE (VALUE)  {1};
CREATE UNIQUE INDEX {0}_DATATYPE_VI ON {0}_DATATYPE(VALUE)   INCLUDE(ID)  {1};

ALTER TABLE {0}_LANGUAGE VOLATILE;
CREATE UNIQUE INDEX {0}_LANGUAGE_IV ON {0}_LANGUAGE(ID)    INCLUDE(VALUE)  {1} ;
CREATE UNIQUE INDEX {0}_LANGUAGE_VI ON {0}_LANGUAGE(VALUE)    INCLUDE(ID)  {1};

