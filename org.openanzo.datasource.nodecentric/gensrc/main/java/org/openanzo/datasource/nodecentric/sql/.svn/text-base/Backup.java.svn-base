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
 *	Backup provides wrappers around SQL queries and transforms ResultSets into java objects
 *
 *	@author Generated Source from org.openanzo.jdbc.utils.opgen.jet
 */
public class Backup {
	private static final org.slf4j.Logger                           log                   = org.slf4j.LoggerFactory.getLogger(Backup.class);
	static final long CUTOFF=5;

	/**
	  *Constant "selectDistinctRevisionedUUIDs" used to reference prepared statement  Backup.selectDistinctRevisionedUUIDs
	  *
	  * <code>
	  *          SELECT DISTINCT UUID FROM NAMEDGRAPHS;     
	  * </code>
	  */
	public static final String selectDistinctRevisionedUUIDs = "Backup.selectDistinctRevisionedUUIDs";

	/**
	  *Constant "selectRevisionedGraphUUIDs" used to reference prepared statement  Backup.selectRevisionedGraphUUIDs
	  *
	  * <code>
	  *          SELECT DISTINCT UUID FROM NAMEDGRAPHS WHERE ID=?;     
	  * </code>
	  */
	public static final String selectRevisionedGraphUUIDs = "Backup.selectRevisionedGraphUUIDs";

	/**
	  *Constant "selectDistinctNonRevisionedUUIDs" used to reference prepared statement  Backup.selectDistinctNonRevisionedUUIDs
	  *
	  * <code>
	  *          SELECT DISTINCT UUID FROM NAMEDGRAPHS_NR;     
	  * </code>
	  */
	public static final String selectDistinctNonRevisionedUUIDs = "Backup.selectDistinctNonRevisionedUUIDs";

	/**
	  *Constant "selectNonRevisionedGraphUUIDs" used to reference prepared statement  Backup.selectNonRevisionedGraphUUIDs
	  *
	  * <code>
	  *          SELECT DISTINCT UUID FROM NAMEDGRAPHS_NR WHERE ID=?;     
	  * </code>
	  */
	public static final String selectNonRevisionedGraphUUIDs = "Backup.selectNonRevisionedGraphUUIDs";

	/**
	  *Constant "selectNamedGraphsRevisioned" used to reference prepared statement  Backup.selectNamedGraphsRevisioned
	  *
	  * <code>
	  *          SELECT ID,METAID,REVISION,HSTART,HEND,LASTMODIFIEDBY FROM NAMEDGRAPHS WHERE UUID=? ORDER BY REVISION ; 	
	  * </code>
	  */
	public static final String selectNamedGraphsRevisioned = "Backup.selectNamedGraphsRevisioned";

	/**
	  *Constant "purgeNamedGraphRevisioned" used to reference prepared statement  Backup.purgeNamedGraphRevisioned
	  *
	  * <code>
	  *          DELETE FROM NAMEDGRAPHS WHERE ID=?     
	  * </code>
	  */
	public static final String purgeNamedGraphRevisioned = "Backup.purgeNamedGraphRevisioned";

	/**
	  *Constant "purgeNamedGraphNonRevisioned" used to reference prepared statement  Backup.purgeNamedGraphNonRevisioned
	  *
	  * <code>
	  *          DELETE FROM NAMEDGRAPHS_NR WHERE ID=?     
	  * </code>
	  */
	public static final String purgeNamedGraphNonRevisioned = "Backup.purgeNamedGraphNonRevisioned";

	/**
	  *Constant "purgeNamedGraphStatementsRevisioned" used to reference prepared statement  Backup.purgeNamedGraphStatementsRevisioned
	  *
	  * <code>
	  *          DELETE FROM STATEMENTS WHERE (NAMEDGRAPHID=? OR NAMEDGRAPHID=?)     
	  * </code>
	  */
	public static final String purgeNamedGraphStatementsRevisioned = "Backup.purgeNamedGraphStatementsRevisioned";

	/**
	  *Constant "purgeNamedGraphStatementsNonRevisioned" used to reference prepared statement  Backup.purgeNamedGraphStatementsNonRevisioned
	  *
	  * <code>
	  *          DELETE FROM STATEMENTS_NR WHERE (NAMEDGRAPHID=? OR NAMEDGRAPHID=?)     
	  * </code>
	  */
	public static final String purgeNamedGraphStatementsNonRevisioned = "Backup.purgeNamedGraphStatementsNonRevisioned";

	/**
	  *Constant "selectStatementsRevisioned" used to reference prepared statement  Backup.selectStatementsRevisioned
	  *
	  * <code>
	  *          SELECT SUBJECT,PREDICATE,OBJECT,RSTART,REND FROM STATEMENTS WHERE UUID=? AND NAMEDGRAPHID=? ORDER BY (RSTART);     
	  * </code>
	  */
	public static final String selectStatementsRevisioned = "Backup.selectStatementsRevisioned";

	/**
	  *Constant "selectNamedGraphsNonRevisioned" used to reference prepared statement  Backup.selectNamedGraphsNonRevisioned
	  *
	  * <code>
	  *          SELECT ID,METAID,REVISION,HSTART,LASTMODIFIEDBY FROM NAMEDGRAPHS_NR WHERE UUID=? ORDER BY REVISION; 	
	  * </code>
	  */
	public static final String selectNamedGraphsNonRevisioned = "Backup.selectNamedGraphsNonRevisioned";

