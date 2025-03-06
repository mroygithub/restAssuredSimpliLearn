package restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Json_Schema {

    public static void main(String[] args) {

        RestAssured.baseURI="http://json-schema.org/draft-07/schema#";
        Response res = RestAssured.get();
        int ststua_Code = res.getStatusCode();
        System.out.println("After hitting Google URL , status code is :"+ ststua_Code);
        String resBody = res.getBody().asString();
        //System.out.println(resBody);
       // int jsonPathcount = res.getBody().jsonPath().getList("definitions.nonNegativeIntegerDefault0.allOf[0].$ref").size();
       // System.out.println("Size is ===>"+jsonPathcount);
        String title = res.getBody().jsonPath().getString("definitions.nonNegativeIntegerDefault0.allOf[0].$ref");
        System.out.println("*****************"+title);



    }
}
