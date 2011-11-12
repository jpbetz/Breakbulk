/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Functionality of LRUHash inspired by the 'Javascript LRU Cache' at
 * http://www.monsur.com/projects/jscache/
 * which is Copyright (c) 2007 Monsur Hossain (http://www.monsur.com)
 * and used under the MIT LICENSE
 * http://www.opensource.org/licenses/mit-license.php
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
dojo.provide("anzo.utils.LRUHash");

dojo.require("anzo.log");

/*
 * @author Jordi Albornoz Mulligan (<a href="mailto:jordi@cambridgesemantics.com">jordi@cambridgesemantics.com</a>) 
 */
(function(){

var log = anzo.log.getLogger("anzo.utils.LRUHash");

anzo.utils.LRUHash = function(hashFunction, equalityFunction, capacity) {
    // summary: A map with a maximum capacity that will evict the least recently used entries when over capacity. Useful for caches.
    // description: Constructs a map with customizable hashFunctions and equality functions and a maximum capacity.
    //   The hash function and the equality functions must have all of the properties of the
    //   Java Object class's hashCode and equals methods. Namely the equality function must be reflexive, symmetric,
    //   transitive, and consistent. The hash function must return the same hash value for two objects that are equal
    //   by the equality function and the hash value must not change over the life of the application. Note that 
    //   the hash function may return the same hash value for two objects that are unequal. 
    //   See http://java.sun.com/javase/6/docs/api/java/lang/Object.html for more detail.
    //   If no custom hash function, equality function, or capacity are specified then the defaults are
    //   such that the hash behaves like a typical ECMAScript Object used as a map. That is, the hash value is the key itself,
    //   equality is determined by the '==' operator and the capacity is unlimited.
    // hashFunction: Function. Optional. The function used to generate a hash value for an item. The first argument is the key
    //   for which the hash should be created. The function must return the hash value. 
    //   Default value is the following function:
    //   | function(item) { return item; };
    // equalityFunction: Function. Optional. The function used to compare equality of two keys. The arguments are the two keys to
    //   compare. The function must return 'true' if the keys are equal and 'false' otherwise.
    //   Default value is the following function:
    //   | function(a, b) { return a == b; };
    // capacity: Number. Optional. Default value is -1 (unlimited capacity). The capacity of the map. -1 denotes unlimited capacity. 
    if (!dojo.isFunction(hashFunction)) {
        hashFunction = function(item) { return item; }; 
    }
    if (!dojo.isFunction(equalityFunction)) {
        equalityFunction = function(a, b) { return a == b; };
    }
    this._hashfunc = hashFunction;
    this._equals = equalityFunction;

    if (capacity) { 
        this._maxEntries = capacity;
    } else {
        this._maxEntries = -1; // unlimited
    }
    
    // This is a map from each the hash values to arrays of item objects.
    // An item object has the following properties:
    //   key - the full key of the object (as opposed to just the hash value of the key)
    //   timeUsed - the timestamp of the last usage or when the item was written to the cache
    //   value - the cached value
    //   removalCallback - the callback to call when this item is removed from the hash or null if no callback is desired.
    this._items = {};
    this._itemCount = 0;
    
    // When purging the cache once its hit the limit, the purgeFactor denotes what portion of the cache we purge.
    // Since purging is relatively expensive, this helps reduce the number of purges but trades off a
    // shorter life in the cache for some entries.
    this._purgeFactor = .25; 
    this._purgeAmount = Math.ceil(this._maxEntries * this._purgeFactor); // Number of entries to clear in a purge
};

anzo.utils.LRUHash.prototype.get = function(key) {
    // summary: Retrieve the value associated with the given key.
    // key: the key to lookup.
    // returns: the value associated with the given key or 'undefined' if no such value exists.
    var retval = undefined;
    var hash = this._hashfunc(key);
    var matchedItems = this._items[hash];
    if (matchedItems) {
        // Multiple entries may match this hash, so we have an array of entries here. 
        // We look inside the array to find the particular item, if any, that matches via the equality function.
        var arrayPrototype = Array.prototype;
        for (var i in matchedItems) { // The array is a 'sparse array' so we iterate with a 'for...in' loop but do it safely by skipping Array.prototype properties.
            if (!(i in arrayPrototype)) {
                var matchedItem = matchedItems[i];
                if (this._equals(matchedItem.key, key)) {
                    matchedItem.timeUsed = new Date().getTime();
                    retval = matchedItem.value;
                    break;
                }
            }
        }
    }
    return retval;
};

anzo.utils.LRUHash.prototype.set = function(key, item, removalCallback) {
    // summary: Associate the given item with the given key.
    // key: The key to associate with the item.
    // item: The value to associate with the given key. If a value is already associated
    //   with the given key, then is it replaced with this new item.
    // removalCallback: Function. Optional. A function that will be called when this item is removed
    //   from the mapping. This will be called if the key association is removed due to full capacity or due to explicit
    //   removal via the 'remove' or 'clear' function. Note that the removalCallback applies to the key not the item
    //   so it will not be called if an existing mapping is replaced via the 'set' method. The first argument
    //   passed to the removalCallback is the removed key and the second argument is the removed item. 
    // returns: The value which used to be associated with the given key or 'undefined' if there was no such value. 
    log.debug("Setting item.")
    var retval = undefined;
    var hash = this._hashfunc(key);
    var matchedItems = this._items[hash];
    var addItem = true; 
    if (matchedItems) {
        var arrayPrototype = Array.prototype;
        for (var i in matchedItems) {  // The array is a 'sparse array' so we iterate with a 'for...in' loop but do it safely by skipping Array.prototype properties. 
            if (!(i in arrayPrototype)) { 
                var matchedItem = matchedItems[i];
                if (this._equals(matchedItem.key, key)) {
                    // Found item already indexed by the given key so replace the entry with this new value
                    matchedItem.timeUsed = new Date().getTime();
                    retval = matchedItem.value;
                    matchedItem.value = item;
                    matchedItem.removalCallback = removalCallback;
                    addItem = false;
                    break;
                }
            }
        }
    }
    if (addItem) {
        log.debug("Adding item.")
        if (this._maxEntries >= 0 && this._itemCount + 1 > this._maxEntries) {
            // If there is a limit and adding this item would cause it to be exceeded, then purge the oldest items.
            this._purge();
            log.debug("Addition needs purge.")
        } else {
            if (log.isDebugEnabled()) {
                log.debug("No purge needed: this._maxEntries:" + this._maxEntries + " (this._itemCount + 1):" + (this._itemCount + 1));
            }
        }
        var cb = dojo.isFunction(removalCallback) ? removalCallback : null; 
        if (matchedItems) {
            this._items[hash].push({ key : key, value: item, timeUsed : new Date().getTime(), removalCallback : cb });
        } else {
            this._items[hash] = [ { key : key, value: item, timeUsed : new Date().getTime(), removalCallback : cb } ];
        }
        this._itemCount++;
    }
    return retval;
};

anzo.utils.LRUHash.prototype.remove = function(key) {
    // summary: Removes the item associated with the given key.
    // key: The key of the association being removed.
    // returns: the item that was removed or 'undefined' if no such item exists.
    var retval = undefined;
    var hash = this._hashfunc(key);
    var matchedItems = this._items[hash];
    var matchedItem = null;
    if (matchedItems) {
        var toDelete = null;
        var arrayPrototype = Array.prototype;
        for (var i in matchedItems) { // The array is a 'sparse array' so we iterate with a 'for...in' loop but do it safely by skipping Array.prototype properties.
            if (!(i in arrayPrototype)) {
                matchedItem = matchedItems[i];
                if (this._equals(matchedItem.key, key)) {
                    retval = matchedItem.value;
                    toDelete = i;
                    break;
                }
            }
        }
        if (toDelete != null) { // Delete outside of the 'for...in' loop to avoid trouble that some browsers have with deleting from the array while in the loop.
            delete matchedItems[toDelete];
            this._itemCount--;
            if (this._sparseArrayIsEmpty(matchedItems)) {
                delete this._items[hash];
            }
            if (matchedItem != null && dojo.isFunction(matchedItem.removalCallback)) {
               setTimeout(function() { matchedItem.removalCallback(matchedItem.key, matchedItem.value); }, 0);
            }
        }
    }
    return retval;
};

anzo.utils.LRUHash.prototype.clear = function() {
    // summary: Removes every item from the hash. The removal callback function, if any, for each item will be called. 
    var items = this._items;

    this._items = {};
    this._itemCount = 0;

    var arrayPrototype = Array.prototype;
    for (var i in items) {
        var arr = items[i];        
        for (var j in arr) { // The array is a 'sparse array' so we iterate with a 'for...in' loop but do it safely by skipping Array.prototype properties.
            if (!(j in arrayPrototype)) {
                var item = arr[j];
                if (dojo.isFunction(item.removalCallback)) {
                    setTimeout((function(x) { return function() { x.removalCallback(x.key, x.value); } })(item), 0);
                }
            }
        }
    }
};

anzo.utils.LRUHash.prototype.size = function() {
    // summary: Gets the number of associations currently in the hash.
    // returns: Number. Returns the number of associations currently in the hash.
    return this._itemCount;
};

anzo.utils.LRUHash.prototype.capacity = function() {
    // summary: Gets the maximum number of associations allowed in the hash.
    // returns: Number. Returns the maximum number of associations allowed in the hash.
    return this._maxEntries;
};

anzo.utils.LRUHash.prototype._purgeComparator = function(a, b) {
    if (a.timeUsed < b.timeUsed) {
        return -1;
    }
    if (a.timeUsed > b.timeUsed) {
        return 1;
    }
    return 0;
};

anzo.utils.LRUHash.prototype._sparseArrayIsEmpty = function(array) {
    var empty = true;
    if (array) {
        var arrayPrototype = Array.prototype;
        for (var i in array) {
            if (!(i in arrayPrototype)) {
                empty = false;
                break;
            }
        }
    }
    return empty;
};

anzo.utils.LRUHash.prototype._purge = function() {
    
    // Take the hash of items and flatten it into an array for easy/quick sorting.
    // NOTE: There may be a faster way, such as collecting a flat array of the 'n'
    // oldest items as we iterate through the list. That requires finding which item to
    // evoke from the small array each time so it's asymptotically worse that sorting but
    // it uses less memory and may be faster in the small constants we're working with.
    // This is simpler to read and implement so we'll stick with this unless this is shown
    // to be a performance bottleneck.
    if (this._purgeAmount > 0) {
        var flatItems = [];
        var arrayPrototype = Array.prototype;
        for (var i in this._items) {
            var itemArray = this._items[i];
            for (var j in itemArray) {
                if (!(j in arrayPrototype)) {
                    flatItems.push({ i: i, j: j, timeUsed: itemArray[j].timeUsed});
                }
            }
        }
        
        flatItems.sort(this._purgeComparator);
        
        // Now the array is sorted with least recently used items first.
        // Remove the 'n' least recently used items where 'n' is this._purgeAmount
        for (var k = 0; k < this._purgeAmount && k < flatItems.length; k++) {
            log.debug("purging item from cache");
            var coordinates = flatItems[k];
            var arr = this._items[coordinates.i];
            var itemToDelete = arr[coordinates.j];
            delete arr[coordinates.j];
            this._itemCount--;
            if (this._sparseArrayIsEmpty(arr)) {
                delete this._items[coordinates.i];
            }
            if (dojo.isFunction(itemToDelete.removalCallback)) {
               setTimeout((function(x) { return function() { x.removalCallback(x.key, x.value); } })(itemToDelete), 0);
            }
        }
    }
};

})();
