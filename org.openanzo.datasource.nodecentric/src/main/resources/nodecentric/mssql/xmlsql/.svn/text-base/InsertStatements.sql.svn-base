<?xml version="1.0" encoding="UTF-8"?>
<preparedstatements>
    <preparedstatement name="commitRemoveStatementsNR" inputs="+Long transactionId" results="COUNTER" templateParams="String sessionPrefix">
        UPDATE STATEMENTS_NR SET COMMITTED=? 
        FROM {0}STMTS_TMP ST
        WHERE STATEMENTS_NR.COMMITTED=0 AND ST.ID=STATEMENTS_NR.ID AND ST.OPERATION=0 
    </preparedstatement>
     
     <preparedstatement name="commitRemoveStatements" inputs="+Long transactionId" results="COUNTER" templateParams="String sessionPrefix">
        UPDATE STATEMENTS SET 
            COMMITTED=?,
            REND=ST.REVISION 
        FROM {0}STMTS_TMP ST 
        WHERE 
        	STATEMENTS.COMMITTED=0 AND 
            STATEMENTS.REND IS NULL AND 
            ST.OPERATION=0 AND 
            ST.ID=STATEMENTS.ID
    </preparedstatement>
     
     <preparedstatement name="commitRemoveStatementsNRRange" inputs="+Long transactionId,+Long start,+Long end" results="COUNTER" templateParams="String sessionPrefix">
        <![CDATA[
        UPDATE STATEMENTS_NR SET COMMITTED=? FROM 
        FROM {0}STMTS_TMP ST
        WHERE STATEMENTS_NR.COMMITTED=0 AND ST.STMTID >= ? AND ST.STMTID < ? AND ST.OPERATION=0 AND ST.ID=STATEMENTS_NR.ID
       ]]>
    </preparedstatement>
    <preparedstatement name="commitRemoveStatementsRange" inputs="+Long transactionId,+Long start,+Long end" results="COUNTER" templateParams="String sessionPrefix">
        <![CDATA[
        UPDATE STATEMENTS SET 
            COMMITTED=?,
            REND=(SELECT ST.REVISION FROM {0}STMTS_TMP ST WHERE ST.OPERATION=0 AND ST.ID=STATEMENTS.ID) 
        FROM {0}STMTS_TMP ST
        WHERE 
            STATEMENTS.COMMITTED=0 AND STATEMENTS.REND IS NULL AND ST.STMTID >= ? AND ST.STMTID < ? AND ST.OPERATION=0 AND ST.ID=STATEMENTS.ID
         ]]>
    </preparedstatement>
    <preparedstatement name="commitTransactionStatementsRange" inputs="+Long transactionId,+Long start,+Long end" results="COUNTER" templateParams="String sessionPrefix">
        <![CDATA[   
        UPDATE STATEMENTS SET COMMITTED=0 FROM {0}STMT_ID_TMP ST WHERE STATEMENTS.COMMITTED=? AND ST.STMTID>=? AND ST.STMTID < ? AND ST.ID=STATEMENTS.ID 
        ]]>
    </preparedstatement>

    <preparedstatement name="commitTransactionAddStatementsNRRange" inputs="+Long transactionId,+Long start,+Long end" results="COUNTER" templateParams="String sessionPrefix">
        <![CDATA[   
         UPDATE STATEMENTS_NR  SET COMMITTED=0 FROM {0}STMT_ID_TMP ST WHERE STATEMENTS_NR.COMMITTED=? AND  ST.STMTID>=? AND ST.STMTID < ? AND ST.ID=STATEMENTS_NR.ID
         ]]>
    </preparedstatement>
</preparedstatements>