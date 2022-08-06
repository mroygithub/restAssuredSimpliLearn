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












}