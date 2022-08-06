package restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import reusable.Reusable;

public class Recres_post {


    public static Reusable reOBJ ;

    public static String my_request_body = "{\n" +
            "    \"name\": \"MITHUN\",\n" +
            "    \"job\": \"Trainer\"\n" +
            "}";




    public static void main(String[] args)throws Exception{

        reOBJ = new Reusable();
        users_post_call();
    }

    public static void users_post_call(){

        RestAssured.baseURI=reOBJ.readPropertiesFile("recresURI");
        Response res = RestAssured.given().contentType(ContentType.JSON).body(my_request_body).post();
        int ststua_Code = res.getStatusCode();
        System.out.println("After hitting Google URL , status code is :"+ ststua_Code);
        Assert.assertEquals(Integer.parseInt(reOBJ.readPropertiesFile("resstatus_201")) , ststua_Code);
        String resBody = res.getBody().asString();
        System.out.println("After hitting Google URL , response looks like :"+ resBody);

    }




























}