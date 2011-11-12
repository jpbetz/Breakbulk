/*******************************************************************************
 * Copyright (c) 2008 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * File:        $Source$
 * Created by:  Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com </a>)
 * Created on:  Dec 6, 2008
 * Revision:	$Id$
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated - initial API and implementation
 *******************************************************************************/
package org.openanzo.aspects;

import org.aspectj.lang.JoinPoint;

/**
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public aspect TraceAspect {
    ThreadLocal<Long> indentCount = new ThreadLocal<Long>() {
                                      @Override
                                      protected Long initialValue() {
                                          return Long.valueOf(0);
                                      }
                                  };

    pointcut myConstructor():  
        !within(TraceAspect+) && 
        execution(@Trace new(..));

    pointcut myMethod(): 
        !within(TraceAspect+) && 
        (execution(@Trace * *(..)) )&& 
        !execution(String toString())&& 
        !cflow(execution(String toString()));

    before(): myConstructor() {
        traceEntry(thisJoinPoint);
    }

    after(): myConstructor() {
        traceExit(thisJoinPoint, null);
    }

    before(): myMethod() {
        traceEntry(thisJoinPoint);
    }

    after(): myMethod() {
        traceExit(thisJoinPoint, null);
    }

    pointcut myTimeMethod(): 
        !within(TraceAspect+) && 
        execution(@Timer * *(..)) && 
        !execution(String toString())&& 
        !cflow(execution(String toString()));

    Object around(): myTimeMethod(){
        Object result = null;
        long start = System.currentTimeMillis();
        try {
            traceEntry(thisJoinPoint);
            result = proceed();
        } finally {
            Long count = indentCount.get();
            String indent = "";
            for (long i = 0; i < count; i++) {
                indent = indent.concat("    ");
            }
            System.err.println(indent + "Time:" + thisJoinPoint.toLongString() + ":" + (System.currentTimeMillis() - start));
            traceExit(thisJoinPoint, result);
        }
        return result;
    }

    protected void traceEntry(JoinPoint joinPoint) {
        Long count = indentCount.get();
        String indent = "";
        for (long i = 0; i < count; i++) {
            indent = indent.concat("    ");
        }
        indentCount.set(Long.valueOf(++count));
        System.err.println(indent + "Entering [" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + createParameterMessage(indent, joinPoint) + "]");
    }

    protected void traceExit(JoinPoint joinPoint, Object result) {
        Long count = indentCount.get();
        indentCount.set(Long.valueOf(--count));
        String indent = "";
        for (long i = 0; i < count; i++) {
            indent = indent.concat("    ");
        }

        System.err.println(indent + "Exiting [" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + ((result != null) ? ("result=" + result) : "") + "]");
    }

    private String createParameterMessage(String indent, JoinPoint joinPoint) {
        StringBuffer sb = new StringBuffer();
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            sb.append("\n    " + indent);
        }
        for (int i = 0; i < args.length; i++) {
            sb.append(args[i].getClass().getSimpleName());
            sb.append('=');
            sb.append(args[i].toString());
            if (i != args.length - 1) {
                sb.append(",\n    " + indent);
            }
        }
        sb.append("\n"+ indent);
        return sb.toString();
    }

}
