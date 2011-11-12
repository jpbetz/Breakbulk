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
package org.openanzo.jdbc.container.sql;
// allow for all types that can be returned from a resultset

/**
 *	BaseSQL provides wrappers around SQL queries and transforms ResultSets into java objects
 *
 *	@author Generated Source from org.openanzo.jdbc.utils.opgen.jet
 */
public class BaseSQL {
	private static final org.slf4j.Logger                           log                   = org.slf4j.LoggerFactory.getLogger(BaseSQL.class);
	static final long CUTOFF=5;

	/**
	  *Constant "dropTable" used to reference prepared statement  base.dropTable
	  *
	  * <code>
	  *  		DROP TABLE {0} 	
	  * </code>
	  */
	public static final String dropTable = "base.dropTable";

	/**
	  *Constant "dropView" used to reference prepared statement  base.dropView
	  *
	  * <code>
	  *  		DROP VIEW {0} 	
	  * </code>
	  */
	public static final String dropView = "base.dropView";

	/**
	  *Constant "truncateTableMayCommit" used to reference prepared statement  base.truncateTableMayCommit
	  *
	  * <code>
	  *          DELETE FROM {0}     
	  * </code>
	  */
	public static final String truncateTableMayCommit = "base.truncateTableMayCommit";

	/**
	  *Constant "truncateTableWithSessionMayCommit" used to reference prepared statement  base.truncateTableWithSessionMayCommit
	  *
	  * <code>
	  *          DELETE FROM {0}{1}     
	  * </code>
	  */
	public static final String truncateTableWithSessionMayCommit = "base.truncateTableWithSessionMayCommit";

	/**
	  *Constant "clearTable" used to reference prepared statement  base.clearTable
	  *
	  * <code>
	  *  		DELETE FROM {0} 	
	  * </code>
	  */
	public static final String clearTable = "base.clearTable";

	/**
	  *Constant "clearTableWithSessionPrefix" used to reference prepared statement  base.clearTableWithSessionPrefix
	  *
	  * <code>
	  *          DELETE FROM {0}{1}     
	  * </code>
	  */
	public static final String clearTableWithSessionPrefix = "base.clearTableWithSessionPrefix";

	/**
	  *Constant "removeRowsFromTable" used to reference prepared statement  base.removeRowsFromTable
	  *
	  * <code>
	  *  		DELETE FROM {0} WHERE (GraphID = ?) 	
	  * </code>
	  */
	public static final String removeRowsFromTable = "base.removeRowsFromTable";

	/**
	  *Constant "insertGraph" used to reference prepared statement  base.insertGraph
	  *
	  * <code>
	  *  		INSERT INTO {0} (Name) VALUES (?) 	
	  * </code>
	  */
	public static final String insertGraph = "base.insertGraph";

	/**
	  *Constant "getRowCount" used to reference prepared statement  base.getRowCount
	  *
	  * <code>
	  *  		SELECT COUNT(1) FROM {0} 	
	  * </code>
	  */
	public static final String getRowCount = "base.getRowCount";

	/**
	  *Constant "lockTable" used to reference prepared statement  base.lockTable
	  *
	  * <code>
	  *  		LOCK TABLE {0} {1} 	
	  * </code>
	  */
	public static final String lockTable = "base.lockTable";

