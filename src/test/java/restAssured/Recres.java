package restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import reusable.Reusable;

public class Recres {


    public static Reusable reOBJ ;




    public static void main(String[] args)throws Exception{


        reOBJ = new Reusable();

        for(int i=2;i<=10;i++){

            recresprog1(i);

        }

    }

    public static void recresprog1(int i){

        RestAssured.baseURI=reOBJ.readPropertiesFile("recresURI")+String.valueOf(i);
        Response res = RestAssured.get();
        int ststua_Code = res.getStatusCode();
        System.out.println("After hitting Google URL , status code is :"+ ststua_Code);
        Assert.assertEquals(Integer.parseInt(reOBJ.readPropertiesFile("responseStatus")) , ststua_Code);
        String resBody = res.getBody().asString();
        System.out.println("After hitting Google URL , response looks like :"+ resBody);

    }




























}
