package org.shekhar.cdidemo.begging_javaee7_book;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * Created by shekhargulati on 02/04/14.
 */
public class Main {
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BookService bookService = container.instance().select(BookService.class).get();
        Book book = bookService.createBook("OpenShift Cookbook", "Shekhar Gulati");
        System.out.println(book);
    }
}
