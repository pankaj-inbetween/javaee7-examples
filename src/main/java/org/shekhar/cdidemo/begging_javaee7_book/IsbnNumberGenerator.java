package org.shekhar.cdidemo.begging_javaee7_book;

/**
 * Created by shekhargulati on 02/04/14.
 */
@ThirteenDigits
public class IsbnNumberGenerator implements NumberGenerator {

    @Override
    public String generateNumber() {
        return "isbn";
    }
}
