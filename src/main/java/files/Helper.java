package files;

import io.restassured.path.json.JsonPath;

public class Helper {

    public static JsonPath responseToJson(String response){

        JsonPath js = new JsonPath(response);
        return js;


    }
}
