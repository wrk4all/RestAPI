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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpClientExample {

    private final String USER_AGENT = "Mozilla/5.0";
    HttpClientResponse hcr;

    // HTTP GET request
    public void sendGet() throws Exception {

        String url = "https://meer-dev-ed.my.salesforce.com/services/wsdl/metadata";

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);

        // add request header
        request.addHeader("Content-Type", "application/x-www-form-urlencoded");
        String bearerToken = "Bearer 00D28000000eBAi!AREAQIrwGTkGC8ZtDGQ1ctlhb_.h1tfmPb8_szIh_jO.gHt0kI03Jna.Ff58ZsBf2yjpk9vvPBLVEC8g69s5qhLZ9I82ehnt"; // + hcr.access_token;
        request.addHeader("Authorization", bearerToken);

        HttpResponse response = client.execute(request);

        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        System.out.println("Sales Force API Opportunities : " + result.toString());

    }

    // HTTP POST request
    public void sendPost() throws Exception {

        String url = "https://meer-dev-ed.my.salesforce.com/services/wsdl/metadata";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);
        post.setHeader("Authorization", "Bearer 00D28000000eBAi!AREAQIrwGTkGC8ZtDGQ1ctlhb_.h1tfmPb8_szIh_jO.gHt0kI03Jna.Ff58ZsBf2yjpk9vvPBLVEC8g69s5qhLZ9I82ehnt");

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
//        urlParameters.add(new BasicNameValuePair("grant_type", "password"));
//        urlParameters.add(new BasicNameValuePair("client_id", "3MVG9pe2TCoA1Pf5bsJXvpPGh5dvgViToCMClu3gAFKmJ3mozwz9GZoptuEJmaSYiWTtg1sC.FT5_ofb.rujS"));
//        urlParameters.add(new BasicNameValuePair("client_secret", "940471E54B538E3B33D3CE8D71C0D43494F8AB9F500F86A334011A0C10A869FE"));
//        urlParameters.add(new BasicNameValuePair("username", "waqar@vds.com"));
//        urlParameters.add(new BasicNameValuePair("password", "hamaraynabi9saww0"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + post.getEntity());
        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        String newStr = result.toString();
        String[] token;// = new String[];
        String[] finalToken;// = new String[];
        token = newStr.split(",");
        System.out.println(token[0]);
        finalToken = token[0].split(":");
        String accessToken = finalToken[1].substring(1, finalToken[1].length() - 1);
        hcr = new HttpClientResponse(accessToken);
        System.out.println("final result :" + result.toString());

    }

}
