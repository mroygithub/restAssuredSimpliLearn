package soap;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.path.xml.config.XmlPathConfig.xmlPathConfig;
import reusable.Reusable;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.xml.HasXPath.hasXPath;


public class SoapTestScenario1 {

   // SoapTestScenario1 obj = new SoapTestScenario1();
   public static Reusable reOBJ ;

   @BeforeClass
   public void testdatasetup(){

       reOBJ = new Reusable();
   }


    @Test
    public void CelsiusToFahrenheitResponse(){

        String testdata = reOBJ.readPropertiesFile("CelsiusToFahrenheitResponse_testData");

        if(testdata.contains(",")){

            String[] splitdata = testdata.split(",");
            for(int a=0;a<splitdata.length;a++){

                String[] againSplitWithColon = splitdata[a].split(":");
                CelsiusToFahrenheitResponse_implementation(againSplitWithColon[0],againSplitWithColon[1]);

            }
        }
        else {
            String[] splitdata = testdata.split(":");
            CelsiusToFahrenheitResponse_implementation(splitdata[0] , splitdata[1]);
        }


    }


    public void CelsiusToFahrenheitResponse_implementation(String Celsius , String Fahrenheit){


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


        System.out.println("The Status Code is==>"+response.getStatusCode());
        System.out.println("The Response Body is==>"+response.getBody().asString());

            XmlPath xml_path_obj = new XmlPath(response.getBody().asString()).using(xmlPathConfig().namespaceAware(false));

            String CelsiusToFahrenheitResult = xml_path_obj.getString("soap:Envelope.soap:Body.CelsiusToFahrenheitResponse.CelsiusToFahrenheitResult");

            System.out.println("The CelsiusToFahrenheitResult is==>"+CelsiusToFahrenheitResult);
        Assert.assertEquals(Fahrenheit,CelsiusToFahrenheitResult);
    }



    @Test
    public void doGetSoapCall(){

        get("https://chercher.tech/sample/api/books.xml")
                .then().assertThat()
                .body("bookstore.book[0].title",equalTo("The Nightingale"))
                .body("bookstore.book[0].price.hardcover",equalTo("570"))
                .body("bookstore.book[0].@category",equalTo("cooking"))
                .body("bookstore.book[0].title.@lang",equalTo("en"))
                .body("bookstore.book[1].@category",equalTo("children"));
    }


    @Test
    public void doGetSoapCall_1(){

        get("https://chercher.tech/sample/api/books.xml")
                .then().assertThat()
                .body("bookstore.book[0].title",equalTo( "The Nightingale")
                        ,"bookstore.book[0].price.hardcover",equalTo("570")
                        ,"bookstore.book[1].price",equalTo("29.99")
                        //.body("bookstore.book.title",containsString("Harry Potter"))
                        ,"bookstore.book[0].@category",equalTo("cooking")
                        ,"bookstore.book[0].title.@lang",equalTo("en")
                        ,"bookstore.book[1].@category",equalTo("children"));

    }

    @Test
    public void doGetSoapCall_2(){

        get("https://chercher.tech/sample/api/books.xml")
                .then().assertThat()
                .body(hasXPath("/bookstore/book[1]/title",containsString("The Nightingale")))
                .body(hasXPath("/bookstore/book[1]/@category",containsString("cooking")));

    }


    @Test
    public void validateWithContains_SOAP_1(){


        Response response =

                get("https://chercher.tech/sample/api/books.xml");

        String res = response.getBody().asString();

        if(res.contains("Harry Potter")){

            System.out.println("Yes , the expected text is available==>"+"Harry Potter");
        }
        else{
            System.out.println("No , the expected text is not available==>"+"Harry Potter");
        }


    }


    @Test
    public void validateWithContains_SOAP_2(){


        Response response =

                get("https://chercher.tech/sample/api/books.xml");

        String res = response.getBody().asString();

        XmlPath xml_path_obj = new XmlPath(res).using(xmlPathConfig().namespaceAware(false));

        // First get the count of node you want to test ...

        int xmlPathcount = xml_path_obj.get("bookstore.book.title.size()");
        System.out.println("Count is ==>"+xmlPathcount);

        for(int a=0;a<xmlPathcount;a++){

            String title = xml_path_obj.getString("bookstore.book["+a+"].title");

            if(title.equals("Harry Potter")){

                System.out.println("Yes , the expected text is available==>"+"Harry Potter");
                break;
            }


        }





    }

























}
