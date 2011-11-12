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
 * Revision: $Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/

/*
 * @author Rouben Meschian (<a href="mailto:rmeschian@cambridgesemantics.com">rmeschian@cambridgesemantics.com</a>) 
 */
 
dojo.provide("anzo.utils.Set");

dojo.require("anzo.log");

(function() {
var log = anzo.log.getLogger("anzo.utils.Set");

anzo.utils.Set = function(arg) {
    
    // summary: Initialize.
	    
    // arg : Array | anzo.utils.Set | null
    //  Value used to set initial values of this Set.
    
    this.items = {};
    this.count = 0; 
    
    this.addAll(arg);
}

anzo.utils.Set.prototype.add = function(value, key) {

	// summary: 
    //     Adds the specified element to this set if it is not already present.
	
	// value : Object
	//  Value added to this set.
	
	// key
	//  Optional key used to identify the given value.
		
    if(value == null)
        return
    if(key == null)
        key = this.getKey(value);
    if(!(key in this.items))
        this.count++;
    this.items[key] = value;
}

anzo.utils.Set.prototype.remove = function(value, key) {
    
    // summary: 
    //     Removes the specified element from this set.
	
	// value : Object
	//  Value added to this set.
	
	// key
	//  Optional key used to identify the given value.
	
    if(value == null)
        return;
    if(key == null)
        key = this.getKey(value);
    if(key in this.items) {
        delete this.items[key];
        this.count--;
    }
}

anzo.utils.Set.prototype.addAll = function(values) {
    
    //	summary: 
    //     Adds all elements in the given array, set or dictionary to this set.
	
	// values : Array | anzo.utils.Set
	//  Collection of elements added to this set.
    
    
    if(!values)
        return;
    var _values = values;
    if(_values instanceof anzo.utils.Set)
        _values = _values.toArray();
    if(dojo.isArray(_values)) {
        for(var i = 0; i < _values.length; i++)
            this.add(_values[i])
    }
}

anzo.utils.Set.prototype.removeAll = function(values) {
    //	summary: 
    //     Removes all elements in the given array from this set.
	
	// values : Array
	//  Array of elements removed from this set.
    
    
    if(!values)
        return;
    var _values = values;
    if(_values instanceof anzo.utils.Set)
        _values = _values.toArray();
    if(dojo.isArray(_values)) {
        for(var i = 0; i < _values.length; i++)
            this.remove(_values[i])
    }
}

anzo.utils.Set.prototype.contains = function(value, key) {
    // summary: 
    //     Checks if the given value is in this set.
    
    // returns: 
    //     Returns true if this set contains the specified element, false otherwise.
    
    // value : Object
    //  Element whose presence in this set is to be tested.
    
    // key
	//  Optional key used to identify the given value.
	
    if(value == null)
        return false;
    if(key == null)
        key = this.getKey(value);
    return key in this.items;
}

anzo.utils.Set.prototype.size = function() {
    // summary: 
    //     Returns the number of elements in this set (its cardinality).
    return this.count;
}

anzo.utils.Set.prototype.isEmpty = function() {
    // summary: Checks if this set is empty.
    // returns: True if this set is empty, false otherwise.
    return this.size() == 0;
}

anzo.utils.Set.prototype.toArray = function() {
    // summary: 
    //     Returns an array containing all of the elements in this collection. 
    //     No guarantees are maid as to the order of the array.
    var array = [];
    for(var key in this.items)
        array.push(this.items[key]);
    return array;
}

anzo.utils.Set.prototype.clear = function() {
    //	summary:
	//	   Removes all elements from this set.
    this.items = {};
    this.count = 0;
}

anzo.utils.Set.prototype.forEach = function(func) {
    // summary: The given method is invoked for each item in this set.
    
    // func: Function
    //  Method that is invoked once with each item in the set.
    
    for(var key in this.items)
        func(this.items[key]);
}

anzo.utils.Set.prototype.toString = function() {
    return this.toArray().toString();
}

anzo.utils.Set.prototype.equals = function(set) {
    // summary: Checks if the given set is equal to this one by comparing the keys stored in the two sets which uniquely identify the values.
    
    // set : anzo.utils.Set
    //   The set that is being compared to this one.
    
    if(set instanceof anzo.utils.Set && set.size() == this.size()) {
        for(var key in this.items) {
            if(!(key in set.items))
               return false;
        }
        return true;
    }
    return false;
}

anzo.utils.Set.prototype.getKey = function(value) {
    // summary: This method returns the key that uniquely hashes to the given value.  
    // Developers can override this method to provide their own means of uniquely identifying the values in this set.
    
    // value : Object
    //   The value for which a key is generated.
    
    return dojo.isFunction(value.dictionaryKey) ? value.dictionaryKey() : (value.id ? value.id : value.toString());
}


})();