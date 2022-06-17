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
            System.out.println("You completed the game in: " + player.getMoveCount() + " moves.");
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
        MusicPlayer.playDoorCloseMusic();

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
        System.out.println("\nYou feel overwhelmed and begin to panic as the heat becomes unbearable and the " +
                                   "\nflames engulf the walls around you.\n" +
                                   "Suddenly the flames vanish and you hear a voice.\n" +
                                   "\t\"That was a good effort but it seems you've run out of time.\n" +
                                   "\t Perhaps the next volunteer will be successful.\"");
    }
}