package game;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public abstract class JSONRead {
    private static final String ROOMS_FILEPATH = "resources/rooms.json";
    private static final String GAME_TEXT_FILEPATH = "resources/gameText.json";

    public static JSONObject readJSON(String filepath) throws Exception{
        Object obj = new JSONParser().parse(new FileReader(filepath));

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;

        return jo;
    }

    public static void gameText(String textSource) throws Exception {
        int delay1 = 300;

        JSONObject gameTextObject= JSONRead.readJSON(GAME_TEXT_FILEPATH);
        ArrayList<String> text = (ArrayList<String>) gameTextObject.get(textSource);
        for (String line : text){
            System.out.println(line);
            Thread.sleep(delay1);
        }
    }

}


