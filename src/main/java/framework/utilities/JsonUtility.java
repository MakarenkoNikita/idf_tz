package framework.utilities;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class JsonUtility {

    private JsonUtility() {
        throw new InstantiationError("Should not instantiate static class");
    }

    public static List<String> getElementList(JSONArray jsonArray, String path) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(jsonArray.getJSONObject(i).get(path).toString());
        }
        return list;
    }
}
