package soap;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.xml.HasXPath.hasXPath;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.path.xml.XmlPath;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.path.xml.config.XmlPathConfig.xmlPathConfig;


public class soap2 {

    public static String a = "400";


    @Test
    public void givenUrl_whenMultipleXmlValuesTestEqual_thenCorrect() {
        get("https://chercher.tech/sample/api/books.xml").then().assertThat()
                .body("bookstore.book[0].title", equalTo("The Nightingale"))
                .body("bookstore.book[0].author", equalTo("Hannah"))
                .body("bookstore.book.price.paperback", equalTo("200"))
                .body("bookstore.book[1].title", equalTo("Harry Potter"));
    }


    @Test
    public void givenUrl_whenMultipleXmlValuesTestEqualInShortHand_thenCorrect() {
        get("https://chercher.tech/sample/api/books.xml")
                .then().assertThat().body("bookstore.book[0].title",
                equalTo("The Nightingale"),"bookstore.book[0].author",
                equalTo("Hannah"), "bookstore.book.price.paperback",
                equalTo("200"),"bookstore.book[1].title",
                equalTo("Harry Potter"));
    }

    @Test
    public void givenUrl_passedwhenValidatesXmlUsingXpath_thenCorrect() {
        get("https://chercher.tech/sample/api/books.xml").then().assertThat()
                .body(hasXPath("/bookstore/book[1]/title", containsString("The Nightingale")))
                .body(hasXPath("/bookstore/book[1]/@category", containsString("cooking")))
                .body(hasXPath("/bookstore/book[1]/@test", containsString("passed")))
                .body(hasXPath("/bookstore/book[1]/title/@lang", containsString("en")));
    }


    @Test
    public void hello2() {


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

        // tests
        int statusCode = response.getStatusCode();

        System.out.println("Status code is:" + statusCode);
        System.out.println("Response is:" + response.body().asString());
        Assert.assertEquals(200, statusCode);

        XmlPath xmlPath = new XmlPath(response.body().asString()).using(xmlPathConfig().namespaceAware(false));
        String availableReplicas = xmlPath.getString("soap:Envelope.soap:Body.CelsiusToFahrenheitResponse.CelsiusToFahrenheitResult");
        System.out.println("Data is:" + availableReplicas);
    }



    @Test
    public void hello3() {


        Response response =
                given()
                        .contentType(ContentType.XML)
                        .accept(ContentType.XML)
                        .header("Content-Type","text/xml; charset=utf-8")
                        .body("<soap12:Envelope xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                                "  <soap12:Body>\n" +
                                "    <ListOfCountryNamesByName xmlns=\"http://www.oorsprong.org/websamples.countryinfo\">\n" +
                                "    </ListOfCountryNamesByName>\n" +
                                "  </soap12:Body>\n" +
                                "</soap12:Envelope>").when().post("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso");

        // tests
        int statusCode = response.getStatusCode();

        System.out.println("Status code is:" + statusCode);
        //System.out.println("Response is:" + response.body().asString());
        Assert.assertEquals(200, statusCode);



        XmlPath xmlPath = new XmlPath(response.body().asString()).using(xmlPathConfig().namespaceAware(false));
        String availableReplicas =
                xmlPath.getString("soap:Envelope.soap:Body.m:ListOfCountryNamesByNameResponse.m:ListOfCountryNamesByNameResult.m:tCountryCodeAndName[1].m:sISOCode");
        System.out.println("Data is:" + availableReplicas);
    }



    @Test
    public void hello4() {


        Response response =
                given()
                        .contentType(ContentType.XML)
                        .accept(ContentType.XML)
                        .when().get("http://soapclient.com/xml/SQLDataSoap.WSDL");

        // tests
        int statusCode = response.getStatusCode();

        System.out.println("Status code is:" + statusCode);
        //System.out.println("Response is:" + response.body().asString());
        Assert.assertEquals(200, statusCode);



        XmlPath xmlPath = new XmlPath(response.body().asString()).using(xmlPathConfig().namespaceAware(false));
        String availableReplicas =
                xmlPath.getString("definitions.message[0].part[0].@type");
        System.out.println("Data is:" + availableReplicas);
        assertThat(xmlPath.getString("definitions.message[0].part[0].@type"), equalTo("xsd:string"));

    }

    @Test
    public void hello5() {


        Response response =
                given()
                        .contentType(ContentType.XML)
                        .accept(ContentType.XML)
                        .when().get("http://soapclient.com/xml/SQLDataSoap.WSDL");

        // tests
        int statusCode = response.getStatusCode();

        System.out.println("Status code is:" + statusCode);
        //System.out.println("Response is:" + response.body().asString());
        Assert.assertEquals(200, statusCode);



        XmlPath xmlPath = new XmlPath(response.body().asString()).using(xmlPathConfig().namespaceAware(false));
        String availableReplicas =
                xmlPath.getString("definitions.message[0].part[0].@type");
        System.out.println("Data is:" + availableReplicas);
        assertThat(xmlPath.getString("definitions.@name"), equalTo("SQLDataSoap"));
        assertThat(xmlPath.getString("definitions.@'xmlns:xsd'"), equalTo("http://www.w3.org/2001/XMLSchema"));

    }









}

