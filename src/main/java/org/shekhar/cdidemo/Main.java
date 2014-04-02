package org.shekhar.cdidemo;

import org.jboss.weld.Weld;
import org.jboss.weld.environment.se.StartMain;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * Created by shekhargulati on 02/04/14.
 */
public class Main {
    public static void main(String[] args) {
        StartMain startMain = new StartMain(null);
        WeldContainer container = startMain.go();
        BookService bookService = container.instance().select(BookService.class).get();
        Book book = bookService.createBook("OpenShift Cookbook", "Shekhar Gulati");
        System.out.println(book);

    }
}
