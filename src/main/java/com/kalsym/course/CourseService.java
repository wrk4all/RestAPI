/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kalsym.course;

import com.kalsym.dao.CourseRepository;
import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muhammad Waqar
 */
@Service
public class CourseService {
    
//    @Autowired
    private CourseRepository tr;
    
    public List<Course> getAllCourse(String id){
      List<Course> values = new ArrayList<>();
      tr.findByTopicId(id).forEach(values::add);
        return values;
    }
    
    public Course getCourse(String id){
//        return values.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return tr.findOne(id);
    }

    public void addCourse(Course course) {
        tr.save(course);
    }

    void updateCourse(Course course) {
//        for(int i = 0; i < values.size() - 1; i++){
//            Course t = values.get(i);
//            if(t.getId().equals(id)){
//                values.set(i, topic);
//                return;
//            }
//        }
        tr.save(course);
       
    }

    void deleteCourse(String id) {
//        values.removeIf(t -> t.getId().equals(id));
        tr.delete(id);
    }
    
}
