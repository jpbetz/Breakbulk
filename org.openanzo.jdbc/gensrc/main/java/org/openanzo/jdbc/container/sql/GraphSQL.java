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
 *	GraphSQL provides wrappers around SQL queries and transforms ResultSets into java objects
 *
 *	@author Generated Source from org.openanzo.jdbc.utils.opgen.jet
 */
public class GraphSQL {
	private static final org.slf4j.Logger                           log                   = org.slf4j.LoggerFactory.getLogger(GraphSQL.class);
	static final long CUTOFF=5;

	/**
	  *Constant "insertStatement" used to reference prepared statement  graph.insertStatement
	  *
	  * <code>
	  *  		INSERT INTO {0} (METADATA,NAMEDGRAPHID,SUBJ, PROP, OBJ) VALUES(?,?, ?,  ?, ?) 	
	  * </code>
	  */
	public static final String insertStatement = "graph.insertStatement";

	/**
	  *Constant "statementExists" used to reference prepared statement  graph.statementExists
	  *
	  * <code>
	  *  		SELECT COUNT(1) FROM {0} WHERE NAMEDGRAPHID=? AND SUBJ = ? AND PROP = ? AND OBJ = ? 	
	  * </code>
	  */
	public static final String statementExists = "graph.statementExists";

	/**
	  *Constant "size" used to reference prepared statement  graph.size
	  *
	  * <code>
	  *  		SELECT COUNT(1) FROM {0} WHERE NAMEDGRAPHID=? 	
	  * </code>
	  */
	public static final String size = "graph.size";

	/**
	  *Constant "deleteStatement" used to reference prepared statement  graph.deleteStatement
	  *
	  * <code>
	  *  		DELETE FROM {0} WHERE NAMEDGRAPHID=? AND SUBJ = ? AND PROP = ? AND OBJ = ? 	
	  * </code>
	  */
	public static final String deleteStatement = "graph.deleteStatement";

	/**
	  *Constant "resolveStatements" used to reference prepared statement  graph.resolveStatements
	  *
	  * <code>
	  *  		SELECT A.METADATA,A.NAMEDGRAPHID,A.SUBJ, A.PROP, A.OBJ FROM {0} AS A WHERE EXISTS(SELECT B.NAMEDGRAPHID FROM {1} AS B WHERE A.METADATA=B.METADATA AND A.NAMEDGRAPHID=B.NAMEDGRAPHID AND A.SUBJ = B.SUBJ AND A.PROP = B.PROP AND A.OBJ = B.OBJ	) 	
	  * </code>
	  */
	public static final String resolveStatements = "graph.resolveStatements";

	/**
	  *Constant "purgeInsertStatements" used to reference prepared statement  graph.purgeInsertStatements
	  *
	  * <code>
	  *  			DELETE FROM {0} ST WHERE EXISTS (SELECT S.NAMEDGRAPHID  FROM {2} S  WHERE ST.METADATA=S.METADATA AND  S.NAMEDGRAPHID=ST.NAMEDGRAPHID AND S.SUBJ=ST.SUBJ AND S.PROP=ST.PROP AND S.OBJ=ST.OBJ) 	
	  * </code>
	  */
	public static final String purgeInsertStatements = "graph.purgeInsertStatements";

	/**
	  *Constant "commitInsertStatements" used to reference prepared statement  graph.commitInsertStatements
	  *
	  * <code>
	  *  		INSERT INTO {1} (METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) 		SELECT  			ST.METADATA, 			ST.NAMEDGRAPHID, 			ST.SUBJ, 			ST.PROP, 			ST.OBJ 		FROM  {0} ST 	
	  * </code>
	  */
	public static final String commitInsertStatements = "graph.commitInsertStatements";

	/**
	  *Constant "commitInsertStatementsNew" used to reference prepared statement  graph.commitInsertStatementsNew
	  *
	  * <code>
	  *  		MERGE INTO {1} USING {0} ON {1}.NAMEDGRAPHID = {0}.NAMEDGRAPHID AND {1}.SUBJ = {0}.SUBJ AND {1}.PROP = {0}.PROP AND {1}.OBJ = {0}.OBJ      	WHEN NOT MATCHED THEN INSERT (NAMEDGRAPHID,SUBJ,PROP,OBJ) VALUES({0}.NAMEDGRAPHID,{0}.SUBJ,{0}.PROP,{0}.OBJ)      	ELSE IGNORE      	 	
	  * </code>
	  */
	public static final String commitInsertStatementsNew = "graph.commitInsertStatementsNew";

