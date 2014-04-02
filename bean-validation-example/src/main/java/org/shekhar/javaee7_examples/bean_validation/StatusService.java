package org.shekhar.javaee7_examples.bean_validation;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;

/**
 * Created by shekhargulati on 02/04/14.
 */
@ApplicationScoped
public class StatusService {

    public Status postStatus(@Valid Status status) {
        return status;
    }
}
