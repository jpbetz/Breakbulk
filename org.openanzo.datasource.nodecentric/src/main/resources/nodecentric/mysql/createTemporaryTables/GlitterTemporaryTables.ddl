#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/sql/nodecentric/mysql/createBocaTemporaryTables/Attic/GlitterTemporaryTables.ddl,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: GlitterTemporaryTables.ddl 229 2007-08-07 15:22:00Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
#
#
CREATE TEMPORARY TABLE IF NOT EXISTS DEFAULTGRAPHS_TMP ( 
  ID {6} NOT NULL 
) ENGINE=MEMORY;


CREATE TEMPORARY TABLE IF NOT EXISTS NAMEDGRAPHS_TMP ( 
  ID {6} NOT NULL  
)  ENGINE=MEMORY;


CREATE TEMPORARY TABLE IF NOT EXISTS TEMPGRAPHS ( 
  ID {6} NOT NULL 
)  ENGINE=MYISAM;

CREATE TEMPORARY TABLE IF NOT EXISTS TEMPGRAPHS1 ( 
  ID {6} NOT NULL 
)  ENGINE = MERGE UNION=(TEMPGRAPHS);

CREATE TEMPORARY TABLE IF NOT EXISTS TEMP_COLUMNS(
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
)ENGINE=MEMORY;