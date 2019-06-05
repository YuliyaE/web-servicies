package com.epam.webservices.training.tests;

import com.epam.webservices.training.model.user.Company;
import com.epam.webservices.training.model.user.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class RestAssuredTest {

    @BeforeTest
    public void initTest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

    }

    @Test
    public void checkStatusCode() {
        Response response = RestAssured
                .when()
                .get("/users")
                .andReturn();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void checkResponseHeader() {
        Response response = RestAssured.when().get("/users").andReturn();
        String rpContentTypeHeader = response.getHeader("Content-type");
        System.out.println(rpContentTypeHeader);
        Assert.assertEquals(rpContentTypeHeader, "application/json; charset=utf-8");
    }

    @Test
    public void checkResponseBody() {
        Response response = RestAssured
                .when()
                .get("/users")
                .andReturn();
        ResponseBody<?> responseBody = response.getBody();
        User[] users = responseBody.as(User[].class);
        Assert.assertEquals(users.length, 10);
    }


    @Test
    public void parseToGson() {
        Response response = RestAssured
                .when()
                .get("/users")
                .andReturn();
        ResponseBody<?> responseBody = response.getBody();
        User[] users = responseBody.as(User[].class);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        for(int i = 0; i < users.length; i++) {
            System.out.println(gson.toJson(users[i]));
        }
        Assert.assertEquals(users.length, 10);
    }

    public static void main(String[] args) {
       }

}
