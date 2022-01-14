package services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class SampleTest4 {


    @Test
    public void sample() {
        Response response = RestAssured.get("https://petstore.swagger.io/v2/store/inventory");

        System.out.println("getBody: " + response.asString());
        System.out.println("getBody: " + response.getBody().asString());
        System.out.println("getStatusCode: " + response.getStatusCode());
        System.out.println("getContent-Type: " + response.getHeader("Content-Type"));
        System.out.println("getHeaders: " + response.getHeaders());
        System.out.println("getTime: " + response.getTime());

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void getInventory() {
        given()
                .log().all().
                when()
                .get("https://petstore.swagger.io/v2/store/inventory").
                then()
                .statusCode(200)
                .time(lessThan(2000L))
                .log().all();
    }

}
