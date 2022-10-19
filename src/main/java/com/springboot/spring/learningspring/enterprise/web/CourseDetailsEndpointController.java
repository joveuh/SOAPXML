package com.springboot.spring.learningspring.enterprise.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.springboot.spring.learningspring.enterprise.data.CourseDetailsService;
import com.springboot.spring.learningspring.enterprise.data.CourseDetailsService.Status;
import com.springboot.spring.learningspring.enterprise.data.courses.Course;

import localhost._8090.courses.CourseDetails;
import localhost._8090.courses.DeleteCourseDetailsRequest;
import localhost._8090.courses.DeleteCourseDetailsResponse;
import localhost._8090.courses.GetAllCourseDetailsRequest;
import localhost._8090.courses.GetAllCourseDetailsResponse;
import localhost._8090.courses.GetCourseDetailsResponse;
import localhost._8090.courses.GetCourseDetailsRequest;

// You will keep running into this sort of error message until you use the ComponentScan annotation "The declared package "com.springboot.spring.learningspring.enterprise.web" does not match the expected package "com.springboot.spring.learningspring.enterprise.data.courses"
@Endpoint
@ComponentScan("com.springboot.spring.learningspring.enterprise.data")
public class CourseDetailsEndpointController {

    // Telling spring to only process requests with the following namespace and name
    // of the request
    // @RequestPayload will convert to a POJO the request
    // @ResponsePayLoad will convert to a POJO the response

    @Autowired
    CourseDetailsService service;

    /**
     * <pre>
     * &#64;param request
     * @return response
     * 
     * Checking this thing out.
     * </pre>
     */
    @PayloadRoot(namespace = "http://localhost:8090/courses", localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
        Course course = service.findById(request.getId());
        if (course == null) throw new RuntimeException("Invalid Course Id" + request.getId());
        return mapCourseDetails(course);
    }


    private GetCourseDetailsResponse mapCourseDetails(Course course) {
        GetCourseDetailsResponse response = new GetCourseDetailsResponse();
        response.setCourseDetails(mapCourse(course));
        return response;
    }

    @PayloadRoot(namespace = "http://localhost:8090/courses", localPart = "GetAllCourseDetailsRequest")
    @ResponsePayload
    public GetAllCourseDetailsResponse processAllCourseDetailsRequest(@RequestPayload GetAllCourseDetailsRequest request) {
        List<Course> courses = service.findAll();
        return mapAllCourseDetails(courses);
    }

    private GetAllCourseDetailsResponse mapAllCourseDetails(List<Course> courses) {
        GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
        for (Course c: courses){
            CourseDetails mapCourse = mapCourse(c);
            response.getCourseDetails().add(mapCourse);
        }
        return response;
    }


    @PayloadRoot(namespace = "http://localhost:8090/courses", localPart = "DeleteCourseDetailsRequest")
    @ResponsePayload
    public DeleteCourseDetailsResponse deleteCourseDetailsRequest(@RequestPayload DeleteCourseDetailsRequest request) {
        Status status = service.deleteById(request.getId());
        DeleteCourseDetailsResponse response = new DeleteCourseDetailsResponse();
        response.setStatus(mapStatusFromEnumtoDeleteCourseDetailsResponseXSDJavaClass(status));
        return response;
    }


    private localhost._8090.courses.Status mapStatusFromEnumtoDeleteCourseDetailsResponseXSDJavaClass(Status status) {
        if (status == Status.FAILURE) return localhost._8090.courses.Status.FAILURE;
        return localhost._8090.courses.Status.SUCCESS;
    }


    private CourseDetails mapCourse(Course course) {
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setDescription(course.getdescription());
        courseDetails.setName(course.getName());
        courseDetails.setId(course.getId());
        return courseDetails;
    }

}
