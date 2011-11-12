package org.openanzo.execution;

import java.io.Writer;
import java.util.Collection;

import org.openanzo.exceptions.AnzoException;
import org.openanzo.exceptions.LogUtils;
import org.openanzo.rdf.RDFFormat;
import org.openanzo.rdf.Statement;
import org.openanzo.rdf.URI;
import org.openanzo.rdf.utils.ReadWriteUtils;
import org.openanzo.services.DynamicServiceStats;
import org.openanzo.services.IExecutionService;
import org.openanzo.services.IOperationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Base Execution Service
 * 
 * @author Matthew Roy ( <a href="mailto:mroy@cambridgesemantics.com">mroy@cambridgesemantics.com</a>)
 * 
 */
public abstract class BaseExecutionService implements IExecutionService {

    private static final Logger       log   = LoggerFactory.getLogger(BaseExecutionService.class);

    private final DynamicServiceStats stats = new DynamicServiceStats(EXECUTE_SERVICE);

    /**
     * Create a new BaseExecutionService
     */
    public BaseExecutionService() {
    }

    public DynamicServiceStats getStatistics() {
        return stats;
    }

    public Collection<Statement> executeService(IOperationContext context, Collection<Statement> statements, URI operationUri) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try {
            try {
                return executeServiceInternal(context, statements, operationUri);
            } catch (AnzoException e) {
                log.error(LogUtils.EXECUTION_MARKER, "Error executing service", e);
                throw (e);
            }
        } finally {
            if (stats.isEnabled()) {
                stats.use(EXECUTE_SERVICE, (System.currentTimeMillis() - start));
            }
        }
    }

    public void executeService(IOperationContext context, String reader, String readerFormat, URI serviceUri, Writer output, String resultFormat) throws AnzoException {
        long start = 0;
        if (stats.isEnabled()) {
            start = System.currentTimeMillis();
        }
        try {
            try {
                Collection<Statement> statements = ReadWriteUtils.readStatements(reader, RDFFormat.forMIMEType(readerFormat));
                Collection<Statement> result = executeServiceInternal(context, statements, serviceUri);
                ReadWriteUtils.writeStatements(result, output, RDFFormat.forMIMEType(resultFormat));
            } catch (AnzoException e) {
                log.error(LogUtils.EXECUTION_MARKER, "Error executing service", e);
                throw (e);
            }
        } finally {
            if (stats.isEnabled()) {
                stats.use(EXECUTE_SERVICE, (System.currentTimeMillis() - start));
            }
        }

    }

    protected abstract Collection<Statement> executeServiceInternal(IOperationContext context, Collection<Statement> statements, URI operationUri) throws AnzoException;

}
