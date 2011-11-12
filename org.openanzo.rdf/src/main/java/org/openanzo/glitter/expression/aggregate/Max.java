package org.openanzo.glitter.expression.aggregate;

import java.util.Collection;
import java.util.List;

import org.openanzo.exceptions.LogUtils;
import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.expression.AggregaterFunctionBase;
import org.openanzo.glitter.expression.builtin.PolymorphicGt;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.glitter.util.Constants;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Variable;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements the MAX() aggregate function.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class Max extends AggregaterFunctionBase {
    private static final Logger log = LoggerFactory.getLogger(Max.class);

    public Value call(List<Variable> arguments, SolutionSet group) throws ExpressionEvaluationException {
        // we find the minimum of all non-null values
        // if any two values cannot be compared with '>', then the result is a type error.
        Value max = null;
        PolymorphicGt gt = new PolymorphicGt();
        for (PatternSolution sol : group) {
            Collection<Variable> vars = (arguments != null && !arguments.isEmpty()) ? arguments : sol.getBoundVariables();
            for (Variable v : vars) {
                Value val = sol.getBinding(v);
                if (val != null) {
                    // skip malformed literals here
                    if (Glitter.isMalformedLiteral(val))
                        continue;
                    try {
                        if (max == null || gt.call(val, max).equals(Constants.TRUE))
                            max = val;
                    } catch (ExpressionEvaluationException e) {
                        log.trace(LogUtils.GLITTER_MARKER, "Skipping value that does not compare with canonical value in MAX(...)");
                    }

                }
            }
        }
        return max;
    }

    public URI getIdentifier() {
        return Glitter.createURI(NAMESPACES.BUILTIN_AGGREGATE_NAMESPACE + "max");
    }

    @Override
    public String toString() {
        return "MAX";
    }

}
