package org.shekhar.cdidemo.myexample;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * Created by shekhargulati on 02/04/14.
 */
@Loggable
@ApplicationScoped
public class StatusService {

    @Inject
    @Beautifier(type = BeautifierType.UPPERCASE)
    private MessageBeautifier messageBeautifier;
    @Inject
    private Event<Status> event;


    public Status postStatus(String message) {
        Status status = new Status(messageBeautifier.beautify(message));
        event.fire(status);
        return status;
    }
}
