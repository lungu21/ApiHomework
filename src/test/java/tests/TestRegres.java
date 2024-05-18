package tests;

import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static Utilities.Steps.*;
import static io.restassured.RestAssured.*;

public class TestRegres {
    @BeforeSuite
    public void setUp(){
        baseURI = "https://reqres.in/api";
    }

    @Test
    public void testListUser(){
        String url = "/users?page=2";
        Response response = GET(url);
        isStatusCodeValid(response,200);

    }
  @Test
    public void getSingleUser(){
        String url =  "/users/2";
        Response response = GET(url);
      isStatusCodeValid(response,200);

    }
    @Test
    public void  restCreate(){
        String url = "/users";
        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        Response response = POST(body, url);
        isStatusCodeValid(response,201);

    }


}
