package game;

import game.rooms.Room;

import java.util.Map;
import java.util.Scanner;


public class Game {

    Player player = new Player();
    ActionParser actionParser = new ActionParser();
    static Map<String, Room> roomMap;

    public Game() throws Exception {
    }

    public void execute() throws Exception {
        welcome();

        playGame();

        if (player.checkWin()) {
            winScreen();
        }
    }

    private boolean playGame() throws Exception {
        RoomUtility.initializeRoom();
        RoomUtility.displayGameInfo(player);
        return !actionParser.playerMove(player);
    }

    // Welcome method
    public static void welcome() throws Exception {
        Scanner scan = new Scanner(System.in);
        AsciiArts.asciiArtThisIsFine();
        JSONRead.gameText("welcome");
        System.out.println();
        System.out.println("Type [Y] to read Game Rules or Press any key to skip:");
        String response = scan.next();

        if (response.matches("(?i)y" )){
            JSONRead.gameText("gameRules");
        }
    }

    public static void winScreen() throws Exception {
        AsciiArts.asciiArtWin();
    }
}