package org.openanzo.rdf;

import java.io.ObjectStreamException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Represents a blank node, identified by an index. Identity is determined purely by object reference equality.
 * 
 * @author lee <lee@cambridgesemantics.com>
 * 
 */
public class MemBlankNode implements BlankNode {
    private static final long                         serialVersionUID = 4126408067877740675L;

    private int                                       hashCode         = -1;

    final private String                              value;

    private transient SoftReference<String>           toStringValue    = null;

    private static Map<String, WeakReference<String>> map              = new WeakHashMap<String, WeakReference<String>>();

    private synchronized static String replace(String object) {
        if (object == null) {
            return null;
        }
        WeakReference<String> reference = map.get(object);
        if (reference != null) {
            String result = reference.get();
            // Another null check, since the GC may have kicked in between the 
            // two lines above.
            if (result != null) {
                return result;
            }
        }
        // If we got here it is because the map doesn't have the key, add it.
        map.put(object, new WeakReference<String>(object));
        return object;
    }

    /**
     * Create a blanknode with the given ID
     * 
     * @param id
     *            id of blank node
     * @return blank node for id
     */
    public static BlankNode create(String id) {
        return MemValueFactory.defaultFactory.createBNode(id);
    }

    protected Object readResolve() throws ObjectStreamException {
        return create(value);
    }

    /**
     * Constructor.
     * 
     * @param index
     */
    protected MemBlankNode(String value) {
        this.value = replace(value);
    }

    @Override
    public String toString() {
        String string = (toStringValue != null) ? toStringValue.get() : null;
        if (string == null) {
            string = Constants.BNODE_PREFIX + this.value;
            toStringValue = new SoftReference<String>(string);
        }
        return string;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof MemBlankNode) {
            // we don't change the natural meaning of equals, and want to be explicit about it.
            // blank nodes are only equal if they're the same object.
            return this == other || ((MemBlankNode) other).value.equals(value);
        } else if (other instanceof BlankNode) {
            // we don't change the natural meaning of equals, and want to be explicit about it.
            // blank nodes are only equal if they're the same object.
            return this == other || ((BlankNode) other).getLabel().equals(value);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        if (hashCode == -1) {
            hashCode = value.hashCode();
        }
        // we don't change the natural meaning of hashCode, and want to be explicit about it.
        // blank nodes are only the same if they're the same object.
        return hashCode;
    }

    public int compareTo(TriplePatternComponent o) {
        return toString().compareTo(o.toString());
    }

    public String getLabel() {
        return value;
    }
}
