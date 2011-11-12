/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/query/PatternSolutionImpl.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: PatternSolutionImpl.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.openanzo.rdf.Bindable;
import org.openanzo.rdf.MemVariable;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Variable;

/**
 * Implements a {@link PatternSolution} as a {@link Map} from {@link Bindable} objects to {@link Value}s.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class PatternSolutionImpl implements PatternSolution, Serializable {
    private static final long             serialVersionUID = 905044318966590498L;

    private Bindable[]                    bindingsArray    = null;

    private Value[]                       valuesArray      = null;

    private final static Bindable[]       EMPTY_BINDABLES  = new Bindable[0];

    private final static Value[]          EMPTY_VALUES     = new Value[0];

    private boolean                       sorted           = false;

    private Map<OrderingCondition, Value> conditions;

    /**
     * Constructs an empty solution (no bindings).
     */
    public PatternSolutionImpl() {
    }

    /**
     * Constructs a solution with a single binding.
     * 
     * @param k
     *            The variable or blank node being bound.
     * @param v
     *            The bound value.
     */
    protected PatternSolutionImpl(Bindable k, Value v) {
        this.bindingsArray = new Bindable[] { k };
        this.valuesArray = new Value[] { v };
        this.sorted = true;
    }

    /**
     * Constructs a solution from a map of bindables and values.
     * 
     * @param m
     */
    public PatternSolutionImpl(Map<Bindable, Value> m) {
        this.bindingsArray = new Bindable[m.size()];
        this.valuesArray = new Value[m.size()];
        int i = 0;
        for (Map.Entry<Bindable, Value> entry : m.entrySet()) {
            this.bindingsArray[i] = entry.getKey();
            this.valuesArray[i] = entry.getValue();
            i++;
        }
    }

    /**
     * Constructs a solution from a map of bindables and values.
     * 
     * @param bindables
     * @param values
     */
    public PatternSolutionImpl(Bindable[] bindables, Value[] values) {
        this.bindingsArray = bindables;
        this.valuesArray = values;
    }

    /**
     * Clones an existing solution.
     * 
     * @param other
     *            The existing solution.
     */
    protected PatternSolutionImpl(PatternSolution other) {
        this.bindingsArray = other.getBoundDomainArray().clone();
        this.valuesArray = other.getBoundVariablesArray(false).clone();
    }

    public Bindable getBinding(int index) {
        return (bindingsArray != null) ? bindingsArray[index] : null;
    }

    public Value getValue(int index) {
        return (valuesArray != null) ? valuesArray[index] : null;
    }

    /*@Override
    public String toString() {
        return this.bindings.toString();
    }*/

    public void setBinding(Bindable k, Value v) {
        if (bindingsArray == null) {
            bindingsArray = new Bindable[] { k };
            valuesArray = new Value[] { v };
            this.sorted = true;
            return;
        }
        if (v != null) {
            for (int i = 0; i < bindingsArray.length; i++) {
                if (bindingsArray[i].equals(k)) {
                    valuesArray[i] = v;
                    return;
                }
            }
            this.sorted = false;
            Bindable[] newBindings = new Bindable[bindingsArray.length + 1];
            System.arraycopy(bindingsArray, 0, newBindings, 0, bindingsArray.length);
            newBindings[bindingsArray.length] = k;
            Value[] newValues = new Value[valuesArray.length + 1];
            System.arraycopy(valuesArray, 0, newValues, 0, valuesArray.length);
            newValues[valuesArray.length] = v;
            bindingsArray = newBindings;
            valuesArray = newValues;
        } else {
            for (int i = 0; i < bindingsArray.length; i++) {
                if (bindingsArray[i].equals(k)) {
                    this.sorted = false;
                    Bindable[] newBindings = new Bindable[bindingsArray.length - 1];
                    if (i > 0) {
                        System.arraycopy(bindingsArray, 0, newBindings, 0, i);
                    }
                    if (i < bindingsArray.length) {
                        System.arraycopy(bindingsArray, i + 1, newBindings, i, newBindings.length - i);
                    }
                    Value[] newValues = new Value[valuesArray.length - 1];
                    if (i > 0) {
                        System.arraycopy(valuesArray, 0, newValues, 0, i);
                    }
                    if (i < valuesArray.length) {
                        System.arraycopy(valuesArray, i + 1, newValues, i, newValues.length - i);
                    }
                    bindingsArray = newBindings;
                    valuesArray = newValues;
                    break;
                }
            }
        }
    }

    /*
        public void removeBinding(Bindable variable) {
            this.bindings.remove(variable);
            this.sorted = false;
            this.bindingsArray = null;
        }
    */

    public Value getBinding(Bindable variable) {
        if (bindingsArray != null) {
            for (int i = 0; i < bindingsArray.length; i++) {
                if (bindingsArray[i].equals(variable)) {
                    return valuesArray[i];
                }
            }
        }
        return null;
    }

    public Value getBinding(String variableName) {
        return getBinding(MemVariable.createVariable(variableName));
    }

    public void sort() {
        if (!this.sorted) {
            if (bindingsArray != null && bindingsArray.length > 1) {
                mergeSortArray(bindingsArray, valuesArray, 0, bindingsArray.length);
            }
            this.sorted = true;
        }
    }

    public Bindable[] getBoundDomain(boolean sort) {
        if (sort) {
            sort();
        }
        return (this.bindingsArray != null) ? this.bindingsArray : EMPTY_BINDABLES;
    }

    public int size() {
        return (bindingsArray != null) ? this.bindingsArray.length : 0;
    }

    public Bindable[] getBoundDomainArray() {
        return getBoundDomain(true);
    }

    public Value[] getBoundVariablesArray(boolean sort) {
        if (this.valuesArray == null) {
            return EMPTY_VALUES;
        }
        if (sort) {
            sort();
        }
        return this.valuesArray;
    }

    // this downcast filter+map can't be done with generics because
    // the generic types are lost at runtime so instanceof cannot be
    // used with a generic argument as an operand
    public Collection<Variable> getBoundVariables() {
        ArrayList<Variable> vs = new ArrayList<Variable>();
        if (bindingsArray != null) {
            for (Bindable b : bindingsArray) {
                if (b instanceof Variable) {
                    vs.add((Variable) b);
                }
            }
        }
        return vs;
    }

    /* public PatternSolution conjoin(PatternSolution other) {
         Map<Bindable, Value> conjunction = new HashMap<Bindable, Value>();
         conjunction.putAll(this.bindings);
         for (Bindable var : other.getBoundDomain(false)) {
             Value otherVal = other.getBinding(var);
             Value thisVal = this.getBinding(var);
             // if this variable is bound in the other one and not bound to the
             // same term in this one, then the solutions are mutually exclusive
             if (otherVal != null && thisVal != null && !otherVal.equals(thisVal))
                 return null;
             if (otherVal != null)
                 conjunction.put(var, otherVal);
         }
         return new PatternSolutionImpl(conjunction);
     }*/

    public int compareTo(PatternSolution o) {
        if (o.size() > this.size())
            return 1;
        if (o.size() < this.size())
            return -1;
        sort();
        o.sort();
        for (int i = 0; i < size(); i++) {
            Bindable b1 = getBinding(i);
            Bindable b2 = o.getBinding(i);

            if (!b1.equals(b2))
                return b1.compareTo(b2);

            Value v1 = getValue(i);
            Value v2 = o.getValue(i);

            if (v2 == null)
                return -1;
            int r = v1.compareTo(v2);
            if (r != 0)
                return r;
        }
        return 0;
    }

    protected static boolean containMatchingBindings(PatternSolution p1, PatternSolution p2) {
        if (p1.size() != p2.size())
            return false;

        boolean matches = true;
        for (Bindable v : p1.getBoundDomainArray()) {
            Value iterm = p2.getBinding(v);
            Value jterm = p1.getBinding(v);
            if (!((iterm == null && jterm == null) || (iterm != null && jterm != null && iterm.equals(jterm)))) {
                matches = false;
                break;
            }
        }
        return matches;
    }

    public boolean bindsAllVariables(Collection<Variable> variables) {
        if (variables != null && bindingsArray == null)
            return false;
        if (variables == null)
            return true;
        for (Variable var : variables) {
            boolean ok = false;
            for (int i = 0; !ok && i < bindingsArray.length; i++) {
                if (bindingsArray[i].equals(var)) {
                    ok = true;
                }
            }
            if (!ok)
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (bindingsArray == null) {
            return super.hashCode();
        }
        int hc = 0;
        for (Bindable b : bindingsArray) {
            hc += b.hashCode();
        }
        for (Value v : valuesArray) {
            hc += v.hashCode();
        }
        return hc;
    }

    @Override
    public boolean equals(Object arg0) {
        if (this == arg0)
            return true;
        if (arg0 == null)
            return false;
        if (arg0 instanceof PatternSolution) {
            PatternSolution ps2 = (PatternSolution) arg0;
            if (size() != ps2.size())
                return false;
            for (Bindable v : getBoundDomainArray()) {
                Value iterm = getBinding(v);
                Value jterm = ps2.getBinding(v);
                if (iterm == null && jterm == null) {
                } else if (iterm != null && jterm != null) {
                    if (!iterm.equals(jterm)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Used to provide a stable sort to two {@link PatternSolution}s. This orders a solution with a common term (from the other solution set) first if the other
     * solution doesn't contain that bindable... It ensures that solutions with common terms are earlier in the sort order.
     * 
     * @author lee <lee@cambridgesemantics.com>
     * 
     */
    static class SetSolutionComparator implements Comparator<PatternSolution> {
        private final Set<Bindable>     matches;

        private final Comparator<Value> comparator;

        protected SetSolutionComparator(Set<Bindable> matches, Comparator<Value> comparator) {
            this.matches = matches;
            this.comparator = comparator;
        }

        public int compare(PatternSolution o1, PatternSolution o2) {
            for (Bindable b : this.matches) {
                Value term2 = o2.getBinding(b);
                Value term1 = o1.getBinding(b);
                if (term1 != null || term2 != null) {
                    if (term1 == null)
                        return 1;
                    if (term2 == null)
                        return -1;

                    int r = comparator.compare(term1, term2);
                    if (r != 0) {
                        return r;
                    }
                }
            }
            return 0;
        }
    }

    /* Copyright (c) 2009 the authors listed at the following URL, and/or
    the authors of referenced articles or incorporated external code:
    http://en.literateprograms.org/Merge_sort_(Java)?action=history&offset=20080109204500

    Permission is hereby granted, free of charge, to any person obtaining
    a copy of this software and associated documentation files (the
    "Software"), to deal in the Software without restriction, including
    without limitation the rights to use, copy, modify, merge, publish,
    distribute, sublicense, and/or sell copies of the Software, and to
    permit persons to whom the Software is furnished to do so, subject to
    the following conditions:

    The above copyright notice and this permission notice shall be
    included in all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
    EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
    MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
    IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
    CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
    TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
    SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

    Retrieved from: http://en.literateprograms.org/Merge_sort_(Java)?oldid=12004
    */

    private static final int minMergeSortListSize = 32;

    private static void mergeSortArray(Bindable[] bindables, Value[] values, int start, int end) {

        if ((end - start) < minMergeSortListSize) {
            /* Use insertion sort for small datasets. */
            for (int i = start; i < end; i++) {
                int j = 0;
                Bindable b = bindables[i];
                Value v = values[i];
                //Value 
                for (j = i - 1; j >= 0; j--) {
                    if (bindables[j].compareTo(b) < 1)
                        break;
                    bindables[j + 1] = bindables[j];
                    values[j + 1] = values[j];
                }
                bindables[j + 1] = b;
                values[j + 1] = v;
            }
            return;
        }

        mergeSortArray(bindables, values, start, start + ((end - start) / 2));
        mergeSortArray(bindables, values, start + ((end - start) / 2), end);
        Bindable[] tempBindable = new Bindable[end];
        Value[] tempValue = new Value[end];
        int i1, i2, tempi;

        i1 = 0;
        i2 = end / 2;
        tempi = 0;
        while (i1 < end / 2 && i2 < end) {
            if (bindables[i1].compareTo(bindables[i2]) < 0) {
                tempBindable[tempi++] = bindables[i1++];
                tempValue[tempi++] = values[i1++];
            } else {
                tempBindable[tempi++] = bindables[i2++];
                tempValue[tempi++] = values[i2++];
            }
        }

        while (i1 < end / 2) {
            int a = tempi++;
            int b = i1++;
            tempBindable[a] = bindables[b];
            tempValue[a] = values[b];
        }
        while (i2 < end) {
            int a = tempi++;
            int b = i2++;
            tempBindable[a] = bindables[b];
            tempValue[a] = values[b];
        }

        System.arraycopy(tempBindable, start, bindables, start, end - start);
        System.arraycopy(tempValue, start, values, start, end - start);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nSolution:" + super.toString() + "\n");
        for (Bindable b : getBoundVariables()) {
            sb.append("\t" + b + "=" + getBinding(b) + "\n");
        }
        return sb.toString();
    }

    public void clearConditions() {
        if (conditions != null) {
            conditions.clear();
        }
    }

    public Value getCondition(OrderingCondition condition) {
        return conditions != null ? conditions.get(condition) : null;
    }

    public Value setCondition(OrderingCondition condition, Value value) {
        if (conditions == null) {
            conditions = new LinkedHashMap<OrderingCondition, Value>();
        }
        conditions.put(condition, value);
        return value;
    }
}
