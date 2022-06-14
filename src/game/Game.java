package game;

import game.rooms.Room;

import java.util.Map;

import static game.readFromJSONSeparateLines.welcomeText;

public class Game {

    Player player = new Player();
    ActionParser actionParser = new ActionParser();
    static Map<String, Room> roomMap;

    public Game() throws Exception {
    }

    public void execute() throws Exception {
        welcome();

        playGame();
    }

    private boolean playGame() throws Exception {
        RoomFactory.initializeRoom();
        player.playerInfo();
        RoomFactory.displayRoomInfo(player);
        return !actionParser.playerMove(player);

    }

    // Welcome method
    public static void welcome() throws Exception {
        AsciiArts.asciiArtThisIsFine();
        welcomeText("welcome");
        welcomeText("gameRules");
    }

}