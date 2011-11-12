/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File:        $Source: /cvsroot/slrp/common/com.ibm.adtech.java.util/src/com/ibm/adtech/java/util/Collections.java,v $
 * Created by:  Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on:  10/23/2006
 * Revision:	$Id: Collections.java 167 2007-07-31 14:11:13Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.openanzo.rdf.URI;

/**
 * Set of collection utilities
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * 
 */
public class Collections {

    /**
     * Create the cartesian product for a collection of collections
     * 
     * @param collections
     *            the list of collections whose cartesian product is being determined.
     * @param <T>
     *            Type of objects in collection
     * @return a set of collections each of which is an element in the cartesian product of the given collections
     */
    static final public <T> Set<Collection<T>> cartesianProduct(List<Collection<T>> collections) {
        List<Iterator<T>> iterators = new ArrayList<Iterator<T>>();
        for (Collection<T> c : collections)
            iterators.add(c.iterator());
        HashSet<Collection<T>> product = new HashSet<Collection<T>>();
        ArrayList<T> tuple = new ArrayList<T>();
        // initialize the tuple with the first element from every iterator
        for (Iterator<T> it : iterators) {
            if (!it.hasNext())
                return product;
            tuple.add(it.next());
        }
        boolean hadNext;
        do {
            hadNext = false;
            product.add(new ArrayList<T>(tuple));
            for (int i = 0; i < iterators.size(); i++) {
                Iterator<T> it = iterators.get(i);
                if (it.hasNext()) {
                    tuple.set(i, it.next());
                    hadNext = true;
                    break;
                }
                // reset this iterator
                it = collections.get(i).iterator();
                iterators.set(i, it);
                // get the first item from this iterator
                tuple.set(i, it.next());
                // we let the for-loop keep going so that the next iterator will get incremented
                // since we're rolling forward
            }
        } while (hadNext);
        return product;
    }

    /**
     * Add all the elements of an iterable into a colleciton
     * 
     * @param <E>
     *            type to add
     * @param source
     *            source of elements
     * @param destination
     *            destination of elements
     */
    static final public <E> void addAll(Iterable<E> source, Collection<E> destination) {
        for (E e : source) {
            destination.add(e);
        }
    }

    /**
     * Convert an iterable to a collection
     * 
     * @param <E>
     *            type of collection
     * @param source
     *            source of elements
     * @return destination collection
     */
    static final public <E> Collection<E> toList(Iterable<E> source) {
        java.util.ArrayList<E> list = new java.util.ArrayList<E>();
        addAll(source, list);
        return list;
    }

    /**
     * Add the source elements to the destination collection
     * 
     * @param source
     *            source elements
     * @param destination
     *            destination of elements
     * @param <T>
     *            type of elements
     */
    public final static <T> void addAllIfNotNull(Collection<T> source, Collection<T> destination) {
        if (source != null) {
            destination.addAll(source);
        }
    }

    /**
     * Add the source elements to the destination collection
     * 
     * @param source
     *            source elements
     * @param destination
     *            destination of elements
     * @param <T>
     *            type of elements
     */
    public final static <T> void addAllArrayIfNotNull(T[] source, Collection<T> destination) {
        if (source != null) {
            for (T t : source) {
                destination.add(t);
            }
        }
    }

    /**
     * Add source elements to the destination if it doesn't already contain the element
     * 
     * @param <T>
     *            type of elements
     * @param source
     *            source of elements
     * @param destination
     *            destination collection
     */
    public final static <T> void addAllUnique(Collection<T> source, Collection<T> destination) {
        if (source != null) {
            for (T element : source) {
                if (!destination.contains(element)) {
                    destination.add(element);
                }
            }
        }
    }

    /**
     * Copy the contents of a collection to a new collection. This tries to use efficient clone if possible.
     * 
     * @param <T>
     *            type of objects in collection
     * @param source
     *            source elements
     * @return copy of original.
     */
    @SuppressWarnings("unchecked")
    public final static <T> Collection<T> copyCollection(Collection<T> source) {
        if (source instanceof HashSet) {
            return (Collection<T>) ((HashSet<T>) source).clone();
        } else if (source instanceof ArrayList) {
            return (Collection<T>) ((ArrayList<T>) source).clone();
        } else {
            return new ArrayList<T>(source);
        }
    }

    /**
     * Copy the contents of a collection to a new collection. This tries to use efficient clone if possible.
     * 
     * @param <T>
     *            type of objects in collection
     * @param source
     *            source elements
     * @return copy of original.
     */
    @SuppressWarnings("unchecked")
    public final static <T> Set<T> copySet(Set<T> source) {
        if (source instanceof HashSet) {
            return (Set<T>) ((HashSet<T>) source).clone();
        } else {
            return new HashSet<T>(source);
        }
    }

    /**
     * @param <T>
     *            Type of elements in set
     * @param source
     *            source array of elements
     * @return Set containing source elements
     */
    public final static <T> Set<T> asSet(T[] source) {
        if (source == null) {
            return java.util.Collections.<T> emptySet();
        } else {
            Set<T> set = new HashSet<T>(source.length);
            for (T t : source) {
                set.add(t);
            }
            return set;
        }
    }

