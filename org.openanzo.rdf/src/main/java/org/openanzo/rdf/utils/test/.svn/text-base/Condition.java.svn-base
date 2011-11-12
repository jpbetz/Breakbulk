package org.openanzo.rdf.utils.test;


/**
 * A condition that can be may be checked repeatedly until it returns true.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public abstract class Condition {
    /**
     * Called to check if the condition has become true.
     * 
     * @return True if the condition is true.
     */
    public abstract boolean check();

    Error error = null;

    protected boolean run() {
        return check();
    }
}
