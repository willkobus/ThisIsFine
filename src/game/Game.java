package game;

import java.awt.*;
import java.awt.image.BufferedImage;

import static game.ColorEnums.*;

public class Game {

    Player player = new Player();
    ActionParser actionParser = new ActionParser();

    public void execute() throws Exception {
        asciiArt();
        welcome();

//        while(start());
        boolean quit = false;

        while(!quit) {
            quit = actionParser.playerMove(player);
        }


    }

    private boolean start() throws Exception {
        return !actionParser.playerMove(player);

        /*
        while !quit
            quit = actionparser.playermove(player)

         */

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
        System.out.println("Hello VOLUNTEER TESTER #18978983! We are grateful that you have signed up for this trial. We also are grateful that you didn’t ask any questions ");
        Thread.sleep(delay);
        System.out.println("as to what the trial would be and still signed the waiver! Safety is our number one concern here at Practical Applications Inc. Now that the door ");
        Thread.sleep(delay);
        System.out.println("has locked behind you in this random house we had you come to, you may be wondering what it is we are going to have you do. Well simply put, we ");
        Thread.sleep(delay);
        System.out.println("are conducting a study to see how well people solve problems when faced with a stressful situation. In your case it seems you are in situation #4352, ");
        Thread.sleep(delay);
        System.out.println(RED_TEXT + "“Escape the Burning Building”" + RESET_TEXT + ". In this scenario you have to solve puzzles and complete tasks in order to get all the keys and escape the building ");
        Thread.sleep(delay);
        System.out.println("in a set number of moves. How many moves you ask? Well, to keep you good and stressed, you don’t get to know that! Don’t worry though, we will give ");
        Thread.sleep(delay);
        System.out.println("periodic updates to let you know how you are doing! Good luck!");
    }

}