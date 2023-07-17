package specBuilder.pojo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class pojoExample {

        public static void main(String[] args){

            AddPlace a = new AddPlace();
            a.setAccuracy(50);
            a.setAddress("29, side layout, cohen 09");
            a.setLanguage("French-IN");
            a.setPhone("(+91) 983 893 3937");
            a.setName("Frontline house");
            a.setWebsite("http:/google.com");

            List<String> myList = new ArrayList<String>();
            myList.add("shoe park");
            myList.add("shop");

            a.setType(myList);

            Location l = new Location();
            l.setLat(-38.383494);
            l.setLng(33.427362);

            a.setLocation(l);

            // request builder build
            RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
                    addQueryParam("key","qaclick123")
                    .setContentType(ContentType.JSON).build();

            // response builder build
            ResponseSpecification resSpec = (ResponseSpecification) new ResponseSpecBuilder().
                    expectStatusCode(200).expectContentType(ContentType.JSON).build();

            // request builder used
            RequestSpecification response=given().spec(req)
                    .body(a);

            // response build used
                   String res = response.when().post("/maps/api/place/add/json")
                           .then().spec(resSpec).extract().response().asString();

            // print that
            System.out.println(res);
        }
}
