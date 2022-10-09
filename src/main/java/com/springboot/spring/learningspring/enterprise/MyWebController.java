package com.springboot.spring.learningspring.enterprise;

import org.springframework.stereotype.Component;

@Component
public class MyWebController {
    public long returnValueFromBusinessService(){
        return 200;
    }
}
