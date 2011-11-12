/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * Created on:  Oct 10, 2007
 * Revision:
 $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * Tests for the anzo.utils.Set class.
 * 
 * @author Jordi A. Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>) 
 */

dojo.provide("anzo.tests.utils.SetTest");

dojo.require("anzo.utils.Set");

tests.register("anzo.tests.utils.SetTest", 
	[
		
		function testAddAndContainsAndRemoveForNumbers() {
			// Numbers work intutitively since their toString simply converts them to
			// a string representation.
		    var set = new anzo.utils.Set();
			set.add(123);
			tests.assertEqual(set.size(), 1);
			tests.assertTrue(set.contains(123));
			tests.assertFalse(set.contains(456));
			set.remove(123);
			tests.assertFalse(set.contains(123));
			tests.assertEqual(set.size(), 0);
		},
		
		function testAddAndContainsAndRemoveForStrings() {
			// Strings work intuitively
		    var set = new anzo.utils.Set();
			var str = "mystring"; 
			set.add(str);
			tests.assertEqual(set.size(), 1);
			tests.assertTrue(set.contains(str));
			tests.assertTrue(set.contains("mystring")); // constant should be the same as the variable
			tests.assertFalse(set.contains("another string"));
			set.remove(str);
			tests.assertFalse(set.contains(str));
			tests.assertEqual(set.size(), 0);
		},
		
		function testAddAndContainsAndRemoveForArray() {		
			// Now an array.  No dictionaryKey function defined so it uses the Array.toString
			// implementation to determine equality.
		    var set = new anzo.utils.Set();
			var arr = [2, "str", [1.3, 3.14] ];
			set.add(arr);
			tests.assertTrue(set.contains(arr));
			tests.assertEqual(set.size(), 1);
			tests.assertTrue(set.contains([2, "str", [1.3, 3.14] ]));
			tests.assertFalse(set.contains([2, "str", [9.999999, 3.14] ]));
			set.remove(arr);
			tests.assertFalse(set.contains(arr));
			tests.assertEqual(set.size(), 0);
		},
		
		function testAddAndContainsAndRemoveForPlainObject() {
			// Now an object without a dictionaryKey function.
			// This means that the object's toString function is used for comparison so
			// all objects will look the same unless they either implement 
			// dictionaryKey or toString specially. That's because most JavaScript engines implemenat
			// Object toString as outputting "[object Object]".
		    var set = new anzo.utils.Set();
			var obj = new Object();
			obj.propertyA = 123;
			obj.propertyB = [15, 16, 17];
			var obj2 = new Object();
			obj2.propertyA = 123;
			obj2.propertyB = [99, 99, 99];
			set.add(obj);
			tests.assertEqual(set.size(), 1);
			tests.assertTrue(set.contains(obj));
			tests.assertTrue(set.contains(obj2)); // Remember, all plain objects look the same unless they change toString or dictionaryKey
			set.remove(obj);
			tests.assertFalse(set.contains(obj));
			tests.assertEqual(set.size(), 0);
		},
		
		function testAddAndContainsAndRemoveUseDictionaryKeyFunction() {
			// If an object has a dictionaryKey method, then the Set
			// should be using that to check equality.
		    var set = new anzo.utils.Set();
			
			function dictionaryKeyObject(propA, propB) { 
				if (propA) this.propertyA = propA;
				if (propB) this.propertyB = propB;
			};
			dictionaryKeyObject.prototype = {
				propertyA : null,
				propertyB : null,
				dictionaryKey : function () {
					return "" + this.propertyA + this.propertyB;
				}
			}
			var hashObj = new dictionaryKeyObject(456, "whatever");
			var hashObj2 = new dictionaryKeyObject(456, "something else");
			set.add(hashObj);
			tests.assertTrue(set.contains(hashObj));
			tests.assertEqual(set.size(), 1);
			tests.assertFalse(set.contains(hashObj2));
			set.add(hashObj2);
			tests.assertTrue(set.contains(hashObj2));
			tests.assertEqual(set.size(), 2);
			set.remove(hashObj2);
			tests.assertFalse(set.contains(hashObj2));
			tests.assertTrue(set.contains(hashObj));
			tests.assertEqual(set.size(), 1);
			set.remove(hashObj);
			tests.assertFalse(set.contains(hashObj));
			tests.assertEqual(set.size(), 0);
		},
		
		function testNullIsIgnored() {
			var set = new anzo.utils.Set();
			tests.assertFalse(set.contains(null));
			set.add(null);
			tests.assertFalse(set.contains(null));
			tests.assertEqual(set.size(), 0);
			set.remove(null); // shouldn't cause an exception or anything
			tests.assertFalse(set.contains(null));
			tests.assertEqual(set.size(), 0);
		},
		
		function testUndefinedIsIgnored() {
			var set = new anzo.utils.Set();
			tests.assertFalse(set.contains(undefined));
			set.add(undefined);
			tests.assertFalse(set.contains(undefined));
			tests.assertEqual(set.size(), 0);
			set.remove(undefined); // shouldn't cause an exception or anything
			tests.assertFalse(set.contains(undefined));
			tests.assertEqual(set.size(), 0);
		},
		
		function testClear() {
			var set = new anzo.utils.Set();
			set.add("a string");
			set.add(123);
			set.add({ anObject: "whatever" });
			tests.assertEqual(set.size(), 3);
			set.clear();
			tests.assertEqual(set.size(), 0);
			tests.assertFalse(set.contains("a string"));
			tests.assertFalse(set.contains(123));
			tests.assertFalse(set.contains({ anObject: "whatever" }));
		},
		
		function testForEach() {
		    
		    var set = new anzo.utils.Set();
		    set.add('a');
		    set.add('b');
		    set.add('c');
		    
		    var count = 0;
		    set.forEach(function(item) {
		        count++;
		        tests.assertTrue(item == 'a' || item == 'b' || item == 'c')
		    });
		    tests.assertTrue(count == 3);
		    
		},
		
		function testToArray() {
			var set = new anzo.utils.Set();
			set.add("a string");
			set.add(123);
			var obj1 = { anObject: "whatever" };
			set.add(obj1);
			var obj = { anObject: "something else" };
			set.add(obj); // This should be the same "toString" and so should just overwrite the old object. 
			tests.assertEqual(set.size(), 3);
			var arr = set.toArray();
			tests.assertEqual(arr.length, 3);
			// Order in resulting array isn't guaranteed so we use indexOf to look in the results.
			tests.assertTrue(dojo.indexOf(arr, "a string") != -1);
			tests.assertTrue(dojo.indexOf(arr, 123) != -1);
			tests.assertTrue(dojo.indexOf(arr, obj) != -1);
		},
		
		function testAddAllAndRemoveAll() {
			var set = new anzo.utils.Set();
			var obj = { anObject: "whatever" };
			var arr = [123, "a string", obj, null];
			arr[9] = true; // expand the array
			set.addAll(arr);
			tests.assertEqual(set.size(), 4); // undefined and null elements in the array are ignored 
			tests.assertTrue(set.contains(123));
			tests.assertTrue(set.contains("a string"));
			tests.assertTrue(set.contains(obj));
			tests.assertTrue(set.contains(true));
			tests.assertFalse(set.contains(undefined)); // undefined elements are ignored
			tests.assertFalse(set.contains(null)); // null elements are ignored
			set.removeAll(arr);
			tests.assertEqual(set.size(), 0);
			
			// Check the only matching things are removed
			set.add("another string");
			set.add(456);
			tests.assertEqual(set.size(), 2);
			var arr2 = ["another string", "something else", 123]
			set.removeAll(arr2);
			tests.assertEqual(set.size(), 1);
			tests.assertTrue(set.contains(456));
			
			// adding a set
			var set1 = new anzo.utils.Set(['1', '2', '3']);
			
			var set2 = new anzo.utils.Set();
			set2.addAll(set1);
			tests.assertTrue(set2.contains('1'));
			tests.assertTrue(set2.contains('2'));
			tests.assertTrue(set2.contains('3'));
			tests.assertFalse(set2.contains('4'));
			
			var set11 = new anzo.utils.Set(['1', '2', '3']);
			var set22 = new anzo.utils.Set();
			set22.addAll(set11);
			tests.assertTrue(set22.contains('1'));
			tests.assertTrue(set22.contains('2'));
			tests.assertTrue(set22.contains('3'));
			tests.assertFalse(set22.contains('4'));
		}

	]
);
