/*******************************************************************************
 * Copyright (c) 2004, 2007-2009 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Created by:  Generated Source from org.openanzo.jdbc.utils.opgen.jet
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *	   Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.datasource.nodecentric.sql;
// allow for all types that can be returned from a resultset

/**
 *	InsertStatementsRdbWrapper provides wrappers around SQL queries and transforms ResultSets into java objects
 *
 *	@author Generated Source from org.openanzo.jdbc.utils.opgen.jet
 */
public class InsertStatementsRdbWrapper {
	private static final org.slf4j.Logger                           log                   = org.slf4j.LoggerFactory.getLogger(InsertStatementsRdbWrapper.class);
	static final long CUTOFF=5;

	/**
	  *Constant "getTempTablespaceDefined" used to reference prepared statement  InsertStatements.getTempTablespaceDefined
	  *
	  * <code>
	  *          SELECT COUNT(1) FROM SYSIBM.SYSTABLESPACES WHERE TBSPACE=''USR_TBSP'' 	
	  * </code>
	  */
	public static final String getTempTablespaceDefined = "InsertStatements.getTempTablespaceDefined";

	/**
	  *Constant "insertTempStatement" used to reference prepared statement  InsertStatements.insertTempStatement
	  *
	  * <code>
	  *          INSERT INTO {0}STMTS_TMP(OPERATION,STMTID,ID,METADATA,UUID,NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT,REVISION,COMMITTED) VALUES(?,?,?,?,?,?,?,?,?,?,?) 	
	  * </code>
	  */
	public static final String insertTempStatement = "InsertStatements.insertTempStatement";

	/**
	  *Constant "selectInsertStatements" used to reference prepared statement  InsertStatements.selectInsertStatements
	  *
	  * <code>
	  *          SELECT         ST.STMTID,         ST.OPERATION         FROM {0}STMTS_TMP ST 	
	  * </code>
	  */
	public static final String selectInsertStatements = "InsertStatements.selectInsertStatements";

	/**
	  *Constant "purgeInsertRemoveStatements" used to reference prepared statement  InsertStatements.purgeInsertRemoveStatements
	  *
	  * <code>
	  *          DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=0 AND {0}STMTS_TMP.ID IN (SELECT S.ID FROM {0}STMTS_TMP S WHERE S.OPERATION=1) 	
	  * </code>
	  */
	public static final String purgeInsertRemoveStatements = "InsertStatements.purgeInsertRemoveStatements";

	/**
	  *Constant "purgeInsertStatements" used to reference prepared statement  InsertStatements.purgeInsertStatements
	  *
	  * <code>
	  *          DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=1 AND EXISTS (SELECT S.ID FROM STATEMENTS S WHERE S.ID={0}STMTS_TMP.ID AND S.COMMITTED=0 AND S.REND IS NULL) 	
	  * </code>
	  */
	public static final String purgeInsertStatements = "InsertStatements.purgeInsertStatements";

	/**
	  *Constant "purgeRemoveStatements" used to reference prepared statement  InsertStatements.purgeRemoveStatements
	  *
	  * <code>
	  *          DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=0 AND NOT EXISTS (SELECT S.ID FROM STATEMENTS S WHERE S.ID={0}STMTS_TMP.ID AND S.COMMITTED=0  AND S.REND IS NULL) 	
	  * </code>
	  */
	public static final String purgeRemoveStatements = "InsertStatements.purgeRemoveStatements";

	/**
	  *Constant "purgeInsertStatementsNR" used to reference prepared statement  InsertStatements.purgeInsertStatementsNR
	  *
	  * <code>
	  *          DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=1 AND EXISTS (SELECT S.ID FROM STATEMENTS_NR S WHERE S.ID={0}STMTS_TMP.ID AND S.COMMITTED=0) 	
	  * </code>
	  */
	public static final String purgeInsertStatementsNR = "InsertStatements.purgeInsertStatementsNR";

	/**
	  *Constant "purgeRemoveStatementsNR" used to reference prepared statement  InsertStatements.purgeRemoveStatementsNR
	  *
	  * <code>
	  *          DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=0 AND NOT EXISTS (SELECT S.ID FROM STATEMENTS_NR S WHERE S.ID={0}STMTS_TMP.ID AND S.COMMITTED=0) 	
	  * </code>
	  */
	public static final String purgeRemoveStatementsNR = "InsertStatements.purgeRemoveStatementsNR";

	/**
	  *Constant "countInsertStatements" used to reference prepared statement  InsertStatements.countInsertStatements
	  *
	  * <code>
	  *          SELECT COUNT(1) FROM {0}STMTS_TMP WHERE OPERATION=1 	
	  * </code>
	  */
	public static final String countInsertStatements = "InsertStatements.countInsertStatements";

	/**
	  *Constant "countRemoveStatements" used to reference prepared statement  InsertStatements.countRemoveStatements
	  *
	  * <code>
	  *          SELECT COUNT(1) FROM {0}STMTS_TMP WHERE OPERATION=0 	
	  * </code>
	  */
	public static final String countRemoveStatements = "InsertStatements.countRemoveStatements";

	/**
	  *Constant "commitStatementIds" used to reference prepared statement  InsertStatements.commitStatementIds
	  *
	  * <code>
	  *          INSERT INTO {0}STMT_ID_TMP(ID,STMTID)         SELECT DISTINCT         {0}STMTS_TMP.ID,         {0}STMTS_TMP.STMTID         FROM {0}STMTS_TMP     
	  * </code>
	  */
	public static final String commitStatementIds = "InsertStatements.commitStatementIds";

	/**
	  *Constant "selectStatementIds" used to reference prepared statement  InsertStatements.selectStatementIds
	  *
	  * <code>
	  *          SELECT MIN(STMTID),MAX(STMTID)          FROM {0}STMT_ID_TMP     
	  * </code>
	  */
	public static final String selectStatementIds = "InsertStatements.selectStatementIds";

	/**
	  *Constant "commitInsertStatements" used to reference prepared statement  InsertStatements.commitInsertStatements
	  *
	  * <code>
	  *          INSERT INTO STATEMENTS(ID,METADATA,UUID,NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT,RSTART,COMMITTED)         SELECT          {0}STMTS_TMP.ID,         {0}STMTS_TMP.METADATA,         {0}STMTS_TMP.UUID,         {0}STMTS_TMP.NAMEDGRAPHID,         {0}STMTS_TMP.SUBJECT,         {0}STMTS_TMP.PREDICATE,         {0}STMTS_TMP.OBJECT,         {0}STMTS_TMP.REVISION,         {0}STMTS_TMP.COMMITTED         FROM {0}STMTS_TMP         WHERE {0}STMTS_TMP.OPERATION=1 	
	  * </code>
	  */
	public static final String commitInsertStatements = "InsertStatements.commitInsertStatements";

	/**
	  *Constant "commitInsertStatementsRange" used to reference prepared statement  InsertStatements.commitInsertStatementsRange
	  *
	  * <code>
	  *          INSERT INTO STATEMENTS(ID,METADATA,UUID,NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT,RSTART,COMMITTED)         SELECT          {0}STMTS_TMP.ID,         {0}STMTS_TMP.METADATA,         {0}STMTS_TMP.UUID,         {0}STMTS_TMP.NAMEDGRAPHID,         {0}STMTS_TMP.SUBJECT,         {0}STMTS_TMP.PREDICATE,         {0}STMTS_TMP.OBJECT,         {0}STMTS_TMP.REVISION,         {0}STMTS_TMP.COMMITTED         FROM {0}STMTS_TMP         WHERE {0}STMTS_TMP.STMTID >= ? AND {0}STMTS_TMP.STMTID < ? AND {0}STMTS_TMP.OPERATION=1          
	  * </code>
	  */
	public static final String commitInsertStatementsRange = "InsertStatements.commitInsertStatementsRange";

	/**
	  *Constant "commitInsertStatementsNR" used to reference prepared statement  InsertStatements.commitInsertStatementsNR
	  *
	  * <code>
	  *          INSERT INTO STATEMENTS_NR(ID,METADATA,NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT,COMMITTED)         SELECT          {0}STMTS_TMP.ID,         {0}STMTS_TMP.METADATA,         {0}STMTS_TMP.NAMEDGRAPHID,         {0}STMTS_TMP.SUBJECT,         {0}STMTS_TMP.PREDICATE,         {0}STMTS_TMP.OBJECT,         {0}STMTS_TMP.COMMITTED         FROM {0}STMTS_TMP         WHERE {0}STMTS_TMP.OPERATION=1 	
	  * </code>
	  */
	public static final String commitInsertStatementsNR = "InsertStatements.commitInsertStatementsNR";

