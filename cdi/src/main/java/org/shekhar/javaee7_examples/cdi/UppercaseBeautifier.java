package org.shekhar.javaee7_examples.cdi;

/**
 * Created by shekhargulati on 02/04/14.
 */
@Beautifier(type = BeautifierType.UPPERCASE)
public class UppercaseBeautifier implements MessageBeautifier {

    @Override
    public String beautify(String message) {
        return message != null ? message.toUpperCase() : null;
    }
}
