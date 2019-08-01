/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kalsym.topic;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muhammad Waqar
 */
@Service
public class TopicService {
    
    @Autowired
    private TopicRepository tr;
    
    public List<Topic> getAllTopics(){
      List<Topic> values = new ArrayList<>();
      tr.findAll().forEach(values::add);
        return values;
    }
    
    public Topic getTopic(String id){
//        return values.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return tr.findOne(id);
    }

    public void addTopic(Topic topic) {
        tr.save(topic);
    }

    void updateTopic(String id, Topic topic) {
//        for(int i = 0; i < values.size() - 1; i++){
//            Course t = values.get(i);
//            if(t.getId().equals(id)){
//                values.set(i, topic);
//                return;
//            }
//        }
        tr.save(topic);
       
    }

    void deleteTopic(String id) {
//        values.removeIf(t -> t.getId().equals(id));
        tr.delete(id);
    }
    
}
