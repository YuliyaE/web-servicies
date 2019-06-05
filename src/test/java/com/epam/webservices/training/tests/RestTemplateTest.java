package com.epam.webservices.training.tests;

import com.epam.webservices.training.model.user.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestTemplateTest {

    @Test
    public void checkStatusCode() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User[]> response = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users", User[].class);
        int actStatusCode = response.getStatusCode().value();
        Assert.assertEquals(actStatusCode, 200);
    }

    @Test
    public void checkResponseHeader() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User[]> response = restTemplate.getForEntity("http://jsonplaceholder.typicode.com/users", User[].class);
        HttpHeaders headers = response.getHeaders();
        String actContentTypeValue = headers.getContentType().toString();
        Assert.assertEquals(actContentTypeValue, "application/json;charset=utf-8");
    }

    @Test()
    public void checkResponseBody() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User[]> response = restTemplate.getForEntity("http://jsonplaceholder.typicode.com/users", User[].class);
        User[] actPosts = response.getBody();
        Assert.assertEquals(actPosts.length, 10);
    }


}
