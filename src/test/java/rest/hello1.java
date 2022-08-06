package rest;



import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.xml.HasXPath.hasXPath;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.path.xml.XmlPath;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.path.xml.config.XmlPathConfig.xmlPathConfig;



public class hello1 {



    @Test
    public void REST_Example_1() {


        given().contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 199,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"MITHUN\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when().post("https://petstore.swagger.io/v2/pet")
                .then().assertThat().body("id",
                equalTo(199),"category.name",
                equalTo("MITHUN"), "name",
                equalTo("doggie"),"status",
                equalTo("available"));


    }



    @Test
    public void REST_Example_2() {


        given().contentType(ContentType.JSON)
                .when().get("https://reqres.in/api/users?page=2")
                .then().assertThat()
                .body("page", equalTo(2))
                .body("data.email[0]", equalTo("michael.lawson@reqres.in"))
                .body("data.id[1]", equalTo(8))
                .body("support.url", equalTo("https://reqres.in/#support-heading"));


    }


    @Test
    public void whenLogResponse_thenOK() {
        given().contentType(ContentType.JSON)
                .when().get("https://reqres.in/api/users?page=2")
                .then().log().body().statusCode(200);
    }




}
