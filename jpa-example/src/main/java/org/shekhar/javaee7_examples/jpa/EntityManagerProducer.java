package org.shekhar.javaee7_examples.jpa;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by shekhargulati on 03/04/14.
 */
public class EntityManagerProducer {

    @Produces
    @PersistenceContext
    private EntityManager entityManager;
}
