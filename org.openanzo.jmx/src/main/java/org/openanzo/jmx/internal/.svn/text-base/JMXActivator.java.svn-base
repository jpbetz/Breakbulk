package org.openanzo.jmx.internal;

import org.openanzo.osgi.ConfiguredServiceActivator;
import org.openanzo.osgi.GenericObjectClassDef;
import org.openanzo.osgi.ServiceLifecycleState;
import org.openanzo.osgi.attributes.CombusAttributes;
import org.openanzo.osgi.attributes.ServicesAttributes;
import org.openanzo.services.IAuthenticationService;
import org.openanzo.services.ServicesDictionary;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.ObjectClassDefinition;

/**
 * JMX Service activator
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class JMXActivator extends ConfiguredServiceActivator {

    //private static final Logger   log                 = LoggerFactory.getLogger(JMXActivator.class);

    private JMXService                  jmxService  = null;

    static final String   SERVICE_PID = "org.openanzo.JMX";

    GenericObjectClassDef classDef;

    public ObjectClassDefinition getObjectClassDefinition(String id, String locale) {
        return classDef != null ? classDef : (classDef = new GenericObjectClassDef(SERVICE_PID, getBundleName(), getBundleDescription(), new AttributeDefinition[] { ServicesAttributes.Enabled, CombusAttributes.Port }, null));
    }

    @Override
    public String getServicePid() {
        return SERVICE_PID;
    }

    @Override
    public boolean startThreaded() {
        return true;
    }

    @Override
    public String[] getDependencies() {
        return new String[] { IAuthenticationService.class.getName() };
    }

    @Override
    public void start() {
        boolean enabled = ServicesDictionary.getEnabled(configProperties);
        if (enabled) {
            jmxService = new JMXService(context, configProperties, eventAdmin, getDependency(IAuthenticationService.class));
            jmxService.start();
        } else {
            state = ServiceLifecycleState.NOT_ENABLED;
        }
    }

    @Override
    public void stop(boolean bundleStopping) {
        if (jmxService != null) {
            jmxService.close();
        }
    }
}
