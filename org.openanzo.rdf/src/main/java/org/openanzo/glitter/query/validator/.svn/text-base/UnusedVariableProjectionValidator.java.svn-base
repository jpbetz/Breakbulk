package org.openanzo.glitter.query.validator;

import java.util.Set;

import org.openanzo.glitter.query.Construct;
import org.openanzo.glitter.query.Projection;
import org.openanzo.glitter.query.QueryInformation;
import org.openanzo.glitter.query.QueryResultForm;
import org.openanzo.glitter.query.QueryValidator;
import org.openanzo.glitter.syntax.abstrakt.TriplePatternNode;
import org.openanzo.rdf.TriplePatternComponent;
import org.openanzo.rdf.Variable;

/**
 * Checks whether the query projects any variables that cannot be bound in the query.
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class UnusedVariableProjectionValidator implements QueryValidator {

    private Variable v = null;

    public String getValidationError() {
        return "The variable " + this.v + " is projected but not used in the query";
    }

    public String getValidatorDescription() {
        return "Checks whether the query projects any variables that cannot be bound in the query";
    }

    public boolean validateQuery(QueryInformation query) {
        QueryResultForm qrf = query.getQueryResultForm();
        if (qrf instanceof Projection) {
            Projection p = (Projection) qrf;
            Set<Variable> projectionVariables = p.getReferencedVariables();
            projectionVariables.removeAll(query.getQueryPattern().getBindableVariables());
            if (!projectionVariables.isEmpty()) {
                this.v = projectionVariables.iterator().next();
                return false;
            }
        } else if (qrf instanceof Construct) {
            Construct c = (Construct) qrf;
            Set<Variable> queryVariables = query.getQueryPattern().getBindableVariables();
            for (TriplePatternNode tpn : c.getTemplate()) {
                Set<Variable> tpnVars = tpn.getReferencedVariables();
                tpnVars.removeAll(queryVariables);
                if (!tpnVars.isEmpty()) {
                    this.v = tpnVars.iterator().next();
                    return false;
                }
            }
            for (TriplePatternComponent tpc : c.getTemplateGraphComponents()) {
                if (tpc != null && tpc instanceof Variable && !queryVariables.contains(tpc)) {
                    this.v = (Variable) tpc;
                    return false;
                }
            }
        }
        return true;
    }

}
