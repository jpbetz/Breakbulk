package org.openanzo.test.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.openanzo.client.AnzoClient;
import org.openanzo.client.ClientGraph;
import org.openanzo.exceptions.AnzoException;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.test.AbstractTest;

/**
 * @author Andreas S. Rath - mailto:arath@gmx.at
 * 
 *         Since 24.10.2008
 */
public class AnzoUpdateRepositoryMultiThreadedTest extends AbstractTest {

    private AnzoClient       anzoClient;

    static final URI         testGraph                  = Constants.valueFactory.createURI("http://test/testGraph/" + new Date().getTime());

    static final URI         ng1                        = Constants.valueFactory.createURI("http://test/1");

    static final URI         ng2                        = Constants.valueFactory.createURI("http://test/2");

    static final URI         ng3                        = Constants.valueFactory.createURI("http://test/3");

    static final URI         ng4                        = Constants.valueFactory.createURI("http://test/4");

    static final URI         ng5                        = Constants.valueFactory.createURI("http://test/5");

    /**
     * Play with these parameters a little bit to make sure that AnzoServer works correct
     * 
     * ...play start..
     */
    private static final int NR_OF_SUBJECT_VARIATIONS   = 100;                                                                              // try with 1000

    private static final int NR_OF_PREDICATE_VARIATIONS = 100;                                                                              // try with 1000

    private static final int NR_OF_OBJECT_VARIATIONS    = 100;                                                                              // try with 1000

    private static final int NR_OF_THREADS              = 10;                                                                               // try with 100

    /**
     * Test multiple threads updating repository via replica graphs
     * 
     * @throws AnzoException
     */
    public void testUpdateRepositoryReplicaGraphTest() throws AnzoException {

        anzoClient = new AnzoClient(getDefaultClientConfiguration());
        Assert.assertNotNull(anzoClient);

        Assert.assertTrue(anzoClient.isConnected() == false);
        anzoClient.connect();
        Assert.assertTrue(anzoClient.isConnected() == true);

        anzoClient.updateRepository();

        final ClientGraph graph = anzoClient.getReplicaGraph(testGraph);
        graph.clear();
        Assert.assertTrue(graph.getStatements().size() == 0);

        List<Thread> threadList = new ArrayList<Thread>();
        int nrOfAddedStatements = 100;
        for (int i = 0; i < nrOfAddedStatements; i++) {
            final URI testUri = Constants.valueFactory.createURI("http://test/" + i);

            Thread t = new Thread() {
                @Override
                public void run() {
                    super.run();
                    final Statement s = new org.openanzo.rdf.Statement(ng1, ng2, testUri);
                    graph.add(s);
                    try {
                        anzoClient.updateRepository();
                    } catch (AnzoException e) {
                        Assert.assertTrue(e.getStackTrace().toString(), false);
                    }

                }
            };

            threadList.add(t);
            t.start();
        }

        int nrOfStillRunningThreads = threadList.size();
        while (nrOfStillRunningThreads > 0) {
            nrOfStillRunningThreads = 0;

            for (Thread thread : threadList) {
                boolean alive = thread.isAlive();
                if (alive) {
                    nrOfStillRunningThreads++;
                }
            }
        }

        Assert.assertTrue(graph.getStatements().size() == nrOfAddedStatements);
        /** Is it necessary to close the graph before closing the AnzoClient? */
        graph.close();
        Assert.assertTrue(graph.isClosed() == true);
        anzoClient.close();
        Assert.assertTrue(anzoClient.isConnected() == false);

        /**
         * reconnect the client and graph to see if we still have all the statements we added
         */
        anzoClient = new AnzoClient(getDefaultClientConfiguration());
        Assert.assertNotNull(anzoClient);

        Assert.assertTrue(anzoClient.isConnected() == false);
        anzoClient.connect();
        Assert.assertTrue(anzoClient.isConnected() == true);

        final ClientGraph graphAfterReconnect = anzoClient.getReplicaGraph(testGraph);
        Assert.assertNotNull(graphAfterReconnect);
        Assert.assertTrue(graphAfterReconnect.getStatements().size() == nrOfAddedStatements);

        graphAfterReconnect.clear();
        Assert.assertTrue(graphAfterReconnect.getStatements().size() == 0);

        anzoClient.updateRepository();

        graphAfterReconnect.close();
        Assert.assertTrue(graphAfterReconnect.isClosed() == true);
        anzoClient.close();
        Assert.assertTrue(anzoClient.isConnected() == false);

        /** is the graph still empty ? */
        anzoClient = new AnzoClient(getDefaultClientConfiguration());
        Assert.assertNotNull(anzoClient);

        Assert.assertTrue(anzoClient.isConnected() == false);
        anzoClient.connect();
        Assert.assertTrue(anzoClient.isConnected() == true);

        final ClientGraph graphAfterCleanUp = anzoClient.getReplicaGraph(testGraph);
        Assert.assertTrue(graphAfterCleanUp.getStatements().size() == 0);
        graphAfterCleanUp.close();
        anzoClient.close();

    }

