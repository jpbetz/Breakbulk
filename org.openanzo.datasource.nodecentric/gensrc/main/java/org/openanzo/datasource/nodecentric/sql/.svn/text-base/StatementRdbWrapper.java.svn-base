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
 *	StatementRdbWrapper provides wrappers around SQL queries and transforms ResultSets into java objects
 *
 *	@author Generated Source from org.openanzo.jdbc.utils.opgen.jet
 */
public class StatementRdbWrapper {
	private static final org.slf4j.Logger                           log                   = org.slf4j.LoggerFactory.getLogger(StatementRdbWrapper.class);
	static final long CUTOFF=5;

	/**
	  *Constant "selectStatementId" used to reference prepared statement  Statement.selectStatementId
	  *
	  * <code>
	  *  		SELECT S.ID 		FROM STATEMENTS S 		WHERE SUBJECT = ? AND PREDICATE = ? AND OBJECT = ? AND S.NAMEDGRAPHID = ? AND REND IS NULL; 	
	  * </code>
	  */
	public static final String selectStatementId = "Statement.selectStatementId";

	/**
	  *Constant "insertStatement" used to reference prepared statement  Statement.insertStatement
	  *
	  * <code>
	  *  		INSERT INTO STATEMENTS(ID,METADATA,UUID,NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT,RSTART,COMMITTED) VALUES (?,?,?,?, ?, ?, ?, ?,0); 	
	  * </code>
	  */
	public static final String insertStatement = "Statement.insertStatement";

	/**
	  *Constant "insertStatementNR" used to reference prepared statement  Statement.insertStatementNR
	  *
	  * <code>
	  *  		INSERT INTO STATEMENTS_NR(ID,METADATA,NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT,COMMITTED) VALUES (?, ?,?, ?, ?, ?,0); 	
	  * </code>
	  */
	public static final String insertStatementNR = "Statement.insertStatementNR";

	/**
	  *Constant "deleteStatement" used to reference prepared statement  Statement.deleteStatement
	  *
	  * <code>
	  *  		UPDATE STATEMENTS SET REND=? WHERE ID=?; 	
	  * </code>
	  */
	public static final String deleteStatement = "Statement.deleteStatement";

	/**
	  *Constant "deleteStatementNR" used to reference prepared statement  Statement.deleteStatementNR
	  *
	  * <code>
	  *  		DELETE FROM STATEMENTS_NR WHERE ID=?; 	
	  * </code>
	  */
	public static final String deleteStatementNR = "Statement.deleteStatementNR";

	/**
	  *Constant "countStatements" used to reference prepared statement  Statement.countStatements
	  *
	  * <code>
	  *  		SELECT COUNT(1) 		FROM STATEMENTS 		WHERE ((REND IS NULL AND COMMITTED=0) OR (REND IS NOT NULL AND COMMITTED<0)); 		
	  * </code>
	  */
	public static final String countStatements = "Statement.countStatements";

	/**
	  *Constant "resolveDataset" used to reference prepared statement  Statement.resolveDataset
	  *
	  * <code>
	  *          SELECT PREDICATE,OBJECT         FROM STATEMENTS         WHERE ((REND IS NULL AND COMMITTED=0) OR (REND IS NOT NULL AND COMMITTED<0)) AND         PREDICATE IN ({0},{1},{2}) AND         SUBJECT = ? AND         NAMEDGRAPHID = ?         
	  * </code>
	  */
	public static final String resolveDataset = "Statement.resolveDataset";

	/**
	  *Constant "resolveDatasetNR" used to reference prepared statement  Statement.resolveDatasetNR
	  *
	  * <code>
	  *          SELECT PREDICATE,OBJECT         FROM STATEMENTS_NR         WHERE COMMITTED<=0 AND         PREDICATE IN ({0},{1},{2}) AND         SUBJECT = ? AND         NAMEDGRAPHID = ?         
	  * </code>
	  */
	public static final String resolveDatasetNR = "Statement.resolveDatasetNR";

	/**
	  *Constant "countStatementsNR" used to reference prepared statement  Statement.countStatementsNR
	  *
	  * <code>
	  *   		SELECT COUNT(1) 		FROM STATEMENTS_NR WHERE COMMITTED <=0; 		
	  * </code>
	  */
	public static final String countStatementsNR = "Statement.countStatementsNR";