	/**
	  *Constant "unlockTable" used to reference prepared statement  base.unlockTable
	  *
	  * <code>
	  * 
	  * </code>
	  */
	public static final String unlockTable = "base.unlockTable";



	
	/**
	 * Runs the dropTable prepared statement.
	  * <code>
	 *  		DROP TABLE {0} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param tableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int dropTable (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(dropTable, new String[] {tableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"dropTable",stmtProvider.getSqlString(dropTable) ,"",""+ "tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[dropTable]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the DropTable prepared statement
	 */
	public static class BatchDropTable extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the DropTable prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param tableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchDropTable(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String tableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,dropTable,new String[] {tableName});
		}
		
		/**
		 * Sets the input parameters for the dropTable prepared statement.
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
	 * Runs the dropView prepared statement.
	  * <code>
	 *  		DROP VIEW {0} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param tableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int dropView (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(dropView, new String[] {tableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"dropView",stmtProvider.getSqlString(dropView) ,"",""+ "tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[dropView]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the DropView prepared statement
	 */
	public static class BatchDropView extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the DropView prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param tableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchDropView(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String tableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,dropView,new String[] {tableName});
		}
		
		/**
		 * Sets the input parameters for the dropView prepared statement.
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
	 * Runs the truncateTableMayCommit prepared statement.
	  * <code>
	 *          DELETE FROM {0}     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param tableName template parameter
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void truncateTableMayCommit (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(truncateTableMayCommit, new String[] {tableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"truncateTableMayCommit",stmtProvider.getSqlString(truncateTableMayCommit) ,"",""+ "tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[truncateTableMayCommit]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the TruncateTableMayCommit prepared statement
	 */
	public static class BatchTruncateTableMayCommit extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the TruncateTableMayCommit prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param tableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchTruncateTableMayCommit(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String tableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,truncateTableMayCommit,new String[] {tableName});
		}
		
		/**
		 * Sets the input parameters for the truncateTableMayCommit prepared statement.
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
	 * Runs the truncateTableWithSessionMayCommit prepared statement.
	  * <code>
	 *          DELETE FROM {0}{1}     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tableName template parameter
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void truncateTableWithSessionMayCommit (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.Statement stmt = null;
		//long startTimer=System.currentTimeMillis();
		try {
			String sql= stmtProvider.getSQL(truncateTableWithSessionMayCommit, new String[] {sessionPrefix, tableName});
			stmt=connection.createStatement();
			stmt.executeUpdate(sql);

		} catch (java.sql.SQLException e) {
			
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"truncateTableWithSessionMayCommit",stmtProvider.getSqlString(truncateTableWithSessionMayCommit) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tableName="+((tableName!=null)?tableName.toString():"null"));
			
		} finally {
			
			if (stmt != null) {
				try { 
					stmt.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing statement",sqle);
				}
			}
			
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[truncateTableWithSessionMayCommit]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the TruncateTableWithSessionMayCommit prepared statement
	 */
	public static class BatchTruncateTableWithSessionMayCommit extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the TruncateTableWithSessionMayCommit prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchTruncateTableWithSessionMayCommit(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,truncateTableWithSessionMayCommit,new String[] {sessionPrefix, tableName});
		}
		
		/**
		 * Sets the input parameters for the truncateTableWithSessionMayCommit prepared statement.
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
	 * Runs the clearTable prepared statement.
	  * <code>
	 *  		DELETE FROM {0} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param tableName template parameter
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void clearTable (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(clearTable, new String[] {tableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"clearTable",stmtProvider.getSqlString(clearTable) ,"",""+ "tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[clearTable]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the ClearTable prepared statement
	 */
	public static class BatchClearTable extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the ClearTable prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param tableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchClearTable(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String tableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,clearTable,new String[] {tableName});
		}
		
		/**
		 * Sets the input parameters for the clearTable prepared statement.
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
	 * Runs the clearTableWithSessionPrefix prepared statement.
	  * <code>
	 *          DELETE FROM {0}{1}     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param tableName template parameter
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void clearTableWithSessionPrefix (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(clearTableWithSessionPrefix, new String[] {sessionPrefix, tableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"clearTableWithSessionPrefix",stmtProvider.getSqlString(clearTableWithSessionPrefix) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[clearTableWithSessionPrefix]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the ClearTableWithSessionPrefix prepared statement
	 */
	public static class BatchClearTableWithSessionPrefix extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the ClearTableWithSessionPrefix prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchClearTableWithSessionPrefix(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,clearTableWithSessionPrefix,new String[] {sessionPrefix, tableName});
		}
		
		/**
		 * Sets the input parameters for the clearTableWithSessionPrefix prepared statement.
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
	 * Runs the removeRowsFromTable prepared statement.
	  * <code>
	 *  		DELETE FROM {0} WHERE (GraphID = ?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param GraphID template parameter
	 *
	 *@param tableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int removeRowsFromTable (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long GraphID, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(removeRowsFromTable, new String[] {tableName},connection); int argc = 1;
			ps.setLong(argc++, GraphID);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"removeRowsFromTable",stmtProvider.getSqlString(removeRowsFromTable) ,""+ "GraphID="+(GraphID),""+ "tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[removeRowsFromTable]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the RemoveRowsFromTable prepared statement
	 */
	public static class BatchRemoveRowsFromTable extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the RemoveRowsFromTable prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param tableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchRemoveRowsFromTable(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String tableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,removeRowsFromTable,new String[] {tableName});
		}
		
		/**
		 * Sets the input parameters for the removeRowsFromTable prepared statement.
		 *
	 *@param GraphID template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long GraphID) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, GraphID);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertGraph prepared statement.
	  * <code>
	 *  		INSERT INTO {0} (Name) VALUES (?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param Name template parameter
	 *
	 *@param tableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertGraph (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String Name, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertGraph, new String[] {tableName},connection); int argc = 1;
			if(Name == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"Name","insertGraph");
			} else {
				ps.setString(argc++, Name);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertGraph",stmtProvider.getSqlString(insertGraph) ,""+ "Name="+((Name!=null)?Name.toString():"null"),""+ "tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertGraph]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertGraph prepared statement
	 */
	public static class BatchInsertGraph extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertGraph prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param tableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertGraph(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String tableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertGraph,new String[] {tableName});
		}
		
		/**
		 * Sets the input parameters for the insertGraph prepared statement.
		 *
	 *@param Name template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (String Name) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			if(Name == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"Name","insertGraph");
			} else {
				ps.setString(argc++, Name);
			}
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the getRowCount prepared statement.
	  * <code>
	 *  		SELECT COUNT(1) FROM {0} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param tableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int getRowCount (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(getRowCount, new String[] {tableName},connection);
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
				int val = rs.getInt(1);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"getRowCount",stmtProvider.getSqlString(getRowCount) ,"",""+ "tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[getRowCount]"+endtimer);
		}
	}




	
	/**
	 * Runs the lockTable prepared statement.
	  * <code>
	 *  		LOCK TABLE {0} {1} 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param tableName template parameter
	 *@param mode template parameter
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void lockTable (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String tableName, String mode) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(lockTable, new String[] {tableName, mode},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"lockTable",stmtProvider.getSqlString(lockTable) ,"",""+ "tableName="+((tableName!=null)?tableName.toString():"null") + "," +"mode="+((mode!=null)?mode.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[lockTable]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the LockTable prepared statement
	 */
	public static class BatchLockTable extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the LockTable prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param tableName template parameter
	 *@param mode template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchLockTable(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String tableName, String mode) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,lockTable,new String[] {tableName, mode});
		}
		
		/**
		 * Sets the input parameters for the lockTable prepared statement.
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
	 * Runs the unlockTable prepared statement.
	  * <code>
	 * 
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param tableName template parameter
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void unlockTable (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(unlockTable, new String[] {tableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"unlockTable",stmtProvider.getSqlString(unlockTable) ,"",""+ "tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[unlockTable]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the UnlockTable prepared statement
	 */
	public static class BatchUnlockTable extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the UnlockTable prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param tableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchUnlockTable(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String tableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,unlockTable,new String[] {tableName});
		}
		
		/**
		 * Sets the input parameters for the unlockTable prepared statement.
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


}