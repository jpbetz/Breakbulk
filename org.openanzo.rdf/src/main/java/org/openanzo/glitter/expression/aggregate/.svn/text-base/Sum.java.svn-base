package org.openanzo.glitter.expression.aggregate;

import java.util.Collection;
import java.util.List;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
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
 * Implements the SUM() aggregate function.
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class Sum extends AggregaterFunctionBase {

    public Value call(List<Variable> arguments, SolutionSet group) throws ExpressionEvaluationException {
        // we sum all numeric, non-null values
        PolymorphicNumber sum = new PolymorphicNumber(0);
        for (PatternSolution sol : group) {
            Collection<Variable> vars = (arguments != null && !arguments.isEmpty()) ? arguments : sol.getBoundVariables();
            for (Variable v : vars) {
                Value val = sol.getBinding(v);
                if (val != null && TypeConversions.isNumeric(val))
                    // skip malformed literals here
                    if (Glitter.isMalformedLiteral(val))
                        continue;
                    sum = sum.add(new PolymorphicNumber(val));
            }
        }
        return sum.asTypedLiteral();
    }

    public URI getIdentifier() {
        return Glitter.createURI(NAMESPACES.BUILTIN_AGGREGATE_NAMESPACE + "sum");
    }

    @Override
    public String toString() {
        return "SUM";
    }

}
