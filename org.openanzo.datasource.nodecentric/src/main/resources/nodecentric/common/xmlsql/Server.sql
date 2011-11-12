<?xml version="1.0" encoding="UTF-8"?>
<!--
#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/sql/nodecentric/common/xmlsql/Server.sql,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: Server.sql 180 2007-07-31 14:24:13Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
-->
<preparedstatements>
	<preparedstatement name="setInitialized" inputs="+Long id"  results="COUNTER">
		UPDATE SERVER SET ID=?,INITIALIZED=1 WHERE INITIALIZED>1;
	</preparedstatement>	
	
	<preparedstatement name="setServerId" inputs="+Long id"  results="COUNTER">
		UPDATE SERVER SET ID=? WHERE INITIALIZED=1;
	</preparedstatement>	
	
	<preparedstatement name="getServerId" outputs="Long id"  results="VALUE">
		SELECT ID FROM SERVER;
	</preparedstatement>	
	
	<preparedstatement name="getServerVersion" outputs="Long id"  results="VALUE">
		SELECT VERSION FROM SERVER;
	</preparedstatement>	
	
	<preparedstatement name="setServerVersion" inputs="+Long version"  results="COUNTER">
		UPDATE SERVER SET VERSION=? WHERE INITIALIZED=1;
	</preparedstatement>	
	
	<preparedstatement name="getInitialized" outputs="Long id"  results="VALUE">
		SELECT INITIALIZED FROM SERVER;
	</preparedstatement>
	
	<preparedstatement name="setInitializing" inputs="+Long timer" results="COUNTER">
		UPDATE SERVER SET INITIALIZED=?
	</preparedstatement>	
	
	<preparedstatement name="setInitializingFailed" results="COUNTER">
		UPDATE SERVER SET INITIALIZED=NULL
	</preparedstatement>
	
	<preparedstatement name="lockTable"  templateParams="String tableName,String tableLocksExtra" >
		LOCK TABLE {0} {1}
	</preparedstatement>
	<preparedstatement name="unlockTable"  templateParams="String tableName" >
		EMPTY
	</preparedstatement>

	<preparedstatement name="stats" templateParams="String tablename" >
		EMPTY
	</preparedstatement>
	
</preparedstatements>