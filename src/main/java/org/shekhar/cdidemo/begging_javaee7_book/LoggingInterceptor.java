package org.shekhar.cdidemo.begging_javaee7_book;

import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
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

    @AroundInvoke
    public Object aroundInvoke(InvocationContext invocationContext) throws Exception {
        logger.trace(String.format("Entered class %s method %s", invocationContext.getClass().getName(), invocationContext.getMethod().getName()));
        try {
            return invocationContext.proceed();
        } finally {
            logger.trace(String.format("Leaving class %s method %s", invocationContext.getClass().getName(), invocationContext.getMethod().getName()));
        }

    }
}
