/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     
 *     Cambridge Semantics Incorporated - Initial Implementation
 *******************************************************************************/
package org.openanzo.services;

import org.openanzo.rdf.Constants;
import org.openanzo.rdf.URI;

/**
 * Binary Store Servlet Constants
 * 
 * @author Simon Martin ( <a href="mailto:simon@cambridgesemantics.com">simon@cambridgesemantics.com </a>)
 * 
 */

public interface BinaryStoreConstants {
    /** Binary store var directory */
    public static final String BINARYSTORE_VAR_DIRECTORY                   = "var";

    /** Lockfile prefix */
    public static final String LOCKFILE_PREFIX                             = ".lock_";

    /** Lockfile delimeter */
    public static final String LOCKFILE_DELIMETER                          = "###";

    /** Frequency for binary store heartbeat */
    public static final int    BINARYSTORE_HEARTBEAT_FREQ                  = 60000;

    /** Heartbeat checktime */
    public static final int    BINARYSTORE_HEARTBEAT_CHECKTIME             = 120000;

    /** Binary store uri prefix */
    public static final String BINARYSTORE_URI_PREFIX                      = "http://openanzo.org/ontologies/2008/07/AnzoBinaryStore#";

    /** NOOP operation */
    public static final String NOOP                                        = "noop";

    /** Create operation */
    public static final String CREATE                                      = "create";

    /** Read operation */
    public static final String READ                                        = "read";

    /** Update operation */
    public static final String UPDATE                                      = "update";

    /** Delete operation */
    public static final String DELETE                                      = "delete";

    /** Feedback id */
    public static final String FEEDBACK_ID                                 = "upload_uri";

    /** Revisioned property */
    public static final String REVISIONED                                  = "revisioned";

    /** Filename property */
    public static final String FILENAME                                    = "file";

    /** Graph property */
    public static final String GRAPH                                       = "graph";

    /** Binary store item */
    public static final URI    BINARYSTORE_ITEM_URI                        = Constants.valueFactory.createURI(BINARYSTORE_URI_PREFIX + "binarystoreitem");

    /** Binary store item size */
    public static final URI    BINARYSTORE_ITEM_SIZE_URI                   = Constants.valueFactory.createURI(BINARYSTORE_URI_PREFIX + "binarystoreitemsize");

    /** Binary store item sha1sum */
    public static final URI    BINARYSTORE_ITEM_SHA_1_URI                  = Constants.valueFactory.createURI(BINARYSTORE_URI_PREFIX + "sha1sum");

    /** Binary store upload job */
    public static final URI    BINARYSTORE_ITEM_UPLOAD_JOB_URI             = Constants.valueFactory.createURI(BINARYSTORE_URI_PREFIX + "jobupload");

    /** Binary store checksum job */
    public static final URI    BINARYSTORE_ITEM_CHECKSUM_JOB_URI           = Constants.valueFactory.createURI(BINARYSTORE_URI_PREFIX + "jobchecksum");

    /** Binary store job */
    public static final URI    BINARYSTORE_ITEM_PROGRESS_JOB_URI           = Constants.valueFactory.createURI(BINARYSTORE_URI_PREFIX + "job");

    /** Binary store complete */
    public static final URI    BINARYSTORE_ITEM_PROGRESS_JOB_COMPLETE_URI  = Constants.valueFactory.createURI(BINARYSTORE_URI_PREFIX + "jobcomplete");

    /** Binary store completed */
    public static final URI    BINARYSTORE_ITEM_PROGRESS_JOB_COMPLETED_URI = Constants.valueFactory.createURI(BINARYSTORE_URI_PREFIX + "jobcompleted");

    /** Binary store channel */
    public static final String BINARYSTORE_ITEM_PROGRESS_CHANNEL_PREFIX    = "http://openanzo.org/ontologies/2008/07/AnzoBinaryStore/FeedbackChannel#";

    /** Content type URI */
    public static final URI    CONTENT_TYPE_URI                            = Constants.valueFactory.createURI("http://www.w3.org/2006/http-headers#content-type");

    /** Revision header */
    public static final String URL_QUERY_REVISION                          = "revision";

    /** Aspect header */
    public static final String URL_QUERY_ASPECT                            = "aspect";

    /** Format header */
    public static final String URL_QUERY_FORMAT                            = "format";

    /** Metadata header */
    public static final String URL_ASPECT_METADATA                         = "metadata";

    /** RDF format header */
    public static final String RDF_XMLFORMAT                               = "rdf";

    /** Auth header */
    public static final String AUTH_HEADER                                 = "X-BinaryFileAuthorized";

    /** Auth runas header */
    public static final String AUTHRUNAS_HEADER                            = "X-OpenAnzoBinaryStoreRunAs";

    /** PROGRESSURI_PREFIX ends in a / and not a # because it is sent from the browser in the url string and if it was a # it would not be sent */
    public static final String PROGRESSURI_PREFIX                          = "http://openanzo.org/ontologies/2008/07/AnzoBinaryStore/FeedbackChannel/Progress/";

}
