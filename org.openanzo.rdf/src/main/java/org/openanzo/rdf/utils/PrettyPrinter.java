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

/**
 * Utility class for pretty printing objects. Favors PrettyPrintable methods if available.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public class PrettyPrinter {

    /**
     * Pretty print the object if appropriate
     * 
     * @param object
     *            print the object if appropriate
     * @return the output either in pretty format or just with toString
     */
    public static String print(Object object) {
        StringBuilder output = new StringBuilder();
        if (object instanceof PrettyPrintable) {
            PrettyPrintable printable = (PrettyPrintable) object;
            printable.prettyPrint(output);
        } else {
            output.append(object.toString());
        }
        return output.toString();
    }

}
