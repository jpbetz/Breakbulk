/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.rdf.utils;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 * String escaping utilities
 * 
 */
public class StringEscapeUtils {
    /**
     * Escape a regex expression
     * 
     * @param string
     *            expression to escape
     * @return escaped expression
     */
    public static String escapeRegex(String string) {
        StringBuilder result = new StringBuilder();
        StringCharacterIterator iter = new StringCharacterIterator(string);

        char c = iter.current();
        while (c != CharacterIterator.DONE) {
            switch (c) {
            case '.':
                result.append("\\.");
                break;
            case '\\':
                result.append("\\\\");
                break;
            case '?':
                result.append("\\?");
                break;
            case '*':
                result.append("\\*");
                break;
            case '+':
                result.append("\\+");
                break;
            case '&':
                result.append("\\&");
                break;
            case ':':
                result.append("\\:");
                break;
            case '{':
                result.append("\\{");
                break;
            case '}':
                result.append("\\}");
                break;
            case '[':
                result.append("\\[");
                break;
            case ']':
                result.append("\\]");
                break;
            case '(':
                result.append("\\(");
                break;
            case ')':
                result.append("\\)");
                break;
            case '^':
                result.append("\\^");
                break;
            case '$':
                result.append("\\$");
                break;
            default:
                result.append(c);
            }
            c = iter.next();
        }
        return result.toString();
    }
}
