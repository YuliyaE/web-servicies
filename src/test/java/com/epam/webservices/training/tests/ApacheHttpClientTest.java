package com.epam.webservices.training.tests;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClients;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ApacheHttpClientTest {

    @Test
    public void checkStatusCodeTest() throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://jsonplaceholder.typicode.com/users");
        HttpResponse response = client.execute(request);
        System.out.println(response.getStatusLine().getStatusCode());
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test
    public void checkResponseContentTest() throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpUriRequest request = new HttpGet("https://jsonplaceholder.typicode.com/users");
        HttpResponse response = client.execute(request);
        System.out.println(response.getEntity().getContent());
        Assert.assertEquals(response.getFirstHeader("Content-type").toString(), "Content-Type: application/json; charset=utf-8");

    }

}
