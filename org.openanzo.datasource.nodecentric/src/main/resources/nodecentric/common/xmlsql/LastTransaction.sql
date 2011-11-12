<?xml version="1.0" encoding="UTF-8"?>
<!--
#*******************************************************************************
# Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
#  File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/sql/nodecentric/common/xmlsql/LastTransaction.sql,v $
# Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
# Created on:  9/30/05
# Revision:	$Id: LastTransaction.sql 229 2007-08-07 15:22:00Z mroy $
# 
# Contributors:
#     IBM Corporation - initial API and implementation
#     Cambridge Semantics Incorporated - Fork to Anzo
#*******************************************************************************
-->
<preparedstatements>
	
	<preparedstatement name="getLastTransactionTime" outputs="Long lastTransactionTime" results="VALUE">
		SELECT COMMITED FROM LASTTRANSACTIONTIME
	</preparedstatement>
	
	<preparedstatement name="getLastTransaction" outputs="Long lastTransactionTime" results="VALUE">
		SELECT COMMITED FROM LASTTRANSACTIONTIME WHERE ID=0
	</preparedstatement>
	
	<preparedstatement name="insertLastTransactionTime" results="COUNTER"  inputs="+Long commited">
		UPDATE LASTTRANSACTIONTIME SET COMMITED=? WHERE ID=0
	</preparedstatement>
	
	<preparedstatement name="insertFirstTransactionTime" results="COUNTER"  inputs="+Long commited">
		INSERT INTO LASTTRANSACTIONTIME (ID,COMMITED)VALUES(0,?)
	</preparedstatement>

	<preparedstatement name="insertTransaction" results="COUNTER"  inputs="+Long id,+String serverId,+Long transactionUriId,String transactionContext">
		INSERT INTO TRANSACTIONTIME (ID,COMMITED,SERVERID,URI,CONTEXT) VALUES(?,-1,?,?,?)
	</preparedstatement>

	<preparedstatement name="updateTransaction" inputs="+Long id,+Long commited" results="COUNTER" >
		UPDATE TRANSACTIONTIME SET COMMITED=? WHERE ID=?
	</preparedstatement>
	
	<preparedstatement name="purgeTransactions" inputs="+String serverId" results="COUNTER" >
		DELETE FROM TRANSACTIONTIME WHERE SERVERID=? AND COMMITED=-1
	</preparedstatement>
	
	<preparedstatement name="abortTransactions" inputs="+Long transactionId" results="COUNTER" >
		DELETE FROM TRANSACTIONTIME WHERE ID= ?
	</preparedstatement>
	
	<preparedstatement name="selectUncommitedTransactions" inputs="String serverId" outputs="Long id" results="ITERATOR" >
		SELECT ID FROM TRANSACTIONTIME WHERE SERVERID=? AND COMMITED =-1
	</preparedstatement>

	<preparedstatement name="selectUnactivatedTransactions" inputs="String serverId" outputs="Long id" results="ITERATOR">
		SELECT ID FROM TRANSACTIONTIME WHERE SERVERID=? AND COMMITED =0
	</preparedstatement>
	
	<preparedstatement name="selectCurrentTimestamp" outputs="Timestamp timestamp,Long lastTime" results="ROW">NULL</preparedstatement>

</preparedstatements>