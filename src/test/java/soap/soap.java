package soap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import reusable.Reusable;
import jsonBody.testJsonbody;
import javax.xml.parsers.*;
import java.io.File;
import org.w3c.dom.Document;


public class soap {

    public static Reusable reOBJ ;
    public static testJsonbody postBody ;


    public static void main(String[] args) throws Exception{

        soap obj = new soap();

        obj.restAssuredGet1();


    }


    public  void restAssuredGet1()throws Exception{



        // Validate GET request...
        // /api/users?page=2
        // https://reqres.in/api/users?page=2
        RestAssured.baseURI="https://www.dataaccess.com/webservicesserver/NumberConversion.wso"; // To initiate the service...

        Response res = RestAssured.given()
                .contentType(ContentType.XML)
                .contentType("text/xml; charset=utf-8")
                .header("Accept" , "application/xml")
                .header("Content-Type" , "text/xml; charset=utf-8")

                .when().post(Body(200));

        System.out.println("Status Code is =="+ res.getStatusCode());
        System.out.println("Response String is =="+ res.getBody().asString());
    }



    public  String Body(int num){

        return

                "<xs:schema attributeFormDefault=\"unqualified\" elementFormDefault=\"qualified\" targetNamespace=\"http://www.dataaccess.com/webservicesserver/\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">\n" +
                        "  <xs:element name=\"500\">\n" +
                        "    <xs:complexType>\n" +
                        "      <xs:sequence>\n" +
                        "        <xs:element type=\"xs:short\" name=\"ubiNum\"/>\n" +
                        "      </xs:sequence>\n" +
                        "    </xs:complexType>\n" +
                        "  </xs:element>\n" +
                        "</xs:schema>";
    }



    public String parseXML() throws Exception{

        File fXmlFile = new File("/Users/mithunroy/IdeaProjects/comtestrestAssuredSL/data.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        return doc.toString();


    }










}