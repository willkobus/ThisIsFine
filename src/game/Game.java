package game;

import java.awt.*;
import java.awt.image.BufferedImage;

import static game.ColorEnums.*;

public class Game {

    Player player = new Player();
    ActionParser actionParser = new ActionParser();

    public Game() throws Exception {
    }

    public void execute() throws Exception {
        asciiArt();
        welcome();
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

    // ASCII Art method
    public static void asciiArt() {
        int width = 100;
        int height = 30;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("SansSerif", Font.BOLD, 15));

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString("THIS IS FINE", 5, 20);


        for (int y = 0; y < height; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < width; x++) {

                sb.append(image.getRGB(x, y) == -16777216 ? " " : "&");

            }

            if (sb.toString().trim().isEmpty()) {
                continue;
            }

            System.out.println(GREEN_TEXT + sb + RESET_TEXT);
        }

    }

    // Welcome method
    public static void welcome() throws InterruptedException {
        int delay = 500;
        System.out.println();
        System.out.println("Hello VOLUNTEER TESTER #18978983! We are grateful that you have signed up for this trial. We also are grateful that you didn't ask any questions ");
        Thread.sleep(delay);
        System.out.println("as to what the trial would be and still signed the waiver! Safety is our number one concern here at Practical Applications Inc. Now that the door ");
        Thread.sleep(delay);
        System.out.println("has locked behind you in this random house we had you come to, you may be wondering what it is we are going to have you do. Well simply put, we ");
        Thread.sleep(delay);
        System.out.println("are conducting a study to see how well people solve problems when faced with a stressful situation. In your case it seems you are in situation #4352, ");
        Thread.sleep(delay);
        System.out.println(RED_TEXT + "'Escape the Burning Building'" + RESET_TEXT + ". In this scenario you have to solve puzzles and complete tasks in order to get all the keys and escape the building ");
        Thread.sleep(delay);
        System.out.println("in a set number of moves. How many moves you ask? Well, to keep you good and stressed, you don't get to know that! Don’t worry though, we will give ");
        Thread.sleep(delay);
        System.out.println("periodic updates to let you know how you are doing! Good luck!");
    }

}