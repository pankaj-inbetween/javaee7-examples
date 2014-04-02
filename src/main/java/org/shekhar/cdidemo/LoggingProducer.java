package org.shekhar.cdidemo;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

/**
 * Created by shekhargulati on 02/04/14.
 */
public class LoggingProducer {

    @Produces
    public Logger logger(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}
