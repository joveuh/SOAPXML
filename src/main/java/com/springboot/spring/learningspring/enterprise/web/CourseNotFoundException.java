package com.springboot.spring.learningspring.enterprise.web;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

// We are adding this because in the Wizdler SOAP response we see:
// <faultcode> SOAP-ENV:Server >/faultcode>. This is actually not true because this 
// is not a server fault because the client is not providing the correct course number.

// @SoapFault(faultCode = FaultCode.CLIENT)

@SoapFault(faultCode=FaultCode.CUSTOM, customFaultCode="{http://localhost:8090/courses}001_COURSE_NOT_FOUND")
public class CourseNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CourseNotFoundException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "CourseNotFoundException []";
    }

}
