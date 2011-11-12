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
package org.openanzo.datasource.nodecentric.rdb.sql;
// allow for all types that can be returned from a resultset

/**
 *	ReplicationRdbWrapper provides wrappers around SQL queries and transforms ResultSets into java objects
 *
 *	@author Generated Source from org.openanzo.jdbc.utils.opgen.jet
 */
public class ReplicationRdbWrapper {
	private static final org.slf4j.Logger                           log                   = org.slf4j.LoggerFactory.getLogger(ReplicationRdbWrapper.class);
	static final long CUTOFF=5;

	/**
	  *Constant "insertNamedGraphRevision" used to reference prepared statement  Replication.insertNamedGraphRevision
	  *
	  * <code>
	  *  		INSERT INTO {0}NGR_TMP 		(ID,METAID,REVISION) 		VALUES  		(?,?,?); 	
	  * </code>
	  */
	public static final String insertNamedGraphRevision = "Replication.insertNamedGraphRevision";

	/**
	  *Constant "insertNamedGraphNewRevisions" used to reference prepared statement  Replication.insertNamedGraphNewRevisions
	  *
	  * <code>
	  *  		INSERT INTO {1}NGR_TMP	(ID,METAID,NEW_REVISION,UUID,REVISION)	 			SELECT NAMEDGRAPHS.ID,NAMEDGRAPHS.METAID,NAMEDGRAPHS.REVISION,NAMEDGRAPHS.UUID,{2} 			FROM NAMEDGRAPHS  			WHERE  			NAMEDGRAPHS.ID={0} AND  			NAMEDGRAPHS.REVISION > {2} AND 			( 				(NAMEDGRAPHS.HEND IS NULL AND NAMEDGRAPHS.COMMITTED=0) OR  				(NAMEDGRAPHS.HEND IS NOT NULL AND NAMEDGRAPHS.COMMITTED>0) 			)		 	
	  * </code>
	  */
	public static final String insertNamedGraphNewRevisions = "Replication.insertNamedGraphNewRevisions";

	/**
	  *Constant "insertNamedGraphNRNewRevisions" used to reference prepared statement  Replication.insertNamedGraphNRNewRevisions
	  *
	  * <code>
	  *  		INSERT INTO {1}NGR_TMP	(ID,METAID,NEW_REVISION,UUID,REVISION)		 			SELECT NAMEDGRAPHS_NR.ID,NAMEDGRAPHS_NR.METAID,NAMEDGRAPHS_NR.REVISION,NAMEDGRAPHS_NR.UUID,{2} 			FROM NAMEDGRAPHS_NR  			WHERE  			NAMEDGRAPHS_NR.ID={0} AND  			NAMEDGRAPHS_NR.REVISION > {2} AND 			NAMEDGRAPHS_NR.COMMITTED=0		 	
	  * </code>
	  */
	public static final String insertNamedGraphNRNewRevisions = "Replication.insertNamedGraphNRNewRevisions";

	/**
	  *Constant "updateNamedGraphNewRevisions" used to reference prepared statement  Replication.updateNamedGraphNewRevisions
	  *
	  * <code>
	  *  		UPDATE {0}NGR_TMP  		SET  		NEW_REVISION=( 			SELECT NAMEDGRAPHS.REVISION  			FROM NAMEDGRAPHS  			WHERE  			NAMEDGRAPHS.ID={0}NGR_TMP.ID AND  			( 				(NAMEDGRAPHS.HEND IS NULL AND NAMEDGRAPHS.COMMITTED=0) OR  				(NAMEDGRAPHS.HEND IS NOT NULL AND NAMEDGRAPHS.COMMITTED>0) 			) 		),  		UUID=( 			SELECT NAMEDGRAPHS.UUID  			FROM NAMEDGRAPHS  			WHERE  			NAMEDGRAPHS.ID={0}NGR_TMP.ID AND  			( 				(NAMEDGRAPHS.HEND IS NULL AND NAMEDGRAPHS.COMMITTED=0) OR  				(NAMEDGRAPHS.HEND IS NOT NULL AND NAMEDGRAPHS.COMMITTED>0) 			) 		)   		WHERE EXISTS (SELECT NAMEDGRAPHS.ID FROM NAMEDGRAPHS WHERE NAMEDGRAPHS.ID={0}NGR_TMP.ID) 	
	  * </code>
	  */
	public static final String updateNamedGraphNewRevisions = "Replication.updateNamedGraphNewRevisions";

	/**
	  *Constant "updateNamedGraphNRNewRevisions" used to reference prepared statement  Replication.updateNamedGraphNRNewRevisions
	  *
	  * <code>
	  *  		UPDATE {0}NGR_TMP  		SET  		NEW_REVISION=( 			SELECT NAMEDGRAPHS_NR.REVISION  			FROM NAMEDGRAPHS_NR  			WHERE  			NAMEDGRAPHS_NR.ID={0}NGR_TMP.ID AND 			NAMEDGRAPHS_NR.COMMITTED=0 		),  		UUID=( 			SELECT NAMEDGRAPHS_NR.UUID  			FROM NAMEDGRAPHS_NR  			WHERE  			NAMEDGRAPHS_NR.ID={0}NGR_TMP.ID  AND  			NAMEDGRAPHS_NR.COMMITTED=0 		)  		WHERE EXISTS (SELECT NAMEDGRAPHS_NR.ID FROM NAMEDGRAPHS_NR WHERE NAMEDGRAPHS_NR.ID={0}NGR_TMP.ID) 	
	  * </code>
	  */
	public static final String updateNamedGraphNRNewRevisions = "Replication.updateNamedGraphNRNewRevisions";

