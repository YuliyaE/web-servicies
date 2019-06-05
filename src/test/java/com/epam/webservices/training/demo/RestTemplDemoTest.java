package com.epam.webservices.training.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.webservices.training.model.post.Post;

public class RestTemplDemoTest {

    @Test
    public void checkStatusCode() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Post[]> response = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users", Post[].class);
        int actStatusCode = response.getStatusCode().value();
        Assert.assertEquals(actStatusCode, 200);
    }

    @Test
    public void checkResponseHeader() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Post[]> response = restTemplate.getForEntity("http://jsonplaceholder.typicode.com/posts", Post[].class);
        HttpHeaders headers = response.getHeaders();
        String actContentTypeValue = headers.getContentType().toString();
        Assert.assertEquals(actContentTypeValue, "application/json;charset=utf-8");
    }

    @Test()
    public void checkResponseBody() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Post[]> response = restTemplate.getForEntity("http://jsonplaceholder.typicode.com/posts", Post[].class);
        Post[] actPosts = response.getBody();
        Assert.assertEquals(actPosts.length, 100);
    }


}
