package org.shekhar.javaee7_examples.cdi;

import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Created by shekhargulati on 02/04/14.
 */
@Interceptor
@Loggable
public class LoggingInterceptor {

    @Inject
    private Logger logger;

    @AroundConstruct
    public Object aroundConstruct(InvocationContext invocationContext) throws Exception {
        logger.trace(String.format("Entering constructor for class %s", invocationContext.getConstructor().getName()));
        try {
            return invocationContext.proceed();
        } finally {
            logger.trace(String.format("Exiting constructor for class %s", invocationContext.getConstructor().getName()));
        }

    }
}
