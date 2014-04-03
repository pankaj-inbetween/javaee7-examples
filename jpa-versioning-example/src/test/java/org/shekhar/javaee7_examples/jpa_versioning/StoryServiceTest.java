package org.shekhar.javaee7_examples.jpa_versioning;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by shekhargulati on 04/04/14.
 */
@RunWith(Arquillian.class)
public class StoryServiceTest {

    @Deployment
    public static Archive<?> deployment() {
        return ShrinkWrap.create(JavaArchive.class).addPackage(Story.class.getPackage()).addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml").addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml");
    }

    @Inject
    private StoryService storyService;

    @Test
    public void testToCheckVersioning() throws Exception {
        final Story story = storyService.submitStory(new Story("http://whyjava.wordpress.com/2014/04/02/how-to-exclude-a-package-from-cdi-scanning-using-vetoed-annotation/"));

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        final CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Running...");
                    storyService.incrementVote(story.getId());
                    latch.countDown();
                }
            });
        }
        latch.await();
        Assert.assertEquals(10, storyService.findOne(story.getId()).getVotes());
    }
}
