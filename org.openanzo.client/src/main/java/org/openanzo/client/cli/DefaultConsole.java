/*******************************************************************************
 * Copyright (c) 2009 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Mar 9, 2010
 * Revision:	$Id: DefaultConsole.java 5245 2010-03-10 15:14:02Z mroy $
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.client.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;

import jline.console.ConsoleReader;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class DefaultConsole implements IConsole {
    ConsoleReader cr;

    public DefaultConsole() {
        try {
            if (System.console() != null) {
                cr = new ConsoleReader();
                cr.setBellEnabled(true);
            }
        } catch (IOException ioe) {

        }

    }

    public String readLine(String prompt) throws IOException {
        if (cr != null) {
            return cr.readLine();
        } else {
            System.out.print(prompt);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            //if (mask) {
            //     return PasswordField.readPassword(prompt, in);
            // } else {
            return in.readLine();
        }
    }

    public void printException(Exception e, boolean showTrace) {
        Throwable exception = e;
        if (exception != null && showTrace) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            // printStackTrace will print this exception including it's message as well as follow the getCause exception chain and print out those.
            exception.printStackTrace(pw);
            writeError(sw.toString());
        } else {
            // We print out just the message of every exception in the getCause exception chain.
            boolean first = true;
            while (exception != null) {
                if (!first) {
                    writeError("\tCaused by: ");
                }
                writeError(exception.getMessage());
                first = false;
                if (exception == exception.getCause()) // prevents a possible infinite loop
                    break;
                exception = exception.getCause();
            }
        }
    }

    public DefaultConsole(ConsoleReader cr) {
        this.cr = cr;
    }

    public void writeError(String error) {
        if (cr != null) {
            try {
                cr.println(error);
            } catch (IOException ioe) {

            }
        } else {
            System.err.println(error);
        }
    }

    public void writeOutput(String output) {
        if (cr != null) {
            try {
                cr.println(output);
            } catch (IOException ioe) {

            }
        } else {
            System.out.println(output);
        }
    }

    public void beep() {
        if (cr != null) {
            try {
                cr.beep();
            } catch (IOException ioe) {

            }
        }
    }

    public String readString(String prompt, boolean mask) throws IOException {
        if (cr != null) {
            try {
                String oldPrompt = cr.getPrompt();
                String result = (mask) ? cr.readLine(prompt, '*') : cr.readLine(prompt);
                cr.setPrompt(oldPrompt);
                return result;
            } catch (IOException ioe) {

            }
        }
        System.out.print(prompt);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //if (mask) {
        //     return PasswordField.readPassword(prompt, in);
        // } else {
        return in.readLine();
        //  }

    }

    // Inner class which masks the characters of the password as it is being typed 
    private static class EraserThread implements Runnable {
        private boolean stop;

        /**
         *@param The
         *            prompt displayed to the user
         */
        public EraserThread(String prompt) {
            System.err.println(prompt);
        }

        /**
         * Begin masking...display blank space
         */
        public void run() {
            stop = true;

            while (stop) {
                System.err.print("\010\0");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ie) {
                    System.err.println(ie.getMessage());
                    //ie.printStackTrace();
                }
            }
        }

        /**
         * Instruct the thread to stop masking
         */
        public void stopMasking() {
            this.stop = false;
        }
    }

    // Basically a wrapper for the EraserThread class
    private static class PasswordField {

        /**
         *@param prompt
         *            The prompt to display to the user
         *@return The password as entered by the user
         */
        public static String readPassword(String prompt, BufferedReader in) throws IOException {
            EraserThread et = new EraserThread(prompt);
            Thread mask = new Thread(et);
            mask.start();

            in = new BufferedReader(new InputStreamReader(System.in));
            String password = "";

            password = in.readLine();
            // stop masking
            et.stopMasking();
            // return the password entered by the user
            return password;
        }
    }

    static HelpFormatter formatter = new HelpFormatter();

    public void printHelp(String syntax, String header, Options options, String footer) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        formatter.printHelp(pw, cr != null ? cr.getTerminal().getWidth() : HelpFormatter.DEFAULT_WIDTH, syntax, header, options, HelpFormatter.DEFAULT_LEFT_PAD, HelpFormatter.DEFAULT_DESC_PAD, footer);
        writeOutput(sw.toString());
    }
}
