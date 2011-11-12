/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/SolutionList.java,v $
 * Created by: Lee Feigenbaum ( <a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com </a>)
 * Created on: Nov 25, 2006
 * Revision: $Id: SolutionList.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors:
 * IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.openanzo.exceptions.AnzoRuntimeException;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.Bindable;
import org.openanzo.rdf.Variable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An implementation of {@link SolutionSet} using an {@link ArrayList} of {@link PatternSolution}s.
 * 
 * @author lee
 */
public class SolutionList implements SolutionSet {
    private static final long           serialVersionUID = -7821232437112225676L;

    private static final Logger         log              = LoggerFactory.getLogger(SolutionList.class);

    private final List<PatternSolution> solutions;

    protected List<Bindable>            bindings;

    static int                          MAX_SIZE;
    static {
        if (System.getProperty("maxGlitterSolutions") != null) {
            try {
                MAX_SIZE = Integer.parseInt(System.getProperty("maxGlitterSolutions"));
            } catch (NumberFormatException nfe) {
                log.error(LogUtils.GLITTER_MARKER, "Number format exception parsing max glitter solutions:" + System.getProperty("maxGlitterSolutions"), nfe);
                MAX_SIZE = Integer.MAX_VALUE;
            }
        } else {
            MAX_SIZE = Integer.MAX_VALUE;
        }
    }

    private final int                   maxSize;

    /**
     * Constructs a solution set with no solutions.
     */
    public SolutionList() {
        this(MAX_SIZE);
    }

    /**
     * Constructs a solution set with no solutions.
     * 
     * @param maxSize
     *            maxSize of list
     */
    public SolutionList(int maxSize) {
        this.bindings = new ArrayList<Bindable>();
        this.solutions = new ArrayList<PatternSolution>();
        this.maxSize = maxSize;
    }

    /**
     * Clones the given list of solutions.
     * 
     * @param solutions
     */
    protected SolutionList(List<PatternSolution> solutions) {
        this();
        this.solutions.addAll(solutions);
    }

    /**
     * Clones the given list of solutions.
     * 
     * @param solutions
     */
    protected SolutionList(int maxSize, List<PatternSolution> solutions) {
        this(maxSize);
        this.solutions.addAll(solutions);
    }

    public SolutionSet slice(int startInclusive, int endExclusive) {
        if (startInclusive >= this.solutions.size())
            return new SolutionList(maxSize);
        return new SolutionList(maxSize, this.solutions.subList(startInclusive, endExclusive));
    }

    private void checkSize(int size) {
        if (size > maxSize) {
            throw new AnzoRuntimeException(ExceptionConstants.GLITTER.TOO_MANY_SOLUTIONS, Integer.toString(size));
        }
    }

    /////////////////////////////////////
    // delegate methods to this.solutions
    /////////////////////////////////////
    public void add(int index, PatternSolution element) {
        checkSize(this.solutions.size());
        this.solutions.add(index, element);
    }

    public boolean add(PatternSolution o) {
        checkSize(this.solutions.size());
        return this.solutions.add(o);
    }

    public boolean addAll(Collection<? extends PatternSolution> c) {
        checkSize(this.solutions.size());
        return this.solutions.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends PatternSolution> c) {
        checkSize(this.solutions.size() + c.size());
        return this.solutions.addAll(index, c);
    }

    public void clear() {
        this.solutions.clear();
    }

    public boolean contains(Object o) {
        return this.solutions.contains(o);
    }

    public boolean containsAll(Collection<?> c) {
        return this.solutions.containsAll(c);
    }

    @Override
    public boolean equals(Object o) {
        return this.solutions.equals(o);
    }

    public PatternSolution get(int index) {
        return this.solutions.get(index);
    }

    @Override
    public int hashCode() {
        return this.solutions.hashCode();
    }

    public int indexOf(Object o) {
        return this.solutions.indexOf(o);
    }

    public boolean isEmpty() {
        return this.solutions.isEmpty();
    }

    public Iterator<PatternSolution> iterator() {
        return this.solutions.iterator();
    }

    public int lastIndexOf(Object o) {
        return this.solutions.lastIndexOf(o);
    }

    public ListIterator<PatternSolution> listIterator() {
        return this.solutions.listIterator();
    }

    public ListIterator<PatternSolution> listIterator(int index) {
        return this.solutions.listIterator(index);
    }

    public PatternSolution remove(int index) {
        return this.solutions.remove(index);
    }

    public boolean remove(Object o) {
        return this.solutions.remove(o);
    }

    public boolean removeAll(Collection<?> c) {
        return this.solutions.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return this.solutions.retainAll(c);
    }

    public PatternSolution set(int index, PatternSolution element) {
        return this.solutions.set(index, element);
    }

    public int size() {
        return this.solutions.size();
    }

    public List<PatternSolution> subList(int fromIndex, int toIndex) {
        return this.solutions.subList(fromIndex, toIndex);
    }

    public Object[] toArray() {
        return this.solutions.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return this.solutions.toArray(a);
    }

    @Override
    public String toString() {
        String s = "{";
        boolean first = true;
        for (PatternSolution ps : this.solutions) {
            if (!first)
                s += ", ";
            else
                first = false;
            s += ps.toString();
        }
        return s += "}";
    }

    public List<String> getBindingNames() {
        List<Bindable> bindings = getBindings();
        List<String> results = new ArrayList<String>();
        for (Bindable binding : bindings) {
            String name;
            if (binding instanceof Variable) {
                name = ((Variable) binding).getName();
            } else {
                name = binding.toString();

            }
            results.add(name);
        }
        return results;
    }

    public List<Bindable> getBindings() {
        return bindings;
    }
}