	/**
	  *Constant "clear" used to reference prepared statement  graph.clear
	  *
	  * <code>
	  *  		DELETE FROM {0} WHERE NAMEDGRAPHID=? 	
	  * </code>
	  */
	public static final String clear = "graph.clear";



	
	/**
	 * Runs the insertStatement prepared statement.
	  * <code>
	 *  		INSERT INTO {0} (METADATA,NAMEDGRAPHID,SUBJ, PROP, OBJ) VALUES(?,?, ?,  ?, ?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param metadata template parameter
	 *@param namedgraphId template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
	 *
	 *@param graphTableName template parameter
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void insertStatement (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, int metadata, long namedgraphId, long subj, long prop, long obj, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertStatement, new String[] {graphTableName},connection); int argc = 1;
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertStatement",stmtProvider.getSqlString(insertStatement) ,""+ "metadata="+(metadata) + "," +"namedgraphId="+(namedgraphId) + "," +"subj="+(subj) + "," +"prop="+(prop) + "," +"obj="+(obj),""+ "graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
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
	 *@param graphTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertStatement(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String graphTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertStatement,new String[] {graphTableName});
		}
		
		/**
		 * Sets the input parameters for the insertStatement prepared statement.
		 *
	 *@param metadata template parameter
	 *@param namedgraphId template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (int metadata, long namedgraphId, long subj, long prop, long obj) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setInt(argc++, metadata);
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the statementExists prepared statement.
	  * <code>
	 *  		SELECT COUNT(1) FROM {0} WHERE NAMEDGRAPHID=? AND SUBJ = ? AND PROP = ? AND OBJ = ? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedgraphId template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
	 *
	 *@param graphTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int statementExists (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedgraphId, long subj, long prop, long obj, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(statementExists, new String[] {graphTableName},connection); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"statementExists",stmtProvider.getSqlString(statementExists) ,""+ "namedgraphId="+(namedgraphId) + "," +"subj="+(subj) + "," +"prop="+(prop) + "," +"obj="+(obj),""+ "graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[statementExists]"+endtimer);
		}
	}




	
	/**
	 * Runs the size prepared statement.
	  * <code>
	 *  		SELECT COUNT(1) FROM {0} WHERE NAMEDGRAPHID=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedgraphId template parameter
	 *
	 *@param graphTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int size (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedgraphId, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(size, new String[] {graphTableName},connection); int argc = 1;
			ps.setLong(argc++, namedgraphId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"size",stmtProvider.getSqlString(size) ,""+ "namedgraphId="+(namedgraphId),""+ "graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[size]"+endtimer);
		}
	}




	
	/**
	 * Runs the deleteStatement prepared statement.
	  * <code>
	 *  		DELETE FROM {0} WHERE NAMEDGRAPHID=? AND SUBJ = ? AND PROP = ? AND OBJ = ? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedgraphId template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
	 *
	 *@param graphTableName template parameter
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void deleteStatement (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedgraphId, long subj, long prop, long obj, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(deleteStatement, new String[] {graphTableName},connection); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"deleteStatement",stmtProvider.getSqlString(deleteStatement) ,""+ "namedgraphId="+(namedgraphId) + "," +"subj="+(subj) + "," +"prop="+(prop) + "," +"obj="+(obj),""+ "graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
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
	 *@param graphTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchDeleteStatement(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String graphTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,deleteStatement,new String[] {graphTableName});
		}
		
		/**
		 * Sets the input parameters for the deleteStatement prepared statement.
		 *
	 *@param namedgraphId template parameter
	 *@param subj template parameter
	 *@param prop template parameter
	 *@param obj template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long namedgraphId, long subj, long prop, long obj) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, namedgraphId);
			ps.setLong(argc++, subj);
			ps.setLong(argc++, prop);
			ps.setLong(argc++, obj);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the resolveStatements prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<ResolveStatementsResult> transformResolveStatements = new org.openanzo.jdbc.utils.Transformer<ResolveStatementsResult>(){
		public ResolveStatementsResult transform(java.sql.ResultSet rs) {

			
				ResolveStatementsResult result = new ResolveStatementsResult();
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
	 * Runs the resolveStatements prepared statement.
	  * <code>
	 *  		SELECT A.METADATA,A.NAMEDGRAPHID,A.SUBJ, A.PROP, A.OBJ FROM {0} AS A WHERE EXISTS(SELECT B.NAMEDGRAPHID FROM {1} AS B WHERE A.METADATA=B.METADATA AND A.NAMEDGRAPHID=B.NAMEDGRAPHID AND A.SUBJ = B.SUBJ AND A.PROP = B.PROP AND A.OBJ = B.OBJ	) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param bulkResolutionTableName template parameter
	 *@param statementTableName template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<ResolveStatementsResult> resolveStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String bulkResolutionTableName, String statementTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(resolveStatements, new String[] {bulkResolutionTableName, statementTableName},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<ResolveStatementsResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<ResolveStatementsResult>(rs, ps, stmtProvider, transformResolveStatements);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"resolveStatements",stmtProvider.getSqlString(resolveStatements) ,"",""+ "bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null") + "," +"statementTableName="+((statementTableName!=null)?statementTableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[resolveStatements]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of ResolveStatementsResult
	 */
	public static class ResolveStatementsResult {
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
	 * Runs the purgeInsertStatements prepared statement.
	  * <code>
	 *  			DELETE FROM {0} ST WHERE EXISTS (SELECT S.NAMEDGRAPHID  FROM {2} S  WHERE ST.METADATA=S.METADATA AND  S.NAMEDGRAPHID=ST.NAMEDGRAPHID AND S.SUBJ=ST.SUBJ AND S.PROP=ST.PROP AND S.OBJ=ST.OBJ) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param bulkResolutionTableName template parameter
	 *@param bulkResolutionTableName2 template parameter
	 *@param statementTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int purgeInsertStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String bulkResolutionTableName, String bulkResolutionTableName2, String statementTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purgeInsertStatements, new String[] {bulkResolutionTableName, bulkResolutionTableName2, statementTableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purgeInsertStatements",stmtProvider.getSqlString(purgeInsertStatements) ,"",""+ "bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null") + "," +"bulkResolutionTableName2="+((bulkResolutionTableName2!=null)?bulkResolutionTableName2.toString():"null") + "," +"statementTableName="+((statementTableName!=null)?statementTableName.toString():"null"));
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
	 *@param bulkResolutionTableName template parameter
	 *@param bulkResolutionTableName2 template parameter
	 *@param statementTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurgeInsertStatements(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String bulkResolutionTableName, String bulkResolutionTableName2, String statementTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purgeInsertStatements,new String[] {bulkResolutionTableName, bulkResolutionTableName2, statementTableName});
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
	 * Runs the commitInsertStatements prepared statement.
	  * <code>
	 *  		INSERT INTO {1} (METADATA,NAMEDGRAPHID,SUBJ,PROP,OBJ) 		SELECT  			ST.METADATA, 			ST.NAMEDGRAPHID, 			ST.SUBJ, 			ST.PROP, 			ST.OBJ 		FROM  {0} ST 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param bulkResolutionTableName template parameter
	 *@param statementTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int commitInsertStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String bulkResolutionTableName, String statementTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(commitInsertStatements, new String[] {bulkResolutionTableName, statementTableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"commitInsertStatements",stmtProvider.getSqlString(commitInsertStatements) ,"",""+ "bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null") + "," +"statementTableName="+((statementTableName!=null)?statementTableName.toString():"null"));
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
	 *@param bulkResolutionTableName template parameter
	 *@param statementTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCommitInsertStatements(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String bulkResolutionTableName, String statementTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,commitInsertStatements,new String[] {bulkResolutionTableName, statementTableName});
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
	 * Runs the commitInsertStatementsNew prepared statement.
	  * <code>
	 *  		MERGE INTO {1} USING {0} ON {1}.NAMEDGRAPHID = {0}.NAMEDGRAPHID AND {1}.SUBJ = {0}.SUBJ AND {1}.PROP = {0}.PROP AND {1}.OBJ = {0}.OBJ      	WHEN NOT MATCHED THEN INSERT (NAMEDGRAPHID,SUBJ,PROP,OBJ) VALUES({0}.NAMEDGRAPHID,{0}.SUBJ,{0}.PROP,{0}.OBJ)      	ELSE IGNORE      	 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param bulkResolutionTableName template parameter
	 *@param statementTableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int commitInsertStatementsNew (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String bulkResolutionTableName, String statementTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(commitInsertStatementsNew, new String[] {bulkResolutionTableName, statementTableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"commitInsertStatementsNew",stmtProvider.getSqlString(commitInsertStatementsNew) ,"",""+ "bulkResolutionTableName="+((bulkResolutionTableName!=null)?bulkResolutionTableName.toString():"null") + "," +"statementTableName="+((statementTableName!=null)?statementTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[commitInsertStatementsNew]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the CommitInsertStatementsNew prepared statement
	 */
	public static class BatchCommitInsertStatementsNew extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the CommitInsertStatementsNew prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param bulkResolutionTableName template parameter
	 *@param statementTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchCommitInsertStatementsNew(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String bulkResolutionTableName, String statementTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,commitInsertStatementsNew,new String[] {bulkResolutionTableName, statementTableName});
		}
		
		/**
		 * Sets the input parameters for the commitInsertStatementsNew prepared statement.
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
	 * Runs the clear prepared statement.
	  * <code>
	 *  		DELETE FROM {0} WHERE NAMEDGRAPHID=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedgraphId template parameter
	 *
	 *@param graphTableName template parameter
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void clear (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedgraphId, String graphTableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(clear, new String[] {graphTableName},connection); int argc = 1;
			ps.setLong(argc++, namedgraphId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"clear",stmtProvider.getSqlString(clear) ,""+ "namedgraphId="+(namedgraphId),""+ "graphTableName="+((graphTableName!=null)?graphTableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[clear]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the Clear prepared statement
	 */
	public static class BatchClear extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the Clear prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param graphTableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchClear(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String graphTableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,clear,new String[] {graphTableName});
		}
		
		/**
		 * Sets the input parameters for the clear prepared statement.
		 *
	 *@param namedgraphId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long namedgraphId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, namedgraphId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}


}