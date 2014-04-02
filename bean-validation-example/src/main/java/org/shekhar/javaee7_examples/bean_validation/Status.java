package org.shekhar.javaee7_examples.bean_validation;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by shekhargulati on 02/04/14.
 */
public class Status implements Serializable{

    @NotNull
    @Size(max = 140)
    private String message;
    @NotNull
    private final Date postedAt = new Date();
    @UniqueUrl
    private String url;

    public Status() {
    }

    public Status(String message, String url) {
        this.message = message;
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Status{" +
                "message='" + message + '\'' +
                ", postedAt=" + postedAt +
                ", url='" + url + '\'' +
                '}';
    }
}
