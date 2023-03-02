package org.example;

import files.body;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Main {

    static String response;

    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        // ADD THE NEW DATA

        response = given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(body.addBody())
                .when()
                .post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();

        System.out.println(response);
        JsonPath js = new JsonPath(response);

        String placeId = js.getString("place_id");
        System.out.println(placeId);

        // UPDATE THE NEW DATA

        String newAdress = "42 ard righ road";
        given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\"place_id\":\"" + placeId + "\",\n" +
                        "\"address\":\"" + newAdress + "\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}")
                .when()
                .put("/maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));

        // VERIFY THE NEW UPDATED DATA

        String verifiableResponse = given().log().all().queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .header("Content-Type", "application/json")
                .when()
                .get("/maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();


        String actualAddress = String.valueOf(files.Helper.responseToJson(verifiableResponse));
        Assert.assertEquals(actualAddress,newAdress);


    }
}