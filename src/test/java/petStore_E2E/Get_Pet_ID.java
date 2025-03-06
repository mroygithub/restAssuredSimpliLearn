package petStore_E2E;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class Get_Pet_ID {



    @Test
    public void Validate_Pet_ID() {

        String petid = "506";
        String petname = "Elephant";

        String url = "https://petstore.swagger.io/v2/pet/"+petid;

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON).when().get(url)
                .then().assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("$" , hasKey("status"))
                .body("$" , hasKey("id"))
                .body("id",equalTo(Integer.parseInt(petid)))
                .body("name",equalTo(petname))
                .body("status",equalTo("available"));
    }
}
