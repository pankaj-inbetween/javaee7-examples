package org.shekhar.javaee7_examples.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by shekhargulati on 08/04/14.
 */
public class StatusServiceTest {

    private WeldContainer container;
    private Weld weld;

    @Before
    public void setup(){
        weld = new Weld();
        container = weld.initialize();
    }

    @After
    public void tearDown(){
        weld.shutdown();
    }


    @Test
    public void testPostStatus() throws Exception {
        StatusService statusService = container.instance().select(StatusService.class).get();
        StatusService2 statusService2 = container.instance().select(StatusService2.class).get();
        Status status = statusService.postStatus("Hello, world");
        statusService2.postStatus("hello, bye");
        System.out.println(status);


        statusService = container.instance().select(StatusService.class).get();
        status = statusService.postStatus("Hello, world");
        System.out.println(status);


        statusService = container.instance().select(StatusService.class).get();
        status = statusService.postStatus("Hello, world");
        System.out.println(status);
    }
}
