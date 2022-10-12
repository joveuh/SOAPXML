package com.springboot.spring.learningspring.enterprise.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.springboot.spring.learningspring.enterprise.business.BusinessService;
 
@Component
@ComponentScan("com.springboot.spring.learningspring.enterprise.business")
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

// package com.springboot.spring.learningspring.enterprise.business;

// @Component
// class BusinessService {

//     @Autowired
//     private DataService dataService;

//     public long calculateSum(){
//         List<Integer> data = dataService.getData();
//         return data.stream().reduce(Integer::sum).get();
//     }
// }

// package com.springboot.spring.learningspring.enterprise.data;

// @Component
// class DataService {
//     public List<Integer> getData(){
//         return Arrays.asList(10,20,30,40);
//     }
// }
