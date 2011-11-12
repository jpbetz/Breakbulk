package org.openanzo.rdf.utils.test;

/**
 * Runs the test block and checks for any junit AssertionFailedErrors.
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public abstract class AssertBlock extends Condition {
    /**
     * Called to check if the condition has become true.
     * 
     * @return True if the condition is true.
     */
    @Override
    public boolean check() {
        return true;
    }

    /**
     * Test assert block
     */
    public abstract void test();

    @Override
    protected boolean run() {
        try {
            test();
            error = null;
            return true;
        } catch (Error e) {
            error = e;
            return false;
        }
    }
}
