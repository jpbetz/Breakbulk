/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/expression/builtin/RegEx.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: RegEx.java 164 2007-07-31 14:11:09Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.expression.builtin;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.exception.IncompatibleTypeException;
import org.openanzo.glitter.exception.InvalidArgumentCountException;
import org.openanzo.glitter.expression.ScalarFunctionBase;
import org.openanzo.glitter.expression.ScalarFunctionOnValues;
import org.openanzo.glitter.util.Constants;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.glitter.util.TypeConversions;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Constants.NAMESPACES;

/**
 * Implements <a href="http://www.w3.org/TR/rdf-sparql-query/#func-regEx">the SPARQL regex function</a>.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class RegEx extends ScalarFunctionBase implements ScalarFunctionOnValues {
    private final static HashMap<Character, Integer> flag_map;

    /**
     * Thrown for an unrecognized regular expression flag.
     * 
     * @author lee <lee@cambridgesemantics.com>
     * 
     */
    static class InvalidRegularExpressionFlagException extends ExpressionEvaluationException {
        private static final long serialVersionUID = 1656708447585086309L;

        /**
         * Default constructor.
         * 
         * @param s
         *            The invalid regex flag.
         */
        protected InvalidRegularExpressionFlagException(String s) {
            super(s);
        }
    }

    static {
        flag_map = new HashMap<Character, Integer>();
        flag_map.put('s', Pattern.DOTALL);
        flag_map.put('m', Pattern.MULTILINE);
        flag_map.put('i', Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        // java doesn't support x (extra whitespace)
        // flag_map.put('x', ...);
        // TODO - only type errors get suppressed by logical-or/and
    }

    public Value call(List<Value> arguments) throws ExpressionEvaluationException {
        int argCount = arguments.size();
        if (argCount < 2 || argCount > 3)
            throw new InvalidArgumentCountException(arguments.size(), 2, 3);
        Value inputTerm = arguments.get(0), patternTerm = arguments.get(1), flagsTerm = argCount == 3 ? arguments.get(2) : null;
        if (!TypeConversions.isSimpleLiteral(inputTerm))
            throw new IncompatibleTypeException(inputTerm, "simple literal");
        if (!TypeConversions.isSimpleLiteral(patternTerm))
            throw new IncompatibleTypeException(patternTerm, "simple literal");
        if (flagsTerm != null && !TypeConversions.isSimpleLiteral(flagsTerm))
            throw new IncompatibleTypeException(flagsTerm, "simple literal");

        String input = ((Literal) inputTerm).getLabel(), pattern = ((Literal) patternTerm).getLabel(), flags = flagsTerm != null ? ((Literal) flagsTerm).getLabel() : "";

        // TODO - not sure if Java reg. ex. matches the syntax/semantics of
        // XPath's fn:matches as per:
        //  http://www.w3.org/TR/xpath-functions/#regex-syntax
        int iFlags = 0;
        for (int i = 0; i < flags.length(); i++) {
            Integer val = flag_map.get(flags.charAt(i));
            if (val == null)
                throw new InvalidRegularExpressionFlagException(flags.charAt(i) + " is not a valid regular expression flag.");
            iFlags |= val;
        }
        Pattern regex = Pattern.compile(pattern, iFlags);
        Matcher matcher = regex.matcher(input);
        return matcher.find() ? Constants.TRUE : Constants.FALSE;
    }

    public URI getIdentifier() {
        return Glitter.createURI(NAMESPACES.FN_NAMESPACE + "matches");
    }

    @Override
    public String toString() {
        return "regex";
    }

}
