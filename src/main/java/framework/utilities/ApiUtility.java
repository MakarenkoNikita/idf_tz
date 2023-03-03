package framework.utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.Map;
import java.util.Set;

import static structure.constant.StringConstant.*;

public class ApiUtility {

    private ApiUtility() {
        throw new InstantiationError("Should not instantiate static class");
    }

    private static RequestSpecification buildUri(Map<String, String> map) {
        Set<String> key = map.keySet();
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header(CONTENT_TYPE, APPLICATION_JSON);
        JSONObject object = new JSONObject();
        for (String value : key) {
            object.put(value, map.get(value));
        }
        requestSpecification.body(object.toString());
        return requestSpecification;
    }

    public static Response requestGet(String method, Map<String, String> map) {
        return buildUri(map).get(method);
    }

    public static Response requestPost(String method, Map<String, String> map) {
        return buildUri(map).post(method);
    }
}
