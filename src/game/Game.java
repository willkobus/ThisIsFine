package game;

import game.rooms.Room;

import java.util.Map;



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
        AsciiArts.asciiArtThisIsFine();
        JSONRead.gameText("welcome");
        JSONRead.gameText("gameRules");
    }

    public static void winScreen() throws Exception {
        //welcomeTextFromSeparateLines("welcome");
        AsciiArts.asciiArtWin();
    }
}