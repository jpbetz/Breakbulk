package org.openanzo.services.serialization;

import java.util.ArrayList;
import java.util.List;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.services.IUpdateTransaction;
import org.openanzo.services.IUpdates;
import org.openanzo.services.impl.Updates;

/**
 * {@link IUpdatesHandler} that collects the {@link IUpdateTransaction}s it is provided.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public class UpdatesCollector implements IUpdatesHandler {

    private final List<IUpdateTransaction> transactions = new ArrayList<IUpdateTransaction>();

    public void end() throws AnzoException {

    }

    public void handleTransaction(IUpdateTransaction transaction) throws AnzoException {
        transactions.add(transaction);
    }

    public void start() throws AnzoException {
    }

    /**
     * Get an IUpdates object for collected transactionsS
     * 
     * @return an IUpdates object for collected transactionsS
     */
    public IUpdates getUpdates() {
        return new Updates(transactions);
    }
}
