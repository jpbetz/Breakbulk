package org.openanzo.execution.echo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.List;
import java.util.Properties;

import org.openanzo.execution.java.IBundledSemanticService;
import org.openanzo.execution.java.ISemanticServiceFactory;
import org.openanzo.execution.java.JavaServiceActivator;

/**
 * Activator for both the echo and long running test services
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public class EchoServiceActivator extends JavaServiceActivator {
    //private static final Logger log         = LoggerFactory.getLogger(EchoServiceActivator.class);

    private static final String SERVICE_PID = "org.openanzo.execution.echo.EchoService";

    @Override
    public String getServicePid() {
        return SERVICE_PID;
    }

    @Override
    public String getName() {
        return "EchoServiceActivator";
    }

    @Override
    public Dictionary<? extends Object, ? extends Object> getDefaultConfigProperties() {
        return new Properties();
    }

    @Override
    public Collection<IBundledSemanticService> getBundledServices(Dictionary<? extends Object, ? extends Object> configProperties) {
        List<IBundledSemanticService> services = new ArrayList<IBundledSemanticService>();
        services.add(new EchoSemanticService(configProperties));
        return services;
    }

    @Override
    public Collection<ISemanticServiceFactory> getServiceFactories(Dictionary<? extends Object, ? extends Object> configProperties) {
        List<ISemanticServiceFactory> services = new ArrayList<ISemanticServiceFactory>();
        services.add(new LongRunningServiceFactory(configProperties));
        return services;
    }

}
