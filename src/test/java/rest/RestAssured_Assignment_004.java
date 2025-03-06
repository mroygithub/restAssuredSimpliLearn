package rest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;

public class RestAssured_Assignment_004 {


    @Test
    public void RA_Assign_004() {


   given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .auth().basic("uname001","@ttitude")
                .when()
                .get("https://petstore.swagger.io/v2/user/login")
                .then().assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("$" , hasKey("message"));


        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .auth().basic("uname001","@ttitude")
                .when()
                .get("https://petstore.swagger.io/v2/user/login");

        Assert.assertTrue(response.getBody().asString().contains("logged in user session:"));
    }

}
