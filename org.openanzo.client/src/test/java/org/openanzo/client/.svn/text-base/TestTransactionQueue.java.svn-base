/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openanzo.rdf.MemQuadStore;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.test.Condition;
import org.openanzo.rdf.utils.test.TestUtilities;
import org.openanzo.rdf.utils.test.TestUtilities.TestData;
import org.openanzo.services.IPrecondition;
import org.openanzo.services.impl.Precondition;

/**
 * Unit tests for the TransactionQueue class.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public class TestTransactionQueue extends TestConfiguration {

    private TransactionQueue createQueue() {
        return new TransactionQueue(new TransactionPersistence(new MemQuadStore()));
    }

    /**
     * verifies that the begin and commit methods modify the inTransaction state correctly.
     * 
     * @throws Exception
     */
    public void testBeginCommit() throws Exception {
        TransactionQueue transactionQueue = createQueue();
        assertFalse(transactionQueue.inTransaction());
        transactionQueue.begin();
        assertTrue(transactionQueue.inTransaction());
        transactionQueue.commit();
    }

    /**
     * verifies that the add and remove methods modify the commitedTransaction state correctly.
     * 
     * @throws Exception
     */
    public void testAddRemove() throws Exception {
        TransactionQueue transactionQueue = createQueue();
        assertEquals(0, transactionQueue.committedTransactions.size());

        transactionQueue.begin();
        Transaction transaction = transactionQueue.getIsolatedTransaction().currentTransaction;
        transactionQueue.add(TestData.stmt1);
        transactionQueue.remove(TestData.stmt2);
        transactionQueue.commit();

        assertEquals(1, transactionQueue.committedTransactions.size());
        assertTrue(transactionQueue.committedTransactions.contains(transaction));
        assertNull(transactionQueue.getOrCreateIsolatedTransaction().currentTransaction);
    }

    /**
     * Runs a test of the walkTransactionTree method. Nests transactions with preconditions and then during the walk keeps track of the order the transactions
     * are walked by building up a list of the preconditions of the transactions and making sure this matches what is expected.
     * 
     * @throws Exception
     */
    public void testTreeWalk() throws Exception {
        Precondition p1 = new Precondition(), p2 = new Precondition(), p3 = new Precondition(), p4 = new Precondition(), p5 = new Precondition();

        TransactionQueue queue = createQueue();

        // normally the preconditions would be an array but for testing we can 
        // pass in a string 
        queue.begin(p1);
        queue.add(TestData.stmt1);
        assertNotNull(queue.getIsolatedTransaction().currentTransaction);
        queue.begin(p2);
        queue.begin(p3);
        queue.commit();
        queue.begin(p4);
        queue.commit();
        queue.commit();
        queue.begin(p5);
        queue.commit();
        queue.commit();
        assertNull(queue.getOrCreateIsolatedTransaction().currentTransaction);
        assertEquals(1, queue.committedTransactions.size());

        final List<IPrecondition> labels = new ArrayList<IPrecondition>();
        Transaction.MapFunction walk = new Transaction.MapFunction() {
            public void call(Transaction transaction) {
                if (transaction.preconditions != null) {
                    for (IPrecondition precondition : transaction.preconditions) {
                        labels.add(precondition);
                    }
                }
            }
        };

        queue.committedTransactions.get(0).walkTransactionTree(walk);

        assertEquals(5, labels.size());

        Iterator<IPrecondition> iter = labels.iterator();
        assertEquals(p1, iter.next());
        assertEquals(p2, iter.next());
        assertEquals(p3, iter.next());
        assertEquals(p4, iter.next());
        assertEquals(p5, iter.next());
    }

    /**
     * Verifies the a filter request within nested transactions correctly filters out the appropriate statements.
     * 
     * @throws Exception
     */
    public void testFilter() throws Exception {

        TransactionQueue queue = createQueue();

        Set<Statement> statements = new HashSet<Statement>();

        statements.add(TestData.stmt1);
        statements.add(TestData.stmt2);
        // don't add stmt3 because we want to test that Transaction filtering is working.

        queue.begin();

        assertTrue(queue.inTransaction());

        queue.add(TestData.stmt1);
        queue.remove(TestData.stmt2);
        queue.add(TestData.stmt3);

        queue.begin();
        assertTrue(queue.inTransaction());
        queue.add(TestData.stmt4);
        queue.begin();
        queue.add(TestData.stmt5);
        queue.commit();
        queue.add(TestData.stmt6);

        queue.filter(statements, TestData.subj1, null, null, (URI[]) null);

        queue.commit();
        assertTrue(queue.inTransaction());
        queue.commit();
        assertFalse(queue.inTransaction());

        // check idempotency of filter
        queue.filter(statements, TestData.subj1, null, null, (URI[]) null);

        assertTrue(statements.contains(TestData.stmt1));
        assertFalse(statements.contains(TestData.stmt2));
        assertTrue(statements.contains(TestData.stmt3));

        assertTrue(statements.contains(TestData.stmt4));
        assertTrue(statements.contains(TestData.stmt5));
        assertTrue(statements.contains(TestData.stmt6));

    }

    /**
     * Verifies that two threads are isolated from one another and that the transaction isolation is objects (IsolatedTransaction) are cleaned up when they are
     * no longer needed.
     * 
     * @throws Exception
     */
    public void testMultiThreaded() throws Exception {
        TransactionQueue queue = createQueue();
        Runner1 runner1 = new Runner1(queue);
        Runner2 runner2 = new Runner2(queue);

        Thread thread1 = new Thread(runner1);
        Thread thread2 = new Thread(runner2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        assertEquals(2, queue.committedTransactions.size());
        Transaction transaction1 = queue.committedTransactions.get(0);
        assertTrue(transaction1.additions.contains(TestData.stmt1));

        Transaction transaction2 = queue.committedTransactions.get(1);
        assertTrue(transaction2.additions.contains(TestData.stmt2));

        assertNull(queue.isolatedTransactions.get());

        assertTrue(runner1.isIsolated);
        assertTrue(runner2.isIsolated);
    }

    private static int token = 0;

    private static final class Runner1 implements Runnable {
        TransactionQueue queue;

        boolean          isIsolated;

        Statement        stmt = TestData.stmt1;

        public Runner1(TransactionQueue queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                queue.begin();

                token = 1;

                TestUtilities.waitFor(new Condition() {
                    @Override
                    public boolean check() {
                        return token >= 2;
                    }
                });

                queue.add(TestData.stmt1);
                token = 3;

                TestUtilities.waitFor(new Condition() {
                    @Override
                    public boolean check() {
                        return token >= 4;
                    }
                });

                List<Statement> stmts = new ArrayList<Statement>();
                queue.filter(stmts, stmt.getSubject(), stmt.getPredicate(), stmt.getObject(), stmt.getNamedGraphUri());
                isIsolated = stmts.contains(TestData.stmt1) && !stmts.contains(TestData.stmt2);

                token = 5;

                TestUtilities.waitFor(new Condition() {
                    @Override
                    public boolean check() {
                        return token >= 6;
                    }
                });

                queue.commit();

                token = 7;

            } catch (InterruptedException e) {
            } catch (TimeoutException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static final class Runner2 implements Runnable {
        TransactionQueue queue;

        boolean          isIsolated;

        Statement        stmt = TestData.stmt2;

        public Runner2(TransactionQueue queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                TestUtilities.waitFor(new Condition() {
                    @Override
                    public boolean check() {
                        return token >= 1;
                    }
                });
                queue.begin();

                token = 2;
                TestUtilities.waitFor(new Condition() {
                    @Override
                    public boolean check() {
                        return token >= 3;
                    }
                });
                queue.add(TestData.stmt2);
                token = 4;
                TestUtilities.waitFor(new Condition() {
                    @Override
                    public boolean check() {
                        return token >= 5;
                    }
                });

                List<Statement> stmts = new ArrayList<Statement>();
                queue.filter(stmts, stmt.getSubject(), stmt.getPredicate(), stmt.getObject(), stmt.getNamedGraphUri());
                isIsolated = stmts.contains(TestData.stmt2) && !stmts.contains(TestData.stmt1);

                token = 6;
                TestUtilities.waitFor(new Condition() {
                    @Override
                    public boolean check() {
                        return token >= 7;
                    }
                });

                queue.commit();

            } catch (InterruptedException e) {
            } catch (TimeoutException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
