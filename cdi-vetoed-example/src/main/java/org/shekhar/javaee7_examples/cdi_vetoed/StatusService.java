package org.shekhar.javaee7_examples.cdi_vetoed;

import javax.enterprise.context.ApplicationScoped;

/**
 * Created by shekhargulati on 02/04/14.
 */
@ApplicationScoped
public class StatusService {

    public String postStatus(String status){
        return status;
    }
}
