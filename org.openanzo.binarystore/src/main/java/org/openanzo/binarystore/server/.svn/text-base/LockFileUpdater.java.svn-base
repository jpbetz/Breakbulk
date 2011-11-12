/*******************************************************************************
 * Copyright (c) 2008-2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.openanzo.binarystore.server;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openanzo.services.BinaryStoreConstants;

class LockFileUpdater extends Thread {

    private final File       lockFile;

    volatile private boolean operate = true;

    LockFileUpdater(String filename) throws IOException {
        lockFile = new File(filename);
        lockFile.createNewFile();
    }

    void shutdown() {
        synchronized (this) {
            operate = false;
            this.notify();
        }
    }

    @Override
    public void run() {
        setName("Binary Store LockFile Updater");
        try {
            // wait for clean shutdown
            while (operate) {
                //update once a minute
                lockFile.setLastModified(new Date().getTime());
                synchronized (this) {
                    wait(BinaryStoreConstants.BINARYSTORE_HEARTBEAT_FREQ);
                }
            }
        } catch (InterruptedException e) {
            return;
        }
        lockFile.deleteOnExit();
    }
}
