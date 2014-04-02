package org.shekhar.javaee7_examples.cdi_vetoed;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.enterprise.inject.UnsatisfiedResolutionException;

/**
 * Created by shekhargulati on 02/04/14.
 */
public class StatusServiceTest {

    private Weld weld;
    private WeldContainer container;

    @Before
    public void setup() {
        weld = new Weld();
        container = weld.initialize();
    }

    @After
    public void tearDown() {
        weld.shutdown();
    }

    @Test(expected = UnsatisfiedResolutionException.class)
    public void testPostStatus() throws Exception {
        StatusService statusService = container.instance().select(StatusService.class).get();
    }
}