	/**
	  *Constant "selectStatementsNonRevisioned" used to reference prepared statement  Backup.selectStatementsNonRevisioned
	  *
	  * <code>
	  *          SELECT SUBJECT,PREDICATE,OBJECT FROM STATEMENTS_NR WHERE NAMEDGRAPHID=?;     
	  * </code>
	  */
	public static final String selectStatementsNonRevisioned = "Backup.selectStatementsNonRevisioned";

	/**
	  *Constant "restoreNamedGraph" used to reference prepared statement  Backup.restoreNamedGraph
	  *
	  * <code>
	  *          INSERT INTO NAMEDGRAPHS (HSTART,HEND, ID, METAID,UUID,REVISION,LASTMODIFIEDBY,COMMITTED) VALUES (?,?, ?, ?,?, ?,?,0);     
	  * </code>
	  */
	public static final String restoreNamedGraph = "Backup.restoreNamedGraph";

	/**
	  *Constant "restoreNamedGraphNR" used to reference prepared statement  Backup.restoreNamedGraphNR
	  *
	  * <code>
	  *          INSERT INTO NAMEDGRAPHS_NR (HSTART, ID, METAID,UUID, REVISION,LASTMODIFIEDBY,COMMITTED) VALUES (?, ?,?,?,?,?,0);     
	  * </code>
	  */
	public static final String restoreNamedGraphNR = "Backup.restoreNamedGraphNR";

	/**
	  *Constant "restoreStatement" used to reference prepared statement  Backup.restoreStatement
	  *
	  * <code>
	  *          INSERT INTO STATEMENTS(ID,METADATA,UUID,NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT,RSTART,REND,COMMITTED) VALUES (?,?,?,?,?,?,?,?,?,0);     
	  * </code>
	  */
	public static final String restoreStatement = "Backup.restoreStatement";

	/**
	  *Constant "restoreStatementNR" used to reference prepared statement  Backup.restoreStatementNR
	  *
	  * <code>
	  *          INSERT INTO STATEMENTS_NR(ID,METADATA,NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT,COMMITTED) VALUES (?, ?,?, ?, ?, ?,0);     
	  * </code>
	  */
	public static final String restoreStatementNR = "Backup.restoreStatementNR";

	/**
	  *Constant "replaceStatement" used to reference prepared statement  Backup.replaceStatement
	  *
	  * <code>
	  *          UPDATE STATEMENTS SET STATEMENTS.ID=?, STATEMENTS.OBJECT=? WHERE STATEMENTS.ID=?     
	  * </code>
	  */
	public static final String replaceStatement = "Backup.replaceStatement";

	/**
	  *Constant "replaceStatementNR" used to reference prepared statement  Backup.replaceStatementNR
	  *
	  * <code>
	  *          UPDATE STATEMENTS_NR SET STATEMENTS_NR.ID=?, STATEMENTS_NR.OBJECT=? WHERE STATEMENTS_NR.ID=?     
	  * </code>
	  */
	public static final String replaceStatementNR = "Backup.replaceStatementNR";

	/**
	  *Constant "selectFullStatements" used to reference prepared statement  Backup.selectFullStatements
	  *
	  * <code>
	  *          SELECT ID,UUID,SUBJECT,PREDICATE,OBJECT,NAMEDGRAPHID,RSTART,REND FROM STATEMENTS WHERE PREDICATE=? AND METADATA=1;     
	  * </code>
	  */
	public static final String selectFullStatements = "Backup.selectFullStatements";

	/**
	  *Constant "selectFullStatementsNR" used to reference prepared statement  Backup.selectFullStatementsNR
	  *
	  * <code>
	  *          SELECT ID,SUBJECT,PREDICATE,OBJECT,NAMEDGRAPHID FROM STATEMENTS_NR WHERE PREDICATE=? AND METADATA=1     
	  * </code>
	  */
	public static final String selectFullStatementsNR = "Backup.selectFullStatementsNR";



