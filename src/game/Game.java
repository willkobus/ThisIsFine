package game;

import com.apps.util.Console;

import java.util.Scanner;

public class Game {
    Player player = new Player();
    ActionParser actionParser = new ActionParser();

    public void execute() {
        Console.clear();

        welcome();

        playGame();

        if (player.checkWin()) {
            Console.clear();
            winScreen();
        } else if (player.checkLose()) {
            Console.clear();
            loseScreen();
        }
    }

    private boolean playGame() {
        RoomFactory.initializeRoom();
        RoomUtility.displayGameInfo(player);
        return !actionParser.playerMove(player);
    }

    // Welcome method
    public static void welcome() {
        Scanner scan = new Scanner(System.in);
        AsciiArts.asciiArtThisIsFine();
        JSONRead.gameText("welcome");

        MusicPlayer.playFireMusic();

        System.out.println();
        System.out.println("Type [Y] to read game rules OR type any key to skip: ");
        String response = scan.next();

        if (response.matches("(?i)y")) {
            JSONRead.gameText("gameRules");
        }
    }

    public static void winScreen() {
        AsciiArts.asciiArtWin();
    }

    public static void loseScreen() {
        AsciiArts.asciiArtLose();
    }
}