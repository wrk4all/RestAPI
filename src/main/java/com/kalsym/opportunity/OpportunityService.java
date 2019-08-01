/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kalsym.opportunity;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muhammad Waqar
 */
@Service
public class OpportunityService {

    @Value("${access_token}")
    private String access_token;

    @Value("${instance_url}")
    private String instance_url;

    private String serviceUrl = "/services/data/v39.0/query/";

    public List<Opportunity> getAll() throws URISyntaxException, ClientProtocolException, IOException {

        List<Opportunity> opportunities = new ArrayList<>();
        HttpClient httpclient = HttpClientBuilder.create().build();

        URIBuilder builder = new URIBuilder(instance_url);
        builder.setPath(serviceUrl).setParameter("q", "SELECT Id,Name FROM Opportunity");

        HttpGet httpGet = new HttpGet(builder.build());
        httpGet.addHeader("Authorization", "Bearer " + access_token);

        HttpResponse queryResponse = httpclient.execute(httpGet);

        int statusCode = queryResponse.getStatusLine().getStatusCode();
        if (statusCode != HttpStatus.SC_OK) {
            System.out.println("Error authenticating to Force.com: " + statusCode);

        } else {

            String response = EntityUtils.toString(queryResponse.getEntity());
            JSONObject json = new JSONObject(response);

            JSONArray j = json.getJSONArray("records");
            for (int i = 0; i < j.length(); i++) {
                Opportunity opp = new Opportunity();
                opp.setId(json.getJSONArray("records").getJSONObject(i).getString("Id"));
                opp.setName(json.getJSONArray("records").getJSONObject(i).getString("Name"));
                opportunities.add(opp);
            }
        }
        return opportunities;

    }

}
