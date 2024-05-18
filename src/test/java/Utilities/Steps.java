package Utilities;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

public class Steps {
 @Step
    public static Response GET(String endpoint) {
        Allure.addAttachment("URL: ", baseURI + endpoint);
        Response response = get(endpoint);
        Allure.addAttachment("Response body ", response.body().prettyPrint());
        Allure.addAttachment("Status code", String.valueOf(response.statusCode()));
        return response;

    }
    @Step
    public static void isStatusCodeValid (Response response, int expectedStatusCode){
        response.then().assertThat().statusCode(expectedStatusCode);
    }
    @Step
    public static Response POST(String body, String endpoint){
        Allure.addAttachment("URL: ", baseURI + endpoint);
       Response response =  given().body(body).post(endpoint);
        Allure.addAttachment("Response body ", response.body().prettyPrint());
        Allure.addAttachment("Status code", String.valueOf(response.statusCode()));
       return response;
    }

}

