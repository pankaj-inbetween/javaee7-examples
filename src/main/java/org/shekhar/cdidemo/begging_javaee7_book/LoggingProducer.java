package org.shekhar.cdidemo.begging_javaee7_book;

import org.apache.log4j.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.interceptor.InvocationContext;

/**
 * Created by shekhargulati on 02/04/14.
 */
public class LoggingProducer {

    @Produces
    public Logger logger(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}
