package com.epam.webservices.training.github.tests;

import com.epam.webservices.training.model.user.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RestAssuredTest {

    @BeforeTest
    public void initTest() {
        RestAssured.baseURI = "https://github.com/";

    }

    @Test
    public void checkStatusCode() {
        //Response response = RestAssured.when().get().andReturn();
        Response response = RestAssured.when().post("/users").andReturn();
        System.out.println(response.getStatusLine());
        Assert.assertEquals(response.getStatusCode(), 404);
    }

    @Test
    public void checkResponseHeader() {
        Response response = RestAssured.when().post("/users").andReturn();
        String rpContentTypeHeader = response.getHeader("Content-type");
        System.out.println(rpContentTypeHeader);
        Assert.assertEquals(rpContentTypeHeader, "text/html; charset=utf-8");
    }

    @Ignore
    public void checkResponseBody() {
        Response response = RestAssured
                .when()
                .post("/users")
                .andReturn();

        ResponseBody<?> responseBody = response.getBody();
        User[] users = responseBody.as(User[].class);
        Assert.assertEquals(users.length, 10);
    }


}
