package org.openanzo.glitter.expression;

import java.util.Map;

/**
 *
 * A {@link FunctionWithAttributes} is a {@link Function} that can have (arbitrary) attributes
 * set that affect it's behavior. These attributes may be "long-acting" if a Function is re-used,
 * but in most cases will be set once directly preceding invocation of the function.
 *
 * @author lee <lee@cambridgesemantics.com>
 *
 */
public interface FunctionWithAttributes extends Function {

    /**
     * Sets the attributes of this function that are in effect fcor subsequent
     * calls, until the next call to setAttributes.
     *
     * @param attributes key/value pairs that represent function attributes
     */
    public void setAttributes(Map<String, Object> attributes);
}
