package rest;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.path.xml.config.XmlPathConfig.xmlPathConfig;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;
import org.apache.http.HttpStatus;

public class task {





    @Test
    public void authentication_Json(){

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .auth().basic("user","passwd")
                .when()
                .get("https://httpbin.org/basic-auth/user/passwd")
                .then().assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("$" , hasKey("authenticated"))
                .body("$" , hasKey("user"))
                .body("authenticated",equalTo(true))
                .body("user",equalTo("user"));
    }


    @Test
    public void Authentication_HTML(){



        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .auth().basic("tomsmith","SuperSecretPassword!")
                .when()
                .get("https://the-internet.herokuapp.com/login")
                .then().assertThat()
                .statusCode(HttpStatus.SC_OK);

    }


    @Test
    public void E2E_Testing(){

    String petid = "2003";
    String petname = "petname";

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": "+petid+",\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \""+petname+"\",\n" +
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
        Assert.assertEquals(Response_id_From_POST_Call ,petid );
        String name = response.getBody().jsonPath().getString("name");
        System.out.println(Response_id_From_POST_Call+name);

        String url = "https://petstore.swagger.io/v2/pet/"+Response_id_From_POST_Call;



        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON).when().get(url)
                .then().assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("$" , hasKey("status"))
                .body("$" , hasKey("id"))
                .body("id",equalTo(Integer.parseInt(Response_id_From_POST_Call)))
                .body("name",equalTo(name))
                .body("status",equalTo("available"));


        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON).when().delete(url)
                .then().assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("$" , hasKey("code"))
                .body("$" , hasKey("message"))
                .body("message",equalTo(String.valueOf(Response_id_From_POST_Call)))
                .body("code",equalTo(200));

    }

    @Test
    public void XML_iterations(){


        Response response =

                get("http://restapi.adequateshop.com/api/Traveler?page=6");

        String res = response.getBody().asString();

        XmlPath xml_path_obj = new XmlPath(res).using(xmlPathConfig().namespaceAware(false));

        // First get the count of node you want to test ...

        int xmlPathcount = xml_path_obj.get("TravelerinformationResponse.travelers.Travelerinformation.name.size()");
        System.out.println("Count is ==>"+xmlPathcount);

        for(int a=0;a<xmlPathcount;a++){

            String title = xml_path_obj.getString("TravelerinformationResponse.travelers.Travelerinformation["+a+"].name");

            if(title.equals("mohammad arif")){

                System.out.println("Yes , the expected name text is available==>"+"Hmohammad arif");
                break;
            }


        }





    }

}
