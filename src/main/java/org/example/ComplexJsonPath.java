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

        // Print title of all courses and their prices

        for(int i=0;i<count;i++){

            String courseTitle = js.get("courses["+i+"].title");
            System.out.println(courseTitle);
            Integer coursePrice = js.get("courses["+i+"].price");
            System.out.println(coursePrice);

        }

        // Print copy of RPA courses

        for(int i=0;i<count;i++){

            if(js.get("courses["+i+"].title").equals("RPA")){

                Integer rpaCopy = js.get("courses["+i+"].copies");
                System.out.println(rpaCopy);
                break;
            }
        }

        // Check price and copies mathches with purchase amount

        Integer totalAmounth = 0;
        for(int i=0;i<count;i++){

                Integer price = js.get("courses["+i+"].price");
                Integer copy = js.get("courses["+i+"].copies");
                totalAmounth = totalAmounth+(price*copy);

                }
        Integer purchaseAmount = js.getInt("dashboard.purchaseAmount");
        if(purchaseAmount==totalAmounth){
            System.out.println("Your purchase amount is correct it is: "+totalAmounth);
        }
        else{
            System.out.println("Your purchase amount is not correct it should be: "+purchaseAmount);
        }

        }



    }


