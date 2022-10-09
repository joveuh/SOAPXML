package com.springboot.spring.learningspring.enterprise;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyWebController {

    @Autowired
    private BusinessService businessService;

    public long returnValueFromBusinessService(){
        return businessService.calculateSum();
    }
}

/**
 * You don't directly call returnValueFromBusinessService method through getBean.
 * Instead another class such as BusinessService calls it.
 * In fact, BusinessService itself might be getting called by another class such as DataService
 **/

@Component
class BusinessService {

    @Autowired
    private DataService dataService;

    public long calculateSum(){
        List<Integer> data = dataService.getData();
        return data.stream().reduce(Integer::sum).get();
    }
}

@Component
class DataService {
    public List<Integer> getData(){
        return Arrays.asList(10,20,30,40);
    }
}
