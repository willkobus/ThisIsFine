package game;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

import static game.ColorEnums.BLUE_TEXT;
import static game.ColorEnums.RESET_TEXT;

public class Game {

    Player player = new Player();
    ActionParser actionParser = new ActionParser();

    public Game() throws Exception {
    }

    public void execute() throws Exception {
        AsciiArts.asciiArtThisIsFine();
//        welcome();
//        welcomeTextFromSeparateLines();
        gameRules();

        playGame();

    }

    private boolean playGame() throws Exception {
        RoomFactory.initializeRoom();
        player.playerInfo();
        RoomFactory.displayRoomInfo(player);
        return !actionParser.playerMove(player);

    }

    // Game Rules
    public static void gameRules() {
        System.out.println("===============================================================================================");
        System.out.println("GAME RULES: \n" +
                "Type a " + BLUE_TEXT + "verb"+ RESET_TEXT + " and a "+ BLUE_TEXT + "noun"  + RESET_TEXT + ".\n" +
                "Here are the options for verbs and how you use them: \n" +
                "\t1. take <item>\n" +
                "\t2. use <item>\n" +
                "\t3. move <direction> (east, west, north, south)\n" +
                "\t4. look (gives more detail about the current room)\n" +
                "\t5. quit (exits game)\n" +
                "\t6. restart (restarts new game, loses all current settings)\n\n" +
                "Goal: Go to different rooms, solve the puzzles and get the keys to escape the burning building. \n" +
                "      REMEMBER, you have to finish this task within 100 steps. Otherwise ...");

        System.out.println("===============================================================================================");
    }

    // Welcome method
    public static void welcome() throws IOException, ParseException {
        int delay = 500;
//        String strJson = getJSONFromFile("resources/gameText.json");
//        System.out.println(strJson);

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("resources/gameText.json");
        // obj is java object
        Object obj = jsonParser.parse(reader);
        // typecasting to json object. This converts java object "obj" to json object "welcomeObject"
        JSONObject welcomeObject = (JSONObject)obj;
        // after we typecast, we can use the .get method

//        String welcomeText = (String) welcomeObject.get("welcome");
//        System.out.println(welcomeText);
        System.out.println(welcomeObject.get("welcome"));

//        for (int i=0; i<strJson.length(); i++){
//            JSONObject strJsonLine = (JSONObject) strJson.(i);
//            System.out.println(strJsonLine);
//        }




        // printlns.. this works
//        System.out.println();
//        System.out.println("Hello VOLUNTEER TESTER #18978983! We are grateful that you have signed up for this trial. We also are grateful that you didn't ask any questions ");
//        Thread.sleep(delay);
//        System.out.println("as to what the trial would be and still signed the waiver! Safety is our number one concern here at Practical Applications Inc. Now that the door ");
//        Thread.sleep(delay);
//        System.out.println("has locked behind you in this random house we had you come to, you may be wondering what it is we are going to have you do. Well simply put, we ");
//        Thread.sleep(delay);
//        System.out.println("are conducting a study to see how well people solve problems when faced with a stressful situation. In your case it seems you are in situation ");
//        Thread.sleep(delay);
//        System.out.println("#4352, " + RED_TEXT + "'Escape the Burning Building'" + RESET_TEXT + ". In this scenario you have to solve puzzles and complete tasks in order to get all the keys and escape the ");
//        Thread.sleep(delay);
//        System.out.println("building in a set number of moves. How many moves you ask? Well, to keep you good and stressed, you don't get to know that! Don’t worry though, we will give ");
//        Thread.sleep(delay);
//        System.out.println("periodic updates to let you know how you are doing! Good luck!");
    }

}