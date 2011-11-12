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
 *	NamedGraphRdbWrapper provides wrappers around SQL queries and transforms ResultSets into java objects
 *
 *	@author Generated Source from org.openanzo.jdbc.utils.opgen.jet
 */
public class NamedGraphRdbWrapper {
	private static final org.slf4j.Logger                           log                   = org.slf4j.LoggerFactory.getLogger(NamedGraphRdbWrapper.class);
	static final long CUTOFF=5;

	/**
	  *Constant "deleteStatementsForNamedGraph" used to reference prepared statement  NamedGraph.deleteStatementsForNamedGraph
	  *
	  * <code>
	  *  		UPDATE STATEMENTS SET REND=? WHERE REND IS NULL AND (NAMEDGRAPHID = ? OR NAMEDGRAPHID = ?); 	
	  * </code>
	  */
	public static final String deleteStatementsForNamedGraph = "NamedGraph.deleteStatementsForNamedGraph";

	/**
	  *Constant "deleteStatementsForNamedGraphBatch" used to reference prepared statement  NamedGraph.deleteStatementsForNamedGraphBatch
	  *
	  * <code>
	  *          UPDATE STATEMENTS SET REND=(SELECT {0}{1}.REND FROM {0}{1} WHERE {0}{1}.TYPE=0 AND {0}{1}.ID=STATEMENTS.NAMEDGRAPHID)  WHERE REND IS NULL AND NAMEDGRAPHID IN (SELECT {0}{1}.ID FROM {0}{1} WHERE {0}{1}.TYPE=0);     
	  * </code>
	  */
	public static final String deleteStatementsForNamedGraphBatch = "NamedGraph.deleteStatementsForNamedGraphBatch";

	/**
	  *Constant "purgeStatementsForNamedGraph" used to reference prepared statement  NamedGraph.purgeStatementsForNamedGraph
	  *
	  * <code>
	  *  		DELETE FROM STATEMENTS WHERE NAMEDGRAPHID = ? OR NAMEDGRAPHID = ?; 	
	  * </code>
	  */
	public static final String purgeStatementsForNamedGraph = "NamedGraph.purgeStatementsForNamedGraph";

	/**
	  *Constant "containsNamedGraphRevisioned" used to reference prepared statement  NamedGraph.containsNamedGraphRevisioned
	  *
	  * <code>
	  *   		SELECT ID FROM NAMEDGRAPHS WHERE ID = ? AND HEND IS NULL AND COMMITTED=0; 	
	  * </code>
	  */
	public static final String containsNamedGraphRevisioned = "NamedGraph.containsNamedGraphRevisioned";

	/**
	  *Constant "containsMetadataGraphRevisioned" used to reference prepared statement  NamedGraph.containsMetadataGraphRevisioned
	  *
	  * <code>
	  *   		SELECT ID FROM NAMEDGRAPHS WHERE METAID=? AND HEND IS NULL AND COMMITTED=0; 	
	  * </code>
	  */
	public static final String containsMetadataGraphRevisioned = "NamedGraph.containsMetadataGraphRevisioned";

	/**
	  *Constant "containsNamedGraphAtRevision" used to reference prepared statement  NamedGraph.containsNamedGraphAtRevision
	  *
	  * <code>
	  *   		SELECT ID FROM NAMEDGRAPHS WHERE UUID=? AND REVISION=? AND COMMITTED<=0; 	
	  * </code>
	  */
	public static final String containsNamedGraphAtRevision = "NamedGraph.containsNamedGraphAtRevision";

	/**
	  *Constant "selectNamedGraphRevisioned" used to reference prepared statement  NamedGraph.selectNamedGraphRevisioned
	  *
	  * <code>
	  *  	 		SELECT ID,METAID,UUID,REVISION,HSTART,LASTMODIFIEDBY FROM NAMEDGRAPHS WHERE ID = ? AND ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0)); 	
	  * </code>
	  */
	public static final String selectNamedGraphRevisioned = "NamedGraph.selectNamedGraphRevisioned";

	/**
	  *Constant "selectNamedGraphNonRevisioned" used to reference prepared statement  NamedGraph.selectNamedGraphNonRevisioned
	  *
	  * <code>
	  *  	 		SELECT ID,METAID,UUID,REVISION,HSTART,LASTMODIFIEDBY FROM NAMEDGRAPHS_NR WHERE ID = ? AND COMMITTED<=0; 	
	  * </code>
	  */
	public static final String selectNamedGraphNonRevisioned = "NamedGraph.selectNamedGraphNonRevisioned";

	/**
	  *Constant "selectNamedGraphRevisionedBatch" used to reference prepared statement  NamedGraph.selectNamedGraphRevisionedBatch
	  *
	  * <code>
	  *             SELECT ID,METAID,UUID,REVISION,HSTART,LASTMODIFIEDBY FROM NAMEDGRAPHS WHERE ID IN (SELECT ID FROM {0}{1}) AND ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0));     
	  * </code>
	  */
	public static final String selectNamedGraphRevisionedBatch = "NamedGraph.selectNamedGraphRevisionedBatch";

	/**
	  *Constant "selectNamedGraphNonRevisionedBatch" used to reference prepared statement  NamedGraph.selectNamedGraphNonRevisionedBatch
	  *
	  * <code>
	  *             SELECT ID,METAID,UUID,REVISION,HSTART,LASTMODIFIEDBY FROM NAMEDGRAPHS_NR WHERE ID IN (SELECT ID FROM {0}{1}) AND COMMITTED<=0;     
	  * </code>
	  */
	public static final String selectNamedGraphNonRevisionedBatch = "NamedGraph.selectNamedGraphNonRevisionedBatch";

	/**
	  *Constant "getAllRevisionedNamedGraphs" used to reference prepared statement  NamedGraph.getAllRevisionedNamedGraphs
	  *
	  * <code>
	  *  	 		SELECT ID FROM NAMEDGRAPHS WHERE ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0)) UNION SELECT METAID FROM NAMEDGRAPHS WHERE ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0)); 	
	  * </code>
	  */
	public static final String getAllRevisionedNamedGraphs = "NamedGraph.getAllRevisionedNamedGraphs";

	/**
	  *Constant "countAllRevisionedNamedGraphs" used to reference prepared statement  NamedGraph.countAllRevisionedNamedGraphs
	  *
	  * <code>
	  *  	 		SELECT COUNT(1) FROM NAMEDGRAPHS WHERE ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0)); 	
	  * </code>
	  */
	public static final String countAllRevisionedNamedGraphs = "NamedGraph.countAllRevisionedNamedGraphs";

	/**
	  *Constant "containsNamedGraphNonRevisioned" used to reference prepared statement  NamedGraph.containsNamedGraphNonRevisioned
	  *
	  * <code>
	  *  		SELECT ID FROM NAMEDGRAPHS_NR WHERE ID = ?; 	
	  * </code>
	  */
	public static final String containsNamedGraphNonRevisioned = "NamedGraph.containsNamedGraphNonRevisioned";

	/**
	  *Constant "containsNamedGraphNRAtRevision" used to reference prepared statement  NamedGraph.containsNamedGraphNRAtRevision
	  *
	  * <code>
	  *  		SELECT ID FROM NAMEDGRAPHS_NR WHERE ID = ?  AND REVISION=?; 	
	  * </code>
	  */
	public static final String containsNamedGraphNRAtRevision = "NamedGraph.containsNamedGraphNRAtRevision";

	/**
	  *Constant "containsMetadataGraphNonRevisioned" used to reference prepared statement  NamedGraph.containsMetadataGraphNonRevisioned
	  *
	  * <code>
	  *  		SELECT ID FROM NAMEDGRAPHS_NR WHERE METAID=?; 	
	  * </code>
	  */
	public static final String containsMetadataGraphNonRevisioned = "NamedGraph.containsMetadataGraphNonRevisioned";

	/**
	  *Constant "containsMetadataGraphNRAtRevision" used to reference prepared statement  NamedGraph.containsMetadataGraphNRAtRevision
	  *
	  * <code>
	  *  		SELECT ID FROM NAMEDGRAPHS_NR WHERE METAID=? AND REVISION=?; 	
	  * </code>
	  */
	public static final String containsMetadataGraphNRAtRevision = "NamedGraph.containsMetadataGraphNRAtRevision";

	/**
	  *Constant "getAllNonRevisionedNamedGraphs" used to reference prepared statement  NamedGraph.getAllNonRevisionedNamedGraphs
	  *
	  * <code>
	  *   		SELECT ID FROM NAMEDGRAPHS_NR WHERE COMMITTED<=0 UNION SELECT METAID FROM NAMEDGRAPHS_NR WHERE COMMITTED<=0; 	
	  * </code>
	  */
	public static final String getAllNonRevisionedNamedGraphs = "NamedGraph.getAllNonRevisionedNamedGraphs";

	/**
	  *Constant "countAllNonRevisionedNamedGraphs" used to reference prepared statement  NamedGraph.countAllNonRevisionedNamedGraphs
	  *
	  * <code>
	  *   		SELECT COUNT(1) FROM NAMEDGRAPHS_NR WHERE COMMITTED<=0; 	
	  * </code>
	  */
	public static final String countAllNonRevisionedNamedGraphs = "NamedGraph.countAllNonRevisionedNamedGraphs";

