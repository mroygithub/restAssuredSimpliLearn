package hamcrest_scenarios;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Rest_hamcrest {


    @Test
    public void resres_test(){

            given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("page" , equalTo(2));

        }


    @Test
    public void resres_test_First_POST_Call(){

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("")
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("email" , equalTo("Your Email..."));

    }
}
