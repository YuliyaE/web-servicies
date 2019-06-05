package com.epam.webservices.training.demo;

import com.epam.webservices.training.model.user.User;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.epam.webservices.training.model.post.Post;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class RestAssuredDemoTest {

    @BeforeTest
    public void initTest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void checkStatusCode() {
        Response response = RestAssured.when()
                .get("/posts")
                .andReturn();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void checkResponseHeader() {
        Response response = RestAssured.when()
                .get("/posts")
                .andReturn();
        String rpContentTypeHeader = response.getHeader("Content-Type");
        Assert.assertEquals(rpContentTypeHeader, "application/json; charset=utf-8");
    }

    @Test
    public void checkResponseBody() {
        Response response = RestAssured.when()
                .get("/posts")
                .andReturn();
        ResponseBody<?> responseBody = response.getBody();
        Post[] posts = responseBody.as(Post[].class);
        Assert.assertEquals(posts.length, 100);

    }

}
