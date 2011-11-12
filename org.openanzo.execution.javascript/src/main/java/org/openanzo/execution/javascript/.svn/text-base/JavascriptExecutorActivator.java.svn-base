package org.openanzo.execution.javascript;

import java.util.Dictionary;
import java.util.Hashtable;

import org.openanzo.execution.BaseExecutorActivator;
import org.openanzo.execution.BaseServiceExecutor;
import org.openanzo.osgi.GenericObjectClassDef;
import org.openanzo.osgi.attributes.ServicesAttributes;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;

/**
 * Activator for JavaScript Semantic Service Executor
 * 
 */
public class JavascriptExecutorActivator extends BaseExecutorActivator {

    //private static final Logger log         = LoggerFactory.getLogger(JavascriptExecutorActivator.class);
    /** Service PID for the JavaScript Semantic Service Executor */
    public static final String SERVICE_PID = "org.openanzo.execution.javascript.JavascriptServiceExecutor";

    GenericObjectClassDef      classDef;

    public ObjectClassDefinition getObjectClassDefinition(String id, String locale) {
        return classDef != null ? classDef : (classDef = new GenericObjectClassDef(SERVICE_PID, getBundleName(), getBundleDescription(), new AttributeDefinition[] { ServicesAttributes.Enabled }, null));
    }

    @Override
    public String getServicePid() {
        return SERVICE_PID;
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop(boolean bundleStopping) {
        super.stop(bundleStopping);
    }

    @Override
    public Dictionary<? extends Object, ? extends Object> getDefaultConfigProperties() {
        return new Hashtable<Object, Object>();
    }

    @Override
    public BaseServiceExecutor getExecutor(Dictionary<? extends Object, ? extends Object> configProperties) {
        return new JavascriptServiceExecutor();
    }
}
