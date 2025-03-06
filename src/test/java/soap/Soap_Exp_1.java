package soap;

import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.path.xml.config.XmlPathConfig.xmlPathConfig;
import reusable.Reusable;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.xml.HasXPath.hasXPath;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;




public class Soap_Exp_1 {

    @Test
    public void doGetSoapCall(){

        String Celsius = "40";

        Response response = given()
                .contentType(ContentType.XML)
                .accept(ContentType.XML)
                .header("Content-Type" , "application/soap+xml; charset=utf-8")
                .body("<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                        "  <soap12:Body>\n" +
                        "    <CelsiusToFahrenheit xmlns=\"https://www.w3schools.com/xml/\">\n" +
                        "      <Celsius>"+Celsius+"</Celsius>\n" +
                        "    </CelsiusToFahrenheit>\n" +
                        "  </soap12:Body>\n" +
                        "</soap12:Envelope>")
                .when()
                .post("https://www.w3schools.com/xml/tempconvert.asmx");
        System.out.println(response.getBody().asString());
    }

    @Test
    public void doGetSoapCall1(){

        given()
                .relaxedHTTPSValidation().when()
                .get("https://chercher.tech/sample/api/books.xml")
                .then().assertThat()
                .body("bookstore.book[0].title",equalTo("The Nightingale"))
                .body("bookstore.book[0].price.hardcover",equalTo("570"))
                .body("bookstore.book[0].@category",equalTo("cooking"))
                .body("bookstore.book[0].title.@lang",equalTo("en"))
                .body("bookstore.book[1].@category",equalTo("children"));
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
}
