package hamcrest_scenarios;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Soap_hamcrest {



    // Validate First Book Name is  - The Nightingale
    // hardcover Book price is  - 570
    // First book category="cooking"
    // Second book category="Children"....

    // How to validate these SOAP response using hamcrest

    @Test
    public void validate_Book_Soap_APIs_Response(){

        given()
                .relaxedHTTPSValidation().when()
                .get("https://chercher.tech/sample/api/books.xml")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("bookstore.book[0].title" , equalTo("The Nightingale"))
                .body("bookstore.book[0].price.hardcover" , equalTo("570"))
                .body("bookstore.book[0].@category" , equalTo("cooking"))
                .body("bookstore.book[1].@category" , equalTo("children"))
                .body("bookstore.book[0].title.@lang" , equalTo("en"));
    }




}
