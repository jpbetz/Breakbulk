package org.openanzo.glitter.query.validator;

import java.util.Iterator;
import java.util.List;

import org.openanzo.glitter.expression.AggregateFunction;
import org.openanzo.glitter.query.Projection;
import org.openanzo.glitter.query.QueryInformation;
import org.openanzo.glitter.query.QueryValidator;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.glitter.syntax.abstrakt.FunctionCall;
import org.openanzo.glitter.syntax.abstrakt.SimpleExpression;
import org.openanzo.rdf.Variable;

/**
 * Checks that variables projected outside an aggregate function in an aggregated query occur in the query's GROUP BY clause
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class AggregateVariableValidator implements QueryValidator {
    private Variable invalidVariable = null;

    public String getValidationError() {
        return invalidVariable + " is used outside an aggregate function and is not in the GROUP BY clause";
    }

    public String getValidatorDescription() {
        return "Checks that variables projected outside an aggregate function in an aggregated query occur in the query's GROUP BY clause";
    }

    public boolean validateQuery(QueryInformation query) {
        if (query.getQueryResultForm() instanceof Projection) {
            Projection p = (Projection) query.getQueryResultForm();
            List<Variable> groupByVariables = p.getGroupByVariables();
            if (p.isAggregateProjection()) {
                Iterator<Variable> aliases = p.getResultVariables().iterator();
                for (Expression e : p.getProjectedExpressions()) {
                    Variable alias = aliases.next();
                    if ((this.invalidVariable = checkProjectedExpressionInAggregate(e, null, alias, groupByVariables)) != null)
                        return false;
                }
            }
        }
        return true;
    }

    // returns the failing variable, if any
    private Variable checkProjectedExpressionInAggregate(Expression e, Expression parent, Variable alias, List<Variable> groupByVariables) {
        if (e instanceof SimpleExpression) {
            SimpleExpression se = (SimpleExpression) e;
            boolean parentIsAggregate = parent != null && parent instanceof FunctionCall && ((FunctionCall) parent).getFunction() instanceof AggregateFunction;
            if (!parentIsAggregate && se.getTerm() instanceof Variable && !groupByVariables.contains(se.getTerm()) && !groupByVariables.contains(alias))
                return (Variable) se.getTerm();
        } else if (e instanceof FunctionCall) {
            FunctionCall fc = (FunctionCall) e;
            Variable v;
            for (Expression arg : fc.getArguments())
                if ((v = checkProjectedExpressionInAggregate(arg, e, alias, groupByVariables)) != null)
                    return v;
        }
        return null;
    }
}
