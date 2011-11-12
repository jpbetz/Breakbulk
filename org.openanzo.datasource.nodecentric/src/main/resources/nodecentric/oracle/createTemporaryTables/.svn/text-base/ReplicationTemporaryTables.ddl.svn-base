#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/sql/nodecentric/postgres/createBocaTemporaryTables/Attic/ReplicationTemporaryTables.ddl,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: ReplicationTemporaryTables.ddl 180 2007-07-31 14:24:13Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
#
#
CREATE GLOBAL TEMPORARY TABLE NGR_TMP(
ID 				{6},
METAID			{6},
REVISION 		{6},
NEW_REVISION	{6},
UUID			{6}
) ON COMMIT PRESERVE ROWS ;

CREATE GLOBAL TEMPORARY TABLE STMTS_REP_TMP (
ID					{7}({4}) {3} NOT NULL,
NAMEDGRAPHID		{6},
SUBJECT    			{6},
PREDICATE  			{6},
OBJECT     			{6},
RSTART				{6},
REND				{6}
) ON COMMIT PRESERVE ROWS ;
