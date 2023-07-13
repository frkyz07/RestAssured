package files;

import files.body;
import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class DynamicTest {

    @Test(dataProvider = "BooksData")
    public void addBook(String phoneNumber, String address){

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        RestAssured.useRelaxedHTTPSValidation();


        String output = given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type","application/json")
                .body(body.addBookBody(phoneNumber, address))
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .header("Server", "Apache/2.4.41 (Ubuntu)")
                .body("scope", equalTo("APP"))
                .extract().response().asString();

        System.out.println(output);
    }
    @DataProvider(name="BooksData")
    public Object[][] getData(){

        return new Object[][] {{"0938210938","somewhere"},
                                {"23812031","sometimes"},
                                {"2312312441","someone"}};
    }

}
