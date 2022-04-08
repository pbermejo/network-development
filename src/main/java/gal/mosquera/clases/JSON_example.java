package gal.mosquera.clases;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSON_example {
    static String json = "{\r\n"
    		+ "    \"pageInfo\": {\r\n"
    		+ "            \"pageName\": \"Homepage\",\r\n"
    		+ "            \"logo\": \"https://www.example.com/logo.jpg\"\r\n"
    		+ "    },\r\n"
    		+ "    \"posts\": [\r\n"
    		+ "            {\r\n"
    		+ "                \"post_id\": \"0123456789\",\r\n"
    		+ "                \"actor_id\": \"1001\",\r\n"
    		+ "                \"author_name\": \"Jane Doe\",\r\n"
    		+ "                \"post_title\": \"How to parse JSON in Java\",\r\n"
    		+ "                \"comments\": [],\r\n"
    		+ "                \"time_of_post\": \"1234567890\"\r\n"
    		+ "            }\r\n"
    		+ "    ]\r\n"
    		+ "}\r\n"
    		+ "";
    public static void main(String[] args) {
        JSONObject obj = new JSONObject(json);
        String pageName = obj.getJSONObject("pageInfo").getString("pageName");

        System.out.println(pageName);

        JSONArray arr = obj.getJSONArray("posts");
        for (int i = 0; i < arr.length(); i++) {
            String post_id = arr.getJSONObject(i).getString("post_id");
            System.out.println(post_id);
        }
    }
}

