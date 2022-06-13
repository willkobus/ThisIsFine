package game;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class JSONRead {
    public JSONObject readJSON() throws Exception{
        Object obj = new JSONParser().parse(new FileReader("resources/rooms.json"));

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;

        return jo;
    }
}


