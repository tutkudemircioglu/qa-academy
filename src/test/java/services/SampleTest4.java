package services;

import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest4 {


    @Test
    public void sample() {
        String baseUrl = "https://petstore.swagger.io/v2/store/inventory";
        RequestSpecification restAssuredReq = RestAssured.given()
                .header("Study","Test")
                .log()
                .all(true);
        Response response = restAssuredReq.get(baseUrl);
        attachment(restAssuredReq, baseUrl, response);
        Assert.assertEquals(response.getStatusCode(), 200);
    }


    public String attachment(RequestSpecification httpRequest, String baseUrl, Response response) {
        String html = "Url = " + baseUrl + "\n \n" +
                "Request Headers = " + ((RequestSpecificationImpl) httpRequest).getHeaders() + "\n \n" +
                "Request Body = " + ((RequestSpecificationImpl) httpRequest).getBody() + "\n \n" +
                "Response Body = " + response.getBody().asString();
        Allure.addAttachment("Request Detail", html);
        return html;
    }

}
