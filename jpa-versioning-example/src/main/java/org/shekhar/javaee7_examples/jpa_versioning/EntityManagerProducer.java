package org.shekhar.javaee7_examples.jpa_versioning;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by shekhargulati on 03/04/14.
 */
public class EntityManagerProducer {

    @Produces
    @PersistenceContext(unitName = "myPU")
    private EntityManager entityManager;
}