	/**
	  *Constant "commitInsertStatementsNRRange" used to reference prepared statement  InsertStatements.commitInsertStatementsNRRange
	  *
	  * <code>
	  *          INSERT INTO STATEMENTS_NR(ID,METADATA,NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT,COMMITTED)         SELECT          {0}STMTS_TMP.ID,         {0}STMTS_TMP.METADATA,         {0}STMTS_TMP.NAMEDGRAPHID,         {0}STMTS_TMP.SUBJECT,         {0}STMTS_TMP.PREDICATE,         {0}STMTS_TMP.OBJECT,         {0}STMTS_TMP.COMMITTED         FROM {0}STMTS_TMP         WHERE {0}STMTS_TMP.STMTID >= ? AND {0}STMTS_TMP.STMTID < ? AND {0}STMTS_TMP.OPERATION=1          
	  * </code>
	  */
	public static final String commitInsertStatementsNRRange = "InsertStatements.commitInsertStatementsNRRange";

	/**
	  *Constant "commitRemoveStatements" used to reference prepared statement  InsertStatements.commitRemoveStatements
	  *
	  * <code>
	  *          UPDATE STATEMENTS SET              COMMITTED=?,             REND=(SELECT ST.REVISION FROM {0}STMTS_TMP ST WHERE ST.OPERATION=0 AND ST.ID=STATEMENTS.ID)          WHERE          	COMMITTED=0 AND              REND IS NULL AND              ID IN (SELECT ST.ID FROM {0}STMTS_TMP ST WHERE ST.OPERATION=0) 	
	  * </code>
	  */
	public static final String commitRemoveStatements = "InsertStatements.commitRemoveStatements";

	/**
	  *Constant "commitRemoveStatementsRange" used to reference prepared statement  InsertStatements.commitRemoveStatementsRange
	  *
	  * <code>
	  *          UPDATE STATEMENTS SET              COMMITTED=?,             REND=(SELECT ST.REVISION FROM {0}STMTS_TMP ST WHERE ST.OPERATION=0 AND ST.ID=STATEMENTS.ID)          WHERE          	COMMITTED=0 AND              REND IS NULL AND ID IN (SELECT ST.ID FROM {0}STMTS_TMP ST WHERE ST.STMTID >= ? AND ST.STMTID < ? AND ST.OPERATION=0)          
	  * </code>
	  */
	public static final String commitRemoveStatementsRange = "InsertStatements.commitRemoveStatementsRange";

	/**
	  *Constant "commitRemoveStatementsNR" used to reference prepared statement  InsertStatements.commitRemoveStatementsNR
	  *
	  * <code>
	  *          UPDATE STATEMENTS_NR SET COMMITTED=? WHERE ID IN(         SELECT ST.ID         FROM {0}STMTS_TMP ST         WHERE ST.OPERATION=0 ) 	
	  * </code>
	  */
	public static final String commitRemoveStatementsNR = "InsertStatements.commitRemoveStatementsNR";

	/**
	  *Constant "commitRemoveStatementsNRRange" used to reference prepared statement  InsertStatements.commitRemoveStatementsNRRange
	  *
	  * <code>
	  *          UPDATE STATEMENTS_NR SET COMMITTED=? WHERE ID IN(         SELECT ST.ID         FROM {0}STMTS_TMP ST         WHERE ST.STMTID >= ? AND ST.STMTID < ? AND ST.OPERATION=0)        
	  * </code>
	  */
	public static final String commitRemoveStatementsNRRange = "InsertStatements.commitRemoveStatementsNRRange";

	/**
	  *Constant "commitTransactionStatements" used to reference prepared statement  InsertStatements.commitTransactionStatements
	  *
	  * <code>
	  *          UPDATE STATEMENTS SET COMMITTED=0 WHERE COMMITTED=? 	
	  * </code>
	  */
	public static final String commitTransactionStatements = "InsertStatements.commitTransactionStatements";

	/**
	  *Constant "commitTransactionAddStatementsNR" used to reference prepared statement  InsertStatements.commitTransactionAddStatementsNR
	  *
	  * <code>
	  *          UPDATE STATEMENTS_NR SET COMMITTED=0 WHERE COMMITTED=? 	
	  * </code>
	  */
	public static final String commitTransactionAddStatementsNR = "InsertStatements.commitTransactionAddStatementsNR";

	/**
	  *Constant "commitTransactionRemoveStatementsNR" used to reference prepared statement  InsertStatements.commitTransactionRemoveStatementsNR
	  *
	  * <code>
	  *          DELETE FROM STATEMENTS_NR WHERE COMMITTED=? 	
	  * </code>
	  */
	public static final String commitTransactionRemoveStatementsNR = "InsertStatements.commitTransactionRemoveStatementsNR";

	/**
	  *Constant "commitTransactionNamedGraphs" used to reference prepared statement  InsertStatements.commitTransactionNamedGraphs
	  *
	  * <code>
	  *          UPDATE NAMEDGRAPHS SET COMMITTED=0 WHERE COMMITTED=? 	
	  * </code>
	  */
	public static final String commitTransactionNamedGraphs = "InsertStatements.commitTransactionNamedGraphs";

	/**
	  *Constant "commitTransactionAddNamedGraphsNR" used to reference prepared statement  InsertStatements.commitTransactionAddNamedGraphsNR
	  *
	  * <code>
	  *          UPDATE NAMEDGRAPHS_NR SET COMMITTED=0 WHERE COMMITTED=? 	
	  * </code>
	  */
	public static final String commitTransactionAddNamedGraphsNR = "InsertStatements.commitTransactionAddNamedGraphsNR";

	/**
	  *Constant "commitTransactionRemoveNamedGraphsNR" used to reference prepared statement  InsertStatements.commitTransactionRemoveNamedGraphsNR
	  *
	  * <code>
	  *          DELETE FROM NAMEDGRAPHS_NR WHERE COMMITTED=? 	
	  * </code>
	  */
	public static final String commitTransactionRemoveNamedGraphsNR = "InsertStatements.commitTransactionRemoveNamedGraphsNR";

	/**
	  *Constant "commitTransactionStatementsRange" used to reference prepared statement  InsertStatements.commitTransactionStatementsRange
	  *
	  * <code>
	  *             UPDATE STATEMENTS SET COMMITTED=0 WHERE COMMITTED=? AND STATEMENTS.ID IN (SELECT ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ? )         
	  * </code>
	  */
	public static final String commitTransactionStatementsRange = "InsertStatements.commitTransactionStatementsRange";

	/**
	  *Constant "commitTransactionAddStatementsNRRange" used to reference prepared statement  InsertStatements.commitTransactionAddStatementsNRRange
	  *
	  * <code>
	  *              UPDATE STATEMENTS_NR  SET COMMITTED=0 WHERE COMMITTED=? AND STATEMENTS_NR.ID IN (SELECT ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ?)          
	  * </code>
	  */
	public static final String commitTransactionAddStatementsNRRange = "InsertStatements.commitTransactionAddStatementsNRRange";

	/**
	  *Constant "commitTransactionRemoveStatementsNRRange" used to reference prepared statement  InsertStatements.commitTransactionRemoveStatementsNRRange
	  *
	  * <code>
	  *              DELETE FROM STATEMENTS_NR WHERE COMMITTED=? AND STATEMENTS_NR.ID IN (SELECT ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ?)          
	  * </code>
	  */
	public static final String commitTransactionRemoveStatementsNRRange = "InsertStatements.commitTransactionRemoveStatementsNRRange";

	/**
	  *Constant "abortTransactionAddStatements" used to reference prepared statement  InsertStatements.abortTransactionAddStatements
	  *
	  * <code>
	  *          DELETE FROM STATEMENTS WHERE COMMITTED=? 	
	  * </code>
	  */
	public static final String abortTransactionAddStatements = "InsertStatements.abortTransactionAddStatements";

	/**
	  *Constant "abortTransactionAlreadyAddedStatements" used to reference prepared statement  InsertStatements.abortTransactionAlreadyAddedStatements
	  *
	  * <code>
	  *          DELETE FROM STATEMENTS WHERE ID IN (SELECT {0}STMT_ID_TMP.ID FROM {0}STMT_ID_TMP) AND COMMITTED=0 AND REND IS NULL; 	
	  * </code>
	  */
	public static final String abortTransactionAlreadyAddedStatements = "InsertStatements.abortTransactionAlreadyAddedStatements";

