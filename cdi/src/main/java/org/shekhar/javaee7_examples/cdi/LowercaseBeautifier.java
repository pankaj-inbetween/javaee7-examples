package org.shekhar.javaee7_examples.cdi;

/**
 * Created by shekhargulati on 02/04/14.
 */
@Beautifier(type = BeautifierType.LOWERCASE)
public class LowercaseBeautifier implements MessageBeautifier {
    @Override
    public String beautify(String message) {
        return message != null ? message.toLowerCase() : null;
    }
}