	/**
	  *Constant "purgeNonChangedNamedGraphEntries" used to reference prepared statement  Replication.purgeNonChangedNamedGraphEntries
	  *
	  * <code>
	  *  		DELETE FROM {0}NGR_TMP WHERE EXISTS(SELECT NG.REVISION FROM NAMEDGRAPHS NG WHERE NG.ID={0}NGR_TMP.ID AND NG.REVISION={0}NGR_TMP.REVISION AND ((NG.HEND IS NULL AND NG.COMMITTED=0) OR (NG.HEND IS NOT NULL AND NG.COMMITTED>0))) 	
	  * </code>
	  */
	public static final String purgeNonChangedNamedGraphEntries = "Replication.purgeNonChangedNamedGraphEntries";

	/**
	  *Constant "purgeNonChangedNamedGraphNREntries" used to reference prepared statement  Replication.purgeNonChangedNamedGraphNREntries
	  *
	  * <code>
	  *  		DELETE FROM {0}NGR_TMP WHERE EXISTS(SELECT NG.REVISION FROM NAMEDGRAPHS_NR NG WHERE	NG.ID={0}NGR_TMP.ID AND	NG.REVISION={0}NGR_TMP.REVISION AND	NG.COMMITTED=0) 	
	  * </code>
	  */
	public static final String purgeNonChangedNamedGraphNREntries = "Replication.purgeNonChangedNamedGraphNREntries";

	/**
	  *Constant "selectNewStatements" used to reference prepared statement  Replication.selectNewStatements
	  *
	  * <code>
	  *  		SELECT  			S.NAMEDGRAPHID,S.SUBJECT,S.PREDICATE,S.OBJECT 		FROM  			STATEMENTS S,{0}NGR_TMP NG 		WHERE 			S.COMMITTED<=0 AND 			S.UUID=NG.UUID AND  			((S.RSTART>NG.REVISION AND S.REND IS NULL) OR (S.RSTART<=NG.REVISION AND S.REND>NG.REVISION)) 		ORDER BY NAMEDGRAPHID,REND 	
	  * </code>
	  */
	public static final String selectNewStatements = "Replication.selectNewStatements";

	/**
	  *Constant "selectNewStatementsNR" used to reference prepared statement  Replication.selectNewStatementsNR
	  *
	  * <code>
	  *  		SELECT  			S.NAMEDGRAPHID,S.SUBJECT,S.PREDICATE,S.OBJECT 		FROM  			STATEMENTS_NR S,{0}NGR_TMP NG 		WHERE 			S.COMMITTED<=0 AND 			(S.NAMEDGRAPHID=NG.ID OR S.NAMEDGRAPHID=NG.METAID) 		ORDER BY NAMEDGRAPHID 	
	  * </code>
	  */
	public static final String selectNewStatementsNR = "Replication.selectNewStatementsNR";

	/**
	  *Constant "insertDeltaStatements" used to reference prepared statement  Replication.insertDeltaStatements
	  *
	  * <code>
	  *  		INSERT INTO {0}STMTS_REP_TMP 		SELECT  			S.ID,S.NAMEDGRAPHID,S.SUBJECT,S.PREDICATE,S.OBJECT,S.RSTART,S.REND 		FROM  			STATEMENTS S,{0}NGR_TMP NG 		WHERE 			NG.REVISION > -1 AND 			S.COMMITTED=0 AND 			S.UUID=NG.UUID AND  			((S.RSTART>NG.REVISION AND S.REND IS NULL) OR (S.RSTART<=NG.REVISION AND S.REND>NG.REVISION)) 	
	  * </code>
	  */
	public static final String insertDeltaStatements = "Replication.insertDeltaStatements";

	/**
	  *Constant "insertDeltaNRStatements" used to reference prepared statement  Replication.insertDeltaNRStatements
	  *
	  * <code>
	  *  		INSERT INTO {0}STMTS_REP_TMP(ID,NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT) 		SELECT  			S.ID,S.NAMEDGRAPHID,S.SUBJECT,S.PREDICATE,S.OBJECT 		FROM  			STATEMENTS_NR S 		WHERE 			S.COMMITTED=0 AND S.NAMEDGRAPHID IN (SELECT ID FROM {0}NGR_TMP WHERE REVISION>-1 UNION SELECT METAID FROM {0}NGR_TMP  WHERE REVISION>-1) 	
	  * </code>
	  */
	public static final String insertDeltaNRStatements = "Replication.insertDeltaNRStatements";

	/**
	  *Constant "purgeExtraStatements" used to reference prepared statement  Replication.purgeExtraStatements
	  *
	  * <code>
	  *  		DELETE FROM {0}STMTS_REP_TMP 		WHERE  		{0}STMTS_REP_TMP.REND IS NOT NULL AND 		EXISTS (SELECT ST2.ID FROM {0}STMTS_REP_TMP ST2 WHERE ST2.ID={0}STMTS_REP_TMP.ID AND (ST2.REND IS NULL OR ST2.REND>{0}STMTS_REP_TMP.REND)) 		 	
	  * </code>
	  */
	public static final String purgeExtraStatements = "Replication.purgeExtraStatements";

