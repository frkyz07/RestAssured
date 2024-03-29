package files;

public class body {


    public static String addBody(){

        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}\n";
    }
    public static String complexJsonPath(){

        return "{\n" +
                "    \"dashboard\": {\n" +
                "\t\"purchaseAmount\":910,\n" +
                "\t\"website\":\"rahulshettyacademy.com\"\n" +
                "    },\n" +
                "    \"courses\": [\n" +
                "\t{\n" +
                "\t    \"title\":\"Selenium Python\",\n" +
                "\t    \"price\":50,\n" +
                "\t    \"copies\":6\n" +
                "\t},\n" +
                "\t{\n" +
                "\t    \"title\":\"Cypress\",\n" +
                "\t    \"price\":40,\n" +
                "\t    \"copies\":4\n" +
                "\t},\n" +
                "\t{\n" +
                "\t    \"title\":\"RPA\",\n" +
                "\t    \"price\":45,\n" +
                "\t    \"copies\":10\n" +
                "\t}\n" +
                "    ]\n" +
                "}";
    }
    public static String addBookBody(String phoneNumber, String address){

        String payload =
                "{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Frontline house\",\n" +
                        "  \"phone_number\": \""+phoneNumber+"\",\n" +
                        "  \"address\": \""+address+"\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://google.com\",\n" +
                        "  \"language\": \"French-IN\"\n" +
                        "}\n" +
                        "";
        return payload;
    }
}
