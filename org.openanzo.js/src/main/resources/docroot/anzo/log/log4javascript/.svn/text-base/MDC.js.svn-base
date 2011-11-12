/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

dojo.provide("anzo.log.log4javascript.MDC");

/*
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>) 
 */

(function(){

var mdcMap = {};

anzo.log.log4javascript.MDC = {
    // summary: A Mapped Diagnostic Context (MDC) implementation for log4javascript.
    // description: This is similar to the implementation in various logging frameworks such as log4j.
    //   The log4javascript PatternLayout supports the MDC via the %x conversion character.
    //   To show a property in the MDC use a pattern like: "%x{propertyName}" where 'propertyName' is 
    //   the relevant property in the MDC.
    clear : function clear() {
        // summary: Clears all properties in the MDC.
        mdcMap = {};
    },
    
    get : function get(key) {
        // summary: Get the value associated with the given key in the MDC.
        // key: String. The key to the desired value.
        // returns: Object. The value associated with the given key. 
        //   Returns 'undefined' if there is no value associated with the given key.
        if (!key || !dojo.isString(key)) {
            throw new Error("Key argument must be a string.");
        }
        return mdcMap[key];
    },
    
    put : function put(key, val) {
        // summary: Sets the value associated with the given key in the MDC. Overwrites any
        //   existing value associated with the given key.
        // key: String. The key to the desired value.
        // val: Object. The value associated with the given key. If the val is 'undefined' the
        //   function removes the key as if 'remove' had been called.  
        // returns: Object. The old value associated with the key, or undefined if none existed. 
        if (!key || !dojo.isString(key)) {
            throw new Error("Key argument must be a string.");
        }
        var oldVal = mdcMap[key];
        if (val === undefined) {
            delete mdcMap[key];
        } else {
            mdcMap[key] = val;            
        }
        return oldVal;
    },
    
    append : function append(key, val) {
        // summary: Appends the given value to the current value of the given key. If the key doesn't yet have
        //   a corresponding value, then it just sets the value. It will append the values as strings.
        // key: String. The key to the desired value.
        // val: Object. The value to append to the current value associated with the given key.
        // returns: Object. The new appended value associated with the key. 
        if (!key || !dojo.isString(key)) {
            throw new Error("Key argument must be a string.");
        }
        var oldVal = mdcMap[key];
        var newVal;
        if (oldVal === undefined) {
            newVal = val;
        } else {
            newVal = ("" + oldVal) + val;
        }
        mdcMap[key] = newVal;
        return newVal;
    },

    remove : function remove(key) {
        // summary: Removes the value associated with the given key in the MDC.
        // key: String. The key to remove.
        if (!key || !dojo.isString(key)) {
            throw new Error("Key argument must be a string.");
        }
        delete mdcMap[key];
    }
};

})();
