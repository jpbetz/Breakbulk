/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Oct 16, 2007
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.rdf.utils;

import java.util.StringTokenizer;

/**
 * Helper class used to format text for wiki. Used in templates.
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@us.ibm.com">mroy@us.ibm.com </a>)
 * 
 */
public class WikiFormatUtils {
    /**
     * Capatilize first letter of string
     * 
     * @param value
     *            value to update
     * @return value with first letter capped
     */
    public static String capFirstLetter(String value) {
        if (value == null)
            return null;
        if (value.length() == 0)
            return value;
        value = value.substring(0, 1).toUpperCase() + value.substring(1, value.length());
        return value;
    }

    /**
     * Add a ! to the front of a string if there are uppercase letters past the first letter
     * 
     * @param title
     *            title to format
     * @return a string with a ! prepended if there are uppercase letters past the first letters
     */
    public static String formatTitleString(String title) {
        if (title != null && title.length() > 0) {
            if (title.contains(" ")) {
                StringTokenizer st = new StringTokenizer(title, " ");
                StringBuilder sb = new StringBuilder();
                while (st.hasMoreTokens()) {
                    sb.append(formatTitleString(st.nextToken()));
                    if (st.hasMoreTokens()) {
                        sb.append(' ');
                    }
                }
                return sb.toString();
            } else {
                boolean seenLower = false;
                char c = title.charAt(0);
                if (isUpper(c)) {
                    for (int i = 1; i < title.length(); i++) {
                        c = title.charAt(i);
                        if (isUpper(c) && seenLower) {
                            return '!' + title;
                        }
                        if (isUpper(c)) {
                            return title;
                        } else if (isLower(c)) {
                            seenLower = true;
                        }
                    }
                }
            }
        }
        return title;
    }

    private static boolean isUpper(char c) {
        return (c >= 'A' && c <= 'Z');
    }

    private static boolean isLower(char c) {
        return (c >= 'a' && c <= 'z');
    }

    /**
     * Convert string to upperCase with _ when there is an upper case letter
     * 
     * @param title
     *            title to format
     * @return a string to upperCase with _ when there is an upper case letter
     */
    public static String formatConstantString(String title) {
        if (title != null && title.length() > 0) {
            boolean seenLower = false;
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < title.length(); i++) {
                char c = title.charAt(i);
                if (isLower(c)) {
                    seenLower = true;
                } else {
                    if (seenLower) {
                        sb.append("_");
                        seenLower = false;
                    }
                }
                sb.append(c);
            }
            return sb.toString().toUpperCase();
        }
        return title;
    }

    /**
     * Convert a package directory to a package name
     * 
     * @param packageDir
     *            directory name
     * @return package name
     */
    public static String convertPackageDirectory(String packageDir) {
        String result = packageDir.replace('/', '.');
        if (result.endsWith(".")) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
}
