package rest;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestAssured_Assignment_006 {


    @Test
    public void RA_Assign_006() {


        // This is When Status = available ;

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get("https://petstore.swagger.io/v2/user/logout")
                .then().assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("message", equalTo("ok"));
    }

}