	/**
	  *Constant "findMinMaxId" used to reference prepared statement  Statement.findMinMaxId
	  *
	  * <code>
	  *          SELECT MIN(ID),MAX(ID) FROM {0}     
	  * </code>
	  */
	public static final String findMinMaxId = "Statement.findMinMaxId";

	/**
	  *Constant "findLiteralStatementsRange" used to reference prepared statement  Statement.findLiteralStatementsRange
	  *
	  * <code>
	  *          SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT         FROM STATEMENTS WHERE COMMITTED=0 AND REND IS NULL AND OBJECT > ? and OBJECT < ?         
	  * </code>
	  */
	public static final String findLiteralStatementsRange = "Statement.findLiteralStatementsRange";

	/**
	  *Constant "findLiteralStatementsNRRange" used to reference prepared statement  Statement.findLiteralStatementsNRRange
	  *
	  * <code>
	  *          SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT          FROM STATEMENTS_NR WHERE COMMITTED=0 AND OBJECT > ? and OBJECT < ?         
	  * </code>
	  */
	public static final String findLiteralStatementsNRRange = "Statement.findLiteralStatementsNRRange";

	/**
	  *Constant "findLiteralStatements" used to reference prepared statement  Statement.findLiteralStatements
	  *
	  * <code>
	  *          SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT FROM ALL_STMTS_VIEW WHERE OBJECT > 2305843009213693953 and OBJECT < 6917529027641081855         
	  * </code>
	  */
	public static final String findLiteralStatements = "Statement.findLiteralStatements";

	/**
	  *Constant "findLiteralStatementsLimited" used to reference prepared statement  Statement.findLiteralStatementsLimited
	  *
	  * <code>
	  *          SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT FROM(         SELECT ROW_NUMBER() OVER (ORDER BY NAMEDGRAPHID) AS ROWNUM,NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT         FROM STATEMENTS WHERE COMMITTED=0 AND REND IS NULL AND OBJECT > 2305843009213693953 and OBJECT < 6917529027641081855) AS FOO         WHERE ROWNUM > ? AND ROWNUM<= ?         
	  * </code>
	  */
	public static final String findLiteralStatementsLimited = "Statement.findLiteralStatementsLimited";

	/**
	  *Constant "findLiteralStatementsNRLimited" used to reference prepared statement  Statement.findLiteralStatementsNRLimited
	  *
	  * <code>
	  *          SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT FROM(         SELECT ROW_NUMBER() OVER (ORDER BY NAMEDGRAPHID) AS ROWNUM,NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT         FROM STATEMENTS_NR WHERE COMMITTED=0 AND OBJECT > 2305843009213693953 and OBJECT < 6917529027641081855) AS FOO         WHERE ROWNUM > ? AND ROWNUM<= ?                  
	  * </code>
	  */
	public static final String findLiteralStatementsNRLimited = "Statement.findLiteralStatementsNRLimited";

	/**
	  *Constant "findLiteralStatementsLimitOffset" used to reference prepared statement  Statement.findLiteralStatementsLimitOffset
	  *
	  * <code>
	  *          SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT         FROM STATEMENTS WHERE COMMITTED=0 AND REND IS NULL AND OBJECT > 2305843009213693953 and OBJECT < 6917529027641081855         ORDER BY NAMEDGRAPHID ASC         LIMIT ? OFFSET ?         
	  * </code>
	  */
	public static final String findLiteralStatementsLimitOffset = "Statement.findLiteralStatementsLimitOffset";

