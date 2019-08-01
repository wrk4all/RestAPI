/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kalsym.opportunity;

/**
 *
 * @author Muhammad Waqar
 */
public class Opportunity {

    String Id;
    String Name;

    public Opportunity() {
    }

    public Opportunity(String id, String name) {
        super();
        Id = id;
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}
