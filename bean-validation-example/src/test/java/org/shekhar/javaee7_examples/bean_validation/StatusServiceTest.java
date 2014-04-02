package org.shekhar.javaee7_examples.bean_validation;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;

/**
 * Created by shekhargulati on 02/04/14.
 */
@RunWith(Arquillian.class)
public class StatusServiceTest {

    @Inject
    private StatusService statusService;

    @Deployment
    public static Archive<?> deployment() {
        return ShrinkWrap.create(WebArchive.class).addPackage(StatusService.class.getPackage()).
                addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test(expected = Exception.class)
    public void testPostStatus() throws Exception {
        statusService.postStatus(new Status());
    }

    @Test
    public void shouldWorkFine() throws Exception {
        Status status = statusService.postStatus(new Status("hello", "http://test.com"));
        Assert.assertNotNull(status);
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionAsUrlAlreadyExists() throws Exception {
        Status status = statusService.postStatus(new Status("hello", "http://google.com"));
        Assert.assertNotNull(status);
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionAsUrlIsNotValie() throws Exception {
        Status status = statusService.postStatus(new Status("hello", "test.com"));
        Assert.assertNotNull(status);
    }

}