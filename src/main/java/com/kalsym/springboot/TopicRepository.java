/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kalsym.springboot;


import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Muhammad Waqar
 */
public interface TopicRepository extends CrudRepository<Topic, String> {
    
}
