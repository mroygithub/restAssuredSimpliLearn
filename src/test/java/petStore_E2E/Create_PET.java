package petStore_E2E;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Create_PET {

    @Test
    public void Create_Pet_ID() {

        //String petid = "299";
        //String petname = "Horse";

        for(int i=300;i<399;i++) {

            String petid = String.valueOf(i);
            String petname = "ABCD"+"_"+String.valueOf(i);

            Response response = given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body("{\n" +
                            "  \"id\": " + petid + ",\n" +
                            "  \"category\": {\n" +
                            "    \"id\": 0,\n" +
                            "    \"name\": \"string\"\n" +
                            "  },\n" +
                            "  \"name\": \"" + petname + "\",\n" +
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
                    .when()
                    .post("https://petstore.swagger.io/v2/pet");

            String Response_id_From_POST_Call = response.getBody().jsonPath().getString("id");
            Assert.assertEquals(Response_id_From_POST_Call, petid);
            String name = response.getBody().jsonPath().getString("name");
            System.out.println(Response_id_From_POST_Call + name);
        }
    }
}
