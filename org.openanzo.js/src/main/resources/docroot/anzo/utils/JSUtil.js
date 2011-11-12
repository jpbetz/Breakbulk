/*******************************************************************************
 * Copyright (c) 2007-2010 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contains some code based on code from the Dojo foundation:
   The anzo.utils.toISOString function is based on the dojo.date.stamp.toISOString function but modified and expanded to support
   the XML Schema built-in date and time-related formats. The portions of the Dojo code is used by permission under 
   the "new" BSD license and is copyright as follows:
   Copyright (c) 2005-2009, The Dojo Foundation
   All rights reserved.
 
   Redistribution and use in source and binary forms, with or without
   modification, are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice, this
      list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright notice,
      this list of conditions and the following disclaimer in the documentation
      and/or other materials provided with the distribution.
    * Neither the name of the Dojo Foundation nor the names of its contributors
      may be used to endorse or promote products derived from this software
      without specific prior written permission.

   THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
   ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
   WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
   DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
   FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
   DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
   SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
   CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
   OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
   OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>)
 * @author Jordi A. Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>)
 */

dojo.provide("anzo.utils.JSUtil");

// dojo
dojo.require("dojo.date.stamp");
dojo.require("dojox.uuid.generateRandomUuid");

// anzo
dojo.require("anzo.utils.Set");
dojo.require("anzo.log");

