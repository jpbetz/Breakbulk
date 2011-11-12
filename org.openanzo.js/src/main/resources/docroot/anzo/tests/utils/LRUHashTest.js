/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * Tests for the anzo.utils.LRUHash class.
 *
 * @author Jordi A. Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */

dojo.provide("anzo.tests.utils.LRUHashTest");

dojo.require("anzo.utils.LRUHash");

(function(){

var log = anzo.log.getLogger("anzo.tests.utils.LRUHashTest");

tests.register("anzo.tests.utils.LRUHashTest", [
    function testAddedItemIsRetrieveable() {
        var h = new anzo.utils.LRUHash(function(key) { return key; }, function(a, b) { return a == b; }, 1);
        var oldval = h.set("the-key", "the-val");
        tests.assertTrue(oldval === undefined); // set returns undefined if the value previously didn't exist
        var val = h.get("the-key");
        tests.assertEqual("the-val", val);
        var size = h.size();
        tests.assertEqual(1, size);
    },

    {
        name: "testOldestItemIsRemoved",
        timeout: 10000,
        setUp: function() {
        },
        runTest: function testOldestItemIsRemoved() {
            var d = new doh.Deferred();
            var h = new anzo.utils.LRUHash(function(key) { return key; }, function(a, b) { return a == b; }, 1);
            h.set("the-old-key", "the-old-val");
            setTimeout(d.getTestErrorWrapper(function() { // ensure time passes so that the items don't looks as if they were added at the same time.
                h.set("the-new-key", "the-new-val");

                // This should have overflowed the max size and the older value should have been removed.
                var size = h.size();
                tests.assertEqual(1, size);
                var val = h.get("the-new-key");
                tests.assertEqual("the-new-val", val);
                var oldval = h.get("the-old-key");
                tests.assertTrue(oldval === undefined);

                d.callback(true);
            }), 100);

            return d;
        }
     },

     {
        name: "testRecentlyUsedItemIsKept",
        timeout: 10000,
        setUp: function() {
        },
        runTest: function testRecentlyUsedItemIsKept() {
            var d = new doh.Deferred();
            var h = new anzo.utils.LRUHash(function(key) { return key; }, function(a, b) { return a == b; }, 2);
            h.set("key1", "val1");
            h.set("key2", "val2");

            setTimeout(d.getTestErrorWrapper(function() { // ensure time passes so that the items don't looks as if they were added at the same time.
                h.get("key1"); // makes key2 the least recently used

                h.set("key3", "val3"); // This should knock off key2 since it's the least recently used

                var size = h.size();
                tests.assertEqual(2, size);
                var val1 = h.get("key1");
                tests.assertEqual("val1", val1);
                var val2 = h.get("key2");
                tests.assertTrue(val2 === undefined);
                var val3 = h.get("key3");
                tests.assertEqual("val3", val3);

                d.callback(true);
            }), 100);
            return d;
        }
    },

    function testHashCollisionLookup() {
        // This hash function only looks at the first 3 characters of the string while equality is based on the full string.
        // It's a simple way to create a hash collision.
        var h = new anzo.utils.LRUHash(function(key) { return key.substr(0, 3); }, function(a, b) { return a == b; }, 2);
        h.set("key1", "val1");
        h.set("key2", "val2");
        var val1 = h.get("key1");
        tests.assertEqual("val1", val1);
        var val2 = h.get("key2");
        tests.assertEqual("val2", val2);
        var size = h.size();
        tests.assertEqual(2, size);
    },

     {
        name: "testHashCollisionPurge",
        timeout: 10000,
        setUp: function() {
        },
        runTest: function testHashCollisionPurge() {
            // summary: Tests that the oppropriate item is purged even when there are items that have a hash collision.
            var d = new doh.Deferred();
            // This hash function only looks at the first 3 characters of the string while equality is based on the full string.
            // It's a simple way to create a hash collision.
            var h = new anzo.utils.LRUHash(function(key) { return key.substr(0, 3); }, function(a, b) { return a == b; }, 2);
            h.set("key1", "val1");
            setTimeout(d.getTestErrorWrapper(function() { // ensure time passes so that the items don't looks as if they were added at the same time.
                h.set("key2", "val2");
                h.set("key3", "val3");
                var val1 = h.get("key1");
                tests.assertTrue(val1 === undefined);
                var val2 = h.get("key2");
                tests.assertEqual("val2", val2);
                var val3 = h.get("key3");
                tests.assertEqual("val3", val3);
                var size = h.size();
                tests.assertEqual(2, size);

                d.callback(true);
            }), 100);
            return d;
        }
    },

    function testExisitingItemIsReplaced() {
        // This hash function only looks at the first 3 characters of the string while equality is based on the full string.
        // It's a simple way to create a hash collision.
        var h = new anzo.utils.LRUHash(function(key) { return key.substr(0, 3); }, function(a, b) { return a == b; }, 2);
        h.set("key1", "val1");
        h.set("key2", "val2");
        var oldval2 = h.set("key2", "val2b");
        tests.assertEqual("val2", oldval2);
        var val1 = h.get("key1");
        tests.assertEqual("val1", val1);
        var val2 = h.get("key2");
        tests.assertEqual("val2b", val2);
        var size = h.size();
        tests.assertEqual(2, size);
    },

    function testDefaultIsUnlimitedCapacity() {
        var h = new anzo.utils.LRUHash(function(key) { return key; }, function(a, b) { return a == b; });

        // Reach into private state just to make sure since it's somewhat hard to test if a cache
        // is really 'unlimited'.
        tests.assertEqual(-1, h._maxEntries);

        // Now do some basic testing to at least somewhat make sure it's not purging things.
        h.set("key1", "val1");
        h.set("key2", "val2");
        h.set("key3", "val3");
        h.set("key4", "val4");
        var val1 = h.get("key1");
        tests.assertEqual("val1", val1);
        var val2 = h.get("key2");
        tests.assertEqual("val2", val2);
        var val3 = h.get("key3");
        tests.assertEqual("val3", val3);
        var val4 = h.get("key4");
        tests.assertEqual("val4", val4);
        var size = h.size();
        tests.assertEqual(4, size);

    },

    {
        name: "testRemoval",
        timeout: 10000,
        setUp: function() {
        },
        runTest: function testRemoval() {
            var d = new doh.Deferred();
            var h = new anzo.utils.LRUHash(function(key) { return key; }, function(a, b) { return a == b; }, 2);
            var callbackResults = [ false ];
            h.set("key1", "val1", d.getTestErrorWrapper(function(key, val) {
                tests.assertEqual("key1", key);
                tests.assertEqual("val1", val);
                callbackResults[0] = true;
            }));
            var removedVal = h.remove("key1");
            tests.assertEqual("val1", removedVal);

            var size = h.size();
            tests.assertEqual(0, size);

            tests.assertTrue(h.get("key1") === undefined); // Empty removal should return undefined

            setTimeout(d.getTestErrorWrapper(function() {
                tests.assertTrue(callbackResults[0]);
                d.callback(true);
            }), 100);

            return d;
        }
    },

    {
        name: "testRemovalCallbackOnPurge",
        timeout: 10000,
        setUp: function() {
        },
        runTest: function testRemovalCallbackOnPurge() {
            var d = new doh.Deferred();
            var h = new anzo.utils.LRUHash(function(key) { return key; }, function(a, b) { return a == b; }, 1);
            var callbackResults = [ false ];
            h.set("the-old-key", "the-old-val", d.getTestErrorWrapper(function(key, val) {
                tests.assertEqual("the-old-key", key);
                tests.assertEqual("the-old-val", val);
                callbackResults[0] = true;
            }));

            setTimeout(d.getTestErrorWrapper(function() { // ensure time passes so that the items don't looks as if they were added at the same time.
                h.set("the-new-key", "the-new-val"); // this should cause the other key to be purged

                setTimeout(d.getTestErrorWrapper(function() { // need to check the callback from here since we aren't guaranteed to have the callback fired in this execution stack.
                    tests.assertTrue(callbackResults[0]);
                    d.callback(true);
                }), 100);
            }), 100);

            return d;
        }
    },

    {
        name: "testClearCallback",
        timeout: 10000,
        setUp: function() {
        },
        runTest: function testClearCallback() {
            var d = new doh.Deferred();
            var h = new anzo.utils.LRUHash(function(key) { return key; }, function(a, b) { return a == b; }, 2);
            var callbackResults = [ false, false ];
            h.set("key1", "val1", d.getTestErrorWrapper(function(key, val) {
                tests.assertEqual("key1", key);
                tests.assertEqual("val1", val);
                callbackResults[0] = true;
            }));
            h.set("key2", "val2", d.getTestErrorWrapper(function(key, val) {
                tests.assertEqual("key2", key);
                tests.assertEqual("val2", val);
                callbackResults[1] = true;
            }));

            h.clear();

            setTimeout(d.getTestErrorWrapper(function() {
                tests.assertTrue(callbackResults[0]);
                tests.assertTrue(callbackResults[1]);
                d.callback(true);
            }), 200);

            return d;
        }
    },

    {
        name: "testRemovalCallbackOnPurgeMultipleItems",
        timeout: 10000,
        setUp: function() {
        },
        runTest: function testRemovalCallbackOnPurge() {
            var d = new doh.Deferred();
            var h = new anzo.utils.LRUHash(function(key) { return key; }, function(a, b) { return a == b; }, 8);

            // Reach into private state to ensure validity of this test. The test only is valid if more than one item is purged
            // So we verify that the purgeAmount is what we expect here.
            var expectedPurgeAmount = 2;
            tests.assertEqual(expectedPurgeAmount, h._purgeAmount);

            var callbackResults = [];
            function addEntry(k, v) {
                h.set(k, v, d.getTestErrorWrapper(function(key, val) {
                    tests.assertEqual(k, key);
                    tests.assertEqual(val, val);
                    callbackResults.push(true);
                }));
            }

            // Add enough items to cause a purge
            for (var i = 0; i < 9; i++) {
                addEntry("key" + i, "val" + i);
            }

            setTimeout(d.getTestErrorWrapper(function() {
                tests.assertEqual(expectedPurgeAmount, callbackResults.length);
                tests.assertTrue(dojo.every(callbackResults, function(item) {
                    return item == true;
                }));
                d.callback(true);
            }), 200);

            return d;
        }
     },
     
    function testDefaultHashEqualityAndCapacity() {
        var h = new anzo.utils.LRUHash(); // Don't pass any arguments so that the default values are used
        h.set("the-key", "the-val");
        var val = h.get("the-key");
        tests.assertEqual("the-val", val);
        var size = h.size();
        tests.assertEqual(1, size);
        var capacity = h.capacity();
        tests.assertEqual(-1, capacity); // default is unlimited capacity
    }
]);

})();
