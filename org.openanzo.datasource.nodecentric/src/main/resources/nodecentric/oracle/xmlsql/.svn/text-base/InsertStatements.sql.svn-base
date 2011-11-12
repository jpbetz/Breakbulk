<?xml version="1.0" encoding="UTF-8"?>
<preparedstatements>
     <preparedstatement name="purgeInsertRemoveStatements" results="COUNTER" templateParams="String sessionPrefix">
        DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=0 AND {0}STMTS_TMP.ID IN (SELECT S.ID FROM {0}STMTS_TMP S WHERE S.OPERATION=1)
	</preparedstatement>

     <preparedstatement name="commitRemoveStatements" inputs="+Long transactionId" results="COUNTER" templateParams="String sessionPrefix">
        UPDATE  /*+ index(STATEMENTS,SRHC) */ STATEMENTS SET 
            COMMITTED=?,
            REND=(SELECT  ST.REVISION FROM {0}STMTS_TMP ST WHERE ST.OPERATION=0 AND ST.ID=STATEMENTS.ID) 
        WHERE 
        	COMMITTED=0 AND 
            REND IS NULL AND 
            ID IN (SELECT  ST.ID FROM {0}STMTS_TMP ST WHERE ST.OPERATION=0)
	</preparedstatement>
    
    <preparedstatement name="commitRemoveStatementsRange" inputs="+Long transactionId,+Long start,+Long end" results="COUNTER" templateParams="String sessionPrefix">
        <![CDATA[
        UPDATE  /*+ index(STATEMENTS,SRHC) */ STATEMENTS SET 
            COMMITTED=?,
            REND=(SELECT  ST.REVISION FROM {0}STMTS_TMP ST WHERE ST.OPERATION=0 AND ST.ID=STATEMENTS.ID) 
        WHERE 
        	COMMITTED=0 AND 
            REND IS NULL AND 
            ID IN (SELECT  ST.ID FROM {0}STMTS_TMP ST WHERE ST.STMTID >= ? AND ST.STMTID < ? AND ST.OPERATION=0)
         ]]>
    </preparedstatement>

    <preparedstatement name="commitRemoveStatementsNR" inputs="+Long transactionId" results="COUNTER" templateParams="String sessionPrefix">
        UPDATE  /*+ index(STATEMENTS_NR,SRHC_NR) */ STATEMENTS_NR SET COMMITTED=? WHERE COMMITTED=0 AND ID IN(
        SELECT  ST.ID
        FROM {0}STMTS_TMP ST
        WHERE ST.OPERATION=0 )
	</preparedstatement>
    
    <preparedstatement name="commitRemoveStatementsNRRange" inputs="+Long transactionId,+Long start,+Long end" results="COUNTER" templateParams="String sessionPrefix">
        <![CDATA[
        UPDATE  /*+ index(STATEMENTS_NR,SRHC_NR) */ STATEMENTS_NR SET COMMITTED=? WHERE COMMITTED=0 AND ID IN(
        SELECT  ST.ID
        FROM {0}STMTS_TMP ST
        WHERE ST.STMTID >= ? AND ST.STMTID < ? AND ST.OPERATION=0)
       ]]>
    </preparedstatement>
    
     <preparedstatement name="commitTransactionStatementsRange" inputs="+Long transactionId,+Long start,+Long end" results="COUNTER" templateParams="String sessionPrefix">
        <![CDATA[   
        UPDATE /*+ index(STATEMENTS,SRHC) */ STATEMENTS SET COMMITTED=0 WHERE COMMITTED=? AND STATEMENTS.ID IN (SELECT  ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ? )
        ]]>
    </preparedstatement>

    <preparedstatement name="commitTransactionAddStatementsNRRange" inputs="+Long transactionId,+Long start,+Long end" results="COUNTER" templateParams="String sessionPrefix">
        <![CDATA[   
         UPDATE /*+ index(STATEMENTS,SRHC) */ STATEMENTS_NR  SET COMMITTED=0 WHERE COMMITTED=? AND STATEMENTS_NR.ID IN (SELECT  ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ?)
         ]]>
    </preparedstatement>

    <preparedstatement name="commitTransactionRemoveStatementsNRRange" inputs="+Long transactionId,+Long start,+Long end" results="COUNTER" templateParams="String sessionPrefix">
         <![CDATA[   
         DELETE /*+ index(STATEMENTS_NR,SRHC_NR) */ FROM STATEMENTS_NR WHERE COMMITTED=? AND STATEMENTS_NR.ID IN (SELECT  ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ?)
         ]]>
    </preparedstatement>
    
    <preparedstatement name="abortTransactionAddStatements" inputs="+Long transactionId" results="COUNTER">
        DELETE /*+ index(STATEMENTS,SRHC) */ FROM STATEMENTS WHERE COMMITTED=?
	</preparedstatement>

    <preparedstatement name="abortTransactionRemoveStatements" inputs="+Long transactionId" results="COUNTER" templateParams="String bigInt">
        UPDATE /*+ index(STATEMENTS,SRHC) */ STATEMENTS SET REND=CAST(NULL AS {0}),COMMITTED=0 WHERE COMMITTED=?
	</preparedstatement>

    <preparedstatement name="abortTransactionAddStatementsNR" inputs="+Long transactionId" results="COUNTER">
        DELETE /*+ index(STATEMENTS_NR,SRHC_NR) */ FROM STATEMENTS_NR WHERE COMMITTED=?
	</preparedstatement>

    <preparedstatement name="abortTransactionRemoveStatementsNR" inputs="+Long transactionId" results="COUNTER">
        UPDATE /*+ index(STATEMENTS_NR,SRHC_NR) */ STATEMENTS_NR SET COMMITTED=0 WHERE COMMITTED=?
	</preparedstatement>
    
     <preparedstatement name="abortTransactionAddStatementsRange" inputs="+Long transactionId,+Long start,+Long end" results="COUNTER" templateParams="String sessionPrefix" >
         <![CDATA[   
         DELETE /*+ index(STATEMENTS,SRHC) */ FROM STATEMENTS WHERE COMMITTED=? AND STATEMENTS.ID IN  (SELECT  ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ?)
        ]]>
    </preparedstatement>

    <preparedstatement name="abortTransactionRemoveStatementsRange" inputs="+Long transactionId,+Long start,+Long end" results="COUNTER" templateParams="String bigInt,String sessionPrefix" >
         <![CDATA[   
         UPDATE /*+ index(STATEMENTS,SRHC) */ STATEMENTS SET REND=CAST(NULL AS {0}),COMMITTED=0 WHERE COMMITTED=? AND ST.ID=STATEMENTS.ID IN (SELECT  ST.ID FROM  {1}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ?)
        ]]>
    </preparedstatement>

    <preparedstatement name="abortTransactionAddStatementsNRRange" inputs="+Long transactionId,+Long start,+Long end" results="COUNTER" templateParams="String sessionPrefix" >
         <![CDATA[   
         DELETE /*+ index(STATEMENTS_NR,SRHC_NR) */ FROM STATEMENTS_NR WHERE COMMITTED=? AND STATEMENTS.ID IN (SELECT  ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ? )
        ]]>
    </preparedstatement>

    <preparedstatement name="abortTransactionRemoveStatementsNRRange" inputs="+Long transactionId,+Long start,+Long end" results="COUNTER" templateParams="String sessionPrefix">
         <![CDATA[   
         UPDATE /*+ index(STATEMENTS_NR,SRHC_NR) */ STATEMENTS_NR SET COMMITTED=0 WHERE COMMITTED=? AND STATEMENTS.ID IN (SELECT  ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ?)
        ]]>
    </preparedstatement>
    
     <preparedstatement name="commitTransactionStatements" inputs="+Long transactionId" results="COUNTER">
        UPDATE /*+ index(STATEMENTS,SNG) */ STATEMENTS SET COMMITTED=0 WHERE COMMITTED=?
	</preparedstatement>

    <preparedstatement name="commitTransactionAddStatementsNR" inputs="+Long transactionId" results="COUNTER">
        UPDATE /*+ index(STATEMENTS_NR,SRHC_NR) */ STATEMENTS_NR SET COMMITTED=0 WHERE COMMITTED=?
	</preparedstatement>

    <preparedstatement name="commitTransactionRemoveStatementsNR" inputs="+Long transactionId" results="COUNTER">
        DELETE /*+ index(STATEMENTS_NR,SRHC_NR) */ FROM STATEMENTS_NR WHERE COMMITTED=?
	</preparedstatement>

    <preparedstatement name="commitTransactionNamedGraphs" inputs="+Long transactionId" results="COUNTER">
        UPDATE /*+ index(NAMEDGRAPHS,NG_UUDI) */ NAMEDGRAPHS SET COMMITTED=0 WHERE COMMITTED=?
	</preparedstatement>

    <preparedstatement name="commitTransactionAddNamedGraphsNR" inputs="+Long transactionId" results="COUNTER">
        UPDATE /*+ index(NAMEDGRAPHS_NR,NG_C_NR) */ NAMEDGRAPHS_NR SET COMMITTED=0 WHERE COMMITTED=?
	</preparedstatement>

    <preparedstatement name="commitTransactionRemoveNamedGraphsNR" inputs="+Long transactionId" results="COUNTER">
        DELETE /*+ index(NAMEDGRAPHS_NR,NG_C_NR) */ FROM NAMEDGRAPHS_NR WHERE COMMITTED=?
	</preparedstatement>
	
	<preparedstatement name="purgeInsertStatements" results="COUNTER" templateParams="String sessionPrefix">
        DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=1 AND  EXISTS (SELECT /*+ index(S,SRHC) */ NULL FROM STATEMENTS S WHERE S.ID={0}STMTS_TMP.ID AND S.COMMITTED=0 AND S.REND IS NULL)
	</preparedstatement>

    <preparedstatement name="purgeRemoveStatements" results="COUNTER" templateParams="String sessionPrefix">
        DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=0 AND  NOT EXISTS(SELECT /*+ index(S,SRHC) */ NULL FROM STATEMENTS S WHERE S.ID={0}STMTS_TMP.ID AND S.COMMITTED=0  AND S.REND IS NULL)
	</preparedstatement>

    <preparedstatement name="purgeInsertStatementsNR" results="COUNTER" templateParams="String sessionPrefix">
        DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=1 AND  EXISTS (SELECT /*+ index(STATEMENTS_NR,SRHC_NR) */ NULL FROM STATEMENTS_NR S WHERE S.ID={0}STMTS_TMP.ID AND S.COMMITTED=0)
	</preparedstatement>

    <preparedstatement name="purgeRemoveStatementsNR" results="COUNTER" templateParams="String sessionPrefix">
        DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=0 AND NOT EXISTS (SELECT /*+ index(STATEMENTS_NR,SRHC_NR) */ NULL FROM STATEMENTS_NR S WHERE S.ID={0}STMTS_TMP.ID AND S.COMMITTED=0)
	</preparedstatement>
	
</preparedstatements>