package restAssured;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.junit.Assert;
import reusable.Reusable;

public class GoogleTest {


    public static Reusable reOBJ ;




    public static void main(String[] args)throws Exception{


        reOBJ = new Reusable();
        validateGoogleURL();
        validateGoogleURL1();


    }


    public static void validateGoogleURL(){

        RestAssured.baseURI=reOBJ.readPropertiesFile("baseURI");
        Response res = RestAssured.get();
        int ststua_Code = res.getStatusCode();
        System.out.println("After hitting Google URL , status code is :"+ ststua_Code);
        Assert.assertEquals(Integer.parseInt(reOBJ.readPropertiesFile("responseStatus")) , ststua_Code);
        String resBody = res.getBody().asString();
        System.out.println("After hitting Google URL , response looks like :"+ resBody);

    }


    public static void validateGoogleURL1(){

        RestAssured.baseURI="https://www.google.com";
        RestAssured.given().when().get().then().statusCode(200);


    }


























}
