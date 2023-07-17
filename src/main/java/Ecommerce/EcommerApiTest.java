package Ecommerce;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.given;

public class EcommerApiTest {


    public static void main(String[] args){


        // Login API Call
        RequestSpecification req =  new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/")
                .setContentType(ContentType.JSON).build();

        Login login = new Login();

        login.setUserEmail("frkyz07@gmail.com");
        login.setUserPassword("Faruk.1313");

        RequestSpecification reqLogin = given().log().all().spec(req).body(login);

       LoginResponse loginResponse = reqLogin.when().post("api/ecom/auth/login").
                then().extract().response().as(LoginResponse.class);

       String token = loginResponse.getToken();
       String userId = loginResponse.getUserId();
        System.out.println("This your token: "+token);
        System.out.println("This is your userId: "+userId);

        // Add Product API Call
        RequestSpecification addProductBaseReq =  new RequestSpecBuilder().
                setBaseUri("https://rahulshettyacademy.com/").addHeader("authorization",token).build();

        RequestSpecification addProductReq = given().log().all().spec(addProductBaseReq).param("productName","Laptop").
                param("userId",userId).param("productCategory","fashion").
                param("productSubCategory","shirts").
                param("productPrice","11500").
                param("productDescription","Addias Originals").
                param("productFor","women").
                multiPart("productImage",new File("/Users/farukayaz/Downloads/photo.jpeg"));

        String addProductResponse = addProductReq.when().post("api/ecom/product/add-product").
                then().log().all().extract().response().asString();

        JsonPath js = new JsonPath(addProductResponse);
        String productId = js.get("productId");
        System.out.println("this is added productId: "+productId);

        //Create Order API Call
        RequestSpecification createOrderBaseReq =  new RequestSpecBuilder().
                setBaseUri("https://rahulshettyacademy.com/").setContentType(ContentType.JSON).
                addHeader("authorization",token).build();

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setProductOrderedId(productId);
        orderDetails.setCountry("Ireland");

        List<OrderDetails> orderDetailsList = new ArrayList<OrderDetails>();
        orderDetailsList.add(orderDetails);

        Orders orders = new Orders();
        orders.setOrders(orderDetailsList);

        RequestSpecification createOrderReq = given().log().all().spec(createOrderBaseReq).body(orders);

        String responseAddOrder = createOrderReq.when().post("api/ecom/order/create-order").
                then().log().all().extract().response().asString();

        System.out.println(responseAddOrder);

        //Delete order API Call

        RequestSpecification deleteProdBaseReq =  new RequestSpecBuilder().
                setBaseUri("https://rahulshettyacademy.com/").setContentType(ContentType.JSON).
                addHeader("authorization",token).build();
        
        RequestSpecification deleteProdReq = given().log().all().spec(deleteProdBaseReq).
                pathParam("productId",productId);

        String deleteResponse = deleteProdReq.when().delete("api/ecom/product/delete-product/{productId}").
        then().log().all().extract().response().asString();

        JsonPath js1 = new JsonPath(deleteResponse);
        String deleteMessage = js1.get("message");
        System.out.println("Your message: "+deleteMessage);

    }
}
