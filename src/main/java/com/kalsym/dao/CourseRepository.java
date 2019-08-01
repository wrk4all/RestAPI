/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kalsym.dao;

import com.kalsym.course.Course;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Muhammad Waqar
 */
@Repository
public interface CourseRepository extends CrudRepository<Course, String> {
   
    public List<Course> findByTopicId(String topicId);
}
