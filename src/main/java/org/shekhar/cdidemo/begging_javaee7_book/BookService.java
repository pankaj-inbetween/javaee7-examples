package org.shekhar.cdidemo.begging_javaee7_book;

import javax.inject.Inject;

/**
 * Created by shekhargulati on 02/04/14.
 */
@Loggable
public class BookService {

    @Inject
    @ThirteenDigits
    NumberGenerator numberGenerator;

    public Book createBook(String title, String author) {
        Book book = new Book(title, author);
        book.setIsbn(numberGenerator.generateNumber());
        return book;
    }

}
