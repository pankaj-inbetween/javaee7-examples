package org.shekhar.javaee7_examples.jpa_ordering;

import org.hibernate.validator.constraints.URL;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by shekhargulati on 03/04/14.
 */
@ApplicationScoped
@Transactional
public class StoryService {

    @Inject
    private EntityManager entityManager;

    public Story submitStory(@Valid Story story) {
        entityManager.persist(story);
        return story;
    }

    public Story findOne(Long id) {
        return entityManager.find(Story.class, id);
    }

}
