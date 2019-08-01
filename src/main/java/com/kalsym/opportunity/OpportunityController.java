/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kalsym.opportunity;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Muhammad Waqar
 */
@RestController
public class OpportunityController {

    @Autowired
    OpportunityService ops;
    
    @RequestMapping("/opportunities")
    public List<Opportunity> getAll() throws URISyntaxException, ClientProtocolException, IOException{
    List<Opportunity> opportunities = ops.getAll();
    return opportunities;
    }

}