    /**
     * Test multiple client updating repository via server graphs
     * 
     * @throws AnzoException
     */
    public void testUpdateRepositoryServerGraphTest() throws AnzoException {

        Assert.assertNotNull(getDefaultClientConfiguration());

        anzoClient = new AnzoClient(getDefaultClientConfiguration());
        Assert.assertNotNull(anzoClient);

        Assert.assertTrue(anzoClient.isConnected() == false);
        anzoClient.connect();
        Assert.assertTrue(anzoClient.isConnected() == true);

        anzoClient.updateRepository();

        final ClientGraph graph = anzoClient.getServerGraph(testGraph);
        graph.clear();
        Assert.assertTrue(graph.getStatements().size() == 0);

        List<Thread> threadList = new ArrayList<Thread>();
        int nrOfAddedStatements = 100;
        for (int i = 0; i < nrOfAddedStatements; i++) {
            final URI testUri = Constants.valueFactory.createURI("http://test/" + i);

            Thread t = new Thread() {
                @Override
                public void run() {
                    super.run();
                    final Statement s = new org.openanzo.rdf.Statement(ng1, ng2, testUri);
                    graph.add(s);
                    try {
                        anzoClient.updateRepository();
                    } catch (AnzoException e) {
                        Assert.assertTrue(e.getStackTrace().toString(), false);
                    }

                }
            };

            threadList.add(t);
            t.start();
        }

        int nrOfStillRunningThreads = threadList.size();
        while (nrOfStillRunningThreads > 0) {
            nrOfStillRunningThreads = 0;

            for (Thread thread : threadList) {
                boolean alive = thread.isAlive();
                if (alive) {
                    nrOfStillRunningThreads++;
                }
            }
        }

        Assert.assertTrue(graph.getStatements().size() == nrOfAddedStatements);
        /** Is it necessary to close the graph before closing the AnzoClient? */
        graph.close();
        Assert.assertTrue(graph.isClosed() == true);
        anzoClient.close();
        Assert.assertTrue(anzoClient.isConnected() == false);

        /**
         * reconnect the client and graph to see if we still have all the statements we added
         */
        anzoClient = new AnzoClient(getDefaultClientConfiguration());
        Assert.assertNotNull(anzoClient);

        Assert.assertTrue(anzoClient.isConnected() == false);
        anzoClient.connect();
        Assert.assertTrue(anzoClient.isConnected() == true);

        final ClientGraph graphAfterReconnect = anzoClient.getServerGraph(testGraph);
        Assert.assertNotNull(graphAfterReconnect);
        Assert.assertTrue(graphAfterReconnect.getStatements().size() == nrOfAddedStatements);

        graphAfterReconnect.clear();
        Assert.assertTrue(graphAfterReconnect.getStatements().size() == 0);

        anzoClient.updateRepository();

        graphAfterReconnect.close();
        Assert.assertTrue(graphAfterReconnect.isClosed() == true);
        anzoClient.close();
        Assert.assertTrue(anzoClient.isConnected() == false);

        /** is the graph still empty ? */
        anzoClient = new AnzoClient(getDefaultClientConfiguration());
        Assert.assertNotNull(anzoClient);

        Assert.assertTrue(anzoClient.isConnected() == false);
        anzoClient.connect();
        Assert.assertTrue(anzoClient.isConnected() == true);

        final ClientGraph graphAfterCleanUp = anzoClient.getServerGraph(testGraph);
        Assert.assertTrue(graphAfterCleanUp.getStatements().size() == 0);
        graphAfterCleanUp.close();
        anzoClient.close();

    }

