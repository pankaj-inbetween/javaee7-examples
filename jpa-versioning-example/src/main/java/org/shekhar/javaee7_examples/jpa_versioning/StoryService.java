package org.shekhar.javaee7_examples.jpa_versioning;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import javax.validation.Valid;

/**
 * Created by shekhargulati on 03/04/14.
 */
@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRES_NEW)
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

    public void incrementVote(Long storyId) {
        Story story = entityManager.find(Story.class, storyId);
        entityManager.refresh(story, LockModeType.PESSIMISTIC_WRITE);
        System.out.println(Thread.currentThread().getName() + " ... Going to increment .. " + storyId + " with votes " + story.getVotes());
        story.setVotes(story.getVotes() + 1);
        System.out.println(Thread.currentThread().getName() + " ... Incremented .. " + storyId + " with votes " + story.getVotes());
    }
}
