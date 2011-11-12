#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/sql/nodecentric/postgres/createBocaTemporaryTables/Attic/GlitterTemporaryTables.ddl,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: GlitterTemporaryTables.ddl 180 2007-07-31 14:24:13Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
#
#
CREATE GLOBAL TEMPORARY TABLE DEFAULTGRAPHS_TMP ( 
  ID {6} NOT NULL 
) ON COMMIT PRESERVE ROWS;

#CREATE INDEX DEFAULTGRAPHS_IDX ON DEFAULTGRAPHS_TMP (ID);

CREATE GLOBAL TEMPORARY TABLE NAMEDGRAPHS_TMP ( 
  ID {6} NOT NULL 
) ON COMMIT PRESERVE ROWS;

#CREATE INDEX NAMEDGRAPHS_IDX ON NAMEDGRAPHS_TMP (ID);

CREATE GLOBAL TEMPORARY TABLE TEMPGRAPHS ( 
  ID {6} NOT NULL 
) ON COMMIT PRESERVE ROWS;

#CREATE INDEX TEMPGRAPHS_IDX ON TEMPGRAPHS (ID);

CREATE GLOBAL TEMPORARY TABLE TEMP_COLUMNS(
	C0				{6},
	C1				{6},
	C2				{6},
	C3				{6},
	C4				{6},
	C5				{6},
	C6				{6},
	C7				{6},
	C8				{6},
	C9				{6},
	C10				{6},
	C11				{6},
	C12				{6},
	C13				{6},
	C14				{6},
	C15				{6}
)ON COMMIT PRESERVE ROWS;
#CREATE INDEX TEMPC0_IDX ON TEMP_COLUMNS (C0);
#CREATE INDEX TEMPC1_IDX ON TEMP_COLUMNS (C1);
#CREATE INDEX TEMPC2_IDX ON TEMP_COLUMNS (C2);

CREATE GLOBAL TEMPORARY TABLE TEMP_CONSTRAINT0(
	ID				{6}
)ON COMMIT PRESERVE ROWS;
#CREATE INDEX CONSTRAINT0_IDX ON TEMP_CONSTRAINT0 (ID);

CREATE GLOBAL TEMPORARY TABLE TEMP_CONSTRAINT1(
	ID				{6}
)ON COMMIT PRESERVE ROWS;
#CREATE INDEX CONSTRAINT1_IDX ON TEMP_CONSTRAINT1 (ID);

CREATE GLOBAL TEMPORARY TABLE TEMP_CONSTRAINT2(
	ID				{6}
)ON COMMIT PRESERVE ROWS;
#CREATE INDEX CONSTRAINT2_IDX ON TEMP_CONSTRAINT2 (ID);

CREATE GLOBAL TEMPORARY TABLE TEMP_CONSTRAINT3(
	ID				{6}
)ON COMMIT PRESERVE ROWS;
#CREATE INDEX CONSTRAINT3_IDX ON TEMP_CONSTRAINT3 (ID);