	/**
	 * Transformer that transforms the rows in the result set for the selectDistinctRevisionedUUIDs prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Long> transformSelectDistinctRevisionedUUIDs = new org.openanzo.jdbc.utils.Transformer<Long>(){
		public Long transform(java.sql.ResultSet rs) {
			try {
				Long val = rs.getLong(1);
				return val;
			} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set value:Long",e);
				throw new org.apache.commons.collections.FunctorException(e);
			}
			}

	};
	
	/**
	 * Runs the selectDistinctRevisionedUUIDs prepared statement.
	  * <code>
	 *          SELECT DISTINCT UUID FROM NAMEDGRAPHS;     
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
	public static org.openanzo.jdbc.utils.ClosableIterator<Long> selectDistinctRevisionedUUIDs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectDistinctRevisionedUUIDs, new String[] {},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<Long> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Long>(rs, ps, stmtProvider, transformSelectDistinctRevisionedUUIDs);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectDistinctRevisionedUUIDs",stmtProvider.getSqlString(selectDistinctRevisionedUUIDs) ,"","");
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectDistinctRevisionedUUIDs]"+endtimer);
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the selectRevisionedGraphUUIDs prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Long> transformSelectRevisionedGraphUUIDs = new org.openanzo.jdbc.utils.Transformer<Long>(){
		public Long transform(java.sql.ResultSet rs) {
			try {
				Long val = rs.getLong(1);
				return val;
			} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set value:Long",e);
				throw new org.apache.commons.collections.FunctorException(e);
			}
			}

	};
	
	/**
	 * Runs the selectRevisionedGraphUUIDs prepared statement.
	  * <code>
	 *          SELECT DISTINCT UUID FROM NAMEDGRAPHS WHERE ID=?;     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param graphId template parameter
	 *
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Long> selectRevisionedGraphUUIDs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long graphId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectRevisionedGraphUUIDs, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, graphId);
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

			org.openanzo.jdbc.utils.ClosableIterator<Long> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Long>(rs, ps, stmtProvider, transformSelectRevisionedGraphUUIDs);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectRevisionedGraphUUIDs",stmtProvider.getSqlString(selectRevisionedGraphUUIDs) ,""+ "graphId="+(graphId),"");
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectRevisionedGraphUUIDs]"+endtimer);
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the selectDistinctNonRevisionedUUIDs prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Long> transformSelectDistinctNonRevisionedUUIDs = new org.openanzo.jdbc.utils.Transformer<Long>(){
		public Long transform(java.sql.ResultSet rs) {
			try {
				Long val = rs.getLong(1);
				return val;
			} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set value:Long",e);
				throw new org.apache.commons.collections.FunctorException(e);
			}
			}

	};
	
	/**
	 * Runs the selectDistinctNonRevisionedUUIDs prepared statement.
	  * <code>
	 *          SELECT DISTINCT UUID FROM NAMEDGRAPHS_NR;     
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
	public static org.openanzo.jdbc.utils.ClosableIterator<Long> selectDistinctNonRevisionedUUIDs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectDistinctNonRevisionedUUIDs, new String[] {},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<Long> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Long>(rs, ps, stmtProvider, transformSelectDistinctNonRevisionedUUIDs);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectDistinctNonRevisionedUUIDs",stmtProvider.getSqlString(selectDistinctNonRevisionedUUIDs) ,"","");
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectDistinctNonRevisionedUUIDs]"+endtimer);
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the selectNonRevisionedGraphUUIDs prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Long> transformSelectNonRevisionedGraphUUIDs = new org.openanzo.jdbc.utils.Transformer<Long>(){
		public Long transform(java.sql.ResultSet rs) {
			try {
				Long val = rs.getLong(1);
				return val;
			} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set value:Long",e);
				throw new org.apache.commons.collections.FunctorException(e);
			}
			}

	};
	
	/**
	 * Runs the selectNonRevisionedGraphUUIDs prepared statement.
	  * <code>
	 *          SELECT DISTINCT UUID FROM NAMEDGRAPHS_NR WHERE ID=?;     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param graphId template parameter
	 *
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Long> selectNonRevisionedGraphUUIDs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long graphId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectNonRevisionedGraphUUIDs, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, graphId);
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

			org.openanzo.jdbc.utils.ClosableIterator<Long> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Long>(rs, ps, stmtProvider, transformSelectNonRevisionedGraphUUIDs);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectNonRevisionedGraphUUIDs",stmtProvider.getSqlString(selectNonRevisionedGraphUUIDs) ,""+ "graphId="+(graphId),"");
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectNonRevisionedGraphUUIDs]"+endtimer);
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the selectNamedGraphsRevisioned prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectNamedGraphsRevisionedResult> transformSelectNamedGraphsRevisioned = new org.openanzo.jdbc.utils.Transformer<SelectNamedGraphsRevisionedResult>(){
		public SelectNamedGraphsRevisionedResult transform(java.sql.ResultSet rs) {

			
				SelectNamedGraphsRevisionedResult result = new SelectNamedGraphsRevisionedResult();
				try {
				result.id=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:id",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.metaId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metaId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.revision=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:revision",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.hstart=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:hstart",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.hend=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:hend",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.lastModifiedBy=rs.getLong(6);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:lastModifiedBy",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the selectNamedGraphsRevisioned prepared statement.
	  * <code>
	 *          SELECT ID,METAID,REVISION,HSTART,HEND,LASTMODIFIEDBY FROM NAMEDGRAPHS WHERE UUID=? ORDER BY REVISION ; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param uuid template parameter
	 *
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectNamedGraphsRevisionedResult> selectNamedGraphsRevisioned (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long uuid) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectNamedGraphsRevisioned, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, uuid);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectNamedGraphsRevisionedResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectNamedGraphsRevisionedResult>(rs, ps, stmtProvider, transformSelectNamedGraphsRevisioned);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectNamedGraphsRevisioned",stmtProvider.getSqlString(selectNamedGraphsRevisioned) ,""+ "uuid="+(uuid),"");
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectNamedGraphsRevisioned]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectNamedGraphsRevisionedResult
	 */
	public static class SelectNamedGraphsRevisionedResult {
			/**Value for the "id" result value*/
			private long id;
			/**Value for the "metaId" result value*/
			private long metaId;
			/**Value for the "revision" result value*/
			private long revision;
			/**Value for the "hstart" result value*/
			private long hstart;
			/**Value for the "hend" result value*/
			private long hend;
			/**Value for the "lastModifiedBy" result value*/
			private long lastModifiedBy;

