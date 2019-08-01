/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kalsym.topic;



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
public class TopicController {

    
    @Autowired
    private TopicService ts;
    
    
    @RequestMapping("/")
    public String HelloWorld(){
        return "Hello World";
    }

    @RequestMapping("/hello")
    public String sayHi(){
        return "Hi";
    }
    
    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return ts.getAllTopics();
    }
    
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable  String id){
        return ts.getTopic(id);
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Topic topic){
        ts.addTopic(topic);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
        ts.updateTopic(id, topic);
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        ts.deleteTopic(id);
    }
    
}