(function() {
var log = anzo.log.getLogger("anzo.utils");

// Some local helper functions
function _zeroPrefix(n) {
    return (n < 10) ? "0" + n : n;
};
var _dateFormats = {
    "dateTime": { y: true, m: true, d: true, t: true },
    "date": { y: true, m: true, d: true, t: false },
    "time": { y: false, m: false, d: false, t: true },
    "gYearMonth": { y: true, m: true, d: false, t: false },
    "gMonthDay": { y: false, m: true, d: true, t: false },
    "gYear": { y: true, m: false, d: false, t: false },
    "gMonth": { y: false, m: true, d: false, t: false },
    "gDay": { y: false, m: false, d: true, t: false }
};

// anzo.utils functions
dojo.mixin(anzo.utils, {

    escapeString : function(/*String*/str){
        //summary:
        //		Adds escape sequences for non-visual characters, double quote and
        //		backslash and surrounds with double quotes to form a valid string
        //		literal.
       return dojo._escapeString(str);
    },

    removeIndex : function(array, from, to) {
      // summary: Removes the elements in the given array from the given index to the corresponding index.
      var rest = array.slice((to || from) + 1 || array.length);
      array.length = from < 0 ? array.length + from : from;
      return array.push.apply(array, rest);
    },

    addToArray : function(elt, dst, compfunc) {
        // depricated: use anzo.utils.Set's add method
        var found = false;
        for (var i=0;i<dst.length;i++) {
            if ((compfunc && compfunc(dst[i],elt) == 0) || dst[i] == elt) {
                found = true;
                break;
            }
        }
        if (!found) {
            dst.push(elt);
        }
    },

    removeFromArray : function(elt, dst, compfunc) {
        for (var i=0;i<dst.length;i++) {
            if ((compfunc && compfunc(dst[i],elt) == 0) || dst[i] == elt) {
                dst.splice(i,1);
                break;
            }
        }
    },

    arrayContains : function(elt, dst, compfunc) {
        var found = false;
        for (var i=0;i<dst.length;i++) {
            if ((compfunc && compfunc(dst[i],elt) == 0) || dst[i] == elt) {
                found = true;
                break;
            }
        }
        return found;
    },

    arrayCompare : function(a1, a2) {
        for(var i = 0; i < a1.length; i++) {
            if(a2[i] != a1[i])
               return false;
        }
        return true;
    },


    binarySearch : function(a,key,compfunc) {

        // description:
        //     Based on binary search implementation from Sun JDK 1.5

        if (!compfunc) {
            compfunc = function(a, b) {
                if (a > b)
                    return 1;
                if (a < b)
                    return -1;
                return 0;
            };
        }
        var low = 0;
        var high = a.length - 1;
        while (low <= high) {
            var mid = Math.floor((low + high) / 2);
            var val = a[mid];
            var comp = compfunc(key,val);
            if (comp == -1) {
                high = mid - 1;
            } else if (comp == 1) {
                low = mid + 1;
            } else
                return mid;
        }
        return -(low + 1); // insertion point
    },

    incrementString : function(str) {
        var cind = str.length - 1;
        var c = str.charCodeAt(cind);
        var inc = "";
        if  (c == 57)
            inc = String.fromCharCode(97);
        else
            inc = String.fromCharCode(c+1);
        var newstr = str.substring(0,cind);
        return newstr + inc;
    },

    randomInt : function(length) {
        var ran_unrounded = Math.random();
        for (var i=0;i<length;i++)
            ran_unrounded *= 10;
        return Math.floor(ran_unrounded);
    },

    formatDate : function(date) {
        var str = "";
        var year = date.getFullYear();
        str += year;
        str += "-";
        var month = date.getMonth() + 1;
        if (month < 10) {
            month = "0" + month;
        }
        str += month;
        str += "-";
        var day = date.getDate();
        if (day < 10) {
            day = "0" + day;
        }
        str += day;
        str += "T";
        var hours = date.getHours();
        if (hours < 10) {
            hours = "0" + hours;
        }
        str += hours;
        str += ":";
        var mins = date.getMinutes();
        if (mins < 10) {
            mins = "0" + mins;
        }
        str += mins;
        str += ":";
        var secs = date.getSeconds();
        if (secs < 10) {
            secs = "0" + secs;
        }
        str += secs;
        return str;
    },


    newGuid : function() {
        // summary:
        //		This function generates random UUIDs, meaning "version 4" UUIDs.
        return dojox.uuid.generateRandomUuid();
    },

    isURI : function(/*Object*/obj) {

        // summary:
        //      Checks if the given parameter's string representation takes the form of an absolute URI.
        //      It converts the object into a string using its toString method.
        // description:
        //      The method matches URIs as per http://www.ietf.org/rfc/rfc3986.txt except it is only
        //      looking for absolute URIs.
        //
        //      Examples:
        //      isURI("http://example.org:8080")) == true
        //      isURI("ftp://user:password@host.example.com/path")) == true
        //      isURI("urn:lsid:example.org:names:30000959-2")) == true
        //      isURI("URN:ISBN:0-395-36341-1")) == true
        //      isURI("mailto:John.Doe@example.com")) == true
        //      isURI("urn:oasis:names:specification:docbook:dtd:xml:4.1.2")) == true
        //      isURI("ldap:///uid=sysadmin,ou=users,dc=openanzo,dc=org") == true
        //
        //      isURI("dc:title")) == true // Be Careful. This is a QName but also happens to match absolute URI syntax.
        //
        //      isURI("aString")) == false
        //      isURI("..")) == false
        //      isURI("../foo.css")) == false
        //      isURI(null)) == false
        //      isURI(undefined)) == false
        //
        //      Note that QName strings like "dc:title" will return true in this function since they
        //      happen to also match absolute URI syntax.
        // obj : Object
        //  The object whose string representation will be checked for being URI-like.  Note that arrays are not allowed.

        if(obj == null || dojo.isArray(obj))
            return false;

        var s = obj.toString();

        // Regular expression based on http://www.ietf.org/rfc/rfc2396.txt
        // Obtained from http://aspn.activestate.com/ASPN/Mail/Message/xml-dev/754445
        // Modified to add IPv6 support as per http://www.ietf.org/rfc/rfc3986.txt,
        // to only allow absolute URIs, to allow commas in the uri, and to allow an empty fragment part.
        var uriRegexp = /^(([a-zA-Z][0-9a-zA-Z\+\-\.]*:)\/{0,2}[0-9a-zA-Z;\/\?:@&=\+\$\.,\-_!~\*'\(\)\[\]%]+)(#[0-9a-zA-Z;\/\?:@&=\+\$\.,\-_!~\*'\(\)%]*)?$/;
        return uriRegexp.test(s);
    },

    indexOf : function(	/*Array*/		array,
                        /*Object*/		value,
                        /*Integer?*/	fromIndex,
                        /*Boolean?*/	findLast){
        // summary:
        //		Extension of dojo.indexOf to support the .equals method.
        // description:
        //      If value has an equals method, then it is used to compare with
        //      the objects in the array. Otherwise, this function is the same as dojo.indexOf.
        //		For details on indexOf, see:
        // 			http://developer.mozilla.org/en/docs/Core_JavaScript_1.5_Reference:Global_Objects:Array:indexOf

        if (!value || !dojo.isFunction(value.equals)) {
            return dojo.indexOf(array, value, fromIndex, findLast);
        }

        var i = 0, step = 1, end = array.length;
        if (findLast){
            i = end - 1;
            step = end = -1;
        }
        for (i = fromIndex || i; i != end; i += step){
            if (value.equals(array[i])) { return i; }
        }
        return -1;	// number
    },

    isEmptyObject : function(obj) {
        // summary: Checks to see if the given object has attributes or not. ( i.e. { foo: 'bar' } is not empty but { } is empty )
        // returns: True if the item has attributes, false otherwise.

        for(var key in obj)
           return false;
        return true;
    },

    keys : function(/*Object*/obj) {

        // summary: Returns the keys for the given javascript object.

        var array = [];
        for(var key in obj)
            array.push(key);
        return array;
    },

    values : function(/*Object*/obj) {

        // summary: Returns the values in the given javascript object.

        var array = [];
        for(var key in obj)
            array.push(obj[key]);
        return array;
    },

    arrayAndSetComparator : function(/* Array | anzo.utils.Set */o1, /* Array | anzo.utils.Set */o2) {

        // summary:
        //      Compares the two given arrays or sets by .length or by .size().

        // returns:
        //      A negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.

        if(o1 && o2) {
            var o1Length = -1;
            if(o1.length)
                o1Length = o1.length;
            else if(dojo.isFunction(o1.size))
                o1Length = o1.size();
            var o2Length = -1;
            if(o2.length)
                o2Length = o2.length;
            else if(dojo.isFunction(o2.size))
                o2Length = o2.size();
            if (o1Length == o2Length)
                return 0;
            return (o1Length < o2Length) ? -1 : 1;
        }
        return 0;
    },

    arrayIntersection : function(/* Array */o1, /* anzo.utils.Set */o2) {

        if(!dojo.isArray(o1) || !dojo.isArray(o2))
            throw Error('The given arguments are not arrays.');

        var _o1 = new anzo.utils.Set(o1);
        var _o2 = new anzo.utils.Set(o2);

        var smaller = (_o1.size() <= _o2.size()) ? _o1 : _o2;
        var bigger  = (_o1.size() > _o2.size()) ? _o1 : _o2;

        var results = new anzo.utils.Set();
        var iter = smaller.forEach(function(val) {
            if(bigger.contains(val))
                results.add(val)
        });
        return results.toArray();

    },

    arrayUnion : function(/* Array */o1, /* Array */o2) {
        if(!dojo.isArray(o1) || !dojo.isArray(o2))
            throw Error('The given arguments are not arrays.');
        var results = new anzo.utils.Set(o1);
        results.addAll(o2);
        return results.toArray();
    },

    hashString : function(val) {
        // 1000003
        return 1;
        if(val == null)
            return null;
        val = val.toString();
        var key = 0;
        for (var i = 0; i < val.length; i++) {
            key = 37*key + val.charCodeAt(i);
            key = key % 1000003; //primes[level];
        }
        return key;
    },

    /*************/

    // This code was written by Tyler Akins and has been placed in the
    // public domain.  It would be nice if you left this header intact.
    // Base64 code from Tyler Akins -- http://rumkin.com
    keyStr : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",

    encode64 : function(input) {
        var output = "";
        var chr1, chr2, chr3;
        var enc1, enc2, enc3, enc4;
        var i = 0;

        do {
            chr1 = input.charCodeAt(i++);
            chr2 = input.charCodeAt(i++);
            chr3 = input.charCodeAt(i++);

            enc1 = chr1 >> 2;
            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
            enc4 = chr3 & 63;

            if (isNaN(chr2)) {
                enc3 = enc4 = 64;
            } else if (isNaN(chr3)) {
                enc4 = 64;
            }

            output = output + this.keyStr.charAt(enc1) + this.keyStr.charAt(enc2) +
            this.keyStr.charAt(enc3) + this.keyStr.charAt(enc4);
        } while (i < input.length);

        return output;
    },

    /***********/

    _sparseArrayFind : function _sparseArrayFind(array, value) {
        // summary: Find the given value inside a sparse Array.
        // description: This only works on objects that are true Array objects. It will
        //   iterate over the array efficiently using a for..in loop. It will avoid
        //   any elements that are part of the Array prototype to protect against
        //   libraries that modify the built-in object prototypes. Again, that means
        //   that this method must only be called on real Array objects, not objects
        //   derived from Array or anything like that. This is typically useful only
        //   in very controlled internal circumstances. Also note that order is not
        //   guaranteed with this methodology, so if there are multiple matching
        //   values, there is no guarantee which one will be found. You should only
        //   use this method on arrays that have all numerically indexed values with integers
        //   0 or higher as the indexes.
        // returns: The index of the value in the array or -1 if the value is not found.
        if (!array || !array.length) {
            return -1;
        }
        var arrayPrototype = Array.prototype;
        for (var i in array) {
            if (array[i] == value && !(i in arrayPrototype)) {
                return i;
            }
        }
        return -1;
    },

    _sparseArrayForEach : function _spareArrayForEach(array, callback) {
        // summary: Call the given callback for every item of the sparse array. The callback's
        //   argument will be the current array item.
        // description: This only works on objects that are true Array objects. It will
        //   iterate over the array efficiently using a for..in loop. It will avoid
        //   any elements that are part of the Array prototype to protect against
        //   libraries that modify the built-in object prototypes. Again, that means
        //   that this method must only be called on real Array objects, not objects
        //   derived from Array or anything like that. This is typically useful only
        //   in very controlled internal circumstances. Also note that order is not
        //   guaranteed with this methodology, so if there are multiple matching
        //   values, there is no guarantee which one will in this be found. You should only
        //   use this method on arrays that have all numerically indexed valued with integers
        //   0 or higher as the indexes.
        if (!array || !array.length) {
            return;
        }
        var arrayPrototype = Array.prototype;
        for (var i in array) {
            if (!(i in arrayPrototype)) {
                callback(array[i]);
            }
        }
    },

    fromISOString : function(/*String*/formattedString) {
        // summary: Wrapper around dojo.date.stamp.fromISOString that adds support for time-zoned dates
        //          and adds support for the gMonthDay, gMonth, and gDay formats. Thus it supports
        //          all of the XML Schema built-in date and time-related formats. 

        // dojo.date.stamp.fromISOString can handle yyyy, yyyy-mm, and yyyy-mm-dd strings but only WITHOUT
        // time zones. So we first check if the input matches one of those formats with time zone and, if so,
        // we strip out the time zone before calling dojo.date.stamp.fromISOString. We'll add it back ourselves.
        var date = null;
        if (!anzo.utils._ZonedDateRegExp) {
            anzo.utils._ZonedDateRegExp = /^-?\d+(?:-(\d\d)(?:-(\d\d))?)?(?:([\-+])(\d\d):(\d\d)|Z)$/;
        }
        var matches = anzo.utils._ZonedDateRegExp.exec(formattedString);
        if(matches) {
            var offset = 0;
            var zoneLessString = null;
            if(formattedString.charAt(formattedString.length-1) == 'Z') {
                zoneLessString = formattedString.substring(0, formattedString.length-1); // convert values of the form 2008-07-29Z to 2008-07-29
                offset = 0;
            } else {
                zoneLessString = formattedString.substring(0, formattedString.length-6); // convert values of the form: 2008-07-29-05:00 or 2008-07-29+05:00 to 2008-07-29
                
                // Parse time zone offset into an integer number of minutes
    			offset = ((matches[4] || 0) * 60) + (Number(matches[5]) || 0);
    			if (matches[3] == '-') {
    			    offset *= -1;
    			}
            }

            var dateNoTimeZone = dojo.date.stamp.fromISOString(zoneLessString);
            if (matches[1] != null && matches[2] != null) {
                // This is a full xsd:date (year-month-day). We care about time zones for xsd:date
                // so make sure to add the appropriate time zone offset back now that dojo.date.stamp.fromISOString has finished its work.
                offset += dateNoTimeZone.getTimezoneOffset(); // The date created by dojo.date.stamp.fromISOString created is based on the current locale time zone settings. So we adjust our offset to account for that.
                if (offset) {
                    dateNoTimeZone.setTime(dateNoTimeZone.getTime() - offset * 60000);
                }
                date = dateNoTimeZone;
                if (log.isDebugEnabled()) {
                    log.debug("Zoned xsd:date ('" + formattedString + "') converted to ECMAScript Date with getTime():" + date.getTime() + "ms (new date timezone offset:" + (new Date()).getTimezoneOffset() + "m)" + (dojo.date.locale ? (" - " + dojo.date.locale.format(date, {formatLength: 'long', selector: "date", datePattern : "dd MMM yyyy"})) : ""));
                }
            } else {
                // This is either a xsd:gYear, a xsd:gYearMonth or an xsd:date without a time zone here. The dojo.date.stamp.fromISOString function
                // handles those properly. For the xsd:gYear and xsd:gYearMonth we decide to not add the time zone offset for those even if it is present
                // since the meaning is so rarely intended and as such is likely to cause display of dates that appear like off-by-one errors
                // when different clients with different time zones are involved.
                date = dateNoTimeZone;
            }
        } else {
            // dojo.date.stamp.fromISOString can't handle xsd:gMonthDay, xsd:gMonth, or xsd:gDay strings. So check
            // if the input is in one of those formats and, if so, so handle it ourselves. Otherwise, let Dojo handle it.
            if (!anzo.utils._MonthDayRegExp) {
                anzo.utils._MonthDayRegExp = /^--(\d\d)?(?:-(\d\d))?(?:[\-+]\d\d:\d\d|Z)?$/;
            }
            var matches = anzo.utils._MonthDayRegExp.exec(formattedString);
            if (log.isDebugEnabled()) {
                log.debug("Match results against gDay, gMonth, gMonthDay regexp for '" + formattedString + "' - match:" + matches);
            }
            if (matches) {
                // We ignore the time zone since it is more likely to confuse more than anything for Date objects that
                // represent xsd:gMonthDay, xsd:gDay, and xsd:gMonth data.
                date = new Date(1970, (matches[1]-1)||0, matches[2]||1, 0, 0, 0, 0); // ECMAScript Date expects January to be month 0.
            } else {
                // For all other kinds of date strings, just let Dojo handle it.
                date = dojo.date.stamp.fromISOString(formattedString);
            }
        }
        return date;
    },

    /*=====
    anzo.utils.__toIsoStringOptions = function(){
        //  format: String
        //      One of "dateTime", "date", "time", "gYearMonth", "gMonthDay, "gYear", "gMonth", or "gDay" specifying
        //      the format of the string as per the XML Schema formats. 
        //      The default is "dateTime".
        //  local: Boolean
        //      if true, the date and/or time is output relative to local time zone.
        //      if false, the date and/or time is output relative the UTC/GMT time zone.
        //      The default is false. 
        //  hideMilliseconds: Boolean
        //      if true, milliseconds will not be output. The default is false.
        //  hideTimezone: Boolean
        //      if true, a time zone offset will NOT be output. If false, if will be output.
        //      The offset output will be either the Date objects time zone offset
        //      or the UTC time zone offset if the 'zulu' option is true. Default is false.
        this.format = format;
        this.local = local;
        this.hideMilliseconds = hideMilliseconds;
        this.hideTimezone = hideTimezone;
    }
    =====*/

    toISOString : function(/*Date*/dateObject, /*anzo.utils.__toIsoStringOptions?*/options) {
        // summary: Format a Date object as a string according to one of the built-in XML Schema formats
        //          such as xsd:dateTime, xsd:time, etc.
        //  description:
        //      When options is omitted, the output is in the xsd:dateTime format relative to the UTC time-zone
        //      with both milliseconds and the time zone offset included. 
        //      Does not check bounds.  Only years between 100 and 9999 are supported.
        //  dateObject:
        //      A Date object

        // This function is based on the dojo.date.stamp.toISOString function but modified and expanded to support
        // the XML Schema built-in date and time-related formats.
         
        options = options || {};
        var formattedDate = [];
        var getter = options.local ? "get" : "getUTC";
        var format = options.format ? options.format : "dateTime"; 
        var includedParts = _dateFormats[format];
        if (includedParts == null) {
            throw new Error("anzo.utils.toISOString - Unknown format '" + format + "'");
        }
        if (format != "time") { // all but the "time" format include some portion of the date
            var dateParts = [];
            if (includedParts.y) {
                var year = dateObject[getter+"FullYear"]();
                dateParts.push("0000".substr((year+"").length)+year);
            } else {
                dateParts.push("-"); // prefix used for partial date formats that omit the year, like gMonth, gDay, etc. 
            }
            if (includedParts.m) {
                dateParts.push(_zeroPrefix(dateObject[getter+"Month"]()+1));
            }
            if (includedParts.d) {
                if (!includedParts.m) {
                    dateParts.push(""); // Ensure there are three dashes before the day in the gDay case.
                }
                dateParts.push(_zeroPrefix(dateObject[getter+"Date"]()));
            }
            var date = dateParts.join('-');
            formattedDate.push(date);
            if (includedParts.t) {
                formattedDate.push("T");
            }
        }
        if (includedParts.t) {
            var time = [_zeroPrefix(dateObject[getter+"Hours"]()), _zeroPrefix(dateObject[getter+"Minutes"]()), _zeroPrefix(dateObject[getter+"Seconds"]())].join(':');
            if (!options.hideMilliseconds) {
                var millis = dateObject[getter+"Milliseconds"]();
                time += "." + (millis < 100 ? "0" : "") + _zeroPrefix(millis);
            }
            formattedDate.push(time);
        }
        if (!options.hideTimezone) {
            var timezone = "Z";
            var timezoneOffset = dateObject.getTimezoneOffset();
            if (options.local && timezoneOffset != 0) {
                var absOffset = Math.abs(timezoneOffset);
                timezone = (timezoneOffset > 0 ? "-" : "+") + 
                    _zeroPrefix(Math.floor(absOffset/60)) + ":" + _zeroPrefix(absOffset%60);
            }
            formattedDate.push(timezone);
        }
        return formattedDate.join(""); // String
    }

});

})();
