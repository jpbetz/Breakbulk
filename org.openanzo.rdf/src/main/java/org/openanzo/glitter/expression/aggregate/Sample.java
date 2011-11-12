package org.openanzo.glitter.expression.aggregate;

import java.util.List;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.exception.InvalidArgumentCountException;
import org.openanzo.glitter.expression.AggregaterFunctionBase;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Variable;
import org.openanzo.rdf.Constants.NAMESPACES;

/**
 * Implements the SAMPLE() aggregate function, which takes an arbitrary value from the group to stand
 * for the given variable.
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class Sample extends AggregaterFunctionBase {

    public Value call(List<Variable> arguments, SolutionSet group) throws ExpressionEvaluationException {
        if (arguments == null || !(arguments.size() == 1))
            throw new InvalidArgumentCountException(arguments == null ? 0 : arguments.size(), 1);

        // prefer a bound value
        Value val = null;
        Variable var = arguments.get(0);
        for (PatternSolution sol : group) {
            val = sol.getBinding(var);
            if (val != null)
                break;
        }
        return val;
    }

    public URI getIdentifier() {
        return Glitter.createURI(NAMESPACES.BUILTIN_AGGREGATE_NAMESPACE + "sample");
    }

    @Override
    public String toString() {
        return "SAMPLE";
    }

}
