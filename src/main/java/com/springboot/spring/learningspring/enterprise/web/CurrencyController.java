package com.springboot.spring.learningspring.enterprise.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.spring.learningspring.enterprise.data.currency.CurrencyServiceConfiguration;
 
@RestController
@Component
@ComponentScan("com.springboot.spring.learningspring.enterprise.data.currency")
public class CurrencyController {

    @Autowired
    CurrencyServiceConfiguration configuration;

    @RequestMapping("/currency-configuration")
    public CurrencyServiceConfiguration outputAllCourses(){
        return configuration;
    }
}