    /**
     * Test updating repository via replicagraphs with
     * 
     * @throws AnzoException
     */
    public void testUpdateRepositoryReplicaGraphMultiStatementsTest() throws AnzoException {

        Assert.assertNotNull(getDefaultClientConfiguration());

        anzoClient = new AnzoClient(getDefaultClientConfiguration());
        Assert.assertNotNull(anzoClient);

        Assert.assertTrue(anzoClient.isConnected() == false);
        anzoClient.connect();
        anzoClient.reset(Collections.<Statement> emptySet(), Collections.<Statement> emptySet());
        Assert.assertTrue(anzoClient.isConnected() == true);

        anzoClient.updateRepository();

        final ClientGraph graph = anzoClient.getReplicaGraph(testGraph);
        graph.clear();
        Assert.assertTrue(graph.getStatements().size() == 0);
        anzoClient.updateRepository();

        List<Thread> threadList = new ArrayList<Thread>();

        /**
         * Play with these parameters a little bit to make sure that AnzoServer works correct
         */
        int nrOfThreadsToGenerate = NR_OF_THREADS;

        final int nrOfSubjectVariations = NR_OF_SUBJECT_VARIATIONS;
        final int nrOfPredicateVariations = NR_OF_PREDICATE_VARIATIONS;
        final int nrOfObjectVariations = NR_OF_OBJECT_VARIATIONS;

        int nrOfAllAddedStatements = nrOfThreadsToGenerate * nrOfObjectVariations * nrOfPredicateVariations * nrOfSubjectVariations;
        System.out.println("We try to add [" + nrOfAllAddedStatements + "] distinct statements with [" + nrOfThreadsToGenerate + "] threads.");

        for (int i = 0; i < nrOfThreadsToGenerate; i++) {

            Thread t = new Thread() {
                @Override
                public void run() {
                    super.run();

                    /** Calculate unique identifier */
                    String uniqueId = String.valueOf(new Date().getTime() + this.getId());

                    for (int z1 = 0; z1 < nrOfSubjectVariations; z1++) {

                        for (int z2 = 0; z2 < nrOfPredicateVariations; z2++) {

                            for (int z3 = 0; z3 < nrOfObjectVariations; z3++) {

                                final URI s = Constants.valueFactory.createURI("http://test/" + uniqueId + "/" + z1 + "_" + z2 + "_" + z3);
                                final URI p = Constants.valueFactory.createURI("http://test/" + uniqueId + "/" + z1 + "_" + z2 + "_" + z3);
                                final URI o = Constants.valueFactory.createURI("http://test/" + uniqueId + "/" + z1 + "_" + z2 + "_" + z3);

                                final Statement stmt = new org.openanzo.rdf.Statement(s, p, o);
                                anzoClient.begin();
                                graph.add(stmt);
                                anzoClient.commit();
                                try {
                                    anzoClient.updateRepository();
                                } catch (AnzoException e) {
                                    e.printStackTrace();
                                    Assert.assertTrue(e.getStackTrace().toString(), false);
                                }
                            }
                            System.out.println("Thread Unique Id: [" + uniqueId + "] added nrOfObjectVariations [" + nrOfObjectVariations + "]");

                            try {
                                anzoClient.updateRepository();
                            } catch (AnzoException e) {
                                e.printStackTrace();
                                Assert.assertTrue(e.getStackTrace().toString(), false);
                            }
                        }

                        System.out.println("Thread Unique Id: [" + uniqueId + "] added nrOfPredicateVariations * nrOfObjectVariations [" + nrOfPredicateVariations * nrOfObjectVariations + "]");

                        try {
                            anzoClient.updateRepository();
                        } catch (AnzoException e) {
                            e.printStackTrace();
                            Assert.assertTrue(e.getStackTrace().toString(), false);
                        }
                    }

                    System.out.println("Thread Unique Id: [" + uniqueId + "] added nrOfSubjectVariations * nrOfPredicateVariations * nrOfObjectVariations [" + nrOfSubjectVariations * nrOfPredicateVariations * nrOfObjectVariations + "]");

                }
            };

            threadList.add(t);
            t.start();
        }

        int nrOfStillRunningThreads = threadList.size();
        while (nrOfStillRunningThreads > 0) {
            nrOfStillRunningThreads = 0;

            for (Thread thread : threadList) {
                boolean alive = thread.isAlive();
                if (alive) {
                    nrOfStillRunningThreads++;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertTrue(graph.getStatements().size() == nrOfAllAddedStatements);
        /** Is it necessary to close the graph before closing the AnzoClient? */
        graph.close();
        Assert.assertTrue(graph.isClosed() == true);
        anzoClient.close();
        Assert.assertTrue(anzoClient.isConnected() == false);

        /**
         * reconnect the client and graph to see if we still have all the statements we added
         */
        anzoClient = new AnzoClient(getDefaultClientConfiguration());
        Assert.assertNotNull(anzoClient);

        Assert.assertTrue(anzoClient.isConnected() == false);
        anzoClient.connect();
        Assert.assertTrue(anzoClient.isConnected() == true);

        final ClientGraph graphAfterReconnect = anzoClient.getReplicaGraph(testGraph);
        Assert.assertNotNull(graphAfterReconnect);
        Assert.assertTrue(graphAfterReconnect.getStatements().size() == nrOfAllAddedStatements);

        graphAfterReconnect.clear();
        Assert.assertTrue(graphAfterReconnect.getStatements().size() == 0);

        anzoClient.updateRepository();

        graphAfterReconnect.close();
        Assert.assertTrue(graphAfterReconnect.isClosed() == true);
        anzoClient.close();
        Assert.assertTrue(anzoClient.isConnected() == false);

        /** is the graph still empty ? */
        anzoClient = new AnzoClient(getDefaultClientConfiguration());
        Assert.assertNotNull(anzoClient);

        Assert.assertTrue(anzoClient.isConnected() == false);
        anzoClient.connect();
        Assert.assertTrue(anzoClient.isConnected() == true);

        final ClientGraph graphAfterCleanUp = anzoClient.getReplicaGraph(testGraph);
        Assert.assertTrue(graphAfterCleanUp.getStatements().size() == 0);
        graphAfterCleanUp.close();
        anzoClient.close();

    }

    /**
     * Test upating repository with replica graphs and transactions
     * 
     * @throws AnzoException
     */
    public void testUpdateRepositoryReplicaGraphMultiStatementsWithTransactionsTest() throws AnzoException {

        Assert.assertNotNull(getDefaultClientConfiguration());

        anzoClient = new AnzoClient(getDefaultClientConfiguration());
        Assert.assertNotNull(anzoClient);

        Assert.assertTrue(anzoClient.isConnected() == false);
        anzoClient.connect();
        Assert.assertTrue(anzoClient.isConnected() == true);

        anzoClient.updateRepository();

        final ClientGraph graph = anzoClient.getReplicaGraph(testGraph);
        graph.clear();
        Assert.assertTrue(graph.getStatements().size() == 0);
        anzoClient.updateRepository();

        List<Thread> threadList = new ArrayList<Thread>();

        /**
         * Play with these parameters a little bit to make sure that AnzoServer works correct
         */
        int nrOfThreadsToGenerate = NR_OF_THREADS;

        final int nrOfSubjectVariations = NR_OF_SUBJECT_VARIATIONS;
        final int nrOfPredicateVariations = NR_OF_PREDICATE_VARIATIONS;
        final int nrOfObjectVariations = NR_OF_OBJECT_VARIATIONS;

        int nrOfAllAddedStatements = nrOfThreadsToGenerate * nrOfObjectVariations * nrOfPredicateVariations * nrOfSubjectVariations;
        System.out.println("We try to add [" + nrOfAllAddedStatements + "] distinct statements with [" + nrOfThreadsToGenerate + "] threads.");

        for (int i = 0; i < nrOfThreadsToGenerate; i++) {

            Thread t = new Thread() {
                @Override
                public void run() {
                    super.run();

                    /** Calculate unique identifier */
                    String uniqueId = String.valueOf(new Date().getTime() + this.getId());

                    for (int z1 = 0; z1 < nrOfSubjectVariations; z1++) {
                        anzoClient.begin();

                        for (int z2 = 0; z2 < nrOfPredicateVariations; z2++) {
                            anzoClient.begin();

                            for (int z3 = 0; z3 < nrOfObjectVariations; z3++) {
                                anzoClient.begin();

                                final URI s = Constants.valueFactory.createURI("http://test/" + uniqueId + "/" + z1 + "_" + z2 + "_" + z3);
                                final URI p = Constants.valueFactory.createURI("http://test/" + uniqueId + "/" + z1 + "_" + z2 + "_" + z3);
                                final URI o = Constants.valueFactory.createURI("http://test/" + uniqueId + "/" + z1 + "_" + z2 + "_" + z3);

                                final Statement stmt = new org.openanzo.rdf.Statement(s, p, o);
                                graph.add(stmt);
                                anzoClient.commit();
                                try {
                                    anzoClient.updateRepository();
                                } catch (AnzoException e) {
                                    e.printStackTrace();
                                    Assert.assertTrue(e.getStackTrace().toString(), false);
                                }
                            }
                            System.out.println("Thread Unique Id: [" + uniqueId + "] added nrOfObjectVariations [" + nrOfObjectVariations + "]");

                            anzoClient.commit();
                            try {
                                anzoClient.updateRepository();
                            } catch (AnzoException e) {
                                e.printStackTrace();
                                Assert.assertTrue(e.getStackTrace().toString(), false);
                            }

                        }

                        System.out.println("Thread Unique Id: [" + uniqueId + "] added nrOfPredicateVariations * nrOfObjectVariations [" + nrOfPredicateVariations * nrOfObjectVariations + "]");

                        anzoClient.commit();
                        try {
                            anzoClient.updateRepository();
                        } catch (AnzoException e) {
                            e.printStackTrace();
                            Assert.assertTrue(e.getStackTrace().toString(), false);
                        }
                    }

                    System.out.println("Thread Unique Id: [" + uniqueId + "] added nrOfSubjectVariations * nrOfPredicateVariations * nrOfObjectVariations [" + nrOfSubjectVariations * nrOfPredicateVariations * nrOfObjectVariations + "]");

                }
            };

            threadList.add(t);
            t.start();
        }

        int nrOfStillRunningThreads = threadList.size();
        while (nrOfStillRunningThreads > 0) {
            nrOfStillRunningThreads = 0;

            for (Thread thread : threadList) {
                boolean alive = thread.isAlive();
                if (alive) {
                    nrOfStillRunningThreads++;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertTrue(graph.getStatements().size() == nrOfAllAddedStatements);
        /** Is it necessary to close the graph before closing the AnzoClient? */
        graph.close();
        Assert.assertTrue(graph.isClosed() == true);
        anzoClient.close();
        Assert.assertTrue(anzoClient.isConnected() == false);

        /**
         * reconnect the client and graph to see if we still have all the statements we added
         */
        anzoClient = new AnzoClient(getDefaultClientConfiguration());
        Assert.assertNotNull(anzoClient);

        Assert.assertTrue(anzoClient.isConnected() == false);
        anzoClient.connect();
        Assert.assertTrue(anzoClient.isConnected() == true);

        final ClientGraph graphAfterReconnect = anzoClient.getReplicaGraph(testGraph);
        Assert.assertNotNull(graphAfterReconnect);
        Assert.assertTrue(graphAfterReconnect.getStatements().size() == nrOfAllAddedStatements);

        graphAfterReconnect.clear();
        Assert.assertTrue(graphAfterReconnect.getStatements().size() == 0);

        anzoClient.updateRepository();

        graphAfterReconnect.close();
        Assert.assertTrue(graphAfterReconnect.isClosed() == true);
        anzoClient.close();
        Assert.assertTrue(anzoClient.isConnected() == false);

        /** is the graph still empty ? */
        anzoClient = new AnzoClient(getDefaultClientConfiguration());
        Assert.assertNotNull(anzoClient);

        Assert.assertTrue(anzoClient.isConnected() == false);
        anzoClient.connect();
        Assert.assertTrue(anzoClient.isConnected() == true);

        final ClientGraph graphAfterCleanUp = anzoClient.getReplicaGraph(testGraph);
        Assert.assertTrue(graphAfterCleanUp.getStatements().size() == 0);
        graphAfterCleanUp.close();
        anzoClient.close();

    }

    /**
     * Test updating repository via server graphs with multiple statements
     * 
     * @throws AnzoException
     */
    public void testUpdateRepositoryServerGraphMultiStatementsTest() throws AnzoException {

        Assert.assertNotNull(getDefaultClientConfiguration());

        anzoClient = new AnzoClient(getDefaultClientConfiguration());
        Assert.assertNotNull(anzoClient);

        Assert.assertTrue(anzoClient.isConnected() == false);
        anzoClient.connect();
        Assert.assertTrue(anzoClient.isConnected() == true);

        anzoClient.updateRepository();

        final ClientGraph graph = anzoClient.getServerGraph(testGraph);
        graph.clear();
        Assert.assertTrue(graph.getStatements().size() == 0);
        anzoClient.updateRepository();

        List<Thread> threadList = new ArrayList<Thread>();

        /**
         * Play with these parameters a little bit to make sure that AnzoServer works correct
         */
        int nrOfThreadsToGenerate = NR_OF_THREADS;

        final int nrOfSubjectVariations = NR_OF_SUBJECT_VARIATIONS;
        final int nrOfPredicateVariations = NR_OF_PREDICATE_VARIATIONS;
        final int nrOfObjectVariations = NR_OF_OBJECT_VARIATIONS;

        int nrOfAllAddedStatements = nrOfThreadsToGenerate * nrOfObjectVariations * nrOfPredicateVariations * nrOfSubjectVariations;
        System.out.println("We try to add [" + nrOfAllAddedStatements + "] distinct statements with [" + nrOfThreadsToGenerate + "] threads.");

        for (int i = 0; i < nrOfThreadsToGenerate; i++) {

            Thread t = new Thread() {
                @Override
                public void run() {
                    super.run();

                    /** Calculate unique identifier */
                    String uniqueId = String.valueOf(new Date().getTime() + this.getId());

                    for (int z1 = 0; z1 < nrOfSubjectVariations; z1++) {

                        for (int z2 = 0; z2 < nrOfPredicateVariations; z2++) {

                            for (int z3 = 0; z3 < nrOfObjectVariations; z3++) {

                                final URI s = Constants.valueFactory.createURI("http://test/" + uniqueId + "/" + z1 + "_" + z2 + "_" + z3);
                                final URI p = Constants.valueFactory.createURI("http://test/" + uniqueId + "/" + z1 + "_" + z2 + "_" + z3);
                                final URI o = Constants.valueFactory.createURI("http://test/" + uniqueId + "/" + z1 + "_" + z2 + "_" + z3);

                                final Statement stmt = new org.openanzo.rdf.Statement(s, p, o);
                                graph.add(stmt);
                                try {
                                    anzoClient.updateRepository();
                                } catch (AnzoException e) {
                                    e.printStackTrace();
                                    Assert.assertTrue(e.getStackTrace().toString(), false);
                                }
                            }
                            System.out.println("Thread Unique Id: [" + uniqueId + "] added nrOfObjectVariations [" + nrOfObjectVariations + "]");

                            try {
                                anzoClient.updateRepository();
                            } catch (AnzoException e) {
                                e.printStackTrace();
                                Assert.assertTrue(e.getStackTrace().toString(), false);
                            }
                        }

                        System.out.println("Thread Unique Id: [" + uniqueId + "] added nrOfPredicateVariations * nrOfObjectVariations [" + nrOfPredicateVariations * nrOfObjectVariations + "]");

                        try {
                            anzoClient.updateRepository();
                        } catch (AnzoException e) {
                            e.printStackTrace();
                            Assert.assertTrue(e.getStackTrace().toString(), false);
                        }
                    }

                    System.out.println("Thread Unique Id: [" + uniqueId + "] added nrOfSubjectVariations * nrOfPredicateVariations * nrOfObjectVariations [" + nrOfSubjectVariations * nrOfPredicateVariations * nrOfObjectVariations + "]");

                }
            };

            threadList.add(t);
            t.start();
        }

        int nrOfStillRunningThreads = threadList.size();
        while (nrOfStillRunningThreads > 0) {
            nrOfStillRunningThreads = 0;

            for (Thread thread : threadList) {
                boolean alive = thread.isAlive();
                if (alive) {
                    nrOfStillRunningThreads++;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertTrue(graph.getStatements().size() == nrOfAllAddedStatements);
        /** Is it necessary to close the graph before closing the AnzoClient? */
        graph.close();
        Assert.assertTrue(graph.isClosed() == true);
        anzoClient.close();
        Assert.assertTrue(anzoClient.isConnected() == false);

        /**
         * reconnect the client and graph to see if we still have all the statements we added
         */
        anzoClient = new AnzoClient(getDefaultClientConfiguration());
        Assert.assertNotNull(anzoClient);

        Assert.assertTrue(anzoClient.isConnected() == false);
        anzoClient.connect();
        Assert.assertTrue(anzoClient.isConnected() == true);

        final ClientGraph graphAfterReconnect = anzoClient.getServerGraph(testGraph);
        Assert.assertNotNull(graphAfterReconnect);
        Assert.assertTrue(graphAfterReconnect.getStatements().size() == nrOfAllAddedStatements);

        graphAfterReconnect.clear();
        Assert.assertTrue(graphAfterReconnect.getStatements().size() == 0);

        anzoClient.updateRepository();

        graphAfterReconnect.close();
        Assert.assertTrue(graphAfterReconnect.isClosed() == true);
        anzoClient.close();
        Assert.assertTrue(anzoClient.isConnected() == false);

        /** is the graph still empty ? */
        anzoClient = new AnzoClient(getDefaultClientConfiguration());
        Assert.assertNotNull(anzoClient);

        Assert.assertTrue(anzoClient.isConnected() == false);
        anzoClient.connect();
        Assert.assertTrue(anzoClient.isConnected() == true);

        final ClientGraph graphAfterCleanUp = anzoClient.getServerGraph(testGraph);
        Assert.assertTrue(graphAfterCleanUp.getStatements().size() == 0);
        graphAfterCleanUp.close();
        anzoClient.close();

    }

    /**
     * Test updating repository via server graphs with transactions
     * 
     * @throws AnzoException
     */
    public void testUpdateRepositoryServerGraphMultiStatementsWithTransactionsTest() throws AnzoException {

        Assert.assertNotNull(getDefaultClientConfiguration());

        anzoClient = new AnzoClient(getDefaultClientConfiguration());
        Assert.assertNotNull(anzoClient);

        Assert.assertTrue(anzoClient.isConnected() == false);
        anzoClient.connect();
        Assert.assertTrue(anzoClient.isConnected() == true);

        anzoClient.updateRepository();

        final ClientGraph graph = anzoClient.getServerGraph(testGraph);
        graph.clear();
        Assert.assertTrue(graph.getStatements().size() == 0);
        anzoClient.updateRepository();

        List<Thread> threadList = new ArrayList<Thread>();

        /**
         * Play with these parameters a little bit to make sure that AnzoServer works correct
         */
        int nrOfThreadsToGenerate = NR_OF_THREADS;

        final int nrOfSubjectVariations = NR_OF_SUBJECT_VARIATIONS;
        final int nrOfPredicateVariations = NR_OF_PREDICATE_VARIATIONS;
        final int nrOfObjectVariations = NR_OF_OBJECT_VARIATIONS;

        int nrOfAllAddedStatements = nrOfThreadsToGenerate * nrOfObjectVariations * nrOfPredicateVariations * nrOfSubjectVariations;
        System.out.println("We try to add [" + nrOfAllAddedStatements + "] distinct statements with [" + nrOfThreadsToGenerate + "] threads.");

        for (int i = 0; i < nrOfThreadsToGenerate; i++) {

            Thread t = new Thread() {
                @Override
                public void run() {
                    super.run();

                    /** Calculate unique identifier */
                    String uniqueId = String.valueOf(new Date().getTime() + this.getId());

                    for (int z1 = 0; z1 < nrOfSubjectVariations; z1++) {
                        anzoClient.begin();

                        for (int z2 = 0; z2 < nrOfPredicateVariations; z2++) {
                            anzoClient.begin();

                            for (int z3 = 0; z3 < nrOfObjectVariations; z3++) {
                                anzoClient.begin();

                                final URI s = Constants.valueFactory.createURI("http://test/" + uniqueId + "/" + z1 + "_" + z2 + "_" + z3);
                                final URI p = Constants.valueFactory.createURI("http://test/" + uniqueId + "/" + z1 + "_" + z2 + "_" + z3);
                                final URI o = Constants.valueFactory.createURI("http://test/" + uniqueId + "/" + z1 + "_" + z2 + "_" + z3);

                                final Statement stmt = new org.openanzo.rdf.Statement(s, p, o);
                                graph.add(stmt);
                                anzoClient.commit();
                                try {
                                    anzoClient.updateRepository();
                                } catch (AnzoException e) {
                                    e.printStackTrace();
                                    Assert.assertTrue(e.getStackTrace().toString(), false);
                                }
                            }
                            System.out.println("Thread Unique Id: [" + uniqueId + "] added nrOfObjectVariations [" + nrOfObjectVariations + "]");

                            anzoClient.commit();
                            try {
                                anzoClient.updateRepository();
                            } catch (AnzoException e) {
                                e.printStackTrace();
                                Assert.assertTrue(e.getStackTrace().toString(), false);
                            }

                        }

                        System.out.println("Thread Unique Id: [" + uniqueId + "] added nrOfPredicateVariations * nrOfObjectVariations [" + nrOfPredicateVariations * nrOfObjectVariations + "]");

                        anzoClient.commit();
                        try {
                            anzoClient.updateRepository();
                        } catch (AnzoException e) {
                            e.printStackTrace();
                            Assert.assertTrue(e.getStackTrace().toString(), false);
                        }
                    }

                    System.out.println("Thread Unique Id: [" + uniqueId + "] added nrOfSubjectVariations * nrOfPredicateVariations * nrOfObjectVariations [" + nrOfSubjectVariations * nrOfPredicateVariations * nrOfObjectVariations + "]");

                }
            };

            threadList.add(t);
            t.start();
        }

        int nrOfStillRunningThreads = threadList.size();
        while (nrOfStillRunningThreads > 0) {
            nrOfStillRunningThreads = 0;

            for (Thread thread : threadList) {
                boolean alive = thread.isAlive();
                if (alive) {
                    nrOfStillRunningThreads++;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertTrue(graph.getStatements().size() == nrOfAllAddedStatements);
        /** Is it necessary to close the graph before closing the AnzoClient? */
        graph.close();
        Assert.assertTrue(graph.isClosed() == true);
        anzoClient.close();
        Assert.assertTrue(anzoClient.isConnected() == false);

        /**
         * reconnect the client and graph to see if we still have all the statements we added
         */
        anzoClient = new AnzoClient(getDefaultClientConfiguration());
        Assert.assertNotNull(anzoClient);

        Assert.assertTrue(anzoClient.isConnected() == false);
        anzoClient.connect();
        Assert.assertTrue(anzoClient.isConnected() == true);

        final ClientGraph graphAfterReconnect = anzoClient.getServerGraph(testGraph);
        Assert.assertNotNull(graphAfterReconnect);
        Assert.assertTrue(graphAfterReconnect.getStatements().size() == nrOfAllAddedStatements);

        graphAfterReconnect.clear();
        Assert.assertTrue(graphAfterReconnect.getStatements().size() == 0);

        anzoClient.updateRepository();

        graphAfterReconnect.close();
        Assert.assertTrue(graphAfterReconnect.isClosed() == true);
        anzoClient.close();
        Assert.assertTrue(anzoClient.isConnected() == false);

        /** is the graph still empty ? */
        anzoClient = new AnzoClient(getDefaultClientConfiguration());
        Assert.assertNotNull(anzoClient);

        Assert.assertTrue(anzoClient.isConnected() == false);
        anzoClient.connect();
        Assert.assertTrue(anzoClient.isConnected() == true);

        final ClientGraph graphAfterCleanUp = anzoClient.getServerGraph(testGraph);
        Assert.assertTrue(graphAfterCleanUp.getStatements().size() == 0);
        graphAfterCleanUp.close();
        anzoClient.close();

    }
}