	/**
	  *Constant "getNamedGraphForUUID" used to reference prepared statement  NamedGraph.getNamedGraphForUUID
	  *
	  * <code>
	  *  	 		SELECT ID FROM NAMEDGRAPHS WHERE UUID=? AND ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0)); 	
	  * </code>
	  */
	public static final String getNamedGraphForUUID = "NamedGraph.getNamedGraphForUUID";

	/**
	  *Constant "getNamedGraphForUUIDNR" used to reference prepared statement  NamedGraph.getNamedGraphForUUIDNR
	  *
	  * <code>
	  *  	 		SELECT ID FROM NAMEDGRAPHS_NR WHERE UUID=? AND COMMITTED<=0; 	
	  * </code>
	  */
	public static final String getNamedGraphForUUIDNR = "NamedGraph.getNamedGraphForUUIDNR";

	/**
	  *Constant "getUUIDForNamedGraph" used to reference prepared statement  NamedGraph.getUUIDForNamedGraph
	  *
	  * <code>
	  *  	 		SELECT UUID FROM NAMEDGRAPHS WHERE ID=? AND ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0)); 	
	  * </code>
	  */
	public static final String getUUIDForNamedGraph = "NamedGraph.getUUIDForNamedGraph";

	/**
	  *Constant "getUUIDForNamedGraphNR" used to reference prepared statement  NamedGraph.getUUIDForNamedGraphNR
	  *
	  * <code>
	  *  	 		SELECT UUID FROM NAMEDGRAPHS_NR WHERE ID=? AND COMMITTED<=0; 	
	  * </code>
	  */
	public static final String getUUIDForNamedGraphNR = "NamedGraph.getUUIDForNamedGraphNR";

	/**
	  *Constant "getBatchNamedGraphForUUID" used to reference prepared statement  NamedGraph.getBatchNamedGraphForUUID
	  *
	  * <code>
	  *             SELECT UUID,ID FROM NAMEDGRAPHS WHERE UUID IN (SELECT ID FROM {0}{1}) AND ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0));     
	  * </code>
	  */
	public static final String getBatchNamedGraphForUUID = "NamedGraph.getBatchNamedGraphForUUID";

	/**
	  *Constant "getBatchNamedGraphForUUIDNR" used to reference prepared statement  NamedGraph.getBatchNamedGraphForUUIDNR
	  *
	  * <code>
	  *             SELECT UUID,ID FROM NAMEDGRAPHS_NR WHERE UUID IN (SELECT ID FROM {0}{1}) AND COMMITTED<=0;     
	  * </code>
	  */
	public static final String getBatchNamedGraphForUUIDNR = "NamedGraph.getBatchNamedGraphForUUIDNR";

	/**
	  *Constant "getBatchUUIDForNamedGraph" used to reference prepared statement  NamedGraph.getBatchUUIDForNamedGraph
	  *
	  * <code>
	  *             SELECT UUID,ID FROM NAMEDGRAPHS WHERE ID IN (SELECT ID FROM {0}{1}) AND ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0));     
	  * </code>
	  */
	public static final String getBatchUUIDForNamedGraph = "NamedGraph.getBatchUUIDForNamedGraph";

	/**
	  *Constant "getBatchUUIDForNamedGraphNR" used to reference prepared statement  NamedGraph.getBatchUUIDForNamedGraphNR
	  *
	  * <code>
	  *             SELECT UUID,ID FROM NAMEDGRAPHS_NR WHERE ID IN (SELECT ID FROM {0}{1}) AND COMMITTED<=0;     
	  * </code>
	  */
	public static final String getBatchUUIDForNamedGraphNR = "NamedGraph.getBatchUUIDForNamedGraphNR";

	/**
	  *Constant "insertNamedGraph" used to reference prepared statement  NamedGraph.insertNamedGraph
	  *
	  * <code>
	  *  		INSERT INTO NAMEDGRAPHS (HSTART, ID, METAID,UUID,REVISION,LASTMODIFIEDBY,COMMITTED) VALUES (?, ?, ?,?, ?,?,?); 	
	  * </code>
	  */
	public static final String insertNamedGraph = "NamedGraph.insertNamedGraph";

	/**
	  *Constant "deleteNamedGraph" used to reference prepared statement  NamedGraph.deleteNamedGraph
	  *
	  * <code>
	  *  		UPDATE NAMEDGRAPHS SET HEND=?,COMMITTED=? WHERE ID = ? AND HEND IS NULL; 	
	  * </code>
	  */
	public static final String deleteNamedGraph = "NamedGraph.deleteNamedGraph";

	/**
	  *Constant "deleteNamedGraphBatch" used to reference prepared statement  NamedGraph.deleteNamedGraphBatch
	  *
	  * <code>
	  *          UPDATE NAMEDGRAPHS SET HEND=?,COMMITTED=? WHERE ID IN (SELECT {0}{1}.ID FROM {0}{1} WHERE {0}{1}.TYPE=0) AND HEND IS NULL;     
	  * </code>
	  */
	public static final String deleteNamedGraphBatch = "NamedGraph.deleteNamedGraphBatch";

	/**
	  *Constant "purgeNamedGraph" used to reference prepared statement  NamedGraph.purgeNamedGraph
	  *
	  * <code>
	  *  		DELTE FROM NAMEDGRAPHS WHERE WHERE ID = ? 	
	  * </code>
	  */
	public static final String purgeNamedGraph = "NamedGraph.purgeNamedGraph";

	/**
	  *Constant "insertNamedGraphNR" used to reference prepared statement  NamedGraph.insertNamedGraphNR
	  *
	  * <code>
	  *  		INSERT INTO NAMEDGRAPHS_NR (HSTART, ID, METAID,UUID, REVISION,LASTMODIFIEDBY,COMMITTED) VALUES (?, ?,?,?,?,?,?); 	
	  * </code>
	  */
	public static final String insertNamedGraphNR = "NamedGraph.insertNamedGraphNR";

	/**
	  *Constant "deleteNamedGraphNR" used to reference prepared statement  NamedGraph.deleteNamedGraphNR
	  *
	  * <code>
	  *  		UPDATE NAMEDGRAPHS_NR SET COMMITTED=? WHERE ID = ?; 	
	  * </code>
	  */
	public static final String deleteNamedGraphNR = "NamedGraph.deleteNamedGraphNR";

	/**
	  *Constant "deleteNamedGraphNRBatch" used to reference prepared statement  NamedGraph.deleteNamedGraphNRBatch
	  *
	  * <code>
	  *          UPDATE NAMEDGRAPHS_NR SET COMMITTED=? WHERE ID IN (SELECT {0}{1}.ID FROM {0}{1} WHERE {0}{1}.TYPE=1);     
	  * </code>
	  */
	public static final String deleteNamedGraphNRBatch = "NamedGraph.deleteNamedGraphNRBatch";

	/**
	  *Constant "deleteStatementsForNamedGraphNR" used to reference prepared statement  NamedGraph.deleteStatementsForNamedGraphNR
	  *
	  * <code>
	  *  		DELETE FROM STATEMENTS_NR WHERE NAMEDGRAPHID = ? OR NAMEDGRAPHID = ?; 	
	  * </code>
	  */
	public static final String deleteStatementsForNamedGraphNR = "NamedGraph.deleteStatementsForNamedGraphNR";

	/**
	  *Constant "deleteStatementsForNamedGraphNRBatch" used to reference prepared statement  NamedGraph.deleteStatementsForNamedGraphNRBatch
	  *
	  * <code>
	  *          DELETE FROM STATEMENTS_NR WHERE NAMEDGRAPHID IN (SELECT {0}{1}.ID FROM {0}{1} WHERE {0}{1}.TYPE=1);     
	  * </code>
	  */
	public static final String deleteStatementsForNamedGraphNRBatch = "NamedGraph.deleteStatementsForNamedGraphNRBatch";

	/**
	  *Constant "updateNamedGraphNR" used to reference prepared statement  NamedGraph.updateNamedGraphNR
	  *
	  * <code>
	  *  		UPDATE NAMEDGRAPHS_NR SET COMMITTED=? WHERE ID = ?; 	
	  * </code>
	  */
	public static final String updateNamedGraphNR = "NamedGraph.updateNamedGraphNR";

	/**
	  *Constant "selectNamedGraphRevision" used to reference prepared statement  NamedGraph.selectNamedGraphRevision
	  *
	  * <code>
	  *   		SELECT SUBJECT,PREDICATE,OBJECT,NAMEDGRAPHID 		FROM STATEMENTS S 		WHERE S.UUID=? AND COMMITTED=0 AND S.RSTART<=? AND (S.REND IS NULL OR S.REND>?); 		
	  * </code>
	  */
	public static final String selectNamedGraphRevision = "NamedGraph.selectNamedGraphRevision";

