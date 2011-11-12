#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/sql/nodecentric/db2/initDBtables/tempTables.ddl,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: tempTables.ddl 178 2007-07-31 14:22:33Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
#
CREATE  USER TEMPORARY  TABLESPACE USR_TBSP_RDB PAGESIZE 4 K  MANAGED BY AUTOMATIC STORAGE EXTENTSIZE 16 OVERHEAD 12.67 PREFETCHSIZE 16 TRANSFERRATE 0.18;