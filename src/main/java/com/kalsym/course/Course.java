/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kalsym.course;

import com.kalsym.topic.Topic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Muhammad Waqar
 */
@Entity
public class Course {
    
    @Id
    private String id;
    private String name;
    private String description;
    @ManyToOne
    private Topic topic;

    public Course(){
        
    }
    
    public Course(String id, String name, String desc, String topicId) {
        super();
        this.id = id;
        this.name = name;
        this.description = desc;
        this.topic = new Topic(topicId, "", "");
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Topic getTopic() {
        return topic;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }
    
    
}