	/**
	  *Constant "findLiteralStatementsNRLimitOffset" used to reference prepared statement  Statement.findLiteralStatementsNRLimitOffset
	  *
	  * <code>
	  *          SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT         FROM STATEMENTS_NR WHERE COMMITTED=0 AND OBJECT > 2305843009213693953 and OBJECT < 6917529027641081855         ORDER BY NAMEDGRAPHID ASC         LIMIT ? OFFSET ?         
	  * </code>
	  */
	public static final String findLiteralStatementsNRLimitOffset = "Statement.findLiteralStatementsNRLimitOffset";



	
	/**
	 * Runs the selectStatementId prepared statement.
	  * <code>
	 *  		SELECT S.ID 		FROM STATEMENTS S 		WHERE SUBJECT = ? AND PREDICATE = ? AND OBJECT = ? AND S.NAMEDGRAPHID = ? AND REND IS NULL; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param subject template parameter
	 *@param predicate template parameter
	 *@param object template parameter
	 *@param namedGraph template parameter
	 *
	 *@return  long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static long selectStatementId (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long subject, long predicate, long object, long namedGraph) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectStatementId, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, subject);
			ps.setLong(argc++, predicate);
			ps.setLong(argc++, object);
			ps.setLong(argc++, namedGraph);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectStatementId",stmtProvider.getSqlString(selectStatementId) ,""+ "subject="+(subject) + "," +"predicate="+(predicate) + "," +"object="+(object) + "," +"namedGraph="+(namedGraph),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectStatementId]"+endtimer);
		}
	}




	
	/**
	 * Runs the insertStatement prepared statement.
	  * <code>
	 *  		INSERT INTO STATEMENTS(ID,METADATA,UUID,NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT,RSTART,COMMITTED) VALUES (?,?,?,?, ?, ?, ?, ?,0); 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *@param metadata template parameter
	 *@param uuid template parameter
	 *@param namedGraphId template parameter
	 *@param subject template parameter
	 *@param predicate template parameter
	 *@param object template parameter
	 *@param rstart template parameter
	 *
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void insertStatement (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String id, int metadata, long uuid, long namedGraphId, long subject, long predicate, long object, long rstart) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertStatement, new String[] {},connection); int argc = 1;
			if(id == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"id","insertStatement");
			} else {
				ps.setString(argc++, id);
			}
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, uuid);
			ps.setLong(argc++, namedGraphId);
			ps.setLong(argc++, subject);
			ps.setLong(argc++, predicate);
			ps.setLong(argc++, object);
			ps.setLong(argc++, rstart);
			try{			
				ps.execute();
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
							ps.execute();
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

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertStatement",stmtProvider.getSqlString(insertStatement) ,""+ "id="+((id!=null)?id.toString():"null") + "," +"metadata="+(metadata) + "," +"uuid="+(uuid) + "," +"namedGraphId="+(namedGraphId) + "," +"subject="+(subject) + "," +"predicate="+(predicate) + "," +"object="+(object) + "," +"rstart="+(rstart),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertStatement]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertStatement prepared statement
	 */
	public static class BatchInsertStatement extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertStatement prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertStatement(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertStatement,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the insertStatement prepared statement.
		 *
	 *@param id template parameter
	 *@param metadata template parameter
	 *@param uuid template parameter
	 *@param namedGraphId template parameter
	 *@param subject template parameter
	 *@param predicate template parameter
	 *@param object template parameter
	 *@param rstart template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (String id, int metadata, long uuid, long namedGraphId, long subject, long predicate, long object, long rstart) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			if(id == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"id","insertStatement");
			} else {
				ps.setString(argc++, id);
			}
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, uuid);
			ps.setLong(argc++, namedGraphId);
			ps.setLong(argc++, subject);
			ps.setLong(argc++, predicate);
			ps.setLong(argc++, object);
			ps.setLong(argc++, rstart);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertStatementNR prepared statement.
	  * <code>
	 *  		INSERT INTO STATEMENTS_NR(ID,METADATA,NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT,COMMITTED) VALUES (?, ?,?, ?, ?, ?,0); 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *@param metadata template parameter
	 *@param namedGraphId template parameter
	 *@param subject template parameter
	 *@param predicate template parameter
	 *@param object template parameter
	 *
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void insertStatementNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String id, int metadata, long namedGraphId, long subject, long predicate, long object) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertStatementNR, new String[] {},connection); int argc = 1;
			if(id == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"id","insertStatementNR");
			} else {
				ps.setString(argc++, id);
			}
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedGraphId);
			ps.setLong(argc++, subject);
			ps.setLong(argc++, predicate);
			ps.setLong(argc++, object);
			try{			
				ps.execute();
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
							ps.execute();
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

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertStatementNR",stmtProvider.getSqlString(insertStatementNR) ,""+ "id="+((id!=null)?id.toString():"null") + "," +"metadata="+(metadata) + "," +"namedGraphId="+(namedGraphId) + "," +"subject="+(subject) + "," +"predicate="+(predicate) + "," +"object="+(object),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertStatementNR]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertStatementNR prepared statement
	 */
	public static class BatchInsertStatementNR extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertStatementNR prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertStatementNR(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertStatementNR,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the insertStatementNR prepared statement.
		 *
	 *@param id template parameter
	 *@param metadata template parameter
	 *@param namedGraphId template parameter
	 *@param subject template parameter
	 *@param predicate template parameter
	 *@param object template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (String id, int metadata, long namedGraphId, long subject, long predicate, long object) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			if(id == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"id","insertStatementNR");
			} else {
				ps.setString(argc++, id);
			}
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedGraphId);
			ps.setLong(argc++, subject);
			ps.setLong(argc++, predicate);
			ps.setLong(argc++, object);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the deleteStatement prepared statement.
	  * <code>
	 *  		UPDATE STATEMENTS SET REND=? WHERE ID=?; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param rend template parameter
	 *@param id template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int deleteStatement (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long rend, String id) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(deleteStatement, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, rend);
			if(id == null) {
				ps.setNull(argc++, java.sql.Types.VARCHAR);
			} else {
				ps.setString(argc++, id);
			}
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"deleteStatement",stmtProvider.getSqlString(deleteStatement) ,""+ "rend="+(rend) + "," +"id="+((id!=null)?id.toString():"null"),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[deleteStatement]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the DeleteStatement prepared statement
	 */
	public static class BatchDeleteStatement extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the DeleteStatement prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchDeleteStatement(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,deleteStatement,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the deleteStatement prepared statement.
		 *
	 *@param rend template parameter
	 *@param id template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long rend, String id) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, rend);
			if(id == null) {
				ps.setNull(argc++, java.sql.Types.VARCHAR);
			} else {
				ps.setString(argc++, id);
			}
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the deleteStatementNR prepared statement.
	  * <code>
	 *  		DELETE FROM STATEMENTS_NR WHERE ID=?; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int deleteStatementNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String id) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(deleteStatementNR, new String[] {},connection); int argc = 1;
			if(id == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"id","deleteStatementNR");
			} else {
				ps.setString(argc++, id);
			}
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"deleteStatementNR",stmtProvider.getSqlString(deleteStatementNR) ,""+ "id="+((id!=null)?id.toString():"null"),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[deleteStatementNR]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the DeleteStatementNR prepared statement
	 */
	public static class BatchDeleteStatementNR extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the DeleteStatementNR prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchDeleteStatementNR(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,deleteStatementNR,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the deleteStatementNR prepared statement.
		 *
	 *@param id template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (String id) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			if(id == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"id","deleteStatementNR");
			} else {
				ps.setString(argc++, id);
			}
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the countStatements prepared statement.
	  * <code>
	 *  		SELECT COUNT(1) 		FROM STATEMENTS 		WHERE ((REND IS NULL AND COMMITTED=0) OR (REND IS NOT NULL AND COMMITTED<0)); 		
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
	public static long countStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(countStatements, new String[] {},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"countStatements",stmtProvider.getSqlString(countStatements) ,"","");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[countStatements]"+endtimer);
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the resolveDataset prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<ResolveDatasetResult> transformResolveDataset = new org.openanzo.jdbc.utils.Transformer<ResolveDatasetResult>(){
		public ResolveDatasetResult transform(java.sql.ResultSet rs) {

			
				ResolveDatasetResult result = new ResolveDatasetResult();
				try {
				result.predicateId=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:predicateId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.object=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:object",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the resolveDataset prepared statement.
	  * <code>
	 *          SELECT PREDICATE,OBJECT         FROM STATEMENTS         WHERE ((REND IS NULL AND COMMITTED=0) OR (REND IS NOT NULL AND COMMITTED<0)) AND         PREDICATE IN ({0},{1},{2}) AND         SUBJECT = ? AND         NAMEDGRAPHID = ?         
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param gId template parameter
	 *@param g2Id template parameter
	 *
	 *@param ngId template parameter
	 *@param dgId template parameter
	 *@param dngId template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<ResolveDatasetResult> resolveDataset (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long gId, long g2Id, String ngId, String dgId, String dngId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(resolveDataset, new String[] {ngId, dgId, dngId},connection); int argc = 1;
			ps.setLong(argc++, gId);
			ps.setLong(argc++, g2Id);
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

			org.openanzo.jdbc.utils.ClosableIterator<ResolveDatasetResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<ResolveDatasetResult>(rs, ps, stmtProvider, transformResolveDataset);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"resolveDataset",stmtProvider.getSqlString(resolveDataset) ,""+ "gId="+(gId) + "," +"g2Id="+(g2Id),""+ "ngId="+((ngId!=null)?ngId.toString():"null") + "," +"dgId="+((dgId!=null)?dgId.toString():"null") + "," +"dngId="+((dngId!=null)?dngId.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[resolveDataset]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of ResolveDatasetResult
	 */
	public static class ResolveDatasetResult {
			/**Value for the "predicateId" result value*/
			private long predicateId;
			/**Value for the "object" result value*/
			private long object;

		/**
		  *Get PredicateId value
		  *@return PredicateId value
		  */
			public long getPredicateId() {
				return this.predicateId;
			}

		/**
		  *Get Object value
		  *@return Object value
		  */
			public long getObject() {
				return this.object;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the resolveDatasetNR prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<ResolveDatasetNRResult> transformResolveDatasetNR = new org.openanzo.jdbc.utils.Transformer<ResolveDatasetNRResult>(){
		public ResolveDatasetNRResult transform(java.sql.ResultSet rs) {

			
				ResolveDatasetNRResult result = new ResolveDatasetNRResult();
				try {
				result.predicateId=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:predicateId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.object=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:object",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the resolveDatasetNR prepared statement.
	  * <code>
	 *          SELECT PREDICATE,OBJECT         FROM STATEMENTS_NR         WHERE COMMITTED<=0 AND         PREDICATE IN ({0},{1},{2}) AND         SUBJECT = ? AND         NAMEDGRAPHID = ?         
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param gId template parameter
	 *@param g2Id template parameter
	 *
	 *@param ngId template parameter
	 *@param dgId template parameter
	 *@param dngId template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<ResolveDatasetNRResult> resolveDatasetNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long gId, long g2Id, String ngId, String dgId, String dngId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(resolveDatasetNR, new String[] {ngId, dgId, dngId},connection); int argc = 1;
			ps.setLong(argc++, gId);
			ps.setLong(argc++, g2Id);
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

			org.openanzo.jdbc.utils.ClosableIterator<ResolveDatasetNRResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<ResolveDatasetNRResult>(rs, ps, stmtProvider, transformResolveDatasetNR);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"resolveDatasetNR",stmtProvider.getSqlString(resolveDatasetNR) ,""+ "gId="+(gId) + "," +"g2Id="+(g2Id),""+ "ngId="+((ngId!=null)?ngId.toString():"null") + "," +"dgId="+((dgId!=null)?dgId.toString():"null") + "," +"dngId="+((dngId!=null)?dngId.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[resolveDatasetNR]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of ResolveDatasetNRResult
	 */
	public static class ResolveDatasetNRResult {
			/**Value for the "predicateId" result value*/
			private long predicateId;
			/**Value for the "object" result value*/
			private long object;

		/**
		  *Get PredicateId value
		  *@return PredicateId value
		  */
			public long getPredicateId() {
				return this.predicateId;
			}

		/**
		  *Get Object value
		  *@return Object value
		  */
			public long getObject() {
				return this.object;
			}

	}



	
	/**
	 * Runs the countStatementsNR prepared statement.
	  * <code>
	 *   		SELECT COUNT(1) 		FROM STATEMENTS_NR WHERE COMMITTED <=0; 		
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
	public static long countStatementsNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(countStatementsNR, new String[] {},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"countStatementsNR",stmtProvider.getSqlString(countStatementsNR) ,"","");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[countStatementsNR]"+endtimer);
		}
	}




	
	/**
	 * Runs the findMinMaxId prepared statement.
	  * <code>
	 *          SELECT MIN(ID),MAX(ID) FROM {0}     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param tableName template parameter
	 *@return  FindMinMaxIdResult
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static FindMinMaxIdResult findMinMaxId (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(findMinMaxId, new String[] {tableName},connection);
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
		FindMinMaxIdResult result=new FindMinMaxIdResult();
				result.min=rs.getLong(1);
				result.max=rs.getLong(2);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"findMinMaxId",stmtProvider.getSqlString(findMinMaxId) ,"",""+ "tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[findMinMaxId]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of FindMinMaxIdResult
	 */
	public static class FindMinMaxIdResult {
			/**Value for the "min" result value*/
			private long min;
			/**Value for the "max" result value*/
			private long max;

		/**
		  *Get Min value
		  *@return Min value
		  */
			public long getMin() {
				return this.min;
			}

		/**
		  *Get Max value
		  *@return Max value
		  */
			public long getMax() {
				return this.max;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the findLiteralStatementsRange prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<FindLiteralStatementsRangeResult> transformFindLiteralStatementsRange = new org.openanzo.jdbc.utils.Transformer<FindLiteralStatementsRangeResult>(){
		public FindLiteralStatementsRangeResult transform(java.sql.ResultSet rs) {

			
				FindLiteralStatementsRangeResult result = new FindLiteralStatementsRangeResult();
				try {
				result.namedGraphId=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the findLiteralStatementsRange prepared statement.
	  * <code>
	 *          SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT         FROM STATEMENTS WHERE COMMITTED=0 AND REND IS NULL AND OBJECT > ? and OBJECT < ?         
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
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<FindLiteralStatementsRangeResult> findLiteralStatementsRange (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long start, long end) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(findLiteralStatementsRange, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
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

			org.openanzo.jdbc.utils.ClosableIterator<FindLiteralStatementsRangeResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<FindLiteralStatementsRangeResult>(rs, ps, stmtProvider, transformFindLiteralStatementsRange);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"findLiteralStatementsRange",stmtProvider.getSqlString(findLiteralStatementsRange) ,""+ "start="+(start) + "," +"end="+(end),"");
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[findLiteralStatementsRange]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of FindLiteralStatementsRangeResult
	 */
	public static class FindLiteralStatementsRangeResult {
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the findLiteralStatementsNRRange prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<FindLiteralStatementsNRRangeResult> transformFindLiteralStatementsNRRange = new org.openanzo.jdbc.utils.Transformer<FindLiteralStatementsNRRangeResult>(){
		public FindLiteralStatementsNRRangeResult transform(java.sql.ResultSet rs) {

			
				FindLiteralStatementsNRRangeResult result = new FindLiteralStatementsNRRangeResult();
				try {
				result.namedGraphId=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the findLiteralStatementsNRRange prepared statement.
	  * <code>
	 *          SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT          FROM STATEMENTS_NR WHERE COMMITTED=0 AND OBJECT > ? and OBJECT < ?         
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
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<FindLiteralStatementsNRRangeResult> findLiteralStatementsNRRange (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long start, long end) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(findLiteralStatementsNRRange, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
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

			org.openanzo.jdbc.utils.ClosableIterator<FindLiteralStatementsNRRangeResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<FindLiteralStatementsNRRangeResult>(rs, ps, stmtProvider, transformFindLiteralStatementsNRRange);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"findLiteralStatementsNRRange",stmtProvider.getSqlString(findLiteralStatementsNRRange) ,""+ "start="+(start) + "," +"end="+(end),"");
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[findLiteralStatementsNRRange]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of FindLiteralStatementsNRRangeResult
	 */
	public static class FindLiteralStatementsNRRangeResult {
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the findLiteralStatements prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<FindLiteralStatementsResult> transformFindLiteralStatements = new org.openanzo.jdbc.utils.Transformer<FindLiteralStatementsResult>(){
		public FindLiteralStatementsResult transform(java.sql.ResultSet rs) {

			
				FindLiteralStatementsResult result = new FindLiteralStatementsResult();
				try {
				result.namedGraphId=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subject=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subject",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.predicate=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:predicate",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.object=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:object",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the findLiteralStatements prepared statement.
	  * <code>
	 *          SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT FROM ALL_STMTS_VIEW WHERE OBJECT > 2305843009213693953 and OBJECT < 6917529027641081855         
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<FindLiteralStatementsResult> findLiteralStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(findLiteralStatements, new String[] {},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<FindLiteralStatementsResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<FindLiteralStatementsResult>(rs, ps, stmtProvider, transformFindLiteralStatements);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"findLiteralStatements",stmtProvider.getSqlString(findLiteralStatements) ,"","");
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[findLiteralStatements]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of FindLiteralStatementsResult
	 */
	public static class FindLiteralStatementsResult {
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subject" result value*/
			private long subject;
			/**Value for the "predicate" result value*/
			private long predicate;
			/**Value for the "object" result value*/
			private long object;

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subject value
		  *@return Subject value
		  */
			public long getSubject() {
				return this.subject;
			}

		/**
		  *Get Predicate value
		  *@return Predicate value
		  */
			public long getPredicate() {
				return this.predicate;
			}

		/**
		  *Get Object value
		  *@return Object value
		  */
			public long getObject() {
				return this.object;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the findLiteralStatementsLimited prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<FindLiteralStatementsLimitedResult> transformFindLiteralStatementsLimited = new org.openanzo.jdbc.utils.Transformer<FindLiteralStatementsLimitedResult>(){
		public FindLiteralStatementsLimitedResult transform(java.sql.ResultSet rs) {

			
				FindLiteralStatementsLimitedResult result = new FindLiteralStatementsLimitedResult();
				try {
				result.namedGraphId=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the findLiteralStatementsLimited prepared statement.
	  * <code>
	 *          SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT FROM(         SELECT ROW_NUMBER() OVER (ORDER BY NAMEDGRAPHID) AS ROWNUM,NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT         FROM STATEMENTS WHERE COMMITTED=0 AND REND IS NULL AND OBJECT > 2305843009213693953 and OBJECT < 6917529027641081855) AS FOO         WHERE ROWNUM > ? AND ROWNUM<= ?         
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
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<FindLiteralStatementsLimitedResult> findLiteralStatementsLimited (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long start, long end, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(findLiteralStatementsLimited, new String[] {sessionPrefix},connection); int argc = 1;
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
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

			org.openanzo.jdbc.utils.ClosableIterator<FindLiteralStatementsLimitedResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<FindLiteralStatementsLimitedResult>(rs, ps, stmtProvider, transformFindLiteralStatementsLimited);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"findLiteralStatementsLimited",stmtProvider.getSqlString(findLiteralStatementsLimited) ,""+ "start="+(start) + "," +"end="+(end),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[findLiteralStatementsLimited]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of FindLiteralStatementsLimitedResult
	 */
	public static class FindLiteralStatementsLimitedResult {
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the findLiteralStatementsNRLimited prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<FindLiteralStatementsNRLimitedResult> transformFindLiteralStatementsNRLimited = new org.openanzo.jdbc.utils.Transformer<FindLiteralStatementsNRLimitedResult>(){
		public FindLiteralStatementsNRLimitedResult transform(java.sql.ResultSet rs) {

			
				FindLiteralStatementsNRLimitedResult result = new FindLiteralStatementsNRLimitedResult();
				try {
				result.namedGraphId=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the findLiteralStatementsNRLimited prepared statement.
	  * <code>
	 *          SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT FROM(         SELECT ROW_NUMBER() OVER (ORDER BY NAMEDGRAPHID) AS ROWNUM,NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT         FROM STATEMENTS_NR WHERE COMMITTED=0 AND OBJECT > 2305843009213693953 and OBJECT < 6917529027641081855) AS FOO         WHERE ROWNUM > ? AND ROWNUM<= ?                  
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
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<FindLiteralStatementsNRLimitedResult> findLiteralStatementsNRLimited (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long start, long end, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(findLiteralStatementsNRLimited, new String[] {sessionPrefix},connection); int argc = 1;
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
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

			org.openanzo.jdbc.utils.ClosableIterator<FindLiteralStatementsNRLimitedResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<FindLiteralStatementsNRLimitedResult>(rs, ps, stmtProvider, transformFindLiteralStatementsNRLimited);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"findLiteralStatementsNRLimited",stmtProvider.getSqlString(findLiteralStatementsNRLimited) ,""+ "start="+(start) + "," +"end="+(end),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[findLiteralStatementsNRLimited]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of FindLiteralStatementsNRLimitedResult
	 */
	public static class FindLiteralStatementsNRLimitedResult {
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the findLiteralStatementsLimitOffset prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<FindLiteralStatementsLimitOffsetResult> transformFindLiteralStatementsLimitOffset = new org.openanzo.jdbc.utils.Transformer<FindLiteralStatementsLimitOffsetResult>(){
		public FindLiteralStatementsLimitOffsetResult transform(java.sql.ResultSet rs) {

			
				FindLiteralStatementsLimitOffsetResult result = new FindLiteralStatementsLimitOffsetResult();
				try {
				result.namedGraphId=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the findLiteralStatementsLimitOffset prepared statement.
	  * <code>
	 *          SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT         FROM STATEMENTS WHERE COMMITTED=0 AND REND IS NULL AND OBJECT > 2305843009213693953 and OBJECT < 6917529027641081855         ORDER BY NAMEDGRAPHID ASC         LIMIT ? OFFSET ?         
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
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<FindLiteralStatementsLimitOffsetResult> findLiteralStatementsLimitOffset (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long start, long end, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(findLiteralStatementsLimitOffset, new String[] {sessionPrefix},connection); int argc = 1;
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
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

			org.openanzo.jdbc.utils.ClosableIterator<FindLiteralStatementsLimitOffsetResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<FindLiteralStatementsLimitOffsetResult>(rs, ps, stmtProvider, transformFindLiteralStatementsLimitOffset);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"findLiteralStatementsLimitOffset",stmtProvider.getSqlString(findLiteralStatementsLimitOffset) ,""+ "start="+(start) + "," +"end="+(end),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[findLiteralStatementsLimitOffset]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of FindLiteralStatementsLimitOffsetResult
	 */
	public static class FindLiteralStatementsLimitOffsetResult {
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the findLiteralStatementsNRLimitOffset prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<FindLiteralStatementsNRLimitOffsetResult> transformFindLiteralStatementsNRLimitOffset = new org.openanzo.jdbc.utils.Transformer<FindLiteralStatementsNRLimitOffsetResult>(){
		public FindLiteralStatementsNRLimitOffsetResult transform(java.sql.ResultSet rs) {

			
				FindLiteralStatementsNRLimitOffsetResult result = new FindLiteralStatementsNRLimitOffsetResult();
				try {
				result.namedGraphId=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the findLiteralStatementsNRLimitOffset prepared statement.
	  * <code>
	 *          SELECT NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT         FROM STATEMENTS_NR WHERE COMMITTED=0 AND OBJECT > 2305843009213693953 and OBJECT < 6917529027641081855         ORDER BY NAMEDGRAPHID ASC         LIMIT ? OFFSET ?         
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
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<FindLiteralStatementsNRLimitOffsetResult> findLiteralStatementsNRLimitOffset (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long start, long end, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(findLiteralStatementsNRLimitOffset, new String[] {sessionPrefix},connection); int argc = 1;
			ps.setLong(argc++, start);
			ps.setLong(argc++, end);
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

			org.openanzo.jdbc.utils.ClosableIterator<FindLiteralStatementsNRLimitOffsetResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<FindLiteralStatementsNRLimitOffsetResult>(rs, ps, stmtProvider, transformFindLiteralStatementsNRLimitOffset);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"findLiteralStatementsNRLimitOffset",stmtProvider.getSqlString(findLiteralStatementsNRLimitOffset) ,""+ "start="+(start) + "," +"end="+(end),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[findLiteralStatementsNRLimitOffset]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of FindLiteralStatementsNRLimitOffsetResult
	 */
	public static class FindLiteralStatementsNRLimitOffsetResult {
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "subj" result value*/
			private long subj;
			/**Value for the "prop" result value*/
			private long prop;
			/**Value for the "obj" result value*/
			private long obj;

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Subj value
		  *@return Subj value
		  */
			public long getSubj() {
				return this.subj;
			}

		/**
		  *Get Prop value
		  *@return Prop value
		  */
			public long getProp() {
				return this.prop;
			}

		/**
		  *Get Obj value
		  *@return Obj value
		  */
			public long getObj() {
				return this.obj;
			}

	}

}