		/**
		  *Get Id value
		  *@return Id value
		  */
			public long getId() {
				return this.id;
			}

		/**
		  *Get MetaId value
		  *@return MetaId value
		  */
			public long getMetaId() {
				return this.metaId;
			}

		/**
		  *Get Revision value
		  *@return Revision value
		  */
			public long getRevision() {
				return this.revision;
			}

		/**
		  *Get Hstart value
		  *@return Hstart value
		  */
			public long getHstart() {
				return this.hstart;
			}

		/**
		  *Get Hend value
		  *@return Hend value
		  */
			public long getHend() {
				return this.hend;
			}

		/**
		  *Get LastModifiedBy value
		  *@return LastModifiedBy value
		  */
			public long getLastModifiedBy() {
				return this.lastModifiedBy;
			}

	}



	
	/**
	 * Runs the purgeNamedGraphRevisioned prepared statement.
	  * <code>
	 *          DELETE FROM NAMEDGRAPHS WHERE ID=?     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ngId template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int purgeNamedGraphRevisioned (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ngId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purgeNamedGraphRevisioned, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, ngId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purgeNamedGraphRevisioned",stmtProvider.getSqlString(purgeNamedGraphRevisioned) ,""+ "ngId="+(ngId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[purgeNamedGraphRevisioned]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PurgeNamedGraphRevisioned prepared statement
	 */
	public static class BatchPurgeNamedGraphRevisioned extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PurgeNamedGraphRevisioned prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurgeNamedGraphRevisioned(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purgeNamedGraphRevisioned,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the purgeNamedGraphRevisioned prepared statement.
		 *
	 *@param ngId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ngId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ngId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the purgeNamedGraphNonRevisioned prepared statement.
	  * <code>
	 *          DELETE FROM NAMEDGRAPHS_NR WHERE ID=?     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ngId template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int purgeNamedGraphNonRevisioned (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ngId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purgeNamedGraphNonRevisioned, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, ngId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purgeNamedGraphNonRevisioned",stmtProvider.getSqlString(purgeNamedGraphNonRevisioned) ,""+ "ngId="+(ngId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[purgeNamedGraphNonRevisioned]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PurgeNamedGraphNonRevisioned prepared statement
	 */
	public static class BatchPurgeNamedGraphNonRevisioned extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PurgeNamedGraphNonRevisioned prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurgeNamedGraphNonRevisioned(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purgeNamedGraphNonRevisioned,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the purgeNamedGraphNonRevisioned prepared statement.
		 *
	 *@param ngId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ngId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ngId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the purgeNamedGraphStatementsRevisioned prepared statement.
	  * <code>
	 *          DELETE FROM STATEMENTS WHERE (NAMEDGRAPHID=? OR NAMEDGRAPHID=?)     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ngId template parameter
	 *@param metaId template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int purgeNamedGraphStatementsRevisioned (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ngId, long metaId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purgeNamedGraphStatementsRevisioned, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, ngId);
			ps.setLong(argc++, metaId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purgeNamedGraphStatementsRevisioned",stmtProvider.getSqlString(purgeNamedGraphStatementsRevisioned) ,""+ "ngId="+(ngId) + "," +"metaId="+(metaId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[purgeNamedGraphStatementsRevisioned]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PurgeNamedGraphStatementsRevisioned prepared statement
	 */
	public static class BatchPurgeNamedGraphStatementsRevisioned extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PurgeNamedGraphStatementsRevisioned prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurgeNamedGraphStatementsRevisioned(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purgeNamedGraphStatementsRevisioned,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the purgeNamedGraphStatementsRevisioned prepared statement.
		 *
	 *@param ngId template parameter
	 *@param metaId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ngId, long metaId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ngId);
			ps.setLong(argc++, metaId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the purgeNamedGraphStatementsNonRevisioned prepared statement.
	  * <code>
	 *          DELETE FROM STATEMENTS_NR WHERE (NAMEDGRAPHID=? OR NAMEDGRAPHID=?)     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ngId template parameter
	 *@param metaId template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int purgeNamedGraphStatementsNonRevisioned (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ngId, long metaId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purgeNamedGraphStatementsNonRevisioned, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, ngId);
			ps.setLong(argc++, metaId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purgeNamedGraphStatementsNonRevisioned",stmtProvider.getSqlString(purgeNamedGraphStatementsNonRevisioned) ,""+ "ngId="+(ngId) + "," +"metaId="+(metaId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[purgeNamedGraphStatementsNonRevisioned]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PurgeNamedGraphStatementsNonRevisioned prepared statement
	 */
	public static class BatchPurgeNamedGraphStatementsNonRevisioned extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PurgeNamedGraphStatementsNonRevisioned prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurgeNamedGraphStatementsNonRevisioned(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purgeNamedGraphStatementsNonRevisioned,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the purgeNamedGraphStatementsNonRevisioned prepared statement.
		 *
	 *@param ngId template parameter
	 *@param metaId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ngId, long metaId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ngId);
			ps.setLong(argc++, metaId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the selectStatementsRevisioned prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectStatementsRevisionedResult> transformSelectStatementsRevisioned = new org.openanzo.jdbc.utils.Transformer<SelectStatementsRevisionedResult>(){
		public SelectStatementsRevisionedResult transform(java.sql.ResultSet rs) {

			
				SelectStatementsRevisionedResult result = new SelectStatementsRevisionedResult();
				try {
				result.subject=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subject",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.predicate=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:predicate",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.object=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:object",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.start=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:start",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.end=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:end",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the selectStatementsRevisioned prepared statement.
	  * <code>
	 *          SELECT SUBJECT,PREDICATE,OBJECT,RSTART,REND FROM STATEMENTS WHERE UUID=? AND NAMEDGRAPHID=? ORDER BY (RSTART);     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param uuid template parameter
	 *@param ngId template parameter
	 *
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectStatementsRevisionedResult> selectStatementsRevisioned (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long uuid, long ngId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectStatementsRevisioned, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, uuid);
			ps.setLong(argc++, ngId);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectStatementsRevisionedResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectStatementsRevisionedResult>(rs, ps, stmtProvider, transformSelectStatementsRevisioned);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectStatementsRevisioned",stmtProvider.getSqlString(selectStatementsRevisioned) ,""+ "uuid="+(uuid) + "," +"ngId="+(ngId),"");
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectStatementsRevisioned]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectStatementsRevisionedResult
	 */
	public static class SelectStatementsRevisionedResult {
			/**Value for the "subject" result value*/
			private long subject;
			/**Value for the "predicate" result value*/
			private long predicate;
			/**Value for the "object" result value*/
			private long object;
			/**Value for the "start" result value*/
			private long start;
			/**Value for the "end" result value*/
			private long end;

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

		/**
		  *Get Start value
		  *@return Start value
		  */
			public long getStart() {
				return this.start;
			}

		/**
		  *Get End value
		  *@return End value
		  */
			public long getEnd() {
				return this.end;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the selectNamedGraphsNonRevisioned prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectNamedGraphsNonRevisionedResult> transformSelectNamedGraphsNonRevisioned = new org.openanzo.jdbc.utils.Transformer<SelectNamedGraphsNonRevisionedResult>(){
		public SelectNamedGraphsNonRevisionedResult transform(java.sql.ResultSet rs) {

			
				SelectNamedGraphsNonRevisionedResult result = new SelectNamedGraphsNonRevisionedResult();
				try {
				result.id=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:id",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.metaId=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:metaId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.revision=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:revision",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.hstart=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:hstart",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.lastModifiedBy=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:lastModifiedBy",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the selectNamedGraphsNonRevisioned prepared statement.
	  * <code>
	 *          SELECT ID,METAID,REVISION,HSTART,LASTMODIFIEDBY FROM NAMEDGRAPHS_NR WHERE UUID=? ORDER BY REVISION; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param uuid template parameter
	 *
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectNamedGraphsNonRevisionedResult> selectNamedGraphsNonRevisioned (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long uuid) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectNamedGraphsNonRevisioned, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, uuid);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectNamedGraphsNonRevisionedResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectNamedGraphsNonRevisionedResult>(rs, ps, stmtProvider, transformSelectNamedGraphsNonRevisioned);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectNamedGraphsNonRevisioned",stmtProvider.getSqlString(selectNamedGraphsNonRevisioned) ,""+ "uuid="+(uuid),"");
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectNamedGraphsNonRevisioned]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectNamedGraphsNonRevisionedResult
	 */
	public static class SelectNamedGraphsNonRevisionedResult {
			/**Value for the "id" result value*/
			private long id;
			/**Value for the "metaId" result value*/
			private long metaId;
			/**Value for the "revision" result value*/
			private long revision;
			/**Value for the "hstart" result value*/
			private long hstart;
			/**Value for the "lastModifiedBy" result value*/
			private long lastModifiedBy;

		/**
		  *Get Id value
		  *@return Id value
		  */
			public long getId() {
				return this.id;
			}

		/**
		  *Get MetaId value
		  *@return MetaId value
		  */
			public long getMetaId() {
				return this.metaId;
			}

		/**
		  *Get Revision value
		  *@return Revision value
		  */
			public long getRevision() {
				return this.revision;
			}

		/**
		  *Get Hstart value
		  *@return Hstart value
		  */
			public long getHstart() {
				return this.hstart;
			}

		/**
		  *Get LastModifiedBy value
		  *@return LastModifiedBy value
		  */
			public long getLastModifiedBy() {
				return this.lastModifiedBy;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the selectStatementsNonRevisioned prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectStatementsNonRevisionedResult> transformSelectStatementsNonRevisioned = new org.openanzo.jdbc.utils.Transformer<SelectStatementsNonRevisionedResult>(){
		public SelectStatementsNonRevisionedResult transform(java.sql.ResultSet rs) {

			
				SelectStatementsNonRevisionedResult result = new SelectStatementsNonRevisionedResult();
				try {
				result.subject=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subject",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.predicate=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:predicate",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.object=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:object",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the selectStatementsNonRevisioned prepared statement.
	  * <code>
	 *          SELECT SUBJECT,PREDICATE,OBJECT FROM STATEMENTS_NR WHERE NAMEDGRAPHID=?;     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param graphId template parameter
	 *
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectStatementsNonRevisionedResult> selectStatementsNonRevisioned (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long graphId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectStatementsNonRevisioned, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, graphId);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectStatementsNonRevisionedResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectStatementsNonRevisionedResult>(rs, ps, stmtProvider, transformSelectStatementsNonRevisioned);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectStatementsNonRevisioned",stmtProvider.getSqlString(selectStatementsNonRevisioned) ,""+ "graphId="+(graphId),"");
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectStatementsNonRevisioned]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectStatementsNonRevisionedResult
	 */
	public static class SelectStatementsNonRevisionedResult {
			/**Value for the "subject" result value*/
			private long subject;
			/**Value for the "predicate" result value*/
			private long predicate;
			/**Value for the "object" result value*/
			private long object;

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
	 * Runs the restoreNamedGraph prepared statement.
	  * <code>
	 *          INSERT INTO NAMEDGRAPHS (HSTART,HEND, ID, METAID,UUID,REVISION,LASTMODIFIEDBY,COMMITTED) VALUES (?,?, ?, ?,?, ?,?,0);     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param start template parameter
	 *@param end template parameter
	 *@param namedgraphid template parameter
	 *@param metadataId template parameter
	 *@param uuid template parameter
	 *@param revision template parameter
	 *@param lastModifiedBy template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int restoreNamedGraph (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long start, Long end, long namedgraphid, long metadataId, long uuid, long revision, long lastModifiedBy) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(restoreNamedGraph, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, start);
			if(end == null) {
				ps.setNull(argc++, java.sql.Types.BIGINT);
			} else {
				ps.setLong(argc++, end);
			}
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, metadataId);
			ps.setLong(argc++, uuid);
			ps.setLong(argc++, revision);
			ps.setLong(argc++, lastModifiedBy);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"restoreNamedGraph",stmtProvider.getSqlString(restoreNamedGraph) ,""+ "start="+(start) + "," +"end="+((end!=null)?end.toString():"null") + "," +"namedgraphid="+(namedgraphid) + "," +"metadataId="+(metadataId) + "," +"uuid="+(uuid) + "," +"revision="+(revision) + "," +"lastModifiedBy="+(lastModifiedBy),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[restoreNamedGraph]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the RestoreNamedGraph prepared statement
	 */
	public static class BatchRestoreNamedGraph extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the RestoreNamedGraph prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchRestoreNamedGraph(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,restoreNamedGraph,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the restoreNamedGraph prepared statement.
		 *
	 *@param start template parameter
	 *@param end template parameter
	 *@param namedgraphid template parameter
	 *@param metadataId template parameter
	 *@param uuid template parameter
	 *@param revision template parameter
	 *@param lastModifiedBy template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long start, Long end, long namedgraphid, long metadataId, long uuid, long revision, long lastModifiedBy) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, start);
			if(end == null) {
				ps.setNull(argc++, java.sql.Types.BIGINT);
			} else {
				ps.setLong(argc++, end);
			}
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, metadataId);
			ps.setLong(argc++, uuid);
			ps.setLong(argc++, revision);
			ps.setLong(argc++, lastModifiedBy);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the restoreNamedGraphNR prepared statement.
	  * <code>
	 *          INSERT INTO NAMEDGRAPHS_NR (HSTART, ID, METAID,UUID, REVISION,LASTMODIFIEDBY,COMMITTED) VALUES (?, ?,?,?,?,?,0);     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param modified template parameter
	 *@param namedgraphid template parameter
	 *@param metadataId template parameter
	 *@param uuid template parameter
	 *@param revision template parameter
	 *@param lastModifiedBy template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int restoreNamedGraphNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long modified, long namedgraphid, long metadataId, long uuid, long revision, long lastModifiedBy) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(restoreNamedGraphNR, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, modified);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, metadataId);
			ps.setLong(argc++, uuid);
			ps.setLong(argc++, revision);
			ps.setLong(argc++, lastModifiedBy);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"restoreNamedGraphNR",stmtProvider.getSqlString(restoreNamedGraphNR) ,""+ "modified="+(modified) + "," +"namedgraphid="+(namedgraphid) + "," +"metadataId="+(metadataId) + "," +"uuid="+(uuid) + "," +"revision="+(revision) + "," +"lastModifiedBy="+(lastModifiedBy),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[restoreNamedGraphNR]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the RestoreNamedGraphNR prepared statement
	 */
	public static class BatchRestoreNamedGraphNR extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the RestoreNamedGraphNR prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchRestoreNamedGraphNR(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,restoreNamedGraphNR,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the restoreNamedGraphNR prepared statement.
		 *
	 *@param modified template parameter
	 *@param namedgraphid template parameter
	 *@param metadataId template parameter
	 *@param uuid template parameter
	 *@param revision template parameter
	 *@param lastModifiedBy template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long modified, long namedgraphid, long metadataId, long uuid, long revision, long lastModifiedBy) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, modified);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, metadataId);
			ps.setLong(argc++, uuid);
			ps.setLong(argc++, revision);
			ps.setLong(argc++, lastModifiedBy);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the restoreStatement prepared statement.
	  * <code>
	 *          INSERT INTO STATEMENTS(ID,METADATA,UUID,NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT,RSTART,REND,COMMITTED) VALUES (?,?,?,?,?,?,?,?,?,0);     
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
	 *@param rend template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int restoreStatement (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String id, int metadata, long uuid, long namedGraphId, long subject, long predicate, long object, long rstart, Long rend) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(restoreStatement, new String[] {},connection); int argc = 1;
			if(id == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"id","restoreStatement");
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
			if(rend == null) {
				ps.setNull(argc++, java.sql.Types.BIGINT);
			} else {
				ps.setLong(argc++, rend);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"restoreStatement",stmtProvider.getSqlString(restoreStatement) ,""+ "id="+((id!=null)?id.toString():"null") + "," +"metadata="+(metadata) + "," +"uuid="+(uuid) + "," +"namedGraphId="+(namedGraphId) + "," +"subject="+(subject) + "," +"predicate="+(predicate) + "," +"object="+(object) + "," +"rstart="+(rstart) + "," +"rend="+((rend!=null)?rend.toString():"null"),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[restoreStatement]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the RestoreStatement prepared statement
	 */
	public static class BatchRestoreStatement extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the RestoreStatement prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchRestoreStatement(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,restoreStatement,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the restoreStatement prepared statement.
		 *
	 *@param id template parameter
	 *@param metadata template parameter
	 *@param uuid template parameter
	 *@param namedGraphId template parameter
	 *@param subject template parameter
	 *@param predicate template parameter
	 *@param object template parameter
	 *@param rstart template parameter
	 *@param rend template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (String id, int metadata, long uuid, long namedGraphId, long subject, long predicate, long object, long rstart, Long rend) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			if(id == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"id","restoreStatement");
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
			if(rend == null) {
				ps.setNull(argc++, java.sql.Types.BIGINT);
			} else {
				ps.setLong(argc++, rend);
			}
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the restoreStatementNR prepared statement.
	  * <code>
	 *          INSERT INTO STATEMENTS_NR(ID,METADATA,NAMEDGRAPHID, SUBJECT, PREDICATE, OBJECT,COMMITTED) VALUES (?, ?,?, ?, ?, ?,0);     
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
	public static void restoreStatementNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String id, int metadata, long namedGraphId, long subject, long predicate, long object) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(restoreStatementNR, new String[] {},connection); int argc = 1;
			if(id == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"id","restoreStatementNR");
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"restoreStatementNR",stmtProvider.getSqlString(restoreStatementNR) ,""+ "id="+((id!=null)?id.toString():"null") + "," +"metadata="+(metadata) + "," +"namedGraphId="+(namedGraphId) + "," +"subject="+(subject) + "," +"predicate="+(predicate) + "," +"object="+(object),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[restoreStatementNR]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the RestoreStatementNR prepared statement
	 */
	public static class BatchRestoreStatementNR extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the RestoreStatementNR prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchRestoreStatementNR(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,restoreStatementNR,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the restoreStatementNR prepared statement.
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
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"id","restoreStatementNR");
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
	 * Runs the replaceStatement prepared statement.
	  * <code>
	 *          UPDATE STATEMENTS SET STATEMENTS.ID=?, STATEMENTS.OBJECT=? WHERE STATEMENTS.ID=?     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param newId template parameter
	 *@param oid template parameter
	 *@param id template parameter
	 *
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void replaceStatement (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String newId, long oid, String id) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(replaceStatement, new String[] {},connection); int argc = 1;
			if(newId == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"newId","replaceStatement");
			} else {
				ps.setString(argc++, newId);
			}
			ps.setLong(argc++, oid);
			if(id == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"id","replaceStatement");
			} else {
				ps.setString(argc++, id);
			}
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"replaceStatement",stmtProvider.getSqlString(replaceStatement) ,""+ "newId="+((newId!=null)?newId.toString():"null") + "," +"oid="+(oid) + "," +"id="+((id!=null)?id.toString():"null"),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[replaceStatement]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the ReplaceStatement prepared statement
	 */
	public static class BatchReplaceStatement extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the ReplaceStatement prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchReplaceStatement(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,replaceStatement,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the replaceStatement prepared statement.
		 *
	 *@param newId template parameter
	 *@param oid template parameter
	 *@param id template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (String newId, long oid, String id) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			if(newId == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"newId","replaceStatement");
			} else {
				ps.setString(argc++, newId);
			}
			ps.setLong(argc++, oid);
			if(id == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"id","replaceStatement");
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
	 * Runs the replaceStatementNR prepared statement.
	  * <code>
	 *          UPDATE STATEMENTS_NR SET STATEMENTS_NR.ID=?, STATEMENTS_NR.OBJECT=? WHERE STATEMENTS_NR.ID=?     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param newId template parameter
	 *@param oid template parameter
	 *@param id template parameter
	 *
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void replaceStatementNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String newId, long oid, String id) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(replaceStatementNR, new String[] {},connection); int argc = 1;
			if(newId == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"newId","replaceStatementNR");
			} else {
				ps.setString(argc++, newId);
			}
			ps.setLong(argc++, oid);
			if(id == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"id","replaceStatementNR");
			} else {
				ps.setString(argc++, id);
			}
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"replaceStatementNR",stmtProvider.getSqlString(replaceStatementNR) ,""+ "newId="+((newId!=null)?newId.toString():"null") + "," +"oid="+(oid) + "," +"id="+((id!=null)?id.toString():"null"),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[replaceStatementNR]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the ReplaceStatementNR prepared statement
	 */
	public static class BatchReplaceStatementNR extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the ReplaceStatementNR prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchReplaceStatementNR(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,replaceStatementNR,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the replaceStatementNR prepared statement.
		 *
	 *@param newId template parameter
	 *@param oid template parameter
	 *@param id template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (String newId, long oid, String id) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			if(newId == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"newId","replaceStatementNR");
			} else {
				ps.setString(argc++, newId);
			}
			ps.setLong(argc++, oid);
			if(id == null) {
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.NULL_PARAMETER,"id","replaceStatementNR");
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
	 * Transformer that transforms the rows in the result set for the selectFullStatements prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectFullStatementsResult> transformSelectFullStatements = new org.openanzo.jdbc.utils.Transformer<SelectFullStatementsResult>(){
		public SelectFullStatementsResult transform(java.sql.ResultSet rs) {

			
				SelectFullStatementsResult result = new SelectFullStatementsResult();
				try {
				result.id=rs.getString(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:id",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.uuid=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:uuid",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subject=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subject",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.predicate=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:predicate",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.object=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:object",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.namedGraphId=rs.getLong(6);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.start=rs.getLong(7);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:start",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.end=rs.getLong(8);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:end",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the selectFullStatements prepared statement.
	  * <code>
	 *          SELECT ID,UUID,SUBJECT,PREDICATE,OBJECT,NAMEDGRAPHID,RSTART,REND FROM STATEMENTS WHERE PREDICATE=? AND METADATA=1;     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param pid template parameter
	 *
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectFullStatementsResult> selectFullStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long pid) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectFullStatements, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, pid);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectFullStatementsResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectFullStatementsResult>(rs, ps, stmtProvider, transformSelectFullStatements);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectFullStatements",stmtProvider.getSqlString(selectFullStatements) ,""+ "pid="+(pid),"");
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectFullStatements]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectFullStatementsResult
	 */
	public static class SelectFullStatementsResult {
			/**Value for the "id" result value*/
			private String id;
			/**Value for the "uuid" result value*/
			private long uuid;
			/**Value for the "subject" result value*/
			private long subject;
			/**Value for the "predicate" result value*/
			private long predicate;
			/**Value for the "object" result value*/
			private long object;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "start" result value*/
			private long start;
			/**Value for the "end" result value*/
			private long end;

		/**
		  *Get Id value
		  *@return Id value
		  */
			public String getId() {
				return this.id;
			}

		/**
		  *Get Uuid value
		  *@return Uuid value
		  */
			public long getUuid() {
				return this.uuid;
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

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

		/**
		  *Get Start value
		  *@return Start value
		  */
			public long getStart() {
				return this.start;
			}

		/**
		  *Get End value
		  *@return End value
		  */
			public long getEnd() {
				return this.end;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the selectFullStatementsNR prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectFullStatementsNRResult> transformSelectFullStatementsNR = new org.openanzo.jdbc.utils.Transformer<SelectFullStatementsNRResult>(){
		public SelectFullStatementsNRResult transform(java.sql.ResultSet rs) {

			
				SelectFullStatementsNRResult result = new SelectFullStatementsNRResult();
				try {
				result.id=rs.getString(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:id",e);
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
				try {
				result.namedGraphId=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the selectFullStatementsNR prepared statement.
	  * <code>
	 *          SELECT ID,SUBJECT,PREDICATE,OBJECT,NAMEDGRAPHID FROM STATEMENTS_NR WHERE PREDICATE=? AND METADATA=1     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param pid template parameter
	 *
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectFullStatementsNRResult> selectFullStatementsNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long pid) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectFullStatementsNR, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, pid);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectFullStatementsNRResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectFullStatementsNRResult>(rs, ps, stmtProvider, transformSelectFullStatementsNR);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectFullStatementsNR",stmtProvider.getSqlString(selectFullStatementsNR) ,""+ "pid="+(pid),"");
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectFullStatementsNR]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectFullStatementsNRResult
	 */
	public static class SelectFullStatementsNRResult {
			/**Value for the "id" result value*/
			private String id;
			/**Value for the "subject" result value*/
			private long subject;
			/**Value for the "predicate" result value*/
			private long predicate;
			/**Value for the "object" result value*/
			private long object;
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;

		/**
		  *Get Id value
		  *@return Id value
		  */
			public String getId() {
				return this.id;
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

		/**
		  *Get NamedGraphId value
		  *@return NamedGraphId value
		  */
			public long getNamedGraphId() {
				return this.namedGraphId;
			}

	}

}