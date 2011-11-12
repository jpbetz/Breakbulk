package org.openanzo.glitter.expression.aggregate;

import java.util.List;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.expression.AggregaterFunctionBase;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.rdf.MemTypedLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Variable;
import org.openanzo.rdf.Constants.NAMESPACES;
import org.openanzo.rdf.vocabulary.XMLSchema;

/**
 * Implements the COUNT() aggregate function.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class Count extends AggregaterFunctionBase {

    public Value call(List<Variable> arguments, SolutionSet group) throws ExpressionEvaluationException {
        // if arguments is non-null, we only count the rows with at least one non-null value for those
        // arguments - note that COUNT(col1, col2) (but COUNT(DISTINCT col1, col2) is).
        int size = 0;
        if (arguments != null && !arguments.isEmpty()) {
            for (PatternSolution sol : group) {
                for (Variable v : arguments) {
                    if (sol.getBinding(v) != null) {
                        size++;
                        break;
                    }
                }
            }
        } else {
            size = group.size();
        }
        return MemTypedLiteral.create(Integer.toString(size), XMLSchema.INTEGER);
    }

    public URI getIdentifier() {
        return Glitter.createURI(NAMESPACES.BUILTIN_AGGREGATE_NAMESPACE + "count");
    }

    @Override
    public String toString() {
        return "COUNT";
    }

}
