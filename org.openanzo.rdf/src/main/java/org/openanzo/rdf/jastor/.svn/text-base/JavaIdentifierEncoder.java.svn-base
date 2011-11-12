/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source: /cvsroot/slrp/boca/com.ibm.adtech.boca.jastor/src/com/ibm/adtech/boca/jastor/JavaIdentifierEncoder.java,v $
 * Created by:  
 * Created on:  01/23/2007
 * Revision:	$Id: JavaIdentifierEncoder.java 172 2007-07-31 14:22:23Z mroy $
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.rdf.jastor;

/**
 * Encodes arbitrary strings into valid java identifiers. Decode is provided as well to prove the encoding is bi-directional.
 * 
 * @author Joe Betz
 * @author Ben Szekely (<a href="mailto:bhszekel@us.ibm.com">bhszekel@us.ibm.com</a>)
 */
public class JavaIdentifierEncoder {

    static final char         ESCAPE_CHAR       = '_';

    private static final char BLANK_CHAR        = '$';

    static final char         ESCAPE_CLOSE_CHAR = '_';

    static final String[]     keywords          = new String[] { "abstract", "default", "if", "private", "this", "boolean", "do", "implements", "protected", "throw", "break", "double", "import", "public", "throws", "byte", "else", "instanceof", "return", "transient", "case", "extends", "int", "short", "try", "catch", "final", "interface", "static", "void", "char", "finally", "long", "strictfp", "volatile", "class", "float", "native", "super", "while", "const", "for", "new", "switch", "continue", "goto",
            "package", "synchronized", "Resource", "Statement", "Thing", "Property" };

    static final String[][]   prettyMapping     = new String[][] { { ".", "DOT" }, { ",", "COMMA" }, { "+", "PLUS" }, { "-", "DASH" }, { "\"", "QUOTE" }, { "'", "TICK" }, { "~", "TILDE" }, { "`", "BACKTICK" }, { "=", "EQUALS" }, { "/", "SLASH" }, { "\\", "BACKSLASH" }, { "<", "LTHAN" }, { ">", "GTHAN" }, { "[", "STRTBLK" }, { "]", "ENDBLK" }, { "{", "STRTBRKT" }, { "}", "LTHAN" }, { "?", "QMARK" }, { "!", "BANG" }, { "@", "AT" }, { "#", "POUND" }, { "$", "DOLLARSIGN" }, { "%", "PERCENT" }, { "^", "CAP" },
            { "&", "AND" }, { "*", "ASTRISK" }, { "(", "STRTPAREN" }, { ")", "ENDPAREN" }, { "|", "BAR" } };

    /**
     * Determine if identifier is a keyword
     * 
     * @param identifier
     *            string to check
     * @return true if identifier is a keyword
     */
    public static boolean isKeyword(String identifier) {
        for (int i = 0; i < keywords.length; i++) {
            if (keywords[i].equals(identifier))
                return true;
        }
        return false;
    }

    /**
     * Encode a string to its encoded version
     * 
     * @param anyString
     *            string to encode
     * @return encoded string
     */
    public static String encode(String anyString) {
        StringBuilder javaIdentifier = new StringBuilder();
        for (int i = 0; i < anyString.length(); i++) {
            char c = anyString.charAt(i);
            if (c == ESCAPE_CHAR) {
                javaIdentifier.append(ESCAPE_CHAR);
                javaIdentifier.append(ESCAPE_CHAR);
            } else if (i == 0) {
                boolean part = Character.isJavaIdentifierPart(c);
                boolean start = Character.isJavaIdentifierStart(c);
                if (start) {
                    javaIdentifier.append(c);
                } else if (part) { // !start && part
                    javaIdentifier.append(ESCAPE_CHAR);
                    javaIdentifier.append(BLANK_CHAR);
                    javaIdentifier.append(c);
                } else { // !start && !part
                    javaIdentifier.append(encode(c));
                }
            } else {
                if (Character.isJavaIdentifierPart(c)) {
                    javaIdentifier.append(c);
                } else {
                    javaIdentifier.append(encode(c));
                }
            }
        }
        String identifier = javaIdentifier.toString();
        if (isKeyword(identifier)) {
            identifier = "" + ESCAPE_CHAR + identifier;
        }
        return identifier;
    }

    /**
     * Encodes every char to a valid java string
     * 
     * @param c
     *            char to encode
     * @return encoded char string
     */
    public static String encode(char c) {
        //System.err.println("Encoding: " + c);
        for (int i = 0; i < prettyMapping.length; i++) {
            String key = prettyMapping[i][0];
            if (key.charAt(0) == c) {
                return "" + ESCAPE_CHAR + prettyMapping[i][1] + ESCAPE_CLOSE_CHAR;
            }
        }
        int val = c;
        return "" + ESCAPE_CHAR + Integer.valueOf(val) + ESCAPE_CLOSE_CHAR;
    }

    /**
     * Decode a string to its decoded version
     * 
     * @param javaIdentifier
     *            string to decode
     * @return decoded string
     * @throws Exception
     */
    //FIXEXCEPTIONS:Should throw a more precise exception
    public static String decode(String javaIdentifier) throws Exception {
        StringBuilder string = new StringBuilder();
        chars: for (int i = 0; i < javaIdentifier.length(); i++) {
            char c = javaIdentifier.charAt(i);
            if (i == 0 && c == ESCAPE_CHAR) {
                String identifier = javaIdentifier.substring(1, javaIdentifier.length());
                if (isKeyword(identifier)) {
                    return identifier;
                }
            }
            if (c == ESCAPE_CHAR) {
                c = javaIdentifier.charAt(++i);
                if (Character.isDigit(c)) {
                    StringBuilder number = new StringBuilder();
                    for (int j = i; j < javaIdentifier.length(); j++) {
                        char forward = javaIdentifier.charAt(j);
                        if (forward == ESCAPE_CLOSE_CHAR) {
                            i = j;
                            break;
                        }
                        if (!Character.isDefined(forward))
                            throw new Exception("Escape started with number but was not purely a number: " + javaIdentifier.substring(i));
                        number.append(forward);
                    }
                    int val = Integer.parseInt(number.toString());
                    string.append((char) val);
                } else if (c == ESCAPE_CHAR) {
                    string.append(ESCAPE_CHAR);
                } else if (c == BLANK_CHAR) {
                    continue;
                } else {
                    // try to match a special mapping
                    for (int j = i; j < javaIdentifier.length(); j++) {
                        char forward = javaIdentifier.charAt(j);
                        if (forward == ESCAPE_CLOSE_CHAR) {
                            String prettyName = javaIdentifier.substring(i, j);
                            for (int k = 0; k < prettyMapping.length; k++) {
                                if (prettyMapping[k][1].equals(prettyName)) {
                                    string.append(prettyMapping[k][0]);
                                    i = j;
                                    continue chars;
                                }
                            }
                            throw new Exception("No decoding found for: " + prettyName);
                        }
                    }
                    throw new Exception("Impossible to decode starting at: " + javaIdentifier.substring(i));
                }
            } else {
                string.append(c);
            }
        }
        return string.toString();
    }
}
