package org.shekhar.javaee7_examples.cdi;

import org.apache.commons.lang3.StringUtils;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

/**
 * Created by shekhargulati on 02/04/14.
 */
@Decorator
public class TitleCaseMessageDecorator implements MessageBeautifier {

    @Inject
    @Delegate
    private MessageBeautifier messageBeautifier;

    public TitleCaseMessageDecorator() {
        System.out.println("Inside constructor");
    }

    @Override
    public String beautify(String message) {
        String msg = messageBeautifier.beautify(message);
        return StringUtils.capitalize(msg);
    }
}
