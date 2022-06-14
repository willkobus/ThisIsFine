package game;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;

public abstract class JSONRead {
    public static JSONObject readJSON(String filepath) throws Exception{
        Object obj = new JSONParser().parse(new FileReader(filepath));

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;

        return jo;
    }

    public static String getJSONFromFile(String filename){
        String jsonTextFromWelcome = "";
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

            String line;
            while((line = bufferedReader.readLine()) != null){
                jsonTextFromWelcome+=line+"\n";
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return jsonTextFromWelcome;
    }

    // read from gameText.json
    public static String getJSONFromFileSeparateLines(String filename){
        String jsonTextFromFileSeparateLines = "";
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

            String line;
            while ((line = bufferedReader.readLine()) != null){
                jsonTextFromFileSeparateLines += line + "\n";
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return jsonTextFromFileSeparateLines;
    }
}


