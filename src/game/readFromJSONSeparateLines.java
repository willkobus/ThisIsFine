package game;

import org.json.simple.JSONObject;

import java.util.ArrayList;

class readFromJSONSeparateLines {
    private final static String filepath = "resources/gameTextSeparateLines.json";

    // read json from gameTextSeparateLines.json
    public static void welcomeTextFromSeparateLines(String textSource) throws Exception {
        int delay1 = 300;

        JSONObject welcomeObject= JSONRead.readJSON(filepath);
        ArrayList<String> welcomeText = (ArrayList<String>) welcomeObject.get(textSource);
        for (String line : welcomeText){
            System.out.println(line);
            Thread.sleep(delay1);
        }
    }
}