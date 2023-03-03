package org.example;

import files.body;
import io.restassured.path.json.JsonPath;

public class ComplexJsonPath {

    public static void main(String[] args) {

        JsonPath js = new JsonPath(body.complexJsonPath());

        // Print number of courses returned by API

        int count = js.getInt("courses.size()");
        System.out.println(count);

        // Print the purchase Amount

        int purchaseAmounth = js.getInt("dashboard.purchaseAmount");
        System.out.println(purchaseAmounth);

        // Print title of the first course

        String title = js.get("courses[0].title");
        System.out.println(title);
    }
}
