package com.springboot.spring.learningspring.enterprise.web;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import localhost._8090.courses.CourseDetails;
import localhost._8090.courses.GetAllCourseDetailsResponse;
import localhost._8090.courses.GetCourseDetailsRequest;

@Endpoint
public class CourseDetailsEndpointController {

    // Telling spring to only process requests with the following namespace and name
    // of the request
    // @RequestPayload will convert to a POJO the request
    // @ResponsePayLoad will convert to a POJO the response

    /**
     * <pre>
     * &#64;param request
     * @return response
     * </pre>
     */
    @ResponsePayload
    @PayloadRoot(namespace = "http://localhost:8090/courses", localPart = "GetCourseDetailsRequest")
    public GetAllCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
        GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(8402);
        courseDetails.setAuthor("Uzarr");
        courseDetails.setName("big courses");
        response.setCourseDetails(courseDetails);
        return response;
    }

}
