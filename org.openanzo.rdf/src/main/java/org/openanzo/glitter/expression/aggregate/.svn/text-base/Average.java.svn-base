package org.openanzo.glitter.expression.aggregate;

import java.util.List;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.exception.InvalidArgumentCountException;
import org.openanzo.glitter.expression.AggregaterFunctionBase;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.glitter.util.PolymorphicNumber;
import org.openanzo.glitter.util.TypeConversions;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Variable;
import org.openanzo.rdf.Constants.NAMESPACES;

/**
 * Implements the AVG() aggregate function.
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class Average extends AggregaterFunctionBase {

    public Value call(List<Variable> arguments, SolutionSet group) throws ExpressionEvaluationException {
        if (arguments == null || !(arguments.size() == 1))
            throw new InvalidArgumentCountException(arguments == null ? 0 : arguments.size(), 1);

        int count = 0;
        PolymorphicNumber sum = null;

        for (PatternSolution sol : group) {
            for (Variable v : arguments) {
                Value val = sol.getBinding(v);
                if (val != null && TypeConversions.isNumeric(val)) {
                    // skip malformed literals here
                    if (Glitter.isMalformedLiteral(val))
                        continue;
                    count++;
                    if (sum == null)
                        sum = new PolymorphicNumber(val);
                    else
                        sum = sum.add(new PolymorphicNumber(val));
                }
            }
        }
        return (sum != null) ? sum.divide(new PolymorphicNumber(count)).asTypedLiteral() : null;
    }

    public URI getIdentifier() {
        return Glitter.createURI(NAMESPACES.BUILTIN_AGGREGATE_NAMESPACE + "avg");
    }

    @Override
    public String toString() {
        return "AVG";
    }

}
