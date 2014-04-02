package org.shekhar.javaee7_examples.bean_validation;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by shekhargulati on 02/04/14.
 */
@ApplicationScoped
public class UrlService {

    private final static Set<String> URLS = new HashSet<String>();

    @PostConstruct
    public void init(){
        URLS.add("http://google.com");
        URLS.add("http://yahoo.com");
        URLS.add("http://bing.com");
        URLS.add("http://twitter.com");
        URLS.add("http://facebook.com");
    }

    public boolean exists(String url){
        return URLS.contains(url);
    }
}
