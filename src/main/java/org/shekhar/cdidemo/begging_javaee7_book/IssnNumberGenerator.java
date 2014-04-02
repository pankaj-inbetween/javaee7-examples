package org.shekhar.cdidemo.begging_javaee7_book;

/**
 * Created by shekhargulati on 02/04/14.
 */
@EightDigits
public class IssnNumberGenerator implements NumberGenerator {

    @Override
    public String generateNumber() {
        return "issn";
    }
}
