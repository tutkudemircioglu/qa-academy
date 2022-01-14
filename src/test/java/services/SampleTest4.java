package services;

import io.restassured.RestAssured;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class SampleTest4 {


    @Test
    public void sample() {
        String baseUrl = "https://petstore.swagger.io/v2/store/inventory";
        RequestSpecification restAssuredReq = RestAssured.given()
                .log()
                .all(true);
        Response response = restAssuredReq.get(baseUrl);
        attachment(restAssuredReq,baseUrl,response);
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

    public String attachment(RequestSpecification httpRequest, String path, Response response) {
        String html = "Url = " + ((RequestSpecificationImpl) httpRequest).getBaseUri() + path + "\n \n" + "Request Headers = " + ((RequestSpecificationImpl) httpRequest).getHeaders() + "\n \n" + "Request Body = " + ((RequestSpecificationImpl) httpRequest).getBody() + "\n \n" + "Response Body = " + response.getBody().asString();
        return html;
    }

}
