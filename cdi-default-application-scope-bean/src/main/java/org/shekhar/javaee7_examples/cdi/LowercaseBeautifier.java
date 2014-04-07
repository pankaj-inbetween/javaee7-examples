package org.shekhar.javaee7_examples.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.New;

/**
 * Created by shekhargulati on 02/04/14.
 */
public class LowercaseBeautifier implements MessageBeautifier {
    public LowercaseBeautifier() {
        System.out.println("In constructor");
    }

    @Override
    public String beautify(String message) {
        return message != null ? message.toLowerCase() : null;
    }
}
