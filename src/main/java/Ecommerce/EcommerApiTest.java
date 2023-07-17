package Ecommerce;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class EcommerApiTest {


    public static void main(String[] args){

        RequestSpecification req =  new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/")
                .setContentType(ContentType.JSON).build();

        Login login = new Login();

        login.setUserEmail("frkyz07@gmail.com");
        login.setUserPassword("Faruk.1313");

        RequestSpecification reqLogin = given().log().all().spec(req).body(login);

       LoginResponse loginResponse = reqLogin.when().post("api/ecom/auth/login").
                then().extract().response().as(LoginResponse.class);

        System.out.println("This your token: "+loginResponse.getToken());
        System.out.println("This is your userId: "+loginResponse.getUserId());
    }
}
