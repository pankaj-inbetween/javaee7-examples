package org.shekhar.cdidemo.myexample;

import java.util.Date;

/**
 * Created by shekhargulati on 02/04/14.
 */
public class Status {

    private final String message;
    private final Date createdAt = new Date();

    public Status(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Status{" +
                "message='" + message + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
