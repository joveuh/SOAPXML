package com.springboot.spring.learningspring.enterprise.business;

import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import com.springboot.spring.learningspring.enterprise.data.DataService;


@Component
@ComponentScan("com.springboot.spring.learningspring.enterprise.data")
public class BusinessService {

    @Autowired
    private DataService dataService;

    public long calculateSum(){
        List<Integer> data = dataService.getData();
        return data.stream().reduce(Integer::sum).get();
    }
}