	/**
	  *Constant "selectNamedGraphSize" used to reference prepared statement  NamedGraph.selectNamedGraphSize
	  *
	  * <code>
	  *   			SELECT DISTINCT COUNT(1)  			FROM STATEMENTS SH 			WHERE SH.NAMEDGRAPHID = ?  AND 			((SH.HEND IS NULL AND SH.COMMITTED=0) OR (SH.HEND IS NOT NULL AND SH.COMMITTED<0)) 		
	  * </code>
	  */
	public static final String selectNamedGraphSize = "NamedGraph.selectNamedGraphSize";

	/**
	  *Constant "selectNamedGraphSizeNonRevisioned" used to reference prepared statement  NamedGraph.selectNamedGraphSizeNonRevisioned
	  *
	  * <code>
	  *   			SELECT DISTINCT COUNT(1)  			FROM STATEMENTS_NR SH 			WHERE SH.NAMEDGRAPHID = ? AND 			SH.COMMITTED<=0 		
	  * </code>
	  */
	public static final String selectNamedGraphSizeNonRevisioned = "NamedGraph.selectNamedGraphSizeNonRevisioned";

	/**
	  *Constant "insertIdsIntoTempTable" used to reference prepared statement  NamedGraph.insertIdsIntoTempTable
	  *
	  * <code>
	  *  	    INSERT INTO {0}{1} VALUES (?) 	
	  * </code>
	  */
	public static final String insertIdsIntoTempTable = "NamedGraph.insertIdsIntoTempTable";

	/**
	  *Constant "lockNamedGraph" used to reference prepared statement  NamedGraph.lockNamedGraph
	  *
	  * <code>
	  *  	    INSERT INTO LOCKED_GRAPHS(ID,TRANSACTIONID) VALUES (?,?) 	
	  * </code>
	  */
	public static final String lockNamedGraph = "NamedGraph.lockNamedGraph";

	/**
	  *Constant "unlockNamedGraph" used to reference prepared statement  NamedGraph.unlockNamedGraph
	  *
	  * <code>
	  *  	    DELETE FROM LOCKED_GRAPHS WHERE ID=? AND TRANSACTIONID=? 	
	  * </code>
	  */
	public static final String unlockNamedGraph = "NamedGraph.unlockNamedGraph";

	/**
	  *Constant "purgelockedNamedGraph" used to reference prepared statement  NamedGraph.purgelockedNamedGraph
	  *
	  * <code>
	  *  	    DELETE FROM LOCKED_GRAPHS WHERE TRANSACTIONID=? 	
	  * </code>
	  */
	public static final String purgelockedNamedGraph = "NamedGraph.purgelockedNamedGraph";

