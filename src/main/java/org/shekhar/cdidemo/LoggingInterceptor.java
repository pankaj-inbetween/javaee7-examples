package org.shekhar.cdidemo;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

/**
 * Created by shekhargulati on 02/04/14.
 */
@Interceptor
@Loggable
public class LoggingInterceptor {

    @Inject
    Logger logger;

    @AroundInvoke
    public Object aroundInvoke(InvocationContext invocationContext) throws Exception{
        logger.entering(invocationContext.getClass().getName(),invocationContext.getMethod().getName());
        try {
            return invocationContext.proceed();
        }finally {
            logger.exiting(invocationContext.getClass().getName(),invocationContext.getMethod().getName());
        }

    }
}
