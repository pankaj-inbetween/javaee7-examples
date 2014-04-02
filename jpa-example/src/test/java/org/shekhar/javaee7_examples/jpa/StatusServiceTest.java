package org.shekhar.javaee7_examples.jpa;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by shekhargulati on 03/04/14.
 */
@RunWith(Arquillian.class)
public class StatusServiceTest {

    @Deployment
    public static Archive<?> deployment() {
        return ShrinkWrap.create(WebArchive.class).addPackage(StatusService.class.getPackage()).
                addAsResource("META-INF/persistence.xml","META-INF/persistence.xml").
                addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    private StatusService statusService;

    @Test
    public void testPostStatus() throws Exception {
        Status status = statusService.postStatus("Hello, world");
        Assert.assertNotNull(status);
        Assert.assertEquals(1L, status.getId().longValue());
    }
}
