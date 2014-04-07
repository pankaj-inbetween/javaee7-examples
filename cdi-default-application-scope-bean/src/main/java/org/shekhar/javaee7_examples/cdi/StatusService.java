package org.shekhar.javaee7_examples.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Created by shekhargulati on 02/04/14.
 */
@ApplicationScoped
public class StatusService {

    public StatusService() {
        System.out.println("in StatusService");
    }

    @Inject
    private MessageBeautifier messageBeautifier;


    public Status postStatus(String message) {
        Status status = new Status(messageBeautifier.beautify(message));
        return status;
    }
}
