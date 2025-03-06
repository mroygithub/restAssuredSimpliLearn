package rest;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.path.xml.config.XmlPathConfig.xmlPathConfig;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class HomeWork1 {


    @Test
    @Parameters({"url"})
    public void auth_validation(String url){

        System.out.println("##################################"+System.getProperty("name"));
        System.out.println("##################################"+System.getProperty("AppUrlValue"));


        given()

                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .auth().basic("user" , "passwd")
                .when()
                .get(url)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("$" , hasKey("authenticated"))
                .body("$" , hasKey("user"))
                .body("authenticated" , equalTo(true))
                .body("user" , equalTo("user"));

    }
}
