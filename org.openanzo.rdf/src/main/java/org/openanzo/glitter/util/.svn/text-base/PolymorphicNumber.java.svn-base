/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/util/PolymorphicNumber.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: PolymorphicNumber.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import org.openanzo.rdf.MemTypedLiteral;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.TypedLiteral;

/**
 * A {@link PolymorphicNumber} handles math operations on numeric types that may require type promotion and coercion.
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
final public class PolymorphicNumber extends Number implements Comparable<PolymorphicNumber> {

    /**
     * Constant 0.
     */
    static final protected PolymorphicNumber ZERO               = new PolymorphicNumber(0);

    private static final long                serialVersionUID   = 3835267671359590129L;

    private final Number                     number;

    private Long                             numberAsLong       = null;

    private BigInteger                       numberAsBigInteger = null;

    private Double                           numberAsDouble     = null;

    private BigDecimal                       numberAsBigDecimal = null;

    private MathOps                          ops                = null;

    /**
     * Create a {@link PolymorphicNumber} from a Java {@link Number}.
     *
     * @param n
     *            {@link Number} to create from
     */
    public PolymorphicNumber(Number n) {
        this.number = n;
    }

    /**
     * Create a {@link PolymorphicNumber} from the numeric value of a Glitter term.
     *
     * @param tpc
     *            TriplePatternComponent to create from
     */
    public PolymorphicNumber(TriplePatternComponent tpc) {
        this.number = (Number) ((TypedLiteral) tpc).getNativeValue();
    }

    /**
     * Get the value of this number in narrowest (most specific) representation for its type.
     *
     * @return The value of this number in narrowest (most specific) representation for its type.
     */
    private Number narrowestValue() {
        return getOps().narrowestValue();
    }

    /**
     * Get the value of this number in its narrowest form wrapped as a {@link TypedLiteral}
     *
     * @return The value of this number in its narrowest form wrapped as a {@link TypedLiteral}.
     */
    public TypedLiteral asTypedLiteral() {
        return MemTypedLiteral.create(narrowestValue());
    }

    /**
     * Polymorphic addition.
     *
     * @param other
     *            PolymorphicNumber to add to this PolymorphicNumber
     * @return PolymorphicNumber that is the product of adding this PolymorphicNumber and the other PolymorphicNumber
     */
    public PolymorphicNumber add(PolymorphicNumber other) {
        return getOps(other).add(other);
    }

    /**
     * Polymorphic subtraction.
     *
     * @param other
     *            PolymorphicNumber to subtract from this PolymorphicNumber
     * @return PolymorphicNumber that is the product of subtracting this PolymorphicNumber and the other PolymorphicNumber
     */
    public PolymorphicNumber subtract(PolymorphicNumber other) {
        return getOps(other).subtract(other);
    }

    /**
     * Polymorphic multiplication.
     *
     * @param other
     *            PolymorphicNumber to multiply with this PolymorphicNumber
     * @return PolymorphicNumber that is the product of multiplying this PolymorphicNumber and the other PolymorphicNumber
     */
    public PolymorphicNumber multiply(PolymorphicNumber other) {
        return getOps(other).multiply(other);
    }

    /**
     * Polymorphic division.
     *
     * @param other
     *            PolymorphicNumber to divide from this PolymorphicNumber
     * @return PolymorphicNumber that is the product of dividing this PolymorphicNumber and the other PolymorphicNumber
     */
    public PolymorphicNumber divide(PolymorphicNumber other) {
        return getOps(other).divide(other);
    }

    /**
     * Polymorphic numeric negation.
     *
     * @return PolymorphicNumber that is the negation of this PolymorphicNumber
     */
    public PolymorphicNumber negate() {
        return getOps().negate();
    }

    public int compareTo(PolymorphicNumber other) {
        return getOps(other).compareTo(other);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof PolymorphicNumber)
            return compareTo((PolymorphicNumber) o) == 0;
        return false;
    }

    @Override
    public int hashCode() {
        return this.number.hashCode();
    }

    // extraction
    /**
     * @return A representation of this number as a {@link BigInteger}
     */
    public BigInteger bigIntegerValue() {
        if (this.numberAsBigInteger == null) {
            if (this.number instanceof BigInteger)
                this.numberAsBigInteger = (BigInteger) this.number;
            else if (this.number instanceof BigDecimal)
                this.numberAsBigInteger = ((BigDecimal) this.number).toBigInteger();
            else
                this.numberAsBigInteger = BigInteger.valueOf(longValue());
        }
        return this.numberAsBigInteger;
    }

    /**
     *
     * @return A representation of this number as a {@link BigDecimal}.
     */
    public BigDecimal bigDecimalValue() {
        if (this.numberAsBigDecimal == null) {
            if (this.number instanceof BigDecimal)
                this.numberAsBigDecimal = (BigDecimal) this.number;
            else if (this.number instanceof BigInteger)
                this.numberAsBigDecimal = new BigDecimal((BigInteger) this.number);
            else if (convertsSafelyToLong())
                this.numberAsBigDecimal = BigDecimal.valueOf(longValue());
            else
                this.numberAsBigDecimal = BigDecimal.valueOf(doubleValue());
        }
        return this.numberAsBigDecimal;
    }

    ////////////////////////////////////////////////
    // java.lang.Number
    //
    @Override
    public double doubleValue() {
        if (this.numberAsDouble == null)
            this.numberAsDouble = this.number.doubleValue();
        return this.numberAsDouble;
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public int intValue() {
        return (int) longValue();
    }

    @Override
    public long longValue() {
        if (this.numberAsLong == null)
            this.numberAsLong = this.number.longValue();
        return this.numberAsLong;
    }

    //////////////////////////////////////////////////

    /**
     * @return Whether this number is an integer that fits into a long
     */
    public boolean convertsSafelyToLong() {
        return this.number instanceof Byte || this.number instanceof Short || this.number instanceof Integer || this.number instanceof Long;
    }

    /**
     * @return Whether this number can safely fit into a double precision floating point number
     */
    public boolean convertsSafelyToDouble() {
        return convertsSafelyToLong() || this.number instanceof Float || this.number instanceof Double;
    }

    private MathOps getOps() {
        if (this.ops == null) {
            if (convertsSafelyToLong())
                this.ops = new LongOps();
            else if (convertsSafelyToDouble())
                this.ops = new DoubleOps();
            else if (this.number instanceof BigInteger)
                this.ops = new BigIntegerOps();
            else
                this.ops = new BigDecimalOps();
        }
        return this.ops;
    }

    // even if they are wider, we need to return an ops
    // attached to ourselves since we're the first argument
    // in whatever operation is going on
    private MathOps getOps(PolymorphicNumber other) {
        MathOps us = getOps(), them = other.getOps();
        if (us instanceof BigDecimalOps)
            return us;
        if (them instanceof BigDecimalOps)
            return new BigDecimalOps();
        if (us instanceof BigIntegerOps)
            return us;
        if (them instanceof BigIntegerOps)
            return new BigIntegerOps();
        if (us instanceof DoubleOps)
            return us;
        if (them instanceof DoubleOps)
            return new DoubleOps();
        return us;
    }

    //////////////////////////////////////////////////
    private interface MathOps {

        /**
         * A specific (by type) addition operation.
         *
         * @param other
         *            PolymorphicNumber to add to this PolymorphicNumber
         * @return PolymorphicNumber that is the product of adding this PolymorphicNumber and the other PolymorphicNumber
         */
        public PolymorphicNumber add(PolymorphicNumber other);

        /**
         * A specific (by type) subtraction operation.
         *
         * @param other
         *            PolymorphicNumber to subtract from this PolymorphicNumber
         * @return PolymorphicNumber that is the product of subtracting this PolymorphicNumber and the other PolymorphicNumber
         */
        public PolymorphicNumber subtract(PolymorphicNumber other);

        /**
         * A specific (by type) multiplication operation.
         *
         * @param other
         *            PolymorphicNumber to multiply with this PolymorphicNumber
         * @return PolymorphicNumber that is the product of multiplying this PolymorphicNumber and the other PolymorphicNumber
         */
        public PolymorphicNumber multiply(PolymorphicNumber other);

        /**
         * A specific (by type) division operation.
         *
         * @param other
         *            PolymorphicNumber to divide from this PolymorphicNumber
         * @return PolymorphicNumber that is the product of dividing this PolymorphicNumber and the other PolymorphicNumber
         */
        public PolymorphicNumber divide(PolymorphicNumber other);

        /**
         * A specific (by type) mod operation.
         *
         * @param other
         *            PolymorphicNumber to mod from this PolymorphicNumber
         * @return PolymorphicNumber that is the product of mod this PolymorphicNumber and the other PolymorphicNumber
         */
        public PolymorphicNumber mod(PolymorphicNumber other);

        /**
         * A specific (by type) numeric negation operation.
         *
         * @return PolymorphicNumber that is the negation of this PolymorphicNumber
         */
        public PolymorphicNumber negate();

        /**
         * A specific (by type) comparison operation.
         *
         * @param other
         *            PolymorphicNumber to compare against
         * @return results of comparing to another PolymorphicNumber
         */
        public int compareTo(PolymorphicNumber other);

        /**
         * Extract the number as the narrowest {@link Number} subclass that it requires.
         *
         * @return The value of this number in narrowest (most specific) representation for its type.
         */
        public Number narrowestValue();
    }

    private class LongOps implements MathOps {

        public PolymorphicNumber add(PolymorphicNumber other) {
            return new PolymorphicNumber(longValue() + other.longValue());
        }

        public int compareTo(PolymorphicNumber other) {
            return Long.valueOf(longValue()).compareTo(other.longValue());
        }

        public PolymorphicNumber divide(PolymorphicNumber other) {
            return new PolymorphicNumber(doubleValue() / other.doubleValue());
        }

        public PolymorphicNumber mod(PolymorphicNumber other) {
            return new PolymorphicNumber(longValue() % other.longValue());
        }

        public PolymorphicNumber multiply(PolymorphicNumber other) {
            return new PolymorphicNumber(longValue() * other.longValue());
        }

        public PolymorphicNumber negate() {
            return new PolymorphicNumber(-longValue());
        }

        public Number narrowestValue() {
            return longValue();
        }

        public PolymorphicNumber subtract(PolymorphicNumber other) {
            return new PolymorphicNumber(longValue() - other.longValue());
        }
    }

    private class DoubleOps implements MathOps {

        public PolymorphicNumber add(PolymorphicNumber other) {
            return new PolymorphicNumber(doubleValue() + other.doubleValue());
        }

        public int compareTo(PolymorphicNumber other) {
            return new Double(doubleValue()).compareTo(other.doubleValue());
        }

        public PolymorphicNumber divide(PolymorphicNumber other) {
            return new PolymorphicNumber(doubleValue() / other.doubleValue());
        }

        public PolymorphicNumber mod(PolymorphicNumber other) {
            return new PolymorphicNumber(doubleValue() % other.doubleValue());
        }

        public PolymorphicNumber multiply(PolymorphicNumber other) {
            return new PolymorphicNumber(doubleValue() * other.doubleValue());
        }

        public PolymorphicNumber negate() {
            return new PolymorphicNumber(-doubleValue());
        }

        public Number narrowestValue() {
            return doubleValue();
        }

        public PolymorphicNumber subtract(PolymorphicNumber other) {
            return new PolymorphicNumber(doubleValue() - other.doubleValue());
        }
    }

    private class BigIntegerOps implements MathOps {

        public PolymorphicNumber add(PolymorphicNumber other) {
            return new PolymorphicNumber(bigIntegerValue().add(other.bigIntegerValue()));
        }

        public int compareTo(PolymorphicNumber other) {
            return bigIntegerValue().compareTo(other.bigIntegerValue());
        }

        public PolymorphicNumber divide(PolymorphicNumber other) {
            BigDecimal first = bigDecimalValue();
            BigDecimal second = other.bigDecimalValue();
            try {
               return new PolymorphicNumber(first.divide(second));
            } catch (ArithmeticException e) {
               return new PolymorphicNumber(first.divide(second, 20, RoundingMode.HALF_UP));
            }
        }

        public PolymorphicNumber mod(PolymorphicNumber other) {
            return new PolymorphicNumber(bigIntegerValue().mod(other.bigIntegerValue()));
        }

        public PolymorphicNumber multiply(PolymorphicNumber other) {
            return new PolymorphicNumber(bigIntegerValue().multiply(other.bigIntegerValue()));
        }

        public PolymorphicNumber negate() {
            return new PolymorphicNumber(bigIntegerValue().negate());
        }

        public Number narrowestValue() {
            return bigIntegerValue();
        }

        public PolymorphicNumber subtract(PolymorphicNumber other) {
            return new PolymorphicNumber(bigIntegerValue().subtract(other.bigIntegerValue()));
        }
    }

    private class BigDecimalOps implements MathOps {

        public PolymorphicNumber add(PolymorphicNumber other) {
            return new PolymorphicNumber(bigDecimalValue().add(other.bigDecimalValue()));
        }

        public int compareTo(PolymorphicNumber other) {
            return bigDecimalValue().compareTo(other.bigDecimalValue());
        }

        public PolymorphicNumber divide(PolymorphicNumber other) {
            BigDecimal first = bigDecimalValue();
            BigDecimal second = other.bigDecimalValue();
            try {
               return new PolymorphicNumber(first.divide(second));
            } catch (ArithmeticException e) {
               return new PolymorphicNumber(first.divide(second, 20, RoundingMode.HALF_UP));
            }
        }

        public PolymorphicNumber mod(PolymorphicNumber other) {
            // TODO - this isn't correct
            return new PolymorphicNumber(bigDecimalValue().remainder(other.bigDecimalValue()));
        }

        public PolymorphicNumber multiply(PolymorphicNumber other) {
            return new PolymorphicNumber(bigDecimalValue().multiply(other.bigDecimalValue()));
        }

        public PolymorphicNumber negate() {
            return new PolymorphicNumber(bigDecimalValue().negate());
        }

        public Number narrowestValue() {
            return bigDecimalValue();
        }

        public PolymorphicNumber subtract(PolymorphicNumber other) {
            return new PolymorphicNumber(bigDecimalValue().subtract(other.bigDecimalValue()));
        }
    }
}
