/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kalsym.app;

/**
 *
 * @author Muhammad Waqar
 */
public class HttpClientResponse {
    
    String access_token;
    
    HttpClientResponse(String token){
        this.access_token = token;
    }
    
}
