/*******************************************************************************
 * Copyright (c) 2007-2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Created by:  Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * Tests for the anzo.utils.Set class.
 * 
 * @author Jordi A. Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>) 
 */

dojo.provide("anzo.tests.utils.JSUtilTest");

dojo.require("anzo.utils.JSUtil");

tests.register("anzo.tests.utils.JSUtilTest", 
    [
        
//		function testAddAllFromArrayAndRemoveAllFromArray() {
//			var obj = { foo: "bar" };
//			var obj2 = { prop: "another object"};
//			var arr = [123, "my string", obj, obj2];
//			var arrToAdd = [456, "another string"];
//			anzo.utils.addAllToArray(arr, arrToAdd);
//			tests.assertEqual(arr[4], 456);
//			tests.assertEqual(arr[5], "another string");
//			var arrToRemove = [123, "not in the array", { prop: "another object" }, obj ];
//			anzo.utils.removeAllFromArray(arr, arrToRemove);
//			tests.assertEqual(arr[0], "my string");
//			tests.assertEqual(arr[1], obj2); // This object doesn't get removed even though it looks the same in arrToRemove because it's not actually the same object in memory.
//			tests.assertEqual(arr[2], 456);
//			tests.assertEqual(arr[3], "another string");
//			tests.assertEqual(arr.length, 4);		
//		},
//		
//		function testRemoveAndAddAndIndexOfSupportEqualsMethod() {
//			// The xxxFromArray and indexOf methods support using an 'equals' method on objects
//			// to determine if the objects are removed or added.
//			function MyObjectWithEquals(a, b) {
//				this.propertyA = a;
//				this.propertyB = b;
//			}
//			MyObjectWithEquals.prototype = {
//				propertyA : null,
//				propertyB : null,
//				equals : function (o) {
//					// propertyB is ignored by this equals implementation  
//					return (o instanceof MyObjectWithEquals) && (this.propertyA == o.propertyA);
//				}
//			}
//			var obj = new MyObjectWithEquals("obj", "ignored");
//			var obj2 = new MyObjectWithEquals("obj", "different but ignored");
//			tests.assertTrue(obj.equals(obj2)); // Little bit of testing the test.
//			
//			// Test addAll/removeAll
//			var arr = [ obj, 123, obj2];
//			anzo.utils.addAllToArray(arr, [new MyObjectWithEquals("different obj", "whatever"), 456]);
//			anzo.utils.removeAllFromArray(arr, [new MyObjectWithEquals("obj", "still ignored"), 789]);
//			tests.assertEqual(arr[0], 123);
//			tests.assertTrue(arr[1].equals(new MyObjectWithEquals("different obj", "something ignored")));
//			tests.assertEqual(arr[2], 456);
//			tests.assertEqual(arr.length, 3);
//			
//			// Just test a simple remove
//			var arr2 = [ obj, 789, obj2 ];
//			anzo.utils.removeFromArray(arr2, new MyObjectWithEquals("obj", "still ignored"));
//			tests.assertEqual(arr2[0], 789);
//			tests.assertEqual(arr2.length, 1);
//			
//			var indexOfArr = [ 123, obj, obj2, new MyObjectWithEquals("different obj", "something ignored")];
//			tests.assertEqual(anzo.utils.indexOf(indexOfArr, new MyObjectWithEquals("obj", "ignored")), 1);
//			tests.assertEqual(anzo.utils.indexOf(indexOfArr, new MyObjectWithEquals("obj", "ignored"), 2), 2);
//			tests.assertEqual(anzo.utils.indexOf(indexOfArr, new MyObjectWithEquals("obj", "ignored"), 0, true), 2);
//			tests.assertEqual(anzo.utils.indexOf(indexOfArr, new MyObjectWithEquals("obj", "ignored"), 1, true), 1);
//		},
        
        function testNewGuid() {
            var guid1 = anzo.utils.newGuid();
            var guidRegexp = /[0-9a-fA-F]{8}\-[0-9a-fA-F]{4}\-[0-9a-fA-F]{4}\-[0-9a-fA-F]{4}\-[0-9a-fA-F]{12}/;
            tests.assertTrue(guidRegexp.test(guid1));
            var guid2 = anzo.utils.newGuid();
            tests.assertTrue(guidRegexp.test(guid2));
            tests.assertFalse(guid1 == guid2);
        },
        
        function testKeysAndValues() {
            var innerObj = { inner: "innerVal" };
            var obj = { foo: "bar", prop: 234, another: innerObj };
            var keys = anzo.utils.keys(obj);
            tests.assertEqual(keys.length, 3);
            // Order in the resulting array isn't guaranteed so we use indexOf to look in it
            tests.assertTrue(dojo.indexOf(keys, "foo") != -1);
            tests.assertTrue(dojo.indexOf(keys, "prop") != -1);
            tests.assertTrue(dojo.indexOf(keys, "another") != -1);
            
            var values = anzo.utils.values(obj);
            tests.assertEqual(values.length, 3);
            tests.assertTrue(dojo.indexOf(values, "bar") != -1);
            tests.assertTrue(dojo.indexOf(values, 234) != -1);
            tests.assertTrue(dojo.indexOf(values, innerObj) != -1);
        },
        
        function testArrayIntersection() {
            var array1 = [1, 2, 3, 4];
            var array2 = [3, 4, 5, 6];
            var intersection1 = anzo.utils.arrayIntersection(array1, array2);
            tests.assertTrue(intersection1[0] == 3);
            tests.assertTrue(intersection1[1] == 4);
        },

        function testDataFormatPlacesLeadingZeroes() {
            // summary: Chose a date that has lots of leading zeroes in the various fields to make sure
            //  they are properly added by the date formatting function.
            var date = new Date(2008, 0, 2, 9, 1, 2); // Jan 2, 2008 9:01:02 AM
            var expectedStr = "2008-01-02T09:01:02";
            var str = anzo.utils.formatDate(date);
            tests.assertEqual(expectedStr, str);
        },
        
        function testIsUri() {
            tests.assertTrue(anzo.utils.isURI("http://example.org"));
            tests.assertTrue(anzo.utils.isURI("http://example.org:8080?foo=test&bar=maybe"));
            tests.assertTrue(anzo.utils.isURI("https://example.com/whatever#bar"));
            tests.assertTrue(anzo.utils.isURI("ftp://user@host.example.com/path"));
            tests.assertTrue(anzo.utils.isURI("ftp://user:password@host.example.com/path"));
            tests.assertTrue(anzo.utils.isURI("urn:lsid:ipni.org:names:30000959-2"));
            tests.assertTrue(anzo.utils.isURI("URN:ISBN:0-395-36341-1"));
            tests.assertTrue(anzo.utils.isURI("http://example"));
            tests.assertTrue(anzo.utils.isURI("file:///example"));
            tests.assertTrue(anzo.utils.isURI("file://"));
            tests.assertTrue(anzo.utils.isURI("ftp://"));
            tests.assertTrue(anzo.utils.isURI("unknown://example.com/"));
            tests.assertTrue(anzo.utils.isURI("ftp://ftp.is.co.za/rfc/rfc1808.txt"));
            tests.assertTrue(anzo.utils.isURI("http://www.ietf.org/rfc/rfc2396.txt"));
            tests.assertTrue(anzo.utils.isURI("ldap://[2001:db8::7]/c=GB?objectClass?one"));
            tests.assertTrue(anzo.utils.isURI("ldap://cambridgesemantics.com/foaf/groups#cn=Engineering,ou=groups,dc=cambridgesemantics,dc=com"));
            
            tests.assertTrue(anzo.utils.isURI("mailto:John.Doe@example.com"));
            tests.assertTrue(anzo.utils.isURI("news:comp.infosystems.www.servers.unix"));
            tests.assertTrue(anzo.utils.isURI("tel:+1-816-555-1212"));
            tests.assertTrue(anzo.utils.isURI("telnet://192.0.2.16:80/"));
            tests.assertTrue(anzo.utils.isURI("urn:oasis:names:specification:docbook:dtd:xml:4.1.2"));
            tests.assertTrue(anzo.utils.isURI("ldap://uid=sysadmin,ou=users,dc=openanzo,dc=org"));
            tests.assertTrue(anzo.utils.isURI("http://www.openanzo.org/ontologies/StatAb#"));
            
            // Relative URLs don't match
            tests.assertFalse(anzo.utils.isURI(""));
            tests.assertFalse(anzo.utils.isURI("aString"));
            tests.assertFalse(anzo.utils.isURI(".."));
            tests.assertFalse(anzo.utils.isURI("../foo.css"));
            tests.assertFalse(anzo.utils.isURI("//g"));
            tests.assertFalse(anzo.utils.isURI("g"));
            tests.assertFalse(anzo.utils.isURI("./g"));
            tests.assertFalse(anzo.utils.isURI("g/"));
            tests.assertFalse(anzo.utils.isURI("/g"));
            tests.assertFalse(anzo.utils.isURI("//g"));
            tests.assertFalse(anzo.utils.isURI("?y"));
            tests.assertFalse(anzo.utils.isURI("g?y"));
            tests.assertFalse(anzo.utils.isURI("#s"));
            tests.assertFalse(anzo.utils.isURI("g#s"));
            tests.assertFalse(anzo.utils.isURI("g?y#s"));
            tests.assertFalse(anzo.utils.isURI(";x"));
            tests.assertFalse(anzo.utils.isURI("g;x"));
            tests.assertFalse(anzo.utils.isURI("g;x?y#s"));
            tests.assertFalse(anzo.utils.isURI("##3"));
            tests.assertFalse(anzo.utils.isURI(5)); // toString called on parameter
            
            tests.assertFalse(anzo.utils.isURI("urn:")); // incomplete...need something after the scheme
            tests.assertFalse(anzo.utils.isURI("urns store remains."));
            tests.assertFalse(anzo.utils.isURI(["http://example.com"])); // arrays toString with one element does not work
            tests.assertFalse(anzo.utils.isURI(["http://example.com/", 123]));
            tests.assertFalse(anzo.utils.isURI(function () { return "http://example.org"; }));
            tests.assertFalse(anzo.utils.isURI(null));
            tests.assertFalse(anzo.utils.isURI(undefined));
        },
        
        function testSpareArrayFindIgnoresArrayPrototypeMembers() {
            // summary: Iterating through arrays with the for...in loop is subject to problems if the Array.prototype is modified.
            //   make sure that we've protected ourselves from such issues.  
            Array.prototype[4] = "find me";
            try {
                var array = [];
                array.push("foo");
                array.push("find me");
                array.push("bar");
                delete array[1];
                tests.assertTrue(anzo.utils._sparseArrayFind(array, "find me") == -1);
            } finally {
                // Make sure to restore the Array.prototype
                delete Array.prototype[4];
            }
        },

        function testSpareArrayFindLocatesItems() {
            // summary: Look for an item inside a spare array. 
            var array = [];
            array.push("foo");
            array.push("find me");
            array.push("bar");
            delete array[0];
            tests.assertTrue(anzo.utils._sparseArrayFind(array, "find me") == 1);
        },
        
        function testSpareArrayFindReturnsNegativeOneForMissingItems() {
            // summary: -1 should be returned for missing items
            var array = [];
            array.push("foo");
            array.push("find me");
            array.push("bar");
            delete array[1];
            tests.assertTrue(anzo.utils._sparseArrayFind(array, "find me") == -1);
        },

        function testSpareArrayForEachIgnoresArrayPrototypeMembers() {
            // summary: Iterating through arrays with the for...in loop is subject to problems if the Array.prototype is modified.
            //   make sure that we've protected ourselves from such issues.
            Array.prototype[4] = "inside the prototype";
            try {
                var array = [];
                array.push("foo");
                array.push("find me");
                array.push("bar");
                delete array[0];
                
                var sawFooCount = 0;
                var sawFindMeCount = 0;
                var sawBarCount = 0;
                var sawAnythingElseCount = 0;
                anzo.utils._sparseArrayForEach(array, function sparseArrayForEachCallback(item) {
                    if (item == "foo") {
                        sawFooCount++;
                    } else if (item == "find me") {
                        sawFindMeCount++;
                    } else if (item == "bar") {
                        sawBarCount++;
                    } else {
                        sawAnythingElseCount++;
                    }
                });
                tests.assertEqual(0, sawFooCount);
                tests.assertEqual(1, sawFindMeCount);
                tests.assertEqual(1, sawBarCount);
                tests.assertEqual(0, sawAnythingElseCount);
            } finally {
                // Make sure to restore the Array.prototype
                delete Array.prototype[4];
            }
        },

        function testToIsoString() {
            // summary: Tests the output of Date objects into string in the XML Schema built-in type formats
            
            var _ = function(n){ return (n < 10) ? "0" + n : n; };
            var localTimezoneOffset = (new Date()).getTimezoneOffset();
            var localTimeZoneOffsetString = localTimezoneOffset == 0 ? "Z" : ((localTimezoneOffset > 0 ? "-" : "+") + _(Math.floor(Math.abs(localTimezoneOffset)/60)) + ":" + _(Math.abs(localTimezoneOffset)%60));

            var dateTests = [
                // xsd:dateTime
                { date: new Date(Date.UTC(2008, 1, 22, 8, 23, 45, 541)), options: undefined, expected: "2008-02-22T08:23:45.541Z" },
                { date: new Date(Date.UTC(2008, 1, 22, 8, 3, 5, 41)), options: undefined, expected: "2008-02-22T08:03:05.041Z" },
                { date: new Date(Date.UTC(2008, 1, 3, 8, 3, 5, 1)), options: undefined, expected: "2008-02-03T08:03:05.001Z" },
                { date: new Date(Date.UTC(2008, 1, 3, 8, 3, 5)), options: undefined, expected: "2008-02-03T08:03:05.000Z" },
                { date: new Date(Date.UTC(2008, 1, 22, 18, 23, 45, 541)), options: { format: "dateTime", local: false, hideMilliseconds: false, hideTimezone: true }, expected: "2008-02-22T18:23:45.541" },
                { date: new Date(Date.UTC(2008, 1, 22, 18, 23, 45, 541)), options: { local: false, hideMilliseconds: false, hideTimezone: true }, expected: "2008-02-22T18:23:45.541" },
                { date: new Date(Date.UTC(2008, 1, 22, 18, 23, 45, 541)), options: { hideMilliseconds: false, hideTimezone: true }, expected: "2008-02-22T18:23:45.541" },
                { date: new Date(Date.UTC(2008, 1, 22, 18, 23, 45, 541)), options: { hideTimezone: true }, expected: "2008-02-22T18:23:45.541" },
                { date: new Date(Date.UTC(2008, 1, 22, 18, 23, 45, 541)), options: {}, expected: "2008-02-22T18:23:45.541Z" },
                { date: new Date(2008, 1, 22, 18, 23, 45, 541), options: { local: true, hideTimezone: true }, expected: "2008-02-22T18:23:45.541" },
                { date: new Date(2008, 1, 22, 18, 23, 45, 541), options: { local: true, hideMilliseconds: true, hideTimezone: true }, expected: "2008-02-22T18:23:45" },
                { date: new Date(2008, 1, 22, 18, 23, 45, 541), options: { local: true }, expected: "2008-02-22T18:23:45.541" + localTimeZoneOffsetString },
                { date: new Date(2008, 1, 22, 18, 23, 45, 541), options: { local: true, hideMilliseconds: true }, expected: "2008-02-22T18:23:45" + localTimeZoneOffsetString },

                // xsd:date
                { date: new Date(Date.UTC(2008, 1, 22, 8, 23, 45, 541)), options: { format: "date" }, expected: "2008-02-22Z" },
                { date: new Date(Date.UTC(2008, 1, 22, 8, 23, 45, 541)), options: { format: "date", hideTimezone: true }, expected: "2008-02-22" },
                { date: new Date(2008, 1, 22, 8, 23, 45, 541), options: { format: "date", local: true, hideTimezone: true }, expected: "2008-02-22" },
                { date: new Date(2008, 1, 22, 8, 23, 45, 541), options: { format: "date", local: true }, expected: "2008-02-22" + localTimeZoneOffsetString },

                // xsd:time
                { date: new Date(Date.UTC(2008, 1, 22, 8, 23, 45, 541)), options: { format: "time" }, expected: "08:23:45.541Z" },
                { date: new Date(Date.UTC(2008, 1, 22, 8, 23, 45, 541)), options: { format: "time", hideTimezone: true }, expected: "08:23:45.541" },
                { date: new Date(Date.UTC(2008, 1, 22, 8, 23, 45, 541)), options: { format: "time", hideMilliseconds: true }, expected: "08:23:45Z" },
                { date: new Date(Date.UTC(2008, 1, 22, 8, 23, 45, 541)), options: { format: "time", hideMilliseconds: true, hideTimezone: true }, expected: "08:23:45" },
                { date: new Date(2008, 1, 22, 8, 23, 45, 541), options: { format: "time", local: true, hideTimezone: true }, expected: "08:23:45.541" },
                { date: new Date(2008, 1, 22, 8, 23, 45, 541), options: { format: "time", local: true }, expected: "08:23:45.541" + localTimeZoneOffsetString },
                { date: new Date(2008, 1, 22, 8, 23, 45, 541), options: { format: "time", local: true, hideMilliseconds: true, hideTimezone: true }, expected: "08:23:45" },
                { date: new Date(2008, 1, 22, 8, 23, 45, 541), options: { format: "time", local: true, hideMilliseconds: true }, expected: "08:23:45" + localTimeZoneOffsetString },

                // xsd:gYearMonth
                { date: new Date(Date.UTC(2008, 1, 22, 8, 23, 45, 541)), options: { format: "gYearMonth" }, expected: "2008-02Z" },
                { date: new Date(Date.UTC(2008, 1, 22, 8, 23, 45, 541)), options: { format: "gYearMonth", hideTimezone: true }, expected: "2008-02" },
                { date: new Date(2008, 1, 22, 8, 23, 45, 541), options: { format: "gYearMonth", local: true, hideTimezone: true }, expected: "2008-02" },
                { date: new Date(2008, 1, 22, 8, 23, 45, 541), options: { format: "gYearMonth", local: true }, expected: "2008-02" + localTimeZoneOffsetString },

                // xsd:gMonthDay
                { date: new Date(Date.UTC(2008, 1, 22, 8, 23, 45, 541)), options: { format: "gMonthDay" }, expected: "--02-22Z" },
                { date: new Date(Date.UTC(2008, 1, 22, 8, 23, 45, 541)), options: { format: "gMonthDay", hideTimezone: true }, expected: "--02-22" },
                { date: new Date(2008, 1, 22, 8, 23, 45, 541), options: { format: "gMonthDay", local: true, hideTimezone: true }, expected: "--02-22" },
                { date: new Date(2008, 1, 22, 8, 23, 45, 541), options: { format: "gMonthDay", local: true }, expected: "--02-22" + localTimeZoneOffsetString },

                // xsd:gYear
                { date: new Date(Date.UTC(2008, 1, 22, 8, 23, 45, 541)), options: { format: "gYear" }, expected: "2008Z" },
                { date: new Date(Date.UTC(2008, 1, 22, 8, 23, 45, 541)), options: { format: "gYear", hideTimezone: true }, expected: "2008" },
                { date: new Date(2008, 1, 22, 8, 23, 45, 541), options: { format: "gYear", local: true, hideTimezone: true }, expected: "2008" },
                { date: new Date(2008, 1, 22, 8, 23, 45, 541), options: { format: "gYear", local: true }, expected: "2008" + localTimeZoneOffsetString },

                // xsd:gMonth
                { date: new Date(Date.UTC(2008, 1, 22, 8, 23, 45, 541)), options: { format: "gMonth" }, expected: "--02Z" },
                { date: new Date(Date.UTC(2008, 1, 22, 8, 23, 45, 541)), options: { format: "gMonth", hideTimezone: true }, expected: "--02" },
                { date: new Date(2008, 1, 22, 8, 23, 45, 541), options: { format: "gMonth", local: true, hideTimezone: true }, expected: "--02" },
                { date: new Date(2008, 1, 22, 8, 23, 45, 541), options: { format: "gMonth", local: true }, expected: "--02" + localTimeZoneOffsetString },

                // xsd:gDay
                { date: new Date(Date.UTC(2008, 1, 22, 8, 23, 45, 541)), options: { format: "gDay" }, expected: "---22Z" },
                { date: new Date(Date.UTC(2008, 1, 22, 8, 23, 45, 541)), options: { format: "gDay", hideTimezone: true }, expected: "---22" },
                { date: new Date(2008, 1, 22, 8, 23, 45, 541), options: { format: "gDay", local: true, hideTimezone: true }, expected: "---22" },
                { date: new Date(2008, 1, 22, 8, 23, 45, 541), options: { format: "gDay", local: true }, expected: "---22" + localTimeZoneOffsetString }
            ];
            
            for (var i = 0; i < dateTests.length; i++) {
                var currentTest = dateTests[i];
                var result = anzo.utils.toISOString(currentTest.date, currentTest.options);
                tests.assertEqual(currentTest.expected, result);
            }
        }
    ]
);
