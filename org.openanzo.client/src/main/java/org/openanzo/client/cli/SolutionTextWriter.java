/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.client.cli;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.rdf.Constants;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.PlainLiteral;
import org.openanzo.rdf.TypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;

/**
 * Writes human readable sparql solution set as a textual table. The output is lossy--some RDF Values will be abbreviated. For non-abbreviated solutions please
 * use the SPARQL Results XML format (srx).
 * 
 * Core features:
 * 
 * <ul>
 * <li>Use CURIE prefixes where possible.</li>
 * <li>Attribute Promotion: If all bindings in a column share a common datatype or language, put it in the column header, not each entry.</li>
 * <li>Dynamically limit column widths so the table width is something reasonable.</li>
 * <ul>
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
class SolutionTextWriter {

    private static class Table {
        final SolutionSet    solutionSet;

        final CommandContext context;

        int                  columnCount;

        int                  rowCount;

        String[][]           output;

        Column[]             columns;

        public Table(CommandContext context, SolutionSet solutionSet) {
            this.context = context;
            this.solutionSet = solutionSet;

            this.columnCount = solutionSet.getBindings().size();
            this.rowCount = solutionSet.size();

            this.output = new String[this.rowCount][this.columnCount];
            this.columns = new Column[this.columnCount];
            for (int j = 0; j < this.columnCount; j++) {
                this.columns[j] = new Column();
            }

            initialize();
        }

        public void initialize() {
            promoteCommonAttributes();
            arrangeHeaders();
            arrangeTable();
            constrainWidth();
        }

        private void promoteCommonAttributes() {
            int j = 0;
            for (String name : this.solutionSet.getBindingNames()) {
                for (PatternSolution sol : this.solutionSet) {

                    // for each entry in column, check if attribute is common
                    // if this becomes false, quit checking for column
                    Value binding = sol.getBinding(name);
                    if (!this.columns[j].hasCommonAttributes(binding)) {
                        break;
                    }
                }
                j++;
            }
        }

        private void arrangeHeaders() {
            int j = 0;
            for (String name : this.solutionSet.getBindingNames()) {
                this.columns[j].arrangeHeader(name);
                j++;
            }
        }

        private void arrangeTable() {
            int i = 0;
            for (PatternSolution sol : this.solutionSet) {
                int j = 0;
                for (String name : this.solutionSet.getBindingNames()) {
                    Value binding = sol.getBinding(name);

                    String val;
                    if (binding == null) {
                        val = "";
                    } else {
                        val = this.columns[j].arrangeEntry(binding);
                    }
                    this.columns[j].width = Math.max(this.columns[j].width, val.length());
                    this.output[i][j] = val;

                    j++;
                }
                i++;
            }
        }

        private void constrainWidth() {
            if (this.columns.length == 0)
                return;

            int[] ordered = new int[this.columns.length];
            long totalWidth = 0;
            for (int i = 0; i < this.columnCount; i++) {
                totalWidth += this.columns[i].width;
                ordered[i] = this.columns[i].width;
            }
            if (totalWidth < 180)
                return;

            Arrays.sort(ordered);

            // find a reasonable column width
            // it should be greater than the median column length, unless that is too large
            int roughMedian = ordered[(int) Math.ceil(ordered.length / 2)]; // this isn't really the mathematical median, but it's close enough
            int maxColumnLength = Math.min(roughMedian, 50);

            // widen out the max column length if there is room
            while (maxColumnLength * this.columns.length < 160) {
                maxColumnLength++;
            }

            for (int j = 0; j < this.columnCount; j++) {
                if (this.columns[j].width < maxColumnLength)
                    continue;

                this.columns[j].width = maxColumnLength;

                for (int i = 0; i < this.rowCount; i++) {

                    String val = this.output[i][j];

                    // abbreviate strings to keep table width under control

                    Value binding = this.solutionSet.get(i).getBinding(this.solutionSet.getBindingNames().get(j));
                    if (binding instanceof URI) {
                        if (val.length() > maxColumnLength) {
                            val = StringUtils.abbreviate(val, val.length(), maxColumnLength);
                        }
                    } else {
                        if (val.length() > maxColumnLength) {
                            val = StringUtils.abbreviate(val, maxColumnLength);
                        }
                    }

                    this.output[i][j] = val;
                }
            }
        }

        public void write(PrintWriter out) {
            out.println();
            for (int j = 0; j < this.columnCount; j++) {
                out.format("%-" + (this.columns[j].width + 2) + "s", this.columns[j].header);
            }
            out.println();
            for (int j = 0; j < this.columnCount; j++) {
                out.print(StringUtils.rightPad("", this.columns[j].width, "-"));
                out.print("  ");
            }
            out.println();
            for (int i = 0; i < this.output.length; i++) {
                for (int j = 0; j < this.columnCount; j++) {
                    out.format("%-" + (this.columns[j].width + 2) + "s", this.output[i][j]);
                }
                out.println();
            }
            out.println();
        }

        public class Column {
            int     width;

            URI     promotedDatatype;

            String  promotedLang;

            String  header;

            boolean hasCommonDatatype = true;

            boolean hasCommonLang     = true;

            public void arrangeHeader(String name) {
                this.header = "?" + name;
                if (this.promotedDatatype != null) {
                    this.header += (" (" + Table.this.context.applyPrefixes(this.promotedDatatype) + ")");
                } else if (this.promotedLang != null) {
                    this.header += (" (@" + this.promotedLang + ")");
                }
                this.width = this.header.length();
            }

            public boolean hasCommonAttributes(Value binding) {
                if (binding instanceof TypedLiteral && this.promotedLang == null) {
                    TypedLiteral lit = (TypedLiteral) binding;
                    if (!hasCommonDatatype(lit))
                        return false;

                } else if (binding instanceof PlainLiteral && this.promotedDatatype == null) {
                    PlainLiteral lit = (PlainLiteral) binding;
                    if (!hasCommonLang(lit))
                        return false;
                }
                return true;
            }

            public boolean hasCommonDatatype(TypedLiteral lit) {
                if (this.hasCommonDatatype == true) {
                    if (this.promotedDatatype == null) {
                        this.promotedDatatype = lit.getDatatypeURI();
                    } else if (!this.promotedDatatype.equals(lit.getDatatypeURI())) {
                        this.promotedDatatype = null;
                        this.hasCommonDatatype = false;
                    }
                }
                return this.hasCommonDatatype;
            }

            public boolean hasCommonLang(PlainLiteral lit) {
                if (this.hasCommonLang == true) {
                    if (this.promotedLang == null) {
                        this.promotedLang = lit.getLanguage();
                    } else if (!ObjectUtils.equals(this.promotedLang, (lit.getLanguage()))) {
                        this.promotedLang = null;
                        this.hasCommonLang = false;
                    }
                }
                return this.hasCommonLang;
            }

            public String arrangeEntry(Value binding) {
                String val = Table.this.context.applyPrefixes(binding);
                if (binding instanceof Literal) {
                    Literal lit = (Literal) binding;

                    if (lit instanceof TypedLiteral) {

                        if (this.promotedDatatype != null) {
                            val = lit.getLabel();
                        }
                    } else {
                        if (this.promotedLang != null) {
                            val = lit.getLabel();
                        }
                    }
                }
                return val;
            }
        }

    }

    public static void write(CommandContext context, SolutionSet solutionSet) throws IOException {
        Table table = new Table(context, solutionSet);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out,Constants.byteEncoding));
        table.write(out);
        out.flush();
    }
}
