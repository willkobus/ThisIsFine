package game;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;

public class JSONRead {
    public JSONObject readJSON() throws Exception{
        Object obj = new JSONParser().parse(new FileReader("resources/rooms.json"));

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;

        return jo;
    }

//    public class readJSONFromWelcome() {
//        Object obj = new JSONParser().parse(new FileReader("resources/gameText.json"));
//
//        public readJSONFromWelcome() throws IOException, ParseException {
//        }
//    }
//     read from gameText.json
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




//    public JSONObject readGameText() throws Exception {
//        Object obj = new JSONParser().parse(new FileReader("resources/gameText.json"));
//
//        // typecasting obj to JSONObject
//        JSONObject joGameText = (JSONObject) obj;
//        return joGameText;
//    }
}