	/**
	  *Constant "insertRemovedGraph" used to reference prepared statement  NamedGraph.insertRemovedGraph
	  *
	  * <code>
	  *          INSERT INTO {0}{1}(ID,TYPE,REND) VALUES (?,?,?)     
	  * </code>
	  */
	public static final String insertRemovedGraph = "NamedGraph.insertRemovedGraph";



	
	/**
	 * Runs the deleteStatementsForNamedGraph prepared statement.
	  * <code>
	 *  		UPDATE STATEMENTS SET REND=? WHERE REND IS NULL AND (NAMEDGRAPHID = ? OR NAMEDGRAPHID = ?); 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param rend template parameter
	 *@param id template parameter
	 *@param metaId template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int deleteStatementsForNamedGraph (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long rend, long id, long metaId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(deleteStatementsForNamedGraph, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, rend);
			ps.setLong(argc++, id);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"deleteStatementsForNamedGraph",stmtProvider.getSqlString(deleteStatementsForNamedGraph) ,""+ "rend="+(rend) + "," +"id="+(id) + "," +"metaId="+(metaId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[deleteStatementsForNamedGraph]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the DeleteStatementsForNamedGraph prepared statement
	 */
	public static class BatchDeleteStatementsForNamedGraph extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the DeleteStatementsForNamedGraph prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchDeleteStatementsForNamedGraph(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,deleteStatementsForNamedGraph,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the deleteStatementsForNamedGraph prepared statement.
		 *
	 *@param rend template parameter
	 *@param id template parameter
	 *@param metaId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long rend, long id, long metaId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, rend);
			ps.setLong(argc++, id);
			ps.setLong(argc++, metaId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the deleteStatementsForNamedGraphBatch prepared statement.
	  * <code>
	 *          UPDATE STATEMENTS SET REND=(SELECT {0}{1}.REND FROM {0}{1} WHERE {0}{1}.TYPE=0 AND {0}{1}.ID=STATEMENTS.NAMEDGRAPHID)  WHERE REND IS NULL AND NAMEDGRAPHID IN (SELECT {0}{1}.ID FROM {0}{1} WHERE {0}{1}.TYPE=0);     
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
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int deleteStatementsForNamedGraphBatch (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(deleteStatementsForNamedGraphBatch, new String[] {sessionPrefix, tableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"deleteStatementsForNamedGraphBatch",stmtProvider.getSqlString(deleteStatementsForNamedGraphBatch) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[deleteStatementsForNamedGraphBatch]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the DeleteStatementsForNamedGraphBatch prepared statement
	 */
	public static class BatchDeleteStatementsForNamedGraphBatch extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the DeleteStatementsForNamedGraphBatch prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchDeleteStatementsForNamedGraphBatch(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,deleteStatementsForNamedGraphBatch,new String[] {sessionPrefix, tableName});
		}
		
		/**
		 * Sets the input parameters for the deleteStatementsForNamedGraphBatch prepared statement.
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
	 * Runs the purgeStatementsForNamedGraph prepared statement.
	  * <code>
	 *  		DELETE FROM STATEMENTS WHERE NAMEDGRAPHID = ? OR NAMEDGRAPHID = ?; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *@param metaId template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int purgeStatementsForNamedGraph (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, long metaId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purgeStatementsForNamedGraph, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, id);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purgeStatementsForNamedGraph",stmtProvider.getSqlString(purgeStatementsForNamedGraph) ,""+ "id="+(id) + "," +"metaId="+(metaId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[purgeStatementsForNamedGraph]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PurgeStatementsForNamedGraph prepared statement
	 */
	public static class BatchPurgeStatementsForNamedGraph extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PurgeStatementsForNamedGraph prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurgeStatementsForNamedGraph(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purgeStatementsForNamedGraph,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the purgeStatementsForNamedGraph prepared statement.
		 *
	 *@param id template parameter
	 *@param metaId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long id, long metaId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, id);
			ps.setLong(argc++, metaId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the containsNamedGraphRevisioned prepared statement.
	  * <code>
	 *   		SELECT ID FROM NAMEDGRAPHS WHERE ID = ? AND HEND IS NULL AND COMMITTED=0; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long containsNamedGraphRevisioned (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(containsNamedGraphRevisioned, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, id);
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
					return null;				 
				Long val = rs.getLong(1);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"containsNamedGraphRevisioned",stmtProvider.getSqlString(containsNamedGraphRevisioned) ,""+ "id="+(id),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[containsNamedGraphRevisioned]"+endtimer);
		}
	}




	
	/**
	 * Runs the containsMetadataGraphRevisioned prepared statement.
	  * <code>
	 *   		SELECT ID FROM NAMEDGRAPHS WHERE METAID=? AND HEND IS NULL AND COMMITTED=0; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long containsMetadataGraphRevisioned (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(containsMetadataGraphRevisioned, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, id);
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
					return null;				 
				Long val = rs.getLong(1);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"containsMetadataGraphRevisioned",stmtProvider.getSqlString(containsMetadataGraphRevisioned) ,""+ "id="+(id),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[containsMetadataGraphRevisioned]"+endtimer);
		}
	}




	
	/**
	 * Runs the containsNamedGraphAtRevision prepared statement.
	  * <code>
	 *   		SELECT ID FROM NAMEDGRAPHS WHERE UUID=? AND REVISION=? AND COMMITTED<=0; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param uuid template parameter
	 *@param revision template parameter
	 *
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long containsNamedGraphAtRevision (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long uuid, long revision) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(containsNamedGraphAtRevision, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, uuid);
			ps.setLong(argc++, revision);
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
					return null;				 
				Long val = rs.getLong(1);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"containsNamedGraphAtRevision",stmtProvider.getSqlString(containsNamedGraphAtRevision) ,""+ "uuid="+(uuid) + "," +"revision="+(revision),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[containsNamedGraphAtRevision]"+endtimer);
		}
	}




	
	/**
	 * Runs the selectNamedGraphRevisioned prepared statement.
	  * <code>
	 *  	 		SELECT ID,METAID,UUID,REVISION,HSTART,LASTMODIFIEDBY FROM NAMEDGRAPHS WHERE ID = ? AND ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0)); 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *
	 *@return  SelectNamedGraphRevisionedResult
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static SelectNamedGraphRevisionedResult selectNamedGraphRevisioned (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectNamedGraphRevisioned, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, id);
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
		SelectNamedGraphRevisionedResult result=new SelectNamedGraphRevisionedResult();
				result.id=rs.getLong(1);
				result.metaId=rs.getLong(2);
				result.uuid=rs.getLong(3);
				result.revision=rs.getLong(4);
				result.hstart=rs.getLong(5);
				result.lastModifiedBy=rs.getLong(6);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectNamedGraphRevisioned",stmtProvider.getSqlString(selectNamedGraphRevisioned) ,""+ "id="+(id),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectNamedGraphRevisioned]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectNamedGraphRevisionedResult
	 */
	public static class SelectNamedGraphRevisionedResult {
			/**Value for the "id" result value*/
			private long id;
			/**Value for the "metaId" result value*/
			private long metaId;
			/**Value for the "uuid" result value*/
			private long uuid;
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
	 * Runs the selectNamedGraphNonRevisioned prepared statement.
	  * <code>
	 *  	 		SELECT ID,METAID,UUID,REVISION,HSTART,LASTMODIFIEDBY FROM NAMEDGRAPHS_NR WHERE ID = ? AND COMMITTED<=0; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *
	 *@return  SelectNamedGraphNonRevisionedResult
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static SelectNamedGraphNonRevisionedResult selectNamedGraphNonRevisioned (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectNamedGraphNonRevisioned, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, id);
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
		SelectNamedGraphNonRevisionedResult result=new SelectNamedGraphNonRevisionedResult();
				result.id=rs.getLong(1);
				result.metaId=rs.getLong(2);
				result.uuid=rs.getLong(3);
				result.revision=rs.getLong(4);
				result.hstart=rs.getLong(5);
				result.lastModifiedBy=rs.getLong(6);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectNamedGraphNonRevisioned",stmtProvider.getSqlString(selectNamedGraphNonRevisioned) ,""+ "id="+(id),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectNamedGraphNonRevisioned]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectNamedGraphNonRevisionedResult
	 */
	public static class SelectNamedGraphNonRevisionedResult {
			/**Value for the "id" result value*/
			private long id;
			/**Value for the "metaId" result value*/
			private long metaId;
			/**Value for the "uuid" result value*/
			private long uuid;
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
	 * Transformer that transforms the rows in the result set for the selectNamedGraphRevisionedBatch prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectNamedGraphRevisionedBatchResult> transformSelectNamedGraphRevisionedBatch = new org.openanzo.jdbc.utils.Transformer<SelectNamedGraphRevisionedBatchResult>(){
		public SelectNamedGraphRevisionedBatchResult transform(java.sql.ResultSet rs) {

			
				SelectNamedGraphRevisionedBatchResult result = new SelectNamedGraphRevisionedBatchResult();
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
				result.uuid=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:uuid",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.revision=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:revision",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.hstart=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:hstart",e);
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
	 * Runs the selectNamedGraphRevisionedBatch prepared statement.
	  * <code>
	 *             SELECT ID,METAID,UUID,REVISION,HSTART,LASTMODIFIEDBY FROM NAMEDGRAPHS WHERE ID IN (SELECT ID FROM {0}{1}) AND ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0));     
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
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectNamedGraphRevisionedBatchResult> selectNamedGraphRevisionedBatch (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectNamedGraphRevisionedBatch, new String[] {sessionPrefix, tableName},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectNamedGraphRevisionedBatchResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectNamedGraphRevisionedBatchResult>(rs, ps, stmtProvider, transformSelectNamedGraphRevisionedBatch);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectNamedGraphRevisionedBatch",stmtProvider.getSqlString(selectNamedGraphRevisionedBatch) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectNamedGraphRevisionedBatch]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectNamedGraphRevisionedBatchResult
	 */
	public static class SelectNamedGraphRevisionedBatchResult {
			/**Value for the "id" result value*/
			private long id;
			/**Value for the "metaId" result value*/
			private long metaId;
			/**Value for the "uuid" result value*/
			private long uuid;
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
	 * Transformer that transforms the rows in the result set for the selectNamedGraphNonRevisionedBatch prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectNamedGraphNonRevisionedBatchResult> transformSelectNamedGraphNonRevisionedBatch = new org.openanzo.jdbc.utils.Transformer<SelectNamedGraphNonRevisionedBatchResult>(){
		public SelectNamedGraphNonRevisionedBatchResult transform(java.sql.ResultSet rs) {

			
				SelectNamedGraphNonRevisionedBatchResult result = new SelectNamedGraphNonRevisionedBatchResult();
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
				result.uuid=rs.getLong(3);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:uuid",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.revision=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:revision",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.hstart=rs.getLong(5);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:hstart",e);
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
	 * Runs the selectNamedGraphNonRevisionedBatch prepared statement.
	  * <code>
	 *             SELECT ID,METAID,UUID,REVISION,HSTART,LASTMODIFIEDBY FROM NAMEDGRAPHS_NR WHERE ID IN (SELECT ID FROM {0}{1}) AND COMMITTED<=0;     
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
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectNamedGraphNonRevisionedBatchResult> selectNamedGraphNonRevisionedBatch (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectNamedGraphNonRevisionedBatch, new String[] {sessionPrefix, tableName},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectNamedGraphNonRevisionedBatchResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectNamedGraphNonRevisionedBatchResult>(rs, ps, stmtProvider, transformSelectNamedGraphNonRevisionedBatch);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectNamedGraphNonRevisionedBatch",stmtProvider.getSqlString(selectNamedGraphNonRevisionedBatch) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectNamedGraphNonRevisionedBatch]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectNamedGraphNonRevisionedBatchResult
	 */
	public static class SelectNamedGraphNonRevisionedBatchResult {
			/**Value for the "id" result value*/
			private long id;
			/**Value for the "metaId" result value*/
			private long metaId;
			/**Value for the "uuid" result value*/
			private long uuid;
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
	 * Transformer that transforms the rows in the result set for the getAllRevisionedNamedGraphs prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Long> transformGetAllRevisionedNamedGraphs = new org.openanzo.jdbc.utils.Transformer<Long>(){
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
	 * Runs the getAllRevisionedNamedGraphs prepared statement.
	  * <code>
	 *  	 		SELECT ID FROM NAMEDGRAPHS WHERE ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0)) UNION SELECT METAID FROM NAMEDGRAPHS WHERE ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0)); 	
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
	public static org.openanzo.jdbc.utils.ClosableIterator<Long> getAllRevisionedNamedGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(getAllRevisionedNamedGraphs, new String[] {},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<Long> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Long>(rs, ps, stmtProvider, transformGetAllRevisionedNamedGraphs);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"getAllRevisionedNamedGraphs",stmtProvider.getSqlString(getAllRevisionedNamedGraphs) ,"","");
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[getAllRevisionedNamedGraphs]"+endtimer);
		}
	}




	
	/**
	 * Runs the countAllRevisionedNamedGraphs prepared statement.
	  * <code>
	 *  	 		SELECT COUNT(1) FROM NAMEDGRAPHS WHERE ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0)); 	
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
	public static long countAllRevisionedNamedGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(countAllRevisionedNamedGraphs, new String[] {},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"countAllRevisionedNamedGraphs",stmtProvider.getSqlString(countAllRevisionedNamedGraphs) ,"","");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[countAllRevisionedNamedGraphs]"+endtimer);
		}
	}




	
	/**
	 * Runs the containsNamedGraphNonRevisioned prepared statement.
	  * <code>
	 *  		SELECT ID FROM NAMEDGRAPHS_NR WHERE ID = ?; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long containsNamedGraphNonRevisioned (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(containsNamedGraphNonRevisioned, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, id);
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
					return null;				 
				Long val = rs.getLong(1);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"containsNamedGraphNonRevisioned",stmtProvider.getSqlString(containsNamedGraphNonRevisioned) ,""+ "id="+(id),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[containsNamedGraphNonRevisioned]"+endtimer);
		}
	}




	
	/**
	 * Runs the containsNamedGraphNRAtRevision prepared statement.
	  * <code>
	 *  		SELECT ID FROM NAMEDGRAPHS_NR WHERE ID = ?  AND REVISION=?; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *@param revision template parameter
	 *
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long containsNamedGraphNRAtRevision (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, long revision) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(containsNamedGraphNRAtRevision, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, id);
			ps.setLong(argc++, revision);
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
					return null;				 
				Long val = rs.getLong(1);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"containsNamedGraphNRAtRevision",stmtProvider.getSqlString(containsNamedGraphNRAtRevision) ,""+ "id="+(id) + "," +"revision="+(revision),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[containsNamedGraphNRAtRevision]"+endtimer);
		}
	}




	
	/**
	 * Runs the containsMetadataGraphNonRevisioned prepared statement.
	  * <code>
	 *  		SELECT ID FROM NAMEDGRAPHS_NR WHERE METAID=?; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long containsMetadataGraphNonRevisioned (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(containsMetadataGraphNonRevisioned, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, id);
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
					return null;				 
				Long val = rs.getLong(1);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"containsMetadataGraphNonRevisioned",stmtProvider.getSqlString(containsMetadataGraphNonRevisioned) ,""+ "id="+(id),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[containsMetadataGraphNonRevisioned]"+endtimer);
		}
	}




	
	/**
	 * Runs the containsMetadataGraphNRAtRevision prepared statement.
	  * <code>
	 *  		SELECT ID FROM NAMEDGRAPHS_NR WHERE METAID=? AND REVISION=?; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *@param revision template parameter
	 *
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long containsMetadataGraphNRAtRevision (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, long revision) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(containsMetadataGraphNRAtRevision, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, id);
			ps.setLong(argc++, revision);
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
					return null;				 
				Long val = rs.getLong(1);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"containsMetadataGraphNRAtRevision",stmtProvider.getSqlString(containsMetadataGraphNRAtRevision) ,""+ "id="+(id) + "," +"revision="+(revision),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[containsMetadataGraphNRAtRevision]"+endtimer);
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the getAllNonRevisionedNamedGraphs prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<Long> transformGetAllNonRevisionedNamedGraphs = new org.openanzo.jdbc.utils.Transformer<Long>(){
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
	 * Runs the getAllNonRevisionedNamedGraphs prepared statement.
	  * <code>
	 *   		SELECT ID FROM NAMEDGRAPHS_NR WHERE COMMITTED<=0 UNION SELECT METAID FROM NAMEDGRAPHS_NR WHERE COMMITTED<=0; 	
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
	public static org.openanzo.jdbc.utils.ClosableIterator<Long> getAllNonRevisionedNamedGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(getAllNonRevisionedNamedGraphs, new String[] {},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<Long> iter = new org.openanzo.jdbc.utils.ResultSetIterator<Long>(rs, ps, stmtProvider, transformGetAllNonRevisionedNamedGraphs);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"getAllNonRevisionedNamedGraphs",stmtProvider.getSqlString(getAllNonRevisionedNamedGraphs) ,"","");
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[getAllNonRevisionedNamedGraphs]"+endtimer);
		}
	}




	
	/**
	 * Runs the countAllNonRevisionedNamedGraphs prepared statement.
	  * <code>
	 *   		SELECT COUNT(1) FROM NAMEDGRAPHS_NR WHERE COMMITTED<=0; 	
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
	public static long countAllNonRevisionedNamedGraphs (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(countAllNonRevisionedNamedGraphs, new String[] {},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"countAllNonRevisionedNamedGraphs",stmtProvider.getSqlString(countAllNonRevisionedNamedGraphs) ,"","");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[countAllNonRevisionedNamedGraphs]"+endtimer);
		}
	}




	
	/**
	 * Runs the getNamedGraphForUUID prepared statement.
	  * <code>
	 *  	 		SELECT ID FROM NAMEDGRAPHS WHERE UUID=? AND ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0)); 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param uuid template parameter
	 *
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long getNamedGraphForUUID (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long uuid) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(getNamedGraphForUUID, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, uuid);
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
					return null;				 
				Long val = rs.getLong(1);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"getNamedGraphForUUID",stmtProvider.getSqlString(getNamedGraphForUUID) ,""+ "uuid="+(uuid),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[getNamedGraphForUUID]"+endtimer);
		}
	}




	
	/**
	 * Runs the getNamedGraphForUUIDNR prepared statement.
	  * <code>
	 *  	 		SELECT ID FROM NAMEDGRAPHS_NR WHERE UUID=? AND COMMITTED<=0; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param uuid template parameter
	 *
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long getNamedGraphForUUIDNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long uuid) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(getNamedGraphForUUIDNR, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, uuid);
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
					return null;				 
				Long val = rs.getLong(1);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"getNamedGraphForUUIDNR",stmtProvider.getSqlString(getNamedGraphForUUIDNR) ,""+ "uuid="+(uuid),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[getNamedGraphForUUIDNR]"+endtimer);
		}
	}




	
	/**
	 * Runs the getUUIDForNamedGraph prepared statement.
	  * <code>
	 *  	 		SELECT UUID FROM NAMEDGRAPHS WHERE ID=? AND ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0)); 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param uri template parameter
	 *
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long getUUIDForNamedGraph (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long uri) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(getUUIDForNamedGraph, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, uri);
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
					return null;				 
				Long val = rs.getLong(1);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"getUUIDForNamedGraph",stmtProvider.getSqlString(getUUIDForNamedGraph) ,""+ "uri="+(uri),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[getUUIDForNamedGraph]"+endtimer);
		}
	}




	
	/**
	 * Runs the getUUIDForNamedGraphNR prepared statement.
	  * <code>
	 *  	 		SELECT UUID FROM NAMEDGRAPHS_NR WHERE ID=? AND COMMITTED<=0; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param uri template parameter
	 *
	 *@return  Long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static Long getUUIDForNamedGraphNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long uri) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(getUUIDForNamedGraphNR, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, uri);
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
					return null;				 
				Long val = rs.getLong(1);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"getUUIDForNamedGraphNR",stmtProvider.getSqlString(getUUIDForNamedGraphNR) ,""+ "uri="+(uri),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[getUUIDForNamedGraphNR]"+endtimer);
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the getBatchNamedGraphForUUID prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<GetBatchNamedGraphForUUIDResult> transformGetBatchNamedGraphForUUID = new org.openanzo.jdbc.utils.Transformer<GetBatchNamedGraphForUUIDResult>(){
		public GetBatchNamedGraphForUUIDResult transform(java.sql.ResultSet rs) {

			
				GetBatchNamedGraphForUUIDResult result = new GetBatchNamedGraphForUUIDResult();
				try {
				result.uuid=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:uuid",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.id=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:id",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the getBatchNamedGraphForUUID prepared statement.
	  * <code>
	 *             SELECT UUID,ID FROM NAMEDGRAPHS WHERE UUID IN (SELECT ID FROM {0}{1}) AND ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0));     
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
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<GetBatchNamedGraphForUUIDResult> getBatchNamedGraphForUUID (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(getBatchNamedGraphForUUID, new String[] {sessionPrefix, tableName},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<GetBatchNamedGraphForUUIDResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<GetBatchNamedGraphForUUIDResult>(rs, ps, stmtProvider, transformGetBatchNamedGraphForUUID);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"getBatchNamedGraphForUUID",stmtProvider.getSqlString(getBatchNamedGraphForUUID) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[getBatchNamedGraphForUUID]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of GetBatchNamedGraphForUUIDResult
	 */
	public static class GetBatchNamedGraphForUUIDResult {
			/**Value for the "uuid" result value*/
			private Long uuid;
			/**Value for the "id" result value*/
			private Long id;

		/**
		  *Get Uuid value
		  *@return Uuid value
		  */
			public Long getUuid() {
				return this.uuid;
			}

		/**
		  *Get Id value
		  *@return Id value
		  */
			public Long getId() {
				return this.id;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the getBatchNamedGraphForUUIDNR prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<GetBatchNamedGraphForUUIDNRResult> transformGetBatchNamedGraphForUUIDNR = new org.openanzo.jdbc.utils.Transformer<GetBatchNamedGraphForUUIDNRResult>(){
		public GetBatchNamedGraphForUUIDNRResult transform(java.sql.ResultSet rs) {

			
				GetBatchNamedGraphForUUIDNRResult result = new GetBatchNamedGraphForUUIDNRResult();
				try {
				result.uuid=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:uuid",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.id=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:id",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the getBatchNamedGraphForUUIDNR prepared statement.
	  * <code>
	 *             SELECT UUID,ID FROM NAMEDGRAPHS_NR WHERE UUID IN (SELECT ID FROM {0}{1}) AND COMMITTED<=0;     
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
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<GetBatchNamedGraphForUUIDNRResult> getBatchNamedGraphForUUIDNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(getBatchNamedGraphForUUIDNR, new String[] {sessionPrefix, tableName},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<GetBatchNamedGraphForUUIDNRResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<GetBatchNamedGraphForUUIDNRResult>(rs, ps, stmtProvider, transformGetBatchNamedGraphForUUIDNR);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"getBatchNamedGraphForUUIDNR",stmtProvider.getSqlString(getBatchNamedGraphForUUIDNR) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[getBatchNamedGraphForUUIDNR]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of GetBatchNamedGraphForUUIDNRResult
	 */
	public static class GetBatchNamedGraphForUUIDNRResult {
			/**Value for the "uuid" result value*/
			private Long uuid;
			/**Value for the "id" result value*/
			private Long id;

		/**
		  *Get Uuid value
		  *@return Uuid value
		  */
			public Long getUuid() {
				return this.uuid;
			}

		/**
		  *Get Id value
		  *@return Id value
		  */
			public Long getId() {
				return this.id;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the getBatchUUIDForNamedGraph prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<GetBatchUUIDForNamedGraphResult> transformGetBatchUUIDForNamedGraph = new org.openanzo.jdbc.utils.Transformer<GetBatchUUIDForNamedGraphResult>(){
		public GetBatchUUIDForNamedGraphResult transform(java.sql.ResultSet rs) {

			
				GetBatchUUIDForNamedGraphResult result = new GetBatchUUIDForNamedGraphResult();
				try {
				result.uuid=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:uuid",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.id=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:id",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the getBatchUUIDForNamedGraph prepared statement.
	  * <code>
	 *             SELECT UUID,ID FROM NAMEDGRAPHS WHERE ID IN (SELECT ID FROM {0}{1}) AND ((HEND IS NULL AND COMMITTED=0) OR (HEND IS NOT NULL AND COMMITTED<0));     
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
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<GetBatchUUIDForNamedGraphResult> getBatchUUIDForNamedGraph (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(getBatchUUIDForNamedGraph, new String[] {sessionPrefix, tableName},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<GetBatchUUIDForNamedGraphResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<GetBatchUUIDForNamedGraphResult>(rs, ps, stmtProvider, transformGetBatchUUIDForNamedGraph);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"getBatchUUIDForNamedGraph",stmtProvider.getSqlString(getBatchUUIDForNamedGraph) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[getBatchUUIDForNamedGraph]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of GetBatchUUIDForNamedGraphResult
	 */
	public static class GetBatchUUIDForNamedGraphResult {
			/**Value for the "uuid" result value*/
			private Long uuid;
			/**Value for the "id" result value*/
			private Long id;

		/**
		  *Get Uuid value
		  *@return Uuid value
		  */
			public Long getUuid() {
				return this.uuid;
			}

		/**
		  *Get Id value
		  *@return Id value
		  */
			public Long getId() {
				return this.id;
			}

	}



	/**
	 * Transformer that transforms the rows in the result set for the getBatchUUIDForNamedGraphNR prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<GetBatchUUIDForNamedGraphNRResult> transformGetBatchUUIDForNamedGraphNR = new org.openanzo.jdbc.utils.Transformer<GetBatchUUIDForNamedGraphNRResult>(){
		public GetBatchUUIDForNamedGraphNRResult transform(java.sql.ResultSet rs) {

			
				GetBatchUUIDForNamedGraphNRResult result = new GetBatchUUIDForNamedGraphNRResult();
				try {
				result.uuid=rs.getLong(1);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:uuid",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				try {
				result.id=rs.getLong(2);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:id",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the getBatchUUIDForNamedGraphNR prepared statement.
	  * <code>
	 *             SELECT UUID,ID FROM NAMEDGRAPHS_NR WHERE ID IN (SELECT ID FROM {0}{1}) AND COMMITTED<=0;     
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
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<GetBatchUUIDForNamedGraphNRResult> getBatchUUIDForNamedGraphNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(getBatchUUIDForNamedGraphNR, new String[] {sessionPrefix, tableName},connection);
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

			org.openanzo.jdbc.utils.ClosableIterator<GetBatchUUIDForNamedGraphNRResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<GetBatchUUIDForNamedGraphNRResult>(rs, ps, stmtProvider, transformGetBatchUUIDForNamedGraphNR);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"getBatchUUIDForNamedGraphNR",stmtProvider.getSqlString(getBatchUUIDForNamedGraphNR) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[getBatchUUIDForNamedGraphNR]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of GetBatchUUIDForNamedGraphNRResult
	 */
	public static class GetBatchUUIDForNamedGraphNRResult {
			/**Value for the "uuid" result value*/
			private Long uuid;
			/**Value for the "id" result value*/
			private Long id;

		/**
		  *Get Uuid value
		  *@return Uuid value
		  */
			public Long getUuid() {
				return this.uuid;
			}

		/**
		  *Get Id value
		  *@return Id value
		  */
			public Long getId() {
				return this.id;
			}

	}



	
	/**
	 * Runs the insertNamedGraph prepared statement.
	  * <code>
	 *  		INSERT INTO NAMEDGRAPHS (HSTART, ID, METAID,UUID,REVISION,LASTMODIFIEDBY,COMMITTED) VALUES (?, ?, ?,?, ?,?,?); 	
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
	 *@param committed template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertNamedGraph (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long modified, long namedgraphid, long metadataId, long uuid, long revision, long lastModifiedBy, long committed) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertNamedGraph, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, modified);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, metadataId);
			ps.setLong(argc++, uuid);
			ps.setLong(argc++, revision);
			ps.setLong(argc++, lastModifiedBy);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertNamedGraph",stmtProvider.getSqlString(insertNamedGraph) ,""+ "modified="+(modified) + "," +"namedgraphid="+(namedgraphid) + "," +"metadataId="+(metadataId) + "," +"uuid="+(uuid) + "," +"revision="+(revision) + "," +"lastModifiedBy="+(lastModifiedBy) + "," +"committed="+(committed),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertNamedGraph]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertNamedGraph prepared statement
	 */
	public static class BatchInsertNamedGraph extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertNamedGraph prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertNamedGraph(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertNamedGraph,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the insertNamedGraph prepared statement.
		 *
	 *@param modified template parameter
	 *@param namedgraphid template parameter
	 *@param metadataId template parameter
	 *@param uuid template parameter
	 *@param revision template parameter
	 *@param lastModifiedBy template parameter
	 *@param committed template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long modified, long namedgraphid, long metadataId, long uuid, long revision, long lastModifiedBy, long committed) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, modified);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, metadataId);
			ps.setLong(argc++, uuid);
			ps.setLong(argc++, revision);
			ps.setLong(argc++, lastModifiedBy);
			ps.setLong(argc++, committed);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the deleteNamedGraph prepared statement.
	  * <code>
	 *  		UPDATE NAMEDGRAPHS SET HEND=?,COMMITTED=? WHERE ID = ? AND HEND IS NULL; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param hend template parameter
	 *@param committed template parameter
	 *@param id template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int deleteNamedGraph (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long hend, long committed, long id) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(deleteNamedGraph, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, hend);
			ps.setLong(argc++, committed);
			ps.setLong(argc++, id);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"deleteNamedGraph",stmtProvider.getSqlString(deleteNamedGraph) ,""+ "hend="+(hend) + "," +"committed="+(committed) + "," +"id="+(id),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[deleteNamedGraph]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the DeleteNamedGraph prepared statement
	 */
	public static class BatchDeleteNamedGraph extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the DeleteNamedGraph prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchDeleteNamedGraph(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,deleteNamedGraph,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the deleteNamedGraph prepared statement.
		 *
	 *@param hend template parameter
	 *@param committed template parameter
	 *@param id template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long hend, long committed, long id) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, hend);
			ps.setLong(argc++, committed);
			ps.setLong(argc++, id);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the deleteNamedGraphBatch prepared statement.
	  * <code>
	 *          UPDATE NAMEDGRAPHS SET HEND=?,COMMITTED=? WHERE ID IN (SELECT {0}{1}.ID FROM {0}{1} WHERE {0}{1}.TYPE=0) AND HEND IS NULL;     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param hend template parameter
	 *@param committed template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int deleteNamedGraphBatch (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long hend, long committed, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(deleteNamedGraphBatch, new String[] {sessionPrefix, tableName},connection); int argc = 1;
			ps.setLong(argc++, hend);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"deleteNamedGraphBatch",stmtProvider.getSqlString(deleteNamedGraphBatch) ,""+ "hend="+(hend) + "," +"committed="+(committed),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[deleteNamedGraphBatch]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the DeleteNamedGraphBatch prepared statement
	 */
	public static class BatchDeleteNamedGraphBatch extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the DeleteNamedGraphBatch prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchDeleteNamedGraphBatch(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,deleteNamedGraphBatch,new String[] {sessionPrefix, tableName});
		}
		
		/**
		 * Sets the input parameters for the deleteNamedGraphBatch prepared statement.
		 *
	 *@param hend template parameter
	 *@param committed template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long hend, long committed) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, hend);
			ps.setLong(argc++, committed);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the purgeNamedGraph prepared statement.
	  * <code>
	 *  		DELTE FROM NAMEDGRAPHS WHERE WHERE ID = ? 	
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
	public static int purgeNamedGraph (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purgeNamedGraph, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, id);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purgeNamedGraph",stmtProvider.getSqlString(purgeNamedGraph) ,""+ "id="+(id),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[purgeNamedGraph]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PurgeNamedGraph prepared statement
	 */
	public static class BatchPurgeNamedGraph extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PurgeNamedGraph prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurgeNamedGraph(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purgeNamedGraph,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the purgeNamedGraph prepared statement.
		 *
	 *@param id template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long id) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, id);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the insertNamedGraphNR prepared statement.
	  * <code>
	 *  		INSERT INTO NAMEDGRAPHS_NR (HSTART, ID, METAID,UUID, REVISION,LASTMODIFIEDBY,COMMITTED) VALUES (?, ?,?,?,?,?,?); 	
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
	 *@param committed template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertNamedGraphNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long modified, long namedgraphid, long metadataId, long uuid, long revision, long lastModifiedBy, long committed) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertNamedGraphNR, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, modified);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, metadataId);
			ps.setLong(argc++, uuid);
			ps.setLong(argc++, revision);
			ps.setLong(argc++, lastModifiedBy);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertNamedGraphNR",stmtProvider.getSqlString(insertNamedGraphNR) ,""+ "modified="+(modified) + "," +"namedgraphid="+(namedgraphid) + "," +"metadataId="+(metadataId) + "," +"uuid="+(uuid) + "," +"revision="+(revision) + "," +"lastModifiedBy="+(lastModifiedBy) + "," +"committed="+(committed),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertNamedGraphNR]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertNamedGraphNR prepared statement
	 */
	public static class BatchInsertNamedGraphNR extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertNamedGraphNR prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertNamedGraphNR(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertNamedGraphNR,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the insertNamedGraphNR prepared statement.
		 *
	 *@param modified template parameter
	 *@param namedgraphid template parameter
	 *@param metadataId template parameter
	 *@param uuid template parameter
	 *@param revision template parameter
	 *@param lastModifiedBy template parameter
	 *@param committed template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long modified, long namedgraphid, long metadataId, long uuid, long revision, long lastModifiedBy, long committed) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, modified);
			ps.setLong(argc++, namedgraphid);
			ps.setLong(argc++, metadataId);
			ps.setLong(argc++, uuid);
			ps.setLong(argc++, revision);
			ps.setLong(argc++, lastModifiedBy);
			ps.setLong(argc++, committed);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the deleteNamedGraphNR prepared statement.
	  * <code>
	 *  		UPDATE NAMEDGRAPHS_NR SET COMMITTED=? WHERE ID = ?; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param committed template parameter
	 *@param namedgraphid template parameter
	 *
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int deleteNamedGraphNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long committed, long namedgraphid) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(deleteNamedGraphNR, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, committed);
			ps.setLong(argc++, namedgraphid);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"deleteNamedGraphNR",stmtProvider.getSqlString(deleteNamedGraphNR) ,""+ "committed="+(committed) + "," +"namedgraphid="+(namedgraphid),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[deleteNamedGraphNR]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the DeleteNamedGraphNR prepared statement
	 */
	public static class BatchDeleteNamedGraphNR extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the DeleteNamedGraphNR prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchDeleteNamedGraphNR(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,deleteNamedGraphNR,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the deleteNamedGraphNR prepared statement.
		 *
	 *@param committed template parameter
	 *@param namedgraphid template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long committed, long namedgraphid) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, committed);
			ps.setLong(argc++, namedgraphid);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the deleteNamedGraphNRBatch prepared statement.
	  * <code>
	 *          UPDATE NAMEDGRAPHS_NR SET COMMITTED=? WHERE ID IN (SELECT {0}{1}.ID FROM {0}{1} WHERE {0}{1}.TYPE=1);     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param committed template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int deleteNamedGraphNRBatch (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long committed, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(deleteNamedGraphNRBatch, new String[] {sessionPrefix, tableName},connection); int argc = 1;
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"deleteNamedGraphNRBatch",stmtProvider.getSqlString(deleteNamedGraphNRBatch) ,""+ "committed="+(committed),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[deleteNamedGraphNRBatch]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the DeleteNamedGraphNRBatch prepared statement
	 */
	public static class BatchDeleteNamedGraphNRBatch extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the DeleteNamedGraphNRBatch prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchDeleteNamedGraphNRBatch(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,deleteNamedGraphNRBatch,new String[] {sessionPrefix, tableName});
		}
		
		/**
		 * Sets the input parameters for the deleteNamedGraphNRBatch prepared statement.
		 *
	 *@param committed template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long committed) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, committed);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the deleteStatementsForNamedGraphNR prepared statement.
	  * <code>
	 *  		DELETE FROM STATEMENTS_NR WHERE NAMEDGRAPHID = ? OR NAMEDGRAPHID = ?; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param ngID template parameter
	 *@param metaID template parameter
	 *
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void deleteStatementsForNamedGraphNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long ngID, long metaID) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(deleteStatementsForNamedGraphNR, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, ngID);
			ps.setLong(argc++, metaID);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"deleteStatementsForNamedGraphNR",stmtProvider.getSqlString(deleteStatementsForNamedGraphNR) ,""+ "ngID="+(ngID) + "," +"metaID="+(metaID),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[deleteStatementsForNamedGraphNR]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the DeleteStatementsForNamedGraphNR prepared statement
	 */
	public static class BatchDeleteStatementsForNamedGraphNR extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the DeleteStatementsForNamedGraphNR prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchDeleteStatementsForNamedGraphNR(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,deleteStatementsForNamedGraphNR,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the deleteStatementsForNamedGraphNR prepared statement.
		 *
	 *@param ngID template parameter
	 *@param metaID template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long ngID, long metaID) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, ngID);
			ps.setLong(argc++, metaID);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the deleteStatementsForNamedGraphNRBatch prepared statement.
	  * <code>
	 *          DELETE FROM STATEMENTS_NR WHERE NAMEDGRAPHID IN (SELECT {0}{1}.ID FROM {0}{1} WHERE {0}{1}.TYPE=1);     
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
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int deleteStatementsForNamedGraphNRBatch (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(deleteStatementsForNamedGraphNRBatch, new String[] {sessionPrefix, tableName},connection);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"deleteStatementsForNamedGraphNRBatch",stmtProvider.getSqlString(deleteStatementsForNamedGraphNRBatch) ,"",""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[deleteStatementsForNamedGraphNRBatch]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the DeleteStatementsForNamedGraphNRBatch prepared statement
	 */
	public static class BatchDeleteStatementsForNamedGraphNRBatch extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the DeleteStatementsForNamedGraphNRBatch prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchDeleteStatementsForNamedGraphNRBatch(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,deleteStatementsForNamedGraphNRBatch,new String[] {sessionPrefix, tableName});
		}
		
		/**
		 * Sets the input parameters for the deleteStatementsForNamedGraphNRBatch prepared statement.
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
	 * Runs the updateNamedGraphNR prepared statement.
	  * <code>
	 *  		UPDATE NAMEDGRAPHS_NR SET COMMITTED=? WHERE ID = ?; 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *@param id template parameter
	 *
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void updateNamedGraphNR (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId, long id) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(updateNamedGraphNR, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, id);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"updateNamedGraphNR",stmtProvider.getSqlString(updateNamedGraphNR) ,""+ "transactionId="+(transactionId) + "," +"id="+(id),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[updateNamedGraphNR]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the UpdateNamedGraphNR prepared statement
	 */
	public static class BatchUpdateNamedGraphNR extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the UpdateNamedGraphNR prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchUpdateNamedGraphNR(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,updateNamedGraphNR,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the updateNamedGraphNR prepared statement.
		 *
	 *@param transactionId template parameter
	 *@param id template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long transactionId, long id) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, transactionId);
			ps.setLong(argc++, id);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	/**
	 * Transformer that transforms the rows in the result set for the selectNamedGraphRevision prepared statement.
	 */
	static final org.openanzo.jdbc.utils.Transformer<SelectNamedGraphRevisionResult> transformSelectNamedGraphRevision = new org.openanzo.jdbc.utils.Transformer<SelectNamedGraphRevisionResult>(){
		public SelectNamedGraphRevisionResult transform(java.sql.ResultSet rs) {

			
				SelectNamedGraphRevisionResult result = new SelectNamedGraphRevisionResult();
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
				result.namedgraphid=rs.getLong(4);
				} catch (java.sql.SQLException e) {
				log.error(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error transforming result set param:namedgraphid",e);
				throw new org.apache.commons.collections.FunctorException(e);
				}
				return result;
			
		}

	};
	
	/**
	 * Runs the selectNamedGraphRevision prepared statement.
	  * <code>
	 *   		SELECT SUBJECT,PREDICATE,OBJECT,NAMEDGRAPHID 		FROM STATEMENTS S 		WHERE S.UUID=? AND COMMITTED=0 AND S.RSTART<=? AND (S.REND IS NULL OR S.REND>?); 		
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param uuid template parameter
	 *@param revision template parameter
	 *@param revision2 template parameter
	 *
	 *@return  org.openanzo.jdbc.utils.ClosableIterator
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static org.openanzo.jdbc.utils.ClosableIterator<SelectNamedGraphRevisionResult> selectNamedGraphRevision (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long uuid, long revision, long revision2) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectNamedGraphRevision, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, uuid);
			ps.setLong(argc++, revision);
			ps.setLong(argc++, revision2);
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

			org.openanzo.jdbc.utils.ClosableIterator<SelectNamedGraphRevisionResult> iter = new org.openanzo.jdbc.utils.ResultSetIterator<SelectNamedGraphRevisionResult>(rs, ps, stmtProvider, transformSelectNamedGraphRevision);
			return iter;

		} catch (java.sql.SQLException e) {
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectNamedGraphRevision",stmtProvider.getSqlString(selectNamedGraphRevision) ,""+ "uuid="+(uuid) + "," +"revision="+(revision) + "," +"revision2="+(revision2),"");
		} finally {
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectNamedGraphRevision]"+endtimer);
		}
	}


	
	/**
	 *Default implementation of SelectNamedGraphRevisionResult
	 */
	public static class SelectNamedGraphRevisionResult {
			/**Value for the "subject" result value*/
			private long subject;
			/**Value for the "predicate" result value*/
			private long predicate;
			/**Value for the "object" result value*/
			private long object;
			/**Value for the "namedgraphid" result value*/
			private long namedgraphid;

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
		  *Get Namedgraphid value
		  *@return Namedgraphid value
		  */
			public long getNamedgraphid() {
				return this.namedgraphid;
			}

	}



	
	/**
	 * Runs the selectNamedGraphSize prepared statement.
	  * <code>
	 *   			SELECT DISTINCT COUNT(1)  			FROM STATEMENTS SH 			WHERE SH.NAMEDGRAPHID = ?  AND 			((SH.HEND IS NULL AND SH.COMMITTED=0) OR (SH.HEND IS NOT NULL AND SH.COMMITTED<0)) 		
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *
	 *@return  long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static long selectNamedGraphSize (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectNamedGraphSize, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, id);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectNamedGraphSize",stmtProvider.getSqlString(selectNamedGraphSize) ,""+ "id="+(id),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectNamedGraphSize]"+endtimer);
		}
	}




	
	/**
	 * Runs the selectNamedGraphSizeNonRevisioned prepared statement.
	  * <code>
	 *   			SELECT DISTINCT COUNT(1)  			FROM STATEMENTS_NR SH 			WHERE SH.NAMEDGRAPHID = ? AND 			SH.COMMITTED<=0 		
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *
	 *@return  long
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static long selectNamedGraphSizeNonRevisioned (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(selectNamedGraphSizeNonRevisioned, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, id);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"selectNamedGraphSizeNonRevisioned",stmtProvider.getSqlString(selectNamedGraphSizeNonRevisioned) ,""+ "id="+(id),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[selectNamedGraphSizeNonRevisioned]"+endtimer);
		}
	}




	
	/**
	 * Runs the insertIdsIntoTempTable prepared statement.
	  * <code>
	 *  	    INSERT INTO {0}{1} VALUES (?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tableName template parameter
	 *@return  int
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static int insertIdsIntoTempTable (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertIdsIntoTempTable, new String[] {sessionPrefix, tableName},connection); int argc = 1;
			ps.setLong(argc++, id);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertIdsIntoTempTable",stmtProvider.getSqlString(insertIdsIntoTempTable) ,""+ "id="+(id),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertIdsIntoTempTable]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertIdsIntoTempTable prepared statement
	 */
	public static class BatchInsertIdsIntoTempTable extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertIdsIntoTempTable prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertIdsIntoTempTable(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertIdsIntoTempTable,new String[] {sessionPrefix, tableName});
		}
		
		/**
		 * Sets the input parameters for the insertIdsIntoTempTable prepared statement.
		 *
	 *@param id template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long id) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, id);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the lockNamedGraph prepared statement.
	  * <code>
	 *  	    INSERT INTO LOCKED_GRAPHS(ID,TRANSACTIONID) VALUES (?,?) 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *@param transactionId template parameter
	 *
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void lockNamedGraph (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, long transactionId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(lockNamedGraph, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, id);
			ps.setLong(argc++, transactionId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"lockNamedGraph",stmtProvider.getSqlString(lockNamedGraph) ,""+ "id="+(id) + "," +"transactionId="+(transactionId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[lockNamedGraph]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the LockNamedGraph prepared statement
	 */
	public static class BatchLockNamedGraph extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the LockNamedGraph prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchLockNamedGraph(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,lockNamedGraph,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the lockNamedGraph prepared statement.
		 *
	 *@param id template parameter
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long id, long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, id);
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the unlockNamedGraph prepared statement.
	  * <code>
	 *  	    DELETE FROM LOCKED_GRAPHS WHERE ID=? AND TRANSACTIONID=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *@param transactionId template parameter
	 *
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void unlockNamedGraph (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, long transactionId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(unlockNamedGraph, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, id);
			ps.setLong(argc++, transactionId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"unlockNamedGraph",stmtProvider.getSqlString(unlockNamedGraph) ,""+ "id="+(id) + "," +"transactionId="+(transactionId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[unlockNamedGraph]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the UnlockNamedGraph prepared statement
	 */
	public static class BatchUnlockNamedGraph extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the UnlockNamedGraph prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchUnlockNamedGraph(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,unlockNamedGraph,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the unlockNamedGraph prepared statement.
		 *
	 *@param id template parameter
	 *@param transactionId template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long id, long transactionId) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, id);
			ps.setLong(argc++, transactionId);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}




	
	/**
	 * Runs the purgelockedNamedGraph prepared statement.
	  * <code>
	 *  	    DELETE FROM LOCKED_GRAPHS WHERE TRANSACTIONID=? 	
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param transactionId template parameter
	 *
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void purgelockedNamedGraph (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long transactionId) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(purgelockedNamedGraph, new String[] {},connection); int argc = 1;
			ps.setLong(argc++, transactionId);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"purgelockedNamedGraph",stmtProvider.getSqlString(purgelockedNamedGraph) ,""+ "transactionId="+(transactionId),"");
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[purgelockedNamedGraph]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the PurgelockedNamedGraph prepared statement
	 */
	public static class BatchPurgelockedNamedGraph extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the PurgelockedNamedGraph prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchPurgelockedNamedGraph(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,purgelockedNamedGraph,new String[] {});
		}
		
		/**
		 * Sets the input parameters for the purgelockedNamedGraph prepared statement.
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
	 * Runs the insertRemovedGraph prepared statement.
	  * <code>
	 *          INSERT INTO {0}{1}(ID,TYPE,REND) VALUES (?,?,?)     
	 * </code>
	 *
	 *@param stmtProvider
	 *			factory and cache of PreparedStatments
	 *@param connection
	 * 			connection to underlying database
	 *
	 *@param id template parameter
	 *@param type template parameter
	 *@param rend template parameter
	 *
	 *@param sessionPrefix template parameter
	 *@param tableName template parameter
	 *
	 *@throws  org.openanzo.jdbc.utils.RdbException
	 */
	public static void insertRemovedGraph (final org.openanzo.jdbc.utils.PreparedStatementProvider stmtProvider,final java.sql.Connection connection, long id, int type, long rend, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException{
		java.sql.PreparedStatement ps = null;
		//long startTimer=System.currentTimeMillis();
		try {		
			ps = stmtProvider.getPreparedSQLStatement(insertRemovedGraph, new String[] {sessionPrefix, tableName},connection); int argc = 1;
			ps.setLong(argc++, id);
			ps.setInt(argc++, type);
			ps.setLong(argc++, rend);
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
			throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_EXECUTING_SQL,e,"insertRemovedGraph",stmtProvider.getSqlString(insertRemovedGraph) ,""+ "id="+(id) + "," +"type="+(type) + "," +"rend="+(rend),""+ "sessionPrefix="+((sessionPrefix!=null)?sessionPrefix.toString():"null") + "," +"tableName="+((tableName!=null)?tableName.toString():"null"));
		} finally {
			if (ps != null) {
				try { 
					ps.close(); 
				} catch (java.sql.SQLException sqle) {
					if(log.isDebugEnabled())log.debug(org.openanzo.exceptions.LogUtils.RDB_MARKER,"Error closing prepared statement",sqle);
				}
			}
			//long endtimer=(System.currentTimeMillis()-startTimer);
			//if(endtimer>CUTOFF)System.out.println("[insertRemovedGraph]"+endtimer);
		}
	}
	/**
	 *Batch operation for adding parameters to the InsertRemovedGraph prepared statement
	 */
	public static class BatchInsertRemovedGraph extends org.openanzo.jdbc.utils.PreparedStatementExecutor {
		/**
		 * Batch operation for adding parameters to the InsertRemovedGraph prepared statement
		 * @param connection Connection to execute 
		 * @param provider Prepared statement provider
		 * 
	 *@param sessionPrefix template parameter
	 *@param tableName template parameter
		 * @throws org.openanzo.jdbc.utils.RdbException
		 */
		public BatchInsertRemovedGraph(java.sql.Connection connection, org.openanzo.jdbc.utils.PreparedStatementProvider provider, String sessionPrefix, String tableName) throws org.openanzo.jdbc.utils.RdbException {
			super(connection,provider,insertRemovedGraph,new String[] {sessionPrefix, tableName});
		}
		
		/**
		 * Sets the input parameters for the insertRemovedGraph prepared statement.
		 *
	 *@param id template parameter
	 *@param type template parameter
	 *@param rend template parameter
		 *@throws org.openanzo.jdbc.utils.RdbException
		 */
		public void addEntry (long id, int type, long rend) throws org.openanzo.jdbc.utils.RdbException {
	 		try{
		 		ps.clearParameters(); int argc = 1;
			ps.setLong(argc++, id);
			ps.setInt(argc++, type);
			ps.setLong(argc++, rend);
				ps.addBatch();
			}catch(java.sql.SQLException sqle){
				throw new org.openanzo.jdbc.utils.RdbException(org.openanzo.exceptions.ExceptionConstants.RDB.FAILED_PREPARING_STATEMENT, sqle);
			}
		}
	}


}