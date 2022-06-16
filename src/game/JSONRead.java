package game;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public abstract class JSONRead {
    private static final String ROOMS_FILEPATH = "rooms.json";
    private static final String GAME_TEXT_FILEPATH = "gameText.json";
    private static final String ERROR_MESSAGE = "File not found";

    public static JSONObject readJSON(String filepath) {

        Object obj = null;
        try {
            InputStreamReader streamReader = new InputStreamReader(JSONParser.class.getResourceAsStream("/" + filepath), StandardCharsets.UTF_8);
            obj = new JSONParser().parse(streamReader);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println(ERROR_MESSAGE);
            e.printStackTrace();
        }


        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
        return jo;

    }

    public static void gameText(String textSource) {
        int delay1 = 300;
        if (textSource.equals("help")){
            delay1 = 0;
        }
        JSONObject gameTextObject = JSONRead.readJSON(GAME_TEXT_FILEPATH);

        ArrayList<String> text = (ArrayList<String>) gameTextObject.get(textSource);

        for (String line : text) {
            System.out.println(line);
            try {
                Thread.sleep(delay1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


