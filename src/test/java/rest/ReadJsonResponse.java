package rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReadJsonResponse {



    @Test
    public void E2E_Testing() {


        Response response = given()
                .when()
                .get("https://api.restful-api.dev/objects");

        String Response_id_From_POST_Call = response.getBody().jsonPath().getString("name[0]");
        System.out.println(Response_id_From_POST_Call + Response_id_From_POST_Call);
    }

    @Test
    public void E2E_Testing1() {
        Response response = given()
                .when()
                .get("https://reqres.in/api/users?page=2");
        String page = response.getBody().jsonPath().getString("page");
        System.out.println("Page number is ==>"+page);
        int totalEmail = response.getBody().jsonPath().getList("data.email").size();
        System.out.println("totalEmail Count is ==>"+totalEmail);
        for(int a=0;a<totalEmail;a++){
            String emailid = response.getBody().jsonPath().getString("data.email["+a+"]");
            System.out.printf("Email ID is ===>"+emailid);
        }
    }


}