	/**
	  *Constant "selectAllStatement" used to reference prepared statement  Replication.selectAllStatement
	  *
	  * <code>
	  *  		SELECT NAMEDGRAPHID,REND,SUBJECT,PREDICATE,OBJECT 		FROM {0}STMTS_REP_TMP 		ORDER BY NAMEDGRAPHID,REND 	
	  * </code>
	  */
	public static final String selectAllStatement = "Replication.selectAllStatement";

	/**
	  *Constant "selectStatementAdditions" used to reference prepared statement  Replication.selectStatementAdditions
	  *
	  * <code>
	  *  		SELECT NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT 		FROM {0}STMTS_REP_TMP 		WHERE REND IS NULL ORDER BY NAMEDGRAPHID 	
	  * </code>
	  */
	public static final String selectStatementAdditions = "Replication.selectStatementAdditions";

	/**
	  *Constant "selectStatementDeletions" used to reference prepared statement  Replication.selectStatementDeletions
	  *
	  * <code>
	  *  		SELECT NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT 		FROM {0}STMTS_REP_TMP 		WHERE REND IS NOT NULL ORDER BY NAMEDGRAPHID 	
	  * </code>
	  */
	public static final String selectStatementDeletions = "Replication.selectStatementDeletions";

	/**
	  *Constant "selectUniqueUris" used to reference prepared statement  Replication.selectUniqueUris
	  *
	  * <code>
	  *  		SELECT DISTINCT {0}_U.ID,{0}_U.VALUE 		FROM {0}_U 		WHERE 			{0}_U.ID IN (SELECT  ID FROM {1}NAMEDGRAPHIDS UNION SELECT  SUBJ FROM {1}{2} UNION SELECT PREDICATE FROM {1}{3} UNION SELECT  NAMEDGRAPHID FROM {1}{4} UNION SELECT  OBJ FROM {1}{5}); 	
	  * </code>
	  */
	public static final String selectUniqueUris = "Replication.selectUniqueUris";

	/**
	  *Constant "selectUniqueIds" used to reference prepared statement  Replication.selectUniqueIds
	  *
	  * <code>
	  *  		SELECT SUBJECT FROM {0}{1} UNION SELECT PREDICATE FROM {0}{2} UNION SELECT NAMEDGRAPHID FROM {0}{3} UNION SELECT OBJECT FROM {0}{4}; 	
	  * </code>
	  */
	public static final String selectUniqueIds = "Replication.selectUniqueIds";

	/**
	  *Constant "selectNamedGraphs" used to reference prepared statement  Replication.selectNamedGraphs
	  *
	  * <code>
	  *  		SELECT ID,UUID,NEW_REVISION FROM {0}NGR_TMP WHERE REVISION IS NULL OR REVISION < NEW_REVISION 	
	  * </code>
	  */
	public static final String selectNamedGraphs = "Replication.selectNamedGraphs";

