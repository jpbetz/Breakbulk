package org.openanzo.glitter.query.rewriter;

import java.util.Iterator;

import org.openanzo.glitter.query.TreeRewriter;
import org.openanzo.glitter.syntax.abstrakt.BGP;
import org.openanzo.glitter.syntax.abstrakt.GraphPattern;
import org.openanzo.glitter.syntax.abstrakt.Group;
import org.openanzo.glitter.syntax.abstrakt.TreeNode;

/**
 * Implements the simplification step in
 * <a href="http://www.w3.org/TR/rdf-sparql-query/#convertGraphPattern">the SPARQL
 * specification</a>. Joins with empty groups are the identity. It also removes
 * empty BGPs.
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public class SingletonGroupRewriter implements TreeRewriter {

    public TreeNode rewriteTreeNode(TreeNode node) {
        // don't rewrite the root
        if (node.getRoot() == node)
            return node;
        if (node instanceof BGP) {
            if (node.getChildren().isEmpty())
                return null;
        } else if (node instanceof Group) {
            Group g = (Group) node;
            if ((g.getFilters() == null || g.getFilters().size() == 0) && (g.getAssignments() == null || g.getAssignments().size() == 0)) {
                Iterator<GraphPattern> it = g.getPatterns().iterator();
                // remove empty groups without a filter
                if (!it.hasNext())
                    return null;
                GraphPattern first = it.next();
                // if only one element, which is itself a group, replace with that
                if (first instanceof Group && !it.hasNext())
                    return first;
                // otherwise leave the group unchanged
                return node;
            }
        }
        return node;
    }

}
