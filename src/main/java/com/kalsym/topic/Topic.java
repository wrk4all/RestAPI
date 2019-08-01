/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kalsym.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Muhammad Waqar
 */
@Entity
public class Topic {
    
    @Id
    private String id;
    private String name;
    private String description;

    public Topic(){
        
    }
    
    public Topic(String id, String name, String desc) {
        super();
        this.id = id;
        this.name = name;
        this.description = desc;
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
