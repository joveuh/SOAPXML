package com.springboot.spring.learningspring.enterprise.web;

import org.springframework.context.ApplicationContext;

import java.util.Collections;
import java.util.List;

import javax.security.auth.callback.CallbackHandler;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.soap.security.wss4j2.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.soap.security.xwss.XwsSecurityInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

// Enable Spring Web Services
@EnableWs
// Spring Configuration
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter{

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

    @Bean(name = "courses")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema coursesSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        // coursesSchema = coursesSchema();
        definition.setPortTypeName("CoursePort");
        definition.setTargetNamespace("http://localhost:8090/courses");
        definition.setLocationUri("/ws");
        definition.setSchema(coursesSchema);

        // PortType - CoursePort
        // NameSpace - http://localhost:8090/courses
        // schema

        return definition;
    }

    // Security using WS-Security standard, which provides security via:
    // Authentication
    // Digital Signatures
    // Certificates
    //
    // One of the implementations of WS-Security is XWSS (XMLand Web Services
    // Security)
    // We will implement a simple Security Policy using XWSS
    // We will also use an XWS Security Interceptor to ensure only requests with
    // valid userID and password are able to access the service
    //
    // Once we create the XWS Security Interceptor, we will need to add it to the list of interceptors.
    // Spring Web Services provides a mechanism to allow adding to a list of exisitng interceptors.
    /**
     * The interceptor must implement a CallbackHandler i.e. what should the interceptor do when it receives a call? It should check the userID and password for validity
     * In this example, we used a SimplePasswordValidationCallbackHandler which is provided by Spring Web Services Security.
     * The other thing is we create a security po;lic.xml to define the security policy and configure it in our interceptor.
     * 
     * @return
     */
    @Bean
    public XwsSecurityInterceptor securityInterceptor(){
        XwsSecurityInterceptor securityInterceptor = new XwsSecurityInterceptor();
        securityInterceptor.setCallbackHandler(callbackHandler());
        securityInterceptor.setPolicyConfiguration(new ClassPathResource("xml/xwssSecurityPolicy.xml"));
        return securityInterceptor;
    }


    public SimplePasswordValidationCallbackHandler callbackHandler() {
		SimplePasswordValidationCallbackHandler handler = new SimplePasswordValidationCallbackHandler();
        handler.setUsersMap(Collections.singletonMap("uzair", "pass"));
        return handler;
	}

	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(securityInterceptor());
    }

    
    @Bean
    public XsdSchema coursesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
    }

}
