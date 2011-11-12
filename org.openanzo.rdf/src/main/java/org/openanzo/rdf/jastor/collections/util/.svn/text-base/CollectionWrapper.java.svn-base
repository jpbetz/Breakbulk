/*******************************************************************************
 * Copyright (c) 2004, 2007-2008 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source:
 * Created by:  Ben Szekely (<a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com</a>)
 * Created on:  6/1/05
 * Revision:    $Id: interface.javajet 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor.collections.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.openanzo.rdf.Constants;
import org.openanzo.rdf.IDataset;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.PlainLiteral;
import org.openanzo.rdf.Resource;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.jastor.JastorException;
import org.openanzo.rdf.jastor.Thing;
import org.openanzo.rdf.jastor.ThingFactory;
import org.openanzo.rdf.jastor.ThingImpl;
import org.openanzo.rdf.jastor.collections.Collection;
import org.openanzo.rdf.jastor.collections.CollectionsFactory;
import org.openanzo.rdf.jastor.collections.Item;
import org.openanzo.rdf.jastor.collections.LiteralItem;
import org.openanzo.rdf.jastor.collections.OrderedCollection;
import org.openanzo.rdf.jastor.collections.OrderedItem;
import org.openanzo.rdf.jastor.collections.ResourceItem;

/**
 * 
 * This utility class provides a standard java.util.Collection view of http://openanzo.org/ontologies/Collections.
 * 
 * @author Ben Szekely ( <a href="mailto:ben@cambridgesemantics.com">ben@cambridgesemantics.com </a>)
 * 
 */
@SuppressWarnings("unchecked")
public class CollectionWrapper implements java.util.Collection {
    final private Collection                c;

    final private boolean                   isOrdered;

    OrderedCollection                       oc = null;

    private OrderedItem                     lastItem;

    private IDataset                        dataset;

    private URI                             namedGraphUri;

    private Class<? extends ThingFactory>[] factoryClasses;

    private List<Method>                    methods;

    private ItemFactory                     itemFactory;

    final private boolean                   nullCollection;

