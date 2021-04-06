package string;


import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class StringObjectToJSON {
    public static void main(String[] args) {

        Map<String, String> m = new HashMap<>();
        m.put("x", "100");
        m.put("y", "200");

        Gson g = new Gson();
        String result = g.toJson(m);
        System.out.println(result);

        Map<String, String> deserialized = g.fromJson(result, Map.class);
        System.out.println(deserialized);
    }
}
