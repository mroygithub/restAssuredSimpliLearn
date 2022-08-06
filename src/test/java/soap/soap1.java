package soap;


import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.xml.HasXPath.hasXPath;






public class soap1 {

    public static String a = "400";


    //@Test
    public void post_xml_test() {
        Response response = given().contentType(ContentType.XML).accept(ContentType.XML).body("<Employee>" +

                "<empName>Lavanya Gowda</empName>" + "<empAddress>abc</empAddress>"
                + "<mobileNumber>1592211560</mobileNumber>" + "<department>abc</department>" + "<project>abc</project>"
                + "<teamLead>abc</teamLead>" + "<salary>10000</salary>" + "<joiningDate>11-10-19</joiningDate>"
                + "</Employee>").when().post("http://192.168.1.207:8080/api/employee/add/xml");
        System.out.println("POST Response\n" + response.asString());
        // tests
        int statusCode = response.getStatusCode();

        System.out.println("Status code is:" + statusCode);
        Assert.assertEquals(200, statusCode);

    }


    @Test
    public void get_Soap() {



        get("http://soapclient.com/xml/SQLDataSoap.WSDL").then().assertThat().
                body(hasXPath("/definitions/binding/operation[2]/@name", containsString("ProcessSRL2")));

    }



   // @Test
    void sampleTest() {

        get("https://chercher.tech/sample/api/books.xml").then().assertThat().
                body(hasXPath("/bookstore/book[2]/title", containsString("Harry Potter")));
        get("https://chercher.tech/sample/api/books.xml").then().assertThat().
                body(hasXPath("/bookstore/book/title", containsString("The Nightingale")));
    }



    //@Test
    public void get_Soap1() {
        Response response = given().contentType(ContentType.XML).accept(ContentType.XML).when().get("http://www.thomas-bayer.com/axis2/services/BLZService?wsdl");
        System.out.println("POST Response\n" + response.asString());
        // tests
        int statusCode = response.getStatusCode();

        System.out.println("Status code is:" + statusCode);
        Assert.assertEquals(200, statusCode);

    }


    //@Test
    public void SOAP_POST_1() {
        Response response =
                given()
                        .contentType(ContentType.XML)
                        .accept(ContentType.XML)
                        .header("Content-Type","application/soap+xml; charset=utf-8")
                        .body("<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                                "  <soap12:Body>\n" +
                                "    <CelsiusToFahrenheit xmlns=\"https://www.w3schools.com/xml/\">\n" +
                                "      <Celsius>20</Celsius>\n" +
                                "    </CelsiusToFahrenheit>\n" +
                                "  </soap12:Body>\n" +
                                "</soap12:Envelope>").when().post("https://www.w3schools.com/xml/tempconvert.asmx");
        System.out.println("POST Response\n" + response.asString());
        // tests
        int statusCode = response.getStatusCode();

        System.out.println("Status code is:" + statusCode);
        Assert.assertEquals(200, statusCode);

    }


    //@Test
    public void SOAP_POST_2() {
        Response response =
                given()
                        .contentType(ContentType.XML)
                        .accept(ContentType.XML)
                        .header("Content-Type","text/xml; charset=utf-8")
                        .body("<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                                "  <soap:Body>\n" +
                                "    <NumberToWords xmlns=\"http://www.dataaccess.com/webservicesserver/\">\n" +
                                "      <ubiNum>"+a+"</ubiNum>\n" +
                                "    </NumberToWords>\n" +
                                "  </soap:Body>\n" +
                                "</soap:Envelope>").when().post("https://www.dataaccess.com/webservicesserver/NumberConversion.wso");
        System.out.println("POST Response\n" + response.asString());
        // tests
        int statusCode = response.getStatusCode();

        System.out.println("Status code is:" + statusCode);
        Assert.assertEquals(200, statusCode);

    }

}

