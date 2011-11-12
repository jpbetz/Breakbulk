
/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Generated Source from org.openanzo.rdf.utils.properties.jet
 * Created on:  11/10/2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.exceptions;
/**
 *  Exception constants
 *	@author Generated Source from org.openanzo.rdf.utils.exceptions.jet
 */
 
 public class ExceptionConstants{
  	/** String constant for ErrorMessageArguements tag */
    public static final String errorMessageArg = "ErrorMessageArg";

    /** String constant for '.' char */
    public static final String DOT             = ".";

    /** String constant for '_' char */
    public static final String USCORE          = "_";

    /** The QName constants for the ErrorMessageArguements tag */
    static javax.xml.namespace.QName               errorArg        = new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", errorMessageArg);
 
 	/** The Major Error Codes. These codes help specify the general area where the exception took place, or general cause of the exception.*/
    public interface MAJOR_CODES {
  	
 	  	/**IO */
    	 public static final long IO_ERROR = 1;
 	
 	  	/**Core */
    	 public static final long CORE_ERROR = 2;
 	
 	  	/**Transport */
    	 public static final long TRANSPORT_ERROR = 4;
 	
 	  	/**Combus */
    	 public static final long COMBUS_ERROR = 8;
 	
 	  	/**ServiceContainer */
    	 public static final long OSGI = 16;
 	
 	  	/**Backend */
    	 public static final long BACKEND_ERROR = 32;
 	
 	  	/**Security */
    	 public static final long SECURITY_ERROR = 64;
 	
 	  	/**RDB */
    	 public static final long RDB_ERROR = 128;
 	
 	  	/**Internal */
    	 public static final long INTERNAL_ERROR = 256;
 	
 	  	/**Client */
    	 public static final long CLIENT_ERROR = 512;
 	
 	  	/**Configuration */
    	 public static final long CONFIG_ERROR = 1024;
 	
 	  	/**Glitter */
    	 public static final long GLITTER_ERROR = 2048;
 	
 	  	/**Jastor */
    	 public static final long JASTOR_ERROR = 4096;
 	
 	}
 	
 	
 	  	/** */
    	public interface MODEL {
    		/**Mask for MODEL */
    		public static final long MASK=1<<8;
    		
    			/** Error loading object */
    			 public static final long LOAD_OBJECT = 1 | MASK; //257
    		
    			/** Error creating object */
    			 public static final long CREATE_OBJECT = 2 | MASK; //258
    		
    			/** Duplicate object */
    			 public static final long CREATE_OBJECT_EXISTS = 3 | MASK; //259
    		
    			/** Failed Batch */
    			 public static final long FAILED_BATCH = 4 | MASK; //260
    		
    			/** Error executing batch */
    			 public static final long FAILED_EXECUTE_BATCH = 5 | MASK; //261
    		
    			/** Invalid Argument */
    			 public static final long INVALID_ARGUMENT = 6 | MASK; //262
    		
    			/** No permission to add statements */
    			 public static final long NO_ADD_ERROR = 7 | MASK; //263
    		
    			/** No permission to remove statements */
    			 public static final long NO_REMOVE_ERROR = 8 | MASK; //264
    		
    			/** No permission to read statements */
    			 public static final long NO_READ_ERROR = 9 | MASK; //265
    		
    			/** No permission to change acls */
    			 public static final long NO_CHANGE_ACL_ERROR = 10 | MASK; //266
    		
    			/** No permission to add namedgraph */
    			 public static final long NO_INSERT_NAMEDGRAPH_ACL_ERROR = 11 | MASK; //267
    		
    			/** No permission to remove namedgraph */
    			 public static final long NO_REMOVE_NAMEDGRAPH_ACL_ERROR = 12 | MASK; //268
    		
    			/** Command precondition */
    			 public static final long COMMAND_PREREQ_FAILED = 13 | MASK; //269
    		
    			/** No permission to add statements to system graph */
    			 public static final long NO_ADD_SYSTEM_PERMISSION = 14 | MASK; //270
    		
    			/** No permission to remove statements from system graph */
    			 public static final long NO_REMOVE_SYSTEM_PERMISSION = 15 | MASK; //271
    		
    			/** Trying to add reserved predicate */
    			 public static final long NO_ADD_RESERVED_URI = 16 | MASK; //272
    		
    		
		 	  	/** */
		    	public interface USER {
		    	/**Mask for USER */
		    		public static final long MASK=1<<9;
		    		
		    			/** User object has no password specified */
		    			 public static final long NULL_PASSWORD = 1 | MASK; //513
		    		
		    			/** Use object has no default role specified */
		    			 public static final long NULL_DEFAULT_ROLE = 2 | MASK; //514
		    		
		    			/** ID already used */
		    			 public static final long ID_IN_USE = 3 | MASK; //515
		    		
		    			/** Failed to insert user object */
		    			 public static final long FAILED_INSERT = 4 | MASK; //516
		    		
		    			/** Failed to remove user object */
		    			 public static final long FAILED_REMOVE = 5 | MASK; //517
		    		
		    			/** Failed to update user object */
		    			 public static final long FAILED_UPDATE = 6 | MASK; //518
		    		
		    			/** Failed to select roles for user */
		    			 public static final long SELECT_ROLES = 7 | MASK; //519
		    		
		    			/** Failed to select explicit roles for user */
		    			 public static final long SELECTEXPLICIT_ROLES = 9 | MASK; //521
		    		
		    			/** User has no defaule role template */
		    			 public static final long NO_DEFAULT_ROLE = 10 | MASK; //522
		    		
		    			/** Failed to load User object */
		    			 public static final long LOAD_OBJECT = 11 | MASK; //523
		    		
		    			/** User specified not found */
		    			 public static final long NOT_FOUND = 12 | MASK; //524
		    		
		    			/** Failed to load a user with the given id */
		    			 public static final long GET_USER_BY_ID = 13 | MASK; //525
		    		
		    		
		    	}
		 	
		 	  	/** */
		    	public interface ROLE {
		    	/**Mask for ROLE */
		    		public static final long MASK=1<<10;
		    		
		    			/**  */
		    			 public static final long NOT_FOUND = 1 | MASK; //1025
		    		
		    			/**  */
		    			 public static final long GET_PARENT_ROLES = 2 | MASK; //1026
		    		
		    			/**  */
		    			 public static final long FAILED_INSERT = 3 | MASK; //1027
		    		
		    			/**  */
		    			 public static final long FAILED_REMOVE = 4 | MASK; //1028
		    		
		    			/**  */
		    			 public static final long FAILED_UPDATE = 5 | MASK; //1029
		    		
		    			/**  */
		    			 public static final long ID_IN_USE = 6 | MASK; //1030
		    		
		    			/**  */
		    			 public static final long FAILED_ADD_USER = 7 | MASK; //1031
		    		
		    			/**  */
		    			 public static final long FAILED_REMOVE_USER = 8 | MASK; //1032
		    		
		    			/**  */
		    			 public static final long FAILED_ADD_IMPLICIT_USER = 9 | MASK; //1033
		    		
		    			/**  */
		    			 public static final long SELECT_USER_IDS = 10 | MASK; //1034
		    		
		    			/**  */
		    			 public static final long LIST_USERS_FOR_ROLE = 11 | MASK; //1035
		    		
		    			/**  */
		    			 public static final long FAILED_ADD_SUBROLE = 12 | MASK; //1036
		    		
		    			/**  */
		    			 public static final long FAILED_REMOVE_SUBROLE = 13 | MASK; //1037
		    		
		    		
		    	}
		 	
		 	  	/** */
		    	public interface ACL {
		    	/**Mask for ACL */
		    		public static final long MASK=1<<11;
		    		
		    			/**  */
		    			 public static final long NOT_FOUND = 1 | MASK; //2049
		    		
		    			/**  */
		    			 public static final long FAILED_INSERT = 2 | MASK; //2050
		    		
		    			/**  */
		    			 public static final long FAILED_REMOVE = 3 | MASK; //2051
		    		
		    			/**  */
		    			 public static final long FAILED_UPDATE_PRIVILEGES = 4 | MASK; //2052
		    		
		    			/**  */
		    			 public static final long ILLEGAL_OPERATION = 5 | MASK; //2053
		    		
		    			/**  */
		    			 public static final long CREATE_ACL_TEMPLATE = 6 | MASK; //2054
		    		
		    			/**  */
		    			 public static final long CREATE_DEFAULT_ACL = 7 | MASK; //2055
		    		
		    			/**  */
		    			 public static final long GET_PRIVILEGE_SET = 8 | MASK; //2056
		    		
		    			/**  */
		    			 public static final long FAILED_UPDATE_ACI = 9 | MASK; //2057
		    		
		    			/**  */
		    			 public static final long FAILED_LIST_ACIS = 10 | MASK; //2058
		    		
		    		
		    	}
		 	
		 	  	/** */
		    	public interface NAMEDGRAPH {
		    	/**Mask for NAMEDGRAPH */
		    		public static final long MASK=1<<12;
		    		
		    			/**  */
		    			 public static final long LIST_GRAPHS = 1 | MASK; //4097
		    		
		    			/**  */
		    			 public static final long NOT_FOUND = 2 | MASK; //4098
		    		
		    			/**  */
		    			 public static final long META_NOT_FOUND = 3 | MASK; //4099
		    		
		    			/**  */
		    			 public static final long FAILED_LOAD = 4 | MASK; //4100
		    		
		    			/**  */
		    			 public static final long FAILED_INSERT = 5 | MASK; //4101
		    		
		    			/**  */
		    			 public static final long FAILED_REMOVE = 6 | MASK; //4102
		    		
		    			/**  */
		    			 public static final long FAILED_UPDATE = 7 | MASK; //4103
		    		
		    			/**  */
		    			 public static final long MODIFIED_NULL = 8 | MASK; //4104
		    		
		    			/**  */
		    			 public static final long FAILED_PERMISSION = 9 | MASK; //4105
		    		
		    			/**  */
		    			 public static final long LIST_ROLES = 10 | MASK; //4106
		    		
		    			/**  */
		    			 public static final long LIST_USERS = 11 | MASK; //4107
		    		
		    		
		    	}
		 	
		 	  	/** */
		    	public interface STATEMENT {
		    	/**Mask for STATEMENT */
		    		public static final long MASK=1<<13;
		    		
		    			/**  */
		    			 public static final long NOT_FOUND = 1 | MASK; //8193
		    		
		    			/**  */
		    			 public static final long FAILED_LOAD = 2 | MASK; //8194
		    		
		    			/**  */
		    			 public static final long FAILED_INSERT = 3 | MASK; //8195
		    		
		    			/**  */
		    			 public static final long FAILED_REMOVE = 4 | MASK; //8196
		    		
		    			/**  */
		    			 public static final long MODIFIED_NULL = 5 | MASK; //8197
		    		
		    			/**  */
		    			 public static final long GET_ACL = 6 | MASK; //8198
		    		
		    			/**  */
		    			 public static final long GET_NAMEDGRAPH = 7 | MASK; //8199
		    		
		    			/**  */
		    			 public static final long GET_ALL = 8 | MASK; //8200
		    		
		    		
		    	}
		 	
    	}
 	
 	  	/***/
    	public interface COMBUS {
    		/**Mask for COMBUS */
    		public static final long MASK=1<<14;
    		
    			/**  */
    			 public static final long COULD_NOT_PUBLISH = 1 | MASK; //16385
    		
    			/**  */
    			 public static final long PROCESS_UPDATE_FAILED = 2 | MASK; //16386
    		
    			/**  */
    			 public static final long TRACKER_STORAGE_ERROR = 3 | MASK; //16387
    		
    			/**  */
    			 public static final long JMS_REGISTER_SELECTOR_ERROR = 4 | MASK; //16388
    		
    			/**  */
    			 public static final long JMS_UNREGISTER_SELECTOR_ERROR = 5 | MASK; //16389
    		
    			/**  */
    			 public static final long JMS_CONNECT_TIMEOUT = 6 | MASK; //16390
    		
    			/**  */
    			 public static final long JMS_CONNECT_FAILED = 7 | MASK; //16391
    		
    			/**  */
    			 public static final long NOTIFICATION_SERVICE_ERROR = 8 | MASK; //16392
    		
    			/**  */
    			 public static final long NO_SERVER_RESPONSE = 9 | MASK; //16393
    		
    			/**  */
    			 public static final long SERVER_CONNECT_EXCEPTION = 10 | MASK; //16394
    		
    			/**  */
    			 public static final long JMS_MESSAGE_PARSING = 11 | MASK; //16395
    		
    			/**  */
    			 public static final long JMS_MISSING_MESSAGE_PARAMETER = 12 | MASK; //16396
    		
    			/**  */
    			 public static final long JMS_DISCONNECT_FAILED = 13 | MASK; //16397
    		
    			/**  */
    			 public static final long JMS_PROVIDER_CLASS_FAILED = 14 | MASK; //16398
    		
    			/**  */
    			 public static final long JMS_CREATE_PRODUCER_FAILED = 15 | MASK; //16399
    		
    			/**  */
    			 public static final long JMS_UNREGISTER_PRODUCER_FAILED = 16 | MASK; //16400
    		
    			/**  */
    			 public static final long JMS_ALREADY_CONNECTED = 17 | MASK; //16401
    		
    			/**  */
    			 public static final long JMS_NOT_CONNECTED = 18 | MASK; //16402
    		
    			/**  */
    			 public static final long NO_SUCH_DESTINATION = 19 | MASK; //16403
    		
    			/**  */
    			 public static final long INTERRUPTED = 20 | MASK; //16404
    		
    			/**  */
    			 public static final long JMS_FAILED_SETTING_MESSAGE_PARAMETER = 21 | MASK; //16405
    		
    			/**  */
    			 public static final long JMS_AUTHENTICATION = 22 | MASK; //16406
    		
    			/**  */
    			 public static final long JMS_SERVICE_EXCEPTION = 23 | MASK; //16407
    		
    		
    	}
 	
 	  	/***/
    	public interface SERVER {
    		/**Mask for SERVER */
    		public static final long MASK=1<<15;
    		
    			/**  */
    			 public static final long RESET_NOT_ENABLED = 1 | MASK; //32769
    		
    			/**  */
    			 public static final long POOL_NOT_INITIALIZED = 2 | MASK; //32770
    		
    			/**  */
    			 public static final long USER_ERROR = 3 | MASK; //32771
    		
    			/**  */
    			 public static final long UNKNOWN_USER_ERROR = 4 | MASK; //32772
    		
    			/**  */
    			 public static final long HASH_AVAILABLE_ERROR = 5 | MASK; //32773
    		
    			/**  */
    			 public static final long HASH_ERROR = 6 | MASK; //32774
    		
    			/**  */
    			 public static final long FIND_QUINT_ERROR = 7 | MASK; //32775
    		
    			/**  */
    			 public static final long UNSUPPORTED_QUERY = 8 | MASK; //32776
    		
    			/**  */
    			 public static final long GET_SIZE = 9 | MASK; //32777
    		
    			/**  */
    			 public static final long INIT_FILE = 10 | MASK; //32778
    		
    			/**  */
    			 public static final long REVISION_NOT_FOUND = 11 | MASK; //32779
    		
    			/**  */
    			 public static final long FIND_MATCHES = 12 | MASK; //32780
    		
    			/**  */
    			 public static final long NO_SERVER_CONFIG = 13 | MASK; //32781
    		
    			/**  */
    			 public static final long REPLICATION_FAILED = 14 | MASK; //32782
    		
    			/**  */
    			 public static final long MISSING_ARG = 15 | MASK; //32783
    		
    			/**  */
    			 public static final long BAD_USER_PASSWORD = 16 | MASK; //32784
    		
    			/**  */
    			 public static final long UPDATE_SERVER_ERROR = 17 | MASK; //32785
    		
    			/**  */
    			 public static final long GET_METAURI = 18 | MASK; //32786
    		
    			/**  */
    			 public static final long NOT_IN_SYSADMIN_ROLE = 19 | MASK; //32787
    		
    			/**  */
    			 public static final long GET_USERS_FOR_GRAPH_ERROR = 20 | MASK; //32788
    		
    			/**  */
    			 public static final long GET_STORED_GRAPHS_ERROR = 21 | MASK; //32789
    		
    			/**  */
    			 public static final long EMPTY_DATASET_ERROR = 22 | MASK; //32790
    		
    			/**  */
    			 public static final long UNKNOWN_OPERATION_ERROR = 23 | MASK; //32791
    		
    			/**  */
    			 public static final long FAILED_INDEX_CLEAR = 64 | MASK; //32832
    		
    			/**  */
    			 public static final long FAILED_INDEX_REBUILD = 65 | MASK; //32833
    		
    			/**  */
    			 public static final long FAILED_INDEX_INIT = 66 | MASK; //32834
    		
    			/**  */
    			 public static final long FAILED_INDEX_QUERY = 67 | MASK; //32835
    		
    			/**  */
    			 public static final long FAILED_INDEX_QUERY_DISABLED = 68 | MASK; //32836
    		
    			/**  */
    			 public static final long FAILED_INDEX_UPDATE = 69 | MASK; //32837
    		
    			/**  */
    			 public static final long FAILED_INDEX_UPDATE_INTERRUPTED = 70 | MASK; //32838
    		
    			/**  */
    			 public static final long FAILED_INDEX_UPDATE_PARSE = 71 | MASK; //32839
    		
    			/**  */
    			 public static final long FAILED_INDEX_UPDATE_PARSE_IO = 72 | MASK; //32840
    		
    			/**  */
    			 public static final long FAILED_INDEX_UPDATE_NO_OBJECT = 73 | MASK; //32841
    		
    			/**  */
    			 public static final long FAILED_INDEX_UPDATE_NO_DB = 74 | MASK; //32842
    		
    			/**  */
    			 public static final long FAILED_INDEX_UPDATE_PRE = 75 | MASK; //32843
    		
    			/**  */
    			 public static final long FAILED_INDEX_UPDATE_POST = 76 | MASK; //32844
    		
    			/**  */
    			 public static final long UNKNOWN_SERVER_ERROR = 77 | MASK; //32845
    		
    			/**  */
    			 public static final long FAILED_TO_AUTHENTICATE = 78 | MASK; //32846
    		
    			/**  */
    			 public static final long INTERNAL_SERVLET_ERROR = 79 | MASK; //32847
    		
    		
    	}
 	
 	  	/***/
    	public interface IO {
    		/**Mask for IO */
    		public static final long MASK=1<<16;
    		
    			/**  */
    			 public static final long SOAP_ERROR = 1 | MASK; //65537
    		
    			/**  */
    			 public static final long WRITE_ERROR = 2 | MASK; //65538
    		
    			/**  */
    			 public static final long READ_ERROR = 3 | MASK; //65539
    		
    			/**  */
    			 public static final long WS_CREATE_ERROR = 4 | MASK; //65540
    		
    			/**  */
    			 public static final long NETWORK_ERROR = 5 | MASK; //65541
    		
    			/**  */
    			 public static final long USER_ENCODE_ERROR = 6 | MASK; //65542
    		
    			/**  */
    			 public static final long MISSING_STREAM = 7 | MASK; //65543
    		
    			/**  */
    			 public static final long MISSING_HOST = 8 | MASK; //65544
    		
    			/**  */
    			 public static final long ENCODING_ERROR = 9 | MASK; //65545
    		
    			/**  */
    			 public static final long AXIS_ERROR = 10 | MASK; //65546
    		
    		
    	}
 	
 	  	/***/
    	public interface CLIENT {
    		/**Mask for CLIENT */
    		public static final long MASK=1<<17;
    		
    			/**  */
    			 public static final long ERROR_CREATING_CACHE = 1 | MASK; //131073
    		
    			/**  */
    			 public static final long ERROR_LOCKING_LOCK = 2 | MASK; //131074
    		
    			/**  */
    			 public static final long INVALID_REPLICATION_INTERVAL = 3 | MASK; //131075
    		
    			/**  */
    			 public static final long ERROR_LOADING_TRACKER = 4 | MASK; //131076
    		
    			/**  */
    			 public static final long ERROR_NOTIFIYING_LISTENERS = 5 | MASK; //131077
    		
    			/**  */
    			 public static final long LOCAL_PERSISTENCE_ERROR = 6 | MASK; //131078
    		
    			/**  */
    			 public static final long CLOSE_DB_ERROR = 7 | MASK; //131079
    		
    			/**  */
    			 public static final long FAILED_ADD_TRIPLES = 8 | MASK; //131080
    		
    			/**  */
    			 public static final long FAILED_DELETE_TRIPLES = 9 | MASK; //131081
    		
    			/**  */
    			 public static final long PARENT_ALREADY_SET = 10 | MASK; //131082
    		
    			/**  */
    			 public static final long CURRENT_THREAD_NOT_OWNER = 11 | MASK; //131083
    		
    			/**  */
    			 public static final long TRACKER_NOT_REGISTERED = 12 | MASK; //131084
    		
    			/**  */
    			 public static final long DB_ALREADY_OPEN = 13 | MASK; //131085
    		
    			/**  */
    			 public static final long XCOMMAND_LINK_ERROR = 14 | MASK; //131086
    		
    			/**  */
    			 public static final long ERROR_PERSISTING_CHANGESET = 15 | MASK; //131087
    		
    			/**  */
    			 public static final long ERROR_PERSISTING_COMMAND = 16 | MASK; //131088
    		
    			/**  */
    			 public static final long ERROR_PERSISTING_TRANSACTION = 17 | MASK; //131089
    		
    			/**  */
    			 public static final long ERROR_PERSISTING_TRANSACTIONQUEUE = 18 | MASK; //131090
    		
    			/**  */
    			 public static final long ERROR_LOADING_PERSISTED_CHANGESET = 19 | MASK; //131091
    		
    			/**  */
    			 public static final long ERROR_LOADING_PERSISTED_COMMAND = 20 | MASK; //131092
    		
    			/**  */
    			 public static final long ERROR_LOADING_PERSISTED_TRANSACTION = 21 | MASK; //131093
    		
    			/**  */
    			 public static final long ERROR_LOADING_PERSISTED_TRANSACTIONQUEUE = 22 | MASK; //131094
    		
    			/**  */
    			 public static final long ERROR_DELETING_PERSISTED_CHANGESET = 23 | MASK; //131095
    		
    			/**  */
    			 public static final long ERROR_DELETING_PERSISTED_COMMAND = 24 | MASK; //131096
    		
    			/**  */
    			 public static final long ERROR_DELETING_PERSISTED_TRANSACTION = 25 | MASK; //131097
    		
    			/**  */
    			 public static final long ERROR_DELETING_PERSISTED_TRANSACTIONQUEUE = 26 | MASK; //131098
    		
    			/**  */
    			 public static final long INVALID_URI = 27 | MASK; //131099
    		
    			/**  */
    			 public static final long DATASET_MISSING_MODEL_ERROR = 28 | MASK; //131100
    		
    			/**  */
    			 public static final long FAILED_CLEAR = 29 | MASK; //131101
    		
    			/**  */
    			 public static final long FAILED_INITIALIZE_CONTAINER = 30 | MASK; //131102
    		
    			/**  */
    			 public static final long FAILED_INITIALIZE_CONTAINER_CONNECTION = 31 | MASK; //131103
    		
    			/**  */
    			 public static final long FAILED_INITIALIZE_CONTAINER_TABLES = 32 | MASK; //131104
    		
    			/**  */
    			 public static final long FAILED_INITIALIZE_CONTAINER_TEMP_TABLES = 33 | MASK; //131105
    		
    			/**  */
    			 public static final long FAILED_INITIALIZE_CONTAINER_SQLCACHE = 34 | MASK; //131106
    		
    			/**  */
    			 public static final long FAILED_CONTAINER_GET_METADATA = 35 | MASK; //131107
    		
    			/**  */
    			 public static final long FAILED_CONTAINER_INSERT_BATCH = 36 | MASK; //131108
    		
    			/**  */
    			 public static final long FAILED_CONTAINER_FIND_NODE = 37 | MASK; //131109
    		
    			/**  */
    			 public static final long FAILED_CONTAINER_STMT_EXISTS = 38 | MASK; //131110
    		
    			/**  */
    			 public static final long FAILED_CONTAINER_FIND_STATEMENTS = 39 | MASK; //131111
    		
    			/**  */
    			 public static final long FAILED_CONTAINER_DELETE_STATEMENT = 40 | MASK; //131112
    		
    			/**  */
    			 public static final long FAILED_CONTAINER_COUNT_STATEMENTS = 41 | MASK; //131113
    		
    			/**  */
    			 public static final long FAILED_CONTAINER_CONVERT_RESULT = 42 | MASK; //131114
    		
    			/**  */
    			 public static final long FAILED_CONTAINER_EXEC_QUERY = 43 | MASK; //131115
    		
    			/**  */
    			 public static final long FAILED_CONTAINER_COUNT_ROWS = 44 | MASK; //131116
    		
    			/**  */
    			 public static final long FAILED_CONTAINER_DELETE_TABLE = 45 | MASK; //131117
    		
    			/**  */
    			 public static final long NO_NULL_VALUES = 46 | MASK; //131118
    		
    			/**  */
    			 public static final long SPACE_IN_URI = 47 | MASK; //131119
    		
    			/**  */
    			 public static final long URI_NOT_NULL = 48 | MASK; //131120
    		
    			/**  */
    			 public static final long ERROR_EXEC_QUERY = 49 | MASK; //131121
    		
    			/**  */
    			 public static final long ERROR_PARSING_QUERY = 50 | MASK; //131122
    		
    		
    	}
 	
 	  	/***/
    	public interface RDB {
    		/**Mask for RDB */
    		public static final long MASK=1<<18;
    		
    			/**  */
    			 public static final long URI_OR_JNDI = 1 | MASK; //262145
    		
    			/**  */
    			 public static final long DRIVER_NAME = 2 | MASK; //262146
    		
    			/**  */
    			 public static final long FAILED_TO_CONNECT = 3 | MASK; //262147
    		
    			/**  */
    			 public static final long OPERATION_ERROR = 4 | MASK; //262148
    		
    			/**  */
    			 public static final long CANNOT_ROLLBACK = 5 | MASK; //262149
    		
    			/**  */
    			 public static final long RETURN_PREPARED_STATEMENT = 6 | MASK; //262150
    		
    			/**  */
    			 public static final long NAMING_ERROR = 7 | MASK; //262151
    		
    			/**  */
    			 public static final long INVALID_SQL_FILE = 8 | MASK; //262152
    		
    			/**  */
    			 public static final long UNHANDLED_RDB_EXCEPTION = 9 | MASK; //262153
    		
    			/**  */
    			 public static final long DETECT_TABLES_EXCEPTION = 10 | MASK; //262154
    		
    			/**  */
    			 public static final long TOO_MANY_CONNECTIONS = 11 | MASK; //262155
    		
    			/**  */
    			 public static final long FAILED_CLOSING_POOL = 12 | MASK; //262156
    		
    			/**  */
    			 public static final long ALREADY_IN_RDB_TRANSACTION = 13 | MASK; //262157
    		
    			/**  */
    			 public static final long DIDNT_START_RDB_TRANSACTION = 14 | MASK; //262158
    		
    			/**  */
    			 public static final long FAILED_START_RDB_TRANSACTION = 15 | MASK; //262159
    		
    			/**  */
    			 public static final long FAILED_COMMIT_RDB_TRANSACTION = 16 | MASK; //262160
    		
    			/**  */
    			 public static final long FAILED_ROLLBACK_RDB_TRANSACTION = 17 | MASK; //262161
    		
    			/**  */
    			 public static final long FAILED_LOCK_TABLES = 18 | MASK; //262162
    		
    			/**  */
    			 public static final long FAILED_UNLOCK_TABLES = 19 | MASK; //262163
    		
    			/**  */
    			 public static final long NOT_IN_RDB_TRANSACTION = 20 | MASK; //262164
    		
    			/**  */
    			 public static final long FAILED_INITIALZE_DB = 21 | MASK; //262165
    		
    			/**  */
    			 public static final long FAILED_GET_INIT_STATUS = 22 | MASK; //262166
    		
    			/**  */
    			 public static final long FAILED_WAITING_DB_INIT = 23 | MASK; //262167
    		
    			/**  */
    			 public static final long FAILED_SETTING_ISOLATION = 24 | MASK; //262168
    		
    			/**  */
    			 public static final long FAILED_GETTING_TABLE_STATUS = 25 | MASK; //262169
    		
    			/**  */
    			 public static final long FAILED_GETTING_CONNECTION = 26 | MASK; //262170
    		
    			/**  */
    			 public static final long FAILED_RETURNING_CONNECTION = 27 | MASK; //262171
    		
    			/**  */
    			 public static final long FAILED_INITIALIZING_POOL = 28 | MASK; //262172
    		
    			/**  */
    			 public static final long FAILED_INITIALZE_TEMPTABLES = 29 | MASK; //262173
    		
    		
    	}
 	
 	  	/***/
    	public interface GLITTER {
    		/**Mask for GLITTER */
    		public static final long MASK=1<<19;
    		
    			/**  */
    			 public static final long GLITTER_EXCEPTION = 1 | MASK; //524289
    		
    			/**  */
    			 public static final long CANNOT_GENERATE_SOLUTIONS = 2 | MASK; //524290
    		
    			/**  */
    			 public static final long CONFIG_EXCEPTION = 3 | MASK; //524291
    		
    			/**  */
    			 public static final long EXPRESSION_EVAL = 4 | MASK; //524292
    		
    			/**  */
    			 public static final long FEATURE_NOT_IMPLEMENTED = 5 | MASK; //524293
    		
    			/**  */
    			 public static final long FUNCTIONAL_PREDICATE_INVOCATION = 6 | MASK; //524294
    		
    			/**  */
    			 public static final long INCOMPATIBLE_TYPE = 7 | MASK; //524295
    		
    			/**  */
    			 public static final long INVALID_ARGUMENT_COUNT = 10 | MASK; //524298
    		
    			/**  */
    			 public static final long INVALID_ARGUMENT_COUNT_MAX = 11 | MASK; //524299
    		
    			/**  */
    			 public static final long INVALID_BLANKNODE_LABEL = 12 | MASK; //524300
    		
    			/**  */
    			 public static final long QUERY_REFUSED = 13 | MASK; //524301
    		
    			/**  */
    			 public static final long STRING_LITERAL = 14 | MASK; //524302
    		
    			/**  */
    			 public static final long UNEXPECTED = 15 | MASK; //524303
    		
    			/**  */
    			 public static final long UNKOWN_FUNCTION = 16 | MASK; //524304
    		
    			/**  */
    			 public static final long UNKNOWN_GRAPH = 17 | MASK; //524305
    		
    			/**  */
    			 public static final long UNKNOWN_PREFIX = 18 | MASK; //524306
    		
    			/**  */
    			 public static final long PARSE_EXCEPTION = 19 | MASK; //524307
    		
    		
    	}
 	
 	  	/***/
    	public interface OSGI {
    		/**Mask for OSGI */
    		public static final long MASK=1<<20;
    		
    			/**  */
    			 public static final long MISSING_DEPENDENCY = 1 | MASK; //1048577
    		
    			/**  */
    			 public static final long ATTRIBUTE_WRONG_TYPE = 2 | MASK; //1048578
    		
    			/**  */
    			 public static final long ERROR_STOPPING_SERVICE = 3 | MASK; //1048579
    		
    			/**  */
    			 public static final long FAILED_INIT_DYNAMIC_CLASS = 4 | MASK; //1048580
    		
    			/**  */
    			 public static final long INTERNAL_COMPONENT_ERROR = 5 | MASK; //1048581
    		
    		
    	}
 	
 	  	/** */
    	public interface CORE {
    		/**Mask for CORE */
    		public static final long MASK=1<<21;
    		
    			/**  */
    			 public static final long COMPOUND_EXCEPTION = 1 | MASK; //2097153
    		
    		
    	}
 	
 }
 	