package org.shekhar.javaee7_examples.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * Created by shekhargulati on 03/04/14.
 */
@ApplicationScoped
@Transactional
public class StatusService {

    @Inject
    private EntityManager entityManager;

    public Status postStatus(String message){
        Status status = new Status(message);
        entityManager.persist(status);
        return status;
    }
}
