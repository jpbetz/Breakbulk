package org.openanzo.glitter.query.validator;

import java.util.LinkedList;

import org.openanzo.glitter.expression.AggregateFunction;
import org.openanzo.glitter.query.OrderingCondition;
import org.openanzo.glitter.query.QueryInformation;
import org.openanzo.glitter.query.QueryValidator;
import org.openanzo.glitter.syntax.abstrakt.Expression;
import org.openanzo.glitter.syntax.abstrakt.FunctionCall;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;

/**
 * Checks that functions used in FILTERs and ORDER BY and LET clauses are scalar (not aggregate) functions.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class ScalarFunctionValidator implements QueryValidator {
    private AggregateFunction f = null;

    public String getValidationError() {
        return "Aggregate function '" + f + "' is used outside a SELECT clause";
    }

    public String getValidatorDescription() {
        return "Checks that aggregate functions are not used where only scalar functions are allowed";
    }

    private AggregateFunction findFirstAggregateFunction(Expression e) {
        AggregateFunction af = null;
        if (e instanceof FunctionCall) {
            FunctionCall fc = (FunctionCall) e;
            if (fc.getFunction() instanceof AggregateFunction)
                return (AggregateFunction) fc.getFunction();
            for (Expression arg : fc.getArguments())
                if ((af = findFirstAggregateFunction(arg)) != null)
                    return af;
        }
        return null;
    }

    public boolean validateQuery(QueryInformation query) {
        AggregateFunction af = null;
        for (OrderingCondition oc : query.getOrderingConditions()) {
            if ((af = findFirstAggregateFunction(oc.getCondition())) != null) {
                this.f = af;
                return false;
            }
        }
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.add(query.getQueryPattern());
        while (!nodes.isEmpty()) {
            TreeNode tn = nodes.removeFirst();
            if (tn != null) {
                if (tn.getFilters() != null)
                    for (Expression e : tn.getFilters()) {
                        if ((af = findFirstAggregateFunction(e)) != null) {
                            this.f = af;
                            return false;
                        }
                    }
                if (tn.getChildren() != null) {
                    nodes.addAll(tn.getChildren());
                }
            }
        }
        return true;
    }
}
