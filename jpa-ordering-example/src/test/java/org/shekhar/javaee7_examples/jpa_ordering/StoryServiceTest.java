package org.shekhar.javaee7_examples.jpa_ordering;

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
import java.util.Arrays;

/**
 * Created by shekhargulati on 03/04/14.
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
    public void testSubmitStory() throws Exception {
        Story story = new Story("http://whyjava.wordpress.com/2014/04/02/how-to-exclude-a-package-from-cdi-scanning-using-vetoed-annotation/");
        Story submittedStory = storyService.submitStory(story);
        Assert.assertNotNull(submittedStory);
        Assert.assertNotNull(submittedStory.getId());
    }

    @Test(expected = Exception.class)
    public void submitStoryShouldThrowExceptionWhenStoryUrlIsNotProperUrl() throws Exception {
        Story story = new Story("abc");
        storyService.submitStory(story);
    }

    @Test
    public void shouldStoreStoryWithTags() throws Exception {
        Story story = new Story("http://whyjava.wordpress.com/2014/04/02/how-to-exclude-a-package-from-cdi-scanning-using-vetoed-annotation/");
        story.getTags().addAll(Arrays.asList("javaee", "cdi", "vetoed"));
        Story submittedStory = storyService.submitStory(story);
        Assert.assertEquals(3, submittedStory.getTags().size());
        System.out.println(submittedStory.getTags());
    }
}
