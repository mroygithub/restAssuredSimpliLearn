package restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import reusable.Reusable;
import jsonBody.testJsonbody;

public class createPetID {


    public static Reusable reOBJ ;
    public static testJsonbody postBody ;




    public static void main(String[] args)throws Exception{

        reOBJ = new Reusable();
        postBody = new testJsonbody();
        for(int i = 1 ; i<=100;i++) {
            users_post_call_pet(i);
        }
    }

    public static void users_post_call_pet(int pet_id){

        RestAssured.baseURI=reOBJ.readPropertiesFile("perbaseURI");
        Response res = RestAssured.given().contentType(ContentType.JSON).body(postBody.createPetIdBody(pet_id)).post();
        int ststua_Code = res.getStatusCode();
        System.out.println("After hitting Google URL , status code is :"+ ststua_Code);
        Assert.assertEquals(Integer.parseInt(reOBJ.readPropertiesFile("responseStatus")) , ststua_Code);
        String resBody = res.getBody().asString();
        System.out.println("After hitting Google URL , response looks like :"+ resBody);

    }




























}
