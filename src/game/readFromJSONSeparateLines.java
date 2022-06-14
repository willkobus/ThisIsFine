package game;

import org.json.simple.JSONObject;

import java.util.ArrayList;

class readFromJSONSeparateLines {
    private final static String filepath = "resources/gameTextSeparateLines.json";

    // read json from gameTextSeparateLines.json
    public static void welcomeTextFromSeparateLines(String textSource) throws Exception {
        int delay1 = 500;

        JSONObject welcomeObject= JSONRead.readJSON(filepath);
        ArrayList<String> welcomeText = (ArrayList<String>) welcomeObject.get(textSource);
        for (String line : welcomeText){
            System.out.println(line);
            Thread.sleep(delay1);
        }
    }

    public static void gameRules(String ruleSource) throws Exception {
        JSONObject ruleObject = JSONRead.readJSON(filepath);
        ArrayList<String> ruleText = (ArrayList<String>) ruleObject.get(ruleSource);
        for (String line : ruleText) {
            System.out.println(line);
        }
    }
}