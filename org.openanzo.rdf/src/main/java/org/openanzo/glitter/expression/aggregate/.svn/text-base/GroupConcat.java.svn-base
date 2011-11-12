package org.openanzo.glitter.expression.aggregate;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.openanzo.glitter.exception.ExpressionEvaluationException;
import org.openanzo.glitter.expression.AggregaterFunctionBase;
import org.openanzo.glitter.expression.FunctionWithAttributes;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.glitter.util.Glitter;
import org.openanzo.rdf.Literal;
import org.openanzo.rdf.MemPlainLiteral;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Variable;
import org.openanzo.rdf.Constants.NAMESPACES;

/**
 * Implements the GROUP_CONCAT() aggregate function, which combines the values for expressions within the group into
 * a single value for the group.
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class GroupConcat extends AggregaterFunctionBase implements FunctionWithAttributes {
    /**
     * What string should be used to separate items being concatenated?
     */
    final static public String ATTRIBUTE_SEPARATOR = "separator";

    private String separator = ",";

    public void setAttributes(Map<String, Object> attributes) {
        if (attributes.containsKey(ATTRIBUTE_SEPARATOR))
            separator = (String) attributes.get(ATTRIBUTE_SEPARATOR);
    }

    public Value call(List<Variable> arguments, SolutionSet group) throws ExpressionEvaluationException {
        String s = "";
        boolean needsSeparator = false;
        for (PatternSolution sol : group) {
            Collection<Variable> vars = (arguments != null && !arguments.isEmpty()) ? arguments : sol.getBoundVariables();
            for (Variable v : vars) {
                Value val = sol.getBinding(v);
                if (val != null) {
                    if (needsSeparator) {
                        s += separator;
                    } else {
                        needsSeparator = true;
                    }
                    if (val instanceof Literal)
                        s += ((Literal)val).getLabel();
                    else
                        s += val.toString();
                }
            }
        }
        return MemPlainLiteral.create(s);
    }

    public URI getIdentifier() {
        return Glitter.createURI(NAMESPACES.BUILTIN_AGGREGATE_NAMESPACE + "group_concat");
    }

    @Override
    public String toString() {
        return "GROUP_CONCAT";
    }

}
