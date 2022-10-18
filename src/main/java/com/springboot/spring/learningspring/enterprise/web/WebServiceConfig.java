package com.springboot.spring.learningspring.enterprise.web;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

// Enable Spring Web Services
@EnableWs

// Spring Configuration
@Configuration
public class WebServiceConfig {

    // ServletRegistrationBean: A ServletContextInitializer to register Servlets in
    // a Servlet 3.0+ container. Similar to the registration features provided by
    // ServletContext but with a Spring Bean friendly design.

    // Indicates that a method produces a bean to be managed
    @Bean
    ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        // Servlet for simplified dispatching of Web service messages.
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext((ApplicationContext) context);
        messageDispatcherServlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean<>(messageDispatcherServlet, "/ws/*");
    }
}
