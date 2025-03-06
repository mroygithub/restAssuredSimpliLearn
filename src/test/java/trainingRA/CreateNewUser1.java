package trainingRA;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import reusable.RecresJsonBody;

import static io.restassured.RestAssured.given;

public class CreateNewUser1 {

    RecresJsonBody RJB;

    @BeforeClass
    public void setUp(){

        RJB = new RecresJsonBody();

    }

    @Parameters({"usercreationURL","ssnNo","userName"})
    @Test(groups = {"smoke","regression"},priority = 5)
    public void create_A_new_User(String usercreationURL,String ssnNo , String userName){

        Response res = given()
                .contentType(ContentType.JSON)
                .body(RJB.CreateUserJsonBody(userName,ssnNo))
                .when()
                .post(usercreationURL);

        int status_code = res.getStatusCode();
        String response_body = res.getBody().asString();
        System.out.println(status_code);
        System.out.println(response_body);

        String user_id = res.getBody().jsonPath().getString("id");
        System.out.println("The user ID ==>"+user_id);
    }

    @Parameters({"url"})
    @Test(groups = {"smoke"},priority = 0)
    public void test_the_AnotherOne(String url){

        System.out.println(url);
    }

    @Test(groups = {"regression"}, priority = 0)
    public void test_the_AnotherOne100(){

        System.out.println("This is TEST 100");
    }

    @Test(groups = {"e2e"},priority = 1)
    public void test_the_AnotherOne101(){

        System.out.println("This is TEST 101");
    }

    @AfterClass
    public void tearDown(){



    }





}