    /**
     * Given 2 sets of URIs, determine of any of the member URIs are within the group URIs
     * 
     * @param group
     *            Set of URIs which membership is being determined
     * @param members
     *            Set of URIs which to find membership of group
     * @return true if at least 1 member is within the group
     */
    public static boolean memberOf(Set<URI> group, Set<URI> members) {
        if (members == null || members.size() == 0 || group == null || group.size() == 0)
            return false;
        for (URI member : members) {
            if (group.contains(member))
                return true;
        }
        return false;
    }

    /**
     * A thread-safe variant of {@link Map} in which all mutative operations (add, set, and so on) are implemented by making a fresh copy of the underlying map.
     * <p>
     * This is ordinarily too costly, but may be <em>more</em> efficient than alternatives when traversal operations vastly out-number mutations, and is useful
     * when you cannot or don't want to synchronise traversals, yet need to preclude interference among concurrent threads. The "snapshot" style iterators on
     * the collections returned by {@link #entrySet()}, {@link #keySet()} and {@link #values()} use a reference to the internal map at the point that the
     * iterator was created. This array never changes during the lifetime of the iterator, so interference is impossible and the iterator is guaranteed not to
     * throw <tt>ConcurrentModificationException</tt>. The iterators will not reflect additions, removals, or changes to the list since the iterator was
     * created. Element-changing operations on iterators and collections themselves (remove, set, and add) are not supported. These methods throw
     * {@link UnsupportedOperationException}.
     * <p>
     * The actual copy is performed by a supplied {@link CopyFunction} object. The Factory is responsible for the underlying Map implementation (for instance a
     * HashMap, TreeMap, ListOrderedMap etc.) and therefore the semantics of what this map will cope with as far as null keys and values, iteration ordering
     * etc.
     * <p>
     * There are supplied {@link Functions} for the common Collections {@link Map} implementations.
     */
    static public class CopyOnWriteMap<K, V> implements Map<K, V> {
        private volatile Map<K, V>       delegate;

        private final CopyFunction<K, V> factory;

        /**
         * Create a new CopyOnWriteMap with the supplied Map to initialise the values and the Factory for creating our actual delegate instances.
         * 
         * @param map
         * @param factory
         */
        public CopyOnWriteMap(Map<K, V> map, CopyFunction<K, V> factory) {
            this.delegate = factory.copy(map);
            this.factory = factory;
        }

        public CopyOnWriteMap(CopyFunction<K, V> factory) {
            this(java.util.Collections.<K, V> emptyMap(), factory);
        }

        public Map<K, V> currentInstance() {
            return delegate;
        }

        // ----------------------------------------------------------------------------------------------
        // mutable operations

        public synchronized void clear() {
            Map<K, V> map = factory.copy(delegate);
            map.clear();
            delegate = map;
        }

        public synchronized V remove(Object key) {
            Map<K, V> map = factory.copy(delegate);
            V result = map.remove(key);
            delegate = map;
            return result;
        }

        public synchronized V put(K key, V value) {
            Map<K, V> map = factory.copy(delegate);
            V result = map.put(key, value);
            delegate = map;
            return result;
        }

        public synchronized void putAll(Map<? extends K, ? extends V> t) {
            Map<K, V> map = factory.copy(delegate);
            map.putAll(t);
            delegate = map;
        }

        // ------------------------------------------------------------------------------------------
        // unmodifiable set views

        public Set<Map.Entry<K, V>> entrySet() {
            return java.util.Collections.unmodifiableSet(delegate.entrySet());
        }

        public Set<K> keySet() {
            return java.util.Collections.unmodifiableSet(delegate.keySet());
        }

        public Collection<V> values() {
            return java.util.Collections.unmodifiableCollection(delegate.values());
        }

        // ----------------------------------------------------------------------------------------
        // simple immutable getters

        public boolean containsKey(Object key) {
            return delegate.containsKey(key);
        }

        public boolean containsValue(Object value) {
            return delegate.containsValue(value);
        }

        public V get(Object key) {
            return delegate.get(key);
        }

        public boolean isEmpty() {
            return delegate.isEmpty();
        }

        public int size() {
            return delegate.size();
        }

        @Override
        public boolean equals(Object o) {
            return delegate.equals(o);
        }

        @Override
        public int hashCode() {
            return delegate.hashCode();
        }

        /*
         * not on the Map interface, but delegate to the internal map anyway as
         * AbstractMap provides a handy toString()
         */
        @Override
        public String toString() {
            return delegate.toString();
        }
    }

    /**
     * Copy the current map. Always done under a lock so we don't get multiple threads doing this concurrently.
     */
    public static interface CopyFunction<K, V> {
        /**
         * Create a new map copied from the one supplied. Implementations should not keep a reference to this map, and must not modify the map after it has been
         * returned. This will be called under synchronisation, so it should not do any IO or blocking operations.
         * 
         * @param map
         *            the map to copy. Will not be null.
         * @return a new copied map. Must not be null.
         */
        Map<K, V> copy(Map<K, V> map);
    }

    /**
     * Factories that create the standard Collections {@link Map} implementations.
     */
    public static final class Functions {
        public static <K, V> CopyFunction<K, V> hash() {
            return new CopyFunction<K, V>() {
                public Map<K, V> copy(Map<K, V> map) {
                    return new HashMap<K, V>(map);
                }
            };
        }

        public static <K, V> CopyFunction<K, V> tree() {
            return new CopyFunction<K, V>() {
                public Map<K, V> copy(Map<K, V> map) {
                    return new TreeMap<K, V>(map);
                }
            };
        }
    }
}