	/**
	  *Constant "abortTransactionRemoveStatements" used to reference prepared statement  InsertStatements.abortTransactionRemoveStatements
	  *
	  * <code>
	  *          UPDATE STATEMENTS SET REND=CAST(NULL AS {0}),COMMITTED=0 WHERE COMMITTED=? 	
	  * </code>
	  */
	public static final String abortTransactionRemoveStatements = "InsertStatements.abortTransactionRemoveStatements";

	/**
	  *Constant "abortTransactionAddStatementsNR" used to reference prepared statement  InsertStatements.abortTransactionAddStatementsNR
	  *
	  * <code>
	  *          DELETE FROM STATEMENTS_NR WHERE COMMITTED=? 	
	  * </code>
	  */
	public static final String abortTransactionAddStatementsNR = "InsertStatements.abortTransactionAddStatementsNR";

	/**
	  *Constant "abortTransactionAlreadyAddedStatementsNR" used to reference prepared statement  InsertStatements.abortTransactionAlreadyAddedStatementsNR
	  *
	  * <code>
	  *          DELETE FROM STATEMENTS_NR WHERE ID  IN (SELECT {0}STMT_ID_TMP.ID FROM {0}STMT_ID_TMP); 	
	  * </code>
	  */
	public static final String abortTransactionAlreadyAddedStatementsNR = "InsertStatements.abortTransactionAlreadyAddedStatementsNR";

	/**
	  *Constant "abortTransactionRemoveStatementsNR" used to reference prepared statement  InsertStatements.abortTransactionRemoveStatementsNR
	  *
	  * <code>
	  *          UPDATE STATEMENTS_NR SET COMMITTED=0 WHERE COMMITTED=? 	
	  * </code>
	  */
	public static final String abortTransactionRemoveStatementsNR = "InsertStatements.abortTransactionRemoveStatementsNR";

	/**
	  *Constant "abortTransactionAddStatementsRange" used to reference prepared statement  InsertStatements.abortTransactionAddStatementsRange
	  *
	  * <code>
	  *              DELETE FROM STATEMENTS WHERE COMMITTED=? AND STATEMENTS.ID IN  (SELECT ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ?)         
	  * </code>
	  */
	public static final String abortTransactionAddStatementsRange = "InsertStatements.abortTransactionAddStatementsRange";

	/**
	  *Constant "abortTransactionRemoveStatementsRange" used to reference prepared statement  InsertStatements.abortTransactionRemoveStatementsRange
	  *
	  * <code>
	  *              UPDATE STATEMENTS SET REND=CAST(NULL AS {0}),COMMITTED=0 WHERE COMMITTED=? AND ST.ID=STATEMENTS.ID IN (SELECT ST.ID FROM  {1}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ?)         
	  * </code>
	  */
	public static final String abortTransactionRemoveStatementsRange = "InsertStatements.abortTransactionRemoveStatementsRange";

	/**
	  *Constant "abortTransactionAddStatementsNRRange" used to reference prepared statement  InsertStatements.abortTransactionAddStatementsNRRange
	  *
	  * <code>
	  *              DELETE FROM STATEMENTS_NR WHERE COMMITTED=? AND STATEMENTS.ID IN (SELECT ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ? )         
	  * </code>
	  */
	public static final String abortTransactionAddStatementsNRRange = "InsertStatements.abortTransactionAddStatementsNRRange";

	/**
	  *Constant "abortTransactionRemoveStatementsNRRange" used to reference prepared statement  InsertStatements.abortTransactionRemoveStatementsNRRange
	  *
	  * <code>
	  *              UPDATE STATEMENTS_NR SET COMMITTED=0 WHERE COMMITTED=? AND STATEMENTS.ID IN (SELECT ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ?)         
	  * </code>
	  */
	public static final String abortTransactionRemoveStatementsNRRange = "InsertStatements.abortTransactionRemoveStatementsNRRange";

	/**
	  *Constant "abortTransactionAddNamedGraphs" used to reference prepared statement  InsertStatements.abortTransactionAddNamedGraphs
	  *
	  * <code>
	  *          DELETE FROM NAMEDGRAPHS WHERE COMMITTED=? 	
	  * </code>
	  */
	public static final String abortTransactionAddNamedGraphs = "InsertStatements.abortTransactionAddNamedGraphs";

	/**
	  *Constant "abortTransactionRemoveNamedGraphs" used to reference prepared statement  InsertStatements.abortTransactionRemoveNamedGraphs
	  *
	  * <code>
	  *          UPDATE NAMEDGRAPHS SET HEND=CAST(NULL AS {0}),COMMITTED=0 WHERE COMMITTED=? 	
	  * </code>
	  */
	public static final String abortTransactionRemoveNamedGraphs = "InsertStatements.abortTransactionRemoveNamedGraphs";

	/**
	  *Constant "abortTransactionAddNamedGraphsNR" used to reference prepared statement  InsertStatements.abortTransactionAddNamedGraphsNR
	  *
	  * <code>
	  *          DELETE FROM NAMEDGRAPHS_NR WHERE COMMITTED=? 	
	  * </code>
	  */
	public static final String abortTransactionAddNamedGraphsNR = "InsertStatements.abortTransactionAddNamedGraphsNR";

