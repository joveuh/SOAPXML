package com.springboot.spring.learningspring.enterprise.web;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

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
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        // Servlet for simplified dispatching of Web service messages.
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext((ApplicationContext) context);
        messageDispatcherServlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean<>(messageDispatcherServlet, "/ws/*");
    }

    // /ws/coures.wsdl
    // course-details.xsd

    @Bean(name="courses")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema coursesSchema){
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        //coursesSchema = coursesSchema();
        definition.setPortTypeName("CoursePort");
        definition.setTargetNamespace("http://localhost:8090/courses");
        definition.setLocationUri("/ws");
        definition.setSchema(coursesSchema);

        // PortType - CoursePort
        // NameSpace - http://localhost:8090/courses
        // schema 

        return definition;
    }



    @Bean
    public XsdSchema coursesSchema(){
       return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
    }

}
