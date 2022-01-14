package services;

import io.restassured.http.ContentType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;

public class Sample2Test {

    @BeforeClass
    public void postCreatePet(){
        String postData = "{\n" +
                "  \"id\": 5,\n" +
                "  \"category\": {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"dog\"\n" +
                "  },\n" +
                "  \"name\": \"doggtest\",\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\":1,\n" +
                "      \"name\": \"dogg\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        given()
                .body(postData)
                .contentType(ContentType.JSON)
                .log().all().
                when()
                .post("https://petstore.swagger.io/v2/pet").
                then()
                .statusCode(200)
                .log().all();

    }

    @Test
    public void getPetDetail() {
        int petId = 5;

        given()
                .log().all().
                when()
                .get("https://petstore.swagger.io/v2/pet/" + petId).
                then()
                .statusCode(200)
                .log().all();
    }

    @AfterClass
    public void deletePet(){
        given()
                .log().all()
                .header("api_key","special-key").
                when()
                .delete("https://petstore.swagger.io/v2/pet/5").
                then()
                .statusCode(200)
                .log().all();

    }


}
