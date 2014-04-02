package org.shekhar.cdidemo;

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
