/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kalsym.course;



import com.kalsym.topic.Topic;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Muhammad Waqar
 */
@RestController
public class CourseController {

    
    @Autowired
    private CourseService ts;
    

    
    @RequestMapping("/topics/{id}/course")
    public List<Course> getAllCourses(@PathVariable String id){
        return ts.getAllCourse(id);
    }
    
    @RequestMapping("/topics/{topicId}/course/{id}")
    public Course getCourse(@PathVariable  String id){
        return ts.getCourse(id);
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/course")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "", ""));
        ts.addCourse(course);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/course/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "", ""));
        ts.updateCourse(course);
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/course/{id}")
    public void deleteCourse(@PathVariable String id){
        ts.deleteCourse(id);
    }
    
}
