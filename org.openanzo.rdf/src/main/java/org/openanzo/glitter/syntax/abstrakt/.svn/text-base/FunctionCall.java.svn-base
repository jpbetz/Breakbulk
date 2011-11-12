/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * File: $Source: /cvsroot/slrp/glitter/com.ibm.adtech.glitter/src/com/ibm/adtech/glitter/syntax/abstrakt/FunctionCall.java,v $
 * Created by:  Lee Feigenbaum (<a href="mailto:feigenbl@us.ibm.com">feigenbl@us.ibm.com</a>)
 * Created on: 10/23/06
 * Revision: $Id: FunctionCall.java 229 2007-08-07 15:22:00Z mroy $
 *
 * Contributors: IBM Corporation - initial API and implementation
 *     Cambridge Semantics Incorporated - Fork to Anzo
 *******************************************************************************/
package org.openanzo.glitter.syntax.abstrakt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.openanzo.exceptions.ExceptionConstants;
import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.exception.GlitterRuntimeException;
import org.openanzo.glitter.exception.IncompatibleTypeException;
import org.openanzo.glitter.exception.InvalidAggregateArgumentException;
import org.openanzo.glitter.exception.InvalidAggregateFunctionException;
import org.openanzo.glitter.exception.InvalidArgumentCountException;
import org.openanzo.glitter.exception.UnknownFunctionException;
import org.openanzo.glitter.expression.AggregateFunction;
import org.openanzo.glitter.expression.BinaryFunction;
import org.openanzo.glitter.expression.Function;
import org.openanzo.glitter.expression.FunctionRegistry;
import org.openanzo.glitter.expression.FunctionWithAttributes;
import org.openanzo.glitter.expression.InfixOperator;
import org.openanzo.glitter.expression.PrefixOperator;
import org.openanzo.glitter.expression.ScalarFunction;
import org.openanzo.glitter.expression.ScalarFunctionOnTerms;
import org.openanzo.glitter.expression.ScalarFunctionOnValues;
import org.openanzo.glitter.expression.ScalarFunctionOnValuesAndErrors;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.PatternSolutionImpl;
import org.openanzo.glitter.query.Projection;
import org.openanzo.glitter.query.SolutionList;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.glitter.query.QueryController.QueryStringPrintOptions;
import org.openanzo.glitter.syntax.concrete.ParseException;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Variable;