	/**
	  *Constant "selectAllNamedGraphs" used to reference prepared statement  Replication.selectAllNamedGraphs
	  *
	  * <code>
	  *  		SELECT ID,UUID,REVISION,NEW_REVISION FROM {0}NGR_TMP WHERE REVISION IS NULL OR NEW_REVISION IS NULL 	
	  * </code>
	  */
	public static final String selectAllNamedGraphs = "Replication.selectAllNamedGraphs";



	
	/**
	 * Runs the insertNamedGraphRevision prepared statement.
	  * <code>
	 *  		INSERT INTO {0}NGR_TMP 		(ID,METAID,REVISION) 		VALUES  		(?,?,?); 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param namedGraphId template parameter
	 *@param metaId template parameter
	 *@param revision template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertNamedGraphRevision (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long namedGraphId, long metaId, long revision, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertNamedGraphRevision, new String[] {sessionPrefix},connection); int argc = 1;
			ps.setLong(argc++, namedGraphId);
			ps.setLong(argc++, metaId);
			ps.setLong(argc++, revision);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertNamedGraphRevision",stmtProvider.getSqlString(insertNamedGraphRevision) ,""+ "namedGraphId="+(namedGraphId) + "," +"metaId="+(metaId) + "," +"revision="+(revision),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertNamedGraphRevision]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertNamedGraphRevision prepared statement
	 */
	public static class BatchInsertNamedGraphRevision extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertNamedGraphRevision prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertNamedGraphRevision(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertNamedGraphRevision,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the insertNamedGraphRevision prepared statement.
		 *
	 *@param namedGraphId template parameter
	 *@param metaId template parameter
	 *@param revision template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long namedGraphId, long metaId, long revision) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, namedGraphId);
			ps.setLong(argc++, metaId);
			ps.setLong(argc++, revision);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertNamedGraphNewRevisions prepared statement.
	  * <code>
	 *  		INSERT INTO {1}NGR_TMP	(ID,METAID,NEW_REVISION,UUID,REVISION)	 			SELECT NAMEDGRAPHS.ID,NAMEDGRAPHS.METAID,NAMEDGRAPHS.REVISION,NAMEDGRAPHS.UUID,{2} 			FROM NAMEDGRAPHS  			WHERE  			NAMEDGRAPHS.ID={0} AND  			NAMEDGRAPHS.REVISION > {2} AND 			( 				(NAMEDGRAPHS.HEND IS NULL AND NAMEDGRAPHS.COMMITTED=0) OR  				(NAMEDGRAPHS.HEND IS NOT NULL AND NAMEDGRAPHS.COMMITTED>0) 			)		 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param ngId template parameter
	 *@param sessionPrefix template parameter
	 *@param revision template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertNamedGraphNewRevisions (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String ngId, String sessionPrefix, String revision) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.Statement stmt = null;
		//long startTimer=System.currentTimeMillis();
		try {
			String sql= stmtProvider.getSQL(insertNamedGraphNewRevisions, new String[] {ngId, sessionPrefix, revision});
			stmt=connection.createStatement();
				int counter = 0;
				try{
					counter=stmt.executeUpdate(sql);
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
								counter=stmt.executeUpdate(sql);
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
			
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertNamedGraphNewRevisions",stmtProvider.getSqlString(insertNamedGraphNewRevisions) ,"",""+ "ngId="+((ngId!=null)?ngId.toString():"null") + "," +"sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"revision="+((revision!=null)?revision.toString():"null"));
			
		} finally {
			
			if (stmt != null) {
				try { 
					stmt.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing statement",sqle);
				}
			}
			
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertNamedGraphNewRevisions]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertNamedGraphNewRevisions prepared statement
	 */
	public static class BatchInsertNamedGraphNewRevisions extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertNamedGraphNewRevisions prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param ngId template parameter
	 *@param sessionPrefix template parameter
	 *@param revision template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertNamedGraphNewRevisions(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String ngId, String sessionPrefix, String revision) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertNamedGraphNewRevisions,new String[] {ngId, sessionPrefix, revision});
		}
		
		/**
		 * Sets the input parameters for the insertNamedGraphNewRevisions prepared statement.
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
	 * Runs the insertNamedGraphNRNewRevisions prepared statement.
	  * <code>
	 *  		INSERT INTO {1}NGR_TMP	(ID,METAID,NEW_REVISION,UUID,REVISION)		 			SELECT NAMEDGRAPHS_NR.ID,NAMEDGRAPHS_NR.METAID,NAMEDGRAPHS_NR.REVISION,NAMEDGRAPHS_NR.UUID,{2} 			FROM NAMEDGRAPHS_NR  			WHERE  			NAMEDGRAPHS_NR.ID={0} AND  			NAMEDGRAPHS_NR.REVISION > {2} AND 			NAMEDGRAPHS_NR.COMMITTED=0		 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param ngId template parameter
	 *@param sessionPrefix template parameter
	 *@param revision template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertNamedGraphNRNewRevisions (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String ngId, String sessionPrefix, String revision) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.Statement stmt = null;
		//long startTimer=System.currentTimeMillis();
		try {
			String sql= stmtProvider.getSQL(insertNamedGraphNRNewRevisions, new String[] {ngId, sessionPrefix, revision});
			stmt=connection.createStatement();
				int counter = 0;
				try{
					counter=stmt.executeUpdate(sql);
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
								counter=stmt.executeUpdate(sql);
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
			
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertNamedGraphNRNewRevisions",stmtProvider.getSqlString(insertNamedGraphNRNewRevisions) ,"",""+ "ngId="+((ngId!=null)?ngId.toString():"null") + "," +"sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"revision="+((revision!=null)?revision.toString():"null"));
			
		} finally {
			
			if (stmt != null) {
				try { 
					stmt.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing statement",sqle);
				}
			}
			
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertNamedGraphNRNewRevisions]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertNamedGraphNRNewRevisions prepared statement
	 */
	public static class BatchInsertNamedGraphNRNewRevisions extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertNamedGraphNRNewRevisions prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param ngId template parameter
	 *@param sessionPrefix template parameter
	 *@param revision template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertNamedGraphNRNewRevisions(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String ngId, String sessionPrefix, String revision) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertNamedGraphNRNewRevisions,new String[] {ngId, sessionPrefix, revision});
		}
		
		/**
		 * Sets the input parameters for the insertNamedGraphNRNewRevisions prepared statement.
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
	 * Runs the updateNamedGraphNewRevisions prepared statement.
	  * <code>
	 *  		UPDATE {0}NGR_TMP  		SET  		NEW_REVISION=( 			SELECT NAMEDGRAPHS.REVISION  			FROM NAMEDGRAPHS  			WHERE  			NAMEDGRAPHS.ID={0}NGR_TMP.ID AND  			( 				(NAMEDGRAPHS.HEND IS NULL AND NAMEDGRAPHS.COMMITTED=0) OR  				(NAMEDGRAPHS.HEND IS NOT NULL AND NAMEDGRAPHS.COMMITTED>0) 			) 		),  		UUID=( 			SELECT NAMEDGRAPHS.UUID  			FROM NAMEDGRAPHS  			WHERE  			NAMEDGRAPHS.ID={0}NGR_TMP.ID AND  			( 				(NAMEDGRAPHS.HEND IS NULL AND NAMEDGRAPHS.COMMITTED=0) OR  				(NAMEDGRAPHS.HEND IS NOT NULL AND NAMEDGRAPHS.COMMITTED>0) 			) 		)   		WHERE EXISTS (SELECT NAMEDGRAPHS.ID FROM NAMEDGRAPHS WHERE NAMEDGRAPHS.ID={0}NGR_TMP.ID) 	
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
	public static int updateNamedGraphNewRevisions (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(updateNamedGraphNewRevisions, new String[] {sessionPrefix},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"updateNamedGraphNewRevisions",stmtProvider.getSqlString(updateNamedGraphNewRevisions) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[updateNamedGraphNewRevisions]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the UpdateNamedGraphNewRevisions prepared statement
	 */
	public static class BatchUpdateNamedGraphNewRevisions extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the UpdateNamedGraphNewRevisions prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchUpdateNamedGraphNewRevisions(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,updateNamedGraphNewRevisions,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the updateNamedGraphNewRevisions prepared statement.
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
	 * Runs the updateNamedGraphNRNewRevisions prepared statement.
	  * <code>
	 *  		UPDATE {0}NGR_TMP  		SET  		NEW_REVISION=( 			SELECT NAMEDGRAPHS_NR.REVISION  			FROM NAMEDGRAPHS_NR  			WHERE  			NAMEDGRAPHS_NR.ID={0}NGR_TMP.ID AND 			NAMEDGRAPHS_NR.COMMITTED=0 		),  		UUID=( 			SELECT NAMEDGRAPHS_NR.UUID  			FROM NAMEDGRAPHS_NR  			WHERE  			NAMEDGRAPHS_NR.ID={0}NGR_TMP.ID  AND  			NAMEDGRAPHS_NR.COMMITTED=0 		)  		WHERE EXISTS (SELECT NAMEDGRAPHS_NR.ID FROM NAMEDGRAPHS_NR WHERE NAMEDGRAPHS_NR.ID={0}NGR_TMP.ID) 	
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
	public static int updateNamedGraphNRNewRevisions (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(updateNamedGraphNRNewRevisions, new String[] {sessionPrefix},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"updateNamedGraphNRNewRevisions",stmtProvider.getSqlString(updateNamedGraphNRNewRevisions) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[updateNamedGraphNRNewRevisions]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the UpdateNamedGraphNRNewRevisions prepared statement
	 */
	public static class BatchUpdateNamedGraphNRNewRevisions extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the UpdateNamedGraphNRNewRevisions prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchUpdateNamedGraphNRNewRevisions(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,updateNamedGraphNRNewRevisions,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the updateNamedGraphNRNewRevisions prepared statement.
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
	 * Runs the purgeNonChangedNamedGraphEntries prepared statement.
	  * <code>
	 *  		DELETE FROM {0}NGR_TMP WHERE EXISTS(SELECT NG.REVISION FROM NAMEDGRAPHS NG WHERE NG.ID={0}NGR_TMP.ID AND NG.REVISION={0}NGR_TMP.REVISION AND ((NG.HEND IS NULL AND NG.COMMITTED=0) OR (NG.HEND IS NOT NULL AND NG.COMMITTED>0))) 	
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
	public static int purgeNonChangedNamedGraphEntries (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purgeNonChangedNamedGraphEntries, new String[] {sessionPrefix},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purgeNonChangedNamedGraphEntries",stmtProvider.getSqlString(purgeNonChangedNamedGraphEntries) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[purgeNonChangedNamedGraphEntries]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PurgeNonChangedNamedGraphEntries prepared statement
	 */
	public static class BatchPurgeNonChangedNamedGraphEntries extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PurgeNonChangedNamedGraphEntries prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurgeNonChangedNamedGraphEntries(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purgeNonChangedNamedGraphEntries,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the purgeNonChangedNamedGraphEntries prepared statement.
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
	 * Runs the purgeNonChangedNamedGraphNREntries prepared statement.
	  * <code>
	 *  		DELETE FROM {0}NGR_TMP WHERE EXISTS(SELECT NG.REVISION FROM NAMEDGRAPHS_NR NG WHERE	NG.ID={0}NGR_TMP.ID AND	NG.REVISION={0}NGR_TMP.REVISION AND	NG.COMMITTED=0) 	
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
	public static int purgeNonChangedNamedGraphNREntries (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purgeNonChangedNamedGraphNREntries, new String[] {sessionPrefix},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purgeNonChangedNamedGraphNREntries",stmtProvider.getSqlString(purgeNonChangedNamedGraphNREntries) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[purgeNonChangedNamedGraphNREntries]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PurgeNonChangedNamedGraphNREntries prepared statement
	 */
	public static class BatchPurgeNonChangedNamedGraphNREntries extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PurgeNonChangedNamedGraphNREntries prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurgeNonChangedNamedGraphNREntries(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purgeNonChangedNamedGraphNREntries,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the purgeNonChangedNamedGraphNREntries prepared statement.
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
	 * Transformer that transforms the rows in the result set for the selectNewStatements prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectNewStatementsResult> transformSelectNewStatements = new org.openanzo.jdbc.utils.Transformer<SelectNewStatementsResult>(){
		public SelectNewStatementsResult transform(java.sql.ResultSet rs) {

			
				SelectNewStatementsResult result = new SelectNewStatementsResult();
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
	 * Runs the selectNewStatements prepared statement.
	  * <code>
	 *  		SELECT  			S.NAMEDGRAPHID,S.SUBJECT,S.PREDICATE,S.OBJECT 		FROM  			STATEMENTS S,{0}NGR_TMP NG 		WHERE 			S.COMMITTED<=0 AND 			S.UUID=NG.UUID AND  			((S.RSTART>NG.REVISION AND S.REND IS NULL) OR (S.RSTART<=NG.REVISION AND S.REND>NG.REVISION)) 		ORDER BY NAMEDGRAPHID,REND 	
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
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectNewStatementsResult> selectNewStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectNewStatements, new String[] {sessionPrefix},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectNewStatementsResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectNewStatementsResult>(rs, ps, stmtProvider, transformSelectNewStatements);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectNewStatements",stmtProvider.getSqlString(selectNewStatements) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectNewStatements]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectNewStatementsResult
	 */
	public static class SelectNewStatementsResult {
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
	 * Transformer that transforms the rows in the result set for the selectNewStatementsNR prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectNewStatementsNRResult> transformSelectNewStatementsNR = new org.openanzo.jdbc.utils.Transformer<SelectNewStatementsNRResult>(){
		public SelectNewStatementsNRResult transform(java.sql.ResultSet rs) {

			
				SelectNewStatementsNRResult result = new SelectNewStatementsNRResult();
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
	 * Runs the selectNewStatementsNR prepared statement.
	  * <code>
	 *  		SELECT  			S.NAMEDGRAPHID,S.SUBJECT,S.PREDICATE,S.OBJECT 		FROM  			STATEMENTS_NR S,{0}NGR_TMP NG 		WHERE 			S.COMMITTED<=0 AND 			(S.NAMEDGRAPHID=NG.ID OR S.NAMEDGRAPHID=NG.METAID) 		ORDER BY NAMEDGRAPHID 	
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
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectNewStatementsNRResult> selectNewStatementsNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectNewStatementsNR, new String[] {sessionPrefix},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectNewStatementsNRResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectNewStatementsNRResult>(rs, ps, stmtProvider, transformSelectNewStatementsNR);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectNewStatementsNR",stmtProvider.getSqlString(selectNewStatementsNR) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectNewStatementsNR]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectNewStatementsNRResult
	 */
	public static class SelectNewStatementsNRResult {
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
	 * Runs the insertDeltaStatements prepared statement.
	  * <code>
	 *  		INSERT INTO {0}STMTS_REP_TMP 		SELECT  			S.ID,S.NAMEDGRAPHID,S.SUBJECT,S.PREDICATE,S.OBJECT,S.RSTART,S.REND 		FROM  			STATEMENTS S,{0}NGR_TMP NG 		WHERE 			NG.REVISION > -1 AND 			S.COMMITTED=0 AND 			S.UUID=NG.UUID AND  			((S.RSTART>NG.REVISION AND S.REND IS NULL) OR (S.RSTART<=NG.REVISION AND S.REND>NG.REVISION)) 	
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
	public static int insertDeltaStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertDeltaStatements, new String[] {sessionPrefix},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertDeltaStatements",stmtProvider.getSqlString(insertDeltaStatements) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertDeltaStatements]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertDeltaStatements prepared statement
	 */
	public static class BatchInsertDeltaStatements extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertDeltaStatements prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertDeltaStatements(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertDeltaStatements,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the insertDeltaStatements prepared statement.
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
	 * Runs the insertDeltaNRStatements prepared statement.
	  * <code>
	 *  		INSERT INTO {0}STMTS_REP_TMP(ID,NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT) 		SELECT  			S.ID,S.NAMEDGRAPHID,S.SUBJECT,S.PREDICATE,S.OBJECT 		FROM  			STATEMENTS_NR S 		WHERE 			S.COMMITTED=0 AND S.NAMEDGRAPHID IN (SELECT ID FROM {0}NGR_TMP WHERE REVISION>-1 UNION SELECT METAID FROM {0}NGR_TMP  WHERE REVISION>-1) 	
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
	public static int insertDeltaNRStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertDeltaNRStatements, new String[] {sessionPrefix},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertDeltaNRStatements",stmtProvider.getSqlString(insertDeltaNRStatements) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertDeltaNRStatements]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertDeltaNRStatements prepared statement
	 */
	public static class BatchInsertDeltaNRStatements extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertDeltaNRStatements prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertDeltaNRStatements(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertDeltaNRStatements,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the insertDeltaNRStatements prepared statement.
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
	 * Runs the purgeExtraStatements prepared statement.
	  * <code>
	 *  		DELETE FROM {0}STMTS_REP_TMP 		WHERE  		{0}STMTS_REP_TMP.REND IS NOT NULL AND 		EXISTS (SELECT ST2.ID FROM {0}STMTS_REP_TMP ST2 WHERE ST2.ID={0}STMTS_REP_TMP.ID AND (ST2.REND IS NULL OR ST2.REND>{0}STMTS_REP_TMP.REND)) 		 	
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
	public static int purgeExtraStatements (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purgeExtraStatements, new String[] {sessionPrefix},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purgeExtraStatements",stmtProvider.getSqlString(purgeExtraStatements) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[purgeExtraStatements]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PurgeExtraStatements prepared statement
	 */
	public static class BatchPurgeExtraStatements extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PurgeExtraStatements prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurgeExtraStatements(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purgeExtraStatements,new String[] {sessionPrefix});
		}
		
		/**
		 * Sets the input parameters for the purgeExtraStatements prepared statement.
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
	 * Transformer that transforms the rows in the result set for the selectAllStatement prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectAllStatementResult> transformSelectAllStatement = new org.openanzo.jdbc.utils.Transformer<SelectAllStatementResult>(){
		public SelectAllStatementResult transform(java.sql.ResultSet rs) {

			
				SelectAllStatementResult result = new SelectAllStatementResult();
				try {
				result.namedGraphId=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphId",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.rend=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:rend",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.subj=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:subj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.prop=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:prop",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.obj=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:obj",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the selectAllStatement prepared statement.
	  * <code>
	 *  		SELECT NAMEDGRAPHID,REND,SUBJECT,PREDICATE,OBJECT 		FROM {0}STMTS_REP_TMP 		ORDER BY NAMEDGRAPHID,REND 	
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
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectAllStatementResult> selectAllStatement (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectAllStatement, new String[] {sessionPrefix},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectAllStatementResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectAllStatementResult>(rs, ps, stmtProvider, transformSelectAllStatement);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectAllStatement",stmtProvider.getSqlString(selectAllStatement) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectAllStatement]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectAllStatementResult
	 */
	public static class SelectAllStatementResult {
			/**Value for the "namedGraphId" result value*/
			private long namedGraphId;
			/**Value for the "rend" result value*/
			private Long rend;
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
		  *Get Rend value
		  *@return Rend value
		  */
			public Long getRend() {
				return this.rend;
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
	 * Transformer that transforms the rows in the result set for the selectStatementAdditions prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectStatementAdditionsResult> transformSelectStatementAdditions = new org.openanzo.jdbc.utils.Transformer<SelectStatementAdditionsResult>(){
		public SelectStatementAdditionsResult transform(java.sql.ResultSet rs) {

			
				SelectStatementAdditionsResult result = new SelectStatementAdditionsResult();
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
	 * Runs the selectStatementAdditions prepared statement.
	  * <code>
	 *  		SELECT NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT 		FROM {0}STMTS_REP_TMP 		WHERE REND IS NULL ORDER BY NAMEDGRAPHID 	
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
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectStatementAdditionsResult> selectStatementAdditions (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectStatementAdditions, new String[] {sessionPrefix},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectStatementAdditionsResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectStatementAdditionsResult>(rs, ps, stmtProvider, transformSelectStatementAdditions);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectStatementAdditions",stmtProvider.getSqlString(selectStatementAdditions) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectStatementAdditions]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectStatementAdditionsResult
	 */
	public static class SelectStatementAdditionsResult {
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
	 * Transformer that transforms the rows in the result set for the selectStatementDeletions prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectStatementDeletionsResult> transformSelectStatementDeletions = new org.openanzo.jdbc.utils.Transformer<SelectStatementDeletionsResult>(){
		public SelectStatementDeletionsResult transform(java.sql.ResultSet rs) {

			
				SelectStatementDeletionsResult result = new SelectStatementDeletionsResult();
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
	 * Runs the selectStatementDeletions prepared statement.
	  * <code>
	 *  		SELECT NAMEDGRAPHID,SUBJECT,PREDICATE,OBJECT 		FROM {0}STMTS_REP_TMP 		WHERE REND IS NOT NULL ORDER BY NAMEDGRAPHID 	
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
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectStatementDeletionsResult> selectStatementDeletions (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectStatementDeletions, new String[] {sessionPrefix},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectStatementDeletionsResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectStatementDeletionsResult>(rs, ps, stmtProvider, transformSelectStatementDeletions);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectStatementDeletions",stmtProvider.getSqlString(selectStatementDeletions) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectStatementDeletions]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectStatementDeletionsResult
	 */
	public static class SelectStatementDeletionsResult {
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
	 * Transformer that transforms the rows in the result set for the selectUniqueUris prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectUniqueUrisResult> transformSelectUniqueUris = new org.openanzo.jdbc.utils.Transformer<SelectUniqueUrisResult>(){
		public SelectUniqueUrisResult transform(java.sql.ResultSet rs) {

			
				SelectUniqueUrisResult result = new SelectUniqueUrisResult();
				try {
				result.id=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:id",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.uri=rs.getString(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:uri",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the selectUniqueUris prepared statement.
	  * <code>
	 *  		SELECT DISTINCT {0}_U.ID,{0}_U.VALUE 		FROM {0}_U 		WHERE 			{0}_U.ID IN (SELECT  ID FROM {1}NAMEDGRAPHIDS UNION SELECT  SUBJ FROM {1}{2} UNION SELECT PREDICATE FROM {1}{3} UNION SELECT  NAMEDGRAPHID FROM {1}{4} UNION SELECT  OBJ FROM {1}{5}); 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param tableNamePrefix template parameter
	 *@param sessionPrefix template parameter
	 *@param resultsTmp1 template parameter
	 *@param resultsTmp2 template parameter
	 *@param resultsTmp3 template parameter
	 *@param resultsTmp4 template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectUniqueUrisResult> selectUniqueUris (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String tableNamePrefix, String sessionPrefix, String resultsTmp1, String resultsTmp2, String resultsTmp3, String resultsTmp4) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectUniqueUris, new String[] {tableNamePrefix, sessionPrefix, resultsTmp1, resultsTmp2, resultsTmp3, resultsTmp4},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectUniqueUrisResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectUniqueUrisResult>(rs, ps, stmtProvider, transformSelectUniqueUris);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectUniqueUris",stmtProvider.getSqlString(selectUniqueUris) ,"",""+ "tableNamePrefix="+((tableNamePrefix!=null)?tableNamePrefix.toString():"null") + "," +"sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"resultsTmp1="+((resultsTmp1!=null)?resultsTmp1.toString():"null") + "," +"resultsTmp2="+((resultsTmp2!=null)?resultsTmp2.toString():"null") + "," +"resultsTmp3="+((resultsTmp3!=null)?resultsTmp3.toString():"null") + "," +"resultsTmp4="+((resultsTmp4!=null)?resultsTmp4.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectUniqueUris]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectUniqueUrisResult
	 */
	public static class SelectUniqueUrisResult {
			/**Value for the "id" result value*/
			private long id;
			/**Value for the "uri" result value*/
			private String uri;

		/**
		  *Get Id value
		  *@return Id value
		  */
			public long getId() {
				return this.id;
			}

		/**
		  *Get Uri value
		  *@return Uri value
		  */
			public String getUri() {
				return this.uri;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the selectUniqueIds prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Long> transformSelectUniqueIds = new org.openanzo.jdbc.utils.Transformer<Long>(){
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
	 * Runs the selectUniqueIds prepared statement.
	  * <code>
	 *  		SELECT SUBJECT FROM {0}{1} UNION SELECT PREDICATE FROM {0}{2} UNION SELECT NAMEDGRAPHID FROM {0}{3} UNION SELECT OBJECT FROM {0}{4}; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *
	 *@param sessionPrefix template parameter
	 *@param resultsTmp1 template parameter
	 *@param resultsTmp2 template parameter
	 *@param resultsTmp3 template parameter
	 *@param resultsTmp4 template parameter
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<Long> selectUniqueIds (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String resultsTmp1, String resultsTmp2, String resultsTmp3, String resultsTmp4) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectUniqueIds, new String[] {sessionPrefix, resultsTmp1, resultsTmp2, resultsTmp3, resultsTmp4},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<Long> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Long>(rs, ps, stmtProvider, transformSelectUniqueIds);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectUniqueIds",stmtProvider.getSqlString(selectUniqueIds) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"resultsTmp1="+((resultsTmp1!=null)?resultsTmp1.toString():"null") + "," +"resultsTmp2="+((resultsTmp2!=null)?resultsTmp2.toString():"null") + "," +"resultsTmp3="+((resultsTmp3!=null)?resultsTmp3.toString():"null") + "," +"resultsTmp4="+((resultsTmp4!=null)?resultsTmp4.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectUniqueIds]"+endtimer);
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the selectNamedGraphs prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectNamedGraphsResult> transformSelectNamedGraphs = new org.openanzo.jdbc.utils.Transformer<SelectNamedGraphsResult>(){
		public SelectNamedGraphsResult transform(java.sql.ResultSet rs) {

			
				SelectNamedGraphsResult result = new SelectNamedGraphsResult();
				try {
				result.namedGraphid=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphid",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.uuid=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:uuid",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.revision=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:revision",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the selectNamedGraphs prepared statement.
	  * <code>
	 *  		SELECT ID,UUID,NEW_REVISION FROM {0}NGR_TMP WHERE REVISION IS NULL OR REVISION < NEW_REVISION 	
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
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectNamedGraphsResult> selectNamedGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectNamedGraphs, new String[] {sessionPrefix},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectNamedGraphsResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectNamedGraphsResult>(rs, ps, stmtProvider, transformSelectNamedGraphs);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectNamedGraphs",stmtProvider.getSqlString(selectNamedGraphs) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectNamedGraphs]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectNamedGraphsResult
	 */
	public static class SelectNamedGraphsResult {
			/**Value for the "namedGraphid" result value*/
			private long namedGraphid;
			/**Value for the "uuid" result value*/
			private long uuid;
			/**Value for the "revision" result value*/
			private long revision;

		/**
		  *Get NamedGraphid value
		  *@return NamedGraphid value
		  */
			public long getNamedGraphid() {
				return this.namedGraphid;
			}

		/**
		  *Get Uuid value
		  *@return Uuid value
		  */
			public long getUuid() {
				return this.uuid;
			}

		/**
		  *Get Revision value
		  *@return Revision value
		  */
			public long getRevision() {
				return this.revision;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the selectAllNamedGraphs prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectAllNamedGraphsResult> transformSelectAllNamedGraphs = new org.openanzo.jdbc.utils.Transformer<SelectAllNamedGraphsResult>(){
		public SelectAllNamedGraphsResult transform(java.sql.ResultSet rs) {

			
				SelectAllNamedGraphsResult result = new SelectAllNamedGraphsResult();
				try {
				result.namedGraphid=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedGraphid",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.uuid=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:uuid",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.revision=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:revision",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.newRevision=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:newRevision",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the selectAllNamedGraphs prepared statement.
	  * <code>
	 *  		SELECT ID,UUID,REVISION,NEW_REVISION FROM {0}NGR_TMP WHERE REVISION IS NULL OR NEW_REVISION IS NULL 	
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
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectAllNamedGraphsResult> selectAllNamedGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectAllNamedGraphs, new String[] {sessionPrefix},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectAllNamedGraphsResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectAllNamedGraphsResult>(rs, ps, stmtProvider, transformSelectAllNamedGraphs);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectAllNamedGraphs",stmtProvider.getSqlString(selectAllNamedGraphs) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectAllNamedGraphs]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectAllNamedGraphsResult
	 */
	public static class SelectAllNamedGraphsResult {
			/**Value for the "namedGraphid" result value*/
			private long namedGraphid;
			/**Value for the "uuid" result value*/
			private long uuid;
			/**Value for the "revision" result value*/
			private long revision;
			/**Value for the "newRevision" result value*/
			private long newRevision;

		/**
		  *Get NamedGraphid value
		  *@return NamedGraphid value
		  */
			public long getNamedGraphid() {
				return this.namedGraphid;
			}

		/**
		  *Get Uuid value
		  *@return Uuid value
		  */
			public long getUuid() {
				return this.uuid;
			}

		/**
		  *Get Revision value
		  *@return Revision value
		  */
			public long getRevision() {
				return this.revision;
			}

		/**
		  *Get NewRevision value
		  *@return NewRevision value
		  */
			public long getNewRevision() {
				return this.newRevision;
			}

	}

}