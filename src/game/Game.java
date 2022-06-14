package game;

import game.rooms.Room;

import java.util.Map;

import static game.readFromJSONSeparateLines.gameRules;
import static game.readFromJSONSeparateLines.welcomeTextFromSeparateLines;

public class Game {

    Player player = new Player();
    ActionParser actionParser = new ActionParser();
    static Map<String, Room> roomMap;

    public Game() throws Exception {
    }

    public void execute() throws Exception {
        AsciiArts.asciiArtThisIsFine();
        welcome();
        gameRules("gameRules");

        playGame();

        if (player.checkWin()) {
            winScreen();
        }
    }

    private boolean playGame() throws Exception {
        RoomFactory.initializeRoom();
        player.playerInfo();
        RoomFactory.displayRoomInfo(player);
        return !actionParser.playerMove(player);
    }

    // Welcome method
    public static void welcome() throws Exception {
        welcomeTextFromSeparateLines("welcome");
    }

    public static void winScreen() throws Exception {
        //welcomeTextFromSeparateLines("welcome");
        System.out.println("YOU WIN");
    }
}