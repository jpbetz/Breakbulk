#*******************************************************************************
# Copyright (c) 2004, 2008 IBM Corporation and Cambridge Semantics Incorporated.
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
#Index for STATEMENTS table
CREATE INDEX SRUUID ON STATEMENTS (UUID,COMMITTED);
CREATE INDEX SRHS ON STATEMENTS (SUBJECT,PREDICATE,REND,COMMITTED);
CREATE INDEX SRHP ON STATEMENTS (PREDICATE,REND,COMMITTED);
CREATE INDEX SRHPO ON STATEMENTS (PREDICATE,OBJECT,REND,COMMITTED);
CREATE INDEX SRHO ON STATEMENTS (OBJECT,REND,COMMITTED);
CREATE INDEX SRHC ON STATEMENTS (COMMITTED,ID);
CREATE INDEX SRIE ON STATEMENTS (REND,ID);
CREATE INDEX SMETA ON STATEMENTS (METADATA);
CREATE INDEX SNG ON STATEMENTS (COMMITTED,REND,NAMEDGRAPHID) ;
CREATE INDEX SRHSSPOIO ON STATEMENTS (NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT,METADATA,REND,RSTART,ID);

#Index for STATEMENTS_NR table
CREATE INDEX SRHSSPOIO_NR ON STATEMENTS_NR (NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT,METADATA,ID);
CREATE INDEX SRMETA_NR ON STATEMENTS_NR (METADATA);
CREATE INDEX SRHS_NR ON STATEMENTS_NR (SUBJECT);
CREATE INDEX SRHP_NR ON STATEMENTS_NR (PREDICATE);
CREATE INDEX SRHO_NR ON STATEMENTS_NR (OBJECT);
CREATE INDEX SRHC_NR ON STATEMENTS_NR (COMMITTED);

#Index for NAMEDGRAPHS table
CREATE INDEX NG_ITRM ON NAMEDGRAPHS (ID,HEND,COMMITTED,HSTART,REVISION,METAID);
CREATE INDEX NG_MH ON NAMEDGRAPHS (METAID,HEND,HSTART, ID);
CREATE INDEX NG_C ON NAMEDGRAPHS (COMMITTED);
CREATE INDEX NG_RHI ON NAMEDGRAPHS(REVISION,HSTART,ID);
CREATE INDEX NG_UUID ON NAMEDGRAPHS(UUID,HEND,ID);
CREATE INDEX NG_LM ON NAMEDGRAPHS(LASTMODIFIEDBY);
CREATE INDEX NG_UUDI ON NAMEDGRAPHS (ID,COMMITTED,HEND,UUID);

#Index for NAMEDGRAPHS_NR table
CREATE INDEX NG_IHR_NR ON NAMEDGRAPHS_NR (ID,COMMITTED,HSTART,REVISION);
CREATE INDEX NG_M_NR ON NAMEDGRAPHS_NR (METAID);
CREATE INDEX NG_RH_NR ON NAMEDGRAPHS_NR(REVISION,HSTART);
CREATE INDEX NG_UUIDR ON NAMEDGRAPHS_NR(UUID,ID);
CREATE INDEX NG_LMR ON NAMEDGRAPHS_NR(LASTMODIFIEDBY);
CREATE INDEX NG_C_NR ON NAMEDGRAPHS_NR (COMMITTED);

#Index for LASTTRANSACTIONTIME table
CREATE INDEX LTT ON LASTTRANSACTIONTIME (ID,COMMITED);
CREATE INDEX LTT4 ON LASTTRANSACTIONTIME (COMMITED,ID);

#Index for TRANSACTIONTIME table
CREATE INDEX TID ON TRANSACTIONTIME (ID,COMMITED);
CREATE INDEX TCIU ON TRANSACTIONTIME (COMMITED,ID,URI);
CREATE INDEX TCSID ON TRANSACTIONTIME(SERVERID,COMMITED);

#Index for _U table
CREATE UNIQUE INDEX {0}_U_V ON {0}_U(VALUE);
CREATE INDEX {0}_U_RI ON {0}_U(REF DESC,ID);
CREATE INDEX {0}_U_RV ON {0}_U(REF ,VALUE);

#Index for _LU table
CREATE INDEX {0}_LU_V ON {0}_LU(HASH,ID);
CREATE INDEX {0}_LU_RI ON {0}_LU(REF DESC,ID);

#Index for _L table
CREATE UNIQUE INDEX {0}_L_V ON {0}_L(VALUE,MODIFIER_ID);
CREATE INDEX {0}_L_RI ON {0}_L(REF DESC,ID);
CREATE INDEX {0}_L_RV ON {0}_L(REF ,MODIFIER_ID,VALUE);

#Index for _TL table
CREATE UNIQUE INDEX {0}_TL_V ON {0}_TL(VALUE,MODIFIER_ID);
CREATE INDEX {0}_TL_RI ON {0}_TL(REF DESC,ID);
CREATE INDEX {0}_TL_RV ON {0}_TL(REF ,MODIFIER_ID,VALUE);

#Index for _LL table
CREATE INDEX {0}_LL_V ON {0}_LL(HASH,MODIFIER_ID);
CREATE INDEX {0}_LL_RI ON {0}_LL(REF DESC,ID);

#Index for _LTL table
CREATE INDEX {0}_LTL_V ON {0}_LTL(HASH,MODIFIER_ID);
CREATE INDEX {0}_LTL_RI ON {0}_LTL(REF DESC,ID);


#Index for _B table
CREATE UNIQUE INDEX {0}_B_V ON {0}_B(VALUE);
CREATE INDEX {0}_B_RI ON {0}_B(REF DESC,ID);
CREATE INDEX {0}_B_RV ON {0}_B(REF ,VALUE);

CREATE INDEX {0}_UIDS_TI ON 	{0}_USED_IDS(TRANSACTIONID,ID)   {1};
CREATE INDEX {0}_UIDS_IT ON 	{0}_USED_IDS(ID,TRANSACTIONID)   {1};

CREATE UNIQUE INDEX LOCKEDS ON LOCKED_GRAPHS(TRANSACTIONID,ID);
CREATE UNIQUE INDEX LOCKEDID ON LOCKED_GRAPHS(ID);

CREATE UNIQUE INDEX QG_DSID_ID ON QUERY_GRAPHS(DSID,ID);
#CREATE INDEX QG_SERVERID ON QUERY_GRAPHS(SERVERID);

CREATE UNIQUE INDEX {0}_DATATYPE_VI ON {0}_DATATYPE(VALUE,ID)  {1};
CREATE UNIQUE INDEX {0}_DATATYPE_IV ON {0}_DATATYPE(ID,VALUE)  {1};

CREATE UNIQUE INDEX {0}_LANGUAGE_VI ON {0}_LANGUAGE(VALUE,ID)  {1};
CREATE UNIQUE INDEX {0}_LANGUAGE_IV ON {0}_LANGUAGE(ID,VALUE)  {1} ;

