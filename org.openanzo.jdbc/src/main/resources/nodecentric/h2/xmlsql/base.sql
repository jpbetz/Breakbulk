<?xml version="1.0" encoding="UTF-8"?>
<!--
#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.common/sql/nodecentric/common/xmlsql/base.sql,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: base.sql 178 2007-07-31 14:22:33Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
-->
<preparedstatements>

    <!--
        truncate table which may or may not commit open transaction
    -->
    <preparedstatement name="truncateTableMayCommit" templateParams="+String tableName">
        TRUNCATE TABLE {0}
    </preparedstatement>
       <!--
        truncate table which may or may not commit open transaction
    -->
    <preparedstatement name="truncateTableWithSessionMayCommit" templateParams="+String sessionPrefix,+String tableName">
        TRUNCATE TABLE {0}{1}
    </preparedstatement>
	
</preparedstatements>