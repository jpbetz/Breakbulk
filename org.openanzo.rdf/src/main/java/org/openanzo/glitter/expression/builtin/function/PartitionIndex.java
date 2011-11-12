/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/builtin/cast/XSDInteger.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: XSDInteger.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression.builtin.function;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;

import org.openanzo.glitter.exception.IncompatibleTypeException;
import org.openanzo.glitter.exception.MalformedLiteralException;
import org.openanzo.glitter.expression.TertiaryFunction;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.glitter.util.PolymorphicNumber;
import org.openanzo.glitter.util.TypeConversions;
import org.openanzo.rdf.MemTypedLiteral;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.vocabulary.XMLSchema;

/**
 * glitter:partitionIndex(value as literal, start as literal, interval as literal)
 * 
 * Returns the zero-based index of the 'bucket' in which 'value' falls, given buckets that start at 'start' and are of size 'interval'. The first bucket is
 * [start, start+interval) - closed on the low end and open on the high end. Returns less than 0 if the 'value' does not fall in any bucket such as when 'value'
 * is less than 'start' or if the comparison is indeterminate for date and time types.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class PartitionIndex extends TertiaryFunction {

    private static final double EPSILON = 1E-6;

    @Override
    public Value call(Value value, Value start, Value interval) throws IncompatibleTypeException {
        // all values need to be typed literals
        if (!(value instanceof TypedLiteral))
            throw new IncompatibleTypeException(value, "typed literal compatible with the interval value types");
        if (!(start instanceof TypedLiteral))
            throw new IncompatibleTypeException(start, "typed literal compatible with the interval value types");
        if (!(interval instanceof TypedLiteral))
            throw new IncompatibleTypeException(interval, "typed literal that can be added to the interval value types");
        // if we're dealing in numerics, we can do this easily using maths
        if (TypeConversions.isNumeric(value) && TypeConversions.isNumeric(start) && TypeConversions.isNumeric(interval)) {
            // floor((value - start) / interval)
            // Example: value = 11, start = 2, interval = 3
            //   0: [2,5)
            //   1: [5,8)
            //   2: [8,11)
            //   3: [11,14)
            PolymorphicNumber n = new PolymorphicNumber(value).subtract(new PolymorphicNumber(start)).divide(new PolymorphicNumber(interval));
            Long l = null;
            if (!n.convertsSafelyToLong()) {
                l = Math.round(Math.floor(n.doubleValue() + EPSILON));
            } else {
                l = n.longValue();
            }
            return MemTypedLiteral.create(Long.toString(l), XMLSchema.INTEGER);
        }
        // if we have dates and a duration, we can also do this, but we have to do it the long way - this is potentially
        // very slow
        if (TypeConversions.isDateTimeType(value) && TypeConversions.isDateTimeType(start) && TypeConversions.isDuration(interval)) {
            long bucket = -1;
            XMLGregorianCalendar currentBucketLow;
            try {
                currentBucketLow = (XMLGregorianCalendar) ((TypedLiteral) start).getNativeValue();
            } catch (IllegalArgumentException iae) {
                throw new MalformedLiteralException(start, "xsd:dateTime or xsd:date or xsd:time");
            }
            XMLGregorianCalendar target;
            try {
                target = (XMLGregorianCalendar) ((TypedLiteral) value).getNativeValue();
            } catch (IllegalArgumentException iae) {
                throw new MalformedLiteralException(value, "xsd:duration, xsd:dayTimeDuration, or xsd:dayTimeDuration");
            }
            Duration duration;
            try {
                duration = (Duration) ((TypedLiteral) interval).getNativeValue();
            } catch (IllegalArgumentException iae) {
                throw new MalformedLiteralException(interval, "xsd:dateTime or xsd:date or xsd:time");
            }
            if (currentBucketLow == null)
                throw new MalformedLiteralException(start, "xsd:dateTime or xsd:date or xsd:time");
            if (target == null)
                throw new MalformedLiteralException(value, "xsd:dateTime or xsd:date or xsd:time");
            if (duration == null)
                throw new MalformedLiteralException(interval, "xsd:duration, xsd:dayTimeDuration, or xsd:dayTimeDuration");

            long cmp;
            // comparison indicates the direction we expect we're going to move as we increment towards the target
            int comparison = duration.getSign() * DatatypeConstants.GREATER;
            XMLGregorianCalendar startBucketLow = (XMLGregorianCalendar) currentBucketLow.clone();
            while ((cmp = target.compare(currentBucketLow)) == comparison) {
                currentBucketLow.add(duration);
                bucket++;
                // if the buckets "wrap around", call it quits
                if (currentBucketLow.compare(startBucketLow) != comparison) {
                    bucket = -1; // we don't have a proper bucket here
                    break;
                }

            }
            // when we exit the loop, target is now <= the currentBucketLow. If it's equal, we're actually in the
            // next bucket
            return MemTypedLiteral.create(Long.toString(bucket + (cmp == DatatypeConstants.EQUAL ? 1 : 0)), XMLSchema.INTEGER);
        }

        throw new IncompatibleTypeException(value, "numeric or date typed literals and compatible intervals");
    }

    public URI getIdentifier() {
        return Glitter.createURI(NAMESPACES.GLITTER_FUNCTION_NAMESPACE + "partitionIndex");
    }

}