	/**
	  *Constant "abortTransactionRemoveNamedGraphsNR" used to reference prepared statement  InsertStatements.abortTransactionRemoveNamedGraphsNR
	  *
	  * <code>
	  *          UPDATE NAMEDGRAPHS_NR SET COMMITTED=0 WHERE COMMITTED=? 	
	  * </code>
	  */
	public static final String abortTransactionRemoveNamedGraphsNR = "InsertStatements.abortTransactionRemoveNamedGraphsNR";



	
	/**
	 * Runs the getTempTablespaceDefined prepared statement.
	  * <code>
	 *          SELECT COUNT(1) FROM SYSIBM.SYSTABLESPACES WHERE TBSPACE=''USR_TBSP'' 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@return  long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static long getTempTablespaceDefined (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(getTempTablespaceDefined, new String[] {},connection);
			java.sql.ResultSet rs = null;
			try {
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				if(!rs.next())
					return 0;				 
				long val = rs.getLong(1);
				return val;
			} finally {
				if(rs != null) {
					try {
						rs.close();
					} catch (java.sql.SQLException sqle) {
						if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing result set",sqle);
					}
				}
			}

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"getTempTablespaceDefined",stmtProvider.getSqlString(getTempTablespaceDefined) ,"","");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[getTempTablespaceDefined]"+endtimer);
		}
	}




	
	/**
	 * Runs the insertTempStatement prepared statement.
	  * <code>
	 *          INSERT INTO {0}STMTS_TMP(OPERATION,STMTID,ID,METADATA,UUID,NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT,REVISION,COMMITTED) VALUES(?,?,?,?,?,?,?,?,?,?,?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param operation template parameter
	 *@param stmtId template parameter
	 *@param id template parameter
	 *@param metadata template parameter
	 *@param uuid template parameter
	 *@param graphid template parameter
	 *@param subject template parameter
	 *@param predicate template parameter
	 *@param object template parameter
	 *@param revision template parameter
	 *@param committed template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertTempStatement (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int operation, int stmtId, String id, int metadata, long uuid, long graphid, long subject, long predicate, long object, Long revision, long committed, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertTempStatement, new String[] {sessionPrefix},connection); int argc = 1;
			ps.setInt(argc++, operation);
			ps.setInt(argc++, stmtId);
			if(id == null) {
				ps.setNull(argc++, java.sql.Types.VARCHAR);
			} else {
				ps.setString(argc++, id);
			}
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, uuid);
			ps.setLong(argc++, graphid);
			ps.setLong(argc++, subject);
			ps.setLong(argc++, predicate);
			ps.setLong(argc++, object);
			if(revision == null) {
				ps.setNull(argc++, java.sql.Types.BIGINT);
			} else {
				ps.setLong(argc++, revision);
			}
			ps.setLong(argc++, committed);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertTempStatement",stmtProvider.getSqlString(insertTempStatement) ,""+ "operation="+(operation) + "," +"stmtId="+(stmtId) + "," +"id="+((id!=null)?id.toString():"null") + "," +"metadata="+(metadata) + "," +"uuid="+(uuid) + "," +"graphid="+(graphid) + "," +"subject="+(subject) + "," +"predicate="+(predicate) + "," +"object="+(object) + "," +"revision="+((revision!=null)?revision.toString():"null") + "," +"committed="+(committed),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertTempStatement]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertTempStatement prepared statement
	 */
	public static class BatchInsertTempStatement extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertTempStatement prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertTempStatement(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertTempStatement,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the insertTempStatement prepared statement.
		 *
	 *@param operation template parameter
	 *@param stmtId template parameter
	 *@param id template parameter
	 *@param metadata template parameter
	 *@param uuid template parameter
	 *@param graphid template parameter
	 *@param subject template parameter
	 *@param predicate template parameter
	 *@param object template parameter
	 *@param revision template parameter
	 *@param committed template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int operation, int stmtId, String id, int metadata, long uuid, long graphid, long subject, long predicate, long object, Long revision, long committed) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, operation);
			ps.setInt(argc++, stmtId);
			if(id == null) {
				ps.setNull(argc++, java.sql.Types.VARCHAR);
			} else {
				ps.setString(argc++, id);
			}
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, uuid);
			ps.setLong(argc++, graphid);
			ps.setLong(argc++, subject);
			ps.setLong(argc++, predicate);
			ps.setLong(argc++, object);
			if(revision == null) {
				ps.setNull(argc++, java.sql.Types.BIGINT);
			} else {
				ps.setLong(argc++, revision);
			}
			ps.setLong(argc++, committed);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the selectInsertStatements prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectInsertStatementsResult> transformSelectInsertStatements = new org.openanzo.jdbc.utils.Transformer<SelectInsertStatementsResult>(){
		public SelectInsertStatementsResult transform(java.sql.ResultSet rs) {

			
				SelectInsertStatementsResult result = new SelectInsertStatementsResult();
				try {
				result.stmtId=rs.getInt(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:stmtId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.operation=rs.getInt(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:operation",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the selectInsertStatements prepared statement.
	  * <code>
	 *          SELECT         ST.STMTID,         ST.OPERATION         FROM {0}STMTS_TMP ST 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectInsertStatementsResult> selectInsertStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectInsertStatements, new String[] {sessionPrefix},connection);
			java.sql.ResultSet rs = null;
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}

			org.openanzo.jdbc.utils.ClosableIterator<SelectInsertStatementsResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectInsertStatementsResult>(rs, ps, stmtProvider, transformSelectInsertStatements);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectInsertStatements",stmtProvider.getSqlString(selectInsertStatements) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectInsertStatements]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectInsertStatementsResult
	 */
	public static class SelectInsertStatementsResult {
			/**Value for the "stmtId" result value*/
			private int stmtId;
			/**Value for the "operation" result value*/
			private int operation;

		/**
		  *Get StmtId value
		  *@return StmtId value
		  */
			public int getStmtId() {
				return this.stmtId;
			}

		/**
		  *Get Operation value
		  *@return Operation value
		  */
			public int getOperation() {
				return this.operation;
			}

	}



	
	/**
	 * Runs the purgeInsertRemoveStatements prepared statement.
	  * <code>
	 *          DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=0 AND {0}STMTS_TMP.ID IN (SELECT S.ID FROM {0}STMTS_TMP S WHERE S.OPERATION=1) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int purgeInsertRemoveStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purgeInsertRemoveStatements, new String[] {sessionPrefix},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purgeInsertRemoveStatements",stmtProvider.getSqlString(purgeInsertRemoveStatements) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[purgeInsertRemoveStatements]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PurgeInsertRemoveStatements prepared statement
	 */
	public static class BatchPurgeInsertRemoveStatements extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PurgeInsertRemoveStatements prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurgeInsertRemoveStatements(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purgeInsertRemoveStatements,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the purgeInsertRemoveStatements prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the purgeInsertStatements prepared statement.
	  * <code>
	 *          DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=1 AND EXISTS (SELECT S.ID FROM STATEMENTS S WHERE S.ID={0}STMTS_TMP.ID AND S.COMMITTED=0 AND S.REND IS NULL) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int purgeInsertStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purgeInsertStatements, new String[] {sessionPrefix},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purgeInsertStatements",stmtProvider.getSqlString(purgeInsertStatements) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[purgeInsertStatements]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PurgeInsertStatements prepared statement
	 */
	public static class BatchPurgeInsertStatements extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PurgeInsertStatements prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurgeInsertStatements(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purgeInsertStatements,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the purgeInsertStatements prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the purgeRemoveStatements prepared statement.
	  * <code>
	 *          DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=0 AND NOT EXISTS (SELECT S.ID FROM STATEMENTS S WHERE S.ID={0}STMTS_TMP.ID AND S.COMMITTED=0  AND S.REND IS NULL) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int purgeRemoveStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purgeRemoveStatements, new String[] {sessionPrefix},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purgeRemoveStatements",stmtProvider.getSqlString(purgeRemoveStatements) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[purgeRemoveStatements]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PurgeRemoveStatements prepared statement
	 */
	public static class BatchPurgeRemoveStatements extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PurgeRemoveStatements prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurgeRemoveStatements(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purgeRemoveStatements,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the purgeRemoveStatements prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the purgeInsertStatementsNR prepared statement.
	  * <code>
	 *          DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=1 AND EXISTS (SELECT S.ID FROM STATEMENTS_NR S WHERE S.ID={0}STMTS_TMP.ID AND S.COMMITTED=0) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int purgeInsertStatementsNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purgeInsertStatementsNR, new String[] {sessionPrefix},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purgeInsertStatementsNR",stmtProvider.getSqlString(purgeInsertStatementsNR) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[purgeInsertStatementsNR]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PurgeInsertStatementsNR prepared statement
	 */
	public static class BatchPurgeInsertStatementsNR extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PurgeInsertStatementsNR prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurgeInsertStatementsNR(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purgeInsertStatementsNR,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the purgeInsertStatementsNR prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the purgeRemoveStatementsNR prepared statement.
	  * <code>
	 *          DELETE FROM {0}STMTS_TMP WHERE {0}STMTS_TMP.OPERATION=0 AND NOT EXISTS (SELECT S.ID FROM STATEMENTS_NR S WHERE S.ID={0}STMTS_TMP.ID AND S.COMMITTED=0) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int purgeRemoveStatementsNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purgeRemoveStatementsNR, new String[] {sessionPrefix},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purgeRemoveStatementsNR",stmtProvider.getSqlString(purgeRemoveStatementsNR) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[purgeRemoveStatementsNR]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PurgeRemoveStatementsNR prepared statement
	 */
	public static class BatchPurgeRemoveStatementsNR extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PurgeRemoveStatementsNR prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurgeRemoveStatementsNR(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purgeRemoveStatementsNR,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the purgeRemoveStatementsNR prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the countInsertStatements prepared statement.
	  * <code>
	 *          SELECT COUNT(1) FROM {0}STMTS_TMP WHERE OPERATION=1 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@return  long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static long countInsertStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(countInsertStatements, new String[] {sessionPrefix},connection);
			java.sql.ResultSet rs = null;
			try {
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				if(!rs.next())
					return 0;				 
				long val = rs.getLong(1);
				return val;
			} finally {
				if(rs != null) {
					try {
						rs.close();
					} catch (java.sql.SQLException sqle) {
						if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing result set",sqle);
					}
				}
			}

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"countInsertStatements",stmtProvider.getSqlString(countInsertStatements) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[countInsertStatements]"+endtimer);
		}
	}




	
	/**
	 * Runs the countRemoveStatements prepared statement.
	  * <code>
	 *          SELECT COUNT(1) FROM {0}STMTS_TMP WHERE OPERATION=0 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@return  long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static long countRemoveStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(countRemoveStatements, new String[] {sessionPrefix},connection);
			java.sql.ResultSet rs = null;
			try {
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				if(!rs.next())
					return 0;				 
				long val = rs.getLong(1);
				return val;
			} finally {
				if(rs != null) {
					try {
						rs.close();
					} catch (java.sql.SQLException sqle) {
						if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing result set",sqle);
					}
				}
			}

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"countRemoveStatements",stmtProvider.getSqlString(countRemoveStatements) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[countRemoveStatements]"+endtimer);
		}
	}




	
	/**
	 * Runs the commitStatementIds prepared statement.
	  * <code>
	 *          INSERT INTO {0}STMT_ID_TMP(ID,STMTID)         SELECT DISTINCT         {0}STMTS_TMP.ID,         {0}STMTS_TMP.STMTID         FROM {0}STMTS_TMP     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int commitStatementIds (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(commitStatementIds, new String[] {sessionPrefix},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"commitStatementIds",stmtProvider.getSqlString(commitStatementIds) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[commitStatementIds]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the CommitStatementIds prepared statement
	 */
	public static class BatchCommitStatementIds extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the CommitStatementIds prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCommitStatementIds(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,commitStatementIds,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the commitStatementIds prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the selectStatementIds prepared statement.
	  * <code>
	 *          SELECT MIN(STMTID),MAX(STMTID)          FROM {0}STMT_ID_TMP     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@return  SelectStatementIdsResult
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static SelectStatementIdsResult selectStatementIds (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectStatementIds, new String[] {sessionPrefix},connection);
			java.sql.ResultSet rs = null;
			try {
				try{
					rs = ps.executeQuery();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								rs = ps.executeQuery();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				if(!rs.next()) return null;
		SelectStatementIdsResult result=new SelectStatementIdsResult();
				result.min=rs.getInt(1);
				result.max=rs.getInt(2);
				return result;
			} finally {
				if(rs != null) {
					try {
						rs.close();
					} catch (java.sql.SQLException sqle) {
						if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing result set",sqle);
					}
				}
			}

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectStatementIds",stmtProvider.getSqlString(selectStatementIds) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectStatementIds]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectStatementIdsResult
	 */
	public static class SelectStatementIdsResult {
			/**Value for the "min" result value*/
			private Integer min;
			/**Value for the "max" result value*/
			private int max;

		/**
		  *Get Min value
		  *@return Min value
		  */
			public Integer getMin() {
				return this.min;
			}

		/**
		  *Get Max value
		  *@return Max value
		  */
			public int getMax() {
				return this.max;
			}

	}



	
	/**
	 * Runs the commitInsertStatements prepared statement.
	  * <code>
	 *          INSERT INTO STATEMENTS(ID,METADATA,UUID,NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT,RSTART,COMMITTED)         SELECT          {0}STMTS_TMP.ID,         {0}STMTS_TMP.METADATA,         {0}STMTS_TMP.UUID,         {0}STMTS_TMP.NAMEDGRAPHID,         {0}STMTS_TMP.SUBJECT,         {0}STMTS_TMP.PREDICATE,         {0}STMTS_TMP.OBJECT,         {0}STMTS_TMP.REVISION,         {0}STMTS_TMP.COMMITTED         FROM {0}STMTS_TMP         WHERE {0}STMTS_TMP.OPERATION=1 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int commitInsertStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(commitInsertStatements, new String[] {sessionPrefix},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"commitInsertStatements",stmtProvider.getSqlString(commitInsertStatements) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[commitInsertStatements]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the CommitInsertStatements prepared statement
	 */
	public static class BatchCommitInsertStatements extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the CommitInsertStatements prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCommitInsertStatements(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,commitInsertStatements,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the commitInsertStatements prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the commitInsertStatementsRange prepared statement.
	  * <code>
	 *          INSERT INTO STATEMENTS(ID,METADATA,UUID,NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT,RSTART,COMMITTED)         SELECT          {0}STMTS_TMP.ID,         {0}STMTS_TMP.METADATA,         {0}STMTS_TMP.UUID,         {0}STMTS_TMP.NAMEDGRAPHID,         {0}STMTS_TMP.SUBJECT,         {0}STMTS_TMP.PREDICATE,         {0}STMTS_TMP.OBJECT,         {0}STMTS_TMP.REVISION,         {0}STMTS_TMP.COMMITTED         FROM {0}STMTS_TMP         WHERE {0}STMTS_TMP.STMTID >= ? AND {0}STMTS_TMP.STMTID < ? AND {0}STMTS_TMP.OPERATION=1          
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param start template parameter
	 *@param end template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int commitInsertStatementsRange (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long start, long end, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(commitInsertStatementsRange, new String[] {sessionPrefix},connection); int argc = 1;
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"commitInsertStatementsRange",stmtProvider.getSqlString(commitInsertStatementsRange) ,""+ "start="+(start) + "," +"end="+(end),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[commitInsertStatementsRange]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the CommitInsertStatementsRange prepared statement
	 */
	public static class BatchCommitInsertStatementsRange extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the CommitInsertStatementsRange prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCommitInsertStatementsRange(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,commitInsertStatementsRange,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the commitInsertStatementsRange prepared statement.
		 *
	 *@param start template parameter
	 *@param end template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long start, long end) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the commitInsertStatementsNR prepared statement.
	  * <code>
	 *          INSERT INTO STATEMENTS_NR(ID,METADATA,NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT,COMMITTED)         SELECT          {0}STMTS_TMP.ID,         {0}STMTS_TMP.METADATA,         {0}STMTS_TMP.NAMEDGRAPHID,         {0}STMTS_TMP.SUBJECT,         {0}STMTS_TMP.PREDICATE,         {0}STMTS_TMP.OBJECT,         {0}STMTS_TMP.COMMITTED         FROM {0}STMTS_TMP         WHERE {0}STMTS_TMP.OPERATION=1 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int commitInsertStatementsNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(commitInsertStatementsNR, new String[] {sessionPrefix},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"commitInsertStatementsNR",stmtProvider.getSqlString(commitInsertStatementsNR) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[commitInsertStatementsNR]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the CommitInsertStatementsNR prepared statement
	 */
	public static class BatchCommitInsertStatementsNR extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the CommitInsertStatementsNR prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCommitInsertStatementsNR(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,commitInsertStatementsNR,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the commitInsertStatementsNR prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the commitInsertStatementsNRRange prepared statement.
	  * <code>
	 *          INSERT INTO STATEMENTS_NR(ID,METADATA,NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT,COMMITTED)         SELECT          {0}STMTS_TMP.ID,         {0}STMTS_TMP.METADATA,         {0}STMTS_TMP.NAMEDGRAPHID,         {0}STMTS_TMP.SUBJECT,         {0}STMTS_TMP.PREDICATE,         {0}STMTS_TMP.OBJECT,         {0}STMTS_TMP.COMMITTED         FROM {0}STMTS_TMP         WHERE {0}STMTS_TMP.STMTID >= ? AND {0}STMTS_TMP.STMTID < ? AND {0}STMTS_TMP.OPERATION=1          
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param start template parameter
	 *@param end template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int commitInsertStatementsNRRange (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long start, long end, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(commitInsertStatementsNRRange, new String[] {sessionPrefix},connection); int argc = 1;
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"commitInsertStatementsNRRange",stmtProvider.getSqlString(commitInsertStatementsNRRange) ,""+ "start="+(start) + "," +"end="+(end),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[commitInsertStatementsNRRange]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the CommitInsertStatementsNRRange prepared statement
	 */
	public static class BatchCommitInsertStatementsNRRange extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the CommitInsertStatementsNRRange prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCommitInsertStatementsNRRange(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,commitInsertStatementsNRRange,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the commitInsertStatementsNRRange prepared statement.
		 *
	 *@param start template parameter
	 *@param end template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long start, long end) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the commitRemoveStatements prepared statement.
	  * <code>
	 *          UPDATE STATEMENTS SET              COMMITTED=?,             REND=(SELECT ST.REVISION FROM {0}STMTS_TMP ST WHERE ST.OPERATION=0 AND ST.ID=STATEMENTS.ID)          WHERE          	COMMITTED=0 AND              REND IS NULL AND              ID IN (SELECT ST.ID FROM {0}STMTS_TMP ST WHERE ST.OPERATION=0) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int commitRemoveStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(commitRemoveStatements, new String[] {sessionPrefix},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"commitRemoveStatements",stmtProvider.getSqlString(commitRemoveStatements) ,""+ "transactionId="+(transactionId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[commitRemoveStatements]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the CommitRemoveStatements prepared statement
	 */
	public static class BatchCommitRemoveStatements extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the CommitRemoveStatements prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCommitRemoveStatements(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,commitRemoveStatements,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the commitRemoveStatements prepared statement.
		 *
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the commitRemoveStatementsRange prepared statement.
	  * <code>
	 *          UPDATE STATEMENTS SET              COMMITTED=?,             REND=(SELECT ST.REVISION FROM {0}STMTS_TMP ST WHERE ST.OPERATION=0 AND ST.ID=STATEMENTS.ID)          WHERE          	COMMITTED=0 AND              REND IS NULL AND ID IN (SELECT ST.ID FROM {0}STMTS_TMP ST WHERE ST.STMTID >= ? AND ST.STMTID < ? AND ST.OPERATION=0)          
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *@param start template parameter
	 *@param end template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int commitRemoveStatementsRange (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, long start, long end, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(commitRemoveStatementsRange, new String[] {sessionPrefix},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"commitRemoveStatementsRange",stmtProvider.getSqlString(commitRemoveStatementsRange) ,""+ "transactionId="+(transactionId) + "," +"start="+(start) + "," +"end="+(end),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[commitRemoveStatementsRange]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the CommitRemoveStatementsRange prepared statement
	 */
	public static class BatchCommitRemoveStatementsRange extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the CommitRemoveStatementsRange prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCommitRemoveStatementsRange(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,commitRemoveStatementsRange,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the commitRemoveStatementsRange prepared statement.
		 *
	 *@param transactionId template parameter
	 *@param start template parameter
	 *@param end template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId, long start, long end) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the commitRemoveStatementsNR prepared statement.
	  * <code>
	 *          UPDATE STATEMENTS_NR SET COMMITTED=? WHERE ID IN(         SELECT ST.ID         FROM {0}STMTS_TMP ST         WHERE ST.OPERATION=0 ) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int commitRemoveStatementsNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(commitRemoveStatementsNR, new String[] {sessionPrefix},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"commitRemoveStatementsNR",stmtProvider.getSqlString(commitRemoveStatementsNR) ,""+ "transactionId="+(transactionId),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[commitRemoveStatementsNR]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the CommitRemoveStatementsNR prepared statement
	 */
	public static class BatchCommitRemoveStatementsNR extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the CommitRemoveStatementsNR prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCommitRemoveStatementsNR(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,commitRemoveStatementsNR,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the commitRemoveStatementsNR prepared statement.
		 *
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the commitRemoveStatementsNRRange prepared statement.
	  * <code>
	 *          UPDATE STATEMENTS_NR SET COMMITTED=? WHERE ID IN(         SELECT ST.ID         FROM {0}STMTS_TMP ST         WHERE ST.STMTID >= ? AND ST.STMTID < ? AND ST.OPERATION=0)        
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *@param start template parameter
	 *@param end template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int commitRemoveStatementsNRRange (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, long start, long end, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(commitRemoveStatementsNRRange, new String[] {sessionPrefix},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"commitRemoveStatementsNRRange",stmtProvider.getSqlString(commitRemoveStatementsNRRange) ,""+ "transactionId="+(transactionId) + "," +"start="+(start) + "," +"end="+(end),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[commitRemoveStatementsNRRange]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the CommitRemoveStatementsNRRange prepared statement
	 */
	public static class BatchCommitRemoveStatementsNRRange extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the CommitRemoveStatementsNRRange prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCommitRemoveStatementsNRRange(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,commitRemoveStatementsNRRange,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the commitRemoveStatementsNRRange prepared statement.
		 *
	 *@param transactionId template parameter
	 *@param start template parameter
	 *@param end template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId, long start, long end) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the commitTransactionStatements prepared statement.
	  * <code>
	 *          UPDATE STATEMENTS SET COMMITTED=0 WHERE COMMITTED=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int commitTransactionStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(commitTransactionStatements, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"commitTransactionStatements",stmtProvider.getSqlString(commitTransactionStatements) ,""+ "transactionId="+(transactionId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[commitTransactionStatements]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the CommitTransactionStatements prepared statement
	 */
	public static class BatchCommitTransactionStatements extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the CommitTransactionStatements prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCommitTransactionStatements(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,commitTransactionStatements,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the commitTransactionStatements prepared statement.
		 *
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the commitTransactionAddStatementsNR prepared statement.
	  * <code>
	 *          UPDATE STATEMENTS_NR SET COMMITTED=0 WHERE COMMITTED=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int commitTransactionAddStatementsNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(commitTransactionAddStatementsNR, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"commitTransactionAddStatementsNR",stmtProvider.getSqlString(commitTransactionAddStatementsNR) ,""+ "transactionId="+(transactionId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[commitTransactionAddStatementsNR]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the CommitTransactionAddStatementsNR prepared statement
	 */
	public static class BatchCommitTransactionAddStatementsNR extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the CommitTransactionAddStatementsNR prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCommitTransactionAddStatementsNR(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,commitTransactionAddStatementsNR,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the commitTransactionAddStatementsNR prepared statement.
		 *
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the commitTransactionRemoveStatementsNR prepared statement.
	  * <code>
	 *          DELETE FROM STATEMENTS_NR WHERE COMMITTED=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int commitTransactionRemoveStatementsNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(commitTransactionRemoveStatementsNR, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"commitTransactionRemoveStatementsNR",stmtProvider.getSqlString(commitTransactionRemoveStatementsNR) ,""+ "transactionId="+(transactionId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[commitTransactionRemoveStatementsNR]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the CommitTransactionRemoveStatementsNR prepared statement
	 */
	public static class BatchCommitTransactionRemoveStatementsNR extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the CommitTransactionRemoveStatementsNR prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCommitTransactionRemoveStatementsNR(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,commitTransactionRemoveStatementsNR,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the commitTransactionRemoveStatementsNR prepared statement.
		 *
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the commitTransactionNamedGraphs prepared statement.
	  * <code>
	 *          UPDATE NAMEDGRAPHS SET COMMITTED=0 WHERE COMMITTED=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int commitTransactionNamedGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(commitTransactionNamedGraphs, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"commitTransactionNamedGraphs",stmtProvider.getSqlString(commitTransactionNamedGraphs) ,""+ "transactionId="+(transactionId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[commitTransactionNamedGraphs]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the CommitTransactionNamedGraphs prepared statement
	 */
	public static class BatchCommitTransactionNamedGraphs extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the CommitTransactionNamedGraphs prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCommitTransactionNamedGraphs(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,commitTransactionNamedGraphs,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the commitTransactionNamedGraphs prepared statement.
		 *
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the commitTransactionAddNamedGraphsNR prepared statement.
	  * <code>
	 *          UPDATE NAMEDGRAPHS_NR SET COMMITTED=0 WHERE COMMITTED=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int commitTransactionAddNamedGraphsNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(commitTransactionAddNamedGraphsNR, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"commitTransactionAddNamedGraphsNR",stmtProvider.getSqlString(commitTransactionAddNamedGraphsNR) ,""+ "transactionId="+(transactionId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[commitTransactionAddNamedGraphsNR]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the CommitTransactionAddNamedGraphsNR prepared statement
	 */
	public static class BatchCommitTransactionAddNamedGraphsNR extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the CommitTransactionAddNamedGraphsNR prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCommitTransactionAddNamedGraphsNR(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,commitTransactionAddNamedGraphsNR,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the commitTransactionAddNamedGraphsNR prepared statement.
		 *
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the commitTransactionRemoveNamedGraphsNR prepared statement.
	  * <code>
	 *          DELETE FROM NAMEDGRAPHS_NR WHERE COMMITTED=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int commitTransactionRemoveNamedGraphsNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(commitTransactionRemoveNamedGraphsNR, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"commitTransactionRemoveNamedGraphsNR",stmtProvider.getSqlString(commitTransactionRemoveNamedGraphsNR) ,""+ "transactionId="+(transactionId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[commitTransactionRemoveNamedGraphsNR]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the CommitTransactionRemoveNamedGraphsNR prepared statement
	 */
	public static class BatchCommitTransactionRemoveNamedGraphsNR extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the CommitTransactionRemoveNamedGraphsNR prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCommitTransactionRemoveNamedGraphsNR(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,commitTransactionRemoveNamedGraphsNR,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the commitTransactionRemoveNamedGraphsNR prepared statement.
		 *
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the commitTransactionStatementsRange prepared statement.
	  * <code>
	 *             UPDATE STATEMENTS SET COMMITTED=0 WHERE COMMITTED=? AND STATEMENTS.ID IN (SELECT ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ? )         
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *@param start template parameter
	 *@param end template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int commitTransactionStatementsRange (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, long start, long end, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(commitTransactionStatementsRange, new String[] {sessionPrefix},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"commitTransactionStatementsRange",stmtProvider.getSqlString(commitTransactionStatementsRange) ,""+ "transactionId="+(transactionId) + "," +"start="+(start) + "," +"end="+(end),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[commitTransactionStatementsRange]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the CommitTransactionStatementsRange prepared statement
	 */
	public static class BatchCommitTransactionStatementsRange extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the CommitTransactionStatementsRange prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCommitTransactionStatementsRange(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,commitTransactionStatementsRange,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the commitTransactionStatementsRange prepared statement.
		 *
	 *@param transactionId template parameter
	 *@param start template parameter
	 *@param end template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId, long start, long end) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the commitTransactionAddStatementsNRRange prepared statement.
	  * <code>
	 *              UPDATE STATEMENTS_NR  SET COMMITTED=0 WHERE COMMITTED=? AND STATEMENTS_NR.ID IN (SELECT ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ?)          
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *@param start template parameter
	 *@param end template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int commitTransactionAddStatementsNRRange (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, long start, long end, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(commitTransactionAddStatementsNRRange, new String[] {sessionPrefix},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"commitTransactionAddStatementsNRRange",stmtProvider.getSqlString(commitTransactionAddStatementsNRRange) ,""+ "transactionId="+(transactionId) + "," +"start="+(start) + "," +"end="+(end),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[commitTransactionAddStatementsNRRange]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the CommitTransactionAddStatementsNRRange prepared statement
	 */
	public static class BatchCommitTransactionAddStatementsNRRange extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the CommitTransactionAddStatementsNRRange prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCommitTransactionAddStatementsNRRange(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,commitTransactionAddStatementsNRRange,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the commitTransactionAddStatementsNRRange prepared statement.
		 *
	 *@param transactionId template parameter
	 *@param start template parameter
	 *@param end template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId, long start, long end) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the commitTransactionRemoveStatementsNRRange prepared statement.
	  * <code>
	 *              DELETE FROM STATEMENTS_NR WHERE COMMITTED=? AND STATEMENTS_NR.ID IN (SELECT ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ?)          
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *@param start template parameter
	 *@param end template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int commitTransactionRemoveStatementsNRRange (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, long start, long end, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(commitTransactionRemoveStatementsNRRange, new String[] {sessionPrefix},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"commitTransactionRemoveStatementsNRRange",stmtProvider.getSqlString(commitTransactionRemoveStatementsNRRange) ,""+ "transactionId="+(transactionId) + "," +"start="+(start) + "," +"end="+(end),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[commitTransactionRemoveStatementsNRRange]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the CommitTransactionRemoveStatementsNRRange prepared statement
	 */
	public static class BatchCommitTransactionRemoveStatementsNRRange extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the CommitTransactionRemoveStatementsNRRange prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCommitTransactionRemoveStatementsNRRange(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,commitTransactionRemoveStatementsNRRange,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the commitTransactionRemoveStatementsNRRange prepared statement.
		 *
	 *@param transactionId template parameter
	 *@param start template parameter
	 *@param end template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId, long start, long end) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the abortTransactionAddStatements prepared statement.
	  * <code>
	 *          DELETE FROM STATEMENTS WHERE COMMITTED=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int abortTransactionAddStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(abortTransactionAddStatements, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"abortTransactionAddStatements",stmtProvider.getSqlString(abortTransactionAddStatements) ,""+ "transactionId="+(transactionId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[abortTransactionAddStatements]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the AbortTransactionAddStatements prepared statement
	 */
	public static class BatchAbortTransactionAddStatements extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the AbortTransactionAddStatements prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchAbortTransactionAddStatements(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,abortTransactionAddStatements,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the abortTransactionAddStatements prepared statement.
		 *
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the abortTransactionAlreadyAddedStatements prepared statement.
	  * <code>
	 *          DELETE FROM STATEMENTS WHERE ID IN (SELECT {0}STMT_ID_TMP.ID FROM {0}STMT_ID_TMP) AND COMMITTED=0 AND REND IS NULL; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int abortTransactionAlreadyAddedStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(abortTransactionAlreadyAddedStatements, new String[] {sessionPrefix},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"abortTransactionAlreadyAddedStatements",stmtProvider.getSqlString(abortTransactionAlreadyAddedStatements) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[abortTransactionAlreadyAddedStatements]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the AbortTransactionAlreadyAddedStatements prepared statement
	 */
	public static class BatchAbortTransactionAlreadyAddedStatements extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the AbortTransactionAlreadyAddedStatements prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchAbortTransactionAlreadyAddedStatements(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,abortTransactionAlreadyAddedStatements,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the abortTransactionAlreadyAddedStatements prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the abortTransactionRemoveStatements prepared statement.
	  * <code>
	 *          UPDATE STATEMENTS SET REND=CAST(NULL AS {0}),COMMITTED=0 WHERE COMMITTED=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@param bigInt template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int abortTransactionRemoveStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, String bigInt) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(abortTransactionRemoveStatements, new String[] {bigInt},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"abortTransactionRemoveStatements",stmtProvider.getSqlString(abortTransactionRemoveStatements) ,""+ "transactionId="+(transactionId),""+ "bigInt="+((bigInt!=null)?bigInt.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[abortTransactionRemoveStatements]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the AbortTransactionRemoveStatements prepared statement
	 */
	public static class BatchAbortTransactionRemoveStatements extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the AbortTransactionRemoveStatements prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param bigInt template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchAbortTransactionRemoveStatements(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String bigInt) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,abortTransactionRemoveStatements,new String[] {bigInt});
		}
		
		/**
		 * Sets the input parameters for the abortTransactionRemoveStatements prepared statement.
		 *
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the abortTransactionAddStatementsNR prepared statement.
	  * <code>
	 *          DELETE FROM STATEMENTS_NR WHERE COMMITTED=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int abortTransactionAddStatementsNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(abortTransactionAddStatementsNR, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"abortTransactionAddStatementsNR",stmtProvider.getSqlString(abortTransactionAddStatementsNR) ,""+ "transactionId="+(transactionId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[abortTransactionAddStatementsNR]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the AbortTransactionAddStatementsNR prepared statement
	 */
	public static class BatchAbortTransactionAddStatementsNR extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the AbortTransactionAddStatementsNR prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchAbortTransactionAddStatementsNR(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,abortTransactionAddStatementsNR,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the abortTransactionAddStatementsNR prepared statement.
		 *
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the abortTransactionAlreadyAddedStatementsNR prepared statement.
	  * <code>
	 *          DELETE FROM STATEMENTS_NR WHERE ID  IN (SELECT {0}STMT_ID_TMP.ID FROM {0}STMT_ID_TMP); 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int abortTransactionAlreadyAddedStatementsNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(abortTransactionAlreadyAddedStatementsNR, new String[] {sessionPrefix},connection);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"abortTransactionAlreadyAddedStatementsNR",stmtProvider.getSqlString(abortTransactionAlreadyAddedStatementsNR) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[abortTransactionAlreadyAddedStatementsNR]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the AbortTransactionAlreadyAddedStatementsNR prepared statement
	 */
	public static class BatchAbortTransactionAlreadyAddedStatementsNR extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the AbortTransactionAlreadyAddedStatementsNR prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchAbortTransactionAlreadyAddedStatementsNR(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,abortTransactionAlreadyAddedStatementsNR,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the abortTransactionAlreadyAddedStatementsNR prepared statement.
		 *
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry () throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters();
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the abortTransactionRemoveStatementsNR prepared statement.
	  * <code>
	 *          UPDATE STATEMENTS_NR SET COMMITTED=0 WHERE COMMITTED=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int abortTransactionRemoveStatementsNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(abortTransactionRemoveStatementsNR, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"abortTransactionRemoveStatementsNR",stmtProvider.getSqlString(abortTransactionRemoveStatementsNR) ,""+ "transactionId="+(transactionId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[abortTransactionRemoveStatementsNR]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the AbortTransactionRemoveStatementsNR prepared statement
	 */
	public static class BatchAbortTransactionRemoveStatementsNR extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the AbortTransactionRemoveStatementsNR prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchAbortTransactionRemoveStatementsNR(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,abortTransactionRemoveStatementsNR,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the abortTransactionRemoveStatementsNR prepared statement.
		 *
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the abortTransactionAddStatementsRange prepared statement.
	  * <code>
	 *              DELETE FROM STATEMENTS WHERE COMMITTED=? AND STATEMENTS.ID IN  (SELECT ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ?)         
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *@param start template parameter
	 *@param end template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int abortTransactionAddStatementsRange (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, long start, long end, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(abortTransactionAddStatementsRange, new String[] {sessionPrefix},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"abortTransactionAddStatementsRange",stmtProvider.getSqlString(abortTransactionAddStatementsRange) ,""+ "transactionId="+(transactionId) + "," +"start="+(start) + "," +"end="+(end),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[abortTransactionAddStatementsRange]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the AbortTransactionAddStatementsRange prepared statement
	 */
	public static class BatchAbortTransactionAddStatementsRange extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the AbortTransactionAddStatementsRange prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchAbortTransactionAddStatementsRange(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,abortTransactionAddStatementsRange,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the abortTransactionAddStatementsRange prepared statement.
		 *
	 *@param transactionId template parameter
	 *@param start template parameter
	 *@param end template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId, long start, long end) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the abortTransactionRemoveStatementsRange prepared statement.
	  * <code>
	 *              UPDATE STATEMENTS SET REND=CAST(NULL AS {0}),COMMITTED=0 WHERE COMMITTED=? AND ST.ID=STATEMENTS.ID IN (SELECT ST.ID FROM  {1}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ?)         
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *@param start template parameter
	 *@param end template parameter
	 *
	 *@param bigInt template parameter
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int abortTransactionRemoveStatementsRange (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, long start, long end, String bigInt, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(abortTransactionRemoveStatementsRange, new String[] {bigInt, sessionPrefix},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"abortTransactionRemoveStatementsRange",stmtProvider.getSqlString(abortTransactionRemoveStatementsRange) ,""+ "transactionId="+(transactionId) + "," +"start="+(start) + "," +"end="+(end),""+ "bigInt="+((bigInt!=null)?bigInt.toString():"null") + "," +"sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[abortTransactionRemoveStatementsRange]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the AbortTransactionRemoveStatementsRange prepared statement
	 */
	public static class BatchAbortTransactionRemoveStatementsRange extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the AbortTransactionRemoveStatementsRange prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param bigInt template parameter
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchAbortTransactionRemoveStatementsRange(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String bigInt, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,abortTransactionRemoveStatementsRange,new String[] {bigInt, sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the abortTransactionRemoveStatementsRange prepared statement.
		 *
	 *@param transactionId template parameter
	 *@param start template parameter
	 *@param end template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId, long start, long end) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the abortTransactionAddStatementsNRRange prepared statement.
	  * <code>
	 *              DELETE FROM STATEMENTS_NR WHERE COMMITTED=? AND STATEMENTS.ID IN (SELECT ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ? )         
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *@param start template parameter
	 *@param end template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int abortTransactionAddStatementsNRRange (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, long start, long end, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(abortTransactionAddStatementsNRRange, new String[] {sessionPrefix},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"abortTransactionAddStatementsNRRange",stmtProvider.getSqlString(abortTransactionAddStatementsNRRange) ,""+ "transactionId="+(transactionId) + "," +"start="+(start) + "," +"end="+(end),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[abortTransactionAddStatementsNRRange]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the AbortTransactionAddStatementsNRRange prepared statement
	 */
	public static class BatchAbortTransactionAddStatementsNRRange extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the AbortTransactionAddStatementsNRRange prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchAbortTransactionAddStatementsNRRange(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,abortTransactionAddStatementsNRRange,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the abortTransactionAddStatementsNRRange prepared statement.
		 *
	 *@param transactionId template parameter
	 *@param start template parameter
	 *@param end template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId, long start, long end) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the abortTransactionRemoveStatementsNRRange prepared statement.
	  * <code>
	 *              UPDATE STATEMENTS_NR SET COMMITTED=0 WHERE COMMITTED=? AND STATEMENTS.ID IN (SELECT ST.ID FROM  {0}STMT_ID_TMP ST WHERE ST.STMTID>=? AND ST.STMTID < ?)         
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *@param start template parameter
	 *@param end template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int abortTransactionRemoveStatementsNRRange (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, long start, long end, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(abortTransactionRemoveStatementsNRRange, new String[] {sessionPrefix},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"abortTransactionRemoveStatementsNRRange",stmtProvider.getSqlString(abortTransactionRemoveStatementsNRRange) ,""+ "transactionId="+(transactionId) + "," +"start="+(start) + "," +"end="+(end),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[abortTransactionRemoveStatementsNRRange]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the AbortTransactionRemoveStatementsNRRange prepared statement
	 */
	public static class BatchAbortTransactionRemoveStatementsNRRange extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the AbortTransactionRemoveStatementsNRRange prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchAbortTransactionRemoveStatementsNRRange(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,abortTransactionRemoveStatementsNRRange,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the abortTransactionRemoveStatementsNRRange prepared statement.
		 *
	 *@param transactionId template parameter
	 *@param start template parameter
	 *@param end template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId, long start, long end) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the abortTransactionAddNamedGraphs prepared statement.
	  * <code>
	 *          DELETE FROM NAMEDGRAPHS WHERE COMMITTED=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int abortTransactionAddNamedGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(abortTransactionAddNamedGraphs, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"abortTransactionAddNamedGraphs",stmtProvider.getSqlString(abortTransactionAddNamedGraphs) ,""+ "transactionId="+(transactionId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[abortTransactionAddNamedGraphs]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the AbortTransactionAddNamedGraphs prepared statement
	 */
	public static class BatchAbortTransactionAddNamedGraphs extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the AbortTransactionAddNamedGraphs prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchAbortTransactionAddNamedGraphs(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,abortTransactionAddNamedGraphs,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the abortTransactionAddNamedGraphs prepared statement.
		 *
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the abortTransactionRemoveNamedGraphs prepared statement.
	  * <code>
	 *          UPDATE NAMEDGRAPHS SET HEND=CAST(NULL AS {0}),COMMITTED=0 WHERE COMMITTED=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@param bigInt template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int abortTransactionRemoveNamedGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, String bigInt) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(abortTransactionRemoveNamedGraphs, new String[] {bigInt},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"abortTransactionRemoveNamedGraphs",stmtProvider.getSqlString(abortTransactionRemoveNamedGraphs) ,""+ "transactionId="+(transactionId),""+ "bigInt="+((bigInt!=null)?bigInt.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[abortTransactionRemoveNamedGraphs]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the AbortTransactionRemoveNamedGraphs prepared statement
	 */
	public static class BatchAbortTransactionRemoveNamedGraphs extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the AbortTransactionRemoveNamedGraphs prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param bigInt template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchAbortTransactionRemoveNamedGraphs(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String bigInt) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,abortTransactionRemoveNamedGraphs,new String[] {bigInt});
		}
		
		/**
		 * Sets the input parameters for the abortTransactionRemoveNamedGraphs prepared statement.
		 *
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the abortTransactionAddNamedGraphsNR prepared statement.
	  * <code>
	 *          DELETE FROM NAMEDGRAPHS_NR WHERE COMMITTED=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int abortTransactionAddNamedGraphsNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(abortTransactionAddNamedGraphsNR, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"abortTransactionAddNamedGraphsNR",stmtProvider.getSqlString(abortTransactionAddNamedGraphsNR) ,""+ "transactionId="+(transactionId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[abortTransactionAddNamedGraphsNR]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the AbortTransactionAddNamedGraphsNR prepared statement
	 */
	public static class BatchAbortTransactionAddNamedGraphsNR extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the AbortTransactionAddNamedGraphsNR prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchAbortTransactionAddNamedGraphsNR(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,abortTransactionAddNamedGraphsNR,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the abortTransactionAddNamedGraphsNR prepared statement.
		 *
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the abortTransactionRemoveNamedGraphsNR prepared statement.
	  * <code>
	 *          UPDATE NAMEDGRAPHS_NR SET COMMITTED=0 WHERE COMMITTED=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int abortTransactionRemoveNamedGraphsNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(abortTransactionRemoveNamedGraphsNR, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
				int counter = 0;
				try{
					counter=ps.executeUpdate();
				}catch(java.sql.SQLException sqle){
					if(sqle.getErrorCode()==1205){
						int retries=0;
						while(retries<5){
							try {
	                        	Thread.sleep(5000);
	                        }catch(InterruptedException ie) {
	                            throw sqle;
	                        }
							try{			
								counter=ps.executeUpdate();
								break;
							}catch(java.sql.SQLException sqleInner){
								if(sqleInner.getErrorCode()==1205){
									retries++;
								}else{
									throw sqleInner;
								}
							}
						}
						if(retries>=5){
							throw sqle;
						}
					}else{
						throw sqle;
					}
				}
				return counter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"abortTransactionRemoveNamedGraphsNR",stmtProvider.getSqlString(abortTransactionRemoveNamedGraphsNR) ,""+ "transactionId="+(transactionId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[abortTransactionRemoveNamedGraphsNR]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the AbortTransactionRemoveNamedGraphsNR prepared statement
	 */
	public static class BatchAbortTransactionRemoveNamedGraphsNR extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the AbortTransactionRemoveNamedGraphsNR prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchAbortTransactionRemoveNamedGraphsNR(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,abortTransactionRemoveNamedGraphsNR,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the abortTransactionRemoveNamedGraphsNR prepared statement.
		 *
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}


}