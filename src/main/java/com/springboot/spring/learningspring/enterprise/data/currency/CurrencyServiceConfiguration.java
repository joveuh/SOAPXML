package com.springboot.spring.learningspring.enterprise.data.currency;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "currency-service")
@Component
public class CurrencyServiceConfiguration {

    String url;
    String username;
    String key;

    // public CurrencyServiceConfiguration(String url, String username, String key) {
    //     this.url = url;
    //     this.username = username;
    //     this.key = key;
    // }

    public void setUrl(String url) {
        this.url = url;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getUrl() {
        return url;
    }
    public String getUsername() {
        return username;
    }
    public String getKey() {
        return key;
    }




}