    /**
     * Create a wrapper around the collection
     * 
     * @param collection
     *            collection to wrap
     * @param factoryClasses
     *            factory for classes
     * @param itemFactory
     *            item factory
     */
    public CollectionWrapper(Collection collection, Class<? extends ThingFactory>[] factoryClasses, ItemFactory itemFactory) {
        if (collection == null) {
            this.nullCollection = true;
            this.isOrdered = false;
            this.c = null;
        } else {
            this.nullCollection = false;
            this.dataset = collection.dataset();
            this.namedGraphUri = collection.graph().getNamedGraphUri();
            this.c = collection;
            this.isOrdered = collection instanceof OrderedCollection;
            if (isOrdered) {
                this.oc = (OrderedCollection) collection;
                try {
                    if (oc.getCollectionSize() == null)
                        oc.setCollectionSize(Integer.valueOf(0));
                    this.lastItem = oc.getFirstItem();
                    while (this.lastItem != null && this.lastItem.getNextItem() != null)
                        this.lastItem = this.lastItem.getNextItem();
                } catch (JastorException e) {
                    e.printStackTrace();
                }
            }
        }
        this.itemFactory = itemFactory;
        this.factoryClasses = factoryClasses;
        if (this.factoryClasses != null) {
            methods = new ArrayList<Method>();
            try {
                for (Class<? extends ThingFactory> clazz : factoryClasses) {
                    methods.add(clazz.getMethod("getThing", new Class[] { Resource.class, URI.class, IDataset.class }));
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Create a wrapper around the collection
     * 
     * @param collection
     *            collection to wrap
     * @param factoryClasses
     *            factory for classes
     */
    public CollectionWrapper(Collection collection, Class<? extends ThingFactory>[] factoryClasses) {
        this(collection, factoryClasses, null);
    }

    /**
     * Create a wrapper around the collection
     * 
     * @param collection
     *            collection to wrap
     * @param factoryClass
     *            factory for classes
     */
    public CollectionWrapper(Collection collection, Class<? extends ThingFactory> factoryClass) {
        this(collection, new Class[] { factoryClass });
    }

    /**
     * Create a wrapper around the collection
     * 
     * @param collection
     *            collection to wrap
     */
    public CollectionWrapper(Collection collection) {
        this(collection, (Class[]) null);
    }

    public boolean add(Object o) {

        if (nullCollection)
            throw new UnsupportedOperationException();

        try {
            Item item = null;
            if (itemFactory != null) {
                item = itemFactory.createItem(Constants.valueFactory.createBNode(), namedGraphUri, dataset);
            }

            if (o instanceof Thing) {
                if (item == null) {
                    item = CollectionsFactory.createResourceItem(Constants.valueFactory.createBNode(), namedGraphUri, dataset);
                }
                ((ResourceItem) item).setItemObject((Thing) o);
            } else if (o instanceof Resource) {
                if (item == null) {
                    item = CollectionsFactory.createResourceItem(Constants.valueFactory.createBNode(), namedGraphUri, dataset);
                }
                ((ResourceItem) item).setItemObject(ThingFactory.createThing((Resource) o, namedGraphUri, dataset));
            } else {
                if (item == null)
                    item = CollectionsFactory.createLiteralItem(Constants.valueFactory.createBNode(), namedGraphUri, dataset);
                Literal lit = null;
                if (o instanceof Literal)
                    lit = (Literal) o;
                else
                    lit = Constants.valueFactory.createTypedLiteral(o);
                ((LiteralItem) item).setItemData(lit);
            }

            if (isOrdered) {
                OrderedItem oitem = CollectionsFactory.createOrderedItem(item.resource(), namedGraphUri, dataset);
                if (lastItem == null) {
                    lastItem = oitem;
                } else {
                    lastItem.setNextItem(oitem);
                    oitem.setPreviousItem(lastItem);
                    lastItem = oitem;
                }
                OrderedItem firstItem = oc.getFirstItem();
                if (firstItem == null) {
                    oc.setFirstItem(oitem);
                }
                int size = oc.getCollectionSize().intValue();
                oc.setCollectionSize(Integer.valueOf(size + 1));
            }
            c.addItem(item);
            return true;
        } catch (JastorException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addAll(java.util.Collection collection) {
        if (nullCollection)
            throw new UnsupportedOperationException();
        Iterator it = collection.iterator();
        boolean success = true;
        while (it.hasNext()) {
            if (!add(it.next())) {
                success = false;
            }
        }
        return success;
    }

    public void clear() {
        if (nullCollection)
            throw new UnsupportedOperationException();
        Iterator it = iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public boolean contains(Object o) {
        if (nullCollection)
            return false;
        Iterator it = iterator();
        while (it.hasNext()) {
            if (o.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(java.util.Collection c) {
        if (nullCollection)
            return false;
        Iterator it = c.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        if (nullCollection)
            return true;
        if (isOrdered)
            return lastItem == null;
        else {
            try {
                java.util.Collection<Item> items = c.getItem();
                boolean empty = items.isEmpty();
                return empty;
            } catch (JastorException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    private Thing getThing(Thing res) {
        if (factoryClasses == null)
            return res;
        else {
            try {
                for (Method method : methods) {
                    // we can speed things up here caching the method perhaps
                    Thing thing = (Thing) method.invoke(null, new Object[] { res.resource(), res.graph().getNamedGraphUri(), dataset });
                    if (!(thing.getClass().equals(ThingImpl.class)))
                        return thing;
                }
            } catch (InvocationTargetException ite) {
                ite.printStackTrace();
                return res;
            } catch (IllegalAccessException ite) {
                ite.printStackTrace();
                return res;
            }
            return res;
        }
    }

    public Iterator iterator() {
        if (nullCollection)
            return Collections.unmodifiableList(new ArrayList()).iterator();
        if (isOrdered) {
            return new Iterator() {
                private OrderedItem currentItem = null;

                public void remove() {
                    CollectionWrapper.this.remove(currentItem);
                }

                public boolean hasNext() {
                    try {
                        if (currentItem == null)
                            return oc.getFirstItem() != null;
                        else
                            return currentItem.getNextItem() != null;
                    } catch (JastorException e) {
                        e.printStackTrace();
                        return false;
                    }
                }

                public Object next() {
                    if (!hasNext())
                        throw new NoSuchElementException();
                    try {
                        if (currentItem == null)
                            currentItem = oc.getFirstItem();
                        else
                            currentItem = currentItem.getNextItem();

                        Object toReturn = null;
                        if (currentItem.isRDFType(ResourceItem.TYPE)) {
                            ResourceItem resItem = CollectionsFactory.getResourceItem(currentItem.resource(), namedGraphUri, dataset);
                            toReturn = getThing(resItem.getItemObject());
                        } else if (currentItem.isRDFType(LiteralItem.TYPE)) {
                            LiteralItem literalItem = CollectionsFactory.getLiteralItem(currentItem.resource(), namedGraphUri, dataset);
                            Literal lit = literalItem.getItemData();
                            if (lit instanceof TypedLiteral) {
                                toReturn = ((TypedLiteral) lit).getNativeValue();
                            } else {
                                toReturn = lit.getLabel();
                            }
                        } else {
                            throw new RuntimeException("OrderedCollectionIterator supports only subclasses of ResourceItem and LiteralItem.");
                        }
                        return toReturn;
                    } catch (JastorException e) {
                        e.printStackTrace();
                        throw new NoSuchElementException();
                    }
                }
            };
        } else {
            try {
                final Iterator<Item> it = c.getItem().iterator();

                return new Iterator() {
                    private Item currentItem = null;

                    public void remove() {
                        CollectionWrapper.this.remove(currentItem);
                    }

                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    public Object next() {
                        if (!hasNext())
                            throw new NoSuchElementException();
                        try {
                            currentItem = it.next();

                            Object toReturn = null;
                            if (currentItem.isRDFType(ResourceItem.TYPE)) {
                                ResourceItem resItem = CollectionsFactory.getResourceItem(currentItem.resource(), namedGraphUri, dataset);
                                toReturn = getThing(resItem.getItemObject());
                            } else if (currentItem.isRDFType(LiteralItem.TYPE)) {
                                LiteralItem literalItem = CollectionsFactory.getLiteralItem(currentItem.resource(), namedGraphUri, dataset);
                                Literal lit = literalItem.getItemData();
                                if (lit instanceof TypedLiteral) {
                                    toReturn = ((TypedLiteral) lit).getNativeValue();
                                } else {
                                    toReturn = lit.getLabel();
                                }
                            } else {
                                throw new RuntimeException("OrderedCollectionIterator supports only subclasses of ResourceItem and LiteralItem.");
                            }
                            return toReturn;
                        } catch (JastorException e) {
                            e.printStackTrace();
                            throw new NoSuchElementException();
                        }
                    }
                };
            } catch (JastorException e) {
                e.printStackTrace();
                return null;
            }
        }

    }

    public boolean remove(Object o) {

        if (nullCollection)
            throw new UnsupportedOperationException();

        try {
            // find the item that contains the object
            Iterator<Item> it = c.getItem().iterator();
            Item item = null;
            while (it.hasNext()) {
                Item next = it.next();
                if (next.isRDFType(ResourceItem.TYPE)) {
                    if (o instanceof Thing) {
                        ResourceItem resItem = CollectionsFactory.getResourceItem(next.resource(), namedGraphUri, dataset);
                        if (resItem.getItemObject().equals(o)) {
                            item = resItem;
                            resItem.removeStatements();
                            break;
                        }
                    } else if (o instanceof Resource) {
                        ResourceItem resItem = CollectionsFactory.getResourceItem(next.resource(), namedGraphUri, dataset);
                        if (resItem.getItemObject().uri().equals(((URI) o).toString())) {
                            item = resItem;
                            resItem.removeStatements();
                            break;
                        }
                    }

                } else {
                    if (o instanceof Thing || o instanceof Resource)
                        continue;
                    LiteralItem litItem = CollectionsFactory.getLiteralItem(next.resource(), namedGraphUri, dataset);
                    Literal lit = litItem.getItemData();
                    if (lit instanceof PlainLiteral) {
                        if (litItem.getItemData().getLabel().equals(o.toString())) {
                            item = litItem;
                            litItem.removeStatements();
                            break;
                        }
                    } else {
                        TypedLiteral tl = (TypedLiteral) lit;
                        if (tl.getNativeValue().equals(o)) {
                            item = litItem;
                            litItem.removeStatements();
                            break;
                        }
                    }
                }
            }
            // the user may be attempting to remove an item that is not in the collection
            if (item != null) {

                c.removeItem(item);
                if (isOrdered) {
                    OrderedItem oItem = CollectionsFactory.getOrderedItem(item.resource(), namedGraphUri, dataset);
                    if (lastItem.equals(item)) {
                        lastItem = oItem.getPreviousItem();
                    }
                    if (oc.getFirstItem().equals(oItem)) {
                        oc.setFirstItem(oItem.getNextItem());
                    }
                    if (oItem.getPreviousItem() != null)
                        oItem.getPreviousItem().setNextItem(oItem.getNextItem());
                    if (oItem.getNextItem() != null)
                        oItem.getNextItem().setPreviousItem(oItem.getPreviousItem());
                    oc.setCollectionSize(Integer.valueOf(oc.getCollectionSize().intValue() - 1));
                    oItem.removeStatements();
                }
                return true;

            }
        } catch (JastorException e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    public boolean removeAll(java.util.Collection collection) {
        if (nullCollection)
            throw new UnsupportedOperationException();
        Iterator it = collection.iterator();
        boolean success = true;
        while (it.hasNext()) {
            if (!remove(it.next()))
                success = false;
        }
        return success;
    }

    public boolean retainAll(java.util.Collection collection) {
        if (nullCollection)
            throw new UnsupportedOperationException();
        Iterator it = iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next()))
                it.remove();
        }
        return true;
    }

    public int size() {
        if (nullCollection)
            return 0;
        try {
            if (isOrdered) {
                return oc.getCollectionSize().intValue();
            } else {
                return c.getItem().size();
            }
        } catch (JastorException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Object[] toArray() {
        if (nullCollection)
            return new Object[] {};
        List list = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            list.add(it.next());
        }
        return list.toArray();
    }

    public Object[] toArray(Object[] a) {
        if (nullCollection)
            return new Object[] {};
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            a[i++] = it.next();
        }
        return a;
    }

}
