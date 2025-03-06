package rest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import org.apache.commons.lang3.RandomStringUtils;
import static org.hamcrest.Matchers.*;
import org.apache.log4j.*;





public class REST_TEST_1 {

    static Logger log = Logger.getLogger(REST_TEST_1.class);


    @BeforeClass
    public void setup(){

        PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/main/resources/log4j.properties");



    }


    @Test
    public void doGetRESTCall(){

        get("https://reqres.in/api/users?page=2")
                .then().assertThat()
                .body("page",equalTo(2))
                .body("per_page",equalTo(6))
                .body("total",equalTo(12))
                .body("data.email[1]",equalTo("lindsay.ferguson@reqres.in"))
                .body("support.url",equalTo("https://reqres.in/#support-heading"))
                .body("data.id[0]",equalTo(7))
                .body("support" , hasKey("url"));

    }

    @Test
    public void doPOSTRESTCall(){


        String email = RandomStringUtils.randomAlphanumeric(10).toUpperCase()+"@Kmail.com";
        String mobile = RandomStringUtils.randomNumeric(10).toUpperCase();

        log.info("The Email is==>"+email);
        log.info("The mobile is==>"+mobile);




        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\",\n" +
                        "    \"email\": \""+email+"\",\n" +
                        "    \"mobile\": \""+mobile+"\"\n" +
                        "}")
                .when()
                .post("https://reqres.in/api/users")
                .then().assertThat()
                .body("email",equalTo(email))
                .body("mobile",equalTo(mobile))
                .body("$" , hasKey("createdAt"))
                .body("$" , hasKey("id"))
                .body("id",is(notNullValue()))
                .body("createdAt",is(notNullValue()));
    }


    @Test
    public void validateWithContains_SOAP_2(){


        Response response =

                get("https://reqres.in/api/users?page=2");

        String res = response.getBody().asString();
        System.out.println(res);


        // First get the count of node you want to test ...

        int jsonPathcount = response.getBody().jsonPath().getList("data.first_name").size();
        System.out.println("Count is ==>"+jsonPathcount);
        log.info("Count is ==>"+jsonPathcount);

        for(int a=0;a<jsonPathcount;a++){

            String title = response.getBody().jsonPath().getString("data.first_name["+a+"]");

            if(title.equals("George")){

                System.out.println("Yes , the expected text is available==>"+"George");
                log.info("Yes , the expected text is available==>"+"George");
                break;
            }
        }
    }

/*
    @Test
    public void authentication_REST_1(){

        Response response = given().header("Authorization" , "Bearer-4j3b43i49reyr98r832")
                .get("https://reqres.in/api/users?page=2");

    }


    @Test
    public void authentication_REST_2(){

        Response response =
                given()
                        .auth().basic("userName1","Password1")
                        .auth().basic("userName2","Password2")
                .post("https://reqres.in/api/users?page=2");

    }

    */



}
