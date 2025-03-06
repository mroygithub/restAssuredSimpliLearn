package soap;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.path.xml.config.XmlPathConfig.xmlPathConfig;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.xml.HasXPath.hasXPath;
import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class soap_Exp {


    @Test
    public void validateWithContains_SOAP_2(){
        Response response= given()
                .relaxedHTTPSValidation().when().get("https://chercher.tech/sample/api/books.xml");
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
