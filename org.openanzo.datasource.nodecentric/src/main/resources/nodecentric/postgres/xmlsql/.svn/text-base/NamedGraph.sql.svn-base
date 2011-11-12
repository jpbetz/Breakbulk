<?xml version="1.0" encoding="UTF-8"?>
<!--
#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/sql/nodecentric/common/xmlsql/NamedGraph.sql,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: NamedGraph.sql 180 2007-07-31 14:24:13Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
-->
<preparedstatements>  
	<preparedstatement name="deleteStatementsForNamedGraphBatch" results="COUNTER" templateParams="String sessionPrefix,String tableName">
        UPDATE STATEMENTS SET REND={0}{1}.REND 
        FROM {0}{1} WHERE 
        WHERE 
        STATEMENTS.REND IS NULL AND 
        {0}{1}.TYPE=0 AND 
        {0}{1}.ID=STATEMENTS.NAMEDGRAPHID;
    </preparedstatement>
</preparedstatements>
