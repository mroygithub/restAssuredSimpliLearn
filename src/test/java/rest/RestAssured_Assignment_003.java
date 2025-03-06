package rest;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class RestAssured_Assignment_003 {


    @Test
    public void RA_Assign_002() {


        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON).when().get("https://petstore.swagger.io/v2/user/Uname001")
                .then().assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("$", hasKey("id"))
                .body("$", hasKey("username"))
                .body("username", equalTo("Uname001"))
                .body("email", equalTo("Positive@Attitude.com"))
                .body("$", hasKey("userStatus"));
    }

}
