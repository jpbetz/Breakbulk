package org.openanzo.datasource.nodecentric.query.predicates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openanzo.glitter.exception.FunctionalPredicateInvocationException;
import org.openanzo.glitter.exception.GlitterException;
import org.openanzo.glitter.query.FunctionalPredicate;
import org.openanzo.glitter.query.NodeCostModel;
import org.openanzo.glitter.query.PatternSolution;
import org.openanzo.glitter.query.QueryInformation;
import org.openanzo.glitter.query.SolutionSet;
import org.openanzo.rdf.Bindable;
import org.openanzo.rdf.TriplePattern;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.Value;
import org.openanzo.rdf.Variable;

/**
 * {@link ListMemberPredicate} is a {@link FunctionalPredicate} that implements the predicate <tt>http://www.jena.hpl.hp.com/ARQ/list#member</tt>. See the <a
 * href="http://www.openanzo.org/projects/openanzo/wiki/QueryingLists">QueryingLists</a> Open Anzo wiki page.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class ListMemberPredicate implements FunctionalPredicate {
    private TriplePattern tp = null;

    public boolean canBindGraphVariables() {
        return true;
    }

    public SolutionSet generateSolutions(URI namedGraph, Variable namedGraphVariable, SolutionSet bindingConstraints) throws GlitterException {
        try {
            Map<Value, List<Value>> lists = new HashMap<Value, List<Value>>();
            if (tp.getSubject() instanceof Bindable) {
                for (PatternSolution ps : bindingConstraints) {
                    lists.put(ps.getBinding((Bindable) tp.getSubject()), new ArrayList<Value>());
                }
            } else {
                lists.put((Value) tp.getSubject(), new ArrayList<Value>());
            }
            // this maps Anzo node IDs into the RDF term (IRI or blank node) that represents the head of the
            // list
            //Map<Long, RDFTerm> listNode2List = new HashMap<Long, RDFTerm>();
            /**
             * 
             * We recursively translate ?list list:member ?member into ?list rdf:first ?member ?list rdf:rest ?next followed by ?list := ?next
             * 
             * TODO - this isn't quite so simple: we can't recurse at the SPARQL level on bnodes, since we can't identify specific bnodes in a triple pattern
             * (no told bnodes). However, we can do this at the Anzo level by simply reusing the same blank node's ID, so we need a slightly lower level
             * interaction with the database, whereby we can pass in the *ID* of next.
             */
            /*
            Variable member = Variable.createVariable("member"), next = Variable.createVariable("next");
            BGP bgp = new BGP();
            TriplePattern rdffirst = new TriplePattern(tp.getSubject(), new IRIReference(RDF.FIRST), member), rdfrest = new TriplePattern(tp.getSubject(), new IRIReference(RDF.REST), next);
            bgp.addTriplePattern(new TriplePatternNode(rdffirst));
            bgp.addTriplePattern(new TriplePatternNode(rdfrest));
            
            ServerBGPQuery q = new ServerBGPQuery(this.context, qi, this.lastTransactionTime);
            q.setThisNode(bgp);
            if (namedGraph != null)
                q.setNamedGraph(namedGraph);
            if (namedGraphVariable != null)
                q.setGraphVariable(namedGraphVariable);
            q.addTriplePattern(rdffirst);
            q.addTriplePattern(rdfrest);
            
            String sql = q.getSQL(null);
            Statement statement = this.context.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);
            SolutionList solutions = new SolutionList();
            //this.sg.addBindings(q, bgp, rs, solutions, bindableColumns);
            for (PatternSolution solution : solutions) {
                solution.getBinding(namedGraphVariable);
            }
            
            
            return null;
            } catch (SQLException e) {
            return null;
            }
            */} finally {
        }
        return null;
    }

    /**
     * Relatively expensive cost since it involves recursive queries.
     */
    public double getCost(NodeCostModel costModel) {
        return 100;
    }

    public TriplePattern getFunctionalTriplePattern() {
        return this.tp;
    }

    /**
     * Don't handle any other triple patterns besides the functional triple pattern.
     */
    public boolean handlesTriplePattern(TriplePattern pattern) throws FunctionalPredicateInvocationException {
        return false;
    }

    public void initialize(QueryInformation qi) {
    }

    public void setFunctionalTriplePattern(TriplePattern pattern) throws FunctionalPredicateInvocationException {
        this.tp = pattern;
    }

    public boolean usesDataFromGraphs() {
        return true;
    }

}
