/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.model/src/com/ibm/adtech/boca/publisher/EventPublisherMBean.java,v $
 * Created by:  Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * Created on:  Oct 18, 2006
 * Revision:	$Id: EventPublisherMBean.java 180 2007-07-31 14:24:13Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.combus.publisher;

/**
 * MBean interface to expose the EventPublisher to JMX
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public interface EventPublisherMBean {

    /**
     * Get the max size of the publish queue
     * 
     * @return the max size of the publish queue
     */
    public int getMaxQueueSize();

    /**
     * Set the max size of the publish queue
     * 
     * @param queueSize
     *            max size of the publish queue
     */
    public void setMaxQueueSize(int queueSize);

    /**
     * Flush the contents of the publish queue
     */
    public void flushQueue();

    /**
     * Get the number of message on the publish queue
     * 
     * @return the number of message on the publish queueF
     */
    public int getQueueSize();



}