/**
 * A {@link FunctionCall} is an {@link Expression} that represents the invocation of a particular {@link Function} against a list of arguments.
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class FunctionCall implements Expression {

    private List<Expression>    arguments            = null;

    private Function            function             = null;

    private boolean             distinct             = false; // for aggregates

    private boolean             star                 = false; // for aggregates

    private List<Variable>      argumentsAsVariables = null; // for aggregates

    private Map<String, Object> attributes           = null;

    private int hashCode = -1;
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FunctionCall))
            return false;
        FunctionCall other = (FunctionCall) obj;
        return
            this.function.equals(other.function) &&
            this.arguments.equals(other.arguments) &&
            this.distinct == other.distinct &&
            this.star == other.star &&
            (
              (this.argumentsAsVariables == null && other.argumentsAsVariables == null) ||
              (this.argumentsAsVariables.equals(other.argumentsAsVariables))
            ) && (
              (this.attributes == null && other.attributes == null) ||
              (this.attributes.equals(other.attributes))
            );
    }

    @Override
    public int hashCode() {
        if (hashCode == -1) {
            HashCodeBuilder hcb = new HashCodeBuilder();
            hcb.append(this.function);
            hcb.append(this.arguments);
            hcb.append(this.distinct);
            hcb.append(this.star);
            hcb.append(this.argumentsAsVariables);
            hcb.append(this.attributes);
            hashCode = hcb.toHashCode();
        }
        return hashCode;
    }

    /**
     *
     * @param f
     * @param arguments
     * @throws ParseException
     */
    public FunctionCall(Function f, List<Expression> arguments) throws ParseException {
        this(f, arguments, false, false, null);
    }

    /**
     * Construct a {@link FunctionCall} from a {@link Function} and a list of arguemnts.
     *
     * @param f
     * @param arguments
     * @param star
     * @param distinct
     * @throws ParseException
     */
    public FunctionCall(Function f, List<Expression> arguments, boolean star, boolean distinct) throws ParseException {
        this(f, arguments, star, distinct, null);
    }

    /**
     * Construct a {@link FunctionCall} from a {@link Function} and a list of arguemnts.
     *
     * @param u
     * @param arguments
     * @param star
     * @param distinct
     * @throws ParseException
     */
    public FunctionCall(URI u, List<Expression> arguments, boolean star, boolean distinct) throws ParseException {
        this(u, arguments, star, distinct, null);
    }

    /**
     * Construct a {@link FunctionCall} from a {@link Function} and a list of arguemnts.
     *
     * @param f
     * @param arguments
     * @param star
     * @param distinct
     * @param attributes
     * @throws ParseException
     */
    public FunctionCall(Function f, List<Expression> arguments, boolean star, boolean distinct, Map<String, Object> attributes) throws ParseException {
        initialize(f, arguments, star, distinct, attributes);
    }

    /**
     * Construct a {@link FunctionCall} from the name of a function (as a URI) and a list of arguments. Finds the {@link Function} in the static
     * {@link FunctionRegistry}.
     *
     * @param u
     * @param arguments
     * @param star
     * @param distinct
     * @param attributes
     * @throws ParseException
     */
    public FunctionCall(URI u, List<Expression> arguments, boolean star, boolean distinct, Map<String, Object> attributes) throws ParseException {
        Function f = FunctionRegistry.getRegistry().getFunction(u);
        if (f == null)
            throw new UnknownFunctionException(u);
        initialize(f, arguments, star, distinct, attributes);
    }

    private void initialize(Function f, List<Expression> arguments, boolean star, boolean distinct, Map<String, Object> attributes) throws ParseException {
        this.function = f;
        this.arguments = arguments == null ? new ArrayList<Expression>() : arguments;
        this.distinct = distinct;
        this.star = star;
        this.attributes = attributes;
        if (this.function instanceof AggregateFunction) {
            this.argumentsAsVariables = new ArrayList<Variable>();
            for (Expression e : this.arguments) {
                if (e instanceof SimpleExpression) {
                    SimpleExpression se = (SimpleExpression) e;
                    if (se.getTerm() instanceof Variable) {
                        this.argumentsAsVariables.add((Variable) se.getTerm());
                        continue;
                    }
                }
                throw new InvalidAggregateArgumentException(e);
            }
            // aggregates can't have both a * and a variable
            if (star && !this.arguments.isEmpty())
                throw new InvalidAggregateArgumentException(this.arguments.get(0));
            // aggregates can't be empty
            if (!star && this.arguments.isEmpty())
                throw new InvalidAggregateArgumentException();
        } else {
            // distinct and star are not valid for non-aggregate functions - this is a parse error
            if (star)
                throw new ParseException("'*' found as argument to non-aggregate function:" + f);
            if (distinct)
                throw new ParseException("'DISTINCT' found as modifier to non-aggregate function:" + f);
        }
        if (this.attributes != null && this.attributes.size() > 0) {
            if (this.function instanceof FunctionWithAttributes) {
                ((FunctionWithAttributes) this.function).setAttributes(this.attributes);
            } else {
                throw new ParseException("Attributes included for function that does not expect attributes.");
            }
        }

    }

    public Value evaluate(PatternSolution solution, SolutionSet group) throws ExpressionEvaluationException {

        if (this.function instanceof ScalarFunction) {
            ScalarFunction f = (ScalarFunction) this.function;
            // TODO - we can catch errors in, for example, numbers of arguments to a function
            // at parse time, but we don't currently do that
            if (f.operatesOnValues()) {
                if (!f.operatesOnTypeErrors() && f instanceof BinaryFunction) {
                    if (arguments.size() != 2) {
                        throw new InvalidArgumentCountException(arguments.size(), 2);
                    }
                    Value argValue1 = arguments.get(0).evaluate(solution, group);
                    Value argValue2 = arguments.get(1).evaluate(solution, group);

                    return ((BinaryFunction) f).call(argValue1, argValue2);
                } else {
                    // evaluate all the arguments, storing them and any errors their
                    // evaluation produces - some functions actually care about the errors,
                    // while others blindly propagate them
                    ArrayList<Value> evaluatedArguments = new ArrayList<Value>();
                    ArrayList<ExpressionEvaluationException> argumentExceptions = new ArrayList<ExpressionEvaluationException>();
                    for (Expression argument : this.arguments) {
                        try {
                            Value argValue = argument.evaluate(solution, group);
                            if (argValue == null) // argument is unbound --> type error
                                throw new IncompatibleTypeException(argument, "bound-value");
                            evaluatedArguments.add(argValue);
                            argumentExceptions.add(null);
                        } catch (ExpressionEvaluationException e) {
                            if (e instanceof IncompatibleTypeException && f.operatesOnTypeErrors()) {
                                evaluatedArguments.add(null);
                                argumentExceptions.add(e);
                            } else {
                                throw e;
                            }
                        }
                    }
                    if (f.operatesOnTypeErrors())
                        return ((ScalarFunctionOnValuesAndErrors) f).call(evaluatedArguments, argumentExceptions);
                    else
                        return ((ScalarFunctionOnValues) f).call(evaluatedArguments);
                }
            } else {
                return ((ScalarFunctionOnTerms) f).call(this.arguments, solution);
            }
        } else if (this.function instanceof AggregateFunction) {
            AggregateFunction f = (AggregateFunction) this.function;
            if (group == null)
                throw new InvalidAggregateFunctionException(f);
            // screen the solution set to contain only the variables given by the arguments
            // if we need to distinct the arguments
            SolutionSet screened = group;
            if (this.distinct && this.arguments != null && this.arguments.size() > 0) {
                screened = new SolutionList();
                for (PatternSolution sol : group) {
                    PatternSolutionImpl psi = new PatternSolutionImpl();
                    Collection<Variable> bound = sol.getBoundVariables();
                    for (Variable v : this.argumentsAsVariables)
                        if (bound.contains(v))
                            psi.setBinding(v, sol.getBinding(v));
                    screened.add(psi);
                }
            }

            if (this.distinct)
                screened = Projection.projectDistinctSolutions(screened, null, null);

            return f.call(this.argumentsAsVariables, screened);
        } else {
            throw new GlitterRuntimeException(ExceptionConstants.GLITTER.SCALER_OR_AGGREGATE);
        }
    }

    public Set<Variable> getReferencedVariables() {
        HashSet<Variable> vars = new HashSet<Variable>();
        for (Expression e : this.arguments)
            vars.addAll(e.getReferencedVariables());
        return vars;
    }

    /**
     * @return the function
     */
    public Function getFunction() {
        return this.function;
    }

    /**
     *
     * @return The list of arguments to this function call.
     */
    public List<Expression> getArguments() {
        return this.arguments;
    }

    /**
     * Is this a star argument
     *
     * @return true if this ia star argument
     */
    public boolean starArgument() {
        return this.star;
    }

    public void prettyPrintQueryPart(EnumSet<QueryStringPrintOptions> printFlags, int indentLevel, Map<String, String> uri2prefix, StringBuilder s) {
        Function fn = this.getFunction();
        List<Expression> args = this.getArguments();

        if (fn instanceof PrefixOperator) {
            s.append("(");
            PrefixOperator pre = (PrefixOperator) fn;
            s.append(pre.getOperator());
            args.get(0).prettyPrintQueryPart(printFlags, indentLevel, uri2prefix, s);
            s.append(")");
        } else if (fn instanceof InfixOperator) {
            s.append("(");
            InfixOperator infix = (InfixOperator) fn;
            args.get(0).prettyPrintQueryPart(printFlags, indentLevel, uri2prefix, s);
            s.append(" ");
            s.append(infix.getOperator());
            s.append(" ");
            args.get(1).prettyPrintQueryPart(printFlags, indentLevel, uri2prefix, s);
            s.append(")");
        } else {
            s.append(fn);
            {
                s.append("(");
                if (this.distinct)
                    s.append("DISTINCT ");
                if (this.star) {
                    s.append("*");
                } else {
                    int j = 0;
                    for (Expression arg : this.getArguments()) {
                        arg.prettyPrintQueryPart(printFlags, indentLevel, uri2prefix, s);
                        if (++j < this.getArguments().size())
                            s.append(", ");
                    }
                }
                s.append(")");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Function fn = this.getFunction();
        List<Expression> args = this.getArguments();

        if (fn instanceof PrefixOperator) {
            builder.append("(");
            PrefixOperator pre = (PrefixOperator) fn;
            builder.append(pre.getOperator());
            builder.append(args.get(0));
            builder.append(")");
        } else if (fn instanceof InfixOperator) {
            builder.append("(");
            InfixOperator infix = (InfixOperator) fn;
            builder.append(args.get(0));
            builder.append(" ");
            builder.append(infix.getOperator());
            builder.append(" ");
            builder.append(args.get(1));
            builder.append(")");
        } else {
            builder.append(fn);
            {
                builder.append("(");
                if (this.distinct)
                    builder.append("DISTINCT ");
                if (this.star) {
                    builder.append("*");
                } else {
                    int j = 0;
                    for (Expression arg : this.getArguments()) {
                        builder.append(arg);
                        if (++j < this.getArguments().size())
                            builder.append(", ");
                    }
                }
                builder.append(")");
            }
        }

        return builder.toString();
    }

    public void prettyPrint(StringBuilder output) {
        output.append(this.getFunction().getClass().getSimpleName());

        output.append("(");
        {
            int j = 0;
            if (this.distinct)
                output.append("DISTINCT ");
            if (this.star) {
                output.append("*");
            } else {
                for (Expression arg : this.getArguments()) {
                    arg.prettyPrint(output);
                    if (++j < this.getArguments().size())
                        output.append(", ");
                }
            }
        }
        output.append(")");
    }

    public Collection<Variable> getBindableVariables() {
        return Collections.emptyList();
    }

    public Collection<URI> getReferencedURIs() {
        HashSet<URI> uris = new HashSet<URI>();
        URI f = this.function.getIdentifier();
        if (f != null)
            uris.add(f);
        for (Expression e : this.arguments)
            uris.addAll(e.getReferencedURIs());
        return uris;
    }
}
