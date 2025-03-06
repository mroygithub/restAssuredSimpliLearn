package rest;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.StringReader;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.path.xml.config.XmlPathConfig.xmlPathConfig;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class HomeWork {


    @Test
    @Parameters({"url"})
    public void auth_validation(String url){

        System.out.println("##################################"+System.getenv("name"));

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


    @Test
    public void XML_Iterations(){

        Response res = get("http://restapi.adequateshop.com/api/Traveler?page=6");
        String resp = res.getBody().asString();
        XmlPath XP_obj = new XmlPath(resp).using(xmlPathConfig().namespaceAware(false));
        int xmlpath_Count = XP_obj.get("TravelerinformationResponse.travelers.Travelerinformation.id.size()");

        for(int i=1 ; i<xmlpath_Count;i++){

            String id = XP_obj.getString("TravelerinformationResponse.travelers.Travelerinformation["+i+"].id");
            String name = XP_obj.getString("TravelerinformationResponse.travelers.Travelerinformation["+i+"].name");
            String email = XP_obj.getString("TravelerinformationResponse.travelers.Travelerinformation["+i+"].email");
            String Address = XP_obj.getString("TravelerinformationResponse.travelers.Travelerinformation["+i+"].adderes");
            System.out.println(id+":"+name+":"+email+":"+Address);

        }
    }



    @Test
    public void E2E_Rest_Scenario(){

            for(int i = 300;i<305;i++){
                String petname = "Testing"+ String.valueOf(i);
                generatePetID(petname,i); // Here I am creating Pet ID
                validatePetID(i); // Here I am validating PET ID
                deletePetID(i); // Here I am deleting PET ID
            }
    }

    public void generatePetID(String petName , int petId){


        Response res = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\n" +
                        "  \"id\":"+petId+",\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \""+petName+"\",\n" +
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
                        "}\n")
                .when()
                .post("https://petstore.swagger.io/v2/pet");

    }

    public void validatePetID(int petId){


        String url = "https://petstore.swagger.io/v2/pet/"+petId;

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON).when().get(url)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    public void deletePetID(int petId){


        String url = "https://petstore.swagger.io/v2/pet/"+petId;

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON).when().delete(url)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    // Print all digits from 1-100 which can be devided by 7







}
