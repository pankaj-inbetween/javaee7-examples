package org.shekhar.cdidemo.myexample;

import org.apache.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * Created by shekhargulati on 02/04/14.
 */
@Loggable
@ApplicationScoped
public class NotificationService {

    @Inject
    private Logger logger;

    public void notify(@Observes Status status) {
        logger.info("Notify all about status " + status);
    }
}
