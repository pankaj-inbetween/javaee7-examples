package org.shekhar.javaee7_examples.jpa_versioning;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by shekhargulati on 03/04/14.
 */
@Entity
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(nullable = false)
    @URL
    private String url;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private final Date submitteAt = new Date();

    @ElementCollection
    @CollectionTable(name = "Tags")
    @OrderColumn(name = "tag_index")
    private final List<String> tags = new ArrayList<String>();

    private int votes;

    public Story(String url) {
        this.url = url;
    }

    public Story() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getSubmitteAt() {
        return submitteAt;
    }

    public List<String> getTags() {
        return tags;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

}

